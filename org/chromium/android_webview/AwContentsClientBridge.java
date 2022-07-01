package org.chromium.android_webview;

import android.content.Context;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Handler;
import java.security.PrivateKey;
import java.util.HashMap;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.CalledByNativeUnchecked;

public class AwContentsClientBridge {
  AwContentsClient mClient;
  
  private Context mContext;
  
  private final ClientCertLookupTable mLookupTable;
  
  long mNativeContentsClientBridge;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwContentsClientBridge(Context paramContext, AwContentsClient paramAwContentsClient, ClientCertLookupTable paramClientCertLookupTable) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean allowCertificateError(int paramInt1, byte[] paramArrayOfbyte, String paramString, int paramInt2) {
    SslCertificate sslCertificate = SslUtil.getCertificateFromDerBytes(paramArrayOfbyte);
    if (sslCertificate == null)
      return false; 
    SslError sslError = SslUtil.sslErrorFromNetErrorCode(paramInt1, sslCertificate, paramString);
    AwContentsClientBridge$$Lambda$0 awContentsClientBridge$$Lambda$0 = new AwContentsClientBridge$$Lambda$0(this, paramInt2);
    (new Handler()).post(new AwContentsClientBridge$$Lambda$1(this, awContentsClientBridge$$Lambda$0, sslError));
    return true;
  }
  
  @CalledByNative
  private void handleJsAlert(String paramString1, String paramString2, int paramInt) {
    (new Handler()).post(new AwContentsClientBridge$$Lambda$2(this, paramInt, paramString1, paramString2));
  }
  
  @CalledByNative
  private void handleJsBeforeUnload(String paramString1, String paramString2, int paramInt) {
    (new Handler()).post(new AwContentsClientBridge$$Lambda$5(this, paramInt, paramString1, paramString2));
  }
  
  @CalledByNative
  private void handleJsConfirm(String paramString1, String paramString2, int paramInt) {
    (new Handler()).post(new AwContentsClientBridge$$Lambda$3(this, paramInt, paramString1, paramString2));
  }
  
  @CalledByNative
  private void handleJsPrompt(String paramString1, String paramString2, String paramString3, int paramInt) {
    (new Handler()).post(new AwContentsClientBridge$$Lambda$4(this, paramInt, paramString1, paramString2, paramString3));
  }
  
  private native void nativeProvideClientCertificateResponse(long paramLong, int paramInt, byte[][] paramArrayOfbyte, PrivateKey paramPrivateKey);
  
  @CalledByNative
  private void newDownload(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mClient.mCallbackHelper;
    AwContentsClientCallbackHelper$DownloadInfo awContentsClientCallbackHelper$DownloadInfo = new AwContentsClientCallbackHelper$DownloadInfo(paramString1, paramString2, paramString3, paramString4, paramLong);
    awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(3, awContentsClientCallbackHelper$DownloadInfo));
  }
  
  @CalledByNative
  private void newLoginRequest(String paramString1, String paramString2, String paramString3) {
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mClient.mCallbackHelper;
    AwContentsClientCallbackHelper$LoginRequestInfo awContentsClientCallbackHelper$LoginRequestInfo = new AwContentsClientCallbackHelper$LoginRequestInfo(paramString1, paramString2, paramString3);
    awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(4, awContentsClientCallbackHelper$LoginRequestInfo));
  }
  
  @CalledByNative
  private void onReceivedError(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt, String paramString3, boolean paramBoolean3) {
    AwContentsClient$AwWebResourceRequest awContentsClient$AwWebResourceRequest = new AwContentsClient$AwWebResourceRequest();
    awContentsClient$AwWebResourceRequest.url = paramString1;
    awContentsClient$AwWebResourceRequest.isMainFrame = paramBoolean1;
    awContentsClient$AwWebResourceRequest.hasUserGesture = paramBoolean2;
    awContentsClient$AwWebResourceRequest.method = paramString2;
    awContentsClient$AwWebResourceRequest.requestHeaders = new HashMap<Object, Object>(paramArrayOfString1.length);
    boolean bool = false;
    int i;
    for (i = 0; i < paramArrayOfString1.length; i++)
      awContentsClient$AwWebResourceRequest.requestHeaders.put(paramArrayOfString1[i], paramArrayOfString2[i]); 
    AwContentsClient$AwWebResourceError awContentsClient$AwWebResourceError = new AwContentsClient$AwWebResourceError();
    awContentsClient$AwWebResourceError.errorCode = paramInt;
    awContentsClient$AwWebResourceError.description = paramString3;
    paramString2 = AwContentsStatics.getUnreachableWebDataUrl();
    if (paramString2 != null && paramString2.equals(awContentsClient$AwWebResourceRequest.url)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if ((paramInt == 0 && awContentsClient$AwWebResourceError.errorCode != -3) || paramBoolean3) {
      if (paramBoolean3) {
        paramInt = -16;
      } else {
        paramInt = awContentsClient$AwWebResourceError.errorCode;
        switch (paramInt) {
          default:
            switch (paramInt) {
              default:
                switch (paramInt) {
                  default:
                    switch (paramInt) {
                      default:
                        switch (paramInt) {
                          default:
                            switch (paramInt) {
                              default:
                                switch (paramInt) {
                                  default:
                                    switch (paramInt) {
                                      default:
                                        switch (paramInt) {
                                          default:
                                            switch (paramInt) {
                                              default:
                                                paramInt = -1;
                                                break;
                                              case -310:
                                                paramInt = -9;
                                                break;
                                              case -331:
                                              case -1:
                                                paramInt = -7;
                                                break;
                                              case -22:
                                                paramInt = -6;
                                                break;
                                              case -166:
                                              case -137:
                                                paramInt = -2;
                                                break;
                                              case -323:
                                              case -123:
                                              case -210:
                                              case -343:
                                              case -341:
                                                break;
                                            } 
                                            break;
                                          case -8:
                                            paramInt = -13;
                                            break;
                                          case -7:
                                            break;
                                        } 
                                      case -14:
                                        paramInt = -14;
                                        break;
                                      case -15:
                                      
                                      case -13:
                                      case -12:
                                        paramInt = -15;
                                        break;
                                    } 
                                  case -104:
                                  case -103:
                                  case -102:
                                  case -101:
                                  case -100:
                                  case -109:
                                  case -108:
                                  case -106:
                                  case -105:
                                  
                                  case -118:
                                    paramInt = -8;
                                    break;
                                  case -119:
                                  
                                  case -115:
                                    paramInt = -5;
                                    break;
                                  case -117:
                                  case -116:
                                  case -114:
                                  case -113:
                                  case -112:
                                  case -111:
                                  case -110:
                                  case -107:
                                    break;
                                } 
                                break;
                              case -127:
                              
                              case -126:
                              case -125:
                                break;
                            } 
                            break;
                          case -130:
                          
                          case -129:
                            break;
                        } 
                        break;
                      case -135:
                      case -134:
                        break;
                    } 
                    paramInt = -11;
                    break;
                  case -208:
                  case -207:
                  case -206:
                  case -205:
                  case -204:
                  case -203:
                  case -202:
                  case -201:
                  case -200:
                    break;
                } 
                paramInt = bool;
                break;
              case -300:
                paramInt = -12;
                break;
              case -302:
              case -301:
                paramInt = -10;
                break;
            } 
          case -338:
            paramInt = -4;
            break;
          case -339:
            paramInt = -3;
            break;
        } 
      } 
      awContentsClient$AwWebResourceError.errorCode = paramInt;
      this.mClient.mCallbackHelper.postOnReceivedError(awContentsClient$AwWebResourceRequest, awContentsClient$AwWebResourceError);
      if (awContentsClient$AwWebResourceRequest.isMainFrame)
        this.mClient.mCallbackHelper.postOnPageFinished(awContentsClient$AwWebResourceRequest.url); 
    } 
  }
  
  @CalledByNative
  private void onReceivedHttpError(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString3, String paramString4, int paramInt, String paramString5, String[] paramArrayOfString3, String[] paramArrayOfString4) {
    AwContentsClient$AwWebResourceRequest awContentsClient$AwWebResourceRequest = new AwContentsClient$AwWebResourceRequest();
    awContentsClient$AwWebResourceRequest.url = paramString1;
    awContentsClient$AwWebResourceRequest.isMainFrame = paramBoolean1;
    awContentsClient$AwWebResourceRequest.hasUserGesture = paramBoolean2;
    awContentsClient$AwWebResourceRequest.method = paramString2;
    awContentsClient$AwWebResourceRequest.requestHeaders = new HashMap<Object, Object>(paramArrayOfString1.length);
    boolean bool = false;
    int i;
    for (i = 0; i < paramArrayOfString1.length; i++)
      awContentsClient$AwWebResourceRequest.requestHeaders.put(paramArrayOfString1[i], paramArrayOfString2[i]); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramArrayOfString3.length);
    for (i = bool; i < paramArrayOfString3.length; i++) {
      if (!hashMap.containsKey(paramArrayOfString3[i])) {
        hashMap.put(paramArrayOfString3[i], paramArrayOfString4[i]);
      } else if (!paramArrayOfString4[i].isEmpty()) {
        String str;
        paramString2 = (String)hashMap.get(paramArrayOfString3[i]);
        paramString1 = paramString2;
        if (!paramString2.isEmpty()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString2);
          stringBuilder1.append(", ");
          str = stringBuilder1.toString();
        } 
        paramString2 = paramArrayOfString3[i];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(paramArrayOfString4[i]);
        hashMap.put(paramString2, stringBuilder.toString());
      } 
    } 
    AwWebResourceResponse awWebResourceResponse = new AwWebResourceResponse(paramString3, paramString4, null, paramInt, paramString5, hashMap);
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mClient.mCallbackHelper;
    AwContentsClientCallbackHelper$OnReceivedHttpErrorInfo awContentsClientCallbackHelper$OnReceivedHttpErrorInfo = new AwContentsClientCallbackHelper$OnReceivedHttpErrorInfo(awContentsClient$AwWebResourceRequest, awWebResourceResponse);
    awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(8, awContentsClientCallbackHelper$OnReceivedHttpErrorInfo));
  }
  
  @CalledByNative
  private void setNativeContentsClientBridge(long paramLong) {
    this.mNativeContentsClientBridge = paramLong;
  }
  
  @CalledByNativeUnchecked
  private boolean shouldOverrideUrlLoading(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    AwContentsClient$AwWebResourceRequest awContentsClient$AwWebResourceRequest;
    AwContentsClient awContentsClient = this.mClient;
    Context context = this.mContext;
    AwContentsClientCallbackHelper$CancelCallbackPoller awContentsClientCallbackHelper$CancelCallbackPoller = awContentsClient.mCallbackHelper.mCancelCallbackPoller;
    if (awContentsClientCallbackHelper$CancelCallbackPoller != null && awContentsClientCallbackHelper$CancelCallbackPoller.shouldCancelAllCallbacks())
      return false; 
    if (awContentsClient.hasWebViewClient()) {
      awContentsClient$AwWebResourceRequest = new AwContentsClient$AwWebResourceRequest();
      awContentsClient$AwWebResourceRequest.url = paramString;
      awContentsClient$AwWebResourceRequest.isMainFrame = paramBoolean3;
      awContentsClient$AwWebResourceRequest.hasUserGesture = paramBoolean1;
      awContentsClient$AwWebResourceRequest.isRedirect = paramBoolean2;
      awContentsClient$AwWebResourceRequest.method = "GET";
      return awContentsClient.shouldOverrideUrlLoading(awContentsClient$AwWebResourceRequest);
    } 
    return AwContentsClient.sendBrowsingIntent((Context)awContentsClient$AwWebResourceRequest, paramString, paramBoolean1, paramBoolean2);
  }
  
  native void nativeCancelJsResult(long paramLong, int paramInt);
  
  native void nativeConfirmJsResult(long paramLong, int paramInt, String paramString);
  
  native void nativeProceedSslError(long paramLong, boolean paramBoolean, int paramInt);
  
  native void nativeTakeSafeBrowsingAction(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  @CalledByNative
  public void onSafeBrowsingHit(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2) {
    AwContentsClient$AwWebResourceRequest awContentsClient$AwWebResourceRequest = new AwContentsClient$AwWebResourceRequest();
    awContentsClient$AwWebResourceRequest.url = paramString1;
    awContentsClient$AwWebResourceRequest.isMainFrame = paramBoolean1;
    awContentsClient$AwWebResourceRequest.hasUserGesture = paramBoolean2;
    awContentsClient$AwWebResourceRequest.method = paramString2;
    awContentsClient$AwWebResourceRequest.requestHeaders = new HashMap<Object, Object>(paramArrayOfString1.length);
    boolean bool = false;
    int i;
    for (i = 0; i < paramArrayOfString1.length; i++)
      awContentsClient$AwWebResourceRequest.requestHeaders.put(paramArrayOfString1[i], paramArrayOfString2[i]); 
    AwContentsClientBridge$$Lambda$6 awContentsClientBridge$$Lambda$6 = new AwContentsClientBridge$$Lambda$6(this, paramInt2);
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mClient.mCallbackHelper;
    switch (paramInt1) {
      default:
        paramInt1 = bool;
        break;
      case 4:
        paramInt1 = 3;
        break;
      case 3:
        paramInt1 = 1;
        break;
      case 2:
        paramInt1 = 2;
        break;
    } 
    AwContentsClientCallbackHelper$OnSafeBrowsingHitInfo awContentsClientCallbackHelper$OnSafeBrowsingHitInfo = new AwContentsClientCallbackHelper$OnSafeBrowsingHitInfo(awContentsClient$AwWebResourceRequest, paramInt1, awContentsClientBridge$$Lambda$6);
    awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(15, awContentsClientCallbackHelper$OnSafeBrowsingHitInfo));
  }
  
  @CalledByNative
  protected void selectClientCertificate(int paramInt1, String[] paramArrayOfString, byte[][] paramArrayOfbyte, String paramString, int paramInt2) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsClientBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */