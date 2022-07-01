package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
  private int a;
  
  private float b = 1.0F;
  
  private DiskCacheStrategy c = DiskCacheStrategy.e;
  
  private Priority d = Priority.c;
  
  private Drawable e;
  
  private int f;
  
  private Drawable g;
  
  private int h;
  
  private boolean i = true;
  
  private int j = -1;
  
  private int k = -1;
  
  private Key l = (Key)EmptySignature.a();
  
  private boolean m;
  
  private boolean n = true;
  
  private Drawable o;
  
  private int p;
  
  private Options q = new Options();
  
  private Map<Class<?>, Transformation<?>> r = (Map<Class<?>, Transformation<?>>)new CachedHashCodeArrayMap();
  
  private Class<?> s = Object.class;
  
  private boolean t;
  
  private Resources.Theme u;
  
  private boolean v;
  
  private boolean w;
  
  private boolean x;
  
  private boolean y = true;
  
  private boolean z;
  
  private T a() {
    if (!this.t)
      return b(); 
    throw new IllegalStateException("You cannot modify locked T, consider clone()");
  }
  
  private T a(DownsampleStrategy paramDownsampleStrategy, Transformation<Bitmap> paramTransformation, boolean paramBoolean) {
    if (paramBoolean) {
      paramDownsampleStrategy = (DownsampleStrategy)b(paramDownsampleStrategy, paramTransformation);
    } else {
      paramDownsampleStrategy = (DownsampleStrategy)a(paramDownsampleStrategy, paramTransformation);
    } 
    ((BaseRequestOptions)paramDownsampleStrategy).y = true;
    return (T)paramDownsampleStrategy;
  }
  
  private boolean a(int paramInt) {
    return a(this.a, paramInt);
  }
  
  private static boolean a(int paramInt1, int paramInt2) {
    return ((paramInt1 & paramInt2) != 0);
  }
  
  private T b() {
    return (T)this;
  }
  
  private T c(DownsampleStrategy paramDownsampleStrategy, Transformation<Bitmap> paramTransformation) {
    return a(paramDownsampleStrategy, paramTransformation, false);
  }
  
  public final boolean A() {
    return this.i;
  }
  
  public final Key B() {
    return this.l;
  }
  
  public final boolean C() {
    return a(8);
  }
  
  public final Priority D() {
    return this.d;
  }
  
  public final int E() {
    return this.k;
  }
  
  public final boolean F() {
    return Util.a(this.k, this.j);
  }
  
  public final int G() {
    return this.j;
  }
  
  public final float H() {
    return this.b;
  }
  
  boolean I() {
    return this.y;
  }
  
  public final boolean J() {
    return this.w;
  }
  
  public final boolean K() {
    return this.z;
  }
  
  public final boolean L() {
    return this.x;
  }
  
  T a(Transformation<Bitmap> paramTransformation, boolean paramBoolean) {
    if (this.v)
      return l().a(paramTransformation, paramBoolean); 
    DrawableTransformation drawableTransformation = new DrawableTransformation(paramTransformation, paramBoolean);
    a(Bitmap.class, paramTransformation, paramBoolean);
    a(Drawable.class, (Transformation<Drawable>)drawableTransformation, paramBoolean);
    a(BitmapDrawable.class, drawableTransformation.a(), paramBoolean);
    a(GifDrawable.class, (Transformation<GifDrawable>)new GifDrawableTransformation(paramTransformation), paramBoolean);
    return a();
  }
  
  final T a(DownsampleStrategy paramDownsampleStrategy, Transformation<Bitmap> paramTransformation) {
    if (this.v)
      return l().a(paramDownsampleStrategy, paramTransformation); 
    b(paramDownsampleStrategy);
    return a(paramTransformation, false);
  }
  
  <Y> T a(Class<Y> paramClass, Transformation<Y> paramTransformation, boolean paramBoolean) {
    if (this.v)
      return l().a(paramClass, paramTransformation, paramBoolean); 
    Preconditions.a(paramClass);
    Preconditions.a(paramTransformation);
    this.r.put(paramClass, paramTransformation);
    this.a |= 0x800;
    this.n = true;
    this.a |= 0x10000;
    this.y = false;
    if (paramBoolean) {
      this.a |= 0x20000;
      this.m = true;
    } 
    return a();
  }
  
  public T b(float paramFloat) {
    if (this.v)
      return l().b(paramFloat); 
    if (paramFloat >= 0.0F && paramFloat <= 1.0F) {
      this.b = paramFloat;
      this.a |= 0x2;
      return a();
    } 
    throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
  }
  
  public T b(int paramInt1, int paramInt2) {
    if (this.v)
      return l().b(paramInt1, paramInt2); 
    this.k = paramInt1;
    this.j = paramInt2;
    this.a |= 0x200;
    return a();
  }
  
  public T b(Drawable paramDrawable) {
    if (this.v)
      return l().b(paramDrawable); 
    this.g = paramDrawable;
    this.a |= 0x40;
    this.h = 0;
    this.a &= 0xFFFFFF7F;
    return a();
  }
  
  public T b(Priority paramPriority) {
    if (this.v)
      return l().b(paramPriority); 
    this.d = (Priority)Preconditions.a(paramPriority);
    this.a |= 0x8;
    return a();
  }
  
  public T b(Key paramKey) {
    if (this.v)
      return l().b(paramKey); 
    this.l = (Key)Preconditions.a(paramKey);
    this.a |= 0x400;
    return a();
  }
  
  public <Y> T b(Option<Y> paramOption, Y paramY) {
    if (this.v)
      return l().b(paramOption, paramY); 
    Preconditions.a(paramOption);
    Preconditions.a(paramY);
    this.q.a(paramOption, paramY);
    return a();
  }
  
  public T b(Transformation<Bitmap> paramTransformation) {
    return a(paramTransformation, true);
  }
  
  public T b(DiskCacheStrategy paramDiskCacheStrategy) {
    if (this.v)
      return l().b(paramDiskCacheStrategy); 
    this.c = (DiskCacheStrategy)Preconditions.a(paramDiskCacheStrategy);
    this.a |= 0x4;
    return a();
  }
  
  public T b(DownsampleStrategy paramDownsampleStrategy) {
    return b(DownsampleStrategy.h, Preconditions.a(paramDownsampleStrategy));
  }
  
  final T b(DownsampleStrategy paramDownsampleStrategy, Transformation<Bitmap> paramTransformation) {
    if (this.v)
      return l().b(paramDownsampleStrategy, paramTransformation); 
    b(paramDownsampleStrategy);
    return b(paramTransformation);
  }
  
  public T b(BaseRequestOptions<?> paramBaseRequestOptions) {
    if (this.v)
      return l().b(paramBaseRequestOptions); 
    if (a(paramBaseRequestOptions.a, 2))
      this.b = paramBaseRequestOptions.b; 
    if (a(paramBaseRequestOptions.a, 262144))
      this.w = paramBaseRequestOptions.w; 
    if (a(paramBaseRequestOptions.a, 1048576))
      this.z = paramBaseRequestOptions.z; 
    if (a(paramBaseRequestOptions.a, 4))
      this.c = paramBaseRequestOptions.c; 
    if (a(paramBaseRequestOptions.a, 8))
      this.d = paramBaseRequestOptions.d; 
    if (a(paramBaseRequestOptions.a, 16)) {
      this.e = paramBaseRequestOptions.e;
      this.f = 0;
      this.a &= 0xFFFFFFDF;
    } 
    if (a(paramBaseRequestOptions.a, 32)) {
      this.f = paramBaseRequestOptions.f;
      this.e = null;
      this.a &= 0xFFFFFFEF;
    } 
    if (a(paramBaseRequestOptions.a, 64)) {
      this.g = paramBaseRequestOptions.g;
      this.h = 0;
      this.a &= 0xFFFFFF7F;
    } 
    if (a(paramBaseRequestOptions.a, 128)) {
      this.h = paramBaseRequestOptions.h;
      this.g = null;
      this.a &= 0xFFFFFFBF;
    } 
    if (a(paramBaseRequestOptions.a, 256))
      this.i = paramBaseRequestOptions.i; 
    if (a(paramBaseRequestOptions.a, 512)) {
      this.k = paramBaseRequestOptions.k;
      this.j = paramBaseRequestOptions.j;
    } 
    if (a(paramBaseRequestOptions.a, 1024))
      this.l = paramBaseRequestOptions.l; 
    if (a(paramBaseRequestOptions.a, 4096))
      this.s = paramBaseRequestOptions.s; 
    if (a(paramBaseRequestOptions.a, 8192)) {
      this.o = paramBaseRequestOptions.o;
      this.p = 0;
      this.a &= 0xFFFFBFFF;
    } 
    if (a(paramBaseRequestOptions.a, 16384)) {
      this.p = paramBaseRequestOptions.p;
      this.o = null;
      this.a &= 0xFFFFDFFF;
    } 
    if (a(paramBaseRequestOptions.a, 32768))
      this.u = paramBaseRequestOptions.u; 
    if (a(paramBaseRequestOptions.a, 65536))
      this.n = paramBaseRequestOptions.n; 
    if (a(paramBaseRequestOptions.a, 131072))
      this.m = paramBaseRequestOptions.m; 
    if (a(paramBaseRequestOptions.a, 2048)) {
      this.r.putAll(paramBaseRequestOptions.r);
      this.y = paramBaseRequestOptions.y;
    } 
    if (a(paramBaseRequestOptions.a, 524288))
      this.x = paramBaseRequestOptions.x; 
    if (!this.n) {
      this.r.clear();
      this.a &= 0xFFFFF7FF;
      this.m = false;
      this.a &= 0xFFFDFFFF;
      this.y = true;
    } 
    this.a |= paramBaseRequestOptions.a;
    this.q.a(paramBaseRequestOptions.q);
    return a();
  }
  
  public T b(Class<?> paramClass) {
    if (this.v)
      return l().b(paramClass); 
    this.s = (Class)Preconditions.a(paramClass);
    this.a |= 0x1000;
    return a();
  }
  
  public T b(Transformation<Bitmap>... paramVarArgs) {
    return (paramVarArgs.length > 1) ? a((Transformation<Bitmap>)new MultiTransformation((Transformation[])paramVarArgs), true) : ((paramVarArgs.length == 1) ? b(paramVarArgs[0]) : a());
  }
  
  public T d(boolean paramBoolean) {
    if (this.v)
      return l().d(true); 
    this.i = paramBoolean ^ true;
    this.a |= 0x100;
    return a();
  }
  
  public T e(int paramInt) {
    return b(paramInt, paramInt);
  }
  
  public T e(boolean paramBoolean) {
    if (this.v)
      return l().e(paramBoolean); 
    this.x = paramBoolean;
    this.a |= 0x80000;
    return a();
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof BaseRequestOptions;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (Float.compare(((BaseRequestOptions)paramObject).b, this.b) == 0) {
        bool1 = bool2;
        if (this.f == ((BaseRequestOptions)paramObject).f) {
          bool1 = bool2;
          if (Util.a(this.e, ((BaseRequestOptions)paramObject).e)) {
            bool1 = bool2;
            if (this.h == ((BaseRequestOptions)paramObject).h) {
              bool1 = bool2;
              if (Util.a(this.g, ((BaseRequestOptions)paramObject).g)) {
                bool1 = bool2;
                if (this.p == ((BaseRequestOptions)paramObject).p) {
                  bool1 = bool2;
                  if (Util.a(this.o, ((BaseRequestOptions)paramObject).o)) {
                    bool1 = bool2;
                    if (this.i == ((BaseRequestOptions)paramObject).i) {
                      bool1 = bool2;
                      if (this.j == ((BaseRequestOptions)paramObject).j) {
                        bool1 = bool2;
                        if (this.k == ((BaseRequestOptions)paramObject).k) {
                          bool1 = bool2;
                          if (this.m == ((BaseRequestOptions)paramObject).m) {
                            bool1 = bool2;
                            if (this.n == ((BaseRequestOptions)paramObject).n) {
                              bool1 = bool2;
                              if (this.w == ((BaseRequestOptions)paramObject).w) {
                                bool1 = bool2;
                                if (this.x == ((BaseRequestOptions)paramObject).x) {
                                  bool1 = bool2;
                                  if (this.c.equals(((BaseRequestOptions)paramObject).c)) {
                                    bool1 = bool2;
                                    if (this.d == ((BaseRequestOptions)paramObject).d) {
                                      bool1 = bool2;
                                      if (this.q.equals(((BaseRequestOptions)paramObject).q)) {
                                        bool1 = bool2;
                                        if (this.r.equals(((BaseRequestOptions)paramObject).r)) {
                                          bool1 = bool2;
                                          if (this.s.equals(((BaseRequestOptions)paramObject).s)) {
                                            bool1 = bool2;
                                            if (Util.a(this.l, ((BaseRequestOptions)paramObject).l)) {
                                              bool1 = bool2;
                                              if (Util.a(this.u, ((BaseRequestOptions)paramObject).u))
                                                bool1 = true; 
                                            } 
                                          } 
                                        } 
                                      } 
                                    } 
                                  } 
                                } 
                              } 
                            } 
                          } 
                        } 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public T f(int paramInt) {
    if (this.v)
      return l().f(paramInt); 
    this.f = paramInt;
    this.a |= 0x20;
    this.e = null;
    this.a &= 0xFFFFFFEF;
    return a();
  }
  
  public T f(boolean paramBoolean) {
    if (this.v)
      return l().f(paramBoolean); 
    this.z = paramBoolean;
    this.a |= 0x100000;
    return a();
  }
  
  public T g() {
    if (!this.t || this.v) {
      this.v = true;
      return h();
    } 
    throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
  }
  
  public T g(int paramInt) {
    if (this.v)
      return l().g(paramInt); 
    this.p = paramInt;
    this.a |= 0x4000;
    this.o = null;
    this.a &= 0xFFFFDFFF;
    return a();
  }
  
  public T h() {
    this.t = true;
    return b();
  }
  
  public T h(int paramInt) {
    if (this.v)
      return l().h(paramInt); 
    this.h = paramInt;
    this.a |= 0x80;
    this.g = null;
    this.a &= 0xFFFFFFBF;
    return a();
  }
  
  public int hashCode() {
    int i = Util.a(this.b);
    i = Util.b(this.f, i);
    i = Util.a(this.e, i);
    i = Util.b(this.h, i);
    i = Util.a(this.g, i);
    i = Util.b(this.p, i);
    i = Util.a(this.o, i);
    i = Util.a(this.i, i);
    i = Util.b(this.j, i);
    i = Util.b(this.k, i);
    i = Util.a(this.m, i);
    i = Util.a(this.n, i);
    i = Util.a(this.w, i);
    i = Util.a(this.x, i);
    i = Util.a(this.c, i);
    i = Util.a(this.d, i);
    i = Util.a(this.q, i);
    i = Util.a(this.r, i);
    i = Util.a(this.s, i);
    i = Util.a(this.l, i);
    return Util.a(this.u, i);
  }
  
  public T i() {
    return c(DownsampleStrategy.d, (Transformation<Bitmap>)new CenterInside());
  }
  
  public T j() {
    return c(DownsampleStrategy.c, (Transformation<Bitmap>)new FitCenter());
  }
  
  public T k() {
    return a(DownsampleStrategy.e, (Transformation<Bitmap>)new CenterCrop());
  }
  
  public T l() {
    try {
      BaseRequestOptions baseRequestOptions = (BaseRequestOptions)super.clone();
      baseRequestOptions.q = new Options();
      baseRequestOptions.q.a(this.q);
      baseRequestOptions.r = (Map<Class<?>, Transformation<?>>)new CachedHashCodeArrayMap();
      baseRequestOptions.r.putAll(this.r);
      baseRequestOptions.t = false;
      baseRequestOptions.v = false;
      return (T)baseRequestOptions;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new RuntimeException(cloneNotSupportedException);
    } 
  }
  
  public final boolean m() {
    return this.n;
  }
  
  public final boolean n() {
    return a(2048);
  }
  
  public final Map<Class<?>, Transformation<?>> o() {
    return this.r;
  }
  
  public final boolean p() {
    return this.m;
  }
  
  public final Options q() {
    return this.q;
  }
  
  public final Class<?> r() {
    return this.s;
  }
  
  public final DiskCacheStrategy s() {
    return this.c;
  }
  
  public final Drawable t() {
    return this.e;
  }
  
  public final int u() {
    return this.f;
  }
  
  public final int v() {
    return this.h;
  }
  
  public final Drawable w() {
    return this.g;
  }
  
  public final int x() {
    return this.p;
  }
  
  public final Drawable y() {
    return this.o;
  }
  
  public final Resources.Theme z() {
    return this.u;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\BaseRequestOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */