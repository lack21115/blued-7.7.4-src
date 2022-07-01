package com.baidu.mobads;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.production.b.b;

public final class CpuAdView extends RelativeLayout {
  private b a;
  
  public CpuAdView(Context paramContext) {
    super(paramContext);
  }
  
  public CpuAdView(Context paramContext, String paramString, int paramInt) {
    super(paramContext);
    XAdView xAdView = new XAdView(paramContext);
    this.a = new b(paramContext, (RelativeLayout)xAdView, paramString, paramInt);
    this.a.request();
    addView((View)xAdView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public CpuAdView(Context paramContext, String paramString1, String paramString2, CpuInfoManager.UrlListener paramUrlListener) {
    super(paramContext);
    XAdView xAdView = new XAdView(paramContext);
    this.a = new b(paramContext, (RelativeLayout)xAdView, paramString1, paramString2);
    this.a.request();
    addView((View)xAdView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  protected boolean canGoBack() {
    try {
      return ((WebView)this.a.h.getAdView()).canGoBack();
    } finally {
      Exception exception = null;
    } 
  }
  
  protected void goBack() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public void onDestroy() {
    View view = this.a.h.getAdView();
    if (view instanceof WebView)
      ((WebView)view).destroy(); 
  }
  
  public boolean onKeyBackDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && canGoBack()) {
      goBack();
      return true;
    } 
    return false;
  }
  
  public void onPause() {
    View view = this.a.h.getAdView();
    if (view instanceof WebView)
      ((WebView)view).onPause(); 
  }
  
  public void onResume() {
    View view = this.a.h.getAdView();
    if (view instanceof WebView)
      ((WebView)view).onResume(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\CpuAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */