package com.blued.android.framework.utils;

import android.text.TextUtils;

public class StringUtils {
  public static int a(String paramString, int paramInt) {
    if (a(paramString))
      return paramInt; 
    try {
      return Integer.valueOf(paramString).intValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramInt;
    } 
  }
  
  public static long a(String paramString, long paramLong) {
    if (a(paramString))
      return paramLong; 
    try {
      return Long.valueOf(paramString).longValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramLong;
    } 
  }
  
  public static String a(int paramInt, String paramString) {
    return String.valueOf(paramInt);
  }
  
  public static boolean a(String paramString) {
    return (paramString == null || "".equals(paramString.trim()) || "null".equals(paramString) || paramString.equals(" "));
  }
  
  public static boolean a(String paramString1, String paramString2) {
    return a(paramString1, paramString2, true);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean) {
    return (paramString1 != null) ? ((paramString2 == null) ? false : ((!paramBoolean && (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString1))) ? false : paramString1.equals(paramString2))) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */