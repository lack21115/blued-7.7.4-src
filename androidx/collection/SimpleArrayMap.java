package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
  static Object[] b;
  
  static int c;
  
  static Object[] d;
  
  static int e;
  
  int[] f;
  
  Object[] g;
  
  int h;
  
  public SimpleArrayMap() {
    this.f = ContainerHelpers.a;
    this.g = ContainerHelpers.c;
    this.h = 0;
  }
  
  public SimpleArrayMap(int paramInt) {
    if (paramInt == 0) {
      this.f = ContainerHelpers.a;
      this.g = ContainerHelpers.c;
    } else {
      a(paramInt);
    } 
    this.h = 0;
  }
  
  public SimpleArrayMap(SimpleArrayMap<K, V> paramSimpleArrayMap) {
    this();
    if (paramSimpleArrayMap != null)
      putAll(paramSimpleArrayMap); 
  }
  
  private static int a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    try {
      return ContainerHelpers.a(paramArrayOfint, paramInt1, paramInt2);
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      throw new ConcurrentModificationException();
    } 
  }
  
  private void a(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 81
    //   6: ldc androidx/collection/SimpleArrayMap
    //   8: monitorenter
    //   9: getstatic androidx/collection/SimpleArrayMap.d : [Ljava/lang/Object;
    //   12: ifnull -> 69
    //   15: getstatic androidx/collection/SimpleArrayMap.d : [Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield g : [Ljava/lang/Object;
    //   24: aload_2
    //   25: iconst_0
    //   26: aaload
    //   27: checkcast [Ljava/lang/Object;
    //   30: checkcast [Ljava/lang/Object;
    //   33: putstatic androidx/collection/SimpleArrayMap.d : [Ljava/lang/Object;
    //   36: aload_0
    //   37: aload_2
    //   38: iconst_1
    //   39: aaload
    //   40: checkcast [I
    //   43: checkcast [I
    //   46: putfield f : [I
    //   49: aload_2
    //   50: iconst_1
    //   51: aconst_null
    //   52: aastore
    //   53: aload_2
    //   54: iconst_0
    //   55: aconst_null
    //   56: aastore
    //   57: getstatic androidx/collection/SimpleArrayMap.e : I
    //   60: iconst_1
    //   61: isub
    //   62: putstatic androidx/collection/SimpleArrayMap.e : I
    //   65: ldc androidx/collection/SimpleArrayMap
    //   67: monitorexit
    //   68: return
    //   69: ldc androidx/collection/SimpleArrayMap
    //   71: monitorexit
    //   72: goto -> 161
    //   75: astore_2
    //   76: ldc androidx/collection/SimpleArrayMap
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: iload_1
    //   82: iconst_4
    //   83: if_icmpne -> 161
    //   86: ldc androidx/collection/SimpleArrayMap
    //   88: monitorenter
    //   89: getstatic androidx/collection/SimpleArrayMap.b : [Ljava/lang/Object;
    //   92: ifnull -> 149
    //   95: getstatic androidx/collection/SimpleArrayMap.b : [Ljava/lang/Object;
    //   98: astore_2
    //   99: aload_0
    //   100: aload_2
    //   101: putfield g : [Ljava/lang/Object;
    //   104: aload_2
    //   105: iconst_0
    //   106: aaload
    //   107: checkcast [Ljava/lang/Object;
    //   110: checkcast [Ljava/lang/Object;
    //   113: putstatic androidx/collection/SimpleArrayMap.b : [Ljava/lang/Object;
    //   116: aload_0
    //   117: aload_2
    //   118: iconst_1
    //   119: aaload
    //   120: checkcast [I
    //   123: checkcast [I
    //   126: putfield f : [I
    //   129: aload_2
    //   130: iconst_1
    //   131: aconst_null
    //   132: aastore
    //   133: aload_2
    //   134: iconst_0
    //   135: aconst_null
    //   136: aastore
    //   137: getstatic androidx/collection/SimpleArrayMap.c : I
    //   140: iconst_1
    //   141: isub
    //   142: putstatic androidx/collection/SimpleArrayMap.c : I
    //   145: ldc androidx/collection/SimpleArrayMap
    //   147: monitorexit
    //   148: return
    //   149: ldc androidx/collection/SimpleArrayMap
    //   151: monitorexit
    //   152: goto -> 161
    //   155: astore_2
    //   156: ldc androidx/collection/SimpleArrayMap
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: aload_0
    //   162: iload_1
    //   163: newarray int
    //   165: putfield f : [I
    //   168: aload_0
    //   169: iload_1
    //   170: iconst_1
    //   171: ishl
    //   172: anewarray java/lang/Object
    //   175: putfield g : [Ljava/lang/Object;
    //   178: return
    // Exception table:
    //   from	to	target	type
    //   9	49	75	finally
    //   57	68	75	finally
    //   69	72	75	finally
    //   76	79	75	finally
    //   89	129	155	finally
    //   137	148	155	finally
    //   149	152	155	finally
    //   156	159	155	finally
  }
  
  private static void a(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 59
    //   7: ldc androidx/collection/SimpleArrayMap
    //   9: monitorenter
    //   10: getstatic androidx/collection/SimpleArrayMap.e : I
    //   13: bipush #10
    //   15: if_icmpge -> 49
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic androidx/collection/SimpleArrayMap.d : [Ljava/lang/Object;
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
    //   34: goto -> 118
    //   37: aload_1
    //   38: putstatic androidx/collection/SimpleArrayMap.d : [Ljava/lang/Object;
    //   41: getstatic androidx/collection/SimpleArrayMap.e : I
    //   44: iconst_1
    //   45: iadd
    //   46: putstatic androidx/collection/SimpleArrayMap.e : I
    //   49: ldc androidx/collection/SimpleArrayMap
    //   51: monitorexit
    //   52: return
    //   53: astore_0
    //   54: ldc androidx/collection/SimpleArrayMap
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    //   59: aload_0
    //   60: arraylength
    //   61: iconst_4
    //   62: if_icmpne -> 117
    //   65: ldc androidx/collection/SimpleArrayMap
    //   67: monitorenter
    //   68: getstatic androidx/collection/SimpleArrayMap.c : I
    //   71: bipush #10
    //   73: if_icmpge -> 107
    //   76: aload_1
    //   77: iconst_0
    //   78: getstatic androidx/collection/SimpleArrayMap.b : [Ljava/lang/Object;
    //   81: aastore
    //   82: aload_1
    //   83: iconst_1
    //   84: aload_0
    //   85: aastore
    //   86: iload_2
    //   87: iconst_1
    //   88: ishl
    //   89: iconst_1
    //   90: isub
    //   91: istore_2
    //   92: goto -> 134
    //   95: aload_1
    //   96: putstatic androidx/collection/SimpleArrayMap.b : [Ljava/lang/Object;
    //   99: getstatic androidx/collection/SimpleArrayMap.c : I
    //   102: iconst_1
    //   103: iadd
    //   104: putstatic androidx/collection/SimpleArrayMap.c : I
    //   107: ldc androidx/collection/SimpleArrayMap
    //   109: monitorexit
    //   110: return
    //   111: astore_0
    //   112: ldc androidx/collection/SimpleArrayMap
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    //   117: return
    //   118: iload_2
    //   119: iconst_2
    //   120: if_icmplt -> 37
    //   123: aload_1
    //   124: iload_2
    //   125: aconst_null
    //   126: aastore
    //   127: iload_2
    //   128: iconst_1
    //   129: isub
    //   130: istore_2
    //   131: goto -> 118
    //   134: iload_2
    //   135: iconst_2
    //   136: if_icmplt -> 95
    //   139: aload_1
    //   140: iload_2
    //   141: aconst_null
    //   142: aastore
    //   143: iload_2
    //   144: iconst_1
    //   145: isub
    //   146: istore_2
    //   147: goto -> 134
    // Exception table:
    //   from	to	target	type
    //   10	24	53	finally
    //   37	49	53	finally
    //   49	52	53	finally
    //   54	57	53	finally
    //   68	82	111	finally
    //   95	107	111	finally
    //   107	110	111	finally
    //   112	115	111	finally
  }
  
  int a() {
    int j = this.h;
    if (j == 0)
      return -1; 
    int k = a(this.f, j, 0);
    if (k < 0)
      return k; 
    if (this.g[k << 1] == null)
      return k; 
    int i;
    for (i = k + 1; i < j && this.f[i] == 0; i++) {
      if (this.g[i << 1] == null)
        return i; 
    } 
    for (j = k - 1; j >= 0 && this.f[j] == 0; j--) {
      if (this.g[j << 1] == null)
        return j; 
    } 
    return i;
  }
  
  int a(Object paramObject) {
    int i = this.h * 2;
    Object[] arrayOfObject = this.g;
    if (paramObject == null) {
      for (int j = 1; j < i; j += 2) {
        if (arrayOfObject[j] == null)
          return j >> 1; 
      } 
    } else {
      for (int j = 1; j < i; j += 2) {
        if (paramObject.equals(arrayOfObject[j]))
          return j >> 1; 
      } 
    } 
    return -1;
  }
  
  int a(Object paramObject, int paramInt) {
    int j = this.h;
    if (j == 0)
      return -1; 
    int k = a(this.f, j, paramInt);
    if (k < 0)
      return k; 
    if (paramObject.equals(this.g[k << 1]))
      return k; 
    int i;
    for (i = k + 1; i < j && this.f[i] == paramInt; i++) {
      if (paramObject.equals(this.g[i << 1]))
        return i; 
    } 
    for (j = k - 1; j >= 0 && this.f[j] == paramInt; j--) {
      if (paramObject.equals(this.g[j << 1]))
        return j; 
    } 
    return i;
  }
  
  public void clear() {
    int i = this.h;
    if (i > 0) {
      int[] arrayOfInt = this.f;
      Object[] arrayOfObject = this.g;
      this.f = ContainerHelpers.a;
      this.g = ContainerHelpers.c;
      this.h = 0;
      a(arrayOfInt, arrayOfObject, i);
    } 
    if (this.h <= 0)
      return; 
    throw new ConcurrentModificationException();
  }
  
  public boolean containsKey(Object paramObject) {
    return (indexOfKey(paramObject) >= 0);
  }
  
  public boolean containsValue(Object paramObject) {
    return (a(paramObject) >= 0);
  }
  
  public void ensureCapacity(int paramInt) {
    int i = this.h;
    int[] arrayOfInt = this.f;
    if (arrayOfInt.length < paramInt) {
      Object[] arrayOfObject = this.g;
      a(paramInt);
      if (this.h > 0) {
        System.arraycopy(arrayOfInt, 0, this.f, 0, i);
        System.arraycopy(arrayOfObject, 0, this.g, 0, i << 1);
      } 
      a(arrayOfInt, arrayOfObject, i);
    } 
    if (this.h == i)
      return; 
    throw new ConcurrentModificationException();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof SimpleArrayMap) {
      paramObject = paramObject;
      if (size() != paramObject.size())
        return false; 
      int i = 0;
      try {
        while (i < this.h) {
          K k = keyAt(i);
          V v = valueAt(i);
          Object object = paramObject.get(k);
          if (v == null) {
            if (object == null) {
              if (!paramObject.containsKey(k))
                return false; 
            } else {
              return false;
            } 
          } else {
            boolean bool = v.equals(object);
            if (!bool)
              return false; 
          } 
          i++;
        } 
        return true;
      } catch (NullPointerException|ClassCastException nullPointerException) {
        return false;
      } 
    } 
    if (nullPointerException instanceof Map) {
      Map map = (Map)nullPointerException;
      if (size() != map.size())
        return false; 
      int i = 0;
      try {
        while (i < this.h) {
          K k = keyAt(i);
          V v = valueAt(i);
          Object object = map.get(k);
          if (v == null) {
            if (object == null) {
              if (!map.containsKey(k))
                return false; 
            } else {
              return false;
            } 
          } else {
            boolean bool = v.equals(object);
            if (!bool)
              return false; 
          } 
          i++;
        } 
        return true;
      } catch (NullPointerException|ClassCastException nullPointerException1) {
        return false;
      } 
    } 
    return false;
  }
  
  public V get(Object paramObject) {
    return getOrDefault(paramObject, null);
  }
  
  public V getOrDefault(Object paramObject, V paramV) {
    int i = indexOfKey(paramObject);
    if (i >= 0)
      paramV = (V)this.g[(i << 1) + 1]; 
    return paramV;
  }
  
  public int hashCode() {
    int[] arrayOfInt = this.f;
    Object[] arrayOfObject = this.g;
    int m = this.h;
    int j = 0;
    int k = 0;
    for (int i = 1; j < m; i += 2) {
      int n;
      Object object = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (object == null) {
        n = 0;
      } else {
        n = object.hashCode();
      } 
      k += n ^ i1;
      j++;
    } 
    return k;
  }
  
  public int indexOfKey(Object paramObject) {
    return (paramObject == null) ? a() : a(paramObject, paramObject.hashCode());
  }
  
  public boolean isEmpty() {
    return (this.h <= 0);
  }
  
  public K keyAt(int paramInt) {
    return (K)this.g[paramInt << 1];
  }
  
  public V put(K paramK, V paramV) {
    Object[] arrayOfObject;
    int j;
    int k = this.h;
    if (paramK == null) {
      i = a();
      j = 0;
    } else {
      j = paramK.hashCode();
      i = a(paramK, j);
    } 
    if (i >= 0) {
      i = (i << 1) + 1;
      arrayOfObject = this.g;
      Object object = arrayOfObject[i];
      arrayOfObject[i] = paramV;
      return (V)object;
    } 
    int m = i;
    if (k >= this.f.length) {
      i = 4;
      if (k >= 8) {
        i = (k >> 1) + k;
      } else if (k >= 4) {
        i = 8;
      } 
      int[] arrayOfInt = this.f;
      Object[] arrayOfObject1 = this.g;
      a(i);
      if (k == this.h) {
        int[] arrayOfInt1 = this.f;
        if (arrayOfInt1.length > 0) {
          System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, arrayOfInt.length);
          System.arraycopy(arrayOfObject1, 0, this.g, 0, arrayOfObject1.length);
        } 
        a(arrayOfInt, arrayOfObject1, k);
      } else {
        throw new ConcurrentModificationException();
      } 
    } 
    if (m < k) {
      int[] arrayOfInt = this.f;
      i = m + 1;
      System.arraycopy(arrayOfInt, m, arrayOfInt, i, k - m);
      Object[] arrayOfObject1 = this.g;
      System.arraycopy(arrayOfObject1, m << 1, arrayOfObject1, i << 1, this.h - m << 1);
    } 
    int i = this.h;
    if (k == i) {
      int[] arrayOfInt = this.f;
      if (m < arrayOfInt.length) {
        arrayOfInt[m] = j;
        Object[] arrayOfObject1 = this.g;
        j = m << 1;
        arrayOfObject1[j] = arrayOfObject;
        arrayOfObject1[j + 1] = paramV;
        this.h = i + 1;
        return null;
      } 
    } 
    throw new ConcurrentModificationException();
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap) {
    int j = paramSimpleArrayMap.h;
    ensureCapacity(this.h + j);
    int k = this.h;
    int i = 0;
    if (k == 0) {
      if (j > 0) {
        System.arraycopy(paramSimpleArrayMap.f, 0, this.f, 0, j);
        System.arraycopy(paramSimpleArrayMap.g, 0, this.g, 0, j << 1);
        this.h = j;
        return;
      } 
    } else {
      while (i < j) {
        put(paramSimpleArrayMap.keyAt(i), paramSimpleArrayMap.valueAt(i));
        i++;
      } 
    } 
  }
  
  public V putIfAbsent(K paramK, V paramV) {
    V v2 = get(paramK);
    V v1 = v2;
    if (v2 == null)
      v1 = put(paramK, paramV); 
    return v1;
  }
  
  public V remove(Object paramObject) {
    int i = indexOfKey(paramObject);
    return (i >= 0) ? removeAt(i) : null;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2) {
    int i = indexOfKey(paramObject1);
    if (i >= 0) {
      paramObject1 = valueAt(i);
      if (paramObject2 == paramObject1 || (paramObject2 != null && paramObject2.equals(paramObject1))) {
        removeAt(i);
        return true;
      } 
    } 
    return false;
  }
  
  public V removeAt(int paramInt) {
    int i;
    Object[] arrayOfObject = this.g;
    int k = paramInt << 1;
    Object object = arrayOfObject[k + 1];
    int j = this.h;
    if (j <= 1) {
      a(this.f, arrayOfObject, j);
      this.f = ContainerHelpers.a;
      this.g = ContainerHelpers.c;
      i = 0;
    } else {
      int m = j - 1;
      int[] arrayOfInt = this.f;
      int n = arrayOfInt.length;
      i = 8;
      if (n > 8 && j < arrayOfInt.length / 3) {
        if (j > 8)
          i = j + (j >> 1); 
        arrayOfInt = this.f;
        Object[] arrayOfObject1 = this.g;
        a(i);
        if (j == this.h) {
          if (paramInt > 0) {
            System.arraycopy(arrayOfInt, 0, this.f, 0, paramInt);
            System.arraycopy(arrayOfObject1, 0, this.g, 0, k);
          } 
          i = m;
          if (paramInt < m) {
            i = paramInt + 1;
            int[] arrayOfInt1 = this.f;
            n = m - paramInt;
            System.arraycopy(arrayOfInt, i, arrayOfInt1, paramInt, n);
            System.arraycopy(arrayOfObject1, i << 1, this.g, k, n << 1);
            i = m;
          } 
        } else {
          throw new ConcurrentModificationException();
        } 
      } else {
        if (paramInt < m) {
          arrayOfInt = this.f;
          i = paramInt + 1;
          n = m - paramInt;
          System.arraycopy(arrayOfInt, i, arrayOfInt, paramInt, n);
          Object[] arrayOfObject2 = this.g;
          System.arraycopy(arrayOfObject2, i << 1, arrayOfObject2, k, n << 1);
        } 
        Object[] arrayOfObject1 = this.g;
        paramInt = m << 1;
        arrayOfObject1[paramInt] = null;
        arrayOfObject1[paramInt + 1] = null;
        i = m;
      } 
    } 
    if (j == this.h) {
      this.h = i;
      return (V)object;
    } 
    throw new ConcurrentModificationException();
  }
  
  public V replace(K paramK, V paramV) {
    int i = indexOfKey(paramK);
    return (i >= 0) ? setValueAt(i, paramV) : null;
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2) {
    int i = indexOfKey(paramK);
    if (i >= 0) {
      paramK = (K)valueAt(i);
      if (paramK == paramV1 || (paramV1 != null && paramV1.equals(paramK))) {
        setValueAt(i, paramV2);
        return true;
      } 
    } 
    return false;
  }
  
  public V setValueAt(int paramInt, V paramV) {
    paramInt = (paramInt << 1) + 1;
    Object[] arrayOfObject = this.g;
    Object object = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramV;
    return (V)object;
  }
  
  public int size() {
    return this.h;
  }
  
  public String toString() {
    if (isEmpty())
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.h * 28);
    stringBuilder.append('{');
    for (int i = 0; i < this.h; i++) {
      if (i > 0)
        stringBuilder.append(", "); 
      V v = (V)keyAt(i);
      if (v != this) {
        stringBuilder.append(v);
      } else {
        stringBuilder.append("(this Map)");
      } 
      stringBuilder.append('=');
      v = valueAt(i);
      if (v != this) {
        stringBuilder.append(v);
      } else {
        stringBuilder.append("(this Map)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public V valueAt(int paramInt) {
    return (V)this.g[(paramInt << 1) + 1];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\collection\SimpleArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */