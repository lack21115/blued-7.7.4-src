package com.blued.android.framework.ui.xpop.util.navbar;

import android.text.TextUtils;

public class OSUtils {
  private static String a(String paramString1, String paramString2) {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { paramString1, paramString2 });
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramString2;
    } 
  }
  
  public static boolean a() {
    return TextUtils.isEmpty(a("ro.miui.ui.version.name", "")) ^ true;
  }
  
  public static boolean b() {
    return TextUtils.isEmpty(a("ro.build.version.emui", "")) ^ true;
  }
  
  public static String c() {
    boolean bool = b();
    String str = "";
    if (bool)
      str = a("ro.build.version.emui", ""); 
    return str;
  }
  
  public static boolean d() {
    String str = c();
    return ("EmotionUI 3".equals(str) || str.contains("EmotionUI_3.1"));
  }
  
  public static boolean e() {
    return c().contains("EmotionUI_3.0");
  }
  
  public static boolean f() {
    return (e() || d());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpo\\util\navbar\OSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */