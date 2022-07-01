package com.amap.api.mapcore2d;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class cu {
  static String a = "";
  
  static String b = "";
  
  public static boolean c = false;
  
  static String d = "";
  
  static boolean e = false;
  
  static int f = -1;
  
  static String g = "";
  
  static String h = "";
  
  private static String i;
  
  private static boolean j = false;
  
  private static String k = "";
  
  private static String l = "";
  
  private static String m = "";
  
  private static String n = "";
  
  private static String o = "";
  
  private static String p = "";
  
  private static boolean q = false;
  
  private static long r = 0L;
  
  private static int s = 0;
  
  private static String t;
  
  private static String u = "";
  
  private static String A(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #6
    //   6: aload #6
    //   8: astore #4
    //   10: aload_0
    //   11: ldc 'android.permission.READ_EXTERNAL_STORAGE'
    //   13: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   16: ifeq -> 224
    //   19: aload #6
    //   21: astore #4
    //   23: ldc 'mounted'
    //   25: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   28: invokevirtual equals : (Ljava/lang/Object;)Z
    //   31: ifeq -> 224
    //   34: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   37: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   40: astore_0
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore #4
    //   50: aload #4
    //   52: aload_0
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload #4
    //   59: ldc '/.UTSystemConfig/Global/Alvin2.xml'
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: new java/io/File
    //   68: dup
    //   69: aload #4
    //   71: invokevirtual toString : ()Ljava/lang/String;
    //   74: invokespecial <init> : (Ljava/lang/String;)V
    //   77: astore_0
    //   78: invokestatic newPullParser : ()Lorg/xmlpull/v1/XmlPullParser;
    //   81: astore #4
    //   83: aload #4
    //   85: invokeinterface getEventType : ()I
    //   90: istore_3
    //   91: new java/io/FileInputStream
    //   94: dup
    //   95: aload_0
    //   96: invokespecial <init> : (Ljava/io/File;)V
    //   99: astore_0
    //   100: aload #4
    //   102: aload_0
    //   103: ldc 'utf-8'
    //   105: invokeinterface setInput : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   110: iconst_0
    //   111: istore_1
    //   112: goto -> 269
    //   115: iload_1
    //   116: istore_2
    //   117: iload_1
    //   118: ifeq -> 202
    //   121: aload #4
    //   123: invokeinterface getText : ()Ljava/lang/String;
    //   128: astore #4
    //   130: aload_0
    //   131: invokevirtual close : ()V
    //   134: aload #4
    //   136: areturn
    //   137: iconst_0
    //   138: istore_2
    //   139: goto -> 202
    //   142: iload_1
    //   143: istore_2
    //   144: aload #4
    //   146: invokeinterface getAttributeCount : ()I
    //   151: ifle -> 202
    //   154: aload #4
    //   156: invokeinterface getAttributeCount : ()I
    //   161: istore_3
    //   162: iconst_0
    //   163: istore_2
    //   164: iload_2
    //   165: iload_3
    //   166: if_icmpge -> 309
    //   169: aload #4
    //   171: iload_2
    //   172: invokeinterface getAttributeValue : (I)Ljava/lang/String;
    //   177: astore #5
    //   179: ldc 'UTDID2'
    //   181: aload #5
    //   183: invokevirtual equals : (Ljava/lang/Object;)Z
    //   186: ifne -> 300
    //   189: ldc 'UTDID'
    //   191: aload #5
    //   193: invokevirtual equals : (Ljava/lang/Object;)Z
    //   196: ifeq -> 302
    //   199: goto -> 300
    //   202: aload #4
    //   204: invokeinterface next : ()I
    //   209: istore_3
    //   210: iload_2
    //   211: istore_1
    //   212: goto -> 269
    //   215: aload_0
    //   216: astore #4
    //   218: goto -> 224
    //   221: goto -> 239
    //   224: aload #4
    //   226: ifnull -> 246
    //   229: aload #4
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual close : ()V
    //   236: goto -> 246
    //   239: aload_0
    //   240: ifnull -> 246
    //   243: goto -> 232
    //   246: ldc ''
    //   248: areturn
    //   249: astore_0
    //   250: aload #5
    //   252: astore_0
    //   253: goto -> 239
    //   256: astore #4
    //   258: goto -> 221
    //   261: astore_0
    //   262: aload #4
    //   264: areturn
    //   265: astore_0
    //   266: goto -> 246
    //   269: iconst_1
    //   270: iload_3
    //   271: if_icmpeq -> 215
    //   274: iload_1
    //   275: istore_2
    //   276: iload_3
    //   277: ifeq -> 202
    //   280: iload_3
    //   281: iconst_2
    //   282: if_icmpeq -> 142
    //   285: iload_3
    //   286: iconst_3
    //   287: if_icmpeq -> 137
    //   290: iload_3
    //   291: iconst_4
    //   292: if_icmpeq -> 115
    //   295: iload_1
    //   296: istore_2
    //   297: goto -> 202
    //   300: iconst_1
    //   301: istore_1
    //   302: iload_2
    //   303: iconst_1
    //   304: iadd
    //   305: istore_2
    //   306: goto -> 164
    //   309: iload_1
    //   310: istore_2
    //   311: goto -> 202
    // Exception table:
    //   from	to	target	type
    //   10	19	249	finally
    //   23	100	249	finally
    //   100	110	256	finally
    //   121	130	256	finally
    //   130	134	261	finally
    //   144	162	256	finally
    //   169	189	256	finally
    //   189	199	256	finally
    //   202	210	256	finally
    //   232	236	265	finally
  }
  
  private static String B(Context paramContext) throws InvocationTargetException, IllegalAccessException {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    String str = u;
    if (str != null && !"".equals(str))
      return u; 
    if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return u; 
    TelephonyManager telephonyManager = H(paramContext);
    if (telephonyManager == null)
      return ""; 
    Method method = db.a(telephonyManager.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
    if (method != null)
      u = (String)method.invoke(telephonyManager, new Object[0]); 
    if (u == null)
      u = ""; 
    return u;
  }
  
  private static String C(Context paramContext) {
    if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return null; 
    TelephonyManager telephonyManager = H(paramContext);
    if (telephonyManager == null)
      return ""; 
    String str2 = telephonyManager.getSimOperatorName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = telephonyManager.getNetworkOperatorName(); 
    return str1;
  }
  
  private static int D(Context paramContext) {
    if (paramContext != null) {
      if (!a(paramContext, db.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")))
        return -1; 
      ConnectivityManager connectivityManager = E(paramContext);
      if (connectivityManager == null)
        return -1; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      return (networkInfo == null) ? -1 : networkInfo.getType();
    } 
    return -1;
  }
  
  private static ConnectivityManager E(Context paramContext) {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  private static String F(Context paramContext) {
    String str = x(paramContext);
    return (str == null || str.length() < 5) ? "" : str.substring(3, 5);
  }
  
  private static int G(Context paramContext) {
    if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return -1; 
    TelephonyManager telephonyManager = H(paramContext);
    return (telephonyManager == null) ? -1 : telephonyManager.getNetworkType();
  }
  
  private static TelephonyManager H(Context paramContext) {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
  
  public static String a() {
    return i;
  }
  
  public static String a(Context paramContext) {
    try {
      if (!TextUtils.isEmpty(d))
        return d; 
      da da = dj.a();
      if (ef.a(paramContext, da)) {
        Class clazz = ef.a(paramContext, da, db.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
        if (clazz != null)
          d = (String)clazz.getMethod("getAdiuExtras", new Class[0]).invoke(clazz, new Object[0]); 
        return d;
      } 
    } finally {}
    return "";
  }
  
  public static String a(Context paramContext, String paramString, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    try {
      if (Build.VERSION.SDK_INT < 21)
        return ""; 
      if (!TextUtils.isEmpty(g))
        return g; 
      if (!paramBoolean && f >= 0 && f < 2)
        return ""; 
      TelephonyManager telephonyManager = H(paramContext);
      if (f == -1) {
        Method method1 = db.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
        if (method1 != null) {
          try {
            f = ((Integer)method1.invoke(telephonyManager, new Object[0])).intValue();
          } finally {
            method1 = null;
          } 
        } else {
          f = 0;
        } 
      } 
      if (!paramBoolean && f <= 1)
        return ""; 
      Method method = db.a(TelephonyManager.class, "MZ2V0SW1laQ=", new Class[] { int.class });
      if (method == null)
        return ""; 
      StringBuilder stringBuilder = new StringBuilder();
      int i = 0;
      try {
        while (i < f) {
          stringBuilder.append((String)method.invoke(telephonyManager, new Object[] { Integer.valueOf(i) }));
          stringBuilder.append(paramString);
          i++;
        } 
      } finally {}
      null = stringBuilder.toString();
      if (null.length() == 0)
        return ""; 
      return g;
    } finally {
      paramContext = null;
    } 
  }
  
  private static List<ScanResult> a(List<ScanResult> paramList) {
    int j = paramList.size();
    for (int i = 0; i < j - 1; i++) {
      for (int k = 1; k < j - i; k++) {
        int m = k - 1;
        if (((ScanResult)paramList.get(m)).level > ((ScanResult)paramList.get(k)).level) {
          ScanResult scanResult = paramList.get(m);
          paramList.set(m, paramList.get(k));
          paramList.set(k, scanResult);
        } 
      } 
    } 
    return paramList;
  }
  
  private static boolean a(Context paramContext, String paramString) {
    return (paramContext != null && paramContext.checkCallingOrSelfPermission(paramString) == 0);
  }
  
  public static String b(Context paramContext) {
    try {
      if (!TextUtils.isEmpty(b))
        return b; 
      da da = dj.a();
      if (da == null)
        return null; 
      if (ef.a(paramContext, da)) {
        Class clazz = ef.a(paramContext, da, db.c("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
        if (clazz == null)
          return b; 
        String str = (String)clazz.getMethod("getADIU", new Class[] { Context.class }).invoke(clazz, new Object[] { paramContext });
        if (!TextUtils.isEmpty(str)) {
          b = str;
          return str;
        } 
        if (!j) {
          j = true;
          do.d().submit(new Runnable(clazz, paramContext) {
                public void run() {
                  try {
                    Map<String, String> map = (Map)this.a.getMethod("getGetParams", new Class[0]).invoke(this.a, new Object[0]);
                    if (map == null)
                      return; 
                    String str = (String)this.a.getMethod("getPostParam", new Class[] { String.class, String.class, String.class, String.class }).invoke(this.a, new Object[] { cu.h(this.b), cu.v(this.b), cu.m(this.b), cu.x(this.b) });
                    if (TextUtils.isEmpty(str))
                      return; 
                    byte[] arrayOfByte = er.a().a(new eq(str.getBytes(), map));
                    return;
                  } finally {
                    Exception exception = null;
                  } 
                }
              });
        } 
      } 
    } finally {}
    return "";
  }
  
  public static void b() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static long c() {
    long l = r;
    if (l != 0L)
      return l; 
    try {
      long l1;
      StatFs statFs1 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
      StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      if (Build.VERSION.SDK_INT >= 18) {
        l = statFs1.getBlockCountLong() * statFs1.getBlockSizeLong() / 1048576L;
        l1 = statFs2.getBlockCountLong() * statFs2.getBlockSizeLong() / 1048576L;
      } else {
        l = statFs1.getBlockCount() * statFs1.getBlockSize() / 1048576L;
        l1 = statFs2.getBlockCount() * statFs2.getBlockSize() / 1048576L;
      } 
      r = l + l1;
    } finally {
      Exception exception;
    } 
    return r;
  }
  
  public static String c(Context paramContext) {
    try {
      return C(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static String d() {
    if (!TextUtils.isEmpty(t))
      return t; 
    t = System.getProperty("os.arch");
    return t;
  }
  
  public static String d(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    try {
      return F(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static int e(Context paramContext) {
    try {
      return G(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  private static String e() {
    String str = "";
    try {
      String str1;
      Iterator<NetworkInterface> iterator = Collections.<NetworkInterface>list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (true) {
        str1 = str;
        if (iterator.hasNext()) {
          byte[] arrayOfByte;
          NetworkInterface networkInterface = iterator.next();
          if (!networkInterface.getName().equalsIgnoreCase("wlan0"))
            continue; 
          str1 = null;
          if (Build.VERSION.SDK_INT >= 9)
            arrayOfByte = networkInterface.getHardwareAddress(); 
          if (arrayOfByte == null)
            return ""; 
          StringBuilder stringBuilder = new StringBuilder();
          int j = arrayOfByte.length;
          for (int i = 0; i < j; i++) {
            String str2 = Integer.toHexString(arrayOfByte[i] & 0xFF).toUpperCase();
            if (str2.length() == 1)
              stringBuilder.append("0"); 
            stringBuilder.append(str2);
            stringBuilder.append(":");
          } 
          if (stringBuilder.length() > 0)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
          str1 = stringBuilder.toString();
        } 
        break;
      } 
      return str1;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static int f(Context paramContext) {
    try {
      return D(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static String g(Context paramContext) {
    try {
      return B(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static String h(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    try {
      if (a != null && !"".equals(a))
        return a; 
      if (a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")))
        a = Settings.System.getString(paramContext.getContentResolver(), "mqBRboGZkQPcAkyk"); 
      if (a != null && !"".equals(a))
        return a; 
    } finally {
      Exception exception;
    } 
    try {
      a = A(paramContext);
    } finally {}
    String str2 = a;
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public static String i(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    if (!TextUtils.isEmpty(l))
      return l; 
    if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return ""; 
    try {
      if (Build.VERSION.SDK_INT >= 26)
        return (String)db.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]); 
      if (Build.VERSION.SDK_INT >= 9)
        l = Build.SERIAL; 
    } finally {}
    String str2 = l;
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public static String j(Context paramContext) {
    if (!TextUtils.isEmpty(k))
      return k; 
    try {
      return (k == null) ? "" : k;
    } finally {
      paramContext = null;
    } 
  }
  
  static String k(Context paramContext) {
    String str2 = "";
    String str1 = str2;
    if (paramContext != null)
      try {
        if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
          return ""; 
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager == null)
          return ""; 
        str1 = str2;
        return str1;
      } finally {
        paramContext = null;
      }  
    return str1;
  }
  
  static String l(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramContext != null) {
      try {
        if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
          return stringBuilder.toString(); 
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager == null)
          return ""; 
        if (wifiManager.isWifiEnabled()) {
          List<ScanResult> list = wifiManager.getScanResults();
          if (list == null || list.size() == 0)
            return stringBuilder.toString(); 
          list = a(list);
          int i = 0;
          boolean bool = true;
          while (i < list.size() && i < 7) {
            ScanResult scanResult = list.get(i);
            if (bool) {
              bool = false;
            } else {
              stringBuilder.append(";");
            } 
            stringBuilder.append(scanResult.BSSID);
            i++;
          } 
        } 
      } finally {}
    } else {
      return stringBuilder.toString();
    } 
    return stringBuilder.toString();
  }
  
  public static String m(Context paramContext) {
    try {
      String str = m;
      if (str != null && !"".equals(m))
        return m; 
      if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
        return m; 
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager == null)
        return ""; 
      m = wifiManager.getConnectionInfo().getMacAddress();
      if (db.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(m) || db.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(m))
        m = e(); 
    } finally {}
    return m;
  }
  
  static String[] n(Context paramContext) {
    try {
      StringBuilder stringBuilder;
      if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) || !a(paramContext, db.c("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=")))
        return new String[] { "", "" }; 
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager == null)
        return new String[] { "", "" }; 
      CellLocation cellLocation = telephonyManager.getCellLocation();
      boolean bool = cellLocation instanceof GsmCellLocation;
      if (bool) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation)cellLocation;
        int i = gsmCellLocation.getCid();
        int j = gsmCellLocation.getLac();
        stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("||");
        stringBuilder.append(i);
        return new String[] { stringBuilder.toString(), "gsm" };
      } 
      if (stringBuilder instanceof CdmaCellLocation) {
        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation)stringBuilder;
        int i = cdmaCellLocation.getSystemId();
        int j = cdmaCellLocation.getNetworkId();
        int k = cdmaCellLocation.getBaseStationId();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i);
        stringBuilder1.append("||");
        stringBuilder1.append(j);
        stringBuilder1.append("||");
        stringBuilder1.append(k);
        return new String[] { stringBuilder1.toString(), "cdma" };
      } 
    } finally {}
    return new String[] { "", "" };
  }
  
  static String o(Context paramContext) {
    String str = "";
    try {
      TelephonyManager telephonyManager = H(paramContext);
      if (telephonyManager == null)
        return ""; 
      String str2 = telephonyManager.getNetworkOperator();
      String str1 = str;
      return str1;
    } finally {
      paramContext = null;
    } 
  }
  
  static String p(Context paramContext) {
    String str = "";
    try {
      TelephonyManager telephonyManager = H(paramContext);
      if (telephonyManager == null)
        return ""; 
      String str2 = telephonyManager.getNetworkOperator();
      String str1 = str;
      return str1;
    } finally {
      paramContext = null;
    } 
  }
  
  public static int q(Context paramContext) {
    try {
      return G(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  public static int r(Context paramContext) {
    try {
      return D(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  public static NetworkInfo s(Context paramContext) {
    if (!a(paramContext, db.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")))
      return null; 
    ConnectivityManager connectivityManager = E(paramContext);
    return (connectivityManager == null) ? null : connectivityManager.getActiveNetworkInfo();
  }
  
  static String t(Context paramContext) {
    try {
      return (networkInfo == null) ? null : networkInfo.getExtraInfo();
    } finally {
      paramContext = null;
    } 
  }
  
  static String u(Context paramContext) {
    try {
      StringBuilder stringBuilder;
      String str2 = n;
      if (str2 != null && !"".equals(n))
        return n; 
      DisplayMetrics displayMetrics = new DisplayMetrics();
      WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
      if (windowManager == null)
        return ""; 
      windowManager.getDefaultDisplay().getMetrics(displayMetrics);
      int i = displayMetrics.widthPixels;
      int j = displayMetrics.heightPixels;
      if (j > i) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("*");
        stringBuilder.append(j);
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("*");
        stringBuilder.append(i);
      } 
      String str1 = stringBuilder.toString();
      n = str1;
    } finally {}
    return n;
  }
  
  public static String v(Context paramContext) {
    try {
      int i = Build.VERSION.SDK_INT;
      if (i >= 29)
        return ""; 
      if (o != null && !"".equals(o))
        return o; 
      if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
        return o; 
      TelephonyManager telephonyManager = H(paramContext);
      if (telephonyManager == null)
        return ""; 
      Method method = db.a(telephonyManager.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
      if (Build.VERSION.SDK_INT >= 26)
        method = db.a(telephonyManager.getClass(), "QZ2V0SW1laQ==", new Class[0]); 
      if (method != null)
        o = (String)method.invoke(telephonyManager, new Object[0]); 
      if (o == null)
        o = ""; 
    } finally {}
    return o;
  }
  
  public static String w(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    try {
      if (p != null && !"".equals(p))
        return p; 
      if (!a(paramContext, db.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
        return p; 
      TelephonyManager telephonyManager = H(paramContext);
      if (telephonyManager == null)
        return ""; 
      if (Build.VERSION.SDK_INT >= 26) {
        Method method = db.a(telephonyManager.getClass(), "QZ2V0TWVpZA==", new Class[0]);
        if (method != null)
          p = (String)method.invoke(telephonyManager, new Object[0]); 
        if (p == null)
          p = ""; 
      } 
    } finally {}
    return p;
  }
  
  public static String x(Context paramContext) {
    try {
      return B(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  public static int y(Context paramContext) {
    int i = s;
    if (i != 0)
      return i; 
    i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i >= 16) {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (activityManager == null)
        return 0; 
      ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
      activityManager.getMemoryInfo(memoryInfo);
      i = (int)(memoryInfo.totalMem / 1024L);
    } else {
      paramContext = null;
      try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/meminfo")));
        try {
          int j = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue();
          i = j;
          try {
            bufferedReader.close();
            i = j;
          } catch (IOException iOException) {}
        } finally {}
      } finally {
        Exception exception;
      } 
      i = bool1;
    } 
    s = i / 1024;
    return s;
  }
  
  static String z(Context paramContext) {
    try {
      return C(paramContext);
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */