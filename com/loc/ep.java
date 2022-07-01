package com.loc;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONObject;

public final class ep {
  static WifiManager a;
  
  private static int b;
  
  private static String[] c;
  
  private static String[] d = new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  
  private static String e = "android.permission.ACCESS_BACKGROUND_LOCATION";
  
  private static boolean f;
  
  static {
    a = null;
    f = false;
  }
  
  public static double a(double paramDouble) {
    return b(paramDouble);
  }
  
  public static float a(float paramFloat) {
    return (float)((long)(paramFloat * 100.0D) / 100.0D);
  }
  
  public static float a(AMapLocation paramAMapLocation1, AMapLocation paramAMapLocation2) {
    return a(new double[] { paramAMapLocation1.getLatitude(), paramAMapLocation1.getLongitude(), paramAMapLocation2.getLatitude(), paramAMapLocation2.getLongitude() });
  }
  
  public static float a(DPoint paramDPoint1, DPoint paramDPoint2) {
    return a(new double[] { paramDPoint1.getLatitude(), paramDPoint1.getLongitude(), paramDPoint2.getLatitude(), paramDPoint2.getLongitude() });
  }
  
  public static float a(double[] paramArrayOfdouble) {
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(paramArrayOfdouble[0], paramArrayOfdouble[1], paramArrayOfdouble[2], paramArrayOfdouble[3], arrayOfFloat);
    return arrayOfFloat[0];
  }
  
  public static int a(int paramInt) {
    return paramInt * 2 - 113;
  }
  
  public static int a(NetworkInfo paramNetworkInfo) {
    return (paramNetworkInfo == null) ? -1 : (!paramNetworkInfo.isAvailable() ? -1 : (!paramNetworkInfo.isConnected() ? -1 : paramNetworkInfo.getType()));
  }
  
  public static long a() {
    return System.currentTimeMillis();
  }
  
  public static Object a(Context paramContext, String paramString) {
    if (paramContext == null)
      return null; 
    try {
      return paramContext.getApplicationContext().getSystemService(paramString);
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "Utils", "getServ");
    } 
  }
  
  public static String a(long paramLong, String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "yyyy-MM-dd HH:mm:ss"; 
    try {
    
    } finally {
      str = null;
      paramString = null;
    } 
    long l = paramLong;
    if (paramLong <= 0L)
      l = System.currentTimeMillis(); 
    return (paramString == null) ? "NULL" : paramString.format(Long.valueOf(l));
  }
  
  public static boolean a(Context paramContext) {
    if (paramContext == null)
      return false; 
    try {
      return (c() < 17) ? c(paramContext, "android.provider.Settings$System") : c(paramContext, "android.provider.Settings$Global");
    } finally {
      paramContext = null;
    } 
  }
  
  public static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: ldc '2.0.201501131131'
    //   11: ldc '.'
    //   13: ldc ''
    //   15: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   18: astore #8
    //   20: aconst_null
    //   21: astore #7
    //   23: aload_0
    //   24: ifnull -> 211
    //   27: iconst_1
    //   28: istore_3
    //   29: iconst_1
    //   30: istore #5
    //   32: iconst_1
    //   33: istore #4
    //   35: aload #7
    //   37: astore #6
    //   39: aload_0
    //   40: invokevirtual isOpen : ()Z
    //   43: ifne -> 48
    //   46: iconst_0
    //   47: ireturn
    //   48: aload #7
    //   50: astore #6
    //   52: new java/lang/StringBuilder
    //   55: dup
    //   56: ldc 'type = 'table' AND name = ''
    //   58: invokespecial <init> : (Ljava/lang/String;)V
    //   61: astore #9
    //   63: aload #7
    //   65: astore #6
    //   67: aload #9
    //   69: aload_1
    //   70: invokevirtual trim : ()Ljava/lang/String;
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload #7
    //   79: astore #6
    //   81: aload #9
    //   83: aload #8
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload #7
    //   91: astore #6
    //   93: aload #9
    //   95: ldc '''
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload #7
    //   103: astore #6
    //   105: aload #9
    //   107: invokevirtual toString : ()Ljava/lang/String;
    //   110: astore_1
    //   111: aload #7
    //   113: astore #6
    //   115: aload_0
    //   116: ldc 'sqlite_master'
    //   118: iconst_1
    //   119: anewarray java/lang/String
    //   122: dup
    //   123: iconst_0
    //   124: ldc 'count(*) as c'
    //   126: aastore
    //   127: aload_1
    //   128: aconst_null
    //   129: aconst_null
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull -> 176
    //   140: aload_0
    //   141: astore #6
    //   143: aload_0
    //   144: invokeinterface moveToFirst : ()Z
    //   149: ifeq -> 176
    //   152: aload_0
    //   153: astore #6
    //   155: aload_0
    //   156: iconst_0
    //   157: invokeinterface getInt : (I)I
    //   162: istore_2
    //   163: iload_2
    //   164: ifle -> 176
    //   167: iload #4
    //   169: istore_3
    //   170: goto -> 178
    //   173: goto -> 193
    //   176: iconst_0
    //   177: istore_3
    //   178: iload_3
    //   179: istore #4
    //   181: aload_0
    //   182: ifnull -> 208
    //   185: aload_0
    //   186: invokeinterface close : ()V
    //   191: iload_3
    //   192: ireturn
    //   193: iload #5
    //   195: istore #4
    //   197: aload #6
    //   199: ifnull -> 208
    //   202: aload #6
    //   204: astore_0
    //   205: goto -> 185
    //   208: iload #4
    //   210: ireturn
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_0
    //   214: goto -> 173
    // Exception table:
    //   from	to	target	type
    //   39	46	213	finally
    //   52	63	213	finally
    //   67	77	213	finally
    //   81	89	213	finally
    //   93	101	213	finally
    //   105	111	213	finally
    //   115	136	213	finally
    //   143	152	213	finally
    //   155	163	213	finally
  }
  
  public static boolean a(Location paramLocation, int paramInt) {
    boolean bool;
    Boolean bool2 = Boolean.valueOf(false);
    Boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 18)
      try {
        bool1 = (Boolean)em.a(paramLocation, "isFromMockProvider", new Object[0]);
      } finally {
        bool1 = null;
      }  
    if (bool1.booleanValue())
      return true; 
    Bundle bundle = paramLocation.getExtras();
    if (bundle != null) {
      bool = bundle.getInt("satellites");
    } else {
      bool = false;
    } 
    return bool ? true : ((paramInt == 0 && paramLocation.getAltitude() == 0.0D && paramLocation.getBearing() == 0.0F && paramLocation.getSpeed() == 0.0F));
  }
  
  public static boolean a(AMapLocation paramAMapLocation) {
    return (paramAMapLocation == null) ? false : ((paramAMapLocation.getErrorCode() != 0) ? false : b(paramAMapLocation));
  }
  
  public static boolean a(ds paramds) {
    return (paramds == null) ? false : ("8".equals(paramds.d()) ? false : ("5".equals(paramds.d()) ? false : ("6".equals(paramds.d()) ? false : b(paramds))));
  }
  
  public static boolean a(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ("00:00:00:00:00:00".equals(paramString) ? false : (!paramString.contains(" :")));
  }
  
  public static boolean a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 146
    //   7: aload_1
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: ifeq -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokestatic d : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual toString : ()Ljava/lang/String;
    //   25: ldc_w '#'
    //   28: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   31: astore_1
    //   32: iconst_0
    //   33: istore_3
    //   34: iconst_0
    //   35: istore #4
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_3
    //   40: aload_1
    //   41: arraylength
    //   42: if_icmpge -> 122
    //   45: aload_1
    //   46: iload_3
    //   47: aaload
    //   48: ldc_w ',nb'
    //   51: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   54: ifne -> 76
    //   57: iload #4
    //   59: istore #5
    //   61: iload_2
    //   62: istore #6
    //   64: aload_1
    //   65: iload_3
    //   66: aaload
    //   67: ldc_w ',access'
    //   70: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   73: ifeq -> 108
    //   76: iload #4
    //   78: iconst_1
    //   79: iadd
    //   80: istore #4
    //   82: iload #4
    //   84: istore #5
    //   86: iload_2
    //   87: istore #6
    //   89: aload_0
    //   90: aload_1
    //   91: iload_3
    //   92: aaload
    //   93: invokevirtual contains : (Ljava/lang/Object;)Z
    //   96: ifeq -> 108
    //   99: iload_2
    //   100: iconst_1
    //   101: iadd
    //   102: istore #6
    //   104: iload #4
    //   106: istore #5
    //   108: iload_3
    //   109: iconst_1
    //   110: iadd
    //   111: istore_3
    //   112: iload #5
    //   114: istore #4
    //   116: iload #6
    //   118: istore_2
    //   119: goto -> 39
    //   122: aload_0
    //   123: invokevirtual size : ()I
    //   126: istore_3
    //   127: iload_2
    //   128: iconst_2
    //   129: imul
    //   130: i2d
    //   131: iload_3
    //   132: iload #4
    //   134: iadd
    //   135: i2d
    //   136: ldc2_w 0.618
    //   139: dmul
    //   140: dcmpl
    //   141: iflt -> 146
    //   144: iconst_1
    //   145: ireturn
    //   146: iconst_0
    //   147: ireturn
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString) {
    return u.a(paramJSONObject, paramString);
  }
  
  public static byte[] a(int paramInt, byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      byte[] arrayOfByte1 = paramArrayOfbyte;
      if (paramArrayOfbyte.length < 2) {
        arrayOfByte1 = new byte[2];
        arrayOfByte1[0] = (byte)(paramInt & 0xFF);
        arrayOfByte1[1] = (byte)((paramInt & 0xFF00) >> 8);
        return arrayOfByte1;
      } 
      arrayOfByte1[0] = (byte)(paramInt & 0xFF);
      arrayOfByte1[1] = (byte)((paramInt & 0xFF00) >> 8);
      return arrayOfByte1;
    } 
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = (byte)(paramInt & 0xFF);
    arrayOfByte[1] = (byte)((paramInt & 0xFF00) >> 8);
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong) {
    byte[] arrayOfByte = new byte[8];
    for (int i = 0; i < 8; i++)
      arrayOfByte[i] = (byte)(int)(paramLong >> i * 8 & 0xFFL); 
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    return u.b(paramArrayOfbyte);
  }
  
  public static String[] a(TelephonyManager paramTelephonyManager) {
    int i;
    if (paramTelephonyManager != null) {
      String str = paramTelephonyManager.getNetworkOperator();
    } else {
      paramTelephonyManager = null;
    } 
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    if (TextUtils.isEmpty((CharSequence)paramTelephonyManager) || !TextUtils.isDigitsOnly((CharSequence)paramTelephonyManager) || paramTelephonyManager.length() <= 4) {
      i = 0;
    } else {
      i = 1;
    } 
    if (i) {
      arrayOfString[0] = paramTelephonyManager.substring(0, 3);
      char[] arrayOfChar = paramTelephonyManager.substring(3).toCharArray();
      for (i = 0; i < arrayOfChar.length && Character.isDigit(arrayOfChar[i]); i++);
      arrayOfString[1] = paramTelephonyManager.substring(3, i + 3);
    } 
    try {
      i = Integer.parseInt(arrayOfString[0]);
    } finally {
      paramTelephonyManager = null;
      ej.a((Throwable)paramTelephonyManager, "Utils", "getMccMnc");
    } 
    return arrayOfString;
  }
  
  public static double b(double paramDouble) {
    return (long)(paramDouble * 1000000.0D) / 1000000.0D;
  }
  
  public static int b(byte[] paramArrayOfbyte) {
    int i = 0;
    int j = 0;
    while (i < 2) {
      j |= (paramArrayOfbyte[i] & 0xFF) << (1 - i) * 8;
      i++;
    } 
    return j;
  }
  
  public static long b() {
    return SystemClock.elapsedRealtime();
  }
  
  public static String b(int paramInt) {
    String str = "其他错误";
    switch (paramInt) {
      default:
        return "其他错误";
      case 19:
        return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
      case 18:
        return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
      case 15:
        return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
      case 14:
        return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
      case 13:
        return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
      case 12:
        return "缺少定位权限";
      case 11:
        return "错误的基站信息，请检查是否插入SIM卡";
      case 10:
        return "定位服务启动失败";
      case 9:
        return "初始化异常";
      case 7:
        return "KEY错误";
      case 6:
        return "定位结果错误";
      case 5:
        return "解析数据异常";
      case 4:
        return "网络连接异常";
      case 3:
        return "请求参数获取出现异常";
      case 2:
        return "WIFI信息不足";
      case 1:
        return "重要参数为空";
      case 0:
        str = "success";
        break;
      case 8:
        break;
    } 
    return str;
  }
  
  public static String b(Context paramContext) {
    StringBuilder stringBuilder;
    if (!TextUtils.isEmpty(ej.h))
      return ej.h; 
    CharSequence charSequence = null;
    if (paramContext == null)
      return null; 
    String str2 = k.c(paramContext);
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str2, 64);
    } finally {
      str2 = null;
      ej.a((Throwable)str2, "Utils", "getAppName part");
    } 
    String str1 = k.c(paramContext);
    if (!TextUtils.isEmpty(str1)) {
      stringBuilder.append(",");
      stringBuilder.append(str1);
    } 
    if (!TextUtils.isEmpty(ej.i)) {
      stringBuilder.append(",");
      stringBuilder.append(ej.i);
    } 
    str1 = stringBuilder.toString();
    ej.h = str1;
    return str1;
  }
  
  public static String b(TelephonyManager paramTelephonyManager) {
    byte b = 0;
    int i = b;
    if (paramTelephonyManager != null)
      try {
        i = paramTelephonyManager.getNetworkType();
      } finally {
        paramTelephonyManager = null;
      }  
    String str = "UNKWN";
    switch (i) {
      default:
        return "UNKWN";
      case 15:
        return "HSPAP";
      case 14:
        return "EHRPD";
      case 13:
        return "LTE";
      case 12:
        return "EVDO_B";
      case 11:
        return "IDEN";
      case 10:
        return "HSPA";
      case 9:
        return "HSUPA";
      case 8:
        return "HSDPA";
      case 7:
        return "1xRTT";
      case 6:
        return "EVDO_A";
      case 5:
        return "EVDO_0";
      case 4:
        return "CDMA";
      case 3:
        return "UMTS";
      case 2:
        return "EDGE";
      case 1:
        str = "GPRS";
        break;
      case 0:
        break;
    } 
    return str;
  }
  
  public static boolean b(Context paramContext, String paramString) {
    PackageManager packageManager = paramContext.getApplicationContext().getPackageManager();
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 256);
    } finally {
      packageManager = null;
    } 
  }
  
  public static boolean b(AMapLocation paramAMapLocation) {
    double d1 = paramAMapLocation.getLongitude();
    double d2 = paramAMapLocation.getLatitude();
    boolean bool2 = false;
    if (d1 == 0.0D && d2 == 0.0D)
      return false; 
    boolean bool1 = bool2;
    if (d1 <= 180.0D) {
      if (d2 > 90.0D)
        return false; 
      bool1 = bool2;
      if (d1 >= -180.0D) {
        if (d2 < -90.0D)
          return false; 
        bool1 = true;
      } 
    } 
    return bool1;
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 12
    //   4: aload_1
    //   5: astore_3
    //   6: aload_1
    //   7: arraylength
    //   8: iconst_4
    //   9: if_icmpge -> 16
    //   12: iconst_4
    //   13: newarray byte
    //   15: astore_3
    //   16: iconst_0
    //   17: istore_2
    //   18: iload_2
    //   19: aload_3
    //   20: arraylength
    //   21: if_icmpge -> 45
    //   24: aload_3
    //   25: iload_2
    //   26: iload_0
    //   27: iload_2
    //   28: bipush #8
    //   30: imul
    //   31: ishr
    //   32: sipush #255
    //   35: iand
    //   36: i2b
    //   37: bastore
    //   38: iload_2
    //   39: iconst_1
    //   40: iadd
    //   41: istore_2
    //   42: goto -> 18
    //   45: aload_3
    //   46: areturn
  }
  
  public static byte[] b(String paramString) {
    return a(Integer.parseInt(paramString), (byte[])null);
  }
  
  public static double c(double paramDouble) {
    return (long)(paramDouble * 100.0D) / 100.0D;
  }
  
  public static int c() {
    int i = b;
    if (i > 0)
      return i; 
    try {
      return em.b("android.os.Build$VERSION", "SDK_INT");
    } finally {
      Exception exception = null;
    } 
  }
  
  public static NetworkInfo c(Context paramContext) {
    try {
      return n.r(paramContext);
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "Utils", "getNetWorkInfo");
    } 
  }
  
  private static boolean c(Context paramContext, String paramString) throws Throwable {
    return (((Integer)em.a(paramString, "getInt", new Object[] { paramContext.getContentResolver(), ((String)em.a(paramString, "AIRPLANE_MODE_ON")).toString() }new Class[] { ContentResolver.class, String.class })).intValue() == 1);
  }
  
  public static byte[] c(String paramString) {
    return b(Integer.parseInt(paramString), (byte[])null);
  }
  
  public static int d() {
    return (new Random()).nextInt(65536) - 32768;
  }
  
  public static ArrayList<String> d(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      String[] arrayOfString = paramString.split("#");
      for (int i = 0; i < arrayOfString.length; i++) {
        if (arrayOfString[i].contains(",nb") || arrayOfString[i].contains(",access"))
          arrayList.add(arrayOfString[i]); 
      } 
    } 
    return arrayList;
  }
  
  public static boolean d(Context paramContext) {
    try {
      NetworkInfo networkInfo = c(paramContext);
      return false;
    } finally {
      paramContext = null;
    } 
  }
  
  public static double e(String paramString) throws NumberFormatException {
    return Double.parseDouble(paramString);
  }
  
  public static String e() {
    try {
      return o.b("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
    } finally {
      Exception exception = null;
    } 
  }
  
  public static boolean e(Context paramContext) {
    try {
      return false;
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "Utils", "isApplicationBroughtToBackground");
    } 
  }
  
  public static float f(String paramString) throws NumberFormatException {
    return Float.parseFloat(paramString);
  }
  
  public static boolean f(Context paramContext) {
    Application application;
    if (Build.VERSION.SDK_INT >= 23 && (paramContext.getApplicationInfo()).targetSdkVersion >= 23) {
      application = (Application)paramContext;
      String[] arrayOfString1 = d;
      int m = arrayOfString1.length;
      int k = 0;
      while (true) {
        if (k < m) {
          boolean bool;
          String str = arrayOfString1[k];
          try {
            bool = em.b(application.getBaseContext(), "checkSelfPermission", new Object[] { str });
          } finally {
            str = null;
          } 
          k++;
          continue;
        } 
        return true;
      } 
    } 
    String[] arrayOfString = d;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (application.checkCallingOrSelfPermission(arrayOfString[i]) != 0)
        return false; 
    } 
    return true;
  }
  
  public static int g(String paramString) throws NumberFormatException {
    return Integer.parseInt(paramString);
  }
  
  public static boolean g(Context paramContext) {
    int i = (paramContext.getApplicationInfo()).targetSdkVersion;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i >= 29) {
      Application application = (Application)paramContext;
      try {
        i = em.b(application.getBaseContext(), "checkSelfPermission", new Object[] { e });
      } finally {
        application = null;
      } 
      if (i != 0)
        bool1 = false; 
    } 
    return bool1;
  }
  
  public static int h(String paramString) throws NumberFormatException {
    return Integer.parseInt(paramString, 16);
  }
  
  public static boolean h(Context paramContext) {
    boolean bool1;
    boolean bool2;
    if (paramContext == null)
      return true; 
    if (a == null)
      a = (WifiManager)a(paramContext, "wifi"); 
    try {
      bool1 = a.isWifiEnabled();
    } finally {
      paramContext = null;
    } 
    if (!bool1) {
      bool2 = bool1;
      if (c() > 17)
        try {
          return "true".equals(String.valueOf(em.a(a, "isScanAlwaysAvailable", new Object[0])));
        } finally {
          paramContext = null;
        }  
    } 
    return bool2;
  }
  
  public static byte i(String paramString) throws NumberFormatException {
    return Byte.parseByte(paramString);
  }
  
  public static String i(Context paramContext) {
    String str1;
    NetworkInfo networkInfo = c(paramContext);
    if (networkInfo == null || !networkInfo.isConnectedOrConnecting())
      return "DISCONNECTED"; 
    int i = networkInfo.getType();
    String str2 = "3G";
    if (i == 1)
      return "WIFI"; 
    if (i == 0) {
      String str = networkInfo.getSubtypeName();
      str1 = str2;
      switch (networkInfo.getSubtype()) {
        default:
          if (!"GSM".equalsIgnoreCase(str)) {
            str1 = str2;
            if (!"TD-SCDMA".equalsIgnoreCase(str)) {
              str1 = str2;
              if (!"WCDMA".equalsIgnoreCase(str))
                return "CDMA2000".equalsIgnoreCase(str) ? "3G" : str; 
            } 
            break;
          } 
        case 13:
          return "4G";
        case 1:
        case 2:
        case 4:
        case 7:
        case 11:
        case 16:
          return "2G";
        case 3:
        case 5:
        case 6:
        case 8:
        case 9:
        case 10:
        case 12:
        case 14:
        case 15:
        case 17:
          break;
      } 
    } else {
      str1 = "UNKNOWN";
    } 
    return str1;
  }
  
  public static String j(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic m : (Landroid/content/Context;)Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   9: ifne -> 24
    //   12: aload_2
    //   13: astore_1
    //   14: aload_2
    //   15: ldc_w '00:00:00:00:00:00'
    //   18: invokevirtual equals : (Ljava/lang/Object;)Z
    //   21: ifeq -> 49
    //   24: aload_0
    //   25: ifnonnull -> 35
    //   28: ldc_w '00:00:00:00:00:00'
    //   31: astore_1
    //   32: goto -> 49
    //   35: aload_0
    //   36: ldc_w 'pref'
    //   39: ldc_w 'smac'
    //   42: ldc_w '00:00:00:00:00:00'
    //   45: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload_1
    //   52: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   55: ifeq -> 62
    //   58: ldc_w '00:00:00:00:00:00'
    //   61: astore_2
    //   62: getstatic com/loc/ep.f : Z
    //   65: ifne -> 103
    //   68: aload_0
    //   69: ifnull -> 99
    //   72: aload_2
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifne -> 99
    //   79: aload_0
    //   80: ldc_w 'pref'
    //   83: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   86: astore_0
    //   87: aload_0
    //   88: ldc_w 'smac'
    //   91: aload_2
    //   92: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: invokestatic a : (Landroid/content/SharedPreferences$Editor;)V
    //   99: iconst_1
    //   100: putstatic com/loc/ep.f : Z
    //   103: aload_2
    //   104: areturn
  }
  
  public static boolean k(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 28 && (paramContext.getApplicationInfo()).targetSdkVersion >= 28);
  }
  
  public static boolean l(Context paramContext) {
    try {
      ComponentName componentName = new ComponentName(paramContext, "com.amap.api.location.APSService");
      ServiceInfo serviceInfo = paramContext.getPackageManager().getServiceInfo(componentName, 128);
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */