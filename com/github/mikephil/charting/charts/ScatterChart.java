package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.ScatterChartRenderer;

public class ScatterChart extends BarLineChartBase<ScatterData> implements ScatterDataProvider {
  public ScatterChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public ScatterChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a() {
    super.a();
    this.O = (DataRenderer)new ScatterChartRenderer(this, this.R, this.Q);
    getXAxis().c(0.5F);
    getXAxis().d(0.5F);
  }
  
  public ScatterData getScatterData() {
    return this.C;
  }
  
  public enum ScatterShape {
    a("SQUARE"),
    b("CIRCLE"),
    c("TRIANGLE"),
    d("CROSS"),
    e("X"),
    f("CHEVRON_UP"),
    g("CHEVRON_DOWN");
    
    private final String h;
    
    ScatterShape(String param1String1) {
      this.h = param1String1;
    }
    
    public String toString() {
      return this.h;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\ScatterChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */