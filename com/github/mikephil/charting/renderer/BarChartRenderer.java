package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
  protected BarDataProvider a;
  
  protected RectF b = new RectF();
  
  protected BarBuffer[] c;
  
  protected Paint d;
  
  protected Paint e;
  
  private RectF l = new RectF();
  
  public BarChartRenderer(BarDataProvider paramBarDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
    this.a = paramBarDataProvider;
    this.i = new Paint(1);
    this.i.setStyle(Paint.Style.FILL);
    this.i.setColor(Color.rgb(0, 0, 0));
    this.i.setAlpha(120);
    this.d = new Paint(1);
    this.d.setStyle(Paint.Style.FILL);
    this.e = new Paint(1);
    this.e.setStyle(Paint.Style.STROKE);
  }
  
  public void a() {
    BarData barData = this.a.getBarData();
    this.c = new BarBuffer[barData.d()];
    for (int i = 0; i < this.c.length; i++) {
      byte b;
      IBarDataSet iBarDataSet = (IBarDataSet)barData.a(i);
      BarBuffer[] arrayOfBarBuffer = this.c;
      int j = iBarDataSet.H();
      if (iBarDataSet.b()) {
        b = iBarDataSet.a();
      } else {
        b = 1;
      } 
      arrayOfBarBuffer[i] = new BarBuffer(j * 4 * b, barData.d(), iBarDataSet.b());
    } 
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer) {
    this.b.set(paramFloat1 - paramFloat4, paramFloat2, paramFloat1 + paramFloat4, paramFloat3);
    paramTransformer.a(this.b, this.g.a());
  }
  
  public void a(Canvas paramCanvas) {
    BarData barData = this.a.getBarData();
    for (int i = 0; i < barData.d(); i++) {
      IBarDataSet iBarDataSet = (IBarDataSet)barData.a(i);
      if (iBarDataSet.B())
        a(paramCanvas, iBarDataSet, i); 
    } 
  }
  
  protected void a(Canvas paramCanvas, IBarDataSet paramIBarDataSet, int paramInt) {
    boolean bool;
    Transformer transformer = this.a.a(paramIBarDataSet.C());
    this.e.setColor(paramIBarDataSet.e());
    this.e.setStrokeWidth(Utils.a(paramIBarDataSet.d()));
    float f1 = paramIBarDataSet.d();
    int j = 0;
    int k = 1;
    if (f1 > 0.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    f1 = this.g.b();
    float f2 = this.g.a();
    if (this.a.d()) {
      this.d.setColor(paramIBarDataSet.c());
      float f = this.a.getBarData().a() / 2.0F;
      int n = Math.min((int)Math.ceil((paramIBarDataSet.H() * f1)), paramIBarDataSet.H());
      int m;
      for (m = 0; m < n; m++) {
        float f3 = ((BarEntry)paramIBarDataSet.e(m)).i();
        RectF rectF = this.l;
        rectF.left = f3 - f;
        rectF.right = f3 + f;
        transformer.a(rectF);
        if (this.o.g(this.l.right)) {
          if (!this.o.h(this.l.left))
            break; 
          this.l.top = this.o.e();
          this.l.bottom = this.o.h();
          paramCanvas.drawRect(this.l, this.d);
        } 
      } 
    } 
    BarBuffer barBuffer = this.c[paramInt];
    barBuffer.a(f1, f2);
    barBuffer.a(paramInt);
    barBuffer.a(this.a.c(paramIBarDataSet.C()));
    barBuffer.a(this.a.getBarData().a());
    barBuffer.a(paramIBarDataSet);
    transformer.a(barBuffer.b);
    if (paramIBarDataSet.j().size() == 1) {
      paramInt = k;
    } else {
      paramInt = 0;
    } 
    int i = j;
    if (paramInt != 0) {
      this.h.setColor(paramIBarDataSet.k());
      i = j;
    } 
    while (i < barBuffer.b()) {
      ViewPortHandler viewPortHandler = this.o;
      float[] arrayOfFloat = barBuffer.b;
      j = i + 2;
      if (viewPortHandler.g(arrayOfFloat[j])) {
        if (!this.o.h(barBuffer.b[i]))
          return; 
        if (paramInt == 0)
          this.h.setColor(paramIBarDataSet.a(i / 4)); 
        if (paramIBarDataSet.l() != null) {
          GradientColor gradientColor = paramIBarDataSet.l();
          this.h.setShader((Shader)new LinearGradient(barBuffer.b[i], barBuffer.b[i + 3], barBuffer.b[i], barBuffer.b[i + 1], gradientColor.a(), gradientColor.b(), Shader.TileMode.MIRROR));
        } 
        if (paramIBarDataSet.m() != null) {
          Paint paint = this.h;
          f1 = barBuffer.b[i];
          f2 = barBuffer.b[i + 3];
          float f3 = barBuffer.b[i];
          float f4 = barBuffer.b[i + 1];
          k = i / 4;
          paint.setShader((Shader)new LinearGradient(f1, f2, f3, f4, paramIBarDataSet.b(k).a(), paramIBarDataSet.b(k).b(), Shader.TileMode.MIRROR));
        } 
        f1 = barBuffer.b[i];
        float[] arrayOfFloat1 = barBuffer.b;
        k = i + 1;
        f2 = arrayOfFloat1[k];
        float f = barBuffer.b[j];
        arrayOfFloat1 = barBuffer.b;
        int m = i + 3;
        paramCanvas.drawRect(f1, f2, f, arrayOfFloat1[m], this.h);
        if (bool)
          paramCanvas.drawRect(barBuffer.b[i], barBuffer.b[k], barBuffer.b[j], barBuffer.b[m], this.e); 
      } 
      i += 4;
    } 
  }
  
  public void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    this.k.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.k);
  }
  
  public void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight) {
    BarData barData = this.a.getBarData();
    int j = paramArrayOfHighlight.length;
    int i;
    for (i = 0; i < j; i++) {
      Highlight highlight = paramArrayOfHighlight[i];
      IBarDataSet iBarDataSet = (IBarDataSet)barData.a(highlight.f());
      if (iBarDataSet != null && iBarDataSet.p()) {
        BarEntry barEntry = (BarEntry)iBarDataSet.b(highlight.a(), highlight.b());
        if (a((Entry)barEntry, (IBarLineScatterCandleBubbleDataSet)iBarDataSet)) {
          float f1;
          float f2;
          boolean bool;
          Transformer transformer = this.a.a(iBarDataSet.C());
          this.i.setColor(iBarDataSet.h());
          this.i.setAlpha(iBarDataSet.f());
          if (highlight.g() >= 0 && barEntry.d()) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool) {
            if (this.a.e()) {
              f1 = barEntry.e();
              f2 = -barEntry.f();
            } else {
              Range range = barEntry.c()[highlight.g()];
              f1 = range.a;
              f2 = range.b;
            } 
          } else {
            f1 = barEntry.b();
            f2 = 0.0F;
          } 
          a(barEntry.i(), f1, f2, barData.a() / 2.0F, transformer);
          a(highlight, this.b);
          paramCanvas.drawRect(this.b, this.i);
        } 
      } 
    } 
  }
  
  protected void a(Highlight paramHighlight, RectF paramRectF) {
    paramHighlight.a(paramRectF.centerX(), paramRectF.top);
  }
  
  public void b(Canvas paramCanvas) {
    if (a((ChartInterface)this.a)) {
      List<IBarDataSet> list = this.a.getBarData().i();
      float f = Utils.a(4.5F);
      boolean bool = this.a.c();
      int i = 0;
      while (i < this.a.getBarData().d()) {
        Object object1;
        MPPointF mPPointF2;
        IBarDataSet iBarDataSet = list.get(i);
        if (!a((IDataSet)iBarDataSet)) {
          float f1 = f;
          List<IBarDataSet> list1 = list;
        } else {
          float f3;
          Object object;
          float f4;
          MPPointF mPPointF3;
          MPPointF mPPointF5;
          b((IDataSet)iBarDataSet);
          boolean bool1 = this.a.c(iBarDataSet.C());
          float f5 = Utils.b(this.k, "8");
          if (bool) {
            f3 = -f;
          } else {
            f3 = f5 + f;
          } 
          if (bool) {
            f4 = f5 + f;
          } else {
            f4 = -f;
          } 
          float f2 = f3;
          float f1 = f4;
          if (bool1) {
            f2 = -f3 - f5;
            f1 = -f4 - f5;
          } 
          BarBuffer barBuffer = this.c[i];
          float f6 = this.g.a();
          ValueFormatter valueFormatter = iBarDataSet.q();
          MPPointF mPPointF4 = MPPointF.a(iBarDataSet.A());
          mPPointF4.a = Utils.a(mPPointF4.a);
          mPPointF4.b = Utils.a(mPPointF4.b);
          if (!iBarDataSet.b()) {
            int j = 0;
            List<IBarDataSet> list1 = list;
            ValueFormatter valueFormatter1 = valueFormatter;
            mPPointF3 = mPPointF4;
            while (j < barBuffer.b.length * this.g.b()) {
              f4 = (barBuffer.b[j] + barBuffer.b[j + 2]) / 2.0F;
              if (!this.o.h(f4))
                break; 
              ViewPortHandler viewPortHandler = this.o;
              float[] arrayOfFloat = barBuffer.b;
              int k = j + 1;
              if (viewPortHandler.f(arrayOfFloat[k]) && this.o.g(f4)) {
                int m = j / 4;
                BarEntry barEntry1 = (BarEntry)iBarDataSet.e(m);
                f5 = barEntry1.b();
                if (iBarDataSet.y()) {
                  String str = valueFormatter1.a(barEntry1);
                  float[] arrayOfFloat1 = barBuffer.b;
                  if (f5 >= 0.0F) {
                    f3 = arrayOfFloat1[k] + f2;
                  } else {
                    f3 = arrayOfFloat1[j + 3] + f1;
                  } 
                  a(paramCanvas, str, f4, f3, iBarDataSet.d(m));
                } 
                BarEntry barEntry2 = barEntry1;
                mPPointF4 = mPPointF3;
                if (barEntry2.g() != null && iBarDataSet.z()) {
                  Drawable drawable = barEntry2.g();
                  if (f5 >= 0.0F) {
                    f3 = barBuffer.b[k] + f2;
                  } else {
                    f3 = barBuffer.b[j + 3] + f1;
                  } 
                  f5 = mPPointF4.a;
                  float f7 = mPPointF4.b;
                  Utils.a(paramCanvas, drawable, (int)(f4 + f5), (int)(f3 + f7), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                } 
              } 
              j += 4;
            } 
            mPPointF5 = mPPointF3;
            f3 = f;
            bool1 = bool;
          } else {
            MPPointF mPPointF = mPPointF3;
            Transformer transformer = this.a.a(iBarDataSet.C());
            int j = 0;
            int k = 0;
            while (true) {
              mPPointF5 = mPPointF4;
              f3 = f;
              bool1 = bool;
              mPPointF2 = mPPointF;
              if (j < iBarDataSet.H() * this.g.b()) {
                float f8;
                BarEntry barEntry = (BarEntry)iBarDataSet.e(j);
                float[] arrayOfFloat = barEntry.a();
                float f7 = (barBuffer.b[k] + barBuffer.b[k + 2]) / 2.0F;
                int m = iBarDataSet.d(j);
                if (arrayOfFloat == null) {
                  if (!this.o.h(f7)) {
                    mPPointF5 = mPPointF4;
                    f3 = f;
                    bool1 = bool;
                    mPPointF2 = mPPointF;
                    break;
                  } 
                  ViewPortHandler viewPortHandler = this.o;
                  float[] arrayOfFloat1 = barBuffer.b;
                  int n = k + 1;
                  if (!viewPortHandler.f(arrayOfFloat1[n]) || !this.o.g(f7))
                    continue; 
                  if (iBarDataSet.y()) {
                    String str = valueFormatter.a((BarEntry)mPPointF2);
                    f4 = barBuffer.b[n];
                    if (mPPointF2.b() >= 0.0F) {
                      f3 = f2;
                    } else {
                      f3 = f1;
                    } 
                    a(paramCanvas, str, f7, f4 + f3, m);
                  } 
                  if (mPPointF2.g() != null && iBarDataSet.z()) {
                    Drawable drawable = mPPointF2.g();
                    f4 = barBuffer.b[n];
                    if (mPPointF2.b() >= 0.0F) {
                      f3 = f2;
                    } else {
                      f3 = f1;
                    } 
                    f5 = mPPointF4.a;
                    f8 = mPPointF4.b;
                    Utils.a(paramCanvas, drawable, (int)(f5 + f7), (int)(f4 + f3 + f8), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                  } 
                } else {
                  MPPointF mPPointF6 = mPPointF5;
                  float[] arrayOfFloat1 = new float[mPPointF6.length * 2];
                  f3 = -mPPointF2.f();
                  int i1 = 0;
                  int n = 0;
                  f5 = 0.0F;
                  while (i1 < arrayOfFloat1.length) {
                    MPPointF mPPointF7 = mPPointF6[n];
                    int i2 = mPPointF7 cmp 0.0F;
                    if (i2 == 0) {
                      MPPointF mPPointF8 = mPPointF7;
                      f8 = f5;
                      Object object3 = object;
                      if (f5 != 0.0F) {
                        if (object == 0.0F) {
                          mPPointF8 = mPPointF7;
                          f8 = f5;
                          object3 = object;
                          continue;
                        } 
                      } else {
                        continue;
                      } 
                    } 
                    if (i2 >= 0) {
                      f4 = f5 + mPPointF7;
                      f8 = f4;
                      Object object3 = object;
                    } else {
                      float f9 = object - mPPointF7;
                      f8 = f5;
                      Object object3 = object;
                    } 
                    continue;
                    arrayOfFloat1[i1 + 1] = f4 * f6;
                    i1 += 2;
                    n++;
                    f5 = f8;
                    object = SYNTHETIC_LOCAL_VARIABLE_10;
                  } 
                  transformer.a(arrayOfFloat1);
                  for (n = 0; n < arrayOfFloat1.length; n += 2) {
                    MPPointF mPPointF7 = mPPointF6[n / 2];
                    if ((mPPointF7 == 0.0F && object == 0.0F && f5 > 0.0F) || mPPointF7 < 0.0F) {
                      i1 = 1;
                    } else {
                      i1 = 0;
                    } 
                    float f9 = arrayOfFloat1[n + 1];
                    if (i1 != 0) {
                      f4 = f1;
                    } else {
                      f4 = f2;
                    } 
                    f4 = f9 + f4;
                    if (!this.o.h(f7))
                      break; 
                    if (this.o.f(f4) && this.o.g(f7)) {
                      if (iBarDataSet.y())
                        a(paramCanvas, valueFormatter.a(mPPointF7, (BarEntry)mPPointF2), f7, f4, m); 
                      MPPointF mPPointF8 = mPPointF2;
                      if (mPPointF8.g() != null && iBarDataSet.z()) {
                        Drawable drawable = mPPointF8.g();
                        Utils.a(paramCanvas, drawable, (int)(f7 + mPPointF4.a), (int)(f4 + mPPointF4.b), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                      } 
                    } 
                  } 
                } 
                if (mPPointF5 == null) {
                  k += 4;
                } else {
                  k += mPPointF5.length * 4;
                } 
                j++;
                continue;
              } 
              break;
            } 
          } 
          object1 = object;
          bool = bool1;
          MPPointF.b(mPPointF5);
        } 
        i++;
        MPPointF mPPointF1 = mPPointF2;
        Object object2 = object1;
      } 
    } 
  }
  
  public void c(Canvas paramCanvas) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\BarChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */