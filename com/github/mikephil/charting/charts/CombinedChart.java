package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;
import com.github.mikephil.charting.renderer.DataRenderer;

public class CombinedChart extends BarLineChartBase<CombinedData> implements CombinedDataProvider {
  protected boolean a = false;
  
  protected DrawOrder[] aa;
  
  private boolean ab = true;
  
  private boolean ac = false;
  
  public CombinedChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public CombinedChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
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
    this.aa = new DrawOrder[] { DrawOrder.a, DrawOrder.b, DrawOrder.c, DrawOrder.d, DrawOrder.e };
    setHighlighter((ChartHighlighter)new CombinedHighlighter(this, (BarDataProvider)this));
    setHighlightFullBarEnabled(true);
    this.O = (DataRenderer)new CombinedChartRenderer(this, this.R, this.Q);
  }
  
  protected void c(Canvas paramCanvas) {
    if (this.V != null && C()) {
      if (!x())
        return; 
      for (int i = 0; i < this.S.length; i++) {
        Highlight highlight = this.S[i];
        IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet = this.C.b(highlight);
        Entry entry = this.C.a(highlight);
        if (entry != null && iBarLineScatterCandleBubbleDataSet.d(entry) <= iBarLineScatterCandleBubbleDataSet.H() * this.R.b()) {
          float[] arrayOfFloat = a(highlight);
          if (this.Q.b(arrayOfFloat[0], arrayOfFloat[1])) {
            this.V.a(entry, highlight);
            this.V.a(paramCanvas, arrayOfFloat[0], arrayOfFloat[1]);
          } 
        } 
      } 
    } 
  }
  
  public boolean c() {
    return this.ab;
  }
  
  public boolean d() {
    return this.ac;
  }
  
  public boolean e() {
    return this.a;
  }
  
  public BarData getBarData() {
    return (this.C == null) ? null : this.C.m();
  }
  
  public BubbleData getBubbleData() {
    return (this.C == null) ? null : this.C.a();
  }
  
  public CandleData getCandleData() {
    return (this.C == null) ? null : this.C.o();
  }
  
  public CombinedData getCombinedData() {
    return this.C;
  }
  
  public DrawOrder[] getDrawOrder() {
    return this.aa;
  }
  
  public LineData getLineData() {
    return (this.C == null) ? null : this.C.l();
  }
  
  public ScatterData getScatterData() {
    return (this.C == null) ? null : this.C.n();
  }
  
  public void setData(CombinedData paramCombinedData) {
    super.setData(paramCombinedData);
    setHighlighter((ChartHighlighter)new CombinedHighlighter(this, (BarDataProvider)this));
    ((CombinedChartRenderer)this.O).b();
    this.O.a();
  }
  
  public void setDrawBarShadow(boolean paramBoolean) {
    this.ac = paramBoolean;
  }
  
  public void setDrawOrder(DrawOrder[] paramArrayOfDrawOrder) {
    if (paramArrayOfDrawOrder != null) {
      if (paramArrayOfDrawOrder.length <= 0)
        return; 
      this.aa = paramArrayOfDrawOrder;
    } 
  }
  
  public void setDrawValueAboveBar(boolean paramBoolean) {
    this.ab = paramBoolean;
  }
  
  public void setHighlightFullBarEnabled(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public enum DrawOrder {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\CombinedChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */