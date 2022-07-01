package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PathEffect;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererRadarChart extends YAxisRenderer {
  private RadarChart r;
  
  private Path s = new Path();
  
  public YAxisRendererRadarChart(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, RadarChart paramRadarChart) {
    super(paramViewPortHandler, paramYAxis, (Transformer)null);
    this.r = paramRadarChart;
  }
  
  protected void a(float paramFloat1, float paramFloat2) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(Canvas paramCanvas) {
    if (this.g.z()) {
      int i;
      if (!this.g.h())
        return; 
      this.d.setTypeface(this.g.w());
      this.d.setTextSize(this.g.x());
      this.d.setColor(this.g.y());
      MPPointF mPPointF1 = this.r.getCenterOffsets();
      MPPointF mPPointF2 = MPPointF.a(0.0F, 0.0F);
      float f = this.r.getFactor();
      int j = this.g.F() ^ true;
      if (this.g.E()) {
        i = this.g.d;
      } else {
        i = this.g.d - 1;
      } 
      while (j < i) {
        Utils.a(mPPointF1, (this.g.b[j] - this.g.u) * f, this.r.getRotationAngle(), mPPointF2);
        paramCanvas.drawText(this.g.b(j), mPPointF2.a + 10.0F, mPPointF2.b, this.d);
        j++;
      } 
      MPPointF.b(mPPointF1);
      MPPointF.b(mPPointF2);
    } 
  }
  
  public void e(Canvas paramCanvas) {
    List<LimitLine> list = this.g.m();
    if (list == null)
      return; 
    float f1 = this.r.getSliceAngle();
    float f2 = this.r.getFactor();
    MPPointF mPPointF1 = this.r.getCenterOffsets();
    MPPointF mPPointF2 = MPPointF.a(0.0F, 0.0F);
    int i;
    for (i = 0; i < list.size(); i++) {
      LimitLine limitLine = list.get(i);
      if (limitLine.z()) {
        this.f.setColor(limitLine.c());
        this.f.setPathEffect((PathEffect)limitLine.d());
        this.f.setStrokeWidth(limitLine.b());
        float f3 = limitLine.a();
        float f4 = this.r.getYChartMin();
        Path path = this.s;
        path.reset();
        int j;
        for (j = 0; j < ((IRadarDataSet)((RadarData)this.r.getData()).k()).H(); j++) {
          Utils.a(mPPointF1, (f3 - f4) * f2, j * f1 + this.r.getRotationAngle(), mPPointF2);
          if (j == 0) {
            path.moveTo(mPPointF2.a, mPPointF2.b);
          } else {
            path.lineTo(mPPointF2.a, mPPointF2.b);
          } 
        } 
        path.close();
        paramCanvas.drawPath(path, this.f);
      } 
    } 
    MPPointF.b(mPPointF1);
    MPPointF.b(mPPointF2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\YAxisRendererRadarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */