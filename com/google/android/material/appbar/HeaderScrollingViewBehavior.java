package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
  final Rect a = new Rect();
  
  final Rect b = new Rect();
  
  private int c = 0;
  
  private int d;
  
  public HeaderScrollingViewBehavior() {}
  
  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private static int c(int paramInt) {
    int i = paramInt;
    if (paramInt == 0)
      i = 8388659; 
    return i;
  }
  
  float a(View paramView) {
    return 1.0F;
  }
  
  protected void a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt) {
    Rect rect;
    View view = b(paramCoordinatorLayout.getDependencies(paramView));
    if (view != null) {
      CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
      Rect rect1 = this.a;
      rect1.set(paramCoordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, view.getBottom() + layoutParams.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - layoutParams.rightMargin, paramCoordinatorLayout.getHeight() + view.getBottom() - paramCoordinatorLayout.getPaddingBottom() - layoutParams.bottomMargin);
      WindowInsetsCompat windowInsetsCompat = paramCoordinatorLayout.getLastWindowInsets();
      if (windowInsetsCompat != null && ViewCompat.getFitsSystemWindows((View)paramCoordinatorLayout) && !ViewCompat.getFitsSystemWindows(paramView)) {
        rect1.left += windowInsetsCompat.getSystemWindowInsetLeft();
        rect1.right -= windowInsetsCompat.getSystemWindowInsetRight();
      } 
      rect = this.b;
      GravityCompat.apply(c(layoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), rect1, rect, paramInt);
      paramInt = c(view);
      paramView.layout(rect.left, rect.top - paramInt, rect.right, rect.bottom - paramInt);
      this.c = rect.top - view.getBottom();
      return;
    } 
    super.a((CoordinatorLayout)rect, paramView, paramInt);
    this.c = 0;
  }
  
  protected boolean a() {
    return false;
  }
  
  int b(View paramView) {
    return paramView.getMeasuredHeight();
  }
  
  abstract View b(List<View> paramList);
  
  public final void b(int paramInt) {
    this.d = paramInt;
  }
  
  final int c() {
    return this.c;
  }
  
  final int c(View paramView) {
    if (this.d == 0)
      return 0; 
    float f = a(paramView);
    int i = this.d;
    return MathUtils.clamp((int)(f * i), 0, i);
  }
  
  public final int d() {
    return this.d;
  }
  
  public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = (paramView.getLayoutParams()).height;
    if (i == -1 || i == -2) {
      View view = b(paramCoordinatorLayout.getDependencies(paramView));
      if (view != null) {
        int j = View.MeasureSpec.getSize(paramInt3);
        if (j > 0) {
          paramInt3 = j;
          if (ViewCompat.getFitsSystemWindows(view)) {
            WindowInsetsCompat windowInsetsCompat = paramCoordinatorLayout.getLastWindowInsets();
            paramInt3 = j;
            if (windowInsetsCompat != null)
              paramInt3 = j + windowInsetsCompat.getSystemWindowInsetTop() + windowInsetsCompat.getSystemWindowInsetBottom(); 
          } 
        } else {
          paramInt3 = paramCoordinatorLayout.getHeight();
        } 
        paramInt3 += b(view);
        j = view.getMeasuredHeight();
        if (a()) {
          paramView.setTranslationY(-j);
        } else {
          paramInt3 -= j;
        } 
        if (i == -1) {
          j = 1073741824;
        } else {
          j = Integer.MIN_VALUE;
        } 
        paramCoordinatorLayout.onMeasureChild(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt3, j), paramInt4);
        return true;
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\appbar\HeaderScrollingViewBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */