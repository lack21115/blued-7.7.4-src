package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class RadarChartRenderer extends LineRadarRenderer {
  protected RadarChart a;
  
  protected Paint b;
  
  protected Paint c;
  
  protected Path d = new Path();
  
  protected Path e = new Path();
  
  public RadarChartRenderer(RadarChart paramRadarChart, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
    this.a = paramRadarChart;
    this.i = new Paint(1);
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(2.0F);
    this.i.setColor(Color.rgb(255, 187, 115));
    this.b = new Paint(1);
    this.b.setStyle(Paint.Style.STROKE);
    this.c = new Paint(1);
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas) {
    RadarData radarData = (RadarData)this.a.getData();
    int i = ((IRadarDataSet)radarData.k()).H();
    for (IRadarDataSet iRadarDataSet : radarData.i()) {
      if (iRadarDataSet.B())
        a(paramCanvas, iRadarDataSet, i); 
    } 
  }
  
  protected void a(Canvas paramCanvas, IRadarDataSet paramIRadarDataSet, int paramInt) {
    float f1 = this.g.b();
    float f2 = this.g.a();
    float f3 = this.a.getSliceAngle();
    float f4 = this.a.getFactor();
    MPPointF mPPointF1 = this.a.getCenterOffsets();
    MPPointF mPPointF2 = MPPointF.a(0.0F, 0.0F);
    Path path = this.d;
    path.reset();
    int i = 0;
    boolean bool = false;
    while (i < paramIRadarDataSet.H()) {
      this.h.setColor(paramIRadarDataSet.a(i));
      Utils.a(mPPointF1, (((RadarEntry)paramIRadarDataSet.e(i)).b() - this.a.getYChartMin()) * f4 * f2, i * f3 * f1 + this.a.getRotationAngle(), mPPointF2);
      if (!Float.isNaN(mPPointF2.a))
        if (!bool) {
          path.moveTo(mPPointF2.a, mPPointF2.b);
          bool = true;
        } else {
          path.lineTo(mPPointF2.a, mPPointF2.b);
        }  
      i++;
    } 
    if (paramIRadarDataSet.H() > paramInt)
      path.lineTo(mPPointF1.a, mPPointF1.b); 
    path.close();
    if (paramIRadarDataSet.S()) {
      Drawable drawable = paramIRadarDataSet.P();
      if (drawable != null) {
        a(paramCanvas, path, drawable);
      } else {
        a(paramCanvas, path, paramIRadarDataSet.O(), paramIRadarDataSet.Q());
      } 
    } 
    this.h.setStrokeWidth(paramIRadarDataSet.R());
    this.h.setStyle(Paint.Style.STROKE);
    if (!paramIRadarDataSet.S() || paramIRadarDataSet.Q() < 255)
      paramCanvas.drawPath(path, this.h); 
    MPPointF.b(mPPointF1);
    MPPointF.b(mPPointF2);
  }
  
  public void a(Canvas paramCanvas, MPPointF paramMPPointF, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3) {
    paramCanvas.save();
    paramFloat2 = Utils.a(paramFloat2);
    paramFloat1 = Utils.a(paramFloat1);
    if (paramInt1 != 1122867) {
      Path path = this.e;
      path.reset();
      path.addCircle(paramMPPointF.a, paramMPPointF.b, paramFloat2, Path.Direction.CW);
      if (paramFloat1 > 0.0F)
        path.addCircle(paramMPPointF.a, paramMPPointF.b, paramFloat1, Path.Direction.CCW); 
      this.c.setColor(paramInt1);
      this.c.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(path, this.c);
    } 
    if (paramInt2 != 1122867) {
      this.c.setColor(paramInt2);
      this.c.setStyle(Paint.Style.STROKE);
      this.c.setStrokeWidth(Utils.a(paramFloat3));
      paramCanvas.drawCircle(paramMPPointF.a, paramMPPointF.b, paramFloat2, this.c);
    } 
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    this.k.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.k);
  }
  
  public void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight) {
    float f1 = this.a.getSliceAngle();
    float f2 = this.a.getFactor();
    MPPointF mPPointF1 = this.a.getCenterOffsets();
    MPPointF mPPointF2 = MPPointF.a(0.0F, 0.0F);
    RadarData radarData = (RadarData)this.a.getData();
    int j = paramArrayOfHighlight.length;
    int i;
    for (i = 0; i < j; i++) {
      Highlight highlight = paramArrayOfHighlight[i];
      IRadarDataSet iRadarDataSet = (IRadarDataSet)radarData.a(highlight.f());
      if (iRadarDataSet != null && iRadarDataSet.p()) {
        RadarEntry radarEntry = (RadarEntry)iRadarDataSet.e((int)highlight.a());
        if (a((Entry)radarEntry, (IBarLineScatterCandleBubbleDataSet)iRadarDataSet)) {
          Utils.a(mPPointF1, (radarEntry.b() - this.a.getYChartMin()) * f2 * this.g.a(), highlight.a() * f1 * this.g.b() + this.a.getRotationAngle(), mPPointF2);
          highlight.a(mPPointF2.a, mPPointF2.b);
          a(paramCanvas, mPPointF2.a, mPPointF2.b, (ILineScatterCandleRadarDataSet)iRadarDataSet);
          if (iRadarDataSet.a() && !Float.isNaN(mPPointF2.a) && !Float.isNaN(mPPointF2.b)) {
            int m = iRadarDataSet.c();
            int k = m;
            if (m == 1122867)
              k = iRadarDataSet.a(0); 
            m = k;
            if (iRadarDataSet.d() < 255)
              m = ColorTemplate.a(k, iRadarDataSet.d()); 
            a(paramCanvas, mPPointF2, iRadarDataSet.e(), iRadarDataSet.f(), iRadarDataSet.b(), m, iRadarDataSet.g());
          } 
        } 
      } 
    } 
    MPPointF.b(mPPointF1);
    MPPointF.b(mPPointF2);
  }
  
  public void b(Canvas paramCanvas) {
    float f1 = this.g.b();
    float f2 = this.g.a();
    float f3 = this.a.getSliceAngle();
    float f4 = this.a.getFactor();
    MPPointF mPPointF1 = this.a.getCenterOffsets();
    MPPointF mPPointF2 = MPPointF.a(0.0F, 0.0F);
    MPPointF mPPointF3 = MPPointF.a(0.0F, 0.0F);
    float f5 = Utils.a(5.0F);
    int i;
    for (i = 0; i < ((RadarData)this.a.getData()).d(); i++) {
      IRadarDataSet iRadarDataSet = (IRadarDataSet)((RadarData)this.a.getData()).a(i);
      if (a((IDataSet)iRadarDataSet)) {
        b((IDataSet)iRadarDataSet);
        ValueFormatter valueFormatter = iRadarDataSet.q();
        MPPointF mPPointF = MPPointF.a(iRadarDataSet.A());
        mPPointF.a = Utils.a(mPPointF.a);
        mPPointF.b = Utils.a(mPPointF.b);
        int j;
        for (j = 0; j < iRadarDataSet.H(); j++) {
          RadarEntry radarEntry = (RadarEntry)iRadarDataSet.e(j);
          float f6 = radarEntry.b();
          float f7 = this.a.getYChartMin();
          float f8 = j * f3 * f1;
          Utils.a(mPPointF1, (f6 - f7) * f4 * f2, f8 + this.a.getRotationAngle(), mPPointF2);
          if (iRadarDataSet.y())
            a(paramCanvas, valueFormatter.a(radarEntry), mPPointF2.a, mPPointF2.b - f5, iRadarDataSet.d(j)); 
          if (radarEntry.g() != null && iRadarDataSet.z()) {
            Drawable drawable = radarEntry.g();
            Utils.a(mPPointF1, radarEntry.b() * f4 * f2 + mPPointF.b, f8 + this.a.getRotationAngle(), mPPointF3);
            mPPointF3.b += mPPointF.a;
            Utils.a(paramCanvas, drawable, (int)mPPointF3.a, (int)mPPointF3.b, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
          } 
        } 
        MPPointF.b(mPPointF);
      } 
    } 
    MPPointF.b(mPPointF1);
    MPPointF.b(mPPointF2);
    MPPointF.b(mPPointF3);
  }
  
  public void c(Canvas paramCanvas) {
    d(paramCanvas);
  }
  
  protected void d(Canvas paramCanvas) {
    float f1 = this.a.getSliceAngle();
    float f2 = this.a.getFactor();
    float f3 = this.a.getRotationAngle();
    MPPointF mPPointF1 = this.a.getCenterOffsets();
    this.b.setStrokeWidth(this.a.getWebLineWidth());
    this.b.setColor(this.a.getWebColor());
    this.b.setAlpha(this.a.getWebAlpha());
    int j = this.a.getSkipWebLineCount();
    int k = ((IRadarDataSet)((RadarData)this.a.getData()).k()).H();
    MPPointF mPPointF2 = MPPointF.a(0.0F, 0.0F);
    int i;
    for (i = 0; i < k; i += j + 1) {
      Utils.a(mPPointF1, this.a.getYRange() * f2, i * f1 + f3, mPPointF2);
      paramCanvas.drawLine(mPPointF1.a, mPPointF1.b, mPPointF2.a, mPPointF2.b, this.b);
    } 
    MPPointF.b(mPPointF2);
    this.b.setStrokeWidth(this.a.getWebLineWidthInner());
    this.b.setColor(this.a.getWebColorInner());
    this.b.setAlpha(this.a.getWebAlpha());
    k = (this.a.getYAxis()).d;
    mPPointF2 = MPPointF.a(0.0F, 0.0F);
    MPPointF mPPointF3 = MPPointF.a(0.0F, 0.0F);
    for (i = 0; i < k; i++) {
      j = 0;
      while (j < ((RadarData)this.a.getData()).j()) {
        float f = ((this.a.getYAxis()).b[i] - this.a.getYChartMin()) * f2;
        Utils.a(mPPointF1, f, j * f1 + f3, mPPointF2);
        Utils.a(mPPointF1, f, ++j * f1 + f3, mPPointF3);
        paramCanvas.drawLine(mPPointF2.a, mPPointF2.b, mPPointF3.a, mPPointF3.b, this.b);
      } 
    } 
    MPPointF.b(mPPointF2);
    MPPointF.b(mPPointF3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\RadarChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */