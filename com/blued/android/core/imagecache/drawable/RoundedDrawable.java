package com.blued.android.core.imagecache.drawable;

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
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.blued.android.core.utils.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RoundedDrawable extends Drawable implements IRecyclingDrawable {
  private String a;
  
  private Set<RecyclingBitmapDrawable> b;
  
  private final RectF c = new RectF();
  
  private final RectF d = new RectF();
  
  private float e;
  
  private final RectF f = new RectF();
  
  private final BitmapShader g;
  
  private final Paint h;
  
  private final int i;
  
  private final int j;
  
  private final RectF k = new RectF();
  
  private final Paint l;
  
  private int m;
  
  private int n;
  
  private ImageView.ScaleType o = ImageView.ScaleType.FIT_XY;
  
  private final Matrix p = new Matrix();
  
  public RoundedDrawable(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2) {
    this.m = paramInt1;
    this.n = paramInt2;
    this.i = paramBitmap.getWidth();
    this.j = paramBitmap.getHeight();
    this.f.set(0.0F, 0.0F, this.i, this.j);
    this.e = paramFloat;
    this.g = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.g.setLocalMatrix(this.p);
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setShader((Shader)this.g);
    this.l = new Paint();
    this.l.setAntiAlias(true);
    this.l.setColor(this.n);
    this.l.setStrokeWidth(paramInt1);
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
  
  public static Drawable a(Drawable paramDrawable, ImageView.ScaleType paramScaleType, float paramFloat, int paramInt1, int paramInt2) {
    if (paramDrawable != null) {
      if (paramDrawable instanceof TransitionDrawable) {
        TransitionDrawable transitionDrawable = (TransitionDrawable)paramDrawable;
        int j = transitionDrawable.getNumberOfLayers();
        Drawable[] arrayOfDrawable = new Drawable[j];
        int i;
        for (i = 0; i < j; i++) {
          Drawable drawable = transitionDrawable.getDrawable(i);
          if (drawable instanceof android.graphics.drawable.ColorDrawable) {
            arrayOfDrawable[i] = drawable;
          } else if (drawable instanceof RoundedDrawable) {
            arrayOfDrawable[i] = drawable;
          } else {
            Bitmap bitmap1 = a(drawable);
            if (bitmap1 != null) {
              arrayOfDrawable[i] = new RoundedDrawable(bitmap1, paramFloat, paramInt1, paramInt2);
              if (drawable instanceof RecyclingBitmapDrawable)
                ((RoundedDrawable)arrayOfDrawable[i]).a((RecyclingBitmapDrawable)drawable); 
              if (paramScaleType != null)
                ((RoundedDrawable)arrayOfDrawable[i]).a(paramScaleType); 
            } 
          } 
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
        RoundedDrawable roundedDrawable = new RoundedDrawable(bitmap, paramFloat, paramInt1, paramInt2);
        if (paramDrawable instanceof RecyclingBitmapDrawable)
          roundedDrawable.a((RecyclingBitmapDrawable)paramDrawable); 
        if (outOfMemoryError != null)
          roundedDrawable.a((ImageView.ScaleType)outOfMemoryError); 
        return roundedDrawable;
      } 
      Log.d("RoundedDrawable", "Failed to create bitmap from drawable!");
    } 
    return paramDrawable;
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
    this.k.set(this.c);
    RectF rectF2 = this.d;
    int i = this.m;
    rectF2.set((i + 0), (i + 0), this.k.width() - this.m, this.k.height() - this.m);
    switch (null.a[this.o.ordinal()]) {
      default:
        this.k.set(this.c);
        rectF2 = this.d;
        i = this.m;
        rectF2.set((i + 0), (i + 0), this.k.width() - this.m, this.k.height() - this.m);
        this.p.set(null);
        this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 6:
        this.k.set(this.f);
        this.p.setRectToRect(this.f, this.c, Matrix.ScaleToFit.START);
        this.p.mapRect(this.k);
        this.d.set(this.k.left + this.m, this.k.top + this.m, this.k.right - this.m, this.k.bottom - this.m);
        this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 5:
        this.k.set(this.f);
        this.p.setRectToRect(this.f, this.c, Matrix.ScaleToFit.END);
        this.p.mapRect(this.k);
        this.d.set(this.k.left + this.m, this.k.top + this.m, this.k.right - this.m, this.k.bottom - this.m);
        this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 4:
        this.k.set(this.f);
        this.p.setRectToRect(this.f, this.c, Matrix.ScaleToFit.CENTER);
        this.p.mapRect(this.k);
        this.d.set(this.k.left + this.m, this.k.top + this.m, this.k.right - this.m, this.k.bottom - this.m);
        this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 3:
        this.p.set(null);
        if (this.i <= this.c.width() && this.j <= this.c.height()) {
          f1 = 1.0F;
        } else {
          f1 = Math.min(this.c.width() / this.i, this.c.height() / this.j);
        } 
        f2 = (int)((this.c.width() - this.i * f1) * 0.5F + 0.5F);
        f3 = (int)((this.c.height() - this.j * f1) * 0.5F + 0.5F);
        this.p.setScale(f1, f1);
        this.p.postTranslate(f2, f3);
        this.k.set(this.f);
        this.p.mapRect(this.k);
        this.d.set(this.k.left + this.m, this.k.top + this.m, this.k.right - this.m, this.k.bottom - this.m);
        this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
        break;
      case 2:
        this.k.set(this.c);
        rectF2 = this.d;
        i = this.m;
        rectF2.set((i + 0), (i + 0), this.k.width() - this.m, this.k.height() - this.m);
        this.p.set(null);
        f1 = this.i;
        f2 = this.d.height();
        f4 = this.d.width();
        f5 = this.j;
        f3 = 0.0F;
        if (f1 * f2 > f4 * f5) {
          f1 = this.d.height() / this.j;
          f2 = (this.d.width() - this.i * f1) * 0.5F;
        } else {
          f1 = this.d.width() / this.i;
          f3 = (this.d.height() - this.j * f1) * 0.5F;
          f2 = 0.0F;
        } 
        this.p.setScale(f1, f1);
        matrix = this.p;
        i = (int)(f2 + 0.5F);
        j = this.m;
        matrix.postTranslate((i + j), ((int)(f3 + 0.5F) + j));
        break;
      case 1:
        this.k.set(this.c);
        rectF1 = this.d;
        i = this.m;
        rectF1.set((i + 0), (i + 0), this.k.width() - this.m, this.k.height() - this.m);
        this.p.set(null);
        this.p.setTranslate((int)((this.d.width() - this.i) * 0.5F + 0.5F), (int)((this.d.height() - this.j) * 0.5F + 0.5F));
        break;
    } 
    this.g.setLocalMatrix(this.p);
  }
  
  public void a(float paramFloat) {
    this.e = paramFloat;
  }
  
  public void a(int paramInt) {
    this.m = paramInt;
    this.l.setStrokeWidth(this.m);
  }
  
  public void a(ImageView.ScaleType paramScaleType) {
    ImageView.ScaleType scaleType = paramScaleType;
    if (paramScaleType == null)
      scaleType = ImageView.ScaleType.FIT_XY; 
    if (this.o != scaleType) {
      this.o = scaleType;
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
    this.n = paramInt;
    this.l.setColor(paramInt);
  }
  
  public void b(boolean paramBoolean) {
    Set<RecyclingBitmapDrawable> set = this.b;
    if (set != null) {
      Iterator<RecyclingBitmapDrawable> iterator = set.iterator();
      while (iterator.hasNext())
        ((RecyclingBitmapDrawable)iterator.next()).b(paramBoolean); 
    } 
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
  
  public void draw(Canvas paramCanvas) {
    if (this.m > 0) {
      RectF rectF1 = this.k;
      float f1 = this.e;
      paramCanvas.drawRoundRect(rectF1, f1, f1, this.l);
      paramCanvas.drawRoundRect(this.d, Math.max(this.e - this.m, 0.0F), Math.max(this.e - this.m, 0.0F), this.h);
      return;
    } 
    RectF rectF = this.d;
    float f = this.e;
    paramCanvas.drawRoundRect(rectF, f, f, this.h);
  }
  
  public int e() {
    return 1;
  }
  
  public ImageView.ScaleType f() {
    return this.o;
  }
  
  public int getIntrinsicHeight() {
    return this.j;
  }
  
  public int getIntrinsicWidth() {
    return this.i;
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
    this.h.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.h.setColorFilter(paramColorFilter);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\RoundedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */