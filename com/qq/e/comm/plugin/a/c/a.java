package com.qq.e.comm.plugin.a.c;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.a.c;

public class a implements b {
  public boolean a(c paramc) {
    boolean bool1 = paramc.r();
    boolean bool = false;
    long l = System.currentTimeMillis() - paramc.d();
    if (bool1) {
      if (l > 432000000L)
        bool = true; 
    } else {
      if (l <= 259200000L)
        return false; 
      bool = true;
    } 
    return bool;
  }
  
  public boolean b(c paramc) {
    return (GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */