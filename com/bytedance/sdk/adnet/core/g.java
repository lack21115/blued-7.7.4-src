package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.sdk.adnet.c.c;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class g implements c {
  private final Executor a;
  
  private final Executor b;
  
  private c c;
  
  public g(Handler paramHandler) {
    this.a = new Executor(this, paramHandler) {
        public void execute(Runnable param1Runnable) {
          this.a.post(param1Runnable);
        }
      };
    this.b = Executors.newCachedThreadPool();
    this.c = (c)f.a();
  }
  
  private Executor a(Request<?> paramRequest) {
    return (paramRequest == null || paramRequest.isResponseOnMain()) ? this.a : this.b;
  }
  
  public void a(Request<?> paramRequest, n<?> paramn) {
    a(paramRequest, paramn, null);
    c c1 = this.c;
    if (c1 != null)
      c1.a(paramRequest, paramn); 
  }
  
  public void a(Request<?> paramRequest, n<?> paramn, Runnable paramRunnable) {
    paramRequest.markDelivered();
    paramRequest.addMarker("post-response");
    a(paramRequest).execute(new a(paramRequest, paramn, paramRunnable));
    c c1 = this.c;
    if (c1 != null)
      c1.a(paramRequest, paramn); 
  }
  
  public void a(Request<?> paramRequest, VAdError paramVAdError) {
    paramRequest.addMarker("post-error");
    n<?> n = n.a(paramVAdError);
    a(paramRequest).execute(new a(paramRequest, n, null));
    c c1 = this.c;
    if (c1 != null)
      c1.a(paramRequest, (Exception)paramVAdError); 
  }
  
  static class a implements Runnable {
    private final Request a;
    
    private final n b;
    
    private final Runnable c;
    
    public a(Request param1Request, n param1n, Runnable param1Runnable) {
      this.a = param1Request;
      this.b = param1n;
      this.c = param1Runnable;
    }
    
    public void run() {
      if (this.a.isCanceled()) {
        this.a.a("canceled-at-delivery");
        return;
      } 
      this.b.g = this.a.getExtra();
      this.b.a(SystemClock.elapsedRealtime() - this.a.getStartTime());
      this.b.b(this.a.getNetDuration());
      if (this.b.a()) {
        try {
          this.a.a(this.b);
        } finally {
          Exception exception;
        } 
      } else {
        this.a.deliverError(this.b);
      } 
      if (this.b.d) {
        this.a.addMarker("intermediate-response");
      } else {
        this.a.a("done");
      } 
      Runnable runnable = this.c;
      if (runnable != null)
        try {
          return;
        } finally {
          runnable = null;
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */