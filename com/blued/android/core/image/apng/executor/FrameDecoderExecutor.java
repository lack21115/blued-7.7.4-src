package com.blued.android.core.image.apng.executor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class FrameDecoderExecutor {
  private HandlerThread a = null;
  
  private Handler b = null;
  
  private volatile Looper c = null;
  
  private FrameDecoderExecutor() {}
  
  public static FrameDecoderExecutor a() {
    return Inner.a;
  }
  
  public void a(Runnable paramRunnable) {
    b().removeCallbacks(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong) {
    b().postDelayed(paramRunnable, paramLong);
  }
  
  public Handler b() {
    if (this.b == null)
      synchronized (Inner.a) {
        if (this.b == null) {
          this.a = new HandlerThread("FrameDecoderExecutor");
          this.a.start();
          this.c = this.a.getLooper();
          this.b = new Handler(this.c);
        } 
      }  
    return this.b;
  }
  
  public void b(Runnable paramRunnable) {
    b().post(paramRunnable);
  }
  
  public boolean c() {
    return (Looper.myLooper() == this.c);
  }
  
  static class Inner {
    static final FrameDecoderExecutor a = new FrameDecoderExecutor();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\executor\FrameDecoderExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */