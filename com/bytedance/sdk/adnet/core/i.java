package com.bytedance.sdk.adnet.core;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import com.bytedance.sdk.adnet.face.b;
import com.bytedance.sdk.adnet.face.c;
import java.util.concurrent.BlockingQueue;

class i extends Thread {
  private final BlockingQueue<Request<?>> a;
  
  private final b b;
  
  private final a c;
  
  private final c d;
  
  private volatile boolean e = false;
  
  public i(BlockingQueue<Request<?>> paramBlockingQueue, b paramb, a parama, c paramc) {
    this.a = paramBlockingQueue;
    this.b = paramb;
    this.c = parama;
    this.d = paramc;
  }
  
  private void a(Request<?> paramRequest, VAdError paramVAdError) {
    paramVAdError = paramRequest.a(paramVAdError);
    this.d.a(paramRequest, paramVAdError);
  }
  
  private void b() throws InterruptedException {
    a(this.a.take());
  }
  
  private void b(Request<?> paramRequest) {
    if (Build.VERSION.SDK_INT >= 14)
      TrafficStats.setThreadStatsTag(paramRequest.getTrafficStatsTag()); 
  }
  
  public void a() {
    this.e = true;
    interrupt();
  }
  
  void a(Request<?> paramRequest) {
    long l = SystemClock.elapsedRealtime();
    paramRequest.a(3);
    try {
      paramRequest.addMarker("network-queue-take");
      if (paramRequest.isCanceled()) {
        paramRequest.a("network-discard-cancelled");
        paramRequest.e();
        return;
      } 
      b(paramRequest);
      j j = this.b.a(paramRequest);
      paramRequest.setNetDuration(j.f);
      paramRequest.addMarker("network-http-complete");
      if (j.e && paramRequest.hasHadResponseDelivered()) {
        paramRequest.a("not-modified");
        paramRequest.e();
        return;
      } 
      n<?> n = paramRequest.a(j);
      paramRequest.setNetDuration(j.f);
      paramRequest.addMarker("network-parse-complete");
      if (paramRequest.shouldCache() && n.b != null) {
        this.c.a(paramRequest.getCacheKey(), n.b);
        paramRequest.addMarker("network-cache-written");
      } 
      paramRequest.markDelivered();
      this.d.a(paramRequest, n);
    } catch (VAdError vAdError) {
      vAdError.a(SystemClock.elapsedRealtime() - l);
      a(paramRequest, vAdError);
    } catch (Exception exception) {
      p.a(exception, "Unhandled exception %s", new Object[] { exception.toString() });
      VAdError vAdError = new VAdError(exception);
      vAdError.a(SystemClock.elapsedRealtime() - l);
      this.d.a(paramRequest, vAdError);
    } finally {
      null = null;
    } 
    paramRequest.a(4);
  }
  
  public void run() {
    Process.setThreadPriority(10);
    while (true) {
      try {
        while (true)
          b(); 
        break;
      } catch (InterruptedException interruptedException) {
        if (this.e) {
          Thread.currentThread().interrupt();
          return;
        } 
        p.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */