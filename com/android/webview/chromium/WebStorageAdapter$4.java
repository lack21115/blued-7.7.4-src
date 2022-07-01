package com.android.webview.chromium;

import android.webkit.ValueCallback;

final class WebStorageAdapter$4 implements Runnable {
  public final void run() {
    WebStorageAdapter.access$000(WebStorageAdapter.this).getQuotaForOrigin(origin, CallbackConverter.fromValueCallback(callback));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebStorageAdapter$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */