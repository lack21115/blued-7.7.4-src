package com.soft.blued.customview;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.widget.NestedScrollView;

public class HeadZoomScrollView extends NestedScrollView {
  private float a = 0.0F;
  
  private int b = 0;
  
  private int c = 0;
  
  private boolean d = false;
  
  private View e;
  
  private float f = 0.4F;
  
  private float g = 1.5F;
  
  private float h = 1.2F;
  
  private Interpolator i;
  
  private boolean j = false;
  
  private boolean k = true;
  
  private OnScrollListener l;
  
  public HeadZoomScrollView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public HeadZoomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a() {
    float f = (this.e.getMeasuredWidth() - this.b);
    ValueAnimator valueAnimator = ObjectAnimator.ofFloat(new float[] { f, 0.0F }).setDuration((long)(this.h * f));
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            HeadZoomScrollView.a(this.a, ((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
          }
        });
    Interpolator interpolator = this.i;
    if (interpolator != null && f > 150.0F)
      valueAnimator.setInterpolator((TimeInterpolator)interpolator); 
    this.j = false;
    valueAnimator.start();
  }
  
  private void setZoom(float paramFloat) {
    int i = this.b;
    if ((float)((i + paramFloat) / i * 1.0D) > this.g) {
      if (this.k) {
        this.d = false;
        a();
      } 
      this.j = false;
      return;
    } 
    ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
    i = this.b;
    layoutParams.width = (int)Math.max(i + paramFloat, i);
    float f = this.c;
    i = this.b;
    layoutParams.height = (int)(f * (i + paramFloat) / i);
    i = -(layoutParams.width - this.b) / 2;
    ((ViewGroup.MarginLayoutParams)layoutParams).setMargins(i, 0, i, 0);
    this.e.setLayoutParams(layoutParams);
    OnScrollListener onScrollListener = this.l;
    if (onScrollListener != null)
      onScrollListener.a(layoutParams.width, layoutParams.height, this.b, this.c, layoutParams); 
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    setOverScrollMode(2);
    if (getChildAt(0) != null && getChildAt(0) instanceof ViewGroup && this.e == null) {
      ViewGroup viewGroup = (ViewGroup)getChildAt(0);
      if (viewGroup.getChildCount() > 0)
        this.e = viewGroup.getChildAt(0); 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0)
      this.j = true; 
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    OnScrollListener onScrollListener = this.l;
    if (onScrollListener != null)
      onScrollListener.a(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.b <= 0 || this.c <= 0) {
      this.b = this.e.getMeasuredWidth();
      this.c = this.e.getMeasuredHeight();
    } 
    if (this.e == null || this.b <= 0 || this.c <= 0)
      return super.onTouchEvent(paramMotionEvent); 
    try {
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1) {
          if (i == 2 && this.j) {
            if (!this.d)
              if (getScrollY() == 0) {
                this.a = paramMotionEvent.getY();
              } else {
                return super.onTouchEvent(paramMotionEvent);
              }  
            i = (int)((paramMotionEvent.getY() - this.a) * this.f);
            if (i >= 0) {
              this.d = true;
              setZoom(i);
              return true;
            } 
          } 
        } else if (this.j) {
          this.d = false;
          a();
        } 
      } else {
        this.j = true;
      } 
    } catch (Exception exception) {}
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setInterpolator(Interpolator paramInterpolator) {
    this.i = paramInterpolator;
  }
  
  public void setOnScrollListener(OnScrollListener paramOnScrollListener) {
    this.l = paramOnScrollListener;
  }
  
  public void setOverBack(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public void setReplyRatio(float paramFloat) {
    this.h = paramFloat;
  }
  
  public void setScaleRatio(float paramFloat) {
    this.f = paramFloat;
  }
  
  public void setScaleTimes(float paramFloat) {
    this.g = paramFloat;
  }
  
  public void setZoomView(View paramView) {
    this.e = paramView;
  }
  
  public static interface OnScrollListener {
    void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4);
    
    void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4, ViewGroup.LayoutParams param1LayoutParams);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\HeadZoomScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */