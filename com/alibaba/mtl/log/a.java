package com.alibaba.mtl.log;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.b.a;
import com.alibaba.mtl.log.c.c;
import com.alibaba.mtl.log.d.a;
import com.alibaba.mtl.log.e.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.model.a;
import com.alibaba.mtl.log.sign.IRequestAuth;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
  public static String B;
  
  public static IRequestAuth a;
  
  private static boolean a = false;
  
  public static long b = -1L;
  
  public static final AtomicInteger d;
  
  private static Context mContext;
  
  public static boolean o = false;
  
  public static boolean p = false;
  
  private static boolean q = false;
  
  public static boolean r = false;
  
  public static int s = 10000;
  
  public static int t;
  
  static {
    boolean bool;
    if (t <= s) {
      bool = true;
    } else {
      bool = false;
    } 
    q = bool;
    B = String.valueOf(System.currentTimeMillis());
    d = new AtomicInteger(0);
    r = true;
    a = null;
  }
  
  public static IRequestAuth a() {
    boolean bool = a;
    if (bool == null || TextUtils.isEmpty(bool.getAppkey())) {
      if (!i.n()) {
        Log.w("UTDC", "please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
        return a;
      } 
    } else {
      return a;
    } 
    throw new RuntimeException("please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
  }
  
  public static void a(IRequestAuth paramIRequestAuth) {
    a = paramIRequestAuth;
    boolean bool = a;
    if (bool != null)
      b.o(bool.getAppkey()); 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap) {
    if (mContext == null) {
      i.a("UTDC", "please call UTDC.init(context) before commit log,and this log will be discarded");
      return;
    } 
    if (a == null) {
      i.a("UTDC", "please call UTDC.setRequestAuthentication(auth) before commit log,and this log will be discarded");
      return;
    } 
    i.a("UTDC", new Object[] { 
          "[commit] page:", paramString1, "eventId:", paramString2, "arg1:", paramString3, "arg2:", paramString4, "arg3:", paramString5, 
          "args:", paramMap });
    a.l(paramString2);
    a a1 = new a(paramString1, paramString2, paramString3, paramString4, paramString5, paramMap);
    c.a().a(a1);
  }
  
  public static String b() {
    try {
      return l.getNetworkState(getContext())[0];
    } catch (Exception exception) {
      return "Unknown";
    } 
  }
  
  public static String c() {
    String str = "Unknown";
    try {
      String[] arrayOfString = l.getNetworkState(getContext());
      if (arrayOfString[0].equals("2G/3G"))
        str = arrayOfString[1]; 
      return str;
    } catch (Exception exception) {
      return "Unknown";
    } 
  }
  
  public static String d() {
    return "";
  }
  
  public static String e() {
    return "";
  }
  
  public static Context getContext() {
    return mContext;
  }
  
  public static void init(Context paramContext) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/log/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull -> 41
    //   7: new java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc 'UTDC init failed ,context:'
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_1
    //   23: aload_0
    //   24: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc 'UTDC'
    //   30: aload_1
    //   31: invokevirtual toString : ()Ljava/lang/String;
    //   34: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   37: ldc com/alibaba/mtl/log/a
    //   39: monitorexit
    //   40: return
    //   41: getstatic com/alibaba/mtl/log/a.a : Z
    //   44: ifne -> 64
    //   47: iconst_1
    //   48: putstatic com/alibaba/mtl/log/a.a : Z
    //   51: aload_0
    //   52: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   55: putstatic com/alibaba/mtl/log/a.mContext : Landroid/content/Context;
    //   58: invokestatic a : ()Lcom/alibaba/mtl/log/d/a;
    //   61: invokevirtual start : ()V
    //   64: ldc com/alibaba/mtl/log/a
    //   66: monitorexit
    //   67: return
    //   68: astore_0
    //   69: ldc com/alibaba/mtl/log/a
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   7	37	68	finally
    //   41	64	68	finally
  }
  
  public static void l() {
    i.a("UTDC", new Object[] { "[onBackground]" });
    o = true;
    a.E();
  }
  
  public static void m() {
    i.a("UTDC", new Object[] { "[onForeground]" });
    o = false;
    a.a().start();
  }
  
  public static void n() {
    a.a().start();
  }
  
  public static void setChannel(String paramString) {
    b.n(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */