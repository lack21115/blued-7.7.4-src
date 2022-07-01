package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ChevronDownShapeRenderer implements IShapeRenderer {
  public void a(Canvas paramCanvas, IScatterDataSet paramIScatterDataSet, ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Paint paramPaint) {
    float f1 = paramIScatterDataSet.a() / 2.0F;
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setStrokeWidth(Utils.a(1.0F));
    f1 *= 2.0F;
    float f2 = paramFloat2 + f1;
    paramCanvas.drawLine(paramFloat1, f2, paramFloat1 + f1, paramFloat2, paramPaint);
    paramCanvas.drawLine(paramFloat1, f2, paramFloat1 - f1, paramFloat2, paramPaint);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\scatter\ChevronDownShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */