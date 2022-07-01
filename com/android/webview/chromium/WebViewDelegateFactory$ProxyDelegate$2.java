package com.android.webview.chromium;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;

final class WebViewDelegateFactory$ProxyDelegate$2 extends ContextWrapper {
  WebViewDelegateFactory$ProxyDelegate$2(Context paramContext) {
    super(paramContext);
  }
  
  public final AssetManager getAssets() {
    return getResources().getAssets();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewDelegateFactory$ProxyDelegate$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */