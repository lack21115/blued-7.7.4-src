package com.blued.android.module.live_china.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.Choreographer;

public class WaveDrawable extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable {
  private static final PorterDuffXfermode p = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  
  private static ColorFilter q = (ColorFilter)new ColorMatrixColorFilter(new float[] { 
        0.264F, 0.472F, 0.088F, 0.0F, 0.0F, 0.264F, 0.472F, 0.088F, 0.0F, 0.0F, 
        0.264F, 0.472F, 0.088F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  
  private Drawable a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private ValueAnimator i;
  
  private float j;
  
  private Paint k;
  
  private Bitmap l;
  
  private Matrix m;
  
  private boolean n;
  
  private boolean o;
  
  private ColorFilter r;
  
  private Choreographer.FrameCallback s;
  
  public WaveDrawable(Context paramContext, int paramInt) {
    Drawable drawable;
    this.d = Integer.MIN_VALUE;
    this.e = Integer.MIN_VALUE;
    this.f = Integer.MIN_VALUE;
    this.g = 0;
    this.h = 0;
    this.i = null;
    this.j = 0.3F;
    this.m = new Matrix();
    this.n = false;
    this.o = false;
    this.r = null;
    this.s = new Choreographer.FrameCallback(this) {
        public void doFrame(long param1Long) {
          this.a.invalidateSelf();
          if (WaveDrawable.a(this.a))
            Choreographer.getInstance().postFrameCallback(this); 
        }
      };
    if (Build.VERSION.SDK_INT >= 21) {
      drawable = paramContext.getDrawable(paramInt);
    } else {
      drawable = drawable.getResources().getDrawable(paramInt);
    } 
    a(drawable);
  }
  
  private void a(float paramFloat) {
    this.j = paramFloat;
    int i = this.c;
    this.h = i - (int)((this.d + i) * this.j);
    invalidateSelf();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 <= 0 || paramInt2 <= 0 || paramInt3 <= 0) {
      Log.w("ContentValues", "updateMask: size must > 0");
      this.l = null;
      return;
    } 
    float f2 = (paramInt1 + paramInt2);
    float f1 = paramInt2;
    int i = (int)Math.ceil((f2 / f1));
    Bitmap bitmap = Bitmap.createBitmap(paramInt2 * i, paramInt3, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint(1);
    paramInt1 = paramInt3 / 2;
    Path path = new Path();
    float f3 = paramInt1;
    path.moveTo(0.0F, f3);
    float f4 = f1 / 4.0F;
    f1 = -paramInt1;
    paramInt1 = 0;
    f2 = 0.0F;
    while (paramInt1 < i * 2) {
      float f = f2 + f4;
      f2 = f + f4;
      path.quadTo(f, f1, f2, f3);
      f1 = bitmap.getHeight() - f1;
      paramInt1++;
    } 
    f1 = bitmap.getWidth();
    f2 = paramInt3;
    path.lineTo(f1, f2);
    path.lineTo(0.0F, f2);
    path.close();
    canvas.drawPath(path, paint);
    this.l = bitmap;
  }
  
  private void a(Rect paramRect) {
    if (paramRect.width() > 0) {
      if (paramRect.height() <= 0)
        return; 
      if (this.b < 0 || this.c < 0) {
        this.b = paramRect.width();
        this.c = paramRect.height();
        if (this.d == Integer.MIN_VALUE)
          this.d = Math.max(8, (int)(this.c * 0.2F)); 
        if (this.e == Integer.MIN_VALUE)
          this.e = this.b; 
        if (this.f == Integer.MIN_VALUE)
          this.f = Math.max(1, (int)(this.b * 0.02F)); 
        a(this.b, this.e, this.d);
      } 
    } 
  }
  
  private void a(Drawable paramDrawable) {
    this.a = paramDrawable;
    this.m.reset();
    this.k = new Paint();
    this.k.setFilterBitmap(false);
    this.k.setColor(-16777216);
    this.k.setXfermode((Xfermode)p);
    this.b = this.a.getIntrinsicWidth();
    this.c = this.a.getIntrinsicHeight();
    int i = this.b;
    if (i > 0) {
      int j = this.c;
      if (j > 0) {
        this.e = i;
        this.d = Math.max(8, (int)(j * 0.2F));
        this.f = Math.max(1, (int)(this.b * 0.02F));
        a(this.b, this.e, this.d);
      } 
    } 
    a(0.0F);
    start();
  }
  
  public void draw(Canvas paramCanvas) {
    this.a.setColorFilter(q);
    this.a.draw(paramCanvas);
    this.a.setColorFilter(this.r);
    if (this.j <= 0.001F)
      return; 
    int i = paramCanvas.saveLayer(0.0F, 0.0F, this.b, this.c, null, 31);
    int j = this.h;
    if (j > 0)
      paramCanvas.clipRect(0, j, this.b, this.c); 
    this.a.draw(paramCanvas);
    if (this.j >= 0.999F)
      return; 
    this.g += this.f;
    j = this.g;
    int k = this.e;
    if (j > k)
      this.g = j - k; 
    if (this.l != null) {
      this.m.setTranslate(-this.g, this.h);
      paramCanvas.drawBitmap(this.l, this.m, this.k);
    } 
    paramCanvas.restoreToCount(i);
  }
  
  public int getIntrinsicHeight() {
    return this.c;
  }
  
  public int getIntrinsicWidth() {
    return this.b;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public boolean isRunning() {
    return this.n;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {
    if (this.o) {
      a(paramValueAnimator.getAnimatedFraction());
      if (!this.n)
        invalidateSelf(); 
    } 
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    a(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt) {
    a(paramInt / 10000.0F);
    return true;
  }
  
  public void setAlpha(int paramInt) {
    this.a.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.r = paramColorFilter;
    invalidateSelf();
  }
  
  public void start() {
    this.n = true;
    Choreographer.getInstance().postFrameCallback(this.s);
  }
  
  public void stop() {
    this.n = false;
    Choreographer.getInstance().removeFrameCallback(this.s);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\WaveDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */