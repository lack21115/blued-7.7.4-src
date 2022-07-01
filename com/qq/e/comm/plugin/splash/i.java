package com.qq.e.comm.plugin.splash;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;

class i {
  static long a() {
    return GDTADManager.getInstance().getSM().getInteger("splashADExpireDuration", 1800) * 1000L;
  }
  
  static void a(int paramInt) {
    GDTADManager.getInstance().getSM().setDEVCodeSetting("spl_ltime", Integer.valueOf(paramInt));
  }
  
  static void a(String paramString) {
    GDTADManager.getInstance().getSM().setDEVCodeSetting("splashContractWXAppId", paramString);
  }
  
  static int b(String paramString) {
    return GDTADManager.getInstance().getSM().getIntegerForPlacement("spl_exptime", paramString, 5000);
  }
  
  static boolean b() {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM.getInteger("splashLoadedEnqueueHead", 0) == 1)
      bool = true; 
    return bool;
  }
  
  static boolean c() {
    return (GDTADManager.getInstance().getSM().getInteger("SplashGuideBanner", 1) == 1);
  }
  
  static boolean c(String paramString) {
    return (GDTADManager.getInstance().getSM().getIntegerForPlacement("deepLink_confirm", paramString, 0) == 1);
  }
  
  static int d(String paramString) {
    return GDTADManager.getInstance().getSM().getIntegerForPlacement("download_confirm", paramString, 0);
  }
  
  static Object d() {
    return GDTADManager.getInstance().getSM().get("splashContractWXAppId");
  }
  
  static boolean e() {
    return (GDTADManager.getInstance().getSM().getInteger("splashVideoMd5Check", 1) == 1);
  }
  
  static long f() {
    return GDTADManager.getInstance().getSM().getInteger("splashVideoAnimationDuration", 400);
  }
  
  static int g() {
    return GDTADManager.getInstance().getSM().getInteger("spl_ltime", 3000);
  }
  
  static boolean h() {
    return (GDTADManager.getInstance().getSM().getInteger("preloadMarkEnable", 1) == 1);
  }
  
  static int i() {
    return GDTADManager.getInstance().getSM().getInteger("splashSkipShowDelay", 0);
  }
  
  static int j() {
    return GDTADManager.getInstance().getSM().getInteger("splashSkipPos", 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */