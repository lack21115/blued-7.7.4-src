package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;

public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry> extends DataSet<T> implements IBarLineScatterCandleBubbleDataSet<T> {
  protected int a = Color.rgb(255, 187, 115);
  
  public BarLineScatterCandleBubbleDataSet(List<T> paramList, String paramString) {
    super(paramList, paramString);
  }
  
  public int h() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\BarLineScatterCandleBubbleDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */