package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {
  protected BubbleDataProvider a;
  
  private float[] b = new float[4];
  
  private float[] c = new float[2];
  
  private float[] d = new float[3];
  
  public BubbleChartRenderer(BubbleDataProvider paramBubbleDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
    this.a = paramBubbleDataProvider;
    this.h.setStyle(Paint.Style.FILL);
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(Utils.a(1.5F));
  }
  
  protected float a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean) {
    float f = paramFloat1;
    if (paramBoolean)
      if (paramFloat2 == 0.0F) {
        f = 1.0F;
      } else {
        f = (float)Math.sqrt((paramFloat1 / paramFloat2));
      }  
    return paramFloat3 * f;
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas) {
    for (IBubbleDataSet iBubbleDataSet : this.a.getBubbleData().i()) {
      if (iBubbleDataSet.B())
        a(paramCanvas, iBubbleDataSet); 
    } 
  }
  
  protected void a(Canvas paramCanvas, IBubbleDataSet paramIBubbleDataSet) {
    if (paramIBubbleDataSet.H() < 1)
      return; 
    Transformer transformer = this.a.a(paramIBubbleDataSet.C());
    float f1 = this.g.a();
    this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)paramIBubbleDataSet);
    float[] arrayOfFloat = this.b;
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[2] = 1.0F;
    transformer.a(arrayOfFloat);
    boolean bool = paramIBubbleDataSet.c();
    arrayOfFloat = this.b;
    float f2 = Math.abs(arrayOfFloat[2] - arrayOfFloat[0]);
    f2 = Math.min(Math.abs(this.o.h() - this.o.e()), f2);
    int i;
    for (i = this.f.a; i <= this.f.c + this.f.a; i++) {
      BubbleEntry bubbleEntry = (BubbleEntry)paramIBubbleDataSet.e(i);
      this.c[0] = bubbleEntry.i();
      this.c[1] = bubbleEntry.b() * f1;
      transformer.a(this.c);
      float f = a(bubbleEntry.a(), paramIBubbleDataSet.b(), f2, bool) / 2.0F;
      if (this.o.i(this.c[1] + f) && this.o.j(this.c[1] - f) && this.o.g(this.c[0] + f)) {
        if (!this.o.h(this.c[0] - f))
          return; 
        int j = paramIBubbleDataSet.a((int)bubbleEntry.i());
        this.h.setColor(j);
        float[] arrayOfFloat1 = this.c;
        paramCanvas.drawCircle(arrayOfFloat1[0], arrayOfFloat1[1], f, this.h);
      } 
    } 
  }
  
  public void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    this.k.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.k);
  }
  
  public void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight) {
    BubbleData bubbleData = this.a.getBubbleData();
    float f = this.g.a();
    int j = paramArrayOfHighlight.length;
    int i;
    for (i = 0; i < j; i++) {
      Highlight highlight = paramArrayOfHighlight[i];
      IBubbleDataSet iBubbleDataSet = (IBubbleDataSet)bubbleData.a(highlight.f());
      if (iBubbleDataSet != null && iBubbleDataSet.p()) {
        BubbleEntry bubbleEntry = (BubbleEntry)iBubbleDataSet.b(highlight.a(), highlight.b());
        if (bubbleEntry.b() == highlight.b() && a((Entry)bubbleEntry, (IBarLineScatterCandleBubbleDataSet)iBubbleDataSet)) {
          Transformer transformer = this.a.a(iBubbleDataSet.C());
          float[] arrayOfFloat2 = this.b;
          arrayOfFloat2[0] = 0.0F;
          arrayOfFloat2[2] = 1.0F;
          transformer.a(arrayOfFloat2);
          boolean bool = iBubbleDataSet.c();
          arrayOfFloat2 = this.b;
          float f1 = Math.abs(arrayOfFloat2[2] - arrayOfFloat2[0]);
          f1 = Math.min(Math.abs(this.o.h() - this.o.e()), f1);
          this.c[0] = bubbleEntry.i();
          this.c[1] = bubbleEntry.b() * f;
          transformer.a(this.c);
          float[] arrayOfFloat1 = this.c;
          highlight.a(arrayOfFloat1[0], arrayOfFloat1[1]);
          f1 = a(bubbleEntry.a(), iBubbleDataSet.b(), f1, bool) / 2.0F;
          if (this.o.i(this.c[1] + f1) && this.o.j(this.c[1] - f1) && this.o.g(this.c[0] + f1)) {
            if (!this.o.h(this.c[0] - f1))
              return; 
            int k = iBubbleDataSet.a((int)bubbleEntry.i());
            Color.RGBToHSV(Color.red(k), Color.green(k), Color.blue(k), this.d);
            float[] arrayOfFloat4 = this.d;
            arrayOfFloat4[2] = arrayOfFloat4[2] * 0.5F;
            k = Color.HSVToColor(Color.alpha(k), this.d);
            this.i.setColor(k);
            this.i.setStrokeWidth(iBubbleDataSet.a());
            float[] arrayOfFloat3 = this.c;
            paramCanvas.drawCircle(arrayOfFloat3[0], arrayOfFloat3[1], f1, this.i);
          } 
        } 
      } 
    } 
  }
  
  public void b(Canvas paramCanvas) {
    BubbleData bubbleData = this.a.getBubbleData();
    if (bubbleData == null)
      return; 
    if (a((ChartInterface)this.a)) {
      List<IBubbleDataSet> list = bubbleData.i();
      float f = Utils.b(this.k, "1");
      int i;
      for (i = 0; i < list.size(); i++) {
        IBubbleDataSet iBubbleDataSet = list.get(i);
        if (a((IDataSet)iBubbleDataSet) && iBubbleDataSet.H() >= 1) {
          b((IDataSet)iBubbleDataSet);
          float f1 = Math.max(0.0F, Math.min(1.0F, this.g.b()));
          float f2 = this.g.a();
          this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)iBubbleDataSet);
          float[] arrayOfFloat = this.a.a(iBubbleDataSet.C()).a(iBubbleDataSet, f2, this.f.a, this.f.b);
          if (f1 == 1.0F)
            f1 = f2; 
          ValueFormatter valueFormatter = iBubbleDataSet.q();
          MPPointF mPPointF = MPPointF.a(iBubbleDataSet.A());
          mPPointF.a = Utils.a(mPPointF.a);
          mPPointF.b = Utils.a(mPPointF.b);
          int j;
          for (j = 0; j < arrayOfFloat.length; j += 2) {
            int k = j / 2;
            int m = iBubbleDataSet.d(this.f.a + k);
            m = Color.argb(Math.round(255.0F * f1), Color.red(m), Color.green(m), Color.blue(m));
            f2 = arrayOfFloat[j];
            float f3 = arrayOfFloat[j + 1];
            if (!this.o.h(f2))
              break; 
            if (this.o.g(f2) && this.o.f(f3)) {
              BubbleEntry bubbleEntry = (BubbleEntry)iBubbleDataSet.e(k + this.f.a);
              if (iBubbleDataSet.y())
                a(paramCanvas, valueFormatter.a(bubbleEntry), f2, f3 + 0.5F * f, m); 
              if (bubbleEntry.g() != null && iBubbleDataSet.z()) {
                Drawable drawable = bubbleEntry.g();
                Utils.a(paramCanvas, drawable, (int)(f2 + mPPointF.a), (int)(f3 + mPPointF.b), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\BubbleChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */