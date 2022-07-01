package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public abstract class PaintDrawable extends Drawable {
  protected Paint a = new Paint();
  
  protected PaintDrawable() {
    this.a.setStyle(Paint.Style.FILL);
    this.a.setAntiAlias(true);
    this.a.setColor(-5592406);
  }
  
  public void a(int paramInt) {
    this.a.setColor(paramInt);
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public void setAlpha(int paramInt) {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\internal\PaintDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */