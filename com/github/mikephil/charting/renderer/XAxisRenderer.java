package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRenderer extends AxisRenderer {
  protected XAxis g;
  
  protected Path h = new Path();
  
  protected float[] i = new float[2];
  
  protected RectF j = new RectF();
  
  protected float[] k = new float[2];
  
  protected RectF l = new RectF();
  
  float[] m = new float[4];
  
  private Path n = new Path();
  
  public XAxisRenderer(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, Transformer paramTransformer) {
    super(paramViewPortHandler, paramTransformer, (AxisBase)paramXAxis);
    this.g = paramXAxis;
    this.d.setColor(-16777216);
    this.d.setTextAlign(Paint.Align.CENTER);
    this.d.setTextSize(Utils.a(10.0F));
  }
  
  protected void a(float paramFloat1, float paramFloat2) {
    super.a(paramFloat1, paramFloat2);
    c();
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    if (this.o.i() > 10.0F) {
      f2 = paramFloat1;
      f1 = paramFloat2;
      if (!this.o.u()) {
        double d;
        MPPointD mPPointD1 = this.b.a(this.o.f(), this.o.e());
        MPPointD mPPointD2 = this.b.a(this.o.g(), this.o.e());
        if (paramBoolean) {
          paramFloat1 = (float)mPPointD2.a;
          d = mPPointD1.a;
        } else {
          paramFloat1 = (float)mPPointD1.a;
          d = mPPointD2.a;
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
      float f = this.g.v();
      this.d.setTypeface(this.g.w());
      this.d.setTextSize(this.g.x());
      this.d.setColor(this.g.y());
      MPPointF mPPointF = MPPointF.a(0.0F, 0.0F);
      if (this.g.A() == XAxis.XAxisPosition.a) {
        mPPointF.a = 0.5F;
        mPPointF.b = 1.0F;
        a(paramCanvas, this.o.e() - f, mPPointF);
      } else if (this.g.A() == XAxis.XAxisPosition.d) {
        mPPointF.a = 0.5F;
        mPPointF.b = 1.0F;
        a(paramCanvas, this.o.e() + f + this.g.F, mPPointF);
      } else if (this.g.A() == XAxis.XAxisPosition.b) {
        mPPointF.a = 0.5F;
        mPPointF.b = 0.0F;
        a(paramCanvas, this.o.h() + f, mPPointF);
      } else if (this.g.A() == XAxis.XAxisPosition.e) {
        mPPointF.a = 0.5F;
        mPPointF.b = 0.0F;
        a(paramCanvas, this.o.h() - f - this.g.F, mPPointF);
      } else {
        mPPointF.a = 0.5F;
        mPPointF.b = 1.0F;
        a(paramCanvas, this.o.e() - f, mPPointF);
        mPPointF.a = 0.5F;
        mPPointF.b = 0.0F;
        a(paramCanvas, this.o.h() + f, mPPointF);
      } 
      MPPointF.b(mPPointF);
    } 
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Path paramPath) {
    paramPath.moveTo(paramFloat1, this.o.h());
    paramPath.lineTo(paramFloat1, this.o.e());
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
        arrayOfFloat[i] = this.g.c[i / 2];
      } else {
        arrayOfFloat[i] = this.g.b[i / 2];
      } 
    } 
    this.b.a(arrayOfFloat);
    for (i = 0; i < arrayOfFloat.length; i += 2) {
      float f1 = arrayOfFloat[i];
      if (this.o.e(f1)) {
        ValueFormatter valueFormatter = this.g.q();
        float[] arrayOfFloat1 = this.g.b;
        int j = i / 2;
        String str = valueFormatter.a(arrayOfFloat1[j], (AxisBase)this.g);
        float f2 = f1;
        if (this.g.C())
          if (j == this.g.d - 1 && this.g.d > 1) {
            float f3 = Utils.a(this.d, str);
            f2 = f1;
            if (f3 > this.o.b() * 2.0F) {
              f2 = f1;
              if (f1 + f3 > this.o.n())
                f2 = f1 - f3 / 2.0F; 
            } 
          } else {
            f2 = f1;
            if (i == 0)
              f2 = f1 + Utils.a(this.d, str) / 2.0F; 
          }  
        a(paramCanvas, str, f2, paramFloat, paramMPPointF, f);
      } 
    } 
  }
  
  public void a(Canvas paramCanvas, LimitLine paramLimitLine, float[] paramArrayOffloat) {
    float[] arrayOfFloat = this.m;
    arrayOfFloat[0] = paramArrayOffloat[0];
    arrayOfFloat[1] = this.o.e();
    arrayOfFloat = this.m;
    arrayOfFloat[2] = paramArrayOffloat[0];
    arrayOfFloat[3] = this.o.h();
    this.n.reset();
    Path path = this.n;
    arrayOfFloat = this.m;
    path.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    path = this.n;
    arrayOfFloat = this.m;
    path.lineTo(arrayOfFloat[2], arrayOfFloat[3]);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setColor(paramLimitLine.c());
    this.f.setStrokeWidth(paramLimitLine.b());
    this.f.setPathEffect((PathEffect)paramLimitLine.d());
    paramCanvas.drawPath(this.n, this.f);
  }
  
  public void a(Canvas paramCanvas, LimitLine paramLimitLine, float[] paramArrayOffloat, float paramFloat) {
    String str = paramLimitLine.g();
    if (str != null && !str.equals("")) {
      this.f.setStyle(paramLimitLine.e());
      this.f.setPathEffect(null);
      this.f.setColor(paramLimitLine.y());
      this.f.setStrokeWidth(0.5F);
      this.f.setTextSize(paramLimitLine.x());
      float f = paramLimitLine.b() + paramLimitLine.u();
      LimitLine.LimitLabelPosition limitLabelPosition = paramLimitLine.f();
      if (limitLabelPosition == LimitLine.LimitLabelPosition.c) {
        float f1 = Utils.b(this.f, str);
        this.f.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(str, paramArrayOffloat[0] + f, this.o.e() + paramFloat + f1, this.f);
        return;
      } 
      if (limitLabelPosition == LimitLine.LimitLabelPosition.d) {
        this.f.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(str, paramArrayOffloat[0] + f, this.o.h() - paramFloat, this.f);
        return;
      } 
      if (limitLabelPosition == LimitLine.LimitLabelPosition.a) {
        this.f.setTextAlign(Paint.Align.RIGHT);
        float f1 = Utils.b(this.f, str);
        paramCanvas.drawText(str, paramArrayOffloat[0] - f, this.o.e() + paramFloat + f1, this.f);
        return;
      } 
      this.f.setTextAlign(Paint.Align.RIGHT);
      paramCanvas.drawText(str, paramArrayOffloat[0] - f, this.o.h() - paramFloat, this.f);
    } 
  }
  
  protected void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, MPPointF paramMPPointF, float paramFloat3) {
    Utils.a(paramCanvas, paramString, paramFloat1, paramFloat2, this.d, paramMPPointF, paramFloat3);
  }
  
  protected void b() {
    this.c.setColor(this.g.d());
    this.c.setStrokeWidth(this.g.f());
    this.c.setPathEffect((PathEffect)this.g.r());
  }
  
  public void b(Canvas paramCanvas) {
    if (this.g.b()) {
      if (!this.g.z())
        return; 
      this.e.setColor(this.g.g());
      this.e.setStrokeWidth(this.g.e());
      this.e.setPathEffect((PathEffect)this.g.s());
      if (this.g.A() == XAxis.XAxisPosition.a || this.g.A() == XAxis.XAxisPosition.d || this.g.A() == XAxis.XAxisPosition.c)
        paramCanvas.drawLine(this.o.f(), this.o.e(), this.o.g(), this.o.e(), this.e); 
      if (this.g.A() == XAxis.XAxisPosition.b || this.g.A() == XAxis.XAxisPosition.e || this.g.A() == XAxis.XAxisPosition.c)
        paramCanvas.drawLine(this.o.f(), this.o.h(), this.o.g(), this.o.h(), this.e); 
    } 
  }
  
  protected void c() {
    String str = this.g.p();
    this.d.setTypeface(this.g.w());
    this.d.setTextSize(this.g.x());
    FSize fSize1 = Utils.c(this.d, str);
    float f1 = fSize1.a;
    float f2 = Utils.b(this.d, "Q");
    FSize fSize2 = Utils.a(f1, f2, this.g.B());
    this.g.C = Math.round(f1);
    this.g.D = Math.round(f2);
    this.g.E = Math.round(fSize2.a);
    this.g.F = Math.round(fSize2.b);
    FSize.a(fSize2);
    FSize.a(fSize1);
  }
  
  public void c(Canvas paramCanvas) {
    if (this.g.a()) {
      if (!this.g.z())
        return; 
      int j = paramCanvas.save();
      paramCanvas.clipRect(d());
      if (this.i.length != this.a.d * 2)
        this.i = new float[this.g.d * 2]; 
      float[] arrayOfFloat = this.i;
      boolean bool = false;
      int i;
      for (i = 0; i < arrayOfFloat.length; i += 2) {
        float[] arrayOfFloat1 = this.g.b;
        int k = i / 2;
        arrayOfFloat[i] = arrayOfFloat1[k];
        arrayOfFloat[i + 1] = this.g.b[k];
      } 
      this.b.a(arrayOfFloat);
      b();
      Path path = this.h;
      path.reset();
      for (i = bool; i < arrayOfFloat.length; i += 2)
        a(paramCanvas, arrayOfFloat[i], arrayOfFloat[i + 1], path); 
      paramCanvas.restoreToCount(j);
    } 
  }
  
  public RectF d() {
    this.j.set(this.o.k());
    this.j.inset(-this.a.f(), 0.0F);
    return this.j;
  }
  
  public void d(Canvas paramCanvas) {
    List<LimitLine> list = this.g.m();
    if (list != null) {
      if (list.size() <= 0)
        return; 
      float[] arrayOfFloat = this.k;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      for (int i = 0; i < list.size(); i++) {
        LimitLine limitLine = list.get(i);
        if (limitLine.z()) {
          int j = paramCanvas.save();
          this.l.set(this.o.k());
          this.l.inset(-limitLine.b(), 0.0F);
          paramCanvas.clipRect(this.l);
          arrayOfFloat[0] = limitLine.a();
          arrayOfFloat[1] = 0.0F;
          this.b.a(arrayOfFloat);
          a(paramCanvas, limitLine, arrayOfFloat);
          a(paramCanvas, limitLine, arrayOfFloat, limitLine.v() + 2.0F);
          paramCanvas.restoreToCount(j);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\XAxisRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */