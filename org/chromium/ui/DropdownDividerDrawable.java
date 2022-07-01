package org.chromium.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class DropdownDividerDrawable extends Drawable {
  private final Integer mBackgroundColor;
  
  final Rect mDividerRect = new Rect();
  
  private final Paint mPaint = new Paint();
  
  public DropdownDividerDrawable(Integer paramInteger) {
    this.mBackgroundColor = paramInteger;
  }
  
  public final void draw(Canvas paramCanvas) {
    if (this.mBackgroundColor != null)
      paramCanvas.drawColor(this.mBackgroundColor.intValue()); 
    paramCanvas.drawRect(this.mDividerRect, this.mPaint);
  }
  
  public final int getOpacity() {
    return -2;
  }
  
  public final void onBoundsChange(Rect paramRect) {
    this.mDividerRect.set(0, 0, paramRect.width(), this.mDividerRect.height());
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void setDividerColor(int paramInt) {
    this.mPaint.setColor(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownDividerDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */