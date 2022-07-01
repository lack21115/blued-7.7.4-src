package com.bytedance.sdk.openadsdk.i;

import com.bytedance.sdk.openadsdk.utils.t;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {
  private static volatile a a;
  
  private static volatile ThreadPoolExecutor b;
  
  private static volatile ThreadPoolExecutor c;
  
  private static volatile ThreadPoolExecutor d;
  
  private static volatile ThreadPoolExecutor e;
  
  private static volatile ScheduledExecutorService f;
  
  private static ConcurrentHashMap<String, c> g;
  
  private static final ConcurrentHashMap<String, c> h = new ConcurrentHashMap<String, c>();
  
  private static final ConcurrentHashMap<String, c> i = new ConcurrentHashMap<String, c>();
  
  private static final ConcurrentHashMap<String, c> j = new ConcurrentHashMap<String, c>();
  
  private static final AtomicBoolean k = new AtomicBoolean();
  
  private a() {
    if (!k.get())
      a(false); 
  }
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/i/a.a : Lcom/bytedance/sdk/openadsdk/i/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/i/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/i/a.a : Lcom/bytedance/sdk/openadsdk/i/a;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/i/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/i/a.a : Lcom/bytedance/sdk/openadsdk/i/a;
    //   25: ldc com/bytedance/sdk/openadsdk/i/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/i/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/i/a.a : Lcom/bytedance/sdk/openadsdk/i/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static void a(boolean paramBoolean) {
    if (k.get())
      return; 
    b = e.a();
    c = e.b();
    f = e.c();
    e = e.e();
    if (paramBoolean) {
      d = e.d();
      g = new ConcurrentHashMap<String, c>();
    } 
    k.set(true);
  }
  
  private void c() {
    if (d == null) {
      d = e.d();
      g = new ConcurrentHashMap<String, c>();
    } 
  }
  
  public ScheduledFuture<?> a(Runnable paramRunnable, long paramLong) {
    if (paramRunnable == null) {
      if (t.c())
        t.e("", "delayExecuteTask->runnable param is not be null"); 
      return null;
    } 
    if (paramLong <= 0L) {
      f.execute(paramRunnable);
      return null;
    } 
    return f.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void a(c paramc) {
    if (paramc == null) {
      if (t.c())
        t.e("", "executeApiTask->TTRunnable param is not be null"); 
      return;
    } 
    if (b != null)
      b.execute(paramc); 
  }
  
  public void a(Runnable paramRunnable, int paramInt) {
    if (paramRunnable == null) {
      if (t.c())
        t.e("", "executeAIDLTask -> runnable param is not be null"); 
      return;
    } 
    c();
    d.execute(new c(this, paramInt, paramRunnable) {
          public void run() {
            this.a.run();
          }
        });
  }
  
  public ExecutorService b() {
    if (e == null)
      e = e.e(); 
    return e;
  }
  
  public void b(c paramc) {
    if (paramc == null) {
      if (t.c())
        t.e("", "executeDefaultTask -> runnable param is not be null"); 
      return;
    } 
    if (c != null)
      c.execute(paramc); 
  }
  
  public void b(Runnable paramRunnable, int paramInt) {
    if (paramRunnable == null) {
      if (t.c())
        t.e("", "executeApiTask->runnable param is not be null"); 
      return;
    } 
    if (b != null)
      b.execute(new c(this, paramInt, paramRunnable) {
            public void run() {
              this.a.run();
            }
          }); 
  }
  
  public void c(Runnable paramRunnable, int paramInt) {
    if (paramRunnable == null) {
      if (t.c())
        t.e("", "executeDefaultTask -> runnable param is not be null"); 
      return;
    } 
    if (c != null)
      c.execute(new c(this, paramInt, paramRunnable) {
            public void run() {
              this.a.run();
            }
          }); 
  }
  
  public void d(Runnable paramRunnable, int paramInt) {
    if (paramRunnable == null) {
      if (t.c())
        t.e("", "executeLogUploadTask（Runnable） -> runnable param is not be null"); 
      return;
    } 
    if (e != null)
      e.execute(new c(this, paramInt, paramRunnable) {
            public void run() {
              this.a.run();
            }
          }); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */