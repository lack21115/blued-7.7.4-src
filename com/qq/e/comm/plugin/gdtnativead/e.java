package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.r.a.d;
import com.qq.e.comm.plugin.util.ak;

public class e implements NEADI {
  NEADI a;
  
  public e(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, ADListener paramADListener) {
    g g;
    f f;
    if (d.a(paramContext).b(paramString2) && SDKStatus.getSDKVersionCode() >= 80) {
      g = new g(paramContext, paramADSize, paramString1, paramString2, paramADListener);
    } else {
      f = new f((Context)g, paramADSize, paramString1, paramString2, paramADListener);
    } 
    this.a = f;
  }
  
  public void loadAd(int paramInt) {
    ak.a("gdt_tag_callback", "loadUrl(count)");
    this.a.loadAd(paramInt);
  }
  
  public void loadAd(int paramInt, LoadAdParams paramLoadAdParams) {
    ak.a("gdt_tag_callback", "loadUrl(count, params)");
    this.a.loadAd(paramInt, paramLoadAdParams);
  }
  
  public void setBrowserType(int paramInt) {
    ak.a("gdt_tag_callback", "setBrowserType(value)");
    this.a.setBrowserType(paramInt);
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    ak.a("gdt_tag_callback", "setDownAPPConfirmPolicy(policy)");
    this.a.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy);
  }
  
  public void setMaxVideoDuration(int paramInt) {
    ak.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
    this.a.setMaxVideoDuration(paramInt);
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */