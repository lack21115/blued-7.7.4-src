package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.blued.android.framework.R;
import java.security.InvalidParameterException;

public class PullRefreshLayout extends ViewGroup {
  private View a;
  
  private ImageView b;
  
  private Interpolator c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private RefreshDrawable h;
  
  private int i;
  
  private boolean j;
  
  private int k;
  
  private boolean l;
  
  private float m;
  
  private int n;
  
  private boolean o;
  
  private OnRefreshListener p;
  
  private int[] q;
  
  private final Animation r = new Animation(this) {
      public void applyTransformation(float param1Float, Transformation param1Transformation) {
        PullRefreshLayout.a(this.a, param1Float);
      }
    };
  
  private final Animation s = new Animation(this) {
      public void applyTransformation(float param1Float, Transformation param1Transformation) {
        int j = PullRefreshLayout.a(this.a);
        int i = PullRefreshLayout.b(this.a);
        j = (int)((j - PullRefreshLayout.b(this.a)) * param1Float);
        int k = PullRefreshLayout.c(this.a).getTop();
        PullRefreshLayout.a(this.a, i + j - k, false);
      }
    };
  
  private Animation.AnimationListener t = new Animation.AnimationListener(this) {
      public void onAnimationEnd(Animation param1Animation) {
        if (!PullRefreshLayout.d(this.a)) {
          PullRefreshLayout.e(this.a).stop();
          PullRefreshLayout.h(this.a).setVisibility(8);
          PullRefreshLayout.i(this.a);
        } 
        PullRefreshLayout pullRefreshLayout = this.a;
        PullRefreshLayout.a(pullRefreshLayout, PullRefreshLayout.c(pullRefreshLayout).getTop());
      }
      
      public void onAnimationRepeat(Animation param1Animation) {}
      
      public void onAnimationStart(Animation param1Animation) {
        if (PullRefreshLayout.d(this.a)) {
          PullRefreshLayout.e(this.a).start();
          if (PullRefreshLayout.f(this.a) && PullRefreshLayout.g(this.a) != null)
            PullRefreshLayout.g(this.a).a(); 
        } 
      }
    };
  
  private Animation.AnimationListener u = new Animation.AnimationListener(this) {
      public void onAnimationEnd(Animation param1Animation) {
        PullRefreshLayout.e(this.a).stop();
        PullRefreshLayout.h(this.a).setVisibility(8);
        PullRefreshLayout pullRefreshLayout = this.a;
        PullRefreshLayout.a(pullRefreshLayout, PullRefreshLayout.c(pullRefreshLayout).getTop());
      }
      
      public void onAnimationRepeat(Animation param1Animation) {}
      
      public void onAnimationStart(Animation param1Animation) {}
    };
  
  public PullRefreshLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PullRefreshLayout);
    int i = typedArray.getInteger(R.styleable.PullRefreshLayout_type, 0);
    int j = typedArray.getResourceId(R.styleable.PullRefreshLayout_colors, R.array.progress_wheel_colors);
    typedArray.recycle();
    this.c = (Interpolator)new DecelerateInterpolator(2.0F);
    this.d = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.e = getResources().getInteger(17694721);
    int k = a(64);
    this.g = k;
    this.f = k;
    this.b = new ImageView(paramContext);
    this.q = paramContext.getResources().getIntArray(j);
    setRefreshStyle(i);
    this.b.setVisibility(8);
    addView((View)this.b);
    setWillNotDraw(false);
  }
  
  private float a(MotionEvent paramMotionEvent, int paramInt) {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    return (paramInt < 0) ? -1.0F : MotionEventCompat.getY(paramMotionEvent, paramInt);
  }
  
  private int a(int paramInt) {
    return (int)TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
  }
  
  private void a() {
    if (this.a != null)
      return; 
    if (getChildCount() > 0)
      for (int i = 0; i < getChildCount(); i++) {
        View view = getChildAt(i);
        if (view != this.b)
          this.a = view; 
      }  
  }
  
  private void a(float paramFloat) {
    int i = this.n;
    a(i - (int)(i * paramFloat) - this.a.getTop(), false);
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    this.b.bringToFront();
    this.a.offsetTopAndBottom(paramInt);
    this.h.c(paramInt);
    this.i = this.a.getTop();
  }
  
  private void a(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.k) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.k = MotionEventCompat.getPointerId(paramMotionEvent, i);
    } 
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.j != paramBoolean1) {
      this.o = paramBoolean2;
      a();
      this.j = paramBoolean1;
      if (this.j) {
        this.h.c(1.0F);
        c();
        return;
      } 
      b();
    } 
  }
  
  private void b() {
    this.n = this.i;
    this.r.reset();
    this.r.setDuration(this.e);
    this.r.setInterpolator(this.c);
    this.r.setAnimationListener(this.u);
    this.b.clearAnimation();
    this.b.startAnimation(this.r);
  }
  
  private void c() {
    this.n = this.i;
    this.s.reset();
    this.s.setDuration(this.e);
    this.s.setInterpolator(this.c);
    this.s.setAnimationListener(this.t);
    this.b.clearAnimation();
    this.b.startAnimation(this.s);
  }
  
  private boolean d() {
    return ViewCompat.canScrollVertically(this.a, -1);
  }
  
  public int getFinalOffset() {
    return this.f;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (isEnabled() && !d()) {
      if (this.j)
        return false; 
      int i = MotionEventCompat.getActionMasked(paramMotionEvent);
      if (i != 0) {
        if (i != 1)
          if (i != 2) {
            if (i != 3) {
              if (i == 6)
                a(paramMotionEvent); 
              return this.l;
            } 
          } else {
            i = this.k;
            if (i == -1)
              return false; 
            float f = a(paramMotionEvent, i);
            if (f == -1.0F)
              return false; 
            if (f - this.m > this.d && !this.l)
              this.l = true; 
            return this.l;
          }  
        this.l = false;
        this.k = -1;
      } else {
        a(0, true);
        this.k = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.l = false;
        float f = a(paramMotionEvent, this.k);
        if (f == -1.0F)
          return false; 
        this.m = f;
      } 
      return this.l;
    } 
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a();
    if (this.a == null)
      return; 
    paramInt4 = getMeasuredHeight();
    int j = getMeasuredWidth();
    paramInt1 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    int k = getPaddingRight();
    int i = getPaddingBottom();
    View view = this.a;
    paramInt3 = this.i;
    j = j + paramInt1 - k;
    paramInt4 = paramInt4 + paramInt2 - i;
    view.layout(paramInt1, paramInt2 + paramInt3, j, paramInt3 + paramInt4);
    this.b.layout(paramInt1, paramInt2, j, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    a();
    if (this.a == null)
      return; 
    paramInt1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingRight() - getPaddingLeft(), 1073741824);
    paramInt2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824);
    this.a.measure(paramInt1, paramInt2);
    this.b.measure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!this.l)
      return super.onTouchEvent(paramMotionEvent); 
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i != 1)
      if (i != 2) {
        if (i != 3) {
          if (i != 5) {
            if (i != 6)
              return true; 
            a(paramMotionEvent);
            return true;
          } 
          this.k = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
          return true;
        } 
      } else {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.k);
        if (i < 0)
          return false; 
        float f3 = (MotionEventCompat.getY(paramMotionEvent, i) - this.m) * 0.5F;
        float f4 = f3 / this.g;
        if (f4 < 0.0F)
          return false; 
        f4 = Math.min(1.0F, Math.abs(f4));
        float f5 = Math.abs(f3);
        float f6 = this.g;
        float f7 = this.f;
        double d = (Math.max(0.0F, Math.min(f5 - f6, f7 * 2.0F) / f7) / 4.0F);
        i = (int)(f7 * f4 + (float)(d - Math.pow(d, 2.0D)) * 2.0F * f7 * 2.0F);
        if (this.b.getVisibility() != 0)
          this.b.setVisibility(0); 
        if (f3 < this.g)
          this.h.c(f4); 
        a(i - this.i, true);
        return true;
      }  
    i = this.k;
    if (i == -1)
      return false; 
    float f1 = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, i));
    float f2 = this.m;
    this.l = false;
    if ((f1 - f2) * 0.5F > this.g) {
      a(true, true);
    } else {
      this.j = false;
      b();
    } 
    this.k = -1;
    return false;
  }
  
  public void setColorSchemeColors(int[] paramArrayOfint) {
    this.q = paramArrayOfint;
    this.h.a(paramArrayOfint);
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener) {
    this.p = paramOnRefreshListener;
  }
  
  public void setRefreshDrawable(RefreshDrawable paramRefreshDrawable) {
    setRefreshing(false);
    this.h = paramRefreshDrawable;
    this.h.a(this.q);
    this.b.setImageDrawable(this.h);
  }
  
  public void setRefreshStyle(int paramInt) {
    setRefreshing(false);
    if (paramInt == 0) {
      this.h = new MaterialDrawable(getContext(), this);
      this.h.a(this.q);
      this.b.setImageDrawable(this.h);
      return;
    } 
    throw new InvalidParameterException("Type does not exist");
  }
  
  public void setRefreshing(boolean paramBoolean) {
    if (this.j != paramBoolean)
      a(paramBoolean, false); 
  }
  
  public static interface OnRefreshListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PullRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */