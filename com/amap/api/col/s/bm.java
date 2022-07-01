package com.amap.api.col.s;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class bm {
  private static String A = "";
  
  static String a = "";
  
  static String b = "";
  
  static volatile boolean c = true;
  
  public static boolean d = false;
  
  static String e = "";
  
  static boolean f = false;
  
  public static a g;
  
  static int h = -1;
  
  static String i = "";
  
  static String j = "";
  
  private static String k;
  
  private static boolean l = false;
  
  private static volatile boolean m = false;
  
  private static String n = "";
  
  private static boolean o = false;
  
  private static String p = "";
  
  private static String q = "";
  
  private static String r = "";
  
  private static String s = "";
  
  private static String t = "";
  
  private static String u = "";
  
  private static boolean v = false;
  
  private static String w = "";
  
  private static long x;
  
  private static int y;
  
  private static String z;
  
  private static String A(Context paramContext) {
    boolean bool = bs.c("IeGlhb21p").equalsIgnoreCase(Build.MANUFACTURER);
    int i = 0;
    if (bool) {
      try {
        Class<?> clazz = Class.forName(bs.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
        Object object2 = clazz.newInstance();
        Object object1 = clazz.getMethod(bs.c("MZ2V0T0FJRA"), new Class[] { Context.class }).invoke(object2, new Object[] { paramContext });
      } finally {
        paramContext = null;
      } 
    } else {
      if (bs.c("IaHVhd2Vp").equalsIgnoreCase(Build.MANUFACTURER)) {
        try {
          Intent intent = new Intent();
          intent.setAction(bs.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
          intent.setPackage(bs.c("UY29tLmh1YXdlaS5od2lk"));
          b b = new b();
          return n;
        } finally {
          paramContext = null;
        } 
      } else {
        "OPPO".equalsIgnoreCase(Build.MANUFACTURER);
      } 
      o = true;
    } 
    return n;
  }
  
  private static String B(Context paramContext) {
    if (!TextUtils.isEmpty(w))
      return w; 
    try {
      String str = ci.b(paramContext, "open_common", "a1", "");
      return w;
    } finally {
      paramContext = null;
    } 
  }
  
  private static String C(Context paramContext) throws InvocationTargetException, IllegalAccessException {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    String str = A;
    if (str != null && !"".equals(str))
      return A; 
    if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return A; 
    TelephonyManager telephonyManager = H(paramContext);
    if (telephonyManager == null)
      return ""; 
    Method method = bs.a(telephonyManager.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
    if (method != null)
      A = (String)method.invoke(telephonyManager, new Object[0]); 
    if (A == null)
      A = ""; 
    return A;
  }
  
  private static String D(Context paramContext) {
    if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
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
  
  private static int E(Context paramContext) {
    if (paramContext != null) {
      if (!b(paramContext, bs.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")))
        return -1; 
      ConnectivityManager connectivityManager = F(paramContext);
      if (connectivityManager == null)
        return -1; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      return (networkInfo == null) ? -1 : networkInfo.getType();
    } 
    return -1;
  }
  
  private static ConnectivityManager F(Context paramContext) {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  private static int G(Context paramContext) {
    if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return -1; 
    TelephonyManager telephonyManager = H(paramContext);
    return (telephonyManager == null) ? -1 : telephonyManager.getNetworkType();
  }
  
  private static TelephonyManager H(Context paramContext) {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
  
  private static String I(Context paramContext) {
    if (!c)
      return ""; 
    Context context = null;
    try {
      String str = J(paramContext);
    } finally {
      paramContext = null;
    } 
    try {
      byte[] arrayOfByte2 = bs.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
      byte[] arrayOfByte1 = bn.b((String)paramContext);
      return new String(bn.a(bs.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), arrayOfByte1, arrayOfByte2), "UTF-8");
    } finally {}
    c = false;
    return "";
  }
  
  private static String J(Context paramContext) {
    String str;
    try {
      str = K(paramContext);
    } finally {
      Exception exception = null;
    } 
  }
  
  private static String K(Context paramContext) {
    String str2 = bq.a(bs.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
    String str1 = L(paramContext);
    if (TextUtils.isEmpty(str1))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(File.separator);
    stringBuilder.append(bs.c("KYmFja3Vwcw"));
    File file = new File(stringBuilder.toString(), bs.c("MLmFkaXU"));
    if (file.exists()) {
      ByteArrayOutputStream byteArrayOutputStream;
      if (!file.canRead())
        return ""; 
      if (file.length() == 0L) {
        file.delete();
        return "";
      } 
      stringBuilder = null;
      try {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
      } finally {
        file = null;
      } 
      a(byteArrayOutputStream);
    } else {
      return "";
    } 
    a((Closeable)file);
    break;
  }
  
  private static String L(Context paramContext) {
    if (Build.VERSION.SDK_INT < 9)
      return null; 
    try {
      int i;
      StorageManager storageManager = (StorageManager)paramContext.getSystemService("storage");
      Class<?> clazz = Class.forName(bs.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
      Method method3 = storageManager.getClass().getMethod(bs.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
      Method method1 = clazz.getMethod(bs.c("FZ2V0UGF0aA"), new Class[0]);
      Method method2 = clazz.getMethod(bs.c("DaXNSZW1vdmFibGU"), new Class[0]);
      Object object = method3.invoke(storageManager, new Object[0]);
      int j = Array.getLength(object);
      return null;
    } finally {
      paramContext = null;
    } 
  }
  
  public static String a() {
    return k;
  }
  
  public static String a(Context paramContext) {
    try {
      if (!TextUtils.isEmpty(b))
        return b; 
    } finally {
      paramContext = null;
    } 
    String str = I(paramContext);
    b = str;
    if (!TextUtils.isEmpty(str))
      return b; 
    if (g == null)
      return ""; 
    if (m)
      return ""; 
    m = true;
    cg.c().submit(new Runnable(paramContext) {
          public final void run() {
            try {
              Map<String, String> map = bm.g.b();
              String str2 = bm.g.a(bm.h(this.a), "", "", bm.v(this.a));
              if (TextUtils.isEmpty(str2))
                return; 
              cs.a();
              byte[] arrayOfByte = cs.a(bm.g.a(str2.getBytes(), map));
              String str1 = bm.g.a(this.a, new String(arrayOfByte));
              return;
            } finally {
              Exception exception = null;
            } 
          }
        });
    return "";
  }
  
  public static String a(Context paramContext, String paramString) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    try {
      if (Build.VERSION.SDK_INT < 21)
        return ""; 
      if (!TextUtils.isEmpty(i))
        return i; 
      TelephonyManager telephonyManager = H(paramContext);
      if (h == -1) {
        Method method1 = bs.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
        if (method1 != null) {
          try {
            h = ((Integer)method1.invoke(telephonyManager, new Object[0])).intValue();
          } finally {
            method1 = null;
          } 
        } else {
          h = 0;
        } 
      } 
      Method method = bs.a(TelephonyManager.class, "MZ2V0SW1laQ=", new Class[] { int.class });
      if (method == null)
        return ""; 
      StringBuilder stringBuilder = new StringBuilder();
      int i = 0;
      try {
        while (i < h) {
          stringBuilder.append((String)method.invoke(telephonyManager, new Object[] { Integer.valueOf(i) }));
          stringBuilder.append(paramString);
          i++;
        } 
      } finally {}
      String str = stringBuilder.toString();
      if (str.length() == 0)
        return ""; 
      str = str.substring(0, str.length() - 1);
      return str;
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
  
  public static void a(a parama) {
    if (g == null)
      g = parama; 
  }
  
  private static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        return;
      } finally {
        paramCloseable = null;
      }  
  }
  
  public static String b() {
    try {
      return !TextUtils.isEmpty(e) ? e : ((g == null) ? "" : g.a());
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String b(Context paramContext) {
    try {
      return D(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  private static boolean b(Context paramContext, String paramString) {
    return (paramContext != null && paramContext.checkCallingOrSelfPermission(paramString) == 0);
  }
  
  public static a c() {
    return g;
  }
  
  public static String c(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    try {
      String str;
      return (str != null) ? ((str.length() < 5) ? "" : str.substring(3, 5)) : "";
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static int d(Context paramContext) {
    try {
      return G(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  static String[] d() {
    return new String[] { "", "" };
  }
  
  public static int e(Context paramContext) {
    try {
      return E(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static long e() {
    long l = x;
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
      x = l + l1;
    } finally {
      Exception exception;
    } 
    return x;
  }
  
  public static String f() {
    if (!TextUtils.isEmpty(z))
      return z; 
    String str = System.getProperty("os.arch");
    z = str;
    return str;
  }
  
  public static String f(Context paramContext) {
    try {
      return C(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static String g(Context paramContext) {
    try {
      if (o)
        return ""; 
      if (!TextUtils.isEmpty(n))
        return n; 
      if (Looper.getMainLooper() == Looper.myLooper()) {
        cg.c().submit(new Runnable(paramContext) {
              public final void run() {
                bm.y(this.a);
              }
            });
      } else {
        return A(paramContext);
      } 
    } finally {}
    return n;
  }
  
  private static String h() {
    String str = "";
    try {
      String str1;
      Iterator<NetworkInterface> iterator = Collections.<NetworkInterface>list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (true) {
        str1 = str;
        if (iterator.hasNext()) {
          NetworkInterface networkInterface = iterator.next();
          if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
            byte[] arrayOfByte;
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
            break;
          } 
          continue;
        } 
        break;
      } 
      return str1;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static String h(Context paramContext) {
    try {
      if (a != null && !"".equals(a))
        return a; 
      if (b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")))
        a = Settings.System.getString(paramContext.getContentResolver(), "mqBRboGZkQPcAkyk"); 
      if (a != null && !"".equals(a))
        return a; 
    } finally {
      Exception exception;
    } 
    try {
      a = z(paramContext);
    } finally {}
    String str = a;
    return (str == null) ? "" : str;
  }
  
  public static String i(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    if (!TextUtils.isEmpty(q))
      return q; 
    if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return ""; 
    try {
      if (Build.VERSION.SDK_INT >= 26)
        return (String)bs.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]); 
      if (Build.VERSION.SDK_INT >= 9)
        q = Build.SERIAL; 
    } finally {}
    String str = q;
    return (str == null) ? "" : str;
  }
  
  public static String j(Context paramContext) {
    if (!TextUtils.isEmpty(p))
      return p; 
    try {
      null = Settings.Secure.getString(paramContext.getContentResolver(), bs.c(new String(cc.a(13))));
      return (null == null) ? "" : p;
    } finally {
      paramContext = null;
    } 
  }
  
  static String k(Context paramContext) {
    String str2 = "";
    String str1 = str2;
    if (paramContext != null)
      try {
        if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
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
        if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
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
      String str = r;
      if (str != null && !"".equals(r))
        return r; 
      if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
        return r; 
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager == null)
        return ""; 
      r = wifiManager.getConnectionInfo().getMacAddress();
      if (bs.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(r) || bs.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(r))
        r = h(); 
    } finally {}
    return r;
  }
  
  static String n(Context paramContext) {
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
  
  public static int o(Context paramContext) {
    try {
      return G(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  public static int p(Context paramContext) {
    try {
      return E(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  static String q(Context paramContext) {
    try {
      StringBuilder stringBuilder;
      String str2 = s;
      if (str2 != null && !"".equals(s))
        return s; 
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
      s = str1;
    } finally {}
    return s;
  }
  
  public static String r(Context paramContext) {
    try {
      if (!b(paramContext, bs.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")))
        return ""; 
      ConnectivityManager connectivityManager = F(paramContext);
      if (connectivityManager == null)
        return ""; 
      return (networkInfo == null) ? "" : networkInfo.getTypeName();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String s(Context paramContext) {
    String str;
    try {
      String str2 = t(paramContext);
      str = str2;
      String str1 = str2;
    } finally {
      paramContext = null;
    } 
    return str;
  }
  
  public static String t(Context paramContext) {
    try {
      int i = Build.VERSION.SDK_INT;
      if (i >= 29)
        return ""; 
      if (t != null && !"".equals(t))
        return t; 
      if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
        return t; 
      TelephonyManager telephonyManager = H(paramContext);
      if (telephonyManager == null)
        return ""; 
      Method method = bs.a(telephonyManager.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
      if (Build.VERSION.SDK_INT >= 26)
        method = bs.a(telephonyManager.getClass(), "QZ2V0SW1laQ==", new Class[0]); 
      if (method != null)
        t = (String)method.invoke(telephonyManager, new Object[0]); 
      if (t == null)
        t = ""; 
    } finally {}
    return t;
  }
  
  public static String u(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    try {
      if (u != null && !"".equals(u))
        return u; 
      if (!b(paramContext, bs.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
        return u; 
      TelephonyManager telephonyManager = H(paramContext);
      if (telephonyManager == null)
        return ""; 
      if (Build.VERSION.SDK_INT >= 26) {
        Method method = bs.a(telephonyManager.getClass(), "QZ2V0TWVpZA==", new Class[0]);
        if (method != null)
          u = (String)method.invoke(telephonyManager, new Object[0]); 
        if (u == null)
          u = ""; 
      } 
    } finally {}
    return u;
  }
  
  public static String v(Context paramContext) {
    try {
      return C(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  public static int w(Context paramContext) {
    int i = y;
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
    i /= 1024;
    y = i;
    return i;
  }
  
  static String x(Context paramContext) {
    try {
      return D(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  private static String z(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #6
    //   6: aload #6
    //   8: astore #4
    //   10: aload_0
    //   11: ldc_w 'android.permission.READ_EXTERNAL_STORAGE'
    //   14: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   17: ifeq -> 230
    //   20: aload #6
    //   22: astore #4
    //   24: ldc_w 'mounted'
    //   27: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   30: invokevirtual equals : (Ljava/lang/Object;)Z
    //   33: ifeq -> 230
    //   36: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   39: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   42: astore_0
    //   43: new java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial <init> : ()V
    //   50: astore #4
    //   52: aload #4
    //   54: aload_0
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #4
    //   61: ldc_w '/.UTSystemConfig/Global/Alvin2.xml'
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: new java/io/File
    //   71: dup
    //   72: aload #4
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: invokespecial <init> : (Ljava/lang/String;)V
    //   80: astore_0
    //   81: invokestatic newPullParser : ()Lorg/xmlpull/v1/XmlPullParser;
    //   84: astore #4
    //   86: aload #4
    //   88: invokeinterface getEventType : ()I
    //   93: istore_3
    //   94: new java/io/FileInputStream
    //   97: dup
    //   98: aload_0
    //   99: invokespecial <init> : (Ljava/io/File;)V
    //   102: astore_0
    //   103: aload #4
    //   105: aload_0
    //   106: ldc_w 'utf-8'
    //   109: invokeinterface setInput : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   114: iconst_0
    //   115: istore_1
    //   116: goto -> 275
    //   119: iload_1
    //   120: istore_2
    //   121: iload_1
    //   122: ifeq -> 208
    //   125: aload #4
    //   127: invokeinterface getText : ()Ljava/lang/String;
    //   132: astore #4
    //   134: aload_0
    //   135: invokevirtual close : ()V
    //   138: aload #4
    //   140: areturn
    //   141: iconst_0
    //   142: istore_2
    //   143: goto -> 208
    //   146: iload_1
    //   147: istore_2
    //   148: aload #4
    //   150: invokeinterface getAttributeCount : ()I
    //   155: ifle -> 208
    //   158: aload #4
    //   160: invokeinterface getAttributeCount : ()I
    //   165: istore_3
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: iload_3
    //   170: if_icmpge -> 315
    //   173: aload #4
    //   175: iload_2
    //   176: invokeinterface getAttributeValue : (I)Ljava/lang/String;
    //   181: astore #5
    //   183: ldc_w 'UTDID2'
    //   186: aload #5
    //   188: invokevirtual equals : (Ljava/lang/Object;)Z
    //   191: ifne -> 306
    //   194: ldc_w 'UTDID'
    //   197: aload #5
    //   199: invokevirtual equals : (Ljava/lang/Object;)Z
    //   202: ifeq -> 308
    //   205: goto -> 306
    //   208: aload #4
    //   210: invokeinterface next : ()I
    //   215: istore_3
    //   216: iload_2
    //   217: istore_1
    //   218: goto -> 275
    //   221: aload_0
    //   222: astore #4
    //   224: goto -> 230
    //   227: goto -> 245
    //   230: aload #4
    //   232: ifnull -> 252
    //   235: aload #4
    //   237: astore_0
    //   238: aload_0
    //   239: invokevirtual close : ()V
    //   242: goto -> 252
    //   245: aload_0
    //   246: ifnull -> 252
    //   249: goto -> 238
    //   252: ldc ''
    //   254: areturn
    //   255: astore_0
    //   256: aload #5
    //   258: astore_0
    //   259: goto -> 245
    //   262: astore #4
    //   264: goto -> 227
    //   267: astore_0
    //   268: aload #4
    //   270: areturn
    //   271: astore_0
    //   272: goto -> 252
    //   275: iconst_1
    //   276: iload_3
    //   277: if_icmpeq -> 221
    //   280: iload_1
    //   281: istore_2
    //   282: iload_3
    //   283: ifeq -> 208
    //   286: iload_3
    //   287: iconst_2
    //   288: if_icmpeq -> 146
    //   291: iload_3
    //   292: iconst_3
    //   293: if_icmpeq -> 141
    //   296: iload_3
    //   297: iconst_4
    //   298: if_icmpeq -> 119
    //   301: iload_1
    //   302: istore_2
    //   303: goto -> 208
    //   306: iconst_1
    //   307: istore_1
    //   308: iload_2
    //   309: iconst_1
    //   310: iadd
    //   311: istore_2
    //   312: goto -> 168
    //   315: iload_1
    //   316: istore_2
    //   317: goto -> 208
    // Exception table:
    //   from	to	target	type
    //   10	20	255	finally
    //   24	103	255	finally
    //   103	114	262	finally
    //   125	134	262	finally
    //   134	138	267	finally
    //   148	166	262	finally
    //   173	194	262	finally
    //   194	205	262	finally
    //   208	216	262	finally
    //   238	242	271	finally
  }
  
  public static interface a {
    cy a(byte[] param1ArrayOfbyte, Map<String, String> param1Map);
    
    String a();
    
    String a(Context param1Context, String param1String);
    
    String a(String param1String1, String param1String2, String param1String3, String param1String4);
    
    Map<String, String> b();
  }
  
  static final class b implements ServiceConnection {
    public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        param1IBinder.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        bm.a(parcel2.readString());
        parcel2.recycle();
        return;
      } finally {
        param1IBinder = null;
      } 
    }
    
    public final void onServiceDisconnected(ComponentName param1ComponentName) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */