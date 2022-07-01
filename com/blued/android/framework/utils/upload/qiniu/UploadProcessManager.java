package com.blued.android.framework.utils.upload.qiniu;

import android.os.Handler;
import android.os.HandlerThread;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.NetworkUtils;
import java.util.Random;

public class UploadProcessManager {
  private double a;
  
  private double b;
  
  private long c;
  
  private long d;
  
  private long e;
  
  private Runnable f;
  
  private boolean g = false;
  
  private IUpdateProcessListener h;
  
  private double i;
  
  private Handler j;
  
  private HandlerThread k;
  
  private Object l = new Object();
  
  private double m = 1.0D;
  
  private Random n = new Random(1L);
  
  public UploadProcessManager(IUpdateProcessListener paramIUpdateProcessListener) {
    this.h = paramIUpdateProcessListener;
    this.b = 0.0D;
    this.c = System.currentTimeMillis();
    long l = this.c;
    this.d = l;
    this.e = l;
    this.g = false;
    d();
  }
  
  private void a(Runnable paramRunnable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Landroid/os/Handler;
    //   6: ifnull -> 17
    //   9: aload_0
    //   10: getfield j : Landroid/os/Handler;
    //   13: aload_1
    //   14: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  private void a(Runnable paramRunnable, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Landroid/os/Handler;
    //   6: ifnull -> 27
    //   9: aload_0
    //   10: getfield j : Landroid/os/Handler;
    //   13: aload_1
    //   14: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   17: aload_0
    //   18: getfield j : Landroid/os/Handler;
    //   21: aload_1
    //   22: lload_2
    //   23: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   26: pop
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	30	finally
  }
  
  private void b(double paramDouble) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updateProcess | process：");
    stringBuilder.append(paramDouble);
    a(stringBuilder.toString());
    if ((paramDouble - this.b >= 1.0D || paramDouble == 99.0D) && paramDouble <= 100.0D) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("updateProcess | currentProcess：");
      stringBuilder.append(this.b);
      a(stringBuilder.toString());
      this.b = paramDouble;
      i();
      IUpdateProcessListener iUpdateProcessListener = this.h;
      if (iUpdateProcessListener != null)
        iUpdateProcessListener.a((int)this.b); 
    } 
  }
  
  private void d() {
    j();
    this.f = new Runnable(this) {
        public void run() {
          if (NetworkUtils.b()) {
            UploadProcessManager.a(this.a);
            return;
          } 
          UploadProcessManager.b(this.a);
        }
      };
    a(this.f, 200L);
  }
  
  private void e() {
    a("stopProcessSmoothness");
    a(this.f);
    k();
  }
  
  private void f() {
    if (this.g) {
      e();
      return;
    } 
    long l = System.currentTimeMillis() - this.d;
    if (l >= 200L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("autoIncrementProcess | 需要自增处理 currentProcess:");
      stringBuilder.append(b());
      stringBuilder.append(" | realProcess:");
      stringBuilder.append(this.a);
      a(stringBuilder.toString());
      if (this.a > 0.0D) {
        g();
        stringBuilder = new StringBuilder();
        stringBuilder.append("预估每秒增加的进度：");
        stringBuilder.append(this.i * 1000.0D);
        stringBuilder.append("%");
        a(stringBuilder.toString());
      } else {
        double d1;
        if (l > 5000L) {
          d1 = this.n.nextInt(6);
          this.i = d1 / 5000.0D;
        } else {
          d1 = this.n.nextInt(5);
          this.i = d1 / 1000.0D;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("随机每秒增加：");
        stringBuilder.append(d1);
        stringBuilder.append("%");
        a(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("自增每秒增加的进度：");
        stringBuilder.append(this.i * 1000.0D);
        stringBuilder.append("%");
        a(stringBuilder.toString());
      } 
      this.m = this.i * (System.currentTimeMillis() - this.e);
      stringBuilder = new StringBuilder();
      stringBuilder.append("autoIncrementProcess | 增加进度：");
      stringBuilder.append(this.m);
      stringBuilder.append("%");
      a(stringBuilder.toString());
      double d = b() + this.m;
      if (d <= 99.0D) {
        b(d);
      } else {
        b(99.0D);
        e();
        return;
      } 
    } 
    a(this.f, 200L);
  }
  
  private double g() {
    long l = System.currentTimeMillis() - this.c;
    double d1 = (long)((100L * l) / this.a);
    double d2 = l;
    this.i = (100.0D - b()) / (d1 - d2) * 1.0D;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("autoIncrementProcess | averageProcess：");
    stringBuilder.append(this.i);
    a(stringBuilder.toString());
    return this.i;
  }
  
  private void h() {
    this.d = System.currentTimeMillis();
  }
  
  private void i() {
    this.e = System.currentTimeMillis();
  }
  
  private void j() {
    if (this.k == null)
      this.k = new HandlerThread("UploadTaskHandle"); 
    HandlerThread handlerThread = this.k;
    if (handlerThread != null) {
      handlerThread.start();
      a("mHandlerThread.start()!!!");
    } 
    if (this.j == null)
      this.j = new Handler(this.k.getLooper()); 
  }
  
  private void k() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 'stopHandle()!!!'
    //   5: invokevirtual a : (Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield k : Landroid/os/HandlerThread;
    //   12: ifnull -> 28
    //   15: aload_0
    //   16: getfield k : Landroid/os/HandlerThread;
    //   19: invokevirtual quit : ()Z
    //   22: pop
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield k : Landroid/os/HandlerThread;
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield j : Landroid/os/Handler;
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	36	finally
    //   28	33	36	finally
  }
  
  public void a() {
    this.g = true;
    e();
  }
  
  public void a(double paramDouble) {
    this.a = paramDouble;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setCurrentProcess | realProcess：");
    stringBuilder.append(this.a);
    a(stringBuilder.toString());
    if (this.a > b()) {
      h();
      b(this.a);
    } 
  }
  
  protected void a(String paramString) {
    if (AppInfo.m())
      Logger.c(MediaSender.a, new Object[] { paramString }); 
  }
  
  public double b() {
    return this.b;
  }
  
  public void c() {
    this.g = true;
  }
  
  public static interface IUpdateProcessListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\UploadProcessManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */