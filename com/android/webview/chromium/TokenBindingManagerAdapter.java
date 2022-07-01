package com.android.webview.chromium;

import android.net.Uri;
import android.webkit.TokenBindingService;
import android.webkit.ValueCallback;
import org.chromium.android_webview.AwTokenBindingManager;
import org.chromium.base.Callback;

public final class TokenBindingManagerAdapter extends TokenBindingService {
  private boolean mEnabled;
  
  private WebViewChromiumFactoryProvider mProvider;
  
  private AwTokenBindingManager mTokenBindingManager = new AwTokenBindingManager();
  
  TokenBindingManagerAdapter(WebViewChromiumFactoryProvider paramWebViewChromiumFactoryProvider) {
    this.mProvider = paramWebViewChromiumFactoryProvider;
  }
  
  private void startChromiumEngine() {
    if (this.mEnabled) {
      this.mProvider.startYourEngines(false);
      return;
    } 
    throw new IllegalStateException("Token binding is not enabled");
  }
  
  public final void deleteAllKeys(ValueCallback paramValueCallback) {
    startChromiumEngine();
    this.mTokenBindingManager.nativeDeleteAllTokenBindingKeys(CallbackConverter.fromValueCallback(paramValueCallback));
  }
  
  public final void deleteKey(Uri paramUri, ValueCallback paramValueCallback) {
    startChromiumEngine();
    AwTokenBindingManager awTokenBindingManager = this.mTokenBindingManager;
    Callback callback = CallbackConverter.fromValueCallback(paramValueCallback);
    if (paramUri != null) {
      awTokenBindingManager.nativeDeleteTokenBindingKey(paramUri.getHost(), callback);
      return;
    } 
    throw new IllegalArgumentException("origin can't be null");
  }
  
  public final void enableTokenBinding() {
    if (!this.mProvider.mAwInit.mStarted) {
      this.mEnabled = true;
      this.mTokenBindingManager.nativeEnableTokenBinding();
      return;
    } 
    throw new IllegalStateException("Token binding cannot be enabled after webview creation");
  }
  
  public final void getKey(Uri paramUri, String[] paramArrayOfString, ValueCallback paramValueCallback) {
    startChromiumEngine();
    if (paramArrayOfString == null || paramArrayOfString.length != 0) {
      if (paramArrayOfString != null) {
        boolean bool1;
        int j = paramArrayOfString.length;
        boolean bool2 = false;
        int i = 0;
        while (true) {
          bool1 = bool2;
          if (i < j) {
            if (paramArrayOfString[i].equals("ECDSAP256")) {
              bool1 = true;
              break;
            } 
            i++;
            continue;
          } 
          break;
        } 
        if (!bool1)
          throw new IllegalArgumentException("no supported algorithm found"); 
      } 
      TokenBindingManagerAdapter$1 tokenBindingManagerAdapter$1 = new TokenBindingManagerAdapter$1(paramValueCallback);
      this.mTokenBindingManager.nativeGetTokenBindingKey(paramUri.getHost(), tokenBindingManagerAdapter$1);
      return;
    } 
    throw new IllegalArgumentException("algorithms cannot be empty");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\TokenBindingManagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */