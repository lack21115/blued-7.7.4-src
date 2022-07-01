package com.blued.android.core;

import java.util.Locale;

public class BlueAppLocal {
  public static String a() {
    return (AppInfo.d().getResources().getConfiguration()).locale.getLanguage();
  }
  
  public static String b() {
    return (AppInfo.d().getResources().getConfiguration()).locale.getCountry();
  }
  
  public static Locale c() {
    return (AppInfo.d().getResources().getConfiguration()).locale;
  }
  
  public static boolean d() {
    return "zh".equals(a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\BlueAppLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */