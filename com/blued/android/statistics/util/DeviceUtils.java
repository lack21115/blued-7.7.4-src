package com.blued.android.statistics.util;

import android.os.Build;

public class DeviceUtils {
  public static String a() {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.toLowerCase().startsWith(str1.toLowerCase()))
      return a(str2); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a(str1));
    stringBuilder.append(" ");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
  
  private static String a(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return ""; 
    char c = paramString.charAt(0);
    if (Character.isUpperCase(c))
      return paramString; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Character.toUpperCase(c));
    stringBuilder.append(paramString.substring(1));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistic\\util\DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */