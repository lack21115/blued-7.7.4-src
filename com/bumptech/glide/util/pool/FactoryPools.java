package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {
  private static final Resetter<Object> a = new Resetter() {
      public void a(Object param1Object) {}
    };
  
  public static <T> Pools.Pool<List<T>> a() {
    return a(20);
  }
  
  public static <T> Pools.Pool<List<T>> a(int paramInt) {
    return a((Pools.Pool<List<T>>)new Pools.SynchronizedPool(paramInt), (Factory)new Factory<List<List<T>>>() {
          public List<T> a() {
            return new ArrayList<T>();
          }
        },  (Resetter)new Resetter<List<List<T>>>() {
          public void a(List<T> param1List) {
            param1List.clear();
          }
        });
  }
  
  public static <T extends Poolable> Pools.Pool<T> a(int paramInt, Factory<T> paramFactory) {
    return a((Pools.Pool<T>)new Pools.SynchronizedPool(paramInt), paramFactory);
  }
  
  private static <T extends Poolable> Pools.Pool<T> a(Pools.Pool<T> paramPool, Factory<T> paramFactory) {
    return a(paramPool, paramFactory, b());
  }
  
  private static <T> Pools.Pool<T> a(Pools.Pool<T> paramPool, Factory<T> paramFactory, Resetter<T> paramResetter) {
    return new FactoryPool<T>(paramPool, paramFactory, paramResetter);
  }
  
  private static <T> Resetter<T> b() {
    return (Resetter)a;
  }
  
  public static interface Factory<T> {
    T b();
  }
  
  static final class FactoryPool<T> implements Pools.Pool<T> {
    private final FactoryPools.Factory<T> a;
    
    private final FactoryPools.Resetter<T> b;
    
    private final Pools.Pool<T> c;
    
    FactoryPool(Pools.Pool<T> param1Pool, FactoryPools.Factory<T> param1Factory, FactoryPools.Resetter<T> param1Resetter) {
      this.c = param1Pool;
      this.a = param1Factory;
      this.b = param1Resetter;
    }
    
    public T acquire() {
      Object object2 = this.c.acquire();
      Object object1 = object2;
      if (object2 == null) {
        object2 = this.a.b();
        object1 = object2;
        if (Log.isLoggable("FactoryPools", 2)) {
          object1 = new StringBuilder();
          object1.append("Created new ");
          object1.append(object2.getClass());
          Log.v("FactoryPools", object1.toString());
          object1 = object2;
        } 
      } 
      if (object1 instanceof FactoryPools.Poolable)
        ((FactoryPools.Poolable)object1).d().a(false); 
      return (T)object1;
    }
    
    public boolean release(T param1T) {
      if (param1T instanceof FactoryPools.Poolable)
        ((FactoryPools.Poolable)param1T).d().a(true); 
      this.b.a(param1T);
      return this.c.release(param1T);
    }
  }
  
  public static interface Poolable {
    StateVerifier d();
  }
  
  public static interface Resetter<T> {
    void a(T param1T);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\pool\FactoryPools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */