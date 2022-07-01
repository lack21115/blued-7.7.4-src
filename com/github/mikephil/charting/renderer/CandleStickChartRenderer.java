package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
  protected CandleDataProvider a;
  
  private float[] b = new float[8];
  
  private float[] c = new float[4];
  
  private float[] d = new float[4];
  
  private float[] e = new float[4];
  
  private float[] l = new float[4];
  
  public CandleStickChartRenderer(CandleDataProvider paramCandleDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
    this.a = paramCandleDataProvider;
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas) {
    for (ICandleDataSet iCandleDataSet : this.a.getCandleData().i()) {
      if (iCandleDataSet.B())
        a(paramCanvas, iCandleDataSet); 
    } 
  }
  
  protected void a(Canvas paramCanvas, ICandleDataSet paramICandleDataSet) {
    Transformer transformer = this.a.a(paramICandleDataSet.C());
    float f1 = this.g.a();
    float f2 = paramICandleDataSet.a();
    boolean bool = paramICandleDataSet.c();
    this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)paramICandleDataSet);
    this.h.setStrokeWidth(paramICandleDataSet.b());
    int i;
    for (i = this.f.a; i <= this.f.c + this.f.a; i++) {
      CandleEntry candleEntry = (CandleEntry)paramICandleDataSet.e(i);
      if (candleEntry != null) {
        float f3 = candleEntry.i();
        float f4 = candleEntry.e();
        float f5 = candleEntry.d();
        float f6 = candleEntry.a();
        float f7 = candleEntry.c();
        if (bool) {
          float[] arrayOfFloat = this.b;
          arrayOfFloat[0] = f3;
          arrayOfFloat[2] = f3;
          arrayOfFloat[4] = f3;
          arrayOfFloat[6] = f3;
          int j = f4 cmp f5;
          if (j > 0) {
            arrayOfFloat[1] = f6 * f1;
            arrayOfFloat[3] = f4 * f1;
            arrayOfFloat[5] = f7 * f1;
            arrayOfFloat[7] = f5 * f1;
          } else if (f4 < f5) {
            arrayOfFloat[1] = f6 * f1;
            arrayOfFloat[3] = f5 * f1;
            arrayOfFloat[5] = f7 * f1;
            arrayOfFloat[7] = f4 * f1;
          } else {
            arrayOfFloat[1] = f6 * f1;
            arrayOfFloat[3] = f4 * f1;
            arrayOfFloat[5] = f7 * f1;
            arrayOfFloat[7] = arrayOfFloat[3];
          } 
          transformer.a(this.b);
          if (paramICandleDataSet.F()) {
            if (j > 0) {
              int k;
              Paint paint = this.h;
              if (paramICandleDataSet.f() == 1122867) {
                k = paramICandleDataSet.a(i);
              } else {
                k = paramICandleDataSet.f();
              } 
              paint.setColor(k);
            } else if (f4 < f5) {
              int k;
              Paint paint = this.h;
              if (paramICandleDataSet.e() == 1122867) {
                k = paramICandleDataSet.a(i);
              } else {
                k = paramICandleDataSet.e();
              } 
              paint.setColor(k);
            } else {
              int k;
              Paint paint = this.h;
              if (paramICandleDataSet.d() == 1122867) {
                k = paramICandleDataSet.a(i);
              } else {
                k = paramICandleDataSet.d();
              } 
              paint.setColor(k);
            } 
          } else {
            int k;
            Paint paint = this.h;
            if (paramICandleDataSet.E() == 1122867) {
              k = paramICandleDataSet.a(i);
            } else {
              k = paramICandleDataSet.E();
            } 
            paint.setColor(k);
          } 
          this.h.setStyle(Paint.Style.STROKE);
          paramCanvas.drawLines(this.b, this.h);
          arrayOfFloat = this.c;
          arrayOfFloat[0] = f3 - 0.5F + f2;
          arrayOfFloat[1] = f5 * f1;
          arrayOfFloat[2] = f3 + 0.5F - f2;
          arrayOfFloat[3] = f4 * f1;
          transformer.a(arrayOfFloat);
          if (j > 0) {
            if (paramICandleDataSet.f() == 1122867) {
              this.h.setColor(paramICandleDataSet.a(i));
            } else {
              this.h.setColor(paramICandleDataSet.f());
            } 
            this.h.setStyle(paramICandleDataSet.D());
            arrayOfFloat = this.c;
            paramCanvas.drawRect(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[2], arrayOfFloat[1], this.h);
          } else if (f4 < f5) {
            if (paramICandleDataSet.e() == 1122867) {
              this.h.setColor(paramICandleDataSet.a(i));
            } else {
              this.h.setColor(paramICandleDataSet.e());
            } 
            this.h.setStyle(paramICandleDataSet.g());
            arrayOfFloat = this.c;
            paramCanvas.drawRect(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], this.h);
          } else {
            if (paramICandleDataSet.d() == 1122867) {
              this.h.setColor(paramICandleDataSet.a(i));
            } else {
              this.h.setColor(paramICandleDataSet.d());
            } 
            arrayOfFloat = this.c;
            paramCanvas.drawLine(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], this.h);
          } 
        } else {
          int j;
          float[] arrayOfFloat1 = this.d;
          arrayOfFloat1[0] = f3;
          arrayOfFloat1[1] = f6 * f1;
          arrayOfFloat1[2] = f3;
          arrayOfFloat1[3] = f7 * f1;
          float[] arrayOfFloat2 = this.e;
          arrayOfFloat2[0] = f3 - 0.5F + f2;
          f6 = f4 * f1;
          arrayOfFloat2[1] = f6;
          arrayOfFloat2[2] = f3;
          arrayOfFloat2[3] = f6;
          arrayOfFloat2 = this.l;
          arrayOfFloat2[0] = 0.5F + f3 - f2;
          f6 = f5 * f1;
          arrayOfFloat2[1] = f6;
          arrayOfFloat2[2] = f3;
          arrayOfFloat2[3] = f6;
          transformer.a(arrayOfFloat1);
          transformer.a(this.e);
          transformer.a(this.l);
          if (f4 > f5) {
            if (paramICandleDataSet.f() == 1122867) {
              j = paramICandleDataSet.a(i);
            } else {
              j = paramICandleDataSet.f();
            } 
          } else if (f4 < f5) {
            if (paramICandleDataSet.e() == 1122867) {
              j = paramICandleDataSet.a(i);
            } else {
              j = paramICandleDataSet.e();
            } 
          } else if (paramICandleDataSet.d() == 1122867) {
            j = paramICandleDataSet.a(i);
          } else {
            j = paramICandleDataSet.d();
          } 
          this.h.setColor(j);
          arrayOfFloat1 = this.d;
          paramCanvas.drawLine(arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2], arrayOfFloat1[3], this.h);
          arrayOfFloat1 = this.e;
          paramCanvas.drawLine(arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2], arrayOfFloat1[3], this.h);
          arrayOfFloat1 = this.l;
          paramCanvas.drawLine(arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2], arrayOfFloat1[3], this.h);
        } 
      } 
    } 
  }
  
  public void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    this.k.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.k);
  }
  
  public void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight) {
    CandleData candleData = this.a.getCandleData();
    int j = paramArrayOfHighlight.length;
    int i;
    for (i = 0; i < j; i++) {
      Highlight highlight = paramArrayOfHighlight[i];
      ICandleDataSet iCandleDataSet = (ICandleDataSet)candleData.a(highlight.f());
      if (iCandleDataSet != null && iCandleDataSet.p()) {
        CandleEntry candleEntry = (CandleEntry)iCandleDataSet.b(highlight.a(), highlight.b());
        if (a((Entry)candleEntry, (IBarLineScatterCandleBubbleDataSet)iCandleDataSet)) {
          float f = (candleEntry.c() * this.g.a() + candleEntry.a() * this.g.a()) / 2.0F;
          MPPointD mPPointD = this.a.a(iCandleDataSet.C()).b(candleEntry.i(), f);
          highlight.a((float)mPPointD.a, (float)mPPointD.b);
          a(paramCanvas, (float)mPPointD.a, (float)mPPointD.b, (ILineScatterCandleRadarDataSet)iCandleDataSet);
        } 
      } 
    } 
  }
  
  public void b(Canvas paramCanvas) {
    if (a((ChartInterface)this.a)) {
      List<ICandleDataSet> list = this.a.getCandleData().i();
      int i;
      for (i = 0; i < list.size(); i++) {
        ICandleDataSet iCandleDataSet = list.get(i);
        if (a((IDataSet)iCandleDataSet) && iCandleDataSet.H() >= 1) {
          b((IDataSet)iCandleDataSet);
          Transformer transformer = this.a.a(iCandleDataSet.C());
          this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)iCandleDataSet);
          float[] arrayOfFloat = transformer.a(iCandleDataSet, this.g.b(), this.g.a(), this.f.a, this.f.b);
          float f = Utils.a(5.0F);
          ValueFormatter valueFormatter = iCandleDataSet.q();
          MPPointF mPPointF = MPPointF.a(iCandleDataSet.A());
          mPPointF.a = Utils.a(mPPointF.a);
          mPPointF.b = Utils.a(mPPointF.b);
          int j;
          for (j = 0; j < arrayOfFloat.length; j += 2) {
            float f1 = arrayOfFloat[j];
            float f2 = arrayOfFloat[j + 1];
            if (!this.o.h(f1))
              break; 
            if (this.o.g(f1) && this.o.f(f2)) {
              int k = j / 2;
              CandleEntry candleEntry = (CandleEntry)iCandleDataSet.e(this.f.a + k);
              if (iCandleDataSet.y())
                a(paramCanvas, valueFormatter.a(candleEntry), f1, f2 - f, iCandleDataSet.d(k)); 
              if (candleEntry.g() != null && iCandleDataSet.z()) {
                Drawable drawable = candleEntry.g();
                Utils.a(paramCanvas, drawable, (int)(f1 + mPPointF.a), (int)(f2 + mPPointF.b), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
              } 
            } 
          } 
          MPPointF.b(mPPointF);
        } 
      } 
    } 
  }
  
  public void c(Canvas paramCanvas) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\CandleStickChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */