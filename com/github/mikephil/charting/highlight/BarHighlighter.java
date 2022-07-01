package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;

public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
  public BarHighlighter(BarDataProvider paramBarDataProvider) {
    super(paramBarDataProvider);
  }
  
  protected float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    return Math.abs(paramFloat1 - paramFloat3);
  }
  
  protected int a(Range[] paramArrayOfRange, float paramFloat) {
    byte b = 0;
    int i = b;
    if (paramArrayOfRange != null) {
      if (paramArrayOfRange.length == 0)
        return 0; 
      int k = paramArrayOfRange.length;
      i = 0;
      int j = 0;
      while (i < k) {
        if (paramArrayOfRange[i].a(paramFloat))
          return j; 
        j++;
        i++;
      } 
      j = Math.max(paramArrayOfRange.length - 1, 0);
      i = b;
      if (paramFloat > (paramArrayOfRange[j]).b)
        i = j; 
    } 
    return i;
  }
  
  protected BarLineScatterCandleBubbleData a() {
    return (BarLineScatterCandleBubbleData)this.a.getBarData();
  }
  
  public Highlight a(float paramFloat1, float paramFloat2) {
    Highlight highlight = super.a(paramFloat1, paramFloat2);
    if (highlight == null)
      return null; 
    MPPointD mPPointD = b(paramFloat1, paramFloat2);
    IBarDataSet iBarDataSet = (IBarDataSet)this.a.getBarData().a(highlight.f());
    if (iBarDataSet.b())
      return a(highlight, iBarDataSet, (float)mPPointD.a, (float)mPPointD.b); 
    MPPointD.a(mPPointD);
    return highlight;
  }
  
  public Highlight a(Highlight paramHighlight, IBarDataSet paramIBarDataSet, float paramFloat1, float paramFloat2) {
    BarEntry barEntry = (BarEntry)paramIBarDataSet.b(paramFloat1, paramFloat2);
    if (barEntry == null)
      return null; 
    if (barEntry.a() == null)
      return paramHighlight; 
    Range[] arrayOfRange = barEntry.c();
    if (arrayOfRange.length > 0) {
      int i = a(arrayOfRange, paramFloat2);
      MPPointD mPPointD = this.a.a(paramIBarDataSet.C()).b(paramHighlight.a(), (arrayOfRange[i]).b);
      paramHighlight = new Highlight(barEntry.i(), barEntry.b(), (float)mPPointD.a, (float)mPPointD.b, paramHighlight.f(), i, paramHighlight.h());
      MPPointD.a(mPPointD);
      return paramHighlight;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\highlight\BarHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */