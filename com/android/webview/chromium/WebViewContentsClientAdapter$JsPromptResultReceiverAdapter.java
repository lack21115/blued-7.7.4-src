package com.android.webview.chromium;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import org.chromium.android_webview.JsPromptResultReceiver;
import org.chromium.android_webview.JsResultReceiver;

final class WebViewContentsClientAdapter$JsPromptResultReceiverAdapter implements JsResult.ResultReceiver {
  private JsPromptResultReceiver mChromePromptResultReceiver;
  
  private JsResultReceiver mChromeResultReceiver;
  
  final JsPromptResult mPromptResult = new JsPromptResult(this);
  
  public WebViewContentsClientAdapter$JsPromptResultReceiverAdapter(JsPromptResultReceiver paramJsPromptResultReceiver) {
    this.mChromePromptResultReceiver = paramJsPromptResultReceiver;
  }
  
  public WebViewContentsClientAdapter$JsPromptResultReceiverAdapter(JsResultReceiver paramJsResultReceiver) {
    this.mChromeResultReceiver = paramJsResultReceiver;
  }
  
  public final void onJsResultComplete(JsResult paramJsResult) {
    if (this.mChromePromptResultReceiver != null) {
      if (this.mPromptResult.getResult()) {
        this.mChromePromptResultReceiver.confirm(this.mPromptResult.getStringResult());
        return;
      } 
      this.mChromePromptResultReceiver.cancel();
      return;
    } 
    if (this.mPromptResult.getResult()) {
      this.mChromeResultReceiver.confirm();
      return;
    } 
    this.mChromeResultReceiver.cancel();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter$JsPromptResultReceiverAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */