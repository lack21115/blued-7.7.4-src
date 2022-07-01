package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class Executors {
  private static final Executor a = new Executor() {
      private final Handler a = new Handler(Looper.getMainLooper());
      
      public void execute(Runnable param1Runnable) {
        this.a.post(param1Runnable);
      }
    };
  
  private static final Executor b = new Executor() {
      public void execute(Runnable param1Runnable) {
        param1Runnable.run();
      }
    };
  
  public static Executor a() {
    return a;
  }
  
  public static Executor b() {
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\Executors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */