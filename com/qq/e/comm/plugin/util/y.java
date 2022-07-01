package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;

public class y {
  private static Handler a;
  
  private static Handler a() {
    if (a == null)
      a = new Handler(Looper.getMainLooper()); 
    return a;
  }
  
  public static final void a(Object paramObject) {
    a().removeCallbacksAndMessages(paramObject);
  }
  
  public static final boolean a(Runnable paramRunnable) {
    return a().post(paramRunnable);
  }
  
  public static final boolean a(Runnable paramRunnable, long paramLong) {
    return a().postDelayed(paramRunnable, paramLong);
  }
  
  public static final boolean b(Runnable paramRunnable) {
    return a().postAtFrontOfQueue(paramRunnable);
  }
  
  public static final void c(Runnable paramRunnable) {
    a().removeCallbacks(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */