package com.blued.android.module.live_china.view.roundimage;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.blued.android.module.live_china.same.Logger;
import java.util.HashSet;

public class RoundedDrawable extends Drawable {
  private final RectF a = new RectF();
  
  private final RectF b = new RectF();
  
  private final RectF c = new RectF();
  
  private final Bitmap d;
  
  private final Paint e;
  
  private final int f;
  
  private final int g;
  
  private final RectF h = new RectF();
  
  private final Paint i;
  
  private final Matrix j = new Matrix();
  
  private final RectF k = new RectF();
  
  private Shader.TileMode l = Shader.TileMode.CLAMP;
  
  private Shader.TileMode m = Shader.TileMode.CLAMP;
  
  private boolean n = true;
  
  private float o = 0.0F;
  
  private final boolean[] p = new boolean[] { true, true, true, true };
  
  private boolean q = false;
  
  private float r = 0.0F;
  
  private ColorStateList s = ColorStateList.valueOf(-16777216);
  
  private ImageView.ScaleType t = ImageView.ScaleType.FIT_CENTER;
  
  public RoundedDrawable(Bitmap paramBitmap) {
    this.d = paramBitmap;
    this.f = paramBitmap.getWidth();
    this.g = paramBitmap.getHeight();
    this.c.set(0.0F, 0.0F, this.f, this.g);
    this.e = new Paint();
    this.e.setStyle(Paint.Style.FILL);
    this.e.setAntiAlias(true);
    this.i = new Paint();
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setAntiAlias(true);
    this.i.setColor(this.s.getColorForState(getState(), -16777216));
    this.i.setStrokeWidth(this.r);
  }
  
  public static Drawable a(Drawable paramDrawable) {
    Drawable drawable = paramDrawable;
    if (paramDrawable != null) {
      LayerDrawable layerDrawable1;
      if (paramDrawable instanceof RoundedDrawable)
        return paramDrawable; 
      if (paramDrawable instanceof LayerDrawable) {
        layerDrawable1 = (LayerDrawable)paramDrawable;
        int j = layerDrawable1.getNumberOfLayers();
        for (int i = 0; i < j; i++) {
          drawable = layerDrawable1.getDrawable(i);
          layerDrawable1.setDrawableByLayerId(layerDrawable1.getId(i), a(drawable));
        } 
        return (Drawable)layerDrawable1;
      } 
      Bitmap bitmap = b((Drawable)layerDrawable1);
      LayerDrawable layerDrawable2 = layerDrawable1;
      if (bitmap != null)
        drawable = new RoundedDrawable(bitmap); 
    } 
    return drawable;
  }
  
  public static RoundedDrawable a(Bitmap paramBitmap) {
    return (paramBitmap != null) ? new RoundedDrawable(paramBitmap) : null;
  }
  
  private void a() {
    int i = null.a[this.t.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 5) {
            if (i != 6) {
              if (i != 7) {
                this.h.set(this.c);
                this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.h);
                RectF rectF = this.h;
                float f = this.r;
                rectF.inset(f / 2.0F, f / 2.0F);
                this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
              } else {
                this.h.set(this.a);
                RectF rectF = this.h;
                float f = this.r;
                rectF.inset(f / 2.0F, f / 2.0F);
                this.j.reset();
                this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
              } 
            } else {
              this.h.set(this.c);
              this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
              this.j.mapRect(this.h);
              RectF rectF = this.h;
              float f = this.r;
              rectF.inset(f / 2.0F, f / 2.0F);
              this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
            } 
          } else {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.h);
            RectF rectF = this.h;
            float f = this.r;
            rectF.inset(f / 2.0F, f / 2.0F);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
          } 
        } else {
          this.j.reset();
          if (this.f <= this.a.width() && this.g <= this.a.height()) {
            f1 = 1.0F;
          } else {
            f1 = Math.min(this.a.width() / this.f, this.a.height() / this.g);
          } 
          float f2 = (int)((this.a.width() - this.f * f1) * 0.5F + 0.5F);
          float f3 = (int)((this.a.height() - this.g * f1) * 0.5F + 0.5F);
          this.j.setScale(f1, f1);
          this.j.postTranslate(f2, f3);
          this.h.set(this.c);
          this.j.mapRect(this.h);
          RectF rectF = this.h;
          float f1 = this.r;
          rectF.inset(f1 / 2.0F, f1 / 2.0F);
          this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } 
      } else {
        this.h.set(this.a);
        RectF rectF = this.h;
        float f1 = this.r;
        rectF.inset(f1 / 2.0F, f1 / 2.0F);
        this.j.reset();
        float f2 = this.f;
        float f3 = this.h.height();
        float f4 = this.h.width();
        float f5 = this.g;
        f1 = 0.0F;
        if (f2 * f3 > f4 * f5) {
          f2 = this.h.height() / this.g;
          f3 = (this.h.width() - this.f * f2) * 0.5F;
        } else {
          f2 = this.h.width() / this.f;
          f1 = (this.h.height() - this.g * f2) * 0.5F;
          f3 = 0.0F;
        } 
        this.j.setScale(f2, f2);
        Matrix matrix = this.j;
        f2 = (int)(f3 + 0.5F);
        f3 = this.r;
        matrix.postTranslate(f2 + f3 / 2.0F, (int)(f1 + 0.5F) + f3 / 2.0F);
      } 
    } else {
      this.h.set(this.a);
      RectF rectF = this.h;
      float f = this.r;
      rectF.inset(f / 2.0F, f / 2.0F);
      this.j.reset();
      this.j.setTranslate((int)((this.h.width() - this.f) * 0.5F + 0.5F), (int)((this.h.height() - this.g) * 0.5F + 0.5F));
    } 
    this.b.set(this.h);
  }
  
  private void a(Canvas paramCanvas) {
    if (b(this.p))
      return; 
    if (this.o == 0.0F)
      return; 
    float f1 = this.b.left;
    float f2 = this.b.top;
    float f3 = this.b.width() + f1;
    float f4 = this.b.height() + f2;
    float f5 = this.o;
    if (!this.p[0]) {
      this.k.set(f1, f2, f1 + f5, f2 + f5);
      paramCanvas.drawRect(this.k, this.e);
    } 
    if (!this.p[1]) {
      this.k.set(f3 - f5, f2, f3, f5);
      paramCanvas.drawRect(this.k, this.e);
    } 
    if (!this.p[2]) {
      this.k.set(f3 - f5, f4 - f5, f3, f4);
      paramCanvas.drawRect(this.k, this.e);
    } 
    if (!this.p[3]) {
      this.k.set(f1, f4 - f5, f5 + f1, f4);
      paramCanvas.drawRect(this.k, this.e);
    } 
  }
  
  private static boolean a(boolean[] paramArrayOfboolean) {
    int j = paramArrayOfboolean.length;
    for (int i = 0; i < j; i++) {
      if (paramArrayOfboolean[i])
        return true; 
    } 
    return false;
  }
  
  public static Bitmap b(Drawable paramDrawable) {
    if (paramDrawable instanceof BitmapDrawable)
      return ((BitmapDrawable)paramDrawable).getBitmap(); 
    int i = Math.max(paramDrawable.getIntrinsicWidth(), 2);
    int j = Math.max(paramDrawable.getIntrinsicHeight(), 2);
    try {
      Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      paramDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
      paramDrawable.draw(canvas);
      return bitmap;
    } catch (Exception exception) {
      exception.printStackTrace();
      Logger.c("RoundedDrawable", new Object[] { "Failed to create bitmap from drawable!" });
      return null;
    } 
  }
  
  private void b(Canvas paramCanvas) {
    if (b(this.p))
      return; 
    if (this.o == 0.0F)
      return; 
    float f1 = this.b.left;
    float f2 = this.b.top;
    float f3 = f1 + this.b.width();
    float f4 = f2 + this.b.height();
    float f5 = this.o;
    float f6 = this.r / 2.0F;
    if (!this.p[0]) {
      paramCanvas.drawLine(f1 - f6, f2, f1 + f5, f2, this.i);
      paramCanvas.drawLine(f1, f2 - f6, f1, f2 + f5, this.i);
    } 
    if (!this.p[1]) {
      paramCanvas.drawLine(f3 - f5 - f6, f2, f3, f2, this.i);
      paramCanvas.drawLine(f3, f2 - f6, f3, f2 + f5, this.i);
    } 
    if (!this.p[2]) {
      paramCanvas.drawLine(f3 - f5 - f6, f4, f3 + f6, f4, this.i);
      paramCanvas.drawLine(f3, f4 - f5, f3, f4, this.i);
    } 
    if (!this.p[3]) {
      paramCanvas.drawLine(f1 - f6, f4, f1 + f5, f4, this.i);
      paramCanvas.drawLine(f1, f4 - f5, f1, f4, this.i);
    } 
  }
  
  private static boolean b(boolean[] paramArrayOfboolean) {
    int j = paramArrayOfboolean.length;
    for (int i = 0; i < j; i++) {
      if (paramArrayOfboolean[i])
        return false; 
    } 
    return true;
  }
  
  public RoundedDrawable a(float paramFloat) {
    this.r = paramFloat;
    this.i.setStrokeWidth(this.r);
    return this;
  }
  
  public RoundedDrawable a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    HashSet<Float> hashSet = new HashSet(4);
    hashSet.add(Float.valueOf(paramFloat1));
    hashSet.add(Float.valueOf(paramFloat2));
    hashSet.add(Float.valueOf(paramFloat3));
    hashSet.add(Float.valueOf(paramFloat4));
    hashSet.remove(Float.valueOf(0.0F));
    if (hashSet.size() <= 1) {
      if (!hashSet.isEmpty()) {
        float f = ((Float)hashSet.iterator().next()).floatValue();
        if (!Float.isInfinite(f) && !Float.isNaN(f) && f >= 0.0F) {
          this.o = f;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid radius value: ");
          stringBuilder.append(f);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } else {
        this.o = 0.0F;
      } 
      boolean[] arrayOfBoolean = this.p;
      boolean bool2 = false;
      if (paramFloat1 > 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      arrayOfBoolean[0] = bool1;
      arrayOfBoolean = this.p;
      if (paramFloat2 > 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      arrayOfBoolean[1] = bool1;
      arrayOfBoolean = this.p;
      if (paramFloat3 > 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      arrayOfBoolean[2] = bool1;
      arrayOfBoolean = this.p;
      boolean bool1 = bool2;
      if (paramFloat4 > 0.0F)
        bool1 = true; 
      arrayOfBoolean[3] = bool1;
      return this;
    } 
    throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
  }
  
  public RoundedDrawable a(ColorStateList paramColorStateList) {
    if (paramColorStateList == null)
      paramColorStateList = ColorStateList.valueOf(0); 
    this.s = paramColorStateList;
    this.i.setColor(this.s.getColorForState(getState(), -16777216));
    return this;
  }
  
  public RoundedDrawable a(Shader.TileMode paramTileMode) {
    if (this.l != paramTileMode) {
      this.l = paramTileMode;
      this.n = true;
      invalidateSelf();
    } 
    return this;
  }
  
  public RoundedDrawable a(ImageView.ScaleType paramScaleType) {
    ImageView.ScaleType scaleType = paramScaleType;
    if (paramScaleType == null)
      scaleType = ImageView.ScaleType.FIT_CENTER; 
    if (this.t != scaleType) {
      this.t = scaleType;
      a();
    } 
    return this;
  }
  
  public RoundedDrawable a(boolean paramBoolean) {
    this.q = paramBoolean;
    return this;
  }
  
  public RoundedDrawable b(Shader.TileMode paramTileMode) {
    if (this.m != paramTileMode) {
      this.m = paramTileMode;
      this.n = true;
      invalidateSelf();
    } 
    return this;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.n) {
      BitmapShader bitmapShader = new BitmapShader(this.d, this.l, this.m);
      if (this.l == Shader.TileMode.CLAMP && this.m == Shader.TileMode.CLAMP)
        bitmapShader.setLocalMatrix(this.j); 
      this.e.setShader((Shader)bitmapShader);
      this.n = false;
    } 
    if (this.q) {
      if (this.r > 0.0F) {
        paramCanvas.drawOval(this.b, this.e);
        paramCanvas.drawOval(this.h, this.i);
        return;
      } 
      paramCanvas.drawOval(this.b, this.e);
      return;
    } 
    if (a(this.p)) {
      float f = this.o;
      if (this.r > 0.0F) {
        paramCanvas.drawRoundRect(this.b, f, f, this.e);
        paramCanvas.drawRoundRect(this.h, f, f, this.i);
        a(paramCanvas);
        b(paramCanvas);
        return;
      } 
      paramCanvas.drawRoundRect(this.b, f, f, this.e);
      a(paramCanvas);
      return;
    } 
    paramCanvas.drawRect(this.b, this.e);
    if (this.r > 0.0F)
      paramCanvas.drawRect(this.h, this.i); 
  }
  
  public int getAlpha() {
    return this.e.getAlpha();
  }
  
  public ColorFilter getColorFilter() {
    return this.e.getColorFilter();
  }
  
  public int getIntrinsicHeight() {
    return this.g;
  }
  
  public int getIntrinsicWidth() {
    return this.f;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public boolean isStateful() {
    return this.s.isStateful();
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    this.a.set(paramRect);
    a();
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    int i = this.s.getColorForState(paramArrayOfint, 0);
    if (this.i.getColor() != i) {
      this.i.setColor(i);
      return true;
    } 
    return super.onStateChange(paramArrayOfint);
  }
  
  public void setAlpha(int paramInt) {
    this.e.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.e.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean) {
    this.e.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean) {
    this.e.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\roundimage\RoundedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */