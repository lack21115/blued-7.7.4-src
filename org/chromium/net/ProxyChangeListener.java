package org.chromium.net;

import android.os.Handler;
import android.os.Looper;
import org.chromium.base.BuildConfig;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.UsedByReflection;

@UsedByReflection
public class ProxyChangeListener {
  private static boolean sEnabled;
  
  private final Handler mHandler = new Handler(this.mLooper);
  
  private final Looper mLooper = Looper.myLooper();
  
  private long mNativePtr;
  
  private ProxyChangeListener$ProxyReceiver mProxyReceiver;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private void assertOnThread() {
    if (BuildConfig.DCHECK_IS_ON) {
      if (onThread())
        return; 
      throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
    } 
  }
  
  @CalledByNative
  public static ProxyChangeListener create() {
    return new ProxyChangeListener();
  }
  
  @CalledByNative
  public static String getProperty(String paramString) {
    return System.getProperty(paramString);
  }
  
  private native void nativeProxySettingsChanged(long paramLong);
  
  private native void nativeProxySettingsChangedTo(long paramLong, String paramString1, int paramInt, String paramString2, String[] paramArrayOfString);
  
  private boolean onThread() {
    return (this.mLooper == Looper.myLooper());
  }
  
  @CalledByNative
  public void start(long paramLong) {
    assertOnThread();
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  public void stop() {
    assertOnThread();
    this.mNativePtr = 0L;
    if (this.mProxyReceiver != null) {
      ContextUtils.sApplicationContext.unregisterReceiver(this.mProxyReceiver);
      this.mProxyReceiver = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\ProxyChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */