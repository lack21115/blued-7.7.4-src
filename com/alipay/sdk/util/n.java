package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.i;
import com.alipay.sdk.app.j;
import com.alipay.sdk.app.k;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class n {
  static final String a = "com.eg.android.AlipayGphone";
  
  static final int b = 125;
  
  private static final String c = "com.alipay.android.app";
  
  private static final String d = "com.eg.android.AlipayGphoneRC";
  
  private static final int e = 99;
  
  private static final String[] f = new String[] { "10.1.5.1013151", "10.1.5.1013148" };
  
  private static a a(PackageInfo paramPackageInfo, int paramInt, String paramString) {
    return (paramPackageInfo == null) ? null : new a(paramPackageInfo, paramInt, paramString);
  }
  
  private static a a(com.alipay.sdk.sys.a parama, Context paramContext, String paramString1, int paramInt, String paramString2) {
    String str = paramString1;
    if (EnvUtils.isSandBox());
  }
  
  public static a a(com.alipay.sdk.sys.a parama, Context paramContext, List<com.alipay.sdk.data.a.a> paramList) {
    if (paramList == null)
      return null; 
    for (com.alipay.sdk.data.a.a a2 : paramList) {
      if (a2 == null)
        continue; 
      a a1 = a(parama, paramContext, a2.a, a2.b, a2.c);
      if (a1 != null && !a1.a(parama) && !a1.a())
        return a1; 
    } 
    return null;
  }
  
  static String a() {
    if (EnvUtils.isSandBox())
      return "com.eg.android.AlipayGphoneRC"; 
    try {
      return ((com.alipay.sdk.data.a.a)i.a.get(0)).a;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String a(int paramInt) {
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramInt; i++) {
      int j = random.nextInt(3);
      if (j != 0) {
        if (j != 1) {
          if (j == 2)
            stringBuilder.append(String.valueOf((new Random()).nextInt(10))); 
        } else {
          stringBuilder.append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 97.0D)));
        } 
      } else {
        stringBuilder.append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 65.0D)));
      } 
    } 
    return stringBuilder.toString();
  }
  
  static String a(Context paramContext, String paramString) {
    String str2 = "";
    try {
      Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      String str = "";
      while (iterator.hasNext()) {
        StringBuilder stringBuilder1;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
        if (runningAppProcessInfo.processName.equals(paramString)) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str);
          stringBuilder1.append("#M");
          str = stringBuilder1.toString();
          continue;
        } 
        String str3 = ((ActivityManager.RunningAppProcessInfo)stringBuilder1).processName;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramString);
        stringBuilder2.append(":");
        if (str3.startsWith(stringBuilder2.toString())) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append("#");
          str = ((ActivityManager.RunningAppProcessInfo)stringBuilder1).processName;
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString);
          stringBuilder1.append(":");
          stringBuilder.append(str.replace(stringBuilder1.toString(), ""));
          str = stringBuilder.toString();
        } 
      } 
    } finally {
      paramContext = null;
    } 
    String str1 = paramString;
    if (paramString.length() > 0)
      str1 = paramString.substring(1); 
    paramString = str1;
    if (str1.length() == 0)
      paramString = "N"; 
    return paramString;
  }
  
  public static String a(com.alipay.sdk.sys.a parama, Context paramContext) {
    return a(parama, paramContext, paramContext.getPackageName());
  }
  
  private static String a(com.alipay.sdk.sys.a parama, Context paramContext, String paramString) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramString, 128)).versionName;
    } finally {
      paramContext = null;
      com.alipay.sdk.app.statistic.a.a(parama, "biz", "GetPackageInfoEx", (Throwable)paramContext);
    } 
  }
  
  public static String a(com.alipay.sdk.sys.a parama, byte[] paramArrayOfbyte) {
    try {
      PublicKey publicKey = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramArrayOfbyte))).getPublicKey();
      if (publicKey instanceof RSAPublicKey) {
        BigInteger bigInteger = ((RSAPublicKey)publicKey).getModulus();
        if (bigInteger != null)
          return bigInteger.toString(16); 
      } 
    } catch (Exception exception) {
      com.alipay.sdk.app.statistic.a.a(parama, "auth", "GetPublicKeyFromSignEx", exception);
    } 
    return null;
  }
  
  static String a(String paramString) {
    return (EnvUtils.isSandBox() && TextUtils.equals(paramString, "com.eg.android.AlipayGphoneRC")) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    try {
      int j = paramString3.indexOf(paramString1) + paramString1.length();
      if (j <= paramString1.length())
        return ""; 
      int i = 0;
      return (i < 1) ? paramString3.substring(j) : paramString3.substring(j, i);
    } finally {
      paramString1 = null;
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      byte b = paramArrayOfbyte[i];
      stringBuilder.append(Character.forDigit((b & 0xF0) >> 4, 16));
      stringBuilder.append(Character.forDigit(b & 0xF, 16));
    } 
    return stringBuilder.toString();
  }
  
  public static Map<String, String> a(com.alipay.sdk.sys.a parama, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(4);
    int i = paramString.indexOf('?');
    if (i != -1 && i < paramString.length() - 1)
      for (String str : paramString.substring(i + 1).split("&")) {
        int j = str.indexOf('=', 1);
        if (j != -1 && j < str.length() - 1)
          hashMap.put(str.substring(0, j), b(parama, str.substring(j + 1))); 
      }  
    return (Map)hashMap;
  }
  
  public static boolean a(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.alipay.android.app", 128);
      return !(packageInfo == null);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  static boolean a(PackageInfo paramPackageInfo) {
    if (paramPackageInfo == null)
      return false; 
    try {
      String str = paramPackageInfo.versionName;
      return true;
    } finally {
      paramPackageInfo = null;
    } 
  }
  
  private static boolean a(com.alipay.sdk.sys.a parama, PackageInfo paramPackageInfo) {
    String str1;
    String str2 = "";
    boolean bool = false;
    if (paramPackageInfo == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append("info == null");
      str1 = stringBuilder.toString();
    } else if (((PackageInfo)str1).signatures == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append("info.signatures == null");
      str1 = stringBuilder.toString();
    } else if (((PackageInfo)str1).signatures.length <= 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append("info.signatures.length <= 0");
      String str = stringBuilder.toString();
    } else {
      bool = true;
      str1 = str2;
    } 
    if (!bool)
      com.alipay.sdk.app.statistic.a.a(parama, "auth", "NotIncludeSignatures", str1); 
    return bool;
  }
  
  public static boolean a(com.alipay.sdk.sys.a parama, WebView paramWebView, String paramString, Activity paramActivity) {
    if (TextUtils.isEmpty(paramString))
      return true; 
    if (paramActivity == null)
      return false; 
    if (paramString.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || paramString.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase()))
      try {
        a a1 = a(parama, (Context)paramActivity, i.a);
        return true;
      } finally {
        parama = null;
      }  
    if (TextUtils.equals(paramString, "sdklite://h5quit") || TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit")) {
      j.a(j.c());
      paramActivity.finish();
      return true;
    } 
    if (paramString.startsWith("sdklite://h5quit?result=")) {
      try {
        String str = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24);
        int i = Integer.parseInt(str.substring(str.lastIndexOf("&end_code=") + 10));
        if (i == k.a.a() || i == k.g.a()) {
          if (com.alipay.sdk.cons.a.u) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = URLDecoder.decode(paramString);
            paramString = URLDecoder.decode(str2);
            paramString = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24, paramString.lastIndexOf("&end_code=")).split("&return_url=")[0];
            int j = str2.indexOf("&return_url=") + 12;
            stringBuilder.append(paramString);
            stringBuilder.append("&return_url=");
            stringBuilder.append(str2.substring(j, str2.indexOf("&", j)));
            stringBuilder.append(str2.substring(str2.indexOf("&", j)));
            String str1 = stringBuilder.toString();
          } else {
            str = URLDecoder.decode(paramString);
            str = str.substring(str.indexOf("sdklite://h5quit?result=") + 24, str.lastIndexOf("&end_code="));
          } 
          k k1 = k.b(i);
          j.a(j.a(k1.a(), k1.b(), str));
          paramActivity.runOnUiThread(new o(paramActivity));
          return true;
        } 
        k k = k.b(k.b.a());
        j.a(j.a(k.a(), k.b(), ""));
      } catch (Exception exception) {
        j.a(j.e());
      } 
      paramActivity.runOnUiThread(new o(paramActivity));
      return true;
    } 
    return false;
  }
  
  private static PackageInfo b(Context paramContext, String paramString) throws PackageManager.NameNotFoundException {
    return paramContext.getPackageManager().getPackageInfo(paramString, 192);
  }
  
  public static String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Android ");
    stringBuilder.append(Build.VERSION.RELEASE);
    return stringBuilder.toString();
  }
  
  public static String b(com.alipay.sdk.sys.a parama, String paramString) {
    try {
      return URLDecoder.decode(paramString, "utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      com.alipay.sdk.app.statistic.a.a(parama, "biz", "H5PayDataAnalysisError", unsupportedEncodingException);
      return "";
    } 
  }
  
  public static Map<String, String> b(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (String str : paramString.split("&")) {
      int i = str.indexOf("=", 1);
      if (-1 != i)
        hashMap.put(str.substring(0, i), URLDecoder.decode(str.substring(i + 1))); 
    } 
    return (Map)hashMap;
  }
  
  public static boolean b(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(a(), 128);
      return (i < 99);
    } finally {
      paramContext = null;
      c.a((Throwable)paramContext);
    } 
  }
  
  public static boolean b(com.alipay.sdk.sys.a parama, Context paramContext, List<com.alipay.sdk.data.a.a> paramList) {
    try {
      Iterator<com.alipay.sdk.data.a.a> iterator = paramList.iterator();
      while (true)
        return false; 
    } finally {
      paramContext = null;
      com.alipay.sdk.app.statistic.a.a(parama, "biz", "CheckLaunchAppExistEx", (Throwable)paramContext);
    } 
  }
  
  public static String c() {
    String str2 = d();
    int i = str2.indexOf("-");
    String str1 = str2;
    if (i != -1)
      str1 = str2.substring(0, i); 
    i = str1.indexOf("\n");
    str2 = str1;
    if (i != -1)
      str2 = str1.substring(0, i); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Linux ");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
  
  public static String c(Context paramContext) {
    String str2 = b();
    String str3 = c();
    String str4 = d(paramContext);
    String str1 = e(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" (");
    stringBuilder.append(str2);
    stringBuilder.append(";");
    stringBuilder.append(str3);
    stringBuilder.append(";");
    stringBuilder.append(str4);
    stringBuilder.append(";");
    stringBuilder.append(";");
    stringBuilder.append(str1);
    stringBuilder.append(")");
    stringBuilder.append("(sdk android)");
    return stringBuilder.toString();
  }
  
  public static JSONObject c(String paramString) {
    try {
      return new JSONObject(paramString);
    } finally {
      paramString = null;
    } 
  }
  
  private static String d() {
    try {
      Matcher matcher;
      BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
      try {
        String str = bufferedReader.readLine();
        bufferedReader.close();
        matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(str);
        if (!matcher.matches())
          return "Unavailable"; 
        if (matcher.groupCount() < 4)
          return "Unavailable"; 
        StringBuilder stringBuilder = new StringBuilder(matcher.group(1));
        stringBuilder.append("\n");
        stringBuilder.append(matcher.group(2));
        stringBuilder.append(" ");
        stringBuilder.append(matcher.group(3));
        stringBuilder.append("\n");
        return stringBuilder.toString();
      } finally {
        matcher.close();
      } 
    } catch (IOException iOException) {
      return "Unavailable";
    } 
  }
  
  public static String d(Context paramContext) {
    return (paramContext.getResources().getConfiguration()).locale.toString();
  }
  
  public static boolean d(String paramString) {
    return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(paramString).matches();
  }
  
  public static String e(Context paramContext) {
    DisplayMetrics displayMetrics = h(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(displayMetrics.widthPixels);
    stringBuilder.append("*");
    stringBuilder.append(displayMetrics.heightPixels);
    return stringBuilder.toString();
  }
  
  public static String e(String paramString) {
    try {
      return String.format("%s%s", new Object[] { uri.getAuthority(), uri.getPath() });
    } finally {
      paramString = null;
      c.a((Throwable)paramString);
    } 
  }
  
  public static String f(Context paramContext) {
    String str = m.a(paramContext);
    return str.substring(0, str.indexOf("://"));
  }
  
  public static String f(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      return a(messageDigest.digest());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return "";
    } 
  }
  
  public static String g(Context paramContext) {
    return "-1;-1";
  }
  
  private static DisplayMetrics h(Context paramContext) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics;
  }
  
  public static final class a {
    public final PackageInfo a;
    
    public final int b;
    
    public final String c;
    
    public a(PackageInfo param1PackageInfo, int param1Int, String param1String) {
      this.a = param1PackageInfo;
      this.b = param1Int;
      this.c = param1String;
    }
    
    public boolean a() {
      return (this.a.versionCode < this.b);
    }
    
    public boolean a(com.alipay.sdk.sys.a param1a) {
      Signature[] arrayOfSignature = this.a.signatures;
      if (arrayOfSignature != null) {
        if (arrayOfSignature.length == 0)
          return false; 
        int j = arrayOfSignature.length;
        for (int i = 0; i < j; i++) {
          String str = n.a(param1a, arrayOfSignature[i].toByteArray());
          if (str != null && !TextUtils.equals(str, this.c)) {
            com.alipay.sdk.app.statistic.a.a(param1a, "biz", "PublicKeyUnmatch", String.format("Got %s, expected %s", new Object[] { str, this.c }));
            return true;
          } 
        } 
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */