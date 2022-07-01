package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
  public static final int DEFAULT = 1;
  
  public static final int LARGE = 0;
  
  private static final Interpolator c = (Interpolator)new LinearInterpolator();
  
  private static final Interpolator d = (Interpolator)new FastOutSlowInInterpolator();
  
  private static final int[] e = new int[] { -16777216 };
  
  float a;
  
  boolean b;
  
  private final Ring f;
  
  private float g;
  
  private Resources h;
  
  private Animator i;
  
  public CircularProgressDrawable(Context paramContext) {
    this.h = ((Context)Preconditions.checkNotNull(paramContext)).getResources();
    this.f = new Ring();
    this.f.a(e);
    setStrokeWidth(2.5F);
    a();
  }
  
  private int a(float paramFloat, int paramInt1, int paramInt2) {
    int i = paramInt1 >> 24 & 0xFF;
    int j = paramInt1 >> 16 & 0xFF;
    int k = paramInt1 >> 8 & 0xFF;
    paramInt1 &= 0xFF;
    return i + (int)(((paramInt2 >> 24 & 0xFF) - i) * paramFloat) << 24 | j + (int)(((paramInt2 >> 16 & 0xFF) - j) * paramFloat) << 16 | k + (int)(((paramInt2 >> 8 & 0xFF) - k) * paramFloat) << 8 | paramInt1 + (int)(paramFloat * ((paramInt2 & 0xFF) - paramInt1));
  }
  
  private void a() {
    Ring ring = this.f;
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, ring) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.b.a(f, this.a);
            this.b.a(f, this.a, false);
            this.b.invalidateSelf();
          }
        });
    valueAnimator.setRepeatCount(-1);
    valueAnimator.setRepeatMode(1);
    valueAnimator.setInterpolator((TimeInterpolator)c);
    valueAnimator.addListener(new Animator.AnimatorListener(this, ring) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {}
          
          public void onAnimationRepeat(Animator param1Animator) {
            this.b.a(1.0F, this.a, true);
            this.a.u();
            this.a.h();
            if (this.b.b) {
              this.b.b = false;
              param1Animator.cancel();
              param1Animator.setDuration(1332L);
              param1Animator.start();
              this.a.a(false);
              return;
            } 
            CircularProgressDrawable circularProgressDrawable = this.b;
            circularProgressDrawable.a++;
          }
          
          public void onAnimationStart(Animator param1Animator) {
            this.b.a = 0.0F;
          }
        });
    this.i = (Animator)valueAnimator;
  }
  
  private void a(float paramFloat) {
    this.g = paramFloat;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Ring ring = this.f;
    float f = (this.h.getDisplayMetrics()).density;
    ring.a(paramFloat2 * f);
    ring.e(paramFloat1 * f);
    ring.c(0);
    ring.a(paramFloat3 * f, paramFloat4 * f);
  }
  
  private void b(float paramFloat, Ring paramRing) {
    a(paramFloat, paramRing);
    float f = (float)(Math.floor((paramRing.t() / 0.8F)) + 1.0D);
    paramRing.b(paramRing.l() + (paramRing.m() - 0.01F - paramRing.l()) * paramFloat);
    paramRing.c(paramRing.m());
    paramRing.d(paramRing.t() + (f - paramRing.t()) * paramFloat);
  }
  
  void a(float paramFloat, Ring paramRing) {
    if (paramFloat > 0.75F) {
      paramRing.a(a((paramFloat - 0.75F) / 0.25F, paramRing.n(), paramRing.f()));
      return;
    } 
    paramRing.a(paramRing.n());
  }
  
  void a(float paramFloat, Ring paramRing, boolean paramBoolean) {
    if (this.b) {
      b(paramFloat, paramRing);
      return;
    } 
    if (paramFloat != 1.0F || paramBoolean) {
      float f1;
      float f2;
      float f3 = paramRing.t();
      if (paramFloat < 0.5F) {
        f2 = paramFloat / 0.5F;
        f1 = paramRing.l();
        f2 = d.getInterpolation(f2) * 0.79F + 0.01F + f1;
      } else {
        f1 = (paramFloat - 0.5F) / 0.5F;
        f2 = paramRing.l() + 0.79F;
        f1 = f2 - (1.0F - d.getInterpolation(f1)) * 0.79F + 0.01F;
      } 
      float f4 = this.a;
      paramRing.b(f1);
      paramRing.c(f2);
      paramRing.d(f3 + 0.20999998F * paramFloat);
      a((paramFloat + f4) * 216.0F);
    } 
  }
  
  public void draw(Canvas paramCanvas) {
    Rect rect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.g, rect.exactCenterX(), rect.exactCenterY());
    this.f.a(paramCanvas, rect);
    paramCanvas.restore();
  }
  
  public int getAlpha() {
    return this.f.i();
  }
  
  public boolean getArrowEnabled() {
    return this.f.r();
  }
  
  public float getArrowHeight() {
    return this.f.c();
  }
  
  public float getArrowScale() {
    return this.f.s();
  }
  
  public float getArrowWidth() {
    return this.f.b();
  }
  
  public int getBackgroundColor() {
    return this.f.e();
  }
  
  public float getCenterRadius() {
    return this.f.q();
  }
  
  public int[] getColorSchemeColors() {
    return this.f.d();
  }
  
  public float getEndTrim() {
    return this.f.o();
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public float getProgressRotation() {
    return this.f.p();
  }
  
  public float getStartTrim() {
    return this.f.k();
  }
  
  public Paint.Cap getStrokeCap() {
    return this.f.a();
  }
  
  public float getStrokeWidth() {
    return this.f.j();
  }
  
  public boolean isRunning() {
    return this.i.isRunning();
  }
  
  public void setAlpha(int paramInt) {
    this.f.d(paramInt);
    invalidateSelf();
  }
  
  public void setArrowDimensions(float paramFloat1, float paramFloat2) {
    this.f.a(paramFloat1, paramFloat2);
    invalidateSelf();
  }
  
  public void setArrowEnabled(boolean paramBoolean) {
    this.f.a(paramBoolean);
    invalidateSelf();
  }
  
  public void setArrowScale(float paramFloat) {
    this.f.f(paramFloat);
    invalidateSelf();
  }
  
  public void setBackgroundColor(int paramInt) {
    this.f.b(paramInt);
    invalidateSelf();
  }
  
  public void setCenterRadius(float paramFloat) {
    this.f.e(paramFloat);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.f.a(paramColorFilter);
    invalidateSelf();
  }
  
  public void setColorSchemeColors(int... paramVarArgs) {
    this.f.a(paramVarArgs);
    this.f.c(0);
    invalidateSelf();
  }
  
  public void setProgressRotation(float paramFloat) {
    this.f.d(paramFloat);
    invalidateSelf();
  }
  
  public void setStartEndTrim(float paramFloat1, float paramFloat2) {
    this.f.b(paramFloat1);
    this.f.c(paramFloat2);
    invalidateSelf();
  }
  
  public void setStrokeCap(Paint.Cap paramCap) {
    this.f.a(paramCap);
    invalidateSelf();
  }
  
  public void setStrokeWidth(float paramFloat) {
    this.f.a(paramFloat);
    invalidateSelf();
  }
  
  public void setStyle(int paramInt) {
    if (paramInt == 0) {
      a(11.0F, 3.0F, 12.0F, 6.0F);
    } else {
      a(7.5F, 2.5F, 10.0F, 5.0F);
    } 
    invalidateSelf();
  }
  
  public void start() {
    this.i.cancel();
    this.f.u();
    if (this.f.o() != this.f.k()) {
      this.b = true;
      this.i.setDuration(666L);
      this.i.start();
      return;
    } 
    this.f.c(0);
    this.f.v();
    this.i.setDuration(1332L);
    this.i.start();
  }
  
  public void stop() {
    this.i.cancel();
    a(0.0F);
    this.f.a(false);
    this.f.c(0);
    this.f.v();
    invalidateSelf();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProgressDrawableSize {}
  
  static class Ring {
    final RectF a = new RectF();
    
    final Paint b = new Paint();
    
    final Paint c = new Paint();
    
    final Paint d = new Paint();
    
    float e = 0.0F;
    
    float f = 0.0F;
    
    float g = 0.0F;
    
    float h = 5.0F;
    
    int[] i;
    
    int j;
    
    float k;
    
    float l;
    
    float m;
    
    boolean n;
    
    Path o;
    
    float p = 1.0F;
    
    float q;
    
    int r;
    
    int s;
    
    int t = 255;
    
    int u;
    
    Ring() {
      this.b.setStrokeCap(Paint.Cap.SQUARE);
      this.b.setAntiAlias(true);
      this.b.setStyle(Paint.Style.STROKE);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setAntiAlias(true);
      this.d.setColor(0);
    }
    
    Paint.Cap a() {
      return this.b.getStrokeCap();
    }
    
    void a(float param1Float) {
      this.h = param1Float;
      this.b.setStrokeWidth(param1Float);
    }
    
    void a(float param1Float1, float param1Float2) {
      this.r = (int)param1Float1;
      this.s = (int)param1Float2;
    }
    
    void a(int param1Int) {
      this.u = param1Int;
    }
    
    void a(Canvas param1Canvas, float param1Float1, float param1Float2, RectF param1RectF) {
      if (this.n) {
        Path path = this.o;
        if (path == null) {
          this.o = new Path();
          this.o.setFillType(Path.FillType.EVEN_ODD);
        } else {
          path.reset();
        } 
        float f1 = Math.min(param1RectF.width(), param1RectF.height()) / 2.0F;
        float f2 = this.r * this.p / 2.0F;
        this.o.moveTo(0.0F, 0.0F);
        this.o.lineTo(this.r * this.p, 0.0F);
        path = this.o;
        float f3 = this.r;
        float f4 = this.p;
        path.lineTo(f3 * f4 / 2.0F, this.s * f4);
        this.o.offset(f1 + param1RectF.centerX() - f2, param1RectF.centerY() + this.h / 2.0F);
        this.o.close();
        this.c.setColor(this.u);
        this.c.setAlpha(this.t);
        param1Canvas.save();
        param1Canvas.rotate(param1Float1 + param1Float2, param1RectF.centerX(), param1RectF.centerY());
        param1Canvas.drawPath(this.o, this.c);
        param1Canvas.restore();
      } 
    }
    
    void a(Canvas param1Canvas, Rect param1Rect) {
      RectF rectF = this.a;
      float f2 = this.q;
      float f1 = this.h / 2.0F + f2;
      if (f2 <= 0.0F)
        f1 = Math.min(param1Rect.width(), param1Rect.height()) / 2.0F - Math.max(this.r * this.p / 2.0F, this.h / 2.0F); 
      rectF.set(param1Rect.centerX() - f1, param1Rect.centerY() - f1, param1Rect.centerX() + f1, param1Rect.centerY() + f1);
      f1 = this.e;
      f2 = this.g;
      f1 = (f1 + f2) * 360.0F;
      f2 = (this.f + f2) * 360.0F - f1;
      this.b.setColor(this.u);
      this.b.setAlpha(this.t);
      float f3 = this.h / 2.0F;
      rectF.inset(f3, f3);
      param1Canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0F, this.d);
      f3 = -f3;
      rectF.inset(f3, f3);
      param1Canvas.drawArc(rectF, f1, f2, false, this.b);
      a(param1Canvas, f1, f2, rectF);
    }
    
    void a(ColorFilter param1ColorFilter) {
      this.b.setColorFilter(param1ColorFilter);
    }
    
    void a(Paint.Cap param1Cap) {
      this.b.setStrokeCap(param1Cap);
    }
    
    void a(boolean param1Boolean) {
      if (this.n != param1Boolean)
        this.n = param1Boolean; 
    }
    
    void a(int[] param1ArrayOfint) {
      this.i = param1ArrayOfint;
      c(0);
    }
    
    float b() {
      return this.r;
    }
    
    void b(float param1Float) {
      this.e = param1Float;
    }
    
    void b(int param1Int) {
      this.d.setColor(param1Int);
    }
    
    float c() {
      return this.s;
    }
    
    void c(float param1Float) {
      this.f = param1Float;
    }
    
    void c(int param1Int) {
      this.j = param1Int;
      this.u = this.i[this.j];
    }
    
    void d(float param1Float) {
      this.g = param1Float;
    }
    
    void d(int param1Int) {
      this.t = param1Int;
    }
    
    int[] d() {
      return this.i;
    }
    
    int e() {
      return this.d.getColor();
    }
    
    void e(float param1Float) {
      this.q = param1Float;
    }
    
    int f() {
      return this.i[g()];
    }
    
    void f(float param1Float) {
      if (param1Float != this.p)
        this.p = param1Float; 
    }
    
    int g() {
      return (this.j + 1) % this.i.length;
    }
    
    void h() {
      c(g());
    }
    
    int i() {
      return this.t;
    }
    
    float j() {
      return this.h;
    }
    
    float k() {
      return this.e;
    }
    
    float l() {
      return this.k;
    }
    
    float m() {
      return this.l;
    }
    
    int n() {
      return this.i[this.j];
    }
    
    float o() {
      return this.f;
    }
    
    float p() {
      return this.g;
    }
    
    float q() {
      return this.q;
    }
    
    boolean r() {
      return this.n;
    }
    
    float s() {
      return this.p;
    }
    
    float t() {
      return this.m;
    }
    
    void u() {
      this.k = this.e;
      this.l = this.f;
      this.m = this.g;
    }
    
    void v() {
      this.k = 0.0F;
      this.l = 0.0F;
      this.m = 0.0F;
      b(0.0F);
      c(0.0F);
      d(0.0F);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\swiperefreshlayout\widget\CircularProgressDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */