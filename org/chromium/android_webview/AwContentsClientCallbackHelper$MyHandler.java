package org.chromium.android_webview;

import android.graphics.Picture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.Callable;

final class AwContentsClientCallbackHelper$MyHandler extends Handler {
  private AwContentsClientCallbackHelper$MyHandler(Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    String str;
    AwContentsClientCallbackHelper$CancelCallbackPoller awContentsClientCallbackHelper$CancelCallbackPoller = AwContentsClientCallbackHelper.this.mCancelCallbackPoller;
    StringBuilder stringBuilder = null;
    if (awContentsClientCallbackHelper$CancelCallbackPoller != null && AwContentsClientCallbackHelper.this.mCancelCallbackPoller.shouldCancelAllCallbacks()) {
      removeCallbacksAndMessages(null);
      return;
    } 
    int i = paramMessage.what;
    if (i != 99) {
      AwContentsClientCallbackHelper$OnSafeBrowsingHitInfo awContentsClientCallbackHelper$OnSafeBrowsingHitInfo;
      AwContentsClientCallbackHelper$OnFormResubmissionInfo awContentsClientCallbackHelper$OnFormResubmissionInfo;
      AwContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo awContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo;
      String str1;
      AwContentsClientCallbackHelper$OnReceivedHttpErrorInfo awContentsClientCallbackHelper$OnReceivedHttpErrorInfo;
      AwContentsClient awContentsClient;
      AwContentsClientCallbackHelper$LoginRequestInfo awContentsClientCallbackHelper$LoginRequestInfo;
      AwContentsClientCallbackHelper$DownloadInfo awContentsClientCallbackHelper$DownloadInfo;
      float f1;
      float f2;
      AwContentsClient$AwWebResourceRequest awContentsClient$AwWebResourceRequest;
      AwContentsClientCallbackHelper$OnReceivedErrorInfo awContentsClientCallbackHelper$OnReceivedErrorInfo;
      AwContentsClient$AwWebResourceError awContentsClient$AwWebResourceError;
      switch (i) {
        default:
          stringBuilder = new StringBuilder("AwContentsClientCallbackHelper: unhandled message ");
          stringBuilder.append(paramMessage.what);
          throw new IllegalStateException(stringBuilder.toString());
        case 15:
          awContentsClientCallbackHelper$OnSafeBrowsingHitInfo = (AwContentsClientCallbackHelper$OnSafeBrowsingHitInfo)paramMessage.obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onSafeBrowsingHit(awContentsClientCallbackHelper$OnSafeBrowsingHitInfo.mRequest, awContentsClientCallbackHelper$OnSafeBrowsingHitInfo.mThreatType, awContentsClientCallbackHelper$OnSafeBrowsingHitInfo.mCallback);
          return;
        case 14:
          awContentsClientCallbackHelper$OnFormResubmissionInfo = (AwContentsClientCallbackHelper$OnFormResubmissionInfo)((Message)awContentsClientCallbackHelper$OnSafeBrowsingHitInfo).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onFormResubmission(awContentsClientCallbackHelper$OnFormResubmissionInfo.mDontResend, awContentsClientCallbackHelper$OnFormResubmissionInfo.mResend);
          return;
        case 13:
          awContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo = (AwContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo)((Message)awContentsClientCallbackHelper$OnFormResubmissionInfo).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.doUpdateVisitedHistory(awContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo.mUrl, awContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo.mIsReload);
          return;
        case 12:
          str1 = (String)((Message)awContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onPageStarted(str1);
          AwContentsClientCallbackHelper.this.mContentsClient.onLoadResource(str1);
          AwContentsClientCallbackHelper.this.mContentsClient.onProgressChanged(100);
          AwContentsClientCallbackHelper.this.mContentsClient.onPageFinished(str1);
          return;
        case 11:
          AwContentsClientCallbackHelper.this.mContentsClient.onProgressChanged(((Message)str1).arg1);
          return;
        case 10:
          str1 = (String)((Message)str1).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onReceivedTitle(str1);
          return;
        case 9:
          str1 = (String)((Message)str1).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onPageFinished(str1);
          return;
        case 8:
          awContentsClientCallbackHelper$OnReceivedHttpErrorInfo = (AwContentsClientCallbackHelper$OnReceivedHttpErrorInfo)((Message)str1).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onReceivedHttpError(awContentsClientCallbackHelper$OnReceivedHttpErrorInfo.mRequest, awContentsClientCallbackHelper$OnReceivedHttpErrorInfo.mResponse);
          return;
        case 7:
          f1 = Float.intBitsToFloat(((Message)awContentsClientCallbackHelper$OnReceivedHttpErrorInfo).arg1);
          f2 = Float.intBitsToFloat(((Message)awContentsClientCallbackHelper$OnReceivedHttpErrorInfo).arg2);
          AwContentsClientCallbackHelper.this.mContentsClient.onScaleChangedScaled(f1, f2);
          return;
        case 6:
          try {
            Picture picture;
            if (((Message)awContentsClientCallbackHelper$OnReceivedHttpErrorInfo).obj != null)
              picture = ((Callable<Picture>)((Message)awContentsClientCallbackHelper$OnReceivedHttpErrorInfo).obj).call(); 
            AwContentsClientCallbackHelper.this.mContentsClient.onNewPicture(picture);
            AwContentsClientCallbackHelper.this.mLastPictureTime = SystemClock.uptimeMillis();
            AwContentsClientCallbackHelper.this.mHasPendingOnNewPicture = false;
            return;
          } catch (Exception exception) {
            throw new RuntimeException("Error getting picture", exception);
          } 
        case 5:
          awContentsClientCallbackHelper$OnReceivedErrorInfo = (AwContentsClientCallbackHelper$OnReceivedErrorInfo)((Message)exception).obj;
          awContentsClient = AwContentsClientCallbackHelper.this.mContentsClient;
          awContentsClient$AwWebResourceRequest = awContentsClientCallbackHelper$OnReceivedErrorInfo.mRequest;
          awContentsClient$AwWebResourceError = awContentsClientCallbackHelper$OnReceivedErrorInfo.mError;
          if (awContentsClient$AwWebResourceRequest.isMainFrame)
            awContentsClient.onReceivedError(awContentsClient$AwWebResourceError.errorCode, awContentsClient$AwWebResourceError.description, awContentsClient$AwWebResourceRequest.url); 
          awContentsClient.onReceivedError2(awContentsClient$AwWebResourceRequest, awContentsClient$AwWebResourceError);
          return;
        case 4:
          awContentsClientCallbackHelper$LoginRequestInfo = (AwContentsClientCallbackHelper$LoginRequestInfo)((Message)awContentsClient).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onReceivedLoginRequest(awContentsClientCallbackHelper$LoginRequestInfo.mRealm, awContentsClientCallbackHelper$LoginRequestInfo.mAccount, awContentsClientCallbackHelper$LoginRequestInfo.mArgs);
          return;
        case 3:
          awContentsClientCallbackHelper$DownloadInfo = (AwContentsClientCallbackHelper$DownloadInfo)((Message)awContentsClientCallbackHelper$LoginRequestInfo).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onDownloadStart(awContentsClientCallbackHelper$DownloadInfo.mUrl, awContentsClientCallbackHelper$DownloadInfo.mUserAgent, awContentsClientCallbackHelper$DownloadInfo.mContentDisposition, awContentsClientCallbackHelper$DownloadInfo.mMimeType, awContentsClientCallbackHelper$DownloadInfo.mContentLength);
          return;
        case 2:
          str = (String)((Message)awContentsClientCallbackHelper$DownloadInfo).obj;
          AwContentsClientCallbackHelper.this.mContentsClient.onPageStarted(str);
          return;
        case 1:
          break;
      } 
      str = (String)((Message)str).obj;
      AwContentsClientCallbackHelper.this.mContentsClient.onLoadResource(str);
      return;
    } 
    AwContentsClientCallbackHelper.this.mContentsClient.onThemeColorChanged(((Message)str).arg1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsClientCallbackHelper$MyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */