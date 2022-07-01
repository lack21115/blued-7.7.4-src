package com.android.webview.chromium;

import android.webkit.HttpAuthHandler;
import org.chromium.android_webview.AwHttpAuthHandler;

final class WebViewContentsClientAdapter$AwHttpAuthHandlerAdapter extends HttpAuthHandler {
  private AwHttpAuthHandler mAwHandler;
  
  public WebViewContentsClientAdapter$AwHttpAuthHandlerAdapter(AwHttpAuthHandler paramAwHttpAuthHandler) {
    this.mAwHandler = paramAwHttpAuthHandler;
  }
  
  public final void cancel() {
    AwHttpAuthHandler awHttpAuthHandler = this.mAwHandler;
    if (awHttpAuthHandler.mNativeAwHttpAuthHandler != 0L) {
      awHttpAuthHandler.nativeCancel(awHttpAuthHandler.mNativeAwHttpAuthHandler);
      awHttpAuthHandler.mNativeAwHttpAuthHandler = 0L;
    } 
  }
  
  public final void proceed(String paramString1, String paramString2) {
    String str = paramString1;
    if (paramString1 == null)
      str = ""; 
    paramString1 = paramString2;
    if (paramString2 == null)
      paramString1 = ""; 
    AwHttpAuthHandler awHttpAuthHandler = this.mAwHandler;
    if (awHttpAuthHandler.mNativeAwHttpAuthHandler != 0L) {
      awHttpAuthHandler.nativeProceed(awHttpAuthHandler.mNativeAwHttpAuthHandler, str, paramString1);
      awHttpAuthHandler.mNativeAwHttpAuthHandler = 0L;
    } 
  }
  
  public final boolean useHttpAuthUsernamePassword() {
    return this.mAwHandler.mFirstAttempt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter$AwHttpAuthHandlerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */