package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;

public class LineChart extends BarLineChartBase<LineData> implements LineDataProvider {
  public LineChart(Context paramContext) {
    super(paramContext);
  }
  
  public LineChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public LineChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a() {
    super.a();
    this.O = (DataRenderer)new LineChartRenderer(this, this.R, this.Q);
  }
  
  public LineData getLineData() {
    return this.C;
  }
  
  protected void onDetachedFromWindow() {
    if (this.O != null && this.O instanceof LineChartRenderer)
      ((LineChartRenderer)this.O).b(); 
    super.onDetachedFromWindow();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\LineChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */