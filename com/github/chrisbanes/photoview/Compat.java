package com.github.chrisbanes.photoview;

import android.os.Build;
import android.view.View;

class Compat {
  public static void a(View paramView, Runnable paramRunnable) {
    if (Build.VERSION.SDK_INT >= 16) {
      b(paramView, paramRunnable);
      return;
    } 
    paramView.postDelayed(paramRunnable, 16L);
  }
  
  private static void b(View paramView, Runnable paramRunnable) {
    paramView.postOnAnimation(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\chrisbanes\photoview\Compat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */