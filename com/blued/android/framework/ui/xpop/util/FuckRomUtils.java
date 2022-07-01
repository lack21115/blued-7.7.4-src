package com.blued.android.framework.ui.xpop.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public final class FuckRomUtils {
  private static final String[] a = new String[] { "huawei" };
  
  private static final String[] b = new String[] { "vivo" };
  
  private static final String[] c = new String[] { "xiaomi" };
  
  private static final String[] d = new String[] { "oppo" };
  
  private static final String[] e = new String[] { "leeco", "letv" };
  
  private static final String[] f = new String[] { "360", "qiku" };
  
  private static final String[] g = new String[] { "zte" };
  
  private static final String[] h = new String[] { "oneplus" };
  
  private static final String[] i = new String[] { "nubia" };
  
  private static final String[] j = new String[] { "coolpad", "yulong" };
  
  private static final String[] k = new String[] { "lg", "lge" };
  
  private static final String[] l = new String[] { "google" };
  
  private static final String[] m = new String[] { "samsung" };
  
  private static final String[] n = new String[] { "meizu" };
  
  private static final String[] o = new String[] { "lenovo" };
  
  private static final String[] p = new String[] { "smartisan" };
  
  private static final String[] q = new String[] { "htc" };
  
  private static final String[] r = new String[] { "sony" };
  
  private static final String[] s = new String[] { "gionee", "amigo" };
  
  private static final String[] t = new String[] { "motorola" };
  
  private static RomInfo u = null;
  
  private FuckRomUtils() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }
  
  private static String a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 15
    //   7: aload_0
    //   8: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: goto -> 18
    //   15: ldc ''
    //   17: astore_0
    //   18: aload_0
    //   19: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   22: ifne -> 36
    //   25: aload_0
    //   26: astore_1
    //   27: aload_0
    //   28: ldc 'unknown'
    //   30: invokevirtual equals : (Ljava/lang/Object;)Z
    //   33: ifeq -> 57
    //   36: getstatic android/os/Build.DISPLAY : Ljava/lang/String;
    //   39: astore_2
    //   40: aload_0
    //   41: astore_1
    //   42: aload_2
    //   43: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   46: ifne -> 57
    //   49: aload_2
    //   50: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   53: astore_1
    //   54: goto -> 57
    //   57: aload_1
    //   58: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   61: ifeq -> 67
    //   64: ldc 'unknown'
    //   66: areturn
    //   67: aload_1
    //   68: areturn
    //   69: astore_1
    //   70: aload_0
    //   71: astore_1
    //   72: goto -> 57
    // Exception table:
    //   from	to	target	type
    //   36	40	69	finally
    //   42	54	69	finally
  }
  
  public static boolean a() {
    return b[0].equals(RomInfo.a(b()));
  }
  
  private static boolean a(String paramString1, String paramString2, String... paramVarArgs) {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = paramVarArgs[i];
      if (paramString1.contains(str) || paramString2.contains(str))
        return true; 
    } 
    return false;
  }
  
  public static RomInfo b() {
    String[] arrayOfString;
    RomInfo romInfo = u;
    if (romInfo != null)
      return romInfo; 
    u = new RomInfo();
    String str1 = d();
    String str2 = c();
    if (a(str1, str2, a)) {
      RomInfo.a(u, a[0]);
      str1 = a("ro.build.version.emui");
      arrayOfString = str1.split("_");
      if (arrayOfString.length > 1) {
        RomInfo.b(u, arrayOfString[1]);
      } else {
        RomInfo.b(u, str1);
      } 
      return u;
    } 
    if (a(str1, (String)arrayOfString, b)) {
      RomInfo.a(u, b[0]);
      RomInfo.b(u, a("ro.vivo.os.build.display.id"));
      return u;
    } 
    if (a(str1, (String)arrayOfString, c)) {
      RomInfo.a(u, c[0]);
      RomInfo.b(u, a("ro.build.version.incremental"));
      return u;
    } 
    if (a(str1, (String)arrayOfString, d)) {
      RomInfo.a(u, d[0]);
      RomInfo.b(u, a("ro.build.version.opporom"));
      return u;
    } 
    if (a(str1, (String)arrayOfString, e)) {
      RomInfo.a(u, e[0]);
      RomInfo.b(u, a("ro.letv.release.version"));
      return u;
    } 
    if (a(str1, (String)arrayOfString, f)) {
      RomInfo.a(u, f[0]);
      RomInfo.b(u, a("ro.build.uiversion"));
      return u;
    } 
    if (a(str1, (String)arrayOfString, g)) {
      RomInfo.a(u, g[0]);
      RomInfo.b(u, a("ro.build.MiFavor_version"));
      return u;
    } 
    if (a(str1, (String)arrayOfString, h)) {
      RomInfo.a(u, h[0]);
      RomInfo.b(u, a("ro.rom.version"));
      return u;
    } 
    if (a(str1, (String)arrayOfString, i)) {
      RomInfo.a(u, i[0]);
      RomInfo.b(u, a("ro.build.rom.id"));
      return u;
    } 
    if (a(str1, (String)arrayOfString, j)) {
      RomInfo.a(u, j[0]);
    } else if (a(str1, (String)arrayOfString, k)) {
      RomInfo.a(u, k[0]);
    } else if (a(str1, (String)arrayOfString, l)) {
      RomInfo.a(u, l[0]);
    } else if (a(str1, (String)arrayOfString, m)) {
      RomInfo.a(u, m[0]);
    } else if (a(str1, (String)arrayOfString, n)) {
      RomInfo.a(u, n[0]);
    } else if (a(str1, (String)arrayOfString, o)) {
      RomInfo.a(u, o[0]);
    } else if (a(str1, (String)arrayOfString, p)) {
      RomInfo.a(u, p[0]);
    } else if (a(str1, (String)arrayOfString, q)) {
      RomInfo.a(u, q[0]);
    } else if (a(str1, (String)arrayOfString, r)) {
      RomInfo.a(u, r[0]);
    } else if (a(str1, (String)arrayOfString, s)) {
      RomInfo.a(u, s[0]);
    } else if (a(str1, (String)arrayOfString, t)) {
      RomInfo.a(u, t[0]);
    } else {
      RomInfo.a(u, (String)arrayOfString);
    } 
    RomInfo.b(u, a(""));
    return u;
  }
  
  private static String b(String paramString) {
    String str = c(paramString);
    if (!TextUtils.isEmpty(str))
      return str; 
    str = d(paramString);
    return !TextUtils.isEmpty(str) ? str : ((Build.VERSION.SDK_INT < 28) ? e(paramString) : str);
  }
  
  private static String c() {
    try {
      String str = Build.MANUFACTURER;
      if (!TextUtils.isEmpty(str))
        return str.toLowerCase(); 
    } finally {
      Exception exception;
    } 
    return "unknown";
  }
  
  private static String c(String paramString) {
    Exception exception = null;
    String str = null;
    try {
      Runtime runtime = Runtime.getRuntime();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getprop ");
      stringBuilder.append(paramString);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec(stringBuilder.toString()).getInputStream()), 1024);
    } catch (IOException iOException1) {
    
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {} 
    } 
    if (paramString != null)
      paramString.close(); 
    return "";
  }
  
  private static String d() {
    try {
      String str = Build.BRAND;
      if (!TextUtils.isEmpty(str))
        return str.toLowerCase(); 
    } finally {
      Exception exception;
    } 
    return "unknown";
  }
  
  private static String d(String paramString) {
    try {
      Properties properties = new Properties();
      properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
      return properties.getProperty(paramString, "");
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String e(String paramString) {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { paramString, "" });
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static class RomInfo {
    private String a;
    
    private String b;
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RomInfo{name=");
      stringBuilder.append(this.a);
      stringBuilder.append(", version=");
      stringBuilder.append(this.b);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpo\\util\FuckRomUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */