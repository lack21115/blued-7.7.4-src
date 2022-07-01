package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;

public class at {
  public static String a() {
    String str2 = GDTADManager.getInstance().getADActivityClazz();
    String str1 = str2;
    if (str2 == null)
      str1 = "com.qq.e.ads.AdActivity"; 
    return str1;
  }
  
  public static String b() {
    String str2 = GDTADManager.getInstance().getPortraitADActivityClazz();
    String str1 = str2;
    if (str2 == null)
      str1 = "com.qq.e.ads.PortraitADActivity"; 
    return str1;
  }
  
  public static String c() {
    String str2 = GDTADManager.getInstance().getRewardvideoPortraitADActivityClazz();
    String str1 = str2;
    if (str2 == null)
      str1 = "com.qq.e.ads.RewardvideoPortraitADActivity"; 
    return str1;
  }
  
  public static String d() {
    String str2 = GDTADManager.getInstance().getLandscapeADActivityClazz();
    String str1 = str2;
    if (str2 == null)
      str1 = "com.qq.e.ads.LandscapeADActivity"; 
    return str1;
  }
  
  public static String e() {
    String str2 = GDTADManager.getInstance().getRewardvideoLandscapeADActivityClazz();
    String str1 = str2;
    if (str2 == null)
      str1 = "com.qq.e.ads.RewardvideoLandscapeADActivity"; 
    return str1;
  }
  
  public static String f() {
    String str2 = GDTADManager.getInstance().getDownLoadClazz();
    String str1 = str2;
    if (str2 == null)
      str1 = "com.qq.e.comm.DownloadService"; 
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */