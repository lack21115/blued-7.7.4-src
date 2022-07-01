package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.ui.xpop.animator.ShadowBgAnimator;
import com.blued.android.framework.ui.xpop.enums.LayoutStatus;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class PopupDrawerLayout extends FrameLayout {
  LayoutStatus a = null;
  
  ViewDragHelper b = ViewDragHelper.create((ViewGroup)this, this.r);
  
  View c;
  
  View d;
  
  public PopupPosition e = PopupPosition.a;
  
  ShadowBgAnimator f = new ShadowBgAnimator();
  
  public boolean g = false;
  
  float h = 0.0F;
  
  public boolean i = true;
  
  public boolean j = true;
  
  float k;
  
  boolean l = false;
  
  boolean m = false;
  
  float n;
  
  float o;
  
  boolean p;
  
  boolean q;
  
  ViewDragHelper.Callback r = new ViewDragHelper.Callback(this) {
      private void a(int param1Int1, int param1Int2) {
        if (this.a.e == PopupPosition.a) {
          PopupDrawerLayout popupDrawerLayout = this.a;
          popupDrawerLayout.h = (popupDrawerLayout.d.getMeasuredWidth() + param1Int1) * 1.0F / this.a.d.getMeasuredWidth();
          if (param1Int1 == -this.a.d.getMeasuredWidth() && PopupDrawerLayout.a(this.a) != null && this.a.a != LayoutStatus.b) {
            this.a.a = LayoutStatus.b;
            PopupDrawerLayout.a(this.a).a();
          } 
        } else if (this.a.e == PopupPosition.b) {
          PopupDrawerLayout popupDrawerLayout = this.a;
          popupDrawerLayout.h = (popupDrawerLayout.getMeasuredWidth() - param1Int1) * 1.0F / this.a.d.getMeasuredWidth();
          if (param1Int1 == this.a.getMeasuredWidth() && PopupDrawerLayout.a(this.a) != null && this.a.a != LayoutStatus.b) {
            this.a.a = LayoutStatus.b;
            PopupDrawerLayout.a(this.a).a();
          } 
        } 
        if (this.a.i) {
          PopupDrawerLayout popupDrawerLayout = this.a;
          popupDrawerLayout.setBackgroundColor(popupDrawerLayout.f.a(this.a.h));
        } 
        if (PopupDrawerLayout.a(this.a) != null) {
          boolean bool;
          PopupDrawerLayout.OnCloseListener onCloseListener = PopupDrawerLayout.a(this.a);
          float f = this.a.h;
          if (param1Int2 < 0) {
            bool = true;
          } else {
            bool = false;
          } 
          onCloseListener.a(param1Int1, f, bool);
          if (this.a.h == 1.0F && this.a.a != LayoutStatus.a) {
            this.a.a = LayoutStatus.a;
            PopupDrawerLayout.a(this.a).b();
          } 
        } 
      }
      
      public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
        return (param1View == this.a.c) ? param1Int1 : PopupDrawerLayout.a(this.a, param1Int1);
      }
      
      public int getViewHorizontalDragRange(View param1View) {
        return 1;
      }
      
      public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
        super.onViewPositionChanged(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
        if (param1View == this.a.c) {
          this.a.c.layout(0, 0, this.a.c.getMeasuredWidth(), this.a.c.getMeasuredHeight());
          PopupDrawerLayout popupDrawerLayout = this.a;
          param1Int1 = PopupDrawerLayout.a(popupDrawerLayout, popupDrawerLayout.d.getLeft() + param1Int3);
          this.a.d.layout(param1Int1, this.a.d.getTop(), this.a.d.getMeasuredWidth() + param1Int1, this.a.d.getBottom());
          a(param1Int1, param1Int3);
          return;
        } 
        a(param1Int1, param1Int3);
      }
      
      public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
        int i;
        super.onViewReleased(param1View, param1Float1, param1Float2);
        if (param1View == this.a.c && param1Float1 == 0.0F) {
          this.a.a();
          return;
        } 
        if (param1View == this.a.d && this.a.p && !this.a.q && param1Float1 < -500.0F) {
          this.a.a();
          return;
        } 
        if (this.a.e == PopupPosition.a) {
          if (param1Float1 < -1000.0F) {
            i = this.a.d.getMeasuredWidth();
          } else {
            i = -this.a.d.getMeasuredWidth() / 2;
            if (this.a.d.getLeft() < i) {
              i = this.a.d.getMeasuredWidth();
            } else {
              i = 0;
              this.a.b.smoothSlideViewTo(this.a.d, i, param1View.getTop());
              ViewCompat.postInvalidateOnAnimation((View)this.a);
            } 
          } 
          i = -i;
        } else if (param1Float1 > 1000.0F) {
          i = this.a.getMeasuredWidth();
        } else {
          i = this.a.getMeasuredWidth();
          int j = this.a.d.getMeasuredWidth() / 2;
          if (param1View.getLeft() < i - j) {
            i = this.a.getMeasuredWidth() - this.a.d.getMeasuredWidth();
          } else {
            i = this.a.getMeasuredWidth();
          } 
        } 
        this.a.b.smoothSlideViewTo(this.a.d, i, param1View.getTop());
        ViewCompat.postInvalidateOnAnimation((View)this.a);
      }
      
      public boolean tryCaptureView(View param1View, int param1Int) {
        return (!this.a.b.continueSettling(true) && this.a.a != LayoutStatus.b);
      }
    };
  
  public boolean s = true;
  
  private OnCloseListener t;
  
  public PopupDrawerLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PopupDrawerLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PopupDrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt) {
    int i;
    if (this.e == PopupPosition.a) {
      int j = paramInt;
      if (paramInt < -this.d.getMeasuredWidth())
        j = -this.d.getMeasuredWidth(); 
      i = j;
      if (j > 0)
        return 0; 
    } else {
      i = paramInt;
      if (this.e == PopupPosition.b) {
        int j = paramInt;
        if (paramInt < getMeasuredWidth() - this.d.getMeasuredWidth())
          j = getMeasuredWidth() - this.d.getMeasuredWidth(); 
        i = j;
        if (j > getMeasuredWidth())
          i = getMeasuredWidth(); 
      } 
    } 
    return i;
  }
  
  private boolean a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2) {
    return a(paramViewGroup, paramFloat1, paramFloat2, 0);
  }
  
  private boolean a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, int paramInt) {
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 0;
    while (true) {
      if (i < paramViewGroup.getChildCount()) {
        View view = paramViewGroup.getChildAt(i);
        int[] arrayOfInt = new int[2];
        view.getLocationInWindow(arrayOfInt);
        if (XPopupUtils.a(paramFloat1, paramFloat2, new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + view.getWidth(), arrayOfInt[1] + view.getHeight())) && view instanceof ViewGroup) {
          if (view instanceof ViewPager) {
            ViewPager viewPager = (ViewPager)view;
            if (paramInt == 0) {
              if (viewPager.canScrollHorizontally(-1) || viewPager.canScrollHorizontally(1))
                bool1 = true; 
              return bool1;
            } 
            return viewPager.canScrollHorizontally(paramInt);
          } 
          if (view instanceof HorizontalScrollView) {
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView)view;
            if (paramInt == 0) {
              if (!horizontalScrollView.canScrollHorizontally(-1)) {
                bool1 = bool2;
                return horizontalScrollView.canScrollHorizontally(1) ? true : bool1;
              } 
            } else {
              return horizontalScrollView.canScrollHorizontally(paramInt);
            } 
          } else {
            return a((ViewGroup)view, paramFloat1, paramFloat2, paramInt);
          } 
        } else {
          i++;
          continue;
        } 
      } else {
        break;
      } 
      return true;
    } 
    return false;
  }
  
  public void a() {
    if (!this.s)
      return; 
    post(new Runnable(this) {
          public void run() {
            int i;
            this.a.b.abort();
            ViewDragHelper viewDragHelper = this.a.b;
            View view = this.a.d;
            if (this.a.e == PopupPosition.a) {
              i = -this.a.d.getMeasuredWidth();
            } else {
              i = this.a.getMeasuredWidth();
            } 
            viewDragHelper.smoothSlideViewTo(view, i, 0);
            ViewCompat.postInvalidateOnAnimation((View)this.a);
          }
        });
  }
  
  public void computeScroll() {
    super.computeScroll();
    if (this.b.continueSettling(true))
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.k = getTranslationY();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.a = null;
    this.l = false;
    this.h = 0.0F;
    setTranslationY(this.k);
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    this.c = getChildAt(0);
    this.d = getChildAt(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (!this.j)
      return super.onInterceptTouchEvent(paramMotionEvent); 
    if (!this.b.continueSettling(true)) {
      boolean bool;
      if (this.a == LayoutStatus.b)
        return true; 
      if (paramMotionEvent.getX() < this.n) {
        bool = true;
      } else {
        bool = false;
      } 
      this.p = bool;
      this.n = paramMotionEvent.getX();
      this.o = paramMotionEvent.getY();
      this.q = a((ViewGroup)this, paramMotionEvent.getX(), paramMotionEvent.getY(), 1);
      if (paramMotionEvent.getAction() == 1 || paramMotionEvent.getAction() == 3) {
        this.n = 0.0F;
        this.o = 0.0F;
      } 
      this.m = this.b.shouldInterceptTouchEvent(paramMotionEvent);
      return (this.p && !this.q) ? this.m : (!a((ViewGroup)this, paramMotionEvent.getX(), paramMotionEvent.getY()) ? this.m : super.onInterceptTouchEvent(paramMotionEvent));
    } 
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.c.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    if (!this.l) {
      if (this.e == PopupPosition.a) {
        View view1 = this.d;
        view1.layout(-view1.getMeasuredWidth(), 0, 0, getMeasuredHeight());
      } else {
        this.d.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.d.getMeasuredWidth(), getMeasuredHeight());
      } 
      this.l = true;
      return;
    } 
    View view = this.d;
    view.layout(view.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getMeasuredHeight());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!this.j)
      return super.onTouchEvent(paramMotionEvent); 
    if (this.b.continueSettling(true))
      return true; 
    this.b.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setDrawerPosition(PopupPosition paramPopupPosition) {
    this.e = paramPopupPosition;
  }
  
  public void setOnCloseListener(OnCloseListener paramOnCloseListener) {
    this.t = paramOnCloseListener;
  }
  
  public static interface OnCloseListener {
    void a();
    
    void a(int param1Int, float param1Float, boolean param1Boolean);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\widget\PopupDrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */