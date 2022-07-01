package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.graphics.ColorUtils;

public class ShadowRenderer {
  private static final int[] g = new int[3];
  
  private static final float[] h = new float[] { 0.0F, 0.5F, 1.0F };
  
  private static final int[] i = new int[4];
  
  private static final float[] j = new float[] { 0.0F, 0.0F, 0.5F, 1.0F };
  
  private final Paint a = new Paint();
  
  private final Paint b;
  
  private final Paint c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private final Path k = new Path();
  
  private Paint l = new Paint();
  
  public ShadowRenderer() {
    this(-16777216);
  }
  
  public ShadowRenderer(int paramInt) {
    a(paramInt);
    this.l.setColor(0);
    this.b = new Paint(4);
    this.b.setStyle(Paint.Style.FILL);
    this.c = new Paint(this.b);
  }
  
  public Paint a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.d = ColorUtils.setAlphaComponent(paramInt, 68);
    this.e = ColorUtils.setAlphaComponent(paramInt, 20);
    this.f = ColorUtils.setAlphaComponent(paramInt, 0);
    this.a.setColor(this.d);
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, RectF paramRectF, int paramInt) {
    paramRectF.bottom += paramInt;
    paramRectF.offset(0.0F, -paramInt);
    int[] arrayOfInt = g;
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = this.e;
    arrayOfInt[2] = this.d;
    this.c.setShader((Shader)new LinearGradient(paramRectF.left, paramRectF.top, paramRectF.left, paramRectF.bottom, g, h, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    paramCanvas.drawRect(paramRectF, this.c);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, RectF paramRectF, int paramInt, float paramFloat1, float paramFloat2) {
    boolean bool;
    if (paramFloat2 < 0.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    Path path = this.k;
    if (bool) {
      int[] arrayOfInt = i;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = this.f;
      arrayOfInt[2] = this.e;
      arrayOfInt[3] = this.d;
    } else {
      path.rewind();
      path.moveTo(paramRectF.centerX(), paramRectF.centerY());
      path.arcTo(paramRectF, paramFloat1, paramFloat2);
      path.close();
      float f = -paramInt;
      paramRectF.inset(f, f);
      int[] arrayOfInt = i;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = this.d;
      arrayOfInt[2] = this.e;
      arrayOfInt[3] = this.f;
    } 
    float f1 = paramRectF.width() / 2.0F;
    if (f1 <= 0.0F)
      return; 
    float f2 = 1.0F - paramInt / f1;
    float f3 = (1.0F - f2) / 2.0F;
    float[] arrayOfFloat = j;
    arrayOfFloat[1] = f2;
    arrayOfFloat[2] = f3 + f2;
    this.b.setShader((Shader)new RadialGradient(paramRectF.centerX(), paramRectF.centerY(), f1, i, j, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    if (!bool) {
      paramCanvas.clipPath(path, Region.Op.DIFFERENCE);
      paramCanvas.drawPath(path, this.l);
    } 
    paramCanvas.drawArc(paramRectF, paramFloat1, paramFloat2, true, this.b);
    paramCanvas.restore();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shadow\ShadowRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */