package com.tencent.bugly.yaq.proguard;

import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;

public final class y {
  public static boolean a;
  
  private static SimpleDateFormat b = null;
  
  private static int c;
  
  private static StringBuilder d;
  
  private static StringBuilder e;
  
  private static boolean f;
  
  private static a g;
  
  private static String h;
  
  private static String i;
  
  private static Context j;
  
  private static String k;
  
  private static boolean l;
  
  private static boolean m;
  
  private static int n;
  
  private static final Object o;
  
  static {
    a = true;
    c = 5120;
    m = false;
    o = new Object();
    try {
      b = new SimpleDateFormat("MM-dd HH:mm:ss");
    } catch (Throwable throwable) {}
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(int paramInt) {
    synchronized (o) {
      c = paramInt;
      if (paramInt < 0) {
        c = 0;
        throw new VerifyError("bad dex opcode");
      } 
      if (paramInt > 10240)
        c = 10240; 
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/y
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/y.l : Z
    //   6: ifne -> 21
    //   9: aload_0
    //   10: ifnull -> 21
    //   13: getstatic com/tencent/bugly/yaq/proguard/y.a : Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne -> 34
    //   21: ldc com/tencent/bugly/yaq/proguard/y
    //   23: monitorexit
    //   24: new java/lang/VerifyError
    //   27: dup
    //   28: ldc 'bad dex opcode'
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: athrow
    //   34: new java/lang/StringBuilder
    //   37: dup
    //   38: iconst_0
    //   39: invokespecial <init> : (I)V
    //   42: putstatic com/tencent/bugly/yaq/proguard/y.e : Ljava/lang/StringBuilder;
    //   45: new java/lang/StringBuilder
    //   48: dup
    //   49: iconst_0
    //   50: invokespecial <init> : (I)V
    //   53: putstatic com/tencent/bugly/yaq/proguard/y.d : Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: putstatic com/tencent/bugly/yaq/proguard/y.j : Landroid/content/Context;
    //   60: aload_0
    //   61: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/yaq/crashreport/common/info/a;
    //   64: pop
    //   65: new java/lang/VerifyError
    //   68: dup
    //   69: ldc 'bad dex opcode'
    //   71: invokespecial <init> : (Ljava/lang/String;)V
    //   74: athrow
    //   75: iconst_1
    //   76: putstatic com/tencent/bugly/yaq/proguard/y.l : Z
    //   79: goto -> 21
    //   82: astore_0
    //   83: ldc com/tencent/bugly/yaq/proguard/y
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    //   88: astore_0
    //   89: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   3	9	82	finally
    //   13	17	82	finally
    //   34	75	88	java/lang/Throwable
    //   34	75	82	finally
    //   75	79	82	finally
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/y
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/y.l : Z
    //   6: ifeq -> 17
    //   9: getstatic com/tencent/bugly/yaq/proguard/y.a : Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifne -> 30
    //   17: ldc com/tencent/bugly/yaq/proguard/y
    //   19: monitorexit
    //   20: new java/lang/VerifyError
    //   23: dup
    //   24: ldc 'bad dex opcode'
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: athrow
    //   30: getstatic com/tencent/bugly/yaq/proguard/y.m : Z
    //   33: ifeq -> 45
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   42: ifne -> 17
    //   45: invokestatic myTid : ()I
    //   48: i2l
    //   49: lstore #4
    //   51: getstatic com/tencent/bugly/yaq/proguard/y.d : Ljava/lang/StringBuilder;
    //   54: astore_0
    //   55: new java/lang/VerifyError
    //   58: dup
    //   59: ldc 'bad dex opcode'
    //   61: invokespecial <init> : (Ljava/lang/String;)V
    //   64: athrow
    //   65: astore_0
    //   66: ldc com/tencent/bugly/yaq/proguard/y
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	65	finally
    //   30	45	65	finally
    //   45	65	65	finally
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    if (paramThrowable == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(boolean paramBoolean) {
    new StringBuilder("[LogUtil] Whether can record user log into native: ");
    throw new VerifyError("bad dex opcode");
  }
  
  public static byte[] a() {
    if (!a)
      return null; 
    if (m) {
      x.a("[LogUtil] Get user log from native.", new Object[0]);
      if (f() != null) {
        Object[] arrayOfObject = new Object[1];
        throw new VerifyError("bad dex opcode");
      } 
    } 
    new StringBuilder();
    synchronized (o) {
      if (g != null && a.d(g) && a.a(g) != null) {
        a.a(g);
        throw new VerifyError("bad dex opcode");
      } 
      if (e != null) {
        StringBuilder stringBuilder = e;
        throw new VerifyError("bad dex opcode");
      } 
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3) {
    try {
      if (com.tencent.bugly.yaq.crashreport.common.info.a.b() != null)
        throw new VerifyError("bad dex opcode"); 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
    } 
    return false;
  }
  
  private static String f() {
    try {
      if (com.tencent.bugly.yaq.crashreport.common.info.a.b() != null)
        throw new VerifyError("bad dex opcode"); 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
    } 
    return null;
  }
  
  public static final class a {
    private boolean a;
    
    private File b;
    
    private String c;
    
    private long d;
    
    private long e;
    
    public a(String param1String) {
      throw new VerifyError("bad dex opcode");
    }
    
    private boolean a() {
      try {
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {
        x.a(throwable);
        throw new VerifyError("bad dex opcode");
      } 
    }
    
    public final boolean a(String param1String) {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */