package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

class EngineResource<Z> implements Resource<Z> {
  private final boolean a;
  
  private final boolean b;
  
  private final Resource<Z> c;
  
  private final ResourceListener d;
  
  private final Key e;
  
  private int f;
  
  private boolean g;
  
  EngineResource(Resource<Z> paramResource, boolean paramBoolean1, boolean paramBoolean2, Key paramKey, ResourceListener paramResourceListener) {
    this.c = (Resource<Z>)Preconditions.a(paramResource);
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.e = paramKey;
    this.d = (ResourceListener)Preconditions.a(paramResourceListener);
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
    //   3: getfield f : I
    //   6: ifgt -> 50
    //   9: aload_0
    //   10: getfield g : Z
    //   13: ifne -> 40
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield g : Z
    //   21: aload_0
    //   22: getfield b : Z
    //   25: ifeq -> 37
    //   28: aload_0
    //   29: getfield c : Lcom/bumptech/glide/load/engine/Resource;
    //   32: invokeinterface c : ()V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: new java/lang/IllegalStateException
    //   43: dup
    //   44: ldc 'Cannot recycle a resource that has already been recycled'
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: athrow
    //   50: new java/lang/IllegalStateException
    //   53: dup
    //   54: ldc 'Cannot recycle a resource while it is still acquired'
    //   56: invokespecial <init> : (Ljava/lang/String;)V
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	60	finally
    //   40	50	60	finally
    //   50	60	60	finally
  }
  
  Resource<Z> d() {
    return this.c;
  }
  
  boolean e() {
    return this.a;
  }
  
  public Z f() {
    return this.c.f();
  }
  
  void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: ifne -> 22
    //   9: aload_0
    //   10: aload_0
    //   11: getfield f : I
    //   14: iconst_1
    //   15: iadd
    //   16: putfield f : I
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: new java/lang/IllegalStateException
    //   25: dup
    //   26: ldc 'Cannot acquire a recycled resource'
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: athrow
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	32	finally
    //   22	32	32	finally
  }
  
  void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : I
    //   6: ifle -> 53
    //   9: aload_0
    //   10: getfield f : I
    //   13: istore_2
    //   14: iconst_1
    //   15: istore_1
    //   16: iload_2
    //   17: iconst_1
    //   18: isub
    //   19: istore_2
    //   20: aload_0
    //   21: iload_2
    //   22: putfield f : I
    //   25: iload_2
    //   26: ifne -> 68
    //   29: goto -> 32
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_1
    //   35: ifeq -> 52
    //   38: aload_0
    //   39: getfield d : Lcom/bumptech/glide/load/engine/EngineResource$ResourceListener;
    //   42: aload_0
    //   43: getfield e : Lcom/bumptech/glide/load/Key;
    //   46: aload_0
    //   47: invokeinterface a : (Lcom/bumptech/glide/load/Key;Lcom/bumptech/glide/load/engine/EngineResource;)V
    //   52: return
    //   53: new java/lang/IllegalStateException
    //   56: dup
    //   57: ldc 'Cannot release a recycled or not yet acquired resource'
    //   59: invokespecial <init> : (Ljava/lang/String;)V
    //   62: athrow
    //   63: astore_3
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    //   68: iconst_0
    //   69: istore_1
    //   70: goto -> 32
    // Exception table:
    //   from	to	target	type
    //   2	14	63	finally
    //   20	25	63	finally
    //   32	34	63	finally
    //   53	63	63	finally
    //   64	66	63	finally
  }
  
  public String toString() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc 'EngineResource{isMemoryCacheable='
    //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_1
    //   18: aload_0
    //   19: getfield a : Z
    //   22: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_1
    //   27: ldc ', listener='
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: aload_0
    //   35: getfield d : Lcom/bumptech/glide/load/engine/EngineResource$ResourceListener;
    //   38: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: ldc ', key='
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: aload_0
    //   51: getfield e : Lcom/bumptech/glide/load/Key;
    //   54: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: ldc ', acquired='
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: aload_0
    //   67: getfield f : I
    //   70: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: ldc ', isRecycled='
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: aload_0
    //   83: getfield g : Z
    //   86: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: ldc ', resource='
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_1
    //   98: aload_0
    //   99: getfield c : Lcom/bumptech/glide/load/engine/Resource;
    //   102: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_1
    //   107: bipush #125
    //   109: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_1
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: areturn
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Exception table:
    //   from	to	target	type
    //   2	118	122	finally
  }
  
  static interface ResourceListener {
    void a(Key param1Key, EngineResource<?> param1EngineResource);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\EngineResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */