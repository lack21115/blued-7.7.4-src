package com.qq.e.comm.constants;

import com.qq.e.ads.ADActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.ads.RewardvideoLandscapeADActivity;
import com.qq.e.ads.RewardvideoPortraitADActivity;
import com.qq.e.comm.DownloadService;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.StringUtil;

public class CustomPkgConstants {
  private static final String a = DownloadService.class.getName();
  
  private static final String b = ADActivity.class.getName();
  
  private static final String c = PortraitADActivity.class.getName();
  
  private static final String d = RewardvideoPortraitADActivity.class.getName();
  
  private static final String e = LandscapeADActivity.class.getName();
  
  private static final String f = RewardvideoLandscapeADActivity.class.getName();
  
  public static String getADActivityName() {
    String str = GlobalSetting.getCustomADActivityClassName();
    return !StringUtil.isEmpty(str) ? str : b;
  }
  
  public static String getAssetPluginDir() {
    return "gdt_plugin";
  }
  
  public static String getAssetPluginName() {
    return "gdtadv2.jar";
  }
  
  public static String getAssetPluginXorKey() {
    return "";
  }
  
  public static String getDownLoadServiceName() {
    return a;
  }
  
  public static String getLandscapeADActivityName() {
    String str = GlobalSetting.getCustomLandscapeActivityClassName();
    return !StringUtil.isEmpty(str) ? str : e;
  }
  
  public static String getPortraitADActivityName() {
    String str = GlobalSetting.getCustomPortraitActivityClassName();
    return !StringUtil.isEmpty(str) ? str : c;
  }
  
  public static String getRewardvideoLandscapeADActivityName() {
    String str = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
    return !StringUtil.isEmpty(str) ? str : f;
  }
  
  public static String getRewardvideoPortraitADActivityName() {
    String str = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
    return !StringUtil.isEmpty(str) ? str : d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\constants\CustomPkgConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */