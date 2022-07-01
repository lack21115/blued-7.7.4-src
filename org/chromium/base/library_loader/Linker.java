package org.chromium.base.library_loader;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.chromium.base.Log;
import org.chromium.base.StreamUtil;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class Linker {
  private static final Linker sSingleton;
  
  public long mBaseLoadAddress = -1L;
  
  public boolean mBrowserUsesSharedRelro;
  
  public long mCurrentLoadAddress = -1L;
  
  public boolean mInBrowserProcess = true;
  
  private boolean mInitialized;
  
  private HashMap mLoadedLibraries;
  
  public Object mLock = new Object();
  
  private int mMemoryDeviceConfig = 0;
  
  boolean mPrepareLibraryLoadCalled;
  
  public Bundle mSharedRelros;
  
  private String mTestRunnerClassName;
  
  public boolean mWaitForSharedRelros;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private Linker() {
    assert false;
  }
  
  public static boolean areTestsEnabled() {
    return NativeLibraries.sEnableLinkerTests;
  }
  
  private static void assertLinkerTestsAreEnabled() {
    assert false;
  }
  
  private static void closeLibInfoMap(HashMap paramHashMap) {
    Iterator<Map.Entry> iterator = paramHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Linker$LibInfo linker$LibInfo = (Linker$LibInfo)((Map.Entry)iterator.next()).getValue();
      if (linker$LibInfo.mRelroFd >= 0) {
        StreamUtil.closeQuietly((Closeable)ParcelFileDescriptor.adoptFd(linker$LibInfo.mRelroFd));
        linker$LibInfo.mRelroFd = -1;
      } 
    } 
  }
  
  private static HashMap createLibInfoMapFromBundle(Bundle paramBundle) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (String str : paramBundle.keySet())
      hashMap.put(str, paramBundle.getParcelable(str)); 
    return hashMap;
  }
  
  public static Linker getInstance() {
    return sSingleton;
  }
  
  static boolean isChromiumLinkerLibrary(String paramString) {
    return paramString.equals("chromium_android_linker");
  }
  
  static native boolean nativeAddZipArchivePath(String paramString);
  
  private static native boolean nativeCreateSharedRelro(String paramString, long paramLong, Linker$LibInfo paramLinker$LibInfo);
  
  private static native long nativeGetRandomBaseLoadAddress();
  
  private static native boolean nativeLoadLibrary(String paramString, long paramLong, Linker$LibInfo paramLinker$LibInfo);
  
  private static native void nativeRunCallbackOnUiThread(long paramLong);
  
  private static native boolean nativeUseSharedRelro(String paramString, Linker$LibInfo paramLinker$LibInfo);
  
  @CalledByNative
  private static void postCallbackOnMainThread(long paramLong) {
    ThreadUtils.postOnUiThread(new Linker$1(paramLong));
  }
  
  public static final void setupForTesting(String paramString) {
    assertLinkerTestsAreEnabled();
    synchronized (sSingleton) {
      sSingleton.mTestRunnerClassName = paramString;
      return;
    } 
  }
  
  private void useSharedRelrosLocked(Bundle paramBundle) {
    assert false;
    throw new AssertionError();
  }
  
  public final void disableSharedRelros() {
    synchronized (this.mLock) {
      ensureInitializedLocked();
      this.mInBrowserProcess = false;
      this.mWaitForSharedRelros = false;
      this.mBrowserUsesSharedRelro = false;
      return;
    } 
  }
  
  public final void ensureInitializedLocked() {
    assert false;
    throw new AssertionError();
  }
  
  final void finishLibraryLoad() {
    synchronized (this.mLock) {
      ensureInitializedLocked();
      HashMap hashMap = this.mLoadedLibraries;
      Linker$TestRunner linker$TestRunner = null;
      if (hashMap != null) {
        if (this.mInBrowserProcess) {
          HashMap hashMap1 = this.mLoadedLibraries;
          Bundle bundle = new Bundle(hashMap1.size());
          for (Map.Entry entry : hashMap1.entrySet())
            bundle.putParcelable((String)entry.getKey(), (Parcelable)entry.getValue()); 
          this.mSharedRelros = bundle;
          if (this.mBrowserUsesSharedRelro)
            useSharedRelrosLocked(this.mSharedRelros); 
        } 
        if (this.mWaitForSharedRelros)
          if ($assertionsDisabled || !this.mInBrowserProcess) {
            while (true) {
              Bundle bundle = this.mSharedRelros;
              if (bundle == null) {
                try {
                  this.mLock.wait();
                } catch (InterruptedException interruptedException) {
                  Thread.currentThread().interrupt();
                } 
                continue;
              } 
              useSharedRelrosLocked(this.mSharedRelros);
              this.mSharedRelros.clear();
              this.mSharedRelros = null;
              break;
            } 
          } else {
            throw new AssertionError();
          }  
      } 
      if (NativeLibraries.sEnableLinkerTests) {
        assertLinkerTestsAreEnabled();
        synchronized (this.mLock) {
          if (this.mTestRunnerClassName == null) {
            Log.wtf("LibraryLoader", "Linker runtime tests not set up for this process", new Object[0]);
            assert false;
          } 
          try {
            Linker$TestRunner linker$TestRunner1 = Class.forName(this.mTestRunnerClassName).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            linker$TestRunner = linker$TestRunner1;
          } catch (Exception exception) {
            Log.wtf("LibraryLoader", "Could not instantiate test runner class by name", new Object[] { exception });
            assert false;
          } 
          if (!linker$TestRunner.runChecks$256326a()) {
            Log.wtf("LibraryLoader", "Linker runtime tests failed in this process", new Object[0]);
            assert false;
          } 
          Log.i("LibraryLoader", "All linker tests passed", new Object[0]);
        } 
      } 
      return;
    } 
  }
  
  public final long getBaseLoadAddress() {
    synchronized (this.mLock) {
      ensureInitializedLocked();
      if (!this.mInBrowserProcess) {
        Log.w("LibraryLoader", "Shared RELRO sections are disabled in this process!", new Object[0]);
        return 0L;
      } 
      setupBaseLoadAddressLocked();
      return this.mBaseLoadAddress;
    } 
  }
  
  public final Bundle getSharedRelros() {
    synchronized (this.mLock) {
      if (!this.mInBrowserProcess)
        return null; 
      return this.mSharedRelros;
    } 
  }
  
  public final String getTestRunnerClassNameForTesting() {
    assertLinkerTestsAreEnabled();
    synchronized (this.mLock) {
      return this.mTestRunnerClassName;
    } 
  }
  
  public final boolean isUsingBrowserSharedRelros() {
    synchronized (this.mLock) {
      ensureInitializedLocked();
      if (this.mInBrowserProcess && this.mBrowserUsesSharedRelro)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  final void loadLibraryImpl(String paramString, boolean paramBoolean) {
    synchronized (this.mLock) {
      ensureInitializedLocked();
      assert false;
      throw new AssertionError();
    } 
  }
  
  final void setupBaseLoadAddressLocked() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\library_loader\Linker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */