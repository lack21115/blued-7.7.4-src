package com.blued.android.statistics;

import com.blued.android.statistics.util.Logger;

public class StatConfig {
  private static int a;
  
  private static int b;
  
  private static Logger c = new Logger("blued-statistics");
  
  public static Logger a() {
    return c;
  }
  
  public static String a(String paramString) {
    if (paramString != null && paramString.trim().length() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("blued-statistics");
      stringBuilder.append("-");
      stringBuilder.append(paramString);
      return stringBuilder.toString();
    } 
    return "blued-statistics";
  }
  
  protected static void a(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
    if (!paramBoolean)
      b(false); 
  }
  
  private static boolean a(int paramInt) {
    return ((a & paramInt) == paramInt);
  }
  
  protected static void b(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    b = bool;
  }
  
  public static boolean b() {
    return (b != 0);
  }
  
  private static boolean b(int paramInt) {
    return ((b & paramInt) == paramInt);
  }
  
  public static boolean c() {
    return a(1);
  }
  
  public static boolean d() {
    return b(1);
  }
  
  public static boolean e() {
    return a(2);
  }
  
  public static boolean f() {
    return b(2);
  }
  
  public static boolean g() {
    return a(4);
  }
  
  public static boolean h() {
    return b(4);
  }
  
  public static boolean i() {
    return a(8);
  }
  
  public static boolean j() {
    return b(8);
  }
  
  public static boolean k() {
    return a(16);
  }
  
  public static boolean l() {
    return b(16);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\StatConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */