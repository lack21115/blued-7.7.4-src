package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
  protected ScatterDataProvider a;
  
  float[] b = new float[2];
  
  public ScatterChartRenderer(ScatterDataProvider paramScatterDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
    this.a = paramScatterDataProvider;
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas) {
    for (IScatterDataSet iScatterDataSet : this.a.getScatterData().i()) {
      if (iScatterDataSet.B())
        a(paramCanvas, iScatterDataSet); 
    } 
  }
  
  protected void a(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet) {
    if (paramIScatterDataSet.H() < 1)
      return; 
    ViewPortHandler viewPortHandler = this.o;
    Transformer transformer = this.a.a(paramIScatterDataSet.C());
    float f = this.g.a();
    IShapeRenderer iShapeRenderer = paramIScatterDataSet.b();
    if (iShapeRenderer == null) {
      Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
      return;
    } 
    int j = (int)Math.min(Math.ceil((paramIScatterDataSet.H() * this.g.b())), paramIScatterDataSet.H());
    int i;
    for (i = 0; i < j; i++) {
      Entry entry = paramIScatterDataSet.e(i);
      this.b[0] = entry.i();
      this.b[1] = entry.b() * f;
      transformer.a(this.b);
      if (!viewPortHandler.h(this.b[0]))
        return; 
      if (viewPortHandler.g(this.b[0]) && viewPortHandler.f(this.b[1])) {
        this.h.setColor(paramIScatterDataSet.a(i / 2));
        ViewPortHandler viewPortHandler1 = this.o;
        float[] arrayOfFloat = this.b;
        iShapeRenderer.a(paramCanvas, paramIScatterDataSet, viewPortHandler1, arrayOfFloat[0], arrayOfFloat[1], this.h);
      } 
    } 
  }
  
  public void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    this.k.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.k);
  }
  
  public void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight) {
    ScatterData scatterData = this.a.getScatterData();
    int j = paramArrayOfHighlight.length;
    for (int i = 0; i < j; i++) {
      Highlight highlight = paramArrayOfHighlight[i];
      IScatterDataSet iScatterDataSet = (IScatterDataSet)scatterData.a(highlight.f());
      if (iScatterDataSet != null && iScatterDataSet.p()) {
        Entry entry = iScatterDataSet.b(highlight.a(), highlight.b());
        if (a(entry, (IBarLineScatterCandleBubbleDataSet)iScatterDataSet)) {
          MPPointD mPPointD = this.a.a(iScatterDataSet.C()).b(entry.i(), entry.b() * this.g.a());
          highlight.a((float)mPPointD.a, (float)mPPointD.b);
          a(paramCanvas, (float)mPPointD.a, (float)mPPointD.b, (ILineScatterCandleRadarDataSet)iScatterDataSet);
        } 
      } 
    } 
  }
  
  public void b(Canvas paramCanvas) {
    if (a((ChartInterface)this.a)) {
      List<IScatterDataSet> list = this.a.getScatterData().i();
      for (int i = 0; i < this.a.getScatterData().d(); i++) {
        IScatterDataSet iScatterDataSet = list.get(i);
        if (a((IDataSet)iScatterDataSet) && iScatterDataSet.H() >= 1) {
          b((IDataSet)iScatterDataSet);
          this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)iScatterDataSet);
          float[] arrayOfFloat = this.a.a(iScatterDataSet.C()).a(iScatterDataSet, this.g.b(), this.g.a(), this.f.a, this.f.b);
          float f = Utils.a(iScatterDataSet.a());
          ValueFormatter valueFormatter = iScatterDataSet.q();
          MPPointF mPPointF = MPPointF.a(iScatterDataSet.A());
          mPPointF.a = Utils.a(mPPointF.a);
          mPPointF.b = Utils.a(mPPointF.b);
          int j;
          for (j = 0; j < arrayOfFloat.length && this.o.h(arrayOfFloat[j]); j += 2) {
            if (this.o.g(arrayOfFloat[j])) {
              ViewPortHandler viewPortHandler = this.o;
              int k = j + 1;
              if (viewPortHandler.f(arrayOfFloat[k])) {
                int m = j / 2;
                Entry entry = iScatterDataSet.e(this.f.a + m);
                if (iScatterDataSet.y())
                  a(paramCanvas, valueFormatter.a(entry), arrayOfFloat[j], arrayOfFloat[k] - f, iScatterDataSet.d(m + this.f.a)); 
                if (entry.g() != null && iScatterDataSet.z()) {
                  Drawable drawable = entry.g();
                  Utils.a(paramCanvas, drawable, (int)(arrayOfFloat[j] + mPPointF.a), (int)(arrayOfFloat[k] + mPPointF.b), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                } 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\ScatterChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */