package com.android.webview.chromium;

import org.chromium.android_webview.AwContents;

final class WebViewChromium$WebViewNativeDrawGLFunctorFactory implements AwContents.NativeDrawGLFunctorFactory {
  private WebViewChromium$WebViewNativeDrawGLFunctorFactory() {}
  
  public final AwContents.NativeDrawGLFunctor createFunctor(long paramLong) {
    return new DrawGLFunctor(paramLong, WebViewChromium.this.mFactory.mWebViewDelegate);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromium$WebViewNativeDrawGLFunctorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */