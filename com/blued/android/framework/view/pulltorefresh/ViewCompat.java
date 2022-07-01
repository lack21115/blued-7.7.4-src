package com.blued.android.framework.view.pulltorefresh;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class ViewCompat {
  public static void a(View paramView, Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT >= 16) {
      SDK16.a(paramView, paramDrawable);
      return;
    } 
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void a(View paramView, Runnable paramRunnable) {
    if (Build.VERSION.SDK_INT >= 16) {
      SDK16.a(paramView, paramRunnable);
      return;
    } 
    paramView.postDelayed(paramRunnable, 16L);
  }
  
  static class SDK11 {}
  
  static class SDK16 {
    public static void a(View param1View, Drawable param1Drawable) {
      param1View.setBackground(param1Drawable);
    }
    
    public static void a(View param1View, Runnable param1Runnable) {
      param1View.postOnAnimation(param1Runnable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\ViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */