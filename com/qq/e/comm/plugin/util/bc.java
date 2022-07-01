package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;

public class bc {
  public static void a(long paramLong, int paramInt, String paramString, c paramc) {
    g g = (new g(2020001)).b(paramLong).b(paramInt);
    g.a(paramc);
    paramInt = GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue();
    g.a((new d()).a("nt", Integer.valueOf(paramInt)).a("vu", paramString));
    u.a(g);
  }
  
  public static void b(long paramLong, int paramInt, String paramString, c paramc) {
    g g = (new g(2020002)).b(paramLong).b(paramInt);
    g.a(paramc);
    g.a((new d()).a("vu", paramString));
    u.a(g);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */