package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public class l {
  private static boolean a = s.a();
  
  private static String b;
  
  private static String c;
  
  private static long d = 0L;
  
  private static int a(String paramString) {
    String str;
    if (!TextUtils.isEmpty(c)) {
      str = c;
    } else {
      str = p.b("pre_sim_key", "");
      c = str;
    } 
    return TextUtils.isEmpty(str) ? 0 : (str.equals(paramString) ? 1 : 2);
  }
  
  public static String a(Context paramContext) {
    if (TextUtils.isEmpty(b)) {
      String str2 = p.b("phonescripcache", "");
      if (TextUtils.isEmpty(str2)) {
        f.a("PhoneScripUtils", "null");
        return null;
      } 
      d = p.b("phonescripstarttime", 0L);
      String str1 = e.b(paramContext, str2);
      b = str1;
      return str1;
    } 
    return b;
  }
  
  public static void a(Context paramContext, String paramString1, long paramLong, String paramString2) {
    b = paramString1;
    d = paramLong;
    c = paramString2;
    if (!a && !TextUtils.isEmpty(paramString2))
      u.a(new u.a(paramContext, paramString1, paramLong, paramString2) {
            protected void a() {
              f.b("PhoneScripUtils", "start save scrip to sp in sub thread");
              l.b(this.a, this.b, this.c, this.d);
            }
          }); 
  }
  
  public static void a(boolean paramBoolean) {
    p.a("phonescripcache");
    p.a("phonescripstarttime");
    p.a("pre_sim_key");
    if (paramBoolean) {
      b = null;
      c = null;
      d = 0L;
    } 
  }
  
  public static boolean a() {
    return a;
  }
  
  private static boolean a(long paramLong) {
    long l1 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    f.b("PhoneScripUtils", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(l1);
    stringBuilder.append("");
    f.b("PhoneScripUtils", stringBuilder.toString());
    return (paramLong - l1 > 120000L);
  }
  
  public static boolean a(Bundle paramBundle) {
    int i;
    if (!paramBundle.getBoolean("keyIsSimKeyICCID", false)) {
      i = a(paramBundle.getString("imsi"));
    } else {
      i = a(paramBundle.getString("iccid"));
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(i);
    stringBuilder2.append("");
    paramBundle.putString("imsiState", stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("simState = ");
    stringBuilder1.append(i);
    f.b("PhoneScripUtils", stringBuilder1.toString());
    if (i != 1)
      return false; 
    if (a) {
      f.b("PhoneScripUtils", "phone is root");
      a(false);
    } 
    return b();
  }
  
  private static boolean b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b);
    stringBuilder.append(" ");
    stringBuilder.append(c);
    stringBuilder.append(" ");
    stringBuilder.append(d);
    f.b("PhoneScripUtils", stringBuilder.toString());
    if (!TextUtils.isEmpty(b))
      return a(d); 
    String str = p.b("phonescripcache", "");
    long l1 = p.b("phonescripstarttime", 0L);
    return (!TextUtils.isEmpty(str) && a(l1));
  }
  
  private static void c(Context paramContext, String paramString1, long paramLong, String paramString2) {
    String str = e.a(paramContext, paramString1);
    if (!TextUtils.isEmpty(str)) {
      p.a("phonescripcache", str);
      p.a("phonescripstarttime", paramLong);
      p.a("pre_sim_key", paramString2);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */