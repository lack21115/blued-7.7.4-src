package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;

public class HorizontalScrollView extends RelativeLayout {
  private RecyclerView a;
  
  private VerticalTextView b;
  
  private boolean c = true;
  
  private float d = 0.0F;
  
  private int e = 0;
  
  private float f;
  
  private float g;
  
  private boolean h = false;
  
  private int i = 0;
  
  private ValueAnimator j;
  
  private OnReleaseListener k;
  
  public HorizontalScrollView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public HorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = -DensityUtils.a(paramContext, 32.0F);
  }
  
  private void setHintTextTranslationX(float paramFloat) {
    if (this.c) {
      VerticalTextView verticalTextView = this.b;
      if (verticalTextView != null) {
        this.d += paramFloat;
        paramFloat = this.d;
        int i = this.e;
        if (paramFloat <= i) {
          paramFloat = i;
          verticalTextView.setVerticalText("更多");
        } else {
          verticalTextView.setVerticalText("更多");
        } 
        this.b.a(paramFloat, this.e);
        this.b.setTranslationX(paramFloat);
      } 
    } 
  }
  
  public void addView(View paramView) {
    if (paramView instanceof RecyclerView) {
      this.a = (RecyclerView)paramView;
    } else if (paramView instanceof VerticalTextView) {
      this.b = (VerticalTextView)paramView;
    } 
    super.addView(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    if (this.a == null)
      return super.dispatchTouchEvent(paramMotionEvent); 
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 3)
            i = ViewConfiguration.get(getContext()).getScaledTouchSlop(); 
        } else {
          ValueAnimator valueAnimator1 = this.j;
          if (valueAnimator1 == null || !valueAnimator1.isRunning()) {
            float f1 = paramMotionEvent.getRawX() - this.f;
            float f2 = paramMotionEvent.getRawY();
            float f3 = this.g;
            if (!this.h)
              if (Math.abs(f1) > Math.abs(f2 - f3)) {
                getParent().requestDisallowInterceptTouchEvent(true);
              } else {
                getParent().requestDisallowInterceptTouchEvent(false);
              }  
            this.i++;
            if (this.i > 2)
              this.h = true; 
            this.f = paramMotionEvent.getRawX();
            this.g = paramMotionEvent.getRawY();
            f3 = f1 * 0.4F;
            if (f3 > 0.0F) {
              if (!this.a.canScrollHorizontally(-1) || this.a.getTranslationX() < 0.0F) {
                f2 = this.a.getTranslationX() + f3;
                f1 = f2;
                if (this.a.canScrollHorizontally(-1)) {
                  f1 = f2;
                  if (f2 >= 0.0F)
                    f1 = 0.0F; 
                } 
                this.a.setTranslationX(f1);
                setHintTextTranslationX(f3);
              } 
            } else if (f3 < 0.0F && (!this.a.canScrollHorizontally(1) || this.a.getTranslationX() > 0.0F)) {
              f2 = this.a.getTranslationX() + f3;
              f1 = f2;
              if (f2 <= 0.0F) {
                f1 = f2;
                if (this.a.canScrollHorizontally(1))
                  f1 = 0.0F; 
              } 
              this.a.setTranslationX(f1);
              setHintTextTranslationX(f3);
            } 
          } 
          i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }  
      getParent().requestDisallowInterceptTouchEvent(false);
      ValueAnimator valueAnimator = this.j;
      if (valueAnimator == null || !valueAnimator.isRunning()) {
        i = this.e;
        if (i != 0 && this.d <= i) {
          OnReleaseListener onReleaseListener = this.k;
          if (onReleaseListener != null)
            onReleaseListener.a(); 
        } 
        this.j = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
        this.j.setDuration(300L);
        this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
              public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
                float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
                HorizontalScrollView.a(this.a).setTranslationX(HorizontalScrollView.a(this.a).getTranslationX() * f);
                if (HorizontalScrollView.b(this.a) != null)
                  HorizontalScrollView.b(this.a).setTranslationX(f * HorizontalScrollView.b(this.a).getTranslationX()); 
              }
            });
        this.j.start();
      } 
    } else {
      this.d = 0.0F;
      this.i = 0;
      this.h = false;
      this.f = paramMotionEvent.getRawX();
      this.g = paramMotionEvent.getRawY();
    } 
    i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public boolean getShowMore() {
    return this.c;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    VerticalTextView verticalTextView = this.b;
    if (verticalTextView != null) {
      this.e = -verticalTextView.getWidth();
      paramInt2 = this.e;
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
        paramInt1 = -DensityUtils.a(getContext(), 32.0F); 
      this.e = paramInt1;
    } 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void setOnReleaseListener(OnReleaseListener paramOnReleaseListener) {
    this.k = paramOnReleaseListener;
  }
  
  public void setShowMore(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public static interface OnReleaseListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\HorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */