package a.c;

public class h<K, V> {
  public static Object[] e;
  
  public static int f;
  
  public static Object[] g;
  
  public static int h;
  
  public int[] b;
  
  public Object[] c;
  
  public int d;
  
  public h() {
    int[] arrayOfInt = d.a;
    throw new VerifyError("bad dex opcode");
  }
  
  public h(int paramInt) {
    if (paramInt == 0) {
      int[] arrayOfInt = d.a;
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 61
    //   7: ldc a/c/a
    //   9: monitorenter
    //   10: getstatic a/c/h.h : I
    //   13: bipush #10
    //   15: if_icmpge -> 49
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic a/c/h.g : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iload_2
    //   29: iconst_1
    //   30: ishl
    //   31: iconst_1
    //   32: isub
    //   33: istore_2
    //   34: goto -> 131
    //   37: aload_1
    //   38: putstatic a/c/h.g : [Ljava/lang/Object;
    //   41: getstatic a/c/h.h : I
    //   44: iconst_1
    //   45: iadd
    //   46: putstatic a/c/h.h : I
    //   49: ldc a/c/a
    //   51: monitorexit
    //   52: goto -> 121
    //   55: astore_0
    //   56: ldc a/c/a
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    //   61: aload_0
    //   62: arraylength
    //   63: iconst_4
    //   64: if_icmpne -> 121
    //   67: ldc a/c/a
    //   69: monitorenter
    //   70: getstatic a/c/h.f : I
    //   73: bipush #10
    //   75: if_icmpge -> 109
    //   78: aload_1
    //   79: iconst_0
    //   80: getstatic a/c/h.e : [Ljava/lang/Object;
    //   83: aastore
    //   84: aload_1
    //   85: iconst_1
    //   86: aload_0
    //   87: aastore
    //   88: iload_2
    //   89: iconst_1
    //   90: ishl
    //   91: iconst_1
    //   92: isub
    //   93: istore_2
    //   94: goto -> 147
    //   97: aload_1
    //   98: putstatic a/c/h.e : [Ljava/lang/Object;
    //   101: getstatic a/c/h.f : I
    //   104: iconst_1
    //   105: iadd
    //   106: putstatic a/c/h.f : I
    //   109: ldc a/c/a
    //   111: monitorexit
    //   112: goto -> 121
    //   115: astore_0
    //   116: ldc a/c/a
    //   118: monitorexit
    //   119: aload_0
    //   120: athrow
    //   121: new java/lang/VerifyError
    //   124: dup
    //   125: ldc 'bad dex opcode'
    //   127: invokespecial <init> : (Ljava/lang/String;)V
    //   130: athrow
    //   131: iload_2
    //   132: iconst_2
    //   133: if_icmplt -> 37
    //   136: aload_1
    //   137: iload_2
    //   138: aconst_null
    //   139: aastore
    //   140: iload_2
    //   141: iconst_1
    //   142: isub
    //   143: istore_2
    //   144: goto -> 131
    //   147: iload_2
    //   148: iconst_2
    //   149: if_icmplt -> 97
    //   152: aload_1
    //   153: iload_2
    //   154: aconst_null
    //   155: aastore
    //   156: iload_2
    //   157: iconst_1
    //   158: isub
    //   159: istore_2
    //   160: goto -> 147
    // Exception table:
    //   from	to	target	type
    //   10	24	55	finally
    //   37	49	55	finally
    //   49	52	55	finally
    //   56	59	55	finally
    //   70	84	115	finally
    //   97	109	115	finally
    //   109	112	115	finally
    //   116	119	115	finally
  }
  
  public int a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public int a(Object paramObject) {
    if (paramObject == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public int a(Object paramObject, int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 41
    //   6: ldc a/c/a
    //   8: monitorenter
    //   9: getstatic a/c/h.g : [Ljava/lang/Object;
    //   12: ifnull -> 29
    //   15: getstatic a/c/h.g : [Ljava/lang/Object;
    //   18: astore_2
    //   19: new java/lang/VerifyError
    //   22: dup
    //   23: ldc 'bad dex opcode'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: athrow
    //   29: ldc a/c/a
    //   31: monitorexit
    //   32: goto -> 81
    //   35: astore_2
    //   36: ldc a/c/a
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    //   41: iload_1
    //   42: iconst_4
    //   43: if_icmpne -> 81
    //   46: ldc a/c/a
    //   48: monitorenter
    //   49: getstatic a/c/h.e : [Ljava/lang/Object;
    //   52: ifnull -> 69
    //   55: getstatic a/c/h.e : [Ljava/lang/Object;
    //   58: astore_2
    //   59: new java/lang/VerifyError
    //   62: dup
    //   63: ldc 'bad dex opcode'
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: athrow
    //   69: ldc a/c/a
    //   71: monitorexit
    //   72: goto -> 81
    //   75: astore_2
    //   76: ldc a/c/a
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: iload_1
    //   82: newarray int
    //   84: astore_2
    //   85: new java/lang/VerifyError
    //   88: dup
    //   89: ldc 'bad dex opcode'
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   9	29	35	finally
    //   29	32	35	finally
    //   36	39	35	finally
    //   49	69	75	finally
    //   69	72	75	finally
    //   76	79	75	finally
  }
  
  public int b(Object paramObject) {
    throw new VerifyError("bad dex opcode");
  }
  
  public K b(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public V c(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public void clear() {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean containsKey(Object paramObject) {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean containsValue(Object paramObject) {
    throw new VerifyError("bad dex opcode");
  }
  
  public V d(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof h) {
      paramObject = paramObject;
      throw new VerifyError("bad dex opcode");
    } 
    if (paramObject instanceof java.util.Map) {
      paramObject = paramObject;
      throw new VerifyError("bad dex opcode");
    } 
    return false;
  }
  
  public V get(Object paramObject) {
    throw new VerifyError("bad dex opcode");
  }
  
  public int hashCode() {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean isEmpty() {
    throw new VerifyError("bad dex opcode");
  }
  
  public V put(K paramK, V paramV) {
    throw new VerifyError("bad dex opcode");
  }
  
  public V remove(Object paramObject) {
    throw new VerifyError("bad dex opcode");
  }
  
  public int size() {
    throw new VerifyError("bad dex opcode");
  }
  
  public String toString() {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */