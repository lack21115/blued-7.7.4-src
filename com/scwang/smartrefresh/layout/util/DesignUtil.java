package com.scwang.smartrefresh.layout.util;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;

public class DesignUtil {
  public static void a(View paramView, RefreshKernel paramRefreshKernel, CoordinatorLayoutListener paramCoordinatorLayoutListener) {
    try {
      return;
    } finally {
      paramView = null;
    } 
  }
  
  private static void a(ViewGroup paramViewGroup, CoordinatorLayoutListener paramCoordinatorLayoutListener) {
    for (int i = paramViewGroup.getChildCount() - 1; i >= 0; i--) {
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof AppBarLayout)
        ((AppBarLayout)view).a(new AppBarLayout.OnOffsetChangedListener(paramCoordinatorLayoutListener) {
              public void onOffsetChanged(AppBarLayout param1AppBarLayout, int param1Int) {
                boolean bool1;
                CoordinatorLayoutListener coordinatorLayoutListener = this.a;
                boolean bool2 = true;
                if (param1Int >= 0) {
                  bool1 = true;
                } else {
                  bool1 = false;
                } 
                if (param1AppBarLayout.getTotalScrollRange() + param1Int > 0)
                  bool2 = false; 
                coordinatorLayoutListener.a(bool1, bool2);
              }
            }); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layou\\util\DesignUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */