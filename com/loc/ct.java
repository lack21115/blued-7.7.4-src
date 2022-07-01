package com.loc;

import java.util.List;

public final class ct {
  public static long a(int paramInt1, int paramInt2) {
    long l = paramInt1;
    return paramInt2 & 0xFFFFFFFFL | (l & 0xFFFFFFFFL) << 32L;
  }
  
  public static short a(long paramLong) {
    // Byte code:
    //   0: ldc com/loc/ct
    //   2: monitorenter
    //   3: invokestatic a : ()Lcom/loc/cs;
    //   6: lload_0
    //   7: invokevirtual a : (J)S
    //   10: istore_2
    //   11: ldc com/loc/ct
    //   13: monitorexit
    //   14: iload_2
    //   15: ireturn
    //   16: astore_3
    //   17: ldc com/loc/ct
    //   19: monitorexit
    //   20: aload_3
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	16	finally
  }
  
  public static void a(List<cw> paramList) {
    // Byte code:
    //   0: ldc com/loc/ct
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 224
    //   7: aload_0
    //   8: invokeinterface isEmpty : ()Z
    //   13: ifeq -> 19
    //   16: goto -> 224
    //   19: new java/util/ArrayList
    //   22: dup
    //   23: aload_0
    //   24: invokeinterface size : ()I
    //   29: invokespecial <init> : (I)V
    //   32: astore_1
    //   33: aload_0
    //   34: invokeinterface iterator : ()Ljava/util/Iterator;
    //   39: astore_2
    //   40: aload_2
    //   41: invokeinterface hasNext : ()Z
    //   46: ifeq -> 207
    //   49: aload_2
    //   50: invokeinterface next : ()Ljava/lang/Object;
    //   55: checkcast com/loc/cw
    //   58: astore_0
    //   59: aload_0
    //   60: instanceof com/loc/cy
    //   63: ifeq -> 102
    //   66: aload_0
    //   67: checkcast com/loc/cy
    //   70: astore_0
    //   71: new com/loc/ct$a
    //   74: dup
    //   75: aload_0
    //   76: getfield j : I
    //   79: aload_0
    //   80: getfield k : I
    //   83: aload_0
    //   84: getfield c : I
    //   87: invokespecial <init> : (III)V
    //   90: astore_0
    //   91: aload_1
    //   92: aload_0
    //   93: invokeinterface add : (Ljava/lang/Object;)Z
    //   98: pop
    //   99: goto -> 40
    //   102: aload_0
    //   103: instanceof com/loc/cz
    //   106: ifeq -> 137
    //   109: aload_0
    //   110: checkcast com/loc/cz
    //   113: astore_0
    //   114: new com/loc/ct$a
    //   117: dup
    //   118: aload_0
    //   119: getfield j : I
    //   122: aload_0
    //   123: getfield k : I
    //   126: aload_0
    //   127: getfield c : I
    //   130: invokespecial <init> : (III)V
    //   133: astore_0
    //   134: goto -> 91
    //   137: aload_0
    //   138: instanceof com/loc/da
    //   141: ifeq -> 172
    //   144: aload_0
    //   145: checkcast com/loc/da
    //   148: astore_0
    //   149: new com/loc/ct$a
    //   152: dup
    //   153: aload_0
    //   154: getfield j : I
    //   157: aload_0
    //   158: getfield k : I
    //   161: aload_0
    //   162: getfield c : I
    //   165: invokespecial <init> : (III)V
    //   168: astore_0
    //   169: goto -> 91
    //   172: aload_0
    //   173: instanceof com/loc/cx
    //   176: ifeq -> 40
    //   179: aload_0
    //   180: checkcast com/loc/cx
    //   183: astore_0
    //   184: new com/loc/ct$a
    //   187: dup
    //   188: aload_0
    //   189: getfield k : I
    //   192: aload_0
    //   193: getfield l : I
    //   196: aload_0
    //   197: getfield c : I
    //   200: invokespecial <init> : (III)V
    //   203: astore_0
    //   204: goto -> 91
    //   207: invokestatic a : ()Lcom/loc/cs;
    //   210: aload_1
    //   211: invokevirtual a : (Ljava/util/List;)V
    //   214: ldc com/loc/ct
    //   216: monitorexit
    //   217: return
    //   218: astore_0
    //   219: ldc com/loc/ct
    //   221: monitorexit
    //   222: aload_0
    //   223: athrow
    //   224: ldc com/loc/ct
    //   226: monitorexit
    //   227: return
    // Exception table:
    //   from	to	target	type
    //   7	16	218	finally
    //   19	40	218	finally
    //   40	91	218	finally
    //   91	99	218	finally
    //   102	134	218	finally
    //   137	169	218	finally
    //   172	204	218	finally
    //   207	214	218	finally
  }
  
  public static short b(long paramLong) {
    // Byte code:
    //   0: ldc com/loc/ct
    //   2: monitorenter
    //   3: invokestatic a : ()Lcom/loc/cs;
    //   6: lload_0
    //   7: invokevirtual b : (J)S
    //   10: istore_2
    //   11: ldc com/loc/ct
    //   13: monitorexit
    //   14: iload_2
    //   15: ireturn
    //   16: astore_3
    //   17: ldc com/loc/ct
    //   19: monitorexit
    //   20: aload_3
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	16	finally
  }
  
  public static void b(List<dd> paramList) {
    // Byte code:
    //   0: ldc com/loc/ct
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 101
    //   7: aload_0
    //   8: invokeinterface isEmpty : ()Z
    //   13: ifeq -> 19
    //   16: goto -> 101
    //   19: new java/util/ArrayList
    //   22: dup
    //   23: aload_0
    //   24: invokeinterface size : ()I
    //   29: invokespecial <init> : (I)V
    //   32: astore_1
    //   33: aload_0
    //   34: invokeinterface iterator : ()Ljava/util/Iterator;
    //   39: astore_0
    //   40: aload_0
    //   41: invokeinterface hasNext : ()Z
    //   46: ifeq -> 84
    //   49: aload_0
    //   50: invokeinterface next : ()Ljava/lang/Object;
    //   55: checkcast com/loc/dd
    //   58: astore_2
    //   59: aload_1
    //   60: new com/loc/ct$b
    //   63: dup
    //   64: aload_2
    //   65: getfield a : J
    //   68: aload_2
    //   69: getfield c : I
    //   72: invokespecial <init> : (JI)V
    //   75: invokeinterface add : (Ljava/lang/Object;)Z
    //   80: pop
    //   81: goto -> 40
    //   84: invokestatic a : ()Lcom/loc/cs;
    //   87: aload_1
    //   88: invokevirtual b : (Ljava/util/List;)V
    //   91: ldc com/loc/ct
    //   93: monitorexit
    //   94: return
    //   95: astore_0
    //   96: ldc com/loc/ct
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    //   101: ldc com/loc/ct
    //   103: monitorexit
    //   104: return
    // Exception table:
    //   from	to	target	type
    //   7	16	95	finally
    //   19	40	95	finally
    //   40	81	95	finally
    //   84	91	95	finally
  }
  
  public static final class a implements cr {
    private int a;
    
    private int b;
    
    private int c;
    
    a(int param1Int1, int param1Int2, int param1Int3) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
    }
    
    public final long a() {
      return ct.a(this.a, this.b);
    }
    
    public final int b() {
      return this.c;
    }
  }
  
  public static final class b implements cr {
    private long a;
    
    private int b;
    
    b(long param1Long, int param1Int) {
      this.a = param1Long;
      this.b = param1Int;
    }
    
    public final long a() {
      return this.a;
    }
    
    public final int b() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */