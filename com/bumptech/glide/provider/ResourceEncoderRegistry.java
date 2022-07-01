package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {
  private final List<Entry<?>> a = new ArrayList<Entry<?>>();
  
  public <Z> ResourceEncoder<Z> a(Class<Z> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield a : Ljava/util/List;
    //   8: invokeinterface size : ()I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmpge -> 60
    //   19: aload_0
    //   20: getfield a : Ljava/util/List;
    //   23: iload_2
    //   24: invokeinterface get : (I)Ljava/lang/Object;
    //   29: checkcast com/bumptech/glide/provider/ResourceEncoderRegistry$Entry
    //   32: astore #4
    //   34: aload #4
    //   36: aload_1
    //   37: invokevirtual a : (Ljava/lang/Class;)Z
    //   40: ifeq -> 53
    //   43: aload #4
    //   45: getfield a : Lcom/bumptech/glide/load/ResourceEncoder;
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: iload_2
    //   54: iconst_1
    //   55: iadd
    //   56: istore_2
    //   57: goto -> 14
    //   60: aload_0
    //   61: monitorexit
    //   62: aconst_null
    //   63: areturn
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   4	14	64	finally
    //   19	49	64	finally
  }
  
  public <Z> void a(Class<Z> paramClass, ResourceEncoder<Z> paramResourceEncoder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: new com/bumptech/glide/provider/ResourceEncoderRegistry$Entry
    //   9: dup
    //   10: aload_1
    //   11: aload_2
    //   12: invokespecial <init> : (Ljava/lang/Class;Lcom/bumptech/glide/load/ResourceEncoder;)V
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
    final ResourceEncoder<T> a;
    
    private final Class<T> b;
    
    Entry(Class<T> param1Class, ResourceEncoder<T> param1ResourceEncoder) {
      this.b = param1Class;
      this.a = param1ResourceEncoder;
    }
    
    boolean a(Class<?> param1Class) {
      return this.b.isAssignableFrom(param1Class);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\provider\ResourceEncoderRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */