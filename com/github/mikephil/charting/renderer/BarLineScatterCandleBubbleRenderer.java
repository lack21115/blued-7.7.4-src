package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class BarLineScatterCandleBubbleRenderer extends DataRenderer {
  protected XBounds f = new XBounds(this);
  
  public BarLineScatterCandleBubbleRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
  }
  
  protected boolean a(Entry paramEntry, IBarLineScatterCandleBubbleDataSet paramIBarLineScatterCandleBubbleDataSet) {
    if (paramEntry == null)
      return false; 
    float f = paramIBarLineScatterCandleBubbleDataSet.d(paramEntry);
    return (paramEntry != null) ? (!(f >= paramIBarLineScatterCandleBubbleDataSet.H() * this.g.b())) : false;
  }
  
  protected boolean a(IDataSet paramIDataSet) {
    return (paramIDataSet.B() && (paramIDataSet.y() || paramIDataSet.z()));
  }
  
  public class XBounds {
    public int a;
    
    public int b;
    
    public int c;
    
    protected XBounds(BarLineScatterCandleBubbleRenderer this$0) {}
    
    public void a(BarLineScatterCandleBubbleDataProvider param1BarLineScatterCandleBubbleDataProvider, IBarLineScatterCandleBubbleDataSet param1IBarLineScatterCandleBubbleDataSet) {
      int i;
      float f1 = Math.max(0.0F, Math.min(1.0F, this.d.g.b()));
      float f2 = param1BarLineScatterCandleBubbleDataProvider.getLowestVisibleX();
      float f3 = param1BarLineScatterCandleBubbleDataProvider.getHighestVisibleX();
      Entry entry1 = param1IBarLineScatterCandleBubbleDataSet.a(f2, Float.NaN, DataSet.Rounding.b);
      Entry entry2 = param1IBarLineScatterCandleBubbleDataSet.a(f3, Float.NaN, DataSet.Rounding.a);
      boolean bool = false;
      if (entry1 == null) {
        i = 0;
      } else {
        i = param1IBarLineScatterCandleBubbleDataSet.d(entry1);
      } 
      this.a = i;
      if (entry2 == null) {
        i = bool;
      } else {
        i = param1IBarLineScatterCandleBubbleDataSet.d(entry2);
      } 
      this.b = i;
      this.c = (int)((this.b - this.a) * f1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\BarLineScatterCandleBubbleRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */