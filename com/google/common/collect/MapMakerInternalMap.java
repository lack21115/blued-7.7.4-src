package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class MapMakerInternalMap<K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>, S extends MapMakerInternalMap.Segment<K, V, E, S>> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
  static final WeakValueReference<Object, Object, DummyInternalEntry> g = new WeakValueReference<Object, Object, DummyInternalEntry>() {
      public MapMakerInternalMap.DummyInternalEntry a() {
        return null;
      }
      
      public MapMakerInternalMap.WeakValueReference<Object, Object, MapMakerInternalMap.DummyInternalEntry> a(ReferenceQueue<Object> param1ReferenceQueue, MapMakerInternalMap.DummyInternalEntry param1DummyInternalEntry) {
        return this;
      }
      
      public void clear() {}
      
      public Object get() {
        return null;
      }
    };
  
  final transient int a;
  
  final transient int b;
  
  final transient Segment<K, V, E, S>[] c;
  
  final int d;
  
  final Equivalence<Object> e;
  
  final transient InternalEntryHelper<K, V, E, S> f;
  
  @NullableDecl
  transient Set<K> h;
  
  @NullableDecl
  transient Collection<V> i;
  
  @NullableDecl
  transient Set<Map.Entry<K, V>> j;
  
  private MapMakerInternalMap(MapMaker paramMapMaker, InternalEntryHelper<K, V, E, S> paramInternalEntryHelper) {
    this.d = Math.min(paramMapMaker.c(), 65536);
    this.e = paramMapMaker.a();
    this.f = paramInternalEntryHelper;
    int n = Math.min(paramMapMaker.b(), 1073741824);
    boolean bool1 = false;
    boolean bool2 = true;
    int i = 1;
    int j = 0;
    while (i < this.d) {
      j++;
      i <<= 1;
    } 
    this.b = 32 - j;
    this.a = i - 1;
    this.c = c(i);
    int m = n / i;
    j = bool2;
    int k = m;
    if (i * m < n) {
      k = m + 1;
      j = bool2;
    } 
    while (true) {
      i = bool1;
      if (j < k) {
        j <<= 1;
        continue;
      } 
      break;
    } 
    while (true) {
      Segment<K, V, E, S>[] arrayOfSegment = this.c;
      if (i < arrayOfSegment.length) {
        arrayOfSegment[i] = a(j, -1);
        i++;
        continue;
      } 
      break;
    } 
  }
  
  static int a(int paramInt) {
    paramInt += paramInt << 15 ^ 0xFFFFCD7D;
    paramInt ^= paramInt >>> 10;
    paramInt += paramInt << 3;
    paramInt ^= paramInt >>> 6;
    paramInt += (paramInt << 2) + (paramInt << 14);
    return paramInt ^ paramInt >>> 16;
  }
  
  static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> a() {
    return (WeakValueReference)g;
  }
  
  static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> a(MapMaker paramMapMaker) {
    if (paramMapMaker.e() == Strength.a && paramMapMaker.f() == Strength.a)
      return new MapMakerInternalMap<K, V, InternalEntry<K, V, ?>, Object>(paramMapMaker, (InternalEntryHelper)StrongKeyStrongValueEntry.Helper.b()); 
    if (paramMapMaker.e() == Strength.a && paramMapMaker.f() == Strength.b)
      return new MapMakerInternalMap<K, V, InternalEntry<K, V, ?>, Object>(paramMapMaker, (InternalEntryHelper)StrongKeyWeakValueEntry.Helper.b()); 
    if (paramMapMaker.e() == Strength.b && paramMapMaker.f() == Strength.a)
      return new MapMakerInternalMap<K, V, InternalEntry<K, V, ?>, Object>(paramMapMaker, (InternalEntryHelper)WeakKeyStrongValueEntry.Helper.b()); 
    if (paramMapMaker.e() == Strength.b && paramMapMaker.f() == Strength.b)
      return new MapMakerInternalMap<K, V, InternalEntry<K, V, ?>, Object>(paramMapMaker, (InternalEntryHelper)WeakKeyWeakValueEntry.Helper.b()); 
    throw new AssertionError();
  }
  
  private static <E> ArrayList<E> b(Collection<E> paramCollection) {
    ArrayList<?> arrayList = new ArrayList(paramCollection.size());
    Iterators.a(arrayList, paramCollection.iterator());
    return (ArrayList)arrayList;
  }
  
  int a(Object paramObject) {
    return a(this.e.a(paramObject));
  }
  
  Segment<K, V, E, S> a(int paramInt1, int paramInt2) {
    return (Segment<K, V, E, S>)this.f.a(this, paramInt1, paramInt2);
  }
  
  void a(E paramE) {
    int i = paramE.b();
    b(i).a(paramE, i);
  }
  
  void a(WeakValueReference<K, V, E> paramWeakValueReference) {
    E e = paramWeakValueReference.b();
    int i = e.b();
    b(i).a((K)e.a(), i, paramWeakValueReference);
  }
  
  Equivalence<Object> b() {
    return this.f.a().a();
  }
  
  E b(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = a(paramObject);
    return b(i).a(paramObject, i);
  }
  
  Segment<K, V, E, S> b(int paramInt) {
    return this.c[paramInt >>> this.b & this.a];
  }
  
  V b(E paramE) {
    return (V)((paramE.a() == null) ? null : paramE.e());
  }
  
  final Segment<K, V, E, S>[] c(int paramInt) {
    return (Segment<K, V, E, S>[])new Segment[paramInt];
  }
  
  public void clear() {
    Segment<K, V, E, S>[] arrayOfSegment = this.c;
    int j = arrayOfSegment.length;
    for (int i = 0; i < j; i++)
      arrayOfSegment[i].f(); 
  }
  
  public boolean containsKey(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return false; 
    int i = a(paramObject);
    return b(i).d(paramObject, i);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return false; 
    Segment<K, V, E, S>[] arrayOfSegment = this.c;
    long l = -1L;
    int i = 0;
    while (i < 3) {
      int k = arrayOfSegment.length;
      long l1 = 0L;
      for (int j = 0; j < k; j++) {
        Segment<K, V, E, S> segment = arrayOfSegment[j];
        int m = segment.b;
        AtomicReferenceArray<E> atomicReferenceArray = segment.e;
        for (m = 0; m < atomicReferenceArray.length(); m++) {
          for (InternalEntry internalEntry = (InternalEntry)atomicReferenceArray.get(m); internalEntry != null; internalEntry = (InternalEntry)internalEntry.c()) {
            V v = segment.b((E)internalEntry);
            if (v != null && b().a(paramObject, v))
              return true; 
          } 
        } 
        l1 += segment.c;
      } 
      if (l1 == l)
        break; 
      i++;
      l = l1;
    } 
    return false;
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set = this.j;
    if (set != null)
      return set; 
    set = new EntrySet(this);
    this.j = set;
    return set;
  }
  
  public V get(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = a(paramObject);
    return b(i).c(paramObject, i);
  }
  
  public boolean isEmpty() {
    Segment<K, V, E, S>[] arrayOfSegment = this.c;
    boolean bool = false;
    long l = 0L;
    int i;
    for (i = 0; i < arrayOfSegment.length; i++) {
      if ((arrayOfSegment[i]).b != 0)
        return false; 
      l += (arrayOfSegment[i]).c;
    } 
    if (l != 0L) {
      for (i = 0; i < arrayOfSegment.length; i++) {
        if ((arrayOfSegment[i]).b != 0)
          return false; 
        l -= (arrayOfSegment[i]).c;
      } 
      if (l == 0L)
        bool = true; 
      return bool;
    } 
    return true;
  }
  
  public Set<K> keySet() {
    Set<K> set = this.h;
    if (set != null)
      return set; 
    set = new KeySet(this);
    this.h = set;
    return set;
  }
  
  public V put(K paramK, V paramV) {
    Preconditions.a(paramK);
    Preconditions.a(paramV);
    int i = a(paramK);
    return b(i).a(paramK, i, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap) {
    for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet())
      put((K)entry.getKey(), (V)entry.getValue()); 
  }
  
  public V putIfAbsent(K paramK, V paramV) {
    Preconditions.a(paramK);
    Preconditions.a(paramV);
    int i = a(paramK);
    return b(i).a(paramK, i, paramV, true);
  }
  
  public V remove(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = a(paramObject);
    return b(i).e(paramObject, i);
  }
  
  public boolean remove(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    if (paramObject1 == null || paramObject2 == null)
      return false; 
    int i = a(paramObject1);
    return b(i).b(paramObject1, i, paramObject2);
  }
  
  public V replace(K paramK, V paramV) {
    Preconditions.a(paramK);
    Preconditions.a(paramV);
    int i = a(paramK);
    return b(i).a(paramK, i, paramV);
  }
  
  public boolean replace(K paramK, @NullableDecl V paramV1, V paramV2) {
    Preconditions.a(paramK);
    Preconditions.a(paramV2);
    if (paramV1 == null)
      return false; 
    int i = a(paramK);
    return b(i).a(paramK, i, paramV1, paramV2);
  }
  
  public int size() {
    Segment<K, V, E, S>[] arrayOfSegment = this.c;
    long l = 0L;
    for (int i = 0; i < arrayOfSegment.length; i++)
      l += (arrayOfSegment[i]).b; 
    return Ints.b(l);
  }
  
  public Collection<V> values() {
    Collection<V> collection = this.i;
    if (collection != null)
      return collection; 
    collection = new Values(this);
    this.i = collection;
    return collection;
  }
  
  static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
    transient ConcurrentMap<K, V> a;
    
    protected ConcurrentMap<K, V> c() {
      return this.a;
    }
  }
  
  static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
    final K a;
    
    final int b;
    
    @NullableDecl
    final E c;
    
    AbstractStrongKeyEntry(K param1K, int param1Int, @NullableDecl E param1E) {
      this.a = param1K;
      this.b = param1Int;
      this.c = param1E;
    }
    
    public K a() {
      return this.a;
    }
    
    public int b() {
      return this.b;
    }
    
    public E c() {
      return this.c;
    }
  }
  
  static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
    final int a;
    
    @NullableDecl
    final E b;
    
    AbstractWeakKeyEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @NullableDecl E param1E) {
      super(param1K, param1ReferenceQueue);
      this.a = param1Int;
      this.b = param1E;
    }
    
    public K a() {
      return get();
    }
    
    public int b() {
      return this.a;
    }
    
    public E c() {
      return this.b;
    }
  }
  
  static final class CleanupMapTask implements Runnable {
    final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> a;
    
    public void run() {
      MapMakerInternalMap mapMakerInternalMap = this.a.get();
      if (mapMakerInternalMap != null) {
        MapMakerInternalMap.Segment[] arrayOfSegment = mapMakerInternalMap.c;
        int j = arrayOfSegment.length;
        for (int i = 0; i < j; i++)
          arrayOfSegment[i].i(); 
        return;
      } 
      throw new CancellationException();
    }
  }
  
  static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
    private DummyInternalEntry() {
      throw new AssertionError();
    }
    
    public Object a() {
      throw new AssertionError();
    }
    
    public int b() {
      throw new AssertionError();
    }
    
    public DummyInternalEntry d() {
      throw new AssertionError();
    }
    
    public Object e() {
      throw new AssertionError();
    }
  }
  
  final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
    EntryIterator(MapMakerInternalMap this$0) {
      super(this$0);
    }
    
    public Map.Entry<K, V> a() {
      return e();
    }
  }
  
  final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
    EntrySet(MapMakerInternalMap this$0) {}
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      Object object = param1Object.getKey();
      if (object == null)
        return false; 
      object = this.a.get(object);
      bool = bool1;
      if (object != null) {
        bool = bool1;
        if (this.a.b().a(param1Object.getValue(), object))
          bool = true; 
      } 
      return bool;
    }
    
    public boolean isEmpty() {
      return this.a.isEmpty();
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new MapMakerInternalMap.EntryIterator(this.a);
    }
    
    public boolean remove(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      Object object = param1Object.getKey();
      bool = bool1;
      if (object != null) {
        bool = bool1;
        if (this.a.remove(object, param1Object.getValue()))
          bool = true; 
      } 
      return bool;
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  abstract class HashIterator<T> implements Iterator<T> {
    int b;
    
    int c;
    
    @NullableDecl
    MapMakerInternalMap.Segment<K, V, E, S> d;
    
    @NullableDecl
    AtomicReferenceArray<E> e;
    
    @NullableDecl
    E f;
    
    @NullableDecl
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry g;
    
    @NullableDecl
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry h;
    
    HashIterator(MapMakerInternalMap this$0) {
      this.b = this$0.c.length - 1;
      this.c = -1;
      b();
    }
    
    boolean a(E param1E) {
      try {
        Object object = param1E.a();
        param1E = (E)this.i.b(param1E);
        if (param1E != null) {
          this.g = new MapMakerInternalMap.WriteThroughEntry(this.i, (K)object, (V)param1E);
          return true;
        } 
        return false;
      } finally {
        this.d.g();
      } 
    }
    
    final void b() {
      this.g = null;
      if (c())
        return; 
      if (d())
        return; 
      while (this.b >= 0) {
        MapMakerInternalMap.Segment[] arrayOfSegment = this.i.c;
        int i = this.b;
        this.b = i - 1;
        this.d = arrayOfSegment[i];
        if (this.d.b != 0) {
          this.e = this.d.e;
          this.c = this.e.length() - 1;
          if (d())
            break; 
        } 
      } 
    }
    
    boolean c() {
      E e = this.f;
      if (e != null)
        while (true) {
          this.f = (E)e.c();
          e = this.f;
          if (e != null) {
            if (a(e))
              return true; 
            e = this.f;
            continue;
          } 
          break;
        }  
      return false;
    }
    
    boolean d() {
      while (true) {
        int i = this.c;
        if (i >= 0) {
          AtomicReferenceArray<E> atomicReferenceArray = this.e;
          this.c = i - 1;
          MapMakerInternalMap.InternalEntry internalEntry = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
          this.f = (E)internalEntry;
          if (internalEntry != null) {
            if (!a(this.f)) {
              if (c())
                continue; 
              continue;
            } 
            return true;
          } 
          continue;
        } 
        return false;
      } 
    }
    
    MapMakerInternalMap<K, V, E, S>.WriteThroughEntry e() {
      MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.g;
      if (writeThroughEntry != null) {
        this.h = writeThroughEntry;
        b();
        return this.h;
      } 
      throw new NoSuchElementException();
    }
    
    public boolean hasNext() {
      return (this.g != null);
    }
    
    public void remove() {
      boolean bool;
      if (this.h != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      this.i.remove(this.h.getKey());
      this.h = null;
    }
  }
  
  static interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
    K a();
    
    int b();
    
    E c();
    
    V e();
  }
  
  static interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
    E a(S param1S, E param1E1, @NullableDecl E param1E2);
    
    E a(S param1S, K param1K, int param1Int, @NullableDecl E param1E);
    
    S a(MapMakerInternalMap<K, V, E, S> param1MapMakerInternalMap, int param1Int1, int param1Int2);
    
    MapMakerInternalMap.Strength a();
    
    void a(S param1S, E param1E, V param1V);
  }
  
  final class KeyIterator extends HashIterator<K> {
    KeyIterator(MapMakerInternalMap this$0) {
      super(this$0);
    }
    
    public K next() {
      return e().getKey();
    }
  }
  
  final class KeySet extends SafeToArraySet<K> {
    KeySet(MapMakerInternalMap this$0) {}
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean contains(Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    public boolean isEmpty() {
      return this.a.isEmpty();
    }
    
    public Iterator<K> iterator() {
      return new MapMakerInternalMap.KeyIterator(this.a);
    }
    
    public boolean remove(Object param1Object) {
      return (this.a.remove(param1Object) != null);
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  static abstract class SafeToArraySet<E> extends AbstractSet<E> {
    private SafeToArraySet() {}
    
    public Object[] toArray() {
      return MapMakerInternalMap.a(this).toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])MapMakerInternalMap.a(this).toArray((Object[])param1ArrayOfT);
    }
  }
  
  static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
    final MapMakerInternalMap<K, V, E, S> a;
    
    volatile int b;
    
    int c;
    
    int d;
    
    @NullableDecl
    volatile AtomicReferenceArray<E> e;
    
    final int f;
    
    final AtomicInteger g = new AtomicInteger();
    
    Segment(MapMakerInternalMap<K, V, E, S> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      this.a = param1MapMakerInternalMap;
      this.f = param1Int2;
      a(a(param1Int1));
    }
    
    static <K, V, E extends MapMakerInternalMap.InternalEntry<K, V, E>> boolean a(E param1E) {
      return (param1E.e() == null);
    }
    
    E a(E param1E1, E param1E2) {
      return this.a.f.a(a(), param1E1, param1E2);
    }
    
    E a(Object param1Object, int param1Int) {
      if (this.b != 0)
        for (E e = b(param1Int); e != null; e = (E)e.c()) {
          if (e.b() == param1Int) {
            Object object = e.a();
            if (object == null) {
              d();
            } else if (this.a.e.a(param1Object, object)) {
              return e;
            } 
          } 
        }  
      return null;
    }
    
    abstract S a();
    
    V a(K param1K, int param1Int, V param1V) {
      lock();
      try {
        h();
        AtomicReferenceArray<E> atomicReferenceArray = this.e;
        int i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry2 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry1 = internalEntry2; internalEntry1 != null; internalEntry1 = (MapMakerInternalMap.InternalEntry)internalEntry1.c()) {
          Object object = internalEntry1.a();
          if (internalEntry1.b() == param1Int && object != null && this.a.e.a(param1K, object)) {
            param1K = (K)internalEntry1.e();
            if (param1K == null) {
              if (a(internalEntry1)) {
                param1Int = this.b;
                this.c++;
                param1K = (K)b((E)internalEntry2, (E)internalEntry1);
                param1Int = this.b;
                atomicReferenceArray.set(i, (E)param1K);
                this.b = param1Int - 1;
              } 
              return null;
            } 
            this.c++;
            a((E)internalEntry1, param1V);
            return (V)param1K;
          } 
        } 
        return null;
      } finally {
        unlock();
      } 
    }
    
    V a(K param1K, int param1Int, V param1V, boolean param1Boolean) {
      lock();
      try {
        h();
        int j = this.b + 1;
        int i = j;
        if (j > this.d) {
          e();
          i = this.b + 1;
        } 
        AtomicReferenceArray<E> atomicReferenceArray = this.e;
        j = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry2 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(j);
        for (MapMakerInternalMap.InternalEntry internalEntry1 = internalEntry2; internalEntry1 != null; internalEntry1 = (MapMakerInternalMap.InternalEntry)internalEntry1.c()) {
          Object object = internalEntry1.a();
          if (internalEntry1.b() == param1Int && object != null && this.a.e.a(param1K, object)) {
            param1K = (K)internalEntry1.e();
            if (param1K == null) {
              this.c++;
              a((E)internalEntry1, param1V);
              this.b = this.b;
              return null;
            } 
            if (param1Boolean)
              return (V)param1K; 
            this.c++;
            a((E)internalEntry1, param1V);
            return (V)param1K;
          } 
        } 
        this.c++;
        param1K = (K)this.a.f.a(a(), param1K, param1Int, (E)internalEntry2);
        a((E)param1K, param1V);
        atomicReferenceArray.set(j, (E)param1K);
        this.b = i;
        return null;
      } finally {
        unlock();
      } 
    }
    
    AtomicReferenceArray<E> a(int param1Int) {
      return new AtomicReferenceArray<E>(param1Int);
    }
    
    void a(E param1E, V param1V) {
      this.a.f.a(a(), param1E, param1V);
    }
    
    void a(ReferenceQueue<K> param1ReferenceQueue) {
      int i = 0;
      while (true) {
        Reference<? extends K> reference = param1ReferenceQueue.poll();
        if (reference != null) {
          MapMakerInternalMap.InternalEntry internalEntry = (MapMakerInternalMap.InternalEntry)reference;
          this.a.a((E)internalEntry);
          int j = i + 1;
          i = j;
          if (j == 16)
            break; 
          continue;
        } 
        break;
      } 
    }
    
    void a(AtomicReferenceArray<E> param1AtomicReferenceArray) {
      this.d = param1AtomicReferenceArray.length() * 3 / 4;
      int i = this.d;
      if (i == this.f)
        this.d = i + 1; 
      this.e = param1AtomicReferenceArray;
    }
    
    boolean a(E param1E, int param1Int) {
      lock();
      try {
        int i = this.b;
        AtomicReferenceArray<E> atomicReferenceArray = this.e;
        param1Int &= atomicReferenceArray.length() - 1;
        MapMakerInternalMap.InternalEntry internalEntry2 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(param1Int);
        for (MapMakerInternalMap.InternalEntry internalEntry1 = internalEntry2; internalEntry1 != null; internalEntry1 = (MapMakerInternalMap.InternalEntry)internalEntry1.c()) {
          if (internalEntry1 == param1E) {
            this.c++;
            param1E = b((E)internalEntry2, (E)internalEntry1);
            i = this.b;
            atomicReferenceArray.set(param1Int, param1E);
            this.b = i - 1;
            return true;
          } 
        } 
        return false;
      } finally {
        unlock();
      } 
    }
    
    boolean a(K param1K, int param1Int, MapMakerInternalMap.WeakValueReference<K, V, E> param1WeakValueReference) {
      lock();
      try {
        int i = this.b;
        AtomicReferenceArray<E> atomicReferenceArray = this.e;
        i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry2 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry1 = internalEntry2; internalEntry1 != null; internalEntry1 = (MapMakerInternalMap.InternalEntry)internalEntry1.c()) {
          Object object = internalEntry1.a();
          if (internalEntry1.b() == param1Int && object != null && this.a.e.a(param1K, object)) {
            if (((MapMakerInternalMap.WeakValueEntry<K, V, E>)internalEntry1).d() == param1WeakValueReference) {
              this.c++;
              param1K = (K)b((E)internalEntry2, (E)internalEntry1);
              param1Int = this.b;
              atomicReferenceArray.set(i, (E)param1K);
              this.b = param1Int - 1;
              return true;
            } 
            return false;
          } 
        } 
        return false;
      } finally {
        unlock();
      } 
    }
    
    boolean a(K param1K, int param1Int, V param1V1, V param1V2) {
      lock();
      try {
        h();
        AtomicReferenceArray<E> atomicReferenceArray = this.e;
        int i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry2 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry1 = internalEntry2; internalEntry1 != null; internalEntry1 = (MapMakerInternalMap.InternalEntry)internalEntry1.c()) {
          Object object = internalEntry1.a();
          if (internalEntry1.b() == param1Int && object != null && this.a.e.a(param1K, object)) {
            param1K = (K)internalEntry1.e();
            if (param1K == null) {
              if (a(internalEntry1)) {
                param1Int = this.b;
                this.c++;
                param1K = (K)b((E)internalEntry2, (E)internalEntry1);
                param1Int = this.b;
                atomicReferenceArray.set(i, (E)param1K);
                this.b = param1Int - 1;
              } 
              return false;
            } 
            if (this.a.b().a(param1V1, param1K)) {
              this.c++;
              a((E)internalEntry1, param1V2);
              return true;
            } 
            return false;
          } 
        } 
        return false;
      } finally {
        unlock();
      } 
    }
    
    E b(int param1Int) {
      AtomicReferenceArray<E> atomicReferenceArray = this.e;
      return atomicReferenceArray.get(param1Int & atomicReferenceArray.length() - 1);
    }
    
    E b(E param1E1, E param1E2) {
      int i = this.b;
      Object object = param1E2.c();
      while (param1E1 != param1E2) {
        E e = a(param1E1, (E)object);
        if (e != null) {
          object = e;
        } else {
          i--;
        } 
        param1E1 = (E)param1E1.c();
      } 
      this.b = i;
      return (E)object;
    }
    
    E b(Object param1Object, int param1Int) {
      return a(param1Object, param1Int);
    }
    
    @NullableDecl
    V b(E param1E) {
      if (param1E.a() == null) {
        d();
        return null;
      } 
      param1E = (E)param1E.e();
      if (param1E == null) {
        d();
        return null;
      } 
      return (V)param1E;
    }
    
    void b() {}
    
    void b(ReferenceQueue<V> param1ReferenceQueue) {
      int i = 0;
      while (true) {
        Reference<? extends V> reference = param1ReferenceQueue.poll();
        if (reference != null) {
          MapMakerInternalMap.WeakValueReference<K, V, E> weakValueReference = (MapMakerInternalMap.WeakValueReference)reference;
          this.a.a(weakValueReference);
          int j = i + 1;
          i = j;
          if (j == 16)
            break; 
          continue;
        } 
        break;
      } 
    }
    
    boolean b(Object param1Object1, int param1Int, Object param1Object2) {
      lock();
      try {
        h();
        int i = this.b;
        AtomicReferenceArray<E> atomicReferenceArray = this.e;
        i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry2 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        MapMakerInternalMap.InternalEntry internalEntry1 = internalEntry2;
        while (true) {
          boolean bool = false;
          if (internalEntry1 != null) {
            Object object = internalEntry1.a();
            if (internalEntry1.b() == param1Int && object != null && this.a.e.a(param1Object1, object)) {
              param1Object1 = internalEntry1.e();
              if (this.a.b().a(param1Object2, param1Object1)) {
                bool = true;
              } else if (!a(internalEntry1)) {
                return false;
              } 
              this.c++;
              param1Object1 = b((E)internalEntry2, (E)internalEntry1);
              param1Int = this.b;
              atomicReferenceArray.set(i, (E)param1Object1);
              this.b = param1Int - 1;
              return bool;
            } 
            internalEntry1 = (MapMakerInternalMap.InternalEntry)internalEntry1.c();
            continue;
          } 
          return false;
        } 
      } finally {
        unlock();
      } 
    }
    
    V c(Object param1Object, int param1Int) {
      try {
        param1Object = b(param1Object, param1Int);
        if (param1Object == null)
          return null; 
        param1Object = param1Object.e();
        if (param1Object == null)
          d(); 
        return (V)param1Object;
      } finally {
        g();
      } 
    }
    
    void c() {}
    
    <T> void c(ReferenceQueue<T> param1ReferenceQueue) {
      while (param1ReferenceQueue.poll() != null);
    }
    
    void d() {
      if (tryLock())
        try {
          b();
          return;
        } finally {
          unlock();
        }  
    }
    
    boolean d(Object param1Object, int param1Int) {
      try {
        int i = this.b;
        boolean bool = false;
        if (i != 0) {
          param1Object = b(param1Object, param1Int);
          boolean bool1 = bool;
          if (param1Object != null) {
            param1Object = param1Object.e();
            bool1 = bool;
            if (param1Object != null)
              bool1 = true; 
          } 
          return bool1;
        } 
        return false;
      } finally {
        g();
      } 
    }
    
    V e(Object param1Object, int param1Int) {
      lock();
      try {
        h();
        int i = this.b;
        AtomicReferenceArray<E> atomicReferenceArray = this.e;
        i = atomicReferenceArray.length() - 1 & param1Int;
        MapMakerInternalMap.InternalEntry internalEntry2 = (MapMakerInternalMap.InternalEntry)atomicReferenceArray.get(i);
        for (MapMakerInternalMap.InternalEntry internalEntry1 = internalEntry2; internalEntry1 != null; internalEntry1 = (MapMakerInternalMap.InternalEntry)internalEntry1.c()) {
          Object object = internalEntry1.a();
          if (internalEntry1.b() == param1Int && object != null && this.a.e.a(param1Object, object)) {
            param1Object = internalEntry1.e();
            if (param1Object != null || a(internalEntry1)) {
              this.c++;
              internalEntry1 = (MapMakerInternalMap.InternalEntry)b((E)internalEntry2, (E)internalEntry1);
              param1Int = this.b;
              atomicReferenceArray.set(i, (E)internalEntry1);
              this.b = param1Int - 1;
              return (V)param1Object;
            } 
            return null;
          } 
        } 
        return null;
      } finally {
        unlock();
      } 
    }
    
    void e() {
      AtomicReferenceArray<E> atomicReferenceArray1 = this.e;
      int k = atomicReferenceArray1.length();
      if (k >= 1073741824)
        return; 
      int i = this.b;
      AtomicReferenceArray<E> atomicReferenceArray2 = a(k << 1);
      this.d = atomicReferenceArray2.length() * 3 / 4;
      int m = atomicReferenceArray2.length() - 1;
      int j = 0;
      while (j < k) {
        MapMakerInternalMap.InternalEntry internalEntry = (MapMakerInternalMap.InternalEntry)atomicReferenceArray1.get(j);
        int n = i;
        if (internalEntry != null) {
          Object object = internalEntry.c();
          n = internalEntry.b() & m;
          if (object == null) {
            atomicReferenceArray2.set(n, (E)internalEntry);
            n = i;
          } else {
            Object object1 = internalEntry;
            while (object != null) {
              int i2 = object.b() & m;
              int i1 = n;
              if (i2 != n) {
                object1 = object;
                i1 = i2;
              } 
              object = object.c();
              n = i1;
            } 
            atomicReferenceArray2.set(n, (E)object1);
            while (true) {
              n = i;
              if (internalEntry != object1) {
                n = internalEntry.b() & m;
                object = a((E)internalEntry, atomicReferenceArray2.get(n));
                if (object != null) {
                  atomicReferenceArray2.set(n, (E)object);
                } else {
                  i--;
                } 
                internalEntry = (MapMakerInternalMap.InternalEntry)internalEntry.c();
                continue;
              } 
              break;
            } 
          } 
        } 
        j++;
        i = n;
      } 
      this.e = atomicReferenceArray2;
      this.b = i;
    }
    
    void f() {
      if (this.b != 0) {
        lock();
        try {
          AtomicReferenceArray<E> atomicReferenceArray = this.e;
          for (int i = 0; i < atomicReferenceArray.length(); i++)
            atomicReferenceArray.set(i, null); 
          c();
          this.g.set(0);
          this.c++;
          this.b = 0;
          return;
        } finally {
          unlock();
        } 
      } 
    }
    
    void g() {
      if ((this.g.incrementAndGet() & 0x3F) == 0)
        i(); 
    }
    
    void h() {
      j();
    }
    
    void i() {
      j();
    }
    
    void j() {
      if (tryLock())
        try {
          b();
          this.g.set(0);
          return;
        } finally {
          unlock();
        }  
    }
  }
  
  static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {}
  
  enum Strength {
    a {
      Equivalence<Object> a() {
        return Equivalence.a();
      }
    },
    b {
      Equivalence<Object> a() {
        return Equivalence.b();
      }
    };
    
    abstract Equivalence<Object> a();
  }
  
  enum null {
    Equivalence<Object> a() {
      return Equivalence.a();
    }
  }
  
  enum null {
    Equivalence<Object> a() {
      return Equivalence.b();
    }
  }
  
  static final class StrongKeyDummyValueEntry<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> {
    StrongKeyDummyValueEntry(K param1K, int param1Int, @NullableDecl StrongKeyDummyValueEntry<K> param1StrongKeyDummyValueEntry) {
      super(param1K, param1Int, param1StrongKeyDummyValueEntry);
    }
    
    StrongKeyDummyValueEntry<K> a(StrongKeyDummyValueEntry<K> param1StrongKeyDummyValueEntry) {
      return new StrongKeyDummyValueEntry(this.a, this.b, param1StrongKeyDummyValueEntry);
    }
    
    public MapMaker.Dummy d() {
      return MapMaker.Dummy.a;
    }
    
    static final class Helper<K> implements MapMakerInternalMap.InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, MapMakerInternalMap.StrongKeyDummyValueSegment<K>> {
      private static final Helper<?> a = new Helper();
      
      public MapMakerInternalMap.Strength a() {
        return MapMakerInternalMap.Strength.a;
      }
      
      public MapMakerInternalMap.StrongKeyDummyValueEntry<K> a(MapMakerInternalMap.StrongKeyDummyValueSegment<K> param2StrongKeyDummyValueSegment, MapMakerInternalMap.StrongKeyDummyValueEntry<K> param2StrongKeyDummyValueEntry1, @NullableDecl MapMakerInternalMap.StrongKeyDummyValueEntry<K> param2StrongKeyDummyValueEntry2) {
        return param2StrongKeyDummyValueEntry1.a(param2StrongKeyDummyValueEntry2);
      }
      
      public MapMakerInternalMap.StrongKeyDummyValueEntry<K> a(MapMakerInternalMap.StrongKeyDummyValueSegment<K> param2StrongKeyDummyValueSegment, K param2K, int param2Int, @NullableDecl MapMakerInternalMap.StrongKeyDummyValueEntry<K> param2StrongKeyDummyValueEntry) {
        return new MapMakerInternalMap.StrongKeyDummyValueEntry<K>(param2K, param2Int, param2StrongKeyDummyValueEntry);
      }
      
      public void a(MapMakerInternalMap.StrongKeyDummyValueSegment<K> param2StrongKeyDummyValueSegment, MapMakerInternalMap.StrongKeyDummyValueEntry<K> param2StrongKeyDummyValueEntry, MapMaker.Dummy param2Dummy) {}
      
      public MapMakerInternalMap.StrongKeyDummyValueSegment<K> b(MapMakerInternalMap<K, MapMaker.Dummy, MapMakerInternalMap.StrongKeyDummyValueEntry<K>, MapMakerInternalMap.StrongKeyDummyValueSegment<K>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.StrongKeyDummyValueSegment<K>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
    }
  }
  
  static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
    private static final Helper<?> a = new Helper();
    
    public MapMakerInternalMap.Strength a() {
      return MapMakerInternalMap.Strength.a;
    }
    
    public MapMakerInternalMap.StrongKeyDummyValueEntry<K> a(MapMakerInternalMap.StrongKeyDummyValueSegment<K> param1StrongKeyDummyValueSegment, MapMakerInternalMap.StrongKeyDummyValueEntry<K> param1StrongKeyDummyValueEntry1, @NullableDecl MapMakerInternalMap.StrongKeyDummyValueEntry<K> param1StrongKeyDummyValueEntry2) {
      return param1StrongKeyDummyValueEntry1.a(param1StrongKeyDummyValueEntry2);
    }
    
    public MapMakerInternalMap.StrongKeyDummyValueEntry<K> a(MapMakerInternalMap.StrongKeyDummyValueSegment<K> param1StrongKeyDummyValueSegment, K param1K, int param1Int, @NullableDecl MapMakerInternalMap.StrongKeyDummyValueEntry<K> param1StrongKeyDummyValueEntry) {
      return new MapMakerInternalMap.StrongKeyDummyValueEntry<K>(param1K, param1Int, param1StrongKeyDummyValueEntry);
    }
    
    public void a(MapMakerInternalMap.StrongKeyDummyValueSegment<K> param1StrongKeyDummyValueSegment, MapMakerInternalMap.StrongKeyDummyValueEntry<K> param1StrongKeyDummyValueEntry, MapMaker.Dummy param1Dummy) {}
    
    public MapMakerInternalMap.StrongKeyDummyValueSegment<K> b(MapMakerInternalMap<K, MapMaker.Dummy, MapMakerInternalMap.StrongKeyDummyValueEntry<K>, MapMakerInternalMap.StrongKeyDummyValueSegment<K>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.StrongKeyDummyValueSegment<K>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
  }
  
  static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
    StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, MapMakerInternalMap.StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    StrongKeyDummyValueSegment<K> k() {
      return this;
    }
  }
  
  static final class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {
    @NullableDecl
    private volatile V d = null;
    
    StrongKeyStrongValueEntry(K param1K, int param1Int, @NullableDecl StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry) {
      super(param1K, param1Int, param1StrongKeyStrongValueEntry);
    }
    
    StrongKeyStrongValueEntry<K, V> a(StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry) {
      param1StrongKeyStrongValueEntry = new StrongKeyStrongValueEntry(this.a, this.b, param1StrongKeyStrongValueEntry);
      param1StrongKeyStrongValueEntry.d = this.d;
      return param1StrongKeyStrongValueEntry;
    }
    
    void a(V param1V) {
      this.d = param1V;
    }
    
    @NullableDecl
    public V e() {
      return this.d;
    }
    
    static final class Helper<K, V> implements MapMakerInternalMap.InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> {
      private static final Helper<?, ?> a = new Helper();
      
      static <K, V> Helper<K, V> b() {
        return (Helper)a;
      }
      
      public MapMakerInternalMap.Strength a() {
        return MapMakerInternalMap.Strength.a;
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> a(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param2StrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param2StrongKeyStrongValueEntry1, @NullableDecl MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param2StrongKeyStrongValueEntry2) {
        return param2StrongKeyStrongValueEntry1.a(param2StrongKeyStrongValueEntry2);
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> a(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param2StrongKeyStrongValueSegment, K param2K, int param2Int, @NullableDecl MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param2StrongKeyStrongValueEntry) {
        return new MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>(param2K, param2Int, param2StrongKeyStrongValueEntry);
      }
      
      public void a(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param2StrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param2StrongKeyStrongValueEntry, V param2V) {
        param2StrongKeyStrongValueEntry.a(param2V);
      }
      
      public MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> b(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
    }
  }
  
  static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
    private static final Helper<?, ?> a = new Helper();
    
    static <K, V> Helper<K, V> b() {
      return (Helper)a;
    }
    
    public MapMakerInternalMap.Strength a() {
      return MapMakerInternalMap.Strength.a;
    }
    
    public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> a(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param1StrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry1, @NullableDecl MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry2) {
      return param1StrongKeyStrongValueEntry1.a(param1StrongKeyStrongValueEntry2);
    }
    
    public MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> a(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param1StrongKeyStrongValueSegment, K param1K, int param1Int, @NullableDecl MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry) {
      return new MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>(param1K, param1Int, param1StrongKeyStrongValueEntry);
    }
    
    public void a(MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> param1StrongKeyStrongValueSegment, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V> param1StrongKeyStrongValueEntry, V param1V) {
      param1StrongKeyStrongValueEntry.a(param1V);
    }
    
    public MapMakerInternalMap.StrongKeyStrongValueSegment<K, V> b(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.StrongKeyStrongValueSegment<K, V>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
  }
  
  static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
    StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    StrongKeyStrongValueSegment<K, V> k() {
      return this;
    }
  }
  
  static final class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
    private volatile MapMakerInternalMap.WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> d = MapMakerInternalMap.a();
    
    StrongKeyWeakValueEntry(K param1K, int param1Int, @NullableDecl StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry) {
      super(param1K, param1Int, param1StrongKeyWeakValueEntry);
    }
    
    StrongKeyWeakValueEntry<K, V> a(ReferenceQueue<V> param1ReferenceQueue, StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry) {
      param1StrongKeyWeakValueEntry = new StrongKeyWeakValueEntry(this.a, this.b, param1StrongKeyWeakValueEntry);
      param1StrongKeyWeakValueEntry.d = this.d.a(param1ReferenceQueue, param1StrongKeyWeakValueEntry);
      return param1StrongKeyWeakValueEntry;
    }
    
    void a(V param1V, ReferenceQueue<V> param1ReferenceQueue) {
      MapMakerInternalMap.WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> weakValueReference = this.d;
      this.d = new MapMakerInternalMap.WeakValueReferenceImpl<K, V, StrongKeyWeakValueEntry<K, V>>(param1ReferenceQueue, param1V, this);
      weakValueReference.clear();
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> d() {
      return this.d;
    }
    
    public V e() {
      return this.d.get();
    }
    
    static final class Helper<K, V> implements MapMakerInternalMap.InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> {
      private static final Helper<?, ?> a = new Helper();
      
      static <K, V> Helper<K, V> b() {
        return (Helper)a;
      }
      
      public MapMakerInternalMap.Strength a() {
        return MapMakerInternalMap.Strength.b;
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> a(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param2StrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param2StrongKeyWeakValueEntry1, @NullableDecl MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param2StrongKeyWeakValueEntry2) {
        return MapMakerInternalMap.Segment.a(param2StrongKeyWeakValueEntry1) ? null : param2StrongKeyWeakValueEntry1.a(MapMakerInternalMap.StrongKeyWeakValueSegment.a(param2StrongKeyWeakValueSegment), param2StrongKeyWeakValueEntry2);
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> a(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param2StrongKeyWeakValueSegment, K param2K, int param2Int, @NullableDecl MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param2StrongKeyWeakValueEntry) {
        return new MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>(param2K, param2Int, param2StrongKeyWeakValueEntry);
      }
      
      public void a(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param2StrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param2StrongKeyWeakValueEntry, V param2V) {
        param2StrongKeyWeakValueEntry.a(param2V, MapMakerInternalMap.StrongKeyWeakValueSegment.a(param2StrongKeyWeakValueSegment));
      }
      
      public MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> b(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
    }
  }
  
  static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
    private static final Helper<?, ?> a = new Helper();
    
    static <K, V> Helper<K, V> b() {
      return (Helper)a;
    }
    
    public MapMakerInternalMap.Strength a() {
      return MapMakerInternalMap.Strength.b;
    }
    
    public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> a(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param1StrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry1, @NullableDecl MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry2) {
      return MapMakerInternalMap.Segment.a(param1StrongKeyWeakValueEntry1) ? null : param1StrongKeyWeakValueEntry1.a(MapMakerInternalMap.StrongKeyWeakValueSegment.a(param1StrongKeyWeakValueSegment), param1StrongKeyWeakValueEntry2);
    }
    
    public MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> a(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param1StrongKeyWeakValueSegment, K param1K, int param1Int, @NullableDecl MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry) {
      return new MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>(param1K, param1Int, param1StrongKeyWeakValueEntry);
    }
    
    public void a(MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> param1StrongKeyWeakValueSegment, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V> param1StrongKeyWeakValueEntry, V param1V) {
      param1StrongKeyWeakValueEntry.a(param1V, MapMakerInternalMap.StrongKeyWeakValueSegment.a(param1StrongKeyWeakValueSegment));
    }
    
    public MapMakerInternalMap.StrongKeyWeakValueSegment<K, V> b(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.StrongKeyWeakValueSegment<K, V>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
  }
  
  static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
    private final ReferenceQueue<V> h = new ReferenceQueue<V>();
    
    StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    void b() {
      b(this.h);
    }
    
    void c() {
      c(this.h);
    }
    
    StrongKeyWeakValueSegment<K, V> k() {
      return this;
    }
  }
  
  static interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {}
  
  final class ValueIterator extends HashIterator<V> {
    ValueIterator(MapMakerInternalMap this$0) {
      super(this$0);
    }
    
    public V next() {
      return e().getValue();
    }
  }
  
  final class Values extends AbstractCollection<V> {
    Values(MapMakerInternalMap this$0) {}
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean contains(Object param1Object) {
      return this.a.containsValue(param1Object);
    }
    
    public boolean isEmpty() {
      return this.a.isEmpty();
    }
    
    public Iterator<V> iterator() {
      return new MapMakerInternalMap.ValueIterator(this.a);
    }
    
    public int size() {
      return this.a.size();
    }
    
    public Object[] toArray() {
      return MapMakerInternalMap.a(this).toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])MapMakerInternalMap.a(this).toArray((Object[])param1ArrayOfT);
    }
  }
  
  static final class WeakKeyDummyValueEntry<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> {
    WeakKeyDummyValueEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @NullableDecl WeakKeyDummyValueEntry<K> param1WeakKeyDummyValueEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1WeakKeyDummyValueEntry);
    }
    
    WeakKeyDummyValueEntry<K> a(ReferenceQueue<K> param1ReferenceQueue, WeakKeyDummyValueEntry<K> param1WeakKeyDummyValueEntry) {
      return new WeakKeyDummyValueEntry(param1ReferenceQueue, a(), this.a, param1WeakKeyDummyValueEntry);
    }
    
    public MapMaker.Dummy d() {
      return MapMaker.Dummy.a;
    }
    
    static final class Helper<K> implements MapMakerInternalMap.InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, MapMakerInternalMap.WeakKeyDummyValueSegment<K>> {
      private static final Helper<?> a = new Helper();
      
      public MapMakerInternalMap.Strength a() {
        return MapMakerInternalMap.Strength.a;
      }
      
      public MapMakerInternalMap.WeakKeyDummyValueEntry<K> a(MapMakerInternalMap.WeakKeyDummyValueSegment<K> param2WeakKeyDummyValueSegment, MapMakerInternalMap.WeakKeyDummyValueEntry<K> param2WeakKeyDummyValueEntry1, @NullableDecl MapMakerInternalMap.WeakKeyDummyValueEntry<K> param2WeakKeyDummyValueEntry2) {
        return (param2WeakKeyDummyValueEntry1.a() == null) ? null : param2WeakKeyDummyValueEntry1.a(MapMakerInternalMap.WeakKeyDummyValueSegment.a(param2WeakKeyDummyValueSegment), param2WeakKeyDummyValueEntry2);
      }
      
      public MapMakerInternalMap.WeakKeyDummyValueEntry<K> a(MapMakerInternalMap.WeakKeyDummyValueSegment<K> param2WeakKeyDummyValueSegment, K param2K, int param2Int, @NullableDecl MapMakerInternalMap.WeakKeyDummyValueEntry<K> param2WeakKeyDummyValueEntry) {
        return new MapMakerInternalMap.WeakKeyDummyValueEntry<K>(MapMakerInternalMap.WeakKeyDummyValueSegment.a(param2WeakKeyDummyValueSegment), param2K, param2Int, param2WeakKeyDummyValueEntry);
      }
      
      public void a(MapMakerInternalMap.WeakKeyDummyValueSegment<K> param2WeakKeyDummyValueSegment, MapMakerInternalMap.WeakKeyDummyValueEntry<K> param2WeakKeyDummyValueEntry, MapMaker.Dummy param2Dummy) {}
      
      public MapMakerInternalMap.WeakKeyDummyValueSegment<K> b(MapMakerInternalMap<K, MapMaker.Dummy, MapMakerInternalMap.WeakKeyDummyValueEntry<K>, MapMakerInternalMap.WeakKeyDummyValueSegment<K>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.WeakKeyDummyValueSegment<K>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
    }
  }
  
  static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
    private static final Helper<?> a = new Helper();
    
    public MapMakerInternalMap.Strength a() {
      return MapMakerInternalMap.Strength.a;
    }
    
    public MapMakerInternalMap.WeakKeyDummyValueEntry<K> a(MapMakerInternalMap.WeakKeyDummyValueSegment<K> param1WeakKeyDummyValueSegment, MapMakerInternalMap.WeakKeyDummyValueEntry<K> param1WeakKeyDummyValueEntry1, @NullableDecl MapMakerInternalMap.WeakKeyDummyValueEntry<K> param1WeakKeyDummyValueEntry2) {
      return (param1WeakKeyDummyValueEntry1.a() == null) ? null : param1WeakKeyDummyValueEntry1.a(MapMakerInternalMap.WeakKeyDummyValueSegment.a(param1WeakKeyDummyValueSegment), param1WeakKeyDummyValueEntry2);
    }
    
    public MapMakerInternalMap.WeakKeyDummyValueEntry<K> a(MapMakerInternalMap.WeakKeyDummyValueSegment<K> param1WeakKeyDummyValueSegment, K param1K, int param1Int, @NullableDecl MapMakerInternalMap.WeakKeyDummyValueEntry<K> param1WeakKeyDummyValueEntry) {
      return new MapMakerInternalMap.WeakKeyDummyValueEntry<K>(MapMakerInternalMap.WeakKeyDummyValueSegment.a(param1WeakKeyDummyValueSegment), param1K, param1Int, param1WeakKeyDummyValueEntry);
    }
    
    public void a(MapMakerInternalMap.WeakKeyDummyValueSegment<K> param1WeakKeyDummyValueSegment, MapMakerInternalMap.WeakKeyDummyValueEntry<K> param1WeakKeyDummyValueEntry, MapMaker.Dummy param1Dummy) {}
    
    public MapMakerInternalMap.WeakKeyDummyValueSegment<K> b(MapMakerInternalMap<K, MapMaker.Dummy, MapMakerInternalMap.WeakKeyDummyValueEntry<K>, MapMakerInternalMap.WeakKeyDummyValueSegment<K>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.WeakKeyDummyValueSegment<K>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
  }
  
  static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
    private final ReferenceQueue<K> h = new ReferenceQueue<K>();
    
    WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, MapMakerInternalMap.WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    void b() {
      a(this.h);
    }
    
    void c() {
      c(this.h);
    }
    
    WeakKeyDummyValueSegment<K> k() {
      return this;
    }
  }
  
  static final class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {
    @NullableDecl
    private volatile V c = null;
    
    WeakKeyStrongValueEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @NullableDecl WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1WeakKeyStrongValueEntry);
    }
    
    WeakKeyStrongValueEntry<K, V> a(ReferenceQueue<K> param1ReferenceQueue, WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry) {
      WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry = new WeakKeyStrongValueEntry(param1ReferenceQueue, a(), this.a, param1WeakKeyStrongValueEntry);
      weakKeyStrongValueEntry.a(this.c);
      return weakKeyStrongValueEntry;
    }
    
    void a(V param1V) {
      this.c = param1V;
    }
    
    @NullableDecl
    public V e() {
      return this.c;
    }
    
    static final class Helper<K, V> implements MapMakerInternalMap.InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> {
      private static final Helper<?, ?> a = new Helper();
      
      static <K, V> Helper<K, V> b() {
        return (Helper)a;
      }
      
      public MapMakerInternalMap.Strength a() {
        return MapMakerInternalMap.Strength.a;
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> a(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param2WeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param2WeakKeyStrongValueEntry1, @NullableDecl MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param2WeakKeyStrongValueEntry2) {
        return (param2WeakKeyStrongValueEntry1.a() == null) ? null : param2WeakKeyStrongValueEntry1.a(MapMakerInternalMap.WeakKeyStrongValueSegment.a(param2WeakKeyStrongValueSegment), param2WeakKeyStrongValueEntry2);
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> a(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param2WeakKeyStrongValueSegment, K param2K, int param2Int, @NullableDecl MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param2WeakKeyStrongValueEntry) {
        return new MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>(MapMakerInternalMap.WeakKeyStrongValueSegment.a(param2WeakKeyStrongValueSegment), param2K, param2Int, param2WeakKeyStrongValueEntry);
      }
      
      public void a(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param2WeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param2WeakKeyStrongValueEntry, V param2V) {
        param2WeakKeyStrongValueEntry.a(param2V);
      }
      
      public MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> b(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
    }
  }
  
  static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
    private static final Helper<?, ?> a = new Helper();
    
    static <K, V> Helper<K, V> b() {
      return (Helper)a;
    }
    
    public MapMakerInternalMap.Strength a() {
      return MapMakerInternalMap.Strength.a;
    }
    
    public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> a(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param1WeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry1, @NullableDecl MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry2) {
      return (param1WeakKeyStrongValueEntry1.a() == null) ? null : param1WeakKeyStrongValueEntry1.a(MapMakerInternalMap.WeakKeyStrongValueSegment.a(param1WeakKeyStrongValueSegment), param1WeakKeyStrongValueEntry2);
    }
    
    public MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> a(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param1WeakKeyStrongValueSegment, K param1K, int param1Int, @NullableDecl MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry) {
      return new MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>(MapMakerInternalMap.WeakKeyStrongValueSegment.a(param1WeakKeyStrongValueSegment), param1K, param1Int, param1WeakKeyStrongValueEntry);
    }
    
    public void a(MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> param1WeakKeyStrongValueSegment, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V> param1WeakKeyStrongValueEntry, V param1V) {
      param1WeakKeyStrongValueEntry.a(param1V);
    }
    
    public MapMakerInternalMap.WeakKeyStrongValueSegment<K, V> b(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.WeakKeyStrongValueSegment<K, V>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
  }
  
  static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
    private final ReferenceQueue<K> h = new ReferenceQueue<K>();
    
    WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    void b() {
      a(this.h);
    }
    
    void c() {
      c(this.h);
    }
    
    WeakKeyStrongValueSegment<K, V> k() {
      return this;
    }
  }
  
  static final class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
    private volatile MapMakerInternalMap.WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> c = MapMakerInternalMap.a();
    
    WeakKeyWeakValueEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @NullableDecl WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1WeakKeyWeakValueEntry);
    }
    
    WeakKeyWeakValueEntry<K, V> a(ReferenceQueue<K> param1ReferenceQueue, ReferenceQueue<V> param1ReferenceQueue1, WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry) {
      WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry = new WeakKeyWeakValueEntry(param1ReferenceQueue, a(), this.a, param1WeakKeyWeakValueEntry);
      weakKeyWeakValueEntry.c = this.c.a(param1ReferenceQueue1, weakKeyWeakValueEntry);
      return weakKeyWeakValueEntry;
    }
    
    void a(V param1V, ReferenceQueue<V> param1ReferenceQueue) {
      MapMakerInternalMap.WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> weakValueReference = this.c;
      this.c = new MapMakerInternalMap.WeakValueReferenceImpl<K, V, WeakKeyWeakValueEntry<K, V>>(param1ReferenceQueue, param1V, this);
      weakValueReference.clear();
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> d() {
      return this.c;
    }
    
    public V e() {
      return this.c.get();
    }
    
    static final class Helper<K, V> implements MapMakerInternalMap.InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> {
      private static final Helper<?, ?> a = new Helper();
      
      static <K, V> Helper<K, V> b() {
        return (Helper)a;
      }
      
      public MapMakerInternalMap.Strength a() {
        return MapMakerInternalMap.Strength.b;
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> a(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param2WeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param2WeakKeyWeakValueEntry1, @NullableDecl MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param2WeakKeyWeakValueEntry2) {
        return (param2WeakKeyWeakValueEntry1.a() == null) ? null : (MapMakerInternalMap.Segment.a(param2WeakKeyWeakValueEntry1) ? null : param2WeakKeyWeakValueEntry1.a(MapMakerInternalMap.WeakKeyWeakValueSegment.a(param2WeakKeyWeakValueSegment), MapMakerInternalMap.WeakKeyWeakValueSegment.b(param2WeakKeyWeakValueSegment), param2WeakKeyWeakValueEntry2));
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> a(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param2WeakKeyWeakValueSegment, K param2K, int param2Int, @NullableDecl MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param2WeakKeyWeakValueEntry) {
        return new MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>(MapMakerInternalMap.WeakKeyWeakValueSegment.a(param2WeakKeyWeakValueSegment), param2K, param2Int, param2WeakKeyWeakValueEntry);
      }
      
      public void a(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param2WeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param2WeakKeyWeakValueEntry, V param2V) {
        param2WeakKeyWeakValueEntry.a(param2V, MapMakerInternalMap.WeakKeyWeakValueSegment.b(param2WeakKeyWeakValueSegment));
      }
      
      public MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> b(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> param2MapMakerInternalMap, int param2Int1, int param2Int2) {
        return new MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>(param2MapMakerInternalMap, param2Int1, param2Int2);
      }
    }
  }
  
  static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
    private static final Helper<?, ?> a = new Helper();
    
    static <K, V> Helper<K, V> b() {
      return (Helper)a;
    }
    
    public MapMakerInternalMap.Strength a() {
      return MapMakerInternalMap.Strength.b;
    }
    
    public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> a(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param1WeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry1, @NullableDecl MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry2) {
      return (param1WeakKeyWeakValueEntry1.a() == null) ? null : (MapMakerInternalMap.Segment.a(param1WeakKeyWeakValueEntry1) ? null : param1WeakKeyWeakValueEntry1.a(MapMakerInternalMap.WeakKeyWeakValueSegment.a(param1WeakKeyWeakValueSegment), MapMakerInternalMap.WeakKeyWeakValueSegment.b(param1WeakKeyWeakValueSegment), param1WeakKeyWeakValueEntry2));
    }
    
    public MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> a(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param1WeakKeyWeakValueSegment, K param1K, int param1Int, @NullableDecl MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry) {
      return new MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>(MapMakerInternalMap.WeakKeyWeakValueSegment.a(param1WeakKeyWeakValueSegment), param1K, param1Int, param1WeakKeyWeakValueEntry);
    }
    
    public void a(MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> param1WeakKeyWeakValueSegment, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V> param1WeakKeyWeakValueEntry, V param1V) {
      param1WeakKeyWeakValueEntry.a(param1V, MapMakerInternalMap.WeakKeyWeakValueSegment.b(param1WeakKeyWeakValueSegment));
    }
    
    public MapMakerInternalMap.WeakKeyWeakValueSegment<K, V> b(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      return new MapMakerInternalMap.WeakKeyWeakValueSegment<K, V>(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
  }
  
  static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
    private final ReferenceQueue<K> h = new ReferenceQueue<K>();
    
    private final ReferenceQueue<V> i = new ReferenceQueue<V>();
    
    WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, MapMakerInternalMap.WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> param1MapMakerInternalMap, int param1Int1, int param1Int2) {
      super(param1MapMakerInternalMap, param1Int1, param1Int2);
    }
    
    void b() {
      a(this.h);
      b(this.i);
    }
    
    void c() {
      c(this.h);
    }
    
    WeakKeyWeakValueSegment<K, V> k() {
      return this;
    }
  }
  
  static interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    MapMakerInternalMap.WeakValueReference<K, V, E> d();
  }
  
  static interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
    WeakValueReference<K, V, E> a(ReferenceQueue<V> param1ReferenceQueue, E param1E);
    
    E b();
    
    void clear();
    
    @NullableDecl
    V get();
  }
  
  static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
    final E a;
    
    WeakValueReferenceImpl(ReferenceQueue<V> param1ReferenceQueue, V param1V, E param1E) {
      super(param1V, param1ReferenceQueue);
      this.a = param1E;
    }
    
    public MapMakerInternalMap.WeakValueReference<K, V, E> a(ReferenceQueue<V> param1ReferenceQueue, E param1E) {
      return new WeakValueReferenceImpl(param1ReferenceQueue, get(), param1E);
    }
    
    public E b() {
      return this.a;
    }
  }
  
  final class WriteThroughEntry extends AbstractMapEntry<K, V> {
    final K a;
    
    V b;
    
    WriteThroughEntry(MapMakerInternalMap this$0, K param1K, V param1V) {
      this.a = param1K;
      this.b = param1V;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a.equals(param1Object.getKey())) {
          bool1 = bool2;
          if (this.b.equals(param1Object.getValue()))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public K getKey() {
      return this.a;
    }
    
    public V getValue() {
      return this.b;
    }
    
    public int hashCode() {
      return this.a.hashCode() ^ this.b.hashCode();
    }
    
    public V setValue(V param1V) {
      Object object = this.c.put(this.a, param1V);
      this.b = param1V;
      return (V)object;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\MapMakerInternalMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */