package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.data.CombinedData;

public interface CombinedDataProvider extends BarDataProvider, BubbleDataProvider, CandleDataProvider, LineDataProvider, ScatterDataProvider {
  CombinedData getCombinedData();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\interfaces\dataprovider\CombinedDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */