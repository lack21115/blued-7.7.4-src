package com.soft.blued.utils;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public class RefreshUtils {
  public static void a(AppBarLayout paramAppBarLayout) {
    if (paramAppBarLayout != null) {
      CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)paramAppBarLayout.getLayoutParams()).getBehavior();
      if (behavior instanceof AppBarLayout.Behavior) {
        AppBarLayout.Behavior behavior1 = (AppBarLayout.Behavior)behavior;
        if (behavior1.b() != 0)
          behavior1.a(0); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\RefreshUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */