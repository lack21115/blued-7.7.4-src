package com.blued.android.module.im.grpc;

import android.os.Handler;

public class HeartBeat {
  private int a;
  
  private int b;
  
  private long c;
  
  private long d;
  
  private Runnable e;
  
  private Runnable f;
  
  private OnBeatListener g;
  
  private Handler h;
  
  public HeartBeat(Handler paramHandler) {
    this(paramHandler, 10000, 30000);
  }
  
  public HeartBeat(Handler paramHandler, int paramInt1, int paramInt2) {
    this.h = paramHandler;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private void c() {
    OnBeatListener onBeatListener = this.g;
    if (onBeatListener != null)
      onBeatListener.a(); 
    Runnable runnable = this.e;
    if (runnable != null)
      this.h.postDelayed(runnable, this.a); 
  }
  
  private void d() {
    long l = this.c - this.d;
    if (l > 0L && l < 3000L) {
      Runnable runnable = this.f;
      if (runnable != null) {
        this.h.removeCallbacks(runnable);
        this.h.postDelayed(this.f, l);
      } 
      this.d = this.c;
      return;
    } 
    OnBeatListener onBeatListener = this.g;
    if (onBeatListener != null)
      onBeatListener.b(); 
  }
  
  public void a() {
    if (this.f != null) {
      this.c = System.currentTimeMillis();
      if (this.c - this.d >= 3000L) {
        this.h.removeCallbacks(this.f);
        this.h.postDelayed(this.f, this.b);
        this.d = this.c;
      } 
    } 
  }
  
  public void a(OnBeatListener paramOnBeatListener) {
    this.g = paramOnBeatListener;
    if (this.e == null) {
      this.e = new Runnable(this) {
          public void run() {
            HeartBeat.a(this.a);
          }
        };
      this.h.postDelayed(this.e, this.a);
    } 
    if (this.f != null) {
      this.f = new Runnable(this) {
          public void run() {
            HeartBeat.b(this.a);
          }
        };
      this.h.postDelayed(this.f, this.b);
    } 
  }
  
  public void b() {
    this.g = null;
    Runnable runnable = this.f;
    if (runnable != null)
      this.h.removeCallbacks(runnable); 
    this.f = null;
    runnable = this.e;
    if (runnable != null)
      this.h.removeCallbacks(runnable); 
    this.e = null;
  }
  
  public static interface OnBeatListener {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\grpc\HeartBeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */