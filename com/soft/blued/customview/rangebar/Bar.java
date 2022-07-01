package com.soft.blued.customview.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

class Bar {
  private final Paint a;
  
  private final float b;
  
  private final float c;
  
  private final float d;
  
  private int e;
  
  private float f;
  
  private final float g;
  
  private final float h;
  
  private final float i;
  
  Bar(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, float paramFloat4, float paramFloat5, int paramInt2) {
    this.b = paramFloat1;
    this.c = paramFloat1 + paramFloat3;
    this.d = paramFloat2;
    this.e = paramInt1 - 1;
    this.f = paramFloat3 / this.e;
    this.g = TypedValue.applyDimension(1, paramFloat4, paramContext.getResources().getDisplayMetrics());
    paramFloat1 = this.d;
    paramFloat2 = this.g;
    this.h = paramFloat1 - paramFloat2 / 2.0F;
    this.i = paramFloat1 + paramFloat2 / 2.0F;
    this.a = new Paint();
    this.a.setColor(paramInt2);
    this.a.setStrokeWidth(paramFloat5);
    this.a.setAntiAlias(true);
  }
  
  private void b(Canvas paramCanvas) {
    for (int i = 0; i < this.e; i++) {
      float f1 = i * this.f + this.b;
      paramCanvas.drawLine(f1, this.h, f1, this.i, this.a);
    } 
    float f = this.c;
    paramCanvas.drawLine(f, this.h, f, this.i, this.a);
  }
  
  float a() {
    return this.b;
  }
  
  float a(Thumb paramThumb) {
    int i = b(paramThumb);
    float f2 = this.b + i * this.f;
    if (f2 < a())
      return a(); 
    float f1 = f2;
    if (f2 > b())
      f1 = b(); 
    return f1;
  }
  
  void a(Canvas paramCanvas) {
    float f1 = this.b;
    float f2 = this.d;
    paramCanvas.drawLine(f1, f2, this.c, f2, this.a);
    b(paramCanvas);
  }
  
  float b() {
    return this.c;
  }
  
  int b(Thumb paramThumb) {
    float f1 = paramThumb.b();
    float f2 = this.b;
    float f3 = this.f;
    return (int)((f1 - f2 + f3 / 2.0F) / f3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\rangebar\Bar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */