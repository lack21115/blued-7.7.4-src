package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class c extends ImageView {
  final String a = "TouchView";
  
  public boolean b = false;
  
  private Matrix c = new Matrix();
  
  private Matrix d = new Matrix();
  
  private int e = 0;
  
  private float f = 1.0F;
  
  private float g = 1.0F;
  
  private Bitmap h;
  
  private boolean i = false;
  
  private float j;
  
  private float k;
  
  private PointF l = new PointF();
  
  private PointF m = new PointF();
  
  private float n = 1.0F;
  
  private float o = 0.0F;
  
  private Rect p = new Rect();
  
  public c(Context paramContext) {
    super(paramContext);
    getDrawingRect(this.p);
    a();
  }
  
  private float a(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getPointerCount() < 2)
      return 0.0F; 
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return FloatMath.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void a() {}
  
  private void a(PointF paramPointF) {
    if (this.h == null)
      return; 
    float[] arrayOfFloat = new float[9];
    this.c.getValues(arrayOfFloat);
    float f3 = arrayOfFloat[2];
    float f4 = arrayOfFloat[5];
    float f5 = arrayOfFloat[0];
    float f7 = this.h.getWidth();
    float f6 = this.h.getHeight();
    float f2 = this.p.left - f3;
    float f1 = f2;
    if (f2 <= 1.0F)
      f1 = 1.0F; 
    f3 = f3 + f7 * f5 - this.p.right;
    f2 = f3;
    if (f3 <= 1.0F)
      f2 = 1.0F; 
    f7 = this.p.width() * f1 / (f2 + f1);
    float f8 = this.p.left;
    f2 = this.p.top - f4;
    f3 = f4 + f6 * f5 - this.p.bottom;
    f1 = f2;
    if (f2 <= 1.0F)
      f1 = 1.0F; 
    f2 = f3;
    if (f3 <= 1.0F)
      f2 = 1.0F; 
    paramPointF.set(f7 + f8, this.p.height() * f1 / (f2 + f1) + this.p.top);
  }
  
  private void b() {
    TranslateAnimation translateAnimation;
    if (this.h == null)
      return; 
    float f4 = this.p.width();
    float f3 = this.p.height();
    float[] arrayOfFloat = new float[9];
    this.c.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[2];
    float f2 = arrayOfFloat[5];
    boolean bool = false;
    float f5 = arrayOfFloat[0];
    Matrix matrix = null;
    float f6 = this.f;
    if (f5 > f6) {
      this.o = f6 / f5;
      matrix = this.c;
      f1 = this.o;
      matrix.postScale(f1, f1, this.m.x, this.m.y);
      setImageMatrix(this.c);
      f1 = this.o;
      ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F / f1, 1.0F, 1.0F / f1, 1.0F, this.m.x, this.m.y);
    } else {
      f6 = this.g;
      if (f5 < f6) {
        this.o = f6 / f5;
        matrix = this.c;
        f1 = this.o;
        matrix.postScale(f1, f1, this.m.x, this.m.y);
        f1 = this.o;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, f1, 1.0F, f1, this.m.x, this.m.y);
      } else {
        float f7 = this.h.getWidth() * f5;
        f5 = this.h.getHeight() * f5;
        float f8 = this.p.left - f1;
        f6 = this.p.top - f2;
        if (f8 < 0.0F) {
          f1 = this.p.left;
          bool = true;
        } 
        if (f6 < 0.0F) {
          f2 = this.p.top;
          bool = true;
        } 
        if (f7 - f8 < f4) {
          f1 = this.p.left - f7 - f4;
          bool = true;
        } 
        if (f5 - f6 < f3) {
          f2 = this.p.top - f5 - f3;
          bool = true;
        } 
        if (bool) {
          f3 = arrayOfFloat[2];
          f4 = arrayOfFloat[5];
          arrayOfFloat[2] = f1;
          arrayOfFloat[5] = f2;
          this.c.setValues(arrayOfFloat);
          setImageMatrix(this.c);
          translateAnimation = new TranslateAnimation(f3 - f1, 0.0F, f4 - f2, 0.0F);
        } else {
          setImageMatrix(this.c);
        } 
      } 
    } 
    if (translateAnimation != null) {
      this.i = true;
      translateAnimation.setDuration(300L);
      startAnimation((Animation)translateAnimation);
      (new Thread(new Runnable(this) {
            public void run() {
              try {
                Thread.sleep(300L);
              } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
              } 
              this.a.post(new Runnable(this) {
                    public void run() {
                      this.a.a.clearAnimation();
                      c.a(this.a.a);
                    }
                  });
              c.a(this.a, false);
            }
          })).start();
    } 
  }
  
  private void c() {
    if (this.h == null)
      return; 
    float[] arrayOfFloat = new float[9];
    this.c.getValues(arrayOfFloat);
    float f1 = Math.max(this.p.width() / this.h.getWidth(), this.p.height() / this.h.getHeight());
    this.j = this.p.left - (this.h.getWidth() * f1 - this.p.width()) / 2.0F;
    this.k = this.p.top - (this.h.getHeight() * f1 - this.p.height()) / 2.0F;
    arrayOfFloat[2] = this.j;
    arrayOfFloat[5] = this.k;
    arrayOfFloat[4] = f1;
    arrayOfFloat[0] = f1;
    this.c.setValues(arrayOfFloat);
    this.f = Math.min(2048.0F / this.h.getWidth(), 2048.0F / this.h.getHeight());
    this.g = f1;
    f1 = this.f;
    float f2 = this.g;
    if (f1 < f2)
      this.f = f2; 
    setImageMatrix(this.c);
  }
  
  public void a(Rect paramRect) {
    this.p = paramRect;
    if (this.h != null)
      c(); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.i)
      return true; 
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 5) {
            if (i != 6) {
              this.b = true;
              return true;
            } 
          } else {
            this.n = a(paramMotionEvent);
            if (this.n > 10.0F) {
              this.d.set(this.c);
              a(this.m);
              this.e = 2;
            } 
            this.b = true;
            return true;
          } 
        } else {
          i = this.e;
          if (i == 1) {
            this.c.set(this.d);
            float f1 = paramMotionEvent.getX();
            float f2 = this.l.x;
            float f3 = paramMotionEvent.getY();
            float f4 = this.l.y;
            this.c.postTranslate(f1 - f2, f3 - f4);
            setImageMatrix(this.c);
          } else if (i == 2) {
            Matrix matrix = this.c;
            matrix.set(matrix);
            float f = a(paramMotionEvent);
            if (f > 10.0F) {
              this.c.set(this.d);
              f /= this.n;
              this.c.postScale(f, f, this.m.x, this.m.y);
            } 
            setImageMatrix(this.c);
          } 
          this.b = true;
          return true;
        }  
      b();
      this.e = 0;
    } else {
      this.c.set(getImageMatrix());
      this.d.set(this.c);
      this.l.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.e = 1;
    } 
    this.b = true;
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    super.setImageBitmap(paramBitmap);
    this.h = paramBitmap;
    if (paramBitmap != null)
      this.h = paramBitmap; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\avatar\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */