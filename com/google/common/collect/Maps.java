package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Maps {
  static int a(int paramInt) {
    if (paramInt < 3) {
      CollectPreconditions.a(paramInt, "expectedSize");
      return paramInt + 1;
    } 
    return (paramInt < 1073741824) ? (int)(paramInt / 0.75F + 1.0F) : Integer.MAX_VALUE;
  }
  
  static <K> Function<Map.Entry<K, ?>, K> a() {
    return EntryFunction.a;
  }
  
  static <K, V1, V2> Function<Map.Entry<K, V1>, V2> a(EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    Preconditions.a(paramEntryTransformer);
    return new Function<Map.Entry<K, V1>, V2>(paramEntryTransformer) {
        public V2 a(Map.Entry<K, V1> param1Entry) {
          return (V2)this.a.a(param1Entry.getKey(), param1Entry.getValue());
        }
      };
  }
  
  static <K, V1, V2> Function<V1, V2> a(EntryTransformer<? super K, V1, V2> paramEntryTransformer, K paramK) {
    Preconditions.a(paramEntryTransformer);
    return new Function<V1, V2>(paramEntryTransformer, paramK) {
        public V2 f(@NullableDecl V1 param1V1) {
          return this.a.a(this.b, param1V1);
        }
      };
  }
  
  static <K> Predicate<Map.Entry<K, ?>> a(Predicate<? super K> paramPredicate) {
    return Predicates.a(paramPredicate, a());
  }
  
  static <E> ImmutableMap<E, Integer> a(Collection<E> paramCollection) {
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder<Object, Object>(paramCollection.size());
    Iterator<E> iterator = paramCollection.iterator();
    for (int i = 0; iterator.hasNext(); i++)
      builder.b(iterator.next(), Integer.valueOf(i)); 
    return (ImmutableMap)builder.b();
  }
  
  static <K, V1, V2> EntryTransformer<K, V1, V2> a(Function<? super V1, V2> paramFunction) {
    Preconditions.a(paramFunction);
    return new EntryTransformer<K, V1, V2>(paramFunction) {
        public V2 a(K param1K, V1 param1V1) {
          return (V2)this.a.f(param1V1);
        }
      };
  }
  
  static <V> V a(Map<?, V> paramMap, @NullableDecl Object paramObject) {
    Preconditions.a(paramMap);
    try {
      return paramMap.get(paramObject);
    } catch (ClassCastException|NullPointerException classCastException) {
      return null;
    } 
  }
  
  static String a(Map<?, ?> paramMap) {
    StringBuilder stringBuilder = Collections2.a(paramMap.size());
    stringBuilder.append('{');
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (!bool)
        stringBuilder.append(", "); 
      bool = false;
      stringBuilder.append(entry.getKey());
      stringBuilder.append('=');
      stringBuilder.append(entry.getValue());
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  static <K, V> Iterator<K> a(Iterator<Map.Entry<K, V>> paramIterator) {
    return new TransformedIterator<Map.Entry<K, V>, K>(paramIterator) {
        K a(Map.Entry<K, V> param1Entry) {
          return param1Entry.getKey();
        }
      };
  }
  
  static <V2, K, V1> Map.Entry<K, V2> a(EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer, Map.Entry<K, V1> paramEntry) {
    Preconditions.a(paramEntryTransformer);
    Preconditions.a(paramEntry);
    return new AbstractMapEntry<K, V2>(paramEntry, paramEntryTransformer) {
        public K getKey() {
          return (K)this.a.getKey();
        }
        
        public V2 getValue() {
          return (V2)this.b.a(this.a.getKey(), this.a.getValue());
        }
      };
  }
  
  public static <K, V> Map.Entry<K, V> a(@NullableDecl K paramK, @NullableDecl V paramV) {
    return new ImmutableEntry<K, V>(paramK, paramV);
  }
  
  static <K, V> Map.Entry<K, V> a(Map.Entry<? extends K, ? extends V> paramEntry) {
    Preconditions.a(paramEntry);
    return new AbstractMapEntry<K, V>(paramEntry) {
        public K getKey() {
          return (K)this.a.getKey();
        }
        
        public V getValue() {
          return (V)this.a.getValue();
        }
      };
  }
  
  private static <K, V> Map<K, V> a(AbstractFilteredMap<K, V> paramAbstractFilteredMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    return new FilteredEntryMap<K, V>(paramAbstractFilteredMap.a, Predicates.a(paramAbstractFilteredMap.b, paramPredicate));
  }
  
  public static <K, V1, V2> Map<K, V2> a(Map<K, V1> paramMap, Function<? super V1, V2> paramFunction) {
    return a(paramMap, a(paramFunction));
  }
  
  public static <K, V> Map<K, V> a(Map<K, V> paramMap, Predicate<? super K> paramPredicate) {
    Preconditions.a(paramPredicate);
    Predicate<Map.Entry<K, ?>> predicate = a(paramPredicate);
    return (paramMap instanceof AbstractFilteredMap) ? a((AbstractFilteredMap<K, V>)paramMap, (Predicate)predicate) : new FilteredKeyMap<K, V>((Map<K, V>)Preconditions.a(paramMap), paramPredicate, (Predicate)predicate);
  }
  
  public static <K, V1, V2> Map<K, V2> a(Map<K, V1> paramMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesMap<K, V1, V2>(paramMap, paramEntryTransformer);
  }
  
  public static <K, V> Map<K, V> a(Set<K> paramSet, Function<? super K, V> paramFunction) {
    return new AsMapView<K, V>(paramSet, paramFunction);
  }
  
  private static <K, V> NavigableMap<K, V> a(FilteredEntryNavigableMap<K, V> paramFilteredEntryNavigableMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    paramPredicate = Predicates.a(FilteredEntryNavigableMap.a(paramFilteredEntryNavigableMap), paramPredicate);
    return new FilteredEntryNavigableMap<K, V>(FilteredEntryNavigableMap.b(paramFilteredEntryNavigableMap), paramPredicate);
  }
  
  public static <K, V> NavigableMap<K, V> a(NavigableMap<K, ? extends V> paramNavigableMap) {
    Preconditions.a(paramNavigableMap);
    return (paramNavigableMap instanceof UnmodifiableNavigableMap) ? paramNavigableMap : new UnmodifiableNavigableMap<K, V>(paramNavigableMap);
  }
  
  public static <K, V> NavigableMap<K, V> a(NavigableMap<K, V> paramNavigableMap, Predicate<? super Map.Entry<K, V>> paramPredicate) {
    Preconditions.a(paramPredicate);
    return (paramNavigableMap instanceof FilteredEntryNavigableMap) ? a((FilteredEntryNavigableMap<K, V>)paramNavigableMap, paramPredicate) : new FilteredEntryNavigableMap<K, V>((NavigableMap<K, V>)Preconditions.a(paramNavigableMap), paramPredicate);
  }
  
  public static <K, V1, V2> NavigableMap<K, V2> a(NavigableMap<K, V1> paramNavigableMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesNavigableMap<K, V1, V2>(paramNavigableMap, paramEntryTransformer);
  }
  
  public static <K, V> NavigableMap<K, V> a(NavigableSet<K> paramNavigableSet, Function<? super K, V> paramFunction) {
    return new NavigableAsMapView<K, V>(paramNavigableSet, paramFunction);
  }
  
  static <K, V> Set<Map.Entry<K, V>> a(Set<Map.Entry<K, V>> paramSet) {
    return new UnmodifiableEntrySet<K, V>(Collections.unmodifiableSet(paramSet));
  }
  
  public static <K, V1, V2> SortedMap<K, V2> a(SortedMap<K, V1> paramSortedMap, Function<? super V1, V2> paramFunction) {
    return a(paramSortedMap, a(paramFunction));
  }
  
  public static <K, V1, V2> SortedMap<K, V2> a(SortedMap<K, V1> paramSortedMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesSortedMap<K, V1, V2>(paramSortedMap, paramEntryTransformer);
  }
  
  public static <K, V> SortedMap<K, V> a(SortedSet<K> paramSortedSet, Function<? super K, V> paramFunction) {
    return new SortedAsMapView<K, V>(paramSortedSet, paramFunction);
  }
  
  static <K, V> boolean a(Collection<Map.Entry<K, V>> paramCollection, Object paramObject) {
    return !(paramObject instanceof Map.Entry) ? false : paramCollection.contains(a((Map.Entry<?, ?>)paramObject));
  }
  
  static <V> Function<Map.Entry<?, V>, V> b() {
    return EntryFunction.b;
  }
  
  static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> b(EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    Preconditions.a(paramEntryTransformer);
    return new Function<Map.Entry<K, V1>, Map.Entry<K, V2>>(paramEntryTransformer) {
        public Map.Entry<K, V2> a(Map.Entry<K, V1> param1Entry) {
          return Maps.a(this.a, param1Entry);
        }
      };
  }
  
  static <V> Predicate<Map.Entry<?, V>> b(Predicate<? super V> paramPredicate) {
    return Predicates.a(paramPredicate, b());
  }
  
  @NullableDecl
  static <K> K b(@NullableDecl Map.Entry<K, ?> paramEntry) {
    return (paramEntry == null) ? null : paramEntry.getKey();
  }
  
  static <K, V> Iterator<V> b(Iterator<Map.Entry<K, V>> paramIterator) {
    return new TransformedIterator<Map.Entry<K, V>, V>(paramIterator) {
        V a(Map.Entry<K, V> param1Entry) {
          return param1Entry.getValue();
        }
      };
  }
  
  static <K, V> Iterator<Map.Entry<K, V>> b(Set<K> paramSet, Function<? super K, V> paramFunction) {
    return new TransformedIterator<K, Map.Entry<K, V>>(paramSet.iterator(), paramFunction) {
        Map.Entry<K, V> b(K param1K) {
          return Maps.a(param1K, (V)this.a.f(param1K));
        }
      };
  }
  
  public static <K, V> LinkedHashMap<K, V> b(int paramInt) {
    return new LinkedHashMap<K, V>(a(paramInt));
  }
  
  private static <E> NavigableSet<E> b(NavigableSet<E> paramNavigableSet) {
    return new ForwardingNavigableSet<E>(paramNavigableSet) {
        public boolean add(E param1E) {
          throw new UnsupportedOperationException();
        }
        
        public boolean addAll(Collection<? extends E> param1Collection) {
          throw new UnsupportedOperationException();
        }
        
        protected NavigableSet<E> d() {
          return this.a;
        }
        
        public NavigableSet<E> descendingSet() {
          return Maps.a(super.descendingSet());
        }
        
        public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
          return Maps.a(super.headSet(param1E, param1Boolean));
        }
        
        public SortedSet<E> headSet(E param1E) {
          return Maps.a(super.headSet(param1E));
        }
        
        public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
          return Maps.a(super.subSet(param1E1, param1Boolean1, param1E2, param1Boolean2));
        }
        
        public SortedSet<E> subSet(E param1E1, E param1E2) {
          return Maps.a(super.subSet(param1E1, param1E2));
        }
        
        public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
          return Maps.a(super.tailSet(param1E, param1Boolean));
        }
        
        public SortedSet<E> tailSet(E param1E) {
          return Maps.a(super.tailSet(param1E));
        }
      };
  }
  
  private static <E> SortedSet<E> b(SortedSet<E> paramSortedSet) {
    return new ForwardingSortedSet<E>(paramSortedSet) {
        public boolean add(E param1E) {
          throw new UnsupportedOperationException();
        }
        
        public boolean addAll(Collection<? extends E> param1Collection) {
          throw new UnsupportedOperationException();
        }
        
        protected SortedSet<E> e() {
          return this.a;
        }
        
        public SortedSet<E> headSet(E param1E) {
          return Maps.a(super.headSet(param1E));
        }
        
        public SortedSet<E> subSet(E param1E1, E param1E2) {
          return Maps.a(super.subSet(param1E1, param1E2));
        }
        
        public SortedSet<E> tailSet(E param1E) {
          return Maps.a(super.tailSet(param1E));
        }
      };
  }
  
  static <K, V> boolean b(Collection<Map.Entry<K, V>> paramCollection, Object paramObject) {
    return !(paramObject instanceof Map.Entry) ? false : paramCollection.remove(a((Map.Entry<?, ?>)paramObject));
  }
  
  static boolean b(Map<?, ?> paramMap, Object paramObject) {
    Preconditions.a(paramMap);
    try {
      return paramMap.containsKey(paramObject);
    } catch (ClassCastException|NullPointerException classCastException) {
      return false;
    } 
  }
  
  static <K, V> UnmodifiableIterator<Map.Entry<K, V>> c(Iterator<Map.Entry<K, V>> paramIterator) {
    return new UnmodifiableIterator<Map.Entry<K, V>>(paramIterator) {
        public Map.Entry<K, V> a() {
          return Maps.a(this.a.next());
        }
        
        public boolean hasNext() {
          return this.a.hasNext();
        }
      };
  }
  
  @NullableDecl
  static <V> V c(@NullableDecl Map.Entry<?, V> paramEntry) {
    return (paramEntry == null) ? null : paramEntry.getValue();
  }
  
  static <V> V c(Map<?, V> paramMap, Object paramObject) {
    Preconditions.a(paramMap);
    try {
      return paramMap.remove(paramObject);
    } catch (ClassCastException|NullPointerException classCastException) {
      return null;
    } 
  }
  
  public static <K, V> HashMap<K, V> c() {
    return new HashMap<K, V>();
  }
  
  private static <E> Set<E> c(Set<E> paramSet) {
    return new ForwardingSet<E>(paramSet) {
        protected Set<E> a() {
          return this.a;
        }
        
        public boolean add(E param1E) {
          throw new UnsupportedOperationException();
        }
        
        public boolean addAll(Collection<? extends E> param1Collection) {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  public static <K, V> LinkedHashMap<K, V> d() {
    return new LinkedHashMap<K, V>();
  }
  
  static boolean d(Map<?, ?> paramMap, Object paramObject) {
    if (paramMap == paramObject)
      return true; 
    if (paramObject instanceof Map) {
      paramObject = paramObject;
      return paramMap.entrySet().equals(paramObject.entrySet());
    } 
    return false;
  }
  
  @NullableDecl
  private static <K, V> Map.Entry<K, V> e(@NullableDecl Map.Entry<K, ? extends V> paramEntry) {
    return (paramEntry == null) ? null : a(paramEntry);
  }
  
  public static <K, V> ConcurrentMap<K, V> e() {
    return new ConcurrentHashMap<K, V>();
  }
  
  public static <K extends Comparable, V> TreeMap<K, V> f() {
    return new TreeMap<K, V>();
  }
  
  public static <K, V> IdentityHashMap<K, V> g() {
    return new IdentityHashMap<K, V>();
  }
  
  static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {
    final Map<K, V> a;
    
    final Predicate<? super Map.Entry<K, V>> b;
    
    AbstractFilteredMap(Map<K, V> param1Map, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      this.a = param1Map;
      this.b = param1Predicate;
    }
    
    boolean a(@NullableDecl Object param1Object, @NullableDecl V param1V) {
      return this.b.a(Maps.a(param1Object, param1V));
    }
    
    Collection<V> b() {
      return new Maps.FilteredMapValues<K, V>(this, this.a, this.b);
    }
    
    public boolean containsKey(Object param1Object) {
      return (this.a.containsKey(param1Object) && a(param1Object, this.a.get(param1Object)));
    }
    
    public V get(Object param1Object) {
      V v = this.a.get(param1Object);
      return (v != null && a(param1Object, v)) ? v : null;
    }
    
    public boolean isEmpty() {
      return entrySet().isEmpty();
    }
    
    public V put(K param1K, V param1V) {
      Preconditions.a(a(param1K, param1V));
      return this.a.put(param1K, param1V);
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      for (Map.Entry<? extends K, ? extends V> entry : param1Map.entrySet())
        Preconditions.a(a(entry.getKey(), (V)entry.getValue())); 
      this.a.putAll(param1Map);
    }
    
    public V remove(Object param1Object) {
      return containsKey(param1Object) ? this.a.remove(param1Object) : null;
    }
  }
  
  static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {
    final Function<? super K, V> a;
    
    private final Set<K> b;
    
    AsMapView(Set<K> param1Set, Function<? super K, V> param1Function) {
      this.b = (Set<K>)Preconditions.a(param1Set);
      this.a = (Function<? super K, V>)Preconditions.a(param1Function);
    }
    
    protected Set<Map.Entry<K, V>> a() {
      class EntrySetImpl extends Maps.EntrySet<K, V> {
        EntrySetImpl(Maps.AsMapView this$0) {}
        
        Map<K, V> a() {
          return this.a;
        }
        
        public Iterator<Map.Entry<K, V>> iterator() {
          return Maps.b(this.a.c(), this.a.a);
        }
      };
      return new EntrySetImpl(this);
    }
    
    Collection<V> b() {
      return Collections2.a(this.b, this.a);
    }
    
    Set<K> c() {
      return this.b;
    }
    
    public void clear() {
      c().clear();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return c().contains(param1Object);
    }
    
    public V get(@NullableDecl Object param1Object) {
      return (V)(Collections2.a(c(), param1Object) ? this.a.f(param1Object) : null);
    }
    
    public Set<K> h() {
      return Maps.b(c());
    }
    
    public V remove(@NullableDecl Object param1Object) {
      return (V)(c().remove(param1Object) ? this.a.f(param1Object) : null);
    }
    
    public int size() {
      return c().size();
    }
  }
  
  class EntrySetImpl extends EntrySet<K, V> {
    EntrySetImpl(Maps this$0) {}
    
    Map<K, V> a() {
      return this.a;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return Maps.b(this.a.c(), this.a.a);
    }
  }
  
  static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
    private final BiMap<A, B> a;
    
    private static <X, Y> Y a(BiMap<X, Y> param1BiMap, X param1X) {
      boolean bool;
      param1BiMap = (BiMap<X, Y>)param1BiMap.get(param1X);
      if (param1BiMap != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool, "No non-null mapping present for input: %s", param1X);
      return (Y)param1BiMap;
    }
    
    public A a(B param1B) {
      return a(this.a.ay_(), param1B);
    }
    
    public B b(A param1A) {
      return a(this.a, param1A);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof BiMapConverter) {
        param1Object = param1Object;
        return this.a.equals(((BiMapConverter)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Maps.asConverter(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
    @NullableDecl
    private transient Comparator<? super K> a;
    
    @NullableDecl
    private transient Set<Map.Entry<K, V>> b;
    
    @NullableDecl
    private transient NavigableSet<K> c;
    
    private static <T> Ordering<T> a(Comparator<T> param1Comparator) {
      return Ordering.<T>a(param1Comparator).a();
    }
    
    protected final Map<K, V> a() {
      return c();
    }
    
    abstract NavigableMap<K, V> c();
    
    public Map.Entry<K, V> ceilingEntry(K param1K) {
      return c().floorEntry(param1K);
    }
    
    public K ceilingKey(K param1K) {
      return c().floorKey(param1K);
    }
    
    public Comparator<? super K> comparator() {
      Comparator<? super K> comparator2 = this.a;
      Comparator<? super K> comparator1 = comparator2;
      if (comparator2 == null) {
        comparator2 = c().comparator();
        comparator1 = comparator2;
        if (comparator2 == null)
          comparator1 = Ordering.d(); 
        comparator1 = a(comparator1);
        this.a = comparator1;
      } 
      return comparator1;
    }
    
    abstract Iterator<Map.Entry<K, V>> d();
    
    public NavigableSet<K> descendingKeySet() {
      return c().navigableKeySet();
    }
    
    public NavigableMap<K, V> descendingMap() {
      return c();
    }
    
    Set<Map.Entry<K, V>> e() {
      class EntrySetImpl extends Maps.EntrySet<K, V> {
        EntrySetImpl(Maps.DescendingMap this$0) {}
        
        Map<K, V> a() {
          return this.a;
        }
        
        public Iterator<Map.Entry<K, V>> iterator() {
          return this.a.d();
        }
      };
      return new EntrySetImpl(this);
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      Set<Map.Entry<K, V>> set2 = this.b;
      Set<Map.Entry<K, V>> set1 = set2;
      if (set2 == null) {
        set1 = e();
        this.b = set1;
      } 
      return set1;
    }
    
    public Map.Entry<K, V> firstEntry() {
      return c().lastEntry();
    }
    
    public K firstKey() {
      return c().lastKey();
    }
    
    public Map.Entry<K, V> floorEntry(K param1K) {
      return c().ceilingEntry(param1K);
    }
    
    public K floorKey(K param1K) {
      return c().ceilingKey(param1K);
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      return c().tailMap(param1K, param1Boolean).descendingMap();
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return headMap(param1K, false);
    }
    
    public Map.Entry<K, V> higherEntry(K param1K) {
      return c().lowerEntry(param1K);
    }
    
    public K higherKey(K param1K) {
      return c().lowerKey(param1K);
    }
    
    public Set<K> keySet() {
      return navigableKeySet();
    }
    
    public Map.Entry<K, V> lastEntry() {
      return c().firstEntry();
    }
    
    public K lastKey() {
      return c().firstKey();
    }
    
    public Map.Entry<K, V> lowerEntry(K param1K) {
      return c().higherEntry(param1K);
    }
    
    public K lowerKey(K param1K) {
      return c().higherKey(param1K);
    }
    
    public NavigableSet<K> navigableKeySet() {
      NavigableSet<K> navigableSet2 = this.c;
      NavigableSet<K> navigableSet1 = navigableSet2;
      if (navigableSet2 == null) {
        navigableSet1 = new Maps.NavigableKeySet<K, Object>(this);
        this.c = navigableSet1;
      } 
      return navigableSet1;
    }
    
    public Map.Entry<K, V> pollFirstEntry() {
      return c().pollLastEntry();
    }
    
    public Map.Entry<K, V> pollLastEntry() {
      return c().pollFirstEntry();
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return c().subMap(param1K2, param1Boolean2, param1K1, param1Boolean1).descendingMap();
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      return c().headMap(param1K, param1Boolean).descendingMap();
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return tailMap(param1K, true);
    }
    
    public String toString() {
      return f();
    }
    
    public Collection<V> values() {
      return new Maps.Values<Object, V>(this);
    }
  }
  
  class EntrySetImpl extends EntrySet<K, V> {
    EntrySetImpl(Maps this$0) {}
    
    Map<K, V> a() {
      return this.a;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return this.a.d();
    }
  }
  
  enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
    a {
      @NullableDecl
      public Object a(Map.Entry<?, ?> param2Entry) {
        return param2Entry.getKey();
      }
    },
    b {
      @NullableDecl
      public Object a(Map.Entry<?, ?> param2Entry) {
        return param2Entry.getValue();
      }
    };
  }
  
  enum null {
    @NullableDecl
    public Object a(Map.Entry<?, ?> param1Entry) {
      return param1Entry.getKey();
    }
  }
  
  enum null {
    @NullableDecl
    public Object a(Map.Entry<?, ?> param1Entry) {
      return param1Entry.getValue();
    }
  }
  
  static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
    abstract Map<K, V> a();
    
    public void clear() {
      a().clear();
    }
    
    public boolean contains(Object param1Object) {
      boolean bool1 = param1Object instanceof Map.Entry;
      boolean bool = false;
      null = bool;
      if (bool1) {
        param1Object = param1Object;
        Object object = param1Object.getKey();
        Object object1 = Maps.a((Map)a(), object);
        null = bool;
        if (Objects.a(object1, param1Object.getValue())) {
          if (object1 == null) {
            null = bool;
            return a().containsKey(object) ? true : null;
          } 
        } else {
          return null;
        } 
      } else {
        return null;
      } 
      return true;
    }
    
    public boolean isEmpty() {
      return a().isEmpty();
    }
    
    public boolean remove(Object param1Object) {
      if (contains(param1Object)) {
        param1Object = param1Object;
        return a().keySet().remove(param1Object.getKey());
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      try {
        return super.removeAll((Collection)Preconditions.a(param1Collection));
      } catch (UnsupportedOperationException unsupportedOperationException) {
        return Sets.a(this, param1Collection.iterator());
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      try {
        return super.retainAll((Collection)Preconditions.a(param1Collection));
      } catch (UnsupportedOperationException unsupportedOperationException) {
        HashSet<?> hashSet = Sets.a(param1Collection.size());
        for (Object object : param1Collection) {
          if (contains(object))
            hashSet.add(((Map.Entry)object).getKey()); 
        } 
        return a().keySet().retainAll(hashSet);
      } 
    }
    
    public int size() {
      return a().size();
    }
  }
  
  public static interface EntryTransformer<K, V1, V2> {
    V2 a(@NullableDecl K param1K, @NullableDecl V1 param1V1);
  }
  
  static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
    private final BiMap<V, K> d;
    
    public BiMap<V, K> ay_() {
      return this.d;
    }
    
    public Set<V> d() {
      return this.d.keySet();
    }
  }
  
  static final class null implements Predicate<Map.Entry<V, K>> {
    public boolean a(Map.Entry<V, K> param1Entry) {
      return this.a.a(Maps.a(param1Entry.getValue(), param1Entry.getKey()));
    }
  }
  
  static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
    final Set<Map.Entry<K, V>> c;
    
    FilteredEntryMap(Map<K, V> param1Map, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      super(param1Map, param1Predicate);
      this.c = Sets.a(param1Map.entrySet(), this.b);
    }
    
    static <K, V> boolean a(Map<K, V> param1Map, Predicate<? super Map.Entry<K, V>> param1Predicate, Collection<?> param1Collection) {
      Iterator<Map.Entry> iterator = param1Map.entrySet().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (param1Predicate.a(entry) && param1Collection.contains(entry.getKey())) {
          iterator.remove();
          bool = true;
        } 
      } 
      return bool;
    }
    
    static <K, V> boolean b(Map<K, V> param1Map, Predicate<? super Map.Entry<K, V>> param1Predicate, Collection<?> param1Collection) {
      Iterator<Map.Entry> iterator = param1Map.entrySet().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (param1Predicate.a(entry) && !param1Collection.contains(entry.getKey())) {
          iterator.remove();
          bool = true;
        } 
      } 
      return bool;
    }
    
    protected Set<Map.Entry<K, V>> a() {
      return new EntrySet();
    }
    
    Set<K> h() {
      return new KeySet(this);
    }
    
    class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
      private EntrySet(Maps.FilteredEntryMap this$0) {}
      
      protected Set<Map.Entry<K, V>> a() {
        return this.a.c;
      }
      
      public Iterator<Map.Entry<K, V>> iterator() {
        return new TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>(this, this.a.c.iterator()) {
            Map.Entry<K, V> a(Map.Entry<K, V> param3Entry) {
              return new ForwardingMapEntry<K, V>(this, param3Entry) {
                  protected Map.Entry<K, V> a() {
                    return this.a;
                  }
                  
                  public V setValue(V param4V) {
                    Preconditions.a(this.b.a.a.a(getKey(), param4V));
                    return super.setValue(param4V);
                  }
                };
            }
          };
      }
    }
    
    class null extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>> {
      null(Maps.FilteredEntryMap this$0, Iterator<? extends Map.Entry<K, V>> param2Iterator) {
        super(param2Iterator);
      }
      
      Map.Entry<K, V> a(Map.Entry<K, V> param2Entry) {
        return new ForwardingMapEntry<K, V>(this, param2Entry) {
            protected Map.Entry<K, V> a() {
              return this.a;
            }
            
            public V setValue(V param4V) {
              Preconditions.a(this.b.a.a.a(getKey(), param4V));
              return super.setValue(param4V);
            }
          };
      }
    }
    
    class null extends ForwardingMapEntry<K, V> {
      protected Map.Entry<K, V> a() {
        return this.a;
      }
      
      public V setValue(V param2V) {
        Preconditions.a(this.b.a.a.a(getKey(), param2V));
        return super.setValue(param2V);
      }
    }
    
    class KeySet extends Maps.KeySet<K, V> {
      KeySet(Maps.FilteredEntryMap<K, V> this$0) {
        super(this$0);
      }
      
      public boolean remove(Object param2Object) {
        if (this.a.containsKey(param2Object)) {
          this.a.a.remove(param2Object);
          return true;
        } 
        return false;
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        return Maps.FilteredEntryMap.a(this.a.a, this.a.b, param2Collection);
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return Maps.FilteredEntryMap.b(this.a.a, this.a.b, param2Collection);
      }
      
      public Object[] toArray() {
        return Lists.<K>a(iterator()).toArray();
      }
      
      public <T> T[] toArray(T[] param2ArrayOfT) {
        return (T[])Lists.<K>a(iterator()).toArray((Object[])param2ArrayOfT);
      }
    }
  }
  
  class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
    private EntrySet(Maps this$0) {}
    
    protected Set<Map.Entry<K, V>> a() {
      return this.a.c;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return new TransformedIterator(this, this.a.c.iterator()) {
          Map.Entry<K, V> a(Map.Entry<K, V> param3Entry) {
            return new ForwardingMapEntry<K, V>(this, param3Entry) {
                protected Map.Entry<K, V> a() {
                  return this.a;
                }
                
                public V setValue(V param4V) {
                  Preconditions.a(this.b.a.a.a(getKey(), param4V));
                  return super.setValue(param4V);
                }
              };
          }
        };
    }
  }
  
  class null extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>> {
    null(Maps this$0, Iterator<? extends Map.Entry<K, V>> param1Iterator) {
      super(param1Iterator);
    }
    
    Map.Entry<K, V> a(Map.Entry<K, V> param1Entry) {
      return new ForwardingMapEntry<K, V>(this, param1Entry) {
          protected Map.Entry<K, V> a() {
            return this.a;
          }
          
          public V setValue(V param4V) {
            Preconditions.a(this.b.a.a.a(getKey(), param4V));
            return super.setValue(param4V);
          }
        };
    }
  }
  
  class null extends ForwardingMapEntry<K, V> {
    protected Map.Entry<K, V> a() {
      return this.a;
    }
    
    public V setValue(V param1V) {
      Preconditions.a(this.b.a.a.a(getKey(), param1V));
      return super.setValue(param1V);
    }
  }
  
  class KeySet extends KeySet<K, V> {
    KeySet(Maps this$0) {
      super((Map<K, V>)this$0);
    }
    
    public boolean remove(Object param1Object) {
      if (this.a.containsKey(param1Object)) {
        this.a.a.remove(param1Object);
        return true;
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return Maps.FilteredEntryMap.a(this.a.a, this.a.b, param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return Maps.FilteredEntryMap.b(this.a.a, this.a.b, param1Collection);
    }
    
    public Object[] toArray() {
      return Lists.<K>a(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])Lists.<K>a(iterator()).toArray((Object[])param1ArrayOfT);
    }
  }
  
  static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
    private final NavigableMap<K, V> a;
    
    private final Predicate<? super Map.Entry<K, V>> b;
    
    private final Map<K, V> c;
    
    FilteredEntryNavigableMap(NavigableMap<K, V> param1NavigableMap, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      this.a = (NavigableMap<K, V>)Preconditions.a(param1NavigableMap);
      this.b = param1Predicate;
      this.c = new Maps.FilteredEntryMap<K, V>(param1NavigableMap, param1Predicate);
    }
    
    Iterator<Map.Entry<K, V>> a() {
      return Iterators.b(this.a.descendingMap().entrySet().iterator(), this.b);
    }
    
    Iterator<Map.Entry<K, V>> b() {
      return Iterators.b(this.a.entrySet().iterator(), this.b);
    }
    
    public void clear() {
      this.c.clear();
    }
    
    public Comparator<? super K> comparator() {
      return this.a.comparator();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return this.c.containsKey(param1Object);
    }
    
    public NavigableMap<K, V> descendingMap() {
      return Maps.a(this.a.descendingMap(), this.b);
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      return this.c.entrySet();
    }
    
    @NullableDecl
    public V get(@NullableDecl Object param1Object) {
      return this.c.get(param1Object);
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      return Maps.a(this.a.headMap(param1K, param1Boolean), this.b);
    }
    
    public boolean isEmpty() {
      return Iterables.<Map.Entry<K, V>>d(this.a.entrySet(), this.b) ^ true;
    }
    
    public NavigableSet<K> navigableKeySet() {
      return new Maps.NavigableKeySet<K, V>(this, this) {
          public boolean removeAll(Collection<?> param2Collection) {
            return Maps.FilteredEntryMap.a(Maps.FilteredEntryNavigableMap.b(this.a), Maps.FilteredEntryNavigableMap.a(this.a), param2Collection);
          }
          
          public boolean retainAll(Collection<?> param2Collection) {
            return Maps.FilteredEntryMap.b(Maps.FilteredEntryNavigableMap.b(this.a), Maps.FilteredEntryNavigableMap.a(this.a), param2Collection);
          }
        };
    }
    
    public Map.Entry<K, V> pollFirstEntry() {
      return Iterables.<Map.Entry<K, V>>b(this.a.entrySet(), this.b);
    }
    
    public Map.Entry<K, V> pollLastEntry() {
      return Iterables.<Map.Entry<K, V>>b(this.a.descendingMap().entrySet(), this.b);
    }
    
    public V put(K param1K, V param1V) {
      return this.c.put(param1K, param1V);
    }
    
    public void putAll(Map<? extends K, ? extends V> param1Map) {
      this.c.putAll(param1Map);
    }
    
    public V remove(@NullableDecl Object param1Object) {
      return this.c.remove(param1Object);
    }
    
    public int size() {
      return this.c.size();
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return Maps.a(this.a.subMap(param1K1, param1Boolean1, param1K2, param1Boolean2), this.b);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      return Maps.a(this.a.tailMap(param1K, param1Boolean), this.b);
    }
    
    public Collection<V> values() {
      return new Maps.FilteredMapValues<K, V>(this, this.a, this.b);
    }
  }
  
  class null extends NavigableKeySet<K, V> {
    null(Maps this$0, NavigableMap<K, V> param1NavigableMap) {
      super(param1NavigableMap);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return Maps.FilteredEntryMap.a(Maps.FilteredEntryNavigableMap.b(this.a), Maps.FilteredEntryNavigableMap.a(this.a), param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return Maps.FilteredEntryMap.b(Maps.FilteredEntryNavigableMap.b(this.a), Maps.FilteredEntryNavigableMap.a(this.a), param1Collection);
    }
  }
  
  static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {
    FilteredEntrySortedMap(SortedMap<K, V> param1SortedMap, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      super(param1SortedMap, param1Predicate);
    }
    
    SortedMap<K, V> c() {
      return (SortedMap<K, V>)this.a;
    }
    
    public Comparator<? super K> comparator() {
      return c().comparator();
    }
    
    public SortedSet<K> d() {
      return (SortedSet<K>)super.keySet();
    }
    
    SortedSet<K> e() {
      return new SortedKeySet(this);
    }
    
    public K firstKey() {
      return d().iterator().next();
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return new FilteredEntrySortedMap(c().headMap(param1K), this.b);
    }
    
    public K lastKey() {
      for (SortedMap<K, V> sortedMap = c();; sortedMap = c().headMap((K)sortedMap)) {
        sortedMap = (SortedMap<K, V>)sortedMap.lastKey();
        if (a(sortedMap, this.a.get(sortedMap)))
          return (K)sortedMap; 
      } 
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return new FilteredEntrySortedMap(c().subMap(param1K1, param1K2), this.b);
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return new FilteredEntrySortedMap(c().tailMap(param1K), this.b);
    }
    
    class SortedKeySet extends Maps.FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
      SortedKeySet(Maps.FilteredEntrySortedMap this$0) {
        super(this$0);
      }
      
      public Comparator<? super K> comparator() {
        return this.b.c().comparator();
      }
      
      public K first() {
        return (K)this.b.firstKey();
      }
      
      public SortedSet<K> headSet(K param2K) {
        return (SortedSet<K>)this.b.headMap(param2K).keySet();
      }
      
      public K last() {
        return (K)this.b.lastKey();
      }
      
      public SortedSet<K> subSet(K param2K1, K param2K2) {
        return (SortedSet<K>)this.b.subMap(param2K1, param2K2).keySet();
      }
      
      public SortedSet<K> tailSet(K param2K) {
        return (SortedSet<K>)this.b.tailMap(param2K).keySet();
      }
    }
  }
  
  class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
    SortedKeySet(Maps this$0) {
      super((Maps.FilteredEntryMap)this$0);
    }
    
    public Comparator<? super K> comparator() {
      return this.b.c().comparator();
    }
    
    public K first() {
      return (K)this.b.firstKey();
    }
    
    public SortedSet<K> headSet(K param1K) {
      return (SortedSet<K>)this.b.headMap(param1K).keySet();
    }
    
    public K last() {
      return (K)this.b.lastKey();
    }
    
    public SortedSet<K> subSet(K param1K1, K param1K2) {
      return (SortedSet<K>)this.b.subMap(param1K1, param1K2).keySet();
    }
    
    public SortedSet<K> tailSet(K param1K) {
      return (SortedSet<K>)this.b.tailMap(param1K).keySet();
    }
  }
  
  static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
    final Predicate<? super K> c;
    
    FilteredKeyMap(Map<K, V> param1Map, Predicate<? super K> param1Predicate, Predicate<? super Map.Entry<K, V>> param1Predicate1) {
      super(param1Map, param1Predicate1);
      this.c = param1Predicate;
    }
    
    protected Set<Map.Entry<K, V>> a() {
      return Sets.a(this.a.entrySet(), this.b);
    }
    
    public boolean containsKey(Object param1Object) {
      return (this.a.containsKey(param1Object) && this.c.a(param1Object));
    }
    
    Set<K> h() {
      return Sets.a(this.a.keySet(), this.c);
    }
  }
  
  static final class FilteredMapValues<K, V> extends Values<K, V> {
    final Map<K, V> a;
    
    final Predicate<? super Map.Entry<K, V>> b;
    
    FilteredMapValues(Map<K, V> param1Map1, Map<K, V> param1Map2, Predicate<? super Map.Entry<K, V>> param1Predicate) {
      super(param1Map1);
      this.a = param1Map2;
      this.b = param1Predicate;
    }
    
    public boolean remove(Object param1Object) {
      Iterator<Map.Entry> iterator = this.a.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (this.b.a(entry) && Objects.a(entry.getValue(), param1Object)) {
          iterator.remove();
          return true;
        } 
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      Iterator<Map.Entry> iterator = this.a.entrySet().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (this.b.a(entry) && param1Collection.contains(entry.getValue())) {
          iterator.remove();
          bool = true;
        } 
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Iterator<Map.Entry> iterator = this.a.entrySet().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (this.b.a(entry) && !param1Collection.contains(entry.getValue())) {
          iterator.remove();
          bool = true;
        } 
      } 
      return bool;
    }
    
    public Object[] toArray() {
      return Lists.<V>a(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])Lists.<V>a(iterator()).toArray((Object[])param1ArrayOfT);
    }
  }
  
  static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
    abstract Iterator<Map.Entry<K, V>> b();
    
    public void clear() {
      Iterators.h(b());
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      return new Maps.EntrySet<K, V>(this) {
          Map<K, V> a() {
            return this.a;
          }
          
          public Iterator<Map.Entry<K, V>> iterator() {
            return this.a.b();
          }
        };
    }
  }
  
  class null extends EntrySet<K, V> {
    null(Maps this$0) {}
    
    Map<K, V> a() {
      return this.a;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return this.a.b();
    }
  }
  
  static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {
    final Map<K, V> d;
    
    KeySet(Map<K, V> param1Map) {
      this.d = (Map<K, V>)Preconditions.a(param1Map);
    }
    
    Map<K, V> c() {
      return this.d;
    }
    
    public void clear() {
      c().clear();
    }
    
    public boolean contains(Object param1Object) {
      return c().containsKey(param1Object);
    }
    
    public boolean isEmpty() {
      return c().isEmpty();
    }
    
    public Iterator<K> iterator() {
      return Maps.a(c().entrySet().iterator());
    }
    
    public boolean remove(Object param1Object) {
      if (contains(param1Object)) {
        c().remove(param1Object);
        return true;
      } 
      return false;
    }
    
    public int size() {
      return c().size();
    }
  }
  
  static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
    final Map<K, V> a;
    
    final Map<K, V> b;
    
    final Map<K, V> c;
    
    final Map<K, MapDifference.ValueDifference<V>> d;
    
    public Map<K, V> a() {
      return this.a;
    }
    
    public Map<K, V> b() {
      return this.b;
    }
    
    public Map<K, V> c() {
      return this.c;
    }
    
    public Map<K, MapDifference.ValueDifference<V>> d() {
      return this.d;
    }
    
    public boolean e() {
      return (this.a.isEmpty() && this.b.isEmpty() && this.d.isEmpty());
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof MapDifference) {
        param1Object = param1Object;
        return (a().equals(param1Object.a()) && b().equals(param1Object.b()) && c().equals(param1Object.c()) && d().equals(param1Object.d()));
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { a(), b(), c(), d() });
    }
    
    public String toString() {
      if (e())
        return "equal"; 
      StringBuilder stringBuilder = new StringBuilder("not equal");
      if (!this.a.isEmpty()) {
        stringBuilder.append(": only on left=");
        stringBuilder.append(this.a);
      } 
      if (!this.b.isEmpty()) {
        stringBuilder.append(": only on right=");
        stringBuilder.append(this.b);
      } 
      if (!this.d.isEmpty()) {
        stringBuilder.append(": value differences=");
        stringBuilder.append(this.d);
      } 
      return stringBuilder.toString();
    }
  }
  
  static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {
    private final NavigableSet<K> a;
    
    private final Function<? super K, V> b;
    
    NavigableAsMapView(NavigableSet<K> param1NavigableSet, Function<? super K, V> param1Function) {
      this.a = (NavigableSet<K>)Preconditions.a(param1NavigableSet);
      this.b = (Function<? super K, V>)Preconditions.a(param1Function);
    }
    
    Iterator<Map.Entry<K, V>> a() {
      return descendingMap().entrySet().iterator();
    }
    
    Iterator<Map.Entry<K, V>> b() {
      return Maps.b(this.a, this.b);
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public Comparator<? super K> comparator() {
      return this.a.comparator();
    }
    
    public NavigableMap<K, V> descendingMap() {
      return Maps.a(this.a.descendingSet(), this.b);
    }
    
    @NullableDecl
    public V get(@NullableDecl Object param1Object) {
      return (V)(Collections2.a(this.a, param1Object) ? this.b.f(param1Object) : null);
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      return Maps.a(this.a.headSet(param1K, param1Boolean), this.b);
    }
    
    public NavigableSet<K> navigableKeySet() {
      return Maps.a(this.a);
    }
    
    public int size() {
      return this.a.size();
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return Maps.a(this.a.subSet(param1K1, param1Boolean1, param1K2, param1Boolean2), this.b);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      return Maps.a(this.a.tailSet(param1K, param1Boolean), this.b);
    }
  }
  
  static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
    NavigableKeySet(NavigableMap<K, V> param1NavigableMap) {
      super(param1NavigableMap);
    }
    
    NavigableMap<K, V> a() {
      return (NavigableMap<K, V>)this.d;
    }
    
    public K ceiling(K param1K) {
      return a().ceilingKey(param1K);
    }
    
    public Iterator<K> descendingIterator() {
      return descendingSet().iterator();
    }
    
    public NavigableSet<K> descendingSet() {
      return a().descendingKeySet();
    }
    
    public K floor(K param1K) {
      return a().floorKey(param1K);
    }
    
    public NavigableSet<K> headSet(K param1K, boolean param1Boolean) {
      return a().headMap(param1K, param1Boolean).navigableKeySet();
    }
    
    public SortedSet<K> headSet(K param1K) {
      return headSet(param1K, false);
    }
    
    public K higher(K param1K) {
      return a().higherKey(param1K);
    }
    
    public K lower(K param1K) {
      return a().lowerKey(param1K);
    }
    
    public K pollFirst() {
      return Maps.b(a().pollFirstEntry());
    }
    
    public K pollLast() {
      return Maps.b(a().pollLastEntry());
    }
    
    public NavigableSet<K> subSet(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return a().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2).navigableKeySet();
    }
    
    public SortedSet<K> subSet(K param1K1, K param1K2) {
      return subSet(param1K1, true, param1K2, false);
    }
    
    public NavigableSet<K> tailSet(K param1K, boolean param1Boolean) {
      return a().tailMap(param1K, param1Boolean).navigableKeySet();
    }
    
    public SortedSet<K> tailSet(K param1K) {
      return tailSet(param1K, true);
    }
  }
  
  static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
    SortedAsMapView(SortedSet<K> param1SortedSet, Function<? super K, V> param1Function) {
      super(param1SortedSet, param1Function);
    }
    
    public Comparator<? super K> comparator() {
      return d().comparator();
    }
    
    SortedSet<K> d() {
      return (SortedSet<K>)super.c();
    }
    
    public K firstKey() {
      return d().first();
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return Maps.a(d().headSet(param1K), this.a);
    }
    
    public Set<K> keySet() {
      return Maps.a(d());
    }
    
    public K lastKey() {
      return d().last();
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return Maps.a(d().subSet(param1K1, param1K2), this.a);
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return Maps.a(d().tailSet(param1K), this.a);
    }
  }
  
  static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
    SortedKeySet(SortedMap<K, V> param1SortedMap) {
      super(param1SortedMap);
    }
    
    SortedMap<K, V> b() {
      return (SortedMap<K, V>)super.c();
    }
    
    public Comparator<? super K> comparator() {
      return b().comparator();
    }
    
    public K first() {
      return b().firstKey();
    }
    
    public SortedSet<K> headSet(K param1K) {
      return new SortedKeySet(b().headMap(param1K));
    }
    
    public K last() {
      return b().lastKey();
    }
    
    public SortedSet<K> subSet(K param1K1, K param1K2) {
      return new SortedKeySet(b().subMap(param1K1, param1K2));
    }
    
    public SortedSet<K> tailSet(K param1K) {
      return new SortedKeySet(b().tailMap(param1K));
    }
  }
  
  static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
    public SortedMap<K, MapDifference.ValueDifference<V>> f() {
      return (SortedMap<K, MapDifference.ValueDifference<V>>)super.d();
    }
    
    public SortedMap<K, V> g() {
      return (SortedMap<K, V>)super.c();
    }
    
    public SortedMap<K, V> h() {
      return (SortedMap<K, V>)super.a();
    }
    
    public SortedMap<K, V> i() {
      return (SortedMap<K, V>)super.b();
    }
  }
  
  static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {
    final Map<K, V1> a;
    
    final Maps.EntryTransformer<? super K, ? super V1, V2> b;
    
    TransformedEntriesMap(Map<K, V1> param1Map, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      this.a = (Map<K, V1>)Preconditions.a(param1Map);
      this.b = (Maps.EntryTransformer<? super K, ? super V1, V2>)Preconditions.a(param1EntryTransformer);
    }
    
    Iterator<Map.Entry<K, V2>> b() {
      return Iterators.a(this.a.entrySet().iterator(), Maps.b(this.b));
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean containsKey(Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    public V2 get(Object param1Object) {
      V1 v1 = this.a.get(param1Object);
      return (v1 != null || this.a.containsKey(param1Object)) ? this.b.a((K)param1Object, v1) : null;
    }
    
    public Set<K> keySet() {
      return this.a.keySet();
    }
    
    public V2 remove(Object param1Object) {
      return this.a.containsKey(param1Object) ? this.b.a((K)param1Object, this.a.remove(param1Object)) : null;
    }
    
    public int size() {
      return this.a.size();
    }
    
    public Collection<V2> values() {
      return new Maps.Values<Object, V2>(this);
    }
  }
  
  static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
    TransformedEntriesNavigableMap(NavigableMap<K, V1> param1NavigableMap, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      super(param1NavigableMap, param1EntryTransformer);
    }
    
    @NullableDecl
    private Map.Entry<K, V2> a(@NullableDecl Map.Entry<K, V1> param1Entry) {
      return (param1Entry == null) ? null : Maps.a(this.b, param1Entry);
    }
    
    protected NavigableMap<K, V1> a() {
      return (NavigableMap<K, V1>)super.c();
    }
    
    public NavigableMap<K, V2> a(K param1K) {
      return headMap(param1K, false);
    }
    
    public NavigableMap<K, V2> a(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, V2> b(K param1K) {
      return tailMap(param1K, true);
    }
    
    public Map.Entry<K, V2> ceilingEntry(K param1K) {
      return a(a().ceilingEntry(param1K));
    }
    
    public K ceilingKey(K param1K) {
      return a().ceilingKey(param1K);
    }
    
    public NavigableSet<K> descendingKeySet() {
      return a().descendingKeySet();
    }
    
    public NavigableMap<K, V2> descendingMap() {
      return Maps.a(a().descendingMap(), this.b);
    }
    
    public Map.Entry<K, V2> firstEntry() {
      return a(a().firstEntry());
    }
    
    public Map.Entry<K, V2> floorEntry(K param1K) {
      return a(a().floorEntry(param1K));
    }
    
    public K floorKey(K param1K) {
      return a().floorKey(param1K);
    }
    
    public NavigableMap<K, V2> headMap(K param1K, boolean param1Boolean) {
      return Maps.a(a().headMap(param1K, param1Boolean), this.b);
    }
    
    public Map.Entry<K, V2> higherEntry(K param1K) {
      return a(a().higherEntry(param1K));
    }
    
    public K higherKey(K param1K) {
      return a().higherKey(param1K);
    }
    
    public Map.Entry<K, V2> lastEntry() {
      return a(a().lastEntry());
    }
    
    public Map.Entry<K, V2> lowerEntry(K param1K) {
      return a(a().lowerEntry(param1K));
    }
    
    public K lowerKey(K param1K) {
      return a().lowerKey(param1K);
    }
    
    public NavigableSet<K> navigableKeySet() {
      return a().navigableKeySet();
    }
    
    public Map.Entry<K, V2> pollFirstEntry() {
      return a(a().pollFirstEntry());
    }
    
    public Map.Entry<K, V2> pollLastEntry() {
      return a(a().pollLastEntry());
    }
    
    public NavigableMap<K, V2> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return Maps.a(a().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2), this.b);
    }
    
    public NavigableMap<K, V2> tailMap(K param1K, boolean param1Boolean) {
      return Maps.a(a().tailMap(param1K, param1Boolean), this.b);
    }
  }
  
  static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
    TransformedEntriesSortedMap(SortedMap<K, V1> param1SortedMap, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      super(param1SortedMap, param1EntryTransformer);
    }
    
    protected SortedMap<K, V1> c() {
      return (SortedMap<K, V1>)this.a;
    }
    
    public Comparator<? super K> comparator() {
      return c().comparator();
    }
    
    public K firstKey() {
      return c().firstKey();
    }
    
    public SortedMap<K, V2> headMap(K param1K) {
      return Maps.a(c().headMap(param1K), this.b);
    }
    
    public K lastKey() {
      return c().lastKey();
    }
    
    public SortedMap<K, V2> subMap(K param1K1, K param1K2) {
      return Maps.a(c().subMap(param1K1, param1K2), this.b);
    }
    
    public SortedMap<K, V2> tailMap(K param1K) {
      return Maps.a(c().tailMap(param1K), this.b);
    }
  }
  
  static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    final Map<K, V> a;
    
    final BiMap<? extends K, ? extends V> b;
    
    @NullableDecl
    BiMap<V, K> c;
    
    @NullableDecl
    transient Set<V> d;
    
    UnmodifiableBiMap(BiMap<? extends K, ? extends V> param1BiMap, @NullableDecl BiMap<V, K> param1BiMap1) {
      this.a = Collections.unmodifiableMap(param1BiMap);
      this.b = param1BiMap;
      this.c = param1BiMap1;
    }
    
    protected Map<K, V> a() {
      return this.a;
    }
    
    public BiMap<V, K> ay_() {
      BiMap<V, K> biMap2 = this.c;
      BiMap<V, K> biMap1 = biMap2;
      if (biMap2 == null) {
        biMap1 = new UnmodifiableBiMap(this.b.ay_(), this);
        this.c = biMap1;
      } 
      return biMap1;
    }
    
    public Set<V> d() {
      Set<V> set2 = this.d;
      Set<V> set1 = set2;
      if (set2 == null) {
        set1 = Collections.unmodifiableSet(this.b.d());
        this.d = set1;
      } 
      return set1;
    }
  }
  
  static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
    private final Collection<Map.Entry<K, V>> a;
    
    UnmodifiableEntries(Collection<Map.Entry<K, V>> param1Collection) {
      this.a = param1Collection;
    }
    
    protected Collection<Map.Entry<K, V>> c() {
      return this.a;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return Maps.c(this.a.iterator());
    }
    
    public Object[] toArray() {
      return o();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])a((Object[])param1ArrayOfT);
    }
  }
  
  static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
    UnmodifiableEntrySet(Set<Map.Entry<K, V>> param1Set) {
      super(param1Set);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      return Sets.a(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.a(this);
    }
  }
  
  static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements Serializable, NavigableMap<K, V> {
    private final NavigableMap<K, ? extends V> a;
    
    @NullableDecl
    private transient UnmodifiableNavigableMap<K, V> b;
    
    UnmodifiableNavigableMap(NavigableMap<K, ? extends V> param1NavigableMap) {
      this.a = param1NavigableMap;
    }
    
    UnmodifiableNavigableMap(NavigableMap<K, ? extends V> param1NavigableMap, UnmodifiableNavigableMap<K, V> param1UnmodifiableNavigableMap) {
      this.a = param1NavigableMap;
      this.b = param1UnmodifiableNavigableMap;
    }
    
    protected SortedMap<K, V> c() {
      return Collections.unmodifiableSortedMap(this.a);
    }
    
    public Map.Entry<K, V> ceilingEntry(K param1K) {
      return Maps.d(this.a.ceilingEntry(param1K));
    }
    
    public K ceilingKey(K param1K) {
      return this.a.ceilingKey(param1K);
    }
    
    public NavigableSet<K> descendingKeySet() {
      return Sets.a(this.a.descendingKeySet());
    }
    
    public NavigableMap<K, V> descendingMap() {
      UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = this.b;
      UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap1 = unmodifiableNavigableMap2;
      if (unmodifiableNavigableMap2 == null) {
        unmodifiableNavigableMap1 = new UnmodifiableNavigableMap(this.a.descendingMap(), this);
        this.b = unmodifiableNavigableMap1;
      } 
      return unmodifiableNavigableMap1;
    }
    
    public Map.Entry<K, V> firstEntry() {
      return Maps.d(this.a.firstEntry());
    }
    
    public Map.Entry<K, V> floorEntry(K param1K) {
      return Maps.d(this.a.floorEntry(param1K));
    }
    
    public K floorKey(K param1K) {
      return this.a.floorKey(param1K);
    }
    
    public NavigableMap<K, V> headMap(K param1K, boolean param1Boolean) {
      return Maps.a(this.a.headMap(param1K, param1Boolean));
    }
    
    public SortedMap<K, V> headMap(K param1K) {
      return headMap(param1K, false);
    }
    
    public Map.Entry<K, V> higherEntry(K param1K) {
      return Maps.d(this.a.higherEntry(param1K));
    }
    
    public K higherKey(K param1K) {
      return this.a.higherKey(param1K);
    }
    
    public Set<K> keySet() {
      return navigableKeySet();
    }
    
    public Map.Entry<K, V> lastEntry() {
      return Maps.d(this.a.lastEntry());
    }
    
    public Map.Entry<K, V> lowerEntry(K param1K) {
      return Maps.d(this.a.lowerEntry(param1K));
    }
    
    public K lowerKey(K param1K) {
      return this.a.lowerKey(param1K);
    }
    
    public NavigableSet<K> navigableKeySet() {
      return Sets.a(this.a.navigableKeySet());
    }
    
    public final Map.Entry<K, V> pollFirstEntry() {
      throw new UnsupportedOperationException();
    }
    
    public final Map.Entry<K, V> pollLastEntry() {
      throw new UnsupportedOperationException();
    }
    
    public NavigableMap<K, V> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
      return Maps.a(this.a.subMap(param1K1, param1Boolean1, param1K2, param1Boolean2));
    }
    
    public SortedMap<K, V> subMap(K param1K1, K param1K2) {
      return subMap(param1K1, true, param1K2, false);
    }
    
    public NavigableMap<K, V> tailMap(K param1K, boolean param1Boolean) {
      return Maps.a(this.a.tailMap(param1K, param1Boolean));
    }
    
    public SortedMap<K, V> tailMap(K param1K) {
      return tailMap(param1K, true);
    }
  }
  
  static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {
    @NullableDecl
    private final V a;
    
    @NullableDecl
    private final V b;
    
    public V a() {
      return this.a;
    }
    
    public V b() {
      return this.b;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof MapDifference.ValueDifference;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (Objects.a(this.a, param1Object.a())) {
          bool1 = bool2;
          if (Objects.a(this.b, param1Object.b()))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { this.a, this.b });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(this.a);
      stringBuilder.append(", ");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class Values<K, V> extends AbstractCollection<V> {
    final Map<K, V> c;
    
    Values(Map<K, V> param1Map) {
      this.c = (Map<K, V>)Preconditions.a(param1Map);
    }
    
    final Map<K, V> a() {
      return this.c;
    }
    
    public void clear() {
      a().clear();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return a().containsValue(param1Object);
    }
    
    public boolean isEmpty() {
      return a().isEmpty();
    }
    
    public Iterator<V> iterator() {
      return Maps.b(a().entrySet().iterator());
    }
    
    public boolean remove(Object param1Object) {
      try {
        return super.remove(param1Object);
      } catch (UnsupportedOperationException unsupportedOperationException) {
        for (Map.Entry<K, V> entry : a().entrySet()) {
          if (Objects.a(param1Object, entry.getValue())) {
            a().remove(entry.getKey());
            return true;
          } 
        } 
        return false;
      } 
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      try {
        return super.removeAll((Collection)Preconditions.a(param1Collection));
      } catch (UnsupportedOperationException unsupportedOperationException) {
        HashSet<?> hashSet = Sets.a();
        for (Map.Entry<K, V> entry : a().entrySet()) {
          if (param1Collection.contains(entry.getValue()))
            hashSet.add(entry.getKey()); 
        } 
        return a().keySet().removeAll(hashSet);
      } 
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      try {
        return super.retainAll((Collection)Preconditions.a(param1Collection));
      } catch (UnsupportedOperationException unsupportedOperationException) {
        HashSet<?> hashSet = Sets.a();
        for (Map.Entry<K, V> entry : a().entrySet()) {
          if (param1Collection.contains(entry.getValue()))
            hashSet.add(entry.getKey()); 
        } 
        return a().keySet().retainAll(hashSet);
      } 
    }
    
    public int size() {
      return a().size();
    }
  }
  
  static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {
    @NullableDecl
    private transient Set<Map.Entry<K, V>> a;
    
    @NullableDecl
    private transient Set<K> b;
    
    @NullableDecl
    private transient Collection<V> c;
    
    abstract Set<Map.Entry<K, V>> a();
    
    Collection<V> b() {
      return new Maps.Values<Object, V>(this);
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
      Set<Map.Entry<K, V>> set2 = this.a;
      Set<Map.Entry<K, V>> set1 = set2;
      if (set2 == null) {
        set1 = a();
        this.a = set1;
      } 
      return set1;
    }
    
    Set<K> h() {
      return new Maps.KeySet<K, Object>(this);
    }
    
    public Set<K> keySet() {
      Set<K> set2 = this.b;
      Set<K> set1 = set2;
      if (set2 == null) {
        set1 = h();
        this.b = set1;
      } 
      return set1;
    }
    
    public Collection<V> values() {
      Collection<V> collection2 = this.c;
      Collection<V> collection1 = collection2;
      if (collection2 == null) {
        collection1 = b();
        this.c = collection1;
      } 
      return collection1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Maps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */