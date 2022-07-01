package com.soft.blued.customview.capricorn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.R;

public class ArcLayout extends ViewGroup {
  private static int f = 100;
  
  private int a;
  
  private int b = 5;
  
  private int c = 10;
  
  private float d = 270.0F;
  
  private float e = 360.0F;
  
  private int g;
  
  private boolean h = false;
  
  private View i;
  
  private OnExpandListener j;
  
  public ArcLayout(Context paramContext) {
    super(paramContext);
  }
  
  public ArcLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ArcLayout, 0, 0);
      this.d = typedArray.getFloat(1, 270.0F);
      this.e = typedArray.getFloat(2, 360.0F);
      this.a = Math.max(typedArray.getDimensionPixelSize(0, 0), 0);
      f = DensityUtils.a(paramContext, 100.0F);
      typedArray.recycle();
    } 
  }
  
  private static int a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt1 < 2)
      return paramInt4; 
    paramFloat = paramFloat / (paramInt1 - 1) / 2.0F;
    return Math.max((int)(((paramInt2 + paramInt3) / 2) / Math.sin(Math.toRadians(paramFloat))), paramInt4);
  }
  
  private static int a(boolean paramBoolean, int paramInt1, int paramInt2) {
    return paramBoolean ? (paramInt1 - 1 - paramInt2) : paramInt2;
  }
  
  private static long a(int paramInt1, boolean paramBoolean, int paramInt2, float paramFloat, long paramLong, Interpolator paramInterpolator) {
    paramFloat *= (float)paramLong;
    paramLong = (long)(a(paramBoolean, paramInt1, paramInt2) * paramFloat);
    paramFloat *= paramInt1;
    return (long)(paramInterpolator.getInterpolation((float)paramLong / paramFloat) * paramFloat);
  }
  
  private static Rect a(int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4) {
    double d1 = paramInt1;
    double d2 = paramInt3;
    double d3 = paramFloat;
    d1 += Math.cos(Math.toRadians(d3)) * d2;
    d2 = paramInt2 + d2 * Math.sin(Math.toRadians(d3));
    d3 = (paramInt4 / 2);
    return new Rect((int)(d1 - d3), (int)(d2 - d3), (int)(d1 + d3), (int)(d2 + d3));
  }
  
  private static Animation a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong1, long paramLong2, Interpolator paramInterpolator) {
    RotateAndTranslateAnimation rotateAndTranslateAnimation = new RotateAndTranslateAnimation(0.0F, paramFloat2, 0.0F, paramFloat4, 0.0F, 0.0F);
    rotateAndTranslateAnimation.setStartOffset(paramLong1);
    rotateAndTranslateAnimation.setDuration(paramLong2);
    rotateAndTranslateAnimation.setInterpolator(paramInterpolator);
    rotateAndTranslateAnimation.setFillAfter(true);
    return rotateAndTranslateAnimation;
  }
  
  private void a(View paramView, int paramInt, long paramLong) {
    int i;
    OvershootInterpolator overshootInterpolator;
    Animation animation;
    boolean bool1 = this.h;
    int j = getWidth() / 2;
    int k = getHeight() / 2;
    boolean bool = false;
    if (bool1) {
      i = 0;
    } else {
      i = this.g;
    } 
    int m = getChildCount();
    float f2 = this.e;
    float f1 = this.d;
    int n = m - 1;
    f2 = (f2 - f1) / n;
    Rect rect = a(j, k, i, f1 + paramInt * f2, this.a);
    if (m == 2 && !this.h) {
      if (paramInt == 0) {
        j = rect.left - paramView.getLeft();
        i = rect.top - paramView.getTop() - 50;
      } else {
        i = rect.left - paramView.getLeft() - 50;
        j = rect.top;
        k = paramView.getTop();
        k = j - k;
        j = i;
        i = k;
      } 
    } else {
      i = rect.left - paramView.getLeft();
      j = rect.top;
      k = paramView.getTop();
      k = j - k;
      j = i;
      i = k;
    } 
    if (this.h) {
      AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
    } else {
      overshootInterpolator = new OvershootInterpolator(1.5F);
    } 
    long l = a(m, this.h, paramInt, 0.1F, paramLong, (Interpolator)overshootInterpolator);
    bool1 = this.h;
    f1 = j;
    if (bool1) {
      animation = b(0.0F, f1, 0.0F, i, l, paramLong, (Interpolator)overshootInterpolator);
    } else {
      animation = a(0.0F, f1, 0.0F, i, l, paramLong, (Interpolator)animation);
    } 
    if (paramInt == n)
      bool = true; 
    animation.setAnimationListener(new Animation.AnimationListener(this, bool) {
          public void onAnimationEnd(Animation param1Animation) {
            if (this.a)
              this.b.postDelayed(new Runnable(this) {
                    public void run() {
                      ArcLayout.a(this.a.b);
                    }
                  },  0L); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramView.setAnimation(animation);
  }
  
  private static Animation b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong1, long paramLong2, Interpolator paramInterpolator) {
    long l = paramLong2 / 2L;
    RotateAndTranslateAnimation rotateAndTranslateAnimation = new RotateAndTranslateAnimation(0.0F, paramFloat2, 0.0F, paramFloat4, 0.0F, 0.0F);
    rotateAndTranslateAnimation.setStartOffset(paramLong1 + l);
    rotateAndTranslateAnimation.setDuration(paramLong2 - l);
    rotateAndTranslateAnimation.setInterpolator(paramInterpolator);
    rotateAndTranslateAnimation.setFillAfter(true);
    return rotateAndTranslateAnimation;
  }
  
  private void b() {
    int j = getChildCount();
    for (int i = 0; i < j; i++)
      getChildAt(i).clearAnimation(); 
    this.h ^= 0x1;
    requestLayout();
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    if (this.d == paramFloat1 && this.e == paramFloat2)
      return; 
    this.d = paramFloat1;
    this.e = paramFloat2;
    requestLayout();
  }
  
  public void a(OnExpandListener paramOnExpandListener, View paramView) {
    this.j = paramOnExpandListener;
    this.i = paramView;
  }
  
  public void a(boolean paramBoolean) {
    OnExpandListener onExpandListener = this.j;
    if (onExpandListener != null && paramBoolean) {
      onExpandListener.a(a() ^ true);
      this.i.setSelected(a() ^ true);
    } 
    if (paramBoolean) {
      int j = getChildCount();
      for (int i = 0; i < j; i++)
        a(getChildAt(i), i, 200L); 
    } 
    if (!paramBoolean) {
      this.h ^= 0x1;
      requestLayout();
    } 
    invalidate();
  }
  
  public boolean a() {
    return this.h;
  }
  
  public void b(boolean paramBoolean) {
    if (!paramBoolean) {
      OnExpandListener onExpandListener = this.j;
      if (onExpandListener != null) {
        onExpandListener.a(a() ^ true);
        this.i.setSelected(a() ^ true);
        invalidate();
        return;
      } 
    } else {
      this.h ^= 0x1;
      OnExpandListener onExpandListener = this.j;
      if (onExpandListener != null) {
        onExpandListener.a(a());
        this.i.setSelected(a());
      } 
      int j = getChildCount();
      for (int i = 0; i < j; i++)
        getChildAt(i).clearAnimation(); 
      requestLayout();
      invalidate();
    } 
  }
  
  public int getChildSize() {
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt4 = getWidth() / 2;
    int i = getHeight() / 2;
    if (this.h) {
      paramInt1 = this.g;
    } else {
      paramInt1 = 0;
    } 
    int j = getChildCount();
    float f2 = this.e;
    float f1 = this.d;
    f2 = (f2 - f1) / (j - 1);
    for (paramInt2 = 0; paramInt2 < j; paramInt2++) {
      Rect rect = a(paramInt4, i, paramInt1, f1, this.a);
      f1 += f2;
      if (j == 2 && this.h) {
        if (paramInt2 == 0) {
          getChildAt(paramInt2).layout(rect.left, rect.top - 50, rect.right, rect.bottom);
        } else {
          getChildAt(paramInt2).layout(rect.left - 50, rect.top, rect.right, rect.bottom);
        } 
      } else {
        getChildAt(paramInt2).layout(rect.left, rect.top, rect.right, rect.bottom);
      } 
      View view = getChildAt(paramInt2);
      if (this.h) {
        paramInt3 = 0;
      } else {
        paramInt3 = 4;
      } 
      view.setVisibility(paramInt3);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    paramInt1 = a(Math.abs(this.e - this.d), getChildCount(), this.a, this.b, f);
    this.g = paramInt1;
    paramInt1 = paramInt1 * 2 + this.a + this.b + this.c * 2;
    setMeasuredDimension(paramInt1, paramInt1);
    paramInt2 = getChildCount();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
      getChildAt(paramInt1).measure(View.MeasureSpec.makeMeasureSpec(this.a, 1073741824), View.MeasureSpec.makeMeasureSpec(this.a, 1073741824)); 
  }
  
  public void setChildSize(int paramInt) {
    if (this.a != paramInt) {
      if (paramInt < 0)
        return; 
      this.a = paramInt;
      requestLayout();
    } 
  }
  
  public static interface OnExpandListener {
    void a(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\capricorn\ArcLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */