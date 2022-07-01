package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
  private int a = 0;
  
  private int b = 2;
  
  private int c = 0;
  
  private ViewPropertyAnimator d;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator) {
    this.d = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            HideBottomViewOnScrollBehavior.a(this.a, (ViewPropertyAnimator)null);
          }
        });
  }
  
  public void a(V paramV) {
    if (this.b == 2)
      return; 
    ViewPropertyAnimator viewPropertyAnimator = this.d;
    if (viewPropertyAnimator != null) {
      viewPropertyAnimator.cancel();
      paramV.clearAnimation();
    } 
    this.b = 2;
    a(paramV, 0, 225L, AnimationUtils.d);
  }
  
  public void a(V paramV, int paramInt) {
    this.c = paramInt;
    if (this.b == 1)
      paramV.setTranslationY((this.a + this.c)); 
  }
  
  public void b(V paramV) {
    if (this.b == 1)
      return; 
    ViewPropertyAnimator viewPropertyAnimator = this.d;
    if (viewPropertyAnimator != null) {
      viewPropertyAnimator.cancel();
      paramV.clearAnimation();
    } 
    this.b = 1;
    a(paramV, this.a + this.c, 175L, AnimationUtils.c);
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramV.getLayoutParams();
    this.a = paramV.getMeasuredHeight() + marginLayoutParams.bottomMargin;
    return super.onLayoutChild(paramCoordinatorLayout, (View)paramV, paramInt);
  }
  
  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint) {
    if (paramInt2 > 0) {
      b(paramV);
      return;
    } 
    if (paramInt2 < 0)
      a(paramV); 
  }
  
  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2) {
    return (paramInt1 == 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\behavior\HideBottomViewOnScrollBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */