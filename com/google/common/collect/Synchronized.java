package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class Synchronized {
  static <K, V> Map<K, V> a(Map<K, V> paramMap, @NullableDecl Object paramObject) {
    return new SynchronizedMap<K, V>(paramMap, paramObject);
  }
  
  static <K, V> NavigableMap<K, V> a(NavigableMap<K, V> paramNavigableMap, @NullableDecl Object paramObject) {
    return new SynchronizedNavigableMap<K, V>(paramNavigableMap, paramObject);
  }
  
  static <E> NavigableSet<E> a(NavigableSet<E> paramNavigableSet, @NullableDecl Object paramObject) {
    return new SynchronizedNavigableSet<E>(paramNavigableSet, paramObject);
  }
  
  static <E> Set<E> a(Set<E> paramSet, @NullableDecl Object paramObject) {
    return new SynchronizedSet<E>(paramSet, paramObject);
  }
  
  static <K, V> SortedMap<K, V> a(SortedMap<K, V> paramSortedMap, @NullableDecl Object paramObject) {
    return new SynchronizedSortedMap<K, V>(paramSortedMap, paramObject);
  }
  
  private static <E> List<E> b(List<E> paramList, @NullableDecl Object paramObject) {
    return (paramList instanceof RandomAccess) ? new SynchronizedRandomAccessList<E>(paramList, paramObject) : new SynchronizedList<E>(paramList, paramObject);
  }
  
  private static <K, V> Map.Entry<K, V> b(@NullableDecl Map.Entry<K, V> paramEntry, @NullableDecl Object paramObject) {
    return (paramEntry == null) ? null : new SynchronizedEntry<K, V>(paramEntry, paramObject);
  }
  
  private static <E> SortedSet<E> b(SortedSet<E> paramSortedSet, @NullableDecl Object paramObject) {
    return new SynchronizedSortedSet<E>(paramSortedSet, paramObject);
  }
  
  private static <E> Collection<E> c(Collection<E> paramCollection, @NullableDecl Object paramObject) {
    return new SynchronizedCollection<E>(paramCollection, paramObject);
  }
  
  private static <E> Set<E> c(Set<E> paramSet, @NullableDecl Object paramObject) {
    return (paramSet instanceof SortedSet) ? b((SortedSet<E>)paramSet, paramObject) : a(paramSet, paramObject);
  }
  
  private static <E> Collection<E> d(Collection<E> paramCollection, @NullableDecl Object paramObject) {
    return (paramCollection instanceof SortedSet) ? b((SortedSet<E>)paramCollection, paramObject) : ((paramCollection instanceof Set) ? a((Set<E>)paramCollection, paramObject) : ((paramCollection instanceof List) ? b((List<E>)paramCollection, paramObject) : c(paramCollection, paramObject)));
  }
  
  static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
    @NullableDecl
    transient Set<Map.Entry<K, Collection<V>>> a;
    
    @NullableDecl
    transient Collection<Collection<V>> b;
    
    SynchronizedAsMap(Map<K, Collection<V>> param1Map, @NullableDecl Object param1Object) {
      super(param1Map, param1Object);
    }
    
    public Collection<V> a(Object param1Object) {
      synchronized (this.h) {
        param1Object = super.get(param1Object);
        if (param1Object == null) {
          param1Object = null;
        } else {
          param1Object = Synchronized.a((Collection)param1Object, this.h);
        } 
        return (Collection<V>)param1Object;
      } 
    }
    
    public boolean containsValue(Object param1Object) {
      return values().contains(param1Object);
    }
    
    public Set<Map.Entry<K, Collection<V>>> entrySet() {
      synchronized (this.h) {
        if (this.a == null)
          this.a = new Synchronized.SynchronizedAsMapEntries<K, V>(b().entrySet(), this.h); 
        return this.a;
      } 
    }
    
    public Collection<Collection<V>> values() {
      synchronized (this.h) {
        if (this.b == null)
          this.b = new Synchronized.SynchronizedAsMapValues<V>(b().values(), this.h); 
        return this.b;
      } 
    }
  }
  
  static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
    SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> param1Set, @NullableDecl Object param1Object) {
      super(param1Set, param1Object);
    }
    
    public boolean contains(Object param1Object) {
      synchronized (this.h) {
        return Maps.a(d(), param1Object);
      } 
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      synchronized (this.h) {
        return Collections2.a(d(), param1Collection);
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.h) {
        return Sets.a(d(), param1Object);
      } 
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(this, super.iterator()) {
          Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> param2Entry) {
            return (Map.Entry)new ForwardingMapEntry<K, Collection<Collection<V>>>(this, param2Entry) {
                protected Map.Entry<K, Collection<V>> a() {
                  return this.a;
                }
                
                public Collection<V> c() {
                  return Synchronized.a((Collection)this.a.getValue(), this.b.a.h);
                }
              };
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      synchronized (this.h) {
        return Maps.b(d(), param1Object);
      } 
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      synchronized (this.h) {
        return Iterators.a(d().iterator(), param1Collection);
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      synchronized (this.h) {
        return Iterators.b(d().iterator(), param1Collection);
      } 
    }
    
    public Object[] toArray() {
      synchronized (this.h) {
        return ObjectArrays.a(d());
      } 
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      synchronized (this.h) {
        param1ArrayOfT = ObjectArrays.a(d(), param1ArrayOfT);
        return param1ArrayOfT;
      } 
    }
  }
  
  class null extends TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {
    null(Synchronized this$0, Iterator<? extends Map.Entry<K, Collection<V>>> param1Iterator) {
      super(param1Iterator);
    }
    
    Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> param1Entry) {
      return (Map.Entry)new ForwardingMapEntry<K, Collection<Collection<V>>>(this, param1Entry) {
          protected Map.Entry<K, Collection<V>> a() {
            return this.a;
          }
          
          public Collection<V> c() {
            return Synchronized.a((Collection)this.a.getValue(), this.b.a.h);
          }
        };
    }
  }
  
  class null extends ForwardingMapEntry<K, Collection<V>> {
    protected Map.Entry<K, Collection<V>> a() {
      return this.a;
    }
    
    public Collection<V> c() {
      return Synchronized.a((Collection)this.a.getValue(), this.b.a.h);
    }
  }
  
  static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
    SynchronizedAsMapValues(Collection<Collection<V>> param1Collection, @NullableDecl Object param1Object) {
      super(param1Collection, param1Object);
    }
    
    public Iterator<Collection<V>> iterator() {
      return new TransformedIterator<Collection<V>, Collection<V>>(this, super.iterator()) {
          Collection<V> a(Collection<V> param2Collection) {
            return Synchronized.a(param2Collection, this.a.h);
          }
        };
    }
  }
  
  class null extends TransformedIterator<Collection<V>, Collection<V>> {
    null(Synchronized this$0, Iterator<? extends Collection<V>> param1Iterator) {
      super(param1Iterator);
    }
    
    Collection<V> a(Collection<V> param1Collection) {
      return Synchronized.a(param1Collection, this.a.h);
    }
  }
  
  static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
    @NullableDecl
    private transient Set<V> a;
    
    @NullableDecl
    private transient BiMap<V, K> b;
    
    private SynchronizedBiMap(BiMap<K, V> param1BiMap, @NullableDecl Object param1Object, @NullableDecl BiMap<V, K> param1BiMap1) {
      super(param1BiMap, param1Object);
      this.b = param1BiMap1;
    }
    
    BiMap<K, V> a() {
      return (BiMap<K, V>)super.b();
    }
    
    public BiMap<V, K> ay_() {
      synchronized (this.h) {
        if (this.b == null)
          this.b = new SynchronizedBiMap(a().ay_(), this.h, this); 
        return this.b;
      } 
    }
    
    public Set<V> d() {
      synchronized (this.h) {
        if (this.a == null)
          this.a = Synchronized.a(a().d(), this.h); 
        return this.a;
      } 
    }
  }
  
  static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
    private SynchronizedCollection(Collection<E> param1Collection, @NullableDecl Object param1Object) {
      super(param1Collection, param1Object);
    }
    
    Collection<E> a() {
      return (Collection<E>)super.aB_();
    }
    
    public boolean add(E param1E) {
      synchronized (this.h) {
        return a().add(param1E);
      } 
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      synchronized (this.h) {
        return a().addAll(param1Collection);
      } 
    }
    
    public void clear() {
      synchronized (this.h) {
        a().clear();
        return;
      } 
    }
    
    public boolean contains(Object param1Object) {
      synchronized (this.h) {
        return a().contains(param1Object);
      } 
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      synchronized (this.h) {
        return a().containsAll(param1Collection);
      } 
    }
    
    public boolean isEmpty() {
      synchronized (this.h) {
        return a().isEmpty();
      } 
    }
    
    public Iterator<E> iterator() {
      return a().iterator();
    }
    
    public boolean remove(Object param1Object) {
      synchronized (this.h) {
        return a().remove(param1Object);
      } 
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      synchronized (this.h) {
        return a().removeAll(param1Collection);
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      synchronized (this.h) {
        return a().retainAll(param1Collection);
      } 
    }
    
    public int size() {
      synchronized (this.h) {
        return a().size();
      } 
    }
    
    public Object[] toArray() {
      synchronized (this.h) {
        return a().toArray();
      } 
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      synchronized (this.h) {
        param1ArrayOfT = a().toArray(param1ArrayOfT);
        return param1ArrayOfT;
      } 
    }
  }
  
  static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
    public void addFirst(E param1E) {
      synchronized (this.h) {
        b().addFirst(param1E);
        return;
      } 
    }
    
    public void addLast(E param1E) {
      synchronized (this.h) {
        b().addLast(param1E);
        return;
      } 
    }
    
    Deque<E> b() {
      return (Deque<E>)super.c();
    }
    
    public Iterator<E> descendingIterator() {
      synchronized (this.h) {
        return b().descendingIterator();
      } 
    }
    
    public E getFirst() {
      synchronized (this.h) {
        return b().getFirst();
      } 
    }
    
    public E getLast() {
      synchronized (this.h) {
        return b().getLast();
      } 
    }
    
    public boolean offerFirst(E param1E) {
      synchronized (this.h) {
        return b().offerFirst(param1E);
      } 
    }
    
    public boolean offerLast(E param1E) {
      synchronized (this.h) {
        return b().offerLast(param1E);
      } 
    }
    
    public E peekFirst() {
      synchronized (this.h) {
        return b().peekFirst();
      } 
    }
    
    public E peekLast() {
      synchronized (this.h) {
        return b().peekLast();
      } 
    }
    
    public E pollFirst() {
      synchronized (this.h) {
        return b().pollFirst();
      } 
    }
    
    public E pollLast() {
      synchronized (this.h) {
        return b().pollLast();
      } 
    }
    
    public E pop() {
      synchronized (this.h) {
        return b().pop();
      } 
    }
    
    public void push(E param1E) {
      synchronized (this.h) {
        b().push(param1E);
        return;
      } 
    }
    
    public E removeFirst() {
      synchronized (this.h) {
        return b().removeFirst();
      } 
    }
    
    public boolean removeFirstOccurrence(Object param1Object) {
      synchronized (this.h) {
        return b().removeFirstOccurrence(param1Object);
      } 
    }
    
    public E removeLast() {
      synchronized (this.h) {
        return b().removeLast();
      } 
    }
    
    public boolean removeLastOccurrence(Object param1Object) {
      synchronized (this.h) {
        return b().removeLastOccurrence(param1Object);
      } 
    }
  }
  
  static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
    SynchronizedEntry(Map.Entry<K, V> param1Entry, @NullableDecl Object param1Object) {
      super(param1Entry, param1Object);
    }
    
    Map.Entry<K, V> a() {
      return (Map.Entry<K, V>)super.aB_();
    }
    
    public boolean equals(Object param1Object) {
      synchronized (this.h) {
        return a().equals(param1Object);
      } 
    }
    
    public K getKey() {
      synchronized (this.h) {
        return a().getKey();
      } 
    }
    
    public V getValue() {
      synchronized (this.h) {
        return a().getValue();
      } 
    }
    
    public int hashCode() {
      synchronized (this.h) {
        return a().hashCode();
      } 
    }
    
    public V setValue(V param1V) {
      synchronized (this.h) {
        param1V = a().setValue(param1V);
        return param1V;
      } 
    }
  }
  
  static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
    SynchronizedList(List<E> param1List, @NullableDecl Object param1Object) {
      super(param1List, param1Object);
    }
    
    public void add(int param1Int, E param1E) {
      synchronized (this.h) {
        b().add(param1Int, param1E);
        return;
      } 
    }
    
    public boolean addAll(int param1Int, Collection<? extends E> param1Collection) {
      synchronized (this.h) {
        return b().addAll(param1Int, param1Collection);
      } 
    }
    
    List<E> b() {
      return (List<E>)super.a();
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.h) {
        return b().equals(param1Object);
      } 
    }
    
    public E get(int param1Int) {
      synchronized (this.h) {
        return b().get(param1Int);
      } 
    }
    
    public int hashCode() {
      synchronized (this.h) {
        return b().hashCode();
      } 
    }
    
    public int indexOf(Object param1Object) {
      synchronized (this.h) {
        return b().indexOf(param1Object);
      } 
    }
    
    public int lastIndexOf(Object param1Object) {
      synchronized (this.h) {
        return b().lastIndexOf(param1Object);
      } 
    }
    
    public ListIterator<E> listIterator() {
      return b().listIterator();
    }
    
    public ListIterator<E> listIterator(int param1Int) {
      return b().listIterator(param1Int);
    }
    
    public E remove(int param1Int) {
      synchronized (this.h) {
        return b().remove(param1Int);
      } 
    }
    
    public E set(int param1Int, E param1E) {
      synchronized (this.h) {
        param1E = b().set(param1Int, param1E);
        return param1E;
      } 
    }
    
    public List<E> subList(int param1Int1, int param1Int2) {
      synchronized (this.h) {
        return Synchronized.a(b().subList(param1Int1, param1Int2), this.h);
      } 
    }
  }
  
  static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
    ListMultimap<K, V> a() {
      return (ListMultimap<K, V>)super.b();
    }
    
    public List<V> a(K param1K) {
      synchronized (this.h) {
        return Synchronized.a(a().a(param1K), this.h);
      } 
    }
    
    public List<V> b(Object<V> param1Object) {
      synchronized (this.h) {
        param1Object = (Object<V>)a().b(param1Object);
        return (List<V>)param1Object;
      } 
    }
  }
  
  static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
    @NullableDecl
    transient Set<K> c;
    
    @NullableDecl
    transient Collection<V> d;
    
    @NullableDecl
    transient Set<Map.Entry<K, V>> e;
    
    SynchronizedMap(Map<K, V> param1Map, @NullableDecl Object param1Object) {
      super(param1Map, param1Object);
    }
    
    Map<K, V> b() {
      return (Map<K, V>)super.aB_();
    }
    
    public void clear() {
      synchronized (this.h) {
        b().clear();
        return;
      } 
    }
    
    public boolean containsKey(Object param1Object) {
      synchronized (this.h) {
        return b().containsKey(param1Object);
      } 
    }
    
    public boolean containsValue(Object param1Object) {
      synchronized (this.h) {
        return b().containsValue(param1Object);
      } 
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      synchronized (this.h) {
        if (this.e == null)
          this.e = Synchronized.a(b().entrySet(), this.h); 
        return this.e;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.h) {
        return b().equals(param1Object);
      } 
    }
    
    public V get(Object param1Object) {
      synchronized (this.h) {
        param1Object = b().get(param1Object);
        return (V)param1Object;
      } 
    }
    
    public int hashCode() {
      synchronized (this.h) {
        return b().hashCode();
      } 
    }
    
    public boolean isEmpty() {
      synchronized (this.h) {
        return b().isEmpty();
      } 
    }
    
    public Set<K> keySet() {
      synchronized (this.h) {
        if (this.c == null)
          this.c = Synchronized.a(b().keySet(), this.h); 
        return this.c;
      } 
    }
    
    public V put(K param1K, V param1V) {
      synchronized (this.h) {
        param1K = (K)b().put(param1K, param1V);
        return (V)param1K;
      } 
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      synchronized (this.h) {
        b().putAll(param1Map);
        return;
      } 
    }
    
    public V remove(Object param1Object) {
      synchronized (this.h) {
        param1Object = b().remove(param1Object);
        return (V)param1Object;
      } 
    }
    
    public int size() {
      synchronized (this.h) {
        return b().size();
      } 
    }
    
    public Collection<V> values() {
      synchronized (this.h) {
        if (this.d == null)
          this.d = Synchronized.b(b().values(), this.h); 
        return this.d;
      } 
    }
  }
  
  static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
    @NullableDecl
    transient Set<K> a;
    
    @NullableDecl
    transient Collection<Map.Entry<K, V>> b;
    
    @NullableDecl
    transient Map<K, Collection<V>> c;
    
    public boolean a(K param1K, V param1V) {
      synchronized (this.h) {
        return b().a(param1K, param1V);
      } 
    }
    
    Multimap<K, V> b() {
      return (Multimap<K, V>)super.aB_();
    }
    
    public boolean b(Object param1Object1, Object param1Object2) {
      synchronized (this.h) {
        return b().b(param1Object1, param1Object2);
      } 
    }
    
    public Collection<V> c(K param1K) {
      synchronized (this.h) {
        return Synchronized.a(b().c(param1K), this.h);
      } 
    }
    
    public Map<K, Collection<V>> c() {
      synchronized (this.h) {
        if (this.c == null)
          this.c = new Synchronized.SynchronizedAsMap<K, V>(b().c(), this.h); 
        return this.c;
      } 
    }
    
    public boolean c(Object param1Object1, Object param1Object2) {
      synchronized (this.h) {
        return b().c(param1Object1, param1Object2);
      } 
    }
    
    public Collection<V> d(Object<V> param1Object) {
      synchronized (this.h) {
        param1Object = (Object<V>)b().d(param1Object);
        return (Collection<V>)param1Object;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.h) {
        return b().equals(param1Object);
      } 
    }
    
    public int f() {
      synchronized (this.h) {
        return b().f();
      } 
    }
    
    public boolean f(Object param1Object) {
      synchronized (this.h) {
        return b().f(param1Object);
      } 
    }
    
    public void g() {
      synchronized (this.h) {
        b().g();
        return;
      } 
    }
    
    public boolean g(Object param1Object) {
      synchronized (this.h) {
        return b().g(param1Object);
      } 
    }
    
    public int hashCode() {
      synchronized (this.h) {
        return b().hashCode();
      } 
    }
    
    public Collection<Map.Entry<K, V>> m() {
      synchronized (this.h) {
        if (this.b == null)
          this.b = Synchronized.a(b().m(), this.h); 
        return this.b;
      } 
    }
    
    public boolean r() {
      synchronized (this.h) {
        return b().r();
      } 
    }
    
    public Set<K> s() {
      synchronized (this.h) {
        if (this.a == null)
          this.a = Synchronized.b(b().s(), this.h); 
        return this.a;
      } 
    }
  }
  
  static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
    @NullableDecl
    transient Set<E> a;
    
    @NullableDecl
    transient Set<Multiset.Entry<E>> b;
    
    public int a(Object param1Object) {
      synchronized (this.h) {
        return b().a(param1Object);
      } 
    }
    
    public int a(E param1E, int param1Int) {
      synchronized (this.h) {
        param1Int = b().a(param1E, param1Int);
        return param1Int;
      } 
    }
    
    public boolean a(E param1E, int param1Int1, int param1Int2) {
      synchronized (this.h) {
        return b().a(param1E, param1Int1, param1Int2);
      } 
    }
    
    public int b(Object param1Object, int param1Int) {
      synchronized (this.h) {
        param1Int = b().b(param1Object, param1Int);
        return param1Int;
      } 
    }
    
    Multiset<E> b() {
      return (Multiset<E>)super.a();
    }
    
    public int c(E param1E, int param1Int) {
      synchronized (this.h) {
        param1Int = b().c(param1E, param1Int);
        return param1Int;
      } 
    }
    
    public Set<E> d() {
      synchronized (this.h) {
        if (this.a == null)
          this.a = Synchronized.b(b().d(), this.h); 
        return this.a;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.h) {
        return b().equals(param1Object);
      } 
    }
    
    public Set<Multiset.Entry<E>> f() {
      synchronized (this.h) {
        if (this.b == null)
          this.b = Synchronized.b(b().f(), this.h); 
        return this.b;
      } 
    }
    
    public int hashCode() {
      synchronized (this.h) {
        return b().hashCode();
      } 
    }
  }
  
  static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
    @NullableDecl
    transient NavigableSet<K> a;
    
    @NullableDecl
    transient NavigableMap<K, V> b;
    
    @NullableDecl
    transient NavigableSet<K> f;
    
    SynchronizedNavigableMap(NavigableMap<K, V> param1NavigableMap, @NullableDecl Object param1Object) {
      super(param1NavigableMap, param1Object);
    }
    
    NavigableMap<K, V> a() {
      return (NavigableMap<K, V>)super.c();
    }
    
    public Map.Entry<K, V> ceilingEntry(K param1K) {
      synchronized (this.h) {
        return Synchronized.a(a().ceilingEntry(param1K), this.h);
      } 
    }
    
    public K ceilingKey(K param1K) {
      synchronized (this.h) {
        param1K = a().ceilingKey(param1K);
        return param1K;
      } 
    }
    
    public NavigableSet<K> descendingKeySet() {
      synchronized (this.h) {
        if (this.a == null) {
          NavigableSet<?> navigableSet = Synchronized.a(a().descendingKeySet(), this.h);
          this.a = (NavigableSet)navigableSet;
          return (NavigableSet)navigableSet;
        } 
        return this.a;
      } 
    }
    
    public NavigableMap<K, V> descendingMap() {
      synchronized (this.h) {
        if (this.b == null) {
          NavigableMap<?, ?> navigableMap = Synchronized.a(a().descendingMap(), this.h);
          this.b = (NavigableMap)navigableMap;
          return (NavigableMap)navigableMap;
        } 
        return this.b;
      } 
    }
    
    public Map.Entry<K, V> firstEntry() {
      synchronized (this.h) {
        return Synchronized.a(a().firstEntry(), this.h);
      } 
    }
    
    public Map.Entry<K, V> floorEntry(K param1K) {
      synchronized (this.h) {
        return Synchronized.a(a().floorEntry(param1K), this.h);
      } 
    }
    
    public K floorKey(K param1K) {
      synchronized (this.h) {
        param1K = a().floorKey(param1K);
        return param1K;
      } 
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      synchronized (this.h) {
        return (NavigableMap)Synchronized.a(a().headMap(param1K, param1Boolean), this.h);
      } 
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return headMap(param1K, false);
    }
    
    public Map.Entry<K, V> higherEntry(K param1K) {
      synchronized (this.h) {
        return Synchronized.a(a().higherEntry(param1K), this.h);
      } 
    }
    
    public K higherKey(K param1K) {
      synchronized (this.h) {
        param1K = a().higherKey(param1K);
        return param1K;
      } 
    }
    
    public Set<K> keySet() {
      return navigableKeySet();
    }
    
    public Map.Entry<K, V> lastEntry() {
      synchronized (this.h) {
        return Synchronized.a(a().lastEntry(), this.h);
      } 
    }
    
    public Map.Entry<K, V> lowerEntry(K param1K) {
      synchronized (this.h) {
        return Synchronized.a(a().lowerEntry(param1K), this.h);
      } 
    }
    
    public K lowerKey(K param1K) {
      synchronized (this.h) {
        param1K = a().lowerKey(param1K);
        return param1K;
      } 
    }
    
    public NavigableSet<K> navigableKeySet() {
      synchronized (this.h) {
        if (this.f == null) {
          NavigableSet<?> navigableSet = Synchronized.a(a().navigableKeySet(), this.h);
          this.f = (NavigableSet)navigableSet;
          return (NavigableSet)navigableSet;
        } 
        return this.f;
      } 
    }
    
    public Map.Entry<K, V> pollFirstEntry() {
      synchronized (this.h) {
        return Synchronized.a(a().pollFirstEntry(), this.h);
      } 
    }
    
    public Map.Entry<K, V> pollLastEntry() {
      synchronized (this.h) {
        return Synchronized.a(a().pollLastEntry(), this.h);
      } 
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      synchronized (this.h) {
        return (NavigableMap)Synchronized.a(a().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2), this.h);
      } 
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      synchronized (this.h) {
        return (NavigableMap)Synchronized.a(a().tailMap(param1K, param1Boolean), this.h);
      } 
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return tailMap(param1K, true);
    }
  }
  
  static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
    @NullableDecl
    transient NavigableSet<E> a;
    
    SynchronizedNavigableSet(NavigableSet<E> param1NavigableSet, @NullableDecl Object param1Object) {
      super(param1NavigableSet, param1Object);
    }
    
    NavigableSet<E> b() {
      return (NavigableSet<E>)super.c();
    }
    
    public E ceiling(E param1E) {
      synchronized (this.h) {
        param1E = b().ceiling(param1E);
        return param1E;
      } 
    }
    
    public Iterator<E> descendingIterator() {
      return b().descendingIterator();
    }
    
    public NavigableSet<E> descendingSet() {
      synchronized (this.h) {
        if (this.a == null) {
          NavigableSet<?> navigableSet = Synchronized.a(b().descendingSet(), this.h);
          this.a = (NavigableSet)navigableSet;
          return (NavigableSet)navigableSet;
        } 
        return this.a;
      } 
    }
    
    public E floor(E param1E) {
      synchronized (this.h) {
        param1E = b().floor(param1E);
        return param1E;
      } 
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      synchronized (this.h) {
        return (NavigableSet)Synchronized.a(b().headSet(param1E, param1Boolean), this.h);
      } 
    }
    
    public SortedSet<E> headSet(E param1E) {
      return headSet(param1E, false);
    }
    
    public E higher(E param1E) {
      synchronized (this.h) {
        param1E = b().higher(param1E);
        return param1E;
      } 
    }
    
    public E lower(E param1E) {
      synchronized (this.h) {
        param1E = b().lower(param1E);
        return param1E;
      } 
    }
    
    public E pollFirst() {
      synchronized (this.h) {
        return b().pollFirst();
      } 
    }
    
    public E pollLast() {
      synchronized (this.h) {
        return b().pollLast();
      } 
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      synchronized (this.h) {
        return (NavigableSet)Synchronized.a(b().subSet(param1E1, param1Boolean1, param1E2, param1Boolean2), this.h);
      } 
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return subSet(param1E1, true, param1E2, false);
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      synchronized (this.h) {
        return (NavigableSet)Synchronized.a(b().tailSet(param1E, param1Boolean), this.h);
      } 
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return tailSet(param1E, true);
    }
  }
  
  static class SynchronizedObject implements Serializable {
    final Object g;
    
    final Object h;
    
    SynchronizedObject(Object param1Object1, @NullableDecl Object param1Object2) {
      this.g = Preconditions.a(param1Object1);
      param1Object1 = param1Object2;
      if (param1Object2 == null)
        param1Object1 = this; 
      this.h = param1Object1;
    }
    
    Object aB_() {
      return this.g;
    }
    
    public String toString() {
      synchronized (this.h) {
        return this.g.toString();
      } 
    }
  }
  
  static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
    Queue<E> c() {
      return (Queue<E>)super.a();
    }
    
    public E element() {
      synchronized (this.h) {
        return c().element();
      } 
    }
    
    public boolean offer(E param1E) {
      synchronized (this.h) {
        return c().offer(param1E);
      } 
    }
    
    public E peek() {
      synchronized (this.h) {
        return c().peek();
      } 
    }
    
    public E poll() {
      synchronized (this.h) {
        return c().poll();
      } 
    }
    
    public E remove() {
      synchronized (this.h) {
        return c().remove();
      } 
    }
  }
  
  static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
    SynchronizedRandomAccessList(List<E> param1List, @NullableDecl Object param1Object) {
      super(param1List, param1Object);
    }
  }
  
  static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
    SynchronizedSet(Set<E> param1Set, @NullableDecl Object param1Object) {
      super(param1Set, param1Object);
    }
    
    Set<E> d() {
      return (Set<E>)super.a();
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      synchronized (this.h) {
        return d().equals(param1Object);
      } 
    }
    
    public int hashCode() {
      synchronized (this.h) {
        return d().hashCode();
      } 
    }
  }
  
  static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
    @NullableDecl
    transient Set<Map.Entry<K, V>> d;
    
    SetMultimap<K, V> a() {
      return (SetMultimap<K, V>)super.b();
    }
    
    public Set<V> a(K param1K) {
      synchronized (this.h) {
        return (Set)Synchronized.a(a().a(param1K), this.h);
      } 
    }
    
    public Set<V> b(Object<V> param1Object) {
      synchronized (this.h) {
        param1Object = (Object<V>)a().b(param1Object);
        return (Set<V>)param1Object;
      } 
    }
    
    public Set<Map.Entry<K, V>> t() {
      synchronized (this.h) {
        if (this.d == null)
          this.d = Synchronized.a(a().t(), this.h); 
        return this.d;
      } 
    }
  }
  
  static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
    SynchronizedSortedMap(SortedMap<K, V> param1SortedMap, @NullableDecl Object param1Object) {
      super(param1SortedMap, param1Object);
    }
    
    SortedMap<K, V> c() {
      return (SortedMap<K, V>)super.b();
    }
    
    public Comparator<? super K> comparator() {
      synchronized (this.h) {
        return c().comparator();
      } 
    }
    
    public K firstKey() {
      synchronized (this.h) {
        return c().firstKey();
      } 
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      synchronized (this.h) {
        return (SortedMap)Synchronized.a(c().headMap(param1K), this.h);
      } 
    }
    
    public K lastKey() {
      synchronized (this.h) {
        return c().lastKey();
      } 
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      synchronized (this.h) {
        return (SortedMap)Synchronized.a(c().subMap(param1K1, param1K2), this.h);
      } 
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      synchronized (this.h) {
        return (SortedMap)Synchronized.a(c().tailMap(param1K), this.h);
      } 
    }
  }
  
  static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
    SynchronizedSortedSet(SortedSet<E> param1SortedSet, @NullableDecl Object param1Object) {
      super(param1SortedSet, param1Object);
    }
    
    SortedSet<E> c() {
      return (SortedSet<E>)super.d();
    }
    
    public Comparator<? super E> comparator() {
      synchronized (this.h) {
        return c().comparator();
      } 
    }
    
    public E first() {
      synchronized (this.h) {
        return c().first();
      } 
    }
    
    public SortedSet<E> headSet(E param1E) {
      synchronized (this.h) {
        return Synchronized.a(c().headSet(param1E), this.h);
      } 
    }
    
    public E last() {
      synchronized (this.h) {
        return c().last();
      } 
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      synchronized (this.h) {
        return Synchronized.a(c().subSet(param1E1, param1E2), this.h);
      } 
    }
    
    public SortedSet<E> tailSet(E param1E) {
      synchronized (this.h) {
        return Synchronized.a(c().tailSet(param1E), this.h);
      } 
    }
  }
  
  static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    SortedSetMultimap<K, V> d() {
      return (SortedSetMultimap<K, V>)super.a();
    }
    
    public SortedSet<V> h(K param1K) {
      synchronized (this.h) {
        return Synchronized.a(d().h(param1K), this.h);
      } 
    }
    
    public SortedSet<V> i(Object<V> param1Object) {
      synchronized (this.h) {
        param1Object = (Object<V>)d().i(param1Object);
        return (SortedSet<V>)param1Object;
      } 
    }
  }
  
  static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {
    public V a(@NullableDecl R param1R, @NullableDecl C param1C, @NullableDecl V param1V) {
      synchronized (this.h) {
        param1R = (R)c().a(param1R, param1C, param1V);
        return (V)param1R;
      } 
    }
    
    public Set<R> a() {
      synchronized (this.h) {
        return (Set)Synchronized.a(c().a(), this.h);
      } 
    }
    
    public boolean a(@NullableDecl Object param1Object) {
      synchronized (this.h) {
        return c().a(param1Object);
      } 
    }
    
    public boolean a(@NullableDecl Object param1Object1, @NullableDecl Object param1Object2) {
      synchronized (this.h) {
        return c().a(param1Object1, param1Object2);
      } 
    }
    
    public V b(@NullableDecl Object param1Object1, @NullableDecl Object param1Object2) {
      synchronized (this.h) {
        param1Object1 = c().b(param1Object1, param1Object2);
        return (V)param1Object1;
      } 
    }
    
    public Set<C> b() {
      synchronized (this.h) {
        return (Set)Synchronized.a(c().b(), this.h);
      } 
    }
    
    public boolean b(@NullableDecl Object param1Object) {
      synchronized (this.h) {
        return c().b(param1Object);
      } 
    }
    
    Table<R, C, V> c() {
      return (Table<R, C, V>)super.aB_();
    }
    
    public V c(@NullableDecl Object param1Object1, @NullableDecl Object param1Object2) {
      synchronized (this.h) {
        param1Object1 = c().c(param1Object1, param1Object2);
        return (V)param1Object1;
      } 
    }
    
    public boolean c(@NullableDecl Object param1Object) {
      synchronized (this.h) {
        return c().c(param1Object);
      } 
    }
    
    public Map<R, V> d(@NullableDecl C param1C) {
      synchronized (this.h) {
        return (Map)Synchronized.a(c().d(param1C), this.h);
      } 
    }
    
    public void d() {
      synchronized (this.h) {
        c().d();
        return;
      } 
    }
    
    public Map<C, V> e(@NullableDecl R param1R) {
      synchronized (this.h) {
        return (Map)Synchronized.a(c().e(param1R), this.h);
      } 
    }
    
    public Set<Table.Cell<R, C, V>> e() {
      synchronized (this.h) {
        return (Set)Synchronized.a(c().e(), this.h);
      } 
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (this == param1Object)
        return true; 
      synchronized (this.h) {
        return c().equals(param1Object);
      } 
    }
    
    public Collection<V> h() {
      synchronized (this.h) {
        return Synchronized.b(c().h(), this.h);
      } 
    }
    
    public int hashCode() {
      synchronized (this.h) {
        return c().hashCode();
      } 
    }
    
    public int k() {
      synchronized (this.h) {
        return c().k();
      } 
    }
    
    public Map<C, Map<R, V>> m() {
      synchronized (this.h) {
        return (Map)Synchronized.a(Maps.a(c().m(), new Function<Map<R, V>, Map<R, V>>(this) {
                public Map<R, V> a(Map<R, V> param2Map) {
                  return Synchronized.a(param2Map, this.a.h);
                }
              }), this.h);
      } 
    }
    
    public Map<R, Map<C, V>> o() {
      synchronized (this.h) {
        return (Map)Synchronized.a(Maps.a(c().o(), new Function<Map<C, V>, Map<C, V>>(this) {
                public Map<C, V> a(Map<C, V> param2Map) {
                  return Synchronized.a(param2Map, this.a.h);
                }
              }), this.h);
      } 
    }
  }
  
  class null implements Function<Map<C, V>, Map<C, V>> {
    null(Synchronized this$0) {}
    
    public Map<C, V> a(Map<C, V> param1Map) {
      return Synchronized.a(param1Map, this.a.h);
    }
  }
  
  class null implements Function<Map<R, V>, Map<R, V>> {
    null(Synchronized this$0) {}
    
    public Map<R, V> a(Map<R, V> param1Map) {
      return Synchronized.a(param1Map, this.a.h);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Synchronized.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */