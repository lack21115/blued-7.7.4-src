package com.blued.android.framework.qrcode.decoding;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class InactivityTimer {
  private final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory());
  
  private final Activity b;
  
  private ScheduledFuture<?> c = null;
  
  public InactivityTimer(Activity paramActivity) {
    this.b = paramActivity;
    a();
  }
  
  private void c() {
    ScheduledFuture<?> scheduledFuture = this.c;
    if (scheduledFuture != null) {
      scheduledFuture.cancel(true);
      this.c = null;
    } 
  }
  
  public void a() {
    c();
    this.c = this.a.schedule(new FinishListener(this.b), 300L, TimeUnit.SECONDS);
  }
  
  public void b() {
    c();
    this.a.shutdown();
  }
  
  static final class DaemonThreadFactory implements ThreadFactory {
    private DaemonThreadFactory() {}
    
    public Thread newThread(Runnable param1Runnable) {
      param1Runnable = new Thread(param1Runnable);
      param1Runnable.setDaemon(true);
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\decoding\InactivityTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */