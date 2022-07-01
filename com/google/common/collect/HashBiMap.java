package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
  transient K[] a;
  
  transient V[] b;
  
  transient int c;
  
  transient int d;
  
  private transient int[] e;
  
  private transient int[] f;
  
  private transient int[] g;
  
  private transient int[] h;
  
  @NullableDecl
  private transient int i;
  
  @NullableDecl
  private transient int j;
  
  private transient int[] k;
  
  private transient int[] l;
  
  private transient Set<K> m;
  
  private transient Set<V> n;
  
  private transient Set<Map.Entry<K, V>> o;
  
  @LazyInit
  @NullableDecl
  private transient BiMap<V, K> p;
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    f(paramInt1, paramInt2);
    g(paramInt1, paramInt3);
    c(this.k[paramInt1], this.l[paramInt1]);
    h(this.c - 1, paramInt1);
    K[] arrayOfK = this.a;
    paramInt1 = this.c;
    arrayOfK[paramInt1 - 1] = null;
    this.b[paramInt1 - 1] = null;
    this.c = paramInt1 - 1;
    this.d++;
  }
  
  private void a(int paramInt, @NullableDecl V paramV, boolean paramBoolean) {
    boolean bool;
    if (paramInt != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    int k = Hashing.a(paramV);
    int j = b(paramV, k);
    int i = paramInt;
    if (j != -1)
      if (paramBoolean) {
        b(j, k);
        i = paramInt;
        if (paramInt == this.c)
          i = j; 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value already present in map: ");
        stringBuilder.append(paramV);
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    g(i, Hashing.a(this.b[i]));
    this.b[i] = paramV;
    e(i, k);
  }
  
  private static int[] a(int[] paramArrayOfint, int paramInt) {
    int i = paramArrayOfint.length;
    paramArrayOfint = Arrays.copyOf(paramArrayOfint, paramInt);
    Arrays.fill(paramArrayOfint, i, paramInt, -1);
    return paramArrayOfint;
  }
  
  private void b(int paramInt, @NullableDecl K paramK, boolean paramBoolean) {
    int m;
    boolean bool;
    if (paramInt != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    int j = Hashing.a(paramK);
    int i = a(paramK, j);
    int k = this.j;
    if (i != -1) {
      if (paramBoolean) {
        int n = this.k[i];
        int i1 = this.l[i];
        a(i, j);
        j = i1;
        m = paramInt;
        k = n;
        if (paramInt == this.c) {
          m = i;
          j = i1;
          k = n;
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key already present in map: ");
        stringBuilder.append(paramK);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
    } else {
      j = -2;
      m = paramInt;
    } 
    if (k == m) {
      paramInt = this.k[m];
    } else {
      paramInt = k;
      if (k == this.c)
        paramInt = i; 
    } 
    if (j == m) {
      i = this.l[m];
    } else if (j != this.c) {
      i = j;
    } 
    c(this.k[m], this.l[m]);
    f(m, Hashing.a(this.a[m]));
    this.a[m] = paramK;
    d(m, Hashing.a(paramK));
    c(paramInt, m);
    c(m, i);
  }
  
  private static int[] b(int paramInt) {
    int[] arrayOfInt = new int[paramInt];
    Arrays.fill(arrayOfInt, -1);
    return arrayOfInt;
  }
  
  private void c(int paramInt) {
    int[] arrayOfInt = this.g;
    if (arrayOfInt.length < paramInt) {
      int i = ImmutableCollection.Builder.a(arrayOfInt.length, paramInt);
      this.a = Arrays.copyOf(this.a, i);
      this.b = Arrays.copyOf(this.b, i);
      this.g = a(this.g, i);
      this.h = a(this.h, i);
      this.k = a(this.k, i);
      this.l = a(this.l, i);
    } 
    if (this.e.length < paramInt) {
      paramInt = Hashing.a(paramInt, 1.0D);
      this.e = b(paramInt);
      this.f = b(paramInt);
      for (paramInt = 0; paramInt < this.c; paramInt++) {
        int i = d(Hashing.a(this.a[paramInt]));
        arrayOfInt = this.g;
        int[] arrayOfInt1 = this.e;
        arrayOfInt[paramInt] = arrayOfInt1[i];
        arrayOfInt1[i] = paramInt;
        i = d(Hashing.a(this.b[paramInt]));
        arrayOfInt = this.h;
        arrayOfInt1 = this.f;
        arrayOfInt[paramInt] = arrayOfInt1[i];
        arrayOfInt1[i] = paramInt;
      } 
    } 
  }
  
  private void c(int paramInt1, int paramInt2) {
    if (paramInt1 == -2) {
      this.i = paramInt2;
    } else {
      this.l[paramInt1] = paramInt2;
    } 
    if (paramInt2 == -2) {
      this.j = paramInt1;
      return;
    } 
    this.k[paramInt2] = paramInt1;
  }
  
  private int d(int paramInt) {
    return paramInt & this.e.length - 1;
  }
  
  private void d(int paramInt1, int paramInt2) {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    paramInt2 = d(paramInt2);
    int[] arrayOfInt1 = this.g;
    int[] arrayOfInt2 = this.e;
    arrayOfInt1[paramInt1] = arrayOfInt2[paramInt2];
    arrayOfInt2[paramInt2] = paramInt1;
  }
  
  private void e(int paramInt1, int paramInt2) {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    paramInt2 = d(paramInt2);
    int[] arrayOfInt1 = this.h;
    int[] arrayOfInt2 = this.f;
    arrayOfInt1[paramInt1] = arrayOfInt2[paramInt2];
    arrayOfInt2[paramInt2] = paramInt1;
  }
  
  private void f(int paramInt1, int paramInt2) {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    paramInt2 = d(paramInt2);
    int[] arrayOfInt = this.e;
    if (arrayOfInt[paramInt2] == paramInt1) {
      int[] arrayOfInt1 = this.g;
      arrayOfInt[paramInt2] = arrayOfInt1[paramInt1];
      arrayOfInt1[paramInt1] = -1;
      return;
    } 
    int i = arrayOfInt[paramInt2];
    paramInt2 = this.g[i];
    while (true) {
      int j = i;
      i = paramInt2;
      if (i != -1) {
        if (i == paramInt1) {
          arrayOfInt = this.g;
          arrayOfInt[j] = arrayOfInt[paramInt1];
          arrayOfInt[paramInt1] = -1;
          return;
        } 
        paramInt2 = this.g[i];
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected to find entry with key ");
      stringBuilder.append(this.a[paramInt1]);
      throw new AssertionError(stringBuilder.toString());
    } 
  }
  
  private void g(int paramInt1, int paramInt2) {
    boolean bool;
    if (paramInt1 != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    paramInt2 = d(paramInt2);
    int[] arrayOfInt = this.f;
    if (arrayOfInt[paramInt2] == paramInt1) {
      int[] arrayOfInt1 = this.h;
      arrayOfInt[paramInt2] = arrayOfInt1[paramInt1];
      arrayOfInt1[paramInt1] = -1;
      return;
    } 
    int i = arrayOfInt[paramInt2];
    paramInt2 = this.h[i];
    while (true) {
      int j = i;
      i = paramInt2;
      if (i != -1) {
        if (i == paramInt1) {
          arrayOfInt = this.h;
          arrayOfInt[j] = arrayOfInt[paramInt1];
          arrayOfInt[paramInt1] = -1;
          return;
        } 
        paramInt2 = this.h[i];
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected to find entry with value ");
      stringBuilder.append(this.b[paramInt1]);
      throw new AssertionError(stringBuilder.toString());
    } 
  }
  
  private void h(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: iload_2
    //   2: if_icmpne -> 6
    //   5: return
    //   6: aload_0
    //   7: getfield k : [I
    //   10: iload_1
    //   11: iaload
    //   12: istore_3
    //   13: aload_0
    //   14: getfield l : [I
    //   17: iload_1
    //   18: iaload
    //   19: istore #4
    //   21: aload_0
    //   22: iload_3
    //   23: iload_2
    //   24: invokespecial c : (II)V
    //   27: aload_0
    //   28: iload_2
    //   29: iload #4
    //   31: invokespecial c : (II)V
    //   34: aload_0
    //   35: getfield a : [Ljava/lang/Object;
    //   38: astore #7
    //   40: aload #7
    //   42: iload_1
    //   43: aaload
    //   44: astore #8
    //   46: aload_0
    //   47: getfield b : [Ljava/lang/Object;
    //   50: astore #9
    //   52: aload #9
    //   54: iload_1
    //   55: aaload
    //   56: astore #6
    //   58: aload #7
    //   60: iload_2
    //   61: aload #8
    //   63: aastore
    //   64: aload #9
    //   66: iload_2
    //   67: aload #6
    //   69: aastore
    //   70: aload_0
    //   71: aload #8
    //   73: invokestatic a : (Ljava/lang/Object;)I
    //   76: invokespecial d : (I)I
    //   79: istore_3
    //   80: aload_0
    //   81: getfield e : [I
    //   84: astore #7
    //   86: aload #7
    //   88: iload_3
    //   89: iaload
    //   90: iload_1
    //   91: if_icmpne -> 102
    //   94: aload #7
    //   96: iload_3
    //   97: iload_2
    //   98: iastore
    //   99: goto -> 129
    //   102: aload #7
    //   104: iload_3
    //   105: iaload
    //   106: istore #4
    //   108: aload_0
    //   109: getfield g : [I
    //   112: iload #4
    //   114: iaload
    //   115: istore_3
    //   116: iload_3
    //   117: iload_1
    //   118: if_icmpne -> 244
    //   121: aload_0
    //   122: getfield g : [I
    //   125: iload #4
    //   127: iload_2
    //   128: iastore
    //   129: aload_0
    //   130: getfield g : [I
    //   133: astore #7
    //   135: aload #7
    //   137: iload_2
    //   138: aload #7
    //   140: iload_1
    //   141: iaload
    //   142: iastore
    //   143: aload #7
    //   145: iload_1
    //   146: iconst_m1
    //   147: iastore
    //   148: aload_0
    //   149: aload #6
    //   151: invokestatic a : (Ljava/lang/Object;)I
    //   154: invokespecial d : (I)I
    //   157: istore_3
    //   158: aload_0
    //   159: getfield f : [I
    //   162: astore #6
    //   164: aload #6
    //   166: iload_3
    //   167: iaload
    //   168: iload_1
    //   169: if_icmpne -> 180
    //   172: aload #6
    //   174: iload_3
    //   175: iload_2
    //   176: iastore
    //   177: goto -> 207
    //   180: aload #6
    //   182: iload_3
    //   183: iaload
    //   184: istore #4
    //   186: aload_0
    //   187: getfield h : [I
    //   190: iload #4
    //   192: iaload
    //   193: istore_3
    //   194: iload_3
    //   195: iload_1
    //   196: if_icmpne -> 227
    //   199: aload_0
    //   200: getfield h : [I
    //   203: iload #4
    //   205: iload_2
    //   206: iastore
    //   207: aload_0
    //   208: getfield h : [I
    //   211: astore #6
    //   213: aload #6
    //   215: iload_2
    //   216: aload #6
    //   218: iload_1
    //   219: iaload
    //   220: iastore
    //   221: aload #6
    //   223: iload_1
    //   224: iconst_m1
    //   225: iastore
    //   226: return
    //   227: aload_0
    //   228: getfield h : [I
    //   231: iload_3
    //   232: iaload
    //   233: istore #5
    //   235: iload_3
    //   236: istore #4
    //   238: iload #5
    //   240: istore_3
    //   241: goto -> 194
    //   244: aload_0
    //   245: getfield g : [I
    //   248: iload_3
    //   249: iaload
    //   250: istore #5
    //   252: iload_3
    //   253: istore #4
    //   255: iload #5
    //   257: istore_3
    //   258: goto -> 116
  }
  
  int a(@NullableDecl Object paramObject) {
    return a(paramObject, Hashing.a(paramObject));
  }
  
  int a(@NullableDecl Object paramObject, int paramInt) {
    return a(paramObject, paramInt, this.e, this.g, (Object[])this.a);
  }
  
  int a(@NullableDecl Object paramObject, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, Object[] paramArrayOfObject) {
    for (paramInt = paramArrayOfint1[d(paramInt)]; paramInt != -1; paramInt = paramArrayOfint2[paramInt]) {
      if (Objects.a(paramArrayOfObject[paramInt], paramObject))
        return paramInt; 
    } 
    return -1;
  }
  
  @NullableDecl
  V a(@NullableDecl K paramK, @NullableDecl V paramV, boolean paramBoolean) {
    V v;
    int i = Hashing.a(paramK);
    int j = a(paramK, i);
    if (j != -1) {
      v = this.b[j];
      if (Objects.a(v, paramV))
        return paramV; 
      a(j, paramV, paramBoolean);
      return v;
    } 
    j = Hashing.a(paramV);
    int k = b(paramV, j);
    if (paramBoolean) {
      if (k != -1)
        b(k, j); 
    } else {
      if (k == -1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      Preconditions.a(paramBoolean, "Value already present: %s", paramV);
    } 
    c(this.c + 1);
    K[] arrayOfK = this.a;
    k = this.c;
    arrayOfK[k] = (K)v;
    this.b[k] = paramV;
    d(k, i);
    e(this.c, j);
    c(this.j, this.c);
    c(this.c, -2);
    this.c++;
    this.d++;
    return null;
  }
  
  void a(int paramInt) {
    a(paramInt, Hashing.a(this.a[paramInt]));
  }
  
  void a(int paramInt1, int paramInt2) {
    a(paramInt1, paramInt2, Hashing.a(this.b[paramInt1]));
  }
  
  public BiMap<V, K> ay_() {
    BiMap<V, K> biMap2 = this.p;
    BiMap<V, K> biMap1 = biMap2;
    if (biMap2 == null) {
      biMap1 = new Inverse<K, V>(this);
      this.p = biMap1;
    } 
    return biMap1;
  }
  
  int b(@NullableDecl Object paramObject) {
    return b(paramObject, Hashing.a(paramObject));
  }
  
  int b(@NullableDecl Object paramObject, int paramInt) {
    return a(paramObject, paramInt, this.f, this.h, (Object[])this.b);
  }
  
  @NullableDecl
  K b(@NullableDecl V paramV, @NullableDecl K paramK, boolean paramBoolean) {
    K k;
    int j = Hashing.a(paramV);
    int i = b(paramV, j);
    if (i != -1) {
      k = this.a[i];
      if (Objects.a(k, paramK))
        return paramK; 
      b(i, paramK, paramBoolean);
      return k;
    } 
    i = this.j;
    int m = Hashing.a(paramK);
    int n = a(paramK, m);
    if (paramBoolean) {
      if (n != -1) {
        i = this.k[n];
        a(n, m);
      } 
    } else {
      if (n == -1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      Preconditions.a(paramBoolean, "Key already present: %s", paramK);
    } 
    c(this.c + 1);
    K[] arrayOfK = this.a;
    n = this.c;
    arrayOfK[n] = paramK;
    this.b[n] = (V)k;
    d(n, m);
    e(this.c, j);
    if (i == -2) {
      j = this.i;
    } else {
      j = this.l[i];
    } 
    c(i, this.c);
    c(this.c, j);
    this.c++;
    this.d++;
    return null;
  }
  
  void b(int paramInt1, int paramInt2) {
    a(paramInt1, Hashing.a(this.a[paramInt1]), paramInt2);
  }
  
  @NullableDecl
  K c(@NullableDecl Object paramObject) {
    int i = b(paramObject);
    return (i == -1) ? null : this.a[i];
  }
  
  public void clear() {
    Arrays.fill((Object[])this.a, 0, this.c, (Object)null);
    Arrays.fill((Object[])this.b, 0, this.c, (Object)null);
    Arrays.fill(this.e, -1);
    Arrays.fill(this.f, -1);
    Arrays.fill(this.g, 0, this.c, -1);
    Arrays.fill(this.h, 0, this.c, -1);
    Arrays.fill(this.k, 0, this.c, -1);
    Arrays.fill(this.l, 0, this.c, -1);
    this.c = 0;
    this.i = -2;
    this.j = -2;
    this.d++;
  }
  
  public boolean containsKey(@NullableDecl Object paramObject) {
    return (a(paramObject) != -1);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject) {
    return (b(paramObject) != -1);
  }
  
  @NullableDecl
  K d(@NullableDecl Object paramObject) {
    int i = Hashing.a(paramObject);
    int j = b(paramObject, i);
    if (j == -1)
      return null; 
    paramObject = this.a[j];
    b(j, i);
    return (K)paramObject;
  }
  
  public Set<V> d() {
    Set<V> set2 = this.n;
    Set<V> set1 = set2;
    if (set2 == null) {
      set1 = new ValueSet(this);
      this.n = set1;
    } 
    return set1;
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set2 = this.o;
    Set<Map.Entry<K, V>> set1 = set2;
    if (set2 == null) {
      set1 = new EntrySet(this);
      this.o = set1;
    } 
    return set1;
  }
  
  @NullableDecl
  public V get(@NullableDecl Object paramObject) {
    int i = a(paramObject);
    return (i == -1) ? null : this.b[i];
  }
  
  public Set<K> keySet() {
    Set<K> set2 = this.m;
    Set<K> set1 = set2;
    if (set2 == null) {
      set1 = new KeySet(this);
      this.m = set1;
    } 
    return set1;
  }
  
  public V put(@NullableDecl K paramK, @NullableDecl V paramV) {
    return a(paramK, paramV, false);
  }
  
  @NullableDecl
  public V remove(@NullableDecl Object paramObject) {
    int i = Hashing.a(paramObject);
    int j = a(paramObject, i);
    if (j == -1)
      return null; 
    paramObject = this.b[j];
    a(j, i);
    return (V)paramObject;
  }
  
  public int size() {
    return this.c;
  }
  
  final class EntryForKey extends AbstractMapEntry<K, V> {
    @NullableDecl
    final K a;
    
    int b;
    
    EntryForKey(HashBiMap this$0, int param1Int) {
      this.a = this$0.a[param1Int];
      this.b = param1Int;
    }
    
    void a() {
      int i = this.b;
      if (i == -1 || i > this.c.c || !Objects.a(this.c.a[this.b], this.a))
        this.b = this.c.a(this.a); 
    }
    
    public K getKey() {
      return this.a;
    }
    
    @NullableDecl
    public V getValue() {
      a();
      return (this.b == -1) ? null : this.c.b[this.b];
    }
    
    public V setValue(V param1V) {
      a();
      if (this.b == -1)
        return this.c.put(this.a, param1V); 
      V v = this.c.b[this.b];
      if (Objects.a(v, param1V))
        return param1V; 
      HashBiMap.a(this.c, this.b, param1V, false);
      return v;
    }
  }
  
  static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
    final HashBiMap<K, V> a;
    
    final V b;
    
    int c;
    
    EntryForValue(HashBiMap<K, V> param1HashBiMap, int param1Int) {
      this.a = param1HashBiMap;
      this.b = param1HashBiMap.b[param1Int];
      this.c = param1Int;
    }
    
    private void a() {
      int i = this.c;
      if (i == -1 || i > this.a.c || !Objects.a(this.b, this.a.b[this.c]))
        this.c = this.a.b(this.b); 
    }
    
    public V getKey() {
      return this.b;
    }
    
    public K getValue() {
      a();
      return (this.c == -1) ? null : this.a.a[this.c];
    }
    
    public K setValue(K param1K) {
      a();
      if (this.c == -1)
        return this.a.b(this.b, param1K, false); 
      K k = this.a.a[this.c];
      if (Objects.a(k, param1K))
        return param1K; 
      HashBiMap.b(this.a, this.c, param1K, false);
      return k;
    }
  }
  
  final class EntrySet extends View<K, V, Map.Entry<K, V>> {
    EntrySet(HashBiMap<K, V> this$0) {
      super(this$0);
    }
    
    Map.Entry<K, V> a(int param1Int) {
      return new HashBiMap.EntryForKey(this.a, param1Int);
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        Map.Entry entry = (Map.Entry)param1Object;
        param1Object = entry.getKey();
        entry = (Map.Entry)entry.getValue();
        int i = this.a.a(param1Object);
        bool1 = bool2;
        if (i != -1) {
          bool1 = bool2;
          if (Objects.a(entry, this.a.b[i]))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        Map.Entry entry = (Map.Entry)param1Object;
        param1Object = entry.getKey();
        entry = (Map.Entry)entry.getValue();
        int i = Hashing.a(param1Object);
        int j = this.a.a(param1Object, i);
        if (j != -1 && Objects.a(entry, this.a.b[j])) {
          this.a.a(j, i);
          return true;
        } 
      } 
      return false;
    }
  }
  
  static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
    private final HashBiMap<K, V> a;
    
    private transient Set<Map.Entry<V, K>> b;
    
    Inverse(HashBiMap<K, V> param1HashBiMap) {
      this.a = param1HashBiMap;
    }
    
    public BiMap<K, V> ay_() {
      return this.a;
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return this.a.containsValue(param1Object);
    }
    
    public boolean containsValue(@NullableDecl Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    public Set<K> d() {
      return this.a.keySet();
    }
    
    public Set<Map.Entry<V, K>> entrySet() {
      Set<Map.Entry<V, K>> set2 = this.b;
      Set<Map.Entry<V, K>> set1 = set2;
      if (set2 == null) {
        set1 = new HashBiMap.InverseEntrySet<K, V>(this.a);
        this.b = set1;
      } 
      return set1;
    }
    
    @NullableDecl
    public K get(@NullableDecl Object param1Object) {
      return this.a.c(param1Object);
    }
    
    public Set<V> keySet() {
      return this.a.d();
    }
    
    @NullableDecl
    public K put(@NullableDecl V param1V, @NullableDecl K param1K) {
      return this.a.b(param1V, param1K, false);
    }
    
    @NullableDecl
    public K remove(@NullableDecl Object param1Object) {
      return this.a.d(param1Object);
    }
    
    public int size() {
      return this.a.c;
    }
  }
  
  static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
    InverseEntrySet(HashBiMap<K, V> param1HashBiMap) {
      super(param1HashBiMap);
    }
    
    Map.Entry<V, K> a(int param1Int) {
      return new HashBiMap.EntryForValue<K, V>(this.b, param1Int);
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        Map.Entry entry = (Map.Entry)param1Object;
        param1Object = entry.getKey();
        entry = (Map.Entry)entry.getValue();
        int i = this.b.b(param1Object);
        bool1 = bool2;
        if (i != -1) {
          bool1 = bool2;
          if (Objects.a(this.b.a[i], entry))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public boolean remove(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        Map.Entry entry = (Map.Entry)param1Object;
        param1Object = entry.getKey();
        entry = (Map.Entry)entry.getValue();
        int i = Hashing.a(param1Object);
        int j = this.b.b(param1Object, i);
        if (j != -1 && Objects.a(this.b.a[j], entry)) {
          this.b.b(j, i);
          return true;
        } 
      } 
      return false;
    }
  }
  
  final class KeySet extends View<K, V, K> {
    KeySet(HashBiMap<K, V> this$0) {
      super(this$0);
    }
    
    K b(int param1Int) {
      return this.a.a[param1Int];
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      int i = Hashing.a(param1Object);
      int j = this.a.a(param1Object, i);
      if (j != -1) {
        this.a.a(j, i);
        return true;
      } 
      return false;
    }
  }
  
  final class ValueSet extends View<K, V, V> {
    ValueSet(HashBiMap<K, V> this$0) {
      super(this$0);
    }
    
    V b(int param1Int) {
      return this.a.b[param1Int];
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return this.a.containsValue(param1Object);
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      int i = Hashing.a(param1Object);
      int j = this.a.b(param1Object, i);
      if (j != -1) {
        this.a.b(j, i);
        return true;
      } 
      return false;
    }
  }
  
  static abstract class View<K, V, T> extends AbstractSet<T> {
    final HashBiMap<K, V> b;
    
    View(HashBiMap<K, V> param1HashBiMap) {
      this.b = param1HashBiMap;
    }
    
    abstract T b(int param1Int);
    
    public void clear() {
      this.b.clear();
    }
    
    public Iterator<T> iterator() {
      return new Iterator<T>(this) {
          private int b = HashBiMap.a(this.a.b);
          
          private int c = -1;
          
          private int d = this.a.b.d;
          
          private int e = this.a.b.c;
          
          private void a() {
            if (this.a.b.d == this.d)
              return; 
            throw new ConcurrentModificationException();
          }
          
          public boolean hasNext() {
            a();
            return (this.b != -2 && this.e > 0);
          }
          
          public T next() {
            if (hasNext()) {
              Object object = this.a.b(this.b);
              this.c = this.b;
              this.b = HashBiMap.b(this.a.b)[this.b];
              this.e--;
              return (T)object;
            } 
            throw new NoSuchElementException();
          }
          
          public void remove() {
            boolean bool;
            a();
            if (this.c != -1) {
              bool = true;
            } else {
              bool = false;
            } 
            CollectPreconditions.a(bool);
            this.a.b.a(this.c);
            if (this.b == this.a.b.c)
              this.b = this.c; 
            this.c = -1;
            this.d = this.a.b.d;
          }
        };
    }
    
    public int size() {
      return this.b.c;
    }
  }
  
  class null implements Iterator<T> {
    private int b = HashBiMap.a(this.a.b);
    
    private int c = -1;
    
    private int d = this.a.b.d;
    
    private int e = this.a.b.c;
    
    null(HashBiMap this$0) {}
    
    private void a() {
      if (this.a.b.d == this.d)
        return; 
      throw new ConcurrentModificationException();
    }
    
    public boolean hasNext() {
      a();
      return (this.b != -2 && this.e > 0);
    }
    
    public T next() {
      if (hasNext()) {
        Object object = this.a.b(this.b);
        this.c = this.b;
        this.b = HashBiMap.b(this.a.b)[this.b];
        this.e--;
        return (T)object;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      boolean bool;
      a();
      if (this.c != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      this.a.b.a(this.c);
      if (this.b == this.a.b.c)
        this.b = this.c; 
      this.c = -1;
      this.d = this.a.b.d;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\HashBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */