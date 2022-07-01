package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
  protected ChartGesture a = ChartGesture.a;
  
  protected int b = 0;
  
  protected Highlight c;
  
  protected GestureDetector d;
  
  protected T e;
  
  public ChartTouchListener(T paramT) {
    this.e = paramT;
    this.d = new GestureDetector(paramT.getContext(), (GestureDetector.OnGestureListener)this);
  }
  
  protected static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    paramFloat1 -= paramFloat2;
    paramFloat2 = paramFloat3 - paramFloat4;
    return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
  }
  
  public void a(MotionEvent paramMotionEvent) {
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    if (onChartGestureListener != null)
      onChartGestureListener.a(paramMotionEvent, this.a); 
  }
  
  public void a(Highlight paramHighlight) {
    this.c = paramHighlight;
  }
  
  protected void a(Highlight paramHighlight, MotionEvent paramMotionEvent) {
    if (paramHighlight == null || paramHighlight.a(this.c)) {
      this.e.a(null, true);
      this.c = null;
      return;
    } 
    this.e.a(paramHighlight, true);
    this.c = paramHighlight;
  }
  
  public void b(MotionEvent paramMotionEvent) {
    OnChartGestureListener onChartGestureListener = this.e.getOnChartGestureListener();
    if (onChartGestureListener != null)
      onChartGestureListener.b(paramMotionEvent, this.a); 
  }
  
  public enum ChartGesture {
    a, b, c, d, e, f, g, h, i, j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\listener\ChartTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */