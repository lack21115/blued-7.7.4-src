package com.qq.e.comm.plugin.i;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.e.a;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.ay;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import java.io.File;
import java.util.List;

public class d {
  private static ay a = new ay(2048, 5, "downloaded_not_installed_limit_num");
  
  public static boolean a() {
    return a.b();
  }
  
  public static boolean a(long paramLong1, long paramLong2, c paramc) {
    g g = new g(2020035);
    paramLong1 = paramLong2 - paramLong1;
    g.b(paramLong1);
    c c1 = new c();
    c1.b(paramc.l());
    g.a(c1);
    u.a(g);
    return (paramLong1 >= GDTADManager.getInstance().getSM().getInteger("apk_downloaded_inter_time", 43200000));
  }
  
  public static boolean a(c paramc) {
    return (System.currentTimeMillis() - paramc.d() >= GDTADManager.getInstance().getSM().getInteger("apk_downloaded_time", 172800000));
  }
  
  public static boolean a(List<c> paramList) {
    return (paramList == null || paramList.size() == 0);
  }
  
  public static a b(c paramc) {
    return new a(paramc.h(), paramc.a(), paramc.b(), paramc.f(), paramc.i(), paramc);
  }
  
  public static void b(List<c> paramList) {
    int i = 0;
    while (true) {
      if (i < paramList.size()) {
        if (!((c)paramList.get(i)).c()) {
          i = 0;
          break;
        } 
        i++;
        continue;
      } 
      i = 1;
      break;
    } 
    if (i != 0)
      for (i = 0; i < paramList.size(); i++) {
        c c = paramList.get(i);
        c.a(false);
        l.a().b(c);
      }  
  }
  
  public static File c(c paramc) {
    File file = aj.h();
    return (file == null) ? null : a.a(file, paramc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */