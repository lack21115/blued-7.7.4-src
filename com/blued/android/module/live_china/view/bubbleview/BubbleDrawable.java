package com.blued.android.module.live_china.view.bubbleview;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class BubbleDrawable extends Drawable {
  private RectF a;
  
  private Path b = new Path();
  
  private BitmapShader c;
  
  private Paint d = new Paint(1);
  
  private float e;
  
  private float f;
  
  private float g;
  
  private float h;
  
  private int i;
  
  private Bitmap j;
  
  private ArrowLocation k;
  
  private BubbleType l;
  
  private boolean m;
  
  private BubbleDrawable(Builder paramBuilder) {
    this.a = Builder.a(paramBuilder);
    this.f = Builder.b(paramBuilder);
    this.g = Builder.c(paramBuilder);
    this.e = Builder.d(paramBuilder);
    this.h = Builder.e(paramBuilder);
    this.i = Builder.f(paramBuilder);
    this.j = Builder.g(paramBuilder);
    this.k = Builder.h(paramBuilder);
    this.l = Builder.i(paramBuilder);
    this.m = Builder.j(paramBuilder);
  }
  
  private void a() {
    Matrix matrix = new Matrix();
    matrix.set(null);
    int i = this.j.getWidth();
    int j = this.j.getHeight();
    matrix.postScale(getIntrinsicWidth() / i, getIntrinsicHeight() / j);
    matrix.postTranslate(this.a.left, this.a.top);
    this.c.setLocalMatrix(matrix);
  }
  
  private void a(Canvas paramCanvas) {
    int i = null.b[this.l.ordinal()];
    if (i != 1) {
      if (i == 2) {
        Bitmap bitmap = this.j;
        if (bitmap == null)
          return; 
        if (this.c == null)
          this.c = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP); 
        this.d.setShader((Shader)this.c);
        a();
      } 
    } else {
      this.d.setColor(this.i);
    } 
    a(this.k, this.b);
    paramCanvas.drawPath(this.b, this.d);
  }
  
  private void a(RectF paramRectF, Path paramPath) {
    if (this.m)
      this.h = (paramRectF.bottom - paramRectF.top) / 2.0F - this.e / 2.0F; 
    paramPath.moveTo(this.e + paramRectF.left + this.f, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.f, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.top, paramRectF.right, this.f + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.f);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.bottom - this.f, paramRectF.right, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.e + this.f, paramRectF.bottom);
    float f1 = paramRectF.left;
    float f2 = this.e;
    float f3 = paramRectF.bottom;
    float f4 = this.f;
    paramPath.arcTo(new RectF(f1 + f2, f3 - f4, f4 + paramRectF.left + this.e, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.e, this.g + this.h);
    paramPath.lineTo(paramRectF.left, this.h + this.g / 2.0F);
    paramPath.lineTo(paramRectF.left + this.e, this.h);
    paramPath.lineTo(paramRectF.left + this.e, paramRectF.top + this.f);
    paramPath.arcTo(new RectF(paramRectF.left + this.e, paramRectF.top, this.f + paramRectF.left + this.e, this.f + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void a(ArrowLocation paramArrowLocation, Path paramPath) {
    int i = null.a[paramArrowLocation.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          d(this.a, paramPath);
          return;
        } 
        b(this.a, paramPath);
        return;
      } 
      c(this.a, paramPath);
      return;
    } 
    a(this.a, paramPath);
  }
  
  private void b(RectF paramRectF, Path paramPath) {
    if (this.m)
      this.h = (paramRectF.right - paramRectF.left) / 2.0F - this.e / 2.0F; 
    paramPath.moveTo(paramRectF.left + Math.min(this.h, this.f), paramRectF.top + this.g);
    paramPath.lineTo(paramRectF.left + this.h, paramRectF.top + this.g);
    paramPath.lineTo(paramRectF.left + this.e / 2.0F + this.h, paramRectF.top);
    paramPath.lineTo(paramRectF.left + this.e + this.h, paramRectF.top + this.g);
    paramPath.lineTo(paramRectF.right - this.f, paramRectF.top + this.g);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.top + this.g, paramRectF.right, this.f + paramRectF.top + this.g), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.f);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.bottom - this.f, paramRectF.right, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.f, paramRectF.bottom);
    float f1 = paramRectF.left;
    float f2 = paramRectF.bottom;
    float f3 = this.f;
    paramPath.arcTo(new RectF(f1, f2 - f3, f3 + paramRectF.left, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left, paramRectF.top + this.g + this.f);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top + this.g, this.f + paramRectF.left, this.f + paramRectF.top + this.g), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void c(RectF paramRectF, Path paramPath) {
    if (this.m)
      this.h = (paramRectF.bottom - paramRectF.top) / 2.0F - this.e / 2.0F; 
    paramPath.moveTo(paramRectF.left + this.f, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.f - this.e, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.f - this.e, paramRectF.top, paramRectF.right - this.e, this.f + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right - this.e, this.h);
    paramPath.lineTo(paramRectF.right, this.h + this.g / 2.0F);
    paramPath.lineTo(paramRectF.right - this.e, this.h + this.g);
    paramPath.lineTo(paramRectF.right - this.e, paramRectF.bottom - this.f);
    paramPath.arcTo(new RectF(paramRectF.right - this.f - this.e, paramRectF.bottom - this.f, paramRectF.right - this.e, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.e, paramRectF.bottom);
    float f1 = paramRectF.left;
    float f2 = paramRectF.bottom;
    float f3 = this.f;
    paramPath.arcTo(new RectF(f1, f2 - f3, f3 + paramRectF.left, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.f + paramRectF.left, this.f + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void d(RectF paramRectF, Path paramPath) {
    if (this.m)
      this.h = (paramRectF.right - paramRectF.left) / 2.0F - this.e / 2.0F; 
    paramPath.moveTo(paramRectF.left + this.f, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.f, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.top, paramRectF.right, this.f + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.g - this.f);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.bottom - this.f - this.g, paramRectF.right, paramRectF.bottom - this.g), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.e + this.h, paramRectF.bottom - this.g);
    paramPath.lineTo(paramRectF.left + this.h + this.e / 2.0F, paramRectF.bottom);
    paramPath.lineTo(paramRectF.left + this.h, paramRectF.bottom - this.g);
    paramPath.lineTo(paramRectF.left + Math.min(this.f, this.h), paramRectF.bottom - this.g);
    float f1 = paramRectF.left;
    float f2 = paramRectF.bottom;
    float f3 = this.f;
    paramPath.arcTo(new RectF(f1, f2 - f3 - this.g, f3 + paramRectF.left, paramRectF.bottom - this.g), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left, paramRectF.top + this.f);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.f + paramRectF.left, this.f + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  public void draw(Canvas paramCanvas) {
    a(paramCanvas);
  }
  
  public int getIntrinsicHeight() {
    return (int)this.a.height();
  }
  
  public int getIntrinsicWidth() {
    return (int)this.a.width();
  }
  
  public int getOpacity() {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt) {
    this.d.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.d.setColorFilter(paramColorFilter);
  }
  
  public enum ArrowLocation {
    a(0),
    b(1),
    c(2),
    d(3);
    
    private int e;
    
    ArrowLocation(int param1Int1) {
      this.e = param1Int1;
    }
    
    public static ArrowLocation a() {
      return a;
    }
    
    public static ArrowLocation a(int param1Int) {
      for (ArrowLocation arrowLocation : values()) {
        if (param1Int == arrowLocation.b())
          return arrowLocation; 
      } 
      return a();
    }
    
    public int b() {
      return this.e;
    }
  }
  
  public enum BubbleType {
    a, b;
  }
  
  public static class Builder {
    public static float a = 25.0F;
    
    public static float b = 25.0F;
    
    public static float c = 20.0F;
    
    public static float d = 50.0F;
    
    public static int e = -65536;
    
    private RectF f;
    
    private float g = a;
    
    private float h = c;
    
    private float i = b;
    
    private float j = d;
    
    private int k = e;
    
    private Bitmap l;
    
    private BubbleDrawable.BubbleType m = BubbleDrawable.BubbleType.a;
    
    private BubbleDrawable.ArrowLocation n = BubbleDrawable.ArrowLocation.a;
    
    private boolean o;
    
    public Builder a(float param1Float) {
      this.g = param1Float;
      return this;
    }
    
    public Builder a(int param1Int) {
      this.k = param1Int;
      a(BubbleDrawable.BubbleType.a);
      return this;
    }
    
    public Builder a(RectF param1RectF) {
      this.f = param1RectF;
      return this;
    }
    
    public Builder a(BubbleDrawable.ArrowLocation param1ArrowLocation) {
      this.n = param1ArrowLocation;
      return this;
    }
    
    public Builder a(BubbleDrawable.BubbleType param1BubbleType) {
      this.m = param1BubbleType;
      return this;
    }
    
    public Builder a(boolean param1Boolean) {
      this.o = param1Boolean;
      return this;
    }
    
    public BubbleDrawable a() {
      if (this.f != null)
        return new BubbleDrawable(this); 
      throw new IllegalArgumentException("BubbleDrawable Rect can not be null");
    }
    
    public Builder b(float param1Float) {
      this.h = param1Float * 2.0F;
      return this;
    }
    
    public Builder c(float param1Float) {
      this.i = param1Float;
      return this;
    }
    
    public Builder d(float param1Float) {
      this.j = param1Float;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\bubbleview\BubbleDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */