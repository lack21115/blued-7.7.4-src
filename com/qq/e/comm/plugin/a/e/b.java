package com.qq.e.comm.plugin.a.e;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.NetworkType;

public class b {
  public static boolean a() {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (sM.getInteger("appLandingPageWifiAutoDownload", 0) == 1) {
      bool1 = bool2;
      if (NetworkType.WIFI == GDTADManager.getInstance().getDeviceStatus().getNetworkType())
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static boolean a(int paramInt, String paramString) {
    return (a(paramString) && paramInt != 1 && paramInt != 4);
  }
  
  public static boolean a(String paramString) {
    return (GDTADManager.getInstance().getSM().getIntegerForPlacement("appAutoDownload", paramString, 0) == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */