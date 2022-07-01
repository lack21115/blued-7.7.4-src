package com.alipay.sdk.app;

public class j {
  private static boolean a = false;
  
  private static String b;
  
  public static String a() {
    return b;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resultStatus={");
    stringBuilder.append(paramInt);
    stringBuilder.append("};memo={");
    stringBuilder.append(paramString1);
    stringBuilder.append("};result={");
    stringBuilder.append(paramString2);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public static void a(String paramString) {
    b = paramString;
  }
  
  public static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static boolean b() {
    return a;
  }
  
  public static String c() {
    k k = k.b(k.c.a());
    return a(k.a(), k.b(), "");
  }
  
  public static String d() {
    k k = k.b(k.f.a());
    return a(k.a(), k.b(), "");
  }
  
  public static String e() {
    k k = k.b(k.e.a());
    return a(k.a(), k.b(), "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */