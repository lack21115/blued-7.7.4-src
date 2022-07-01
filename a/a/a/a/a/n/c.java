package a.a.a.a.a.n;

import java.util.ArrayList;
import java.util.HashMap;

public final class c {
  public static final String[] a = new String[] { "domain", "wsHost" };
  
  public final HashMap<String, a> b = new HashMap<String, a>();
  
  public final HashMap<String, Integer[]> c = (HashMap)new HashMap<String, Integer>();
  
  public a a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast a/a/a/a/a/n/a
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
  }
  
  public ArrayList<String> a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: aload_0
    //   7: getfield b : Ljava/util/HashMap;
    //   10: invokevirtual keySet : ()Ljava/util/Set;
    //   13: invokespecial <init> : (Ljava/util/Collection;)V
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	21	finally
  }
  
  public void a(ArrayList<String> paramArrayList, HashMap<String, ArrayList<String>> paramHashMap, HashMap<String, Integer[]> paramHashMap1, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/HashMap;
    //   6: invokevirtual clear : ()V
    //   9: aload_0
    //   10: getfield c : Ljava/util/HashMap;
    //   13: invokevirtual clear : ()V
    //   16: aload_2
    //   17: invokevirtual entrySet : ()Ljava/util/Set;
    //   20: invokeinterface iterator : ()Ljava/util/Iterator;
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 107
    //   35: aload_2
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast java/util/Map$Entry
    //   44: astore #5
    //   46: aload #5
    //   48: invokeinterface getValue : ()Ljava/lang/Object;
    //   53: checkcast java/util/ArrayList
    //   56: invokevirtual size : ()I
    //   59: anewarray java/lang/String
    //   62: astore #6
    //   64: aload_0
    //   65: getfield b : Ljava/util/HashMap;
    //   68: aload #5
    //   70: invokeinterface getKey : ()Ljava/lang/Object;
    //   75: new a/a/a/a/a/n/a
    //   78: dup
    //   79: aload #5
    //   81: invokeinterface getValue : ()Ljava/lang/Object;
    //   86: checkcast java/util/ArrayList
    //   89: aload #6
    //   91: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   94: checkcast [Ljava/lang/String;
    //   97: invokespecial <init> : ([Ljava/lang/String;)V
    //   100: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: goto -> 26
    //   107: aload_1
    //   108: invokevirtual iterator : ()Ljava/util/Iterator;
    //   111: astore_1
    //   112: aload_1
    //   113: invokeinterface hasNext : ()Z
    //   118: ifeq -> 151
    //   121: aload_1
    //   122: invokeinterface next : ()Ljava/lang/Object;
    //   127: checkcast java/lang/String
    //   130: astore_2
    //   131: aload_0
    //   132: getfield b : Ljava/util/HashMap;
    //   135: aload_2
    //   136: new a/a/a/a/a/n/a
    //   139: dup
    //   140: aconst_null
    //   141: invokespecial <init> : ([Ljava/lang/String;)V
    //   144: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: goto -> 112
    //   151: aload_3
    //   152: invokevirtual entrySet : ()Ljava/util/Set;
    //   155: invokeinterface iterator : ()Ljava/util/Iterator;
    //   160: astore_1
    //   161: aload_1
    //   162: invokeinterface hasNext : ()Z
    //   167: ifeq -> 203
    //   170: aload_1
    //   171: invokeinterface next : ()Ljava/lang/Object;
    //   176: checkcast java/util/Map$Entry
    //   179: astore_2
    //   180: aload_0
    //   181: getfield c : Ljava/util/HashMap;
    //   184: aload_2
    //   185: invokeinterface getKey : ()Ljava/lang/Object;
    //   190: aload_2
    //   191: invokeinterface getValue : ()Ljava/lang/Object;
    //   196: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: goto -> 161
    //   203: aload_0
    //   204: monitorexit
    //   205: return
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	206	finally
    //   26	104	206	finally
    //   107	112	206	finally
    //   112	148	206	finally
    //   151	161	206	finally
    //   161	200	206	finally
  }
  
  public Integer[] b(String paramString) {
    return this.c.containsKey(paramString) ? this.c.get(paramString) : new Integer[] { Integer.valueOf(2), Integer.valueOf(6935) };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\n\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */