package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager implements ComponentCallbacks2, ModelTypes<RequestBuilder<Drawable>>, LifecycleListener {
  private static final RequestOptions d = (RequestOptions)RequestOptions.c(Bitmap.class).h();
  
  private static final RequestOptions e = (RequestOptions)RequestOptions.c(GifDrawable.class).h();
  
  private static final RequestOptions f = (RequestOptions)((RequestOptions)RequestOptions.c(DiskCacheStrategy.c).b(Priority.d)).d(true);
  
  protected final Glide a;
  
  protected final Context b;
  
  final Lifecycle c;
  
  private final RequestTracker g;
  
  private final RequestManagerTreeNode h;
  
  private final TargetTracker i = new TargetTracker();
  
  private final Runnable j = new Runnable(this) {
      public void run() {
        this.a.c.a(this.a);
      }
    };
  
  private final Handler k = new Handler(Looper.getMainLooper());
  
  private final ConnectivityMonitor l;
  
  private final CopyOnWriteArrayList<RequestListener<Object>> m;
  
  private RequestOptions n;
  
  private boolean o;
  
  public RequestManager(Glide paramGlide, Lifecycle paramLifecycle, RequestManagerTreeNode paramRequestManagerTreeNode, Context paramContext) {
    this(paramGlide, paramLifecycle, paramRequestManagerTreeNode, new RequestTracker(), paramGlide.d(), paramContext);
  }
  
  RequestManager(Glide paramGlide, Lifecycle paramLifecycle, RequestManagerTreeNode paramRequestManagerTreeNode, RequestTracker paramRequestTracker, ConnectivityMonitorFactory paramConnectivityMonitorFactory, Context paramContext) {
    this.a = paramGlide;
    this.c = paramLifecycle;
    this.h = paramRequestManagerTreeNode;
    this.g = paramRequestTracker;
    this.b = paramContext;
    this.l = paramConnectivityMonitorFactory.a(paramContext.getApplicationContext(), new RequestManagerConnectivityListener(this, paramRequestTracker));
    if (Util.d()) {
      this.k.post(this.j);
    } else {
      paramLifecycle.a(this);
    } 
    paramLifecycle.a((LifecycleListener)this.l);
    this.m = new CopyOnWriteArrayList<RequestListener<Object>>(paramGlide.e().a());
    a(paramGlide.e().b());
    paramGlide.a(this);
  }
  
  private void c(Target<?> paramTarget) {
    boolean bool = b(paramTarget);
    Request request = paramTarget.a();
    if (!bool && !this.a.a(paramTarget) && request != null) {
      paramTarget.a(null);
      request.b();
    } 
  }
  
  public void a(View paramView) {
    a((Target<?>)new ClearTarget(paramView));
  }
  
  public void a(RequestOptions paramRequestOptions) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual l : ()Lcom/bumptech/glide/request/BaseRequestOptions;
    //   7: checkcast com/bumptech/glide/request/RequestOptions
    //   10: invokevirtual g : ()Lcom/bumptech/glide/request/BaseRequestOptions;
    //   13: checkcast com/bumptech/glide/request/RequestOptions
    //   16: putfield n : Lcom/bumptech/glide/request/RequestOptions;
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	22	finally
  }
  
  public void a(Target<?> paramTarget) {
    if (paramTarget == null)
      return; 
    c(paramTarget);
  }
  
  void a(Target<?> paramTarget, Request paramRequest) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Lcom/bumptech/glide/manager/TargetTracker;
    //   6: aload_1
    //   7: invokevirtual a : (Lcom/bumptech/glide/request/target/Target;)V
    //   10: aload_0
    //   11: getfield g : Lcom/bumptech/glide/manager/RequestTracker;
    //   14: aload_2
    //   15: invokevirtual a : (Lcom/bumptech/glide/request/Request;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public <ResourceType> RequestBuilder<ResourceType> b(Class<ResourceType> paramClass) {
    return new RequestBuilder<ResourceType>(this.a, this, paramClass, this.b);
  }
  
  public RequestBuilder<Drawable> b(Integer paramInteger) {
    return e().b(paramInteger);
  }
  
  public RequestBuilder<Drawable> b(String paramString) {
    return e().b(paramString);
  }
  
  boolean b(Target<?> paramTarget) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface a : ()Lcom/bumptech/glide/request/Request;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iconst_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield g : Lcom/bumptech/glide/manager/RequestTracker;
    //   21: aload_2
    //   22: invokevirtual b : (Lcom/bumptech/glide/request/Request;)Z
    //   25: ifeq -> 47
    //   28: aload_0
    //   29: getfield i : Lcom/bumptech/glide/manager/TargetTracker;
    //   32: aload_1
    //   33: invokevirtual b : (Lcom/bumptech/glide/request/target/Target;)V
    //   36: aload_1
    //   37: aconst_null
    //   38: invokeinterface a : (Lcom/bumptech/glide/request/Request;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: iconst_1
    //   46: ireturn
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_0
    //   50: ireturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	51	finally
    //   17	43	51	finally
  }
  
  <T> TransitionOptions<?, T> c(Class<T> paramClass) {
    return this.a.e().a(paramClass);
  }
  
  public RequestBuilder<File> d() {
    return b(File.class).c((BaseRequestOptions<?>)RequestOptions.g(true));
  }
  
  public RequestBuilder<Drawable> e() {
    return b(Drawable.class);
  }
  
  public RequestBuilder<Bitmap> f() {
    return b(Bitmap.class).c((BaseRequestOptions<?>)d);
  }
  
  public void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Lcom/bumptech/glide/manager/RequestTracker;
    //   6: invokevirtual a : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Lcom/bumptech/glide/manager/RequestTracker;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual h : ()V
    //   6: aload_0
    //   7: getfield h : Lcom/bumptech/glide/manager/RequestManagerTreeNode;
    //   10: invokeinterface a : ()Ljava/util/Set;
    //   15: invokeinterface iterator : ()Ljava/util/Iterator;
    //   20: astore_1
    //   21: aload_1
    //   22: invokeinterface hasNext : ()Z
    //   27: ifeq -> 45
    //   30: aload_1
    //   31: invokeinterface next : ()Ljava/lang/Object;
    //   36: checkcast com/bumptech/glide/RequestManager
    //   39: invokevirtual h : ()V
    //   42: goto -> 21
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	48	finally
    //   21	42	48	finally
  }
  
  public void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Lcom/bumptech/glide/manager/RequestTracker;
    //   6: invokevirtual c : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  List<RequestListener<Object>> k() {
    return this.m;
  }
  
  RequestOptions l() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield n : Lcom/bumptech/glide/request/RequestOptions;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void o_() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual j : ()V
    //   6: aload_0
    //   7: getfield i : Lcom/bumptech/glide/manager/TargetTracker;
    //   10: invokevirtual o_ : ()V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt) {
    if (paramInt == 60 && this.o)
      i(); 
  }
  
  public void p_() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual g : ()V
    //   6: aload_0
    //   7: getfield i : Lcom/bumptech/glide/manager/TargetTracker;
    //   10: invokevirtual p_ : ()V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  public void q_() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Lcom/bumptech/glide/manager/TargetTracker;
    //   6: invokevirtual q_ : ()V
    //   9: aload_0
    //   10: getfield i : Lcom/bumptech/glide/manager/TargetTracker;
    //   13: invokevirtual a : ()Ljava/util/List;
    //   16: invokeinterface iterator : ()Ljava/util/Iterator;
    //   21: astore_1
    //   22: aload_1
    //   23: invokeinterface hasNext : ()Z
    //   28: ifeq -> 47
    //   31: aload_0
    //   32: aload_1
    //   33: invokeinterface next : ()Ljava/lang/Object;
    //   38: checkcast com/bumptech/glide/request/target/Target
    //   41: invokevirtual a : (Lcom/bumptech/glide/request/target/Target;)V
    //   44: goto -> 22
    //   47: aload_0
    //   48: getfield i : Lcom/bumptech/glide/manager/TargetTracker;
    //   51: invokevirtual e : ()V
    //   54: aload_0
    //   55: getfield g : Lcom/bumptech/glide/manager/RequestTracker;
    //   58: invokevirtual d : ()V
    //   61: aload_0
    //   62: getfield c : Lcom/bumptech/glide/manager/Lifecycle;
    //   65: aload_0
    //   66: invokeinterface b : (Lcom/bumptech/glide/manager/LifecycleListener;)V
    //   71: aload_0
    //   72: getfield c : Lcom/bumptech/glide/manager/Lifecycle;
    //   75: aload_0
    //   76: getfield l : Lcom/bumptech/glide/manager/ConnectivityMonitor;
    //   79: invokeinterface b : (Lcom/bumptech/glide/manager/LifecycleListener;)V
    //   84: aload_0
    //   85: getfield k : Landroid/os/Handler;
    //   88: aload_0
    //   89: getfield j : Ljava/lang/Runnable;
    //   92: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   95: aload_0
    //   96: getfield a : Lcom/bumptech/glide/Glide;
    //   99: aload_0
    //   100: invokevirtual b : (Lcom/bumptech/glide/RequestManager;)V
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	106	finally
    //   22	44	106	finally
    //   47	103	106	finally
  }
  
  public String toString() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: aload_1
    //   11: aload_0
    //   12: invokespecial toString : ()Ljava/lang/String;
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_1
    //   20: ldc_w '{tracker='
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: aload_0
    //   29: getfield g : Lcom/bumptech/glide/manager/RequestTracker;
    //   32: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: ldc_w ', treeNode='
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: getfield h : Lcom/bumptech/glide/manager/RequestManagerTreeNode;
    //   49: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_1
    //   54: ldc_w '}'
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_1
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Exception table:
    //   from	to	target	type
    //   2	66	70	finally
  }
  
  static class ClearTarget extends CustomViewTarget<View, Object> {
    ClearTarget(View param1View) {
      super(param1View);
    }
    
    public void a(Object param1Object, Transition<? super Object> param1Transition) {}
    
    public void b(Drawable param1Drawable) {}
    
    public void d(Drawable param1Drawable) {}
  }
  
  class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
    private final RequestTracker b;
    
    RequestManagerConnectivityListener(RequestManager this$0, RequestTracker param1RequestTracker) {
      this.b = param1RequestTracker;
    }
    
    public void a(boolean param1Boolean) {
      if (param1Boolean)
        synchronized (this.a) {
          this.b.e();
          return;
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\RequestManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */