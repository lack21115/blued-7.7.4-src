package com.android.webview.chromium;

import android.content.Context;
import android.view.ViewGroup;
import org.chromium.android_webview.AwContents;
import org.chromium.components.autofill.AutofillProvider;

final class WebViewChromium$2 extends AwContents.DependencyFactory {
  public final AutofillProvider createAutofillProvider$9c0822e(Context paramContext) {
    WebViewChromiumFactoryProvider webViewChromiumFactoryProvider = WebViewChromium.this.mFactory;
    return WebViewChromiumFactoryProvider.createAutofillProvider(paramContext, (ViewGroup)WebViewChromium.this.mWebView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromium$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */