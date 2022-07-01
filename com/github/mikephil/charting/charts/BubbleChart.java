package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.renderer.BubbleChartRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;

public class BubbleChart extends BarLineChartBase<BubbleData> implements BubbleDataProvider {
  public BubbleChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public BubbleChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a() {
    super.a();
    this.O = (DataRenderer)new BubbleChartRenderer(this, this.R, this.Q);
  }
  
  public BubbleData getBubbleData() {
    return this.C;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\BubbleChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */