package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRendererHorizontalBarChart extends XAxisRenderer {
  protected BarChart n;
  
  protected Path p = new Path();
  
  public XAxisRendererHorizontalBarChart(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, Transformer paramTransformer, BarChart paramBarChart) {
    super(paramViewPortHandler, paramXAxis, paramTransformer);
    this.n = paramBarChart;
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    if (this.o.i() > 10.0F) {
      f2 = paramFloat1;
      f1 = paramFloat2;
      if (!this.o.t()) {
        double d;
        MPPointD mPPointD1 = this.b.a(this.o.f(), this.o.h());
        MPPointD mPPointD2 = this.b.a(this.o.f(), this.o.e());
        if (paramBoolean) {
          paramFloat1 = (float)mPPointD2.b;
          d = mPPointD1.b;
        } else {
          paramFloat1 = (float)mPPointD1.b;
          d = mPPointD2.b;
        } 
        f1 = (float)d;
        MPPointD.a(mPPointD1);
        MPPointD.a(mPPointD2);
        f2 = paramFloat1;
      } 
    } 
    a(f2, f1);
  }
  
  public void a(Canvas paramCanvas) {
    if (this.g.z()) {
      if (!this.g.h())
        return; 
      float f = this.g.u();
      this.d.setTypeface(this.g.w());
      this.d.setTextSize(this.g.x());
      this.d.setColor(this.g.y());
      MPPointF mPPointF = MPPointF.a(0.0F, 0.0F);
      if (this.g.A() == XAxis.XAxisPosition.a) {
        mPPointF.a = 0.0F;
        mPPointF.b = 0.5F;
        a(paramCanvas, this.o.g() + f, mPPointF);
      } else if (this.g.A() == XAxis.XAxisPosition.d) {
        mPPointF.a = 1.0F;
        mPPointF.b = 0.5F;
        a(paramCanvas, this.o.g() - f, mPPointF);
      } else if (this.g.A() == XAxis.XAxisPosition.b) {
        mPPointF.a = 1.0F;
        mPPointF.b = 0.5F;
        a(paramCanvas, this.o.f() - f, mPPointF);
      } else if (this.g.A() == XAxis.XAxisPosition.e) {
        mPPointF.a = 1.0F;
        mPPointF.b = 0.5F;
        a(paramCanvas, this.o.f() + f, mPPointF);
      } else {
        mPPointF.a = 0.0F;
        mPPointF.b = 0.5F;
        a(paramCanvas, this.o.g() + f, mPPointF);
        mPPointF.a = 1.0F;
        mPPointF.b = 0.5F;
        a(paramCanvas, this.o.f() - f, mPPointF);
      } 
      MPPointF.b(mPPointF);
    } 
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Path paramPath) {
    paramPath.moveTo(this.o.g(), paramFloat2);
    paramPath.lineTo(this.o.f(), paramFloat2);
    paramCanvas.drawPath(paramPath, this.c);
    paramPath.reset();
  }
  
  protected void a(Canvas paramCanvas, float paramFloat, MPPointF paramMPPointF) {
    float f = this.g.B();
    boolean bool = this.g.c();
    float[] arrayOfFloat = new float[this.g.d * 2];
    int i;
    for (i = 0; i < arrayOfFloat.length; i += 2) {
      if (bool) {
        arrayOfFloat[i + 1] = this.g.c[i / 2];
      } else {
        arrayOfFloat[i + 1] = this.g.b[i / 2];
      } 
    } 
    this.b.a(arrayOfFloat);
    for (i = 0; i < arrayOfFloat.length; i += 2) {
      float f1 = arrayOfFloat[i + 1];
      if (this.o.f(f1))
        a(paramCanvas, this.g.q().a(this.g.b[i / 2], (AxisBase)this.g), paramFloat, f1, paramMPPointF, f); 
    } 
  }
  
  public void b(Canvas paramCanvas) {
    if (this.g.b()) {
      if (!this.g.z())
        return; 
      this.e.setColor(this.g.g());
      this.e.setStrokeWidth(this.g.e());
      if (this.g.A() == XAxis.XAxisPosition.a || this.g.A() == XAxis.XAxisPosition.d || this.g.A() == XAxis.XAxisPosition.c)
        paramCanvas.drawLine(this.o.g(), this.o.e(), this.o.g(), this.o.h(), this.e); 
      if (this.g.A() == XAxis.XAxisPosition.b || this.g.A() == XAxis.XAxisPosition.e || this.g.A() == XAxis.XAxisPosition.c)
        paramCanvas.drawLine(this.o.f(), this.o.e(), this.o.f(), this.o.h(), this.e); 
    } 
  }
  
  protected void c() {
    this.d.setTypeface(this.g.w());
    this.d.setTextSize(this.g.x());
    String str = this.g.p();
    FSize fSize = Utils.c(this.d, str);
    float f1 = (int)(fSize.a + this.g.u() * 3.5F);
    float f2 = fSize.b;
    fSize = Utils.a(fSize.a, f2, this.g.B());
    this.g.C = Math.round(f1);
    this.g.D = Math.round(f2);
    this.g.E = (int)(fSize.a + this.g.u() * 3.5F);
    this.g.F = Math.round(fSize.b);
    FSize.a(fSize);
  }
  
  public RectF d() {
    this.j.set(this.o.k());
    this.j.inset(0.0F, -this.a.f());
    return this.j;
  }
  
  public void d(Canvas paramCanvas) {
    List<LimitLine> list = this.g.m();
    if (list != null) {
      if (list.size() <= 0)
        return; 
      float[] arrayOfFloat = this.k;
      int i = 0;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      Path path = this.p;
      path.reset();
      while (i < list.size()) {
        LimitLine limitLine = list.get(i);
        if (limitLine.z()) {
          int j = paramCanvas.save();
          this.l.set(this.o.k());
          this.l.inset(0.0F, -limitLine.b());
          paramCanvas.clipRect(this.l);
          this.f.setStyle(Paint.Style.STROKE);
          this.f.setColor(limitLine.c());
          this.f.setStrokeWidth(limitLine.b());
          this.f.setPathEffect((PathEffect)limitLine.d());
          arrayOfFloat[1] = limitLine.a();
          this.b.a(arrayOfFloat);
          path.moveTo(this.o.f(), arrayOfFloat[1]);
          path.lineTo(this.o.g(), arrayOfFloat[1]);
          paramCanvas.drawPath(path, this.f);
          path.reset();
          String str = limitLine.g();
          if (str != null && !str.equals("")) {
            this.f.setStyle(limitLine.e());
            this.f.setPathEffect(null);
            this.f.setColor(limitLine.y());
            this.f.setStrokeWidth(0.5F);
            this.f.setTextSize(limitLine.x());
            float f1 = Utils.b(this.f, str);
            float f2 = Utils.a(4.0F) + limitLine.u();
            float f3 = limitLine.b() + f1 + limitLine.v();
            LimitLine.LimitLabelPosition limitLabelPosition = limitLine.f();
            if (limitLabelPosition == LimitLine.LimitLabelPosition.c) {
              this.f.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, this.o.g() - f2, arrayOfFloat[1] - f3 + f1, this.f);
            } else if (limitLabelPosition == LimitLine.LimitLabelPosition.d) {
              this.f.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, this.o.g() - f2, arrayOfFloat[1] + f3, this.f);
            } else if (limitLabelPosition == LimitLine.LimitLabelPosition.a) {
              this.f.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, this.o.f() + f2, arrayOfFloat[1] - f3 + f1, this.f);
            } else {
              this.f.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, this.o.a() + f2, arrayOfFloat[1] + f3, this.f);
            } 
          } 
          paramCanvas.restoreToCount(j);
        } 
        i++;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\XAxisRendererHorizontalBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */