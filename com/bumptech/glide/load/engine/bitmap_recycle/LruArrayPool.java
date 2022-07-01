package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {
  private final GroupedLinkedMap<Key, Object> a = new GroupedLinkedMap<Key, Object>();
  
  private final KeyPool b = new KeyPool();
  
  private final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap<Class<?>, NavigableMap<Integer, Integer>>();
  
  private final Map<Class<?>, ArrayAdapterInterface<?>> d = new HashMap<Class<?>, ArrayAdapterInterface<?>>();
  
  private final int e = 4194304;
  
  private int f;
  
  public LruArrayPool() {}
  
  public LruArrayPool(int paramInt) {}
  
  private <T> T a(Key paramKey) {
    return (T)this.a.a(paramKey);
  }
  
  private <T> T a(Key paramKey, Class<T> paramClass) {
    ArrayAdapterInterface<T> arrayAdapterInterface = b(paramClass);
    T t2 = (T)a(paramKey);
    if (t2 != null) {
      this.f -= arrayAdapterInterface.a(t2) * arrayAdapterInterface.b();
      c(arrayAdapterInterface.a(t2), paramClass);
    } 
    T t1 = t2;
    if (t2 == null) {
      if (Log.isLoggable(arrayAdapterInterface.a(), 2)) {
        String str = arrayAdapterInterface.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Allocated ");
        stringBuilder.append(paramKey.a);
        stringBuilder.append(" bytes");
        Log.v(str, stringBuilder.toString());
      } 
      t1 = arrayAdapterInterface.a(paramKey.a);
    } 
    return t1;
  }
  
  private NavigableMap<Integer, Integer> a(Class<?> paramClass) {
    NavigableMap<Object, Object> navigableMap2 = (NavigableMap)this.c.get(paramClass);
    NavigableMap<Object, Object> navigableMap1 = navigableMap2;
    if (navigableMap2 == null) {
      navigableMap1 = new TreeMap<Object, Object>();
      this.c.put(paramClass, navigableMap1);
    } 
    return (NavigableMap)navigableMap1;
  }
  
  private boolean a(int paramInt, Integer paramInteger) {
    return (paramInteger != null && (b() || paramInteger.intValue() <= paramInt * 8));
  }
  
  private <T> ArrayAdapterInterface<T> b(Class<T> paramClass) {
    StringBuilder stringBuilder;
    ArrayAdapterInterface<?> arrayAdapterInterface = this.d.get(paramClass);
    if (arrayAdapterInterface == null) {
      if (paramClass.equals(int[].class)) {
        arrayAdapterInterface = new IntegerArrayAdapter();
      } else {
        if (paramClass.equals(byte[].class)) {
          arrayAdapterInterface = new ByteArrayAdapter();
          this.d.put(paramClass, arrayAdapterInterface);
          return (ArrayAdapterInterface)arrayAdapterInterface;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("No array pool found for: ");
        stringBuilder.append(paramClass.getSimpleName());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      this.d.put(paramClass, stringBuilder);
      return (ArrayAdapterInterface<T>)stringBuilder;
    } 
    return (ArrayAdapterInterface<T>)stringBuilder;
  }
  
  private <T> ArrayAdapterInterface<T> b(T paramT) {
    return b((Class)paramT.getClass());
  }
  
  private boolean b() {
    int i = this.f;
    return (i == 0 || this.e / i >= 2);
  }
  
  private boolean b(int paramInt) {
    return (paramInt <= this.e / 2);
  }
  
  private void c() {
    c(this.e);
  }
  
  private void c(int paramInt) {
    while (this.f > paramInt) {
      Object object = this.a.a();
      Preconditions.a(object);
      ArrayAdapterInterface<Object> arrayAdapterInterface = b(object);
      this.f -= arrayAdapterInterface.a(object) * arrayAdapterInterface.b();
      c(arrayAdapterInterface.a(object), object.getClass());
      if (Log.isLoggable(arrayAdapterInterface.a(), 2)) {
        String str = arrayAdapterInterface.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("evicted: ");
        stringBuilder.append(arrayAdapterInterface.a(object));
        Log.v(str, stringBuilder.toString());
      } 
    } 
  }
  
  private void c(int paramInt, Class<?> paramClass) {
    NavigableMap<Integer, Integer> navigableMap = a(paramClass);
    Integer integer = navigableMap.get(Integer.valueOf(paramInt));
    if (integer != null) {
      if (integer.intValue() == 1) {
        navigableMap.remove(Integer.valueOf(paramInt));
        return;
      } 
      navigableMap.put(Integer.valueOf(paramInt), Integer.valueOf(integer.intValue() - 1));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Tried to decrement empty size, size: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", this: ");
    stringBuilder.append(this);
    throw new NullPointerException(stringBuilder.toString());
  }
  
  public <T> T a(int paramInt, Class<T> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokespecial a : (Ljava/lang/Class;)Ljava/util/NavigableMap;
    //   7: iload_1
    //   8: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   11: invokeinterface ceilingKey : (Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast java/lang/Integer
    //   19: astore_3
    //   20: aload_0
    //   21: iload_1
    //   22: aload_3
    //   23: invokespecial a : (ILjava/lang/Integer;)Z
    //   26: ifeq -> 45
    //   29: aload_0
    //   30: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$KeyPool;
    //   33: aload_3
    //   34: invokevirtual intValue : ()I
    //   37: aload_2
    //   38: invokevirtual a : (ILjava/lang/Class;)Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$Key;
    //   41: astore_3
    //   42: goto -> 55
    //   45: aload_0
    //   46: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$KeyPool;
    //   49: iload_1
    //   50: aload_2
    //   51: invokevirtual a : (ILjava/lang/Class;)Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$Key;
    //   54: astore_3
    //   55: aload_0
    //   56: aload_3
    //   57: aload_2
    //   58: invokespecial a : (Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$Key;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: areturn
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	66	finally
    //   45	55	66	finally
    //   55	62	66	finally
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: invokespecial c : (I)V
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: bipush #40
    //   5: if_icmplt -> 36
    //   8: aload_0
    //   9: invokevirtual a : ()V
    //   12: goto -> 25
    //   15: aload_0
    //   16: aload_0
    //   17: getfield e : I
    //   20: iconst_2
    //   21: idiv
    //   22: invokespecial c : (I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    //   32: astore_2
    //   33: goto -> 28
    //   36: iload_1
    //   37: bipush #20
    //   39: if_icmpge -> 15
    //   42: iload_1
    //   43: bipush #15
    //   45: if_icmpne -> 25
    //   48: goto -> 15
    // Exception table:
    //   from	to	target	type
    //   8	12	32	finally
    //   15	25	32	finally
  }
  
  public <T> void a(T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getClass : ()Ljava/lang/Class;
    //   6: astore #7
    //   8: aload_0
    //   9: aload #7
    //   11: invokespecial b : (Ljava/lang/Class;)Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayAdapterInterface;
    //   14: astore #6
    //   16: aload #6
    //   18: aload_1
    //   19: invokeinterface a : (Ljava/lang/Object;)I
    //   24: istore_2
    //   25: aload #6
    //   27: invokeinterface b : ()I
    //   32: iload_2
    //   33: imul
    //   34: istore_3
    //   35: aload_0
    //   36: iload_3
    //   37: invokespecial b : (I)Z
    //   40: istore #5
    //   42: iload #5
    //   44: ifne -> 50
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$KeyPool;
    //   54: iload_2
    //   55: aload #7
    //   57: invokevirtual a : (ILjava/lang/Class;)Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$Key;
    //   60: astore #6
    //   62: aload_0
    //   63: getfield a : Lcom/bumptech/glide/load/engine/bitmap_recycle/GroupedLinkedMap;
    //   66: aload #6
    //   68: aload_1
    //   69: invokevirtual a : (Lcom/bumptech/glide/load/engine/bitmap_recycle/Poolable;Ljava/lang/Object;)V
    //   72: aload_0
    //   73: aload #7
    //   75: invokespecial a : (Ljava/lang/Class;)Ljava/util/NavigableMap;
    //   78: astore_1
    //   79: aload_1
    //   80: aload #6
    //   82: getfield a : I
    //   85: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   88: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast java/lang/Integer
    //   96: astore #7
    //   98: aload #6
    //   100: getfield a : I
    //   103: istore #4
    //   105: iconst_1
    //   106: istore_2
    //   107: aload #7
    //   109: ifnonnull -> 115
    //   112: goto -> 123
    //   115: iconst_1
    //   116: aload #7
    //   118: invokevirtual intValue : ()I
    //   121: iadd
    //   122: istore_2
    //   123: aload_1
    //   124: iload #4
    //   126: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   129: iload_2
    //   130: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   133: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: pop
    //   139: aload_0
    //   140: aload_0
    //   141: getfield f : I
    //   144: iload_3
    //   145: iadd
    //   146: putfield f : I
    //   149: aload_0
    //   150: invokespecial c : ()V
    //   153: aload_0
    //   154: monitorexit
    //   155: return
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	156	finally
    //   50	105	156	finally
    //   115	123	156	finally
    //   123	153	156	finally
  }
  
  public <T> T b(int paramInt, Class<T> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield b : Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$KeyPool;
    //   7: iload_1
    //   8: aload_2
    //   9: invokevirtual a : (ILjava/lang/Class;)Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$Key;
    //   12: aload_2
    //   13: invokespecial a : (Lcom/bumptech/glide/load/engine/bitmap_recycle/LruArrayPool$Key;Ljava/lang/Class;)Ljava/lang/Object;
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: areturn
    //   21: astore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_2
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	21	finally
  }
  
  static final class Key implements Poolable {
    int a;
    
    private final LruArrayPool.KeyPool b;
    
    private Class<?> c;
    
    Key(LruArrayPool.KeyPool param1KeyPool) {
      this.b = param1KeyPool;
    }
    
    public void a() {
      this.b.a(this);
    }
    
    void a(int param1Int, Class<?> param1Class) {
      this.a = param1Int;
      this.c = param1Class;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof Key;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a == ((Key)param1Object).a) {
          bool1 = bool2;
          if (this.c == ((Key)param1Object).c)
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      byte b;
      int i = this.a;
      Class<?> clazz = this.c;
      if (clazz != null) {
        b = clazz.hashCode();
      } else {
        b = 0;
      } 
      return i * 31 + b;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key{size=");
      stringBuilder.append(this.a);
      stringBuilder.append("array=");
      stringBuilder.append(this.c);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  static final class KeyPool extends BaseKeyPool<Key> {
    protected LruArrayPool.Key a() {
      return new LruArrayPool.Key(this);
    }
    
    LruArrayPool.Key a(int param1Int, Class<?> param1Class) {
      LruArrayPool.Key key = c();
      key.a(param1Int, param1Class);
      return key;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\LruArrayPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */