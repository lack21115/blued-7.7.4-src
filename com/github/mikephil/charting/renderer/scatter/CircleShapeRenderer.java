package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class CircleShapeRenderer implements IShapeRenderer {
  public void a(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet, ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Paint paramPaint) {
    float f1 = paramIScatterDataSet.a();
    float f2 = f1 / 2.0F;
    float f3 = Utils.a(paramIScatterDataSet.c());
    float f4 = (f1 - f3 * 2.0F) / 2.0F;
    float f5 = f4 / 2.0F;
    int i = paramIScatterDataSet.d();
    if (f1 > 0.0D) {
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setStrokeWidth(f4);
      paramCanvas.drawCircle(paramFloat1, paramFloat2, f5 + f3, paramPaint);
      if (i != 1122867) {
        paramPaint.setStyle(Paint.Style.FILL);
        paramPaint.setColor(i);
        paramCanvas.drawCircle(paramFloat1, paramFloat2, f3, paramPaint);
        return;
      } 
    } else {
      paramPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(paramFloat1, paramFloat2, f2, paramPaint);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\scatter\CircleShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */