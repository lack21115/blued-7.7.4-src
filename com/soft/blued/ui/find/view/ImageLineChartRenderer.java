package com.soft.blued.ui.find.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class ImageLineChartRenderer extends LineChartRenderer {
  private final LineChart p;
  
  private final Bitmap q;
  
  public ImageLineChartRenderer(LineChart paramLineChart, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler, Bitmap paramBitmap) {
    super((LineDataProvider)paramLineChart, paramChartAnimator, paramViewPortHandler);
    this.p = paramLineChart;
    this.q = paramBitmap;
  }
  
  private Bitmap a(int paramInt) {
    return Bitmap.createScaledBitmap(this.q, paramInt, paramInt, false);
  }
  
  public void c(Canvas paramCanvas) {
    super.c(paramCanvas);
    Highlight[] arrayOfHighlight = this.p.getHighlighted();
    if (arrayOfHighlight == null)
      return; 
    float f = this.g.a();
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = 0.0F;
    arrayOfFloat1[1] = 0.0F;
    LineData lineData = this.a.getLineData();
    List<ILineDataSet> list = this.a.getLineData().i();
    Bitmap[] arrayOfBitmap = new Bitmap[list.size()];
    float[] arrayOfFloat2 = new float[list.size()];
    int i;
    for (i = 0; i < list.size(); i++) {
      float f1 = ((ILineDataSet)list.get(i)).c();
      arrayOfFloat2[i] = f1 / 2.0F;
      arrayOfBitmap[i] = a((int)f1);
    } 
    int j = arrayOfHighlight.length;
    for (i = 0; i < j; i++) {
      Highlight highlight = arrayOfHighlight[i];
      int k = highlight.f();
      ILineDataSet iLineDataSet = (ILineDataSet)lineData.a(k);
      Transformer transformer = this.p.a(iLineDataSet.C());
      if (iLineDataSet != null && iLineDataSet.p()) {
        Entry entry = iLineDataSet.b(highlight.a(), highlight.b());
        if (a(entry, (IBarLineScatterCandleBubbleDataSet)iLineDataSet)) {
          arrayOfFloat1[0] = entry.i();
          arrayOfFloat1[1] = entry.b() * f;
          transformer.a(arrayOfFloat1);
          paramCanvas.drawBitmap(arrayOfBitmap[k], arrayOfFloat1[0] - arrayOfFloat2[k], arrayOfFloat1[1] - arrayOfFloat2[k], this.h);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\view\ImageLineChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */