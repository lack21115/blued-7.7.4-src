package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.r.a.d;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ak;

public class c implements NSPVI {
  private NSPVI a;
  
  private String b;
  
  public c(Context paramContext, String paramString1, String paramString2) {
    d d;
    b b;
    if (d.a(paramContext).b(paramString2)) {
      d = new d(paramContext, paramString1, paramString2);
    } else {
      b = new b((Context)d, paramString1, paramString2);
    } 
    this.a = b;
    this.b = paramString2;
  }
  
  public void fetchAdOnly() {
    ak.a("gdt_tag_callback", "fetchAdOnly()");
    this.a.fetchAdOnly();
  }
  
  public void fetchAndShowIn(ViewGroup paramViewGroup) {
    ak.a("gdt_tag_callback", "fetchAndShowIn(container)");
    this.a.fetchAndShowIn(paramViewGroup);
  }
  
  public String getAdNetWorkName() {
    ak.a("gdt_tag_callback", "getAdNetWorkName()");
    return this.a.getAdNetWorkName();
  }
  
  public String getECPMLevel() {
    return this.a.getECPMLevel();
  }
  
  public void preload() {
    ak.a("gdt_tag_callback", "preload()");
    this.a.preload();
  }
  
  public void setAdListener(ADListener paramADListener) {
    ak.a("gdt_tag_callback", "setAdListener(listener)");
    this.a.setAdListener(paramADListener);
  }
  
  public void setAdLogoMargin(int paramInt1, int paramInt2) {
    ak.a("gdt_tag_callback", "setAdLogoMargin(topMargin, leftMargin)");
    this.a.setAdLogoMargin(paramInt1, paramInt2);
  }
  
  public void setFetchDelay(int paramInt) {
    ak.a("gdt_tag_callback", "setFetchDelay(fetchDelay)");
    this.a.setFetchDelay(paramInt);
  }
  
  public void setFloatView(View paramView) {
    ak.a("gdt_tag_callback", "setFloatView(view)");
    this.a.setFloatView(paramView);
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    ak.a("gdt_tag_callback", "setLoadAdParams(params)");
    this.a.setLoadAdParams(paramLoadAdParams);
  }
  
  public void setPreloadView(View paramView) {
    ak.a("gdt_tag_callback", "setPreloadView(view)");
    this.a.setPreloadView(paramView);
  }
  
  public void setSkipView(View paramView) {
    ak.a("gdt_tag_callback", "setSkipView(view)");
    this.a.setSkipView(paramView);
  }
  
  public void showAd(ViewGroup paramViewGroup) {
    ak.a("gdt_tag_callback", "showAd(container)");
    ab.a().a(this.b);
    this.a.showAd(paramViewGroup);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */