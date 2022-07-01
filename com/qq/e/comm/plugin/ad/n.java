package com.qq.e.comm.plugin.ad;

import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.plugin.r.a;

public class n implements AdData, a {
  private p a;
  
  private AdData.VideoPlayer b;
  
  public n(p paramp) {
    if (paramp == null)
      paramp = new o(); 
    this.a = paramp;
  }
  
  public void a(AdData.VideoPlayer paramVideoPlayer) {
    this.b = paramVideoPlayer;
  }
  
  public boolean equalsAdData(AdData paramAdData) {
    if (this != paramAdData) {
      if (paramAdData == null)
        return false; 
      String str2 = getProperty("ad_id");
      String str1 = paramAdData.getProperty("ad_id");
      if (str2 != null)
        return str2.equals(str1); 
      if (str1 != null)
        return false; 
    } 
    return true;
  }
  
  public int getAdPatternType() {
    return this.a.b("ad_pattern_type");
  }
  
  public String getDesc() {
    return this.a.a("ad_desc");
  }
  
  public int getECPM() {
    return this.a.b("ad_ecpm");
  }
  
  public String getECPMLevel() {
    return this.a.a("ad_ecpm_level");
  }
  
  public int getMediationPrice() {
    return this.a.b("ad_mp");
  }
  
  public <T> T getProperty(Class<T> paramClass) {
    return (T)((paramClass == AdData.VideoPlayer.class) ? this.b : ((paramClass == p.class) ? this.a : null));
  }
  
  public String getProperty(String paramString) {
    return this.a.a(paramString);
  }
  
  public String getTitle() {
    return this.a.a("ad_title");
  }
  
  public int getVideoDuration() {
    return this.a.b("ad_video_duration");
  }
  
  public boolean isContractAd() {
    return this.a.c("ad_contract_ad");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */