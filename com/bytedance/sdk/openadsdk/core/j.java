package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.io.File;
import java.util.List;

public class j {
  private static String a;
  
  private static String b;
  
  private static String c;
  
  private static String d;
  
  private static String e;
  
  private static String f;
  
  private static String g;
  
  private static String h;
  
  private static String i;
  
  private static String j;
  
  private static boolean k;
  
  private static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      if (ac.e()) {
        stringBuilder.append("MIUI-");
      } else if (ac.b()) {
        stringBuilder.append("FLYME-");
      } else {
        String str = ac.n();
        if (ac.a(str))
          stringBuilder.append("EMUI-"); 
        if (!TextUtils.isEmpty(str)) {
          stringBuilder.append(str);
          stringBuilder.append("-");
        } 
      } 
      stringBuilder.append(Build.VERSION.INCREMENTAL);
    } catch (Exception exception) {}
    return stringBuilder.toString();
  }
  
  public static String a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/j.a : Ljava/lang/String;
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifeq -> 40
    //   9: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   12: ifne -> 40
    //   15: ldc com/bytedance/sdk/openadsdk/core/j
    //   17: monitorenter
    //   18: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   21: ifne -> 28
    //   24: aload_0
    //   25: invokestatic l : (Landroid/content/Context;)V
    //   28: ldc com/bytedance/sdk/openadsdk/core/j
    //   30: monitorexit
    //   31: goto -> 40
    //   34: astore_0
    //   35: ldc com/bytedance/sdk/openadsdk/core/j
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: getstatic com/bytedance/sdk/openadsdk/core/j.a : Ljava/lang/String;
    //   43: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   46: ifeq -> 71
    //   49: invokestatic b : ()Z
    //   52: ifeq -> 71
    //   55: aload_0
    //   56: invokestatic k : (Landroid/content/Context;)Landroid/content/Context;
    //   59: invokestatic a : (Landroid/content/Context;)Lcom/bytedance/sdk/openadsdk/core/d;
    //   62: ldc 'did'
    //   64: aconst_null
    //   65: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: putstatic com/bytedance/sdk/openadsdk/core/j.a : Ljava/lang/String;
    //   71: getstatic com/bytedance/sdk/openadsdk/core/j.a : Ljava/lang/String;
    //   74: areturn
    //   75: astore_0
    //   76: goto -> 71
    // Exception table:
    //   from	to	target	type
    //   18	28	34	finally
    //   28	31	34	finally
    //   35	38	34	finally
    //   40	71	75	java/lang/Exception
  }
  
  private static String a(Context paramContext, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/core/j
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic k : (Landroid/content/Context;)Landroid/content/Context;
    //   7: astore #4
    //   9: aload #4
    //   11: ifnonnull -> 19
    //   14: ldc com/bytedance/sdk/openadsdk/core/j
    //   16: monitorexit
    //   17: aconst_null
    //   18: areturn
    //   19: aload #4
    //   21: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   24: ldc 'android_id'
    //   26: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_0
    //   30: goto -> 35
    //   33: aconst_null
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull -> 59
    //   39: aload_0
    //   40: ldc '9774d56d682e549c'
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: ifne -> 59
    //   48: aload_0
    //   49: astore_3
    //   50: aload_0
    //   51: invokevirtual length : ()I
    //   54: bipush #13
    //   56: if_icmpge -> 216
    //   59: aload #4
    //   61: invokestatic a : (Landroid/content/Context;)Lcom/bytedance/sdk/openadsdk/core/d;
    //   64: astore #5
    //   66: aload #5
    //   68: ldc 'openudid'
    //   70: aconst_null
    //   71: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: invokestatic a : (Ljava/lang/String;)Z
    //   79: ifne -> 216
    //   82: new java/math/BigInteger
    //   85: dup
    //   86: bipush #64
    //   88: new java/security/SecureRandom
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: invokespecial <init> : (ILjava/util/Random;)V
    //   98: bipush #16
    //   100: invokevirtual toString : (I)Ljava/lang/String;
    //   103: astore #4
    //   105: aload #4
    //   107: astore_3
    //   108: aload #4
    //   110: iconst_0
    //   111: invokevirtual charAt : (I)C
    //   114: bipush #45
    //   116: if_icmpne -> 126
    //   119: aload #4
    //   121: iconst_1
    //   122: invokevirtual substring : (I)Ljava/lang/String;
    //   125: astore_3
    //   126: bipush #13
    //   128: aload_3
    //   129: invokevirtual length : ()I
    //   132: isub
    //   133: istore_2
    //   134: aload_3
    //   135: astore #4
    //   137: iload_2
    //   138: ifle -> 183
    //   141: new java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: astore #4
    //   150: iload_2
    //   151: ifle -> 169
    //   154: aload #4
    //   156: bipush #70
    //   158: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: iload_2
    //   163: iconst_1
    //   164: isub
    //   165: istore_2
    //   166: goto -> 150
    //   169: aload #4
    //   171: aload_3
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #4
    //   178: invokevirtual toString : ()Ljava/lang/String;
    //   181: astore #4
    //   183: iload_1
    //   184: ifeq -> 237
    //   187: ldc 'openudid.dat'
    //   189: aload #4
    //   191: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   194: astore_3
    //   195: aload_3
    //   196: invokestatic a : (Ljava/lang/String;)Z
    //   199: ifeq -> 237
    //   202: goto -> 205
    //   205: aload #5
    //   207: ldc 'openudid'
    //   209: aload_3
    //   210: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   213: goto -> 216
    //   216: ldc com/bytedance/sdk/openadsdk/core/j
    //   218: monitorexit
    //   219: aload_3
    //   220: areturn
    //   221: astore_0
    //   222: ldc com/bytedance/sdk/openadsdk/core/j
    //   224: monitorexit
    //   225: aload_0
    //   226: athrow
    //   227: astore_0
    //   228: goto -> 33
    //   231: astore_3
    //   232: aload_0
    //   233: astore_3
    //   234: goto -> 216
    //   237: aload #4
    //   239: astore_3
    //   240: goto -> 205
    // Exception table:
    //   from	to	target	type
    //   3	9	221	finally
    //   19	30	227	java/lang/Exception
    //   19	30	221	finally
    //   39	48	231	java/lang/Exception
    //   39	48	221	finally
    //   50	59	231	java/lang/Exception
    //   50	59	221	finally
    //   59	105	231	java/lang/Exception
    //   59	105	221	finally
    //   108	126	231	java/lang/Exception
    //   108	126	221	finally
    //   126	134	231	java/lang/Exception
    //   126	134	221	finally
    //   141	150	231	java/lang/Exception
    //   141	150	221	finally
    //   154	162	231	java/lang/Exception
    //   154	162	221	finally
    //   169	183	231	java/lang/Exception
    //   169	183	221	finally
    //   187	202	231	java/lang/Exception
    //   187	202	221	finally
    //   205	213	231	java/lang/Exception
    //   205	213	221	finally
  }
  
  public static String a(WifiManager paramWifiManager) {
    String str1 = "02:00:00:00:00:00";
    if (paramWifiManager == null)
      return "02:00:00:00:00:00"; 
    String str2 = str1;
    try {
      ScanResult scanResult;
      List<ScanResult> list = paramWifiManager.getScanResults();
      str2 = str1;
      WifiInfo wifiInfo = paramWifiManager.getConnectionInfo();
      String str = str1;
      if (list != null) {
        str = str1;
        if (wifiInfo != null) {
          str = str1;
          str2 = str1;
          if (wifiInfo.getBSSID() != null) {
            int i = 0;
            String str3 = str1;
            while (true) {
              str = str3;
              str2 = str3;
              if (i < list.size()) {
                str2 = str3;
                scanResult = list.get(i);
                str1 = str3;
                str2 = str3;
                if (wifiInfo.getBSSID().equals(scanResult.BSSID)) {
                  str2 = str3;
                  str1 = scanResult.BSSID;
                } 
                i++;
                str3 = str1;
                continue;
              } 
              break;
            } 
          } 
        } 
      } 
      return (String)scanResult;
    } catch (Exception exception) {
      return str2;
    } 
  }
  
  private static String a(String paramString1, String paramString2) {
    if (!"mounted".equals(Environment.getExternalStorageState()))
      return paramString2; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(Environment.getExternalStorageDirectory().getPath());
    stringBuilder1.append("/Android/data/com.snssdk.api/cache");
    String str1 = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append("/");
    stringBuilder1.append(paramString1);
    String str3 = stringBuilder1.toString();
    stringBuilder1 = null;
    paramString1 = null;
    StringBuilder stringBuilder2 = null;
    String str2 = null;
    try {
      File file1 = new File(str1);
      if (!file1.exists() && !file1.mkdirs())
        return paramString2; 
      File file2 = new File(str3);
    } catch (Exception exception1) {
    
    } finally {
      str1 = null;
      StringBuilder stringBuilder = stringBuilder1;
      if (stringBuilder != null)
        try {
          stringBuilder.release();
        } catch (Exception null) {} 
      if (str1 != null)
        try {
          str1.close();
        } catch (Exception exception) {} 
    } 
    if (stringBuilder1 != null)
      try {
        stringBuilder1.release();
      } catch (Exception exception1) {} 
    if (str1 != null)
      try {
        str1.close();
        return (String)exception;
      } catch (Exception exception1) {
        return (String)exception;
      }  
    return (String)exception;
  }
  
  public static void a(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString) && !paramString.equals(a)) {
      d.a(paramContext).a("did", paramString);
      a = paramString;
    } 
    if (!TextUtils.isEmpty(a))
      s.b(a).a(a); 
  }
  
  private static boolean a(String paramString) {
    if (paramString == null)
      return false; 
    int i = paramString.length();
    if (i >= 13) {
      if (i > 128)
        return false; 
      for (int k = 0; k < i; k++) {
        char c = paramString.charAt(k);
        if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F') && c != '-')
          return false; 
      } 
      return true;
    } 
    return false;
  }
  
  public static String b(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/j.h : Ljava/lang/String;
    //   3: ifnonnull -> 37
    //   6: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   9: ifne -> 37
    //   12: ldc com/bytedance/sdk/openadsdk/core/j
    //   14: monitorenter
    //   15: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   18: ifne -> 25
    //   21: aload_0
    //   22: invokestatic l : (Landroid/content/Context;)V
    //   25: ldc com/bytedance/sdk/openadsdk/core/j
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/j
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/j.h : Ljava/lang/String;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   15	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static String c(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/j.b : Ljava/lang/String;
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifeq -> 40
    //   9: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   12: ifne -> 40
    //   15: ldc com/bytedance/sdk/openadsdk/core/j
    //   17: monitorenter
    //   18: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   21: ifne -> 28
    //   24: aload_0
    //   25: invokestatic l : (Landroid/content/Context;)V
    //   28: ldc com/bytedance/sdk/openadsdk/core/j
    //   30: monitorexit
    //   31: goto -> 40
    //   34: astore_0
    //   35: ldc com/bytedance/sdk/openadsdk/core/j
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: getstatic com/bytedance/sdk/openadsdk/core/j.b : Ljava/lang/String;
    //   43: areturn
    // Exception table:
    //   from	to	target	type
    //   18	28	34	finally
    //   28	31	34	finally
    //   35	38	34	finally
  }
  
  public static String d(Context paramContext) {
    // Byte code:
    //   0: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/core/h;
    //   3: invokevirtual d : ()Lcom/bytedance/sdk/openadsdk/TTCustomController;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 23
    //   11: aload_1
    //   12: invokevirtual isCanUsePhoneState : ()Z
    //   15: ifne -> 23
    //   18: aload_1
    //   19: invokevirtual getDevImei : ()Ljava/lang/String;
    //   22: areturn
    //   23: getstatic com/bytedance/sdk/openadsdk/core/j.c : Ljava/lang/String;
    //   26: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   29: ifeq -> 63
    //   32: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   35: ifne -> 63
    //   38: ldc com/bytedance/sdk/openadsdk/core/j
    //   40: monitorenter
    //   41: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   44: ifne -> 51
    //   47: aload_0
    //   48: invokestatic l : (Landroid/content/Context;)V
    //   51: ldc com/bytedance/sdk/openadsdk/core/j
    //   53: monitorexit
    //   54: goto -> 63
    //   57: astore_0
    //   58: ldc com/bytedance/sdk/openadsdk/core/j
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    //   63: getstatic com/bytedance/sdk/openadsdk/core/j.c : Ljava/lang/String;
    //   66: areturn
    // Exception table:
    //   from	to	target	type
    //   41	51	57	finally
    //   51	54	57	finally
    //   58	61	57	finally
  }
  
  public static String e(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/j.i : Ljava/lang/String;
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifeq -> 40
    //   9: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   12: ifne -> 40
    //   15: ldc com/bytedance/sdk/openadsdk/core/j
    //   17: monitorenter
    //   18: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   21: ifne -> 28
    //   24: aload_0
    //   25: invokestatic l : (Landroid/content/Context;)V
    //   28: ldc com/bytedance/sdk/openadsdk/core/j
    //   30: monitorexit
    //   31: goto -> 40
    //   34: astore_0
    //   35: ldc com/bytedance/sdk/openadsdk/core/j
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: getstatic com/bytedance/sdk/openadsdk/core/j.i : Ljava/lang/String;
    //   43: areturn
    // Exception table:
    //   from	to	target	type
    //   18	28	34	finally
    //   28	31	34	finally
    //   35	38	34	finally
  }
  
  public static String f(Context paramContext) {
    // Byte code:
    //   0: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/core/h;
    //   3: invokevirtual d : ()Lcom/bytedance/sdk/openadsdk/TTCustomController;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 20
    //   11: aload_1
    //   12: invokevirtual isCanUsePhoneState : ()Z
    //   15: ifne -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: getstatic com/bytedance/sdk/openadsdk/core/j.f : Ljava/lang/String;
    //   23: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   26: ifeq -> 60
    //   29: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   32: ifne -> 60
    //   35: ldc com/bytedance/sdk/openadsdk/core/j
    //   37: monitorenter
    //   38: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   41: ifne -> 48
    //   44: aload_0
    //   45: invokestatic l : (Landroid/content/Context;)V
    //   48: ldc com/bytedance/sdk/openadsdk/core/j
    //   50: monitorexit
    //   51: goto -> 60
    //   54: astore_0
    //   55: ldc com/bytedance/sdk/openadsdk/core/j
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    //   60: getstatic com/bytedance/sdk/openadsdk/core/j.f : Ljava/lang/String;
    //   63: areturn
    // Exception table:
    //   from	to	target	type
    //   38	48	54	finally
    //   48	51	54	finally
    //   55	58	54	finally
  }
  
  public static String g(Context paramContext) {
    // Byte code:
    //   0: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/core/h;
    //   3: invokevirtual d : ()Lcom/bytedance/sdk/openadsdk/TTCustomController;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 20
    //   11: aload_1
    //   12: invokevirtual isCanUseWifiState : ()Z
    //   15: ifne -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: getstatic com/bytedance/sdk/openadsdk/core/j.d : Ljava/lang/String;
    //   23: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   26: ifeq -> 60
    //   29: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   32: ifne -> 60
    //   35: ldc com/bytedance/sdk/openadsdk/core/j
    //   37: monitorenter
    //   38: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   41: ifne -> 48
    //   44: aload_0
    //   45: invokestatic l : (Landroid/content/Context;)V
    //   48: ldc com/bytedance/sdk/openadsdk/core/j
    //   50: monitorexit
    //   51: goto -> 60
    //   54: astore_0
    //   55: ldc com/bytedance/sdk/openadsdk/core/j
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    //   60: getstatic com/bytedance/sdk/openadsdk/core/j.d : Ljava/lang/String;
    //   63: areturn
    // Exception table:
    //   from	to	target	type
    //   38	48	54	finally
    //   48	51	54	finally
    //   55	58	54	finally
  }
  
  public static String h(Context paramContext) {
    // Byte code:
    //   0: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/core/h;
    //   3: invokevirtual d : ()Lcom/bytedance/sdk/openadsdk/TTCustomController;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 20
    //   11: aload_1
    //   12: invokevirtual isCanUseWifiState : ()Z
    //   15: ifne -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: getstatic com/bytedance/sdk/openadsdk/core/j.e : Ljava/lang/String;
    //   23: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   26: ifeq -> 60
    //   29: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   32: ifne -> 60
    //   35: ldc com/bytedance/sdk/openadsdk/core/j
    //   37: monitorenter
    //   38: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   41: ifne -> 48
    //   44: aload_0
    //   45: invokestatic l : (Landroid/content/Context;)V
    //   48: ldc com/bytedance/sdk/openadsdk/core/j
    //   50: monitorexit
    //   51: goto -> 60
    //   54: astore_0
    //   55: ldc com/bytedance/sdk/openadsdk/core/j
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    //   60: getstatic com/bytedance/sdk/openadsdk/core/j.e : Ljava/lang/String;
    //   63: areturn
    // Exception table:
    //   from	to	target	type
    //   38	48	54	finally
    //   48	51	54	finally
    //   55	58	54	finally
  }
  
  public static String i(Context paramContext) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #28
    //   5: if_icmplt -> 28
    //   8: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/core/h;
    //   11: invokevirtual d : ()Lcom/bytedance/sdk/openadsdk/TTCustomController;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull -> 28
    //   19: aload_1
    //   20: invokevirtual isCanUsePhoneState : ()Z
    //   23: ifne -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: getstatic com/bytedance/sdk/openadsdk/core/j.j : Ljava/lang/String;
    //   31: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   34: ifeq -> 68
    //   37: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   40: ifne -> 68
    //   43: ldc com/bytedance/sdk/openadsdk/core/j
    //   45: monitorenter
    //   46: getstatic com/bytedance/sdk/openadsdk/core/j.k : Z
    //   49: ifne -> 56
    //   52: aload_0
    //   53: invokestatic l : (Landroid/content/Context;)V
    //   56: ldc com/bytedance/sdk/openadsdk/core/j
    //   58: monitorexit
    //   59: goto -> 68
    //   62: astore_0
    //   63: ldc com/bytedance/sdk/openadsdk/core/j
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: getstatic com/bytedance/sdk/openadsdk/core/j.j : Ljava/lang/String;
    //   71: areturn
    // Exception table:
    //   from	to	target	type
    //   46	56	62	finally
    //   56	59	62	finally
    //   63	66	62	finally
  }
  
  public static void j(Context paramContext) {
    if (!TextUtils.isEmpty(c))
      return; 
    paramContext = k(paramContext);
    if (paramContext == null)
      return; 
    try {
      m(paramContext);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static Context k(Context paramContext) {
    Context context = paramContext;
    if (paramContext == null)
      context = o.a(); 
    return context;
  }
  
  private static void l(Context paramContext) {
    if (k)
      return; 
    Context context = k(paramContext);
    if (context == null)
      return; 
    try {
      m(context);
    } catch (Exception exception) {}
    try {
      TTCustomController tTCustomController = h.c().d();
      if (tTCustomController != null && tTCustomController.isCanUseWifiState()) {
        boolean bool = tTCustomController.isCanUseLocation();
        if (bool)
          try {
            WifiManager wifiManager = (WifiManager)context.getSystemService("wifi");
            if (wifiManager != null) {
              WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            } else {
              tTCustomController = null;
            } 
            if (tTCustomController != null)
              d = tTCustomController.getSSID(); 
            e = a(wifiManager);
          } finally {} 
      } 
      if (Build.VERSION.SDK_INT >= 28) {
        j = Build.getSerial();
      } else {
        j = Build.SERIAL;
      } 
    } catch (Exception exception) {}
    b = a(context, true);
    a = d.a(context).b("did", (String)null);
    g = a();
    h = String.valueOf(Build.TIME);
    i = d.a(context).b("uuid", (String)null);
    k = true;
  }
  
  private static void m(Context paramContext) {
    TTCustomController tTCustomController = h.c().d();
    if (tTCustomController != null && !tTCustomController.isCanUsePhoneState())
      return; 
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (telephonyManager != null) {
      c = telephonyManager.getDeviceId();
      f = telephonyManager.getSubscriberId();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */