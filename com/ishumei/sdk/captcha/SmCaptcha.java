package com.ishumei.sdk.captcha;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmCaptcha {
  private static Pattern O0000O000000oO = Pattern.compile("code\":(\\d+)");
  
  static {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String O0000O000000oO(String paramString1, String paramString2) {
    try {
      return (new SmCaptcha()).m2(paramString1, paramString2);
    } finally {
      paramString1 = null;
    } 
  }
  
  private static boolean O0000O000000oO(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    Matcher matcher = O0000O000000oO.matcher(paramString);
    return matcher.find() ? matcher.group(1).equals("1100") : false;
  }
  
  public static WebResourceResponse O000O00000OoO(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      int i = paramString.indexOf("?");
      if (i == -1)
        return null; 
      String str = paramString.substring(0, i);
      Map<String, String> map = O000O0000O0oO.O000O00000o0O(paramString);
      paramString = map.remove(O000O00000oO.O0000O000000oO("908d989e9196859e8b969091"));
      return null;
    } finally {
      paramString = null;
    } 
  }
  
  public static String O000O00000OoO(String paramString1, String paramString2) {
    try {
      return (new SmCaptcha()).x2(paramString1, paramString2);
    } finally {
      paramString1 = null;
    } 
  }
  
  public native String m2(String paramString1, String paramString2);
  
  public native String x2(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\sdk\captcha\SmCaptcha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */