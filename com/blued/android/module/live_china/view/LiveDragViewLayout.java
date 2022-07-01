package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.customview.widget.ViewDragHelper;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.same.Logger;

public class LiveDragViewLayout extends LinearLayout {
  private ViewDragHelper a;
  
  private Point b;
  
  private View c;
  
  private int d;
  
  private OnLayoutStateListener e;
  
  private boolean f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private ListView k;
  
  private View l;
  
  private View m;
  
  private ViewDragHelperLayout n;
  
  private boolean o;
  
  private boolean p = true;
  
  private boolean q = false;
  
  private ViewDragHelper.Callback r = new ViewDragHelper.Callback(this) {
      public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
        if (!LiveDragViewLayout.c(this.a))
          return 0; 
        if (LiveDragViewLayout.d(this.a)) {
          if (LiveDragViewLayout.e(this.a) + param1Int2 > LiveDragViewLayout.f(this.a))
            return LiveDragViewLayout.f(this.a); 
          if (-LiveDragViewLayout.e(this.a) + -param1Int2 > LiveDragViewLayout.f(this.a))
            return -LiveDragViewLayout.f(this.a); 
        } 
        return param1Int1;
      }
      
      public int getViewVerticalDragRange(View param1View) {
        return this.a.getMeasuredHeight();
      }
      
      public void onViewDragStateChanged(int param1Int) {
        super.onViewDragStateChanged(param1Int);
        Logger.a("drb", new Object[] { "onViewDragStateChanged = ", Integer.valueOf(param1Int) });
        if (param1Int != 0)
          return; 
        if (LiveDragViewLayout.j(this.a) != null) {
          if (!LiveDragViewLayout.k(this.a)) {
            LiveDragViewLayout.j(this.a).a();
            return;
          } 
          Logger.a("drb", new Object[] { "whereFromOut = ", Integer.valueOf(LiveDragViewLayout.l(this.a)) });
          param1Int = LiveDragViewLayout.l(this.a);
          if (param1Int != 1) {
            if (param1Int != 2)
              return; 
            LiveDragViewLayout.j(this.a).c();
            return;
          } 
          LiveDragViewLayout.j(this.a).b();
        } 
      }
      
      public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
        super.onViewPositionChanged(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
        LiveDragViewLayout.b(this.a, param1Int2);
        if (LiveDragViewLayout.d(this.a))
          if (LiveDragViewLayout.e(this.a) > LiveDragViewLayout.f(this.a)) {
            LiveDragViewLayout liveDragViewLayout = this.a;
            LiveDragViewLayout.b(liveDragViewLayout, LiveDragViewLayout.f(liveDragViewLayout));
          } else if (-LiveDragViewLayout.e(this.a) > LiveDragViewLayout.f(this.a)) {
            LiveDragViewLayout liveDragViewLayout = this.a;
            LiveDragViewLayout.b(liveDragViewLayout, -LiveDragViewLayout.f(liveDragViewLayout));
          }  
        param1Int1 = (int)(Math.abs(param1Int2) * 1.0F / LiveDragViewLayout.g(this.a) * 1.0F * 255.0F);
        if (LiveDragViewLayout.j(this.a) != null)
          LiveDragViewLayout.j(this.a).a(-(param1Int1 - 255)); 
      }
      
      public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
        LiveDragViewLayout liveDragViewLayout;
        super.onViewReleased(param1View, param1Float1, param1Float2);
        int i = param1View.getTop();
        boolean bool3 = true;
        boolean bool1 = true;
        boolean bool4 = false;
        boolean bool2 = false;
        if (i > 0) {
          int k = param1View.getTop();
          if (!LiveDragViewLayout.d(this.a) && param1Float2 > 5000.0F) {
            i = 0;
          } else {
            i = (int)(LiveDragViewLayout.g(this.a) * 0.5D);
          } 
          if (k > i) {
            i = LiveDragViewLayout.g(this.a);
          } else if ((LiveDragViewLayout.h(this.a)).y != 0) {
            i = (LiveDragViewLayout.h(this.a)).y;
          } else {
            i = (LiveDragViewLayout.h(this.a)).y;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("settleTop = ");
          stringBuilder.append(i);
          Logger.a("pk", new Object[] { stringBuilder.toString() });
          LiveDragViewLayout.i(this.a).settleCapturedViewAt(param1View.getLeft(), i);
          this.a.invalidate();
          if ((LiveDragViewLayout.h(this.a)).y != 0) {
            liveDragViewLayout = this.a;
            bool1 = bool2;
            if (i != (LiveDragViewLayout.h(liveDragViewLayout)).y)
              bool1 = true; 
            LiveDragViewLayout.a(liveDragViewLayout, bool1);
          } else {
            liveDragViewLayout = this.a;
            bool1 = bool4;
            if (i != (LiveDragViewLayout.h(liveDragViewLayout)).y)
              bool1 = true; 
            LiveDragViewLayout.a(liveDragViewLayout, bool1);
          } 
          LiveDragViewLayout.a(this.a, 1);
          return;
        } 
        int j = -liveDragViewLayout.getTop();
        if (!LiveDragViewLayout.d(this.a) && -param1Float2 > 5000.0F) {
          i = 0;
        } else {
          i = (int)(LiveDragViewLayout.g(this.a) * 0.5D);
        } 
        if (j > i) {
          i = -LiveDragViewLayout.g(this.a);
        } else if ((LiveDragViewLayout.h(this.a)).y != 0) {
          i = (LiveDragViewLayout.h(this.a)).y;
        } else {
          i = (LiveDragViewLayout.h(this.a)).y;
        } 
        LiveDragViewLayout.i(this.a).settleCapturedViewAt(liveDragViewLayout.getLeft(), i);
        this.a.invalidate();
        if ((LiveDragViewLayout.h(this.a)).y != 0) {
          liveDragViewLayout = this.a;
          if (i == (LiveDragViewLayout.h(liveDragViewLayout)).y)
            bool1 = false; 
          LiveDragViewLayout.a(liveDragViewLayout, bool1);
        } else {
          liveDragViewLayout = this.a;
          if (i != (LiveDragViewLayout.h(liveDragViewLayout)).y) {
            bool1 = bool3;
          } else {
            bool1 = false;
          } 
          LiveDragViewLayout.a(liveDragViewLayout, bool1);
        } 
        LiveDragViewLayout.a(this.a, 2);
      }
      
      public boolean tryCaptureView(View param1View, int param1Int) {
        if (LiveDragViewLayout.a(this.a) == null) {
          LiveDragViewLayout.a(this.a, (ListView)param1View.findViewById(R.id.live_msg_content_pullrefresh));
          LiveDragViewLayout.a(this.a, param1View.findViewById(R.id.live_make_friend_list_view));
          LiveDragViewLayout.b(this.a, param1View.findViewById(R.id.live_activity_web_view));
        } 
        return LiveDragViewLayout.b(this.a);
      }
    };
  
  private int s;
  
  public LiveDragViewLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a() {
    this.a = ViewDragHelper.create((ViewGroup)this, 1.0F, this.r);
    this.d = (getResources().getDisplayMetrics()).heightPixels;
    this.b = new Point();
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2) {
    if (paramView == null)
      return false; 
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    return (paramInt2 >= j && paramInt2 <= m + j && paramInt1 >= i && paramInt1 <= k + i);
  }
  
  public void a(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public void computeScroll() {
    super.computeScroll();
    if (this.a.continueSettling(true))
      invalidate(); 
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    this.c = getChildAt(0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    try {
      if (this.k != null) {
        int i = (int)paramMotionEvent.getRawX();
        int j = (int)paramMotionEvent.getRawY();
        if (a((View)this.k, i, j))
          return false; 
      } 
      if (this.n != null && this.n.getVisibility() == 0)
        return false; 
      if (this.l != null && this.l.getVisibility() == 0)
        return false; 
      if (this.m != null) {
        int i = this.m.getVisibility();
        if (i == 0)
          return false; 
      } 
    } catch (Exception exception) {}
    return this.a.shouldInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.x = this.c.getLeft();
    this.b.y = this.c.getTop();
    paramInt1 = this.j;
    if (paramInt1 >= 0) {
      this.c.layout(0, paramInt1, this.h, this.i + paramInt1);
      return;
    } 
    this.c.layout(0, paramInt1, this.h, this.i - -paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = getMeasuredWidth();
    this.i = getMeasuredHeight();
    this.s = (int)(this.i * 0.1F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    this.a.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setDragEnable(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  public void setGestureLayout(ViewDragHelperLayout paramViewDragHelperLayout) {
    this.n = paramViewDragHelperLayout;
  }
  
  public void setOnLayoutStateListener(OnLayoutStateListener paramOnLayoutStateListener) {
    this.e = paramOnLayoutStateListener;
  }
  
  public void setRTCModel(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public static interface OnLayoutStateListener {
    void a();
    
    void a(int param1Int);
    
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveDragViewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */