package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottieDrawable extends Drawable implements Animatable, Drawable.Callback {
  private static final String c = LottieDrawable.class.getSimpleName();
  
  FontAssetDelegate a;
  
  TextDelegate b;
  
  private final Matrix d = new Matrix();
  
  private LottieComposition e;
  
  private final LottieValueAnimator f = new LottieValueAnimator();
  
  private float g = 1.0F;
  
  private boolean h = true;
  
  private final Set<ColorFilterData> i = new HashSet<ColorFilterData>();
  
  private final ArrayList<LazyCompositionTask> j = new ArrayList<LazyCompositionTask>();
  
  private ImageAssetManager k;
  
  private String l;
  
  private ImageAssetDelegate m;
  
  private FontAssetManager n;
  
  private boolean o;
  
  private CompositionLayer p;
  
  private int q = 255;
  
  private boolean r;
  
  private boolean s = false;
  
  public LottieDrawable() {
    this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            if (LottieDrawable.a(this.a) != null)
              LottieDrawable.a(this.a).a(LottieDrawable.b(this.a).d()); 
          }
        });
  }
  
  private float a(Canvas paramCanvas) {
    return Math.min(paramCanvas.getWidth() / this.e.d().width(), paramCanvas.getHeight() / this.e.d().height());
  }
  
  private void v() {
    this.p = new CompositionLayer(this, LayerParser.a(this.e), this.e.i(), this.e);
  }
  
  private void w() {
    if (this.e == null)
      return; 
    float f = q();
    setBounds(0, 0, (int)(this.e.d().width() * f), (int)(this.e.d().height() * f));
  }
  
  private ImageAssetManager x() {
    if (getCallback() == null)
      return null; 
    ImageAssetManager imageAssetManager = this.k;
    if (imageAssetManager != null && !imageAssetManager.a(z()))
      this.k = null; 
    if (this.k == null)
      this.k = new ImageAssetManager(getCallback(), this.l, this.m, this.e.l()); 
    return this.k;
  }
  
  private FontAssetManager y() {
    if (getCallback() == null)
      return null; 
    if (this.n == null)
      this.n = new FontAssetManager(getCallback(), this.a); 
    return this.n;
  }
  
  private Context z() {
    Drawable.Callback callback = getCallback();
    return (callback == null) ? null : ((callback instanceof View) ? ((View)callback).getContext() : null);
  }
  
  public Typeface a(String paramString1, String paramString2) {
    FontAssetManager fontAssetManager = y();
    return (fontAssetManager != null) ? fontAssetManager.a(paramString1, paramString2) : null;
  }
  
  public List<KeyPath> a(KeyPath paramKeyPath) {
    if (this.p == null) {
      Logger.b("Cannot resolve KeyPath. Composition is not set yet.");
      return Collections.emptyList();
    } 
    ArrayList<KeyPath> arrayList = new ArrayList();
    this.p.a(paramKeyPath, 0, arrayList, new KeyPath(new String[0]));
    return arrayList;
  }
  
  public void a(float paramFloat) {
    LottieComposition lottieComposition = this.e;
    if (lottieComposition == null) {
      this.j.add(new LazyCompositionTask(this, paramFloat) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.a(this.a);
            }
          });
      return;
    } 
    a((int)MiscUtils.a(lottieComposition.f(), this.e.g(), paramFloat));
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    LottieComposition lottieComposition = this.e;
    if (lottieComposition == null) {
      this.j.add(new LazyCompositionTask(this, paramFloat1, paramFloat2) {
            public void a(LottieComposition param1LottieComposition) {
              this.c.a(this.a, this.b);
            }
          });
      return;
    } 
    a((int)MiscUtils.a(lottieComposition.f(), this.e.g(), paramFloat1), (int)MiscUtils.a(this.e.f(), this.e.g(), paramFloat2));
  }
  
  public void a(int paramInt) {
    if (this.e == null) {
      this.j.add(new LazyCompositionTask(this, paramInt) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.a(this.a);
            }
          });
      return;
    } 
    this.f.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (this.e == null) {
      this.j.add(new LazyCompositionTask(this, paramInt1, paramInt2) {
            public void a(LottieComposition param1LottieComposition) {
              this.c.a(this.a, this.b);
            }
          });
      return;
    } 
    this.f.a(paramInt1, paramInt2 + 0.99F);
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener) {
    this.f.addListener(paramAnimatorListener);
  }
  
  public void a(FontAssetDelegate paramFontAssetDelegate) {
    this.a = paramFontAssetDelegate;
    FontAssetManager fontAssetManager = this.n;
    if (fontAssetManager != null)
      fontAssetManager.a(paramFontAssetDelegate); 
  }
  
  public void a(ImageAssetDelegate paramImageAssetDelegate) {
    this.m = paramImageAssetDelegate;
    ImageAssetManager imageAssetManager = this.k;
    if (imageAssetManager != null)
      imageAssetManager.a(paramImageAssetDelegate); 
  }
  
  public void a(TextDelegate paramTextDelegate) {
    this.b = paramTextDelegate;
  }
  
  public <T> void a(KeyPath paramKeyPath, T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    if (this.p == null) {
      this.j.add(new LazyCompositionTask(this, paramKeyPath, paramT, paramLottieValueCallback) {
            public void a(LottieComposition param1LottieComposition) {
              this.d.a(this.a, this.b, this.c);
            }
          });
      return;
    } 
    KeyPathElement keyPathElement = paramKeyPath.a();
    int i = 1;
    if (keyPathElement != null) {
      paramKeyPath.a().a(paramT, paramLottieValueCallback);
    } else {
      List<KeyPath> list = a(paramKeyPath);
      for (i = 0; i < list.size(); i++)
        ((KeyPath)list.get(i)).a().a(paramT, paramLottieValueCallback); 
      i = true ^ list.isEmpty();
    } 
    if (i != 0) {
      invalidateSelf();
      if (paramT == LottieProperty.A)
        d(u()); 
    } 
  }
  
  void a(Boolean paramBoolean) {
    this.h = paramBoolean.booleanValue();
  }
  
  public void a(String paramString) {
    this.l = paramString;
  }
  
  public void a(boolean paramBoolean) {
    if (this.o == paramBoolean)
      return; 
    if (Build.VERSION.SDK_INT < 19) {
      Logger.b("Merge paths are not supported pre-Kit Kat.");
      return;
    } 
    this.o = paramBoolean;
    if (this.e != null)
      v(); 
  }
  
  public boolean a() {
    return this.o;
  }
  
  public boolean a(LottieComposition paramLottieComposition) {
    if (this.e == paramLottieComposition)
      return false; 
    this.s = false;
    d();
    this.e = paramLottieComposition;
    v();
    this.f.a(paramLottieComposition);
    d(this.f.getAnimatedFraction());
    e(this.g);
    w();
    Iterator<?> iterator = (new ArrayList(this.j)).iterator();
    while (iterator.hasNext()) {
      ((LazyCompositionTask)iterator.next()).a(paramLottieComposition);
      iterator.remove();
    } 
    this.j.clear();
    paramLottieComposition.b(this.r);
    return true;
  }
  
  public String b() {
    return this.l;
  }
  
  public void b(float paramFloat) {
    LottieComposition lottieComposition = this.e;
    if (lottieComposition == null) {
      this.j.add(new LazyCompositionTask(this, paramFloat) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.b(this.a);
            }
          });
      return;
    } 
    b((int)MiscUtils.a(lottieComposition.f(), this.e.g(), paramFloat));
  }
  
  public void b(int paramInt) {
    if (this.e == null) {
      this.j.add(new LazyCompositionTask(this, paramInt) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.b(this.a);
            }
          });
      return;
    } 
    this.f.a(paramInt + 0.99F);
  }
  
  public void b(String paramString) {
    LottieComposition lottieComposition = this.e;
    if (lottieComposition == null) {
      this.j.add(new LazyCompositionTask(this, paramString) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.b(this.a);
            }
          });
      return;
    } 
    Marker marker = lottieComposition.c(paramString);
    if (marker != null) {
      a((int)marker.a);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot find marker with name ");
    stringBuilder.append(paramString);
    stringBuilder.append(".");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void b(boolean paramBoolean) {
    this.r = paramBoolean;
    LottieComposition lottieComposition = this.e;
    if (lottieComposition != null)
      lottieComposition.b(paramBoolean); 
  }
  
  public PerformanceTracker c() {
    LottieComposition lottieComposition = this.e;
    return (lottieComposition != null) ? lottieComposition.c() : null;
  }
  
  public void c(float paramFloat) {
    this.f.b(paramFloat);
  }
  
  public void c(int paramInt) {
    if (this.e == null) {
      this.j.add(new LazyCompositionTask(this, paramInt) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.c(this.a);
            }
          });
      return;
    } 
    this.f.a(paramInt);
  }
  
  public void c(String paramString) {
    LottieComposition lottieComposition = this.e;
    if (lottieComposition == null) {
      this.j.add(new LazyCompositionTask(this, paramString) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.c(this.a);
            }
          });
      return;
    } 
    Marker marker = lottieComposition.c(paramString);
    if (marker != null) {
      b((int)(marker.a + marker.b));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot find marker with name ");
    stringBuilder.append(paramString);
    stringBuilder.append(".");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void d() {
    if (this.f.isRunning())
      this.f.cancel(); 
    this.e = null;
    this.p = null;
    this.k = null;
    this.f.f();
    invalidateSelf();
  }
  
  public void d(float paramFloat) {
    LottieComposition lottieComposition = this.e;
    if (lottieComposition == null) {
      this.j.add(new LazyCompositionTask(this, paramFloat) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.d(this.a);
            }
          });
      return;
    } 
    c((int)MiscUtils.a(lottieComposition.f(), this.e.g(), paramFloat));
  }
  
  public void d(int paramInt) {
    this.f.setRepeatMode(paramInt);
  }
  
  public void d(String paramString) {
    LottieComposition lottieComposition = this.e;
    if (lottieComposition == null) {
      this.j.add(new LazyCompositionTask(this, paramString) {
            public void a(LottieComposition param1LottieComposition) {
              this.b.d(this.a);
            }
          });
      return;
    } 
    Marker marker = lottieComposition.c(paramString);
    if (marker != null) {
      int i = (int)marker.a;
      a(i, (int)marker.b + i);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot find marker with name ");
    stringBuilder.append(paramString);
    stringBuilder.append(".");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void draw(Canvas paramCanvas) {
    this.s = false;
    L.a("Drawable#draw");
    if (this.p == null)
      return; 
    float f1 = this.g;
    float f2 = a(paramCanvas);
    if (f1 > f2) {
      f1 = this.g / f2;
    } else {
      f2 = f1;
      f1 = 1.0F;
    } 
    int i = -1;
    if (f1 > 1.0F) {
      i = paramCanvas.save();
      float f3 = this.e.d().width() / 2.0F;
      float f4 = this.e.d().height() / 2.0F;
      float f5 = f3 * f2;
      float f6 = f4 * f2;
      paramCanvas.translate(q() * f3 - f5, q() * f4 - f6);
      paramCanvas.scale(f1, f1, f5, f6);
    } 
    this.d.reset();
    this.d.preScale(f2, f2);
    this.p.a(paramCanvas, this.d, this.q);
    L.b("Drawable#draw");
    if (i > 0)
      paramCanvas.restoreToCount(i); 
  }
  
  public Bitmap e(String paramString) {
    ImageAssetManager imageAssetManager = x();
    return (imageAssetManager != null) ? imageAssetManager.a(paramString) : null;
  }
  
  public void e() {
    if (this.p == null) {
      this.j.add(new LazyCompositionTask(this) {
            public void a(LottieComposition param1LottieComposition) {
              this.a.e();
            }
          });
      return;
    } 
    if (this.h || m() == 0)
      this.f.i(); 
    if (!this.h) {
      float f;
      if (j() < 0.0F) {
        f = h();
      } else {
        f = i();
      } 
      c((int)f);
    } 
  }
  
  public void e(float paramFloat) {
    this.g = paramFloat;
    w();
  }
  
  public void e(int paramInt) {
    this.f.setRepeatCount(paramInt);
  }
  
  public void f() {
    this.j.clear();
    this.f.j();
  }
  
  public void g() {
    if (this.p == null) {
      this.j.add(new LazyCompositionTask(this) {
            public void a(LottieComposition param1LottieComposition) {
              this.a.g();
            }
          });
      return;
    } 
    this.f.l();
  }
  
  public int getAlpha() {
    return this.q;
  }
  
  public int getIntrinsicHeight() {
    LottieComposition lottieComposition = this.e;
    return (lottieComposition == null) ? -1 : (int)(lottieComposition.d().height() * q());
  }
  
  public int getIntrinsicWidth() {
    LottieComposition lottieComposition = this.e;
    return (lottieComposition == null) ? -1 : (int)(lottieComposition.d().width() * q());
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public float h() {
    return this.f.m();
  }
  
  public float i() {
    return this.f.n();
  }
  
  public void invalidateDrawable(Drawable paramDrawable) {
    Drawable.Callback callback = getCallback();
    if (callback == null)
      return; 
    callback.invalidateDrawable(this);
  }
  
  public void invalidateSelf() {
    if (this.s)
      return; 
    this.s = true;
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.invalidateDrawable(this); 
  }
  
  public boolean isRunning() {
    return n();
  }
  
  public float j() {
    return this.f.h();
  }
  
  public int k() {
    return (int)this.f.e();
  }
  
  public int l() {
    return this.f.getRepeatMode();
  }
  
  public int m() {
    return this.f.getRepeatCount();
  }
  
  public boolean n() {
    return this.f.isRunning();
  }
  
  public TextDelegate o() {
    return this.b;
  }
  
  public boolean p() {
    return (this.b == null && this.e.j().size() > 0);
  }
  
  public float q() {
    return this.g;
  }
  
  public LottieComposition r() {
    return this.e;
  }
  
  public void s() {
    this.j.clear();
    this.f.cancel();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
    Drawable.Callback callback = getCallback();
    if (callback == null)
      return; 
    callback.scheduleDrawable(this, paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt) {
    this.q = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    Logger.b("Use addColorFilter instead.");
  }
  
  public void start() {
    e();
  }
  
  public void stop() {
    f();
  }
  
  public void t() {
    this.j.clear();
    this.f.k();
  }
  
  public float u() {
    return this.f.d();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    Drawable.Callback callback = getCallback();
    if (callback == null)
      return; 
    callback.unscheduleDrawable(this, paramRunnable);
  }
  
  static class ColorFilterData {
    final String a;
    
    final String b;
    
    final ColorFilter c;
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (!(param1Object instanceof ColorFilterData))
        return false; 
      param1Object = param1Object;
      return (hashCode() == param1Object.hashCode() && this.c == ((ColorFilterData)param1Object).c);
    }
    
    public int hashCode() {
      byte b;
      String str = this.a;
      if (str != null) {
        b = 527 * str.hashCode();
      } else {
        b = 17;
      } 
      str = this.b;
      int i = b;
      if (str != null)
        i = b * 31 * str.hashCode(); 
      return i;
    }
  }
  
  static interface LazyCompositionTask {
    void a(LottieComposition param1LottieComposition);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RepeatMode {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\LottieDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */