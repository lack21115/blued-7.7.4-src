package com.bumptech.glide.load.data;

import java.util.HashMap;
import java.util.Map;

public class DataRewinderRegistry {
  private static final DataRewinder.Factory<?> b = new DataRewinder.Factory() {
      public DataRewinder<Object> a(Object param1Object) {
        return new DataRewinderRegistry.DefaultRewinder(param1Object);
      }
      
      public Class<Object> a() {
        throw new UnsupportedOperationException("Not implemented");
      }
    };
  
  private final Map<Class<?>, DataRewinder.Factory<?>> a = new HashMap<Class<?>, DataRewinder.Factory<?>>();
  
  public <T> DataRewinder<T> a(T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic a : (Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield a : Ljava/util/Map;
    //   11: aload_1
    //   12: invokevirtual getClass : ()Ljava/lang/Class;
    //   15: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast com/bumptech/glide/load/data/DataRewinder$Factory
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: aload_3
    //   27: ifnonnull -> 85
    //   30: aload_0
    //   31: getfield a : Ljava/util/Map;
    //   34: invokeinterface values : ()Ljava/util/Collection;
    //   39: invokeinterface iterator : ()Ljava/util/Iterator;
    //   44: astore #4
    //   46: aload_3
    //   47: astore_2
    //   48: aload #4
    //   50: invokeinterface hasNext : ()Z
    //   55: ifeq -> 85
    //   58: aload #4
    //   60: invokeinterface next : ()Ljava/lang/Object;
    //   65: checkcast com/bumptech/glide/load/data/DataRewinder$Factory
    //   68: astore_2
    //   69: aload_2
    //   70: invokeinterface a : ()Ljava/lang/Class;
    //   75: aload_1
    //   76: invokevirtual getClass : ()Ljava/lang/Class;
    //   79: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   82: ifeq -> 46
    //   85: aload_2
    //   86: astore_3
    //   87: aload_2
    //   88: ifnonnull -> 95
    //   91: getstatic com/bumptech/glide/load/data/DataRewinderRegistry.b : Lcom/bumptech/glide/load/data/DataRewinder$Factory;
    //   94: astore_3
    //   95: aload_3
    //   96: aload_1
    //   97: invokeinterface a : (Ljava/lang/Object;)Lcom/bumptech/glide/load/data/DataRewinder;
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: areturn
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	107	finally
    //   30	46	107	finally
    //   48	85	107	finally
    //   91	95	107	finally
    //   95	103	107	finally
  }
  
  public void a(DataRewinder.Factory<?> paramFactory) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface a : ()Ljava/lang/Class;
    //   12: aload_1
    //   13: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: pop
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
  
  static final class DefaultRewinder implements DataRewinder<Object> {
    private final Object a;
    
    DefaultRewinder(Object param1Object) {
      this.a = param1Object;
    }
    
    public Object a() {
      return this.a;
    }
    
    public void b() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\DataRewinderRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */