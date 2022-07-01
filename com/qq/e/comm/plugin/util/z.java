package com.qq.e.comm.plugin.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;

public class z {
  private static volatile Boolean a;
  
  private static volatile Boolean b;
  
  private static volatile Boolean c;
  
  private static volatile Boolean d;
  
  private static volatile String e;
  
  private static volatile String f;
  
  private static volatile String g;
  
  private static volatile String h;
  
  private static volatile String i;
  
  private static volatile String j;
  
  private static volatile String k;
  
  private static volatile String l;
  
  public static Intent a(String paramString) {
    if (!TextUtils.isEmpty(paramString) && a()) {
      String str1 = f();
      String str2 = g();
      ak.b("gdt_tag_appstore", "storePackageName=%s,uri=%s", new Object[] { str1, str2 });
      if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(str2, new Object[] { paramString })));
        intent.setPackage(str1);
        intent.addFlags(268435456);
        return intent;
      } 
    } 
    return null;
  }
  
  private static String a(String paramString1, String paramString2) {
    paramString1 = GDTADManager.getInstance().getSM().getString(paramString1);
    return !TextUtils.isEmpty(paramString1) ? paramString1 : paramString2;
  }
  
  public static boolean a() {
    return (b() || c() || d() || e());
  }
  
  public static boolean b() {
    if (a == null) {
      String str = a("m_huawei", "HUAWEI");
      if (!TextUtils.isEmpty(str)) {
        String[] arrayOfString = str.split(",");
        if (arrayOfString != null && arrayOfString.length > 0) {
          int j = arrayOfString.length;
          for (int i = 0; i < j; i++) {
            String str1 = arrayOfString[i];
            if (!TextUtils.isEmpty(str1) && str1.equalsIgnoreCase(Build.MANUFACTURER)) {
              Boolean bool1 = Boolean.valueOf(true);
              // Byte code: goto -> 88
            } 
          } 
        } 
      } 
      Boolean bool = Boolean.valueOf(false);
      a = bool;
    } 
    return a.booleanValue();
  }
  
  public static boolean c() {
    if (b == null) {
      String str = a("m_oppo", "OPPO");
      if (!TextUtils.isEmpty(str)) {
        String[] arrayOfString = str.split(",");
        if (arrayOfString != null && arrayOfString.length > 0) {
          int j = arrayOfString.length;
          for (int i = 0; i < j; i++) {
            String str1 = arrayOfString[i];
            if (!TextUtils.isEmpty(str1) && str1.equalsIgnoreCase(Build.MANUFACTURER)) {
              Boolean bool1 = Boolean.valueOf(true);
              // Byte code: goto -> 88
            } 
          } 
        } 
      } 
      Boolean bool = Boolean.valueOf(false);
      b = bool;
    } 
    return b.booleanValue();
  }
  
  public static boolean d() {
    if (c == null) {
      String str = a("m_vivo", "vivo");
      if (!TextUtils.isEmpty(str)) {
        String[] arrayOfString = str.split(",");
        if (arrayOfString != null && arrayOfString.length > 0) {
          int j = arrayOfString.length;
          for (int i = 0; i < j; i++) {
            String str1 = arrayOfString[i];
            if (!TextUtils.isEmpty(str1) && str1.equalsIgnoreCase(Build.MANUFACTURER)) {
              Boolean bool1 = Boolean.valueOf(true);
              // Byte code: goto -> 88
            } 
          } 
        } 
      } 
      Boolean bool = Boolean.valueOf(false);
      c = bool;
    } 
    return c.booleanValue();
  }
  
  public static boolean e() {
    if (d == null) {
      String str = a("m_xiaomi", "Xiaomi");
      if (!TextUtils.isEmpty(str)) {
        String[] arrayOfString = str.split(",");
        if (arrayOfString != null && arrayOfString.length > 0) {
          int j = arrayOfString.length;
          for (int i = 0; i < j; i++) {
            String str1 = arrayOfString[i];
            if (!TextUtils.isEmpty(str1) && str1.equalsIgnoreCase(Build.MANUFACTURER)) {
              Boolean bool1 = Boolean.valueOf(true);
              // Byte code: goto -> 88
            } 
          } 
        } 
      } 
      Boolean bool = Boolean.valueOf(false);
      d = bool;
    } 
    return d.booleanValue();
  }
  
  private static String f() {
    if (b()) {
      if (TextUtils.isEmpty(e))
        e = a("pkg_huawei", "com.huawei.appmarket"); 
      return e;
    } 
    if (c()) {
      if (TextUtils.isEmpty(f))
        f = a("pkg_oppo", "com.oppo.market"); 
      return f;
    } 
    if (d()) {
      if (TextUtils.isEmpty(g))
        g = a("pkg_vivo", "com.bbk.appstore"); 
      return g;
    } 
    if (e()) {
      if (TextUtils.isEmpty(h))
        h = a("pkg_xiaomi", "com.xiaomi.market"); 
      return h;
    } 
    return null;
  }
  
  private static String g() {
    if (b()) {
      if (TextUtils.isEmpty(i))
        i = a("uri_huawei", "market://details?id=%s"); 
      return i;
    } 
    if (c()) {
      if (TextUtils.isEmpty(j))
        j = a("uri_oppo", "market://details?id=%s"); 
      return j;
    } 
    if (d()) {
      if (TextUtils.isEmpty(k))
        k = a("uri_vivo", "market://details?id=%s"); 
      return k;
    } 
    if (e()) {
      if (TextUtils.isEmpty(l))
        l = a("uri_xiaomi", "market://details?id=%s"); 
      return l;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */