package com.blued.android.framework.ui.markdown.image;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

public class ImageLineSpacingSpan implements LineHeightSpan {
  private final int a;
  
  public ImageLineSpacingSpan(int paramInt) {
    this.a = paramInt;
  }
  
  public void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt) {
    paramFontMetricsInt.top -= this.a;
    paramFontMetricsInt.ascent -= this.a;
    paramFontMetricsInt.descent += this.a;
    paramFontMetricsInt.bottom += this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\markdown\image\ImageLineSpacingSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */