package com.qq.e.comm.plugin.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.qq.e.comm.util.StringUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bb {
  public static String a(Uri paramUri) {
    String str2 = "";
    if (paramUri == null)
      return ""; 
    String str3 = paramUri.getPath();
    if (StringUtil.isEmpty(str3))
      return ""; 
    int i = str3.lastIndexOf("/0");
    String str1 = str3;
    if (i > 0)
      str1 = str3.substring(0, i); 
    str3 = MimeTypeMap.getFileExtensionFromUrl(str1);
    str1 = str2;
    if (!TextUtils.isEmpty(str3))
      str1 = str3.toLowerCase(); 
    return str1;
  }
  
  public static String a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[\\?&#]");
      stringBuilder.append(paramString2);
      stringBuilder.append("=([^&#]*)");
      Matcher matcher = Pattern.compile(stringBuilder.toString()).matcher(paramString1);
      if (matcher.find())
        return matcher.group(1); 
    } 
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    String str = paramString1;
    if (!StringUtil.isEmpty(paramString2)) {
      str = paramString1;
      if (!StringUtil.isEmpty(paramString3)) {
        if (StringUtil.isEmpty(paramString1))
          return paramString1; 
        str = "?";
        if (paramString1.contains("?"))
          str = "&"; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString1);
        stringBuilder.append(str);
        stringBuilder.append(paramString2);
        stringBuilder.append("=");
        stringBuilder.append(paramString3);
        str = stringBuilder.toString();
      } 
    } 
    return str;
  }
  
  public static boolean a(String paramString) {
    return b(Uri.parse(paramString));
  }
  
  public static Pair<Boolean, String> b(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(\\?|&|#)");
    stringBuilder1.append(paramString2);
    stringBuilder1.append("=([^&#]*)");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString2);
    stringBuilder2.append("=");
    stringBuilder2.append(paramString3);
    paramString2 = stringBuilder2.toString();
    Matcher matcher = Pattern.compile(str).matcher(paramString1);
    StringBuffer stringBuffer = new StringBuffer();
    boolean bool;
    for (bool = false; matcher.find(); bool = true) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(matcher.group(1));
      stringBuilder.append(paramString2);
      matcher.appendReplacement(stringBuffer, stringBuilder.toString());
    } 
    matcher.appendTail(stringBuffer);
    return new Pair(Boolean.valueOf(bool), stringBuffer.toString());
  }
  
  private static boolean b(Uri paramUri) {
    return (paramUri != null && paramUri.getScheme() != null && (paramUri.getScheme().equalsIgnoreCase("http") || paramUri.getScheme().equalsIgnoreCase("https")));
  }
  
  public static boolean b(String paramString) {
    return (!TextUtils.isEmpty(paramString) && !a(paramString));
  }
  
  public static a c(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
      str = paramString.toLowerCase(); 
    byte b = -1;
    switch (str.hashCode()) {
      case 3645340:
        if (str.equals("webp"))
          b = 5; 
        break;
      case 3268712:
        if (str.equals("jpeg"))
          b = 3; 
        break;
      case 3213227:
        if (str.equals("html"))
          b = 8; 
        break;
      case 111145:
        if (str.equals("png"))
          b = 4; 
        break;
      case 105441:
        if (str.equals("jpg"))
          b = 2; 
        break;
      case 102340:
        if (str.equals("gif"))
          b = 7; 
        break;
      case 98819:
        if (str.equals("css"))
          b = 0; 
        break;
      case 97669:
        if (str.equals("bmp"))
          b = 6; 
        break;
      case 3401:
        if (str.equals("js"))
          b = 1; 
        break;
    } 
    switch (b) {
      default:
        return a.a;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
        return a.d;
      case 1:
        return a.c;
      case 0:
        break;
    } 
    return a.b;
  }
  
  public static String c(String paramString1, String paramString2, String paramString3) {
    Pair<Boolean, String> pair = b(paramString1, paramString2, paramString3);
    return ((Boolean)pair.first).booleanValue() ? (String)pair.second : a(paramString1, paramString2, paramString3);
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2) && !TextUtils.isEmpty(paramString3)) {
      try {
        URL uRL = new URL(paramString1);
      } catch (MalformedURLException malformedURLException) {
        malformedURLException.printStackTrace();
        malformedURLException = null;
      } 
      if (malformedURLException != null) {
        String str = malformedURLException.getQuery();
        if (!TextUtils.isEmpty(str)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("(^|&)");
          stringBuilder.append(paramString2);
          stringBuilder.append("=");
          stringBuilder.append(paramString3);
          stringBuilder.append("(&|$)");
          return Pattern.compile(stringBuilder.toString()).matcher(str).find();
        } 
      } 
    } 
    return false;
  }
  
  public enum a {
    a("text/html"),
    b("text/css"),
    c("application/x-javascript"),
    d("image/*");
    
    private String e;
    
    a(String param1String1) {
      this.e = param1String1;
    }
    
    public String a() {
      return this.e;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */