package com.loc;

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

public final class n {
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
  
  public static String A(Context paramContext) {
    try {
      return H(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  public static int B(Context paramContext) {
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
  
  static String C(Context paramContext) {
    try {
      return I(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  private static String E(Context paramContext) {
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
  
  private static String F(Context paramContext) {
    boolean bool = u.c("IeGlhb21p").equalsIgnoreCase(Build.MANUFACTURER);
    int i = 0;
    if (bool) {
      try {
        Class<?> clazz = Class.forName(u.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
        Object object2 = clazz.newInstance();
        Object object1 = clazz.getMethod(u.c("MZ2V0T0FJRA"), new Class[] { Context.class }).invoke(object2, new Object[] { paramContext });
        if (object1 != null) {
          object1 = object1;
          n = (String)object1;
          return (String)object1;
        } 
        return n;
      } finally {}
    } else if (u.c("IaHVhd2Vp").equalsIgnoreCase(Build.MANUFACTURER)) {
      try {
        Intent intent = new Intent();
        intent.setAction(u.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
        intent.setPackage(u.c("UY29tLmh1YXdlaS5od2lk"));
        b b = new b();
        return n;
      } finally {
        paramContext = null;
      } 
    } else {
      "OPPO".equalsIgnoreCase(Build.MANUFACTURER);
    } 
    o = true;
    return n;
  }
  
  private static String G(Context paramContext) {
    if (!TextUtils.isEmpty(w))
      return w; 
    try {
      String str = x.b(paramContext, "open_common", "a1", "");
      return w;
    } finally {
      paramContext = null;
    } 
  }
  
  private static String H(Context paramContext) throws InvocationTargetException, IllegalAccessException {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    String str = A;
    if (str != null && !"".equals(str))
      return A; 
    if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return A; 
    TelephonyManager telephonyManager = M(paramContext);
    if (telephonyManager == null)
      return ""; 
    Method method = u.a(telephonyManager.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
    if (method != null)
      A = (String)method.invoke(telephonyManager, new Object[0]); 
    if (A == null)
      A = ""; 
    return A;
  }
  
  private static String I(Context paramContext) {
    if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return null; 
    TelephonyManager telephonyManager = M(paramContext);
    if (telephonyManager == null)
      return ""; 
    String str2 = telephonyManager.getSimOperatorName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = telephonyManager.getNetworkOperatorName(); 
    return str1;
  }
  
  private static int J(Context paramContext) {
    if (paramContext != null) {
      if (!b(paramContext, u.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")))
        return -1; 
      ConnectivityManager connectivityManager = K(paramContext);
      if (connectivityManager == null)
        return -1; 
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      return (networkInfo == null) ? -1 : networkInfo.getType();
    } 
    return -1;
  }
  
  private static ConnectivityManager K(Context paramContext) {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  private static int L(Context paramContext) {
    if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return -1; 
    TelephonyManager telephonyManager = M(paramContext);
    return (telephonyManager == null) ? -1 : telephonyManager.getNetworkType();
  }
  
  private static TelephonyManager M(Context paramContext) {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
  
  private static String N(Context paramContext) {
    if (!c)
      return ""; 
    Context context = null;
    try {
      String str = O(paramContext);
    } finally {
      paramContext = null;
    } 
    try {
      byte[] arrayOfByte2 = u.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
      byte[] arrayOfByte1 = o.b((String)paramContext);
      return new String(o.a(u.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), arrayOfByte1, arrayOfByte2), "UTF-8");
    } finally {}
    c = false;
    return "";
  }
  
  private static String O(Context paramContext) {
    String str;
    try {
      str = P(paramContext);
    } finally {
      Exception exception = null;
    } 
  }
  
  private static String P(Context paramContext) {
    String str2 = r.a(u.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
    String str1 = Q(paramContext);
    if (TextUtils.isEmpty(str1))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(File.separator);
    stringBuilder.append(u.c("KYmFja3Vwcw"));
    File file = new File(stringBuilder.toString(), u.c("MLmFkaXU"));
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
  
  private static String Q(Context paramContext) {
    if (Build.VERSION.SDK_INT < 9)
      return null; 
    try {
      int i;
      StorageManager storageManager = (StorageManager)paramContext.getSystemService("storage");
      Class<?> clazz = Class.forName(u.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
      Method method3 = storageManager.getClass().getMethod(u.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
      Method method1 = clazz.getMethod(u.c("FZ2V0UGF0aA"), new Class[0]);
      Method method2 = clazz.getMethod(u.c("DaXNSZW1vdmFibGU"), new Class[0]);
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
    String str = N(paramContext);
    b = str;
    if (!TextUtils.isEmpty(str))
      return b; 
    if (g == null)
      return ""; 
    if (m)
      return ""; 
    m = true;
    ab.d().submit(new Runnable(paramContext) {
          public final void run() {
            try {
              n.a a1 = n.g;
              n.h(this.a);
              n.A(this.a);
              String str2 = a1.d();
              if (TextUtils.isEmpty(str2))
                return; 
              aq.a();
              n.a a2 = n.g;
              str2.getBytes();
              byte[] arrayOfByte = aq.a(a2.a());
              a2 = n.g;
              new String(arrayOfByte);
              String str1 = a2.c();
              return;
            } finally {
              Exception exception = null;
            } 
          }
        });
    return "";
  }
  
  public static String a(Context paramContext, String paramString) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #29
    //   5: if_icmplt -> 11
    //   8: ldc ''
    //   10: areturn
    //   11: getstatic android/os/Build$VERSION.SDK_INT : I
    //   14: bipush #21
    //   16: if_icmpge -> 22
    //   19: ldc ''
    //   21: areturn
    //   22: getstatic com/loc/n.i : Ljava/lang/String;
    //   25: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   28: ifne -> 35
    //   31: getstatic com/loc/n.i : Ljava/lang/String;
    //   34: areturn
    //   35: aload_0
    //   36: invokestatic M : (Landroid/content/Context;)Landroid/telephony/TelephonyManager;
    //   39: astore_0
    //   40: getstatic com/loc/n.h : I
    //   43: iconst_m1
    //   44: if_icmpne -> 90
    //   47: ldc_w android/telephony/TelephonyManager
    //   50: ldc_w 'UZ2V0UGhvbmVDb3VudA='
    //   53: iconst_0
    //   54: anewarray java/lang/Class
    //   57: invokestatic a : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   60: astore_3
    //   61: aload_3
    //   62: ifnull -> 86
    //   65: aload_3
    //   66: aload_0
    //   67: iconst_0
    //   68: anewarray java/lang/Object
    //   71: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   74: checkcast java/lang/Integer
    //   77: invokevirtual intValue : ()I
    //   80: putstatic com/loc/n.h : I
    //   83: goto -> 90
    //   86: iconst_0
    //   87: putstatic com/loc/n.h : I
    //   90: ldc_w android/telephony/TelephonyManager
    //   93: ldc_w 'MZ2V0SW1laQ='
    //   96: iconst_1
    //   97: anewarray java/lang/Class
    //   100: dup
    //   101: iconst_0
    //   102: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   105: aastore
    //   106: invokestatic a : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   109: astore #4
    //   111: aload #4
    //   113: ifnonnull -> 123
    //   116: iconst_0
    //   117: putstatic com/loc/n.h : I
    //   120: ldc ''
    //   122: areturn
    //   123: new java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial <init> : ()V
    //   130: astore_3
    //   131: iconst_0
    //   132: istore_2
    //   133: iload_2
    //   134: getstatic com/loc/n.h : I
    //   137: if_icmpge -> 178
    //   140: aload_3
    //   141: aload #4
    //   143: aload_0
    //   144: iconst_1
    //   145: anewarray java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: iload_2
    //   151: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   154: aastore
    //   155: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   158: checkcast java/lang/String
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_3
    //   166: aload_1
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: iload_2
    //   172: iconst_1
    //   173: iadd
    //   174: istore_2
    //   175: goto -> 133
    //   178: aload_3
    //   179: invokevirtual toString : ()Ljava/lang/String;
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual length : ()I
    //   187: ifne -> 197
    //   190: iconst_0
    //   191: putstatic com/loc/n.h : I
    //   194: ldc ''
    //   196: areturn
    //   197: aload_0
    //   198: iconst_0
    //   199: aload_0
    //   200: invokevirtual length : ()I
    //   203: iconst_1
    //   204: isub
    //   205: invokevirtual substring : (II)Ljava/lang/String;
    //   208: astore_0
    //   209: aload_0
    //   210: putstatic com/loc/n.i : Ljava/lang/String;
    //   213: aload_0
    //   214: areturn
    //   215: astore_0
    //   216: ldc ''
    //   218: areturn
    //   219: astore_3
    //   220: goto -> 86
    //   223: astore_0
    //   224: goto -> 178
    // Exception table:
    //   from	to	target	type
    //   11	19	215	finally
    //   22	35	215	finally
    //   35	61	215	finally
    //   65	83	219	finally
    //   86	90	215	finally
    //   90	111	215	finally
    //   116	120	215	finally
    //   123	131	215	finally
    //   133	171	223	finally
    //   178	194	215	finally
    //   197	213	215	finally
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
  
  private static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        return;
      } finally {
        paramCloseable = null;
      }  
  }
  
  public static void a(String paramString) {
    k = paramString;
  }
  
  public static String b() {
    try {
      return !TextUtils.isEmpty(e) ? e : ((g == null) ? "" : g.b());
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String b(Context paramContext) {
    try {
      return I(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  private static boolean b(Context paramContext, String paramString) {
    return (paramContext != null && paramContext.checkCallingOrSelfPermission(paramString) == 0);
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
  
  static String[] c() {
    return new String[] { "", "" };
  }
  
  public static int d(Context paramContext) {
    try {
      return L(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static long d() {
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
  
  public static int e(Context paramContext) {
    try {
      return J(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static String e() {
    if (!TextUtils.isEmpty(z))
      return z; 
    String str = System.getProperty("os.arch");
    z = str;
    return str;
  }
  
  public static String f(Context paramContext) {
    try {
      return H(paramContext);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  private static String g() {
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
  
  public static String g(Context paramContext) {
    try {
      if (o)
        return ""; 
      if (!TextUtils.isEmpty(n))
        return n; 
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ab.d().submit(new Runnable(paramContext) {
              public final void run() {
                n.D(this.a);
              }
            });
      } else {
        return F(paramContext);
      } 
    } finally {}
    return n;
  }
  
  public static String h(Context paramContext) {
    try {
      if (a != null && !"".equals(a))
        return a; 
      if (b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")))
        a = Settings.System.getString(paramContext.getContentResolver(), "mqBRboGZkQPcAkyk"); 
      if (a != null && !"".equals(a))
        return a; 
    } finally {
      Exception exception;
    } 
    try {
      a = E(paramContext);
    } finally {}
    String str = a;
    return (str == null) ? "" : str;
  }
  
  public static String i(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    if (!TextUtils.isEmpty(q))
      return q; 
    if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
      return ""; 
    try {
      if (Build.VERSION.SDK_INT >= 26)
        return (String)u.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]); 
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
      null = Settings.Secure.getString(paramContext.getContentResolver(), u.c(new String(v.a(13))));
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
        if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
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
        if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
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
      if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")))
        return r; 
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager == null)
        return ""; 
      r = wifiManager.getConnectionInfo().getMacAddress();
      if (u.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(r) || u.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(r))
        r = g(); 
    } finally {}
    return r;
  }
  
  static String n(Context paramContext) {
    String str = "";
    try {
      TelephonyManager telephonyManager = M(paramContext);
      if (telephonyManager == null)
        return ""; 
      String str2 = telephonyManager.getNetworkOperator();
      String str1 = str;
      return str1;
    } finally {
      paramContext = null;
    } 
  }
  
  static String o(Context paramContext) {
    String str = "";
    try {
      TelephonyManager telephonyManager = M(paramContext);
      if (telephonyManager == null)
        return ""; 
      String str2 = telephonyManager.getNetworkOperator();
      String str1 = str;
      return str1;
    } finally {
      paramContext = null;
    } 
  }
  
  public static int p(Context paramContext) {
    try {
      return L(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  public static int q(Context paramContext) {
    try {
      return J(paramContext);
    } finally {
      paramContext = null;
    } 
  }
  
  public static NetworkInfo r(Context paramContext) {
    if (!b(paramContext, u.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")))
      return null; 
    ConnectivityManager connectivityManager = K(paramContext);
    return (connectivityManager == null) ? null : connectivityManager.getActiveNetworkInfo();
  }
  
  static String s(Context paramContext) {
    try {
      return (networkInfo == null) ? null : networkInfo.getExtraInfo();
    } finally {
      paramContext = null;
    } 
  }
  
  static String t(Context paramContext) {
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
  
  public static String u(Context paramContext) {
    try {
      if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
        return A; 
      return (telephonyManager == null) ? "" : telephonyManager.getNetworkOperatorName();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String v(Context paramContext) {
    try {
      if (!b(paramContext, u.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")))
        return ""; 
      ConnectivityManager connectivityManager = K(paramContext);
      if (connectivityManager == null)
        return ""; 
      return (networkInfo == null) ? "" : networkInfo.getTypeName();
    } finally {
      paramContext = null;
    } 
  }
  
  public static String w(Context paramContext) {
    String str;
    try {
      String str2 = x(paramContext);
      str = str2;
      String str1 = str2;
    } finally {
      paramContext = null;
    } 
    return str;
  }
  
  public static String x(Context paramContext) {
    try {
      int i = Build.VERSION.SDK_INT;
      if (i >= 29)
        return ""; 
      if (t != null && !"".equals(t))
        return t; 
      if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
        return t; 
      TelephonyManager telephonyManager = M(paramContext);
      if (telephonyManager == null)
        return ""; 
      Method method = u.a(telephonyManager.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
      if (Build.VERSION.SDK_INT >= 26)
        method = u.a(telephonyManager.getClass(), "QZ2V0SW1laQ==", new Class[0]); 
      if (method != null)
        t = (String)method.invoke(telephonyManager, new Object[0]); 
      if (t == null)
        t = ""; 
    } finally {}
    return t;
  }
  
  public static String y(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(x(paramContext));
    stringBuilder.append("#");
    stringBuilder.append(a(paramContext));
    stringBuilder.append("#");
    stringBuilder.append(w(paramContext));
    return stringBuilder.toString();
  }
  
  public static String z(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 29)
      return ""; 
    try {
      if (u != null && !"".equals(u))
        return u; 
      if (!b(paramContext, u.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")))
        return u; 
      TelephonyManager telephonyManager = M(paramContext);
      if (telephonyManager == null)
        return ""; 
      if (Build.VERSION.SDK_INT >= 26) {
        Method method = u.a(telephonyManager.getClass(), "QZ2V0TWVpZA==", new Class[0]);
        if (method != null)
          u = (String)method.invoke(telephonyManager, new Object[0]); 
        if (u == null)
          u = ""; 
      } 
    } finally {}
    return u;
  }
  
  public static interface a {
    av a();
    
    String b();
    
    String c();
    
    String d();
  }
  
  static final class b implements ServiceConnection {
    public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        param1IBinder.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        n.b(parcel2.readString());
        parcel2.recycle();
        return;
      } finally {
        param1IBinder = null;
      } 
    }
    
    public final void onServiceDisconnected(ComponentName param1ComponentName) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */