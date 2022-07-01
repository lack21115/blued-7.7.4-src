package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class b extends View {
  private Rect a;
  
  private Paint b;
  
  public b(Context paramContext) {
    super(paramContext);
    b();
  }
  
  private void b() {
    this.b = new Paint();
  }
  
  public Rect a() {
    if (this.a == null) {
      this.a = new Rect();
      int k = getMeasuredWidth();
      int j = getMeasuredHeight();
      int i = Math.min(Math.min(j - 60 - 80, k), 640);
      k = (k - i) / 2;
      j = (j - i) / 2;
      this.a.set(k, j, k + i, i + j);
    } 
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    Rect rect = a();
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(Color.argb(100, 0, 0, 0));
    float f = i;
    paramCanvas.drawRect(0.0F, 0.0F, f, rect.top, this.b);
    paramCanvas.drawRect(0.0F, rect.bottom, f, j, this.b);
    paramCanvas.drawRect(0.0F, rect.top, rect.left, rect.bottom, this.b);
    paramCanvas.drawRect(rect.right, rect.top, f, rect.bottom, this.b);
    paramCanvas.drawColor(Color.argb(100, 0, 0, 0));
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(-1);
    paramCanvas.drawRect(rect.left, rect.top, (rect.right - 1), rect.bottom, this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\avatar\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */