package com.github.chrisbanes.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class CustomGestureDetector {
  private int a = -1;
  
  private int b = 0;
  
  private final ScaleGestureDetector c;
  
  private VelocityTracker d;
  
  private boolean e;
  
  private float f;
  
  private float g;
  
  private final float h;
  
  private final float i;
  
  private OnGestureListener j;
  
  CustomGestureDetector(Context paramContext, OnGestureListener paramOnGestureListener) {
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    this.i = viewConfiguration.getScaledMinimumFlingVelocity();
    this.h = viewConfiguration.getScaledTouchSlop();
    this.j = paramOnGestureListener;
    this.c = new ScaleGestureDetector(paramContext, new ScaleGestureDetector.OnScaleGestureListener(this) {
          public boolean onScale(ScaleGestureDetector param1ScaleGestureDetector) {
            float f = param1ScaleGestureDetector.getScaleFactor();
            if (Float.isNaN(f) || Float.isInfinite(f))
              return false; 
            if (f >= 0.0F)
              CustomGestureDetector.a(this.a).a(f, param1ScaleGestureDetector.getFocusX(), param1ScaleGestureDetector.getFocusY()); 
            return true;
          }
          
          public boolean onScaleBegin(ScaleGestureDetector param1ScaleGestureDetector) {
            return true;
          }
          
          public void onScaleEnd(ScaleGestureDetector param1ScaleGestureDetector) {}
        });
  }
  
  private float b(MotionEvent paramMotionEvent) {
    try {
      return paramMotionEvent.getX(this.b);
    } catch (Exception exception) {
      return paramMotionEvent.getX();
    } 
  }
  
  private float c(MotionEvent paramMotionEvent) {
    try {
      return paramMotionEvent.getY(this.b);
    } catch (Exception exception) {
      return paramMotionEvent.getY();
    } 
  }
  
  private boolean d(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i == 6) {
              i = Util.a(paramMotionEvent.getAction());
              if (paramMotionEvent.getPointerId(i) == this.a) {
                if (i == 0) {
                  i = 1;
                } else {
                  i = 0;
                } 
                this.a = paramMotionEvent.getPointerId(i);
                this.f = paramMotionEvent.getX(i);
                this.g = paramMotionEvent.getY(i);
              } 
            } 
          } else {
            this.a = -1;
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null) {
              velocityTracker.recycle();
              this.d = null;
            } 
          } 
        } else {
          float f1 = b(paramMotionEvent);
          float f2 = c(paramMotionEvent);
          float f3 = f1 - this.f;
          float f4 = f2 - this.g;
          if (!this.e) {
            boolean bool;
            if (Math.sqrt((f3 * f3 + f4 * f4)) >= this.h) {
              bool = true;
            } else {
              bool = false;
            } 
            this.e = bool;
          } 
          if (this.e) {
            this.j.a(f3, f4);
            this.f = f1;
            this.g = f2;
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null)
              velocityTracker.addMovement(paramMotionEvent); 
          } 
        } 
      } else {
        this.a = -1;
        if (this.e && this.d != null) {
          this.f = b(paramMotionEvent);
          this.g = c(paramMotionEvent);
          this.d.addMovement(paramMotionEvent);
          this.d.computeCurrentVelocity(1000);
          float f1 = this.d.getXVelocity();
          float f2 = this.d.getYVelocity();
          if (Math.max(Math.abs(f1), Math.abs(f2)) >= this.i)
            this.j.a(this.f, this.g, -f1, -f2); 
        } 
        VelocityTracker velocityTracker = this.d;
        if (velocityTracker != null) {
          velocityTracker.recycle();
          this.d = null;
        } 
      } 
    } else {
      this.a = paramMotionEvent.getPointerId(0);
      this.d = VelocityTracker.obtain();
      VelocityTracker velocityTracker = this.d;
      if (velocityTracker != null)
        velocityTracker.addMovement(paramMotionEvent); 
      this.f = b(paramMotionEvent);
      this.g = c(paramMotionEvent);
      this.e = false;
    } 
    i = this.a;
    if (i == -1)
      i = 0; 
    this.b = paramMotionEvent.findPointerIndex(i);
    return true;
  }
  
  public boolean a() {
    return this.c.isInProgress();
  }
  
  public boolean a(MotionEvent paramMotionEvent) {
    try {
      this.c.onTouchEvent(paramMotionEvent);
      return d(paramMotionEvent);
    } catch (IllegalArgumentException illegalArgumentException) {
      return true;
    } 
  }
  
  public boolean b() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\chrisbanes\photoview\CustomGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */