package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
  private transient Map<K, Collection<V>> a;
  
  private transient int b;
  
  protected AbstractMapBasedMultimap(Map<K, Collection<V>> paramMap) {
    Preconditions.a(paramMap.isEmpty());
    this.a = paramMap;
  }
  
  private static <E> Iterator<E> c(Collection<E> paramCollection) {
    return (paramCollection instanceof List) ? ((List<E>)paramCollection).listIterator() : paramCollection.iterator();
  }
  
  private void j(Object paramObject) {
    paramObject = Maps.<Collection>c((Map)this.a, paramObject);
    if (paramObject != null) {
      int i = paramObject.size();
      paramObject.clear();
      this.b -= i;
    } 
  }
  
  Collection<V> a(@NullableDecl K paramK, Collection<V> paramCollection) {
    return new WrappedCollection(this, paramK, paramCollection, null);
  }
  
  <E> Collection<E> a(Collection<E> paramCollection) {
    return Collections.unmodifiableCollection(paramCollection);
  }
  
  final List<V> a(@NullableDecl K paramK, List<V> paramList, @NullableDecl WrappedCollection paramWrappedCollection) {
    return (paramList instanceof RandomAccess) ? new RandomAccessWrappedList(this, paramK, paramList, paramWrappedCollection) : new WrappedList(this, paramK, paramList, paramWrappedCollection);
  }
  
  public boolean a(@NullableDecl K paramK, @NullableDecl V paramV) {
    Collection<V> collection = this.a.get(paramK);
    if (collection == null) {
      collection = e(paramK);
      if (collection.add(paramV)) {
        this.b++;
        this.a.put(paramK, collection);
        return true;
      } 
      throw new AssertionError("New Collection violated the Collection spec");
    } 
    if (collection.add(paramV)) {
      this.b++;
      return true;
    } 
    return false;
  }
  
  public Collection<V> c(@NullableDecl K paramK) {
    Collection<V> collection2 = this.a.get(paramK);
    Collection<V> collection1 = collection2;
    if (collection2 == null)
      collection1 = e(paramK); 
    return a(paramK, collection1);
  }
  
  abstract Collection<V> d();
  
  public Collection<V> d(@NullableDecl Object paramObject) {
    paramObject = this.a.remove(paramObject);
    if (paramObject == null)
      return e(); 
    Collection<V> collection = d();
    collection.addAll((Collection<? extends V>)paramObject);
    this.b -= paramObject.size();
    paramObject.clear();
    return a(collection);
  }
  
  Collection<V> e() {
    return a(d());
  }
  
  Collection<V> e(@NullableDecl K paramK) {
    return d();
  }
  
  public int f() {
    return this.b;
  }
  
  public boolean f(@NullableDecl Object paramObject) {
    return this.a.containsKey(paramObject);
  }
  
  public void g() {
    Iterator<Collection> iterator = this.a.values().iterator();
    while (iterator.hasNext())
      ((Collection)iterator.next()).clear(); 
    this.a.clear();
    this.b = 0;
  }
  
  Set<K> h() {
    return new KeySet(this, this.a);
  }
  
  final Set<K> i() {
    Map<K, Collection<V>> map = this.a;
    return (map instanceof NavigableMap) ? new NavigableKeySet(this, (NavigableMap<K, Collection<V>>)map) : ((map instanceof SortedMap) ? new SortedKeySet(this, (SortedMap<K, Collection<V>>)map) : new KeySet(this, map));
  }
  
  public Collection<V> j() {
    return super.j();
  }
  
  Collection<V> k() {
    return new AbstractMultimap.Values(this);
  }
  
  Iterator<V> l() {
    return new Itr<V>(this) {
        V a(K param1K, V param1V) {
          return param1V;
        }
      };
  }
  
  public Collection<Map.Entry<K, V>> m() {
    return super.m();
  }
  
  Collection<Map.Entry<K, V>> n() {
    return (this instanceof SetMultimap) ? new AbstractMultimap.EntrySet(this) : new AbstractMultimap.Entries(this);
  }
  
  Iterator<Map.Entry<K, V>> o() {
    return new Itr<Map.Entry<K, V>>(this) {
        Map.Entry<K, V> b(K param1K, V param1V) {
          return Maps.a(param1K, param1V);
        }
      };
  }
  
  Map<K, Collection<V>> p() {
    return new AsMap(this, this.a);
  }
  
  final Map<K, Collection<V>> q() {
    Map<K, Collection<V>> map = this.a;
    return (map instanceof NavigableMap) ? new NavigableAsMap(this, (NavigableMap<K, Collection<V>>)map) : ((map instanceof SortedMap) ? new SortedAsMap(this, (SortedMap<K, Collection<V>>)map) : new AsMap(this, map));
  }
  
  class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
    final transient Map<K, Collection<V>> a;
    
    AsMap(AbstractMapBasedMultimap this$0, Map<K, Collection<V>> param1Map) {
      this.a = param1Map;
    }
    
    public Collection<V> a(Object param1Object) {
      Collection<V> collection = Maps.<Collection>a((Map)this.a, param1Object);
      return (collection == null) ? null : this.b.a(param1Object, collection);
    }
    
    Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> param1Entry) {
      K k = param1Entry.getKey();
      return Maps.a(k, this.b.a(k, param1Entry.getValue()));
    }
    
    protected Set<Map.Entry<K, Collection<V>>> a() {
      return new AsMapEntries(this);
    }
    
    public Collection<V> b(Object param1Object) {
      param1Object = this.a.remove(param1Object);
      if (param1Object == null)
        return null; 
      Collection<V> collection = this.b.d();
      collection.addAll((Collection)param1Object);
      AbstractMapBasedMultimap abstractMapBasedMultimap = this.b;
      AbstractMapBasedMultimap.a(abstractMapBasedMultimap, AbstractMapBasedMultimap.d(abstractMapBasedMultimap) - param1Object.size());
      param1Object.clear();
      return collection;
    }
    
    public void clear() {
      if (this.a == AbstractMapBasedMultimap.a(this.b)) {
        this.b.g();
        return;
      } 
      Iterators.h(new AsMapIterator(this));
    }
    
    public boolean containsKey(Object param1Object) {
      return Maps.b(this.a, param1Object);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      return (this == param1Object || this.a.equals(param1Object));
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public Set<K> keySet() {
      return this.b.s();
    }
    
    public int size() {
      return this.a.size();
    }
    
    public String toString() {
      return this.a.toString();
    }
    
    class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
      AsMapEntries(AbstractMapBasedMultimap.AsMap this$0) {}
      
      Map<K, Collection<V>> a() {
        return this.a;
      }
      
      public boolean contains(Object param2Object) {
        return Collections2.a(this.a.a.entrySet(), param2Object);
      }
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator() {
        return new AbstractMapBasedMultimap.AsMap.AsMapIterator(this.a);
      }
      
      public boolean remove(Object param2Object) {
        if (!contains(param2Object))
          return false; 
        param2Object = param2Object;
        AbstractMapBasedMultimap.a(this.a.b, param2Object.getKey());
        return true;
      }
    }
    
    class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {
      final Iterator<Map.Entry<K, Collection<V>>> a = this.c.a.entrySet().iterator();
      
      @NullableDecl
      Collection<V> b;
      
      AsMapIterator(AbstractMapBasedMultimap.AsMap this$0) {}
      
      public Map.Entry<K, Collection<V>> a() {
        Map.Entry<K, Collection<V>> entry = this.a.next();
        this.b = (Collection<V>)entry.getValue();
        return this.c.a(entry);
      }
      
      public boolean hasNext() {
        return this.a.hasNext();
      }
      
      public void remove() {
        boolean bool;
        if (this.b != null) {
          bool = true;
        } else {
          bool = false;
        } 
        CollectPreconditions.a(bool);
        this.a.remove();
        AbstractMapBasedMultimap.a(this.c.b, AbstractMapBasedMultimap.d(this.c.b) - this.b.size());
        this.b.clear();
        this.b = null;
      }
    }
  }
  
  class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
    AsMapEntries(AbstractMapBasedMultimap this$0) {}
    
    Map<K, Collection<V>> a() {
      return this.a;
    }
    
    public boolean contains(Object param1Object) {
      return Collections2.a(this.a.a.entrySet(), param1Object);
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return new AbstractMapBasedMultimap.AsMap.AsMapIterator(this.a);
    }
    
    public boolean remove(Object param1Object) {
      if (!contains(param1Object))
        return false; 
      param1Object = param1Object;
      AbstractMapBasedMultimap.a(this.a.b, param1Object.getKey());
      return true;
    }
  }
  
  class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {
    final Iterator<Map.Entry<K, Collection<V>>> a = this.c.a.entrySet().iterator();
    
    @NullableDecl
    Collection<V> b;
    
    AsMapIterator(AbstractMapBasedMultimap this$0) {}
    
    public Map.Entry<K, Collection<V>> a() {
      Map.Entry<K, Collection<V>> entry = this.a.next();
      this.b = (Collection<V>)entry.getValue();
      return this.c.a(entry);
    }
    
    public boolean hasNext() {
      return this.a.hasNext();
    }
    
    public void remove() {
      boolean bool;
      if (this.b != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      this.a.remove();
      AbstractMapBasedMultimap.a(this.c.b, AbstractMapBasedMultimap.d(this.c.b) - this.b.size());
      this.b.clear();
      this.b = null;
    }
  }
  
  abstract class Itr<T> implements Iterator<T> {
    final Iterator<Map.Entry<K, Collection<V>>> b;
    
    @NullableDecl
    K c;
    
    @NullableDecl
    Collection<V> d;
    
    Iterator<V> e;
    
    Itr(AbstractMapBasedMultimap this$0) {
      this.b = AbstractMapBasedMultimap.a(this$0).entrySet().iterator();
      this.c = null;
      this.d = null;
      this.e = Iterators.c();
    }
    
    abstract T a(K param1K, V param1V);
    
    public boolean hasNext() {
      return (this.b.hasNext() || this.e.hasNext());
    }
    
    public T next() {
      if (!this.e.hasNext()) {
        Map.Entry entry = this.b.next();
        this.c = (K)entry.getKey();
        this.d = (Collection<V>)entry.getValue();
        this.e = this.d.iterator();
      } 
      return a(this.c, this.e.next());
    }
    
    public void remove() {
      this.e.remove();
      if (this.d.isEmpty())
        this.b.remove(); 
      AbstractMapBasedMultimap.b(this.f);
    }
  }
  
  class KeySet extends Maps.KeySet<K, Collection<V>> {
    KeySet(AbstractMapBasedMultimap this$0, Map<K, Collection<V>> param1Map) {
      super(param1Map);
    }
    
    public void clear() {
      Iterators.h(iterator());
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return c().keySet().containsAll(param1Collection);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      return (this == param1Object || c().keySet().equals(param1Object));
    }
    
    public int hashCode() {
      return c().keySet().hashCode();
    }
    
    public Iterator<K> iterator() {
      return new Iterator<K>(this, c().entrySet().iterator()) {
          @NullableDecl
          Map.Entry<K, Collection<V>> a;
          
          public boolean hasNext() {
            return this.b.hasNext();
          }
          
          public K next() {
            this.a = this.b.next();
            return this.a.getKey();
          }
          
          public void remove() {
            boolean bool;
            if (this.a != null) {
              bool = true;
            } else {
              bool = false;
            } 
            CollectPreconditions.a(bool);
            Collection collection = this.a.getValue();
            this.b.remove();
            AbstractMapBasedMultimap.a(this.c.a, AbstractMapBasedMultimap.d(this.c.a) - collection.size());
            collection.clear();
            this.a = null;
          }
        };
    }
    
    public boolean remove(Object param1Object) {
      boolean bool1;
      param1Object = c().remove(param1Object);
      boolean bool2 = false;
      if (param1Object != null) {
        bool1 = param1Object.size();
        param1Object.clear();
        param1Object = this.a;
        AbstractMapBasedMultimap.a((AbstractMapBasedMultimap)param1Object, AbstractMapBasedMultimap.d((AbstractMapBasedMultimap)param1Object) - bool1);
      } else {
        bool1 = false;
      } 
      if (bool1)
        bool2 = true; 
      return bool2;
    }
  }
  
  class null implements Iterator<K> {
    @NullableDecl
    Map.Entry<K, Collection<V>> a;
    
    null(AbstractMapBasedMultimap this$0, Iterator param1Iterator) {}
    
    public boolean hasNext() {
      return this.b.hasNext();
    }
    
    public K next() {
      this.a = this.b.next();
      return this.a.getKey();
    }
    
    public void remove() {
      boolean bool;
      if (this.a != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      Collection collection = this.a.getValue();
      this.b.remove();
      AbstractMapBasedMultimap.a(this.c.a, AbstractMapBasedMultimap.d(this.c.a) - collection.size());
      collection.clear();
      this.a = null;
    }
  }
  
  class NavigableAsMap extends SortedAsMap implements NavigableMap<K, Collection<V>> {
    NavigableAsMap(AbstractMapBasedMultimap this$0, NavigableMap<K, Collection<V>> param1NavigableMap) {
      super(this$0, param1NavigableMap);
    }
    
    Map.Entry<K, Collection<V>> a(Iterator<Map.Entry<K, Collection<V>>> param1Iterator) {
      if (!param1Iterator.hasNext())
        return null; 
      Map.Entry entry = param1Iterator.next();
      Collection collection = this.c.d();
      collection.addAll((Collection)entry.getValue());
      param1Iterator.remove();
      return Maps.a((K)entry.getKey(), this.c.a(collection));
    }
    
    public NavigableMap<K, Collection<V>> a(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    NavigableMap<K, Collection<V>> aq_() {
      return (NavigableMap<K, Collection<V>>)super.g();
    }
    
    public NavigableMap<K, Collection<V>> c(K param1K) {
      return headMap(param1K, false);
    }
    
    public NavigableSet<K> c() {
      return (NavigableSet<K>)super.f();
    }
    
    public Map.Entry<K, Collection<V>> ceilingEntry(K param1K) {
      Map.Entry<K, Collection<V>> entry = aq_().ceilingEntry(param1K);
      return (entry == null) ? null : a(entry);
    }
    
    public K ceilingKey(K param1K) {
      return aq_().ceilingKey(param1K);
    }
    
    public NavigableMap<K, Collection<V>> d(K param1K) {
      return tailMap(param1K, true);
    }
    
    NavigableSet<K> d() {
      return new AbstractMapBasedMultimap.NavigableKeySet(this.c, aq_());
    }
    
    public NavigableSet<K> descendingKeySet() {
      return descendingMap().navigableKeySet();
    }
    
    public NavigableMap<K, Collection<V>> descendingMap() {
      return new NavigableAsMap(this.c, aq_().descendingMap());
    }
    
    public Map.Entry<K, Collection<V>> firstEntry() {
      Map.Entry<K, Collection<V>> entry = aq_().firstEntry();
      return (entry == null) ? null : a(entry);
    }
    
    public Map.Entry<K, Collection<V>> floorEntry(K param1K) {
      Map.Entry<K, Collection<V>> entry = aq_().floorEntry(param1K);
      return (entry == null) ? null : a(entry);
    }
    
    public K floorKey(K param1K) {
      return aq_().floorKey(param1K);
    }
    
    public NavigableMap<K, Collection<V>> headMap(K param1K, boolean param1Boolean) {
      return new NavigableAsMap(this.c, aq_().headMap(param1K, param1Boolean));
    }
    
    public Map.Entry<K, Collection<V>> higherEntry(K param1K) {
      Map.Entry<K, Collection<V>> entry = aq_().higherEntry(param1K);
      return (entry == null) ? null : a(entry);
    }
    
    public K higherKey(K param1K) {
      return aq_().higherKey(param1K);
    }
    
    public Map.Entry<K, Collection<V>> lastEntry() {
      Map.Entry<K, Collection<V>> entry = aq_().lastEntry();
      return (entry == null) ? null : a(entry);
    }
    
    public Map.Entry<K, Collection<V>> lowerEntry(K param1K) {
      Map.Entry<K, Collection<V>> entry = aq_().lowerEntry(param1K);
      return (entry == null) ? null : a(entry);
    }
    
    public K lowerKey(K param1K) {
      return aq_().lowerKey(param1K);
    }
    
    public NavigableSet<K> navigableKeySet() {
      return c();
    }
    
    public Map.Entry<K, Collection<V>> pollFirstEntry() {
      return a(entrySet().iterator());
    }
    
    public Map.Entry<K, Collection<V>> pollLastEntry() {
      return a(descendingMap().entrySet().iterator());
    }
    
    public NavigableMap<K, Collection<V>> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return new NavigableAsMap(this.c, aq_().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2));
    }
    
    public NavigableMap<K, Collection<V>> tailMap(K param1K, boolean param1Boolean) {
      return new NavigableAsMap(this.c, aq_().tailMap(param1K, param1Boolean));
    }
  }
  
  class NavigableKeySet extends SortedKeySet implements NavigableSet<K> {
    NavigableKeySet(AbstractMapBasedMultimap this$0, NavigableMap<K, Collection<V>> param1NavigableMap) {
      super(this$0, param1NavigableMap);
    }
    
    NavigableMap<K, Collection<V>> a() {
      return (NavigableMap<K, Collection<V>>)super.b();
    }
    
    public NavigableSet<K> a(K param1K) {
      return headSet(param1K, false);
    }
    
    public NavigableSet<K> a(K param1K1, K param1K2) {
      return subSet(param1K1, true, param1K2, false);
    }
    
    public NavigableSet<K> b(K param1K) {
      return tailSet(param1K, true);
    }
    
    public K ceiling(K param1K) {
      return a().ceilingKey(param1K);
    }
    
    public Iterator<K> descendingIterator() {
      return descendingSet().iterator();
    }
    
    public NavigableSet<K> descendingSet() {
      return new NavigableKeySet(this.b, a().descendingMap());
    }
    
    public K floor(K param1K) {
      return a().floorKey(param1K);
    }
    
    public NavigableSet<K> headSet(K param1K, boolean param1Boolean) {
      return new NavigableKeySet(this.b, a().headMap(param1K, param1Boolean));
    }
    
    public K higher(K param1K) {
      return a().higherKey(param1K);
    }
    
    public K lower(K param1K) {
      return a().lowerKey(param1K);
    }
    
    public K pollFirst() {
      return Iterators.g(iterator());
    }
    
    public K pollLast() {
      return Iterators.g(descendingIterator());
    }
    
    public NavigableSet<K> subSet(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return new NavigableKeySet(this.b, a().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2));
    }
    
    public NavigableSet<K> tailSet(K param1K, boolean param1Boolean) {
      return new NavigableKeySet(this.b, a().tailMap(param1K, param1Boolean));
    }
  }
  
  class RandomAccessWrappedList extends WrappedList implements RandomAccess {
    RandomAccessWrappedList(@NullableDecl AbstractMapBasedMultimap this$0, K param1K, @NullableDecl List<V> param1List, AbstractMapBasedMultimap<K, V>.WrappedCollection param1WrappedCollection) {
      super(this$0, param1K, param1List, param1WrappedCollection);
    }
  }
  
  class SortedAsMap extends AsMap implements SortedMap<K, Collection<V>> {
    @NullableDecl
    SortedSet<K> d;
    
    SortedAsMap(AbstractMapBasedMultimap this$0, SortedMap<K, Collection<V>> param1SortedMap) {
      super(this$0, param1SortedMap);
    }
    
    public Comparator<? super K> comparator() {
      return g().comparator();
    }
    
    SortedSet<K> e() {
      return new AbstractMapBasedMultimap.SortedKeySet(this.e, g());
    }
    
    public SortedSet<K> f() {
      SortedSet<K> sortedSet2 = this.d;
      SortedSet<K> sortedSet1 = sortedSet2;
      if (sortedSet2 == null) {
        sortedSet1 = e();
        this.d = sortedSet1;
      } 
      return sortedSet1;
    }
    
    public K firstKey() {
      return g().firstKey();
    }
    
    SortedMap<K, Collection<V>> g() {
      return (SortedMap<K, Collection<V>>)this.a;
    }
    
    public SortedMap<K, Collection<V>> headMap(K param1K) {
      return new SortedAsMap(this.e, g().headMap(param1K));
    }
    
    public K lastKey() {
      return g().lastKey();
    }
    
    public SortedMap<K, Collection<V>> subMap(K param1K1, K param1K2) {
      return new SortedAsMap(this.e, g().subMap(param1K1, param1K2));
    }
    
    public SortedMap<K, Collection<V>> tailMap(K param1K) {
      return new SortedAsMap(this.e, g().tailMap(param1K));
    }
  }
  
  class SortedKeySet extends KeySet implements SortedSet<K> {
    SortedKeySet(AbstractMapBasedMultimap this$0, SortedMap<K, Collection<V>> param1SortedMap) {
      super(this$0, param1SortedMap);
    }
    
    SortedMap<K, Collection<V>> b() {
      return (SortedMap<K, Collection<V>>)c();
    }
    
    public Comparator<? super K> comparator() {
      return b().comparator();
    }
    
    public K first() {
      return b().firstKey();
    }
    
    public SortedSet<K> headSet(K param1K) {
      return new SortedKeySet(this.c, b().headMap(param1K));
    }
    
    public K last() {
      return b().lastKey();
    }
    
    public SortedSet<K> subSet(K param1K1, K param1K2) {
      return new SortedKeySet(this.c, b().subMap(param1K1, param1K2));
    }
    
    public SortedSet<K> tailSet(K param1K) {
      return new SortedKeySet(this.c, b().tailMap(param1K));
    }
  }
  
  class WrappedCollection extends AbstractCollection<V> {
    @NullableDecl
    final K b;
    
    Collection<V> c;
    
    @NullableDecl
    final WrappedCollection d;
    
    @NullableDecl
    final Collection<V> e;
    
    WrappedCollection(@NullableDecl AbstractMapBasedMultimap this$0, K param1K, @NullableDecl Collection<V> param1Collection, WrappedCollection param1WrappedCollection) {
      Collection<V> collection;
      this.b = param1K;
      this.c = param1Collection;
      this.d = param1WrappedCollection;
      if (param1WrappedCollection == null) {
        this$0 = null;
      } else {
        collection = param1WrappedCollection.e();
      } 
      this.e = collection;
    }
    
    void a() {
      WrappedCollection wrappedCollection = this.d;
      if (wrappedCollection != null) {
        wrappedCollection.a();
        if (this.d.e() == this.e)
          return; 
        throw new ConcurrentModificationException();
      } 
      if (this.c.isEmpty()) {
        Collection<V> collection = (Collection)AbstractMapBasedMultimap.a(this.f).get(this.b);
        if (collection != null)
          this.c = collection; 
      } 
    }
    
    public boolean add(V param1V) {
      a();
      boolean bool1 = this.c.isEmpty();
      boolean bool2 = this.c.add(param1V);
      if (bool2) {
        AbstractMapBasedMultimap.c(this.f);
        if (bool1)
          d(); 
      } 
      return bool2;
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      if (param1Collection.isEmpty())
        return false; 
      int i = size();
      boolean bool = this.c.addAll(param1Collection);
      if (bool) {
        int j = this.c.size();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.f;
        AbstractMapBasedMultimap.a(abstractMapBasedMultimap, AbstractMapBasedMultimap.d(abstractMapBasedMultimap) + j - i);
        if (i == 0)
          d(); 
      } 
      return bool;
    }
    
    void b() {
      WrappedCollection wrappedCollection = this.d;
      if (wrappedCollection != null) {
        wrappedCollection.b();
        return;
      } 
      if (this.c.isEmpty())
        AbstractMapBasedMultimap.a(this.f).remove(this.b); 
    }
    
    K c() {
      return this.b;
    }
    
    public void clear() {
      int i = size();
      if (i == 0)
        return; 
      this.c.clear();
      AbstractMapBasedMultimap abstractMapBasedMultimap = this.f;
      AbstractMapBasedMultimap.a(abstractMapBasedMultimap, AbstractMapBasedMultimap.d(abstractMapBasedMultimap) - i);
      b();
    }
    
    public boolean contains(Object param1Object) {
      a();
      return this.c.contains(param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      a();
      return this.c.containsAll(param1Collection);
    }
    
    void d() {
      WrappedCollection wrappedCollection = this.d;
      if (wrappedCollection != null) {
        wrappedCollection.d();
        return;
      } 
      AbstractMapBasedMultimap.a(this.f).put(this.b, this.c);
    }
    
    Collection<V> e() {
      return this.c;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      a();
      return this.c.equals(param1Object);
    }
    
    WrappedCollection f() {
      return this.d;
    }
    
    public int hashCode() {
      a();
      return this.c.hashCode();
    }
    
    public Iterator<V> iterator() {
      a();
      return new WrappedIterator(this);
    }
    
    public boolean remove(Object param1Object) {
      a();
      boolean bool = this.c.remove(param1Object);
      if (bool) {
        AbstractMapBasedMultimap.b(this.f);
        b();
      } 
      return bool;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      if (param1Collection.isEmpty())
        return false; 
      int i = size();
      boolean bool = this.c.removeAll(param1Collection);
      if (bool) {
        int j = this.c.size();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.f;
        AbstractMapBasedMultimap.a(abstractMapBasedMultimap, AbstractMapBasedMultimap.d(abstractMapBasedMultimap) + j - i);
        b();
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Preconditions.a(param1Collection);
      int i = size();
      boolean bool = this.c.retainAll(param1Collection);
      if (bool) {
        int j = this.c.size();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.f;
        AbstractMapBasedMultimap.a(abstractMapBasedMultimap, AbstractMapBasedMultimap.d(abstractMapBasedMultimap) + j - i);
        b();
      } 
      return bool;
    }
    
    public int size() {
      a();
      return this.c.size();
    }
    
    public String toString() {
      a();
      return this.c.toString();
    }
    
    class WrappedIterator implements Iterator<V> {
      final Iterator<V> a;
      
      final Collection<V> b = this.c.c;
      
      WrappedIterator(AbstractMapBasedMultimap.WrappedCollection this$0) {
        this.a = AbstractMapBasedMultimap.b(this$0.c);
      }
      
      WrappedIterator(AbstractMapBasedMultimap.WrappedCollection this$0, Iterator<V> param2Iterator) {
        this.a = param2Iterator;
      }
      
      void a() {
        this.c.a();
        if (this.c.c == this.b)
          return; 
        throw new ConcurrentModificationException();
      }
      
      Iterator<V> b() {
        a();
        return this.a;
      }
      
      public boolean hasNext() {
        a();
        return this.a.hasNext();
      }
      
      public V next() {
        a();
        return this.a.next();
      }
      
      public void remove() {
        this.a.remove();
        AbstractMapBasedMultimap.b(this.c.f);
        this.c.b();
      }
    }
  }
  
  class WrappedIterator implements Iterator<V> {
    final Iterator<V> a;
    
    final Collection<V> b = this.c.c;
    
    WrappedIterator(AbstractMapBasedMultimap this$0) {
      this.a = AbstractMapBasedMultimap.b(((AbstractMapBasedMultimap.WrappedCollection)this$0).c);
    }
    
    WrappedIterator(AbstractMapBasedMultimap this$0, Iterator<V> param1Iterator) {
      this.a = param1Iterator;
    }
    
    void a() {
      this.c.a();
      if (this.c.c == this.b)
        return; 
      throw new ConcurrentModificationException();
    }
    
    Iterator<V> b() {
      a();
      return this.a;
    }
    
    public boolean hasNext() {
      a();
      return this.a.hasNext();
    }
    
    public V next() {
      a();
      return this.a.next();
    }
    
    public void remove() {
      this.a.remove();
      AbstractMapBasedMultimap.b(this.c.f);
      this.c.b();
    }
  }
  
  class WrappedList extends WrappedCollection implements List<V> {
    WrappedList(@NullableDecl AbstractMapBasedMultimap this$0, K param1K, @NullableDecl List<V> param1List, AbstractMapBasedMultimap<K, V>.WrappedCollection param1WrappedCollection) {
      super(this$0, param1K, param1List, param1WrappedCollection);
    }
    
    public void add(int param1Int, V param1V) {
      a();
      boolean bool = e().isEmpty();
      g().add(param1Int, param1V);
      AbstractMapBasedMultimap.c(this.g);
      if (bool)
        d(); 
    }
    
    public boolean addAll(int param1Int, Collection<? extends V> param1Collection) {
      if (param1Collection.isEmpty())
        return false; 
      int i = size();
      boolean bool = g().addAll(param1Int, param1Collection);
      if (bool) {
        param1Int = e().size();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.g;
        AbstractMapBasedMultimap.a(abstractMapBasedMultimap, AbstractMapBasedMultimap.d(abstractMapBasedMultimap) + param1Int - i);
        if (i == 0)
          d(); 
      } 
      return bool;
    }
    
    List<V> g() {
      return (List<V>)e();
    }
    
    public V get(int param1Int) {
      a();
      return g().get(param1Int);
    }
    
    public int indexOf(Object param1Object) {
      a();
      return g().indexOf(param1Object);
    }
    
    public int lastIndexOf(Object param1Object) {
      a();
      return g().lastIndexOf(param1Object);
    }
    
    public ListIterator<V> listIterator() {
      a();
      return new WrappedListIterator(this);
    }
    
    public ListIterator<V> listIterator(int param1Int) {
      a();
      return new WrappedListIterator(this, param1Int);
    }
    
    public V remove(int param1Int) {
      a();
      V v = g().remove(param1Int);
      AbstractMapBasedMultimap.b(this.g);
      b();
      return v;
    }
    
    public V set(int param1Int, V param1V) {
      a();
      return g().set(param1Int, param1V);
    }
    
    public List<V> subList(int param1Int1, int param1Int2) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      a();
      AbstractMapBasedMultimap<K, V> abstractMapBasedMultimap = this.g;
      K k = c();
      List<V> list = g().subList(param1Int1, param1Int2);
      if (f() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = f();
      } 
      return abstractMapBasedMultimap.a(k, list, wrappedCollection);
    }
    
    class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator implements ListIterator<V> {
      WrappedListIterator(AbstractMapBasedMultimap.WrappedList this$0) {
        super(this$0);
      }
      
      public WrappedListIterator(AbstractMapBasedMultimap.WrappedList this$0, int param2Int) {
        super(this$0, this$0.g().listIterator(param2Int));
      }
      
      private ListIterator<V> c() {
        return (ListIterator<V>)b();
      }
      
      public void add(V param2V) {
        boolean bool = this.d.isEmpty();
        c().add(param2V);
        AbstractMapBasedMultimap.c(this.d.g);
        if (bool)
          this.d.d(); 
      }
      
      public boolean hasPrevious() {
        return c().hasPrevious();
      }
      
      public int nextIndex() {
        return c().nextIndex();
      }
      
      public V previous() {
        return c().previous();
      }
      
      public int previousIndex() {
        return c().previousIndex();
      }
      
      public void set(V param2V) {
        c().set(param2V);
      }
    }
  }
  
  class WrappedListIterator extends WrappedCollection.WrappedIterator implements ListIterator<V> {
    WrappedListIterator(AbstractMapBasedMultimap this$0) {
      super((AbstractMapBasedMultimap.WrappedCollection)this$0);
    }
    
    public WrappedListIterator(AbstractMapBasedMultimap this$0, int param1Int) {
      super((AbstractMapBasedMultimap.WrappedCollection)this$0, this$0.g().listIterator(param1Int));
    }
    
    private ListIterator<V> c() {
      return (ListIterator<V>)b();
    }
    
    public void add(V param1V) {
      boolean bool = this.d.isEmpty();
      c().add(param1V);
      AbstractMapBasedMultimap.c(this.d.g);
      if (bool)
        this.d.d(); 
    }
    
    public boolean hasPrevious() {
      return c().hasPrevious();
    }
    
    public int nextIndex() {
      return c().nextIndex();
    }
    
    public V previous() {
      return c().previous();
    }
    
    public int previousIndex() {
      return c().previousIndex();
    }
    
    public void set(V param1V) {
      c().set(param1V);
    }
  }
  
  class WrappedNavigableSet extends WrappedSortedSet implements NavigableSet<V> {
    WrappedNavigableSet(@NullableDecl AbstractMapBasedMultimap this$0, K param1K, @NullableDecl NavigableSet<V> param1NavigableSet, AbstractMapBasedMultimap<K, V>.WrappedCollection param1WrappedCollection) {
      super(this$0, param1K, param1NavigableSet, param1WrappedCollection);
    }
    
    private NavigableSet<V> a(NavigableSet<V> param1NavigableSet) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      AbstractMapBasedMultimap abstractMapBasedMultimap = this.a;
      K k = this.b;
      if (f() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = f();
      } 
      return new WrappedNavigableSet(abstractMapBasedMultimap, k, param1NavigableSet, wrappedCollection);
    }
    
    public V ceiling(V param1V) {
      return g().ceiling(param1V);
    }
    
    public Iterator<V> descendingIterator() {
      return new AbstractMapBasedMultimap.WrappedCollection.WrappedIterator(this, g().descendingIterator());
    }
    
    public NavigableSet<V> descendingSet() {
      return a(g().descendingSet());
    }
    
    public V floor(V param1V) {
      return g().floor(param1V);
    }
    
    NavigableSet<V> g() {
      return (NavigableSet<V>)super.h();
    }
    
    public NavigableSet<V> headSet(V param1V, boolean param1Boolean) {
      return a(g().headSet(param1V, param1Boolean));
    }
    
    public V higher(V param1V) {
      return g().higher(param1V);
    }
    
    public V lower(V param1V) {
      return g().lower(param1V);
    }
    
    public V pollFirst() {
      return Iterators.g(iterator());
    }
    
    public V pollLast() {
      return Iterators.g(descendingIterator());
    }
    
    public NavigableSet<V> subSet(V param1V1, boolean param1Boolean1, V param1V2, boolean param1Boolean2) {
      return a(g().subSet(param1V1, param1Boolean1, param1V2, param1Boolean2));
    }
    
    public NavigableSet<V> tailSet(V param1V, boolean param1Boolean) {
      return a(g().tailSet(param1V, param1Boolean));
    }
  }
  
  class WrappedSet extends WrappedCollection implements Set<V> {
    WrappedSet(@NullableDecl AbstractMapBasedMultimap this$0, K param1K, Set<V> param1Set) {
      super(this$0, param1K, param1Set, null);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      if (param1Collection.isEmpty())
        return false; 
      int i = size();
      boolean bool = Sets.a((Set)this.c, param1Collection);
      if (bool) {
        int j = this.c.size();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.a;
        AbstractMapBasedMultimap.a(abstractMapBasedMultimap, AbstractMapBasedMultimap.d(abstractMapBasedMultimap) + j - i);
        b();
      } 
      return bool;
    }
  }
  
  class WrappedSortedSet extends WrappedCollection implements SortedSet<V> {
    WrappedSortedSet(@NullableDecl AbstractMapBasedMultimap this$0, K param1K, @NullableDecl SortedSet<V> param1SortedSet, AbstractMapBasedMultimap<K, V>.WrappedCollection param1WrappedCollection) {
      super(this$0, param1K, param1SortedSet, param1WrappedCollection);
    }
    
    public Comparator<? super V> comparator() {
      return h().comparator();
    }
    
    public V first() {
      a();
      return h().first();
    }
    
    SortedSet<V> h() {
      return (SortedSet<V>)e();
    }
    
    public SortedSet<V> headSet(V param1V) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      a();
      AbstractMapBasedMultimap abstractMapBasedMultimap = this.g;
      K k = c();
      SortedSet<V> sortedSet = h().headSet(param1V);
      if (f() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = f();
      } 
      return new WrappedSortedSet(abstractMapBasedMultimap, k, sortedSet, wrappedCollection);
    }
    
    public V last() {
      a();
      return h().last();
    }
    
    public SortedSet<V> subSet(V param1V1, V param1V2) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      a();
      AbstractMapBasedMultimap abstractMapBasedMultimap = this.g;
      K k = c();
      SortedSet<V> sortedSet = h().subSet(param1V1, param1V2);
      if (f() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = f();
      } 
      return new WrappedSortedSet(abstractMapBasedMultimap, k, sortedSet, wrappedCollection);
    }
    
    public SortedSet<V> tailSet(V param1V) {
      AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection;
      a();
      AbstractMapBasedMultimap abstractMapBasedMultimap = this.g;
      K k = c();
      SortedSet<V> sortedSet = h().tailSet(param1V);
      if (f() == null) {
        wrappedCollection = this;
      } else {
        wrappedCollection = f();
      } 
      return new WrappedSortedSet(abstractMapBasedMultimap, k, sortedSet, wrappedCollection);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractMapBasedMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */