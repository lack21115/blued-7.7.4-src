package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.e.e;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.f;
import java.util.Collections;
import org.json.JSONObject;

public class r implements Handler.Callback, a.a {
  private static volatile r a;
  
  private final Context b = b.B();
  
  private final Handler c = new Handler(Looper.getMainLooper(), this);
  
  private final SparseArray<a> d = new SparseArray();
  
  private final boolean e;
  
  private long f;
  
  private int g = 0;
  
  private ConnectivityManager h;
  
  private r() {
    f();
    this.e = f.c();
    a.a().a(this);
  }
  
  public static r a() {
    // Byte code:
    //   0: getstatic com/ss/android/socialbase/downloader/impls/r.a : Lcom/ss/android/socialbase/downloader/impls/r;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/socialbase/downloader/impls/r
    //   8: monitorenter
    //   9: getstatic com/ss/android/socialbase/downloader/impls/r.a : Lcom/ss/android/socialbase/downloader/impls/r;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/socialbase/downloader/impls/r
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/socialbase/downloader/impls/r.a : Lcom/ss/android/socialbase/downloader/impls/r;
    //   25: ldc com/ss/android/socialbase/downloader/impls/r
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/socialbase/downloader/impls/r
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/socialbase/downloader/impls/r.a : Lcom/ss/android/socialbase/downloader/impls/r;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean) {
    SparseArray<a> sparseArray;
    c c;
    null = this.b;
    if (null == null)
      return; 
    synchronized (this.d) {
      m m;
      a a1 = (a)this.d.get(paramInt1);
      if (a1 == null)
        return; 
      boolean bool1 = a.b(a1);
      boolean bool = true;
      if (bool1) {
        a.b(a1, false);
        this.g--;
        if (this.g < 0)
          this.g = 0; 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("doSchedulerRetryInSubThread: downloadId = ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", retryCount = ");
      stringBuilder.append(a.a(a1));
      stringBuilder.append(", mWaitingRetryTasksCount = ");
      stringBuilder.append(this.g);
      com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", stringBuilder.toString());
      c = f.a(null).h(paramInt1);
      if (c == null) {
        c(paramInt1);
        return;
      } 
      int i = c.w();
      if (i == -3 || i == -4) {
        c(paramInt1);
        return;
      } 
      if (i == -5) {
        m = b.o();
        if (m != null)
          m.a(Collections.singletonList(c)); 
        c(paramInt1);
        return;
      } 
      if (i != -1)
        return; 
      if (paramInt2 == 0)
        if (a1.f) {
          bool = false;
        } else {
          return;
        }  
      com.ss.android.socialbase.downloader.e.a a2 = c.aW();
      bool1 = bool;
      if (bool) {
        bool1 = bool;
        if (f.g((Throwable)a2))
          bool1 = a(c, a2); 
      } 
      a1.b();
      if (bool1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("doSchedulerRetry: restart task, ****** id = ");
        stringBuilder1.append(a1.a);
        com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", stringBuilder1.toString());
        a1.a(System.currentTimeMillis());
        if (paramBoolean)
          a1.a(); 
        c.a(a.a(a1));
        if (c.q() == -1) {
          f.a((Context)m).e(c.g());
          return;
        } 
      } else {
        if (paramBoolean)
          a1.a(); 
        a(c, c.x(), paramInt2);
      } 
      return;
    } 
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(c paramc, boolean paramBoolean, int paramInt) {
    SparseArray<a> sparseArray;
    StringBuilder stringBuilder;
    com.ss.android.socialbase.downloader.e.a a2 = paramc.aW();
    if (a2 == null)
      return; 
    a a1 = b(paramc.g());
    if (a.a(a1) > a1.c) {
      null = new StringBuilder();
      null.append("tryStartScheduleRetry, id = ");
      null.append(a1.a);
      null.append(", mRetryCount = ");
      null.append(a.a(a1));
      null.append(", maxCount = ");
      null.append(a1.c);
      com.ss.android.socialbase.downloader.f.a.d("RetryScheduler", null.toString());
      return;
    } 
    int i = a2.a();
    if (!f.g((Throwable)a2) && !f.h((Throwable)a2)) {
      if (!a(a1, i))
        return; 
      stringBuilder = new StringBuilder();
      stringBuilder.append("white error code, id = ");
      stringBuilder.append(a1.a);
      stringBuilder.append(", error code = ");
      stringBuilder.append(i);
      com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", stringBuilder.toString());
    } 
    a.a(a1, paramBoolean);
    synchronized (this.d) {
      if (!a.b(a1)) {
        a.b(a1, true);
        this.g++;
      } 
      i = a1.d();
      stringBuilder = new StringBuilder();
      stringBuilder.append("tryStartScheduleRetry: id = ");
      stringBuilder.append(a1.a);
      stringBuilder.append(", delayTimeMills = ");
      stringBuilder.append(i);
      stringBuilder.append(", mWaitingRetryTasks = ");
      stringBuilder.append(this.g);
      com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", stringBuilder.toString());
      if (a1.f) {
        if (paramInt == 0)
          a1.c(); 
        RetryJobSchedulerService.a((c)null, i, paramBoolean, paramInt);
        if (this.e) {
          a1.a(System.currentTimeMillis());
          a1.b();
          a1.a();
          return;
        } 
      } else {
        if (paramBoolean)
          return; 
        this.c.removeMessages(null.g());
        this.c.sendEmptyMessageDelayed(null.g(), i);
      } 
      return;
    } 
  }
  
  private boolean a(c paramc, com.ss.android.socialbase.downloader.e.a parama) {
    long l1;
    long l2;
    try {
      l1 = f.c(paramc.l());
    } catch (com.ss.android.socialbase.downloader.e.a a1) {
      a1.printStackTrace();
      l1 = 0L;
    } 
    if (parama instanceof e) {
      l2 = ((e)parama).d();
    } else {
      l2 = paramc.ab() - paramc.Z();
    } 
    if (l1 < l2) {
      com.ss.android.socialbase.downloader.k.a a1 = com.ss.android.socialbase.downloader.k.a.a(paramc.g());
      if (a1.a("space_fill_part_download", 0) == 1) {
        StringBuilder stringBuilder;
        if (l1 > 0L) {
          int i = a1.a("space_fill_min_keep_mb", 100);
          if (i > 0) {
            l2 = l1 - i * 1048576L;
            stringBuilder = new StringBuilder();
            stringBuilder.append("retry schedule: available = ");
            stringBuilder.append(f.a(l1));
            stringBuilder.append("MB, minKeep = ");
            stringBuilder.append(i);
            stringBuilder.append("MB, canDownload = ");
            stringBuilder.append(f.a(l2));
            stringBuilder.append("MB");
            com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", stringBuilder.toString());
            if (l2 <= 0L) {
              com.ss.android.socialbase.downloader.f.a.d("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
              return false;
            } 
          } 
        } else if (stringBuilder.a("download_when_space_negative", 0) != 1) {
          return false;
        } 
      } else {
        return false;
      } 
    } 
    return true;
  }
  
  private boolean a(a parama, int paramInt) {
    int[] arrayOfInt = parama.g;
    if (arrayOfInt != null) {
      if (arrayOfInt.length == 0)
        return false; 
      int j = arrayOfInt.length;
      for (int i = 0; i < j; i++) {
        if (arrayOfInt[i] == paramInt)
          return true; 
      } 
    } 
    return false;
  }
  
  private int[] a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      int i;
      String[] arrayOfString = paramString.split(",");
      if (arrayOfString.length <= 0)
        return null; 
      int[] arrayOfInt = new int[arrayOfString.length];
      return arrayOfInt;
    } finally {
      paramString = null;
    } 
  }
  
  private a b(int paramInt) {
    a a1 = (a)this.d.get(paramInt);
    if (a1 == null)
      synchronized (this.d) {
        a a2 = (a)this.d.get(paramInt);
        a1 = a2;
        if (a2 == null)
          a1 = d(paramInt); 
        this.d.put(paramInt, a1);
        return a1;
      }  
    return a1;
  }
  
  private void b(int paramInt, boolean paramBoolean) {
    b.k().execute(new Runnable(this, paramInt, paramBoolean) {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: getfield c : Lcom/ss/android/socialbase/downloader/impls/r;
            //   4: invokestatic c : (Lcom/ss/android/socialbase/downloader/impls/r;)I
            //   7: ifgt -> 11
            //   10: return
            //   11: aload_0
            //   12: getfield c : Lcom/ss/android/socialbase/downloader/impls/r;
            //   15: invokestatic d : (Lcom/ss/android/socialbase/downloader/impls/r;)I
            //   18: istore_2
            //   19: iload_2
            //   20: ifne -> 24
            //   23: return
            //   24: new java/lang/StringBuilder
            //   27: dup
            //   28: invokespecial <init> : ()V
            //   31: astore #5
            //   33: aload #5
            //   35: ldc 'doScheduleAllTaskRetry: mWaitingRetryTasksCount = '
            //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   40: pop
            //   41: aload #5
            //   43: aload_0
            //   44: getfield c : Lcom/ss/android/socialbase/downloader/impls/r;
            //   47: invokestatic c : (Lcom/ss/android/socialbase/downloader/impls/r;)I
            //   50: invokevirtual append : (I)Ljava/lang/StringBuilder;
            //   53: pop
            //   54: ldc 'RetryScheduler'
            //   56: aload #5
            //   58: invokevirtual toString : ()Ljava/lang/String;
            //   61: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
            //   64: invokestatic currentTimeMillis : ()J
            //   67: lstore_3
            //   68: new java/util/ArrayList
            //   71: dup
            //   72: invokespecial <init> : ()V
            //   75: astore #6
            //   77: aload_0
            //   78: getfield c : Lcom/ss/android/socialbase/downloader/impls/r;
            //   81: invokestatic e : (Lcom/ss/android/socialbase/downloader/impls/r;)Landroid/util/SparseArray;
            //   84: astore #5
            //   86: aload #5
            //   88: monitorenter
            //   89: iconst_0
            //   90: istore_1
            //   91: iload_1
            //   92: aload_0
            //   93: getfield c : Lcom/ss/android/socialbase/downloader/impls/r;
            //   96: invokestatic e : (Lcom/ss/android/socialbase/downloader/impls/r;)Landroid/util/SparseArray;
            //   99: invokevirtual size : ()I
            //   102: if_icmpge -> 169
            //   105: aload_0
            //   106: getfield c : Lcom/ss/android/socialbase/downloader/impls/r;
            //   109: invokestatic e : (Lcom/ss/android/socialbase/downloader/impls/r;)Landroid/util/SparseArray;
            //   112: iload_1
            //   113: invokevirtual valueAt : (I)Ljava/lang/Object;
            //   116: checkcast com/ss/android/socialbase/downloader/impls/r$a
            //   119: astore #7
            //   121: aload #7
            //   123: ifnull -> 242
            //   126: aload #7
            //   128: lload_3
            //   129: aload_0
            //   130: getfield a : I
            //   133: iload_2
            //   134: aload_0
            //   135: getfield b : Z
            //   138: invokevirtual a : (JIIZ)Z
            //   141: ifeq -> 242
            //   144: aload_0
            //   145: getfield b : Z
            //   148: ifeq -> 156
            //   151: aload #7
            //   153: invokevirtual c : ()V
            //   156: aload #6
            //   158: aload #7
            //   160: invokeinterface add : (Ljava/lang/Object;)Z
            //   165: pop
            //   166: goto -> 242
            //   169: aload #5
            //   171: monitorexit
            //   172: aload #6
            //   174: invokeinterface size : ()I
            //   179: ifle -> 238
            //   182: aload #6
            //   184: invokeinterface iterator : ()Ljava/util/Iterator;
            //   189: astore #5
            //   191: aload #5
            //   193: invokeinterface hasNext : ()Z
            //   198: ifeq -> 238
            //   201: aload #5
            //   203: invokeinterface next : ()Ljava/lang/Object;
            //   208: checkcast com/ss/android/socialbase/downloader/impls/r$a
            //   211: astore #6
            //   213: aload_0
            //   214: getfield c : Lcom/ss/android/socialbase/downloader/impls/r;
            //   217: aload #6
            //   219: getfield a : I
            //   222: iload_2
            //   223: iconst_0
            //   224: invokestatic a : (Lcom/ss/android/socialbase/downloader/impls/r;IIZ)V
            //   227: goto -> 191
            //   230: astore #6
            //   232: aload #5
            //   234: monitorexit
            //   235: aload #6
            //   237: athrow
            //   238: return
            //   239: astore #5
            //   241: return
            //   242: iload_1
            //   243: iconst_1
            //   244: iadd
            //   245: istore_1
            //   246: goto -> 91
            // Exception table:
            //   from	to	target	type
            //   0	10	239	java/lang/Exception
            //   11	19	239	java/lang/Exception
            //   24	89	239	java/lang/Exception
            //   91	121	230	finally
            //   126	156	230	finally
            //   156	166	230	finally
            //   169	172	230	finally
            //   172	191	239	java/lang/Exception
            //   191	227	239	java/lang/Exception
            //   232	235	230	finally
            //   235	238	239	java/lang/Exception
          }
        });
  }
  
  private void c(int paramInt) {
    synchronized (this.d) {
      this.d.remove(paramInt);
      return;
    } 
  }
  
  private a d(int paramInt) {
    byte b1;
    byte b2;
    boolean bool1;
    com.ss.android.socialbase.downloader.k.a a1 = com.ss.android.socialbase.downloader.k.a.a(paramInt);
    boolean bool2 = false;
    int j = a1.a("retry_schedule", 0);
    JSONObject jSONObject = a1.d("retry_schedule_config");
    int i = 60;
    if (jSONObject != null) {
      b1 = jSONObject.optInt("max_count", 60);
      i = jSONObject.optInt("interval_sec", 60);
      b2 = jSONObject.optInt("interval_sec_acceleration", 60);
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {
        bool1 = bool2;
        if (jSONObject.optInt("use_job_scheduler", 0) == 1)
          bool1 = true; 
      } 
      int[] arrayOfInt = a(jSONObject.optString("white_error_code"));
    } else {
      jSONObject = null;
      b2 = 60;
      b1 = 60;
      bool1 = false;
    } 
    return new a(paramInt, j, b1, i * 1000, b2 * 1000, bool1, (int[])jSONObject);
  }
  
  private void f() {
    if (com.ss.android.socialbase.downloader.k.a.b().a("use_network_callback", 0) != 1)
      return; 
    b.k().execute(new Runnable(this) {
          public void run() {
            try {
              if (r.a(this.a) != null && Build.VERSION.SDK_INT >= 21) {
                r.a(this.a, (ConnectivityManager)r.a(this.a).getApplicationContext().getSystemService("connectivity"));
                r.b(this.a).registerNetworkCallback((new NetworkRequest.Builder()).build(), new ConnectivityManager.NetworkCallback(this) {
                      public void onAvailable(Network param2Network) {
                        com.ss.android.socialbase.downloader.f.a.b("RetryScheduler", "network onAvailable: ");
                        r.a(this.a.a, 1, true);
                      }
                    });
                return;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
          }
        });
  }
  
  private int g() {
    try {
      if (this.h == null)
        this.h = (ConnectivityManager)this.b.getApplicationContext().getSystemService("connectivity"); 
      NetworkInfo networkInfo = this.h.getActiveNetworkInfo();
      if (networkInfo != null) {
        if (!networkInfo.isConnected())
          return 0; 
        int i = networkInfo.getType();
        return (i == 1) ? 2 : 1;
      } 
      return 0;
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  void a(int paramInt) {
    b.k().execute(new Runnable(this, paramInt) {
          public void run() {
            try {
              r.a(this.b, this.a, r.d(this.b), true);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
        });
  }
  
  public void a(c paramc) {
    if (paramc != null) {
      if (!"application/vnd.android.package-archive".contains(paramc.ah()))
        return; 
      a(paramc, paramc.x(), g());
    } 
  }
  
  public void b() {
    a(4, false);
  }
  
  public void c() {
    a(3, false);
  }
  
  public void d() {
    a(2, false);
  }
  
  public void e() {
    a(5, false);
  }
  
  public boolean handleMessage(Message paramMessage) {
    if (paramMessage.what == 0) {
      boolean bool;
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      b(i, bool);
      return true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("handleMessage, doSchedulerRetry, id = ");
    stringBuilder.append(paramMessage.what);
    com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", stringBuilder.toString());
    a(paramMessage.what);
    return true;
  }
  
  static class a {
    final int a;
    
    final int b;
    
    final int c;
    
    final int d;
    
    final int e;
    
    final boolean f;
    
    final int[] g;
    
    private int h;
    
    private int i;
    
    private boolean j;
    
    private long k;
    
    private boolean l;
    
    a(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, boolean param1Boolean, int[] param1ArrayOfint) {
      int i = param1Int4;
      if (param1Int4 < 20000)
        i = 20000; 
      param1Int4 = param1Int5;
      if (param1Int5 < 20000)
        param1Int4 = 20000; 
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
      this.d = i;
      this.e = param1Int4;
      this.f = param1Boolean;
      this.g = param1ArrayOfint;
      this.h = i;
    }
    
    void a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield h : I
      //   7: aload_0
      //   8: getfield e : I
      //   11: iadd
      //   12: putfield h : I
      //   15: aload_0
      //   16: monitorexit
      //   17: return
      //   18: astore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_1
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	15	18	finally
    }
    
    void a(long param1Long) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: lload_1
      //   4: putfield k : J
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_3
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_3
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	10	finally
    }
    
    boolean a(long param1Long, int param1Int1, int param1Int2, boolean param1Boolean) {
      if (!this.l) {
        com.ss.android.socialbase.downloader.f.a.c("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
        return false;
      } 
      return (this.b < param1Int1) ? false : ((this.i >= this.c) ? false : ((this.j && param1Int2 != 2) ? false : (!(!param1Boolean && param1Long - this.k < this.d))));
    }
    
    void b() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield i : I
      //   7: iconst_1
      //   8: iadd
      //   9: putfield i : I
      //   12: aload_0
      //   13: monitorexit
      //   14: return
      //   15: astore_1
      //   16: aload_0
      //   17: monitorexit
      //   18: aload_1
      //   19: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	15	finally
    }
    
    void c() {
      this.h = this.d;
    }
    
    int d() {
      return this.h;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */