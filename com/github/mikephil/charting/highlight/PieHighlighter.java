package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

public class PieHighlighter extends PieRadarHighlighter<PieChart> {
  public PieHighlighter(PieChart paramPieChart) {
    super(paramPieChart);
  }
  
  protected Highlight a(int paramInt, float paramFloat1, float paramFloat2) {
    IPieDataSet iPieDataSet = ((PieData)this.a.getData()).a();
    Entry entry = iPieDataSet.e(paramInt);
    return new Highlight(paramInt, entry.b(), paramFloat1, paramFloat2, 0, iPieDataSet.C());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\highlight\PieHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */