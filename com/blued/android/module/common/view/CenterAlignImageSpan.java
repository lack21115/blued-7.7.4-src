package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class CenterAlignImageSpan extends ImageSpan {
  public CenterAlignImageSpan(Context paramContext, Bitmap paramBitmap) {
    super(paramContext, paramBitmap);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {
    Drawable drawable = getDrawable();
    paramCanvas.save();
    Paint.FontMetricsInt fontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = fontMetricsInt.descent;
    paramInt2 = fontMetricsInt.ascent;
    paramCanvas.translate(paramFloat, (paramInt4 + fontMetricsInt.descent - (paramInt1 - paramInt2) / 2 - ((drawable.getBounds()).bottom - (drawable.getBounds()).top) / 2));
    drawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt) {
    Rect rect = getDrawable().getBounds();
    if (paramFontMetricsInt != null) {
      Paint.FontMetricsInt fontMetricsInt = paramPaint.getFontMetricsInt();
      int i = fontMetricsInt.descent;
      int j = fontMetricsInt.ascent;
      paramInt1 = rect.bottom;
      paramInt2 = rect.top;
      i = fontMetricsInt.ascent + (i - j) / 2;
      paramInt1 = (paramInt1 - paramInt2) / 2;
      paramFontMetricsInt.ascent = i - paramInt1;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = i + paramInt1;
      paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
    } 
    return rect.right;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\CenterAlignImageSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */