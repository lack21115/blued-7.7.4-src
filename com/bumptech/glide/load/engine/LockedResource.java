package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {
  private static final Pools.Pool<LockedResource<?>> a = FactoryPools.a(20, new FactoryPools.Factory<LockedResource<?>>() {
        public LockedResource<?> a() {
          return new LockedResource();
        }
      });
  
  private final StateVerifier b = StateVerifier.a();
  
  private Resource<Z> c;
  
  private boolean d;
  
  private boolean e;
  
  static <Z> LockedResource<Z> a(Resource<Z> paramResource) {
    LockedResource<Z> lockedResource = (LockedResource)Preconditions.a(a.acquire());
    lockedResource.b(paramResource);
    return lockedResource;
  }
  
  private void b(Resource<Z> paramResource) {
    this.e = false;
    this.d = true;
    this.c = paramResource;
  }
  
  private void g() {
    this.c = null;
    a.release(this);
  }
  
  public Class<Z> a() {
    return this.c.a();
  }
  
  public int b() {
    return this.c.b();
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/bumptech/glide/util/pool/StateVerifier;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield e : Z
    //   14: aload_0
    //   15: getfield d : Z
    //   18: ifne -> 34
    //   21: aload_0
    //   22: getfield c : Lcom/bumptech/glide/load/engine/Resource;
    //   25: invokeinterface c : ()V
    //   30: aload_0
    //   31: invokespecial g : ()V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	37	finally
  }
  
  public StateVerifier d() {
    return this.b;
  }
  
  void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/bumptech/glide/util/pool/StateVerifier;
    //   6: invokevirtual b : ()V
    //   9: aload_0
    //   10: getfield d : Z
    //   13: ifeq -> 35
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield d : Z
    //   21: aload_0
    //   22: getfield e : Z
    //   25: ifeq -> 32
    //   28: aload_0
    //   29: invokevirtual c : ()V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: new java/lang/IllegalStateException
    //   38: dup
    //   39: ldc 'Already unlocked'
    //   41: invokespecial <init> : (Ljava/lang/String;)V
    //   44: athrow
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	45	finally
    //   35	45	45	finally
  }
  
  public Z f() {
    return this.c.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\LockedResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */