package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

public class EllipSizeText extends TextView {
  private boolean a = false;
  
  public EllipSizeText(Context paramContext) {
    super(paramContext);
  }
  
  public EllipSizeText(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a() {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    try {
      CharSequence charSequence = getText();
      i = getLayout().getLineCount();
      int k = getMaxLines();
      if (k <= i)
        i = k; 
    } catch (Exception exception) {
      exception.printStackTrace();
      super.onDraw(paramCanvas);
      return;
    } 
    int j = i;
    if (i <= 0)
      j = 1; 
    int i = getLayout().getLineVisibleEnd(j - 1);
    if (exception != null && exception.length() > i) {
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
      spannableStringBuilder.append(exception.subSequence(0, i - 4)).append("...");
      setText((CharSequence)spannableStringBuilder);
      this.a = true;
    } 
    super.onDraw(paramCanvas);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\EllipSizeText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */