package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;

public abstract class BarLineScatterCandleBubbleData<T extends IBarLineScatterCandleBubbleDataSet<? extends Entry>> extends ChartData<T> {
  public BarLineScatterCandleBubbleData() {}
  
  public BarLineScatterCandleBubbleData(T... paramVarArgs) {
    super(paramVarArgs);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\BarLineScatterCandleBubbleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */