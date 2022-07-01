package com.soft.blued.customview.selectabletextview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public class SelectedImageSpan extends ImageSpan {
  public int a = 0;
  
  private WeakReference<Drawable> b;
  
  public SelectedImageSpan(Drawable paramDrawable, int paramInt) {
    super(paramDrawable, paramInt);
  }
  
  private Drawable a() {
    Drawable drawable;
    WeakReference<Drawable> weakReference1 = this.b;
    if (weakReference1 != null) {
      Drawable drawable1 = weakReference1.get();
    } else {
      weakReference1 = null;
    } 
    WeakReference<Drawable> weakReference2 = weakReference1;
    if (weakReference1 == null) {
      drawable = getDrawable();
      this.b = new WeakReference<Drawable>(drawable);
    } 
    return drawable;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {
    if (this.a != 0) {
      Rect rect = a().getBounds();
      paramPaint.setColor(this.a);
      paramCanvas.drawRect(paramFloat, paramInt3, rect.right + paramFloat - rect.left, paramInt5, paramPaint);
    } else {
      paramPaint.setColor(0);
    } 
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\selectabletextview\SelectedImageSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */