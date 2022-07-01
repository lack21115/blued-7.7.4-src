package com.qiniu.android.http;

import android.os.Build;
import android.text.TextUtils;
import com.qiniu.android.utils.StringUtils;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;

public final class UserAgent {
  private static UserAgent _instance = new UserAgent();
  
  public final String id = genId();
  
  public final String ua = getUserAgent(this.id);
  
  public static String device() {
    try {
      String str2 = Build.MODEL.trim();
      String str1 = deviceName(Build.MANUFACTURER.trim(), str2);
      null = str1;
      if (TextUtils.isEmpty(str1))
        null = deviceName(Build.BRAND.trim(), str2); 
      StringBuilder stringBuilder = new StringBuilder();
      str1 = null;
      if (null == null)
        str1 = "-"; 
      stringBuilder.append(str1);
      stringBuilder.append("-");
      return StringUtils.strip(stringBuilder.toString());
    } finally {
      Exception exception = null;
    } 
  }
  
  private static String deviceName(String paramString1, String paramString2) {
    String str = paramString1.toLowerCase(Locale.getDefault());
    return (str.startsWith("unknown") || str.startsWith("alps") || str.startsWith("android") || str.startsWith("sprd") || str.startsWith("spreadtrum") || str.startsWith("rockchip") || str.startsWith("wondermedia") || str.startsWith("mtk") || str.startsWith("mt65") || str.startsWith("nvidia") || str.startsWith("brcm") || str.startsWith("marvell") || paramString2.toLowerCase(Locale.getDefault()).contains(str)) ? null : paramString1;
  }
  
  private static String genId() {
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    stringBuilder.append(random.nextInt(999));
    return stringBuilder.toString();
  }
  
  static String getUserAgent(String paramString) {
    return String.format("QiniuAndroid/%s (%s; %s; %s", new Object[] { "7.4.6", osVersion(), device(), paramString });
  }
  
  public static UserAgent instance() {
    return _instance;
  }
  
  public static String osVersion() {
    try {
      return (null == null) ? "-" : StringUtils.strip(null.trim());
    } finally {
      Exception exception = null;
    } 
  }
  
  public String getUa(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramString);
    paramString = stringBuilder.toString().trim();
    paramString = paramString.substring(0, Math.min(16, paramString.length()));
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.ua);
    stringBuilder.append("; ");
    stringBuilder.append(paramString);
    stringBuilder.append(")");
    return new String(stringBuilder.toString().getBytes(Charset.forName("ISO-8859-1")));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\UserAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */