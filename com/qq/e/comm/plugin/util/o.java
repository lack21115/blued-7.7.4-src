package com.qq.e.comm.plugin.util;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.f.a;
import com.qq.e.comm.plugin.h.b;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class o {
  private static String a = "";
  
  private static String b = "";
  
  private static String c;
  
  private static String d = "";
  
  public static Pair<Integer, Integer> a() {
    Display display = ((WindowManager)GDTADManager.getInstance().getAppContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      display.getRealMetrics(displayMetrics);
    } else {
      display.getMetrics(displayMetrics);
    } 
    return new Pair(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
  }
  
  private static String a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 8 & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 16 & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >> 24 & 0xFF);
    return stringBuilder.toString();
  }
  
  private static String a(String paramString) throws IOException {
    Exception exception;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramString), a.a));
    } finally {
      exception = null;
    } 
    if (paramString != null)
      paramString.close(); 
    throw exception;
  }
  
  public static boolean a(Context paramContext) {
    if (Build.VERSION.SDK_INT < 21)
      try {
        return h(paramContext);
      } catch (SecurityException securityException) {
        ak.a("no permission : android.permission.GET_TASKS", new Object[0]);
      }  
    int i = Process.myPid();
    if ((new File("/dev/cpuctl/tasks")).exists()) {
      try {
        return c(i);
      } catch (IOException iOException) {
        ak.a("checkForegroundUseCGroup Exception", new Object[0]);
      } 
    } else {
      try {
        return b(i);
      } catch (IOException iOException) {
        ak.a("checkForegroundUseStat Exception", new Object[0]);
      } 
    } 
    return g(paramContext);
  }
  
  public static boolean a(Intent paramIntent) {
    if (paramIntent != null) {
      int i = paramIntent.getIntExtra("status", -1);
      if (i == 2 || i == 5)
        return true; 
    } 
    return false;
  }
  
  public static String b() {
    if (!n())
      return null; 
    if (TextUtils.isEmpty(a)) {
      Context context = GDTADManager.getInstance().getAppContext();
      a = b.a.a().b(context);
    } 
    return a;
  }
  
  private static boolean b(int paramInt) throws IOException {
    String str = a(String.format("/proc/%d/stat", new Object[] { Integer.valueOf(paramInt) }));
    ak.b("gdt_tag_p", "checkForegroundUseStat : stat = %s ", new Object[] { str });
    if (!TextUtils.isEmpty(str)) {
      String[] arrayOfString = str.split("\\s+");
      if (arrayOfString != null && arrayOfString.length > 40)
        return (Integer.parseInt(arrayOfString[40]) == 0); 
      throw new IOException("Invalid format,no match status");
    } 
    throw new IOException("No content");
  }
  
  public static boolean b(Context paramContext) {
    byte b = 0;
    int i = b;
    if (paramContext != null) {
      Display[] arrayOfDisplay;
      if (Build.VERSION.SDK_INT >= 20) {
        DisplayManager displayManager = (DisplayManager)paramContext.getSystemService("display");
        i = b;
        if (displayManager != null) {
          paramContext = null;
          try {
            Display[] arrayOfDisplay1 = displayManager.getDisplays();
            arrayOfDisplay = arrayOfDisplay1;
          } catch (Exception exception) {}
          i = b;
          if (arrayOfDisplay != null) {
            i = b;
            if (arrayOfDisplay.length > 0) {
              int k = arrayOfDisplay.length;
              int j = 0;
              while (true) {
                i = b;
                if (j < k) {
                  Display display = arrayOfDisplay[j];
                  if (display != null && display.getState() == 1)
                    return true; 
                  j++;
                  continue;
                } 
                break;
              } 
            } 
          } 
        } 
      } else {
        PowerManager powerManager = (PowerManager)arrayOfDisplay.getSystemService("power");
        i = b;
        if (powerManager != null)
          i = powerManager.isScreenOn() ^ true; 
      } 
    } 
    return i;
  }
  
  public static boolean b(Intent paramIntent) {
    null = true;
    if (paramIntent != null) {
      int i = paramIntent.getIntExtra("plugged", -1);
      if (i != 2) {
        if (i == 1)
          return true; 
      } else {
        return null;
      } 
    } 
    return false;
  }
  
  public static String c() {
    if (!n())
      return null; 
    if (TextUtils.isEmpty(b)) {
      Context context = GDTADManager.getInstance().getAppContext();
      b = b.b.a().b(context);
    } 
    return b;
  }
  
  private static boolean c(int paramInt) throws IOException {
    String str = a(String.format("/proc/%d/cgroup", new Object[] { Integer.valueOf(paramInt) }));
    ak.b("gdt_tag_p", "checkForegroundUseCGroup : cgroup = %s ", new Object[] { str });
    if (!TextUtils.isEmpty(str))
      return (!str.contains("bg_non_interactive") && !str.contains("background")); 
    throw new IOException("No content");
  }
  
  public static boolean c(Context paramContext) {
    if (paramContext != null) {
      KeyguardManager keyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
      if (keyguardManager != null)
        return keyguardManager.inKeyguardRestrictedInputMode(); 
    } 
    return false;
  }
  
  public static Intent d(Context paramContext) {
    Intent intent = null;
    if (paramContext != null)
      try {
        return paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      } catch (Exception exception) {
        return null;
      }  
    return intent;
  }
  
  public static String d() {
    // Byte code:
    //   0: ldc_w '0.0.0.0'
    //   3: astore_1
    //   4: aload_1
    //   5: astore_0
    //   6: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   9: invokevirtual getAppContext : ()Landroid/content/Context;
    //   12: astore_3
    //   13: aload_1
    //   14: astore_0
    //   15: aload_3
    //   16: ldc_w 'connectivity'
    //   19: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast android/net/ConnectivityManager
    //   25: astore #4
    //   27: aload_1
    //   28: astore_2
    //   29: aload #4
    //   31: ifnull -> 248
    //   34: aload_1
    //   35: astore_0
    //   36: aload #4
    //   38: iconst_0
    //   39: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   42: astore_2
    //   43: aload_1
    //   44: astore_0
    //   45: aload #4
    //   47: iconst_1
    //   48: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   51: astore #4
    //   53: aload_2
    //   54: ifnull -> 115
    //   57: aload_1
    //   58: astore_0
    //   59: aload_2
    //   60: invokevirtual isConnected : ()Z
    //   63: ifeq -> 115
    //   66: aload_1
    //   67: astore_0
    //   68: invokestatic p : ()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: astore_0
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore_2
    //   82: aload_1
    //   83: astore_0
    //   84: aload_2
    //   85: ldc_w '移动网络ip地址为：'
    //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_1
    //   93: astore_0
    //   94: aload_2
    //   95: aload_1
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual toString : ()Ljava/lang/String;
    //   106: astore_2
    //   107: aload_1
    //   108: astore_0
    //   109: aload_2
    //   110: invokestatic d : (Ljava/lang/String;)V
    //   113: aload_1
    //   114: areturn
    //   115: aload_1
    //   116: astore_2
    //   117: aload #4
    //   119: ifnull -> 248
    //   122: aload_1
    //   123: astore_2
    //   124: aload_1
    //   125: astore_0
    //   126: aload #4
    //   128: invokevirtual isConnected : ()Z
    //   131: ifeq -> 248
    //   134: aload_1
    //   135: astore_0
    //   136: aload_3
    //   137: ldc_w 'wifi'
    //   140: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   143: checkcast android/net/wifi/WifiManager
    //   146: astore_3
    //   147: aload_1
    //   148: astore_2
    //   149: aload_3
    //   150: ifnull -> 248
    //   153: aload_1
    //   154: astore_0
    //   155: aload_3
    //   156: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   159: astore_3
    //   160: aload_1
    //   161: astore_2
    //   162: aload_3
    //   163: ifnull -> 248
    //   166: aload_1
    //   167: astore_0
    //   168: aload_3
    //   169: invokevirtual getIpAddress : ()I
    //   172: invokestatic a : (I)Ljava/lang/String;
    //   175: astore_1
    //   176: aload_1
    //   177: astore_0
    //   178: new java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial <init> : ()V
    //   185: astore_2
    //   186: aload_1
    //   187: astore_0
    //   188: aload_2
    //   189: ldc_w 'WiFi网络ip地址为：'
    //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_1
    //   197: astore_0
    //   198: aload_2
    //   199: aload_1
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: astore_0
    //   206: aload_2
    //   207: invokevirtual toString : ()Ljava/lang/String;
    //   210: astore_2
    //   211: goto -> 107
    //   214: new java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: astore_1
    //   222: aload_1
    //   223: ldc_w 'Get ip encounter error: '
    //   226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_1
    //   231: aload_2
    //   232: invokevirtual getMessage : ()Ljava/lang/String;
    //   235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: invokevirtual toString : ()Ljava/lang/String;
    //   243: invokestatic d : (Ljava/lang/String;)V
    //   246: aload_0
    //   247: astore_2
    //   248: aload_2
    //   249: areturn
    //   250: astore_2
    //   251: goto -> 214
    // Exception table:
    //   from	to	target	type
    //   6	13	250	java/lang/Exception
    //   15	27	250	java/lang/Exception
    //   36	43	250	java/lang/Exception
    //   45	53	250	java/lang/Exception
    //   59	66	250	java/lang/Exception
    //   68	72	250	java/lang/Exception
    //   74	82	250	java/lang/Exception
    //   84	92	250	java/lang/Exception
    //   94	100	250	java/lang/Exception
    //   102	107	250	java/lang/Exception
    //   109	113	250	java/lang/Exception
    //   126	134	250	java/lang/Exception
    //   136	147	250	java/lang/Exception
    //   155	160	250	java/lang/Exception
    //   168	176	250	java/lang/Exception
    //   178	186	250	java/lang/Exception
    //   188	196	250	java/lang/Exception
    //   198	204	250	java/lang/Exception
    //   206	211	250	java/lang/Exception
  }
  
  public static int e(Context paramContext) {
    String str = f(paramContext);
    if (!TextUtils.isEmpty(str)) {
      if (str.equals("46000") || str.equals("46002") || str.equals("46007") || str.equals("46020"))
        return 1; 
      if (str.equals("46001") || str.equals("46006"))
        return 2; 
      if (str.equals("46003") || str.equals("46005"))
        return 3; 
    } 
    return 0;
  }
  
  public static String e() {
    return b.c.a().b(GDTADManager.getInstance().getAppContext());
  }
  
  public static String f(Context paramContext) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager != null)
        return telephonyManager.getNetworkOperator(); 
    } catch (Exception exception) {
      GDTLogger.w("Get operator failed: ", exception);
    } 
    return "";
  }
  
  public static boolean f() {
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "/system/app/Superuser.apk";
    arrayOfString[1] = "/sbin/su";
    arrayOfString[2] = "/system/bin/su";
    arrayOfString[3] = "/system/xbin/su";
    arrayOfString[4] = "/data/local/xbin/su";
    arrayOfString[5] = "/data/local/bin/su";
    arrayOfString[6] = "/system/sd/xbin/su";
    arrayOfString[7] = "/system/bin/failsafe/su";
    arrayOfString[8] = "/data/local/su";
    arrayOfString[9] = "/su/bin/su";
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if ((new File(arrayOfString[i])).exists())
        return true; 
    } 
    return false;
  }
  
  public static String g() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new java/io/RandomAccessFile
    //   7: dup
    //   8: ldc_w '/proc/version'
    //   11: ldc_w 'r'
    //   14: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: invokevirtual readLine : ()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual close : ()V
    //   31: aload_2
    //   32: areturn
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual printStackTrace : ()V
    //   38: aload_0
    //   39: areturn
    //   40: astore_2
    //   41: goto -> 57
    //   44: astore_2
    //   45: goto -> 116
    //   48: astore_0
    //   49: aload_2
    //   50: astore_1
    //   51: goto -> 177
    //   54: astore_2
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: new java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: astore #4
    //   68: aload_1
    //   69: astore_0
    //   70: aload #4
    //   72: ldc_w 'getProcVersion Exception:'
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_1
    //   80: astore_0
    //   81: aload #4
    //   83: aload_2
    //   84: invokevirtual getMessage : ()Ljava/lang/String;
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: astore_0
    //   93: aload #4
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: invokestatic d : (Ljava/lang/String;)V
    //   101: aload_1
    //   102: ifnull -> 170
    //   105: aload_3
    //   106: astore_0
    //   107: aload_1
    //   108: invokevirtual close : ()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_1
    //   117: astore_0
    //   118: new java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore #4
    //   127: aload_1
    //   128: astore_0
    //   129: aload #4
    //   131: ldc_w 'getProcVersion Exception:'
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: astore_0
    //   140: aload #4
    //   142: aload_2
    //   143: invokevirtual getMessage : ()Ljava/lang/String;
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: astore_0
    //   152: aload #4
    //   154: invokevirtual toString : ()Ljava/lang/String;
    //   157: invokestatic d : (Ljava/lang/String;)V
    //   160: aload_1
    //   161: ifnull -> 170
    //   164: aload_3
    //   165: astore_0
    //   166: aload_1
    //   167: invokevirtual close : ()V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_2
    //   173: aload_0
    //   174: astore_1
    //   175: aload_2
    //   176: astore_0
    //   177: aload_1
    //   178: ifnull -> 193
    //   181: aload_1
    //   182: invokevirtual close : ()V
    //   185: goto -> 193
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual printStackTrace : ()V
    //   193: aload_0
    //   194: athrow
    // Exception table:
    //   from	to	target	type
    //   4	18	113	java/io/FileNotFoundException
    //   4	18	54	java/io/IOException
    //   4	18	48	finally
    //   20	25	44	java/io/FileNotFoundException
    //   20	25	40	java/io/IOException
    //   20	25	172	finally
    //   27	31	33	java/io/IOException
    //   59	68	172	finally
    //   70	79	172	finally
    //   81	91	172	finally
    //   93	101	172	finally
    //   107	111	33	java/io/IOException
    //   118	127	172	finally
    //   129	138	172	finally
    //   140	150	172	finally
    //   152	160	172	finally
    //   166	170	33	java/io/IOException
    //   181	185	188	java/io/IOException
  }
  
  private static boolean g(Context paramContext) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      bool1 = bool2;
      if (list != null) {
        if (list.isEmpty())
          return false; 
        String str = paramContext.getPackageName();
        Iterator<ActivityManager.RunningAppProcessInfo> iterator = list.iterator();
        while (true) {
          bool1 = bool2;
          if (iterator.hasNext()) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
            if (runningAppProcessInfo.importance == 100 && str.equals(runningAppProcessInfo.processName)) {
              bool1 = true;
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
    } 
    return bool1;
  }
  
  public static long h() {
    Context context = GDTADManager.getInstance().getAppContext();
    if (context != null) {
      ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
      if (activityManager != null) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
      } 
    } 
    return -1L;
  }
  
  private static boolean h(Context paramContext) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      String str = paramContext.getPackageName();
      List list = activityManager.getRunningTasks(1);
      bool1 = bool2;
      if (list != null) {
        if (list.isEmpty())
          return false; 
        ComponentName componentName = ((ActivityManager.RunningTaskInfo)list.get(0)).topActivity;
        bool1 = bool2;
        if (componentName != null) {
          bool1 = bool2;
          if (str.equals(componentName.getPackageName()))
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  public static long i() {
    long l1;
    long l2;
    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
    if (Build.VERSION.SDK_INT >= 18) {
      l1 = statFs.getBlockSizeLong();
      l2 = statFs.getBlockCountLong();
    } else {
      l1 = statFs.getBlockSize();
      l2 = statFs.getBlockCount();
    } 
    return l2 * l1;
  }
  
  public static String j() {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      Context context = GDTADManager.getInstance().getAppContext();
      if (context != null)
        return (new WebView(context)).getSettings().getUserAgentString(); 
    } 
    return null;
  }
  
  public static boolean k() {
    StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
    if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length > 0) {
      StackTraceElement stackTraceElement = arrayOfStackTraceElement[arrayOfStackTraceElement.length - 1];
      if (stackTraceElement != null && "de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()))
        return true; 
    } 
    return false;
  }
  
  public static String l() {
    if (TextUtils.isEmpty(c)) {
      Context context = GDTADManager.getInstance().getAppContext();
      if (context != null) {
        String str = b.a.a().a(context);
        if (!TextUtils.isEmpty(str))
          c = str; 
      } 
    } 
    return c;
  }
  
  public static String m() {
    boolean bool = n();
    String str = null;
    if (!bool)
      return null; 
    if (TextUtils.isEmpty(d)) {
      Context context = GDTADManager.getInstance().getAppContext();
      if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
        return null; 
      try {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        if (telephonyManager != null)
          str = telephonyManager.getDeviceId(); 
        if (!TextUtils.isEmpty(str))
          d = Md5Util.encode(str.toLowerCase()); 
      } catch (Exception exception) {}
    } 
    return d;
  }
  
  public static boolean n() {
    return (GDTADManager.getInstance().getSM().getInteger("imeion", 1) == 1);
  }
  
  public static long o() {
    if ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory() != null && Environment.getExternalStorageDirectory().exists())
      try {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = statFs.getBlockSize();
        int i = statFs.getAvailableBlocks();
        return i * l;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return 0L;
  }
  
  private static String p() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration != null && enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && !(inetAddress instanceof java.net.Inet6Address))
            return inetAddress.getHostAddress(); 
        } 
      } 
    } catch (SocketException socketException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get mobile ip address encounter error: ");
      stringBuilder.append(socketException.toString());
      GDTLogger.d(stringBuilder.toString());
    } 
    return "0.0.0.0";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */