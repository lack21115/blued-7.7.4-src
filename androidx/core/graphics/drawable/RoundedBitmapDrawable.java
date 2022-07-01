package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public abstract class RoundedBitmapDrawable extends Drawable {
  final Bitmap a;
  
  final Rect b = new Rect();
  
  private int c = 160;
  
  private int d = 119;
  
  private final Paint e = new Paint(3);
  
  private final BitmapShader f;
  
  private final Matrix g = new Matrix();
  
  private float h;
  
  private final RectF i = new RectF();
  
  private boolean j = true;
  
  private boolean k;
  
  private int l;
  
  private int m;
  
  RoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap) {
    if (paramResources != null)
      this.c = (paramResources.getDisplayMetrics()).densityDpi; 
    this.a = paramBitmap;
    if (this.a != null) {
      b();
      this.f = new BitmapShader(this.a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    } 
    this.m = -1;
    this.l = -1;
    this.f = null;
  }
  
  private static boolean a(float paramFloat) {
    return (paramFloat > 0.05F);
  }
  
  private void b() {
    this.l = this.a.getScaledWidth(this.c);
    this.m = this.a.getScaledHeight(this.c);
  }
  
  private void c() {
    this.h = (Math.min(this.m, this.l) / 2);
  }
  
  void a() {
    if (this.j) {
      if (this.k) {
        int i = Math.min(this.l, this.m);
        a(this.d, i, i, getBounds(), this.b);
        i = Math.min(this.b.width(), this.b.height());
        int j = Math.max(0, (this.b.width() - i) / 2);
        int k = Math.max(0, (this.b.height() - i) / 2);
        this.b.inset(j, k);
        this.h = i * 0.5F;
      } else {
        a(this.d, this.l, this.m, getBounds(), this.b);
      } 
      this.i.set(this.b);
      if (this.f != null) {
        this.g.setTranslate(this.i.left, this.i.top);
        this.g.preScale(this.i.width() / this.a.getWidth(), this.i.height() / this.a.getHeight());
        this.f.setLocalMatrix(this.g);
        this.e.setShader((Shader)this.f);
      } 
      this.j = false;
    } 
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2) {
    throw new UnsupportedOperationException();
  }
  
  public void draw(Canvas paramCanvas) {
    Bitmap bitmap = this.a;
    if (bitmap == null)
      return; 
    a();
    if (this.e.getShader() == null) {
      paramCanvas.drawBitmap(bitmap, null, this.b, this.e);
      return;
    } 
    RectF rectF = this.i;
    float f = this.h;
    paramCanvas.drawRoundRect(rectF, f, f, this.e);
  }
  
  public int getAlpha() {
    return this.e.getAlpha();
  }
  
  public final Bitmap getBitmap() {
    return this.a;
  }
  
  public ColorFilter getColorFilter() {
    return this.e.getColorFilter();
  }
  
  public float getCornerRadius() {
    return this.h;
  }
  
  public int getGravity() {
    return this.d;
  }
  
  public int getIntrinsicHeight() {
    return this.m;
  }
  
  public int getIntrinsicWidth() {
    return this.l;
  }
  
  public int getOpacity() {
    int i = this.d;
    byte b2 = -3;
    byte b1 = b2;
    if (i == 119) {
      if (this.k)
        return -3; 
      Bitmap bitmap = this.a;
      b1 = b2;
      if (bitmap != null) {
        b1 = b2;
        if (!bitmap.hasAlpha()) {
          b1 = b2;
          if (this.e.getAlpha() >= 255) {
            if (a(this.h))
              return -3; 
            b1 = -1;
          } 
        } 
      } 
    } 
    return b1;
  }
  
  public final Paint getPaint() {
    return this.e;
  }
  
  public boolean hasAntiAlias() {
    return this.e.isAntiAlias();
  }
  
  public boolean hasMipMap() {
    throw new UnsupportedOperationException();
  }
  
  public boolean isCircular() {
    return this.k;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    if (this.k)
      c(); 
    this.j = true;
  }
  
  public void setAlpha(int paramInt) {
    if (paramInt != this.e.getAlpha()) {
      this.e.setAlpha(paramInt);
      invalidateSelf();
    } 
  }
  
  public void setAntiAlias(boolean paramBoolean) {
    this.e.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  public void setCircular(boolean paramBoolean) {
    this.k = paramBoolean;
    this.j = true;
    if (paramBoolean) {
      c();
      this.e.setShader((Shader)this.f);
      invalidateSelf();
      return;
    } 
    setCornerRadius(0.0F);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.e.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setCornerRadius(float paramFloat) {
    if (this.h == paramFloat)
      return; 
    this.k = false;
    if (a(paramFloat)) {
      this.e.setShader((Shader)this.f);
    } else {
      this.e.setShader(null);
    } 
    this.h = paramFloat;
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
  
  public void setGravity(int paramInt) {
    if (this.d != paramInt) {
      this.d = paramInt;
      this.j = true;
      invalidateSelf();
    } 
  }
  
  public void setMipMap(boolean paramBoolean) {
    throw new UnsupportedOperationException();
  }
  
  public void setTargetDensity(int paramInt) {
    if (this.c != paramInt) {
      int i = paramInt;
      if (paramInt == 0)
        i = 160; 
      this.c = i;
      if (this.a != null)
        b(); 
      invalidateSelf();
    } 
  }
  
  public void setTargetDensity(Canvas paramCanvas) {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics) {
    setTargetDensity(paramDisplayMetrics.densityDpi);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\drawable\RoundedBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */