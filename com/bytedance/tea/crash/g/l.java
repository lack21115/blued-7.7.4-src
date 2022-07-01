package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class l {
  private static final CharSequence a = "sony";
  
  private static final CharSequence b = "amigo";
  
  private static final CharSequence c = "funtouch";
  
  public static String a() {
    if (c.c())
      return j(); 
    if (c.d())
      return l(); 
    if (m())
      return n(); 
    String str = k();
    if (!TextUtils.isEmpty(str))
      return str; 
    if (e())
      return d(); 
    if (f())
      return g(); 
    if (c())
      return b(); 
    str = h();
    return !TextUtils.isEmpty(str) ? str : Build.DISPLAY;
  }
  
  private static String a(String paramString) {
    BufferedReader bufferedReader1;
    BufferedReader bufferedReader2;
    String str = "";
    BufferedReader bufferedReader3 = null;
    try {
      Runtime runtime = Runtime.getRuntime();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getprop ");
      stringBuilder.append(paramString);
      Process process = runtime.exec(stringBuilder.toString());
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
    } finally {
      paramString = null;
      bufferedReader1 = bufferedReader2;
    } 
    f.a(bufferedReader2);
    return (String)bufferedReader1;
  }
  
  public static String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a("ro.build.uiversion"));
    stringBuilder.append("_");
    stringBuilder.append(Build.DISPLAY);
    return stringBuilder.toString();
  }
  
  public static boolean c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append(Build.BRAND);
    String str = stringBuilder.toString();
    boolean bool1 = TextUtils.isEmpty(str);
    boolean bool = false;
    if (bool1)
      return false; 
    str = str.toLowerCase(Locale.getDefault());
    if (str.contains("360") || str.contains("qiku"))
      bool = true; 
    return bool;
  }
  
  public static String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a("ro.vivo.os.build.display.id"));
    stringBuilder.append("_");
    stringBuilder.append(a("ro.vivo.product.version"));
    return stringBuilder.toString();
  }
  
  public static boolean e() {
    String str = a("ro.vivo.os.build.display.id");
    return (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains(c));
  }
  
  public static boolean f() {
    return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(b));
  }
  
  public static String g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.DISPLAY);
    stringBuilder.append("_");
    stringBuilder.append(a("ro.gn.sv.version"));
    return stringBuilder.toString();
  }
  
  public static String h() {
    if (i()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("eui_");
      stringBuilder.append(a("ro.letv.release.version"));
      stringBuilder.append("_");
      stringBuilder.append(Build.DISPLAY);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static boolean i() {
    return TextUtils.isEmpty(a("ro.letv.release.version")) ^ true;
  }
  
  public static String j() {
    if (c.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("miui_");
      stringBuilder.append(a("ro.miui.ui.version.name"));
      stringBuilder.append("_");
      stringBuilder.append(Build.VERSION.INCREMENTAL);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static String k() {
    String str = c.a();
    if (str != null && str.toLowerCase(Locale.getDefault()).contains("emotionui")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("_");
      stringBuilder.append(Build.DISPLAY);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static String l() {
    String str = Build.DISPLAY;
    return (str != null && str.toLowerCase(Locale.getDefault()).contains("flyme")) ? str : "";
  }
  
  public static boolean m() {
    String str = Build.MANUFACTURER;
    return !TextUtils.isEmpty(str) ? str.toLowerCase(Locale.getDefault()).contains("oppo") : false;
  }
  
  public static String n() {
    if (m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("coloros_");
      stringBuilder.append(a("ro.build.version.opporom"));
      stringBuilder.append("_");
      stringBuilder.append(Build.DISPLAY);
      return stringBuilder.toString();
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */