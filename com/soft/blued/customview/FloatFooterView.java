package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;
import com.soft.blued.utils.click.SingleClickProxy;

public class FloatFooterView extends LinearLayout implements View.OnClickListener {
  private Context a;
  
  private ShapeLinearLayout b;
  
  private ImageView c;
  
  private TextView d;
  
  private OnBtnClickListener e;
  
  private BtnAnimatorUpdateListener f;
  
  private int g;
  
  private boolean h = true;
  
  public FloatFooterView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public FloatFooterView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.g = a(this.a, 150.0F);
    a(paramAttributeSet);
  }
  
  private static int a(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    View.inflate(getContext(), 2131493750, (ViewGroup)this);
    this.b = (ShapeLinearLayout)findViewById(2131296574);
    this.b.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.c = (ImageView)findViewById(2131297709);
    this.d = (TextView)findViewById(2131300590);
    if (paramAttributeSet != null) {
      TypedArray typedArray = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatFooterView);
      int i = typedArray.getResourceId(1, 0);
      int j = typedArray.getResourceId(0, 0);
      if (i != 0)
        this.d.setText(i); 
      if (j != 0) {
        this.c.setImageResource(j);
        this.c.setVisibility(0);
        return;
      } 
      this.c.setVisibility(8);
    } 
  }
  
  private void c() {
    AnimatorSet animatorSet = new AnimatorSet();
    ValueAnimator valueAnimator1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.7F });
    valueAnimator1.setDuration(100L);
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            FloatFooterView.a(this.a).setScaleX(f);
            FloatFooterView.a(this.a).setScaleY(f);
          }
        });
    ValueAnimator valueAnimator2 = ObjectAnimator.ofFloat(new float[] { 0.7F, 1.0F });
    valueAnimator2.setDuration(100L);
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            FloatFooterView.a(this.a).setScaleX(f);
            FloatFooterView.a(this.a).setScaleY(f);
          }
        });
    valueAnimator2.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    animatorSet.playSequentially(new Animator[] { (Animator)valueAnimator1, (Animator)valueAnimator2 });
    animatorSet.addListener(new Animator.AnimatorListener(this) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            if (FloatFooterView.b(this.a) != null)
              FloatFooterView.b(this.a).onPostFeedClick(); 
            FloatFooterView.a(this.a).setOnClickListener((View.OnClickListener)new SingleClickProxy(this.a));
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            FloatFooterView.a(this.a).setOnClickListener(null);
          }
        });
    animatorSet.start();
  }
  
  private void d() {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
    if (marginLayoutParams.topMargin != 0) {
      ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { marginLayoutParams.topMargin, 0 });
      valueAnimator.setDuration(450L);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)FloatFooterView.a(this.a).getLayoutParams();
              layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
              FloatFooterView.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              if (FloatFooterView.c(this.a) != null)
                FloatFooterView.c(this.a).a(param1ValueAnimator); 
            }
          });
      valueAnimator.start();
    } 
  }
  
  private void e() {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
    if (marginLayoutParams.topMargin != this.g) {
      ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { marginLayoutParams.topMargin, this.g });
      valueAnimator.setDuration(450L);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)FloatFooterView.a(this.a).getLayoutParams();
              layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
              FloatFooterView.a(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              if (FloatFooterView.c(this.a) != null)
                FloatFooterView.c(this.a).a(param1ValueAnimator); 
            }
          });
      valueAnimator.start();
    } 
  }
  
  public void a() {
    if (this.h)
      return; 
    this.h = true;
    d();
  }
  
  public void a(int paramInt1, int paramInt2) {
    ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
    layoutParams.width = paramInt1;
    layoutParams.height = paramInt2;
    this.b.setLayoutParams(layoutParams);
  }
  
  public void b() {
    if (!this.h)
      return; 
    this.h = false;
    e();
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296574)
      return; 
    c();
  }
  
  public void setBtnAnimatorUpdateListener(BtnAnimatorUpdateListener paramBtnAnimatorUpdateListener) {
    this.f = paramBtnAnimatorUpdateListener;
  }
  
  public void setBtnBackgroundColor(int paramInt) {
    ShapeHelper.b((ShapeHelper.ShapeView)this.b, paramInt);
  }
  
  public void setBtnEnabled(boolean paramBoolean) {
    this.b.setEnabled(paramBoolean);
  }
  
  public void setBtnIconImageDrawable(Drawable paramDrawable) {
    this.c.setImageDrawable(paramDrawable);
  }
  
  public void setBtnText(int paramInt) {
    this.d.setText(paramInt);
  }
  
  public void setBtnText(CharSequence paramCharSequence) {
    this.d.setText(paramCharSequence);
  }
  
  public void setHideHeight(int paramInt) {
    this.g = paramInt;
  }
  
  public void setOnBtnClickListener(OnBtnClickListener paramOnBtnClickListener) {
    this.e = paramOnBtnClickListener;
  }
  
  public static interface BtnAnimatorUpdateListener {
    void a(ValueAnimator param1ValueAnimator);
  }
  
  public static interface OnBtnClickListener {
    void onPostFeedClick();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\FloatFooterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */