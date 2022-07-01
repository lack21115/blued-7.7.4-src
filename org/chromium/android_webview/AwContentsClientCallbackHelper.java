package org.chromium.android_webview;

import android.os.Handler;
import android.os.Looper;

public final class AwContentsClientCallbackHelper {
  AwContentsClientCallbackHelper$CancelCallbackPoller mCancelCallbackPoller;
  
  final AwContentsClient mContentsClient;
  
  final Handler mHandler;
  
  boolean mHasPendingOnNewPicture;
  
  long mLastPictureTime;
  
  public AwContentsClientCallbackHelper(Looper paramLooper, AwContentsClient paramAwContentsClient) {
    this.mHandler = new AwContentsClientCallbackHelper$MyHandler(this, paramLooper, (byte)0);
    this.mContentsClient = paramAwContentsClient;
  }
  
  public final void postOnPageFinished(String paramString) {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(9, paramString));
  }
  
  public final void postOnReceivedError(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest, AwContentsClient$AwWebResourceError paramAwContentsClient$AwWebResourceError) {
    AwContentsClientCallbackHelper$OnReceivedErrorInfo awContentsClientCallbackHelper$OnReceivedErrorInfo = new AwContentsClientCallbackHelper$OnReceivedErrorInfo(paramAwContentsClient$AwWebResourceRequest, paramAwContentsClient$AwWebResourceError);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(5, awContentsClientCallbackHelper$OnReceivedErrorInfo));
  }
  
  public final void postOnThemeColorChanged(int paramInt) {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(99, paramInt, 0));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsClientCallbackHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */