package org.chromium.android_webview;

import org.chromium.base.annotations.CalledByNative;

public class AwHttpAuthHandler {
  public final boolean mFirstAttempt;
  
  public long mNativeAwHttpAuthHandler;
  
  private AwHttpAuthHandler(long paramLong, boolean paramBoolean) {
    this.mNativeAwHttpAuthHandler = paramLong;
    this.mFirstAttempt = paramBoolean;
  }
  
  @CalledByNative
  public static AwHttpAuthHandler create(long paramLong, boolean paramBoolean) {
    return new AwHttpAuthHandler(paramLong, paramBoolean);
  }
  
  @CalledByNative
  void handlerDestroyed() {
    this.mNativeAwHttpAuthHandler = 0L;
  }
  
  public native void nativeCancel(long paramLong);
  
  public native void nativeProceed(long paramLong, String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwHttpAuthHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */