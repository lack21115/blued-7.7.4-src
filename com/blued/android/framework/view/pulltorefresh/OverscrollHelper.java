package com.blued.android.framework.view.pulltorefresh;

import android.view.View;

public final class OverscrollHelper {
  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean) {
    if (null.a[paramPullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] != 1) {
      paramInt1 = paramPullToRefreshBase.getScrollY();
      paramInt2 = paramInt3;
      paramInt3 = paramInt1;
    } else {
      paramInt3 = paramPullToRefreshBase.getScrollX();
      paramInt4 = paramInt2;
      paramInt2 = paramInt1;
    } 
    if (paramPullToRefreshBase.h() && !paramPullToRefreshBase.i()) {
      PullToRefreshBase.Mode mode = paramPullToRefreshBase.getMode();
      if (mode.b() && !paramBoolean && paramInt2 != 0) {
        paramInt1 = paramInt2 + paramInt4;
        if (paramInt1 < 0 - paramInt6) {
          if (mode.c()) {
            if (paramInt3 == 0)
              paramPullToRefreshBase.a(PullToRefreshBase.State.f, new boolean[0]); 
            paramPullToRefreshBase.setHeaderScroll((int)(paramFloat * (paramInt3 + paramInt1)));
            return;
          } 
        } else if (paramInt1 > paramInt5 + paramInt6) {
          if (mode.d()) {
            if (paramInt3 == 0)
              paramPullToRefreshBase.a(PullToRefreshBase.State.f, new boolean[0]); 
            paramPullToRefreshBase.setHeaderScroll((int)(paramFloat * (paramInt3 + paramInt1 - paramInt5)));
            return;
          } 
        } else if (Math.abs(paramInt1) <= paramInt6 || Math.abs(paramInt1 - paramInt5) <= paramInt6) {
          paramPullToRefreshBase.a(PullToRefreshBase.State.a, new boolean[0]);
          return;
        } 
      } else if (paramBoolean && PullToRefreshBase.State.f == paramPullToRefreshBase.getState()) {
        paramPullToRefreshBase.a(PullToRefreshBase.State.a, new boolean[0]);
      } 
    } 
  }
  
  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
    a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 1.0F, paramBoolean);
  }
  
  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramBoolean);
  }
  
  static boolean a(View paramView) {
    return (paramView.getOverScrollMode() != 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\OverscrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */