package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.highlight.RadarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;

public class RadarChart extends PieRadarChartBase<RadarData> {
  protected YAxisRendererRadarChart a;
  
  protected XAxisRendererRadarChart b;
  
  private float e = 2.5F;
  
  private float f = 1.5F;
  
  private int g = Color.rgb(122, 122, 122);
  
  private int h = Color.rgb(122, 122, 122);
  
  private int i = 150;
  
  private boolean j = true;
  
  private int k = 0;
  
  private YAxis l;
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a(float paramFloat) {
    paramFloat = Utils.c(paramFloat - getRotationAngle());
    float f = getSliceAngle();
    int j = ((IRadarDataSet)this.C.k()).H();
    for (int i = 0; i < j; i = k) {
      int k = i + 1;
      if (k * f - f / 2.0F > paramFloat)
        return i; 
    } 
    return 0;
  }
  
  protected void a() {
    super.a();
    this.l = new YAxis(YAxis.AxisDependency.a);
    this.e = Utils.a(1.5F);
    this.f = Utils.a(0.75F);
    this.O = (DataRenderer)new RadarChartRenderer(this, this.R, this.Q);
    this.a = new YAxisRendererRadarChart(this.Q, this.l, this);
    this.b = new XAxisRendererRadarChart(this.Q, this.H, this);
    this.P = (IHighlighter)new RadarHighlighter(this);
  }
  
  protected void b() {
    super.b();
    this.l.a(this.C.a(YAxis.AxisDependency.a), this.C.b(YAxis.AxisDependency.a));
    this.H.a(0.0F, ((IRadarDataSet)this.C.k()).H());
  }
  
  public float getFactor() {
    RectF rectF = this.Q.k();
    return Math.min(rectF.width() / 2.0F, rectF.height() / 2.0F) / this.l.v;
  }
  
  public float getRadius() {
    RectF rectF = this.Q.k();
    return Math.min(rectF.width() / 2.0F, rectF.height() / 2.0F);
  }
  
  protected float getRequiredBaseOffset() {
    return (this.H.z() && this.H.h()) ? this.H.E : Utils.a(10.0F);
  }
  
  protected float getRequiredLegendOffset() {
    return this.N.a().getTextSize() * 4.0F;
  }
  
  public int getSkipWebLineCount() {
    return this.k;
  }
  
  public float getSliceAngle() {
    return 360.0F / ((IRadarDataSet)this.C.k()).H();
  }
  
  public int getWebAlpha() {
    return this.i;
  }
  
  public int getWebColor() {
    return this.g;
  }
  
  public int getWebColorInner() {
    return this.h;
  }
  
  public float getWebLineWidth() {
    return this.e;
  }
  
  public float getWebLineWidthInner() {
    return this.f;
  }
  
  public YAxis getYAxis() {
    return this.l;
  }
  
  public float getYChartMax() {
    return this.l.t;
  }
  
  public float getYChartMin() {
    return this.l.u;
  }
  
  public float getYRange() {
    return this.l.v;
  }
  
  public void h() {
    if (this.C == null)
      return; 
    b();
    this.a.a(this.l.u, this.l.t, this.l.G());
    this.b.a(this.H.u, this.H.t, false);
    if (this.K != null && !this.K.c())
      this.N.a((ChartData)this.C); 
    j();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.C == null)
      return; 
    if (this.H.z())
      this.b.a(this.H.u, this.H.t, false); 
    this.b.a(paramCanvas);
    if (this.j)
      this.O.c(paramCanvas); 
    if (this.l.z() && this.l.n())
      this.a.e(paramCanvas); 
    this.O.a(paramCanvas);
    if (x())
      this.O.a(paramCanvas, this.S); 
    if (this.l.z() && !this.l.n())
      this.a.e(paramCanvas); 
    this.a.a(paramCanvas);
    this.O.b(paramCanvas);
    this.N.a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
  }
  
  public void setDrawWeb(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public void setSkipWebLineCount(int paramInt) {
    this.k = Math.max(0, paramInt);
  }
  
  public void setWebAlpha(int paramInt) {
    this.i = paramInt;
  }
  
  public void setWebColor(int paramInt) {
    this.g = paramInt;
  }
  
  public void setWebColorInner(int paramInt) {
    this.h = paramInt;
  }
  
  public void setWebLineWidth(float paramFloat) {
    this.e = Utils.a(paramFloat);
  }
  
  public void setWebLineWidthInner(float paramFloat) {
    this.f = Utils.a(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\charts\RadarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */