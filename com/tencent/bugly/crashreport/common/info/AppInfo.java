package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class AppInfo {
  private static ActivityManager a;
  
  static {
    "@buglyAllChannel@".split(",");
    "@buglyAllChannelPriority@".split(",");
  }
  
  public static String a(int paramInt) {
    FileReader fileReader1;
    FileReader fileReader2 = null;
    try {
      StringBuilder stringBuilder = new StringBuilder("/proc/");
      stringBuilder.append(paramInt);
      stringBuilder.append("/cmdline");
      fileReader1 = new FileReader(stringBuilder.toString());
    } finally {
      null = null;
    } 
    try {
      if (!x.a(null))
        null.printStackTrace(); 
      String str = String.valueOf(paramInt);
      return str;
    } finally {
      if (fileReader1 != null)
        try {
          fileReader1.close();
        } finally {} 
    } 
  }
  
  public static String a(Context paramContext) {
    if (paramContext == null)
      return null; 
    try {
      return paramContext.getPackageName();
    } finally {
      paramContext = null;
      if (!x.a((Throwable)paramContext))
        paramContext.printStackTrace(); 
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0)
      try {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        if (certificateFactory == null)
          return null; 
        X509Certificate x509Certificate = (X509Certificate)certificateFactory.generateCertificate(new ByteArrayInputStream(paramArrayOfbyte));
        if (x509Certificate == null)
          return null; 
        stringBuilder.append("Issuer|");
        Principal principal = x509Certificate.getIssuerDN();
        if (principal != null) {
          stringBuilder.append(principal.toString());
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("SerialNumber|");
        BigInteger bigInteger = x509Certificate.getSerialNumber();
        if (principal != null) {
          stringBuilder.append(bigInteger.toString(16));
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("NotBefore|");
        Date date = x509Certificate.getNotBefore();
        if (principal != null) {
          stringBuilder.append(date.toString());
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("NotAfter|");
        date = x509Certificate.getNotAfter();
        if (principal != null) {
          stringBuilder.append(date.toString());
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("SHA1|");
        String str2 = z.a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
        if (str2 != null && str2.length() > 0) {
          stringBuilder.append(str2.toString());
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("MD5|");
        String str1 = z.a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
      } catch (CertificateException certificateException) {
      
      } finally {
        paramArrayOfbyte = null;
      }  
    return (stringBuilder.length() == 0) ? "unknown" : stringBuilder.toString();
  }
  
  public static List<String> a(Map<String, String> paramMap) {
    if (paramMap == null)
      return null; 
    try {
      return null;
    } finally {
      paramMap = null;
      if (!x.a((Throwable)paramMap))
        paramMap.printStackTrace(); 
    } 
  }
  
  public static boolean a(Context paramContext, String paramString) {
    if (paramContext != null && paramString != null) {
      if (paramString.trim().length() <= 0)
        return false; 
      try {
        String[] arrayOfString = (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096)).requestedPermissions;
      } finally {
        paramContext = null;
      } 
    } 
    return false;
  }
  
  public static PackageInfo b(Context paramContext) {
    try {
      return paramContext.getPackageManager().getPackageInfo(str, 0);
    } finally {
      paramContext = null;
      if (!x.a((Throwable)paramContext))
        paramContext.printStackTrace(); 
    } 
  }
  
  public static String c(Context paramContext) {
    if (paramContext == null)
      return null; 
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
    } finally {
      paramContext = null;
    } 
    return null;
  }
  
  public static Map<String, String> d(Context paramContext) {
    Context context = null;
    if (paramContext == null)
      return null; 
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      return (Map)hashMap;
    } finally {
      paramContext = null;
      if (!x.a((Throwable)paramContext))
        paramContext.printStackTrace(); 
    } 
  }
  
  public static String e(Context paramContext) {
    String str = a(paramContext);
    if (str == null)
      return null; 
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str, 64);
      if (packageInfo == null)
        return null; 
      Signature[] arrayOfSignature = packageInfo.signatures;
      return (arrayOfSignature != null) ? ((arrayOfSignature.length == 0) ? null : a(packageInfo.signatures[0].toByteArray())) : null;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static boolean f(Context paramContext) {
    if (paramContext == null)
      return false; 
    if (a == null)
      a = (ActivityManager)paramContext.getSystemService("activity"); 
    try {
      ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
      return false;
    } finally {
      paramContext = null;
      if (!x.a((Throwable)paramContext))
        paramContext.printStackTrace(); 
    } 
  }
  
  public static String g(Context paramContext) {
    if (paramContext == null)
      return ""; 
    String str = h(paramContext);
    return !z.a(str) ? str : i(paramContext);
  }
  
  private static String h(Context paramContext) {
    String str2 = "";
    SharedPreferences sharedPreferences = z.a("DENGTA_META", paramContext);
    InputStream inputStream4 = null;
    InputStream inputStream5 = null;
    InputStream inputStream3 = null;
    InputStream inputStream2 = inputStream4;
    String str1 = str2;
    InputStream inputStream1 = inputStream5;
    try {
      String str5 = sharedPreferences.getString("key_channelpath", "");
      String str6 = str5;
      inputStream2 = inputStream4;
      str1 = str2;
      inputStream1 = inputStream5;
      if (z.a(str5))
        str6 = "channel.ini"; 
      inputStream2 = inputStream4;
      str1 = str2;
      inputStream1 = inputStream5;
      StringBuilder stringBuilder = new StringBuilder("[AppInfo] Beacon channel file path: ");
      inputStream2 = inputStream4;
      str1 = str2;
      inputStream1 = inputStream5;
      stringBuilder.append(str6);
      inputStream2 = inputStream4;
      str1 = str2;
      inputStream1 = inputStream5;
      x.a(stringBuilder.toString(), new Object[0]);
      String str4 = str2;
      inputStream2 = inputStream4;
      str1 = str2;
      inputStream1 = inputStream5;
      if (!str6.equals("")) {
        inputStream2 = inputStream4;
        str1 = str2;
        inputStream1 = inputStream5;
        InputStream inputStream = paramContext.getAssets().open(str6);
        inputStream2 = inputStream;
        str1 = str2;
        inputStream1 = inputStream;
        Properties properties = new Properties();
        inputStream2 = inputStream;
        str1 = str2;
        inputStream1 = inputStream;
        properties.load(inputStream);
        inputStream2 = inputStream;
        str1 = str2;
        inputStream1 = inputStream;
        str2 = properties.getProperty("CHANNEL", "");
        inputStream2 = inputStream;
        str1 = str2;
        inputStream1 = inputStream;
        StringBuilder stringBuilder1 = new StringBuilder("[AppInfo] Beacon channel read from assert: ");
        inputStream2 = inputStream;
        str1 = str2;
        inputStream1 = inputStream;
        stringBuilder1.append(str2);
        inputStream2 = inputStream;
        str1 = str2;
        inputStream1 = inputStream;
        x.a(stringBuilder1.toString(), new Object[0]);
        inputStream2 = inputStream;
        str1 = str2;
        inputStream1 = inputStream;
        boolean bool = z.a(str2);
        str4 = str2;
        inputStream3 = inputStream;
        if (!bool)
          return str2; 
      } 
      String str3 = str4;
    } catch (Exception exception) {
      inputStream2 = inputStream1;
      x.d("[AppInfo] Failed to get get beacon channel", new Object[0]);
      exception = iOException;
    } finally {
      if (inputStream2 != null)
        try {
          inputStream2.close();
        } catch (IOException iOException1) {
          x.a(iOException1);
        }  
    } 
    return (String)paramContext;
  }
  
  private static String i(Context paramContext) {
    try {
      Object object = (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData.get("CHANNEL_DENGTA");
    } finally {
      paramContext = null;
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */