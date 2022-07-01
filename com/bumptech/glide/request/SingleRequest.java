package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, ResourceCallback, SizeReadyCallback {
  private static final boolean a = Log.isLoggable("Request", 2);
  
  private int A;
  
  private int B;
  
  private boolean C;
  
  private RuntimeException D;
  
  private final String b;
  
  private final StateVerifier c;
  
  private final Object d;
  
  private final RequestListener<R> e;
  
  private final RequestCoordinator f;
  
  private final Context g;
  
  private final GlideContext h;
  
  private final Object i;
  
  private final Class<R> j;
  
  private final BaseRequestOptions<?> k;
  
  private final int l;
  
  private final int m;
  
  private final Priority n;
  
  private final Target<R> o;
  
  private final List<RequestListener<R>> p;
  
  private final TransitionFactory<? super R> q;
  
  private final Executor r;
  
  private Resource<R> s;
  
  private Engine.LoadStatus t;
  
  private long u;
  
  private volatile Engine v;
  
  private Status w;
  
  private Drawable x;
  
  private Drawable y;
  
  private Drawable z;
  
  private SingleRequest(Context paramContext, GlideContext paramGlideContext, Object paramObject1, Object paramObject2, Class<R> paramClass, BaseRequestOptions<?> paramBaseRequestOptions, int paramInt1, int paramInt2, Priority paramPriority, Target<R> paramTarget, RequestListener<R> paramRequestListener, List<RequestListener<R>> paramList, RequestCoordinator paramRequestCoordinator, Engine paramEngine, TransitionFactory<? super R> paramTransitionFactory, Executor paramExecutor) {
    String str;
    if (a) {
      str = String.valueOf(hashCode());
    } else {
      str = null;
    } 
    this.b = str;
    this.c = StateVerifier.a();
    this.d = paramObject1;
    this.g = paramContext;
    this.h = paramGlideContext;
    this.i = paramObject2;
    this.j = paramClass;
    this.k = paramBaseRequestOptions;
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramPriority;
    this.o = paramTarget;
    this.e = paramRequestListener;
    this.p = paramList;
    this.f = paramRequestCoordinator;
    this.v = paramEngine;
    this.q = paramTransitionFactory;
    this.r = paramExecutor;
    this.w = Status.a;
    if (this.D == null && paramGlideContext.g())
      this.D = new RuntimeException("Glide request origin trace"); 
  }
  
  private static int a(int paramInt, float paramFloat) {
    return (paramInt == Integer.MIN_VALUE) ? paramInt : Math.round(paramFloat * paramInt);
  }
  
  private Drawable a(int paramInt) {
    Resources.Theme theme;
    if (this.k.z() != null) {
      theme = this.k.z();
    } else {
      theme = this.g.getTheme();
    } 
    return DrawableDecoderCompat.a((Context)this.h, paramInt, theme);
  }
  
  public static <R> SingleRequest<R> a(Context paramContext, GlideContext paramGlideContext, Object paramObject1, Object paramObject2, Class<R> paramClass, BaseRequestOptions<?> paramBaseRequestOptions, int paramInt1, int paramInt2, Priority paramPriority, Target<R> paramTarget, RequestListener<R> paramRequestListener, List<RequestListener<R>> paramList, RequestCoordinator paramRequestCoordinator, Engine paramEngine, TransitionFactory<? super R> paramTransitionFactory, Executor paramExecutor) {
    return new SingleRequest<R>(paramContext, paramGlideContext, paramObject1, paramObject2, paramClass, paramBaseRequestOptions, paramInt1, paramInt2, paramPriority, paramTarget, paramRequestListener, paramList, paramRequestCoordinator, paramEngine, paramTransitionFactory, paramExecutor);
  }
  
  private void a(GlideException paramGlideException, int paramInt) {
    this.c.b();
    synchronized (this.d) {
      paramGlideException.a(this.D);
      int i = this.h.e();
      if (i <= paramInt) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Load failed for ");
        stringBuilder.append(this.i);
        stringBuilder.append(" with size [");
        stringBuilder.append(this.A);
        stringBuilder.append("x");
        stringBuilder.append(this.B);
        stringBuilder.append("]");
        Log.w("Glide", stringBuilder.toString(), (Throwable)paramGlideException);
        if (i <= 4)
          paramGlideException.a("Glide"); 
      } 
      this.t = null;
      this.w = Status.e;
      boolean bool = true;
      this.C = true;
    } 
  }
  
  private void a(Resource<R> paramResource, R paramR, DataSource paramDataSource) {
    boolean bool1 = r();
    this.w = Status.d;
    this.s = paramResource;
    if (this.h.e() <= 3) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Finished loading ");
      stringBuilder.append(paramR.getClass().getSimpleName());
      stringBuilder.append(" from ");
      stringBuilder.append(paramDataSource);
      stringBuilder.append(" for ");
      stringBuilder.append(this.i);
      stringBuilder.append(" with size [");
      stringBuilder.append(this.A);
      stringBuilder.append("x");
      stringBuilder.append(this.B);
      stringBuilder.append("] in ");
      stringBuilder.append(LogTime.a(this.u));
      stringBuilder.append(" ms");
      Log.d("Glide", stringBuilder.toString());
    } 
    boolean bool = true;
    this.C = true;
  }
  
  private void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" this: ");
    stringBuilder.append(this.b);
    Log.v("Request", stringBuilder.toString());
  }
  
  private void i() {
    j();
    this.c.b();
    this.o.b(this);
    Engine.LoadStatus loadStatus = this.t;
    if (loadStatus != null) {
      loadStatus.a();
      this.t = null;
    } 
  }
  
  private void j() {
    if (!this.C)
      return; 
    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
  }
  
  private Drawable k() {
    if (this.x == null) {
      this.x = this.k.t();
      if (this.x == null && this.k.u() > 0)
        this.x = a(this.k.u()); 
    } 
    return this.x;
  }
  
  private Drawable l() {
    if (this.y == null) {
      this.y = this.k.w();
      if (this.y == null && this.k.v() > 0)
        this.y = a(this.k.v()); 
    } 
    return this.y;
  }
  
  private Drawable m() {
    if (this.z == null) {
      this.z = this.k.y();
      if (this.z == null && this.k.x() > 0)
        this.z = a(this.k.x()); 
    } 
    return this.z;
  }
  
  private void n() {
    if (!q())
      return; 
    Drawable drawable2 = null;
    if (this.i == null)
      drawable2 = m(); 
    Drawable drawable1 = drawable2;
    if (drawable2 == null)
      drawable1 = k(); 
    drawable2 = drawable1;
    if (drawable1 == null)
      drawable2 = l(); 
    this.o.b(drawable2);
  }
  
  private boolean o() {
    RequestCoordinator requestCoordinator = this.f;
    return (requestCoordinator == null || requestCoordinator.b(this));
  }
  
  private boolean p() {
    RequestCoordinator requestCoordinator = this.f;
    return (requestCoordinator == null || requestCoordinator.d(this));
  }
  
  private boolean q() {
    RequestCoordinator requestCoordinator = this.f;
    return (requestCoordinator == null || requestCoordinator.c(this));
  }
  
  private boolean r() {
    RequestCoordinator requestCoordinator = this.f;
    return (requestCoordinator == null || !requestCoordinator.h().g());
  }
  
  private void s() {
    RequestCoordinator requestCoordinator = this.f;
    if (requestCoordinator != null)
      requestCoordinator.e(this); 
  }
  
  private void t() {
    RequestCoordinator requestCoordinator = this.f;
    if (requestCoordinator != null)
      requestCoordinator.f(this); 
  }
  
  public void a() {
    synchronized (this.d) {
      j();
      this.c.b();
      this.u = LogTime.a();
      if (this.i == null) {
        byte b;
        if (Util.a(this.l, this.m)) {
          this.A = this.l;
          this.B = this.m;
        } 
        if (m() == null) {
          b = 5;
        } else {
          b = 3;
        } 
        a(new GlideException("Received null model"), b);
        return;
      } 
      if (this.w != Status.b) {
        if (this.w == Status.d) {
          a(this.s, DataSource.e);
          return;
        } 
        this.w = Status.c;
        if (Util.a(this.l, this.m)) {
          a(this.l, this.m);
        } else {
          this.o.a(this);
        } 
        if ((this.w == Status.b || this.w == Status.c) && q())
          this.o.a(l()); 
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("finished run method in ");
          stringBuilder.append(LogTime.a(this.u));
          a(stringBuilder.toString());
        } 
        return;
      } 
      throw new IllegalArgumentException("Cannot restart a running request");
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    Exception exception;
    this.c.b();
    Object object1 = this.d;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    try {
      if (a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got onSizeReady in ");
        stringBuilder.append(LogTime.a(this.u));
        a(stringBuilder.toString());
      } 
      if (this.w != Status.c) {
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
        return;
      } 
      this.w = Status.b;
      float f = this.k.H();
      this.A = a(paramInt1, f);
      this.B = a(paramInt2, f);
      if (a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("finished setup for calling load in ");
        stringBuilder.append(LogTime.a(this.u));
        a(stringBuilder.toString());
      } 
      Engine engine = this.v;
      GlideContext glideContext = this.h;
      Object object = this.i;
      Key key = this.k.B();
      paramInt1 = this.A;
      paramInt2 = this.B;
      Class<?> clazz = this.k.r();
      Class<R> clazz1 = this.j;
      Priority priority = this.n;
      DiskCacheStrategy diskCacheStrategy = this.k.s();
      Map<Class<?>, Transformation<?>> map = this.k.o();
      boolean bool1 = this.k.p();
      boolean bool2 = this.k.I();
      Options options = this.k.q();
      boolean bool3 = this.k.A();
      boolean bool4 = this.k.J();
      boolean bool5 = this.k.K();
      boolean bool6 = this.k.L();
      Executor executor = this.r;
      try {
        Engine.LoadStatus loadStatus = engine.a(glideContext, object, key, paramInt1, paramInt2, clazz, clazz1, priority, diskCacheStrategy, map, bool1, bool2, options, bool3, bool4, bool5, bool6, this, executor);
        Object object3 = object1;
        try {
          this.t = loadStatus;
          object3 = object1;
          if (this.w != Status.b) {
            object3 = object1;
            this.t = null;
          } 
          object3 = object1;
          if (a) {
            object3 = object1;
            StringBuilder stringBuilder = new StringBuilder();
            object3 = object1;
            stringBuilder.append("finished onSizeReady in ");
            object3 = object1;
            stringBuilder.append(LogTime.a(this.u));
            object3 = object1;
            a(stringBuilder.toString());
          } 
          object3 = object1;
          return;
        } finally {
          loadStatus = null;
        } 
      } finally {}
    } finally {}
    Object object2 = object1;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    throw exception;
  }
  
  public void a(GlideException paramGlideException) {
    a(paramGlideException, 5);
  }
  
  public void a(Resource<?> paramResource, DataSource paramDataSource) {
    Class<?> clazz1;
    this.c.b();
    Class<?> clazz2 = null;
    try {
      Object object = this.d;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      try {
        StringBuilder stringBuilder1;
        StringBuilder stringBuilder2;
        this.t = null;
        if (paramResource == null) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Expected to receive a Resource<R> with an object of ");
          stringBuilder1.append(this.j);
          stringBuilder1.append(" inside, but instead got null.");
          return;
        } 
        Object object1 = stringBuilder1.f();
        if (object1 == null || !this.j.isAssignableFrom(object1.getClass())) {
          String str;
          stringBuilder2 = stringBuilder1;
          this.s = null;
          stringBuilder2 = stringBuilder1;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder2 = stringBuilder1;
          stringBuilder.append("Expected to receive an object of ");
          stringBuilder2 = stringBuilder1;
          stringBuilder.append(this.j);
          stringBuilder2 = stringBuilder1;
          stringBuilder.append(" but instead got ");
          if (object1 != null) {
            stringBuilder2 = stringBuilder1;
            clazz2 = object1.getClass();
          } else {
            str = "";
          } 
          stringBuilder2 = stringBuilder1;
          stringBuilder.append(str);
          stringBuilder2 = stringBuilder1;
          stringBuilder.append("{");
          stringBuilder2 = stringBuilder1;
          stringBuilder.append(object1);
          stringBuilder2 = stringBuilder1;
          stringBuilder.append("} inside Resource{");
          stringBuilder2 = stringBuilder1;
          stringBuilder.append(stringBuilder1);
          stringBuilder2 = stringBuilder1;
          stringBuilder.append("}.");
          if (object1 != null) {
            str = "";
          } else {
            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
          } 
          stringBuilder2 = stringBuilder1;
          stringBuilder.append(str);
          stringBuilder2 = stringBuilder1;
          a(new GlideException(stringBuilder.toString()));
          stringBuilder2 = stringBuilder1;
          return;
        } 
        boolean bool = o();
      } finally {
        clazz2 = null;
      } 
      Resource<?> resource = paramResource;
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    } finally {
      paramDataSource = null;
    } 
    if (clazz1 != null)
      this.v.a((Resource)clazz1); 
    throw paramDataSource;
  }
  
  public boolean a(Request paramRequest) {
    if (!(paramRequest instanceof SingleRequest))
      return false; 
    synchronized (this.d) {
      boolean bool;
      int i = this.l;
      int j = this.m;
      null = this.i;
      Class<R> clazz = this.j;
      BaseRequestOptions<?> baseRequestOptions = this.k;
      Priority priority = this.n;
      if (this.p != null) {
        bool = this.p.size();
      } else {
        bool = false;
      } 
      null = paramRequest;
      synchronized (((SingleRequest)null).d) {
        boolean bool1;
        int k = ((SingleRequest)null).l;
        int m = ((SingleRequest)null).m;
        Object object = ((SingleRequest)null).i;
        Class<R> clazz1 = ((SingleRequest)null).j;
        BaseRequestOptions<?> baseRequestOptions1 = ((SingleRequest)null).k;
        Priority priority1 = ((SingleRequest)null).n;
        if (((SingleRequest)null).p != null) {
          bool1 = ((SingleRequest)null).p.size();
        } else {
          bool1 = false;
        } 
        return (i == k && j == m && Util.b(null, object) && clazz.equals(clazz1) && baseRequestOptions.equals(baseRequestOptions1) && priority == priority1 && bool == bool1);
      } 
    } 
  }
  
  public void b() {
    synchronized (this.d) {
      Resource resource;
      j();
      this.c.b();
      if (this.w == Status.f)
        return; 
      i();
      if (this.s != null) {
        resource = this.s;
        this.s = null;
      } else {
        resource = null;
      } 
      if (p())
        this.o.c(l()); 
      this.w = Status.f;
      if (resource != null)
        this.v.a(resource); 
      return;
    } 
  }
  
  public void c() {
    synchronized (this.d) {
      if (d())
        b(); 
      return;
    } 
  }
  
  public boolean d() {
    synchronized (this.d) {
      if (this.w == Status.b || this.w == Status.c)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean e() {
    synchronized (this.d) {
      if (this.w == Status.d)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean f() {
    synchronized (this.d) {
      if (this.w == Status.f)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean g() {
    synchronized (this.d) {
      if (this.w == Status.d)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public Object h() {
    this.c.b();
    return this.d;
  }
  
  enum Status {
    a, b, c, d, e, f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\SingleRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */