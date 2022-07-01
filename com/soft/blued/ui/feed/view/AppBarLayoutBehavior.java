package com.soft.blued.ui.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

public class AppBarLayoutBehavior extends AppBarLayout.Behavior {
  private boolean b;
  
  private boolean c;
  
  public AppBarLayoutBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private Field c() throws NoSuchFieldException {
    try {
      return getClass().getSuperclass().getSuperclass().getDeclaredField("mFlingRunnable");
    } catch (NoSuchFieldException noSuchFieldException) {
      return getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("flingRunnable");
    } 
  }
  
  private Field d() throws NoSuchFieldException {
    try {
      return getClass().getSuperclass().getSuperclass().getDeclaredField("mScroller");
    } catch (NoSuchFieldException noSuchFieldException) {
      return getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("scroller");
    } 
  }
  
  private void d(AppBarLayout paramAppBarLayout) {
    try {
      Field field1 = c();
      Field field2 = d();
      field1.setAccessible(true);
      field2.setAccessible(true);
      Runnable runnable = (Runnable)field1.get(this);
      OverScroller overScroller = (OverScroller)field2.get(this);
      if (runnable != null) {
        paramAppBarLayout.removeCallbacks(runnable);
        field1.set(this, (Object)null);
      } 
      if (overScroller != null && !overScroller.isFinished()) {
        overScroller.abortAnimation();
        return;
      } 
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      return;
    } 
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt) {
    super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt);
    this.b = false;
    this.c = false;
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (!this.c)
      super.onNestedScroll(paramCoordinatorLayout, (View)paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5); 
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
    if (paramInt3 == 1)
      this.b = true; 
    if (!this.c)
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfint, paramInt3); 
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, MotionEvent paramMotionEvent) {
    this.c = false;
    if (this.b)
      this.c = true; 
    if (paramMotionEvent.getActionMasked() == 0)
      d(paramAppBarLayout); 
    return super.onInterceptTouchEvent(paramCoordinatorLayout, (View)paramAppBarLayout, paramMotionEvent);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2) {
    d(paramAppBarLayout);
    return super.a(paramCoordinatorLayout, paramAppBarLayout, paramView1, paramView2, paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\view\AppBarLayoutBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */