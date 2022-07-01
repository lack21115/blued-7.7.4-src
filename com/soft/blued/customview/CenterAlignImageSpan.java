package com.soft.blued.customview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class CenterAlignImageSpan extends ImageSpan {
  public CenterAlignImageSpan(Drawable paramDrawable) {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {
    Drawable drawable = getDrawable();
    Paint.FontMetricsInt fontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = (fontMetricsInt.descent + paramInt4 + paramInt4 + fontMetricsInt.ascent) / 2;
    paramInt2 = (drawable.getBounds()).bottom / 2;
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt1 - paramInt2));
    drawable.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CenterAlignImageSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */