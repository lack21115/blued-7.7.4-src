package com.alipay.security.mobile.module.b;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.alipay.security.mobile.module.a.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
  private static b a = new b();
  
  public static b a() {
    return a;
  }
  
  public static String a(Context paramContext) {
    if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      return ""; 
    String str3 = null;
    String str2 = str3;
    if (paramContext != null)
      try {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        str2 = str3;
      } finally {
        paramContext = null;
      }  
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  private static boolean a(Context paramContext, String paramString) {
    boolean bool;
    if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return !bool;
  }
  
  public static String b() {
    long l;
    try {
      StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
      l = statFs.getBlockSize();
      int i = statFs.getAvailableBlocks();
    } finally {
      Exception exception = null;
    } 
    return String.valueOf(l);
  }
  
  public static String b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'android.permission.READ_PHONE_STATE'
    //   3: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   6: ifeq -> 12
    //   9: ldc ''
    //   11: areturn
    //   12: aload_0
    //   13: ifnull -> 38
    //   16: aload_0
    //   17: ldc 'phone'
    //   19: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast android/telephony/TelephonyManager
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull -> 38
    //   30: aload_0
    //   31: invokevirtual getSubscriberId : ()Ljava/lang/String;
    //   34: astore_0
    //   35: goto -> 41
    //   38: ldc ''
    //   40: astore_0
    //   41: aload_0
    //   42: astore_1
    //   43: aload_0
    //   44: ifnonnull -> 50
    //   47: ldc ''
    //   49: astore_1
    //   50: aload_1
    //   51: areturn
    //   52: astore_0
    //   53: goto -> 38
    // Exception table:
    //   from	to	target	type
    //   16	26	52	finally
    //   30	35	52	finally
  }
  
  public static String c() {
    long l2 = 0L;
    long l1 = l2;
    try {
    
    } finally {
      Exception exception = null;
    } 
    return String.valueOf(l1);
  }
  
  public static String c(Context paramContext) {
    int i = 0;
    try {
      int j = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);
      i = j;
    } finally {}
    return (i == 1) ? "1" : "0";
  }
  
  public static String d() {
    // Byte code:
    //   0: ldc '0000000000000000'
    //   2: astore_1
    //   3: aconst_null
    //   4: astore #4
    //   6: new java/io/FileInputStream
    //   9: dup
    //   10: new java/io/File
    //   13: dup
    //   14: ldc '/proc/cpuinfo'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: invokespecial <init> : (Ljava/io/File;)V
    //   22: astore_3
    //   23: new java/io/InputStreamReader
    //   26: dup
    //   27: aload_3
    //   28: invokespecial <init> : (Ljava/io/InputStream;)V
    //   31: astore #5
    //   33: new java/io/LineNumberReader
    //   36: dup
    //   37: aload #5
    //   39: invokespecial <init> : (Ljava/io/Reader;)V
    //   42: astore #6
    //   44: iconst_1
    //   45: istore_0
    //   46: aload_1
    //   47: astore_2
    //   48: iload_0
    //   49: bipush #100
    //   51: if_icmpge -> 123
    //   54: aload #6
    //   56: invokevirtual readLine : ()Ljava/lang/String;
    //   59: astore #4
    //   61: aload_1
    //   62: astore_2
    //   63: aload #4
    //   65: ifnull -> 123
    //   68: aload #4
    //   70: ldc 'Serial'
    //   72: invokevirtual indexOf : (Ljava/lang/String;)I
    //   75: iflt -> 104
    //   78: aload #4
    //   80: aload #4
    //   82: ldc ':'
    //   84: invokevirtual indexOf : (Ljava/lang/String;)I
    //   87: iconst_1
    //   88: iadd
    //   89: aload #4
    //   91: invokevirtual length : ()I
    //   94: invokevirtual substring : (II)Ljava/lang/String;
    //   97: invokevirtual trim : ()Ljava/lang/String;
    //   100: astore_2
    //   101: goto -> 123
    //   104: iload_0
    //   105: iconst_1
    //   106: iadd
    //   107: istore_0
    //   108: goto -> 46
    //   111: aload #6
    //   113: astore #4
    //   115: aload_3
    //   116: astore_2
    //   117: aload #5
    //   119: astore_3
    //   120: goto -> 172
    //   123: aload #6
    //   125: invokevirtual close : ()V
    //   128: aload #5
    //   130: invokevirtual close : ()V
    //   133: aload_2
    //   134: astore_1
    //   135: aload_3
    //   136: invokevirtual close : ()V
    //   139: aload_1
    //   140: astore_3
    //   141: goto -> 207
    //   144: aload_1
    //   145: astore_3
    //   146: goto -> 207
    //   149: aload_3
    //   150: astore_2
    //   151: aload #5
    //   153: astore_3
    //   154: goto -> 172
    //   157: aconst_null
    //   158: astore #5
    //   160: aload_3
    //   161: astore_2
    //   162: aload #5
    //   164: astore_3
    //   165: goto -> 172
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_2
    //   171: astore_3
    //   172: aload #4
    //   174: ifnull -> 185
    //   177: aload #4
    //   179: invokevirtual close : ()V
    //   182: goto -> 185
    //   185: aload_3
    //   186: ifnull -> 196
    //   189: aload_3
    //   190: invokevirtual close : ()V
    //   193: goto -> 196
    //   196: aload_1
    //   197: astore_3
    //   198: aload_2
    //   199: ifnull -> 207
    //   202: aload_2
    //   203: astore_3
    //   204: goto -> 135
    //   207: aload_3
    //   208: astore_1
    //   209: aload_3
    //   210: ifnonnull -> 216
    //   213: ldc ''
    //   215: astore_1
    //   216: aload_1
    //   217: areturn
    //   218: astore_2
    //   219: goto -> 168
    //   222: astore_2
    //   223: goto -> 157
    //   226: astore_2
    //   227: goto -> 149
    //   230: astore_2
    //   231: goto -> 111
    //   234: astore_1
    //   235: goto -> 128
    //   238: astore_1
    //   239: aload_2
    //   240: astore_1
    //   241: goto -> 135
    //   244: astore_2
    //   245: goto -> 144
    //   248: astore #4
    //   250: goto -> 185
    //   253: astore_3
    //   254: goto -> 196
    // Exception table:
    //   from	to	target	type
    //   6	23	218	finally
    //   23	33	222	finally
    //   33	44	226	finally
    //   54	61	230	finally
    //   68	101	230	finally
    //   123	128	234	finally
    //   128	133	238	finally
    //   135	139	244	finally
    //   177	182	248	finally
    //   189	193	253	finally
  }
  
  public static String d(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      boolean bool;
      AudioManager audioManager = (AudioManager)paramContext.getSystemService("audio");
      if (audioManager.getRingerMode() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      int i = audioManager.getStreamVolume(0);
      int j = audioManager.getStreamVolume(1);
      int k = audioManager.getStreamVolume(2);
      int m = audioManager.getStreamVolume(3);
      int n = audioManager.getStreamVolume(4);
      jSONObject.put("ringermode", String.valueOf(bool));
      jSONObject.put("call", String.valueOf(i));
      jSONObject.put("system", String.valueOf(j));
      jSONObject.put("ring", String.valueOf(k));
      jSONObject.put("music", String.valueOf(m));
      jSONObject.put("alarm", String.valueOf(n));
    } finally {}
    return jSONObject.toString();
  }
  
  public static String e(Context paramContext) {
    String str2 = null;
    String str1 = str2;
    if (paramContext != null)
      try {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        str1 = str2;
      } finally {
        paramContext = null;
      }  
    if (str1 != null) {
      String str = str1;
      return "null".equals(str1) ? "" : str;
    } 
    return "";
  }
  
  public static String f() {
    String str = v();
    return !a.a(str) ? str : w();
  }
  
  public static String f(Context paramContext) {
    String str;
    Iterator<Sensor> iterator3 = null;
    Iterator<Sensor> iterator2 = iterator3;
    if (paramContext != null)
      try {
        SensorManager sensorManager = (SensorManager)paramContext.getSystemService("sensor");
        iterator2 = iterator3;
      } finally {
        paramContext = null;
      }  
    Iterator<Sensor> iterator1 = iterator2;
    if (iterator2 == null)
      str = ""; 
    return str;
  }
  
  public static String g() {
    String[] arrayOfString1;
    FileReader fileReader;
    String[] arrayOfString2 = null;
    try {
    
    } finally {
      Exception exception = null;
      fileReader = null;
    } 
    if (fileReader != null)
      try {
        fileReader.close();
      } finally {} 
    if (arrayOfString1 != null)
      arrayOfString1.close(); 
    return "";
  }
  
  public static String g(Context paramContext) {
    JSONArray jSONArray = new JSONArray();
    if (paramContext != null)
      try {
        SensorManager sensorManager = (SensorManager)paramContext.getSystemService("sensor");
        if (sensorManager != null) {
          List list = sensorManager.getSensorList(-1);
          if (list != null && list.size() > 0)
            for (Sensor sensor : list) {
              if (sensor != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", sensor.getName());
                jSONObject.put("version", sensor.getVersion());
                jSONObject.put("vendor", sensor.getVendor());
                jSONArray.put(jSONObject);
              } 
            }  
        } 
      } finally {} 
    return jSONArray.toString();
  }
  
  public static String h() {
    BufferedReader bufferedReader;
    Exception exception;
    String str = null;
    long l2 = 0L;
    try {
      FileReader fileReader = new FileReader("/proc/meminfo");
    } finally {
      exception = null;
    } 
    if (exception != null)
      try {
        exception.close();
      } finally {} 
    long l1 = l2;
    if (bufferedReader != null) {
      long l = l2;
      bufferedReader.close();
      l1 = l2;
    } 
    return String.valueOf(l1);
  }
  
  public static String h(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Integer.toString(displayMetrics.widthPixels));
      stringBuilder.append("*");
      return stringBuilder.toString();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String i() {
    long l;
    try {
      StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
      l = statFs.getBlockSize();
      int i = statFs.getBlockCount();
    } finally {
      Exception exception = null;
    } 
    return String.valueOf(l);
  }
  
  public static String i(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String j() {
    long l2 = 0L;
    long l1 = l2;
    try {
    
    } finally {
      Exception exception = null;
    } 
    return String.valueOf(l1);
  }
  
  public static String j(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String k() {
    String str;
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      Object object = clazz.newInstance();
      str = (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(object, new Object[] { "gsm.version.baseband", "no message" });
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String k(Context paramContext) {
    boolean bool = a(paramContext, "android.permission.ACCESS_WIFI_STATE");
    String str = "";
    if (bool)
      return ""; 
    try {
      null = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if (null != null) {
        str = null;
        if (null.length() != 0) {
          str = null;
          if (!"02:00:00:00:00:00".equals(null))
            return null; 
        } 
      } 
      return u();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String l() {
    String str;
    try {
      str = Locale.getDefault().toString();
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String l(Context paramContext) {
    if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      return ""; 
    try {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
      if (str != null) {
        String str1 = str;
        if (str != null)
          try {
            int i = str.length();
            return (i == 0) ? "" : str1;
          } finally {
            str1 = null;
          }  
        return str1;
      } 
    } finally {}
    return "";
  }
  
  public static String m() {
    String str;
    try {
      str = TimeZone.getDefault().getDisplayName(false, 0);
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String m(Context paramContext) {
    String str1;
    String str2;
    try {
      str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } finally {
      paramContext = null;
    } 
    if (str1 == null)
      str2 = ""; 
    return str2;
  }
  
  public static String n() {
    try {
      long l = System.currentTimeMillis() - SystemClock.elapsedRealtime();
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String n(Context paramContext) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager != null) {
        int i = telephonyManager.getNetworkType();
        return String.valueOf(i);
      } 
    } finally {}
    return "";
  }
  
  public static String o() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String o(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'android.permission.ACCESS_WIFI_STATE'
    //   4: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifeq -> 13
    //   10: ldc ''
    //   12: areturn
    //   13: aload_0
    //   14: ldc_w 'wifi'
    //   17: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast android/net/wifi/WifiManager
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual isWifiEnabled : ()Z
    //   28: ifeq -> 42
    //   31: aload_0
    //   32: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   35: invokevirtual getBSSID : ()Ljava/lang/String;
    //   38: astore_0
    //   39: goto -> 45
    //   42: ldc ''
    //   44: astore_0
    //   45: aload_0
    //   46: astore_1
    //   47: aload_0
    //   48: ifnonnull -> 54
    //   51: ldc ''
    //   53: astore_1
    //   54: aload_1
    //   55: areturn
    //   56: astore_0
    //   57: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   13	39	56	finally
  }
  
  public static String p() {
    try {
      int i;
      StringBuilder stringBuilder2 = new StringBuilder();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("00");
      stringBuilder1.append(":");
      stringBuilder2.append(stringBuilder1.toString());
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String p(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   4: getfield targetSdkVersion : I
    //   7: istore_1
    //   8: getstatic android/os/Build$VERSION.SDK_INT : I
    //   11: bipush #29
    //   13: if_icmplt -> 19
    //   16: goto -> 47
    //   19: getstatic android/os/Build$VERSION.SDK_INT : I
    //   22: bipush #26
    //   24: if_icmplt -> 40
    //   27: iload_1
    //   28: bipush #28
    //   30: if_icmplt -> 40
    //   33: invokestatic getSerial : ()Ljava/lang/String;
    //   36: astore_0
    //   37: goto -> 50
    //   40: getstatic android/os/Build.SERIAL : Ljava/lang/String;
    //   43: astore_0
    //   44: goto -> 50
    //   47: ldc ''
    //   49: astore_0
    //   50: aload_0
    //   51: astore_2
    //   52: aload_0
    //   53: ifnonnull -> 59
    //   56: ldc ''
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_0
    //   62: goto -> 47
    // Exception table:
    //   from	to	target	type
    //   8	16	61	finally
    //   19	27	61	finally
    //   33	37	61	finally
    //   40	44	61	finally
  }
  
  public static String q() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("00");
    stringBuilder.append(":");
    int i = 0;
    while (true) {
      if (i) {
        (new String[1])[0] = "dalvik.system.Taint";
        String str = (new String[1])[0];
        try {
          Class.forName(str);
          stringBuilder.append("1");
        } finally {
          str = null;
        } 
        continue;
      } 
      return stringBuilder.toString();
    } 
  }
  
  public static String q(Context paramContext) {
    String str = "";
    try {
      String str2 = t(paramContext);
      String str3 = x();
      String str1 = str;
      return str1;
    } finally {
      paramContext = null;
    } 
  }
  
  public static String r() {
    StringBuilder stringBuilder2 = new StringBuilder();
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
    linkedHashMap.put("/proc/tty/drivers", "goldfish");
    linkedHashMap.put("/proc/cpuinfo", "goldfish");
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("00");
    stringBuilder1.append(":");
    stringBuilder2.append(stringBuilder1.toString());
    Iterator<String> iterator = linkedHashMap.keySet().iterator();
    while (true) {
      if (iterator.hasNext()) {
        String str1;
        String str3 = iterator.next();
        String str2 = null;
        byte b1 = 48;
        try {
          LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str3)));
        } finally {
          stringBuilder1 = null;
        } 
        stringBuilder2.append('0');
        if (str1 != null)
          str1.close(); 
        continue;
      } 
      return stringBuilder2.toString();
    } 
  }
  
  public static String r(Context paramContext) {
    try {
      boolean bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).isKeyguardSecure();
      long l = 0L;
      if (!bool)
        return "0:0"; 
      int i = 0;
      while (true) {
        if (i < 5) {
          (new String[5])[0] = "/data/system/password.key";
          (new String[5])[1] = "/data/system/gesture.key";
          (new String[5])[2] = "/data/system/gatekeeper.password.key";
          (new String[5])[3] = "/data/system/gatekeeper.gesture.key";
          (new String[5])[4] = "/data/system/gatekeeper.pattern.key";
          String str = (new String[5])[i];
          long l1 = -1L;
          try {
            long l2 = (new File(str)).lastModified();
            l1 = l2;
          } finally {}
          l = Math.max(l1, l);
          i++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder("1:");
        return stringBuilder.toString();
      } 
    } finally {
      paramContext = null;
    } 
  }
  
  public static String s() {
    StringBuilder stringBuilder2 = new StringBuilder();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("00");
    stringBuilder1.append(":");
    stringBuilder2.append(stringBuilder1.toString());
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    linkedHashMap.put("BRAND", "generic");
    linkedHashMap.put("BOARD", "unknown");
    linkedHashMap.put("DEVICE", "generic");
    linkedHashMap.put("HARDWARE", "goldfish");
    linkedHashMap.put("PRODUCT", "sdk");
    linkedHashMap.put("MODEL", "sdk");
    Iterator<String> iterator = linkedHashMap.keySet().iterator();
    while (true) {
      if (iterator.hasNext()) {
        byte b1;
        String str = iterator.next();
        byte b2 = 48;
        try {
          String str1;
          Field field = Build.class.getField(str);
          stringBuilder1 = null;
          String str2 = (String)field.get(null);
          str = (String)linkedHashMap.get(str);
          if (str2 != null)
            str1 = str2.toLowerCase(); 
          b1 = b2;
        } finally {
          stringBuilder1 = null;
        } 
        stringBuilder2.append(b1);
        continue;
      } 
      return stringBuilder2.toString();
    } 
  }
  
  public static String s(Context paramContext) {
    int i;
    StringBuilder stringBuilder;
    try {
      Intent intent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      i = intent.getIntExtra("level", -1);
      int j = intent.getIntExtra("status", -1);
      if (j == 2 || j == 5) {
        j = 1;
      } else {
        j = 0;
      } 
      stringBuilder = new StringBuilder();
    } finally {
      paramContext = null;
    } 
    null = "0";
    stringBuilder.append(null);
    stringBuilder.append(":");
    stringBuilder.append(i);
    return stringBuilder.toString();
  }
  
  public static String t() {
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("00");
    stringBuilder2.append(":");
    stringBuilder1.append(stringBuilder2.toString());
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    linkedHashMap.put("ro.hardware", "goldfish");
    linkedHashMap.put("ro.kernel.qemu", "1");
    linkedHashMap.put("ro.product.device", "generic");
    linkedHashMap.put("ro.product.model", "sdk");
    linkedHashMap.put("ro.product.brand", "generic");
    linkedHashMap.put("ro.product.name", "sdk");
    linkedHashMap.put("ro.build.fingerprint", "test-keys");
    linkedHashMap.put("ro.product.manufacturer", "unknow");
    for (String str2 : linkedHashMap.keySet()) {
      byte b2 = 48;
      String str1 = (String)linkedHashMap.get(str2);
      str2 = a.b(str2, "");
      byte b1 = b2;
      if (str2 != null) {
        b1 = b2;
        if (str2.contains(str1))
          b1 = 49; 
      } 
      stringBuilder1.append(b1);
    } 
    return stringBuilder1.toString();
  }
  
  private static String t(Context paramContext) {
    int i;
    if (a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      return ""; 
    Context context = null;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo == null)
        return null; 
      if (networkInfo.getType() == 1)
        return "WIFI"; 
      paramContext = context;
    } finally {
      paramContext = null;
    } 
    return (i == 3 || i == 5 || i == 6 || i == 8 || i == 9 || i == 10 || i == 12 || i == 14 || i == 15) ? "3G" : ((i == 13) ? "4G" : "UNKNOW");
  }
  
  private static String u() {
    String str = "02:00:00:00:00:00";
    try {
      ArrayList<NetworkInterface> arrayList = Collections.list(NetworkInterface.getNetworkInterfaces());
      String str1 = str;
      return str1;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static String v() {
    Exception exception;
    BufferedReader bufferedReader;
    String str = null;
    try {
      FileReader fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
    } finally {
      exception = null;
    } 
    if (bufferedReader != null)
      try {
        bufferedReader.close();
      } finally {} 
    if (exception != null) {
      try {
        exception.close();
      } finally {}
      return "";
    } 
    return "";
  }
  
  private static String w() {
    BufferedReader bufferedReader;
    Exception exception;
    String str2 = "";
    String str1 = null;
    try {
      FileReader fileReader = new FileReader("/proc/cpuinfo");
    } finally {
      exception = null;
    } 
    if (exception != null)
      try {
        exception.close();
      } finally {} 
    if (bufferedReader != null)
      bufferedReader.close(); 
    return "";
  }
  
  private static String x() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address)
            return inetAddress.getHostAddress().toString(); 
        } 
      } 
    } finally {
      Exception exception;
    } 
    return "";
  }
  
  public final String e() {
    try {
      return String.valueOf(i);
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */