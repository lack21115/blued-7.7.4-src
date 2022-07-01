package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Multimaps {
  public static <K, V1, V2> ListMultimap<K, V2> a(ListMultimap<K, V1> paramListMultimap, Function<? super V1, V2> paramFunction) {
    Preconditions.a(paramFunction);
    return a(paramListMultimap, Maps.a(paramFunction));
  }
  
  public static <K, V1, V2> ListMultimap<K, V2> a(ListMultimap<K, V1> paramListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer) {
    return new TransformedEntriesListMultimap<K, V1, V2>(paramListMultimap, paramEntryTransformer);
  }
  
  public static <K, V> SetMultimap<K, V> a(Map<K, Collection<V>> paramMap, Supplier<? extends Set<V>> paramSupplier) {
    return new CustomSetMultimap<K, V>(paramMap, paramSupplier);
  }
  
  static boolean a(Multimap<?, ?> paramMultimap, @NullableDecl Object paramObject) {
    if (paramObject == paramMultimap)
      return true; 
    if (paramObject instanceof Multimap) {
      paramObject = paramObject;
      return paramMultimap.c().equals(paramObject.c());
    } 
    return false;
  }
  
  public static <K, V> SortedSetMultimap<K, V> b(Map<K, Collection<V>> paramMap, Supplier<? extends SortedSet<V>> paramSupplier) {
    return new CustomSortedSetMultimap<K, V>(paramMap, paramSupplier);
  }
  
  private static <V> Collection<V> c(Collection<V> paramCollection) {
    return (paramCollection instanceof SortedSet) ? Collections.unmodifiableSortedSet((SortedSet<V>)paramCollection) : ((paramCollection instanceof Set) ? Collections.unmodifiableSet((Set<? extends V>)paramCollection) : ((paramCollection instanceof List) ? Collections.unmodifiableList((List<? extends V>)paramCollection) : Collections.unmodifiableCollection(paramCollection)));
  }
  
  private static <K, V> Collection<Map.Entry<K, V>> d(Collection<Map.Entry<K, V>> paramCollection) {
    return (Collection<Map.Entry<K, V>>)((paramCollection instanceof Set) ? Maps.a((Set<Map.Entry<K, V>>)paramCollection) : new Maps.UnmodifiableEntries<K, V>(Collections.unmodifiableCollection(paramCollection)));
  }
  
  static final class AsMap<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
    private final Multimap<K, V> a;
    
    AsMap(Multimap<K, V> param1Multimap) {
      this.a = (Multimap<K, V>)Preconditions.a(param1Multimap);
    }
    
    protected Set<Map.Entry<K, Collection<V>>> a() {
      return new EntrySet(this);
    }
    
    void a(Object param1Object) {
      this.a.s().remove(param1Object);
    }
    
    public Collection<V> b(Object param1Object) {
      return containsKey(param1Object) ? this.a.c((K)param1Object) : null;
    }
    
    public Collection<V> c(Object param1Object) {
      return containsKey(param1Object) ? this.a.d(param1Object) : null;
    }
    
    public void clear() {
      this.a.g();
    }
    
    public boolean containsKey(Object param1Object) {
      return this.a.f(param1Object);
    }
    
    public boolean isEmpty() {
      return this.a.r();
    }
    
    public Set<K> keySet() {
      return this.a.s();
    }
    
    public int size() {
      return this.a.s().size();
    }
    
    class EntrySet extends Maps.EntrySet<K, Collection<V>> {
      EntrySet(Multimaps.AsMap this$0) {}
      
      Map<K, Collection<V>> a() {
        return this.a;
      }
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator() {
        return Maps.b(Multimaps.AsMap.a(this.a).s(), new Function<K, Collection<V>>(this) {
              public Collection<V> a(K param3K) {
                return Multimaps.AsMap.a(this.a.a).c(param3K);
              }
            });
      }
      
      public boolean remove(Object param2Object) {
        if (!contains(param2Object))
          return false; 
        param2Object = param2Object;
        this.a.a(param2Object.getKey());
        return true;
      }
    }
    
    class null implements Function<K, Collection<V>> {
      null(Multimaps.AsMap this$0) {}
      
      public Collection<V> a(K param2K) {
        return Multimaps.AsMap.a(this.a.a).c(param2K);
      }
    }
  }
  
  class EntrySet extends Maps.EntrySet<K, Collection<V>> {
    EntrySet(Multimaps this$0) {}
    
    Map<K, Collection<V>> a() {
      return this.a;
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return Maps.b(Multimaps.AsMap.a(this.a).s(), new Function<K, Collection<V>>(this) {
            public Collection<V> a(K param3K) {
              return Multimaps.AsMap.a(this.a.a).c(param3K);
            }
          });
    }
    
    public boolean remove(Object param1Object) {
      if (!contains(param1Object))
        return false; 
      param1Object = param1Object;
      this.a.a(param1Object.getKey());
      return true;
    }
  }
  
  class null implements Function<K, Collection<V>> {
    null(Multimaps this$0) {}
    
    public Collection<V> a(K param1K) {
      return Multimaps.AsMap.a(this.a.a).c(param1K);
    }
  }
  
  static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
    transient Supplier<? extends List<V>> a;
    
    protected List<V> a() {
      return (List<V>)this.a.get();
    }
    
    Set<K> h() {
      return i();
    }
    
    Map<K, Collection<V>> p() {
      return q();
    }
  }
  
  static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
    transient Supplier<? extends Collection<V>> a;
    
    Collection<V> a(K param1K, Collection<V> param1Collection) {
      return (Collection<V>)((param1Collection instanceof List) ? a(param1K, (List<V>)param1Collection, null) : ((param1Collection instanceof NavigableSet) ? new AbstractMapBasedMultimap.WrappedNavigableSet(this, param1K, (NavigableSet<V>)param1Collection, null) : ((param1Collection instanceof SortedSet) ? new AbstractMapBasedMultimap.WrappedSortedSet(this, param1K, (SortedSet<V>)param1Collection, null) : ((param1Collection instanceof Set) ? new AbstractMapBasedMultimap.WrappedSet(this, param1K, (Set<V>)param1Collection) : new AbstractMapBasedMultimap.WrappedCollection(this, param1K, param1Collection, null)))));
    }
    
    <E> Collection<E> a(Collection<E> param1Collection) {
      return (param1Collection instanceof NavigableSet) ? Sets.a((NavigableSet<E>)param1Collection) : ((param1Collection instanceof SortedSet) ? Collections.unmodifiableSortedSet((SortedSet<E>)param1Collection) : ((param1Collection instanceof Set) ? Collections.unmodifiableSet((Set<? extends E>)param1Collection) : ((param1Collection instanceof List) ? Collections.unmodifiableList((List<? extends E>)param1Collection) : Collections.unmodifiableCollection(param1Collection))));
    }
    
    protected Collection<V> d() {
      return (Collection<V>)this.a.get();
    }
    
    Set<K> h() {
      return i();
    }
    
    Map<K, Collection<V>> p() {
      return q();
    }
  }
  
  static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
    transient Supplier<? extends Set<V>> a;
    
    CustomSetMultimap(Map<K, Collection<V>> param1Map, Supplier<? extends Set<V>> param1Supplier) {
      super(param1Map);
      this.a = (Supplier<? extends Set<V>>)Preconditions.a(param1Supplier);
    }
    
    Collection<V> a(K param1K, Collection<V> param1Collection) {
      return (Collection<V>)((param1Collection instanceof NavigableSet) ? new AbstractMapBasedMultimap.WrappedNavigableSet(this, param1K, (NavigableSet<V>)param1Collection, null) : ((param1Collection instanceof SortedSet) ? new AbstractMapBasedMultimap.WrappedSortedSet(this, param1K, (SortedSet<V>)param1Collection, null) : new AbstractMapBasedMultimap.WrappedSet(this, param1K, (Set<V>)param1Collection)));
    }
    
    <E> Collection<E> a(Collection<E> param1Collection) {
      return (param1Collection instanceof NavigableSet) ? Sets.a((NavigableSet<E>)param1Collection) : ((param1Collection instanceof SortedSet) ? Collections.unmodifiableSortedSet((SortedSet<E>)param1Collection) : Collections.unmodifiableSet((Set<? extends E>)param1Collection));
    }
    
    protected Set<V> a() {
      return (Set<V>)this.a.get();
    }
    
    Set<K> h() {
      return i();
    }
    
    Map<K, Collection<V>> p() {
      return q();
    }
  }
  
  static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    transient Supplier<? extends SortedSet<V>> a;
    
    transient Comparator<? super V> b;
    
    CustomSortedSetMultimap(Map<K, Collection<V>> param1Map, Supplier<? extends SortedSet<V>> param1Supplier) {
      super(param1Map);
      this.a = (Supplier<? extends SortedSet<V>>)Preconditions.a(param1Supplier);
      this.b = ((SortedSet<V>)param1Supplier.get()).comparator();
    }
    
    Set<K> h() {
      return i();
    }
    
    Map<K, Collection<V>> p() {
      return q();
    }
    
    protected SortedSet<V> w() {
      return (SortedSet<V>)this.a.get();
    }
  }
  
  static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
    abstract Multimap<K, V> a();
    
    public void clear() {
      a().g();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return a().b(param1Object.getKey(), param1Object.getValue());
      } 
      return false;
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return a().c(param1Object.getKey(), param1Object.getValue());
      } 
      return false;
    }
    
    public int size() {
      return a().f();
    }
  }
  
  static class Keys<K, V> extends AbstractMultiset<K> {
    final Multimap<K, V> b;
    
    public int a(@NullableDecl Object param1Object) {
      param1Object = Maps.<Collection>a((Map)this.b.c(), param1Object);
      return (param1Object == null) ? 0 : param1Object.size();
    }
    
    Iterator<K> a() {
      throw new AssertionError("should never be called");
    }
    
    public int b(@NullableDecl Object param1Object, int param1Int) {
      CollectPreconditions.a(param1Int, "occurrences");
      if (param1Int == 0)
        return a(param1Object); 
      param1Object = Maps.<Collection>a((Map)this.b.c(), param1Object);
      int i = 0;
      if (param1Object == null)
        return 0; 
      int j = param1Object.size();
      if (param1Int >= j) {
        param1Object.clear();
        return j;
      } 
      param1Object = param1Object.iterator();
      while (i < param1Int) {
        param1Object.next();
        param1Object.remove();
        i++;
      } 
      return j;
    }
    
    Iterator<Multiset.Entry<K>> b() {
      return new TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>(this, this.b.c().entrySet().iterator()) {
          Multiset.Entry<K> a(Map.Entry<K, Collection<V>> param2Entry) {
            return new Multisets.AbstractEntry<K>(this, param2Entry) {
                public int b() {
                  return ((Collection)this.a.getValue()).size();
                }
                
                public K c() {
                  return (K)this.a.getKey();
                }
              };
          }
        };
    }
    
    int c() {
      return this.b.c().size();
    }
    
    public void clear() {
      this.b.g();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return this.b.f(param1Object);
    }
    
    public Set<K> d() {
      return this.b.s();
    }
    
    public Iterator<K> iterator() {
      return Maps.a(this.b.m().iterator());
    }
    
    public int size() {
      return this.b.f();
    }
  }
  
  class null extends TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>> {
    null(Multimaps this$0, Iterator<? extends Map.Entry<K, Collection<V>>> param1Iterator) {
      super(param1Iterator);
    }
    
    Multiset.Entry<K> a(Map.Entry<K, Collection<V>> param1Entry) {
      return new Multisets.AbstractEntry(this, param1Entry) {
          public int b() {
            return ((Collection)this.a.getValue()).size();
          }
          
          public K c() {
            return (K)this.a.getKey();
          }
        };
    }
  }
  
  class null extends Multisets.AbstractEntry<K> {
    public int b() {
      return ((Collection)this.a.getValue()).size();
    }
    
    public K c() {
      return (K)this.a.getKey();
    }
  }
  
  static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {
    final Map<K, V> a;
    
    public Set<V> a(K param1K) {
      return new Sets.ImprovedAbstractSet<V>(this, param1K) {
          public Iterator<V> iterator() {
            return new Iterator<V>(this) {
                int a;
                
                public boolean hasNext() {
                  return (this.a == 0 && this.b.b.a.containsKey(this.b.a));
                }
                
                public V next() {
                  if (hasNext()) {
                    this.a++;
                    return (V)this.b.b.a.get(this.b.a);
                  } 
                  throw new NoSuchElementException();
                }
                
                public void remove() {
                  int i = this.a;
                  boolean bool = true;
                  if (i != 1)
                    bool = false; 
                  CollectPreconditions.a(bool);
                  this.a = -1;
                  this.b.b.a.remove(this.b.a);
                }
              };
          }
          
          public int size() {
            throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
          }
        };
    }
    
    public boolean a(K param1K, V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public Set<V> b(Object param1Object) {
      HashSet<V> hashSet = new HashSet(2);
      if (!this.a.containsKey(param1Object))
        return hashSet; 
      hashSet.add(this.a.remove(param1Object));
      return hashSet;
    }
    
    public boolean b(Object param1Object1, Object param1Object2) {
      return this.a.entrySet().contains(Maps.a(param1Object1, param1Object2));
    }
    
    public boolean c(Object param1Object1, Object param1Object2) {
      return this.a.entrySet().remove(Maps.a(param1Object1, param1Object2));
    }
    
    public int f() {
      return this.a.size();
    }
    
    public boolean f(Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    public void g() {
      this.a.clear();
    }
    
    public boolean g(Object param1Object) {
      return this.a.containsValue(param1Object);
    }
    
    Set<K> h() {
      return this.a.keySet();
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    Collection<V> k() {
      return this.a.values();
    }
    
    Collection<Map.Entry<K, V>> n() {
      throw new AssertionError("unreachable");
    }
    
    Iterator<Map.Entry<K, V>> o() {
      return this.a.entrySet().iterator();
    }
    
    Map<K, Collection<V>> p() {
      return new Multimaps.AsMap<K, V>(this);
    }
    
    public Set<Map.Entry<K, V>> t() {
      return this.a.entrySet();
    }
  }
  
  class null extends Sets.ImprovedAbstractSet<V> {
    null(Multimaps this$0, Object param1Object) {}
    
    public Iterator<V> iterator() {
      return new Iterator(this) {
          int a;
          
          public boolean hasNext() {
            return (this.a == 0 && this.b.b.a.containsKey(this.b.a));
          }
          
          public V next() {
            if (hasNext()) {
              this.a++;
              return (V)this.b.b.a.get(this.b.a);
            } 
            throw new NoSuchElementException();
          }
          
          public void remove() {
            int i = this.a;
            boolean bool = true;
            if (i != 1)
              bool = false; 
            CollectPreconditions.a(bool);
            this.a = -1;
            this.b.b.a.remove(this.b.a);
          }
        };
    }
    
    public int size() {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  class null implements Iterator<V> {
    int a;
    
    public boolean hasNext() {
      return (this.a == 0 && this.b.b.a.containsKey(this.b.a));
    }
    
    public V next() {
      if (hasNext()) {
        this.a++;
        return (V)this.b.b.a.get(this.b.a);
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      int i = this.a;
      boolean bool = true;
      if (i != 1)
        bool = false; 
      CollectPreconditions.a(bool);
      this.a = -1;
      this.b.b.a.remove(this.b.a);
    }
  }
  
  static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {
    TransformedEntriesListMultimap(ListMultimap<K, V1> param1ListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      super(param1ListMultimap, param1EntryTransformer);
    }
    
    public List<V2> a(K param1K) {
      return a(param1K, this.a.c(param1K));
    }
    
    List<V2> a(K param1K, Collection<V1> param1Collection) {
      return Lists.a((List)param1Collection, Maps.a(this.b, param1K));
    }
    
    public List<V2> b(Object param1Object) {
      return a((K)param1Object, this.a.d(param1Object));
    }
  }
  
  static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2> {
    final Multimap<K, V1> a;
    
    final Maps.EntryTransformer<? super K, ? super V1, V2> b;
    
    TransformedEntriesMultimap(Multimap<K, V1> param1Multimap, Maps.EntryTransformer<? super K, ? super V1, V2> param1EntryTransformer) {
      this.a = (Multimap<K, V1>)Preconditions.a(param1Multimap);
      this.b = (Maps.EntryTransformer<? super K, ? super V1, V2>)Preconditions.a(param1EntryTransformer);
    }
    
    public boolean a(K param1K, V2 param1V2) {
      throw new UnsupportedOperationException();
    }
    
    Collection<V2> b(K param1K, Collection<V1> param1Collection) {
      Function<? super V1, V2> function = Maps.a(this.b, param1K);
      return (param1Collection instanceof List) ? Lists.a((List<V1>)param1Collection, function) : Collections2.a(param1Collection, function);
    }
    
    public Collection<V2> c(K param1K) {
      return b(param1K, this.a.c(param1K));
    }
    
    public boolean c(Object param1Object1, Object param1Object2) {
      return c((K)param1Object1).remove(param1Object2);
    }
    
    public Collection<V2> d(Object param1Object) {
      return b((K)param1Object, this.a.d(param1Object));
    }
    
    public int f() {
      return this.a.f();
    }
    
    public boolean f(Object param1Object) {
      return this.a.f(param1Object);
    }
    
    public void g() {
      this.a.g();
    }
    
    Set<K> h() {
      return this.a.s();
    }
    
    Collection<V2> k() {
      return Collections2.a(this.a.m(), Maps.a(this.b));
    }
    
    Collection<Map.Entry<K, V2>> n() {
      return new AbstractMultimap.Entries(this);
    }
    
    Iterator<Map.Entry<K, V2>> o() {
      return Iterators.a(this.a.m().iterator(), Maps.b(this.b));
    }
    
    Map<K, Collection<V2>> p() {
      return Maps.a(this.a.c(), (Maps.EntryTransformer)new Maps.EntryTransformer<K, Collection<Collection<V1>>, Collection<Collection<V2>>>(this) {
            public Collection<V2> a(K param2K, Collection<V1> param2Collection) {
              return this.a.b(param2K, param2Collection);
            }
          });
    }
    
    public boolean r() {
      return this.a.r();
    }
  }
  
  class null implements Maps.EntryTransformer<K, Collection<V1>, Collection<V2>> {
    null(Multimaps this$0) {}
    
    public Collection<V2> a(K param1K, Collection<V1> param1Collection) {
      return this.a.b(param1K, param1Collection);
    }
  }
  
  static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
    public List<V> a(K param1K) {
      return Collections.unmodifiableList(d().a(param1K));
    }
    
    public List<V> b(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public ListMultimap<K, V> d() {
      return (ListMultimap<K, V>)super.a();
    }
  }
  
  static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
    final Multimap<K, V> a;
    
    @NullableDecl
    transient Collection<Map.Entry<K, V>> b;
    
    @NullableDecl
    transient Set<K> c;
    
    @NullableDecl
    transient Map<K, Collection<V>> d;
    
    protected Multimap<K, V> a() {
      return this.a;
    }
    
    public boolean a(K param1K, V param1V) {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> c(K param1K) {
      return Multimaps.a(this.a.c(param1K));
    }
    
    public Map<K, Collection<V>> c() {
      Map<K, Collection<V>> map2 = this.d;
      Map<K, Collection<V>> map1 = map2;
      if (map2 == null) {
        map1 = Collections.unmodifiableMap(Maps.a(this.a.c(), new Function<Collection<V>, Collection<V>>(this) {
                public Collection<V> a(Collection<V> param2Collection) {
                  return Multimaps.a(param2Collection);
                }
              }));
        this.d = map1;
      } 
      return map1;
    }
    
    public boolean c(Object param1Object1, Object param1Object2) {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> d(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public void g() {
      throw new UnsupportedOperationException();
    }
    
    public Collection<Map.Entry<K, V>> m() {
      Collection<Map.Entry<K, V>> collection2 = this.b;
      Collection<Map.Entry<K, V>> collection1 = collection2;
      if (collection2 == null) {
        collection1 = Multimaps.b(this.a.m());
        this.b = collection1;
      } 
      return collection1;
    }
    
    public Set<K> s() {
      Set<K> set2 = this.c;
      Set<K> set1 = set2;
      if (set2 == null) {
        set1 = Collections.unmodifiableSet(this.a.s());
        this.c = set1;
      } 
      return set1;
    }
  }
  
  class null implements Function<Collection<V>, Collection<V>> {
    null(Multimaps this$0) {}
    
    public Collection<V> a(Collection<V> param1Collection) {
      return Multimaps.a(param1Collection);
    }
  }
  
  static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
    public Set<V> a(K param1K) {
      return Collections.unmodifiableSet(d().a(param1K));
    }
    
    public Set<V> b(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public SetMultimap<K, V> d() {
      return (SetMultimap<K, V>)super.a();
    }
    
    public Set<Map.Entry<K, V>> t() {
      return Maps.a(d().t());
    }
  }
  
  static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    public SortedSetMultimap<K, V> e() {
      return (SortedSetMultimap<K, V>)super.d();
    }
    
    public SortedSet<V> h(K param1K) {
      return Collections.unmodifiableSortedSet(e().h(param1K));
    }
    
    public SortedSet<V> i(Object param1Object) {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Multimaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */