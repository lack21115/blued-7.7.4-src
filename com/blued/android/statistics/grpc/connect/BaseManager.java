package com.blued.android.statistics.grpc.connect;

import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.util.LoopQueue;
import com.blued.android.statistics.util.Utils;

public abstract class BaseManager<Request> {
  private LoopQueue a = new LoopQueue(40);
  
  private long b = 0L;
  
  private long c = 0L;
  
  private long d = 0L;
  
  private Runnable e = new Runnable(this) {
      public void run() {
        if (!this.a.c())
          return; 
        if (!ConnectManager.b())
          return; 
        synchronized (BaseManager.a(this.a)) {
          if (BaseManager.a(this.a).b() > 0) {
            Object[] arrayOfObject = BaseManager.a(this.a).a(30);
            if (arrayOfObject != null && arrayOfObject.length > 0)
              this.a.a(arrayOfObject); 
          } 
          return;
        } 
      }
    };
  
  private void a() {
    Utils.a(this.e);
    this.b = this.d + b();
    this.c = this.d;
  }
  
  private void d() {
    Utils.a(this.e, this.b - this.d);
    this.c = this.b;
  }
  
  public void a(Request paramRequest) {
    if (!c())
      return; 
    synchronized (this.a) {
      Utils.b(this.e);
      this.a.a(paramRequest);
      this.d = System.currentTimeMillis();
      if (0L == this.c) {
        this.c = this.d;
        this.b = this.d + b();
      } 
      if (this.a.b() >= 30) {
        a();
      } else if (this.d < this.b) {
        d();
      } else if (this.d >= this.c + b()) {
        a();
      } else {
        this.b += b();
        d();
      } 
      return;
    } 
  }
  
  protected abstract void a(Object[] paramArrayOfObject);
  
  protected abstract long b();
  
  protected boolean c() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\connect\BaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */