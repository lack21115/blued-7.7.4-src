package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.webkit.WebResourceError;
import org.chromium.android_webview.AwContentsClient;

@TargetApi(23)
public final class WebResourceErrorAdapter extends WebResourceError {
  public final AwContentsClient.AwWebResourceError mError;
  
  public WebResourceErrorAdapter(AwContentsClient.AwWebResourceError paramAwWebResourceError) {
    this.mError = paramAwWebResourceError;
  }
  
  public final CharSequence getDescription() {
    return this.mError.description;
  }
  
  public final int getErrorCode() {
    return this.mError.errorCode;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebResourceErrorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */