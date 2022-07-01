package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PathEffect;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {
  private Path a = new Path();
  
  public LineScatterCandleRadarRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, ILineScatterCandleRadarDataSet paramILineScatterCandleRadarDataSet) {
    this.i.setColor(paramILineScatterCandleRadarDataSet.h());
    this.i.setStrokeWidth(paramILineScatterCandleRadarDataSet.V());
    this.i.setPathEffect((PathEffect)paramILineScatterCandleRadarDataSet.W());
    if (paramILineScatterCandleRadarDataSet.T()) {
      this.a.reset();
      this.a.moveTo(paramFloat1, this.o.e());
      this.a.lineTo(paramFloat1, this.o.h());
      paramCanvas.drawPath(this.a, this.i);
    } 
    if (paramILineScatterCandleRadarDataSet.U()) {
      this.a.reset();
      this.a.moveTo(this.o.f(), paramFloat2);
      this.a.lineTo(this.o.g(), paramFloat2);
      paramCanvas.drawPath(this.a, this.i);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\LineScatterCandleRadarRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */