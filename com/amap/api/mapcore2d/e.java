package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Looper;

abstract class e {
  protected int a;
  
  protected int b;
  
  private Handler c = null;
  
  private int d = 0;
  
  private boolean e = false;
  
  private boolean f = true;
  
  private Runnable g = new Runnable(this) {
      public void run() {
        e.a(this.a);
        if (!this.a.f()) {
          if (e.b(this.a) != null)
            e.b(this.a).removeCallbacks(this); 
          e.a(this.a, null);
          if (e.c(this.a)) {
            this.a.c();
            return;
          } 
          this.a.b();
          return;
        } 
        long l = System.currentTimeMillis();
        this.a.a();
        e.d(this.a);
        l = System.currentTimeMillis() - l;
        if (l < this.a.b)
          try {
            Thread.sleep(this.a.b - l);
            return;
          } catch (InterruptedException interruptedException) {
            cm.a(interruptedException, "AnimBase", "run");
          }  
      }
    };
  
  public e(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private void g() {
    this.e = false;
  }
  
  private void h() {
    this.d += this.b;
    int i = this.a;
    if (i != -1 && this.d > i) {
      g();
      b(true);
    } 
  }
  
  private void i() {
    Handler handler = this.c;
    if (handler != null)
      handler.post(this.g); 
  }
  
  protected abstract void a();
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  protected abstract void b();
  
  public void b(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  protected abstract void c();
  
  public void d() {
    if (!f()) {
      this.c = new Handler(Looper.getMainLooper());
      this.e = true;
      this.f = false;
      this.d = 0;
    } 
    i();
  }
  
  public void e() {
    n.a().b();
    g();
    this.g.run();
  }
  
  public boolean f() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */