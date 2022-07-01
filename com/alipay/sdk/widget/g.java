package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;

public abstract class g extends FrameLayout {
  protected Activity a;
  
  public g(Activity paramActivity) {
    super((Context)paramActivity);
    this.a = paramActivity;
  }
  
  public abstract void a();
  
  public abstract void a(String paramString);
  
  public void a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString2)) {
      CookieSyncManager.createInstance(this.a.getApplicationContext()).sync();
      CookieManager.getInstance().setCookie(paramString1, paramString2);
      CookieSyncManager.getInstance().sync();
    } 
  }
  
  public abstract boolean b();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */