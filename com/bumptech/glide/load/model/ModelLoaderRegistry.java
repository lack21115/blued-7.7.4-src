package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ModelLoaderRegistry {
  private final MultiModelLoaderFactory a;
  
  private final ModelLoaderCache b = new ModelLoaderCache();
  
  public ModelLoaderRegistry(Pools.Pool<List<Throwable>> paramPool) {
    this(new MultiModelLoaderFactory(paramPool));
  }
  
  private ModelLoaderRegistry(MultiModelLoaderFactory paramMultiModelLoaderFactory) {
    this.a = paramMultiModelLoaderFactory;
  }
  
  private <Model, Data> void a(List<ModelLoaderFactory<? extends Model, ? extends Data>> paramList) {
    Iterator<ModelLoaderFactory<? extends Model, ? extends Data>> iterator = paramList.iterator();
    while (iterator.hasNext())
      ((ModelLoaderFactory)iterator.next()).a(); 
  }
  
  private static <A> Class<A> b(A paramA) {
    return (Class)paramA.getClass();
  }
  
  private <A> List<ModelLoader<A, ?>> b(Class<A> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/bumptech/glide/load/model/ModelLoaderRegistry$ModelLoaderCache;
    //   6: aload_1
    //   7: invokevirtual a : (Ljava/lang/Class;)Ljava/util/List;
    //   10: astore_3
    //   11: aload_3
    //   12: astore_2
    //   13: aload_3
    //   14: ifnonnull -> 38
    //   17: aload_0
    //   18: getfield a : Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;
    //   21: aload_1
    //   22: invokevirtual a : (Ljava/lang/Class;)Ljava/util/List;
    //   25: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
    //   28: astore_2
    //   29: aload_0
    //   30: getfield b : Lcom/bumptech/glide/load/model/ModelLoaderRegistry$ModelLoaderCache;
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual a : (Ljava/lang/Class;Ljava/util/List;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	42	finally
    //   17	38	42	finally
  }
  
  public List<Class<?>> a(Class<?> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;
    //   6: aload_1
    //   7: invokevirtual b : (Ljava/lang/Class;)Ljava/util/List;
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: areturn
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
  }
  
  public <A> List<ModelLoader<A, ?>> a(A paramA) {
    List<ModelLoader<?, ?>> list = b(b(paramA));
    if (!list.isEmpty()) {
      int j = list.size();
      List<?> list1 = Collections.emptyList();
      int i = 0;
      for (boolean bool = true; i < j; bool = bool1) {
        ModelLoader modelLoader = list.get(i);
        List<?> list2 = list1;
        boolean bool1 = bool;
        if (modelLoader.a(paramA)) {
          bool1 = bool;
          if (bool) {
            list1 = new ArrayList(j - i);
            bool1 = false;
          } 
          list1.add(modelLoader);
          list2 = list1;
        } 
        i++;
        list1 = list2;
      } 
      if (!list1.isEmpty())
        return (List)list1; 
      throw new Registry.NoModelLoaderAvailableException(paramA, list);
    } 
    throw new Registry.NoModelLoaderAvailableException(paramA);
  }
  
  public <Model, Data> void a(Class<Model> paramClass, Class<Data> paramClass1, ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;
    //   6: aload_1
    //   7: aload_2
    //   8: aload_3
    //   9: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;)V
    //   12: aload_0
    //   13: getfield b : Lcom/bumptech/glide/load/model/ModelLoaderRegistry$ModelLoaderCache;
    //   16: invokevirtual a : ()V
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
  
  public <Model, Data> void b(Class<Model> paramClass, Class<Data> paramClass1, ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield a : Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;
    //   7: aload_1
    //   8: aload_2
    //   9: aload_3
    //   10: invokevirtual b : (Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;)Ljava/util/List;
    //   13: invokespecial a : (Ljava/util/List;)V
    //   16: aload_0
    //   17: getfield b : Lcom/bumptech/glide/load/model/ModelLoaderRegistry$ModelLoaderCache;
    //   20: invokevirtual a : ()V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	26	finally
  }
  
  static class ModelLoaderCache {
    private final Map<Class<?>, Entry<?>> a = new HashMap<Class<?>, Entry<?>>();
    
    public <Model> List<ModelLoader<Model, ?>> a(Class<Model> param1Class) {
      Entry entry = this.a.get(param1Class);
      return (entry == null) ? null : entry.a;
    }
    
    public void a() {
      this.a.clear();
    }
    
    public <Model> void a(Class<Model> param1Class, List<ModelLoader<Model, ?>> param1List) {
      if ((Entry)this.a.put(param1Class, new Entry(param1List)) == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Already cached loaders for model: ");
      stringBuilder.append(param1Class);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    static class Entry<Model> {
      final List<ModelLoader<Model, ?>> a;
      
      public Entry(List<ModelLoader<Model, ?>> param2List) {
        this.a = param2List;
      }
    }
  }
  
  static class Entry<Model> {
    final List<ModelLoader<Model, ?>> a;
    
    public Entry(List<ModelLoader<Model, ?>> param1List) {
      this.a = param1List;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\ModelLoaderRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */