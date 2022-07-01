package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
  public RadarHighlighter(RadarChart paramRadarChart) {
    super(paramRadarChart);
  }
  
  protected Highlight a(int paramInt, float paramFloat1, float paramFloat2) {
    List<Highlight> list = a(paramInt);
    float f = this.a.d(paramFloat1, paramFloat2) / this.a.getFactor();
    Highlight highlight = null;
    paramFloat1 = Float.MAX_VALUE;
    paramInt = 0;
    while (paramInt < list.size()) {
      Highlight highlight1 = list.get(paramInt);
      float f1 = Math.abs(highlight1.b() - f);
      paramFloat2 = paramFloat1;
      if (f1 < paramFloat1) {
        highlight = highlight1;
        paramFloat2 = f1;
      } 
      paramInt++;
      paramFloat1 = paramFloat2;
    } 
    return highlight;
  }
  
  protected List<Highlight> a(int paramInt) {
    this.b.clear();
    float f1 = this.a.getAnimator().b();
    float f2 = this.a.getAnimator().a();
    float f3 = this.a.getSliceAngle();
    float f4 = this.a.getFactor();
    MPPointF mPPointF = MPPointF.a(0.0F, 0.0F);
    int i = 0;
    while (true) {
      int j = paramInt;
      if (i < ((RadarData)this.a.getData()).d()) {
        IDataSet iDataSet = ((RadarData)this.a.getData()).a(i);
        Entry entry = iDataSet.e(j);
        float f5 = entry.b();
        float f6 = this.a.getYChartMin();
        MPPointF mPPointF1 = this.a.getCenterOffsets();
        float f7 = j;
        Utils.a(mPPointF1, (f5 - f6) * f4 * f2, f3 * f7 * f1 + this.a.getRotationAngle(), mPPointF);
        this.b.add(new Highlight(f7, entry.b(), mPPointF.a, mPPointF.b, i, iDataSet.C()));
        i++;
        continue;
      } 
      return this.b;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\highlight\RadarHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */