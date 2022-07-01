package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.List;

public class TranscoderRegistry {
  private final List<Entry<?, ?>> a = new ArrayList<Entry<?, ?>>();
  
  public <Z, R> ResourceTranscoder<Z, R> a(Class<Z> paramClass, Class<R> paramClass1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: aload_1
    //   4: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   7: ifeq -> 18
    //   10: invokestatic a : ()Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: getfield a : Ljava/util/List;
    //   22: invokeinterface iterator : ()Ljava/util/Iterator;
    //   27: astore_3
    //   28: aload_3
    //   29: invokeinterface hasNext : ()Z
    //   34: ifeq -> 68
    //   37: aload_3
    //   38: invokeinterface next : ()Ljava/lang/Object;
    //   43: checkcast com/bumptech/glide/load/resource/transcode/TranscoderRegistry$Entry
    //   46: astore #4
    //   48: aload #4
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;)Z
    //   55: ifeq -> 28
    //   58: aload #4
    //   60: getfield a : Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore_3
    //   76: aload_3
    //   77: ldc 'No transcoder registered to transcode from '
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_3
    //   84: aload_1
    //   85: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_3
    //   90: ldc ' to '
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_3
    //   97: aload_2
    //   98: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: new java/lang/IllegalArgumentException
    //   105: dup
    //   106: aload_3
    //   107: invokevirtual toString : ()Ljava/lang/String;
    //   110: invokespecial <init> : (Ljava/lang/String;)V
    //   113: athrow
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	114	finally
    //   18	28	114	finally
    //   28	64	114	finally
    //   68	114	114	finally
  }
  
  public <Z, R> void a(Class<Z> paramClass, Class<R> paramClass1, ResourceTranscoder<Z, R> paramResourceTranscoder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: new com/bumptech/glide/load/resource/transcode/TranscoderRegistry$Entry
    //   9: dup
    //   10: aload_1
    //   11: aload_2
    //   12: aload_3
    //   13: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;)V
    //   16: invokeinterface add : (Ljava/lang/Object;)Z
    //   21: pop
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	25	finally
  }
  
  public <Z, R> List<Class<R>> b(Class<Z> paramClass, Class<R> paramClass1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   15: ifeq -> 30
    //   18: aload_3
    //   19: aload_2
    //   20: invokeinterface add : (Ljava/lang/Object;)Z
    //   25: pop
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: areturn
    //   30: aload_0
    //   31: getfield a : Ljava/util/List;
    //   34: invokeinterface iterator : ()Ljava/util/Iterator;
    //   39: astore #4
    //   41: aload #4
    //   43: invokeinterface hasNext : ()Z
    //   48: ifeq -> 80
    //   51: aload #4
    //   53: invokeinterface next : ()Ljava/lang/Object;
    //   58: checkcast com/bumptech/glide/load/resource/transcode/TranscoderRegistry$Entry
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;)Z
    //   66: ifeq -> 41
    //   69: aload_3
    //   70: aload_2
    //   71: invokeinterface add : (Ljava/lang/Object;)Z
    //   76: pop
    //   77: goto -> 41
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: areturn
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	84	finally
    //   30	41	84	finally
    //   41	77	84	finally
  }
  
  static final class Entry<Z, R> {
    final ResourceTranscoder<Z, R> a;
    
    private final Class<Z> b;
    
    private final Class<R> c;
    
    Entry(Class<Z> param1Class, Class<R> param1Class1, ResourceTranscoder<Z, R> param1ResourceTranscoder) {
      this.b = param1Class;
      this.c = param1Class1;
      this.a = param1ResourceTranscoder;
    }
    
    public boolean a(Class<?> param1Class1, Class<?> param1Class2) {
      return (this.b.isAssignableFrom(param1Class1) && param1Class2.isAssignableFrom(this.c));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\transcode\TranscoderRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */