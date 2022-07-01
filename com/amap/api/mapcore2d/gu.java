package com.amap.api.mapcore2d;

public final class gu {
  static String a = "http://apilocate.amap.com/mobile/binary";
  
  static String b = "";
  
  static String c;
  
  public static String d;
  
  public static String e;
  
  public static int f;
  
  public static String g;
  
  public static String h;
  
  static boolean i;
  
  static boolean j;
  
  private static final String[] k = new String[] { "com.amap.api.location", "com.loc", "com.amap.api.fence" };
  
  private static da l;
  
  private static boolean m;
  
  private static boolean n;
  
  static {
    c = "001;11B;11C;11F;11G;11H;11I;11K;122;135;13J;13S;14S;157;15O;15U";
    d = null;
    e = null;
    f = 30000;
    g = null;
    h = null;
    l = null;
    m = false;
    n = false;
    i = false;
    j = false;
  }
  
  public static String a() {
    return a;
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2) {
    if ("reportError".equals(paramString2))
      return; 
    try {
      if (paramThrowable instanceof cp)
        return; 
      return;
    } finally {
      paramThrowable = null;
    } 
  }
  
  public static boolean a(double paramDouble1, double paramDouble2) {
    int i = (int)((paramDouble2 - 73.0D) / 0.5D);
    int j = (int)((paramDouble1 - 3.5D) / 0.5D);
    if (j >= 0 && j < 101 && i >= 0) {
      if (i >= 124)
        return false; 
      try {
        return (i == 49);
      } finally {
        Exception exception = null;
        a(exception, "CoreUtil", "isChina");
      } 
    } 
    return false;
  }
  
  public static da b() {
    try {
      if (l == null)
        l = (new da.a("loc", "4.7.0", "AMAP_Location_SDK_Android 4.7.0")).a(c()).a("4.7.0").a(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  private static String[] c() {
    return (String[])k.clone();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */