package com.bytedance.embedapplog.util;

public class g {
  private static boolean a;
  
  private static long b;
  
  private static long c;
  
  public static long a() {
    return System.currentTimeMillis() / 86400000L;
  }
  
  public static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static void b() {
    b++;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("addFailedCount ");
    stringBuilder.append(b);
    h.a(stringBuilder.toString(), null);
  }
  
  public static boolean c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("canSave ");
    stringBuilder.append(a);
    h.a(stringBuilder.toString(), null);
    return a;
  }
  
  public static boolean d() {
    boolean bool;
    if (b < 3L && a() != c && a) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("canSend ");
    stringBuilder.append(bool);
    h.a(stringBuilder.toString(), null);
    return bool;
  }
  
  public static void e() {
    c = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSendFinished ");
    stringBuilder.append(c);
    h.a(stringBuilder.toString(), null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */