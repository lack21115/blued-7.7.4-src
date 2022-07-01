package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererHorizontalBarChart extends YAxisRenderer {
  protected Path r = new Path();
  
  protected Path s = new Path();
  
  protected float[] t = new float[4];
  
  public YAxisRendererHorizontalBarChart(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, Transformer paramTransformer) {
    super(paramViewPortHandler, paramYAxis, paramTransformer);
    this.f.setTextAlign(Paint.Align.LEFT);
  }
  
  protected Path a(Path paramPath, int paramInt, float[] paramArrayOffloat) {
    paramPath.moveTo(paramArrayOffloat[paramInt], this.o.e());
    paramPath.lineTo(paramArrayOffloat[paramInt], this.o.h());
    return paramPath;
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    if (this.o.j() > 10.0F) {
      f2 = paramFloat1;
      f1 = paramFloat2;
      if (!this.o.u()) {
        double d;
        MPPointD mPPointD1 = this.b.a(this.o.f(), this.o.e());
        MPPointD mPPointD2 = this.b.a(this.o.g(), this.o.e());
        if (!paramBoolean) {
          paramFloat1 = (float)mPPointD1.a;
          d = mPPointD2.a;
        } else {
          paramFloat1 = (float)mPPointD2.a;
          d = mPPointD1.a;
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
      float f1;
      if (!this.g.h())
        return; 
      float[] arrayOfFloat = c();
      this.d.setTypeface(this.g.w());
      this.d.setTextSize(this.g.x());
      this.d.setColor(this.g.y());
      this.d.setTextAlign(Paint.Align.CENTER);
      float f2 = Utils.a(2.5F);
      float f3 = Utils.b(this.d, "Q");
      YAxis.AxisDependency axisDependency = this.g.A();
      YAxis.YAxisLabelPosition yAxisLabelPosition = this.g.D();
      if (axisDependency == YAxis.AxisDependency.a) {
        if (yAxisLabelPosition == YAxis.YAxisLabelPosition.a) {
          f1 = this.o.e();
        } else {
          f1 = this.o.e();
        } 
        f1 -= f2;
      } else {
        if (yAxisLabelPosition == YAxis.YAxisLabelPosition.a) {
          f1 = this.o.h();
        } else {
          f1 = this.o.h();
        } 
        f1 = f1 + f3 + f2;
      } 
      a(paramCanvas, f1, arrayOfFloat, this.g.v());
    } 
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float[] paramArrayOffloat, float paramFloat2) {
    int i;
    this.d.setTypeface(this.g.w());
    this.d.setTextSize(this.g.x());
    this.d.setColor(this.g.y());
    int j = this.g.F() ^ true;
    if (this.g.E()) {
      i = this.g.d;
    } else {
      i = this.g.d - 1;
    } 
    while (j < i) {
      paramCanvas.drawText(this.g.b(j), paramArrayOffloat[j * 2], paramFloat1 - paramFloat2, this.d);
      j++;
    } 
  }
  
  public RectF b() {
    this.j.set(this.o.k());
    this.j.inset(-this.a.f(), 0.0F);
    return this.j;
  }
  
  public void b(Canvas paramCanvas) {
    if (this.g.z()) {
      if (!this.g.b())
        return; 
      this.e.setColor(this.g.g());
      this.e.setStrokeWidth(this.g.e());
      if (this.g.A() == YAxis.AxisDependency.a) {
        paramCanvas.drawLine(this.o.f(), this.o.e(), this.o.g(), this.o.e(), this.e);
        return;
      } 
      paramCanvas.drawLine(this.o.f(), this.o.h(), this.o.g(), this.o.h(), this.e);
    } 
  }
  
  protected float[] c() {
    if (this.k.length != this.g.d * 2)
      this.k = new float[this.g.d * 2]; 
    float[] arrayOfFloat = this.k;
    for (int i = 0; i < arrayOfFloat.length; i += 2)
      arrayOfFloat[i] = this.g.b[i / 2]; 
    this.b.a(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected void d(Canvas paramCanvas) {
    int i = paramCanvas.save();
    this.m.set(this.o.k());
    this.m.inset(-this.g.L(), 0.0F);
    paramCanvas.clipRect(this.q);
    MPPointD mPPointD = this.b.b(0.0F, 0.0F);
    this.h.setColor(this.g.K());
    this.h.setStrokeWidth(this.g.L());
    Path path = this.r;
    path.reset();
    path.moveTo((float)mPPointD.a - 1.0F, this.o.e());
    path.lineTo((float)mPPointD.a - 1.0F, this.o.h());
    paramCanvas.drawPath(path, this.h);
    paramCanvas.restoreToCount(i);
  }
  
  public void e(Canvas paramCanvas) {
    List<LimitLine> list = this.g.m();
    if (list != null) {
      if (list.size() <= 0)
        return; 
      float[] arrayOfFloat = this.t;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      arrayOfFloat[2] = 0.0F;
      arrayOfFloat[3] = 0.0F;
      Path path = this.s;
      path.reset();
      int i;
      for (i = 0; i < list.size(); i++) {
        LimitLine limitLine = list.get(i);
        if (limitLine.z()) {
          int j = paramCanvas.save();
          this.q.set(this.o.k());
          this.q.inset(-limitLine.b(), 0.0F);
          paramCanvas.clipRect(this.q);
          arrayOfFloat[0] = limitLine.a();
          arrayOfFloat[2] = limitLine.a();
          this.b.a(arrayOfFloat);
          arrayOfFloat[1] = this.o.e();
          arrayOfFloat[3] = this.o.h();
          path.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
          path.lineTo(arrayOfFloat[2], arrayOfFloat[3]);
          this.f.setStyle(Paint.Style.STROKE);
          this.f.setColor(limitLine.c());
          this.f.setPathEffect((PathEffect)limitLine.d());
          this.f.setStrokeWidth(limitLine.b());
          paramCanvas.drawPath(path, this.f);
          path.reset();
          String str = limitLine.g();
          if (str != null && !str.equals("")) {
            this.f.setStyle(limitLine.e());
            this.f.setPathEffect(null);
            this.f.setColor(limitLine.y());
            this.f.setTypeface(limitLine.w());
            this.f.setStrokeWidth(0.5F);
            this.f.setTextSize(limitLine.x());
            float f1 = limitLine.b() + limitLine.u();
            float f2 = Utils.a(2.0F) + limitLine.v();
            LimitLine.LimitLabelPosition limitLabelPosition = limitLine.f();
            if (limitLabelPosition == LimitLine.LimitLabelPosition.c) {
              float f = Utils.b(this.f, str);
              this.f.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, arrayOfFloat[0] + f1, this.o.e() + f2 + f, this.f);
            } else if (limitLabelPosition == LimitLine.LimitLabelPosition.d) {
              this.f.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, arrayOfFloat[0] + f1, this.o.h() - f2, this.f);
            } else if (limitLabelPosition == LimitLine.LimitLabelPosition.a) {
              this.f.setTextAlign(Paint.Align.RIGHT);
              float f = Utils.b(this.f, str);
              paramCanvas.drawText(str, arrayOfFloat[0] - f1, this.o.e() + f2 + f, this.f);
            } else {
              this.f.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, arrayOfFloat[0] - f1, this.o.h() - f2, this.f);
            } 
          } 
          paramCanvas.restoreToCount(j);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\YAxisRendererHorizontalBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */