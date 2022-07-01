package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.r.a.d;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ak;

public class i implements RVADI {
  private RVADI a;
  
  private String b;
  
  public i(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    k k;
    j j;
    if (d.a(paramContext).b(paramString2)) {
      k = new k(paramContext, paramString1, paramString2, paramADListener);
    } else {
      j = new j((Context)k, paramString1, paramString2, paramADListener);
    } 
    this.a = j;
    this.b = paramString2;
  }
  
  public String getAdNetWorkName() {
    ak.a("gdt_tag_callback", "getAdNetWorkName()");
    return this.a.getAdNetWorkName();
  }
  
  public int getECPM() {
    ak.a("gdt_tag_callback", "getECPM()");
    return this.a.getECPM();
  }
  
  public String getECPMLevel() {
    ak.a("gdt_tag_callback", "getECPMLevel()");
    return this.a.getECPMLevel();
  }
  
  public long getExpireTimestamp() {
    ak.a("gdt_tag_callback", "getExpireTimestamp()");
    return this.a.getExpireTimestamp();
  }
  
  public int getRewardAdType() {
    ak.a("gdt_tag_callback", "getRewardAdType()");
    return this.a.getRewardAdType();
  }
  
  public int getVideoDuration() {
    ak.a("gdt_tag_callback", "getVideoDuration()");
    return this.a.getVideoDuration();
  }
  
  public boolean hasShown() {
    ak.a("gdt_tag_callback", "hasShown()");
    return this.a.hasShown();
  }
  
  public void loadAD() {
    ak.a("gdt_tag_callback", "loadAD()");
    this.a.loadAD();
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    ak.a("gdt_tag_callback", "setLoadAdParams(loadAdParams)");
    this.a.setLoadAdParams(paramLoadAdParams);
  }
  
  public void setVolumeOn(boolean paramBoolean) {
    ak.a("gdt_tag_callback", "setVolumeOn(volumeOn)");
    this.a.setVolumeOn(paramBoolean);
  }
  
  public void showAD() {
    ak.a("gdt_tag_callback", "showAD()");
    ab.a().a(this.b);
    this.a.showAD();
  }
  
  public void showAD(Activity paramActivity) {
    ak.a("gdt_tag_callback", "showAD(activity)");
    ab.a().a(this.b);
    this.a.showAD(paramActivity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */