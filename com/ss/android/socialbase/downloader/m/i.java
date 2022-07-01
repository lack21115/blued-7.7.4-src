package com.ss.android.socialbase.downloader.m;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class i {
  public static String a;
  
  private static String b;
  
  private static String c;
  
  private static String d;
  
  public static boolean a() {
    return a("EMUI");
  }
  
  public static boolean a(String paramString) {
    String str = b;
    if (str != null)
      return str.equals(paramString); 
    str = b("ro.miui.ui.version.name");
    c = str;
    if (!TextUtils.isEmpty(str)) {
      b = "MIUI";
      a = "com.xiaomi.market";
    } else {
      str = b("ro.build.version.emui");
      c = str;
      if (!TextUtils.isEmpty(str)) {
        b = "EMUI";
        a = "com.huawei.appmarket";
      } else {
        str = b("ro.build.version.opporom");
        c = str;
        if (!TextUtils.isEmpty(str)) {
          b = "OPPO";
          a = "com.oppo.market";
        } else {
          str = b("ro.vivo.os.version");
          c = str;
          if (!TextUtils.isEmpty(str)) {
            b = "VIVO";
            a = "com.bbk.appstore";
          } else {
            str = b("ro.smartisan.version");
            c = str;
            if (!TextUtils.isEmpty(str)) {
              b = "SMARTISAN";
              a = "com.smartisanos.appstore";
            } else {
              str = b("ro.gn.sv.version");
              c = str;
              if (!TextUtils.isEmpty(str)) {
                b = "QIONEE";
                a = "com.gionee.aora.market";
              } else {
                str = b("ro.lenovo.lvp.version");
                c = str;
                if (!TextUtils.isEmpty(str)) {
                  b = "LENOVO";
                  a = "com.lenovo.leos.appstore";
                } else if (i().toUpperCase().contains("SAMSUNG")) {
                  b = "SAMSUNG";
                  a = "com.sec.android.app.samsungapps";
                } else if (i().toUpperCase().contains("ZTE")) {
                  b = "ZTE";
                  a = "zte.com.market";
                } else if (i().toLowerCase().contains("NUBIA")) {
                  b = "NUBIA";
                  a = "cn.nubia.neostore";
                } else {
                  c = Build.DISPLAY;
                  if (c.toUpperCase().contains("FLYME")) {
                    b = "FLYME";
                    a = "com.meizu.mstore";
                  } else {
                    c = "unknown";
                    b = Build.MANUFACTURER.toUpperCase();
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return b.equals(paramString);
  }
  
  public static String b(String paramString) {
    try {
      Runtime runtime = Runtime.getRuntime();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getprop ");
      stringBuilder.append(paramString);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec(stringBuilder.toString()).getInputStream()), 1024);
    } finally {
      paramString = null;
    } 
    if (paramString != null)
      try {
        paramString.close();
        return null;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return null;
  }
  
  public static boolean b() {
    return a("MIUI");
  }
  
  public static boolean c() {
    return a("VIVO");
  }
  
  public static boolean d() {
    return a("OPPO");
  }
  
  public static boolean e() {
    return a("SAMSUNG");
  }
  
  public static String f() {
    if (b == null)
      a(""); 
    return b;
  }
  
  public static String g() {
    if (c == null)
      a(""); 
    return c;
  }
  
  public static String h() {
    if (a == null)
      a(""); 
    return a;
  }
  
  public static final String i() {
    return (Build.MANUFACTURER == null) ? "" : Build.MANUFACTURER.trim();
  }
  
  public static boolean j() {
    l();
    return "V10".equals(d);
  }
  
  public static boolean k() {
    l();
    return "V11".equals(d);
  }
  
  private static void l() {
    if (d == null) {
      try {
        d = b("ro.miui.ui.version.name");
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      String str2 = d;
      String str1 = str2;
      if (str2 == null)
        str1 = ""; 
      d = str1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */