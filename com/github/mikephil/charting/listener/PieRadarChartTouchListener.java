package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {
  private MPPointF f = MPPointF.a(0.0F, 0.0F);
  
  private float g = 0.0F;
  
  private ArrayList<AngularVelocitySample> h = new ArrayList<AngularVelocitySample>();
  
  private long i = 0L;
  
  private float j = 0.0F;
  
  public PieRadarChartTouchListener(PieRadarChartBase<?> paramPieRadarChartBase) {
    super(paramPieRadarChartBase);
  }
  
  private void c() {
    this.h.clear();
  }
  
  private void c(float paramFloat1, float paramFloat2) {
    long l = AnimationUtils.currentAnimationTimeMillis();
    this.h.add(new AngularVelocitySample(this, l, this.e.b(paramFloat1, paramFloat2)));
    for (int i = this.h.size(); i - 2 > 0 && l - ((AngularVelocitySample)this.h.get(0)).a > 1000L; i--)
      this.h.remove(0); 
  }
  
  private float d() {
    if (this.h.isEmpty())
      return 0.0F; 
    ArrayList<AngularVelocitySample> arrayList = this.h;
    int j = 0;
    AngularVelocitySample angularVelocitySample2 = arrayList.get(0);
    arrayList = this.h;
    AngularVelocitySample angularVelocitySample3 = arrayList.get(arrayList.size() - 1);
    int i = this.h.size() - 1;
    AngularVelocitySample angularVelocitySample1 = angularVelocitySample2;
    while (i >= 0) {
      angularVelocitySample1 = this.h.get(i);
      if (angularVelocitySample1.b != angularVelocitySample3.b)
        break; 
      i--;
    } 
    float f2 = (float)(angularVelocitySample3.a - angularVelocitySample2.a) / 1000.0F;
    float f1 = f2;
    if (f2 == 0.0F)
      f1 = 0.1F; 
    i = j;
    if (angularVelocitySample3.b >= angularVelocitySample1.b)
      i = 1; 
    j = i;
    if (Math.abs(angularVelocitySample3.b - angularVelocitySample1.b) > 270.0D)
      j = i ^ 0x1; 
    if ((angularVelocitySample3.b - angularVelocitySample2.b) > 180.0D) {
      angularVelocitySample2.b = (float)(angularVelocitySample2.b + 360.0D);
    } else if ((angularVelocitySample2.b - angularVelocitySample3.b) > 180.0D) {
      angularVelocitySample3.b = (float)(angularVelocitySample3.b + 360.0D);
    } 
    f2 = Math.abs((angularVelocitySample3.b - angularVelocitySample2.b) / f1);
    f1 = f2;
    if (j == 0)
      f1 = -f2; 
    return f1;
  }
  
  public void a() {
    this.j = 0.0F;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.g = this.e.b(paramFloat1, paramFloat2) - this.e.getRawRotationAngle();
  }
  
  public void b() {
    if (this.j == 0.0F)
      return; 
    long l = AnimationUtils.currentAnimationTimeMillis();
    this.j *= this.e.getDragDecelerationFrictionCoef();
    float f = (float)(l - this.i) / 1000.0F;
    this.e.setRotationAngle(this.e.getRotationAngle() + this.j * f);
    this.i = l;
    if (Math.abs(this.j) >= 0.001D) {
      Utils.a((View)this.e);
      return;
    } 
    a();
  }
  
  public void b(float paramFloat1, float paramFloat2) {
    this.e.setRotationAngle(this.e.b(paramFloat1, paramFloat2) - this.g);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {
    this.a = ChartTouchListener.ChartGesture.i;
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    if (onChartGestureListener != null)
      onChartGestureListener.a(paramMotionEvent); 
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
    this.a = ChartTouchListener.ChartGesture.g;
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    if (onChartGestureListener != null)
      onChartGestureListener.c(paramMotionEvent); 
    if (!this.e.w())
      return false; 
    a(this.e.a(paramMotionEvent.getX(), paramMotionEvent.getY()), paramMotionEvent);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    if (this.d.onTouchEvent(paramMotionEvent))
      return true; 
    if (this.e.k()) {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1) {
          if (i != 2)
            return true; 
          if (this.e.y())
            c(f1, f2); 
          if (this.b == 0 && a(f1, this.f.a, f2, this.f.b) > Utils.a(8.0F)) {
            this.a = ChartTouchListener.ChartGesture.f;
            this.b = 6;
            this.e.A();
          } else if (this.b == 6) {
            b(f1, f2);
            this.e.invalidate();
          } 
          b(paramMotionEvent);
          return true;
        } 
        if (this.e.y()) {
          a();
          c(f1, f2);
          this.j = d();
          if (this.j != 0.0F) {
            this.i = AnimationUtils.currentAnimationTimeMillis();
            Utils.a((View)this.e);
          } 
        } 
        this.e.B();
        this.b = 0;
        b(paramMotionEvent);
        return true;
      } 
      a(paramMotionEvent);
      a();
      c();
      if (this.e.y())
        c(f1, f2); 
      a(f1, f2);
      MPPointF mPPointF = this.f;
      mPPointF.a = f1;
      mPPointF.b = f2;
    } 
    return true;
  }
  
  class AngularVelocitySample {
    public long a;
    
    public float b;
    
    public AngularVelocitySample(PieRadarChartTouchListener this$0, long param1Long, float param1Float) {
      this.a = param1Long;
      this.b = param1Float;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\listener\PieRadarChartTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */