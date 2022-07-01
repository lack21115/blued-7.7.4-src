package org.chromium.android_webview;

final class AwContents$BackgroundThreadClientImpl extends AwContentsBackgroundThreadClient {
  private AwContents$BackgroundThreadClientImpl() {}
  
  public final AwWebResourceResponse shouldInterceptRequest(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest) {
    String str = paramAwContentsClient$AwWebResourceRequest.url;
    AwWebResourceResponse awWebResourceResponse = AwContents.access$500(AwContents.this).shouldInterceptRequest(str);
    if (awWebResourceResponse != null)
      return awWebResourceResponse; 
    awWebResourceResponse = AwContents.access$600(AwContents.this).shouldInterceptRequest(paramAwContentsClient$AwWebResourceRequest);
    if (awWebResourceResponse == null) {
      AwContentsClientCallbackHelper awContentsClientCallbackHelper = (AwContents.access$600(AwContents.this)).mCallbackHelper;
      awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(1, str));
    } 
    if (awWebResourceResponse != null && awWebResourceResponse.getData() == null)
      (AwContents.access$600(AwContents.this)).mCallbackHelper.postOnReceivedError(paramAwContentsClient$AwWebResourceRequest, new AwContentsClient$AwWebResourceError()); 
    return awWebResourceResponse;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$BackgroundThreadClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */