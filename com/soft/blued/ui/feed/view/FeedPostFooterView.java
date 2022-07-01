package com.soft.blued.ui.feed.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

public class FeedPostFooterView extends LinearLayout implements View.OnClickListener {
  private Context a;
  
  private LinearLayout b;
  
  private OnBtnClickListener c;
  
  private BtnAnimatorUpdateListener d;
  
  private int e;
  
  private boolean f = true;
  
  public FeedPostFooterView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FeedPostFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.e = a(this.a, 100.0F);
    a();
  }
  
  private static int a(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  private void a() {
    View.inflate(getContext(), 2131493750, (ViewGroup)this);
    this.b = (LinearLayout)findViewById(2131296574);
    this.b.setOnClickListener(this);
  }
  
  private void b() {
    AnimatorSet animatorSet = new AnimatorSet();
    ValueAnimator valueAnimator1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.7F });
    valueAnimator1.setDuration(100L);
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            FeedPostFooterView.a(this.a).setScaleX(f);
            FeedPostFooterView.a(this.a).setScaleY(f);
          }
        });
    ValueAnimator valueAnimator2 = ObjectAnimator.ofFloat(new float[] { 0.7F, 1.0F });
    valueAnimator2.setDuration(100L);
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            FeedPostFooterView.a(this.a).setScaleX(f);
            FeedPostFooterView.a(this.a).setScaleY(f);
          }
        });
    valueAnimator2.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    animatorSet.playSequentially(new Animator[] { (Animator)valueAnimator1, (Animator)valueAnimator2 });
    animatorSet.addListener(new Animator.AnimatorListener(this) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            if (FeedPostFooterView.b(this.a) != null)
              FeedPostFooterView.b(this.a).a(); 
            FeedPostFooterView.a(this.a).setOnClickListener(this.a);
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            FeedPostFooterView.a(this.a).setOnClickListener(null);
          }
        });
    animatorSet.start();
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296574)
      return; 
    b();
  }
  
  public void setBtnAnimatorUpdateListener(BtnAnimatorUpdateListener paramBtnAnimatorUpdateListener) {
    this.d = paramBtnAnimatorUpdateListener;
  }
  
  public void setHideHeight(int paramInt) {
    this.e = paramInt;
  }
  
  public void setOnBtnClickListener(OnBtnClickListener paramOnBtnClickListener) {
    this.c = paramOnBtnClickListener;
  }
  
  public static interface BtnAnimatorUpdateListener {
    void a(ValueAnimator param1ValueAnimator);
  }
  
  public static interface OnBtnClickListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\view\FeedPostFooterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */