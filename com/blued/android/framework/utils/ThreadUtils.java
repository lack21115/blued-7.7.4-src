package com.blued.android.framework.utils;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtils {
  private static final Handler a = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable) {
    if (a()) {
      paramRunnable.run();
      return;
    } 
    a.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong) {
    a.postDelayed(paramRunnable, paramLong);
  }
  
  public static boolean a() {
    return (Looper.getMainLooper() == Looper.myLooper());
  }
  
  public static void b(Runnable paramRunnable) {
    a.removeCallbacks(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\ThreadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */