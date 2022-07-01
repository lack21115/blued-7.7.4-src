package com.android.webview.chromium;

import android.webkit.TokenBindingService;
import java.security.KeyPair;

final class TokenBindingManagerAdapter$1$1 extends TokenBindingService.TokenBindingKey {
  public final String getAlgorithm() {
    return "ECDSAP256";
  }
  
  public final KeyPair getKeyPair() {
    return value;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\TokenBindingManagerAdapter$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */