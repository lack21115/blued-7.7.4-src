package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public abstract class CacheLoader<K, V> {
  public ListenableFuture<V> a(K paramK, V paramV) throws Exception {
    Preconditions.a(paramK);
    Preconditions.a(paramV);
    return Futures.a(a(paramK));
  }
  
  public abstract V a(K paramK) throws Exception;
  
  static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
    private final Function<K, V> a;
    
    public V a(K param1K) {
      return (V)this.a.f(Preconditions.a(param1K));
    }
  }
  
  public static final class InvalidCacheLoadException extends RuntimeException {
    public InvalidCacheLoadException(String param1String) {
      super(param1String);
    }
  }
  
  static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
    private final Supplier<V> a;
    
    public V a(Object param1Object) {
      Preconditions.a(param1Object);
      return (V)this.a.get();
    }
  }
  
  public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\CacheLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */