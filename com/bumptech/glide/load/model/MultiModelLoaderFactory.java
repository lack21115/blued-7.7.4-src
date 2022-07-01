package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {
  private static final Factory a = new Factory();
  
  private static final ModelLoader<Object, Object> b = new EmptyModelLoader();
  
  private final List<Entry<?, ?>> c = new ArrayList<Entry<?, ?>>();
  
  private final Factory d;
  
  private final Set<Entry<?, ?>> e = new HashSet<Entry<?, ?>>();
  
  private final Pools.Pool<List<Throwable>> f;
  
  public MultiModelLoaderFactory(Pools.Pool<List<Throwable>> paramPool) {
    this(paramPool, a);
  }
  
  MultiModelLoaderFactory(Pools.Pool<List<Throwable>> paramPool, Factory paramFactory) {
    this.f = paramPool;
    this.d = paramFactory;
  }
  
  private static <Model, Data> ModelLoader<Model, Data> a() {
    return (ModelLoader)b;
  }
  
  private <Model, Data> ModelLoaderFactory<Model, Data> a(Entry<?, ?> paramEntry) {
    return (ModelLoaderFactory)paramEntry.b;
  }
  
  private <Model, Data> void a(Class<Model> paramClass, Class<Data> paramClass1, ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory, boolean paramBoolean) {
    boolean bool;
    Entry<Model, Data> entry = new Entry<Model, Data>(paramClass, paramClass1, paramModelLoaderFactory);
    List<Entry<?, ?>> list = this.c;
    if (paramBoolean) {
      bool = list.size();
    } else {
      bool = false;
    } 
    list.add(bool, entry);
  }
  
  private <Model, Data> ModelLoader<Model, Data> b(Entry<?, ?> paramEntry) {
    return (ModelLoader<Model, Data>)Preconditions.a(paramEntry.b.a(this));
  }
  
  <Model> List<ModelLoader<Model, ?>> a(Class<Model> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield c : Ljava/util/List;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface hasNext : ()Z
    //   26: ifeq -> 106
    //   29: aload_3
    //   30: invokeinterface next : ()Ljava/lang/Object;
    //   35: checkcast com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry
    //   38: astore #4
    //   40: aload_0
    //   41: getfield e : Ljava/util/Set;
    //   44: aload #4
    //   46: invokeinterface contains : (Ljava/lang/Object;)Z
    //   51: ifeq -> 57
    //   54: goto -> 20
    //   57: aload #4
    //   59: aload_1
    //   60: invokevirtual a : (Ljava/lang/Class;)Z
    //   63: ifeq -> 20
    //   66: aload_0
    //   67: getfield e : Ljava/util/Set;
    //   70: aload #4
    //   72: invokeinterface add : (Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload_2
    //   79: aload_0
    //   80: aload #4
    //   82: invokespecial b : (Lcom/bumptech/glide/load/model/MultiModelLoaderFactory$Entry;)Lcom/bumptech/glide/load/model/ModelLoader;
    //   85: invokeinterface add : (Ljava/lang/Object;)Z
    //   90: pop
    //   91: aload_0
    //   92: getfield e : Ljava/util/Set;
    //   95: aload #4
    //   97: invokeinterface remove : (Ljava/lang/Object;)Z
    //   102: pop
    //   103: goto -> 20
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: areturn
    //   110: astore_1
    //   111: aload_0
    //   112: getfield e : Ljava/util/Set;
    //   115: invokeinterface clear : ()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	110	finally
    //   20	54	110	finally
    //   57	103	110	finally
    //   111	122	122	finally
  }
  
  <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> a(Class<Model> paramClass, Class<Data> paramClass1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield c : Ljava/util/List;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore #4
    //   21: aload #4
    //   23: invokeinterface hasNext : ()Z
    //   28: ifeq -> 76
    //   31: aload #4
    //   33: invokeinterface next : ()Ljava/lang/Object;
    //   38: checkcast com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry
    //   41: astore #5
    //   43: aload #5
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;)Z
    //   50: ifeq -> 21
    //   53: aload #4
    //   55: invokeinterface remove : ()V
    //   60: aload_3
    //   61: aload_0
    //   62: aload #5
    //   64: invokespecial a : (Lcom/bumptech/glide/load/model/MultiModelLoaderFactory$Entry;)Lcom/bumptech/glide/load/model/ModelLoaderFactory;
    //   67: invokeinterface add : (Ljava/lang/Object;)Z
    //   72: pop
    //   73: goto -> 21
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_3
    //   79: areturn
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	80	finally
    //   21	73	80	finally
  }
  
  <Model, Data> void a(Class<Model> paramClass, Class<Data> paramClass1, ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: aload_3
    //   6: iconst_1
    //   7: invokespecial a : (Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;Z)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public <Model, Data> ModelLoader<Model, Data> b(Class<Model> paramClass, Class<Data> paramClass1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #4
    //   11: aload_0
    //   12: getfield c : Ljava/util/List;
    //   15: invokeinterface iterator : ()Ljava/util/Iterator;
    //   20: astore #5
    //   22: iconst_0
    //   23: istore_3
    //   24: aload #5
    //   26: invokeinterface hasNext : ()Z
    //   31: ifeq -> 116
    //   34: aload #5
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry
    //   44: astore #6
    //   46: aload_0
    //   47: getfield e : Ljava/util/Set;
    //   50: aload #6
    //   52: invokeinterface contains : (Ljava/lang/Object;)Z
    //   57: ifeq -> 65
    //   60: iconst_1
    //   61: istore_3
    //   62: goto -> 24
    //   65: aload #6
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;)Z
    //   72: ifeq -> 24
    //   75: aload_0
    //   76: getfield e : Ljava/util/Set;
    //   79: aload #6
    //   81: invokeinterface add : (Ljava/lang/Object;)Z
    //   86: pop
    //   87: aload #4
    //   89: aload_0
    //   90: aload #6
    //   92: invokespecial b : (Lcom/bumptech/glide/load/model/MultiModelLoaderFactory$Entry;)Lcom/bumptech/glide/load/model/ModelLoader;
    //   95: invokeinterface add : (Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload_0
    //   102: getfield e : Ljava/util/Set;
    //   105: aload #6
    //   107: invokeinterface remove : (Ljava/lang/Object;)Z
    //   112: pop
    //   113: goto -> 24
    //   116: aload #4
    //   118: invokeinterface size : ()I
    //   123: iconst_1
    //   124: if_icmple -> 145
    //   127: aload_0
    //   128: getfield d : Lcom/bumptech/glide/load/model/MultiModelLoaderFactory$Factory;
    //   131: aload #4
    //   133: aload_0
    //   134: getfield f : Landroidx/core/util/Pools$Pool;
    //   137: invokevirtual a : (Ljava/util/List;Landroidx/core/util/Pools$Pool;)Lcom/bumptech/glide/load/model/MultiModelLoader;
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: areturn
    //   145: aload #4
    //   147: invokeinterface size : ()I
    //   152: iconst_1
    //   153: if_icmpne -> 172
    //   156: aload #4
    //   158: iconst_0
    //   159: invokeinterface get : (I)Ljava/lang/Object;
    //   164: checkcast com/bumptech/glide/load/model/ModelLoader
    //   167: astore_1
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: areturn
    //   172: iload_3
    //   173: ifeq -> 184
    //   176: invokestatic a : ()Lcom/bumptech/glide/load/model/ModelLoader;
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: areturn
    //   184: new com/bumptech/glide/Registry$NoModelLoaderAvailableException
    //   187: dup
    //   188: aload_1
    //   189: aload_2
    //   190: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;)V
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: getfield e : Ljava/util/Set;
    //   199: invokeinterface clear : ()V
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	194	finally
    //   24	60	194	finally
    //   65	113	194	finally
    //   116	141	194	finally
    //   145	168	194	finally
    //   176	180	194	finally
    //   184	194	194	finally
    //   195	206	206	finally
  }
  
  List<Class<?>> b(Class<?> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield c : Ljava/util/List;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface hasNext : ()Z
    //   26: ifeq -> 78
    //   29: aload_3
    //   30: invokeinterface next : ()Ljava/lang/Object;
    //   35: checkcast com/bumptech/glide/load/model/MultiModelLoaderFactory$Entry
    //   38: astore #4
    //   40: aload_2
    //   41: aload #4
    //   43: getfield a : Ljava/lang/Class;
    //   46: invokeinterface contains : (Ljava/lang/Object;)Z
    //   51: ifne -> 20
    //   54: aload #4
    //   56: aload_1
    //   57: invokevirtual a : (Ljava/lang/Class;)Z
    //   60: ifeq -> 20
    //   63: aload_2
    //   64: aload #4
    //   66: getfield a : Ljava/lang/Class;
    //   69: invokeinterface add : (Ljava/lang/Object;)Z
    //   74: pop
    //   75: goto -> 20
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: areturn
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	82	finally
    //   20	75	82	finally
  }
  
  <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> b(Class<Model> paramClass, Class<Data> paramClass1, ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/List;
    //   8: astore #4
    //   10: aload_0
    //   11: aload_1
    //   12: aload_2
    //   13: aload_3
    //   14: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/model/ModelLoaderFactory;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: aload #4
    //   21: areturn
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	22	finally
  }
  
  static class EmptyModelLoader implements ModelLoader<Object, Object> {
    public ModelLoader.LoadData<Object> a(Object param1Object, int param1Int1, int param1Int2, Options param1Options) {
      return null;
    }
    
    public boolean a(Object param1Object) {
      return false;
    }
  }
  
  static class Entry<Model, Data> {
    final Class<Data> a;
    
    final ModelLoaderFactory<? extends Model, ? extends Data> b;
    
    private final Class<Model> c;
    
    public Entry(Class<Model> param1Class, Class<Data> param1Class1, ModelLoaderFactory<? extends Model, ? extends Data> param1ModelLoaderFactory) {
      this.c = param1Class;
      this.a = param1Class1;
      this.b = param1ModelLoaderFactory;
    }
    
    public boolean a(Class<?> param1Class) {
      return this.c.isAssignableFrom(param1Class);
    }
    
    public boolean a(Class<?> param1Class1, Class<?> param1Class2) {
      return (a(param1Class1) && this.a.isAssignableFrom(param1Class2));
    }
  }
  
  static class Factory {
    public <Model, Data> MultiModelLoader<Model, Data> a(List<ModelLoader<Model, Data>> param1List, Pools.Pool<List<Throwable>> param1Pool) {
      return new MultiModelLoader<Model, Data>(param1List, param1Pool);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\MultiModelLoaderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */