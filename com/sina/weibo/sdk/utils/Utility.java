package com.sina.weibo.sdk.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.WBAgent;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Utility {
  private static final String DEFAULT_CHARSET = "UTF-8";
  
  private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
  
  public static Bundle decodeUrl(String paramString) {
    Bundle bundle = new Bundle();
    if (paramString != null) {
      String[] arrayOfString = paramString.split("&");
      int j = arrayOfString.length;
      for (int i = 0;; i++) {
        if (i >= j)
          return bundle; 
        String[] arrayOfString1 = arrayOfString[i].split("=");
        try {
          bundle.putString(URLDecoder.decode(arrayOfString1[0], "UTF-8"), URLDecoder.decode(arrayOfString1[1], "UTF-8"));
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
        } 
      } 
    } 
    return bundle;
  }
  
  public static String generateGUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  public static String generateUA(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append("-");
    stringBuilder.append(Build.MODEL);
    stringBuilder.append("_");
    stringBuilder.append(Build.VERSION.RELEASE);
    stringBuilder.append("_");
    stringBuilder.append("weibosdk");
    stringBuilder.append("_");
    stringBuilder.append("0031405000");
    stringBuilder.append("_android");
    return stringBuilder.toString();
  }
  
  public static String generateUAAid(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append("-");
    stringBuilder.append(Build.MODEL);
    stringBuilder.append("__");
    stringBuilder.append("weibosdk");
    stringBuilder.append("__");
    try {
      stringBuilder.append("0031405000".replaceAll("\\s+", "_"));
    } catch (Exception exception) {
      stringBuilder.append("unknown");
    } 
    stringBuilder.append("__");
    stringBuilder.append("android");
    stringBuilder.append("__android");
    stringBuilder.append(Build.VERSION.RELEASE);
    return stringBuilder.toString();
  }
  
  public static String getAid(Context paramContext, String paramString) {
    AidTask.AidInfo aidInfo = AidTask.getInstance(paramContext).getAidSync(paramString);
    return (aidInfo != null) ? aidInfo.getAid() : "";
  }
  
  public static String getSign(Context paramContext, String paramString) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      for (int i = 0;; i++) {
        if (i >= packageInfo.signatures.length)
          return null; 
        byte[] arrayOfByte = packageInfo.signatures[i].toByteArray();
        if (arrayOfByte != null)
          return MD5.hexdigest(arrayOfByte); 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static boolean isChineseLocale(Context paramContext) {
    try {
      Locale locale = (paramContext.getResources().getConfiguration()).locale;
      if (!Locale.CHINA.equals(locale) && !Locale.CHINESE.equals(locale) && !Locale.SIMPLIFIED_CHINESE.equals(locale)) {
        boolean bool = Locale.TAIWAN.equals(locale);
        return bool;
      } 
      return true;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  public static Boolean isWeiBoVersionSupportNewPay(Context paramContext) {
    Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
    intent.addCategory("android.intent.category.DEFAULT");
    PackageManager packageManager = paramContext.getPackageManager();
    boolean bool = false;
    List list = packageManager.queryIntentServices(intent, 0);
    if (list == null || list.isEmpty())
      return Boolean.valueOf(false); 
    Iterator<ResolveInfo> iterator = list.iterator();
    int i = 0;
    while (true) {
      int j = i;
      if (!iterator.hasNext()) {
        if (j >= 1920)
          bool = true; 
        return Boolean.valueOf(bool);
      } 
      ResolveInfo resolveInfo = iterator.next();
      i = j;
      if (resolveInfo.serviceInfo != null) {
        i = j;
        if (resolveInfo.serviceInfo.applicationInfo != null) {
          if (TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName)) {
            i = j;
            continue;
          } 
          String str = resolveInfo.serviceInfo.applicationInfo.packageName;
          try {
            i = (paramContext.getPackageManager().getPackageInfo(str, 0)).versionCode;
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            i = j;
          } 
        } 
      } 
    } 
  }
  
  public static void openWeiboActivity(Context paramContext, String paramString, Bundle paramBundle) {
    try {
      Intent intent = new Intent();
      intent.setAction("android.intent.action.VIEW");
      intent.putExtra("_weibo_appPackage", paramContext.getPackageName());
      intent.setData(Uri.parse(paramString));
      intent.setFlags(268435456);
      intent.putExtras(paramBundle);
      paramContext.startActivity(intent);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      return;
    } 
  }
  
  public static Bundle parseUri(String paramString) {
    try {
      return decodeUrl((new URI(paramString)).getQuery());
    } catch (Exception exception) {
      return new Bundle();
    } 
  }
  
  public static Bundle parseUrl(String paramString) {
    try {
      URL uRL = new URL(paramString);
      Bundle bundle = decodeUrl(uRL.getQuery());
      bundle.putAll(decodeUrl(uRL.getRef()));
      return bundle;
    } catch (MalformedURLException malformedURLException) {
      return new Bundle();
    } 
  }
  
  public static String safeString(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = ""; 
    return str;
  }
  
  public static void shareMessagetoWeibo(Context paramContext, String paramString, Bundle paramBundle) {
    try {
      Intent intent = new Intent();
      String str = String.valueOf(System.currentTimeMillis());
      intent.putExtra("_weibo_transaction", str);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("other_app_action_start_time", str);
      try {
        WBAgent.onEvent(paramContext, "message", hashMap);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      intent.setAction("android.intent.action.VIEW");
      intent.putExtra("_weibo_appPackage", paramContext.getPackageName());
      intent.setData(Uri.parse(paramString));
      intent.setFlags(268435456);
      intent.putExtras(paramBundle);
      paramContext.startActivity(intent);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */