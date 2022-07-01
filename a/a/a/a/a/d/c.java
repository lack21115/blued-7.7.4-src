package a.a.a.a.a.d;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class c {
  public static c a;
  
  public static f b;
  
  public static boolean c = false;
  
  public ScheduledExecutorService d;
  
  public boolean e = true;
  
  public c() {
    c();
  }
  
  public static c a() {
    // Byte code:
    //   0: ldc a/a/a/a/a/d/c
    //   2: monitorenter
    //   3: getstatic a/a/a/a/a/d/c.a : La/a/a/a/a/d/c;
    //   6: ifnonnull -> 19
    //   9: new a/a/a/a/a/d/c
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic a/a/a/a/a/d/c.a : La/a/a/a/a/d/c;
    //   19: getstatic a/a/a/a/a/d/c.a : La/a/a/a/a/d/c;
    //   22: astore_0
    //   23: ldc a/a/a/a/a/d/c
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc a/a/a/a/a/d/c
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public static void a(Context paramContext) {
    if (c)
      return; 
    c = true;
    f f1 = f.a();
    b = f1;
    f1.a(paramContext);
  }
  
  public boolean b() {
    return this.e;
  }
  
  public final void c() {
    this.d = Executors.newScheduledThreadPool(1);
    long l = b.a("method_report_last_time_ms");
    l = System.currentTimeMillis() - l;
    if (l >= 86400000L) {
      this.d.scheduleWithFixedDelay(new d(), 0L, 86400000L, TimeUnit.MILLISECONDS);
      return;
    } 
    this.d.scheduleWithFixedDelay(new d(), 86400000L - l, 86400000L, TimeUnit.MILLISECONDS);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */