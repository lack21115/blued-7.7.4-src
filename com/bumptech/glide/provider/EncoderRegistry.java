package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {
  private final List<Entry<?>> a = new ArrayList<Entry<?>>();
  
  public <T> Encoder<T> a(Class<T> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 48
    //   21: aload_2
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/bumptech/glide/provider/EncoderRegistry$Entry
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual a : (Ljava/lang/Class;)Z
    //   36: ifeq -> 12
    //   39: aload_3
    //   40: getfield a : Lcom/bumptech/glide/load/Encoder;
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: aload_0
    //   49: monitorexit
    //   50: aconst_null
    //   51: areturn
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	52	finally
    //   12	44	52	finally
  }
  
  public <T> void a(Class<T> paramClass, Encoder<T> paramEncoder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: new com/bumptech/glide/provider/EncoderRegistry$Entry
    //   9: dup
    //   10: aload_1
    //   11: aload_2
    //   12: invokespecial <init> : (Ljava/lang/Class;Lcom/bumptech/glide/load/Encoder;)V
    //   15: invokeinterface add : (Ljava/lang/Object;)Z
    //   20: pop
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
  }
  
  static final class Entry<T> {
    final Encoder<T> a;
    
    private final Class<T> b;
    
    Entry(Class<T> param1Class, Encoder<T> param1Encoder) {
      this.b = param1Class;
      this.a = param1Encoder;
    }
    
    boolean a(Class<?> param1Class) {
      return this.b.isAssignableFrom(param1Class);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\provider\EncoderRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */