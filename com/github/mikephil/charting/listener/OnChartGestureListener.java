package com.github.mikephil.charting.listener;

import android.view.MotionEvent;

public interface OnChartGestureListener {
  void a(MotionEvent paramMotionEvent);
  
  void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2);
  
  void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  void a(MotionEvent paramMotionEvent, ChartTouchListener.ChartGesture paramChartGesture);
  
  void b(MotionEvent paramMotionEvent);
  
  void b(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2);
  
  void b(MotionEvent paramMotionEvent, ChartTouchListener.ChartGesture paramChartGesture);
  
  void c(MotionEvent paramMotionEvent);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\listener\OnChartGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */