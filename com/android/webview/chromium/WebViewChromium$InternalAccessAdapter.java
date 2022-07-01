package com.android.webview.chromium;

import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import org.chromium.android_webview.AwContents;

final class WebViewChromium$InternalAccessAdapter implements AwContents.InternalAccessDelegate {
  private WebViewChromium$InternalAccessAdapter() {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean) {
    WebViewChromium.this.mWebViewPrivate.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public final void setMeasuredDimension(int paramInt1, int paramInt2) {
    WebViewChromium.this.mWebViewPrivate.setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public final boolean super_dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return WebViewChromium.this.mWebViewPrivate.super_dispatchKeyEvent(paramKeyEvent);
  }
  
  public final int super_getScrollBarStyle() {
    return WebViewChromium.this.mWebViewPrivate.super_getScrollBarStyle();
  }
  
  public final boolean super_onGenericMotionEvent(MotionEvent paramMotionEvent) {
    return WebViewChromium.this.mWebViewPrivate.super_onGenericMotionEvent(paramMotionEvent);
  }
  
  public final boolean super_onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return false;
  }
  
  public final void super_scrollTo(int paramInt1, int paramInt2) {
    WebViewChromium.this.mWebViewPrivate.super_scrollTo(paramInt1, paramInt2);
  }
  
  public final void super_startActivityForResult(Intent paramIntent, int paramInt) {
    if (Build.VERSION.SDK_INT >= 24) {
      WebViewChromium.this.mWebViewPrivate.super_startActivityForResult(paramIntent, paramInt);
      return;
    } 
    try {
      View.class.getMethod("startActivityForResult", new Class[] { Intent.class, int.class }).invoke(WebViewChromium.this.mWebView, new Object[] { paramIntent, Integer.valueOf(paramInt) });
      return;
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromium$InternalAccessAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */