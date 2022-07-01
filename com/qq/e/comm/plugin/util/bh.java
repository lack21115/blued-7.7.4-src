package com.qq.e.comm.plugin.util;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bh<K, V> {
  private Map<K, List<WeakReference<V>>> a = new HashMap<K, List<WeakReference<V>>>();
  
  public Collection<V> a(K paramK) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast java/util/List
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull -> 123
    //   20: aload_2
    //   21: invokeinterface isEmpty : ()Z
    //   26: ifeq -> 32
    //   29: goto -> 123
    //   32: aload_2
    //   33: invokeinterface iterator : ()Ljava/util/Iterator;
    //   38: astore_2
    //   39: new java/util/ArrayList
    //   42: dup
    //   43: invokespecial <init> : ()V
    //   46: astore_3
    //   47: aload_2
    //   48: invokeinterface hasNext : ()Z
    //   53: ifeq -> 96
    //   56: aload_2
    //   57: invokeinterface next : ()Ljava/lang/Object;
    //   62: checkcast java/lang/ref/WeakReference
    //   65: invokevirtual get : ()Ljava/lang/Object;
    //   68: astore #4
    //   70: aload #4
    //   72: ifnonnull -> 84
    //   75: aload_2
    //   76: invokeinterface remove : ()V
    //   81: goto -> 47
    //   84: aload_3
    //   85: aload #4
    //   87: invokeinterface add : (Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -> 47
    //   96: aload_3
    //   97: astore_2
    //   98: aload_3
    //   99: invokeinterface isEmpty : ()Z
    //   104: ifeq -> 127
    //   107: aload_0
    //   108: getfield a : Ljava/util/Map;
    //   111: aload_1
    //   112: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: aload_3
    //   119: astore_2
    //   120: goto -> 127
    //   123: invokestatic emptyList : ()Ljava/util/List;
    //   126: astore_2
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_2
    //   130: areturn
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	131	finally
    //   20	29	131	finally
    //   32	47	131	finally
    //   47	70	131	finally
    //   75	81	131	finally
    //   84	93	131	finally
    //   98	118	131	finally
    //   123	127	131	finally
  }
  
  public void a(K paramK, V paramV) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast java/util/List
    //   15: astore #4
    //   17: aload #4
    //   19: astore_3
    //   20: aload #4
    //   22: ifnonnull -> 45
    //   25: new java/util/ArrayList
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore_3
    //   33: aload_0
    //   34: getfield a : Ljava/util/Map;
    //   37: aload_1
    //   38: aload_3
    //   39: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_3
    //   46: new java/lang/ref/WeakReference
    //   49: dup
    //   50: aload_2
    //   51: invokespecial <init> : (Ljava/lang/Object;)V
    //   54: invokeinterface add : (Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	63	finally
    //   25	45	63	finally
    //   45	60	63	finally
  }
  
  public void a(String paramString, V paramV) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast java/util/List
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull -> 61
    //   20: aload_1
    //   21: invokeinterface iterator : ()Ljava/util/Iterator;
    //   26: astore_1
    //   27: aload_1
    //   28: invokeinterface hasNext : ()Z
    //   33: ifeq -> 61
    //   36: aload_1
    //   37: invokeinterface next : ()Ljava/lang/Object;
    //   42: checkcast java/lang/ref/WeakReference
    //   45: invokevirtual get : ()Ljava/lang/Object;
    //   48: aload_2
    //   49: if_acmpne -> 27
    //   52: aload_1
    //   53: invokeinterface remove : ()V
    //   58: goto -> 27
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	64	finally
    //   20	27	64	finally
    //   27	58	64	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */