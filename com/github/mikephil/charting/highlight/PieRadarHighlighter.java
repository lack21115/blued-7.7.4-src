package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {
  protected T a;
  
  protected List<Highlight> b = new ArrayList<Highlight>();
  
  public PieRadarHighlighter(T paramT) {
    this.a = paramT;
  }
  
  public Highlight a(float paramFloat1, float paramFloat2) {
    if (this.a.d(paramFloat1, paramFloat2) > this.a.getRadius())
      return null; 
    float f2 = this.a.b(paramFloat1, paramFloat2);
    T t = this.a;
    float f1 = f2;
    if (t instanceof com.github.mikephil.charting.charts.PieChart)
      f1 = f2 / t.getAnimator().a(); 
    int i = this.a.a(f1);
    return (i >= 0) ? ((i >= this.a.getData().k().H()) ? null : a(i, paramFloat1, paramFloat2)) : null;
  }
  
  protected abstract Highlight a(int paramInt, float paramFloat1, float paramFloat2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\highlight\PieRadarHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */