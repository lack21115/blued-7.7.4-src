package com.blued.android.framework.view.wheel.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class WheelScroller {
  private ScrollingListener a;
  
  private Context b;
  
  private GestureDetector c;
  
  private Scroller d;
  
  private int e;
  
  private float f;
  
  private boolean g;
  
  private GestureDetector.SimpleOnGestureListener h = new GestureDetector.SimpleOnGestureListener(this) {
      public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
        WheelScroller.a(this.a, 0);
        WheelScroller.b(this.a).fling(0, WheelScroller.a(this.a), 0, (int)-param1Float2, 0, 0, -2147483647, 2147483647);
        WheelScroller.b(this.a, 0);
        return true;
      }
      
      public boolean onScroll(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
        return true;
      }
    };
  
  private final int i = 0;
  
  private final int j = 1;
  
  private Handler k = new Handler(this) {
      public void handleMessage(Message param1Message) {
        WheelScroller.b(this.a).computeScrollOffset();
        int i = WheelScroller.b(this.a).getCurrY();
        int j = WheelScroller.a(this.a) - i;
        WheelScroller.a(this.a, i);
        if (j != 0)
          WheelScroller.c(this.a).a(j); 
        if (Math.abs(i - WheelScroller.b(this.a).getFinalY()) < 1) {
          WheelScroller.b(this.a).getFinalY();
          WheelScroller.b(this.a).forceFinished(true);
        } 
        if (!WheelScroller.b(this.a).isFinished()) {
          WheelScroller.d(this.a).sendEmptyMessage(param1Message.what);
          return;
        } 
        if (param1Message.what == 0) {
          WheelScroller.e(this.a);
          return;
        } 
        this.a.b();
      }
    };
  
  public WheelScroller(Context paramContext, ScrollingListener paramScrollingListener) {
    this.c = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)this.h);
    this.c.setIsLongpressEnabled(false);
    this.d = new Scroller(paramContext);
    this.a = paramScrollingListener;
    this.b = paramContext;
  }
  
  private void a(int paramInt) {
    c();
    this.k.sendEmptyMessage(paramInt);
  }
  
  private void c() {
    this.k.removeMessages(0);
    this.k.removeMessages(1);
  }
  
  private void d() {
    this.a.c();
    a(1);
  }
  
  private void e() {
    if (!this.g) {
      this.g = true;
      this.a.a();
    } 
  }
  
  public void a() {
    this.d.forceFinished(true);
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.d.forceFinished(true);
    this.e = 0;
    Scroller scroller = this.d;
    if (paramInt2 == 0)
      paramInt2 = 400; 
    scroller.startScroll(0, 0, 0, paramInt1, paramInt2);
    a(0);
    e();
  }
  
  public void a(Interpolator paramInterpolator) {
    this.d.forceFinished(true);
    this.d = new Scroller(this.b, paramInterpolator);
  }
  
  public boolean a(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i == 2) {
        i = (int)(paramMotionEvent.getY() - this.f);
        if (i != 0) {
          e();
          this.a.a(i);
          this.f = paramMotionEvent.getY();
        } 
      } 
    } else {
      this.f = paramMotionEvent.getY();
      this.d.forceFinished(true);
      c();
    } 
    if (!this.c.onTouchEvent(paramMotionEvent) && paramMotionEvent.getAction() == 1)
      d(); 
    return true;
  }
  
  void b() {
    if (this.g) {
      this.a.b();
      this.g = false;
    } 
  }
  
  public static interface ScrollingListener {
    void a();
    
    void a(int param1Int);
    
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\wheel\widget\WheelScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */