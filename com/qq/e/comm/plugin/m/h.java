package com.qq.e.comm.plugin.m;

import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;

public class h {
  static void a(int paramInt, c paramc) {
    if (paramInt != 0) {
      switch (paramInt) {
        default:
          return;
        case 2005:
          paramInt = 1210007;
          break;
        case 2004:
          paramInt = 1210006;
          break;
        case 2003:
          paramInt = 1210005;
          break;
        case 2002:
          paramInt = 1210004;
          break;
        case 2001:
          paramInt = 1210003;
          break;
      } 
    } else {
      paramInt = 121008;
    } 
    u.a(paramInt, paramc);
  }
  
  static void a(int paramInt, c paramc, String paramString) {
    if (paramInt != 301) {
      if (paramInt != 302)
        return; 
      u.a(1210021, 0, paramc, (new d()).a("video", paramString));
      return;
    } 
    u.a(1210022, paramc);
  }
  
  static void a(long paramLong, c paramc) {
    g g = (new g(2210001)).b(paramLong);
    g.a(paramc);
    u.a(g);
  }
  
  static void a(c paramc) {
    u.a(1210001, paramc);
  }
  
  static void a(boolean paramBoolean, c paramc) {
    int i;
    if (paramBoolean) {
      i = 1210023;
    } else {
      i = 1210024;
    } 
    u.a(i, paramc);
  }
  
  static void b(int paramInt, c paramc) {
    switch (paramInt) {
      default:
        return;
      case 104:
        paramInt = 1210009;
        break;
      case 103:
        paramInt = 1210012;
        break;
      case 102:
        paramInt = 1210011;
        break;
      case 101:
        paramInt = 1210010;
        break;
    } 
    u.a(paramInt, paramc);
  }
  
  static void b(long paramLong, c paramc) {
    g g = (new g(2210002)).b(paramLong);
    g.a(paramc);
    u.a(g);
  }
  
  static void b(c paramc) {
    u.a(1210013, paramc);
  }
  
  static void c(int paramInt, c paramc) {
    if (paramInt == 200) {
      paramInt = 1210014;
    } else {
      u.a(1210015, paramc);
      switch (paramInt) {
        default:
          return;
        case 206:
          paramInt = 1210020;
          u.a(paramInt, paramc);
          return;
        case 205:
          paramInt = 1210019;
          u.a(paramInt, paramc);
          return;
        case 204:
          paramInt = 1210018;
          u.a(paramInt, paramc);
          return;
        case 203:
          paramInt = 1210017;
          u.a(paramInt, paramc);
          return;
        case 202:
          break;
      } 
      paramInt = 1210016;
    } 
    u.a(paramInt, paramc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */