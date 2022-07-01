package com.android.webview.chromium;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;

interface WebViewDelegateFactory$WebViewDelegate {
  void addWebViewAssetPath(Context paramContext);
  
  void callDrawGlFunction(Canvas paramCanvas, long paramLong);
  
  void callDrawGlFunction(Canvas paramCanvas, long paramLong, Runnable paramRunnable);
  
  boolean canInvokeDrawGlFunctor(View paramView);
  
  void detachDrawGlFunctor(View paramView, long paramLong);
  
  Application getApplication();
  
  String getDataDirectorySuffix();
  
  String getErrorString(Context paramContext, int paramInt);
  
  int getPackageId(Resources paramResources, String paramString);
  
  void invokeDrawGlFunctor(View paramView, long paramLong, boolean paramBoolean);
  
  boolean isMultiProcessEnabled();
  
  boolean isTraceTagEnabled();
  
  void setOnTraceEnabledChangeListener(WebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener paramWebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewDelegateFactory$WebViewDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */