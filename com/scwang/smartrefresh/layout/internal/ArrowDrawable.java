package com.scwang.smartrefresh.layout.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

public class ArrowDrawable extends PaintDrawable {
  private int b = 0;
  
  private int c = 0;
  
  private Path d = new Path();
  
  public void draw(Canvas paramCanvas) {
    Rect rect = getBounds();
    int i = rect.width();
    int j = rect.height();
    if (this.b != i || this.c != j) {
      int m = i * 30 / 225;
      this.d.reset();
      double d = m;
      float f1 = (float)(Math.sin(0.7853981633974483D) * d);
      float f4 = (float)(d / Math.sin(0.7853981633974483D));
      Path path = this.d;
      int k = i / 2;
      float f2 = k;
      float f5 = j;
      path.moveTo(f2, f5);
      path = this.d;
      f2 = (j / 2);
      path.lineTo(0.0F, f2);
      path = this.d;
      float f3 = f2 - f1;
      path.lineTo(f1, f3);
      path = this.d;
      m /= 2;
      float f6 = (k - m);
      f4 = f5 - f4 - m;
      path.lineTo(f6, f4);
      this.d.lineTo(f6, 0.0F);
      path = this.d;
      f5 = (k + m);
      path.lineTo(f5, 0.0F);
      this.d.lineTo(f5, f4);
      path = this.d;
      f4 = i;
      path.lineTo(f4 - f1, f3);
      this.d.lineTo(f4, f2);
      this.d.close();
      this.b = i;
      this.c = j;
    } 
    paramCanvas.drawPath(this.d, this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\internal\ArrowDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */