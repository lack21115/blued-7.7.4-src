package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

class MaterialDrawable extends RefreshDrawable implements Animatable {
  private static final Interpolator a = (Interpolator)new LinearInterpolator();
  
  private static final Interpolator b = (Interpolator)new EndCurveInterpolator();
  
  private static final Interpolator c = (Interpolator)new StartCurveInterpolator();
  
  private static final Interpolator d = (Interpolator)new AccelerateDecelerateInterpolator();
  
  private final int[] e = new int[] { -16777216 };
  
  private final ArrayList<Animation> f = new ArrayList<Animation>();
  
  private final Ring g;
  
  private float h;
  
  private Resources i;
  
  private View j;
  
  private Animation k;
  
  private float l;
  
  private double m;
  
  private double n;
  
  private Animation o;
  
  private int p;
  
  private int q;
  
  private ShapeDrawable r;
  
  private int s;
  
  private int t;
  
  private final Drawable.Callback u = new Drawable.Callback(this) {
      public void invalidateDrawable(Drawable param1Drawable) {
        this.a.invalidateSelf();
      }
      
      public void scheduleDrawable(Drawable param1Drawable, Runnable param1Runnable, long param1Long) {
        this.a.scheduleSelf(param1Runnable, param1Long);
      }
      
      public void unscheduleDrawable(Drawable param1Drawable, Runnable param1Runnable) {
        this.a.unscheduleSelf(param1Runnable);
      }
    };
  
  public MaterialDrawable(Context paramContext, PullRefreshLayout paramPullRefreshLayout) {
    super(paramContext, paramPullRefreshLayout);
    this.j = (View)paramPullRefreshLayout;
    this.i = paramContext.getResources();
    this.g = new Ring(this.u);
    this.g.a(this.e);
    a(1);
    f();
    e();
    b(-1);
    this.t = d(40);
    this.s = -this.t - (d().getFinalOffset() - this.t) / 2;
  }
  
  private void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat1, float paramFloat2) {
    Ring ring = this.g;
    float f = (this.i.getDisplayMetrics()).density;
    double d = f;
    this.m = paramDouble1 * d;
    this.n = paramDouble2 * d;
    ring.a((float)paramDouble4 * f);
    ring.a(paramDouble3 * d);
    ring.b(0);
    ring.a(paramFloat1 * f, paramFloat2 * f);
    ring.a((int)this.m, (int)this.n);
  }
  
  private int d(int paramInt) {
    return (int)TypedValue.applyDimension(1, paramInt, c().getResources().getDisplayMetrics());
  }
  
  private void e() {
    float f = (c().getResources().getDisplayMetrics()).density;
    int i = (int)(20.0F * f * 2.0F);
    int j = (int)(1.75F * f);
    int k = (int)(0.0F * f);
    this.p = (int)(f * 3.5F);
    this.r = new ShapeDrawable((Shape)new OvalShadow(this, this.p, i));
    this.r.getPaint().setShadowLayer(this.p, k, j, 503316480);
    this.q = this.p;
    this.r.getPaint().setColor(-1);
  }
  
  private void f() {
    Ring ring = this.g;
    Animation animation1 = new Animation(this, ring) {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          float f1 = (float)(Math.floor((this.a.i() / 0.8F)) + 1.0D);
          float f2 = this.a.e();
          float f3 = this.a.f();
          float f4 = this.a.e();
          this.a.b(f2 + (f3 - f4) * param1Float);
          f2 = this.a.i();
          f3 = this.a.i();
          this.a.d(f2 + (f1 - f3) * param1Float);
          this.a.e(1.0F - param1Float);
        }
      };
    animation1.setInterpolator(d);
    animation1.setDuration(666L);
    animation1.setAnimationListener(new Animation.AnimationListener(this, ring) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.a();
            this.a.j();
            this.a.a(false);
            MaterialDrawable.b(this.b).startAnimation(MaterialDrawable.a(this.b));
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    Animation animation2 = new Animation(this, ring) {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          float f3 = (float)Math.toRadians(this.a.c() / this.a.h() * 6.283185307179586D);
          float f4 = this.a.f();
          float f1 = this.a.e();
          float f2 = this.a.i();
          float f5 = MaterialDrawable.a().getInterpolation(param1Float);
          this.a.c(f4 + (0.8F - f3) * f5);
          f3 = MaterialDrawable.b().getInterpolation(param1Float);
          this.a.b(f1 + f3 * 0.8F);
          this.a.d(f2 + 0.25F * param1Float);
          f1 = MaterialDrawable.c(this.b) / 5.0F;
          this.b.d(param1Float * 144.0F + f1 * 720.0F);
        }
      };
    animation2.setRepeatCount(-1);
    animation2.setRepeatMode(1);
    animation2.setInterpolator(a);
    animation2.setDuration(1333L);
    animation2.setAnimationListener(new Animation.AnimationListener(this, ring) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {
            this.a.j();
            this.a.a();
            MaterialDrawable.Ring ring = this.a;
            ring.b(ring.g());
            MaterialDrawable materialDrawable = this.b;
            MaterialDrawable.a(materialDrawable, (MaterialDrawable.c(materialDrawable) + 1.0F) % 5.0F);
          }
          
          public void onAnimationStart(Animation param1Animation) {
            MaterialDrawable.a(this.b, 0.0F);
          }
        });
    this.o = animation1;
    this.k = animation2;
  }
  
  public void a(float paramFloat) {
    this.g.e(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.g.b(paramFloat1);
    this.g.c(paramFloat2);
  }
  
  public void a(int paramInt) {
    if (paramInt == 0) {
      a(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      return;
    } 
    a(40.0D, 40.0D, 8.75D, 2.5D, 10.0F, 5.0F);
  }
  
  public void a(boolean paramBoolean) {
    this.g.a(paramBoolean);
  }
  
  public void a(int... paramVarArgs) {
    this.g.a(paramVarArgs);
    this.g.b(0);
  }
  
  public void b(float paramFloat) {
    this.g.d(paramFloat);
  }
  
  public void b(int paramInt) {
    this.g.a(paramInt);
  }
  
  public void c(float paramFloat) {
    if (paramFloat < 0.4F)
      return; 
    paramFloat = (paramFloat - 0.4F) / 0.6F;
    setAlpha((int)(255.0F * paramFloat));
    a(true);
    a(0.0F, Math.min(0.8F, paramFloat * 0.8F));
    a(Math.min(1.0F, paramFloat));
    b((0.4F * paramFloat - 0.25F + paramFloat * 2.0F) * 0.5F);
  }
  
  public void c(int paramInt) {
    this.s += paramInt;
    invalidateSelf();
  }
  
  void d(float paramFloat) {
    this.h = paramFloat;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas) {
    Rect rect = getBounds();
    int i = paramCanvas.save();
    paramCanvas.translate(0.0F, this.s);
    this.r.draw(paramCanvas);
    paramCanvas.rotate(this.h, rect.exactCenterX(), rect.exactCenterY());
    this.g.a(paramCanvas, rect);
    paramCanvas.restoreToCount(i);
  }
  
  public int getAlpha() {
    return this.g.b();
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public boolean isRunning() {
    ArrayList<Animation> arrayList = this.f;
    int j = arrayList.size();
    for (int i = 0; i < j; i++) {
      Animation animation = arrayList.get(i);
      if (animation.hasStarted() && !animation.hasEnded())
        return true; 
    } 
    return false;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt) {
    this.g.c(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 = (paramInt3 - paramInt1) / 2;
    paramInt3 = this.t;
    super.setBounds(paramInt1 - paramInt3 / 2, paramInt2, paramInt1 + paramInt3 / 2, paramInt3 + paramInt2);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.g.a(paramColorFilter);
  }
  
  public void start() {
    this.k.reset();
    this.g.j();
    if (this.g.g() != this.g.d()) {
      this.j.startAnimation(this.o);
      return;
    } 
    this.g.b(0);
    this.g.k();
    this.j.startAnimation(this.k);
  }
  
  public void stop() {
    this.j.clearAnimation();
    d(0.0F);
    this.g.a(false);
    this.g.b(0);
    this.g.k();
  }
  
  static class EndCurveInterpolator extends AccelerateDecelerateInterpolator {
    private EndCurveInterpolator() {}
    
    public float getInterpolation(float param1Float) {
      return super.getInterpolation(Math.max(0.0F, (param1Float - 0.5F) * 2.0F));
    }
  }
  
  class OvalShadow extends OvalShape {
    private RadialGradient b;
    
    private int c;
    
    private Paint d = new Paint();
    
    private int e;
    
    public OvalShadow(MaterialDrawable this$0, int param1Int1, int param1Int2) {
      this.c = param1Int1;
      this.e = param1Int2;
      param1Int1 = this.e;
      float f1 = (param1Int1 / 2);
      float f2 = (param1Int1 / 2);
      float f3 = this.c;
      Shader.TileMode tileMode = Shader.TileMode.CLAMP;
      this.b = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, tileMode);
      this.d.setShader((Shader)this.b);
    }
    
    public void draw(Canvas param1Canvas, Paint param1Paint) {
      int i = this.a.getBounds().centerX();
      int j = this.a.getBounds().centerY();
      float f1 = i;
      float f2 = j;
      param1Canvas.drawCircle(f1, f2, (this.e / 2 + this.c), this.d);
      param1Canvas.drawCircle(f1, f2, (this.e / 2), param1Paint);
    }
  }
  
  @Retention(RetentionPolicy.CLASS)
  public static @interface ProgressDrawableSize {}
  
  static class Ring {
    private final RectF a = new RectF();
    
    private final Paint b = new Paint();
    
    private final Paint c = new Paint();
    
    private final Drawable.Callback d;
    
    private float e = 0.0F;
    
    private float f = 0.0F;
    
    private float g = 0.0F;
    
    private float h = 5.0F;
    
    private float i = 2.5F;
    
    private int[] j;
    
    private int k;
    
    private float l;
    
    private float m;
    
    private float n;
    
    private boolean o;
    
    private float p;
    
    private double q;
    
    private int r;
    
    private int s;
    
    private int t;
    
    private final Paint u = new Paint();
    
    private int v;
    
    public Ring(Drawable.Callback param1Callback) {
      this.d = param1Callback;
      this.b.setStrokeCap(Paint.Cap.SQUARE);
      this.b.setAntiAlias(true);
      this.b.setStyle(Paint.Style.STROKE);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setAntiAlias(true);
    }
    
    private void l() {
      this.d.invalidateDrawable(null);
    }
    
    public void a() {
      this.k = (this.k + 1) % this.j.length;
    }
    
    public void a(double param1Double) {
      this.q = param1Double;
    }
    
    public void a(float param1Float) {
      this.h = param1Float;
      this.b.setStrokeWidth(param1Float);
      l();
    }
    
    public void a(float param1Float1, float param1Float2) {
      this.r = (int)param1Float1;
      this.s = (int)param1Float2;
    }
    
    public void a(int param1Int) {
      this.v = param1Int;
    }
    
    public void a(int param1Int1, int param1Int2) {
      float f = Math.min(param1Int1, param1Int2);
      double d = this.q;
      if (d <= 0.0D || f < 0.0F) {
        d = Math.ceil((this.h / 2.0F));
      } else {
        d = (f / 2.0F) - d;
      } 
      this.i = (float)d;
    }
    
    public void a(Canvas param1Canvas, Rect param1Rect) {
      RectF rectF = this.a;
      rectF.set(param1Rect);
      float f1 = this.i;
      rectF.inset(f1, f1);
      float f2 = this.e;
      f1 = this.g;
      f2 = (f2 + f1) * 360.0F;
      float f3 = this.f;
      this.b.setColor(this.j[this.k]);
      param1Canvas.drawArc(rectF, f2, (f3 + f1) * 360.0F - f2, false, this.b);
      if (this.t < 255) {
        this.u.setColor(this.v);
        this.u.setAlpha(255 - this.t);
        param1Canvas.drawCircle(param1Rect.exactCenterX(), param1Rect.exactCenterY(), (param1Rect.width() / 2), this.u);
      } 
    }
    
    public void a(ColorFilter param1ColorFilter) {
      this.b.setColorFilter(param1ColorFilter);
      l();
    }
    
    public void a(boolean param1Boolean) {
      if (this.o != param1Boolean) {
        this.o = param1Boolean;
        l();
      } 
    }
    
    public void a(int[] param1ArrayOfint) {
      this.j = param1ArrayOfint;
      b(0);
    }
    
    public int b() {
      return this.t;
    }
    
    public void b(float param1Float) {
      this.e = param1Float;
      l();
    }
    
    public void b(int param1Int) {
      this.k = param1Int;
    }
    
    public float c() {
      return this.h;
    }
    
    public void c(float param1Float) {
      this.f = param1Float;
      l();
    }
    
    public void c(int param1Int) {
      this.t = param1Int;
    }
    
    public float d() {
      return this.e;
    }
    
    public void d(float param1Float) {
      this.g = param1Float;
      l();
    }
    
    public float e() {
      return this.l;
    }
    
    public void e(float param1Float) {
      if (param1Float != this.p) {
        this.p = param1Float;
        l();
      } 
    }
    
    public float f() {
      return this.m;
    }
    
    public float g() {
      return this.f;
    }
    
    public double h() {
      return this.q;
    }
    
    public float i() {
      return this.n;
    }
    
    public void j() {
      this.l = this.e;
      this.m = this.f;
      this.n = this.g;
    }
    
    public void k() {
      this.l = 0.0F;
      this.m = 0.0F;
      this.n = 0.0F;
      b(0.0F);
      c(0.0F);
      d(0.0F);
    }
  }
  
  static class StartCurveInterpolator extends AccelerateDecelerateInterpolator {
    private StartCurveInterpolator() {}
    
    public float getInterpolation(float param1Float) {
      return super.getInterpolation(Math.min(1.0F, param1Float * 2.0F));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\MaterialDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */