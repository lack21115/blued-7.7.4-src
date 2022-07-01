package com.qq.e.comm.plugin.intersitial2;

import com.qq.e.comm.managers.GDTADManager;

class g {
  static double a() {
    return GDTADManager.getInstance().getSM().getInteger("unifiedIntersitialPaddingRate", 84) / 100.0D;
  }
  
  static boolean a(String paramString) {
    return (GDTADManager.getInstance().getSM().getIntegerForPlacement("unifiedIntersitialAbandonInLandscape", paramString, 0) == 1);
  }
  
  static double b() {
    return GDTADManager.getInstance().getSM().getInteger("unifiedIntersitialVideoPaddingRate", 84) / 100.0D;
  }
  
  static boolean c() {
    return (GDTADManager.getInstance().getSM().getInteger("uivdwha", 1) == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */