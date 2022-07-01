package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;

public final class e implements Thread.UncaughtExceptionHandler {
  private static String h;
  
  private static final Object i = new Object();
  
  private Context a;
  
  private b b;
  
  private a c;
  
  private a d;
  
  private Thread.UncaughtExceptionHandler e;
  
  private Thread.UncaughtExceptionHandler f;
  
  private boolean g = false;
  
  private int j;
  
  public e(Context paramContext, b paramb, a parama, a parama1) {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  private static String a(Throwable paramThrowable, int paramInt) {
    if (paramThrowable == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    try {
      if (paramThrowable.getStackTrace() != null)
        for (StackTraceElement stackTraceElement : paramThrowable.getStackTrace()) {
          if (paramInt > 0 && stringBuilder.length() >= paramInt) {
            StringBuilder stringBuilder1 = new StringBuilder("\n[Stack over limit size :");
            stringBuilder1.append(paramInt);
            stringBuilder1.append(" , has been cutted !]");
            return stringBuilder.toString();
          } 
          stringBuilder.append(stackTraceElement.toString());
          stringBuilder.append("\n");
        }  
    } finally {
      paramThrowable = null;
    } 
  }
  
  private static boolean a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
    if (paramUncaughtExceptionHandler == null)
      return true; 
    String str = paramUncaughtExceptionHandler.getClass().getName();
    for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
      String str1 = stackTraceElement.getClassName();
      String str2 = stackTraceElement.getMethodName();
      if (str.equals(str1) && "uncaughtException".equals(str2))
        return false; 
    } 
    return true;
  }
  
  private static boolean a(Thread paramThread) {
    synchronized (i) {
      if (h != null) {
        boolean bool = paramThread.getName().equals(h);
        if (bool)
          return true; 
      } 
      h = paramThread.getName();
      return false;
    } 
  }
  
  private CrashDetailBean b(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfbyte) {
    String str1;
    StringBuilder stringBuilder;
    if (paramThrowable == null) {
      x.d("We can do nothing with a null throwable.", new Object[0]);
      return null;
    } 
    boolean bool = c.a().k();
    if (bool && paramBoolean) {
      String str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
    } else {
      String str = "";
    } 
    if (bool && paramBoolean)
      x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]); 
    CrashDetailBean crashDetailBean = new CrashDetailBean();
    crashDetailBean.C = b.k();
    crashDetailBean.D = b.i();
    crashDetailBean.E = b.m();
    crashDetailBean.F = this.d.p();
    crashDetailBean.G = this.d.o();
    crashDetailBean.H = this.d.q();
    crashDetailBean.w = z.a(this.a, c.e, null);
    crashDetailBean.y = y.a();
    if (crashDetailBean.y == null) {
      i = 0;
    } else {
      i = crashDetailBean.y.length;
    } 
    x.a("user log size:%d", new Object[] { Integer.valueOf(i) });
    if (paramBoolean) {
      i = 0;
    } else {
      i = 2;
    } 
    crashDetailBean.b = i;
    crashDetailBean.e = this.d.h();
    crashDetailBean.f = this.d.k;
    crashDetailBean.g = this.d.w();
    crashDetailBean.m = this.d.g();
    String str4 = paramThrowable.getClass().getName();
    String str3 = b(paramThrowable, 1000);
    String str2 = str3;
    if (str3 == null)
      str2 = ""; 
    int i = (paramThrowable.getStackTrace()).length;
    if (paramThrowable.getCause() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    x.e("stack frame :%d, has cause %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if ((paramThrowable.getStackTrace()).length > 0) {
      str3 = paramThrowable.getStackTrace()[0].toString();
    } else {
      str3 = "";
    } 
    Throwable throwable;
    for (throwable = paramThrowable; throwable != null && throwable.getCause() != null; throwable = throwable.getCause());
    if (throwable != null && throwable != paramThrowable) {
      crashDetailBean.n = throwable.getClass().getName();
      crashDetailBean.o = b(throwable, 1000);
      if (crashDetailBean.o == null)
        crashDetailBean.o = ""; 
      if ((throwable.getStackTrace()).length > 0)
        crashDetailBean.p = throwable.getStackTrace()[0].toString(); 
      stringBuilder = new StringBuilder();
      stringBuilder.append(str4);
      stringBuilder.append(":");
      stringBuilder.append(str2);
      stringBuilder.append("\n");
      stringBuilder.append(str3);
      stringBuilder.append("\n......");
      stringBuilder.append("\nCaused by:\n");
      stringBuilder.append(crashDetailBean.n);
      stringBuilder.append(":");
      stringBuilder.append(crashDetailBean.o);
      stringBuilder.append("\n");
      str1 = a(throwable, c.f);
      stringBuilder.append(str1);
      crashDetailBean.q = stringBuilder.toString();
    } else {
      crashDetailBean.n = str4;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append((String)stringBuilder);
      crashDetailBean.o = stringBuilder1.toString();
      if (crashDetailBean.o == null)
        crashDetailBean.o = ""; 
      crashDetailBean.p = str3;
      str1 = a((Throwable)str1, c.f);
      crashDetailBean.q = str1;
    } 
    crashDetailBean.r = System.currentTimeMillis();
    crashDetailBean.u = z.b(crashDetailBean.q.getBytes());
    try {
      crashDetailBean.z = z.a(c.f, false);
      crashDetailBean.A = this.d.d;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramThread.getName());
      stringBuilder.append("(");
      stringBuilder.append(paramThread.getId());
      stringBuilder.append(")");
      crashDetailBean.B = stringBuilder.toString();
      crashDetailBean.z.put(crashDetailBean.B, str1);
      crashDetailBean.I = this.d.y();
      crashDetailBean.h = this.d.v();
      crashDetailBean.i = this.d.J();
      crashDetailBean.M = this.d.a;
      crashDetailBean.N = this.d.a();
      if (paramBoolean) {
        this.b.d(crashDetailBean);
      } else {
        boolean bool1;
        if (paramString != null && paramString.length() > 0) {
          i = 1;
        } else {
          i = 0;
        } 
        if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (i != 0) {
          crashDetailBean.O = new HashMap<String, String>(1);
          crashDetailBean.O.put("UserData", paramString);
        } 
        if (bool1)
          crashDetailBean.U = paramArrayOfbyte; 
      } 
      crashDetailBean.Q = this.d.H();
      crashDetailBean.R = this.d.I();
      return crashDetailBean;
    } finally {
      paramThread = null;
      x.e("handle crash error %s", new Object[] { paramThread.toString() });
    } 
  }
  
  private static String b(Throwable paramThrowable, int paramInt) {
    if (paramThrowable.getMessage() == null)
      return ""; 
    if (paramThrowable.getMessage().length() <= 1000)
      return paramThrowable.getMessage(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramThrowable.getMessage().substring(0, 1000));
    stringBuilder.append("\n[Message over limit size:1000");
    stringBuilder.append(", has been cutted!]");
    return stringBuilder.toString();
  }
  
  public final void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : I
    //   6: bipush #10
    //   8: if_icmplt -> 33
    //   11: ldc_w 'java crash handler over %d, no need set.'
    //   14: iconst_1
    //   15: anewarray java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: bipush #10
    //   22: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   25: aastore
    //   26: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   29: pop
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: iconst_1
    //   35: putfield g : Z
    //   38: invokestatic getDefaultUncaughtExceptionHandler : ()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull -> 141
    //   46: aload_0
    //   47: invokevirtual getClass : ()Ljava/lang/Class;
    //   50: invokevirtual getName : ()Ljava/lang/String;
    //   53: aload_2
    //   54: invokevirtual getClass : ()Ljava/lang/Class;
    //   57: invokevirtual getName : ()Ljava/lang/String;
    //   60: invokevirtual equals : (Ljava/lang/Object;)Z
    //   63: istore_1
    //   64: iload_1
    //   65: ifeq -> 71
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: ldc_w 'com.android.internal.os.RuntimeInit$UncaughtHandler'
    //   74: aload_2
    //   75: invokevirtual getClass : ()Ljava/lang/Class;
    //   78: invokevirtual getName : ()Ljava/lang/String;
    //   81: invokevirtual equals : (Ljava/lang/Object;)Z
    //   84: ifeq -> 118
    //   87: ldc_w 'backup system java handler: %s'
    //   90: iconst_1
    //   91: anewarray java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_2
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: aload_2
    //   107: putfield f : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   110: aload_0
    //   111: aload_2
    //   112: putfield e : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   115: goto -> 141
    //   118: ldc_w 'backup java handler: %s'
    //   121: iconst_1
    //   122: anewarray java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_2
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   135: pop
    //   136: aload_0
    //   137: aload_2
    //   138: putfield e : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   141: aload_0
    //   142: invokestatic setDefaultUncaughtExceptionHandler : (Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   145: aload_0
    //   146: aload_0
    //   147: getfield j : I
    //   150: iconst_1
    //   151: iadd
    //   152: putfield j : I
    //   155: ldc_w 'registered java monitor: %s'
    //   158: iconst_1
    //   159: anewarray java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: aastore
    //   169: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   172: pop
    //   173: aload_0
    //   174: monitorexit
    //   175: return
    //   176: astore_2
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_2
    //   180: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	176	finally
    //   33	42	176	finally
    //   46	64	176	finally
    //   71	115	176	finally
    //   118	141	176	finally
    //   141	173	176	finally
  }
  
  public final void a(StrategyBean paramStrategyBean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 64
    //   6: aload_1
    //   7: getfield g : Z
    //   10: aload_0
    //   11: getfield g : Z
    //   14: if_icmpeq -> 64
    //   17: ldc_w 'java changed to %b'
    //   20: iconst_1
    //   21: anewarray java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: getfield g : Z
    //   30: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   33: aastore
    //   34: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload_1
    //   39: getfield g : Z
    //   42: ifeq -> 52
    //   45: aload_0
    //   46: invokevirtual a : ()V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: invokevirtual b : ()V
    //   56: goto -> 64
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    // Exception table:
    //   from	to	target	type
    //   6	49	59	finally
    //   52	56	59	finally
  }
  
  public final void a(Thread paramThread, Throwable paramThrowable, boolean paramBoolean, String paramString, byte[] paramArrayOfbyte) {
    if (paramBoolean) {
      x.e("Java Crash Happen cause by %s(%d)", new Object[] { paramThread.getName(), Long.valueOf(paramThread.getId()) });
      if (a(paramThread)) {
        x.a("this class has handled this exception", new Object[0]);
        if (this.f != null) {
          x.a("call system handler", new Object[0]);
          this.f.uncaughtException(paramThread, paramThrowable);
        } else {
          x.e("current process die", new Object[0]);
          Process.killProcess(Process.myPid());
          System.exit(1);
        } 
      } 
    } else {
      x.e("Java Catch Happen", new Object[0]);
    } 
    try {
      Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
      String str;
      if (!this.g) {
        x.c("Java crash handler is disable. Just return.", new Object[0]);
        return;
      } 
      if (!this.c.b())
        x.d("no remote but still store!", new Object[0]); 
      boolean bool = (this.c.c()).g;
      if (!bool && this.c.b()) {
        x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
        if (paramBoolean) {
          paramString = "JAVA_CRASH";
        } else {
          paramString = "JAVA_CATCH";
        } 
        b.a(paramString, z.a(), this.d.d, paramThread.getName(), z.a(paramThrowable), null);
        return;
      } 
      CrashDetailBean crashDetailBean = b(paramThread, paramThrowable, paramBoolean, (String)uncaughtExceptionHandler, paramArrayOfbyte);
      if (crashDetailBean == null) {
        x.e("pkg crash datas fail!", new Object[0]);
        return;
      } 
      if (paramBoolean) {
        str = "JAVA_CRASH";
      } else {
        str = "JAVA_CATCH";
      } 
      b.a(str, z.a(), this.d.d, paramThread.getName(), z.a(paramThrowable), crashDetailBean);
      if (!this.b.a(crashDetailBean))
        this.b.a(crashDetailBean, 3000L, paramBoolean); 
      if (paramBoolean)
        this.b.c(crashDetailBean); 
    } finally {
      paramString = null;
    } 
  }
  
  public final void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield g : Z
    //   7: ldc_w 'close java monitor!'
    //   10: iconst_0
    //   11: anewarray java/lang/Object
    //   14: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   17: pop
    //   18: invokestatic getDefaultUncaughtExceptionHandler : ()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   21: invokevirtual getClass : ()Ljava/lang/Class;
    //   24: invokevirtual getName : ()Ljava/lang/String;
    //   27: ldc_w 'bugly'
    //   30: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   33: ifeq -> 71
    //   36: ldc_w 'Java monitor to unregister: %s'
    //   39: iconst_1
    //   40: anewarray java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_0
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: aastore
    //   50: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_0
    //   55: getfield e : Ljava/lang/Thread$UncaughtExceptionHandler;
    //   58: invokestatic setDefaultUncaughtExceptionHandler : (Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield j : I
    //   66: iconst_1
    //   67: isub
    //   68: putfield j : I
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   2	71	74	finally
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    synchronized (i) {
      a(paramThread, paramThrowable, true, null, null);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */