package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapper {
  static final double a = Math.cos(Math.toRadians(45.0D));
  
  final Paint b;
  
  final Paint c;
  
  final RectF d;
  
  float e;
  
  Path f;
  
  float g;
  
  float h;
  
  float i;
  
  private boolean j;
  
  private final int k;
  
  private final int l;
  
  private final int m;
  
  private boolean n;
  
  private float o;
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return paramBoolean ? (float)((paramFloat1 * 1.5F) + (1.0D - a) * paramFloat2) : (paramFloat1 * 1.5F);
  }
  
  private void a() {
    float f1 = this.e;
    RectF rectF1 = new RectF(-f1, -f1, f1, f1);
    RectF rectF2 = new RectF(rectF1);
    f1 = this.h;
    rectF2.inset(-f1, -f1);
    Path path = this.f;
    if (path == null) {
      this.f = new Path();
    } else {
      path.reset();
    } 
    this.f.setFillType(Path.FillType.EVEN_ODD);
    this.f.moveTo(-this.e, 0.0F);
    this.f.rLineTo(-this.h, 0.0F);
    this.f.arcTo(rectF2, 180.0F, 90.0F, false);
    this.f.arcTo(rectF1, 270.0F, -90.0F, false);
    this.f.close();
    f1 = -rectF2.top;
    if (f1 > 0.0F) {
      float f3 = this.e / f1;
      float f4 = (1.0F - f3) / 2.0F;
      Paint paint1 = this.b;
      int m = this.k;
      int n = this.l;
      int i1 = this.m;
      Shader.TileMode tileMode1 = Shader.TileMode.CLAMP;
      paint1.setShader((Shader)new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, m, n, i1 }, new float[] { 0.0F, f3, f4 + f3, 1.0F }, tileMode1));
    } 
    Paint paint = this.c;
    f1 = rectF1.top;
    float f2 = rectF2.top;
    int i = this.k;
    int j = this.l;
    int k = this.m;
    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
    paint.setShader((Shader)new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, tileMode));
    this.c.setAntiAlias(false);
  }
  
  private void a(Canvas paramCanvas) {
    boolean bool;
    int j = paramCanvas.save();
    paramCanvas.rotate(this.o, this.d.centerX(), this.d.centerY());
    float f3 = this.e;
    float f4 = -f3 - this.h;
    float f1 = this.d.width();
    float f5 = f3 * 2.0F;
    if (f1 - f5 > 0.0F) {
      i = 1;
    } else {
      i = 0;
    } 
    if (this.d.height() - f5 > 0.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    f1 = this.i;
    float f6 = f3 / (f1 - 0.5F * f1 + f3);
    float f2 = f3 / (f1 - 0.25F * f1 + f3);
    f1 = f3 / (f1 - f1 * 1.0F + f3);
    int k = paramCanvas.save();
    paramCanvas.translate(this.d.left + f3, this.d.top + f3);
    paramCanvas.scale(f6, f2);
    paramCanvas.drawPath(this.f, this.b);
    if (i) {
      paramCanvas.scale(1.0F / f6, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.d.width() - f5, -this.e, this.c);
    } 
    paramCanvas.restoreToCount(k);
    k = paramCanvas.save();
    paramCanvas.translate(this.d.right - f3, this.d.bottom - f3);
    paramCanvas.scale(f6, f1);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (i) {
      paramCanvas.scale(1.0F / f6, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.d.width() - f5, -this.e + this.h, this.c);
    } 
    paramCanvas.restoreToCount(k);
    int i = paramCanvas.save();
    paramCanvas.translate(this.d.left + f3, this.d.bottom - f3);
    paramCanvas.scale(f6, f1);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (bool) {
      paramCanvas.scale(1.0F / f1, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.d.height() - f5, -this.e, this.c);
    } 
    paramCanvas.restoreToCount(i);
    i = paramCanvas.save();
    paramCanvas.translate(this.d.right - f3, this.d.top + f3);
    paramCanvas.scale(f6, f2);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (bool) {
      paramCanvas.scale(1.0F / f2, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.d.height() - f5, -this.e, this.c);
    } 
    paramCanvas.restoreToCount(i);
    paramCanvas.restoreToCount(j);
  }
  
  private void a(Rect paramRect) {
    float f = this.g * 1.5F;
    this.d.set(paramRect.left + this.g, paramRect.top + f, paramRect.right - this.g, paramRect.bottom - f);
    getWrappedDrawable().setBounds((int)this.d.left, (int)this.d.top, (int)this.d.right, (int)this.d.bottom);
    a();
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    float f = paramFloat1;
    if (paramBoolean)
      f = (float)(paramFloat1 + (1.0D - a) * paramFloat2); 
    return f;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.j) {
      a(getBounds());
      this.j = false;
    } 
    a(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect) {
    int i = (int)Math.ceil(a(this.g, this.e, this.n));
    int j = (int)Math.ceil(b(this.g, this.e, this.n));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public void onBoundsChange(Rect paramRect) {
    this.j = true;
  }
  
  public void setAlpha(int paramInt) {
    super.setAlpha(paramInt);
    this.b.setAlpha(paramInt);
    this.c.setAlpha(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shadow\ShadowDrawableWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */