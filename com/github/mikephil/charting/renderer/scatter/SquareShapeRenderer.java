package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class SquareShapeRenderer implements IShapeRenderer {
  public void a(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet, ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Paint paramPaint) {
    float f3 = paramIScatterDataSet.a();
    float f4 = f3 / 2.0F;
    float f2 = Utils.a(paramIScatterDataSet.c());
    float f5 = (f3 - f2 * 2.0F) / 2.0F;
    float f1 = f5 / 2.0F;
    int i = paramIScatterDataSet.d();
    if (f3 > 0.0D) {
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setStrokeWidth(f5);
      f3 = paramFloat1 - f2;
      f4 = paramFloat2 - f2;
      paramFloat1 += f2;
      paramFloat2 += f2;
      paramCanvas.drawRect(f3 - f1, f4 - f1, paramFloat1 + f1, paramFloat2 + f1, paramPaint);
      if (i != 1122867) {
        paramPaint.setStyle(Paint.Style.FILL);
        paramPaint.setColor(i);
        paramCanvas.drawRect(f3, f4, paramFloat1, paramFloat2, paramPaint);
        return;
      } 
    } else {
      paramPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(paramFloat1 - f4, paramFloat2 - f4, paramFloat1 + f4, paramFloat2 + f4, paramPaint);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\scatter\SquareShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */