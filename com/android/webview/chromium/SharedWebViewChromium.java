package com.android.webview.chromium;

import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.util.concurrent.FutureTask;
import org.chromium.android_webview.AwContents;
import org.chromium.android_webview.WebViewChromiumRunQueue;
import org.chromium.base.ThreadUtils;
import org.chromium.content.browser.AppWebMessagePort;
import org.chromium.content_public.browser.MessagePort;

public class SharedWebViewChromium {
  static final WebViewClient sNullWebViewClient;
  
  AwContents mAwContents;
  
  private final WebViewChromiumAwInit mAwInit;
  
  private final WebViewChromiumRunQueue mRunQueue;
  
  public WebChromeClient mWebChromeClient;
  
  public WebViewClient mWebViewClient = sNullWebViewClient;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SharedWebViewChromium(WebViewChromiumRunQueue paramWebViewChromiumRunQueue, WebViewChromiumAwInit paramWebViewChromiumAwInit) {
    this.mRunQueue = paramWebViewChromiumRunQueue;
    this.mAwInit = paramWebViewChromiumAwInit;
  }
  
  protected final boolean checkNeedsPost() {
    boolean bool;
    if (!this.mRunQueue.chromiumHasStarted() || !ThreadUtils.runningOnUiThread()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      if (this.mAwContents != null)
        return bool; 
      throw new IllegalStateException("AwContents must be created if we are not posting!");
    } 
    return bool;
  }
  
  public final MessagePort[] createWebMessageChannel() {
    this.mAwInit.startYourEngines(true);
    return (MessagePort[])(checkNeedsPost() ? this.mRunQueue.runBlockingFuture(new FutureTask(new SharedWebViewChromium$2(this))) : (this.mAwContents.isDestroyedOrNoOperation(1) ? null : AppWebMessagePort.createPair()));
  }
  
  public final void insertVisualStateCallback(long paramLong, AwContents.VisualStateCallback paramVisualStateCallback) {
    if (checkNeedsPost()) {
      this.mRunQueue.addTask(new SharedWebViewChromium$1(this, paramLong, paramVisualStateCallback));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyed(0)) {
      awContents.nativeInsertVisualStateCallback(awContents.mNativeAwContents, paramLong, paramVisualStateCallback);
      return;
    } 
    throw new IllegalStateException("insertVisualStateCallback cannot be called after the WebView has been destroyed");
  }
  
  public final void postMessageToMainFrame(String paramString1, String paramString2, MessagePort[] paramArrayOfMessagePort) {
    if (checkNeedsPost()) {
      this.mRunQueue.addTask(new SharedWebViewChromium$3(this, paramString1, paramString2, paramArrayOfMessagePort));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mWebContents.postMessageToFrame(null, paramString1, null, paramString2, paramArrayOfMessagePort); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\SharedWebViewChromium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */