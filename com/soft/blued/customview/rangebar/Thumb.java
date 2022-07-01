package com.soft.blued.customview.rangebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

class Thumb {
  private final float a;
  
  private final Bitmap b;
  
  private final Bitmap c;
  
  private final float d;
  
  private final float e;
  
  private final float f;
  
  private final float g;
  
  private boolean h = false;
  
  private final float i;
  
  private float j;
  
  private Paint k;
  
  private Paint l;
  
  private float m;
  
  private boolean n;
  
  private int o;
  
  private int p;
  
  Thumb(Context paramContext, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4) {
    Resources resources = paramContext.getResources();
    this.b = BitmapFactory.decodeResource(resources, paramInt3);
    this.c = BitmapFactory.decodeResource(resources, paramInt4);
    paramInt3 = paramFloat2 cmp -1.0F;
    if (paramInt3 == 0 && paramInt1 == -1 && paramInt2 == -1) {
      this.n = true;
    } else {
      this.n = false;
      if (paramInt3 == 0) {
        this.m = TypedValue.applyDimension(1, 14.0F, resources.getDisplayMetrics());
      } else {
        this.m = TypedValue.applyDimension(1, paramFloat2, resources.getDisplayMetrics());
      } 
      if (paramInt1 == -1) {
        this.o = -13388315;
      } else {
        this.o = paramInt1;
      } 
      if (paramInt2 == -1) {
        this.p = -13388315;
      } else {
        this.p = paramInt2;
      } 
      this.k = new Paint();
      this.k.setColor(this.o);
      this.k.setAntiAlias(true);
      this.l = new Paint();
      this.l.setColor(this.p);
      this.l.setAntiAlias(true);
    } 
    this.d = this.b.getWidth() / 2.0F;
    this.e = this.b.getHeight() / 2.0F;
    this.f = this.c.getWidth() / 2.0F;
    this.g = this.c.getHeight() / 2.0F;
    this.a = TypedValue.applyDimension(1, (int)Math.max(24.0F, paramFloat2), resources.getDisplayMetrics());
    this.j = this.d;
    this.i = paramFloat1;
  }
  
  float a() {
    return this.d;
  }
  
  void a(float paramFloat) {
    this.j = paramFloat;
  }
  
  void a(Canvas paramCanvas) {
    if (this.n) {
      Bitmap bitmap;
      if (this.h) {
        bitmap = this.c;
      } else {
        bitmap = this.b;
      } 
      if (this.h) {
        float f3 = this.i;
        float f4 = this.g;
        paramCanvas.drawBitmap(bitmap, this.j - this.f, f3 - f4, null);
        return;
      } 
      float f1 = this.i;
      float f2 = this.e;
      paramCanvas.drawBitmap(bitmap, this.j - this.d, f1 - f2, null);
      return;
    } 
    if (this.h) {
      paramCanvas.drawCircle(this.j, this.i, this.m, this.l);
      return;
    } 
    paramCanvas.drawCircle(this.j, this.i, this.m, this.k);
  }
  
  boolean a(float paramFloat1, float paramFloat2) {
    return (Math.abs(paramFloat1 - this.j) <= this.a && Math.abs(paramFloat2 - this.i) <= this.a);
  }
  
  float b() {
    return this.j;
  }
  
  boolean c() {
    return this.h;
  }
  
  void d() {
    this.h = true;
  }
  
  void e() {
    this.h = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\rangebar\Thumb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */