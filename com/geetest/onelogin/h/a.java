package com.geetest.onelogin.h;

import android.text.TextUtils;
import com.geetest.onelogin.j.c;

public class a {
  private static boolean a;
  
  private static String b;
  
  private static String c;
  
  private static int d;
  
  public static void a(String paramString1, String paramString2, int paramInt) {
    a = e();
    b = paramString1;
    c = paramString2;
    d = paramInt;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init SenseBot hasSdk=");
    stringBuilder.append(a);
    stringBuilder.append(", api1=");
    stringBuilder.append(paramString1);
    stringBuilder.append(", api2=");
    stringBuilder.append(paramString2);
    c.a(stringBuilder.toString());
  }
  
  public static boolean a() {
    return (a && !TextUtils.isEmpty(b) && !TextUtils.isEmpty(c));
  }
  
  public static String b() {
    return b;
  }
  
  public static String c() {
    return c;
  }
  
  public static int d() {
    return d;
  }
  
  private static boolean e() {
    return com.geetest.onelogin.j.a.a("com.geetest.sdk.GT3GeetestUtils");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */