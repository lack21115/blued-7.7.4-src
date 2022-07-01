package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b implements ac {
  private AtomicInteger a = new AtomicInteger(0);
  
  private long b = -1L;
  
  private final Context c;
  
  private final a d;
  
  private final w e;
  
  private final a f;
  
  private final String g;
  
  private final com.tencent.bugly.crashreport.crash.b h;
  
  private FileObserver i;
  
  private boolean j = true;
  
  private ab k;
  
  private int l;
  
  private ActivityManager.ProcessErrorStateInfo m;
  
  public b(Context paramContext, a parama, a parama1, w paramw, com.tencent.bugly.crashreport.crash.b paramb) {
    this.c = z.a(paramContext);
    this.g = paramContext.getDir("bugly", 0).getAbsolutePath();
    this.d = parama1;
    this.e = paramw;
    this.f = parama;
    this.h = paramb;
    this.m = new ActivityManager.ProcessErrorStateInfo();
  }
  
  private ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong) {
    try {
      x.c("to find!", new Object[0]);
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      int i;
      for (i = 0;; i++) {
        x.c("waiting!", new Object[0]);
        List list = activityManager.getProcessesInErrorState();
        if (list != null)
          for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
            if (processErrorStateInfo.condition == 2) {
              x.c("found!", new Object[0]);
              return processErrorStateInfo;
            } 
          }  
        z.b(500L);
        if (i >= 20L) {
          x.c("end!", new Object[0]);
          break;
        } 
      } 
    } catch (Exception exception) {
      x.b(exception);
    } catch (OutOfMemoryError outOfMemoryError) {
      this.m.pid = Process.myPid();
      ActivityManager.ProcessErrorStateInfo processErrorStateInfo = this.m;
      StringBuilder stringBuilder = new StringBuilder("bugly sdk waitForAnrProcessStateChanged encount error:");
      stringBuilder.append(outOfMemoryError.getMessage());
      processErrorStateInfo.shortMsg = stringBuilder.toString();
      return this.m;
    } 
    return null;
  }
  
  private CrashDetailBean a(a parama) {
    CrashDetailBean crashDetailBean = new CrashDetailBean();
    try {
      String str;
      crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
      crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
      crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
      crashDetailBean.F = this.d.p();
      crashDetailBean.G = this.d.o();
      crashDetailBean.H = this.d.q();
      Context context2 = this.c;
      if (!com.tencent.bugly.crashreport.common.info.b.t())
        crashDetailBean.w = z.a(this.c, c.e, null); 
      crashDetailBean.b = 3;
      crashDetailBean.e = this.d.h();
      crashDetailBean.f = this.d.k;
      crashDetailBean.g = this.d.w();
      crashDetailBean.m = this.d.g();
      crashDetailBean.n = "ANR_EXCEPTION";
      crashDetailBean.o = parama.f;
      crashDetailBean.q = parama.g;
      crashDetailBean.P = new HashMap<Object, Object>();
      crashDetailBean.P.put("BUGLY_CR_01", parama.e);
      int i = -1;
      if (crashDetailBean.q != null)
        i = crashDetailBean.q.indexOf("\n"); 
      if (i > 0) {
        str = crashDetailBean.q.substring(0, i);
      } else {
        str = "GET_FAIL";
      } 
      crashDetailBean.p = str;
      crashDetailBean.r = parama.c;
      if (crashDetailBean.q != null)
        crashDetailBean.u = z.b(crashDetailBean.q.getBytes()); 
      crashDetailBean.z = parama.b;
      crashDetailBean.A = parama.a;
      crashDetailBean.B = "main(1)";
      crashDetailBean.I = this.d.y();
      crashDetailBean.h = this.d.v();
      crashDetailBean.i = this.d.J();
      crashDetailBean.v = parama.d;
      crashDetailBean.L = this.d.o;
      crashDetailBean.M = this.d.a;
      crashDetailBean.N = this.d.a();
      Context context1 = this.c;
      if (!com.tencent.bugly.crashreport.common.info.b.t())
        this.h.d(crashDetailBean); 
      crashDetailBean.Q = this.d.H();
      crashDetailBean.R = this.d.I();
      crashDetailBean.S = this.d.B();
      return crashDetailBean;
    } finally {
      parama = null;
      if (!x.a((Throwable)parama))
        parama.printStackTrace(); 
    } 
  }
  
  private boolean a(Context paramContext, String paramString, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo, long paramLong, Map<String, String> paramMap) {
    int i;
    a a1 = new a();
    a1.c = paramLong;
    str5 = "";
    if (paramProcessErrorStateInfo != null) {
      str2 = paramProcessErrorStateInfo.processName;
    } else {
      str2 = "";
    } 
    a1.a = str2;
    if (paramProcessErrorStateInfo != null) {
      str2 = paramProcessErrorStateInfo.shortMsg;
    } else {
      str2 = "";
    } 
    a1.f = str2;
    String str2 = str5;
    if (paramProcessErrorStateInfo != null)
      str2 = paramProcessErrorStateInfo.longMsg; 
    a1.e = str2;
    a1.b = paramMap;
    Thread thread = Looper.getMainLooper().getThread();
    if (paramMap != null)
      for (String str5 : paramMap.keySet()) {
        if (str5.startsWith(thread.getName())) {
          a1.g = paramMap.get(str5);
          break;
        } 
      }  
    if (TextUtils.isEmpty(a1.g))
      a1.g = "main stack is null , some error may be encountered."; 
    long l = a1.c;
    String str1 = a1.d;
    String str3 = a1.a;
    String str4 = a1.g;
    str5 = a1.f;
    String str6 = a1.e;
    if (a1.b == null) {
      i = 0;
    } else {
      i = a1.b.size();
    } 
    x.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new Object[] { Long.valueOf(l), str1, str3, str4, str5, str6, Integer.valueOf(i) });
    if (!(this.f.c()).j) {
      x.d("ANR Report is closed! print local for helpful!", new Object[0]);
      com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), a1.a, "main", a1.g, null);
      return false;
    } 
    x.a("found visiable anr , start to upload!", new Object[0]);
    CrashDetailBean crashDetailBean = a(a1);
    if (crashDetailBean == null) {
      x.e("pack anr fail!", new Object[0]);
      return false;
    } 
    c.a().a(crashDetailBean);
    if (crashDetailBean.a >= 0L) {
      x.a("backup anr record success!", new Object[0]);
    } else {
      x.d("backup anr record fail!", new Object[0]);
    } 
    if (paramString != null && (new File(paramString)).exists()) {
      str3 = this.g;
      StringBuilder stringBuilder = new StringBuilder("bugly_trace_");
      stringBuilder.append(paramLong);
      stringBuilder.append(".txt");
      a1.d = (new File(str3, stringBuilder.toString())).getAbsolutePath();
      this.a.set(3);
      if (a(paramString, a1.d, a1.a))
        x.a("backup trace success", new Object[0]); 
    } else {
      File file = j();
      x.a("traceFile is %s", new Object[] { file });
      if (file != null)
        crashDetailBean.v = file.getAbsolutePath(); 
    } 
    com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), a1.a, "main", a1.g, crashDetailBean);
    if (!this.h.a(crashDetailBean))
      this.h.a(crashDetailBean, 3000L, true); 
    this.h.c(crashDetailBean);
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3) {
    IOException iOException;
    TraceFileHelper.a a1 = TraceFileHelper.readTargetDumpInfo(paramString3, paramString1, true);
    if (a1 == null || a1.d == null || a1.d.size() <= 0) {
      x.e("not found trace dump for %s", new Object[] { paramString3 });
      return false;
    } 
    File file = new File(paramString2);
    try {
      if (!file.exists()) {
        if (!file.getParentFile().exists())
          file.getParentFile().mkdirs(); 
        file.createNewFile();
      } 
      if (!file.exists() || !file.canWrite()) {
        x.e("backup file create fail %s", new Object[] { paramString2 });
        return false;
      } 
      paramString3 = null;
      paramString1 = null;
      try {
      
      } catch (IOException iOException1) {
      
      } finally {
        iOException2 = null;
        iOException = iOException1;
      } 
      iOException1 = iOException;
      if (!x.a(iOException2)) {
        iOException1 = iOException;
        iOException2.printStackTrace();
      } 
      iOException1 = iOException;
      StringBuilder stringBuilder = new StringBuilder();
      iOException1 = iOException;
      stringBuilder.append(iOException2.getClass().getName());
      iOException1 = iOException;
      stringBuilder.append(":");
      iOException1 = iOException;
      stringBuilder.append(iOException2.getMessage());
      iOException1 = iOException;
      x.e("dump trace fail %s", new Object[] { stringBuilder.toString() });
      if (iOException != null)
        try {
          iOException.close();
          return false;
        } catch (IOException iOException3) {
          if (!x.a(iOException3))
            iOException3.printStackTrace(); 
        }  
      return false;
    } catch (Exception exception) {
      if (!x.a(exception))
        exception.printStackTrace(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(exception.getClass().getName());
      stringBuilder.append(":");
      stringBuilder.append(exception.getMessage());
      x.e("backup file create error! %s  %s", new Object[] { stringBuilder.toString(), iOException });
      return false;
    } 
  }
  
  private void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 13
    //   6: aload_0
    //   7: invokespecial f : ()V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokespecial g : ()V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	20	finally
    //   13	17	20	finally
  }
  
  private void c(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: iload_1
    //   7: if_icmpeq -> 33
    //   10: ldc_w 'user change anr %b'
    //   13: iconst_1
    //   14: anewarray java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: iload_1
    //   20: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   23: aastore
    //   24: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   27: pop
    //   28: aload_0
    //   29: iload_1
    //   30: putfield j : Z
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	33	36	finally
  }
  
  private void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial h : ()Z
    //   6: ifeq -> 23
    //   9: ldc_w 'start when started!'
    //   12: iconst_0
    //   13: anewarray java/lang/Object
    //   16: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: new com/tencent/bugly/crashreport/crash/anr/b$1
    //   27: dup
    //   28: aload_0
    //   29: ldc_w '/data/anr/'
    //   32: bipush #8
    //   34: invokespecial <init> : (Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   37: putfield i : Landroid/os/FileObserver;
    //   40: aload_0
    //   41: getfield i : Landroid/os/FileObserver;
    //   44: invokevirtual startWatching : ()V
    //   47: ldc_w 'start anr monitor!'
    //   50: iconst_0
    //   51: anewarray java/lang/Object
    //   54: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield e : Lcom/tencent/bugly/proguard/w;
    //   62: new com/tencent/bugly/crashreport/crash/anr/b$2
    //   65: dup
    //   66: aload_0
    //   67: invokespecial <init> : (Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   70: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield i : Landroid/os/FileObserver;
    //   83: ldc_w 'start anr monitor failed!'
    //   86: iconst_0
    //   87: anewarray java/lang/Object
    //   90: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_1
    //   95: invokestatic a : (Ljava/lang/Throwable;)Z
    //   98: ifne -> 105
    //   101: aload_1
    //   102: invokevirtual printStackTrace : ()V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	108	finally
    //   23	40	108	finally
    //   40	74	77	finally
    //   78	105	108	finally
  }
  
  private void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial h : ()Z
    //   6: ifne -> 23
    //   9: ldc_w 'close when closed!'
    //   12: iconst_0
    //   13: anewarray java/lang/Object
    //   16: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield i : Landroid/os/FileObserver;
    //   27: invokevirtual stopWatching : ()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield i : Landroid/os/FileObserver;
    //   35: ldc_w 'close anr monitor!'
    //   38: iconst_0
    //   39: anewarray java/lang/Object
    //   42: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc_w 'stop anr monitor failed!'
    //   53: iconst_0
    //   54: anewarray java/lang/Object
    //   57: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic a : (Ljava/lang/Throwable;)Z
    //   65: ifne -> 72
    //   68: aload_1
    //   69: invokevirtual printStackTrace : ()V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   23	46	49	finally
    //   50	72	75	finally
  }
  
  private boolean h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Landroid/os/FileObserver;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  private boolean i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  private File j() {
    long l = System.currentTimeMillis();
    File file = new File(this.g);
    if (file.exists() && file.isDirectory())
      try {
        File[] arrayOfFile = file.listFiles();
        if (arrayOfFile == null || arrayOfFile.length == 0)
          return null; 
        int j = arrayOfFile.length;
        int i = 0;
        while (true)
          return null; 
      } finally {
        file = null;
        x.a((Throwable)file);
      }  
    return null;
  }
  
  public final void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual get : ()I
    //   9: ifeq -> 26
    //   12: ldc_w 'trace started return '
    //   15: iconst_0
    //   16: anewarray java/lang/Object
    //   19: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual set : (I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc_w 'read trace first dump for create time!'
    //   39: iconst_0
    //   40: anewarray java/lang/Object
    //   43: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_1
    //   48: iconst_0
    //   49: invokestatic readFirstDumpInfo : (Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   52: astore #6
    //   54: aload #6
    //   56: ifnull -> 373
    //   59: aload #6
    //   61: getfield c : J
    //   64: lstore_2
    //   65: goto -> 68
    //   68: lload_2
    //   69: lstore #4
    //   71: lload_2
    //   72: ldc2_w -1
    //   75: lcmp
    //   76: ifne -> 95
    //   79: ldc_w 'trace dump fail could not get time!'
    //   82: iconst_0
    //   83: anewarray java/lang/Object
    //   86: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   89: pop
    //   90: invokestatic currentTimeMillis : ()J
    //   93: lstore #4
    //   95: lload #4
    //   97: aload_0
    //   98: getfield b : J
    //   101: lsub
    //   102: invokestatic abs : (J)J
    //   105: ldc2_w 10000
    //   108: lcmp
    //   109: ifge -> 141
    //   112: ldc_w 'should not process ANR too Fre in %d'
    //   115: iconst_1
    //   116: anewarray java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: sipush #10000
    //   124: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   131: pop
    //   132: aload_0
    //   133: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   136: iconst_0
    //   137: invokevirtual set : (I)V
    //   140: return
    //   141: aload_0
    //   142: lload #4
    //   144: putfield b : J
    //   147: aload_0
    //   148: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   151: iconst_1
    //   152: invokevirtual set : (I)V
    //   155: getstatic com/tencent/bugly/crashreport/crash/c.f : I
    //   158: iconst_0
    //   159: invokestatic a : (IZ)Ljava/util/Map;
    //   162: astore #6
    //   164: aload #6
    //   166: ifnull -> 287
    //   169: aload #6
    //   171: invokeinterface size : ()I
    //   176: ifgt -> 182
    //   179: goto -> 287
    //   182: aload_0
    //   183: aload_0
    //   184: aload_0
    //   185: getfield c : Landroid/content/Context;
    //   188: ldc2_w 10000
    //   191: invokespecial a : (Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   194: putfield m : Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   197: aload_0
    //   198: getfield m : Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   201: ifnonnull -> 218
    //   204: ldc_w 'proc state is unvisiable!'
    //   207: iconst_0
    //   208: anewarray java/lang/Object
    //   211: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -> 132
    //   218: aload_0
    //   219: getfield m : Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   222: getfield pid : I
    //   225: invokestatic myPid : ()I
    //   228: if_icmpeq -> 255
    //   231: ldc_w 'not mind proc!'
    //   234: iconst_1
    //   235: anewarray java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: getfield m : Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   244: getfield processName : Ljava/lang/String;
    //   247: aastore
    //   248: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: goto -> 132
    //   255: ldc_w 'found visiable anr , start to process!'
    //   258: iconst_0
    //   259: anewarray java/lang/Object
    //   262: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   265: pop
    //   266: aload_0
    //   267: aload_0
    //   268: getfield c : Landroid/content/Context;
    //   271: aload_1
    //   272: aload_0
    //   273: getfield m : Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   276: lload #4
    //   278: aload #6
    //   280: invokespecial a : (Landroid/content/Context;Ljava/lang/String;Landroid/app/ActivityManager$ProcessErrorStateInfo;JLjava/util/Map;)Z
    //   283: pop
    //   284: goto -> 132
    //   287: ldc_w 'can't get all thread skip this anr'
    //   290: iconst_0
    //   291: anewarray java/lang/Object
    //   294: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   297: pop
    //   298: goto -> 132
    //   301: astore_1
    //   302: aload_1
    //   303: invokestatic a : (Ljava/lang/Throwable;)Z
    //   306: pop
    //   307: ldc_w 'get all thread stack fail!'
    //   310: iconst_0
    //   311: anewarray java/lang/Object
    //   314: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   317: pop
    //   318: goto -> 132
    //   321: astore_1
    //   322: aload_1
    //   323: invokestatic a : (Ljava/lang/Throwable;)Z
    //   326: ifne -> 333
    //   329: aload_1
    //   330: invokevirtual printStackTrace : ()V
    //   333: ldc_w 'handle anr error %s'
    //   336: iconst_1
    //   337: anewarray java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload_1
    //   343: invokevirtual getClass : ()Ljava/lang/Class;
    //   346: invokevirtual toString : ()Ljava/lang/String;
    //   349: aastore
    //   350: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   353: pop
    //   354: goto -> 132
    //   357: astore_1
    //   358: aload_0
    //   359: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   362: iconst_0
    //   363: invokevirtual set : (I)V
    //   366: aload_1
    //   367: athrow
    //   368: astore_1
    //   369: aload_0
    //   370: monitorexit
    //   371: aload_1
    //   372: athrow
    //   373: ldc2_w -1
    //   376: lstore_2
    //   377: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   2	25	368	finally
    //   26	36	368	finally
    //   36	54	321	finally
    //   59	65	321	finally
    //   79	95	321	finally
    //   95	132	321	finally
    //   141	155	321	finally
    //   155	164	301	finally
    //   169	179	321	finally
    //   182	215	321	finally
    //   218	252	321	finally
    //   255	284	321	finally
    //   287	298	321	finally
    //   302	318	321	finally
    //   322	333	357	finally
    //   333	354	357	finally
  }
  
  public final void a(boolean paramBoolean) {
    c(paramBoolean);
    boolean bool = i();
    a a1 = a.a();
    paramBoolean = bool;
    if (a1 != null)
      if (bool && (a1.c()).g) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }  
    if (paramBoolean != h()) {
      x.a("anr changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
      b(paramBoolean);
    } 
  }
  
  public final boolean a() {
    return (this.a.get() != 0);
  }
  
  public final boolean a(aa paramaa) {
    Map<String, String> map;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramaa.e().equals(Looper.getMainLooper())) {
      this.m = a(this.c, 10000L);
      ActivityManager.ProcessErrorStateInfo processErrorStateInfo = this.m;
      if (processErrorStateInfo == null) {
        x.c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
        return false;
      } 
      if (processErrorStateInfo.pid != Process.myPid()) {
        x.c("onThreadBlock not mind proc!", new Object[] { this.m.processName });
        return false;
      } 
      try {
        map = z.a(200000, false);
      } finally {
        processErrorStateInfo = null;
        x.b((Throwable)processErrorStateInfo);
        hashMap.put("main", processErrorStateInfo.getMessage());
      } 
    } 
    x.c("anr handler onThreadBlock only care main thread ,current thread is: %s", new Object[] { map.d() });
    return true;
  }
  
  protected final void b() {
    long l1 = z.b();
    long l2 = c.g;
    File file = new File(this.g);
    if (file.exists() && file.isDirectory())
      try {
        File[] arrayOfFile = file.listFiles();
        return;
      } finally {
        file = null;
      }  
  }
  
  public final void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'customer decides whether to open or close.'
    //   5: iconst_0
    //   6: anewarray java/lang/Object
    //   9: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  public final boolean d() {
    ab ab1 = this.k;
    if (ab1 != null && ab1.isAlive())
      return false; 
    this.k = new ab();
    ab1 = this.k;
    StringBuilder stringBuilder = new StringBuilder("Bugly-ThreadMonitor");
    int i = this.l;
    this.l = i + 1;
    stringBuilder.append(i);
    ab1.setName(stringBuilder.toString());
    this.k.a();
    this.k.a(this);
    boolean bool = this.k.d();
    this.e.a(new Runnable(this) {
          public final void run() {
            this.a.b();
          }
        });
    return bool;
  }
  
  public final boolean e() {
    ab ab1 = this.k;
    if (ab1 != null) {
      boolean bool = ab1.c();
      this.k.b();
      this.k.b(this);
      this.k = null;
      return bool;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */