package com.amap.api.mapcore2d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Hashtable;
import java.util.Random;
import org.json.JSONObject;

public final class gy {
  static WifiManager a;
  
  private static int b;
  
  private static String[] c;
  
  private static Hashtable<String, Long> d = new Hashtable<String, Long>();
  
  private static SparseArray<String> e = null;
  
  private static String[] f = new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  
  private static String g = "android.permission.ACCESS_BACKGROUND_LOCATION";
  
  private static boolean h;
  
  static {
    a = null;
    h = false;
  }
  
  public static double a(double paramDouble) {
    return (long)(paramDouble * 1000000.0D) / 1000000.0D;
  }
  
  public static float a(float paramFloat) {
    return (float)((long)(paramFloat * 100.0D) / 100.0D);
  }
  
  public static float a(double[] paramArrayOfdouble) {
    if (paramArrayOfdouble.length != 4)
      return 0.0F; 
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
      gu.a((Throwable)paramContext, "Utils", "getServ");
    } 
  }
  
  public static boolean a(Context paramContext) {
    if (paramContext == null)
      return false; 
    try {
      return (c() < 17) ? b(paramContext, "android.provider.Settings$System") : b(paramContext, "android.provider.Settings$Global");
    } finally {
      paramContext = null;
    } 
  }
  
  public static boolean a(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ("00:00:00:00:00:00".equals(paramString) ? false : (!paramString.contains(" :")));
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString) {
    return db.a(paramJSONObject, paramString);
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
    for (int i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = (byte)(int)(paramLong >> i * 8 & 0xFFL); 
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    try {
      return db.b(paramArrayOfbyte);
    } finally {
      paramArrayOfbyte = null;
      gu.a((Throwable)paramArrayOfbyte, "Utils", "gz");
    } 
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
      gu.a((Throwable)paramTelephonyManager, "Utils", "getMccMnc");
    } 
    return arrayOfString;
  }
  
  public static double b(double paramDouble) {
    return (long)(paramDouble * 100.0D) / 100.0D;
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
    if (!TextUtils.isEmpty(gu.g))
      return gu.g; 
    CharSequence charSequence = null;
    if (paramContext == null)
      return null; 
    String str2 = cq.c(paramContext);
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str2, 64);
    } finally {
      str2 = null;
      gu.a((Throwable)str2, "Utils", "getAppName part");
    } 
    String str1 = cq.c(paramContext);
    if (!TextUtils.isEmpty(str1)) {
      stringBuilder.append(",");
      stringBuilder.append(str1);
    } 
    if (!TextUtils.isEmpty(gu.h)) {
      stringBuilder.append(",");
      stringBuilder.append(gu.h);
    } 
    str1 = stringBuilder.toString();
    gu.g = str1;
    return str1;
  }
  
  public static String b(TelephonyManager paramTelephonyManager) {
    SparseArray<String> sparseArray = e;
    int i = 0;
    if (sparseArray == null) {
      sparseArray = new SparseArray();
      e = sparseArray;
      sparseArray.append(0, "UNKWN");
      e.append(1, "GPRS");
      e.append(2, "EDGE");
      e.append(3, "UMTS");
      e.append(4, "CDMA");
      e.append(5, "EVDO_0");
      e.append(6, "EVDO_A");
      e.append(7, "1xRTT");
      e.append(8, "HSDPA");
      e.append(9, "HSUPA");
      e.append(10, "HSPA");
      e.append(11, "IDEN");
      e.append(12, "EVDO_B");
      e.append(13, "LTE");
      e.append(14, "EHRPD");
      e.append(15, "HSPAP");
    } 
    if (paramTelephonyManager != null)
      i = paramTelephonyManager.getNetworkType(); 
    return (String)e.get(i, "UNKWN");
  }
  
  private static boolean b(Context paramContext, String paramString) throws Throwable {
    return (((Integer)gw.a(paramString, "getInt", new Object[] { paramContext.getContentResolver(), ((String)gw.a(paramString, "AIRPLANE_MODE_ON")).toString() }new Class[] { ContentResolver.class, String.class })).intValue() == 1);
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
    return a(d(paramString), (byte[])null);
  }
  
  public static int c() {
    int i = b;
    if (i > 0)
      return i; 
    try {
      return gw.b("android.os.Build$VERSION", "SDK_INT");
    } finally {
      Exception exception = null;
    } 
  }
  
  public static boolean c(Context paramContext) {
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
          return "true".equals(String.valueOf(gw.a(a, "isScanAlwaysAvailable", new Object[0])));
        } finally {
          paramContext = null;
        }  
    } 
    return bool2;
  }
  
  public static byte[] c(String paramString) {
    return b(d(paramString), (byte[])null);
  }
  
  public static int d(String paramString) throws NumberFormatException {
    return Integer.parseInt(paramString);
  }
  
  public static String d() {
    return Build.MODEL;
  }
  
  public static String d(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic m : (Landroid/content/Context;)Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   9: ifne -> 23
    //   12: aload_2
    //   13: astore_1
    //   14: aload_2
    //   15: ldc '00:00:00:00:00:00'
    //   17: invokevirtual equals : (Ljava/lang/Object;)Z
    //   20: ifeq -> 28
    //   23: aload_0
    //   24: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_2
    //   30: aload_1
    //   31: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   34: ifeq -> 40
    //   37: ldc '00:00:00:00:00:00'
    //   39: astore_2
    //   40: getstatic com/amap/api/mapcore2d/gy.h : Z
    //   43: ifne -> 55
    //   46: aload_0
    //   47: aload_2
    //   48: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   51: iconst_1
    //   52: putstatic com/amap/api/mapcore2d/gy.h : Z
    //   55: aload_2
    //   56: areturn
  }
  
  public static byte e(String paramString) throws NumberFormatException {
    return Byte.parseByte(paramString);
  }
  
  public static String e() {
    return Build.VERSION.RELEASE;
  }
  
  public static boolean e(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 28 && (paramContext.getApplicationInfo()).targetSdkVersion >= 28);
  }
  
  public static int f() {
    return (new Random()).nextInt(65536) - 32768;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */