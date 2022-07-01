package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.ShadowBgAnimator;
import com.blued.android.framework.ui.xpop.enums.LayoutStatus;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class SmartDragLayout extends FrameLayout implements NestedScrollingParent {
  OverScroller a;
  
  VelocityTracker b;
  
  ShadowBgAnimator c = new ShadowBgAnimator();
  
  boolean d = true;
  
  boolean e = true;
  
  boolean f = true;
  
  boolean g = false;
  
  boolean h = false;
  
  LayoutStatus i = LayoutStatus.b;
  
  int j;
  
  int k;
  
  int l;
  
  float m;
  
  float n;
  
  boolean o;
  
  private View p;
  
  private OnCloseListener q;
  
  public SmartDragLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SmartDragLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmartDragLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (this.d)
      this.a = new OverScroller(paramContext); 
  }
  
  private void c() {
    if (this.d) {
      int i;
      if (this.o) {
        i = this.j - this.k;
      } else {
        i = (this.j - this.k) * 2;
      } 
      i /= 3;
      if (getScrollY() > i) {
        i = this.j;
      } else {
        i = this.k;
      } 
      i -= getScrollY();
      if (this.h) {
        int j;
        i = this.j / 3;
        float f1 = getScrollY();
        float f2 = i;
        float f3 = 2.5F * f2;
        if (f1 > f3) {
          i = this.j;
          j = getScrollY();
        } else if (getScrollY() <= f3 && getScrollY() > f2 * 1.5F) {
          i *= 2;
          j = getScrollY();
        } else if (getScrollY() > i) {
          j = getScrollY();
        } else {
          i = this.k;
          j = getScrollY();
        } 
        i -= j;
      } 
      this.a.startScroll(getScrollX(), getScrollY(), 0, i, XPopup.b());
      ViewCompat.postInvalidateOnAnimation((View)this);
    } 
  }
  
  public void a() {
    post(new Runnable(this) {
          public void run() {
            int j = this.a.j - this.a.getScrollY();
            SmartDragLayout smartDragLayout = this.a;
            int i = j;
            if (smartDragLayout.d) {
              i = j;
              if (this.a.h)
                i = j / 3; 
            } 
            smartDragLayout.a(i, true);
            this.a.i = LayoutStatus.c;
          }
        });
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    post(new Runnable(this, paramInt, paramBoolean) {
          public void run() {
            float f;
            OverScroller overScroller = this.c.a;
            int i = this.c.getScrollX();
            int j = this.c.getScrollY();
            int k = this.a;
            if (this.b) {
              f = XPopup.b();
            } else {
              f = XPopup.b() * 0.8F;
            } 
            overScroller.startScroll(i, j, 0, k, (int)f);
            ViewCompat.postInvalidateOnAnimation((View)this.c);
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void b() {
    this.g = true;
    post(new Runnable(this) {
          public void run() {
            this.a.a.abortAnimation();
            SmartDragLayout smartDragLayout = this.a;
            smartDragLayout.a(smartDragLayout.k - this.a.getScrollY(), false);
            this.a.i = LayoutStatus.d;
          }
        });
  }
  
  public void b(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public void c(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public void computeScroll() {
    super.computeScroll();
    if (this.a.computeScrollOffset()) {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      ViewCompat.postInvalidateOnAnimation((View)this);
    } 
  }
  
  public void d(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    this.g = true;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getNestedScrollAxes() {
    return 2;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.o = false;
    this.g = false;
    setTranslationY(0.0F);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.j = this.p.getMeasuredHeight();
    this.k = 0;
    paramInt1 = getMeasuredWidth() / 2 - this.p.getMeasuredWidth() / 2;
    if (this.d) {
      this.p.layout(paramInt1, getMeasuredHeight(), this.p.getMeasuredWidth() + paramInt1, getMeasuredHeight() + this.j);
      if (this.i == LayoutStatus.a)
        if (this.h) {
          scrollTo(getScrollX(), getScrollY() - this.l - this.j);
        } else {
          scrollTo(getScrollX(), getScrollY() - this.l - this.j);
        }  
    } else {
      this.p.layout(paramInt1, getMeasuredHeight() - this.p.getMeasuredHeight(), this.p.getMeasuredWidth() + paramInt1, getMeasuredHeight());
    } 
    this.l = this.j;
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    boolean bool;
    if (getScrollY() > this.k && getScrollY() < this.j) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && paramFloat2 < -1500.0F && !this.h)
      b(); 
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    if (paramInt2 > 0) {
      paramInt1 = getScrollY() + paramInt2;
      if (paramInt1 < this.j)
        paramArrayOfint[1] = paramInt2; 
      scrollTo(getScrollX(), paramInt1);
    } 
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    scrollTo(getScrollX(), getScrollY() + paramInt4);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.a.abortAnimation();
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    return (paramInt == 2 && this.d);
  }
  
  public void onStopNestedScroll(View paramView) {
    c();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    VelocityTracker velocityTracker;
    if (this.d && this.a.computeScrollOffset()) {
      this.m = 0.0F;
      this.n = 0.0F;
      return true;
    } 
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 3)
            return true; 
        } else {
          if (this.d) {
            VelocityTracker velocityTracker1 = this.b;
            if (velocityTracker1 != null) {
              velocityTracker1.addMovement(paramMotionEvent);
              this.b.computeCurrentVelocity(1000);
              i = (int)(paramMotionEvent.getY() - this.n);
              scrollTo(getScrollX(), getScrollY() - i);
              this.n = paramMotionEvent.getY();
              return true;
            } 
          } 
          return true;
        }  
      Rect rect = new Rect();
      this.p.getGlobalVisibleRect(rect);
      if (!XPopupUtils.a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), rect) && this.e && (float)Math.sqrt(Math.pow((paramMotionEvent.getX() - this.m), 2.0D) + Math.pow((paramMotionEvent.getY() - this.n), 2.0D)) < ViewConfiguration.get(getContext()).getScaledTouchSlop())
        performClick(); 
      if (this.d) {
        velocityTracker = this.b;
        if (velocityTracker != null) {
          if (velocityTracker.getYVelocity() > 1500.0F && !this.h) {
            b();
          } else {
            c();
          } 
          this.b = null;
          return true;
        } 
      } 
    } else {
      if (this.d) {
        VelocityTracker velocityTracker1 = this.b;
        if (velocityTracker1 != null)
          velocityTracker1.clear(); 
        this.b = VelocityTracker.obtain();
      } 
      this.m = velocityTracker.getX();
      this.n = velocityTracker.getY();
    } 
    return true;
  }
  
  public void onViewAdded(View paramView) {
    super.onViewAdded(paramView);
    this.p = paramView;
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {
    boolean bool;
    int j = this.j;
    int i = paramInt2;
    if (paramInt2 > j)
      i = j; 
    j = this.k;
    paramInt2 = i;
    if (i < j)
      paramInt2 = j; 
    i = this.k;
    float f = (paramInt2 - i) * 1.0F / (this.j - i);
    if (paramInt2 > getScrollY()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.o = bool;
    if (this.f)
      setBackgroundColor(this.c.a(f)); 
    if (this.q != null) {
      if (this.g && f == 0.0F && this.i != LayoutStatus.b) {
        this.i = LayoutStatus.b;
        this.q.a();
      } else if (f == 1.0F && this.i != LayoutStatus.a) {
        this.i = LayoutStatus.a;
        this.q.b();
      } 
      this.q.a(paramInt2, f, this.o);
    } 
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setOnCloseListener(OnCloseListener paramOnCloseListener) {
    this.q = paramOnCloseListener;
  }
  
  public static interface OnCloseListener {
    void a();
    
    void a(int param1Int, float param1Float, boolean param1Boolean);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\widget\SmartDragLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */