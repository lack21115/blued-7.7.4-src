package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRenderer extends AxisRenderer {
  protected YAxis g;
  
  protected Paint h;
  
  protected Path i = new Path();
  
  protected RectF j = new RectF();
  
  protected float[] k = new float[2];
  
  protected Path l = new Path();
  
  protected RectF m = new RectF();
  
  protected Path n = new Path();
  
  protected float[] p = new float[2];
  
  protected RectF q = new RectF();
  
  public YAxisRenderer(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, Transformer paramTransformer) {
    super(paramViewPortHandler, paramTransformer, (AxisBase)paramYAxis);
    this.g = paramYAxis;
    if (this.o != null) {
      this.d.setColor(-16777216);
      this.d.setTextSize(Utils.a(10.0F));
      this.h = new Paint(1);
      this.h.setColor(-7829368);
      this.h.setStrokeWidth(1.0F);
      this.h.setStyle(Paint.Style.STROKE);
    } 
  }
  
  protected Path a(Path paramPath, int paramInt, float[] paramArrayOffloat) {
    float f = this.o.a();
    paramPath.moveTo(f, paramArrayOffloat[++paramInt]);
    paramPath.lineTo(this.o.g(), paramArrayOffloat[paramInt]);
    return paramPath;
  }
  
  public void a(Canvas paramCanvas) {
    float f1;
    float f2;
    if (this.g.z()) {
      if (!this.g.h())
        return; 
      float[] arrayOfFloat = c();
      this.d.setTypeface(this.g.w());
      this.d.setTextSize(this.g.x());
      this.d.setColor(this.g.y());
      f2 = this.g.u();
      float f3 = Utils.b(this.d, "A") / 2.5F;
      float f4 = this.g.v();
      YAxis.AxisDependency axisDependency = this.g.A();
      YAxis.YAxisLabelPosition yAxisLabelPosition = this.g.D();
      if (axisDependency == YAxis.AxisDependency.a) {
        if (yAxisLabelPosition == YAxis.YAxisLabelPosition.a) {
          this.d.setTextAlign(Paint.Align.RIGHT);
          f1 = this.o.a();
        } else {
          this.d.setTextAlign(Paint.Align.LEFT);
          f1 = this.o.a();
          f1 += f2;
        } 
      } else {
        if (yAxisLabelPosition == YAxis.YAxisLabelPosition.a) {
          this.d.setTextAlign(Paint.Align.LEFT);
          f1 = this.o.g();
        } else {
          this.d.setTextAlign(Paint.Align.RIGHT);
          f1 = this.o.g();
          f1 -= f2;
        } 
        f1 += f2;
      } 
    } else {
      return;
    } 
    f1 -= f2;
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float[] paramArrayOffloat, float paramFloat2) {
    int i;
    int j = this.g.F() ^ true;
    if (this.g.E()) {
      i = this.g.d;
    } else {
      i = this.g.d - 1;
    } 
    while (j < i) {
      paramCanvas.drawText(this.g.b(j), paramFloat1, paramArrayOffloat[j * 2 + 1] + paramFloat2, this.d);
      j++;
    } 
  }
  
  public RectF b() {
    this.j.set(this.o.k());
    this.j.inset(0.0F, -this.a.f());
    return this.j;
  }
  
  public void b(Canvas paramCanvas) {
    if (this.g.z()) {
      if (!this.g.b())
        return; 
      this.e.setColor(this.g.g());
      this.e.setStrokeWidth(this.g.e());
      if (this.g.A() == YAxis.AxisDependency.a) {
        paramCanvas.drawLine(this.o.f(), this.o.e(), this.o.f(), this.o.h(), this.e);
        return;
      } 
      paramCanvas.drawLine(this.o.g(), this.o.e(), this.o.g(), this.o.h(), this.e);
    } 
  }
  
  public void c(Canvas paramCanvas) {
    if (!this.g.z())
      return; 
    if (this.g.a()) {
      int j = paramCanvas.save();
      paramCanvas.clipRect(b());
      float[] arrayOfFloat = c();
      this.c.setColor(this.g.d());
      this.c.setStrokeWidth(this.g.f());
      this.c.setPathEffect((PathEffect)this.g.r());
      Path path = this.i;
      path.reset();
      for (int i = 0; i < arrayOfFloat.length; i += 2) {
        paramCanvas.drawPath(a(path, i, arrayOfFloat), this.c);
        path.reset();
      } 
      paramCanvas.restoreToCount(j);
    } 
    if (this.g.J())
      d(paramCanvas); 
  }
  
  protected float[] c() {
    if (this.k.length != this.g.d * 2)
      this.k = new float[this.g.d * 2]; 
    float[] arrayOfFloat = this.k;
    for (int i = 0; i < arrayOfFloat.length; i += 2)
      arrayOfFloat[i + 1] = this.g.b[i / 2]; 
    this.b.a(arrayOfFloat);
    return arrayOfFloat;
  }
  
  protected void d(Canvas paramCanvas) {
    int i = paramCanvas.save();
    this.m.set(this.o.k());
    this.m.inset(0.0F, -this.g.L());
    paramCanvas.clipRect(this.m);
    MPPointD mPPointD = this.b.b(0.0F, 0.0F);
    this.h.setColor(this.g.K());
    this.h.setStrokeWidth(this.g.L());
    Path path = this.l;
    path.reset();
    path.moveTo(this.o.f(), (float)mPPointD.b);
    path.lineTo(this.o.g(), (float)mPPointD.b);
    paramCanvas.drawPath(path, this.h);
    paramCanvas.restoreToCount(i);
  }
  
  public void e(Canvas paramCanvas) {
    List<LimitLine> list = this.g.m();
    if (list != null) {
      if (list.size() <= 0)
        return; 
      float[] arrayOfFloat = this.p;
      int i = 0;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      Path path = this.n;
      path.reset();
      while (i < list.size()) {
        LimitLine limitLine = list.get(i);
        if (limitLine.z()) {
          int j = paramCanvas.save();
          this.q.set(this.o.k());
          this.q.inset(0.0F, -limitLine.b());
          paramCanvas.clipRect(this.q);
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
            this.f.setTypeface(limitLine.w());
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\YAxisRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */