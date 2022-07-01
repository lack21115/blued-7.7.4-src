package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.renderer.CandleStickChartRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;

public class CandleStickChart extends BarLineChartBase<CandleData> implements CandleDataProvider {
  public CandleStickChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public CandleStickChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a() {
    super.a();
    this.O = (DataRenderer)new CandleStickChartRenderer(this, this.R, this.Q);
    getXAxis().c(0.5F);
    getXAxis().d(0.5F);
  }
  
  public CandleData getCandleData() {
    return this.C;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\CandleStickChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */