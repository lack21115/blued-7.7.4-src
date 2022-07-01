package com.android.webview.chromium;

import org.chromium.content_public.browser.MessagePort;

final class SharedWebViewChromium$3 implements Runnable {
  public final void run() {
    SharedWebViewChromium.this.postMessageToMainFrame(message, targetOrigin, sentPorts);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\SharedWebViewChromium$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */