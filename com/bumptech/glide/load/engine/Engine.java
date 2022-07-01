package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

public class Engine implements EngineJobListener, EngineResource.ResourceListener, MemoryCache.ResourceRemovedListener {
  private static final boolean a = Log.isLoggable("Engine", 2);
  
  private final Jobs b;
  
  private final EngineKeyFactory c;
  
  private final MemoryCache d;
  
  private final EngineJobFactory e;
  
  private final ResourceRecycler f;
  
  private final LazyDiskCacheProvider g;
  
  private final DecodeJobFactory h;
  
  private final ActiveResources i;
  
  Engine(MemoryCache paramMemoryCache, DiskCache.Factory paramFactory, GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, Jobs paramJobs, EngineKeyFactory paramEngineKeyFactory, ActiveResources paramActiveResources, EngineJobFactory paramEngineJobFactory, DecodeJobFactory paramDecodeJobFactory, ResourceRecycler paramResourceRecycler, boolean paramBoolean) {
    this.d = paramMemoryCache;
    this.g = new LazyDiskCacheProvider(paramFactory);
    if (paramActiveResources == null)
      paramActiveResources = new ActiveResources(paramBoolean); 
    this.i = paramActiveResources;
    paramActiveResources.a(this);
    if (paramEngineKeyFactory == null)
      paramEngineKeyFactory = new EngineKeyFactory(); 
    this.c = paramEngineKeyFactory;
    if (paramJobs == null)
      paramJobs = new Jobs(); 
    this.b = paramJobs;
    if (paramEngineJobFactory == null)
      paramEngineJobFactory = new EngineJobFactory(paramGlideExecutor1, paramGlideExecutor2, paramGlideExecutor3, paramGlideExecutor4, this, this); 
    this.e = paramEngineJobFactory;
    if (paramDecodeJobFactory == null)
      paramDecodeJobFactory = new DecodeJobFactory(this.g); 
    this.h = paramDecodeJobFactory;
    if (paramResourceRecycler == null)
      paramResourceRecycler = new ResourceRecycler(); 
    this.f = paramResourceRecycler;
    paramMemoryCache.a(this);
  }
  
  public Engine(MemoryCache paramMemoryCache, DiskCache.Factory paramFactory, GlideExecutor paramGlideExecutor1, GlideExecutor paramGlideExecutor2, GlideExecutor paramGlideExecutor3, GlideExecutor paramGlideExecutor4, boolean paramBoolean) {
    this(paramMemoryCache, paramFactory, paramGlideExecutor1, paramGlideExecutor2, paramGlideExecutor3, paramGlideExecutor4, null, null, null, null, null, null, paramBoolean);
  }
  
  private <R> LoadStatus a(GlideContext paramGlideContext, Object paramObject, Key paramKey, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, DiskCacheStrategy paramDiskCacheStrategy, Map<Class<?>, Transformation<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, Options paramOptions, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, ResourceCallback paramResourceCallback, Executor paramExecutor, EngineKey paramEngineKey, long paramLong) {
    EngineJob<?> engineJob = this.b.a(paramEngineKey, paramBoolean6);
    if (engineJob != null) {
      engineJob.a(paramResourceCallback, paramExecutor);
      if (a)
        a("Added to existing load", paramLong, paramEngineKey); 
      return new LoadStatus(this, paramResourceCallback, engineJob);
    } 
    engineJob = this.e.a(paramEngineKey, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6);
    DecodeJob<R> decodeJob = this.h.a(paramGlideContext, paramObject, paramEngineKey, paramKey, paramInt1, paramInt2, paramClass, paramClass1, paramPriority, paramDiskCacheStrategy, paramMap, paramBoolean1, paramBoolean2, paramBoolean6, paramOptions, (DecodeJob.Callback)engineJob);
    this.b.a(paramEngineKey, engineJob);
    engineJob.a(paramResourceCallback, paramExecutor);
    engineJob.b(decodeJob);
    if (a)
      a("Started new load", paramLong, paramEngineKey); 
    return new LoadStatus(this, paramResourceCallback, engineJob);
  }
  
  private EngineResource<?> a(Key paramKey) {
    EngineResource<?> engineResource = this.i.b(paramKey);
    if (engineResource != null)
      engineResource.g(); 
    return engineResource;
  }
  
  private EngineResource<?> a(EngineKey paramEngineKey, boolean paramBoolean, long paramLong) {
    if (!paramBoolean)
      return null; 
    EngineResource<?> engineResource = a(paramEngineKey);
    if (engineResource != null) {
      if (a)
        a("Loaded resource from active resources", paramLong, paramEngineKey); 
      return engineResource;
    } 
    engineResource = b(paramEngineKey);
    if (engineResource != null) {
      if (a)
        a("Loaded resource from cache", paramLong, paramEngineKey); 
      return engineResource;
    } 
    return null;
  }
  
  private static void a(String paramString, long paramLong, Key paramKey) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" in ");
    stringBuilder.append(LogTime.a(paramLong));
    stringBuilder.append("ms, key: ");
    stringBuilder.append(paramKey);
    Log.v("Engine", stringBuilder.toString());
  }
  
  private EngineResource<?> b(Key paramKey) {
    EngineResource<?> engineResource = c(paramKey);
    if (engineResource != null) {
      engineResource.g();
      this.i.a(paramKey, engineResource);
    } 
    return engineResource;
  }
  
  private EngineResource<?> c(Key paramKey) {
    Resource<?> resource = this.d.a(paramKey);
    return (resource == null) ? null : ((resource instanceof EngineResource) ? (EngineResource)resource : new EngineResource(resource, true, true, paramKey, this));
  }
  
  public <R> LoadStatus a(GlideContext paramGlideContext, Object paramObject, Key paramKey, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, DiskCacheStrategy paramDiskCacheStrategy, Map<Class<?>, Transformation<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, Options paramOptions, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, ResourceCallback paramResourceCallback, Executor paramExecutor) {
    // Byte code:
    //   0: getstatic com/bumptech/glide/load/engine/Engine.a : Z
    //   3: ifeq -> 14
    //   6: invokestatic a : ()J
    //   9: lstore #20
    //   11: goto -> 17
    //   14: lconst_0
    //   15: lstore #20
    //   17: aload_0
    //   18: getfield c : Lcom/bumptech/glide/load/engine/EngineKeyFactory;
    //   21: aload_2
    //   22: aload_3
    //   23: iload #4
    //   25: iload #5
    //   27: aload #10
    //   29: aload #6
    //   31: aload #7
    //   33: aload #13
    //   35: invokevirtual a : (Ljava/lang/Object;Lcom/bumptech/glide/load/Key;IILjava/util/Map;Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/Options;)Lcom/bumptech/glide/load/engine/EngineKey;
    //   38: astore #22
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: aload #22
    //   45: iload #14
    //   47: lload #20
    //   49: invokespecial a : (Lcom/bumptech/glide/load/engine/EngineKey;ZJ)Lcom/bumptech/glide/load/engine/EngineResource;
    //   52: astore #23
    //   54: aload #23
    //   56: ifnonnull -> 107
    //   59: aload_0
    //   60: aload_1
    //   61: aload_2
    //   62: aload_3
    //   63: iload #4
    //   65: iload #5
    //   67: aload #6
    //   69: aload #7
    //   71: aload #8
    //   73: aload #9
    //   75: aload #10
    //   77: iload #11
    //   79: iload #12
    //   81: aload #13
    //   83: iload #14
    //   85: iload #15
    //   87: iload #16
    //   89: iload #17
    //   91: aload #18
    //   93: aload #19
    //   95: aload #22
    //   97: lload #20
    //   99: invokespecial a : (Lcom/bumptech/glide/GlideContext;Ljava/lang/Object;Lcom/bumptech/glide/load/Key;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/Priority;Lcom/bumptech/glide/load/engine/DiskCacheStrategy;Ljava/util/Map;ZZLcom/bumptech/glide/load/Options;ZZZZLcom/bumptech/glide/request/ResourceCallback;Ljava/util/concurrent/Executor;Lcom/bumptech/glide/load/engine/EngineKey;J)Lcom/bumptech/glide/load/engine/Engine$LoadStatus;
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: areturn
    //   107: aload_0
    //   108: monitorexit
    //   109: aload #18
    //   111: aload #23
    //   113: getstatic com/bumptech/glide/load/DataSource.e : Lcom/bumptech/glide/load/DataSource;
    //   116: invokeinterface a : (Lcom/bumptech/glide/load/engine/Resource;Lcom/bumptech/glide/load/DataSource;)V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Exception table:
    //   from	to	target	type
    //   42	54	123	finally
    //   59	105	123	finally
    //   107	109	123	finally
    //   124	126	123	finally
  }
  
  public void a() {
    this.g.a().a();
  }
  
  public void a(Key paramKey, EngineResource<?> paramEngineResource) {
    this.i.a(paramKey);
    if (paramEngineResource.e()) {
      this.d.b(paramKey, paramEngineResource);
      return;
    } 
    this.f.a(paramEngineResource, false);
  }
  
  public void a(EngineJob<?> paramEngineJob, Key paramKey) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/bumptech/glide/load/engine/Jobs;
    //   6: aload_2
    //   7: aload_1
    //   8: invokevirtual b : (Lcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/engine/EngineJob;)V
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
  }
  
  public void a(EngineJob<?> paramEngineJob, Key paramKey, EngineResource<?> paramEngineResource) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: ifnull -> 22
    //   6: aload_3
    //   7: invokevirtual e : ()Z
    //   10: ifeq -> 22
    //   13: aload_0
    //   14: getfield i : Lcom/bumptech/glide/load/engine/ActiveResources;
    //   17: aload_2
    //   18: aload_3
    //   19: invokevirtual a : (Lcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/engine/EngineResource;)V
    //   22: aload_0
    //   23: getfield b : Lcom/bumptech/glide/load/engine/Jobs;
    //   26: aload_2
    //   27: aload_1
    //   28: invokevirtual b : (Lcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/engine/EngineJob;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   6	22	34	finally
    //   22	31	34	finally
  }
  
  public void a(Resource<?> paramResource) {
    if (paramResource instanceof EngineResource) {
      ((EngineResource)paramResource).h();
      return;
    } 
    throw new IllegalArgumentException("Cannot release anything but an EngineResource");
  }
  
  public void b(Resource<?> paramResource) {
    this.f.a(paramResource, true);
  }
  
  static class DecodeJobFactory {
    final DecodeJob.DiskCacheProvider a;
    
    final Pools.Pool<DecodeJob<?>> b = FactoryPools.a(150, new FactoryPools.Factory<DecodeJob<?>>(this) {
          public DecodeJob<?> a() {
            return new DecodeJob(this.a.a, this.a.b);
          }
        });
    
    private int c;
    
    DecodeJobFactory(DecodeJob.DiskCacheProvider param1DiskCacheProvider) {
      this.a = param1DiskCacheProvider;
    }
    
    <R> DecodeJob<R> a(GlideContext param1GlideContext, Object param1Object, EngineKey param1EngineKey, Key param1Key, int param1Int1, int param1Int2, Class<?> param1Class, Class<R> param1Class1, Priority param1Priority, DiskCacheStrategy param1DiskCacheStrategy, Map<Class<?>, Transformation<?>> param1Map, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, Options param1Options, DecodeJob.Callback<R> param1Callback) {
      DecodeJob<R> decodeJob = (DecodeJob)Preconditions.a(this.b.acquire());
      int i = this.c;
      this.c = i + 1;
      return decodeJob.a(param1GlideContext, param1Object, param1EngineKey, param1Key, param1Int1, param1Int2, param1Class, param1Class1, param1Priority, param1DiskCacheStrategy, param1Map, param1Boolean1, param1Boolean2, param1Boolean3, param1Options, param1Callback, i);
    }
  }
  
  class null implements FactoryPools.Factory<DecodeJob<?>> {
    null(Engine this$0) {}
    
    public DecodeJob<?> a() {
      return new DecodeJob(this.a.a, this.a.b);
    }
  }
  
  static class EngineJobFactory {
    final GlideExecutor a;
    
    final GlideExecutor b;
    
    final GlideExecutor c;
    
    final GlideExecutor d;
    
    final EngineJobListener e;
    
    final EngineResource.ResourceListener f;
    
    final Pools.Pool<EngineJob<?>> g = FactoryPools.a(150, new FactoryPools.Factory<EngineJob<?>>(this) {
          public EngineJob<?> a() {
            return new EngineJob(this.a.a, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.g);
          }
        });
    
    EngineJobFactory(GlideExecutor param1GlideExecutor1, GlideExecutor param1GlideExecutor2, GlideExecutor param1GlideExecutor3, GlideExecutor param1GlideExecutor4, EngineJobListener param1EngineJobListener, EngineResource.ResourceListener param1ResourceListener) {
      this.a = param1GlideExecutor1;
      this.b = param1GlideExecutor2;
      this.c = param1GlideExecutor3;
      this.d = param1GlideExecutor4;
      this.e = param1EngineJobListener;
      this.f = param1ResourceListener;
    }
    
    <R> EngineJob<R> a(Key param1Key, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
      return ((EngineJob<R>)Preconditions.a(this.g.acquire())).a(param1Key, param1Boolean1, param1Boolean2, param1Boolean3, param1Boolean4);
    }
  }
  
  class null implements FactoryPools.Factory<EngineJob<?>> {
    null(Engine this$0) {}
    
    public EngineJob<?> a() {
      return new EngineJob(this.a.a, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.g);
    }
  }
  
  static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
    private final DiskCache.Factory a;
    
    private volatile DiskCache b;
    
    LazyDiskCacheProvider(DiskCache.Factory param1Factory) {
      this.a = param1Factory;
    }
    
    public DiskCache a() {
      // Byte code:
      //   0: aload_0
      //   1: getfield b : Lcom/bumptech/glide/load/engine/cache/DiskCache;
      //   4: ifnonnull -> 57
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield b : Lcom/bumptech/glide/load/engine/cache/DiskCache;
      //   13: ifnonnull -> 29
      //   16: aload_0
      //   17: aload_0
      //   18: getfield a : Lcom/bumptech/glide/load/engine/cache/DiskCache$Factory;
      //   21: invokeinterface a : ()Lcom/bumptech/glide/load/engine/cache/DiskCache;
      //   26: putfield b : Lcom/bumptech/glide/load/engine/cache/DiskCache;
      //   29: aload_0
      //   30: getfield b : Lcom/bumptech/glide/load/engine/cache/DiskCache;
      //   33: ifnonnull -> 47
      //   36: aload_0
      //   37: new com/bumptech/glide/load/engine/cache/DiskCacheAdapter
      //   40: dup
      //   41: invokespecial <init> : ()V
      //   44: putfield b : Lcom/bumptech/glide/load/engine/cache/DiskCache;
      //   47: aload_0
      //   48: monitorexit
      //   49: goto -> 57
      //   52: astore_1
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_1
      //   56: athrow
      //   57: aload_0
      //   58: getfield b : Lcom/bumptech/glide/load/engine/cache/DiskCache;
      //   61: areturn
      // Exception table:
      //   from	to	target	type
      //   9	29	52	finally
      //   29	47	52	finally
      //   47	49	52	finally
      //   53	55	52	finally
    }
  }
  
  public class LoadStatus {
    private final EngineJob<?> b;
    
    private final ResourceCallback c;
    
    LoadStatus(Engine this$0, ResourceCallback param1ResourceCallback, EngineJob<?> param1EngineJob) {
      this.c = param1ResourceCallback;
      this.b = param1EngineJob;
    }
    
    public void a() {
      synchronized (this.a) {
        this.b.c(this.c);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */