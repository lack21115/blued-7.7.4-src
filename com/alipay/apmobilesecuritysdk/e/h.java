package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.c.a;

public class h {
  private static String a = "";
  
  public static long a(Context paramContext) {
    String str = a.a(paramContext, "vkeyid_settings", "update_time_interval");
    boolean bool = a.b(str);
    long l = 86400000L;
    if (bool)
      try {
        return Long.parseLong(str);
      } catch (Exception exception) {
        return 86400000L;
      }  
    return l;
  }
  
  public static void a(Context paramContext, String paramString) {
    a(paramContext, "update_time_interval", paramString);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder("vkey_valid");
    stringBuilder.append(paramString);
    a.a(paramContext, "vkeyid_settings", stringBuilder.toString(), String.valueOf(paramLong));
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2) {
    a.a(paramContext, "vkeyid_settings", paramString1, paramString2);
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    } 
    a(paramContext, "log_switch", str);
  }
  
  public static String b(Context paramContext) {
    return a.a(paramContext, "vkeyid_settings", "last_apdid_env");
  }
  
  public static void b(Context paramContext, String paramString) {
    a(paramContext, "last_machine_boot_time", paramString);
  }
  
  public static void c(Context paramContext, String paramString) {
    a(paramContext, "last_apdid_env", paramString);
  }
  
  public static boolean c(Context paramContext) {
    String str = a.a(paramContext, "vkeyid_settings", "log_switch");
    return (str != null && "1".equals(str));
  }
  
  public static String d(Context paramContext) {
    return a.a(paramContext, "vkeyid_settings", "dynamic_key");
  }
  
  public static void d(Context paramContext, String paramString) {
    a(paramContext, "agent_switch", paramString);
  }
  
  public static String e(Context paramContext) {
    return a.a(paramContext, "vkeyid_settings", "apse_degrade");
  }
  
  public static void e(Context paramContext, String paramString) {
    a(paramContext, "dynamic_key", paramString);
  }
  
  public static String f(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/h
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/h.a : Ljava/lang/String;
    //   6: invokestatic a : (Ljava/lang/String;)Z
    //   9: ifeq -> 88
    //   12: aload_0
    //   13: ldc 'alipay_vkey_random'
    //   15: ldc 'random'
    //   17: ldc ''
    //   19: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: putstatic com/alipay/apmobilesecuritysdk/e/h.a : Ljava/lang/String;
    //   27: aload_1
    //   28: invokestatic a : (Ljava/lang/String;)Z
    //   31: ifeq -> 88
    //   34: invokestatic randomUUID : ()Ljava/util/UUID;
    //   37: invokevirtual toString : ()Ljava/lang/String;
    //   40: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   43: putstatic com/alipay/apmobilesecuritysdk/e/h.a : Ljava/lang/String;
    //   46: getstatic com/alipay/apmobilesecuritysdk/e/h.a : Ljava/lang/String;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull -> 88
    //   54: aload_0
    //   55: ldc 'alipay_vkey_random'
    //   57: iconst_0
    //   58: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   61: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   66: astore_0
    //   67: aload_0
    //   68: ifnull -> 88
    //   71: aload_0
    //   72: ldc 'random'
    //   74: aload_1
    //   75: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   80: pop
    //   81: aload_0
    //   82: invokeinterface commit : ()Z
    //   87: pop
    //   88: getstatic com/alipay/apmobilesecuritysdk/e/h.a : Ljava/lang/String;
    //   91: astore_0
    //   92: ldc com/alipay/apmobilesecuritysdk/e/h
    //   94: monitorexit
    //   95: aload_0
    //   96: areturn
    //   97: astore_0
    //   98: ldc com/alipay/apmobilesecuritysdk/e/h
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    // Exception table:
    //   from	to	target	type
    //   3	50	97	finally
    //   54	67	97	finally
    //   71	88	97	finally
    //   88	95	97	finally
    //   98	101	97	finally
  }
  
  public static void f(Context paramContext, String paramString) {
    a(paramContext, "webrtc_url", paramString);
  }
  
  public static void g(Context paramContext, String paramString) {
    a(paramContext, "apse_degrade", paramString);
  }
  
  public static long h(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder("vkey_valid");
      stringBuilder.append(paramString);
      return a.a(str) ? 0L : Long.parseLong(str);
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */