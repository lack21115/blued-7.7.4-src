package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.r.a.d;
import com.qq.e.comm.plugin.util.ak;
import java.util.List;

public class j implements NUADI {
  private NUADI a;
  
  public j(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    k k;
    i i;
    if (d.a(paramContext).b(paramString2)) {
      k = new k(paramContext, paramString1, paramString2, paramADListener);
    } else {
      i = new i((Context)k, paramString1, paramString2, paramADListener);
    } 
    this.a = i;
  }
  
  public String getAdNetWorkName() {
    ak.a("gdt_tag_callback", "getAdNetWorkName()");
    return this.a.getAdNetWorkName();
  }
  
  public void loadData(int paramInt) {
    ak.a("gdt_tag_callback", "loadData(count)");
    this.a.loadData(paramInt);
  }
  
  public void loadData(int paramInt, LoadAdParams paramLoadAdParams) {
    ak.a("gdt_tag_callback", "loadData(count, params)");
    this.a.loadData(paramInt, paramLoadAdParams);
  }
  
  public void setBrowserType(int paramInt) {
    ak.a("gdt_tag_callback", "setBrowserType(value)");
    this.a.setBrowserType(paramInt);
  }
  
  public void setCategories(List<String> paramList) {
    ak.a("gdt_tag_callback", "setCategories(categories)");
    this.a.setCategories(paramList);
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
  
  public void setVastClassName(String paramString) {
    ak.a("gdt_tag_callback", "setVastClassName(className)");
    this.a.setVastClassName(paramString);
  }
  
  public void setVideoADContainerRender(int paramInt) {
    ak.a("gdt_tag_callback", "setVideoADContainerRender(videoADContainerRender)");
    this.a.setVideoADContainerRender(paramInt);
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    ak.a("gdt_tag_callback", "setVideoPlayPolicy(videoPlayPolicy)");
    this.a.setVideoPlayPolicy(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */