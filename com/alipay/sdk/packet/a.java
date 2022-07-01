package com.alipay.sdk.packet;

import android.text.TextUtils;

public class a {
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    String[] arrayOfString = paramString.split("&");
    if (arrayOfString.length == 0)
      return ""; 
    int j = arrayOfString.length;
    String str3 = null;
    paramString = str3;
    String str1 = paramString;
    String str2 = str1;
    int i = 0;
    while (i < j) {
      String str8 = arrayOfString[i];
      String str4 = str3;
      if (TextUtils.isEmpty(str3))
        str4 = b(str8); 
      String str5 = paramString;
      if (TextUtils.isEmpty(paramString))
        str5 = c(str8); 
      String str6 = str1;
      if (TextUtils.isEmpty(str1))
        str6 = d(str8); 
      String str7 = str2;
      if (TextUtils.isEmpty(str2))
        str7 = f(str8); 
      i++;
      str3 = str4;
      paramString = str5;
      str1 = str6;
      str2 = str7;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(str3)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("biz_type=");
      stringBuilder1.append(str3);
      stringBuilder1.append(";");
      stringBuilder.append(stringBuilder1.toString());
    } 
    if (!TextUtils.isEmpty(paramString)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("biz_no=");
      stringBuilder1.append(paramString);
      stringBuilder1.append(";");
      stringBuilder.append(stringBuilder1.toString());
    } 
    if (!TextUtils.isEmpty(str1)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("trade_no=");
      stringBuilder1.append(str1);
      stringBuilder1.append(";");
      stringBuilder.append(stringBuilder1.toString());
    } 
    if (!TextUtils.isEmpty(str2)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("app_userid=");
      stringBuilder1.append(str2);
      stringBuilder1.append(";");
      stringBuilder.append(stringBuilder1.toString());
    } 
    str1 = stringBuilder.toString();
    paramString = str1;
    if (str1.endsWith(";"))
      paramString = str1.substring(0, str1.length() - 1); 
    return paramString;
  }
  
  private static String b(String paramString) {
    return !paramString.contains("biz_type") ? null : e(paramString);
  }
  
  private static String c(String paramString) {
    return !paramString.contains("biz_no") ? null : e(paramString);
  }
  
  private static String d(String paramString) {
    return (!paramString.contains("trade_no") || paramString.startsWith("out_trade_no")) ? null : e(paramString);
  }
  
  private static String e(String paramString) {
    String[] arrayOfString = paramString.split("=");
    if (arrayOfString.length > 1) {
      String str2 = arrayOfString[1];
      String str1 = str2;
      if (str2.contains("\""))
        return str2.replaceAll("\"", ""); 
    } else {
      arrayOfString = null;
    } 
    return (String)arrayOfString;
  }
  
  private static String f(String paramString) {
    return !paramString.contains("app_userid") ? null : e(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\packet\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */