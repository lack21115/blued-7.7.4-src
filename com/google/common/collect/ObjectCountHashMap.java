package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class ObjectCountHashMap<K> {
  transient Object[] a;
  
  transient int[] b;
  
  transient int c;
  
  transient int d;
  
  transient long[] e;
  
  private transient int[] f;
  
  private transient float g;
  
  private transient int h;
  
  ObjectCountHashMap() {
    a(3, 1.0F);
  }
  
  ObjectCountHashMap(int paramInt) {
    this(paramInt, 1.0F);
  }
  
  ObjectCountHashMap(int paramInt, float paramFloat) {
    a(paramInt, paramFloat);
  }
  
  ObjectCountHashMap(ObjectCountHashMap<? extends K> paramObjectCountHashMap) {
    a(paramObjectCountHashMap.c(), 1.0F);
    for (int i = paramObjectCountHashMap.b(); i != -1; i = paramObjectCountHashMap.b(i))
      a(paramObjectCountHashMap.c(i), paramObjectCountHashMap.d(i)); 
  }
  
  private static int a(long paramLong) {
    return (int)(paramLong >>> 32L);
  }
  
  private static long a(long paramLong, int paramInt) {
    return paramLong & 0xFFFFFFFF00000000L | paramInt & 0xFFFFFFFFL;
  }
  
  public static <K> ObjectCountHashMap<K> a() {
    return new ObjectCountHashMap<K>();
  }
  
  public static <K> ObjectCountHashMap<K> a(int paramInt) {
    return new ObjectCountHashMap<K>(paramInt);
  }
  
  private static int b(long paramLong) {
    return (int)paramLong;
  }
  
  private int b(@NullableDecl Object paramObject, int paramInt) {
    int k = e() & paramInt;
    int i = this.f[k];
    if (i == -1)
      return 0; 
    int j = -1;
    while (true) {
      if (a(this.e[i]) == paramInt && Objects.a(paramObject, this.a[i])) {
        paramInt = this.b[i];
        if (j == -1) {
          this.f[k] = b(this.e[i]);
        } else {
          paramObject = this.e;
          paramObject[j] = a(paramObject[j], b(paramObject[i]));
        } 
        i(i);
        this.c--;
        this.d++;
        return paramInt;
      } 
      int m = b(this.e[i]);
      if (m == -1)
        return 0; 
      j = i;
      i = m;
    } 
  }
  
  private int e() {
    return this.f.length - 1;
  }
  
  private static int[] j(int paramInt) {
    int[] arrayOfInt = new int[paramInt];
    Arrays.fill(arrayOfInt, -1);
    return arrayOfInt;
  }
  
  private static long[] k(int paramInt) {
    long[] arrayOfLong = new long[paramInt];
    Arrays.fill(arrayOfLong, -1L);
    return arrayOfLong;
  }
  
  private void l(int paramInt) {
    int i = this.e.length;
    if (paramInt > i) {
      int j = Math.max(1, i >>> 1) + i;
      paramInt = j;
      if (j < 0)
        paramInt = Integer.MAX_VALUE; 
      if (paramInt != i)
        g(paramInt); 
    } 
  }
  
  private void m(int paramInt) {
    if (this.f.length >= 1073741824) {
      this.h = Integer.MAX_VALUE;
      return;
    } 
    int i = (int)(paramInt * this.g);
    int[] arrayOfInt = j(paramInt);
    long[] arrayOfLong = this.e;
    int j = arrayOfInt.length;
    for (paramInt = 0; paramInt < this.c; paramInt++) {
      int k = a(arrayOfLong[paramInt]);
      int m = k & j - 1;
      int n = arrayOfInt[m];
      arrayOfInt[m] = paramInt;
      arrayOfLong[paramInt] = k << 32L | n & 0xFFFFFFFFL;
    } 
    this.h = i + 1;
    this.f = arrayOfInt;
  }
  
  int a(int paramInt1, int paramInt2) {
    return paramInt1 - 1;
  }
  
  int a(@NullableDecl Object paramObject) {
    int j = Hashing.a(paramObject);
    for (int i = this.f[e() & j]; i != -1; i = b(l)) {
      long l = this.e[i];
      if (a(l) == j && Objects.a(paramObject, this.a[i]))
        return i; 
    } 
    return -1;
  }
  
  public int a(@NullableDecl K paramK, int paramInt) {
    // Byte code:
    //   0: iload_2
    //   1: ldc 'count'
    //   3: invokestatic b : (ILjava/lang/String;)V
    //   6: aload_0
    //   7: getfield e : [J
    //   10: astore #10
    //   12: aload_0
    //   13: getfield a : [Ljava/lang/Object;
    //   16: astore #11
    //   18: aload_0
    //   19: getfield b : [I
    //   22: astore #12
    //   24: aload_1
    //   25: invokestatic a : (Ljava/lang/Object;)I
    //   28: istore #5
    //   30: aload_0
    //   31: invokespecial e : ()I
    //   34: iload #5
    //   36: iand
    //   37: istore #7
    //   39: aload_0
    //   40: getfield c : I
    //   43: istore #6
    //   45: aload_0
    //   46: getfield f : [I
    //   49: astore #13
    //   51: aload #13
    //   53: iload #7
    //   55: iaload
    //   56: istore #4
    //   58: iload #4
    //   60: istore_3
    //   61: iload #4
    //   63: iconst_m1
    //   64: if_icmpne -> 77
    //   67: aload #13
    //   69: iload #7
    //   71: iload #6
    //   73: iastore
    //   74: goto -> 142
    //   77: aload #10
    //   79: iload_3
    //   80: laload
    //   81: lstore #8
    //   83: lload #8
    //   85: invokestatic a : (J)I
    //   88: iload #5
    //   90: if_icmpne -> 118
    //   93: aload_1
    //   94: aload #11
    //   96: iload_3
    //   97: aaload
    //   98: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   101: ifeq -> 118
    //   104: aload #12
    //   106: iload_3
    //   107: iaload
    //   108: istore #4
    //   110: aload #12
    //   112: iload_3
    //   113: iload_2
    //   114: iastore
    //   115: iload #4
    //   117: ireturn
    //   118: lload #8
    //   120: invokestatic b : (J)I
    //   123: istore #4
    //   125: iload #4
    //   127: iconst_m1
    //   128: if_icmpne -> 216
    //   131: aload #10
    //   133: iload_3
    //   134: lload #8
    //   136: iload #6
    //   138: invokestatic a : (JI)J
    //   141: lastore
    //   142: iload #6
    //   144: ldc 2147483647
    //   146: if_icmpeq -> 206
    //   149: iload #6
    //   151: iconst_1
    //   152: iadd
    //   153: istore_3
    //   154: aload_0
    //   155: iload_3
    //   156: invokespecial l : (I)V
    //   159: aload_0
    //   160: iload #6
    //   162: aload_1
    //   163: iload_2
    //   164: iload #5
    //   166: invokevirtual a : (ILjava/lang/Object;II)V
    //   169: aload_0
    //   170: iload_3
    //   171: putfield c : I
    //   174: iload #6
    //   176: aload_0
    //   177: getfield h : I
    //   180: if_icmplt -> 194
    //   183: aload_0
    //   184: aload_0
    //   185: getfield f : [I
    //   188: arraylength
    //   189: iconst_2
    //   190: imul
    //   191: invokespecial m : (I)V
    //   194: aload_0
    //   195: aload_0
    //   196: getfield d : I
    //   199: iconst_1
    //   200: iadd
    //   201: putfield d : I
    //   204: iconst_0
    //   205: ireturn
    //   206: new java/lang/IllegalStateException
    //   209: dup
    //   210: ldc 'Cannot contain more than Integer.MAX_VALUE elements!'
    //   212: invokespecial <init> : (Ljava/lang/String;)V
    //   215: athrow
    //   216: iload #4
    //   218: istore_3
    //   219: goto -> 77
  }
  
  void a(int paramInt, float paramFloat) {
    boolean bool2 = false;
    if (paramInt >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1, "Initial capacity must be non-negative");
    boolean bool1 = bool2;
    if (paramFloat > 0.0F)
      bool1 = true; 
    Preconditions.a(bool1, "Illegal load factor");
    int i = Hashing.a(paramInt, paramFloat);
    this.f = j(i);
    this.g = paramFloat;
    this.a = new Object[paramInt];
    this.b = new int[paramInt];
    this.e = k(paramInt);
    this.h = Math.max(1, (int)(i * paramFloat));
  }
  
  void a(int paramInt1, @NullableDecl K paramK, int paramInt2, int paramInt3) {
    this.e[paramInt1] = paramInt3 << 32L | 0xFFFFFFFFL;
    this.a[paramInt1] = paramK;
    this.b[paramInt1] = paramInt2;
  }
  
  int b() {
    return (this.c == 0) ? -1 : 0;
  }
  
  int b(int paramInt) {
    return (++paramInt < this.c) ? paramInt : -1;
  }
  
  public int b(@NullableDecl Object paramObject) {
    int i = a(paramObject);
    return (i == -1) ? 0 : this.b[i];
  }
  
  void b(int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, this.c);
    this.b[paramInt1] = paramInt2;
  }
  
  int c() {
    return this.c;
  }
  
  public int c(@NullableDecl Object paramObject) {
    return b(paramObject, Hashing.a(paramObject));
  }
  
  K c(int paramInt) {
    Preconditions.a(paramInt, this.c);
    return (K)this.a[paramInt];
  }
  
  int d(int paramInt) {
    Preconditions.a(paramInt, this.c);
    return this.b[paramInt];
  }
  
  public void d() {
    this.d++;
    Arrays.fill(this.a, 0, this.c, (Object)null);
    Arrays.fill(this.b, 0, this.c, 0);
    Arrays.fill(this.f, -1);
    Arrays.fill(this.e, -1L);
    this.c = 0;
  }
  
  Multiset.Entry<K> e(int paramInt) {
    Preconditions.a(paramInt, this.c);
    return new MapEntry(this, paramInt);
  }
  
  void f(int paramInt) {
    if (paramInt > this.e.length)
      g(paramInt); 
    if (paramInt >= this.h)
      m(Math.max(2, Integer.highestOneBit(paramInt - 1) << 1)); 
  }
  
  void g(int paramInt) {
    this.a = Arrays.copyOf(this.a, paramInt);
    this.b = Arrays.copyOf(this.b, paramInt);
    long[] arrayOfLong = this.e;
    int i = arrayOfLong.length;
    arrayOfLong = Arrays.copyOf(arrayOfLong, paramInt);
    if (paramInt > i)
      Arrays.fill(arrayOfLong, i, paramInt, -1L); 
    this.e = arrayOfLong;
  }
  
  int h(int paramInt) {
    return b(this.a[paramInt], a(this.e[paramInt]));
  }
  
  void i(int paramInt) {
    int i = c() - 1;
    if (paramInt < i) {
      Object[] arrayOfObject = this.a;
      arrayOfObject[paramInt] = arrayOfObject[i];
      int[] arrayOfInt2 = this.b;
      arrayOfInt2[paramInt] = arrayOfInt2[i];
      arrayOfObject[i] = null;
      arrayOfInt2[i] = 0;
      long[] arrayOfLong = this.e;
      long l = arrayOfLong[i];
      arrayOfLong[paramInt] = l;
      arrayOfLong[i] = -1L;
      int m = a(l) & e();
      int[] arrayOfInt1 = this.f;
      int k = arrayOfInt1[m];
      int j = k;
      if (k == i) {
        arrayOfInt1[m] = paramInt;
        return;
      } 
      while (true) {
        l = this.e[j];
        k = b(l);
        if (k == i) {
          this.e[j] = a(l, paramInt);
          return;
        } 
        j = k;
      } 
    } 
    this.a[paramInt] = null;
    this.b[paramInt] = 0;
    this.e[paramInt] = -1L;
  }
  
  class MapEntry extends Multisets.AbstractEntry<K> {
    @NullableDecl
    final K a;
    
    int b;
    
    MapEntry(ObjectCountHashMap this$0, int param1Int) {
      this.a = (K)this$0.a[param1Int];
      this.b = param1Int;
    }
    
    void a() {
      int i = this.b;
      if (i == -1 || i >= this.c.c() || !Objects.a(this.a, this.c.a[this.b]))
        this.b = this.c.a(this.a); 
    }
    
    public int b() {
      a();
      return (this.b == -1) ? 0 : this.c.b[this.b];
    }
    
    public K c() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ObjectCountHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */