package com.qq.e.comm.plugin.l;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.s.e;

public class b {
  public static boolean a(e parame) {
    int i = GDTADManager.getInstance().getSM().getInteger("expOverlayVideoPage", 0);
    if (i != 1) {
      if (i == 0)
        return false; 
      if (a.a().a(parame, String.valueOf(i), 0) != 2)
        return false; 
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\l\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */