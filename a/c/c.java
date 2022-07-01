package a.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c<E> implements Collection<E>, Set<E> {
  public static final int[] f = new int[0];
  
  public static final Object[] g = new Object[0];
  
  public static Object[] h;
  
  public static int i;
  
  public static Object[] j;
  
  public static int k;
  
  public int[] b;
  
  public Object[] c;
  
  public int d;
  
  public g<E, E> e;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public c() {
    int[] arrayOfInt = f;
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 59
    //   7: ldc a/c/c
    //   9: monitorenter
    //   10: getstatic a/c/c.k : I
    //   13: bipush #10
    //   15: if_icmpge -> 47
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic a/c/c.j : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iload_2
    //   29: iconst_1
    //   30: isub
    //   31: istore_2
    //   32: goto -> 127
    //   35: aload_1
    //   36: putstatic a/c/c.j : [Ljava/lang/Object;
    //   39: getstatic a/c/c.k : I
    //   42: iconst_1
    //   43: iadd
    //   44: putstatic a/c/c.k : I
    //   47: ldc a/c/c
    //   49: monitorexit
    //   50: goto -> 117
    //   53: astore_0
    //   54: ldc a/c/c
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    //   59: aload_0
    //   60: arraylength
    //   61: iconst_4
    //   62: if_icmpne -> 117
    //   65: ldc a/c/c
    //   67: monitorenter
    //   68: getstatic a/c/c.i : I
    //   71: bipush #10
    //   73: if_icmpge -> 105
    //   76: aload_1
    //   77: iconst_0
    //   78: getstatic a/c/c.h : [Ljava/lang/Object;
    //   81: aastore
    //   82: aload_1
    //   83: iconst_1
    //   84: aload_0
    //   85: aastore
    //   86: iload_2
    //   87: iconst_1
    //   88: isub
    //   89: istore_2
    //   90: goto -> 143
    //   93: aload_1
    //   94: putstatic a/c/c.h : [Ljava/lang/Object;
    //   97: getstatic a/c/c.i : I
    //   100: iconst_1
    //   101: iadd
    //   102: putstatic a/c/c.i : I
    //   105: ldc a/c/c
    //   107: monitorexit
    //   108: goto -> 117
    //   111: astore_0
    //   112: ldc a/c/c
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    //   117: new java/lang/VerifyError
    //   120: dup
    //   121: ldc 'bad dex opcode'
    //   123: invokespecial <init> : (Ljava/lang/String;)V
    //   126: athrow
    //   127: iload_2
    //   128: iconst_2
    //   129: if_icmplt -> 35
    //   132: aload_1
    //   133: iload_2
    //   134: aconst_null
    //   135: aastore
    //   136: iload_2
    //   137: iconst_1
    //   138: isub
    //   139: istore_2
    //   140: goto -> 127
    //   143: iload_2
    //   144: iconst_2
    //   145: if_icmplt -> 93
    //   148: aload_1
    //   149: iload_2
    //   150: aconst_null
    //   151: aastore
    //   152: iload_2
    //   153: iconst_1
    //   154: isub
    //   155: istore_2
    //   156: goto -> 143
    // Exception table:
    //   from	to	target	type
    //   10	24	53	finally
    //   35	47	53	finally
    //   47	50	53	finally
    //   54	57	53	finally
    //   68	82	111	finally
    //   93	105	111	finally
    //   105	108	111	finally
    //   112	115	111	finally
  }
  
  public final int a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public int a(Object paramObject) {
    if (paramObject == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final int a(Object paramObject, int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 41
    //   6: ldc a/c/c
    //   8: monitorenter
    //   9: getstatic a/c/c.j : [Ljava/lang/Object;
    //   12: ifnull -> 29
    //   15: getstatic a/c/c.j : [Ljava/lang/Object;
    //   18: astore_2
    //   19: new java/lang/VerifyError
    //   22: dup
    //   23: ldc 'bad dex opcode'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: athrow
    //   29: ldc a/c/c
    //   31: monitorexit
    //   32: goto -> 81
    //   35: astore_2
    //   36: ldc a/c/c
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    //   41: iload_1
    //   42: iconst_4
    //   43: if_icmpne -> 81
    //   46: ldc a/c/c
    //   48: monitorenter
    //   49: getstatic a/c/c.h : [Ljava/lang/Object;
    //   52: ifnull -> 69
    //   55: getstatic a/c/c.h : [Ljava/lang/Object;
    //   58: astore_2
    //   59: new java/lang/VerifyError
    //   62: dup
    //   63: ldc 'bad dex opcode'
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: athrow
    //   69: ldc a/c/c
    //   71: monitorexit
    //   72: goto -> 81
    //   75: astore_2
    //   76: ldc a/c/c
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
  
  public boolean add(E paramE) {
    if (paramE == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    throw new VerifyError("bad dex opcode");
  }
  
  public E b(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public void clear() {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean contains(Object paramObject) {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    Iterator<?> iterator = paramCollection.iterator();
    if (iterator.hasNext()) {
      iterator.next();
      throw new VerifyError("bad dex opcode");
    } 
    return true;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof Set) {
      paramObject = paramObject;
      throw new VerifyError("bad dex opcode");
    } 
    return false;
  }
  
  public int hashCode() {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean isEmpty() {
    throw new VerifyError("bad dex opcode");
  }
  
  public Iterator<E> iterator() {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean remove(Object paramObject) {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    Iterator<?> iterator = paramCollection.iterator();
    if (iterator.hasNext()) {
      iterator.next();
      throw new VerifyError("bad dex opcode");
    } 
    return false;
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    throw new VerifyError("bad dex opcode");
  }
  
  public int size() {
    throw new VerifyError("bad dex opcode");
  }
  
  public Object[] toArray() {
    throw new VerifyError("bad dex opcode");
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    int i = paramArrayOfT.length;
    throw new VerifyError("bad dex opcode");
  }
  
  public String toString() {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */