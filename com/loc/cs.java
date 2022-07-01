package com.loc;

import android.util.LongSparseArray;
import java.util.List;

public final class cs {
  private static volatile cs g;
  
  private static Object h = new Object();
  
  private LongSparseArray<a> a = new LongSparseArray();
  
  private LongSparseArray<a> b = new LongSparseArray();
  
  private LongSparseArray<a> c = new LongSparseArray();
  
  private LongSparseArray<a> d = new LongSparseArray();
  
  private Object e = new Object();
  
  private Object f = new Object();
  
  public static cs a() {
    if (g == null)
      synchronized (h) {
        if (g == null)
          g = new cs(); 
      }  
    return g;
  }
  
  private static short a(LongSparseArray<a> paramLongSparseArray, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: invokevirtual get : (J)Ljava/lang/Object;
    //   7: checkcast com/loc/cs$a
    //   10: astore #4
    //   12: aload #4
    //   14: ifnonnull -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: iconst_0
    //   20: ireturn
    //   21: lconst_1
    //   22: ldc2_w 32767
    //   25: invokestatic elapsedRealtime : ()J
    //   28: aload #4
    //   30: getfield b : J
    //   33: lsub
    //   34: ldc2_w 1000
    //   37: ldiv
    //   38: invokestatic min : (JJ)J
    //   41: invokestatic max : (JJ)J
    //   44: l2i
    //   45: i2s
    //   46: istore_3
    //   47: aload #4
    //   49: getfield c : Z
    //   52: ifeq -> 69
    //   55: goto -> 58
    //   58: aload_0
    //   59: monitorexit
    //   60: iload_3
    //   61: ireturn
    //   62: astore #4
    //   64: aload_0
    //   65: monitorexit
    //   66: aload #4
    //   68: athrow
    //   69: iload_3
    //   70: ineg
    //   71: i2s
    //   72: istore_3
    //   73: goto -> 58
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   17	19	62	finally
    //   21	55	62	finally
    //   58	60	62	finally
    //   64	66	62	finally
  }
  
  private static void a(List<cr> paramList, LongSparseArray<a> paramLongSparseArray1, LongSparseArray<a> paramLongSparseArray2) {
    // Byte code:
    //   0: invokestatic elapsedRealtime : ()J
    //   3: lstore #4
    //   5: aload_1
    //   6: invokevirtual size : ()I
    //   9: istore_3
    //   10: aload_0
    //   11: invokeinterface iterator : ()Ljava/util/Iterator;
    //   16: astore #9
    //   18: iload_3
    //   19: ifne -> 88
    //   22: aload #9
    //   24: invokeinterface hasNext : ()Z
    //   29: ifeq -> 87
    //   32: aload #9
    //   34: invokeinterface next : ()Ljava/lang/Object;
    //   39: checkcast com/loc/cr
    //   42: astore_0
    //   43: new com/loc/cs$a
    //   46: dup
    //   47: iconst_0
    //   48: invokespecial <init> : (B)V
    //   51: astore_1
    //   52: aload_1
    //   53: aload_0
    //   54: invokeinterface b : ()I
    //   59: putfield a : I
    //   62: aload_1
    //   63: lload #4
    //   65: putfield b : J
    //   68: aload_1
    //   69: iconst_0
    //   70: putfield c : Z
    //   73: aload_2
    //   74: aload_0
    //   75: invokeinterface a : ()J
    //   80: aload_1
    //   81: invokevirtual put : (JLjava/lang/Object;)V
    //   84: goto -> 22
    //   87: return
    //   88: aload #9
    //   90: invokeinterface hasNext : ()Z
    //   95: ifeq -> 201
    //   98: aload #9
    //   100: invokeinterface next : ()Ljava/lang/Object;
    //   105: checkcast com/loc/cr
    //   108: astore #10
    //   110: aload #10
    //   112: invokeinterface a : ()J
    //   117: lstore #6
    //   119: aload_1
    //   120: lload #6
    //   122: invokevirtual get : (J)Ljava/lang/Object;
    //   125: checkcast com/loc/cs$a
    //   128: astore_0
    //   129: aload_0
    //   130: ifnonnull -> 170
    //   133: new com/loc/cs$a
    //   136: dup
    //   137: iconst_0
    //   138: invokespecial <init> : (B)V
    //   141: astore_0
    //   142: aload_0
    //   143: aload #10
    //   145: invokeinterface b : ()I
    //   150: putfield a : I
    //   153: aload_0
    //   154: lload #4
    //   156: putfield b : J
    //   159: aload_0
    //   160: iconst_1
    //   161: putfield c : Z
    //   164: aload_0
    //   165: astore #8
    //   167: goto -> 190
    //   170: aload_0
    //   171: astore #8
    //   173: aload_0
    //   174: getfield a : I
    //   177: aload #10
    //   179: invokeinterface b : ()I
    //   184: if_icmpeq -> 190
    //   187: goto -> 142
    //   190: aload_2
    //   191: lload #6
    //   193: aload #8
    //   195: invokevirtual put : (JLjava/lang/Object;)V
    //   198: goto -> 88
    //   201: return
  }
  
  final short a(long paramLong) {
    return a(this.a, paramLong);
  }
  
  final void a(List<cr> paramList) {
    if (paramList.isEmpty())
      return; 
    synchronized (this.e) {
      a(paramList, this.a, this.b);
      LongSparseArray<a> longSparseArray = this.a;
      this.a = this.b;
      this.b = longSparseArray;
      this.b.clear();
      return;
    } 
  }
  
  final short b(long paramLong) {
    return a(this.c, paramLong);
  }
  
  final void b(List<cr> paramList) {
    if (paramList.isEmpty())
      return; 
    synchronized (this.f) {
      a(paramList, this.c, this.d);
      LongSparseArray<a> longSparseArray = this.c;
      this.c = this.d;
      this.d = longSparseArray;
      this.d.clear();
      return;
    } 
  }
  
  static final class a {
    int a;
    
    long b;
    
    boolean c;
    
    private a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */