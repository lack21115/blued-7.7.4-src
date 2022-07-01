package com.android.webview.chromium;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.WebViewDelegate;

final class WebViewDelegateFactory$ProxyDelegate implements WebViewDelegateFactory$WebViewDelegate {
  private WebViewDelegate mDelegate;
  
  WebViewDelegateFactory$ProxyDelegate(WebViewDelegate paramWebViewDelegate) {
    this.mDelegate = paramWebViewDelegate;
  }
  
  public final void addWebViewAssetPath(Context paramContext) {
    this.mDelegate.addWebViewAssetPath((Context)new WebViewDelegateFactory$ProxyDelegate$2(paramContext));
  }
  
  public final void callDrawGlFunction(Canvas paramCanvas, long paramLong) {
    this.mDelegate.callDrawGlFunction(paramCanvas, paramLong);
  }
  
  public final void callDrawGlFunction(Canvas paramCanvas, long paramLong, Runnable paramRunnable) {
    this.mDelegate.callDrawGlFunction(paramCanvas, paramLong, paramRunnable);
  }
  
  public final boolean canInvokeDrawGlFunctor(View paramView) {
    return this.mDelegate.canInvokeDrawGlFunctor(paramView);
  }
  
  public final void detachDrawGlFunctor(View paramView, long paramLong) {
    this.mDelegate.detachDrawGlFunctor(paramView, paramLong);
  }
  
  public final Application getApplication() {
    return this.mDelegate.getApplication();
  }
  
  public final String getDataDirectorySuffix() {
    return this.mDelegate.getDataDirectorySuffix();
  }
  
  public final String getErrorString(Context paramContext, int paramInt) {
    return this.mDelegate.getErrorString(paramContext, paramInt);
  }
  
  public final int getPackageId(Resources paramResources, String paramString) {
    return this.mDelegate.getPackageId(paramResources, paramString);
  }
  
  public final void invokeDrawGlFunctor(View paramView, long paramLong, boolean paramBoolean) {
    this.mDelegate.invokeDrawGlFunctor(paramView, paramLong, paramBoolean);
  }
  
  public final boolean isMultiProcessEnabled() {
    return this.mDelegate.isMultiProcessEnabled();
  }
  
  public final boolean isTraceTagEnabled() {
    return this.mDelegate.isTraceTagEnabled();
  }
  
  public final void setOnTraceEnabledChangeListener(WebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener paramWebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener) {
    this.mDelegate.setOnTraceEnabledChangeListener(new WebViewDelegateFactory$ProxyDelegate$1(paramWebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewDelegateFactory$ProxyDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */