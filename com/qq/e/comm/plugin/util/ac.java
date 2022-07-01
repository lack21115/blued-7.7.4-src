package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.tencent.ams.a.a.a.a;

public class ac {
  public static void a(String paramString) {
    if (GDTADManager.getInstance().getSM().getInteger("mmaEnabled", 1) != 0 && !TextUtils.isEmpty(paramString)) {
      a.a().a(GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getSM().getString("mmaConfigUrl"));
      ah.a(a.a().a(paramString));
    } 
  }
  
  public static boolean a() {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM.getInteger("mma_disable_get_mac", 0) == 0)
      bool = true; 
    return bool;
  }
  
  public static boolean b() {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM.getInteger("mma_disable_get_imei", 0) == 0)
      bool = true; 
    return bool;
  }
  
  public static boolean c() {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM.getInteger("mma_disable_get_androidid", 0) == 0)
      bool = true; 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */