package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

public final class y {
  public static boolean a = true;
  
  private static boolean b = true;
  
  private static SimpleDateFormat c;
  
  private static int d = 30720;
  
  private static StringBuilder e;
  
  private static StringBuilder f;
  
  private static boolean g = false;
  
  private static a h;
  
  private static String i;
  
  private static String j;
  
  private static Context k;
  
  private static String l;
  
  private static boolean m = false;
  
  private static boolean n = false;
  
  private static ExecutorService o;
  
  private static int p;
  
  private static final Object q = new Object();
  
  static {
    try {
      return;
    } finally {
      Exception exception = null;
      x.b(exception.getCause());
    } 
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, long paramLong) {
    String str1;
    e.setLength(0);
    String str2 = paramString3;
    if (paramString3.length() > 30720)
      str2 = paramString3.substring(paramString3.length() - 30720, paramString3.length() - 1); 
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = c;
    if (simpleDateFormat != null) {
      str1 = simpleDateFormat.format(date);
    } else {
      str1 = str1.toString();
    } 
    StringBuilder stringBuilder = e;
    stringBuilder.append(str1);
    stringBuilder.append(" ");
    stringBuilder.append(p);
    stringBuilder.append(" ");
    stringBuilder.append(paramLong);
    stringBuilder.append(" ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" ");
    stringBuilder.append(paramString2);
    stringBuilder.append(": ");
    stringBuilder.append(str2);
    stringBuilder.append("\001\r\n");
    return e.toString();
  }
  
  public static void a(int paramInt) {
    synchronized (q) {
      d = paramInt;
      if (paramInt < 0) {
        d = 0;
      } else if (paramInt > 30720) {
        d = 30720;
      } 
      return;
    } 
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/y
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/y.m : Z
    //   6: ifne -> 158
    //   9: aload_0
    //   10: ifnull -> 158
    //   13: getstatic com/tencent/bugly/proguard/y.a : Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne -> 24
    //   21: goto -> 158
    //   24: invokestatic newSingleThreadExecutor : ()Ljava/util/concurrent/ExecutorService;
    //   27: putstatic com/tencent/bugly/proguard/y.o : Ljava/util/concurrent/ExecutorService;
    //   30: new java/lang/StringBuilder
    //   33: dup
    //   34: iconst_0
    //   35: invokespecial <init> : (I)V
    //   38: putstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: iconst_0
    //   46: invokespecial <init> : (I)V
    //   49: putstatic com/tencent/bugly/proguard/y.e : Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: putstatic com/tencent/bugly/proguard/y.k : Landroid/content/Context;
    //   56: aload_0
    //   57: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   60: astore_0
    //   61: aload_0
    //   62: getfield d : Ljava/lang/String;
    //   65: putstatic com/tencent/bugly/proguard/y.i : Ljava/lang/String;
    //   68: aload_0
    //   69: invokevirtual getClass : ()Ljava/lang/Class;
    //   72: pop
    //   73: ldc ''
    //   75: putstatic com/tencent/bugly/proguard/y.j : Ljava/lang/String;
    //   78: new java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: astore_0
    //   86: aload_0
    //   87: getstatic com/tencent/bugly/proguard/y.k : Landroid/content/Context;
    //   90: invokevirtual getFilesDir : ()Ljava/io/File;
    //   93: invokevirtual getPath : ()Ljava/lang/String;
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_0
    //   101: ldc '/buglylog_'
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_0
    //   108: getstatic com/tencent/bugly/proguard/y.i : Ljava/lang/String;
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_0
    //   116: ldc '_'
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_0
    //   123: getstatic com/tencent/bugly/proguard/y.j : Ljava/lang/String;
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_0
    //   131: ldc '.txt'
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_0
    //   138: invokevirtual toString : ()Ljava/lang/String;
    //   141: putstatic com/tencent/bugly/proguard/y.l : Ljava/lang/String;
    //   144: invokestatic myPid : ()I
    //   147: putstatic com/tencent/bugly/proguard/y.p : I
    //   150: iconst_1
    //   151: putstatic com/tencent/bugly/proguard/y.m : Z
    //   154: ldc com/tencent/bugly/proguard/y
    //   156: monitorexit
    //   157: return
    //   158: ldc com/tencent/bugly/proguard/y
    //   160: monitorexit
    //   161: return
    //   162: astore_0
    //   163: ldc com/tencent/bugly/proguard/y
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    //   168: astore_0
    //   169: goto -> 150
    // Exception table:
    //   from	to	target	type
    //   3	9	162	finally
    //   13	17	162	finally
    //   24	150	168	finally
    //   150	154	162	finally
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/y
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/y.m : Z
    //   6: ifeq -> 52
    //   9: getstatic com/tencent/bugly/proguard/y.a : Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifne -> 20
    //   17: goto -> 52
    //   20: getstatic com/tencent/bugly/proguard/y.o : Ljava/util/concurrent/ExecutorService;
    //   23: new com/tencent/bugly/proguard/y$1
    //   26: dup
    //   27: aload_0
    //   28: aload_1
    //   29: aload_2
    //   30: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   33: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   38: ldc com/tencent/bugly/proguard/y
    //   40: monitorexit
    //   41: return
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic b : (Ljava/lang/Throwable;)Z
    //   47: pop
    //   48: ldc com/tencent/bugly/proguard/y
    //   50: monitorexit
    //   51: return
    //   52: ldc com/tencent/bugly/proguard/y
    //   54: monitorexit
    //   55: return
    //   56: astore_0
    //   57: ldc com/tencent/bugly/proguard/y
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	56	finally
    //   20	38	42	java/lang/Exception
    //   20	38	56	finally
    //   43	48	56	finally
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    if (paramThrowable == null)
      return; 
    String str2 = paramThrowable.getMessage();
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append('\n');
    stringBuilder.append(z.b(paramThrowable));
    a(paramString1, paramString2, stringBuilder.toString());
  }
  
  public static byte[] a() {
    return b ? (!a ? null : z.a((File)null, f.toString(), "BuglyLog.txt")) : b();
  }
  
  private static byte[] b() {
    if (!a)
      return null; 
    null = new StringBuilder();
    synchronized (q) {
      if (h != null && a.d(h) && a.a(h) != null && a.a(h).length() > 0L)
        null.append(z.a(a.a(h), 30720, true)); 
      if (f != null && f.length() > 0)
        null.append(f.toString()); 
      return z.a((File)null, null.toString(), "BuglyLog.txt");
    } 
  }
  
  private static void c(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/y
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/y.b : Z
    //   6: ifeq -> 19
    //   9: aload_0
    //   10: aload_1
    //   11: aload_2
    //   12: invokestatic d : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   15: ldc com/tencent/bugly/proguard/y
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc com/tencent/bugly/proguard/y
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: ldc com/tencent/bugly/proguard/y
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	29	finally
    //   19	25	29	finally
  }
  
  private static void d(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/y
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: invokestatic myTid : ()I
    //   9: i2l
    //   10: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   13: astore_1
    //   14: getstatic com/tencent/bugly/proguard/y.q : Ljava/lang/Object;
    //   17: astore_0
    //   18: aload_0
    //   19: monitorenter
    //   20: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   31: invokevirtual length : ()I
    //   34: getstatic com/tencent/bugly/proguard/y.d : I
    //   37: if_icmplt -> 75
    //   40: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   43: iconst_0
    //   44: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   47: ldc '\\r\\n'
    //   49: invokevirtual indexOf : (Ljava/lang/String;)I
    //   52: iconst_1
    //   53: iadd
    //   54: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   57: putstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   60: goto -> 75
    //   63: astore_1
    //   64: aload_1
    //   65: invokestatic b : (Ljava/lang/Throwable;)Z
    //   68: ifne -> 75
    //   71: aload_1
    //   72: invokevirtual printStackTrace : ()V
    //   75: aload_0
    //   76: monitorexit
    //   77: ldc com/tencent/bugly/proguard/y
    //   79: monitorexit
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_0
    //   87: ldc com/tencent/bugly/proguard/y
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	86	finally
    //   20	60	63	finally
    //   64	75	81	finally
    //   75	77	81	finally
    //   82	86	86	finally
  }
  
  private static void e(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/y
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: invokestatic myTid : ()I
    //   9: i2l
    //   10: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   13: astore_1
    //   14: getstatic com/tencent/bugly/proguard/y.q : Ljava/lang/Object;
    //   17: astore_0
    //   18: aload_0
    //   19: monitorenter
    //   20: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   31: invokevirtual length : ()I
    //   34: istore_3
    //   35: getstatic com/tencent/bugly/proguard/y.d : I
    //   38: istore #4
    //   40: iload_3
    //   41: iload #4
    //   43: if_icmpgt -> 52
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc com/tencent/bugly/proguard/y
    //   50: monitorexit
    //   51: return
    //   52: getstatic com/tencent/bugly/proguard/y.g : Z
    //   55: istore #5
    //   57: iload #5
    //   59: ifeq -> 68
    //   62: aload_0
    //   63: monitorexit
    //   64: ldc com/tencent/bugly/proguard/y
    //   66: monitorexit
    //   67: return
    //   68: iconst_1
    //   69: putstatic com/tencent/bugly/proguard/y.g : Z
    //   72: getstatic com/tencent/bugly/proguard/y.h : Lcom/tencent/bugly/proguard/y$a;
    //   75: ifnonnull -> 94
    //   78: new com/tencent/bugly/proguard/y$a
    //   81: dup
    //   82: getstatic com/tencent/bugly/proguard/y.l : Ljava/lang/String;
    //   85: invokespecial <init> : (Ljava/lang/String;)V
    //   88: putstatic com/tencent/bugly/proguard/y.h : Lcom/tencent/bugly/proguard/y$a;
    //   91: goto -> 137
    //   94: getstatic com/tencent/bugly/proguard/y.h : Lcom/tencent/bugly/proguard/y$a;
    //   97: invokestatic a : (Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   100: ifnull -> 130
    //   103: getstatic com/tencent/bugly/proguard/y.h : Lcom/tencent/bugly/proguard/y$a;
    //   106: invokestatic a : (Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   109: invokevirtual length : ()J
    //   112: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   115: invokevirtual length : ()I
    //   118: i2l
    //   119: ladd
    //   120: getstatic com/tencent/bugly/proguard/y.h : Lcom/tencent/bugly/proguard/y$a;
    //   123: invokestatic b : (Lcom/tencent/bugly/proguard/y$a;)J
    //   126: lcmp
    //   127: ifle -> 137
    //   130: getstatic com/tencent/bugly/proguard/y.h : Lcom/tencent/bugly/proguard/y$a;
    //   133: invokestatic c : (Lcom/tencent/bugly/proguard/y$a;)Z
    //   136: pop
    //   137: getstatic com/tencent/bugly/proguard/y.h : Lcom/tencent/bugly/proguard/y$a;
    //   140: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   143: invokevirtual toString : ()Ljava/lang/String;
    //   146: invokevirtual a : (Ljava/lang/String;)Z
    //   149: ifeq -> 163
    //   152: getstatic com/tencent/bugly/proguard/y.f : Ljava/lang/StringBuilder;
    //   155: iconst_0
    //   156: invokevirtual setLength : (I)V
    //   159: iconst_0
    //   160: putstatic com/tencent/bugly/proguard/y.g : Z
    //   163: aload_0
    //   164: monitorexit
    //   165: ldc com/tencent/bugly/proguard/y
    //   167: monitorexit
    //   168: return
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    //   174: astore_0
    //   175: ldc com/tencent/bugly/proguard/y
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    //   180: astore_1
    //   181: goto -> 163
    // Exception table:
    //   from	to	target	type
    //   3	20	174	finally
    //   20	40	180	finally
    //   46	48	169	finally
    //   52	57	180	finally
    //   62	64	169	finally
    //   68	91	180	finally
    //   94	130	180	finally
    //   130	137	180	finally
    //   137	163	180	finally
    //   163	165	169	finally
    //   170	174	174	finally
  }
  
  public static final class a {
    private boolean a;
    
    private File b;
    
    private String c;
    
    private long d;
    
    private long e = 30720L;
    
    public a(String param1String) {
      if (param1String != null) {
        if (param1String.equals(""))
          return; 
        this.c = param1String;
        this.a = a();
      } 
    }
    
    private boolean a() {
      try {
        return true;
      } finally {
        Exception exception = null;
        x.a(exception);
        this.a = false;
      } 
    }
    
    public final boolean a(String param1String) {
      if (!this.a)
        return false; 
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(this.b, true);
      } finally {
        null = null;
      } 
      try {
        x.a(null);
        this.a = false;
        return false;
      } finally {
        if (iOException != null)
          try {
            iOException.close();
          } catch (IOException iOException1) {} 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */