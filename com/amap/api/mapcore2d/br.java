package com.amap.api.mapcore2d;

import java.util.ArrayList;

class br extends bo<bs> {
  protected ArrayList<bs> b(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/LinkedList;
    //   6: astore #10
    //   8: aload #10
    //   10: ifnonnull -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: getfield a : Ljava/util/LinkedList;
    //   21: invokevirtual size : ()I
    //   24: istore #5
    //   26: iload_1
    //   27: istore #8
    //   29: iload_1
    //   30: iload #5
    //   32: if_icmple -> 39
    //   35: iload #5
    //   37: istore #8
    //   39: new java/util/ArrayList
    //   42: dup
    //   43: iload #8
    //   45: invokespecial <init> : (I)V
    //   48: astore #10
    //   50: iconst_0
    //   51: istore_1
    //   52: iconst_0
    //   53: istore_3
    //   54: iload_1
    //   55: iload #5
    //   57: if_icmpge -> 202
    //   60: aload_0
    //   61: getfield a : Ljava/util/LinkedList;
    //   64: iload_1
    //   65: invokevirtual get : (I)Ljava/lang/Object;
    //   68: checkcast com/amap/api/mapcore2d/bs
    //   71: astore #11
    //   73: aload #11
    //   75: ifnonnull -> 81
    //   78: goto -> 195
    //   81: aload #11
    //   83: getfield a : I
    //   86: istore #9
    //   88: iload_2
    //   89: ifeq -> 127
    //   92: iload #5
    //   94: istore #7
    //   96: iload_1
    //   97: istore #6
    //   99: iload_3
    //   100: istore #4
    //   102: iload #9
    //   104: ifne -> 175
    //   107: aload #10
    //   109: aload #11
    //   111: invokevirtual add : (Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_0
    //   116: getfield a : Ljava/util/LinkedList;
    //   119: iload_1
    //   120: invokevirtual remove : (I)Ljava/lang/Object;
    //   123: pop
    //   124: goto -> 159
    //   127: iload #5
    //   129: istore #7
    //   131: iload_1
    //   132: istore #6
    //   134: iload_3
    //   135: istore #4
    //   137: iload #9
    //   139: ifge -> 175
    //   142: aload #10
    //   144: aload #11
    //   146: invokevirtual add : (Ljava/lang/Object;)Z
    //   149: pop
    //   150: aload_0
    //   151: getfield a : Ljava/util/LinkedList;
    //   154: iload_1
    //   155: invokevirtual remove : (I)Ljava/lang/Object;
    //   158: pop
    //   159: iload #5
    //   161: iconst_1
    //   162: isub
    //   163: istore #7
    //   165: iload_1
    //   166: iconst_1
    //   167: isub
    //   168: istore #6
    //   170: iload_3
    //   171: iconst_1
    //   172: iadd
    //   173: istore #4
    //   175: iload #7
    //   177: istore #5
    //   179: iload #6
    //   181: istore_1
    //   182: iload #4
    //   184: istore_3
    //   185: iload #4
    //   187: iload #8
    //   189: if_icmplt -> 195
    //   192: goto -> 202
    //   195: iload_1
    //   196: iconst_1
    //   197: iadd
    //   198: istore_1
    //   199: goto -> 54
    //   202: aload_0
    //   203: monitorexit
    //   204: aload #10
    //   206: areturn
    //   207: aload_0
    //   208: monitorexit
    //   209: aconst_null
    //   210: areturn
    //   211: astore #10
    //   213: aload_0
    //   214: monitorexit
    //   215: aload #10
    //   217: athrow
    //   218: astore #10
    //   220: goto -> 207
    // Exception table:
    //   from	to	target	type
    //   2	8	211	finally
    //   17	26	218	finally
    //   39	50	218	finally
    //   60	73	218	finally
    //   81	88	218	finally
    //   107	124	218	finally
    //   142	159	218	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */