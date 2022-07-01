package org.chromium.components.embedder_support.delegate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

public class ColorPickerMoreButton extends Button {
  private Paint mBorderPaint;
  
  public ColorPickerMoreButton(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ColorPickerMoreButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init() {
    this.mBorderPaint = new Paint();
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setColor(-1);
    this.mBorderPaint.setStrokeWidth(1.0F);
    this.mBorderPaint.setAntiAlias(false);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    paramCanvas.drawRect(0.5F, 0.5F, getWidth() - 1.5F, getHeight() - 1.5F, this.mBorderPaint);
    super.onDraw(paramCanvas);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\embedder_support\delegate\ColorPickerMoreButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */