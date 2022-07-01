package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;

public class BounceBackViewPager extends ViewPager {
  private int d = 0;
  
  private Rect e = new Rect();
  
  private boolean f = true;
  
  private float g = 0.0F;
  
  public BounceBackViewPager(Context paramContext) {
    super(paramContext);
  }
  
  public BounceBackViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void b(float paramFloat) {
    if (this.e.isEmpty())
      this.e.set(getLeft(), getTop(), getRight(), getBottom()); 
    this.f = false;
    int i = getLeft();
    int j = (int)(paramFloat * 0.5F);
    layout(i + j, getTop(), getRight() + j, getBottom());
  }
  
  private void f() {
    if (!this.e.isEmpty())
      g(); 
  }
  
  private void g() {
    TranslateAnimation translateAnimation = new TranslateAnimation(getLeft(), this.e.left, 0.0F, 0.0F);
    translateAnimation.setDuration(300L);
    startAnimation((Animation)translateAnimation);
    layout(this.e.left, this.e.top, this.e.right, this.e.bottom);
    this.e.setEmpty();
    this.f = true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      this.g = paramMotionEvent.getX();
      this.d = getCurrentItem();
    } 
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    paramInt2 = 0;
    int i;
    for (i = 0; paramInt2 < getChildCount(); i = j) {
      View view = getChildAt(paramInt2);
      view.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      int k = view.getMeasuredHeight();
      int j = i;
      if (k > i)
        j = k; 
      paramInt2++;
    } 
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (i != 1) {
      if (i == 2) {
        if (getAdapter().getCount() == 1) {
          float f1 = paramMotionEvent.getX();
          float f2 = f1 - this.g;
          this.g = f1;
          if (f2 > 10.0F) {
            b(f2);
          } else if (f2 < -10.0F) {
            b(f2);
          } else if (!this.f) {
            i = getLeft();
            int j = (int)(f2 * 0.5F);
            if (i + j != this.e.left)
              layout(getLeft() + j, getTop(), getRight() + j, getBottom()); 
          } 
        } else {
          i = this.d;
          if (i == 0 || i == getAdapter().getCount() - 1) {
            float f1 = paramMotionEvent.getX();
            float f2 = f1 - this.g;
            this.g = f1;
            if (this.d == 0) {
              if (f2 > 10.0F) {
                b(f2);
              } else if (!this.f) {
                i = getLeft();
                int j = (int)(f2 * 0.5F);
                if (i + j >= this.e.left)
                  layout(getLeft() + j, getTop(), getRight() + j, getBottom()); 
              } 
            } else if (f2 < -10.0F) {
              b(f2);
            } else if (!this.f) {
              i = getRight();
              int j = (int)(f2 * 0.5F);
              if (i + j <= this.e.right)
                layout(getLeft() + j, getTop(), getRight() + j, getBottom()); 
            } 
          } else {
            this.f = true;
          } 
        } 
        if (!this.f)
          return true; 
      } 
    } else {
      f();
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\BounceBackViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */