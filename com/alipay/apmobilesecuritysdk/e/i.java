package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class i {
  private static String a = "";
  
  private static String b = "";
  
  private static String c = "";
  
  private static String d = "";
  
  private static String e = "";
  
  private static Map<String, String> f = new HashMap<String, String>();
  
  public static String a(String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: dup
    //   7: ldc 'apdidTokenCache'
    //   9: invokespecial <init> : (Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual toString : ()Ljava/lang/String;
    //   23: astore_0
    //   24: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   27: aload_0
    //   28: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   33: ifeq -> 63
    //   36: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   39: aload_0
    //   40: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast java/lang/String
    //   48: astore_0
    //   49: aload_0
    //   50: invokestatic b : (Ljava/lang/String;)Z
    //   53: istore_1
    //   54: iload_1
    //   55: ifeq -> 63
    //   58: ldc com/alipay/apmobilesecuritysdk/e/i
    //   60: monitorexit
    //   61: aload_0
    //   62: areturn
    //   63: ldc com/alipay/apmobilesecuritysdk/e/i
    //   65: monitorexit
    //   66: ldc ''
    //   68: areturn
    //   69: astore_0
    //   70: ldc com/alipay/apmobilesecuritysdk/e/i
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Exception table:
    //   from	to	target	type
    //   3	54	69	finally
  }
  
  public static void a() {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/i}} */
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/i}} */
  }
  
  public static void a(b paramb) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 37
    //   7: aload_0
    //   8: getfield a : Ljava/lang/String;
    //   11: putstatic com/alipay/apmobilesecuritysdk/e/i.a : Ljava/lang/String;
    //   14: aload_0
    //   15: getfield b : Ljava/lang/String;
    //   18: putstatic com/alipay/apmobilesecuritysdk/e/i.b : Ljava/lang/String;
    //   21: aload_0
    //   22: getfield c : Ljava/lang/String;
    //   25: putstatic com/alipay/apmobilesecuritysdk/e/i.c : Ljava/lang/String;
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/alipay/apmobilesecuritysdk/e/i
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: ldc com/alipay/apmobilesecuritysdk/e/i
    //   39: monitorexit
    //   40: return
    // Exception table:
    //   from	to	target	type
    //   7	28	31	finally
  }
  
  public static void a(c paramc) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 51
    //   7: aload_0
    //   8: getfield a : Ljava/lang/String;
    //   11: putstatic com/alipay/apmobilesecuritysdk/e/i.a : Ljava/lang/String;
    //   14: aload_0
    //   15: getfield b : Ljava/lang/String;
    //   18: putstatic com/alipay/apmobilesecuritysdk/e/i.b : Ljava/lang/String;
    //   21: aload_0
    //   22: getfield d : Ljava/lang/String;
    //   25: putstatic com/alipay/apmobilesecuritysdk/e/i.d : Ljava/lang/String;
    //   28: aload_0
    //   29: getfield e : Ljava/lang/String;
    //   32: putstatic com/alipay/apmobilesecuritysdk/e/i.e : Ljava/lang/String;
    //   35: aload_0
    //   36: getfield c : Ljava/lang/String;
    //   39: putstatic com/alipay/apmobilesecuritysdk/e/i.c : Ljava/lang/String;
    //   42: goto -> 51
    //   45: astore_0
    //   46: ldc com/alipay/apmobilesecuritysdk/e/i
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    //   51: ldc com/alipay/apmobilesecuritysdk/e/i
    //   53: monitorexit
    //   54: return
    // Exception table:
    //   from	to	target	type
    //   7	42	45	finally
  }
  
  public static void a(String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: dup
    //   7: ldc 'apdidTokenCache'
    //   9: invokespecial <init> : (Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual toString : ()Ljava/lang/String;
    //   23: astore_0
    //   24: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   27: aload_0
    //   28: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   33: ifeq -> 46
    //   36: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   39: aload_0
    //   40: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   45: pop
    //   46: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   49: aload_0
    //   50: aload_1
    //   51: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: ldc com/alipay/apmobilesecuritysdk/e/i
    //   59: monitorexit
    //   60: return
    //   61: astore_0
    //   62: ldc com/alipay/apmobilesecuritysdk/e/i
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   3	46	61	finally
    //   46	57	61	finally
  }
  
  public static boolean a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: ldc2_w 86400000
    //   6: lstore_2
    //   7: aload_0
    //   8: invokestatic a : (Landroid/content/Context;)J
    //   11: lstore #4
    //   13: lload #4
    //   15: lconst_0
    //   16: lcmp
    //   17: ifge -> 23
    //   20: goto -> 26
    //   23: lload #4
    //   25: lstore_2
    //   26: invokestatic currentTimeMillis : ()J
    //   29: aload_0
    //   30: aload_1
    //   31: invokestatic h : (Landroid/content/Context;Ljava/lang/String;)J
    //   34: lsub
    //   35: invokestatic abs : (J)J
    //   38: lstore #4
    //   40: lload #4
    //   42: lload_2
    //   43: lcmp
    //   44: ifge -> 61
    //   47: iconst_1
    //   48: istore #6
    //   50: ldc com/alipay/apmobilesecuritysdk/e/i
    //   52: monitorexit
    //   53: iload #6
    //   55: ireturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokestatic a : (Ljava/lang/Throwable;)V
    //   61: iconst_0
    //   62: istore #6
    //   64: goto -> 50
    //   67: astore_0
    //   68: ldc com/alipay/apmobilesecuritysdk/e/i
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    //   73: astore #7
    //   75: goto -> 26
    // Exception table:
    //   from	to	target	type
    //   7	13	73	finally
    //   26	40	56	finally
    //   57	61	67	finally
  }
  
  public static String b() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.a : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void b(String paramString) {
    a = paramString;
  }
  
  public static String c() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.b : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void c(String paramString) {
    b = paramString;
  }
  
  public static String d() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.d : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void d(String paramString) {
    c = paramString;
  }
  
  public static String e() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.e : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void e(String paramString) {
    d = paramString;
  }
  
  public static String f() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.c : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void f(String paramString) {
    e = paramString;
  }
  
  public static c g() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: new com/alipay/apmobilesecuritysdk/e/c
    //   6: dup
    //   7: getstatic com/alipay/apmobilesecuritysdk/e/i.a : Ljava/lang/String;
    //   10: getstatic com/alipay/apmobilesecuritysdk/e/i.b : Ljava/lang/String;
    //   13: getstatic com/alipay/apmobilesecuritysdk/e/i.c : Ljava/lang/String;
    //   16: getstatic com/alipay/apmobilesecuritysdk/e/i.d : Ljava/lang/String;
    //   19: getstatic com/alipay/apmobilesecuritysdk/e/i.e : Ljava/lang/String;
    //   22: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   25: astore_0
    //   26: ldc com/alipay/apmobilesecuritysdk/e/i
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/alipay/apmobilesecuritysdk/e/i
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	26	31	finally
  }
  
  public static void h() {
    f.clear();
    a = "";
    b = "";
    d = "";
    e = "";
    c = "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */