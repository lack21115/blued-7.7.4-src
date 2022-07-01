package com.amap.api.mapcore2d;

import java.util.Locale;
import java.util.Random;

class ax {
  private static ax b;
  
  private String a = "http://tm.amap.com";
  
  public static ax a() {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/ax
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/ax.b : Lcom/amap/api/mapcore2d/ax;
    //   6: ifnonnull -> 19
    //   9: new com/amap/api/mapcore2d/ax
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/amap/api/mapcore2d/ax.b : Lcom/amap/api/mapcore2d/ax;
    //   19: getstatic com/amap/api/mapcore2d/ax.b : Lcom/amap/api/mapcore2d/ax;
    //   22: astore_0
    //   23: ldc com/amap/api/mapcore2d/ax
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/amap/api/mapcore2d/ax
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public String b() {
    String str;
    int i = (new Random(System.currentTimeMillis())).nextInt(100000) % 4;
    if (q.m == 2) {
      str = String.format(Locale.US, "http://wprd0%d.is.autonavi.com", new Object[] { Integer.valueOf(i + 1) });
    } else {
      str = String.format(Locale.US, "http://webrd0%d.is.autonavi.com", new Object[] { Integer.valueOf(i + 1) });
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(q.a());
    return stringBuilder.toString();
  }
  
  public String c() {
    return this.a;
  }
  
  public String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://grid.amap.com/grid/%d/%d/%d?ds=");
    stringBuilder.append(q.i);
    return stringBuilder.toString();
  }
  
  public String e() {
    int i = (new Random(System.currentTimeMillis())).nextInt(100000);
    return String.format(Locale.US, "http://mst0%d.is.autonavi.com", new Object[] { Integer.valueOf(i % 4 + 1) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */