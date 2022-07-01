package com.android.webview.chromium;

final class WebViewChromiumAwInit$3 implements Runnable {
  public final void run() {
    synchronized (WebViewChromiumAwInit.this.mLock) {
      WebViewChromiumAwInit.this.startChromiumLocked();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromiumAwInit$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */