package com.huawei.secure.android.common.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UriUtil {
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      LogsUtil.a("UriUtil", "url is null");
      return paramString;
    } 
    try {
      if (!URLUtil.isNetworkUrl(paramString)) {
        LogsUtil.b("UriUtil", "url don't starts with http or https");
        return "";
      } 
      return (new URL(paramString.replaceAll("[\\\\#]", "/"))).getHost();
    } catch (MalformedURLException malformedURLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getHostByURI error  MalformedURLException : ");
      stringBuilder.append(malformedURLException.getMessage());
      LogsUtil.b("UriUtil", stringBuilder.toString());
      return "";
    } 
  }
  
  public static boolean a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      Log.e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
      return false;
    } 
    return TextUtils.equals(a(paramString1), b(paramString2));
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString) {
    if (paramArrayOfString == null || paramArrayOfString.length == 0) {
      LogsUtil.b("UriUtil", "whitelist is null");
      return false;
    } 
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (b(paramString, paramArrayOfString[i]))
        return true; 
    } 
    return false;
  }
  
  private static String b(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      LogsUtil.a("UriUtil", "whiteListUrl is null");
      return null;
    } 
    return !URLUtil.isNetworkUrl(paramString) ? paramString : a(paramString);
  }
  
  public static boolean b(String paramString1, String paramString2) {
    paramString1 = a(paramString1);
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      LogsUtil.b("UriUtil", "url or whitelist is null");
      return false;
    } 
    paramString2 = b(paramString2);
    if (TextUtils.isEmpty(paramString2)) {
      Log.e("UriUtil", "whitelist host is null");
      return false;
    } 
    if (paramString2.equals(paramString1))
      return true; 
    if (paramString1.endsWith(paramString2))
      try {
        paramString1 = paramString1.substring(0, paramString1.length() - paramString2.length());
        return !paramString1.endsWith(".") ? false : paramString1.matches("^[A-Za-z0-9.-]+$");
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IndexOutOfBoundsException");
        stringBuilder.append(indexOutOfBoundsException.getMessage());
        LogsUtil.b("UriUtil", stringBuilder.toString());
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception : ");
        stringBuilder.append(exception.getMessage());
        LogsUtil.b("UriUtil", stringBuilder.toString());
        return false;
      }  
    return false;
  }
  
  public static boolean b(String paramString, String[] paramArrayOfString) {
    if (paramArrayOfString == null || paramArrayOfString.length == 0) {
      LogsUtil.b("UriUtil", "whitelist is null");
      return false;
    } 
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (a(paramString, paramArrayOfString[i]))
        return true; 
    } 
    return false;
  }
  
  public static boolean c(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return false; 
      if (paramString1.contains("..") || paramString1.contains("@")) {
        Log.e("UriUtil", "url contains unsafe char");
        return false;
      } 
      if (!paramString2.equals(paramString1)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString2);
        stringBuilder.append("?");
        if (!paramString1.startsWith(stringBuilder.toString())) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramString2);
          stringBuilder.append("#");
          if (paramString1.startsWith(stringBuilder.toString()))
            return true; 
          if (!paramString2.endsWith("/"))
            return false; 
          List list = Uri.parse(paramString2).getPathSegments();
          return (Uri.parse(paramString1).getPathSegments().size() - list.size() != 1) ? false : paramString1.startsWith(paramString2);
        } 
      } 
      return true;
    } 
    return false;
  }
  
  public static boolean c(String paramString, String[] paramArrayOfString) {
    if (paramArrayOfString == null || paramArrayOfString.length == 0) {
      LogsUtil.b("UriUtil", "whitelist is null");
      return false;
    } 
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (c(paramString, paramArrayOfString[i]))
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\webview\UriUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */