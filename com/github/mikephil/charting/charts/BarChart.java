package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;

public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {
  protected boolean a = false;
  
  private boolean aa = true;
  
  private boolean ab = false;
  
  private boolean ac = false;
  
  public BarChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public BarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Highlight a(float paramFloat1, float paramFloat2) {
    if (this.C == null) {
      Log.e("MPAndroidChart", "Can't select by touch. No data set.");
      return null;
    } 
    Highlight highlight = getHighlighter().a(paramFloat1, paramFloat2);
    return (highlight != null) ? (!e() ? highlight : new Highlight(highlight.a(), highlight.b(), highlight.c(), highlight.d(), highlight.f(), -1, highlight.h())) : highlight;
  }
  
  protected void a() {
    super.a();
    this.O = (DataRenderer)new BarChartRenderer(this, this.R, this.Q);
    setHighlighter((ChartHighlighter)new BarHighlighter(this));
    getXAxis().c(0.5F);
    getXAxis().d(0.5F);
  }
  
  protected void b() {
    if (this.ac) {
      this.H.a(this.C.g() - this.C.a() / 2.0F, this.C.h() + this.C.a() / 2.0F);
    } else {
      this.H.a(this.C.g(), this.C.h());
    } 
    this.o.a(this.C.a(YAxis.AxisDependency.a), this.C.b(YAxis.AxisDependency.a));
    this.p.a(this.C.a(YAxis.AxisDependency.b), this.C.b(YAxis.AxisDependency.b));
  }
  
  public boolean c() {
    return this.aa;
  }
  
  public boolean d() {
    return this.ab;
  }
  
  public boolean e() {
    return this.a;
  }
  
  public BarData getBarData() {
    return this.C;
  }
  
  public void setDrawBarShadow(boolean paramBoolean) {
    this.ab = paramBoolean;
  }
  
  public void setDrawValueAboveBar(boolean paramBoolean) {
    this.aa = paramBoolean;
  }
  
  public void setFitBars(boolean paramBoolean) {
    this.ac = paramBoolean;
  }
  
  public void setHighlightFullBarEnabled(boolean paramBoolean) {
    this.a = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\BarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */