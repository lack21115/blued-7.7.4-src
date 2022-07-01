package com.qq.e.comm.plugin.y;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.NetworkType;
import java.util.Random;

class h {
  private static final SM a = GDTADManager.getInstance().getSM();
  
  private static final int b = (new Random(System.currentTimeMillis())).nextInt(10000);
  
  private static final int c = a.getInteger("maxSingleSize", 1024);
  
  private static final boolean d;
  
  private static final boolean e;
  
  private static final boolean f;
  
  private static final int g = a.getInteger("maxCount", 30);
  
  private static final boolean h;
  
  private static final int i = a.getInteger("perfPeriod", 600);
  
  private static final int j = a.getInteger("eventPeriod", 600);
  
  private static final int k = a.getInteger("perfBatchCount", 30);
  
  private static final int l = a.getInteger("eventBatchCount", 30);
  
  private static final int m = a.getInteger("perfNetPer", 30);
  
  private static final int n = a.getInteger("eventNetPer", 30);
  
  static int a() {
    return c;
  }
  
  static int b() {
    return g;
  }
  
  static boolean c() {
    return d;
  }
  
  static boolean d() {
    return e;
  }
  
  static boolean e() {
    return h;
  }
  
  static boolean f() {
    return f;
  }
  
  static int g() {
    return i;
  }
  
  static int h() {
    return j;
  }
  
  static int i() {
    return k;
  }
  
  static int j() {
    return l;
  }
  
  static boolean k() {
    NetworkType networkType = GDTADManager.getInstance().getDeviceStatus().getNetworkType();
    int i = m;
    return ((networkType.getPermValue() & i) > 0);
  }
  
  static boolean l() {
    NetworkType networkType = GDTADManager.getInstance().getDeviceStatus().getNetworkType();
    int i = n;
    return ((networkType.getPermValue() & i) > 0);
  }
  
  static {
    int i = b;
    SM sM = a;
    boolean bool2 = false;
    if (i < sM.getInteger("perfRate", 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    d = bool1;
    if (b < a.getInteger("eventRate", 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    e = bool1;
    if (a.getInteger("eventInstant", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    f = bool1;
  }
  
  static {
    boolean bool1 = bool2;
    if (a.getInteger("perfInstant", 0) == 1)
      bool1 = true; 
    h = bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */