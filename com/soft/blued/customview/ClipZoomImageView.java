package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.core.imagecache.MemoryRequest;
import com.soft.blued.utils.Logger;

public class ClipZoomImageView extends AppCompatImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
  public static float a;
  
  private static final String b = ClipZoomImageView.class.getSimpleName();
  
  private static float c;
  
  private float d = 1.0F;
  
  private boolean e = true;
  
  private final float[] f = new float[9];
  
  private ScaleGestureDetector g = null;
  
  private final Matrix h = new Matrix();
  
  private GestureDetector i;
  
  private boolean j;
  
  private int k;
  
  private float l;
  
  private float m;
  
  private boolean n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private boolean r = true;
  
  static {
    a = 4.0F;
    c = 2.0F;
  }
  
  public ClipZoomImageView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ClipZoomImageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.i = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
          public boolean onDoubleTap(MotionEvent param1MotionEvent) {
            return true;
          }
        });
    this.g = new ScaleGestureDetector(paramContext, this);
    setOnTouchListener(this);
  }
  
  private boolean a(float paramFloat1, float paramFloat2) {
    return (Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2)) >= this.k);
  }
  
  private void b() {
    float f1;
    RectF rectF = getMatrixRectF();
    int j = getWidth();
    int i = getHeight();
    Logger.e(b, new Object[] { "rect.width() =  ", Float.valueOf(rectF.width()), " , width - 2 * mHorizontalPadding =", Integer.valueOf(j - this.p * 2) });
    double d1 = rectF.width();
    double d2 = (j - this.p * 2);
    float f2 = 0.0F;
    float f3 = 0.0F;
    if (d1 + 0.01D >= d2) {
      if (rectF.left > this.p) {
        f1 = -rectF.left + this.p;
      } else {
        f1 = 0.0F;
      } 
      float f = rectF.right;
      int k = this.p;
      if (f < (j - k))
        f1 = (j - k) - rectF.right; 
    } else {
      f1 = 0.0F;
    } 
    if (rectF.height() + 0.01D >= (i - this.q * 2)) {
      f2 = f3;
      if (rectF.top > this.q)
        f2 = -rectF.top + this.q; 
      f3 = rectF.bottom;
      j = this.q;
      if (f3 < (i - j))
        f2 = (i - j) - rectF.bottom; 
    } 
    this.h.postTranslate(f1, f2);
  }
  
  private RectF getMatrixRectF() {
    Matrix matrix = this.h;
    RectF rectF = new RectF();
    Drawable drawable = getDrawable();
    if (drawable != null) {
      rectF.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
      matrix.mapRect(rectF);
    } 
    return rectF;
  }
  
  public Bitmap a() {
    try {
      Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
      draw(new Canvas(bitmap));
      try {
        return this.r ? Bitmap.createBitmap(bitmap, this.p, this.q, getWidth() - this.p * 2, getWidth() - this.p * 2) : Bitmap.createBitmap(bitmap, this.p, this.q, getWidth() - this.p * 2, getHeight() - this.q * 2);
      } catch (OutOfMemoryError outOfMemoryError) {}
      MemoryRequest.a().b();
      return bitmap;
    } catch (OutOfMemoryError outOfMemoryError) {
      MemoryRequest.a().b();
      return null;
    } 
  }
  
  public final float getScale() {
    this.h.getValues(this.f);
    return this.f[0];
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  public void onGlobalLayout() {
    if (this.e) {
      Drawable drawable = getDrawable();
      if (drawable == null)
        return; 
      if (this.q == 0)
        this.q = (getHeight() - getWidth() - this.p * 2) / 2; 
      int i = getWidth();
      int j = getHeight();
      int k = drawable.getIntrinsicWidth();
      int m = drawable.getIntrinsicHeight();
      if (k < getWidth() - this.p * 2 && m > getHeight() - this.q * 2) {
        f1 = (getWidth() * 1.0F - (this.p * 2)) / k;
      } else {
        f1 = 1.0F;
      } 
      float f2 = f1;
      if (m < getHeight() - this.q * 2) {
        f2 = f1;
        if (k > getWidth() - this.p * 2)
          f2 = (getHeight() * 1.0F - (this.q * 2)) / m; 
      } 
      this.d = f2;
      float f1 = this.d;
      c = 2.0F * f1;
      a = f1 * 4.0F;
      this.h.postTranslate(((i - k) / 2), ((j - m) / 2));
      this.h.postScale(f2, f2, (getWidth() / 2), (getHeight() / 2));
      setImageMatrix(this.h);
      this.e = false;
    } 
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector) {
    float f2 = getScale();
    float f1 = paramScaleGestureDetector.getScaleFactor();
    if (getDrawable() == null)
      return true; 
    if ((f2 < a && f1 > 1.0F) || (f2 > this.d && f1 < 1.0F)) {
      float f4 = this.d;
      float f3 = f1;
      if (f1 * f2 < f4)
        f3 = f4 / f2; 
      f4 = a;
      f1 = f3;
      if (f3 * f2 > f4)
        f1 = f4 / f2; 
      this.h.postScale(f1, f1, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      b();
      setImageMatrix(this.h);
    } 
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector) {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    try {
      if (this.i.onTouchEvent(paramMotionEvent))
        return true; 
      this.g.onTouchEvent(paramMotionEvent);
      int j = paramMotionEvent.getPointerCount();
      int i = 0;
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (i < j) {
        f2 += paramMotionEvent.getX(i);
        f1 += paramMotionEvent.getY(i);
        i++;
      } 
      float f4 = j;
      float f3 = f2 / f4;
      f4 = f1 / f4;
      if (j != this.o) {
        this.n = false;
        this.l = f3;
        this.m = f4;
      } 
      this.o = j;
      i = paramMotionEvent.getAction();
      if (i != 1)
        if (i != 2) {
          if (i != 3)
            return true; 
        } else {
          f1 = f3 - this.l;
          f2 = f4 - this.m;
          if (!this.n)
            this.n = a(f1, f2); 
          if (this.n && getDrawable() != null) {
            RectF rectF = getMatrixRectF();
            if (rectF.width() <= (getWidth() - this.p * 2))
              f1 = 0.0F; 
            if (rectF.height() <= (getHeight() - this.q * 2))
              f2 = 0.0F; 
            this.h.postTranslate(f1, f2);
            b();
            setImageMatrix(this.h);
          } 
          this.l = f3;
          this.m = f4;
          return true;
        }  
      this.o = 0;
      return true;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  public void setHorizontalPadding(int paramInt) {
    this.p = paramInt;
  }
  
  public void setVerticalPadding(int paramInt) {
    this.q = paramInt;
    this.r = false;
  }
  
  class AutoScaleRunnable implements Runnable {
    private float b;
    
    private float c;
    
    private float d;
    
    private float e;
    
    public void run() {
      Matrix matrix = ClipZoomImageView.a(this.a);
      float f = this.c;
      matrix.postScale(f, f, this.d, this.e);
      ClipZoomImageView.b(this.a);
      ClipZoomImageView clipZoomImageView = this.a;
      clipZoomImageView.setImageMatrix(ClipZoomImageView.a(clipZoomImageView));
      f = this.a.getScale();
      if ((this.c > 1.0F && f < this.b) || (this.c < 1.0F && this.b < f)) {
        this.a.postDelayed(this, 16L);
        return;
      } 
      f = this.b / f;
      ClipZoomImageView.a(this.a).postScale(f, f, this.d, this.e);
      ClipZoomImageView.b(this.a);
      clipZoomImageView = this.a;
      clipZoomImageView.setImageMatrix(ClipZoomImageView.a(clipZoomImageView));
      ClipZoomImageView.a(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ClipZoomImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */