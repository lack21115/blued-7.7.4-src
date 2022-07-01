package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GlideContext extends ContextWrapper {
  static final TransitionOptions<?, ?> a = new GenericTransitionOptions();
  
  private final ArrayPool b;
  
  private final Registry c;
  
  private final ImageViewTargetFactory d;
  
  private final Glide.RequestOptionsFactory e;
  
  private final List<RequestListener<Object>> f;
  
  private final Map<Class<?>, TransitionOptions<?, ?>> g;
  
  private final Engine h;
  
  private final boolean i;
  
  private final int j;
  
  private RequestOptions k;
  
  public GlideContext(Context paramContext, ArrayPool paramArrayPool, Registry paramRegistry, ImageViewTargetFactory paramImageViewTargetFactory, Glide.RequestOptionsFactory paramRequestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> paramMap, List<RequestListener<Object>> paramList, Engine paramEngine, boolean paramBoolean, int paramInt) {
    super(paramContext.getApplicationContext());
    this.b = paramArrayPool;
    this.c = paramRegistry;
    this.d = paramImageViewTargetFactory;
    this.e = paramRequestOptionsFactory;
    this.f = paramList;
    this.g = paramMap;
    this.h = paramEngine;
    this.i = paramBoolean;
    this.j = paramInt;
  }
  
  public <T> TransitionOptions<?, T> a(Class<T> paramClass) {
    TransitionOptions<?, ?> transitionOptions;
    Map.Entry entry2;
    TransitionOptions transitionOptions2 = this.g.get(paramClass);
    TransitionOptions transitionOptions1 = transitionOptions2;
    if (transitionOptions2 == null) {
      Iterator<Map.Entry> iterator = this.g.entrySet().iterator();
      while (true) {
        transitionOptions1 = transitionOptions2;
        if (iterator.hasNext()) {
          entry2 = iterator.next();
          if (((Class)entry2.getKey()).isAssignableFrom(paramClass))
            transitionOptions2 = (TransitionOptions)entry2.getValue(); 
          continue;
        } 
        break;
      } 
    } 
    Map.Entry entry1 = entry2;
    if (entry2 == null)
      transitionOptions = a; 
    return (TransitionOptions)transitionOptions;
  }
  
  public <X> ViewTarget<ImageView, X> a(ImageView paramImageView, Class<X> paramClass) {
    return this.d.a(paramImageView, paramClass);
  }
  
  public List<RequestListener<Object>> a() {
    return this.f;
  }
  
  public RequestOptions b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Lcom/bumptech/glide/request/RequestOptions;
    //   6: ifnonnull -> 28
    //   9: aload_0
    //   10: aload_0
    //   11: getfield e : Lcom/bumptech/glide/Glide$RequestOptionsFactory;
    //   14: invokeinterface a : ()Lcom/bumptech/glide/request/RequestOptions;
    //   19: invokevirtual h : ()Lcom/bumptech/glide/request/BaseRequestOptions;
    //   22: checkcast com/bumptech/glide/request/RequestOptions
    //   25: putfield k : Lcom/bumptech/glide/request/RequestOptions;
    //   28: aload_0
    //   29: getfield k : Lcom/bumptech/glide/request/RequestOptions;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	37	finally
    //   28	33	37	finally
  }
  
  public Engine c() {
    return this.h;
  }
  
  public Registry d() {
    return this.c;
  }
  
  public int e() {
    return this.j;
  }
  
  public ArrayPool f() {
    return this.b;
  }
  
  public boolean g() {
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\GlideContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */