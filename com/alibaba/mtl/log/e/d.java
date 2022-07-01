package com.alibaba.mtl.log.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alibaba.mtl.log.b;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

public class d {
  private static Map<String, String> t;
  
  public static Map<String, String> a(Context paramContext) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/e/d
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   6: ifnull -> 122
    //   9: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   12: getstatic com/alibaba/mtl/log/model/LogField.CHANNEL : Lcom/alibaba/mtl/log/model/LogField;
    //   15: invokevirtual toString : ()Ljava/lang/String;
    //   18: invokestatic l : ()Ljava/lang/String;
    //   21: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: pop
    //   27: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   30: getstatic com/alibaba/mtl/log/model/LogField.APPKEY : Lcom/alibaba/mtl/log/model/LogField;
    //   33: invokevirtual toString : ()Ljava/lang/String;
    //   36: invokestatic getAppkey : ()Ljava/lang/String;
    //   39: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_0
    //   46: invokestatic getImei : (Landroid/content/Context;)Ljava/lang/String;
    //   49: astore_1
    //   50: aload_0
    //   51: invokestatic getImsi : (Landroid/content/Context;)Ljava/lang/String;
    //   54: astore_3
    //   55: aload_1
    //   56: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   59: ifne -> 478
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   68: ifeq -> 74
    //   71: goto -> 478
    //   74: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   77: getstatic com/alibaba/mtl/log/model/LogField.IMEI : Lcom/alibaba/mtl/log/model/LogField;
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: aload_1
    //   84: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   93: getstatic com/alibaba/mtl/log/model/LogField.IMSI : Lcom/alibaba/mtl/log/model/LogField;
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: aload_2
    //   100: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   109: aload_0
    //   110: invokestatic a : (Ljava/util/Map;Landroid/content/Context;)V
    //   113: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   116: astore_0
    //   117: ldc com/alibaba/mtl/log/e/d
    //   119: monitorexit
    //   120: aload_0
    //   121: areturn
    //   122: new java/util/HashMap
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: putstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   132: aload_0
    //   133: ifnull -> 463
    //   136: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull -> 454
    //   144: aload_0
    //   145: invokestatic getImei : (Landroid/content/Context;)Ljava/lang/String;
    //   148: astore_1
    //   149: aload_0
    //   150: invokestatic getImsi : (Landroid/content/Context;)Ljava/lang/String;
    //   153: astore_3
    //   154: aload_1
    //   155: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   158: ifne -> 487
    //   161: aload_3
    //   162: astore_2
    //   163: aload_3
    //   164: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   167: ifeq -> 173
    //   170: goto -> 487
    //   173: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   176: getstatic com/alibaba/mtl/log/model/LogField.IMEI : Lcom/alibaba/mtl/log/model/LogField;
    //   179: invokevirtual toString : ()Ljava/lang/String;
    //   182: aload_1
    //   183: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   192: getstatic com/alibaba/mtl/log/model/LogField.IMSI : Lcom/alibaba/mtl/log/model/LogField;
    //   195: invokevirtual toString : ()Ljava/lang/String;
    //   198: aload_2
    //   199: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: pop
    //   205: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   208: getstatic com/alibaba/mtl/log/model/LogField.BRAND : Lcom/alibaba/mtl/log/model/LogField;
    //   211: invokevirtual toString : ()Ljava/lang/String;
    //   214: getstatic android/os/Build.BRAND : Ljava/lang/String;
    //   217: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   222: pop
    //   223: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   226: getstatic com/alibaba/mtl/log/model/LogField.DEVICE_MODEL : Lcom/alibaba/mtl/log/model/LogField;
    //   229: invokevirtual toString : ()Ljava/lang/String;
    //   232: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   235: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   240: pop
    //   241: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   244: getstatic com/alibaba/mtl/log/model/LogField.RESOLUTION : Lcom/alibaba/mtl/log/model/LogField;
    //   247: invokevirtual toString : ()Ljava/lang/String;
    //   250: aload_0
    //   251: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   254: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   263: getstatic com/alibaba/mtl/log/model/LogField.CHANNEL : Lcom/alibaba/mtl/log/model/LogField;
    //   266: invokevirtual toString : ()Ljava/lang/String;
    //   269: invokestatic l : ()Ljava/lang/String;
    //   272: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   277: pop
    //   278: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   281: getstatic com/alibaba/mtl/log/model/LogField.APPKEY : Lcom/alibaba/mtl/log/model/LogField;
    //   284: invokevirtual toString : ()Ljava/lang/String;
    //   287: invokestatic getAppkey : ()Ljava/lang/String;
    //   290: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: pop
    //   296: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   299: getstatic com/alibaba/mtl/log/model/LogField.APPVERSION : Lcom/alibaba/mtl/log/model/LogField;
    //   302: invokevirtual toString : ()Ljava/lang/String;
    //   305: aload_0
    //   306: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
    //   309: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   314: pop
    //   315: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   318: getstatic com/alibaba/mtl/log/model/LogField.LANGUAGE : Lcom/alibaba/mtl/log/model/LogField;
    //   321: invokevirtual toString : ()Ljava/lang/String;
    //   324: aload_0
    //   325: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   328: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   333: pop
    //   334: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   337: getstatic com/alibaba/mtl/log/model/LogField.OS : Lcom/alibaba/mtl/log/model/LogField;
    //   340: invokevirtual toString : ()Ljava/lang/String;
    //   343: invokestatic p : ()Ljava/lang/String;
    //   346: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   351: pop
    //   352: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   355: getstatic com/alibaba/mtl/log/model/LogField.OSVERSION : Lcom/alibaba/mtl/log/model/LogField;
    //   358: invokevirtual toString : ()Ljava/lang/String;
    //   361: invokestatic o : ()Ljava/lang/String;
    //   364: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   369: pop
    //   370: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   373: getstatic com/alibaba/mtl/log/model/LogField.SDKVERSION : Lcom/alibaba/mtl/log/model/LogField;
    //   376: invokevirtual toString : ()Ljava/lang/String;
    //   379: ldc '2.5.1.3_for_bc'
    //   381: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: pop
    //   387: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   390: getstatic com/alibaba/mtl/log/model/LogField.SDKTYPE : Lcom/alibaba/mtl/log/model/LogField;
    //   393: invokevirtual toString : ()Ljava/lang/String;
    //   396: ldc 'mini'
    //   398: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   403: pop
    //   404: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   407: getstatic com/alibaba/mtl/log/model/LogField.UTDID : Lcom/alibaba/mtl/log/model/LogField;
    //   410: invokevirtual toString : ()Ljava/lang/String;
    //   413: aload_0
    //   414: invokestatic getUtdid : (Landroid/content/Context;)Ljava/lang/String;
    //   417: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   422: pop
    //   423: goto -> 439
    //   426: astore_1
    //   427: ldc 'DeviceUtil'
    //   429: ldc 'utdid4all jar doesn't exist, please copy the libs folder.'
    //   431: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   434: pop
    //   435: aload_1
    //   436: invokevirtual printStackTrace : ()V
    //   439: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   442: aload_0
    //   443: invokestatic a : (Ljava/util/Map;Landroid/content/Context;)V
    //   446: goto -> 454
    //   449: ldc com/alibaba/mtl/log/e/d
    //   451: monitorexit
    //   452: aconst_null
    //   453: areturn
    //   454: getstatic com/alibaba/mtl/log/e/d.t : Ljava/util/Map;
    //   457: astore_0
    //   458: ldc com/alibaba/mtl/log/e/d
    //   460: monitorexit
    //   461: aload_0
    //   462: areturn
    //   463: ldc com/alibaba/mtl/log/e/d
    //   465: monitorexit
    //   466: aconst_null
    //   467: areturn
    //   468: astore_0
    //   469: ldc com/alibaba/mtl/log/e/d
    //   471: monitorexit
    //   472: aload_0
    //   473: athrow
    //   474: astore_0
    //   475: goto -> 449
    //   478: ldc ''
    //   480: astore_1
    //   481: ldc ''
    //   483: astore_2
    //   484: goto -> 74
    //   487: ldc ''
    //   489: astore_1
    //   490: ldc ''
    //   492: astore_2
    //   493: goto -> 173
    // Exception table:
    //   from	to	target	type
    //   3	62	468	finally
    //   64	71	468	finally
    //   74	117	468	finally
    //   122	132	468	finally
    //   136	140	468	finally
    //   144	161	474	java/lang/Exception
    //   144	161	468	finally
    //   163	170	474	java/lang/Exception
    //   163	170	468	finally
    //   173	404	474	java/lang/Exception
    //   173	404	468	finally
    //   404	423	426	finally
    //   427	439	474	java/lang/Exception
    //   427	439	468	finally
    //   439	446	474	java/lang/Exception
    //   439	446	468	finally
    //   454	458	468	finally
  }
  
  private static void a(Map<String, String> paramMap, Context paramContext) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic getNetworkState : (Landroid/content/Context;)[Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: getstatic com/alibaba/mtl/log/model/LogField.ACCESS : Lcom/alibaba/mtl/log/model/LogField;
    //   9: invokevirtual toString : ()Ljava/lang/String;
    //   12: aload_2
    //   13: iconst_0
    //   14: aaload
    //   15: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   20: pop
    //   21: aload_2
    //   22: iconst_0
    //   23: aaload
    //   24: ldc '2G/3G'
    //   26: invokevirtual equals : (Ljava/lang/Object;)Z
    //   29: ifeq -> 51
    //   32: aload_0
    //   33: getstatic com/alibaba/mtl/log/model/LogField.ACCESS_SUBTYPE : Lcom/alibaba/mtl/log/model/LogField;
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: aload_2
    //   40: iconst_1
    //   41: aaload
    //   42: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: goto -> 99
    //   51: aload_0
    //   52: getstatic com/alibaba/mtl/log/model/LogField.ACCESS_SUBTYPE : Lcom/alibaba/mtl/log/model/LogField;
    //   55: invokevirtual toString : ()Ljava/lang/String;
    //   58: ldc 'Unknown'
    //   60: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: goto -> 99
    //   69: aload_0
    //   70: getstatic com/alibaba/mtl/log/model/LogField.ACCESS : Lcom/alibaba/mtl/log/model/LogField;
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: ldc 'Unknown'
    //   78: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload_0
    //   85: getstatic com/alibaba/mtl/log/model/LogField.ACCESS_SUBTYPE : Lcom/alibaba/mtl/log/model/LogField;
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: ldc 'Unknown'
    //   93: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: aload_1
    //   100: ldc 'phone'
    //   102: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   105: checkcast android/telephony/TelephonyManager
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull -> 162
    //   113: aload_1
    //   114: invokevirtual getSimState : ()I
    //   117: iconst_5
    //   118: if_icmpne -> 162
    //   121: aload_1
    //   122: invokevirtual getNetworkOperatorName : ()Ljava/lang/String;
    //   125: astore_1
    //   126: goto -> 129
    //   129: aload_1
    //   130: astore_2
    //   131: aload_1
    //   132: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   135: ifeq -> 141
    //   138: ldc 'Unknown'
    //   140: astore_2
    //   141: aload_0
    //   142: getstatic com/alibaba/mtl/log/model/LogField.CARRIER : Lcom/alibaba/mtl/log/model/LogField;
    //   145: invokevirtual toString : ()Ljava/lang/String;
    //   148: aload_2
    //   149: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: pop
    //   155: return
    //   156: astore_2
    //   157: goto -> 69
    //   160: astore_0
    //   161: return
    //   162: ldc ''
    //   164: astore_1
    //   165: goto -> 129
    // Exception table:
    //   from	to	target	type
    //   0	48	156	java/lang/Exception
    //   51	66	156	java/lang/Exception
    //   99	109	160	java/lang/Exception
    //   113	126	160	java/lang/Exception
    //   131	138	160	java/lang/Exception
    //   141	155	160	java/lang/Exception
  }
  
  private static String b(Context paramContext) {
    try {
      return Locale.getDefault().getLanguage();
    } finally {
      paramContext = null;
    } 
  }
  
  private static String c(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      int m = displayMetrics.widthPixels;
      int k = displayMetrics.heightPixels;
      int j = m;
      int i = k;
      if (m > k) {
        j = m ^ k;
        i = k ^ j;
        j ^= i;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("*");
      stringBuilder.append(j);
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "Unknown";
    } 
  }
  
  public static String c(String paramString) {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return (String)clazz.getMethod("get", new Class[] { String.class }).invoke(clazz.newInstance(), new Object[] { paramString });
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String d(Context paramContext) {
    String str = b.a().getAppVersion();
    if (!TextUtils.isEmpty(str))
      return str; 
    str = "Unknown";
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str1 = str;
      return str1;
    } finally {
      paramContext = null;
    } 
  }
  
  public static boolean k() {
    return ((System.getProperty("java.vm.name") != null && System.getProperty("java.vm.name").toLowerCase().contains("lemur")) || System.getProperty("ro.yunos.version") != null || !TextUtils.isEmpty(q.get("ro.yunos.build.version"))) ? true : l();
  }
  
  private static boolean l() {
    return (!TextUtils.isEmpty(c("ro.yunos.product.chip")) || !TextUtils.isEmpty(c("ro.yunos.hardware")));
  }
  
  private static String o() {
    String str = Build.VERSION.RELEASE;
    if (k()) {
      System.getProperty("ro.yunos.version");
      String str1 = s();
      str = str1;
      if (!TextUtils.isEmpty(str1));
    } 
    return str;
  }
  
  private static String p() {
    return (k() && !l()) ? "y" : "a";
  }
  
  public static String q() {
    String str2 = q.get("ro.aliyun.clouduuid", "false");
    String str1 = str2;
    if ("false".equals(str2))
      str1 = q.get("ro.sys.aliyun.clouduuid", "false"); 
    return TextUtils.isEmpty(str1) ? r() : str1;
  }
  
  private static String r() {
    try {
      return (String)Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static String s() {
    try {
      Field field = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
      if (field != null) {
        field.setAccessible(true);
        return (String)field.get(new String());
      } 
    } catch (Exception exception) {}
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */