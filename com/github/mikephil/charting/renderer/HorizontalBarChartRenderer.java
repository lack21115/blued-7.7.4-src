package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class HorizontalBarChartRenderer extends BarChartRenderer {
  private RectF l = new RectF();
  
  public HorizontalBarChartRenderer(BarDataProvider paramBarDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramBarDataProvider, paramChartAnimator, paramViewPortHandler);
    this.k.setTextAlign(Paint.Align.LEFT);
  }
  
  public void a() {
    BarData barData = this.a.getBarData();
    this.c = (BarBuffer[])new HorizontalBarBuffer[barData.d()];
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
      arrayOfBarBuffer[i] = (BarBuffer)new HorizontalBarBuffer(j * 4 * b, barData.d(), iBarDataSet.b());
    } 
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer) {
    this.b.set(paramFloat2, paramFloat1 - paramFloat4, paramFloat3, paramFloat1 + paramFloat4);
    paramTransformer.b(this.b, this.g.a());
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
        rectF.top = f3 - f;
        rectF.bottom = f3 + f;
        transformer.a(rectF);
        if (this.o.i(this.l.bottom)) {
          if (!this.o.j(this.l.top))
            break; 
          this.l.left = this.o.f();
          this.l.right = this.o.g();
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
      j = i + 3;
      if (!viewPortHandler.i(arrayOfFloat[j]))
        return; 
      viewPortHandler = this.o;
      arrayOfFloat = barBuffer.b;
      k = i + 1;
      if (viewPortHandler.j(arrayOfFloat[k])) {
        if (paramInt == 0)
          this.h.setColor(paramIBarDataSet.a(i / 4)); 
        f1 = barBuffer.b[i];
        f2 = barBuffer.b[k];
        float[] arrayOfFloat1 = barBuffer.b;
        int m = i + 2;
        paramCanvas.drawRect(f1, f2, arrayOfFloat1[m], barBuffer.b[j], this.h);
        if (bool)
          paramCanvas.drawRect(barBuffer.b[i], barBuffer.b[k], barBuffer.b[m], barBuffer.b[j], this.e); 
      } 
      i += 4;
    } 
  }
  
  public void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    this.k.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.k);
  }
  
  protected void a(Highlight paramHighlight, RectF paramRectF) {
    paramHighlight.a(paramRectF.centerY(), paramRectF.right);
  }
  
  protected boolean a(ChartInterface paramChartInterface) {
    return (paramChartInterface.getData().j() < paramChartInterface.getMaxVisibleCount() * this.o.r());
  }
  
  public void b(Canvas paramCanvas) {
    if (a((ChartInterface)this.a)) {
      List<IBarDataSet> list = this.a.getBarData().i();
      float f = Utils.a(5.0F);
      boolean bool = this.a.c();
      int i;
      for (i = 0; i < this.a.getBarData().d(); i++) {
        IBarDataSet iBarDataSet = list.get(i);
        if (a((IDataSet)iBarDataSet)) {
          boolean bool1;
          List<IBarDataSet> list1;
          float[] arrayOfFloat;
          Drawable drawable;
          boolean bool2 = this.a.c(iBarDataSet.C());
          b((IDataSet)iBarDataSet);
          float f1 = Utils.b(this.k, "10") / 2.0F;
          ValueFormatter valueFormatter = iBarDataSet.q();
          BarBuffer barBuffer = this.c[i];
          float f2 = this.g.a();
          MPPointF mPPointF = MPPointF.a(iBarDataSet.A());
          mPPointF.a = Utils.a(mPPointF.a);
          mPPointF.b = Utils.a(mPPointF.b);
          if (!iBarDataSet.b()) {
            int j = 0;
            float f3 = f1;
            List<IBarDataSet> list2 = list;
            ValueFormatter valueFormatter1 = valueFormatter;
            BarBuffer barBuffer1 = barBuffer;
            MPPointF mPPointF1 = mPPointF;
            while (j < barBuffer1.b.length * this.g.b()) {
              float[] arrayOfFloat1 = barBuffer1.b;
              int k = j + 1;
              float f4 = (arrayOfFloat1[k] + barBuffer1.b[j + 3]) / 2.0F;
              if (!this.o.i(barBuffer1.b[k]))
                break; 
              if (this.o.e(barBuffer1.b[j]) && this.o.j(barBuffer1.b[k])) {
                float f7;
                BarEntry barEntry = (BarEntry)iBarDataSet.e(j / 4);
                f1 = barEntry.b();
                String str = valueFormatter1.a(barEntry);
                f2 = Utils.a(this.k, str);
                if (bool) {
                  f6 = f;
                } else {
                  f6 = -(f2 + f);
                } 
                if (bool) {
                  f7 = -(f2 + f);
                } else {
                  f7 = f;
                } 
                float f5 = f6;
                float f8 = f7;
                if (bool2) {
                  f5 = -f6 - f2;
                  f8 = -f7 - f2;
                } 
                float f6 = f8;
                if (iBarDataSet.y()) {
                  f8 = barBuffer1.b[j + 2];
                  if (f1 >= 0.0F) {
                    f7 = f5;
                  } else {
                    f7 = f6;
                  } 
                  a(paramCanvas, str, f8 + f7, f4 + f3, iBarDataSet.d(j / 2));
                } 
                mPPointF = mPPointF1;
                if (barEntry.g() != null && iBarDataSet.z()) {
                  drawable = barEntry.g();
                  f7 = barBuffer1.b[j + 2];
                  if (f1 >= 0.0F)
                    f6 = f5; 
                  f5 = mPPointF.a;
                  f8 = mPPointF.b;
                  Utils.a(paramCanvas, drawable, (int)(f7 + f6 + f5), (int)(f4 + f8), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                } 
              } 
              j += 4;
            } 
            MPPointF mPPointF2 = mPPointF1;
            bool1 = bool;
            list1 = list2;
          } else {
            List<IBarDataSet> list2 = list1;
            int j = i;
            MPPointF mPPointF1 = mPPointF;
            Transformer transformer = this.a.a(iBarDataSet.C());
            int k = 0;
            int m = 0;
            while (true) {
              MPPointF mPPointF2 = mPPointF1;
              bool1 = bool;
              list1 = list2;
              i = j;
              if (k < iBarDataSet.H() * this.g.b()) {
                float f3;
                float f4;
                float f5;
                List<IBarDataSet> list3;
                BarEntry barEntry = (BarEntry)iBarDataSet.e(k);
                int n = iBarDataSet.d(k);
                float[] arrayOfFloat1 = barEntry.a();
                if (arrayOfFloat1 == null) {
                  ViewPortHandler viewPortHandler = this.o;
                  float[] arrayOfFloat2 = ((BarBuffer)drawable).b;
                  i = m + 1;
                  if (!viewPortHandler.i(arrayOfFloat2[i])) {
                    MPPointF mPPointF3 = mPPointF1;
                    bool1 = bool;
                    list3 = list2;
                    i = j;
                    break;
                  } 
                  if (!this.o.e(((BarBuffer)drawable).b[m]) || !this.o.j(((BarBuffer)drawable).b[i]))
                    continue; 
                  String str = valueFormatter.a(barEntry);
                  float f7 = Utils.a(this.k, str);
                  if (bool) {
                    f3 = f;
                  } else {
                    f3 = -(f7 + f);
                  } 
                  if (bool) {
                    f4 = -(f7 + f);
                  } else {
                    f4 = f;
                  } 
                  float f6 = f3;
                  f5 = f4;
                  if (bool2) {
                    f6 = -f3 - f7;
                    f5 = -f4 - f7;
                  } 
                  f3 = f5;
                  if (iBarDataSet.y()) {
                    f5 = ((BarBuffer)drawable).b[m + 2];
                    if (barEntry.b() >= 0.0F) {
                      f4 = f6;
                    } else {
                      f4 = f3;
                    } 
                    a(paramCanvas, str, f5 + f4, ((BarBuffer)drawable).b[i] + f1, n);
                  } 
                  bool1 = bool;
                  if (barEntry.g() != null) {
                    bool1 = bool;
                    if (iBarDataSet.z()) {
                      Drawable drawable1 = barEntry.g();
                      f4 = ((BarBuffer)drawable).b[m + 2];
                      if (barEntry.b() >= 0.0F)
                        f3 = f6; 
                      f6 = ((BarBuffer)drawable).b[i];
                      f5 = mPPointF1.a;
                      f7 = mPPointF1.b;
                      Utils.a(paramCanvas, drawable1, (int)(f4 + f3 + f5), (int)(f6 + f7), drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
                      bool1 = bool;
                    } 
                  } 
                } else {
                  List<IBarDataSet> list4 = list3;
                  arrayOfFloat = new float[list4.length * 2];
                  float f6 = -barEntry.f();
                  int i1 = 0;
                  i = 0;
                  float f7 = 0.0F;
                  while (i1 < arrayOfFloat.length) {
                    List<IBarDataSet> list5 = list4[i];
                    int i2 = list5 cmp 0.0F;
                    if (i2 == 0) {
                      List<IBarDataSet> list6 = list5;
                      f4 = f7;
                      f5 = f6;
                      if (f7 != 0.0F) {
                        if (f6 == 0.0F) {
                          list6 = list5;
                          f4 = f7;
                          f5 = f6;
                          continue;
                        } 
                      } else {
                        continue;
                      } 
                    } 
                    if (i2 >= 0) {
                      f3 = f7 + list5;
                      f4 = f3;
                      f5 = f6;
                    } else {
                      f5 = f6 - list5;
                      f4 = f7;
                      f3 = f6;
                    } 
                    continue;
                    arrayOfFloat[i1] = f3 * f2;
                    i1 += 2;
                    i++;
                    f7 = f4;
                    f6 = f5;
                  } 
                  transformer.a(arrayOfFloat);
                  i = 0;
                  while (true) {
                    bool1 = bool;
                    if (i < arrayOfFloat.length) {
                      List<IBarDataSet> list5 = list4[i / 2];
                      String str = valueFormatter.a(list5, barEntry);
                      float f9 = Utils.a(this.k, str);
                      if (bool) {
                        f4 = f;
                      } else {
                        f4 = -(f9 + f);
                      } 
                      bool1 = bool;
                      if (bool) {
                        f5 = -(f9 + f);
                      } else {
                        f5 = f;
                      } 
                      float f8 = f4;
                      f3 = f5;
                      if (bool2) {
                        f8 = -f4 - f9;
                        f3 = -f5 - f9;
                      } 
                      if ((list5 == 0.0F && f6 == 0.0F && f7 > 0.0F) || list5 < 0.0F) {
                        i1 = 1;
                      } else {
                        i1 = 0;
                      } 
                      f4 = arrayOfFloat[i];
                      if (i1 != 0)
                        f8 = f3; 
                      f3 = f4 + f8;
                      f4 = (((BarBuffer)drawable).b[m + 1] + ((BarBuffer)drawable).b[m + 3]) / 2.0F;
                      if (!this.o.i(f4))
                        break; 
                      if (this.o.e(f3) && this.o.j(f4)) {
                        if (iBarDataSet.y())
                          a(paramCanvas, str, f3, f4 + f1, n); 
                        if (barEntry.g() != null && iBarDataSet.z()) {
                          Drawable drawable1 = barEntry.g();
                          Utils.a(paramCanvas, drawable1, (int)(f3 + mPPointF1.a), (int)(f4 + mPPointF1.b), drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
                        } 
                      } 
                      i += 2;
                      bool = bool1;
                      continue;
                    } 
                    break;
                  } 
                } 
                if (list3 == null) {
                  i = m + 4;
                } else {
                  i = m + list3.length * 4;
                } 
                k++;
                bool = bool1;
                m = i;
                continue;
              } 
              break;
            } 
          } 
          bool = bool1;
          MPPointF.b((MPPointF)arrayOfFloat);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\HorizontalBarChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */