package com.brandongogetap.stickyheaders;

import android.view.View;

final class Preconditions {
  static <T> T a(T paramT, String paramString) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(paramString);
  }
  
  static void a(View paramView) {
    paramView = (View)paramView.getParent();
    if (!(paramView instanceof android.widget.FrameLayout)) {
      if (paramView instanceof androidx.coordinatorlayout.widget.CoordinatorLayout)
        return; 
      throw new IllegalArgumentException("RecyclerView parent must be either a FrameLayout or CoordinatorLayout");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\brandongogetap\stickyheaders\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */