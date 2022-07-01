package com.amap.api.mapcore2d;

import com.autonavi.amap.mapcore2d.Inner_3dMap_location;

public final class gk {
  static da a;
  
  private static final String[] b = new String[] { "com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core" };
  
  private static final String[] c = new String[] { "com.amap.api.mapcore2d", "com.amap.api.maps2d" };
  
  private static final String[] d = new String[] { "com.amap.trace" };
  
  static {
    a = null;
  }
  
  public static da a() throws cp {
    Class<?> clazz;
    da da2;
    da da1 = a;
    if (da1 != null)
      return da1; 
    try {
      da2 = (da)Class.forName("com.amap.api.maps.MapsInitializer");
    } finally {
      da1 = null;
    } 
    if (clazz == null)
      try {
        clazz = Class.forName("com.amap.trace.AMapTraceClient");
      } finally {
        clazz = null;
      }  
    return a;
  }
  
  public static boolean a(gg paramgg) {
    return (paramgg == null) ? false : (paramgg.d().equals("8") ? false : (paramgg.d().equals("5") ? false : (paramgg.d().equals("6") ? false : a(paramgg))));
  }
  
  public static boolean a(Inner_3dMap_location paramInner_3dMap_location) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getLongitude : ()D
    //   4: dstore_1
    //   5: aload_0
    //   6: invokevirtual getLatitude : ()D
    //   9: dstore_3
    //   10: iconst_0
    //   11: istore #6
    //   13: dload_1
    //   14: dconst_0
    //   15: dcmpl
    //   16: ifne -> 29
    //   19: iload #6
    //   21: istore #5
    //   23: dload_3
    //   24: dconst_0
    //   25: dcmpl
    //   26: ifeq -> 76
    //   29: iload #6
    //   31: istore #5
    //   33: dload_1
    //   34: ldc2_w 180.0
    //   37: dcmpl
    //   38: ifgt -> 76
    //   41: dload_3
    //   42: ldc2_w 90.0
    //   45: dcmpl
    //   46: ifle -> 51
    //   49: iconst_0
    //   50: ireturn
    //   51: iload #6
    //   53: istore #5
    //   55: dload_1
    //   56: ldc2_w -180.0
    //   59: dcmpg
    //   60: iflt -> 76
    //   63: dload_3
    //   64: ldc2_w -90.0
    //   67: dcmpg
    //   68: ifge -> 73
    //   71: iconst_0
    //   72: ireturn
    //   73: iconst_1
    //   74: istore #5
    //   76: iload #5
    //   78: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */