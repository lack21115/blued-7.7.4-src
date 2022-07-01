package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.CustomLandingPageListener;

public final class GlobalSetting {
  private static volatile CustomLandingPageListener a;
  
  private static volatile Integer b;
  
  private static volatile boolean c;
  
  private static volatile Boolean d;
  
  private static volatile String e;
  
  private static volatile String f;
  
  private static volatile String g;
  
  private static volatile String h;
  
  private static volatile String i;
  
  public static Integer getChannel() {
    return b;
  }
  
  public static String getCustomADActivityClassName() {
    return e;
  }
  
  public static CustomLandingPageListener getCustomLandingPageListener() {
    return a;
  }
  
  public static String getCustomLandscapeActivityClassName() {
    return h;
  }
  
  public static String getCustomPortraitActivityClassName() {
    return f;
  }
  
  public static String getCustomRewardvideoLandscapeActivityClassName() {
    return i;
  }
  
  public static String getCustomRewardvideoPortraitActivityClassName() {
    return g;
  }
  
  public static Boolean isAgreePrivacyStrategy() {
    return d;
  }
  
  public static boolean isEnableMediationTool() {
    return c;
  }
  
  public static void setAgreePrivacyStrategy(boolean paramBoolean) {
    if (d == null)
      d = Boolean.valueOf(paramBoolean); 
  }
  
  public static void setChannel(int paramInt) {
    if (b == null)
      b = Integer.valueOf(paramInt); 
  }
  
  public static void setCustomADActivityClassName(String paramString) {
    e = paramString;
  }
  
  public static void setCustomLandingPageListener(CustomLandingPageListener paramCustomLandingPageListener) {
    a = paramCustomLandingPageListener;
  }
  
  public static void setCustomLandscapeActivityClassName(String paramString) {
    h = paramString;
  }
  
  public static void setCustomPortraitActivityClassName(String paramString) {
    f = paramString;
  }
  
  public static void setCustomRewardvideoLandscapeActivityClassName(String paramString) {
    i = paramString;
  }
  
  public static void setCustomRewardvideoPortraitActivityClassName(String paramString) {
    g = paramString;
  }
  
  public static void setEnableMediationTool(boolean paramBoolean) {
    c = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\setting\GlobalSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */