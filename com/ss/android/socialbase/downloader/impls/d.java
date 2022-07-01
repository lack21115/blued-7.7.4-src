package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.ss.android.socialbase.downloader.c.e;
import com.ss.android.socialbase.downloader.c.f;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.n;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.l.f;
import com.ss.android.socialbase.downloader.m.f;
import com.ss.android.socialbase.downloader.m.k;
import java.util.List;

public class d implements k {
  private final k a = new k();
  
  private s b;
  
  private volatile boolean c;
  
  private volatile boolean d;
  
  private f.a e = new f.a(this) {
      public void a(Message param1Message) {
        if (param1Message.what == 1)
          b.k().execute(new Runnable(this) {
                public void run() {
                  try {
                    k.a();
                    this.a.a.h();
                    return;
                  } catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                  } 
                }
              }); 
      }
    };
  
  private f f = null;
  
  public d() {
    if (a.b().a("fix_sigbus_downloader_db")) {
      if (f.a()) {
        this.b = (s)new e();
      } else {
        f f1 = new f();
        f1.a(new f.a(this) {
              public void a() {
                d.a(this.a, (s)new e());
                Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
              }
            });
        this.b = (s)f1;
      } 
    } else {
      this.b = (s)new e();
    } 
    this.c = false;
    this.f = new f(Looper.getMainLooper(), this.e);
    f();
  }
  
  private void a(c paramc, boolean paramBoolean) {
    if (paramc == null)
      return; 
    if (f.b()) {
      if (paramBoolean) {
        n n = l.a(true);
        if (n != null) {
          n.c(paramc);
          return;
        } 
        this.b.a(paramc);
        return;
      } 
    } else {
      this.b.a(paramc);
    } 
  }
  
  private void c(c paramc) {
    a(paramc, true);
  }
  
  private void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield c : Z
    //   7: aload_0
    //   8: invokevirtual notifyAll : ()V
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	14	finally
    //   15	17	14	finally
  }
  
  public c a(int paramInt1, int paramInt2) {
    c c = this.a.a(paramInt1, paramInt2);
    c(c);
    return c;
  }
  
  public c a(int paramInt, long paramLong) {
    c c = this.a.a(paramInt, paramLong);
    a(c, false);
    return c;
  }
  
  public c a(int paramInt, long paramLong, String paramString1, String paramString2) {
    c c = this.a.a(paramInt, paramLong, paramString1, paramString2);
    c(c);
    return c;
  }
  
  public k a() {
    return this.a;
  }
  
  public List<c> a(String paramString) {
    return this.a.a(paramString);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (f.b()) {
      n n = l.a(true);
      if (n != null) {
        n.a(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      } 
      this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    if (f.b()) {
      n n = l.a(true);
      if (n != null) {
        n.a(paramInt1, paramInt2, paramInt3, paramLong);
        return;
      } 
      this.b.a(paramInt1, paramInt2, paramInt3, paramLong);
      return;
    } 
    this.b.a(paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong) {
    this.a.a(paramInt1, paramInt2, paramLong);
    if (f.b()) {
      n n = l.a(true);
      if (n != null) {
        n.a(paramInt1, paramInt2, paramLong);
        return;
      } 
      this.b.a(paramInt1, paramInt2, paramLong);
      return;
    } 
    this.b.a(paramInt1, paramInt2, paramLong);
  }
  
  public void a(int paramInt, List<b> paramList) {
    if (paramList != null) {
      if (paramList.size() == 0)
        return; 
      this.a.a(paramInt, paramList);
      if (f.c())
        this.b.b(paramInt, paramList); 
    } 
  }
  
  public void a(b paramb) {
    this.a.a(paramb);
    if (f.b()) {
      n n = l.a(true);
      if (n != null) {
        n.a(paramb);
        return;
      } 
      this.b.a(paramb);
      return;
    } 
    this.b.a(paramb);
  }
  
  public boolean a(c paramc) {
    if (paramc == null)
      return false; 
    boolean bool = this.a.a(paramc);
    c(paramc);
    return bool;
  }
  
  public c b(int paramInt) {
    return this.a.b(paramInt);
  }
  
  public c b(int paramInt, long paramLong) {
    c c = this.a.b(paramInt, paramLong);
    b(paramInt, (List<b>)null);
    return c;
  }
  
  public List<c> b(String paramString) {
    return this.a.b(paramString);
  }
  
  public void b() {
    try {
      this.a.b();
    } catch (SQLiteException sQLiteException) {
      sQLiteException.printStackTrace();
    } 
    if (f.b()) {
      n n = l.a(true);
      if (n != null) {
        n.f();
        return;
      } 
      this.b.b();
      return;
    } 
    this.b.b();
  }
  
  public void b(int paramInt, List<b> paramList) {
    try {
      a(this.a.b(paramInt));
      List<b> list = paramList;
      if (paramList == null)
        list = this.a.c(paramInt); 
      if (f.b()) {
        n n = l.a(true);
        if (n != null) {
          n.b(paramInt, list);
          return;
        } 
        this.b.b(paramInt, list);
        return;
      } 
      this.b.b(paramInt, list);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void b(b paramb) {
    if (f.b()) {
      n n = l.a(true);
      if (n != null) {
        n.a(paramb);
        return;
      } 
      this.b.a(paramb);
      return;
    } 
    this.b.a(paramb);
  }
  
  public void b(c paramc) {
    if (paramc == null)
      return; 
    this.a.a(paramc);
  }
  
  public c c(int paramInt, long paramLong) {
    c c = this.a.c(paramInt, paramLong);
    b(paramInt, (List<b>)null);
    return c;
  }
  
  public List<b> c(int paramInt) {
    return this.a.c(paramInt);
  }
  
  public List<c> c(String paramString) {
    return this.a.c(paramString);
  }
  
  public boolean c() {
    return this.c;
  }
  
  public c d(int paramInt, long paramLong) {
    c c = this.a.d(paramInt, paramLong);
    b(paramInt, (List<b>)null);
    return c;
  }
  
  public List<c> d(String paramString) {
    return this.a.d(paramString);
  }
  
  public void d(int paramInt) {
    this.a.d(paramInt);
    if (f.b()) {
      n n = l.a(true);
      if (n != null) {
        n.o(paramInt);
        return;
      } 
      this.b.d(paramInt);
      return;
    } 
    this.b.d(paramInt);
  }
  
  public boolean d() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Z
    //   4: ifeq -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield c : Z
    //   15: ifne -> 47
    //   18: ldc 'DefaultDownloadCache'
    //   20: ldc 'ensureDownloadCacheSyncSuccess: waiting start!!!!'
    //   22: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: ldc2_w 5000
    //   29: invokevirtual wait : (J)V
    //   32: goto -> 40
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual printStackTrace : ()V
    //   40: ldc 'DefaultDownloadCache'
    //   42: ldc 'ensureDownloadCacheSyncSuccess: waiting end!!!!'
    //   44: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: getfield c : Z
    //   53: ireturn
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   11	25	54	finally
    //   25	32	35	java/lang/InterruptedException
    //   25	32	54	finally
    //   36	40	54	finally
    //   40	47	54	finally
    //   47	49	54	finally
    //   55	57	54	finally
  }
  
  public s e() {
    return this.b;
  }
  
  public boolean e(int paramInt) {
    try {
      if (f.b()) {
        n n = l.a(true);
        if (n != null) {
          n.n(paramInt);
        } else {
          this.b.e(paramInt);
        } 
      } else {
        this.b.e(paramInt);
      } 
    } catch (SQLiteException sQLiteException) {
      sQLiteException.printStackTrace();
    } 
    return this.a.e(paramInt);
  }
  
  public void f() {
    b.a(com.ss.android.socialbase.downloader.b.d.b);
    this.b.a(this.a.a(), this.a.e(), new com.ss.android.socialbase.downloader.c.d(this) {
          public void a() {
            d.a(this.a);
            this.a.g();
            b.a(com.ss.android.socialbase.downloader.b.d.c);
          }
        });
  }
  
  public boolean f(int paramInt) {
    if (f.b()) {
      n n = l.a(true);
      if (n != null) {
        n.p(paramInt);
      } else {
        this.b.f(paramInt);
      } 
    } else {
      this.b.f(paramInt);
    } 
    return this.a.f(paramInt);
  }
  
  public c g(int paramInt) {
    c c = this.a.g(paramInt);
    c(c);
    return c;
  }
  
  public void g() {
    long l;
    if (a.b().a("task_resume_delay")) {
      l = 4000L;
    } else if (Build.VERSION.SDK_INT >= 23) {
      l = 1000L;
    } else {
      l = 5000L;
    } 
    Message message = this.f.obtainMessage(1);
    this.f.sendMessageDelayed(message, l);
  }
  
  public c h(int paramInt) {
    c c = this.a.h(paramInt);
    c(c);
    return c;
  }
  
  public void h() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Z
    //   4: ifne -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield d : Z
    //   12: ifeq -> 24
    //   15: ldc 'DefaultDownloadCache'
    //   17: ldc_w 'resumeUnCompleteTask: has resumed, return!!!'
    //   20: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   23: return
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield d : Z
    //   29: invokestatic a : ()Z
    //   32: ifne -> 36
    //   35: return
    //   36: invokestatic o : ()Lcom/ss/android/socialbase/downloader/downloader/m;
    //   39: astore #4
    //   41: aload #4
    //   43: ifnonnull -> 47
    //   46: return
    //   47: aload #4
    //   49: invokeinterface a : ()Ljava/util/List;
    //   54: astore #5
    //   56: aload #5
    //   58: ifnull -> 204
    //   61: aload #5
    //   63: invokeinterface isEmpty : ()Z
    //   68: ifeq -> 72
    //   71: return
    //   72: aload_0
    //   73: getfield a : Lcom/ss/android/socialbase/downloader/impls/k;
    //   76: invokevirtual a : ()Landroid/util/SparseArray;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnonnull -> 85
    //   84: return
    //   85: new java/util/ArrayList
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore #6
    //   94: aload_3
    //   95: monitorenter
    //   96: iconst_0
    //   97: istore_1
    //   98: iload_1
    //   99: aload_3
    //   100: invokevirtual size : ()I
    //   103: if_icmpge -> 175
    //   106: aload_3
    //   107: iload_1
    //   108: invokevirtual keyAt : (I)I
    //   111: istore_2
    //   112: iload_2
    //   113: ifne -> 119
    //   116: goto -> 205
    //   119: aload_3
    //   120: iload_2
    //   121: invokevirtual get : (I)Ljava/lang/Object;
    //   124: checkcast com/ss/android/socialbase/downloader/g/c
    //   127: astore #7
    //   129: aload #7
    //   131: ifnull -> 205
    //   134: aload #5
    //   136: aload #7
    //   138: invokevirtual ah : ()Ljava/lang/String;
    //   141: invokeinterface contains : (Ljava/lang/Object;)Z
    //   146: ifeq -> 205
    //   149: aload #7
    //   151: invokevirtual w : ()I
    //   154: bipush #-2
    //   156: if_icmpne -> 162
    //   159: goto -> 205
    //   162: aload #6
    //   164: aload #7
    //   166: invokeinterface add : (Ljava/lang/Object;)Z
    //   171: pop
    //   172: goto -> 205
    //   175: aload_3
    //   176: monitorexit
    //   177: aload #6
    //   179: invokeinterface isEmpty : ()Z
    //   184: ifne -> 196
    //   187: aload #4
    //   189: aload #6
    //   191: invokeinterface a : (Ljava/util/List;)V
    //   196: return
    //   197: astore #4
    //   199: aload_3
    //   200: monitorexit
    //   201: aload #4
    //   203: athrow
    //   204: return
    //   205: iload_1
    //   206: iconst_1
    //   207: iadd
    //   208: istore_1
    //   209: goto -> 98
    // Exception table:
    //   from	to	target	type
    //   98	112	197	finally
    //   119	129	197	finally
    //   134	159	197	finally
    //   162	172	197	finally
    //   175	177	197	finally
    //   199	201	197	finally
  }
  
  public c i(int paramInt) {
    c c = this.a.i(paramInt);
    c(c);
    return c;
  }
  
  public c j(int paramInt) {
    c c = this.a.j(paramInt);
    c(c);
    return c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */