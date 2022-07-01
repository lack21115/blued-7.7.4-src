package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.tea.crash.upload.b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.Locale;

public class c {
  private static boolean a = false;
  
  public static String a() {
    return b("ro.build.version.emui");
  }
  
  public static boolean a(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = a(); 
    return (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) ? true : b();
  }
  
  private static String b(String paramString) {
    Closeable closeable;
    String str2 = null;
    String str1 = null;
    try {
      Runtime runtime = Runtime.getRuntime();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getprop ");
      stringBuilder.append(paramString);
      closeable = new BufferedReader(new InputStreamReader(runtime.exec(stringBuilder.toString()).getInputStream()), 1024);
    } finally {
      paramString = null;
      closeable = null;
    } 
    f.a(closeable);
    return paramString;
  }
  
  public static boolean b() {
    boolean bool = false;
    try {
      null = TextUtils.isEmpty(Build.BRAND);
      return true;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static boolean c() {
    if (!a) {
      try {
        if (Class.forName("miui.os.Build") != null) {
          b.a = true;
          a = true;
          return b.a;
        } 
      } catch (Exception exception) {}
      a = true;
    } 
    return b.a;
  }
  
  public static boolean d() {
    return (Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */