package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
  private final MotionTiming a = new MotionTiming(75L, 150L);
  
  private final MotionTiming b = new MotionTiming(0L, 150L);
  
  public FabTransformationScrimBehavior() {}
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2, List<Animator> paramList, List<Animator.AnimatorListener> paramList1) {
    ObjectAnimator objectAnimator;
    MotionTiming motionTiming;
    if (paramBoolean1) {
      motionTiming = this.a;
    } else {
      motionTiming = this.b;
    } 
    if (paramBoolean1) {
      if (!paramBoolean2)
        paramView.setAlpha(0.0F); 
      objectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F });
    } else {
      objectAnimator = ObjectAnimator.ofFloat(objectAnimator, View.ALPHA, new float[] { 0.0F });
    } 
    motionTiming.a((Animator)objectAnimator);
    paramList.add(objectAnimator);
  }
  
  protected AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2) {
    ArrayList<Animator> arrayList = new ArrayList();
    a(paramView2, paramBoolean1, paramBoolean2, arrayList, new ArrayList<Animator.AnimatorListener>());
    AnimatorSet animatorSet = new AnimatorSet();
    AnimatorSetCompat.a(animatorSet, arrayList);
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramBoolean1, paramView2) {
          public void onAnimationEnd(Animator param1Animator) {
            if (!this.a)
              this.b.setVisibility(4); 
          }
          
          public void onAnimationStart(Animator param1Animator) {
            if (this.a)
              this.b.setVisibility(0); 
          }
        });
    return animatorSet;
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {
    return paramView2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent) {
    return super.onTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transformation\FabTransformationScrimBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */