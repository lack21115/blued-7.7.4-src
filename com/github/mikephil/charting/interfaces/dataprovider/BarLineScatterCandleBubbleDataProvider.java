package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {
  Transformer a(YAxis.AxisDependency paramAxisDependency);
  
  boolean c(YAxis.AxisDependency paramAxisDependency);
  
  BarLineScatterCandleBubbleData getData();
  
  float getHighestVisibleX();
  
  float getLowestVisibleX();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\interfaces\dataprovider\BarLineScatterCandleBubbleDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */