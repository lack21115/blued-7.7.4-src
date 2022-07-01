package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.customview.widget.ViewDragHelper;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.player.media.observer.ScaleChangeObserver;

public class ViewDragHelperLayout extends LinearLayout implements ScaleChangeObserver.IScaleChangeObserver {
  private ViewDragHelper a = ViewDragHelper.create((ViewGroup)this, 1.0F, new ViewDragHelper.Callback(this) {
        public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
          return param1Int1;
        }
        
        public int getViewVerticalDragRange(View param1View) {
          return this.a.getMeasuredHeight() - param1View.getMeasuredWidth();
        }
        
        public void onViewDragStateChanged(int param1Int) {
          super.onViewDragStateChanged(param1Int);
          Logger.a("drb", new Object[] { "onViewDragStateChanged = ", Integer.valueOf(param1Int) });
          if (param1Int != 0)
            return; 
          if (ViewDragHelperLayout.d(this.a) != null) {
            if (!ViewDragHelperLayout.e(this.a)) {
              ViewDragHelperLayout.d(this.a).b();
              return;
            } 
            Logger.a("drb", new Object[] { "whereFromOut = ", Integer.valueOf(ViewDragHelperLayout.f(this.a)) });
            param1Int = ViewDragHelperLayout.f(this.a);
            if (param1Int != 1) {
              if (param1Int != 2) {
                ViewDragHelperLayout.d(this.a).a();
                return;
              } 
              ViewDragHelperLayout.d(this.a).d();
              ViewDragHelperLayout.d(this.a).a();
              return;
            } 
            ViewDragHelperLayout.d(this.a).c();
            ViewDragHelperLayout.d(this.a).a();
          } 
        }
        
        public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
          ViewDragHelperLayout.a(this.a, param1Int2);
          Logger.a("drb", new Object[] { "mMainLeft = ", Integer.valueOf(ViewDragHelperLayout.b(this.a)) });
          param1Int1 = (int)(Math.abs(param1Int2) * 1.0F / ViewDragHelperLayout.c(this.a) * 1.0F * 255.0F);
          if (ViewDragHelperLayout.d(this.a) != null)
            ViewDragHelperLayout.d(this.a).a(-(param1Int1 - 255)); 
        }
        
        public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
          ViewDragHelperLayout viewDragHelperLayout;
          int i = param1View.getTop();
          boolean bool3 = true;
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool5 = false;
          boolean bool6 = false;
          boolean bool2 = false;
          if (i > 0) {
            int k = param1View.getTop();
            if (param1Float2 > 2000.0F) {
              i = 0;
            } else {
              i = (int)(ViewDragHelperLayout.c(this.a) * 0.6D);
            } 
            if (k > i) {
              i = ViewDragHelperLayout.c(this.a);
            } else if ((ViewDragHelperLayout.g(this.a)).y != 0) {
              i = (ViewDragHelperLayout.g(this.a)).y;
            } else if ((ViewDragHelperLayout.h(this.a)).y != 0) {
              i = (ViewDragHelperLayout.h(this.a)).y;
            } else {
              i = (ViewDragHelperLayout.g(this.a)).y;
            } 
            ViewDragHelperLayout.i(this.a).settleCapturedViewAt(param1View.getLeft(), i);
            this.a.invalidate();
            if ((ViewDragHelperLayout.g(this.a)).y != 0) {
              viewDragHelperLayout = this.a;
              bool1 = bool2;
              if (i != (ViewDragHelperLayout.g(viewDragHelperLayout)).y)
                bool1 = true; 
              ViewDragHelperLayout.a(viewDragHelperLayout, bool1);
            } else if ((ViewDragHelperLayout.h(this.a)).y != 0) {
              viewDragHelperLayout = this.a;
              bool1 = bool5;
              if (i != (ViewDragHelperLayout.h(viewDragHelperLayout)).y)
                bool1 = true; 
              ViewDragHelperLayout.a(viewDragHelperLayout, bool1);
            } else {
              viewDragHelperLayout = this.a;
              bool1 = bool6;
              if (i != (ViewDragHelperLayout.g(viewDragHelperLayout)).y)
                bool1 = true; 
              ViewDragHelperLayout.a(viewDragHelperLayout, bool1);
            } 
            ViewDragHelperLayout.b(this.a, 1);
            return;
          } 
          int j = -viewDragHelperLayout.getTop();
          if (-param1Float2 > 2000.0F) {
            i = 0;
          } else {
            i = (int)(ViewDragHelperLayout.c(this.a) * 0.4D);
          } 
          if (j > i) {
            i = -ViewDragHelperLayout.c(this.a);
          } else if ((ViewDragHelperLayout.g(this.a)).y != 0) {
            i = (ViewDragHelperLayout.g(this.a)).y;
          } else if ((ViewDragHelperLayout.h(this.a)).y != 0) {
            i = (ViewDragHelperLayout.h(this.a)).y;
          } else {
            i = (ViewDragHelperLayout.g(this.a)).y;
          } 
          ViewDragHelperLayout.i(this.a).settleCapturedViewAt(viewDragHelperLayout.getLeft(), i);
          this.a.invalidate();
          if ((ViewDragHelperLayout.g(this.a)).y != 0) {
            viewDragHelperLayout = this.a;
            if (i == (ViewDragHelperLayout.g(viewDragHelperLayout)).y)
              bool1 = false; 
            ViewDragHelperLayout.a(viewDragHelperLayout, bool1);
          } else if ((ViewDragHelperLayout.h(this.a)).y != 0) {
            viewDragHelperLayout = this.a;
            if (i != (ViewDragHelperLayout.h(viewDragHelperLayout)).y) {
              bool1 = bool3;
            } else {
              bool1 = false;
            } 
            ViewDragHelperLayout.a(viewDragHelperLayout, bool1);
          } else {
            viewDragHelperLayout = this.a;
            if (i != (ViewDragHelperLayout.g(viewDragHelperLayout)).y) {
              bool1 = bool4;
            } else {
              bool1 = false;
            } 
            ViewDragHelperLayout.a(viewDragHelperLayout, bool1);
          } 
          ViewDragHelperLayout.b(this.a, 2);
        }
        
        public boolean tryCaptureView(View param1View, int param1Int) {
          return ViewDragHelperLayout.a(this.a);
        }
      });
  
  private View b;
  
  private View c;
  
  private int d = (getResources().getDisplayMetrics()).heightPixels;
  
  private Point e = new Point();
  
  private Point f = new Point();
  
  private OnLayoutStateListener g;
  
  private boolean h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private boolean m = true;
  
  public ViewDragHelperLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void computeScroll() {
    if (this.a.continueSettling(true))
      invalidate(); 
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    ScaleChangeObserver.a().a(this);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    ScaleChangeObserver.a().b(this);
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    this.b = getChildAt(0);
    this.c = getChildAt(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    boolean bool = this.a.shouldInterceptTouchEvent(paramMotionEvent);
    Logger.a("drb", new Object[] { "onInterceptTouchEvent = ", Integer.valueOf(paramMotionEvent.getAction()), "-- isIntercept = ", Boolean.valueOf(bool) });
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.e.x = this.b.getLeft();
    this.e.y = this.b.getTop();
    View view = this.c;
    if (view != null) {
      this.f.x = view.getLeft();
      this.f.y = this.c.getTop();
    } 
    paramInt1 = this.l;
    if (paramInt1 >= 0) {
      this.b.layout(0, paramInt1, this.j, this.k + paramInt1);
      return;
    } 
    this.b.layout(0, paramInt1, this.j, this.k - -paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.j = getMeasuredWidth();
    this.k = getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    Logger.a("drb", new Object[] { "onTouchEvent = ", Integer.valueOf(paramMotionEvent.getAction()) });
    this.a.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setOnLayoutStateListener(OnLayoutStateListener paramOnLayoutStateListener) {
    this.g = paramOnLayoutStateListener;
  }
  
  public void setScrollDisable(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public static interface OnLayoutStateListener {
    void a();
    
    void a(int param1Int);
    
    void b();
    
    void c();
    
    void d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\ViewDragHelperLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */