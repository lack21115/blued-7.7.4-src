package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
  final Multimap<K, V> a;
  
  final Predicate<? super Map.Entry<K, V>> b;
  
  static <E> Collection<E> a(Collection<E> paramCollection, Predicate<? super E> paramPredicate) {
    return (paramCollection instanceof Set) ? Sets.a((Set<E>)paramCollection, paramPredicate) : Collections2.a(paramCollection, paramPredicate);
  }
  
  private boolean d(K paramK, V paramV) {
    return this.b.a(Maps.a(paramK, paramV));
  }
  
  public Multimap<K, V> a() {
    return this.a;
  }
  
  boolean a(Predicate<? super Map.Entry<K, Collection<V>>> paramPredicate) {
    Iterator<Map.Entry> iterator = this.a.c().entrySet().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Object object = entry.getKey();
      Collection<?> collection = a((Collection)entry.getValue(), new ValuePredicate(this, (K)object));
      if (!collection.isEmpty() && paramPredicate.a(Maps.a(object, collection))) {
        if (collection.size() == ((Collection)entry.getValue()).size()) {
          iterator.remove();
        } else {
          collection.clear();
        } 
        bool = true;
      } 
    } 
    return bool;
  }
  
  public Predicate<? super Map.Entry<K, V>> b() {
    return this.b;
  }
  
  public Collection<V> c(K paramK) {
    return a(this.a.c(paramK), new ValuePredicate(this, paramK));
  }
  
  Collection<V> d() {
    return (Collection<V>)((this.a instanceof SetMultimap) ? Collections.emptySet() : Collections.emptyList());
  }
  
  public Collection<V> d(@NullableDecl Object paramObject) {
    return (Collection<V>)MoreObjects.a(c().remove(paramObject), d());
  }
  
  public int f() {
    return m().size();
  }
  
  public boolean f(@NullableDecl Object paramObject) {
    return (c().get(paramObject) != null);
  }
  
  public void g() {
    m().clear();
  }
  
  Set<K> h() {
    return c().keySet();
  }
  
  Collection<V> k() {
    return new FilteredMultimapValues<Object, V>(this);
  }
  
  Collection<Map.Entry<K, V>> n() {
    return a(this.a.m(), this.b);
  }
  
  Iterator<Map.Entry<K, V>> o() {
    throw new AssertionError("should never be called");
  }
  
  Map<K, Collection<V>> p() {
    return new AsMap(this);
  }
  
  class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
    AsMap(FilteredEntryMultimap this$0) {}
    
    public Collection<V> a(@NullableDecl Object<?> param1Object) {
      Collection<?> collection = (Collection)this.a.a.c().get(param1Object);
      if (collection == null)
        return null; 
      collection = FilteredEntryMultimap.a(collection, new FilteredEntryMultimap.ValuePredicate(this.a, (K)param1Object));
      param1Object = (Object<?>)collection;
      if (collection.isEmpty())
        param1Object = null; 
      return (Collection)param1Object;
    }
    
    Set<Map.Entry<K, Collection<V>>> a() {
      class EntrySetImpl extends Maps.EntrySet<K, Collection<V>> {
        EntrySetImpl(FilteredEntryMultimap.AsMap this$0) {}
        
        Map<K, Collection<V>> a() {
          return this.a;
        }
        
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
          return new AbstractIterator<Map.Entry<K, Collection<V>>>(this) {
              final Iterator<Map.Entry<K, Collection<V>>> a = this.b.a.a.a.c().entrySet().iterator();
              
              protected Map.Entry<K, Collection<V>> c() {
                while (this.a.hasNext()) {
                  Map.Entry entry = this.a.next();
                  Object object = entry.getKey();
                  Collection<?> collection = FilteredEntryMultimap.a((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this.b.a.a, (K)object));
                  if (!collection.isEmpty())
                    return (Map.Entry)Maps.a((K)object, collection); 
                } 
                return b();
              }
            };
        }
        
        public boolean removeAll(Collection<?> param2Collection) {
          return this.a.a.a(Predicates.a(param2Collection));
        }
        
        public boolean retainAll(Collection<?> param2Collection) {
          return this.a.a.a(Predicates.a(Predicates.a(param2Collection)));
        }
        
        public int size() {
          return Iterators.b(iterator());
        }
      };
      return new EntrySetImpl(this);
    }
    
    Collection<Collection<V>> b() {
      class ValuesImpl extends Maps.Values<K, Collection<V>> {
        ValuesImpl(FilteredEntryMultimap.AsMap this$0) {
          super(this$0);
        }
        
        public boolean remove(@NullableDecl Object param2Object) {
          if (param2Object instanceof Collection) {
            param2Object = param2Object;
            Iterator<Map.Entry> iterator = this.a.a.a.c().entrySet().iterator();
            while (iterator.hasNext()) {
              Map.Entry entry = iterator.next();
              Object<?> object = (Object<?>)entry.getKey();
              object = FilteredEntryMultimap.a((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this.a.a, (K)object));
              if (!object.isEmpty() && param2Object.equals(object)) {
                if (object.size() == ((Collection)entry.getValue()).size()) {
                  iterator.remove();
                } else {
                  object.clear();
                } 
                return true;
              } 
            } 
          } 
          return false;
        }
        
        public boolean removeAll(Collection<?> param2Collection) {
          return this.a.a.a(Maps.b(Predicates.a(param2Collection)));
        }
        
        public boolean retainAll(Collection<?> param2Collection) {
          return this.a.a.a(Maps.b(Predicates.a(Predicates.a(param2Collection))));
        }
      };
      return new ValuesImpl(this);
    }
    
    public Collection<V> b(@NullableDecl Object param1Object) {
      Collection collection = (Collection)this.a.a.c().get(param1Object);
      if (collection == null)
        return null; 
      ArrayList<?> arrayList = Lists.a();
      Iterator<Object> iterator = collection.iterator();
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (FilteredEntryMultimap.a(this.a, param1Object, object)) {
          iterator.remove();
          arrayList.add(object);
        } 
      } 
      return (Collection<V>)(arrayList.isEmpty() ? null : ((this.a.a instanceof SetMultimap) ? Collections.unmodifiableSet(Sets.a((Iterable)arrayList)) : Collections.unmodifiableList((List)arrayList)));
    }
    
    public void clear() {
      this.a.g();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return (a(param1Object) != null);
    }
    
    Set<K> h() {
      class KeySetImpl extends Maps.KeySet<K, Collection<V>> {
        KeySetImpl(FilteredEntryMultimap.AsMap this$0) {
          super(this$0);
        }
        
        public boolean remove(@NullableDecl Object param2Object) {
          return (this.a.b(param2Object) != null);
        }
        
        public boolean removeAll(Collection<?> param2Collection) {
          return this.a.a.a(Maps.a(Predicates.a(param2Collection)));
        }
        
        public boolean retainAll(Collection<?> param2Collection) {
          return this.a.a.a(Maps.a(Predicates.a(Predicates.a(param2Collection))));
        }
      };
      return new KeySetImpl(this);
    }
  }
  
  class EntrySetImpl extends Maps.EntrySet<K, Collection<V>> {
    EntrySetImpl(FilteredEntryMultimap this$0) {}
    
    Map<K, Collection<V>> a() {
      return this.a;
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
      return new AbstractIterator<Map.Entry<K, Collection<V>>>(this) {
          final Iterator<Map.Entry<K, Collection<V>>> a = this.b.a.a.a.c().entrySet().iterator();
          
          protected Map.Entry<K, Collection<V>> c() {
            while (this.a.hasNext()) {
              Map.Entry entry = this.a.next();
              Object object = entry.getKey();
              Collection<?> collection = FilteredEntryMultimap.a((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this.b.a.a, (K)object));
              if (!collection.isEmpty())
                return (Map.Entry)Maps.a((K)object, collection); 
            } 
            return b();
          }
        };
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return this.a.a.a(Predicates.a(param1Collection));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.a.a.a(Predicates.a(Predicates.a(param1Collection)));
    }
    
    public int size() {
      return Iterators.b(iterator());
    }
  }
  
  class null extends AbstractIterator<Map.Entry<K, Collection<V>>> {
    final Iterator<Map.Entry<K, Collection<V>>> a = this.b.a.a.a.c().entrySet().iterator();
    
    null(FilteredEntryMultimap this$0) {}
    
    protected Map.Entry<K, Collection<V>> c() {
      while (this.a.hasNext()) {
        Map.Entry entry = this.a.next();
        Object object = entry.getKey();
        Collection<?> collection = FilteredEntryMultimap.a((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this.b.a.a, (K)object));
        if (!collection.isEmpty())
          return (Map.Entry)Maps.a((K)object, collection); 
      } 
      return b();
    }
  }
  
  class KeySetImpl extends Maps.KeySet<K, Collection<V>> {
    KeySetImpl(FilteredEntryMultimap this$0) {
      super((Map<K, Collection<V>>)this$0);
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      return (this.a.b(param1Object) != null);
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return this.a.a.a(Maps.a(Predicates.a(param1Collection)));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.a.a.a(Maps.a(Predicates.a(Predicates.a(param1Collection))));
    }
  }
  
  class ValuesImpl extends Maps.Values<K, Collection<V>> {
    ValuesImpl(FilteredEntryMultimap this$0) {
      super((Map<K, Collection<V>>)this$0);
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      if (param1Object instanceof Collection) {
        param1Object = param1Object;
        Iterator<Map.Entry> iterator = this.a.a.a.c().entrySet().iterator();
        while (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          Object<?> object = (Object<?>)entry.getKey();
          object = FilteredEntryMultimap.a((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this.a.a, (K)object));
          if (!object.isEmpty() && param1Object.equals(object)) {
            if (object.size() == ((Collection)entry.getValue()).size()) {
              iterator.remove();
            } else {
              object.clear();
            } 
            return true;
          } 
        } 
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return this.a.a.a(Maps.b(Predicates.a(param1Collection)));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.a.a.a(Maps.b(Predicates.a(Predicates.a(param1Collection))));
    }
  }
  
  class Keys extends Multimaps.Keys<K, V> {
    public int b(@NullableDecl Object param1Object, int param1Int) {
      CollectPreconditions.a(param1Int, "occurrences");
      if (param1Int == 0)
        return a(param1Object); 
      Collection collection = (Collection)this.a.a.c().get(param1Object);
      int i = 0;
      if (collection == null)
        return 0; 
      Iterator<Object> iterator = collection.iterator();
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (FilteredEntryMultimap.a(this.a, param1Object, object)) {
          int j = i + 1;
          i = j;
          if (j <= param1Int) {
            iterator.remove();
            i = j;
          } 
        } 
      } 
      return i;
    }
    
    public Set<Multiset.Entry<K>> f() {
      return new Multisets.EntrySet<K>(this) {
          private boolean a(Predicate<? super Multiset.Entry<K>> param2Predicate) {
            return this.a.a.a(new Predicate<Map.Entry<K, Collection<V>>>(this, param2Predicate) {
                  public boolean a(Map.Entry<K, Collection<V>> param3Entry) {
                    return this.a.a(Multisets.a(param3Entry.getKey(), ((Collection)param3Entry.getValue()).size()));
                  }
                });
          }
          
          Multiset<K> a() {
            return this.a;
          }
          
          public Iterator<Multiset.Entry<K>> iterator() {
            return this.a.b();
          }
          
          public boolean removeAll(Collection<?> param2Collection) {
            return a(Predicates.a(param2Collection));
          }
          
          public boolean retainAll(Collection<?> param2Collection) {
            return a(Predicates.a(Predicates.a(param2Collection)));
          }
          
          public int size() {
            return this.a.a.s().size();
          }
        };
    }
  }
  
  class null extends Multisets.EntrySet<K> {
    null(FilteredEntryMultimap this$0) {}
    
    private boolean a(Predicate<? super Multiset.Entry<K>> param1Predicate) {
      return this.a.a.a(new Predicate<Map.Entry<K, Collection<V>>>(this, param1Predicate) {
            public boolean a(Map.Entry<K, Collection<V>> param3Entry) {
              return this.a.a(Multisets.a(param3Entry.getKey(), ((Collection)param3Entry.getValue()).size()));
            }
          });
    }
    
    Multiset<K> a() {
      return this.a;
    }
    
    public Iterator<Multiset.Entry<K>> iterator() {
      return this.a.b();
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return a(Predicates.a(param1Collection));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return a(Predicates.a(Predicates.a(param1Collection)));
    }
    
    public int size() {
      return this.a.a.s().size();
    }
  }
  
  class null implements Predicate<Map.Entry<K, Collection<V>>> {
    public boolean a(Map.Entry<K, Collection<V>> param1Entry) {
      return this.a.a(Multisets.a(param1Entry.getKey(), ((Collection)param1Entry.getValue()).size()));
    }
  }
  
  final class ValuePredicate implements Predicate<V> {
    private final K b;
    
    ValuePredicate(FilteredEntryMultimap this$0, K param1K) {
      this.b = param1K;
    }
    
    public boolean a(@NullableDecl V param1V) {
      return FilteredEntryMultimap.a(this.a, this.b, param1V);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\FilteredEntryMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */