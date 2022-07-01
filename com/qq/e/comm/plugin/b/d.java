package com.qq.e.comm.plugin.b;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ak;

public class d implements UBVI {
  private final c a;
  
  private final a b;
  
  private final String c;
  
  public d(UnifiedBannerView paramUnifiedBannerView, Activity paramActivity, String paramString1, String paramString2, UnifiedBannerADListener paramUnifiedBannerADListener) {
    this.b = new a(paramUnifiedBannerView, this, paramUnifiedBannerADListener, paramString2);
    this.c = paramString2;
    this.a = new c((Context)paramActivity, new ADSize(-1, -2), paramString1, paramString2, this.b);
  }
  
  public void destroy() {
    ak.a("gdt_tag_callback", "destroy()");
    ab.a().a(this.c);
    NativeExpressADView nativeExpressADView = this.b.a();
    if (nativeExpressADView != null)
      nativeExpressADView.destroy(); 
    this.a.c();
  }
  
  public void fetchAd() {
    ak.a("gdt_tag_callback", "fetchAd()");
    this.a.a();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    ak.a("gdt_tag_callback", "onWindowFocusChanged(hasWindowFocus)");
    this.b.a(paramBoolean);
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    ak.a("gdt_tag_callback", "setDownAPPConfirmPolicy(policy)");
    this.a.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy);
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    ak.a("gdt_tag_callback", "setLoadAdParams(loadAdParams)");
    this.a.a(paramLoadAdParams);
  }
  
  public void setRefresh(int paramInt) {
    ak.a("gdt_tag_callback", "setRefresh(refresh)");
    this.a.b(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */