package com.blued.android.framework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class SlideView extends HorizontalScrollView {
  private LinearLayout a;
  
  private View b;
  
  private OnSlideListener c;
  
  private int d;
  
  private int e;
  
  public SlideView(Context paramContext) {
    super(paramContext);
  }
  
  public SlideView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void b() {
    LinearLayout linearLayout = this.a;
    if (linearLayout != null) {
      this.d = 0;
      int j = linearLayout.getChildCount();
      int i = 1;
      if (j > 1) {
        this.b = this.a.getChildAt(0);
        while (i < j) {
          this.d += this.a.getChildAt(i).getMeasuredWidth();
          i++;
        } 
      } else {
        this.d = 0;
      } 
    } 
  }
  
  public void a() {
    if (getScrollX() != 0)
      smoothScrollTo(0, 0); 
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    if (this.a == null)
      return super.dispatchTouchEvent(paramMotionEvent); 
    int i = (int)paramMotionEvent.getX();
    int j = getScrollX();
    int k = paramMotionEvent.getAction();
    if (k != 0) {
      if (k == 1) {
        double d1 = j;
        i = this.d;
        double d2 = i;
        j = 0;
        if (d1 - d2 * 0.5D > 0.0D) {
          this.e = 2;
        } else {
          this.e = 0;
          i = 0;
        } 
        smoothScrollTo(i, 0);
        OnSlideListener onSlideListener = this.c;
        if (onSlideListener != null) {
          if (i == 0) {
            i = j;
          } else {
            i = 2;
          } 
          onSlideListener.a((View)this, i);
        } 
      } 
    } else if (this.c != null && this.e == 2) {
      View view = this.b;
      if (view != null && i < view.getWidth() - this.d)
        this.c.a((View)this, 1); 
    } 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    if (getChildCount() > 0)
      this.a = (LinearLayout)getChildAt(0); 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setOnSlideListener(OnSlideListener paramOnSlideListener) {
    this.c = paramOnSlideListener;
  }
  
  public static interface OnSlideListener {
    void a(View param1View, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SlideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */