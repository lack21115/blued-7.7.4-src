package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
  private static final Object d = new Object();
  
  @NullableDecl
  transient int[] a;
  
  @NullableDecl
  transient Object[] b;
  
  @NullableDecl
  transient Object[] c;
  
  @NullableDecl
  private transient Object e;
  
  private transient int f;
  
  private transient int g;
  
  @NullableDecl
  private transient Set<K> h;
  
  @NullableDecl
  private transient Set<Map.Entry<K, V>> i;
  
  @NullableDecl
  private transient Collection<V> j;
  
  CompactHashMap() {
    b(3);
  }
  
  CompactHashMap(int paramInt) {
    b(paramInt);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Object object1 = CompactHashing.b(paramInt2);
    int i = paramInt2 - 1;
    if (paramInt4 != 0)
      CompactHashing.a(object1, paramInt3 & i, paramInt4 + 1); 
    Object object2 = this.e;
    int[] arrayOfInt = this.a;
    for (paramInt2 = 0; paramInt2 <= paramInt1; paramInt2++) {
      for (paramInt3 = CompactHashing.a(object2, paramInt2); paramInt3 != 0; paramInt3 = CompactHashing.b(j, paramInt1)) {
        paramInt4 = paramInt3 - 1;
        int j = arrayOfInt[paramInt4];
        int k = CompactHashing.a(j, paramInt1) | paramInt2;
        int m = k & i;
        int n = CompactHashing.a(object1, m);
        CompactHashing.a(object1, m, paramInt3);
        arrayOfInt[paramInt4] = CompactHashing.a(k, n, i);
      } 
    } 
    this.e = object1;
    g(i);
    return i;
  }
  
  private int a(@NullableDecl Object paramObject) {
    if (b())
      return -1; 
    int j = Hashing.a(paramObject);
    int k = o();
    int i = CompactHashing.a(this.e, j & k);
    if (i == 0)
      return -1; 
    int m = CompactHashing.a(j, k);
    while (true) {
      j = this.a[--i];
      if (CompactHashing.a(j, k) == m && Objects.a(paramObject, this.b[i]))
        return i; 
      j = CompactHashing.b(j, k);
      i = j;
      if (j == 0)
        return -1; 
    } 
  }
  
  public static <K, V> CompactHashMap<K, V> a() {
    return new CompactHashMap<K, V>();
  }
  
  public static <K, V> CompactHashMap<K, V> a(int paramInt) {
    return new CompactHashMap<K, V>(paramInt);
  }
  
  @NullableDecl
  private Object b(@NullableDecl Object paramObject) {
    if (b())
      return d; 
    int i = o();
    int j = CompactHashing.a(paramObject, null, i, this.e, this.a, this.b, null);
    if (j == -1)
      return d; 
    paramObject = this.c[j];
    a(j, i);
    this.g--;
    f();
    return paramObject;
  }
  
  private void g(int paramInt) {
    paramInt = Integer.numberOfLeadingZeros(paramInt);
    this.f = CompactHashing.a(this.f, 32 - paramInt, 31);
  }
  
  private void h(int paramInt) {
    int i = this.a.length;
    if (paramInt > i) {
      paramInt = Math.min(1073741823, Math.max(1, i >>> 1) + i | 0x1);
      if (paramInt != i)
        e(paramInt); 
    } 
  }
  
  private int o() {
    return (1 << (this.f & 0x1F)) - 1;
  }
  
  void a(int paramInt1, int paramInt2) {
    int i = size() - 1;
    if (paramInt1 < i) {
      Object[] arrayOfObject1 = this.b;
      Object object = arrayOfObject1[i];
      arrayOfObject1[paramInt1] = object;
      Object[] arrayOfObject2 = this.c;
      arrayOfObject2[paramInt1] = arrayOfObject2[i];
      arrayOfObject1[i] = null;
      arrayOfObject2[i] = null;
      int[] arrayOfInt = this.a;
      arrayOfInt[paramInt1] = arrayOfInt[i];
      arrayOfInt[i] = 0;
      int m = Hashing.a(object) & paramInt2;
      int j = CompactHashing.a(this.e, m);
      int k = i + 1;
      i = j;
      if (j == k) {
        CompactHashing.a(this.e, m, paramInt1 + 1);
        return;
      } 
      while (true) {
        j = i - 1;
        m = this.a[j];
        i = CompactHashing.b(m, paramInt2);
        if (i == k) {
          this.a[j] = CompactHashing.a(m, paramInt1 + 1, paramInt2);
          return;
        } 
      } 
    } 
    this.b[paramInt1] = null;
    this.c[paramInt1] = null;
    this.a[paramInt1] = 0;
  }
  
  void a(int paramInt1, @NullableDecl K paramK, @NullableDecl V paramV, int paramInt2, int paramInt3) {
    this.a[paramInt1] = CompactHashing.a(paramInt2, 0, paramInt3);
    this.b[paramInt1] = paramK;
    this.c[paramInt1] = paramV;
  }
  
  int b(int paramInt1, int paramInt2) {
    return paramInt1 - 1;
  }
  
  void b(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "Expected size must be >= 0");
    this.f = Ints.a(paramInt, 1, 1073741823);
  }
  
  boolean b() {
    return (this.e == null);
  }
  
  int c() {
    Preconditions.b(b(), "Arrays already allocated");
    int i = this.f;
    int j = CompactHashing.a(i);
    this.e = CompactHashing.b(j);
    g(j - 1);
    this.a = new int[i];
    this.b = new Object[i];
    this.c = new Object[i];
    return i;
  }
  
  Map<K, V> c(int paramInt) {
    return new LinkedHashMap<K, V>(paramInt, 1.0F);
  }
  
  public void clear() {
    if (b())
      return; 
    f();
    Map<K, V> map = d();
    if (map != null) {
      this.f = Ints.a(size(), 3, 1073741823);
      map.clear();
      this.e = null;
      this.g = 0;
      return;
    } 
    Arrays.fill(this.b, 0, this.g, (Object)null);
    Arrays.fill(this.c, 0, this.g, (Object)null);
    CompactHashing.a(this.e);
    Arrays.fill(this.a, 0, this.g, 0);
    this.g = 0;
  }
  
  public boolean containsKey(@NullableDecl Object paramObject) {
    Map<K, V> map = d();
    return (map != null) ? map.containsKey(paramObject) : ((a(paramObject) != -1));
  }
  
  public boolean containsValue(@NullableDecl Object paramObject) {
    Map<K, V> map = d();
    if (map != null)
      return map.containsValue(paramObject); 
    for (int i = 0; i < this.g; i++) {
      if (Objects.a(paramObject, this.c[i]))
        return true; 
    } 
    return false;
  }
  
  @NullableDecl
  Map<K, V> d() {
    Object object = this.e;
    return (object instanceof Map) ? (Map<K, V>)object : null;
  }
  
  void d(int paramInt) {}
  
  Map<K, V> e() {
    Map<K, V> map = c(o() + 1);
    for (int i = g(); i >= 0; i = f(i))
      map.put((K)this.b[i], (V)this.c[i]); 
    this.e = map;
    this.a = null;
    this.b = null;
    this.c = null;
    f();
    return map;
  }
  
  void e(int paramInt) {
    this.a = Arrays.copyOf(this.a, paramInt);
    this.b = Arrays.copyOf(this.b, paramInt);
    this.c = Arrays.copyOf(this.c, paramInt);
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set2 = this.i;
    Set<Map.Entry<K, V>> set1 = set2;
    if (set2 == null) {
      set1 = j();
      this.i = set1;
    } 
    return set1;
  }
  
  int f(int paramInt) {
    return (++paramInt < this.g) ? paramInt : -1;
  }
  
  void f() {
    this.f += 32;
  }
  
  int g() {
    return isEmpty() ? -1 : 0;
  }
  
  public V get(@NullableDecl Object paramObject) {
    Map<K, V> map = d();
    if (map != null)
      return map.get(paramObject); 
    int i = a(paramObject);
    if (i == -1)
      return null; 
    d(i);
    return (V)this.c[i];
  }
  
  Set<K> h() {
    return new KeySetView(this);
  }
  
  Iterator<K> i() {
    Map<K, V> map = d();
    return (map != null) ? map.keySet().iterator() : new Itr<K>(this) {
        K a(int param1Int) {
          return (K)this.a.b[param1Int];
        }
      };
  }
  
  public boolean isEmpty() {
    return (size() == 0);
  }
  
  Set<Map.Entry<K, V>> j() {
    return new EntrySetView(this);
  }
  
  Iterator<Map.Entry<K, V>> k() {
    Map<K, V> map = d();
    return (map != null) ? map.entrySet().iterator() : new Itr<Map.Entry<K, V>>(this) {
        Map.Entry<K, V> b(int param1Int) {
          return new CompactHashMap.MapEntry(this.a, param1Int);
        }
      };
  }
  
  public Set<K> keySet() {
    Set<K> set2 = this.h;
    Set<K> set1 = set2;
    if (set2 == null) {
      set1 = h();
      this.h = set1;
    } 
    return set1;
  }
  
  Collection<V> l() {
    return new ValuesView(this);
  }
  
  Iterator<V> m() {
    Map<K, V> map = d();
    return (map != null) ? map.values().iterator() : new Itr<V>(this) {
        V a(int param1Int) {
          return (V)this.a.c[param1Int];
        }
      };
  }
  
  @NullableDecl
  public V put(@NullableDecl K paramK, @NullableDecl V paramV) {
    if (b())
      c(); 
    Map<K, V> map = d();
    if (map != null)
      return map.put(paramK, paramV); 
    int[] arrayOfInt = this.a;
    Object[] arrayOfObject2 = this.b;
    Object[] arrayOfObject1 = this.c;
    int m = this.g;
    int n = m + 1;
    int i1 = Hashing.a(paramK);
    int k = o();
    int i = i1 & k;
    int j = CompactHashing.a(this.e, i);
    if (j == 0) {
      if (n > k) {
        i = a(k, CompactHashing.c(k), i1, m);
      } else {
        CompactHashing.a(this.e, i, n);
        i = k;
      } 
    } else {
      int i2 = CompactHashing.a(i1, k);
      i = 0;
      while (true) {
        int i3 = j - 1;
        int i4 = arrayOfInt[i3];
        if (CompactHashing.a(i4, k) == i2 && Objects.a(paramK, arrayOfObject2[i3])) {
          paramK = (K)arrayOfObject1[i3];
          arrayOfObject1[i3] = paramV;
          d(i3);
          return (V)paramK;
        } 
        j = CompactHashing.b(i4, k);
        i++;
        if (j == 0) {
          if (i >= 9)
            return e().put(paramK, paramV); 
          if (n > k) {
            i = a(k, CompactHashing.c(k), i1, m);
          } else {
            arrayOfInt[i3] = CompactHashing.a(i4, n, k);
            i = k;
          } 
          h(n);
          a(m, paramK, paramV, i1, i);
          this.g = n;
          f();
          return null;
        } 
      } 
    } 
    h(n);
    a(m, paramK, paramV, i1, i);
    this.g = n;
    f();
    return null;
  }
  
  @NullableDecl
  public V remove(@NullableDecl Object paramObject) {
    Map<K, V> map = d();
    if (map != null)
      return map.remove(paramObject); 
    Object object = b(paramObject);
    paramObject = object;
    if (object == d)
      paramObject = null; 
    return (V)paramObject;
  }
  
  public int size() {
    Map<K, V> map = d();
    return (map != null) ? map.size() : this.g;
  }
  
  public Collection<V> values() {
    Collection<V> collection2 = this.j;
    Collection<V> collection1 = collection2;
    if (collection2 == null) {
      collection1 = l();
      this.j = collection1;
    } 
    return collection1;
  }
  
  class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
    EntrySetView(CompactHashMap this$0) {}
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      Map map = this.a.d();
      if (map != null)
        return map.entrySet().contains(param1Object); 
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        int i = CompactHashMap.b(this.a, param1Object.getKey());
        bool1 = bool2;
        if (i != -1) {
          bool1 = bool2;
          if (Objects.a(this.a.c[i], param1Object.getValue()))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return this.a.k();
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      Map map = this.a.d();
      if (map != null)
        return map.entrySet().remove(param1Object); 
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        if (this.a.b())
          return false; 
        int i = CompactHashMap.b(this.a);
        int j = CompactHashing.a(param1Object.getKey(), param1Object.getValue(), i, CompactHashMap.c(this.a), this.a.a, this.a.b, this.a.c);
        if (j == -1)
          return false; 
        this.a.a(j, i);
        CompactHashMap.d(this.a);
        this.a.f();
        return true;
      } 
      return false;
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  abstract class Itr<T> implements Iterator<T> {
    int b = CompactHashMap.a(this.e);
    
    int c = this.e.g();
    
    int d = -1;
    
    private Itr(CompactHashMap this$0) {}
    
    private void b() {
      if (CompactHashMap.a(this.e) == this.b)
        return; 
      throw new ConcurrentModificationException();
    }
    
    abstract T a(int param1Int);
    
    void a() {
      this.b += 32;
    }
    
    public boolean hasNext() {
      return (this.c >= 0);
    }
    
    public T next() {
      b();
      if (hasNext()) {
        int i = this.c;
        this.d = i;
        T t = a(i);
        this.c = this.e.f(this.c);
        return t;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      boolean bool;
      b();
      if (this.d >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      a();
      CompactHashMap compactHashMap = this.e;
      compactHashMap.remove(compactHashMap.b[this.d]);
      this.c = this.e.b(this.c, this.d);
      this.d = -1;
    }
  }
  
  class KeySetView extends AbstractSet<K> {
    KeySetView(CompactHashMap this$0) {}
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean contains(Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    public Iterator<K> iterator() {
      return this.a.i();
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      Map map = this.a.d();
      return (map != null) ? map.keySet().remove(param1Object) : ((CompactHashMap.a(this.a, param1Object) != CompactHashMap.n()));
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  final class MapEntry extends AbstractMapEntry<K, V> {
    @NullableDecl
    private final K b;
    
    private int c;
    
    MapEntry(CompactHashMap this$0, int param1Int) {
      this.b = (K)this$0.b[param1Int];
      this.c = param1Int;
    }
    
    private void a() {
      int i = this.c;
      if (i == -1 || i >= this.a.size() || !Objects.a(this.b, this.a.b[this.c]))
        this.c = CompactHashMap.b(this.a, this.b); 
    }
    
    @NullableDecl
    public K getKey() {
      return this.b;
    }
    
    @NullableDecl
    public V getValue() {
      Map map = this.a.d();
      if (map != null)
        return (V)map.get(this.b); 
      a();
      return (V)((this.c == -1) ? null : this.a.c[this.c]);
    }
    
    public V setValue(V param1V) {
      Map<K, V> map = this.a.d();
      if (map != null)
        return map.put(this.b, param1V); 
      a();
      if (this.c == -1) {
        this.a.put(this.b, param1V);
        return null;
      } 
      Object object = this.a.c[this.c];
      this.a.c[this.c] = param1V;
      return (V)object;
    }
  }
  
  class ValuesView extends AbstractCollection<V> {
    ValuesView(CompactHashMap this$0) {}
    
    public void clear() {
      this.a.clear();
    }
    
    public Iterator<V> iterator() {
      return this.a.m();
    }
    
    public int size() {
      return this.a.size();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\CompactHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */