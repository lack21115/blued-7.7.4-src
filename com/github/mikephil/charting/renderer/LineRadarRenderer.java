package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class LineRadarRenderer extends LineScatterCandleRadarRenderer {
  public LineRadarRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
  }
  
  private boolean b() {
    return (Utils.d() >= 18);
  }
  
  protected void a(Canvas paramCanvas, Path paramPath, int paramInt1, int paramInt2) {
    paramInt1 = paramInt1 & 0xFFFFFF | paramInt2 << 24;
    if (b()) {
      paramInt2 = paramCanvas.save();
      paramCanvas.clipPath(paramPath);
      paramCanvas.drawColor(paramInt1);
      paramCanvas.restoreToCount(paramInt2);
      return;
    } 
    Paint.Style style = this.h.getStyle();
    paramInt2 = this.h.getColor();
    this.h.setStyle(Paint.Style.FILL);
    this.h.setColor(paramInt1);
    paramCanvas.drawPath(paramPath, this.h);
    this.h.setColor(paramInt2);
    this.h.setStyle(style);
  }
  
  protected void a(Canvas paramCanvas, Path paramPath, Drawable paramDrawable) {
    if (b()) {
      int i = paramCanvas.save();
      paramCanvas.clipPath(paramPath);
      paramDrawable.setBounds((int)this.o.f(), (int)this.o.e(), (int)this.o.g(), (int)this.o.h());
      paramDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fill-drawables not (yet) supported below API level 18, this code was run on API level ");
    stringBuilder.append(Utils.d());
    stringBuilder.append(".");
    throw new RuntimeException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\LineRadarRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */