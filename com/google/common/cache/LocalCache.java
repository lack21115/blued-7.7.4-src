package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
  static final Logger a = Logger.getLogger(LocalCache.class.getName());
  
  static final ValueReference<Object, Object> u = new ValueReference<Object, Object>() {
      public int a() {
        return 0;
      }
      
      public LocalCache.ValueReference<Object, Object> a(ReferenceQueue<Object> param1ReferenceQueue, @NullableDecl Object param1Object, ReferenceEntry<Object, Object> param1ReferenceEntry) {
        return this;
      }
      
      public void a(Object param1Object) {}
      
      public ReferenceEntry<Object, Object> b() {
        return null;
      }
      
      public boolean c() {
        return false;
      }
      
      public boolean d() {
        return false;
      }
      
      public Object e() {
        return null;
      }
      
      public Object get() {
        return null;
      }
    };
  
  static final Queue<?> v = new AbstractQueue() {
      public Iterator<Object> iterator() {
        return (Iterator<Object>)ImmutableSet.j().av_();
      }
      
      public boolean offer(Object param1Object) {
        return true;
      }
      
      public Object peek() {
        return null;
      }
      
      public Object poll() {
        return null;
      }
      
      public int size() {
        return 0;
      }
    };
  
  final int b;
  
  final int c;
  
  final Segment<K, V>[] d;
  
  final int e;
  
  final Equivalence<Object> f;
  
  final Equivalence<Object> g;
  
  final Strength h;
  
  final Strength i;
  
  final long j;
  
  final Weigher<K, V> k;
  
  final long l;
  
  final long m;
  
  final long n;
  
  final Queue<RemovalNotification<K, V>> o;
  
  final RemovalListener<K, V> p;
  
  final Ticker q;
  
  final EntryFactory r;
  
  final AbstractCache.StatsCounter s;
  
  @NullableDecl
  final CacheLoader<? super K, V> t;
  
  @NullableDecl
  Set<K> w;
  
  @NullableDecl
  Collection<V> x;
  
  @NullableDecl
  Set<Map.Entry<K, V>> y;
  
  LocalCache(CacheBuilder<? super K, ? super V> paramCacheBuilder, @NullableDecl CacheLoader<? super K, V> paramCacheLoader) {
    Queue<?> queue;
    this.e = Math.min(paramCacheBuilder.e(), 65536);
    this.h = paramCacheBuilder.i();
    this.i = paramCacheBuilder.j();
    this.f = paramCacheBuilder.b();
    this.g = paramCacheBuilder.c();
    this.j = paramCacheBuilder.f();
    this.k = paramCacheBuilder.g();
    this.l = paramCacheBuilder.l();
    this.m = paramCacheBuilder.k();
    this.n = paramCacheBuilder.m();
    this.p = paramCacheBuilder.n();
    if (this.p == CacheBuilder.NullListener.a) {
      queue = q();
    } else {
      queue = new ConcurrentLinkedQueue();
    } 
    this.o = (Queue)queue;
    this.q = paramCacheBuilder.a(j());
    this.r = EntryFactory.a(this.h, l(), k());
    this.s = (AbstractCache.StatsCounter)paramCacheBuilder.o().get();
    this.t = paramCacheLoader;
    int j = Math.min(paramCacheBuilder.d(), 1073741824);
    int i = j;
    if (a()) {
      i = j;
      if (!b())
        i = (int)Math.min(j, this.j); 
    } 
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = true;
    j = 1;
    int k = 0;
    while (j < this.e && (!a() || (j * 20) <= this.j)) {
      k++;
      j <<= 1;
    } 
    this.c = 32 - k;
    this.b = j - 1;
    this.d = c(j);
    int n = i / j;
    k = bool3;
    int m = n;
    if (n * j < i) {
      m = n + 1;
      k = bool3;
    } 
    while (k < m)
      k <<= 1; 
    i = bool2;
    if (a()) {
      long l2 = this.j;
      long l3 = j;
      long l1 = l2 / l3 + 1L;
      i = bool1;
      while (i < this.d.length) {
        long l = l1;
        if (i == l2 % l3)
          l = l1 - 1L; 
        this.d[i] = a(k, l, (AbstractCache.StatsCounter)paramCacheBuilder.o().get());
        i++;
        l1 = l;
      } 
    } else {
      while (true) {
        Segment<K, V>[] arrayOfSegment = this.d;
        if (i < arrayOfSegment.length) {
          arrayOfSegment[i] = a(k, -1L, (AbstractCache.StatsCounter)paramCacheBuilder.o().get());
          i++;
          continue;
        } 
        break;
      } 
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
  
  static <K, V> void a(ReferenceEntry<K, V> paramReferenceEntry1, ReferenceEntry<K, V> paramReferenceEntry2) {
    paramReferenceEntry1.a(paramReferenceEntry2);
    paramReferenceEntry2.b(paramReferenceEntry1);
  }
  
  private static <E> ArrayList<E> b(Collection<E> paramCollection) {
    ArrayList<E> arrayList = new ArrayList(paramCollection.size());
    Iterators.a(arrayList, paramCollection.iterator());
    return arrayList;
  }
  
  static <K, V> void b(ReferenceEntry<K, V> paramReferenceEntry) {
    ReferenceEntry<?, ?> referenceEntry = p();
    paramReferenceEntry.a((ReferenceEntry)referenceEntry);
    paramReferenceEntry.b((ReferenceEntry)referenceEntry);
  }
  
  static <K, V> void b(ReferenceEntry<K, V> paramReferenceEntry1, ReferenceEntry<K, V> paramReferenceEntry2) {
    paramReferenceEntry1.c(paramReferenceEntry2);
    paramReferenceEntry2.d(paramReferenceEntry1);
  }
  
  static <K, V> void c(ReferenceEntry<K, V> paramReferenceEntry) {
    ReferenceEntry<?, ?> referenceEntry = p();
    paramReferenceEntry.c((ReferenceEntry)referenceEntry);
    paramReferenceEntry.d((ReferenceEntry)referenceEntry);
  }
  
  static <K, V> ValueReference<K, V> o() {
    return (ValueReference)u;
  }
  
  static <K, V> ReferenceEntry<K, V> p() {
    return NullEntry.a;
  }
  
  static <E> Queue<E> q() {
    return (Queue)v;
  }
  
  int a(@NullableDecl Object paramObject) {
    return a(this.f.a(paramObject));
  }
  
  Segment<K, V> a(int paramInt, long paramLong, AbstractCache.StatsCounter paramStatsCounter) {
    return new Segment<K, V>(this, paramInt, paramLong, paramStatsCounter);
  }
  
  @NullableDecl
  V a(ReferenceEntry<K, V> paramReferenceEntry, long paramLong) {
    if (paramReferenceEntry.d() == null)
      return null; 
    Object object = paramReferenceEntry.a().get();
    return (V)((object == null) ? null : (b(paramReferenceEntry, paramLong) ? null : object));
  }
  
  V a(K paramK, CacheLoader<? super K, V> paramCacheLoader) throws ExecutionException {
    int i = a(Preconditions.a(paramK));
    return b(i).a(paramK, i, paramCacheLoader);
  }
  
  void a(ValueReference<K, V> paramValueReference) {
    ReferenceEntry<K, V> referenceEntry = paramValueReference.b();
    int i = referenceEntry.c();
    b(i).a(referenceEntry.d(), i, paramValueReference);
  }
  
  void a(ReferenceEntry<K, V> paramReferenceEntry) {
    int i = paramReferenceEntry.c();
    b(i).a(paramReferenceEntry, i);
  }
  
  boolean a() {
    return (this.j >= 0L);
  }
  
  Segment<K, V> b(int paramInt) {
    return this.d[paramInt >>> this.c & this.b];
  }
  
  V b(K paramK) throws ExecutionException {
    return a(paramK, this.t);
  }
  
  boolean b() {
    return (this.k != CacheBuilder.OneWeigher.a);
  }
  
  boolean b(ReferenceEntry<K, V> paramReferenceEntry, long paramLong) {
    Preconditions.a(paramReferenceEntry);
    return (d() && paramLong - paramReferenceEntry.e() >= this.l) ? true : ((c() && paramLong - paramReferenceEntry.h() >= this.m));
  }
  
  boolean c() {
    return (this.m > 0L);
  }
  
  final Segment<K, V>[] c(int paramInt) {
    return (Segment<K, V>[])new Segment[paramInt];
  }
  
  public void clear() {
    Segment<K, V>[] arrayOfSegment = this.d;
    int j = arrayOfSegment.length;
    for (int i = 0; i < j; i++)
      arrayOfSegment[i].k(); 
  }
  
  public boolean containsKey(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return false; 
    int i = a(paramObject);
    return b(i).c(paramObject, i);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return false; 
    long l1 = this.q.a();
    Segment<K, V>[] arrayOfSegment = this.d;
    long l2 = -1L;
    int i = 0;
    while (i < 3) {
      int k = arrayOfSegment.length;
      long l = 0L;
      for (int j = 0; j < k; j++) {
        Segment<K, V> segment = arrayOfSegment[j];
        int m = segment.b;
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.f;
        for (m = 0; m < atomicReferenceArray.length(); m++) {
          for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(m); referenceEntry != null; referenceEntry = referenceEntry.b()) {
            V v = segment.c(referenceEntry, l1);
            if (v != null && this.g.a(paramObject, v))
              return true; 
          } 
        } 
        l += segment.d;
      } 
      if (l == l2)
        break; 
      i++;
      l2 = l;
    } 
    return false;
  }
  
  boolean d() {
    return (this.l > 0L);
  }
  
  boolean e() {
    return (this.n > 0L);
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set = this.y;
    if (set != null)
      return set; 
    set = new EntrySet(this, this);
    this.y = set;
    return set;
  }
  
  boolean f() {
    return (d() || a());
  }
  
  boolean g() {
    return c();
  }
  
  @NullableDecl
  public V get(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = a(paramObject);
    return b(i).a(paramObject, i);
  }
  
  @NullableDecl
  public V getOrDefault(@NullableDecl Object paramObject, @NullableDecl V paramV) {
    paramObject = get(paramObject);
    return (V)((paramObject != null) ? paramObject : (Object)paramV);
  }
  
  boolean h() {
    return (c() || e());
  }
  
  boolean i() {
    return d();
  }
  
  public boolean isEmpty() {
    Segment<K, V>[] arrayOfSegment = this.d;
    boolean bool = false;
    long l = 0L;
    int i;
    for (i = 0; i < arrayOfSegment.length; i++) {
      if ((arrayOfSegment[i]).b != 0)
        return false; 
      l += (arrayOfSegment[i]).d;
    } 
    if (l != 0L) {
      for (i = 0; i < arrayOfSegment.length; i++) {
        if ((arrayOfSegment[i]).b != 0)
          return false; 
        l -= (arrayOfSegment[i]).d;
      } 
      if (l == 0L)
        bool = true; 
      return bool;
    } 
    return true;
  }
  
  boolean j() {
    return (h() || i());
  }
  
  boolean k() {
    return (g() || h());
  }
  
  public Set<K> keySet() {
    Set<K> set = this.w;
    if (set != null)
      return set; 
    set = new KeySet(this, this);
    this.w = set;
    return set;
  }
  
  boolean l() {
    return (f() || i());
  }
  
  boolean m() {
    return (this.h != Strength.a);
  }
  
  boolean n() {
    return (this.i != Strength.a);
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
  
  void r() {
    while (true) {
      RemovalNotification<K, V> removalNotification = this.o.poll();
      if (removalNotification != null)
        try {
          this.p.a(removalNotification);
        } finally {
          removalNotification = null;
        }  
      break;
    } 
  }
  
  public V remove(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return null; 
    int i = a(paramObject);
    return b(i).d(paramObject, i);
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
  
  long s() {
    Segment<K, V>[] arrayOfSegment = this.d;
    long l = 0L;
    for (int i = 0; i < arrayOfSegment.length; i++)
      l += Math.max(0, (arrayOfSegment[i]).b); 
    return l;
  }
  
  public int size() {
    return Ints.b(s());
  }
  
  public Collection<V> values() {
    Collection<V> collection = this.x;
    if (collection != null)
      return collection; 
    collection = new Values(this, this);
    this.x = collection;
    return collection;
  }
  
  abstract class AbstractCacheSet<T> extends AbstractSet<T> {
    final ConcurrentMap<?, ?> a;
    
    AbstractCacheSet(LocalCache this$0, ConcurrentMap<?, ?> param1ConcurrentMap) {
      this.a = param1ConcurrentMap;
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean isEmpty() {
      return this.a.isEmpty();
    }
    
    public int size() {
      return this.a.size();
    }
    
    public Object[] toArray() {
      return LocalCache.a(this).toArray();
    }
    
    public <E> E[] toArray(E[] param1ArrayOfE) {
      return (E[])LocalCache.a(this).toArray((Object[])param1ArrayOfE);
    }
  }
  
  static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
    public LocalCache.ValueReference<K, V> a() {
      throw new UnsupportedOperationException();
    }
    
    public void a(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public void a(LocalCache.ValueReference<K, V> param1ValueReference) {
      throw new UnsupportedOperationException();
    }
    
    public void a(ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> b() {
      throw new UnsupportedOperationException();
    }
    
    public void b(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public void b(ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public int c() {
      throw new UnsupportedOperationException();
    }
    
    public void c(ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public K d() {
      throw new UnsupportedOperationException();
    }
    
    public void d(ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public long e() {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> f() {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> g() {
      throw new UnsupportedOperationException();
    }
    
    public long h() {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> i() {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> j() {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
    final ReferenceEntry<K, V> a = new LocalCache.AbstractReferenceEntry<K, V>(this) {
        ReferenceEntry<K, V> a = this;
        
        ReferenceEntry<K, V> b = this;
        
        public void a(long param2Long) {}
        
        public void a(ReferenceEntry<K, V> param2ReferenceEntry) {
          this.a = param2ReferenceEntry;
        }
        
        public void b(ReferenceEntry<K, V> param2ReferenceEntry) {
          this.b = param2ReferenceEntry;
        }
        
        public long e() {
          return Long.MAX_VALUE;
        }
        
        public ReferenceEntry<K, V> f() {
          return this.a;
        }
        
        public ReferenceEntry<K, V> g() {
          return this.b;
        }
      };
    
    public ReferenceEntry<K, V> a() {
      ReferenceEntry<K, V> referenceEntry2 = this.a.f();
      ReferenceEntry<K, V> referenceEntry1 = referenceEntry2;
      if (referenceEntry2 == this.a)
        referenceEntry1 = null; 
      return referenceEntry1;
    }
    
    public boolean a(ReferenceEntry<K, V> param1ReferenceEntry) {
      LocalCache.a(param1ReferenceEntry.g(), param1ReferenceEntry.f());
      LocalCache.a(this.a.g(), param1ReferenceEntry);
      LocalCache.a(param1ReferenceEntry, this.a);
      return true;
    }
    
    public ReferenceEntry<K, V> b() {
      ReferenceEntry<K, V> referenceEntry = this.a.f();
      if (referenceEntry == this.a)
        return null; 
      remove(referenceEntry);
      return referenceEntry;
    }
    
    public void clear() {
      ReferenceEntry<K, V> referenceEntry = this.a.f();
      while (true) {
        ReferenceEntry<K, V> referenceEntry1 = this.a;
        if (referenceEntry != referenceEntry1) {
          referenceEntry1 = referenceEntry.f();
          LocalCache.b(referenceEntry);
          referenceEntry = referenceEntry1;
          continue;
        } 
        referenceEntry1.a(referenceEntry1);
        referenceEntry = this.a;
        referenceEntry.b(referenceEntry);
        return;
      } 
    }
    
    public boolean contains(Object param1Object) {
      return (((ReferenceEntry)param1Object).f() != LocalCache.NullEntry.a);
    }
    
    public boolean isEmpty() {
      return (this.a.f() == this.a);
    }
    
    public Iterator<ReferenceEntry<K, V>> iterator() {
      return (Iterator<ReferenceEntry<K, V>>)new AbstractSequentialIterator<ReferenceEntry<K, V>>(this, a()) {
          protected ReferenceEntry<K, V> a(ReferenceEntry<K, V> param2ReferenceEntry) {
            ReferenceEntry<K, V> referenceEntry = param2ReferenceEntry.f();
            param2ReferenceEntry = referenceEntry;
            if (referenceEntry == this.a.a)
              param2ReferenceEntry = null; 
            return param2ReferenceEntry;
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      param1Object = param1Object;
      ReferenceEntry<?, ?> referenceEntry1 = param1Object.g();
      ReferenceEntry<?, ?> referenceEntry2 = param1Object.f();
      LocalCache.a(referenceEntry1, referenceEntry2);
      LocalCache.b((ReferenceEntry<?, ?>)param1Object);
      return (referenceEntry2 != LocalCache.NullEntry.a);
    }
    
    public int size() {
      ReferenceEntry<K, V> referenceEntry = this.a.f();
      int i = 0;
      while (referenceEntry != this.a) {
        i++;
        referenceEntry = referenceEntry.f();
      } 
      return i;
    }
  }
  
  class null extends AbstractReferenceEntry<K, V> {
    ReferenceEntry<K, V> a = this;
    
    ReferenceEntry<K, V> b = this;
    
    null(LocalCache this$0) {}
    
    public void a(long param1Long) {}
    
    public void a(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.a = param1ReferenceEntry;
    }
    
    public void b(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.b = param1ReferenceEntry;
    }
    
    public long e() {
      return Long.MAX_VALUE;
    }
    
    public ReferenceEntry<K, V> f() {
      return this.a;
    }
    
    public ReferenceEntry<K, V> g() {
      return this.b;
    }
  }
  
  class null extends AbstractSequentialIterator<ReferenceEntry<K, V>> {
    null(LocalCache this$0, ReferenceEntry param1ReferenceEntry) {
      super(param1ReferenceEntry);
    }
    
    protected ReferenceEntry<K, V> a(ReferenceEntry<K, V> param1ReferenceEntry) {
      ReferenceEntry<K, V> referenceEntry = param1ReferenceEntry.f();
      param1ReferenceEntry = referenceEntry;
      if (referenceEntry == this.a.a)
        param1ReferenceEntry = null; 
      return param1ReferenceEntry;
    }
  }
  
  enum EntryFactory {
    a {
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @NullableDecl ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.StrongEntry<K, V>(param2K, param2Int, param2ReferenceEntry);
      }
    },
    b {
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry1, ReferenceEntry<K, V> param2ReferenceEntry2) {
        ReferenceEntry<K, V> referenceEntry = super.a(param2Segment, param2ReferenceEntry1, param2ReferenceEntry2);
        a(param2ReferenceEntry1, referenceEntry);
        return referenceEntry;
      }
      
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @NullableDecl ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.StrongAccessEntry<K, V>(param2K, param2Int, param2ReferenceEntry);
      }
    },
    c {
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry1, ReferenceEntry<K, V> param2ReferenceEntry2) {
        ReferenceEntry<K, V> referenceEntry = super.a(param2Segment, param2ReferenceEntry1, param2ReferenceEntry2);
        b(param2ReferenceEntry1, referenceEntry);
        return referenceEntry;
      }
      
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @NullableDecl ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.StrongWriteEntry<K, V>(param2K, param2Int, param2ReferenceEntry);
      }
    },
    d {
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry1, ReferenceEntry<K, V> param2ReferenceEntry2) {
        ReferenceEntry<K, V> referenceEntry = super.a(param2Segment, param2ReferenceEntry1, param2ReferenceEntry2);
        a(param2ReferenceEntry1, referenceEntry);
        b(param2ReferenceEntry1, referenceEntry);
        return referenceEntry;
      }
      
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @NullableDecl ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.StrongAccessWriteEntry<K, V>(param2K, param2Int, param2ReferenceEntry);
      }
    },
    e {
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @NullableDecl ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.WeakEntry<K, V>(param2Segment.h, param2K, param2Int, param2ReferenceEntry);
      }
    },
    f {
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry1, ReferenceEntry<K, V> param2ReferenceEntry2) {
        ReferenceEntry<K, V> referenceEntry = super.a(param2Segment, param2ReferenceEntry1, param2ReferenceEntry2);
        a(param2ReferenceEntry1, referenceEntry);
        return referenceEntry;
      }
      
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @NullableDecl ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.WeakAccessEntry<K, V>(param2Segment.h, param2K, param2Int, param2ReferenceEntry);
      }
    },
    g {
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry1, ReferenceEntry<K, V> param2ReferenceEntry2) {
        ReferenceEntry<K, V> referenceEntry = super.a(param2Segment, param2ReferenceEntry1, param2ReferenceEntry2);
        b(param2ReferenceEntry1, referenceEntry);
        return referenceEntry;
      }
      
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @NullableDecl ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.WeakWriteEntry<K, V>(param2Segment.h, param2K, param2Int, param2ReferenceEntry);
      }
    },
    h {
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry1, ReferenceEntry<K, V> param2ReferenceEntry2) {
        ReferenceEntry<K, V> referenceEntry = super.a(param2Segment, param2ReferenceEntry1, param2ReferenceEntry2);
        a(param2ReferenceEntry1, referenceEntry);
        b(param2ReferenceEntry1, referenceEntry);
        return referenceEntry;
      }
      
      <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param2Segment, K param2K, int param2Int, @NullableDecl ReferenceEntry<K, V> param2ReferenceEntry) {
        return new LocalCache.WeakAccessWriteEntry<K, V>(param2Segment.h, param2K, param2Int, param2ReferenceEntry);
      }
    };
    
    static final EntryFactory[] i;
    
    static {
      EntryFactory entryFactory1 = a;
      EntryFactory entryFactory2 = b;
      EntryFactory entryFactory3 = c;
      EntryFactory entryFactory4 = d;
      EntryFactory entryFactory5 = e;
      EntryFactory entryFactory6 = f;
      EntryFactory entryFactory7 = g;
      EntryFactory entryFactory8 = h;
      j = new EntryFactory[] { entryFactory1, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8 };
      i = new EntryFactory[] { entryFactory1, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8 };
    }
    
    static EntryFactory a(LocalCache.Strength param1Strength, boolean param1Boolean1, boolean param1Boolean2) {
      boolean bool;
      LocalCache.Strength strength = LocalCache.Strength.c;
      byte b = 0;
      if (param1Strength == strength) {
        bool = true;
      } else {
        bool = false;
      } 
      if (param1Boolean2)
        b = 2; 
      return i[bool | param1Boolean1 | b];
    }
    
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      return a(param1Segment, param1ReferenceEntry1.d(), param1ReferenceEntry1.c(), param1ReferenceEntry2);
    }
    
    abstract <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry);
    
    <K, V> void a(ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      param1ReferenceEntry2.a(param1ReferenceEntry1.e());
      LocalCache.a(param1ReferenceEntry1.g(), param1ReferenceEntry2);
      LocalCache.a(param1ReferenceEntry2, param1ReferenceEntry1.f());
      LocalCache.b(param1ReferenceEntry1);
    }
    
    <K, V> void b(ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      param1ReferenceEntry2.b(param1ReferenceEntry1.h());
      LocalCache.b(param1ReferenceEntry1.j(), param1ReferenceEntry2);
      LocalCache.b(param1ReferenceEntry2, param1ReferenceEntry1.i());
      LocalCache.c(param1ReferenceEntry1);
    }
  }
  
  enum null {
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.StrongEntry<K, V>(param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      ReferenceEntry<K, V> referenceEntry = super.a(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      a(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.StrongAccessEntry<K, V>(param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      ReferenceEntry<K, V> referenceEntry = super.a(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      b(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.StrongWriteEntry<K, V>(param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      ReferenceEntry<K, V> referenceEntry = super.a(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      a(param1ReferenceEntry1, referenceEntry);
      b(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.StrongAccessWriteEntry<K, V>(param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.WeakEntry<K, V>(param1Segment.h, param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      ReferenceEntry<K, V> referenceEntry = super.a(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      a(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.WeakAccessEntry<K, V>(param1Segment.h, param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      ReferenceEntry<K, V> referenceEntry = super.a(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      b(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.WeakWriteEntry<K, V>(param1Segment.h, param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  enum null {
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      ReferenceEntry<K, V> referenceEntry = super.a(param1Segment, param1ReferenceEntry1, param1ReferenceEntry2);
      a(param1ReferenceEntry1, referenceEntry);
      b(param1ReferenceEntry1, referenceEntry);
      return referenceEntry;
    }
    
    <K, V> ReferenceEntry<K, V> a(LocalCache.Segment<K, V> param1Segment, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return new LocalCache.WeakAccessWriteEntry<K, V>(param1Segment.h, param1K, param1Int, param1ReferenceEntry);
    }
  }
  
  final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
    EntryIterator(LocalCache this$0) {
      super(this$0);
    }
    
    public Map.Entry<K, V> a() {
      return e();
    }
  }
  
  final class EntrySet extends AbstractCacheSet<Map.Entry<K, V>> {
    EntrySet(LocalCache this$0, ConcurrentMap<?, ?> param1ConcurrentMap) {
      super(this$0, param1ConcurrentMap);
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
      object = this.c.get(object);
      bool = bool1;
      if (object != null) {
        bool = bool1;
        if (this.c.g.a(param1Object.getValue(), object))
          bool = true; 
      } 
      return bool;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new LocalCache.EntryIterator(this.c);
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
        if (this.c.remove(object, param1Object.getValue()))
          bool = true; 
      } 
      return bool;
    }
  }
  
  abstract class HashIterator<T> implements Iterator<T> {
    int b;
    
    int c;
    
    @NullableDecl
    LocalCache.Segment<K, V> d;
    
    @NullableDecl
    AtomicReferenceArray<ReferenceEntry<K, V>> e;
    
    @NullableDecl
    ReferenceEntry<K, V> f;
    
    @NullableDecl
    LocalCache<K, V>.WriteThroughEntry g;
    
    @NullableDecl
    LocalCache<K, V>.WriteThroughEntry h;
    
    HashIterator(LocalCache this$0) {
      this.b = this$0.d.length - 1;
      this.c = -1;
      b();
    }
    
    boolean a(ReferenceEntry<K, V> param1ReferenceEntry) {
      try {
        long l = this.i.q.a();
        K k = param1ReferenceEntry.d();
        param1ReferenceEntry = this.i.a((ReferenceEntry)param1ReferenceEntry, l);
        if (param1ReferenceEntry != null) {
          this.g = new LocalCache.WriteThroughEntry(this.i, k, (V)param1ReferenceEntry);
          return true;
        } 
        return false;
      } finally {
        this.d.l();
      } 
    }
    
    final void b() {
      this.g = null;
      if (c())
        return; 
      if (d())
        return; 
      while (this.b >= 0) {
        LocalCache.Segment[] arrayOfSegment = this.i.d;
        int i = this.b;
        this.b = i - 1;
        this.d = arrayOfSegment[i];
        if (this.d.b != 0) {
          this.e = this.d.f;
          this.c = this.e.length() - 1;
          if (d())
            break; 
        } 
      } 
    }
    
    boolean c() {
      ReferenceEntry<K, V> referenceEntry = this.f;
      if (referenceEntry != null)
        while (true) {
          this.f = referenceEntry.b();
          referenceEntry = this.f;
          if (referenceEntry != null) {
            if (a(referenceEntry))
              return true; 
            referenceEntry = this.f;
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
          AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.e;
          this.c = i - 1;
          ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
          this.f = referenceEntry;
          if (referenceEntry != null) {
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
    
    LocalCache<K, V>.WriteThroughEntry e() {
      LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.g;
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
      Preconditions.b(bool);
      this.i.remove(this.h.getKey());
      this.h = null;
    }
  }
  
  final class KeyIterator extends HashIterator<K> {
    KeyIterator(LocalCache this$0) {
      super(this$0);
    }
    
    public K next() {
      return e().getKey();
    }
  }
  
  final class KeySet extends AbstractCacheSet<K> {
    KeySet(LocalCache this$0, ConcurrentMap<?, ?> param1ConcurrentMap) {
      super(this$0, param1ConcurrentMap);
    }
    
    public boolean contains(Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    public Iterator<K> iterator() {
      return new LocalCache.KeyIterator(this.c);
    }
    
    public boolean remove(Object param1Object) {
      return (this.a.remove(param1Object) != null);
    }
  }
  
  static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
    @NullableDecl
    transient LoadingCache<K, V> a;
    
    public final V f(K param1K) {
      return this.a.f(param1K);
    }
  }
  
  static class LoadingValueReference<K, V> implements ValueReference<K, V> {
    volatile LocalCache.ValueReference<K, V> a;
    
    final SettableFuture<V> b = SettableFuture.a();
    
    final Stopwatch c = Stopwatch.a();
    
    public LoadingValueReference() {
      this(LocalCache.o());
    }
    
    public LoadingValueReference(LocalCache.ValueReference<K, V> param1ValueReference) {
      this.a = param1ValueReference;
    }
    
    private ListenableFuture<V> b(Throwable param1Throwable) {
      return Futures.a(param1Throwable);
    }
    
    public int a() {
      return this.a.a();
    }
    
    public LocalCache.ValueReference<K, V> a(ReferenceQueue<V> param1ReferenceQueue, @NullableDecl V param1V, ReferenceEntry<K, V> param1ReferenceEntry) {
      return this;
    }
    
    public ListenableFuture<V> a(K param1K, CacheLoader<? super K, V> param1CacheLoader) {
      try {
        this.c.d();
        return (null == null) ? Futures.a(null) : Futures.a(null, new Function<V, V>(this) {
              public V f(V param2V) {
                this.a.b(param2V);
                return param2V;
              }
            },  MoreExecutors.a());
      } finally {
        ListenableFuture<V> listenableFuture;
        param1CacheLoader = null;
        if (a((Throwable)param1CacheLoader)) {
          SettableFuture<V> settableFuture = this.b;
        } else {
          listenableFuture = b((Throwable)param1CacheLoader);
        } 
        if (param1CacheLoader instanceof InterruptedException)
          Thread.currentThread().interrupt(); 
      } 
    }
    
    public void a(@NullableDecl V param1V) {
      if (param1V != null) {
        b(param1V);
        return;
      } 
      this.a = LocalCache.o();
    }
    
    public boolean a(Throwable param1Throwable) {
      return this.b.setException(param1Throwable);
    }
    
    public ReferenceEntry<K, V> b() {
      return null;
    }
    
    public boolean b(@NullableDecl V param1V) {
      return this.b.set(param1V);
    }
    
    public boolean c() {
      return true;
    }
    
    public boolean d() {
      return this.a.d();
    }
    
    public V e() throws ExecutionException {
      return (V)Uninterruptibles.a((Future)this.b);
    }
    
    public long f() {
      return this.c.a(TimeUnit.NANOSECONDS);
    }
    
    public LocalCache.ValueReference<K, V> g() {
      return this.a;
    }
    
    public V get() {
      return this.a.get();
    }
  }
  
  class null implements Function<V, V> {
    null(LocalCache this$0) {}
    
    public V f(V param1V) {
      this.a.b(param1V);
      return param1V;
    }
  }
  
  static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
    LocalLoadingCache(CacheBuilder<? super K, ? super V> param1CacheBuilder, CacheLoader<? super K, V> param1CacheLoader) {
      super(new LocalCache<K, V>(param1CacheBuilder, (CacheLoader<? super K, V>)Preconditions.a(param1CacheLoader)));
    }
    
    public V a(K param1K) throws ExecutionException {
      return this.a.b(param1K);
    }
    
    public V b(K param1K) {
      try {
        return a(param1K);
      } catch (ExecutionException executionException) {
        throw new UncheckedExecutionException(executionException.getCause());
      } 
    }
    
    public final V f(K param1K) {
      return b(param1K);
    }
  }
  
  static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
    final LocalCache<K, V> a;
    
    private LocalManualCache(LocalCache<K, V> param1LocalCache) {
      this.a = param1LocalCache;
    }
  }
  
  class null extends CacheLoader<Object, V> {
    public V a(Object param1Object) throws Exception {
      return this.a.call();
    }
  }
  
  static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
    @NullableDecl
    transient Cache<K, V> b;
    
    protected Cache<K, V> a() {
      return this.b;
    }
  }
  
  enum NullEntry implements ReferenceEntry<Object, Object> {
    a;
    
    public LocalCache.ValueReference<Object, Object> a() {
      return null;
    }
    
    public void a(long param1Long) {}
    
    public void a(LocalCache.ValueReference<Object, Object> param1ValueReference) {}
    
    public void a(ReferenceEntry<Object, Object> param1ReferenceEntry) {}
    
    public ReferenceEntry<Object, Object> b() {
      return null;
    }
    
    public void b(long param1Long) {}
    
    public void b(ReferenceEntry<Object, Object> param1ReferenceEntry) {}
    
    public int c() {
      return 0;
    }
    
    public void c(ReferenceEntry<Object, Object> param1ReferenceEntry) {}
    
    public Object d() {
      return null;
    }
    
    public void d(ReferenceEntry<Object, Object> param1ReferenceEntry) {}
    
    public long e() {
      return 0L;
    }
    
    public ReferenceEntry<Object, Object> f() {
      return this;
    }
    
    public ReferenceEntry<Object, Object> g() {
      return this;
    }
    
    public long h() {
      return 0L;
    }
    
    public ReferenceEntry<Object, Object> i() {
      return this;
    }
    
    public ReferenceEntry<Object, Object> j() {
      return this;
    }
  }
  
  static class Segment<K, V> extends ReentrantLock {
    final LocalCache<K, V> a;
    
    volatile int b;
    
    long c;
    
    int d;
    
    int e;
    
    @NullableDecl
    volatile AtomicReferenceArray<ReferenceEntry<K, V>> f;
    
    final long g;
    
    @NullableDecl
    final ReferenceQueue<K> h;
    
    @NullableDecl
    final ReferenceQueue<V> i;
    
    final Queue<ReferenceEntry<K, V>> j;
    
    final AtomicInteger k;
    
    final Queue<ReferenceEntry<K, V>> l;
    
    final Queue<ReferenceEntry<K, V>> m;
    
    final AbstractCache.StatsCounter n;
    
    Segment(LocalCache<K, V> param1LocalCache, int param1Int, long param1Long, AbstractCache.StatsCounter param1StatsCounter) {
      Queue<?> queue1;
      ReferenceQueue<V> referenceQueue;
      Queue<?> queue2;
      this.k = new AtomicInteger();
      this.a = param1LocalCache;
      this.g = param1Long;
      this.n = (AbstractCache.StatsCounter)Preconditions.a(param1StatsCounter);
      a(a(param1Int));
      boolean bool = param1LocalCache.m();
      AbstractCache.StatsCounter statsCounter = null;
      if (bool) {
        referenceQueue = new ReferenceQueue();
      } else {
        param1StatsCounter = null;
      } 
      this.h = (ReferenceQueue<K>)param1StatsCounter;
      param1StatsCounter = statsCounter;
      if (param1LocalCache.n())
        referenceQueue = new ReferenceQueue(); 
      this.i = referenceQueue;
      if (param1LocalCache.f()) {
        queue2 = new ConcurrentLinkedQueue();
      } else {
        queue2 = LocalCache.q();
      } 
      this.j = (Queue)queue2;
      if (param1LocalCache.g()) {
        queue2 = new LocalCache.WriteQueue<Object, Object>();
      } else {
        queue2 = LocalCache.q();
      } 
      this.l = (Queue)queue2;
      if (param1LocalCache.f()) {
        queue1 = new LocalCache.AccessQueue<Object, Object>();
      } else {
        queue1 = LocalCache.q();
      } 
      this.m = (Queue)queue1;
    }
    
    @NullableDecl
    LocalCache.LoadingValueReference<K, V> a(K param1K, int param1Int, boolean param1Boolean) {
      lock();
      try {
        LocalCache.ValueReference<?, ?> valueReference;
        long l = this.a.q.a();
        c(l);
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
        int i = atomicReferenceArray.length() - 1 & param1Int;
        ReferenceEntry<?, ?> referenceEntry2 = atomicReferenceArray.get(i);
        for (ReferenceEntry<?, ?> referenceEntry1 = referenceEntry2; referenceEntry1 != null; referenceEntry1 = referenceEntry1.b()) {
          Object object = referenceEntry1.d();
          if (referenceEntry1.c() == param1Int && object != null && this.a.f.a(param1K, object)) {
            valueReference = referenceEntry1.a();
            if (valueReference.c() || (param1Boolean && l - referenceEntry1.h() < this.a.n))
              return null; 
            this.d++;
            valueReference = new LocalCache.LoadingValueReference<Object, Object>(valueReference);
            referenceEntry1.a(valueReference);
            return (LocalCache.LoadingValueReference)valueReference;
          } 
        } 
        this.d++;
        LocalCache.LoadingValueReference<Object, Object> loadingValueReference = new LocalCache.LoadingValueReference<Object, Object>();
        ReferenceEntry<K, V> referenceEntry = a((K)valueReference, param1Int, (ReferenceEntry)referenceEntry2);
        referenceEntry.a((LocalCache.ValueReference)loadingValueReference);
        atomicReferenceArray.set(i, referenceEntry);
        return (LocalCache.LoadingValueReference)loadingValueReference;
      } finally {
        unlock();
        m();
      } 
    }
    
    ReferenceEntry<K, V> a(ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      if (param1ReferenceEntry1.d() == null)
        return null; 
      LocalCache.ValueReference<K, V> valueReference = param1ReferenceEntry1.a();
      V v = valueReference.get();
      if (v == null && valueReference.d())
        return null; 
      param1ReferenceEntry1 = this.a.r.a(this, param1ReferenceEntry1, param1ReferenceEntry2);
      param1ReferenceEntry1.a(valueReference.a(this.i, v, param1ReferenceEntry1));
      return param1ReferenceEntry1;
    }
    
    @NullableDecl
    ReferenceEntry<K, V> a(ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2, @NullableDecl K param1K, int param1Int, V param1V, LocalCache.ValueReference<K, V> param1ValueReference, RemovalCause param1RemovalCause) {
      a(param1K, param1Int, param1V, param1ValueReference.a(), param1RemovalCause);
      this.l.remove(param1ReferenceEntry2);
      this.m.remove(param1ReferenceEntry2);
      if (param1ValueReference.c()) {
        param1ValueReference.a(null);
        return param1ReferenceEntry1;
      } 
      return b(param1ReferenceEntry1, param1ReferenceEntry2);
    }
    
    @NullableDecl
    ReferenceEntry<K, V> a(Object<K, V> param1Object, int param1Int, long param1Long) {
      param1Object = (Object<K, V>)b(param1Object, param1Int);
      if (param1Object == null)
        return null; 
      if (this.a.b((ReferenceEntry<K, V>)param1Object, param1Long)) {
        a(param1Long);
        return null;
      } 
      return (ReferenceEntry<K, V>)param1Object;
    }
    
    ReferenceEntry<K, V> a(K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      return this.a.r.a(this, (K)Preconditions.a(param1K), param1Int, param1ReferenceEntry);
    }
    
    V a(ReferenceEntry<K, V> param1ReferenceEntry, K param1K, int param1Int, V param1V, long param1Long, CacheLoader<? super K, V> param1CacheLoader) {
      if (this.a.e() && param1Long - param1ReferenceEntry.h() > this.a.n && !param1ReferenceEntry.a().c()) {
        param1ReferenceEntry = (ReferenceEntry<K, V>)a(param1K, param1Int, param1CacheLoader, true);
        if (param1ReferenceEntry != null)
          return (V)param1ReferenceEntry; 
      } 
      return param1V;
    }
    
    V a(ReferenceEntry<K, V> param1ReferenceEntry, K param1K, LocalCache.ValueReference<K, V> param1ValueReference) throws ExecutionException {
      if (param1ValueReference.c()) {
        Preconditions.b(Thread.holdsLock(param1ReferenceEntry) ^ true, "Recursive load of: %s", param1K);
        try {
          param1ValueReference = (LocalCache.ValueReference<K, V>)param1ValueReference.e();
          if (param1ValueReference != null) {
            a(param1ReferenceEntry, this.a.q.a());
            return (V)param1ValueReference;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("CacheLoader returned null for key ");
          stringBuilder.append(param1K);
          stringBuilder.append(".");
          throw new CacheLoader.InvalidCacheLoadException(stringBuilder.toString());
        } finally {
          this.n.b(1);
        } 
      } 
      throw new AssertionError();
    }
    
    @NullableDecl
    V a(Object<K, V> param1Object, int param1Int) {
      try {
        if (this.b != 0) {
          long l = this.a.q.a();
          param1Object = (Object<K, V>)a(param1Object, param1Int, l);
          if (param1Object == null)
            return null; 
          Object object = param1Object.a().get();
          if (object != null) {
            a((ReferenceEntry<K, V>)param1Object, l);
            param1Object = (Object<K, V>)a((ReferenceEntry<K, V>)param1Object, param1Object.d(), param1Int, (V)object, l, this.a.t);
            return (V)param1Object;
          } 
          a();
        } 
        return null;
      } finally {
        l();
      } 
    }
    
    V a(K param1K, int param1Int, CacheLoader<? super K, V> param1CacheLoader) throws ExecutionException {
      Preconditions.a(param1K);
      Preconditions.a(param1CacheLoader);
      try {
        if (this.b != 0) {
          ReferenceEntry<K, V> referenceEntry = b(param1K, param1Int);
          if (referenceEntry != null) {
            long l = this.a.q.a();
            V v = c(referenceEntry, l);
            if (v != null) {
              a(referenceEntry, l);
              this.n.a(1);
              param1K = (K)a(referenceEntry, param1K, param1Int, v, l, param1CacheLoader);
              l();
              return (V)param1K;
            } 
            LocalCache.ValueReference<K, V> valueReference = referenceEntry.a();
            if (valueReference.c()) {
              param1K = (K)a(referenceEntry, param1K, valueReference);
              l();
              return (V)param1K;
            } 
          } 
        } 
        param1K = (K)b(param1K, param1Int, param1CacheLoader);
        l();
        return (V)param1K;
      } catch (ExecutionException executionException) {
        Throwable throwable = executionException.getCause();
        if (!(throwable instanceof Error)) {
          if (throwable instanceof RuntimeException)
            throw new UncheckedExecutionException(throwable); 
          throw executionException;
        } 
        throw new ExecutionError((Error)throwable);
      } finally {}
      l();
      throw param1K;
    }
    
    @NullableDecl
    V a(K param1K, int param1Int, CacheLoader<? super K, V> param1CacheLoader, boolean param1Boolean) {
      LocalCache.LoadingValueReference<K, V> loadingValueReference = a(param1K, param1Int, param1Boolean);
      if (loadingValueReference == null)
        return null; 
      ListenableFuture<V> listenableFuture = b(param1K, param1Int, loadingValueReference, param1CacheLoader);
      if (listenableFuture.isDone())
        try {
          return (V)Uninterruptibles.a((Future)listenableFuture);
        } finally {
          listenableFuture = null;
        }  
      return null;
    }
    
    V a(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference, CacheLoader<? super K, V> param1CacheLoader) throws ExecutionException {
      return a(param1K, param1Int, param1LoadingValueReference, param1LoadingValueReference.a(param1K, param1CacheLoader));
    }
    
    V a(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference, ListenableFuture<V> param1ListenableFuture) throws ExecutionException {
      Object object;
      try {
        object = Uninterruptibles.a((Future)param1ListenableFuture);
      } finally {
        param1ListenableFuture = null;
      } 
      if (object == null) {
        this.n.b(param1LoadingValueReference.f());
        a(param1K, param1Int, param1LoadingValueReference);
      } 
      throw param1ListenableFuture;
    }
    
    @NullableDecl
    V a(K param1K, int param1Int, V param1V) {
      lock();
      try {
        long l = this.a.q.a();
        c(l);
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
        int i = param1Int & atomicReferenceArray.length() - 1;
      } finally {
        unlock();
        m();
      } 
    }
    
    @NullableDecl
    V a(K param1K, int param1Int, V param1V, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual lock : ()V
      //   4: aload_0
      //   5: getfield a : Lcom/google/common/cache/LocalCache;
      //   8: getfield q : Lcom/google/common/base/Ticker;
      //   11: invokevirtual a : ()J
      //   14: lstore #6
      //   16: aload_0
      //   17: lload #6
      //   19: invokevirtual c : (J)V
      //   22: aload_0
      //   23: getfield b : I
      //   26: iconst_1
      //   27: iadd
      //   28: aload_0
      //   29: getfield e : I
      //   32: if_icmple -> 45
      //   35: aload_0
      //   36: invokevirtual j : ()V
      //   39: aload_0
      //   40: getfield b : I
      //   43: istore #5
      //   45: aload_0
      //   46: getfield f : Ljava/util/concurrent/atomic/AtomicReferenceArray;
      //   49: astore #10
      //   51: iload_2
      //   52: aload #10
      //   54: invokevirtual length : ()I
      //   57: iconst_1
      //   58: isub
      //   59: iand
      //   60: istore #5
      //   62: aload #10
      //   64: iload #5
      //   66: invokevirtual get : (I)Ljava/lang/Object;
      //   69: checkcast com/google/common/cache/ReferenceEntry
      //   72: astore #9
      //   74: aload #9
      //   76: astore #8
      //   78: aload #8
      //   80: ifnull -> 324
      //   83: aload #8
      //   85: invokeinterface d : ()Ljava/lang/Object;
      //   90: astore #11
      //   92: aload #8
      //   94: invokeinterface c : ()I
      //   99: iload_2
      //   100: if_icmpne -> 312
      //   103: aload #11
      //   105: ifnull -> 312
      //   108: aload_0
      //   109: getfield a : Lcom/google/common/cache/LocalCache;
      //   112: getfield f : Lcom/google/common/base/Equivalence;
      //   115: aload_1
      //   116: aload #11
      //   118: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   121: ifeq -> 312
      //   124: aload #8
      //   126: invokeinterface a : ()Lcom/google/common/cache/LocalCache$ValueReference;
      //   131: astore #9
      //   133: aload #9
      //   135: invokeinterface get : ()Ljava/lang/Object;
      //   140: astore #10
      //   142: aload #10
      //   144: ifnonnull -> 241
      //   147: aload_0
      //   148: aload_0
      //   149: getfield d : I
      //   152: iconst_1
      //   153: iadd
      //   154: putfield d : I
      //   157: aload #9
      //   159: invokeinterface d : ()Z
      //   164: ifeq -> 203
      //   167: aload_0
      //   168: aload_1
      //   169: iload_2
      //   170: aload #10
      //   172: aload #9
      //   174: invokeinterface a : ()I
      //   179: getstatic com/google/common/cache/RemovalCause.c : Lcom/google/common/cache/RemovalCause;
      //   182: invokevirtual a : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   185: aload_0
      //   186: aload #8
      //   188: aload_1
      //   189: aload_3
      //   190: lload #6
      //   192: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   195: aload_0
      //   196: getfield b : I
      //   199: istore_2
      //   200: goto -> 220
      //   203: aload_0
      //   204: aload #8
      //   206: aload_1
      //   207: aload_3
      //   208: lload #6
      //   210: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   213: aload_0
      //   214: getfield b : I
      //   217: iconst_1
      //   218: iadd
      //   219: istore_2
      //   220: aload_0
      //   221: iload_2
      //   222: putfield b : I
      //   225: aload_0
      //   226: aload #8
      //   228: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;)V
      //   231: aload_0
      //   232: invokevirtual unlock : ()V
      //   235: aload_0
      //   236: invokevirtual m : ()V
      //   239: aconst_null
      //   240: areturn
      //   241: iload #4
      //   243: ifeq -> 265
      //   246: aload_0
      //   247: aload #8
      //   249: lload #6
      //   251: invokevirtual b : (Lcom/google/common/cache/ReferenceEntry;J)V
      //   254: aload_0
      //   255: invokevirtual unlock : ()V
      //   258: aload_0
      //   259: invokevirtual m : ()V
      //   262: aload #10
      //   264: areturn
      //   265: aload_0
      //   266: aload_0
      //   267: getfield d : I
      //   270: iconst_1
      //   271: iadd
      //   272: putfield d : I
      //   275: aload_0
      //   276: aload_1
      //   277: iload_2
      //   278: aload #10
      //   280: aload #9
      //   282: invokeinterface a : ()I
      //   287: getstatic com/google/common/cache/RemovalCause.b : Lcom/google/common/cache/RemovalCause;
      //   290: invokevirtual a : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   293: aload_0
      //   294: aload #8
      //   296: aload_1
      //   297: aload_3
      //   298: lload #6
      //   300: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   303: aload_0
      //   304: aload #8
      //   306: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;)V
      //   309: goto -> 254
      //   312: aload #8
      //   314: invokeinterface b : ()Lcom/google/common/cache/ReferenceEntry;
      //   319: astore #8
      //   321: goto -> 78
      //   324: aload_0
      //   325: aload_0
      //   326: getfield d : I
      //   329: iconst_1
      //   330: iadd
      //   331: putfield d : I
      //   334: aload_0
      //   335: aload_1
      //   336: iload_2
      //   337: aload #9
      //   339: invokevirtual a : (Ljava/lang/Object;ILcom/google/common/cache/ReferenceEntry;)Lcom/google/common/cache/ReferenceEntry;
      //   342: astore #8
      //   344: aload_0
      //   345: aload #8
      //   347: aload_1
      //   348: aload_3
      //   349: lload #6
      //   351: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   354: aload #10
      //   356: iload #5
      //   358: aload #8
      //   360: invokevirtual set : (ILjava/lang/Object;)V
      //   363: aload_0
      //   364: aload_0
      //   365: getfield b : I
      //   368: iconst_1
      //   369: iadd
      //   370: putfield b : I
      //   373: aload_0
      //   374: aload #8
      //   376: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;)V
      //   379: goto -> 231
      //   382: astore_1
      //   383: aload_0
      //   384: invokevirtual unlock : ()V
      //   387: aload_0
      //   388: invokevirtual m : ()V
      //   391: aload_1
      //   392: athrow
      // Exception table:
      //   from	to	target	type
      //   4	45	382	finally
      //   45	74	382	finally
      //   83	103	382	finally
      //   108	142	382	finally
      //   147	200	382	finally
      //   203	220	382	finally
      //   220	231	382	finally
      //   246	254	382	finally
      //   265	309	382	finally
      //   312	321	382	finally
      //   324	379	382	finally
    }
    
    AtomicReferenceArray<ReferenceEntry<K, V>> a(int param1Int) {
      return new AtomicReferenceArray<ReferenceEntry<K, V>>(param1Int);
    }
    
    void a() {
      if (tryLock())
        try {
          b();
          return;
        } finally {
          unlock();
        }  
    }
    
    void a(long param1Long) {
      if (tryLock())
        try {
          b(param1Long);
          return;
        } finally {
          unlock();
        }  
    }
    
    void a(ReferenceEntry<K, V> param1ReferenceEntry) {
      if (!this.a.a())
        return; 
      h();
      if (param1ReferenceEntry.a().a() <= this.g || a(param1ReferenceEntry, param1ReferenceEntry.c(), RemovalCause.e)) {
        while (this.c > this.g) {
          param1ReferenceEntry = i();
          if (a(param1ReferenceEntry, param1ReferenceEntry.c(), RemovalCause.e))
            continue; 
          throw new AssertionError();
        } 
        return;
      } 
      throw new AssertionError();
    }
    
    void a(ReferenceEntry<K, V> param1ReferenceEntry, int param1Int, long param1Long) {
      h();
      this.c += param1Int;
      if (this.a.i())
        param1ReferenceEntry.a(param1Long); 
      if (this.a.h())
        param1ReferenceEntry.b(param1Long); 
      this.m.add(param1ReferenceEntry);
      this.l.add(param1ReferenceEntry);
    }
    
    void a(ReferenceEntry<K, V> param1ReferenceEntry, long param1Long) {
      if (this.a.i())
        param1ReferenceEntry.a(param1Long); 
      this.j.add(param1ReferenceEntry);
    }
    
    void a(ReferenceEntry<K, V> param1ReferenceEntry, K param1K, V param1V, long param1Long) {
      boolean bool;
      LocalCache.ValueReference<K, V> valueReference = param1ReferenceEntry.a();
      int i = this.a.k.a(param1K, param1V);
      if (i >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool, "Weights must be non-negative");
      param1ReferenceEntry.a(this.a.i.a(this, param1ReferenceEntry, param1V, i));
      a(param1ReferenceEntry, i, param1Long);
      valueReference.a(param1V);
    }
    
    void a(@NullableDecl K param1K, int param1Int1, @NullableDecl V param1V, int param1Int2, RemovalCause param1RemovalCause) {
      this.c -= param1Int2;
      if (param1RemovalCause.a())
        this.n.a(); 
      if (this.a.o != LocalCache.v) {
        RemovalNotification<K, V> removalNotification = RemovalNotification.a(param1K, param1V, param1RemovalCause);
        this.a.o.offer(removalNotification);
      } 
    }
    
    void a(AtomicReferenceArray<ReferenceEntry<K, V>> param1AtomicReferenceArray) {
      this.e = param1AtomicReferenceArray.length() * 3 / 4;
      if (!this.a.b()) {
        int i = this.e;
        if (i == this.g)
          this.e = i + 1; 
      } 
      this.f = param1AtomicReferenceArray;
    }
    
    boolean a(ReferenceEntry<K, V> param1ReferenceEntry, int param1Int) {
      lock();
      try {
        int i = this.b;
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
        i = atomicReferenceArray.length() - 1 & param1Int;
        ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(i);
        for (ReferenceEntry<K, V> referenceEntry1 = referenceEntry2; referenceEntry1 != null; referenceEntry1 = referenceEntry1.b()) {
          if (referenceEntry1 == param1ReferenceEntry) {
            this.d++;
            param1ReferenceEntry = a(referenceEntry2, referenceEntry1, referenceEntry1.d(), param1Int, (V)referenceEntry1.a().get(), referenceEntry1.a(), RemovalCause.c);
            param1Int = this.b;
            atomicReferenceArray.set(i, param1ReferenceEntry);
            this.b = param1Int - 1;
            return true;
          } 
        } 
        return false;
      } finally {
        unlock();
        m();
      } 
    }
    
    boolean a(ReferenceEntry<K, V> param1ReferenceEntry, int param1Int, RemovalCause param1RemovalCause) {
      int i = this.b;
      AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
      i = atomicReferenceArray.length() - 1 & param1Int;
      ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(i);
      for (ReferenceEntry<K, V> referenceEntry1 = referenceEntry2; referenceEntry1 != null; referenceEntry1 = referenceEntry1.b()) {
        if (referenceEntry1 == param1ReferenceEntry) {
          this.d++;
          param1ReferenceEntry = a(referenceEntry2, referenceEntry1, referenceEntry1.d(), param1Int, (V)referenceEntry1.a().get(), referenceEntry1.a(), param1RemovalCause);
          param1Int = this.b;
          atomicReferenceArray.set(i, param1ReferenceEntry);
          this.b = param1Int - 1;
          return true;
        } 
      } 
      return false;
    }
    
    boolean a(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference) {
      lock();
      try {
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
        int i = atomicReferenceArray.length() - 1 & param1Int;
      } finally {
        unlock();
        m();
      } 
    }
    
    boolean a(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference, V param1V) {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual lock : ()V
      //   4: aload_0
      //   5: getfield a : Lcom/google/common/cache/LocalCache;
      //   8: getfield q : Lcom/google/common/base/Ticker;
      //   11: invokevirtual a : ()J
      //   14: lstore #7
      //   16: aload_0
      //   17: lload #7
      //   19: invokevirtual c : (J)V
      //   22: aload_0
      //   23: getfield b : I
      //   26: iconst_1
      //   27: iadd
      //   28: istore #6
      //   30: iload #6
      //   32: istore #5
      //   34: iload #6
      //   36: aload_0
      //   37: getfield e : I
      //   40: if_icmple -> 55
      //   43: aload_0
      //   44: invokevirtual j : ()V
      //   47: aload_0
      //   48: getfield b : I
      //   51: iconst_1
      //   52: iadd
      //   53: istore #5
      //   55: aload_0
      //   56: getfield f : Ljava/util/concurrent/atomic/AtomicReferenceArray;
      //   59: astore #11
      //   61: iload_2
      //   62: aload #11
      //   64: invokevirtual length : ()I
      //   67: iconst_1
      //   68: isub
      //   69: iand
      //   70: istore #6
      //   72: aload #11
      //   74: iload #6
      //   76: invokevirtual get : (I)Ljava/lang/Object;
      //   79: checkcast com/google/common/cache/ReferenceEntry
      //   82: astore #10
      //   84: aload #10
      //   86: astore #9
      //   88: aload #9
      //   90: ifnull -> 300
      //   93: aload #9
      //   95: invokeinterface d : ()Ljava/lang/Object;
      //   100: astore #12
      //   102: aload #9
      //   104: invokeinterface c : ()I
      //   109: iload_2
      //   110: if_icmpne -> 288
      //   113: aload #12
      //   115: ifnull -> 288
      //   118: aload_0
      //   119: getfield a : Lcom/google/common/cache/LocalCache;
      //   122: getfield f : Lcom/google/common/base/Equivalence;
      //   125: aload_1
      //   126: aload #12
      //   128: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   131: ifeq -> 288
      //   134: aload #9
      //   136: invokeinterface a : ()Lcom/google/common/cache/LocalCache$ValueReference;
      //   141: astore #10
      //   143: aload #10
      //   145: invokeinterface get : ()Ljava/lang/Object;
      //   150: astore #11
      //   152: aload_3
      //   153: aload #10
      //   155: if_acmpeq -> 196
      //   158: aload #11
      //   160: ifnonnull -> 174
      //   163: aload #10
      //   165: getstatic com/google/common/cache/LocalCache.u : Lcom/google/common/cache/LocalCache$ValueReference;
      //   168: if_acmpeq -> 174
      //   171: goto -> 196
      //   174: aload_0
      //   175: aload_1
      //   176: iload_2
      //   177: aload #4
      //   179: iconst_0
      //   180: getstatic com/google/common/cache/RemovalCause.b : Lcom/google/common/cache/RemovalCause;
      //   183: invokevirtual a : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   186: aload_0
      //   187: invokevirtual unlock : ()V
      //   190: aload_0
      //   191: invokevirtual m : ()V
      //   194: iconst_0
      //   195: ireturn
      //   196: aload_0
      //   197: aload_0
      //   198: getfield d : I
      //   201: iconst_1
      //   202: iadd
      //   203: putfield d : I
      //   206: iload #5
      //   208: istore #6
      //   210: aload_3
      //   211: invokevirtual d : ()Z
      //   214: ifeq -> 255
      //   217: aload #11
      //   219: ifnonnull -> 230
      //   222: getstatic com/google/common/cache/RemovalCause.c : Lcom/google/common/cache/RemovalCause;
      //   225: astore #10
      //   227: goto -> 235
      //   230: getstatic com/google/common/cache/RemovalCause.b : Lcom/google/common/cache/RemovalCause;
      //   233: astore #10
      //   235: aload_0
      //   236: aload_1
      //   237: iload_2
      //   238: aload #11
      //   240: aload_3
      //   241: invokevirtual a : ()I
      //   244: aload #10
      //   246: invokevirtual a : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   249: iload #5
      //   251: iconst_1
      //   252: isub
      //   253: istore #6
      //   255: aload_0
      //   256: aload #9
      //   258: aload_1
      //   259: aload #4
      //   261: lload #7
      //   263: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   266: aload_0
      //   267: iload #6
      //   269: putfield b : I
      //   272: aload_0
      //   273: aload #9
      //   275: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;)V
      //   278: aload_0
      //   279: invokevirtual unlock : ()V
      //   282: aload_0
      //   283: invokevirtual m : ()V
      //   286: iconst_1
      //   287: ireturn
      //   288: aload #9
      //   290: invokeinterface b : ()Lcom/google/common/cache/ReferenceEntry;
      //   295: astore #9
      //   297: goto -> 88
      //   300: aload_0
      //   301: aload_0
      //   302: getfield d : I
      //   305: iconst_1
      //   306: iadd
      //   307: putfield d : I
      //   310: aload_0
      //   311: aload_1
      //   312: iload_2
      //   313: aload #10
      //   315: invokevirtual a : (Ljava/lang/Object;ILcom/google/common/cache/ReferenceEntry;)Lcom/google/common/cache/ReferenceEntry;
      //   318: astore_3
      //   319: aload_0
      //   320: aload_3
      //   321: aload_1
      //   322: aload #4
      //   324: lload #7
      //   326: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;Ljava/lang/Object;Ljava/lang/Object;J)V
      //   329: aload #11
      //   331: iload #6
      //   333: aload_3
      //   334: invokevirtual set : (ILjava/lang/Object;)V
      //   337: aload_0
      //   338: iload #5
      //   340: putfield b : I
      //   343: aload_0
      //   344: aload_3
      //   345: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;)V
      //   348: goto -> 278
      //   351: astore_1
      //   352: aload_0
      //   353: invokevirtual unlock : ()V
      //   356: aload_0
      //   357: invokevirtual m : ()V
      //   360: aload_1
      //   361: athrow
      // Exception table:
      //   from	to	target	type
      //   4	30	351	finally
      //   34	55	351	finally
      //   55	84	351	finally
      //   93	113	351	finally
      //   118	152	351	finally
      //   163	171	351	finally
      //   174	186	351	finally
      //   196	206	351	finally
      //   210	217	351	finally
      //   222	227	351	finally
      //   230	235	351	finally
      //   235	249	351	finally
      //   255	278	351	finally
      //   288	297	351	finally
      //   300	348	351	finally
    }
    
    boolean a(K param1K, int param1Int, LocalCache.ValueReference<K, V> param1ValueReference) {
      lock();
      try {
        int i = this.b;
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
        i = atomicReferenceArray.length() - 1 & param1Int;
        ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(i);
        for (ReferenceEntry<K, V> referenceEntry1 = referenceEntry2; referenceEntry1 != null; referenceEntry1 = referenceEntry1.b()) {
          Object object = referenceEntry1.d();
          if (referenceEntry1.c() == param1Int && object != null && this.a.f.a(param1K, object)) {
            if (referenceEntry1.a() == param1ValueReference) {
              this.d++;
              ReferenceEntry<K, V> referenceEntry = a(referenceEntry2, referenceEntry1, (K)object, param1Int, param1ValueReference.get(), param1ValueReference, RemovalCause.c);
              param1Int = this.b;
              atomicReferenceArray.set(i, referenceEntry);
              this.b = param1Int - 1;
              return true;
            } 
            return false;
          } 
        } 
        return false;
      } finally {
        unlock();
        if (!isHeldByCurrentThread())
          m(); 
      } 
    }
    
    boolean a(K param1K, int param1Int, V param1V1, V param1V2) {
      lock();
      try {
        long l = this.a.q.a();
        c(l);
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
        int i = param1Int & atomicReferenceArray.length() - 1;
      } finally {
        unlock();
        m();
      } 
    }
    
    ReferenceEntry<K, V> b(int param1Int) {
      AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
      return atomicReferenceArray.get(param1Int & atomicReferenceArray.length() - 1);
    }
    
    @NullableDecl
    ReferenceEntry<K, V> b(ReferenceEntry<K, V> param1ReferenceEntry1, ReferenceEntry<K, V> param1ReferenceEntry2) {
      int i = this.b;
      ReferenceEntry<K, V> referenceEntry = param1ReferenceEntry2.b();
      while (param1ReferenceEntry1 != param1ReferenceEntry2) {
        ReferenceEntry<K, V> referenceEntry1 = a(param1ReferenceEntry1, referenceEntry);
        if (referenceEntry1 != null) {
          referenceEntry = referenceEntry1;
        } else {
          b(param1ReferenceEntry1);
          i--;
        } 
        param1ReferenceEntry1 = param1ReferenceEntry1.b();
      } 
      this.b = i;
      return referenceEntry;
    }
    
    @NullableDecl
    ReferenceEntry<K, V> b(Object param1Object, int param1Int) {
      for (ReferenceEntry<K, V> referenceEntry = b(param1Int); referenceEntry != null; referenceEntry = referenceEntry.b()) {
        if (referenceEntry.c() == param1Int) {
          K k = referenceEntry.d();
          if (k == null) {
            a();
          } else if (this.a.f.a(param1Object, k)) {
            return referenceEntry;
          } 
        } 
      } 
      return null;
    }
    
    ListenableFuture<V> b(K param1K, int param1Int, LocalCache.LoadingValueReference<K, V> param1LoadingValueReference, CacheLoader<? super K, V> param1CacheLoader) {
      ListenableFuture<V> listenableFuture = param1LoadingValueReference.a(param1K, param1CacheLoader);
      listenableFuture.addListener(new Runnable(this, param1K, param1Int, param1LoadingValueReference, listenableFuture) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                LocalCache.a.log(Level.WARNING, "Exception thrown during refresh", exception);
                this.c.a(exception);
              } 
            }
          }MoreExecutors.a());
      return listenableFuture;
    }
    
    V b(K param1K, int param1Int, CacheLoader<? super K, V> param1CacheLoader) throws ExecutionException {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual lock : ()V
      //   4: aload_0
      //   5: getfield a : Lcom/google/common/cache/LocalCache;
      //   8: getfield q : Lcom/google/common/base/Ticker;
      //   11: invokevirtual a : ()J
      //   14: lstore #6
      //   16: aload_0
      //   17: lload #6
      //   19: invokevirtual c : (J)V
      //   22: aload_0
      //   23: getfield b : I
      //   26: istore #4
      //   28: aload_0
      //   29: getfield f : Ljava/util/concurrent/atomic/AtomicReferenceArray;
      //   32: astore #13
      //   34: iload_2
      //   35: aload #13
      //   37: invokevirtual length : ()I
      //   40: iconst_1
      //   41: isub
      //   42: iand
      //   43: istore #5
      //   45: aload #13
      //   47: iload #5
      //   49: invokevirtual get : (I)Ljava/lang/Object;
      //   52: checkcast com/google/common/cache/ReferenceEntry
      //   55: astore #12
      //   57: aload #12
      //   59: astore #8
      //   61: aconst_null
      //   62: astore #11
      //   64: aload #8
      //   66: ifnull -> 432
      //   69: aload #8
      //   71: invokeinterface d : ()Ljava/lang/Object;
      //   76: astore #10
      //   78: aload #8
      //   80: invokeinterface c : ()I
      //   85: iload_2
      //   86: if_icmpne -> 272
      //   89: aload #10
      //   91: ifnull -> 272
      //   94: aload_0
      //   95: getfield a : Lcom/google/common/cache/LocalCache;
      //   98: getfield f : Lcom/google/common/base/Equivalence;
      //   101: aload_1
      //   102: aload #10
      //   104: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Z
      //   107: ifeq -> 272
      //   110: aload #8
      //   112: invokeinterface a : ()Lcom/google/common/cache/LocalCache$ValueReference;
      //   117: astore #9
      //   119: aload #9
      //   121: invokeinterface c : ()Z
      //   126: ifeq -> 139
      //   129: iconst_0
      //   130: istore #4
      //   132: aload #9
      //   134: astore #10
      //   136: goto -> 284
      //   139: aload #9
      //   141: invokeinterface get : ()Ljava/lang/Object;
      //   146: astore #14
      //   148: aload #14
      //   150: ifnonnull -> 175
      //   153: aload_0
      //   154: aload #10
      //   156: iload_2
      //   157: aload #14
      //   159: aload #9
      //   161: invokeinterface a : ()I
      //   166: getstatic com/google/common/cache/RemovalCause.c : Lcom/google/common/cache/RemovalCause;
      //   169: invokevirtual a : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   172: goto -> 208
      //   175: aload_0
      //   176: getfield a : Lcom/google/common/cache/LocalCache;
      //   179: aload #8
      //   181: lload #6
      //   183: invokevirtual b : (Lcom/google/common/cache/ReferenceEntry;J)Z
      //   186: ifeq -> 243
      //   189: aload_0
      //   190: aload #10
      //   192: iload_2
      //   193: aload #14
      //   195: aload #9
      //   197: invokeinterface a : ()I
      //   202: getstatic com/google/common/cache/RemovalCause.d : Lcom/google/common/cache/RemovalCause;
      //   205: invokevirtual a : (Ljava/lang/Object;ILjava/lang/Object;ILcom/google/common/cache/RemovalCause;)V
      //   208: aload_0
      //   209: getfield l : Ljava/util/Queue;
      //   212: aload #8
      //   214: invokeinterface remove : (Ljava/lang/Object;)Z
      //   219: pop
      //   220: aload_0
      //   221: getfield m : Ljava/util/Queue;
      //   224: aload #8
      //   226: invokeinterface remove : (Ljava/lang/Object;)Z
      //   231: pop
      //   232: aload_0
      //   233: iload #4
      //   235: iconst_1
      //   236: isub
      //   237: putfield b : I
      //   240: goto -> 435
      //   243: aload_0
      //   244: aload #8
      //   246: lload #6
      //   248: invokevirtual b : (Lcom/google/common/cache/ReferenceEntry;J)V
      //   251: aload_0
      //   252: getfield n : Lcom/google/common/cache/AbstractCache$StatsCounter;
      //   255: iconst_1
      //   256: invokeinterface a : (I)V
      //   261: aload_0
      //   262: invokevirtual unlock : ()V
      //   265: aload_0
      //   266: invokevirtual m : ()V
      //   269: aload #14
      //   271: areturn
      //   272: aload #8
      //   274: invokeinterface b : ()Lcom/google/common/cache/ReferenceEntry;
      //   279: astore #8
      //   281: goto -> 61
      //   284: aload #8
      //   286: astore #9
      //   288: iload #4
      //   290: ifeq -> 351
      //   293: new com/google/common/cache/LocalCache$LoadingValueReference
      //   296: dup
      //   297: invokespecial <init> : ()V
      //   300: astore #11
      //   302: aload #8
      //   304: ifnonnull -> 338
      //   307: aload_0
      //   308: aload_1
      //   309: iload_2
      //   310: aload #12
      //   312: invokevirtual a : (Ljava/lang/Object;ILcom/google/common/cache/ReferenceEntry;)Lcom/google/common/cache/ReferenceEntry;
      //   315: astore #9
      //   317: aload #9
      //   319: aload #11
      //   321: invokeinterface a : (Lcom/google/common/cache/LocalCache$ValueReference;)V
      //   326: aload #13
      //   328: iload #5
      //   330: aload #9
      //   332: invokevirtual set : (ILjava/lang/Object;)V
      //   335: goto -> 351
      //   338: aload #8
      //   340: aload #11
      //   342: invokeinterface a : (Lcom/google/common/cache/LocalCache$ValueReference;)V
      //   347: aload #8
      //   349: astore #9
      //   351: aload_0
      //   352: invokevirtual unlock : ()V
      //   355: aload_0
      //   356: invokevirtual m : ()V
      //   359: iload #4
      //   361: ifeq -> 411
      //   364: aload #9
      //   366: monitorenter
      //   367: aload_0
      //   368: aload_1
      //   369: iload_2
      //   370: aload #11
      //   372: aload_3
      //   373: invokevirtual a : (Ljava/lang/Object;ILcom/google/common/cache/LocalCache$LoadingValueReference;Lcom/google/common/cache/CacheLoader;)Ljava/lang/Object;
      //   376: astore_1
      //   377: aload #9
      //   379: monitorexit
      //   380: aload_0
      //   381: getfield n : Lcom/google/common/cache/AbstractCache$StatsCounter;
      //   384: iconst_1
      //   385: invokeinterface b : (I)V
      //   390: aload_1
      //   391: areturn
      //   392: astore_1
      //   393: aload #9
      //   395: monitorexit
      //   396: aload_1
      //   397: athrow
      //   398: astore_1
      //   399: aload_0
      //   400: getfield n : Lcom/google/common/cache/AbstractCache$StatsCounter;
      //   403: iconst_1
      //   404: invokeinterface b : (I)V
      //   409: aload_1
      //   410: athrow
      //   411: aload_0
      //   412: aload #9
      //   414: aload_1
      //   415: aload #10
      //   417: invokevirtual a : (Lcom/google/common/cache/ReferenceEntry;Ljava/lang/Object;Lcom/google/common/cache/LocalCache$ValueReference;)Ljava/lang/Object;
      //   420: areturn
      //   421: astore_1
      //   422: aload_0
      //   423: invokevirtual unlock : ()V
      //   426: aload_0
      //   427: invokevirtual m : ()V
      //   430: aload_1
      //   431: athrow
      //   432: aconst_null
      //   433: astore #9
      //   435: iconst_1
      //   436: istore #4
      //   438: aload #9
      //   440: astore #10
      //   442: goto -> 284
      // Exception table:
      //   from	to	target	type
      //   4	57	421	finally
      //   69	89	421	finally
      //   94	129	421	finally
      //   139	148	421	finally
      //   153	172	421	finally
      //   175	208	421	finally
      //   208	240	421	finally
      //   243	261	421	finally
      //   272	281	421	finally
      //   293	302	421	finally
      //   307	335	421	finally
      //   338	347	421	finally
      //   364	367	398	finally
      //   367	380	392	finally
      //   393	396	392	finally
      //   396	398	398	finally
    }
    
    void b() {
      if (this.a.m())
        c(); 
      if (this.a.n())
        d(); 
    }
    
    void b(long param1Long) {
      h();
      while (true) {
        ReferenceEntry<K, V> referenceEntry = this.l.peek();
        if (referenceEntry != null && this.a.b(referenceEntry, param1Long)) {
          if (a(referenceEntry, referenceEntry.c(), RemovalCause.d))
            continue; 
          throw new AssertionError();
        } 
        break;
      } 
      while (true) {
        ReferenceEntry<K, V> referenceEntry = this.m.peek();
        if (referenceEntry != null && this.a.b(referenceEntry, param1Long)) {
          if (a(referenceEntry, referenceEntry.c(), RemovalCause.d))
            continue; 
          throw new AssertionError();
        } 
        break;
      } 
    }
    
    void b(ReferenceEntry<K, V> param1ReferenceEntry) {
      a(param1ReferenceEntry.d(), param1ReferenceEntry.c(), (V)param1ReferenceEntry.a().get(), param1ReferenceEntry.a().a(), RemovalCause.c);
      this.l.remove(param1ReferenceEntry);
      this.m.remove(param1ReferenceEntry);
    }
    
    void b(ReferenceEntry<K, V> param1ReferenceEntry, long param1Long) {
      if (this.a.i())
        param1ReferenceEntry.a(param1Long); 
      this.m.add(param1ReferenceEntry);
    }
    
    boolean b(Object param1Object1, int param1Int, Object<K, V> param1Object2) {
      lock();
      try {
        c(this.a.q.a());
        int i = this.b;
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
        i = atomicReferenceArray.length();
        boolean bool = true;
        i = i - 1 & param1Int;
      } finally {
        unlock();
        m();
      } 
    }
    
    V c(ReferenceEntry<K, V> param1ReferenceEntry, long param1Long) {
      if (param1ReferenceEntry.d() == null) {
        a();
        return null;
      } 
      Object object = param1ReferenceEntry.a().get();
      if (object == null) {
        a();
        return null;
      } 
      if (this.a.b(param1ReferenceEntry, param1Long)) {
        a(param1Long);
        return null;
      } 
      return (V)object;
    }
    
    void c() {
      int i = 0;
      while (true) {
        Reference<? extends K> reference = this.h.poll();
        if (reference != null) {
          ReferenceEntry<K, V> referenceEntry = (ReferenceEntry)reference;
          this.a.a(referenceEntry);
          int j = i + 1;
          i = j;
          if (j == 16)
            break; 
          continue;
        } 
        break;
      } 
    }
    
    void c(long param1Long) {
      d(param1Long);
    }
    
    boolean c(Object<K, V> param1Object, int param1Int) {
      try {
        int i = this.b;
        boolean bool = false;
        if (i != 0) {
          param1Object = (Object<K, V>)a(param1Object, param1Int, this.a.q.a());
          if (param1Object == null)
            return false; 
          param1Object = (Object<K, V>)param1Object.a().get();
          if (param1Object != null)
            bool = true; 
          return bool;
        } 
        return false;
      } finally {
        l();
      } 
    }
    
    @NullableDecl
    V d(Object<K, V> param1Object, int param1Int) {
      lock();
      try {
        c(this.a.q.a());
        int i = this.b;
        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
        i = atomicReferenceArray.length() - 1 & param1Int;
      } finally {
        unlock();
        m();
      } 
    }
    
    void d() {
      int i = 0;
      while (true) {
        Reference<? extends V> reference = this.i.poll();
        if (reference != null) {
          LocalCache.ValueReference<K, V> valueReference = (LocalCache.ValueReference)reference;
          this.a.a(valueReference);
          int j = i + 1;
          i = j;
          if (j == 16)
            break; 
          continue;
        } 
        break;
      } 
    }
    
    void d(long param1Long) {
      if (tryLock())
        try {
          b();
          b(param1Long);
          this.k.set(0);
          return;
        } finally {
          unlock();
        }  
    }
    
    void e() {
      if (this.a.m())
        f(); 
      if (this.a.n())
        g(); 
    }
    
    void f() {
      while (this.h.poll() != null);
    }
    
    void g() {
      while (this.i.poll() != null);
    }
    
    void h() {
      while (true) {
        ReferenceEntry<K, V> referenceEntry = this.j.poll();
        if (referenceEntry != null) {
          if (this.m.contains(referenceEntry))
            this.m.add(referenceEntry); 
          continue;
        } 
        break;
      } 
    }
    
    ReferenceEntry<K, V> i() {
      for (ReferenceEntry<K, V> referenceEntry : this.m) {
        if (referenceEntry.a().a() > 0)
          return referenceEntry; 
      } 
      throw new AssertionError();
    }
    
    void j() {
      AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray1 = this.f;
      int k = atomicReferenceArray1.length();
      if (k >= 1073741824)
        return; 
      int i = this.b;
      AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray2 = a(k << 1);
      this.e = atomicReferenceArray2.length() * 3 / 4;
      int m = atomicReferenceArray2.length() - 1;
      int j = 0;
      while (j < k) {
        ReferenceEntry<K, V> referenceEntry = atomicReferenceArray1.get(j);
        int n = i;
        if (referenceEntry != null) {
          ReferenceEntry<K, V> referenceEntry1 = referenceEntry.b();
          n = referenceEntry.c() & m;
          if (referenceEntry1 == null) {
            atomicReferenceArray2.set(n, referenceEntry);
            n = i;
          } else {
            ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
            while (referenceEntry1 != null) {
              int i2 = referenceEntry1.c() & m;
              int i1 = n;
              if (i2 != n) {
                referenceEntry2 = referenceEntry1;
                i1 = i2;
              } 
              referenceEntry1 = referenceEntry1.b();
              n = i1;
            } 
            atomicReferenceArray2.set(n, referenceEntry2);
            while (true) {
              n = i;
              if (referenceEntry != referenceEntry2) {
                n = referenceEntry.c() & m;
                referenceEntry1 = a(referenceEntry, atomicReferenceArray2.get(n));
                if (referenceEntry1 != null) {
                  atomicReferenceArray2.set(n, referenceEntry1);
                } else {
                  b(referenceEntry);
                  i--;
                } 
                referenceEntry = referenceEntry.b();
                continue;
              } 
              break;
            } 
          } 
        } 
        j++;
        i = n;
      } 
      this.f = atomicReferenceArray2;
      this.b = i;
    }
    
    void k() {
      AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray;
      if (this.b != 0) {
        lock();
        try {
          int j;
          c(this.a.q.a());
        } finally {
          unlock();
          m();
        } 
      } else {
        return;
      } 
      int i;
      for (i = 0; i < atomicReferenceArray.length(); i++)
        atomicReferenceArray.set(i, null); 
      e();
      this.l.clear();
      this.m.clear();
      this.k.set(0);
      this.d++;
      this.b = 0;
      unlock();
      m();
    }
    
    void l() {
      if ((this.k.incrementAndGet() & 0x3F) == 0)
        n(); 
    }
    
    void m() {
      o();
    }
    
    void n() {
      d(this.a.q.a());
      o();
    }
    
    void o() {
      if (!isHeldByCurrentThread())
        this.a.r(); 
    }
  }
  
  class null implements Runnable {
    null(LocalCache this$0, Object param1Object, int param1Int, LocalCache.LoadingValueReference param1LoadingValueReference, ListenableFuture param1ListenableFuture) {}
    
    public void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        LocalCache.a.log(Level.WARNING, "Exception thrown during refresh", exception);
        this.c.a(exception);
      } 
    }
  }
  
  static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
    final ReferenceEntry<K, V> a;
    
    SoftValueReference(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1V, param1ReferenceQueue);
      this.a = param1ReferenceEntry;
    }
    
    public int a() {
      return 1;
    }
    
    public LocalCache.ValueReference<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry) {
      return new SoftValueReference(param1ReferenceQueue, param1V, param1ReferenceEntry);
    }
    
    public void a(V param1V) {}
    
    public ReferenceEntry<K, V> b() {
      return this.a;
    }
    
    public boolean c() {
      return false;
    }
    
    public boolean d() {
      return true;
    }
    
    public V e() {
      return get();
    }
  }
  
  enum Strength {
    a {
      Equivalence<Object> a() {
        return Equivalence.a();
      }
      
      <K, V> LocalCache.ValueReference<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry, V param2V, int param2Int) {
        return (param2Int == 1) ? new LocalCache.StrongValueReference<K, V>(param2V) : new LocalCache.WeightedStrongValueReference<K, V>(param2V, param2Int);
      }
    },
    b {
      Equivalence<Object> a() {
        return Equivalence.b();
      }
      
      <K, V> LocalCache.ValueReference<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry, V param2V, int param2Int) {
        return (param2Int == 1) ? new LocalCache.SoftValueReference<K, V>(param2Segment.i, param2V, param2ReferenceEntry) : new LocalCache.WeightedSoftValueReference<K, V>(param2Segment.i, param2V, param2ReferenceEntry, param2Int);
      }
    },
    c {
      Equivalence<Object> a() {
        return Equivalence.b();
      }
      
      <K, V> LocalCache.ValueReference<K, V> a(LocalCache.Segment<K, V> param2Segment, ReferenceEntry<K, V> param2ReferenceEntry, V param2V, int param2Int) {
        return (param2Int == 1) ? new LocalCache.WeakValueReference<K, V>(param2Segment.i, param2V, param2ReferenceEntry) : new LocalCache.WeightedWeakValueReference<K, V>(param2Segment.i, param2V, param2ReferenceEntry, param2Int);
      }
    };
    
    abstract Equivalence<Object> a();
    
    abstract <K, V> LocalCache.ValueReference<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry, V param1V, int param1Int);
  }
  
  enum null {
    Equivalence<Object> a() {
      return Equivalence.a();
    }
    
    <K, V> LocalCache.ValueReference<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry, V param1V, int param1Int) {
      return (param1Int == 1) ? new LocalCache.StrongValueReference<K, V>(param1V) : new LocalCache.WeightedStrongValueReference<K, V>(param1V, param1Int);
    }
  }
  
  enum null {
    Equivalence<Object> a() {
      return Equivalence.b();
    }
    
    <K, V> LocalCache.ValueReference<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry, V param1V, int param1Int) {
      return (param1Int == 1) ? new LocalCache.SoftValueReference<K, V>(param1Segment.i, param1V, param1ReferenceEntry) : new LocalCache.WeightedSoftValueReference<K, V>(param1Segment.i, param1V, param1ReferenceEntry, param1Int);
    }
  }
  
  enum null {
    Equivalence<Object> a() {
      return Equivalence.b();
    }
    
    <K, V> LocalCache.ValueReference<K, V> a(LocalCache.Segment<K, V> param1Segment, ReferenceEntry<K, V> param1ReferenceEntry, V param1V, int param1Int) {
      return (param1Int == 1) ? new LocalCache.WeakValueReference<K, V>(param1Segment.i, param1V, param1ReferenceEntry) : new LocalCache.WeightedWeakValueReference<K, V>(param1Segment.i, param1V, param1ReferenceEntry, param1Int);
    }
  }
  
  static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
    volatile long a = Long.MAX_VALUE;
    
    ReferenceEntry<K, V> b = LocalCache.p();
    
    ReferenceEntry<K, V> c = LocalCache.p();
    
    StrongAccessEntry(K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1K, param1Int, param1ReferenceEntry);
    }
    
    public void a(long param1Long) {
      this.a = param1Long;
    }
    
    public void a(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.b = param1ReferenceEntry;
    }
    
    public void b(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.c = param1ReferenceEntry;
    }
    
    public long e() {
      return this.a;
    }
    
    public ReferenceEntry<K, V> f() {
      return this.b;
    }
    
    public ReferenceEntry<K, V> g() {
      return this.c;
    }
  }
  
  static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
    volatile long a = Long.MAX_VALUE;
    
    ReferenceEntry<K, V> b = LocalCache.p();
    
    ReferenceEntry<K, V> c = LocalCache.p();
    
    volatile long d = Long.MAX_VALUE;
    
    ReferenceEntry<K, V> e = LocalCache.p();
    
    ReferenceEntry<K, V> f = LocalCache.p();
    
    StrongAccessWriteEntry(K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1K, param1Int, param1ReferenceEntry);
    }
    
    public void a(long param1Long) {
      this.a = param1Long;
    }
    
    public void a(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.b = param1ReferenceEntry;
    }
    
    public void b(long param1Long) {
      this.d = param1Long;
    }
    
    public void b(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.c = param1ReferenceEntry;
    }
    
    public void c(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.e = param1ReferenceEntry;
    }
    
    public void d(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.f = param1ReferenceEntry;
    }
    
    public long e() {
      return this.a;
    }
    
    public ReferenceEntry<K, V> f() {
      return this.b;
    }
    
    public ReferenceEntry<K, V> g() {
      return this.c;
    }
    
    public long h() {
      return this.d;
    }
    
    public ReferenceEntry<K, V> i() {
      return this.e;
    }
    
    public ReferenceEntry<K, V> j() {
      return this.f;
    }
  }
  
  static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
    final K g;
    
    final int h;
    
    @NullableDecl
    final ReferenceEntry<K, V> i;
    
    volatile LocalCache.ValueReference<K, V> j = LocalCache.o();
    
    StrongEntry(K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      this.g = param1K;
      this.h = param1Int;
      this.i = param1ReferenceEntry;
    }
    
    public LocalCache.ValueReference<K, V> a() {
      return this.j;
    }
    
    public void a(LocalCache.ValueReference<K, V> param1ValueReference) {
      this.j = param1ValueReference;
    }
    
    public ReferenceEntry<K, V> b() {
      return this.i;
    }
    
    public int c() {
      return this.h;
    }
    
    public K d() {
      return this.g;
    }
  }
  
  static class StrongValueReference<K, V> implements ValueReference<K, V> {
    final V a;
    
    StrongValueReference(V param1V) {
      this.a = param1V;
    }
    
    public int a() {
      return 1;
    }
    
    public LocalCache.ValueReference<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry) {
      return this;
    }
    
    public void a(V param1V) {}
    
    public ReferenceEntry<K, V> b() {
      return null;
    }
    
    public boolean c() {
      return false;
    }
    
    public boolean d() {
      return true;
    }
    
    public V e() {
      return get();
    }
    
    public V get() {
      return this.a;
    }
  }
  
  static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
    volatile long a = Long.MAX_VALUE;
    
    ReferenceEntry<K, V> b = LocalCache.p();
    
    ReferenceEntry<K, V> c = LocalCache.p();
    
    StrongWriteEntry(K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1K, param1Int, param1ReferenceEntry);
    }
    
    public void b(long param1Long) {
      this.a = param1Long;
    }
    
    public void c(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.b = param1ReferenceEntry;
    }
    
    public void d(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.c = param1ReferenceEntry;
    }
    
    public long h() {
      return this.a;
    }
    
    public ReferenceEntry<K, V> i() {
      return this.b;
    }
    
    public ReferenceEntry<K, V> j() {
      return this.c;
    }
  }
  
  final class ValueIterator extends HashIterator<V> {
    ValueIterator(LocalCache this$0) {
      super(this$0);
    }
    
    public V next() {
      return e().getValue();
    }
  }
  
  static interface ValueReference<K, V> {
    int a();
    
    ValueReference<K, V> a(ReferenceQueue<V> param1ReferenceQueue, @NullableDecl V param1V, ReferenceEntry<K, V> param1ReferenceEntry);
    
    void a(@NullableDecl V param1V);
    
    @NullableDecl
    ReferenceEntry<K, V> b();
    
    boolean c();
    
    boolean d();
    
    V e() throws ExecutionException;
    
    @NullableDecl
    V get();
  }
  
  final class Values extends AbstractCollection<V> {
    private final ConcurrentMap<?, ?> b;
    
    Values(LocalCache this$0, ConcurrentMap<?, ?> param1ConcurrentMap) {
      this.b = param1ConcurrentMap;
    }
    
    public void clear() {
      this.b.clear();
    }
    
    public boolean contains(Object param1Object) {
      return this.b.containsValue(param1Object);
    }
    
    public boolean isEmpty() {
      return this.b.isEmpty();
    }
    
    public Iterator<V> iterator() {
      return new LocalCache.ValueIterator(this.a);
    }
    
    public int size() {
      return this.b.size();
    }
    
    public Object[] toArray() {
      return LocalCache.a(this).toArray();
    }
    
    public <E> E[] toArray(E[] param1ArrayOfE) {
      return (E[])LocalCache.a(this).toArray((Object[])param1ArrayOfE);
    }
  }
  
  static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
    volatile long a = Long.MAX_VALUE;
    
    ReferenceEntry<K, V> b = LocalCache.p();
    
    ReferenceEntry<K, V> c = LocalCache.p();
    
    WeakAccessEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
    
    public void a(long param1Long) {
      this.a = param1Long;
    }
    
    public void a(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.b = param1ReferenceEntry;
    }
    
    public void b(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.c = param1ReferenceEntry;
    }
    
    public long e() {
      return this.a;
    }
    
    public ReferenceEntry<K, V> f() {
      return this.b;
    }
    
    public ReferenceEntry<K, V> g() {
      return this.c;
    }
  }
  
  static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
    volatile long a = Long.MAX_VALUE;
    
    ReferenceEntry<K, V> b = LocalCache.p();
    
    ReferenceEntry<K, V> c = LocalCache.p();
    
    volatile long d = Long.MAX_VALUE;
    
    ReferenceEntry<K, V> e = LocalCache.p();
    
    ReferenceEntry<K, V> f = LocalCache.p();
    
    WeakAccessWriteEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
    
    public void a(long param1Long) {
      this.a = param1Long;
    }
    
    public void a(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.b = param1ReferenceEntry;
    }
    
    public void b(long param1Long) {
      this.d = param1Long;
    }
    
    public void b(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.c = param1ReferenceEntry;
    }
    
    public void c(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.e = param1ReferenceEntry;
    }
    
    public void d(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.f = param1ReferenceEntry;
    }
    
    public long e() {
      return this.a;
    }
    
    public ReferenceEntry<K, V> f() {
      return this.b;
    }
    
    public ReferenceEntry<K, V> g() {
      return this.c;
    }
    
    public long h() {
      return this.d;
    }
    
    public ReferenceEntry<K, V> i() {
      return this.e;
    }
    
    public ReferenceEntry<K, V> j() {
      return this.f;
    }
  }
  
  static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
    final int g;
    
    @NullableDecl
    final ReferenceEntry<K, V> h;
    
    volatile LocalCache.ValueReference<K, V> i = LocalCache.o();
    
    WeakEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1K, param1ReferenceQueue);
      this.g = param1Int;
      this.h = param1ReferenceEntry;
    }
    
    public LocalCache.ValueReference<K, V> a() {
      return this.i;
    }
    
    public void a(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public void a(LocalCache.ValueReference<K, V> param1ValueReference) {
      this.i = param1ValueReference;
    }
    
    public void a(ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> b() {
      return this.h;
    }
    
    public void b(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public void b(ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public int c() {
      return this.g;
    }
    
    public void c(ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public K d() {
      return get();
    }
    
    public void d(ReferenceEntry<K, V> param1ReferenceEntry) {
      throw new UnsupportedOperationException();
    }
    
    public long e() {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> f() {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> g() {
      throw new UnsupportedOperationException();
    }
    
    public long h() {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> i() {
      throw new UnsupportedOperationException();
    }
    
    public ReferenceEntry<K, V> j() {
      throw new UnsupportedOperationException();
    }
  }
  
  static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
    final ReferenceEntry<K, V> a;
    
    WeakValueReference(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1V, param1ReferenceQueue);
      this.a = param1ReferenceEntry;
    }
    
    public int a() {
      return 1;
    }
    
    public LocalCache.ValueReference<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry) {
      return new WeakValueReference(param1ReferenceQueue, param1V, param1ReferenceEntry);
    }
    
    public void a(V param1V) {}
    
    public ReferenceEntry<K, V> b() {
      return this.a;
    }
    
    public boolean c() {
      return false;
    }
    
    public boolean d() {
      return true;
    }
    
    public V e() {
      return get();
    }
  }
  
  static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
    volatile long a = Long.MAX_VALUE;
    
    ReferenceEntry<K, V> b = LocalCache.p();
    
    ReferenceEntry<K, V> c = LocalCache.p();
    
    WeakWriteEntry(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, @NullableDecl ReferenceEntry<K, V> param1ReferenceEntry) {
      super(param1ReferenceQueue, param1K, param1Int, param1ReferenceEntry);
    }
    
    public void b(long param1Long) {
      this.a = param1Long;
    }
    
    public void c(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.b = param1ReferenceEntry;
    }
    
    public void d(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.c = param1ReferenceEntry;
    }
    
    public long h() {
      return this.a;
    }
    
    public ReferenceEntry<K, V> i() {
      return this.b;
    }
    
    public ReferenceEntry<K, V> j() {
      return this.c;
    }
  }
  
  static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
    final int b;
    
    WeightedSoftValueReference(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry, int param1Int) {
      super(param1ReferenceQueue, param1V, param1ReferenceEntry);
      this.b = param1Int;
    }
    
    public int a() {
      return this.b;
    }
    
    public LocalCache.ValueReference<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry) {
      return new WeightedSoftValueReference(param1ReferenceQueue, param1V, param1ReferenceEntry, this.b);
    }
  }
  
  static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
    final int b;
    
    WeightedStrongValueReference(V param1V, int param1Int) {
      super(param1V);
      this.b = param1Int;
    }
    
    public int a() {
      return this.b;
    }
  }
  
  static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
    final int b;
    
    WeightedWeakValueReference(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry, int param1Int) {
      super(param1ReferenceQueue, param1V, param1ReferenceEntry);
      this.b = param1Int;
    }
    
    public int a() {
      return this.b;
    }
    
    public LocalCache.ValueReference<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, ReferenceEntry<K, V> param1ReferenceEntry) {
      return new WeightedWeakValueReference(param1ReferenceQueue, param1V, param1ReferenceEntry, this.b);
    }
  }
  
  static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
    final ReferenceEntry<K, V> a = new LocalCache.AbstractReferenceEntry<K, V>(this) {
        ReferenceEntry<K, V> a = this;
        
        ReferenceEntry<K, V> b = this;
        
        public void b(long param2Long) {}
        
        public void c(ReferenceEntry<K, V> param2ReferenceEntry) {
          this.a = param2ReferenceEntry;
        }
        
        public void d(ReferenceEntry<K, V> param2ReferenceEntry) {
          this.b = param2ReferenceEntry;
        }
        
        public long h() {
          return Long.MAX_VALUE;
        }
        
        public ReferenceEntry<K, V> i() {
          return this.a;
        }
        
        public ReferenceEntry<K, V> j() {
          return this.b;
        }
      };
    
    public ReferenceEntry<K, V> a() {
      ReferenceEntry<K, V> referenceEntry2 = this.a.i();
      ReferenceEntry<K, V> referenceEntry1 = referenceEntry2;
      if (referenceEntry2 == this.a)
        referenceEntry1 = null; 
      return referenceEntry1;
    }
    
    public boolean a(ReferenceEntry<K, V> param1ReferenceEntry) {
      LocalCache.b(param1ReferenceEntry.j(), param1ReferenceEntry.i());
      LocalCache.b(this.a.j(), param1ReferenceEntry);
      LocalCache.b(param1ReferenceEntry, this.a);
      return true;
    }
    
    public ReferenceEntry<K, V> b() {
      ReferenceEntry<K, V> referenceEntry = this.a.i();
      if (referenceEntry == this.a)
        return null; 
      remove(referenceEntry);
      return referenceEntry;
    }
    
    public void clear() {
      ReferenceEntry<K, V> referenceEntry = this.a.i();
      while (true) {
        ReferenceEntry<K, V> referenceEntry1 = this.a;
        if (referenceEntry != referenceEntry1) {
          referenceEntry1 = referenceEntry.i();
          LocalCache.c(referenceEntry);
          referenceEntry = referenceEntry1;
          continue;
        } 
        referenceEntry1.c(referenceEntry1);
        referenceEntry = this.a;
        referenceEntry.d(referenceEntry);
        return;
      } 
    }
    
    public boolean contains(Object param1Object) {
      return (((ReferenceEntry)param1Object).i() != LocalCache.NullEntry.a);
    }
    
    public boolean isEmpty() {
      return (this.a.i() == this.a);
    }
    
    public Iterator<ReferenceEntry<K, V>> iterator() {
      return (Iterator<ReferenceEntry<K, V>>)new AbstractSequentialIterator<ReferenceEntry<K, V>>(this, a()) {
          protected ReferenceEntry<K, V> a(ReferenceEntry<K, V> param2ReferenceEntry) {
            ReferenceEntry<K, V> referenceEntry = param2ReferenceEntry.i();
            param2ReferenceEntry = referenceEntry;
            if (referenceEntry == this.a.a)
              param2ReferenceEntry = null; 
            return param2ReferenceEntry;
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      param1Object = param1Object;
      ReferenceEntry<?, ?> referenceEntry1 = param1Object.j();
      ReferenceEntry<?, ?> referenceEntry2 = param1Object.i();
      LocalCache.b(referenceEntry1, referenceEntry2);
      LocalCache.c((ReferenceEntry<?, ?>)param1Object);
      return (referenceEntry2 != LocalCache.NullEntry.a);
    }
    
    public int size() {
      ReferenceEntry<K, V> referenceEntry = this.a.i();
      int i = 0;
      while (referenceEntry != this.a) {
        i++;
        referenceEntry = referenceEntry.i();
      } 
      return i;
    }
  }
  
  class null extends AbstractReferenceEntry<K, V> {
    ReferenceEntry<K, V> a = this;
    
    ReferenceEntry<K, V> b = this;
    
    null(LocalCache this$0) {}
    
    public void b(long param1Long) {}
    
    public void c(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.a = param1ReferenceEntry;
    }
    
    public void d(ReferenceEntry<K, V> param1ReferenceEntry) {
      this.b = param1ReferenceEntry;
    }
    
    public long h() {
      return Long.MAX_VALUE;
    }
    
    public ReferenceEntry<K, V> i() {
      return this.a;
    }
    
    public ReferenceEntry<K, V> j() {
      return this.b;
    }
  }
  
  class null extends AbstractSequentialIterator<ReferenceEntry<K, V>> {
    null(LocalCache this$0, ReferenceEntry param1ReferenceEntry) {
      super(param1ReferenceEntry);
    }
    
    protected ReferenceEntry<K, V> a(ReferenceEntry<K, V> param1ReferenceEntry) {
      ReferenceEntry<K, V> referenceEntry = param1ReferenceEntry.i();
      param1ReferenceEntry = referenceEntry;
      if (referenceEntry == this.a.a)
        param1ReferenceEntry = null; 
      return param1ReferenceEntry;
    }
  }
  
  final class WriteThroughEntry implements Map.Entry<K, V> {
    final K a;
    
    V b;
    
    WriteThroughEntry(LocalCache this$0, K param1K, V param1V) {
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
      V v = (V)this.c.put(this.a, (Object)param1V);
      this.b = param1V;
      return v;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getKey());
      stringBuilder.append("=");
      stringBuilder.append(getValue());
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\LocalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */