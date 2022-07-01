package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public class DefaultFillFormatter implements IFillFormatter {
  public float getFillLinePosition(ILineDataSet paramILineDataSet, LineDataProvider paramLineDataProvider) {
    float f1 = paramLineDataProvider.getYChartMax();
    float f2 = paramLineDataProvider.getYChartMin();
    LineData lineData = paramLineDataProvider.getLineData();
    if (paramILineDataSet.K() > 0.0F && paramILineDataSet.J() < 0.0F)
      return 0.0F; 
    if (lineData.f() > 0.0F)
      f1 = 0.0F; 
    if (lineData.e() < 0.0F)
      f2 = 0.0F; 
    return (paramILineDataSet.J() >= 0.0F) ? f2 : f1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\formatter\DefaultFillFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */