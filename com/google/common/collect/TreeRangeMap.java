package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
  private static final RangeMap b = new RangeMap<Comparable, Object>() {
      public Map<Range, Object> b() {
        return Collections.emptyMap();
      }
    };
  
  private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> a = Maps.f();
  
  private void a(Cut<K> paramCut1, Cut<K> paramCut2, V paramV) {
    this.a.put(paramCut1, new RangeMapEntry<K, V>(paramCut1, paramCut2, paramV));
  }
  
  public void a(Range<K> paramRange) {
    if (paramRange.k())
      return; 
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry = this.a.lowerEntry(paramRange.a);
    if (entry != null) {
      RangeMapEntry rangeMapEntry = entry.getValue();
      if (rangeMapEntry.c().a(paramRange.a) > 0) {
        if (rangeMapEntry.c().a(paramRange.b) > 0)
          a(paramRange.b, rangeMapEntry.c(), (V)((RangeMapEntry)entry.getValue()).getValue()); 
        a(rangeMapEntry.b(), paramRange.a, (V)((RangeMapEntry)entry.getValue()).getValue());
      } 
    } 
    entry = this.a.lowerEntry(paramRange.b);
    if (entry != null) {
      RangeMapEntry rangeMapEntry = entry.getValue();
      if (rangeMapEntry.c().a(paramRange.b) > 0)
        a(paramRange.b, rangeMapEntry.c(), (V)((RangeMapEntry)entry.getValue()).getValue()); 
    } 
    this.a.subMap(paramRange.a, paramRange.b).clear();
  }
  
  public Map<Range<K>, V> b() {
    return new AsMapOfRanges(this, this.a.values());
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject instanceof RangeMap) {
      paramObject = paramObject;
      return b().equals(paramObject.b());
    } 
    return false;
  }
  
  public int hashCode() {
    return b().hashCode();
  }
  
  public String toString() {
    return this.a.values().toString();
  }
  
  final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {
    final Iterable<Map.Entry<Range<K>, V>> a;
    
    AsMapOfRanges(TreeRangeMap this$0, Iterable<TreeRangeMap.RangeMapEntry<K, V>> param1Iterable) {
      this.a = (Iterable)param1Iterable;
    }
    
    Iterator<Map.Entry<Range<K>, V>> b() {
      return this.a.iterator();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return (get(param1Object) != null);
    }
    
    public V get(@NullableDecl Object param1Object) {
      if (param1Object instanceof Range) {
        param1Object = param1Object;
        TreeRangeMap.RangeMapEntry rangeMapEntry = (TreeRangeMap.RangeMapEntry)TreeRangeMap.a(this.b).get(((Range)param1Object).a);
        if (rangeMapEntry != null && rangeMapEntry.a().equals(param1Object))
          return (V)rangeMapEntry.getValue(); 
      } 
      return null;
    }
    
    public int size() {
      return TreeRangeMap.a(this.b).size();
    }
  }
  
  static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
    private final Range<K> a;
    
    private final V b;
    
    RangeMapEntry(Cut<K> param1Cut1, Cut<K> param1Cut2, V param1V) {
      this(Range.a(param1Cut1, param1Cut2), param1V);
    }
    
    RangeMapEntry(Range<K> param1Range, V param1V) {
      this.a = param1Range;
      this.b = param1V;
    }
    
    public Range<K> a() {
      return this.a;
    }
    
    Cut<K> b() {
      return this.a.a;
    }
    
    Cut<K> c() {
      return this.a.b;
    }
    
    public V getValue() {
      return this.b;
    }
  }
  
  class SubRangeMap implements RangeMap<K, V> {
    private final Range<K> b;
    
    public void a() {
      this.a.a(this.b);
    }
    
    public Map<Range<K>, V> b() {
      return new SubRangeMapAsMap(this);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof RangeMap) {
        param1Object = param1Object;
        return b().equals(param1Object.b());
      } 
      return false;
    }
    
    public int hashCode() {
      return b().hashCode();
    }
    
    public String toString() {
      return b().toString();
    }
    
    class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
      SubRangeMapAsMap(TreeRangeMap.SubRangeMap this$0) {}
      
      private boolean a(Predicate<? super Map.Entry<Range<K>, V>> param2Predicate) {
        ArrayList<?> arrayList = Lists.a();
        for (Map.Entry<Range<K>, V> entry : entrySet()) {
          if (param2Predicate.a(entry))
            arrayList.add(entry.getKey()); 
        } 
        for (Range range : arrayList)
          this.b.a.a(range); 
        return arrayList.isEmpty() ^ true;
      }
      
      Iterator<Map.Entry<Range<K>, V>> a() {
        if (TreeRangeMap.SubRangeMap.a(this.b).k())
          return Iterators.a(); 
        Cut cut = (Cut)MoreObjects.a(TreeRangeMap.a(this.b.a).floorKey((TreeRangeMap.SubRangeMap.a(this.b)).a), (TreeRangeMap.SubRangeMap.a(this.b)).a);
        return new AbstractIterator<Map.Entry<Range<K>, V>>(this, TreeRangeMap.a(this.b.a).tailMap(cut, true).values().iterator()) {
            protected Map.Entry<Range<K>, V> c() {
              while (this.a.hasNext()) {
                TreeRangeMap.RangeMapEntry rangeMapEntry = this.a.next();
                if (rangeMapEntry.b().a((TreeRangeMap.SubRangeMap.a(this.b.b)).b) >= 0)
                  return b(); 
                if (rangeMapEntry.c().a((TreeRangeMap.SubRangeMap.a(this.b.b)).a) > 0)
                  return Maps.a(rangeMapEntry.a().c(TreeRangeMap.SubRangeMap.a(this.b.b)), (V)rangeMapEntry.getValue()); 
              } 
              return b();
            }
          };
      }
      
      public void clear() {
        this.b.a();
      }
      
      public boolean containsKey(Object param2Object) {
        return (get(param2Object) != null);
      }
      
      public Set<Map.Entry<Range<K>, V>> entrySet() {
        return (Set)new Maps.EntrySet<Range<Range<K>>, V>(this) {
            Map<Range<K>, V> a() {
              return this.a;
            }
            
            public boolean isEmpty() {
              return iterator().hasNext() ^ true;
            }
            
            public Iterator<Map.Entry<Range<K>, V>> iterator() {
              return this.a.a();
            }
            
            public boolean retainAll(Collection<?> param3Collection) {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(param3Collection)));
            }
            
            public int size() {
              return Iterators.b(iterator());
            }
          };
      }
      
      public V get(Object param2Object) {
        try {
          if (param2Object instanceof Range) {
            Range range = (Range)param2Object;
            if (TreeRangeMap.SubRangeMap.a(this.b).a(range)) {
              if (range.k())
                return null; 
              if (range.a.a((TreeRangeMap.SubRangeMap.a(this.b)).a) == 0) {
                param2Object = TreeRangeMap.a(this.b.a).floorEntry(range.a);
                if (param2Object != null) {
                  param2Object = param2Object.getValue();
                } else {
                  param2Object = null;
                } 
              } else {
                param2Object = TreeRangeMap.a(this.b.a).get(range.a);
              } 
              if (param2Object != null && param2Object.a().b(TreeRangeMap.SubRangeMap.a(this.b)) && param2Object.a().c(TreeRangeMap.SubRangeMap.a(this.b)).equals(range))
                return (V)param2Object.getValue(); 
            } 
          } 
          return null;
        } catch (ClassCastException classCastException) {
          return null;
        } 
      }
      
      public Set<Range<K>> keySet() {
        return (Set)new Maps.KeySet<Range<Range<K>>, V>(this, this) {
            public boolean remove(@NullableDecl Object param3Object) {
              return (this.a.remove(param3Object) != null);
            }
            
            public boolean retainAll(Collection<?> param3Collection) {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(Predicates.a(param3Collection)), Maps.a()));
            }
          };
      }
      
      public V remove(Object param2Object) {
        V v = get(param2Object);
        if (v != null) {
          param2Object = param2Object;
          this.b.a.a((Range)param2Object);
          return v;
        } 
        return null;
      }
      
      public Collection<V> values() {
        return new Maps.Values<Range<Range<K>>, V>(this, this) {
            public boolean removeAll(Collection<?> param3Collection) {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(param3Collection), Maps.b()));
            }
            
            public boolean retainAll(Collection<?> param3Collection) {
              return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(Predicates.a(param3Collection)), Maps.b()));
            }
          };
      }
    }
    
    class null extends Maps.KeySet<Range<K>, V> {
      null(TreeRangeMap.SubRangeMap this$0, Map<Range<K>, V> param2Map) {
        super(param2Map);
      }
      
      public boolean remove(@NullableDecl Object param2Object) {
        return (this.a.remove(param2Object) != null);
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(Predicates.a(param2Collection)), Maps.a()));
      }
    }
    
    class null extends Maps.EntrySet<Range<K>, V> {
      null(TreeRangeMap.SubRangeMap this$0) {}
      
      Map<Range<K>, V> a() {
        return this.a;
      }
      
      public boolean isEmpty() {
        return iterator().hasNext() ^ true;
      }
      
      public Iterator<Map.Entry<Range<K>, V>> iterator() {
        return this.a.a();
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(param2Collection)));
      }
      
      public int size() {
        return Iterators.b(iterator());
      }
    }
    
    class null extends AbstractIterator<Map.Entry<Range<K>, V>> {
      null(TreeRangeMap.SubRangeMap this$0, Iterator param2Iterator) {}
      
      protected Map.Entry<Range<K>, V> c() {
        while (this.a.hasNext()) {
          TreeRangeMap.RangeMapEntry rangeMapEntry = this.a.next();
          if (rangeMapEntry.b().a((TreeRangeMap.SubRangeMap.a(this.b.b)).b) >= 0)
            return b(); 
          if (rangeMapEntry.c().a((TreeRangeMap.SubRangeMap.a(this.b.b)).a) > 0)
            return Maps.a(rangeMapEntry.a().c(TreeRangeMap.SubRangeMap.a(this.b.b)), (V)rangeMapEntry.getValue()); 
        } 
        return b();
      }
    }
    
    class null extends Maps.Values<Range<K>, V> {
      null(TreeRangeMap.SubRangeMap this$0, Map<Range<K>, V> param2Map) {
        super(param2Map);
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(param2Collection), Maps.b()));
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(Predicates.a(param2Collection)), Maps.b()));
      }
    }
  }
  
  class null extends SubRangeMap.SubRangeMapAsMap {
    Iterator<Map.Entry<Range<K>, V>> a() {
      return TreeRangeMap.SubRangeMap.a(this.a).k() ? Iterators.a() : new AbstractIterator<Map.Entry<Range<K>, V>>(this, TreeRangeMap.a(this.a.a).headMap((TreeRangeMap.SubRangeMap.a(this.a)).b, false).descendingMap().values().iterator()) {
          protected Map.Entry<Range<K>, V> c() {
            if (this.a.hasNext()) {
              TreeRangeMap.RangeMapEntry rangeMapEntry = this.a.next();
              return (rangeMapEntry.c().a((TreeRangeMap.SubRangeMap.a(this.b.a)).a) <= 0) ? b() : Maps.a(rangeMapEntry.a().c(TreeRangeMap.SubRangeMap.a(this.b.a)), (V)rangeMapEntry.getValue());
            } 
            return b();
          }
        };
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Range<K>, V>> {
    protected Map.Entry<Range<K>, V> c() {
      if (this.a.hasNext()) {
        TreeRangeMap.RangeMapEntry rangeMapEntry = this.a.next();
        return (rangeMapEntry.c().a((TreeRangeMap.SubRangeMap.a(this.b.a)).a) <= 0) ? b() : Maps.a(rangeMapEntry.a().c(TreeRangeMap.SubRangeMap.a(this.b.a)), (V)rangeMapEntry.getValue());
      } 
      return b();
    }
  }
  
  class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
    SubRangeMapAsMap(TreeRangeMap this$0) {}
    
    private boolean a(Predicate<? super Map.Entry<Range<K>, V>> param1Predicate) {
      ArrayList<?> arrayList = Lists.a();
      for (Map.Entry<Range<K>, V> entry : entrySet()) {
        if (param1Predicate.a(entry))
          arrayList.add(entry.getKey()); 
      } 
      for (Range range : arrayList)
        this.b.a.a(range); 
      return arrayList.isEmpty() ^ true;
    }
    
    Iterator<Map.Entry<Range<K>, V>> a() {
      if (TreeRangeMap.SubRangeMap.a(this.b).k())
        return Iterators.a(); 
      Cut cut = (Cut)MoreObjects.a(TreeRangeMap.a(this.b.a).floorKey((TreeRangeMap.SubRangeMap.a(this.b)).a), (TreeRangeMap.SubRangeMap.a(this.b)).a);
      return new AbstractIterator<Map.Entry<Range<K>, V>>(this, TreeRangeMap.a(this.b.a).tailMap(cut, true).values().iterator()) {
          protected Map.Entry<Range<K>, V> c() {
            while (this.a.hasNext()) {
              TreeRangeMap.RangeMapEntry rangeMapEntry = this.a.next();
              if (rangeMapEntry.b().a((TreeRangeMap.SubRangeMap.a(this.b.b)).b) >= 0)
                return b(); 
              if (rangeMapEntry.c().a((TreeRangeMap.SubRangeMap.a(this.b.b)).a) > 0)
                return Maps.a(rangeMapEntry.a().c(TreeRangeMap.SubRangeMap.a(this.b.b)), (V)rangeMapEntry.getValue()); 
            } 
            return b();
          }
        };
    }
    
    public void clear() {
      this.b.a();
    }
    
    public boolean containsKey(Object param1Object) {
      return (get(param1Object) != null);
    }
    
    public Set<Map.Entry<Range<K>, V>> entrySet() {
      return (Set)new Maps.EntrySet<Range<Range<K>>, V>(this) {
          Map<Range<K>, V> a() {
            return this.a;
          }
          
          public boolean isEmpty() {
            return iterator().hasNext() ^ true;
          }
          
          public Iterator<Map.Entry<Range<K>, V>> iterator() {
            return this.a.a();
          }
          
          public boolean retainAll(Collection<?> param3Collection) {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(param3Collection)));
          }
          
          public int size() {
            return Iterators.b(iterator());
          }
        };
    }
    
    public V get(Object param1Object) {
      try {
        if (param1Object instanceof Range) {
          Range range = (Range)param1Object;
          if (TreeRangeMap.SubRangeMap.a(this.b).a(range)) {
            if (range.k())
              return null; 
            if (range.a.a((TreeRangeMap.SubRangeMap.a(this.b)).a) == 0) {
              param1Object = TreeRangeMap.a(this.b.a).floorEntry(range.a);
              if (param1Object != null) {
                param1Object = param1Object.getValue();
              } else {
                param1Object = null;
              } 
            } else {
              param1Object = TreeRangeMap.a(this.b.a).get(range.a);
            } 
            if (param1Object != null && param1Object.a().b(TreeRangeMap.SubRangeMap.a(this.b)) && param1Object.a().c(TreeRangeMap.SubRangeMap.a(this.b)).equals(range))
              return (V)param1Object.getValue(); 
          } 
        } 
        return null;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    public Set<Range<K>> keySet() {
      return (Set)new Maps.KeySet<Range<Range<K>>, V>(this, this) {
          public boolean remove(@NullableDecl Object param3Object) {
            return (this.a.remove(param3Object) != null);
          }
          
          public boolean retainAll(Collection<?> param3Collection) {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(Predicates.a(param3Collection)), Maps.a()));
          }
        };
    }
    
    public V remove(Object param1Object) {
      V v = get(param1Object);
      if (v != null) {
        param1Object = param1Object;
        this.b.a.a((Range)param1Object);
        return v;
      } 
      return null;
    }
    
    public Collection<V> values() {
      return new Maps.Values<Range<Range<K>>, V>(this, this) {
          public boolean removeAll(Collection<?> param3Collection) {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(param3Collection), Maps.b()));
          }
          
          public boolean retainAll(Collection<?> param3Collection) {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(Predicates.a(param3Collection)), Maps.b()));
          }
        };
    }
  }
  
  class null extends Maps.KeySet<Range<K>, V> {
    null(TreeRangeMap this$0, Map<Range<K>, V> param1Map) {
      super(param1Map);
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      return (this.a.remove(param1Object) != null);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(Predicates.a(param1Collection)), Maps.a()));
    }
  }
  
  class null extends Maps.EntrySet<Range<K>, V> {
    null(TreeRangeMap this$0) {}
    
    Map<Range<K>, V> a() {
      return this.a;
    }
    
    public boolean isEmpty() {
      return iterator().hasNext() ^ true;
    }
    
    public Iterator<Map.Entry<Range<K>, V>> iterator() {
      return this.a.a();
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(param1Collection)));
    }
    
    public int size() {
      return Iterators.b(iterator());
    }
  }
  
  class null extends AbstractIterator<Map.Entry<Range<K>, V>> {
    null(TreeRangeMap this$0, Iterator param1Iterator) {}
    
    protected Map.Entry<Range<K>, V> c() {
      while (this.a.hasNext()) {
        TreeRangeMap.RangeMapEntry rangeMapEntry = this.a.next();
        if (rangeMapEntry.b().a((TreeRangeMap.SubRangeMap.a(this.b.b)).b) >= 0)
          return b(); 
        if (rangeMapEntry.c().a((TreeRangeMap.SubRangeMap.a(this.b.b)).a) > 0)
          return Maps.a(rangeMapEntry.a().c(TreeRangeMap.SubRangeMap.a(this.b.b)), (V)rangeMapEntry.getValue()); 
      } 
      return b();
    }
  }
  
  class null extends Maps.Values<Range<K>, V> {
    null(TreeRangeMap this$0, Map<Range<K>, V> param1Map) {
      super(param1Map);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(param1Collection), Maps.b()));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.a(this.a, Predicates.a(Predicates.a(Predicates.a(param1Collection)), Maps.b()));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\TreeRangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */