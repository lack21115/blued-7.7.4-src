package com.bumptech.glide.load.engine;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, FactoryPools.Poolable, Comparable<DecodeJob<?>>, Runnable {
  private DataSource A;
  
  private DataFetcher<?> B;
  
  private volatile DataFetcherGenerator C;
  
  private volatile boolean D;
  
  private volatile boolean E;
  
  private final DecodeHelper<R> a = new DecodeHelper<R>();
  
  private final List<Throwable> b = new ArrayList<Throwable>();
  
  private final StateVerifier c = StateVerifier.a();
  
  private final DiskCacheProvider d;
  
  private final Pools.Pool<DecodeJob<?>> e;
  
  private final DeferredEncodeManager<?> f = new DeferredEncodeManager();
  
  private final ReleaseManager g = new ReleaseManager();
  
  private GlideContext h;
  
  private Key i;
  
  private Priority j;
  
  private EngineKey k;
  
  private int l;
  
  private int m;
  
  private DiskCacheStrategy n;
  
  private Options o;
  
  private Callback<R> p;
  
  private int q;
  
  private Stage r;
  
  private RunReason s;
  
  private long t;
  
  private boolean u;
  
  private Object v;
  
  private Thread w;
  
  private Key x;
  
  private Key y;
  
  private Object z;
  
  DecodeJob(DiskCacheProvider paramDiskCacheProvider, Pools.Pool<DecodeJob<?>> paramPool) {
    this.d = paramDiskCacheProvider;
    this.e = paramPool;
  }
  
  private Options a(DataSource paramDataSource) {
    boolean bool1;
    Options options2 = this.o;
    if (Build.VERSION.SDK_INT < 26)
      return options2; 
    if (paramDataSource == DataSource.d || this.a.m()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Boolean bool = (Boolean)options2.a(Downsampler.e);
    if (bool != null && (!bool.booleanValue() || bool1))
      return options2; 
    Options options1 = new Options();
    options1.a(this.o);
    options1.a(Downsampler.e, Boolean.valueOf(bool1));
    return options1;
  }
  
  private Stage a(Stage paramStage) {
    int i = null.b[paramStage.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3 && i != 4) {
          if (i == 5)
            return this.n.a() ? Stage.b : a(Stage.b); 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unrecognized stage: ");
          stringBuilder.append(paramStage);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        return Stage.f;
      } 
      return this.u ? Stage.f : Stage.d;
    } 
    return this.n.b() ? Stage.c : a(Stage.c);
  }
  
  private <Data> Resource<R> a(DataFetcher<?> paramDataFetcher, Data paramData, DataSource paramDataSource) throws GlideException {
    if (paramData == null) {
      paramDataFetcher.a();
      return null;
    } 
    try {
      long l = LogTime.a();
      Resource<?> resource = a(paramData, paramDataSource);
      if (Log.isLoggable("DecodeJob", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Decoded result ");
        stringBuilder.append(resource);
        a(stringBuilder.toString(), l);
      } 
      return (Resource)resource;
    } finally {
      paramDataFetcher.a();
    } 
  }
  
  private <Data> Resource<R> a(Data paramData, DataSource paramDataSource) throws GlideException {
    return a(paramData, paramDataSource, this.a.b((Class)paramData.getClass()));
  }
  
  private <Data, ResourceType> Resource<R> a(Data paramData, DataSource paramDataSource, LoadPath<Data, ResourceType, R> paramLoadPath) throws GlideException {
    Options options = a(paramDataSource);
    DataRewinder<Data> dataRewinder = this.h.d().b(paramData);
    try {
      return paramLoadPath.a(dataRewinder, options, this.l, this.m, new DecodeCallback<ResourceType>(this, paramDataSource));
    } finally {
      dataRewinder.b();
    } 
  }
  
  private void a(Resource<R> paramResource, DataSource paramDataSource) {
    m();
    this.p.a(paramResource, paramDataSource);
  }
  
  private void a(String paramString, long paramLong) {
    a(paramString, paramLong, (String)null);
  }
  
  private void a(String paramString1, long paramLong, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(" in ");
    stringBuilder.append(LogTime.a(paramLong));
    stringBuilder.append(", load key: ");
    stringBuilder.append(this.k);
    if (paramString2 != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(", ");
      stringBuilder1.append(paramString2);
      String str = stringBuilder1.toString();
    } else {
      paramString1 = "";
    } 
    stringBuilder.append(paramString1);
    stringBuilder.append(", thread: ");
    stringBuilder.append(Thread.currentThread().getName());
    Log.v("DecodeJob", stringBuilder.toString());
  }
  
  private void b(Resource<R> paramResource, DataSource paramDataSource) {
    if (paramResource instanceof Initializable)
      ((Initializable)paramResource).d(); 
    Resource<R> resource1 = null;
    Resource<R> resource2 = paramResource;
    if (this.f.a()) {
      resource2 = LockedResource.a(paramResource);
      resource1 = resource2;
    } 
    a(resource2, paramDataSource);
    this.r = Stage.e;
    try {
      if (this.f.a())
        this.f.a(this.d, this.o); 
      if (resource1 != null)
        resource1.e(); 
      return;
    } finally {
      if (resource1 != null)
        resource1.e(); 
    } 
  }
  
  private void e() {
    if (this.g.a())
      g(); 
  }
  
  private void f() {
    if (this.g.b())
      g(); 
  }
  
  private void g() {
    this.g.c();
    this.f.b();
    this.a.a();
    this.D = false;
    this.h = null;
    this.i = null;
    this.o = null;
    this.j = null;
    this.k = null;
    this.p = null;
    this.r = null;
    this.C = null;
    this.w = null;
    this.x = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.t = 0L;
    this.E = false;
    this.v = null;
    this.b.clear();
    this.e.release(this);
  }
  
  private int h() {
    return this.j.ordinal();
  }
  
  private void i() {
    int i = null.a[this.s.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i == 3) {
          n();
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unrecognized run reason: ");
        stringBuilder.append(this.s);
        throw new IllegalStateException(stringBuilder.toString());
      } 
      k();
      return;
    } 
    this.r = a(Stage.a);
    this.C = j();
    k();
  }
  
  private DataFetcherGenerator j() {
    int i = null.b[this.r.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4)
            return null; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unrecognized stage: ");
          stringBuilder.append(this.r);
          throw new IllegalStateException(stringBuilder.toString());
        } 
        return new SourceGenerator(this.a, this);
      } 
      return new DataCacheGenerator(this.a, this);
    } 
    return new ResourceCacheGenerator(this.a, this);
  }
  
  private void k() {
    boolean bool2;
    this.w = Thread.currentThread();
    this.t = LogTime.a();
    boolean bool1 = false;
    while (true) {
      bool2 = bool1;
      if (!this.E) {
        bool2 = bool1;
        if (this.C != null) {
          bool1 = this.C.a();
          bool2 = bool1;
          if (!bool1) {
            this.r = a(this.r);
            this.C = j();
            if (this.r == Stage.d) {
              c();
              return;
            } 
            continue;
          } 
        } 
      } 
      break;
    } 
    if ((this.r == Stage.f || this.E) && !bool2)
      l(); 
  }
  
  private void l() {
    m();
    GlideException glideException = new GlideException("Failed to load resource", new ArrayList<Throwable>(this.b));
    this.p.a(glideException);
    f();
  }
  
  private void m() {
    this.c.b();
    if (this.D) {
      Throwable throwable;
      if (this.b.isEmpty()) {
        throwable = null;
      } else {
        List<Throwable> list = this.b;
        throwable = list.get(list.size() - 1);
      } 
      throw new IllegalStateException("Already notified", throwable);
    } 
    this.D = true;
  }
  
  private void n() {
    if (Log.isLoggable("DecodeJob", 2)) {
      long l = this.t;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("data: ");
      stringBuilder.append(this.z);
      stringBuilder.append(", cache key: ");
      stringBuilder.append(this.x);
      stringBuilder.append(", fetcher: ");
      stringBuilder.append(this.B);
      a("Retrieved data", l, stringBuilder.toString());
    } 
    Resource<?> resource = null;
    try {
      Resource<?> resource1 = a(this.B, this.z, this.A);
      resource = resource1;
    } catch (GlideException glideException) {
      glideException.a(this.y, this.A);
      this.b.add(glideException);
    } 
    if (resource != null) {
      b((Resource)resource, this.A);
      return;
    } 
    k();
  }
  
  public int a(DecodeJob<?> paramDecodeJob) {
    int j = h() - paramDecodeJob.h();
    int i = j;
    if (j == 0)
      i = this.q - paramDecodeJob.q; 
    return i;
  }
  
  DecodeJob<R> a(GlideContext paramGlideContext, Object paramObject, EngineKey paramEngineKey, Key paramKey, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, DiskCacheStrategy paramDiskCacheStrategy, Map<Class<?>, Transformation<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Options paramOptions, Callback<R> paramCallback, int paramInt3) {
    this.a.a(paramGlideContext, paramObject, paramKey, paramInt1, paramInt2, paramDiskCacheStrategy, paramClass, paramClass1, paramPriority, paramOptions, paramMap, paramBoolean1, paramBoolean2, this.d);
    this.h = paramGlideContext;
    this.i = paramKey;
    this.j = paramPriority;
    this.k = paramEngineKey;
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramDiskCacheStrategy;
    this.u = paramBoolean3;
    this.o = paramOptions;
    this.p = paramCallback;
    this.q = paramInt3;
    this.s = RunReason.a;
    this.v = paramObject;
    return this;
  }
  
  <Z> Resource<Z> a(DataSource paramDataSource, Resource<Z> paramResource) {
    Resource<Z> resource;
    Transformation transformation;
    EncodeStrategy encodeStrategy;
    Class<?> clazz = paramResource.f().getClass();
    DataSource dataSource = DataSource.d;
    Resource resource1 = null;
    if (paramDataSource != dataSource) {
      transformation = this.a.c(clazz);
      resource = transformation.a((Context)this.h, paramResource, this.l, this.m);
    } else {
      resource = paramResource;
      transformation = null;
    } 
    if (!paramResource.equals(resource))
      paramResource.c(); 
    if (this.a.a(resource)) {
      ResourceEncoder<Z> resourceEncoder = this.a.b(resource);
      encodeStrategy = resourceEncoder.a(this.o);
    } else {
      encodeStrategy = EncodeStrategy.c;
      paramResource = resource1;
    } 
    boolean bool = this.a.a(this.x);
    if (this.n.a(bool ^ true, paramDataSource, encodeStrategy)) {
      if (paramResource != null) {
        DataCacheKey dataCacheKey;
        int i = null.c[encodeStrategy.ordinal()];
        if (i != 1) {
          if (i == 2) {
            ResourceCacheKey resourceCacheKey = new ResourceCacheKey(this.a.i(), this.x, this.i, this.l, this.m, transformation, clazz, this.o);
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown strategy: ");
            stringBuilder.append(encodeStrategy);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
        } else {
          dataCacheKey = new DataCacheKey(this.x, this.i);
        } 
        resource = LockedResource.a(resource);
        this.f.a(dataCacheKey, (ResourceEncoder<Z>)paramResource, (LockedResource<Z>)resource);
        return resource;
      } 
      throw new Registry.NoResultEncoderAvailableException(resource.f().getClass());
    } 
    return resource;
  }
  
  public void a(Key paramKey, Exception paramException, DataFetcher<?> paramDataFetcher, DataSource paramDataSource) {
    paramDataFetcher.a();
    paramException = new GlideException("Fetching data failed", paramException);
    paramException.a(paramKey, paramDataSource, paramDataFetcher.c());
    this.b.add(paramException);
    if (Thread.currentThread() != this.w) {
      this.s = RunReason.b;
      this.p.a(this);
      return;
    } 
    k();
  }
  
  public void a(Key paramKey1, Object paramObject, DataFetcher<?> paramDataFetcher, DataSource paramDataSource, Key paramKey2) {
    this.x = paramKey1;
    this.z = paramObject;
    this.B = paramDataFetcher;
    this.A = paramDataSource;
    this.y = paramKey2;
    if (Thread.currentThread() != this.w) {
      this.s = RunReason.c;
      this.p.a(this);
      return;
    } 
    GlideTrace.a("DecodeJob.decodeFromRetrievedData");
    try {
      n();
      return;
    } finally {
      GlideTrace.a();
    } 
  }
  
  void a(boolean paramBoolean) {
    if (this.g.a(paramBoolean))
      g(); 
  }
  
  boolean a() {
    Stage stage = a(Stage.a);
    return (stage == Stage.b || stage == Stage.c);
  }
  
  public void b() {
    this.E = true;
    DataFetcherGenerator dataFetcherGenerator = this.C;
    if (dataFetcherGenerator != null)
      dataFetcherGenerator.b(); 
  }
  
  public void c() {
    this.s = RunReason.b;
    this.p.a(this);
  }
  
  public StateVerifier d() {
    return this.c;
  }
  
  public void run() {
    Exception exception;
    GlideTrace.a("DecodeJob#run(model=%s)", this.v);
    DataFetcher<?> dataFetcher = this.B;
    try {
      if (this.E) {
        l();
        if (dataFetcher != null)
          dataFetcher.a(); 
        return;
      } 
      i();
      if (dataFetcher != null)
        dataFetcher.a(); 
      return;
    } catch (CallbackException null) {
      throw exception;
    } finally {
      exception = null;
    } 
    if (dataFetcher != null)
      dataFetcher.a(); 
    GlideTrace.a();
    throw exception;
  }
  
  static interface Callback<R> {
    void a(DecodeJob<?> param1DecodeJob);
    
    void a(GlideException param1GlideException);
    
    void a(Resource<R> param1Resource, DataSource param1DataSource);
  }
  
  final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
    private final DataSource b;
    
    DecodeCallback(DecodeJob this$0, DataSource param1DataSource) {
      this.b = param1DataSource;
    }
    
    public Resource<Z> a(Resource<Z> param1Resource) {
      return this.a.a(this.b, param1Resource);
    }
  }
  
  static class DeferredEncodeManager<Z> {
    private Key a;
    
    private ResourceEncoder<Z> b;
    
    private LockedResource<Z> c;
    
    <X> void a(Key param1Key, ResourceEncoder<X> param1ResourceEncoder, LockedResource<X> param1LockedResource) {
      this.a = param1Key;
      this.b = param1ResourceEncoder;
      this.c = param1LockedResource;
    }
    
    void a(DecodeJob.DiskCacheProvider param1DiskCacheProvider, Options param1Options) {
      GlideTrace.a("DecodeJob.encode");
      try {
        param1DiskCacheProvider.a().a(this.a, new DataCacheWriter<Z>((Encoder<Z>)this.b, (Z)this.c, param1Options));
        return;
      } finally {
        this.c.e();
        GlideTrace.a();
      } 
    }
    
    boolean a() {
      return (this.c != null);
    }
    
    void b() {
      this.a = null;
      this.b = null;
      this.c = null;
    }
  }
  
  static interface DiskCacheProvider {
    DiskCache a();
  }
  
  static class ReleaseManager {
    private boolean a;
    
    private boolean b;
    
    private boolean c;
    
    private boolean b(boolean param1Boolean) {
      return ((this.c || param1Boolean || this.b) && this.a);
    }
    
    boolean a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield b : Z
      //   7: aload_0
      //   8: iconst_0
      //   9: invokespecial b : (Z)Z
      //   12: istore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_1
      //   16: ireturn
      //   17: astore_2
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_2
      //   21: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	17	finally
    }
    
    boolean a(boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield a : Z
      //   7: aload_0
      //   8: iload_1
      //   9: invokespecial b : (Z)Z
      //   12: istore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_1
      //   16: ireturn
      //   17: astore_2
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_2
      //   21: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	17	finally
    }
    
    boolean b() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield c : Z
      //   7: aload_0
      //   8: iconst_0
      //   9: invokespecial b : (Z)Z
      //   12: istore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_1
      //   16: ireturn
      //   17: astore_2
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_2
      //   21: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	17	finally
    }
    
    void c() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_0
      //   4: putfield b : Z
      //   7: aload_0
      //   8: iconst_0
      //   9: putfield a : Z
      //   12: aload_0
      //   13: iconst_0
      //   14: putfield c : Z
      //   17: aload_0
      //   18: monitorexit
      //   19: return
      //   20: astore_1
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: athrow
      // Exception table:
      //   from	to	target	type
      //   2	17	20	finally
    }
  }
  
  enum RunReason {
    a, b, c;
  }
  
  enum Stage {
    a, b, c, d, e, f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\DecodeJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */