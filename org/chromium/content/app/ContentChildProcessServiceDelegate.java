package org.chromium.content.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.Surface;
import java.util.List;
import org.chromium.base.CommandLine;
import org.chromium.base.JNIUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.UnguessableToken;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.library_loader.Linker;
import org.chromium.base.memory.MemoryPressureUma;
import org.chromium.base.process_launcher.ChildProcessServiceDelegate;
import org.chromium.content.browser.ChildProcessCreationParamsImpl;
import org.chromium.content.common.IGpuProcessCallback;
import org.chromium.content.common.SurfaceWrapper;

public class ContentChildProcessServiceDelegate implements ChildProcessServiceDelegate {
  private int mCpuCount;
  
  private long mCpuFeatures;
  
  private SparseArray mFdsIdsToKeys;
  
  private IGpuProcessCallback mGpuCallback;
  
  private int mLibraryProcessType;
  
  private ChromiumLinkerParams mLinkerParams;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ContentChildProcessServiceDelegate() {
    KillChildUncaughtExceptionHandler.maybeInstallHandler();
  }
  
  @CalledByNative
  private void forwardSurfaceTextureForSurfaceRequest(UnguessableToken paramUnguessableToken, SurfaceTexture paramSurfaceTexture) {
    if (this.mGpuCallback == null) {
      Log.e("ContentCPSDelegate", "No callback interface has been provided.", new Object[0]);
      return;
    } 
    Surface surface = new Surface(paramSurfaceTexture);
    try {
      this.mGpuCallback.forwardSurfaceForSurfaceRequest(paramUnguessableToken, surface);
      surface.release();
      return;
    } catch (RemoteException remoteException) {
      Log.e("ContentCPSDelegate", "Unable to call forwardSurfaceForSurfaceRequest: %s", new Object[] { remoteException });
      surface.release();
      return;
    } finally {}
    surface.release();
    throw paramUnguessableToken;
  }
  
  private Linker getLinker() {
    if (Linker.areTestsEnabled()) {
      assert false;
      throw new AssertionError();
    } 
    return Linker.getInstance();
  }
  
  @CalledByNative
  private Surface getViewSurface(int paramInt) {
    if (this.mGpuCallback == null) {
      Log.e("ContentCPSDelegate", "No callback interface has been provided.", new Object[0]);
      return null;
    } 
    try {
      SurfaceWrapper surfaceWrapper = this.mGpuCallback.getViewSurface(paramInt);
      return (surfaceWrapper != null) ? surfaceWrapper.mSurface : null;
    } catch (RemoteException remoteException) {
      Log.e("ContentCPSDelegate", "Unable to call getViewSurface: %s", new Object[] { remoteException });
      return null;
    } 
  }
  
  private native void nativeInitChildProcess(int paramInt, long paramLong);
  
  private native void nativeRetrieveFileDescriptorsIdsToKeys();
  
  private native void nativeShutdownMainThread();
  
  @CalledByNative
  private void setFileDescriptorsIdsToKeys(int[] paramArrayOfint, String[] paramArrayOfString) {
    assert false;
    throw new AssertionError();
  }
  
  public final SparseArray getFileDescriptorsIdsToKeys() {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean loadNativeLibrary(Context paramContext) {
    if (CommandLine.getInstance().getSwitchValue("type") != null)
      JNIUtils.enableSelectiveJniRegistration(); 
    Linker linker = null;
    if (LibraryLoader.useCrazyLinker()) {
      assert false;
      throw new AssertionError();
    } 
    boolean bool = false;
  }
  
  public final void onBeforeMain() {
    nativeInitChildProcess(this.mCpuCount, this.mCpuFeatures);
    ThreadUtils.postOnUiThread(ContentChildProcessServiceDelegate$$Lambda$0.$instance);
  }
  
  public final void onConnectionSetup(Bundle paramBundle, List<IBinder> paramList) {
    Bundle bundle = null;
    if (paramList != null && !paramList.isEmpty()) {
      IGpuProcessCallback iGpuProcessCallback = IGpuProcessCallback.Stub.asInterface(paramList.get(0));
    } else {
      paramList = null;
    } 
    this.mGpuCallback = (IGpuProcessCallback)paramList;
    this.mCpuCount = paramBundle.getInt("com.google.android.apps.chrome.extra.cpu_count");
    this.mCpuFeatures = paramBundle.getLong("com.google.android.apps.chrome.extra.cpu_features");
    assert false;
    throw new AssertionError();
  }
  
  public final void onDestroy() {
    nativeShutdownMainThread();
  }
  
  public final void onServiceBound(Intent paramIntent) {
    ChromiumLinkerParams chromiumLinkerParams;
    Bundle bundle = paramIntent.getExtras();
    if (!bundle.containsKey("org.chromium.content.common.linker_params.base_load_address") || !bundle.containsKey("org.chromium.content.common.linker_params.wait_for_shared_relro") || !bundle.containsKey("org.chromium.content.common.linker_params.test_runner_class_name")) {
      bundle = null;
    } else {
      chromiumLinkerParams = new ChromiumLinkerParams(bundle);
    } 
    this.mLinkerParams = chromiumLinkerParams;
    this.mLibraryProcessType = ChildProcessCreationParamsImpl.getLibraryProcessType(paramIntent.getExtras());
  }
  
  public final void preloadNativeLibrary$faab20d() {
    null = LibraryLoader.getInstance();
    synchronized (null.mLock) {
      if (!LibraryLoader.useCrazyLinker())
        null.preloadAlreadyLocked$faab20d(); 
      return;
    } 
  }
  
  public final void runMain() {
    ContentMain.start(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\app\ContentChildProcessServiceDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */