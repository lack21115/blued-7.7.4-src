package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry {
  private final List<String> a = new ArrayList<String>();
  
  private final Map<String, List<Entry<?, ?>>> b = new HashMap<String, List<Entry<?, ?>>>();
  
  private List<Entry<?, ?>> a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface contains : (Ljava/lang/Object;)Z
    //   12: ifne -> 26
    //   15: aload_0
    //   16: getfield a : Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface add : (Ljava/lang/Object;)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield b : Ljava/util/Map;
    //   30: aload_1
    //   31: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast java/util/List
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: ifnonnull -> 66
    //   46: new java/util/ArrayList
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: astore_2
    //   54: aload_0
    //   55: getfield b : Ljava/util/Map;
    //   58: aload_1
    //   59: aload_2
    //   60: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_2
    //   69: areturn
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	70	finally
    //   26	40	70	finally
    //   46	66	70	finally
  }
  
  public <T, R> List<ResourceDecoder<T, R>> a(Class<T> paramClass, Class<R> paramClass1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield a : Ljava/util/List;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore #4
    //   21: aload #4
    //   23: invokeinterface hasNext : ()Z
    //   28: ifeq -> 123
    //   31: aload #4
    //   33: invokeinterface next : ()Ljava/lang/Object;
    //   38: checkcast java/lang/String
    //   41: astore #5
    //   43: aload_0
    //   44: getfield b : Ljava/util/Map;
    //   47: aload #5
    //   49: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast java/util/List
    //   57: astore #5
    //   59: aload #5
    //   61: ifnonnull -> 67
    //   64: goto -> 21
    //   67: aload #5
    //   69: invokeinterface iterator : ()Ljava/util/Iterator;
    //   74: astore #5
    //   76: aload #5
    //   78: invokeinterface hasNext : ()Z
    //   83: ifeq -> 21
    //   86: aload #5
    //   88: invokeinterface next : ()Ljava/lang/Object;
    //   93: checkcast com/bumptech/glide/provider/ResourceDecoderRegistry$Entry
    //   96: astore #6
    //   98: aload #6
    //   100: aload_1
    //   101: aload_2
    //   102: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;)Z
    //   105: ifeq -> 76
    //   108: aload_3
    //   109: aload #6
    //   111: getfield b : Lcom/bumptech/glide/load/ResourceDecoder;
    //   114: invokeinterface add : (Ljava/lang/Object;)Z
    //   119: pop
    //   120: goto -> 76
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_3
    //   126: areturn
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	127	finally
    //   21	59	127	finally
    //   67	76	127	finally
    //   76	120	127	finally
  }
  
  public <T, R> void a(String paramString, ResourceDecoder<T, R> paramResourceDecoder, Class<T> paramClass, Class<R> paramClass1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial a : (Ljava/lang/String;)Ljava/util/List;
    //   7: new com/bumptech/glide/provider/ResourceDecoderRegistry$Entry
    //   10: dup
    //   11: aload_3
    //   12: aload #4
    //   14: aload_2
    //   15: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/ResourceDecoder;)V
    //   18: invokeinterface add : (Ljava/lang/Object;)Z
    //   23: pop
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
  }
  
  public void a(List<String> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: aload_0
    //   7: getfield a : Ljava/util/List;
    //   10: invokespecial <init> : (Ljava/util/Collection;)V
    //   13: astore_2
    //   14: aload_0
    //   15: getfield a : Ljava/util/List;
    //   18: invokeinterface clear : ()V
    //   23: aload_1
    //   24: invokeinterface iterator : ()Ljava/util/Iterator;
    //   29: astore_3
    //   30: aload_3
    //   31: invokeinterface hasNext : ()Z
    //   36: ifeq -> 65
    //   39: aload_3
    //   40: invokeinterface next : ()Ljava/lang/Object;
    //   45: checkcast java/lang/String
    //   48: astore #4
    //   50: aload_0
    //   51: getfield a : Ljava/util/List;
    //   54: aload #4
    //   56: invokeinterface add : (Ljava/lang/Object;)Z
    //   61: pop
    //   62: goto -> 30
    //   65: aload_2
    //   66: invokeinterface iterator : ()Ljava/util/Iterator;
    //   71: astore_2
    //   72: aload_2
    //   73: invokeinterface hasNext : ()Z
    //   78: ifeq -> 115
    //   81: aload_2
    //   82: invokeinterface next : ()Ljava/lang/Object;
    //   87: checkcast java/lang/String
    //   90: astore_3
    //   91: aload_1
    //   92: aload_3
    //   93: invokeinterface contains : (Ljava/lang/Object;)Z
    //   98: ifne -> 72
    //   101: aload_0
    //   102: getfield a : Ljava/util/List;
    //   105: aload_3
    //   106: invokeinterface add : (Ljava/lang/Object;)Z
    //   111: pop
    //   112: goto -> 72
    //   115: aload_0
    //   116: monitorexit
    //   117: return
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	118	finally
    //   30	62	118	finally
    //   65	72	118	finally
    //   72	112	118	finally
  }
  
  public <T, R> List<Class<R>> b(Class<T> paramClass, Class<R> paramClass1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_3
    //   10: aload_0
    //   11: getfield a : Ljava/util/List;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore #4
    //   21: aload #4
    //   23: invokeinterface hasNext : ()Z
    //   28: ifeq -> 137
    //   31: aload #4
    //   33: invokeinterface next : ()Ljava/lang/Object;
    //   38: checkcast java/lang/String
    //   41: astore #5
    //   43: aload_0
    //   44: getfield b : Ljava/util/Map;
    //   47: aload #5
    //   49: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast java/util/List
    //   57: astore #5
    //   59: aload #5
    //   61: ifnonnull -> 67
    //   64: goto -> 21
    //   67: aload #5
    //   69: invokeinterface iterator : ()Ljava/util/Iterator;
    //   74: astore #5
    //   76: aload #5
    //   78: invokeinterface hasNext : ()Z
    //   83: ifeq -> 21
    //   86: aload #5
    //   88: invokeinterface next : ()Ljava/lang/Object;
    //   93: checkcast com/bumptech/glide/provider/ResourceDecoderRegistry$Entry
    //   96: astore #6
    //   98: aload #6
    //   100: aload_1
    //   101: aload_2
    //   102: invokevirtual a : (Ljava/lang/Class;Ljava/lang/Class;)Z
    //   105: ifeq -> 76
    //   108: aload_3
    //   109: aload #6
    //   111: getfield a : Ljava/lang/Class;
    //   114: invokeinterface contains : (Ljava/lang/Object;)Z
    //   119: ifne -> 76
    //   122: aload_3
    //   123: aload #6
    //   125: getfield a : Ljava/lang/Class;
    //   128: invokeinterface add : (Ljava/lang/Object;)Z
    //   133: pop
    //   134: goto -> 76
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_3
    //   140: areturn
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	141	finally
    //   21	59	141	finally
    //   67	76	141	finally
    //   76	134	141	finally
  }
  
  public <T, R> void b(String paramString, ResourceDecoder<T, R> paramResourceDecoder, Class<T> paramClass, Class<R> paramClass1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial a : (Ljava/lang/String;)Ljava/util/List;
    //   7: iconst_0
    //   8: new com/bumptech/glide/provider/ResourceDecoderRegistry$Entry
    //   11: dup
    //   12: aload_3
    //   13: aload #4
    //   15: aload_2
    //   16: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/load/ResourceDecoder;)V
    //   19: invokeinterface add : (ILjava/lang/Object;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
  }
  
  static class Entry<T, R> {
    final Class<R> a;
    
    final ResourceDecoder<T, R> b;
    
    private final Class<T> c;
    
    public Entry(Class<T> param1Class, Class<R> param1Class1, ResourceDecoder<T, R> param1ResourceDecoder) {
      this.c = param1Class;
      this.a = param1Class1;
      this.b = param1ResourceDecoder;
    }
    
    public boolean a(Class<?> param1Class1, Class<?> param1Class2) {
      return (this.c.isAssignableFrom(param1Class1) && param1Class2.isAssignableFrom(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\provider\ResourceDecoderRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */