package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Locale;

public class cq {
  static String a;
  
  static boolean b = false;
  
  private static String c = "";
  
  private static String d = "";
  
  private static String e = "";
  
  private static String f = "";
  
  public static String a(Context paramContext) {
    try {
      return h(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  static void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    f = paramString;
  }
  
  static boolean a() {
    try {
      if (b)
        return true; 
      if (b(a))
        return true; 
      if (!TextUtils.isEmpty(a)) {
        b = false;
        return false;
      } 
      if (b(d))
        return true; 
      return true;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String b(Context paramContext) {
    try {
      if (!"".equals(c))
        return c; 
      PackageManager packageManager = paramContext.getPackageManager();
    } finally {
      paramContext = null;
    } 
    return c;
  }
  
  private static boolean b(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      paramString.toCharArray();
      char[] arrayOfChar = paramString.toCharArray();
      int j = arrayOfChar.length;
      int i = 0;
      while (i < j) {
        char c = arrayOfChar[i];
        if (('A' <= c && c <= 'z') || ('0' <= c && c <= ':') || c == '.') {
          i++;
          continue;
        } 
        try {
          return false;
        } finally {
          paramString = null;
        } 
      } 
      return true;
    } 
    return false;
  }
  
  public static String c(Context paramContext) {
    try {
      if (d != null && !"".equals(d))
        return d; 
      d = paramContext.getPackageName();
    } finally {
      paramContext = null;
    } 
    return d;
  }
  
  public static String d(Context paramContext) {
    try {
      if (!"".equals(e))
        return e; 
    } finally {
      paramContext = null;
    } 
    String str2 = e;
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public static String e(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64);
      Signature[] arrayOfSignature = packageInfo.signatures;
      int i = 0;
      byte[] arrayOfByte = arrayOfSignature[0].toByteArray();
      arrayOfByte = MessageDigest.getInstance("SHA1").digest(arrayOfByte);
      StringBuffer stringBuffer = new StringBuffer();
      while (i < arrayOfByte.length) {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF).toUpperCase(Locale.US);
        if (str.length() == 1)
          stringBuffer.append("0"); 
        stringBuffer.append(str);
        stringBuffer.append(":");
        i++;
      } 
      String str2 = packageInfo.packageName;
      String str1 = str2;
      if (b(str2))
        str1 = packageInfo.packageName; 
      if (!TextUtils.isEmpty(d))
        str1 = c(paramContext); 
      return a;
    } finally {
      paramContext = null;
      dl.a((Throwable)paramContext, "AI", "gsp");
    } 
  }
  
  public static String f(Context paramContext) {
    try {
      return h(paramContext);
    } finally {
      paramContext = null;
      dl.a((Throwable)paramContext, "AI", "gKy");
    } 
  }
  
  private static String g(Context paramContext) {
    File file = new File(dm.c(paramContext, "k.store"));
    if (!file.exists())
      return ""; 
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
    } finally {
      null = null;
    } 
    try {
      dl.a(null, "AI", "gKe");
      try {
        if (file.exists())
          file.delete(); 
      } finally {
        null = null;
      } 
    } finally {
      if (paramContext != null)
        try {
          paramContext.close();
        } finally {
          paramContext = null;
        }  
    } 
  }
  
  private static String h(Context paramContext) throws PackageManager.NameNotFoundException {
    String str = f;
    if (str == null || str.equals("")) {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo == null || applicationInfo.metaData == null)
        return f; 
      f = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
      if (f == null)
        f = g(paramContext); 
    } 
    return f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */