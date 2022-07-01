package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class GlideBuilder {
  private final Map<Class<?>, TransitionOptions<?, ?>> a = (Map<Class<?>, TransitionOptions<?, ?>>)new ArrayMap();
  
  private Engine b;
  
  private BitmapPool c;
  
  private ArrayPool d;
  
  private MemoryCache e;
  
  private GlideExecutor f;
  
  private GlideExecutor g;
  
  private DiskCache.Factory h;
  
  private MemorySizeCalculator i;
  
  private ConnectivityMonitorFactory j;
  
  private int k = 4;
  
  private Glide.RequestOptionsFactory l = new Glide.RequestOptionsFactory(this) {
      public RequestOptions a() {
        return new RequestOptions();
      }
    };
  
  private RequestManagerRetriever.RequestManagerFactory m;
  
  private GlideExecutor n;
  
  private boolean o;
  
  private List<RequestListener<Object>> p;
  
  private boolean q;
  
  private boolean r;
  
  Glide a(Context paramContext) {
    if (this.f == null)
      this.f = GlideExecutor.d(); 
    if (this.g == null)
      this.g = GlideExecutor.b(); 
    if (this.n == null)
      this.n = GlideExecutor.g(); 
    if (this.i == null)
      this.i = (new MemorySizeCalculator.Builder(paramContext)).a(); 
    if (this.j == null)
      this.j = (ConnectivityMonitorFactory)new DefaultConnectivityMonitorFactory(); 
    if (this.c == null) {
      int i = this.i.b();
      if (i > 0) {
        this.c = (BitmapPool)new LruBitmapPool(i);
      } else {
        this.c = (BitmapPool)new BitmapPoolAdapter();
      } 
    } 
    if (this.d == null)
      this.d = (ArrayPool)new LruArrayPool(this.i.c()); 
    if (this.e == null)
      this.e = (MemoryCache)new LruResourceCache(this.i.a()); 
    if (this.h == null)
      this.h = (DiskCache.Factory)new InternalCacheDiskCacheFactory(paramContext); 
    if (this.b == null)
      this.b = new Engine(this.e, this.h, this.g, this.f, GlideExecutor.e(), this.n, this.o); 
    List<RequestListener<Object>> list = this.p;
    if (list == null) {
      this.p = Collections.emptyList();
    } else {
      this.p = Collections.unmodifiableList(list);
    } 
    RequestManagerRetriever requestManagerRetriever = new RequestManagerRetriever(this.m);
    return new Glide(paramContext, this.b, this.e, this.c, this.d, requestManagerRetriever, this.j, this.k, this.l, this.a, this.p, this.q, this.r);
  }
  
  public GlideBuilder a(int paramInt) {
    if (paramInt >= 2 && paramInt <= 6) {
      this.k = paramInt;
      return this;
    } 
    throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
  }
  
  public GlideBuilder a(BitmapPool paramBitmapPool) {
    this.c = paramBitmapPool;
    return this;
  }
  
  public GlideBuilder a(DiskCache.Factory paramFactory) {
    this.h = paramFactory;
    return this;
  }
  
  public GlideBuilder a(MemoryCache paramMemoryCache) {
    this.e = paramMemoryCache;
    return this;
  }
  
  void a(RequestManagerRetriever.RequestManagerFactory paramRequestManagerFactory) {
    this.m = paramRequestManagerFactory;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\GlideBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */