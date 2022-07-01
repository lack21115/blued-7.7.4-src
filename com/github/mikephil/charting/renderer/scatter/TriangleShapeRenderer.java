package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class TriangleShapeRenderer implements IShapeRenderer {
  protected Path a = new Path();
  
  public void a(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet, ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Paint paramPaint) {
    float f5 = paramIScatterDataSet.a();
    float f4 = f5 / 2.0F;
    float f1 = (f5 - Utils.a(paramIScatterDataSet.c()) * 2.0F) / 2.0F;
    int i = paramIScatterDataSet.d();
    paramPaint.setStyle(Paint.Style.FILL);
    Path path = this.a;
    path.reset();
    float f3 = paramFloat2 - f4;
    path.moveTo(paramFloat1, f3);
    float f2 = paramFloat1 + f4;
    paramFloat2 += f4;
    path.lineTo(f2, paramFloat2);
    f4 = paramFloat1 - f4;
    path.lineTo(f4, paramFloat2);
    int j = f5 cmp 0.0D;
    if (j > 0) {
      path.lineTo(paramFloat1, f3);
      f5 = f4 + f1;
      float f = paramFloat2 - f1;
      path.moveTo(f5, f);
      path.lineTo(f2 - f1, f);
      path.lineTo(paramFloat1, f3 + f1);
      path.lineTo(f5, f);
    } 
    path.close();
    paramCanvas.drawPath(path, paramPaint);
    path.reset();
    if (j > 0 && i != 1122867) {
      paramPaint.setColor(i);
      path.moveTo(paramFloat1, f3 + f1);
      paramFloat1 = paramFloat2 - f1;
      path.lineTo(f2 - f1, paramFloat1);
      path.lineTo(f4 + f1, paramFloat1);
      path.close();
      paramCanvas.drawPath(path, paramPaint);
      path.reset();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\scatter\TriangleShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */