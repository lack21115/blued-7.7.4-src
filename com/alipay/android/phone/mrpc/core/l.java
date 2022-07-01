package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l implements ab {
  private static l b;
  
  private static final ThreadFactory i = new n();
  
  Context a;
  
  private ThreadPoolExecutor c;
  
  private b d;
  
  private long e;
  
  private long f;
  
  private long g;
  
  private int h;
  
  private l(Context paramContext) {
    this.a = paramContext;
    this.d = b.a("android");
    this.c = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
    try {
      this.c.allowCoreThreadTimeOut(true);
    } catch (Exception exception) {}
    CookieSyncManager.createInstance(this.a);
    CookieManager.getInstance().setAcceptCookie(true);
  }
  
  public static final l a(Context paramContext) {
    l l1 = b;
    return (l1 != null) ? l1 : b(paramContext);
  }
  
  private static final l b(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/android/phone/mrpc/core/l
    //   2: monitorenter
    //   3: getstatic com/alipay/android/phone/mrpc/core/l.b : Lcom/alipay/android/phone/mrpc/core/l;
    //   6: ifnull -> 18
    //   9: getstatic com/alipay/android/phone/mrpc/core/l.b : Lcom/alipay/android/phone/mrpc/core/l;
    //   12: astore_0
    //   13: ldc com/alipay/android/phone/mrpc/core/l
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new com/alipay/android/phone/mrpc/core/l
    //   21: dup
    //   22: aload_0
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: astore_0
    //   27: aload_0
    //   28: putstatic com/alipay/android/phone/mrpc/core/l.b : Lcom/alipay/android/phone/mrpc/core/l;
    //   31: ldc com/alipay/android/phone/mrpc/core/l
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: astore_0
    //   37: ldc com/alipay/android/phone/mrpc/core/l
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	36	finally
    //   18	31	36	finally
  }
  
  public final b a() {
    return this.d;
  }
  
  public final Future<u> a(t paramt) {
    if (s.a(this.a)) {
      StringBuilder stringBuilder = new StringBuilder("HttpManager");
      stringBuilder.append(hashCode());
      stringBuilder.append(": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times");
      String str = stringBuilder.toString();
      int i = this.c.getActiveCount();
      long l3 = this.c.getCompletedTaskCount();
      long l4 = this.c.getTaskCount();
      long l1 = this.g;
      long l2 = 0L;
      if (l1 == 0L) {
        l1 = 0L;
      } else {
        l1 = this.e * 1000L / l1 >> 10L;
      } 
      int j = this.h;
      if (j != 0)
        l2 = this.f / j; 
      String.format(str, new Object[] { Integer.valueOf(i), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g), Integer.valueOf(this.h) });
    } 
    q q = new q(this, (o)paramt);
    m m = new m(this, q, q);
    this.c.execute(m);
    return m;
  }
  
  public final void a(long paramLong) {
    this.e += paramLong;
  }
  
  public final void b(long paramLong) {
    this.f += paramLong;
    this.h++;
  }
  
  public final void c(long paramLong) {
    this.g += paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */