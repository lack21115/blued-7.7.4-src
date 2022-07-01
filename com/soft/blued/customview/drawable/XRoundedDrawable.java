package com.soft.blued.customview.drawable;

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
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.drawable.RecyclingBitmapDrawable;
import com.soft.blued.utils.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class XRoundedDrawable extends Drawable implements IRecyclingDrawable {
  private String a;
  
  private Set<RecyclingBitmapDrawable> b;
  
  private final RectF c = new RectF();
  
  private final RectF d = new RectF();
  
  private float e;
  
  private float f;
  
  private float g;
  
  private float h;
  
  private final RectF i = new RectF();
  
  private final BitmapShader j;
  
  private final Paint k;
  
  private final int l;
  
  private final int m;
  
  private final RectF n = new RectF();
  
  private final Paint o;
  
  private int p;
  
  private int q;
  
  private ImageView.ScaleType r = ImageView.ScaleType.FIT_XY;
  
  private final Matrix s = new Matrix();
  
  public XRoundedDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    this.p = paramInt1;
    this.q = paramInt2;
    this.l = paramBitmap.getWidth();
    this.m = paramBitmap.getHeight();
    this.i.set(0.0F, 0.0F, this.l, this.m);
    this.j = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.j.setLocalMatrix(this.s);
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setShader((Shader)this.j);
    this.o = new Paint();
    this.o.setAntiAlias(true);
    this.o.setColor(this.q);
    this.o.setStrokeWidth(paramInt1);
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
  }
  
  public static Bitmap a(Drawable paramDrawable) {
    if (paramDrawable instanceof BitmapDrawable)
      return ((BitmapDrawable)paramDrawable).getBitmap(); 
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (i > 0 && j > 0)
      try {
        Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (bitmap == null)
          return null; 
        Canvas canvas = new Canvas(bitmap);
        paramDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        paramDrawable.draw(canvas);
        return bitmap;
      } catch (OutOfMemoryError outOfMemoryError) {
        outOfMemoryError.printStackTrace();
        return null;
      }  
    return null;
  }
  
  public static Drawable a(Drawable paramDrawable, ImageView.ScaleType paramScaleType, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    if (paramDrawable != null) {
      boolean bool = paramDrawable instanceof TransitionDrawable;
      int i = 0;
      if (bool) {
        TransitionDrawable transitionDrawable = (TransitionDrawable)paramDrawable;
        int j = transitionDrawable.getNumberOfLayers();
        Drawable[] arrayOfDrawable = new Drawable[j];
        while (i < j) {
          Drawable drawable = transitionDrawable.getDrawable(i);
          if (drawable instanceof android.graphics.drawable.ColorDrawable) {
            arrayOfDrawable[i] = drawable;
          } else if (drawable instanceof XRoundedDrawable) {
            arrayOfDrawable[i] = drawable;
          } else {
            Bitmap bitmap1 = a(drawable);
            if (bitmap1 != null) {
              arrayOfDrawable[i] = new XRoundedDrawable(bitmap1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
              if (drawable instanceof RecyclingBitmapDrawable)
                ((XRoundedDrawable)arrayOfDrawable[i]).a((RecyclingBitmapDrawable)drawable); 
              if (paramScaleType != null)
                ((XRoundedDrawable)arrayOfDrawable[i]).a(paramScaleType); 
            } 
          } 
          i++;
        } 
        try {
          return (Drawable)new TransitionDrawable(arrayOfDrawable);
        } catch (OutOfMemoryError outOfMemoryError) {
          outOfMemoryError.printStackTrace();
          return paramDrawable;
        } 
      } 
      Bitmap bitmap = a(paramDrawable);
      if (bitmap != null) {
        XRoundedDrawable xRoundedDrawable = new XRoundedDrawable(bitmap, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        if (paramDrawable instanceof RecyclingBitmapDrawable)
          xRoundedDrawable.a((RecyclingBitmapDrawable)paramDrawable); 
        if (outOfMemoryError != null)
          xRoundedDrawable.a((ImageView.ScaleType)outOfMemoryError); 
        return xRoundedDrawable;
      } 
      Logger.d("RoundedDrawable", new Object[] { "Failed to create bitmap from drawable!" });
    } 
    return paramDrawable;
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF, Paint paramPaint, int paramInt) {
    paramCanvas.save();
    float f1 = paramInt;
    paramCanvas.translate(f1, f1);
    Path path = new Path();
    path.moveTo(this.e, 0.0F);
    path.lineTo(paramRectF.width() - this.g, 0.0F);
    path.arcTo(new RectF(paramRectF.width() - this.g * 2.0F, 0.0F, paramRectF.width(), this.g * 2.0F), 270.0F, 90.0F);
    path.lineTo(paramRectF.width(), paramRectF.height() - this.h);
    path.arcTo(new RectF(paramRectF.width() - this.h * 2.0F, paramRectF.height() - this.h * 2.0F, paramRectF.width(), paramRectF.height()), 0.0F, 90.0F);
    path.lineTo(this.f, paramRectF.height());
    f1 = paramRectF.height();
    float f2 = this.f;
    path.arcTo(new RectF(0.0F, f1 - f2 * 2.0F, f2 * 2.0F, paramRectF.height()), 90.0F, 90.0F);
    path.lineTo(0.0F, this.e);
    f1 = this.e;
    path.arcTo(new RectF(0.0F, 0.0F, f1 * 2.0F, f1 * 2.0F), 180.0F, 90.0F);
    path.close();
    paramCanvas.drawPath(path, paramPaint);
    paramCanvas.restore();
  }
  
  private void g() {
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    int j;
    Matrix matrix;
    RectF rectF1;
    this.n.set(this.c);
    RectF rectF2 = this.d;
    int i = this.p;
    rectF2.set((i + 0), (i + 0), this.n.width() - this.p, this.n.height() - this.p);
    switch (null.a[this.r.ordinal()]) {
      default:
        this.n.set(this.c);
        rectF2 = this.d;
        i = this.p;
        rectF2.set((i + 0), (i + 0), this.n.width() - this.p, this.n.height() - this.p);
        this.s.set(null);
        this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 6:
        this.n.set(this.i);
        this.s.setRectToRect(this.i, this.c, Matrix.ScaleToFit.START);
        this.s.mapRect(this.n);
        this.d.set(this.n.left + this.p, this.n.top + this.p, this.n.right - this.p, this.n.bottom - this.p);
        this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 5:
        this.n.set(this.i);
        this.s.setRectToRect(this.i, this.c, Matrix.ScaleToFit.END);
        this.s.mapRect(this.n);
        this.d.set(this.n.left + this.p, this.n.top + this.p, this.n.right - this.p, this.n.bottom - this.p);
        this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 4:
        this.n.set(this.i);
        this.s.setRectToRect(this.i, this.c, Matrix.ScaleToFit.CENTER);
        this.s.mapRect(this.n);
        this.d.set(this.n.left + this.p, this.n.top + this.p, this.n.right - this.p, this.n.bottom - this.p);
        this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 3:
        this.s.set(null);
        if (this.l <= this.c.width() && this.m <= this.c.height()) {
          f1 = 1.0F;
        } else {
          f1 = Math.min(this.c.width() / this.l, this.c.height() / this.m);
        } 
        f2 = (int)((this.c.width() - this.l * f1) * 0.5F + 0.5F);
        f3 = (int)((this.c.height() - this.m * f1) * 0.5F + 0.5F);
        this.s.setScale(f1, f1);
        this.s.postTranslate(f2, f3);
        this.n.set(this.i);
        this.s.mapRect(this.n);
        this.d.set(this.n.left + this.p, this.n.top + this.p, this.n.right - this.p, this.n.bottom - this.p);
        this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 2:
        this.n.set(this.c);
        rectF2 = this.d;
        i = this.p;
        rectF2.set((i + 0), (i + 0), this.n.width() - this.p, this.n.height() - this.p);
        this.s.set(null);
        f1 = this.l;
        f2 = this.d.height();
        f4 = this.d.width();
        f5 = this.m;
        f3 = 0.0F;
        if (f1 * f2 > f4 * f5) {
          f1 = this.d.height() / this.m;
          f2 = (this.d.width() - this.l * f1) * 0.5F;
        } else {
          f1 = this.d.width() / this.l;
          f3 = (this.d.height() - this.m * f1) * 0.5F;
          f2 = 0.0F;
        } 
        this.s.setScale(f1, f1);
        matrix = this.s;
        i = (int)(f2 + 0.5F);
        j = this.p;
        matrix.postTranslate((i + j), ((int)(f3 + 0.5F) + j));
        break;
      case 1:
        this.n.set(this.c);
        rectF1 = this.d;
        i = this.p;
        rectF1.set((i + 0), (i + 0), this.n.width() - this.p, this.n.height() - this.p);
        this.s.set(null);
        this.s.setTranslate((int)((this.d.width() - this.l) * 0.5F + 0.5F), (int)((this.d.height() - this.m) * 0.5F + 0.5F));
        break;
    } 
    this.j.setLocalMatrix(this.s);
  }
  
  public void a(int paramInt) {
    this.p = paramInt;
    this.o.setStrokeWidth(this.p);
  }
  
  public void a(ImageView.ScaleType paramScaleType) {
    ImageView.ScaleType scaleType = paramScaleType;
    if (paramScaleType == null)
      scaleType = ImageView.ScaleType.FIT_XY; 
    if (this.r != scaleType) {
      this.r = scaleType;
      g();
    } 
  }
  
  public void a(RecyclingBitmapDrawable paramRecyclingBitmapDrawable) {
    if (paramRecyclingBitmapDrawable == null)
      return; 
    if (this.b == null)
      this.b = new HashSet<RecyclingBitmapDrawable>(); 
    this.b.add(paramRecyclingBitmapDrawable);
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean) {
    Set<RecyclingBitmapDrawable> set = this.b;
    if (set != null) {
      Iterator<RecyclingBitmapDrawable> iterator = set.iterator();
      while (iterator.hasNext())
        ((RecyclingBitmapDrawable)iterator.next()).a(paramBoolean); 
    } 
  }
  
  public boolean a() {
    return true;
  }
  
  public String b() {
    return this.a;
  }
  
  public void b(int paramInt) {
    this.q = paramInt;
    this.o.setColor(paramInt);
  }
  
  public void b(boolean paramBoolean) {
    Set<RecyclingBitmapDrawable> set = this.b;
    if (set != null) {
      Iterator<RecyclingBitmapDrawable> iterator = set.iterator();
      while (iterator.hasNext())
        ((RecyclingBitmapDrawable)iterator.next()).b(paramBoolean); 
    } 
  }
  
  public void c(int paramInt) {
    float f = paramInt;
    this.h = f;
    this.g = f;
    this.f = f;
    this.e = f;
  }
  
  public boolean c() {
    Set<RecyclingBitmapDrawable> set = this.b;
    if (set != null) {
      Iterator<RecyclingBitmapDrawable> iterator = set.iterator();
      while (iterator.hasNext()) {
        if (!((RecyclingBitmapDrawable)iterator.next()).c())
          return false; 
      } 
    } 
    return true;
  }
  
  public void d() {
    Set<RecyclingBitmapDrawable> set = this.b;
    if (set != null) {
      Iterator<RecyclingBitmapDrawable> iterator = set.iterator();
      while (iterator.hasNext())
        ((RecyclingBitmapDrawable)iterator.next()).d(); 
      this.b = null;
    } 
  }
  
  public void d(int paramInt) {
    this.h = paramInt;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.p > 0) {
      a(paramCanvas, this.n, this.o, 0);
      a(paramCanvas, this.d, this.k, this.p);
      return;
    } 
    a(paramCanvas, this.d, this.k, 0);
  }
  
  public int e() {
    return 1;
  }
  
  public void e(int paramInt) {
    this.g = paramInt;
  }
  
  public ImageView.ScaleType f() {
    return this.r;
  }
  
  public void f(int paramInt) {
    this.f = paramInt;
  }
  
  public void g(int paramInt) {
    this.e = paramInt;
  }
  
  public int getIntrinsicHeight() {
    return this.m;
  }
  
  public int getIntrinsicWidth() {
    return this.l;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    this.c.set(paramRect);
    g();
  }
  
  public void setAlpha(int paramInt) {
    this.k.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.k.setColorFilter(paramColorFilter);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\drawable\XRoundedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */