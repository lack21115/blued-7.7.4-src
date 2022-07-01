package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class XAxisRendererRadarChart extends XAxisRenderer {
  private RadarChart n;
  
  public XAxisRendererRadarChart(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, RadarChart paramRadarChart) {
    super(paramViewPortHandler, paramXAxis, (Transformer)null);
    this.n = paramRadarChart;
  }
  
  public void a(Canvas paramCanvas) {
    if (this.g.z()) {
      if (!this.g.h())
        return; 
      float f1 = this.g.B();
      MPPointF mPPointF1 = MPPointF.a(0.5F, 0.25F);
      this.d.setTypeface(this.g.w());
      this.d.setTextSize(this.g.x());
      this.d.setColor(this.g.y());
      float f2 = this.n.getSliceAngle();
      float f3 = this.n.getFactor();
      MPPointF mPPointF2 = this.n.getCenterOffsets();
      MPPointF mPPointF3 = MPPointF.a(0.0F, 0.0F);
      int i;
      for (i = 0; i < ((IRadarDataSet)((RadarData)this.n.getData()).k()).H(); i++) {
        ValueFormatter valueFormatter = this.g.q();
        float f4 = i;
        String str = valueFormatter.a(f4, (AxisBase)this.g);
        float f5 = this.n.getRotationAngle();
        Utils.a(mPPointF2, this.n.getYRange() * f3 + this.g.E / 2.0F, (f4 * f2 + f5) % 360.0F, mPPointF3);
        a(paramCanvas, str, mPPointF3.a, mPPointF3.b - this.g.F / 2.0F, mPPointF1, f1);
      } 
      MPPointF.b(mPPointF2);
      MPPointF.b(mPPointF3);
      MPPointF.b(mPPointF1);
    } 
  }
  
  public void d(Canvas paramCanvas) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\XAxisRendererRadarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */