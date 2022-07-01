package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.r.a.d;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ak;

public class c implements UIADI {
  UIADI a;
  
  private String b;
  
  public c(Activity paramActivity, String paramString1, String paramString2, UnifiedInterstitialADListener paramUnifiedInterstitialADListener) {
    e e;
    d d;
    if (d.a((Context)paramActivity).b(paramString2) && SDKStatus.getSDKVersionCode() >= 70) {
      e = new e(paramActivity, paramString1, paramString2, paramUnifiedInterstitialADListener);
    } else {
      d = new d((Activity)e, paramString1, paramString2, paramUnifiedInterstitialADListener);
    } 
    this.a = d;
    this.b = paramString2;
  }
  
  public void close() {
    ak.a("gdt_tag_callback", "close()");
    this.a.close();
  }
  
  public void destory() {
    ak.a("gdt_tag_callback", "destory()");
    this.a.destory();
  }
  
  public String getAdNetWorkName() {
    ak.a("gdt_tag_callback", "getAdNetWorkName()");
    return this.a.getAdNetWorkName();
  }
  
  public int getAdPatternType() {
    ak.a("gdt_tag_callback", "getAdPatternType()");
    return this.a.getAdPatternType();
  }
  
  public int getECPM() {
    ak.a("gdt_tag_callback", "getECPM()");
    return this.a.getECPM();
  }
  
  public String getECPMLevel() {
    ak.a("gdt_tag_callback", "getECPMLevel()");
    return this.a.getECPMLevel();
  }
  
  public boolean isValid() {
    ak.a("gdt_tag_callback", "isValid()");
    return this.a.isValid();
  }
  
  public void loadAd() {
    ak.a("gdt_tag_callback", "loadAd()");
    this.a.loadAd();
  }
  
  public void loadFullScreenAD() {
    ak.a("gdt_tag_callback", "loadFullScreenAD()");
    this.a.loadFullScreenAD();
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    ak.a("gdt_tag_callback", "setDownAPPConfirmPolicy(policy)");
    this.a.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy);
  }
  
  public void setMaxVideoDuration(int paramInt) {
    ak.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
    this.a.setMaxVideoDuration(paramInt);
  }
  
  public void setMediaListener(UnifiedInterstitialMediaListener paramUnifiedInterstitialMediaListener) {
    ak.a("gdt_tag_callback", "setMediaListener(listener)");
    this.a.setMediaListener(paramUnifiedInterstitialMediaListener);
  }
  
  public void setMinVideoDuration(int paramInt) {
    ak.a("gdt_tag_callback", "setMinVideoDuration(minVideoDuration)");
    this.a.setMinVideoDuration(paramInt);
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    ak.a("gdt_tag_callback", "setVideoOption(videoOption)");
    this.a.setVideoOption(paramVideoOption);
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    ak.a("gdt_tag_callback", "setVideoPlayPolicy(videoPlayPolicy)");
    this.a.setVideoPlayPolicy(paramInt);
  }
  
  public void show() {
    ak.a("gdt_tag_callback", "show()");
    ab.a().a(this.b);
    this.a.show();
  }
  
  public void show(Activity paramActivity) {
    ak.a("gdt_tag_callback", "show(activity)");
    ab.a().a(this.b);
    this.a.show(paramActivity);
  }
  
  public void showAsPopupWindow() {
    ak.a("gdt_tag_callback", "showAsPopupWindow()");
    ab.a().a(this.b);
    this.a.showAsPopupWindow();
  }
  
  public void showAsPopupWindow(Activity paramActivity) {
    ak.a("gdt_tag_callback", "showAsPopupWindow(activity)");
    ab.a().a(this.b);
    this.a.showAsPopupWindow(paramActivity);
  }
  
  public void showFullScreenAD(Activity paramActivity) {
    ak.a("gdt_tag_callback", "showFullScreenAD(activity)");
    ab.a().a(this.b);
    this.a.showFullScreenAD(paramActivity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */