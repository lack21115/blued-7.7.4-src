package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
  @GwtTransient
  final Map<R, Map<C, V>> a;
  
  @GwtTransient
  final Supplier<? extends Map<C, V>> b;
  
  @NullableDecl
  private transient Set<C> c;
  
  @NullableDecl
  private transient Map<R, Map<C, V>> d;
  
  @NullableDecl
  private transient ColumnMap e;
  
  StandardTable(Map<R, Map<C, V>> paramMap, Supplier<? extends Map<C, V>> paramSupplier) {
    this.a = paramMap;
    this.b = paramSupplier;
  }
  
  private boolean b(Object paramObject1, Object paramObject2, Object paramObject3) {
    return (paramObject3 != null && paramObject3.equals(b(paramObject1, paramObject2)));
  }
  
  private boolean c(Object paramObject1, Object paramObject2, Object paramObject3) {
    if (b(paramObject1, paramObject2, paramObject3)) {
      c(paramObject1, paramObject2);
      return true;
    } 
    return false;
  }
  
  private Map<C, V> f(R paramR) {
    Map<C, V> map2 = this.a.get(paramR);
    Map<C, V> map1 = map2;
    if (map2 == null) {
      map1 = (Map)this.b.get();
      this.a.put(paramR, map1);
    } 
    return map1;
  }
  
  private Map<R, V> g(Object paramObject) {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    Iterator<Map.Entry> iterator = this.a.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Object object = ((Map)entry.getValue()).remove(paramObject);
      if (object != null) {
        linkedHashMap.put(entry.getKey(), object);
        if (((Map)entry.getValue()).isEmpty())
          iterator.remove(); 
      } 
    } 
    return (Map)linkedHashMap;
  }
  
  public V a(R paramR, C paramC, V paramV) {
    Preconditions.a(paramR);
    Preconditions.a(paramC);
    Preconditions.a(paramV);
    return f(paramR).put(paramC, paramV);
  }
  
  public Set<R> a() {
    return o().keySet();
  }
  
  public boolean a(@NullableDecl Object paramObject) {
    return (paramObject != null && Maps.b(this.a, paramObject));
  }
  
  public boolean a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return (paramObject1 != null && paramObject2 != null && super.a(paramObject1, paramObject2));
  }
  
  public V b(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return (paramObject1 == null || paramObject2 == null) ? null : super.b(paramObject1, paramObject2);
  }
  
  public Set<C> b() {
    Set<C> set2 = this.c;
    Set<C> set1 = set2;
    if (set2 == null) {
      set1 = new ColumnKeySet();
      this.c = set1;
    } 
    return set1;
  }
  
  public boolean b(@NullableDecl Object paramObject) {
    if (paramObject == null)
      return false; 
    Iterator<Map<?, ?>> iterator = this.a.values().iterator();
    while (iterator.hasNext()) {
      if (Maps.b(iterator.next(), paramObject))
        return true; 
    } 
    return false;
  }
  
  public V c(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    if (paramObject1 != null) {
      if (paramObject2 == null)
        return null; 
      Map map = Maps.<Map>a((Map)this.a, paramObject1);
      if (map == null)
        return null; 
      paramObject2 = map.remove(paramObject2);
      if (map.isEmpty())
        this.a.remove(paramObject1); 
      return (V)paramObject2;
    } 
    return null;
  }
  
  public boolean c() {
    return this.a.isEmpty();
  }
  
  public boolean c(@NullableDecl Object paramObject) {
    return (paramObject != null && super.c(paramObject));
  }
  
  public Map<R, V> d(C paramC) {
    return new Column(this, paramC);
  }
  
  public void d() {
    this.a.clear();
  }
  
  public Map<C, V> e(R paramR) {
    return new Row(this, paramR);
  }
  
  public Set<Table.Cell<R, C, V>> e() {
    return super.e();
  }
  
  Iterator<Table.Cell<R, C, V>> g() {
    return new CellIterator();
  }
  
  public Collection<V> h() {
    return super.h();
  }
  
  public int k() {
    Iterator<Map> iterator = this.a.values().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((Map)iterator.next()).size());
    return i;
  }
  
  public Map<C, Map<R, V>> m() {
    ColumnMap columnMap2 = this.e;
    ColumnMap columnMap1 = columnMap2;
    if (columnMap2 == null) {
      columnMap1 = new ColumnMap();
      this.e = columnMap1;
    } 
    return columnMap1;
  }
  
  Map<R, Map<C, V>> n() {
    return new RowMap(this);
  }
  
  public Map<R, Map<C, V>> o() {
    Map<R, Map<C, V>> map2 = this.d;
    Map<R, Map<C, V>> map1 = map2;
    if (map2 == null) {
      map1 = n();
      this.d = map1;
    } 
    return map1;
  }
  
  Iterator<C> p() {
    return new ColumnKeyIterator();
  }
  
  class CellIterator implements Iterator<Table.Cell<R, C, V>> {
    final Iterator<Map.Entry<R, Map<C, V>>> a = this.d.a.entrySet().iterator();
    
    @NullableDecl
    Map.Entry<R, Map<C, V>> b;
    
    Iterator<Map.Entry<C, V>> c = Iterators.c();
    
    private CellIterator(StandardTable this$0) {}
    
    public Table.Cell<R, C, V> a() {
      if (!this.c.hasNext()) {
        this.b = this.a.next();
        this.c = ((Map<C, V>)this.b.getValue()).entrySet().iterator();
      } 
      Map.Entry entry = this.c.next();
      return Tables.a(this.b.getKey(), (C)entry.getKey(), (V)entry.getValue());
    }
    
    public boolean hasNext() {
      return (this.a.hasNext() || this.c.hasNext());
    }
    
    public void remove() {
      this.c.remove();
      if (((Map)this.b.getValue()).isEmpty()) {
        this.a.remove();
        this.b = null;
      } 
    }
  }
  
  class Column extends Maps.ViewCachingAbstractMap<R, V> {
    final C a;
    
    Column(StandardTable this$0, C param1C) {
      this.a = (C)Preconditions.a(param1C);
    }
    
    Set<Map.Entry<R, V>> a() {
      return new EntrySet();
    }
    
    boolean a(Predicate<? super Map.Entry<R, V>> param1Predicate) {
      Iterator<Map.Entry> iterator = this.b.a.entrySet().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        Map map = (Map)entry.getValue();
        Object object = map.get(this.a);
        if (object != null && param1Predicate.a(Maps.a(entry.getKey(), object))) {
          map.remove(this.a);
          boolean bool1 = true;
          bool = bool1;
          if (map.isEmpty()) {
            iterator.remove();
            bool = bool1;
          } 
        } 
      } 
      return bool;
    }
    
    Collection<V> b() {
      return new Values(this);
    }
    
    public boolean containsKey(Object param1Object) {
      return this.b.a(param1Object, this.a);
    }
    
    public V get(Object param1Object) {
      return (V)this.b.b(param1Object, this.a);
    }
    
    Set<R> h() {
      return new KeySet(this);
    }
    
    public V put(R param1R, V param1V) {
      return this.b.a(param1R, this.a, param1V);
    }
    
    public V remove(Object param1Object) {
      return (V)this.b.c(param1Object, this.a);
    }
    
    class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
      private EntrySet(StandardTable.Column this$0) {}
      
      public void clear() {
        this.a.a(Predicates.a());
      }
      
      public boolean contains(Object param2Object) {
        if (param2Object instanceof Map.Entry) {
          param2Object = param2Object;
          return StandardTable.a(this.a.b, param2Object.getKey(), this.a.a, param2Object.getValue());
        } 
        return false;
      }
      
      public boolean isEmpty() {
        return this.a.b.b(this.a.a) ^ true;
      }
      
      public Iterator<Map.Entry<R, V>> iterator() {
        return new StandardTable.Column.EntrySetIterator();
      }
      
      public boolean remove(Object param2Object) {
        if (param2Object instanceof Map.Entry) {
          param2Object = param2Object;
          return StandardTable.b(this.a.b, param2Object.getKey(), this.a.a, param2Object.getValue());
        } 
        return false;
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return this.a.a(Predicates.a(Predicates.a(param2Collection)));
      }
      
      public int size() {
        Iterator<Map> iterator = this.a.b.a.values().iterator();
        int i = 0;
        while (iterator.hasNext()) {
          if (((Map)iterator.next()).containsKey(this.a.a))
            i++; 
        } 
        return i;
      }
    }
    
    class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {
      final Iterator<Map.Entry<R, Map<C, V>>> a = this.b.b.a.entrySet().iterator();
      
      private EntrySetIterator(StandardTable.Column this$0) {}
      
      protected Map.Entry<R, V> c() {
        while (this.a.hasNext()) {
          Map.Entry entry = this.a.next();
          if (((Map)entry.getValue()).containsKey(this.b.a)) {
            class EntryImpl extends AbstractMapEntry<R, V> {
              EntryImpl(StandardTable.Column.EntrySetIterator this$0, Map.Entry param3Entry) {}
              
              public R getKey() {
                return (R)this.a.getKey();
              }
              
              public V getValue() {
                return (V)((Map)this.a.getValue()).get(this.b.b.a);
              }
              
              public V setValue(V param3V) {
                return ((Map<C, V>)this.a.getValue()).put(this.b.b.a, (V)Preconditions.a(param3V));
              }
            };
            return new EntryImpl(this, entry);
          } 
        } 
        return b();
      }
    }
    
    class EntryImpl extends AbstractMapEntry<R, V> {
      EntryImpl(StandardTable.Column this$0, Map.Entry param2Entry) {}
      
      public R getKey() {
        return (R)this.a.getKey();
      }
      
      public V getValue() {
        return (V)((Map)this.a.getValue()).get(this.b.b.a);
      }
      
      public V setValue(V param2V) {
        return ((Map<C, V>)this.a.getValue()).put(this.b.b.a, (V)Preconditions.a(param2V));
      }
    }
    
    class KeySet extends Maps.KeySet<R, V> {
      KeySet(StandardTable.Column this$0) {
        super(this$0);
      }
      
      public boolean contains(Object param2Object) {
        return this.a.b.a(param2Object, this.a.a);
      }
      
      public boolean remove(Object param2Object) {
        return (this.a.b.c(param2Object, this.a.a) != null);
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return this.a.a((Predicate)Maps.a(Predicates.a(Predicates.a(param2Collection))));
      }
    }
    
    class Values extends Maps.Values<R, V> {
      Values(StandardTable.Column this$0) {
        super(this$0);
      }
      
      public boolean remove(Object param2Object) {
        return (param2Object != null && this.a.a((Predicate)Maps.b(Predicates.a(param2Object))));
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        return this.a.a((Predicate)Maps.b(Predicates.a(param2Collection)));
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return this.a.a((Predicate)Maps.b(Predicates.a(Predicates.a(param2Collection))));
      }
    }
  }
  
  class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
    private EntrySet(StandardTable this$0) {}
    
    public void clear() {
      this.a.a(Predicates.a());
    }
    
    public boolean contains(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return StandardTable.a(this.a.b, param1Object.getKey(), this.a.a, param1Object.getValue());
      } 
      return false;
    }
    
    public boolean isEmpty() {
      return this.a.b.b(this.a.a) ^ true;
    }
    
    public Iterator<Map.Entry<R, V>> iterator() {
      return new StandardTable.Column.EntrySetIterator();
    }
    
    public boolean remove(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return StandardTable.b(this.a.b, param1Object.getKey(), this.a.a, param1Object.getValue());
      } 
      return false;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.a.a(Predicates.a(Predicates.a(param1Collection)));
    }
    
    public int size() {
      Iterator<Map> iterator = this.a.b.a.values().iterator();
      int i = 0;
      while (iterator.hasNext()) {
        if (((Map)iterator.next()).containsKey(this.a.a))
          i++; 
      } 
      return i;
    }
  }
  
  class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {
    final Iterator<Map.Entry<R, Map<C, V>>> a = this.b.b.a.entrySet().iterator();
    
    private EntrySetIterator(StandardTable this$0) {}
    
    protected Map.Entry<R, V> c() {
      while (this.a.hasNext()) {
        Map.Entry entry = this.a.next();
        if (((Map)entry.getValue()).containsKey(this.b.a)) {
          class EntryImpl extends AbstractMapEntry<R, V> {
            EntryImpl(StandardTable.Column.EntrySetIterator this$0, Map.Entry param3Entry) {}
            
            public R getKey() {
              return (R)this.a.getKey();
            }
            
            public V getValue() {
              return (V)((Map)this.a.getValue()).get(this.b.b.a);
            }
            
            public V setValue(V param3V) {
              return ((Map<C, V>)this.a.getValue()).put(this.b.b.a, (V)Preconditions.a(param3V));
            }
          };
          return new EntryImpl(this, entry);
        } 
      } 
      return b();
    }
  }
  
  class EntryImpl extends AbstractMapEntry<R, V> {
    EntryImpl(StandardTable this$0, Map.Entry param1Entry) {}
    
    public R getKey() {
      return (R)this.a.getKey();
    }
    
    public V getValue() {
      return (V)((Map)this.a.getValue()).get(this.b.b.a);
    }
    
    public V setValue(V param1V) {
      return ((Map<C, V>)this.a.getValue()).put(this.b.b.a, (V)Preconditions.a(param1V));
    }
  }
  
  class KeySet extends Maps.KeySet<R, V> {
    KeySet(StandardTable this$0) {
      super((Map<R, V>)this$0);
    }
    
    public boolean contains(Object param1Object) {
      return this.a.b.a(param1Object, this.a.a);
    }
    
    public boolean remove(Object param1Object) {
      return (this.a.b.c(param1Object, this.a.a) != null);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.a.a((Predicate)Maps.a(Predicates.a(Predicates.a(param1Collection))));
    }
  }
  
  class Values extends Maps.Values<R, V> {
    Values(StandardTable this$0) {
      super((Map<R, V>)this$0);
    }
    
    public boolean remove(Object param1Object) {
      return (param1Object != null && this.a.a((Predicate)Maps.b(Predicates.a(param1Object))));
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return this.a.a((Predicate)Maps.b(Predicates.a(param1Collection)));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.a.a((Predicate)Maps.b(Predicates.a(Predicates.a(param1Collection))));
    }
  }
  
  class ColumnKeyIterator extends AbstractIterator<C> {
    final Map<C, V> a = (Map<C, V>)this.d.b.get();
    
    final Iterator<Map<C, V>> b = this.d.a.values().iterator();
    
    Iterator<Map.Entry<C, V>> c = Iterators.a();
    
    private ColumnKeyIterator(StandardTable this$0) {}
    
    protected C a() {
      while (true) {
        while (this.c.hasNext()) {
          Map.Entry entry = this.c.next();
          if (!this.a.containsKey(entry.getKey())) {
            this.a.put((C)entry.getKey(), (V)entry.getValue());
            return (C)entry.getKey();
          } 
        } 
        if (this.b.hasNext()) {
          this.c = ((Map<C, V>)this.b.next()).entrySet().iterator();
          continue;
        } 
        return b();
      } 
    }
  }
  
  class ColumnKeySet extends TableSet<C> {
    private ColumnKeySet(StandardTable this$0) {}
    
    public boolean contains(Object param1Object) {
      return this.a.b(param1Object);
    }
    
    public Iterator<C> iterator() {
      return this.a.p();
    }
    
    public boolean remove(Object param1Object) {
      boolean bool = false;
      if (param1Object == null)
        return false; 
      Iterator<Map> iterator = this.a.a.values().iterator();
      while (iterator.hasNext()) {
        Map map = iterator.next();
        if (map.keySet().remove(param1Object)) {
          boolean bool1 = true;
          bool = bool1;
          if (map.isEmpty()) {
            iterator.remove();
            bool = bool1;
          } 
        } 
      } 
      return bool;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      Preconditions.a(param1Collection);
      Iterator<Map> iterator = this.a.a.values().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map map = iterator.next();
        if (Iterators.a(map.keySet().iterator(), param1Collection)) {
          boolean bool1 = true;
          bool = bool1;
          if (map.isEmpty()) {
            iterator.remove();
            bool = bool1;
          } 
        } 
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Preconditions.a(param1Collection);
      Iterator<Map> iterator = this.a.a.values().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map map = iterator.next();
        if (map.keySet().retainAll(param1Collection)) {
          boolean bool1 = true;
          bool = bool1;
          if (map.isEmpty()) {
            iterator.remove();
            bool = bool1;
          } 
        } 
      } 
      return bool;
    }
    
    public int size() {
      return Iterators.b(iterator());
    }
  }
  
  class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {
    private ColumnMap(StandardTable this$0) {}
    
    public Map<R, V> a(Object param1Object) {
      return this.a.b(param1Object) ? this.a.d(param1Object) : null;
    }
    
    public Set<Map.Entry<C, Map<R, V>>> a() {
      return new ColumnMapEntrySet(this);
    }
    
    Collection<Map<R, V>> b() {
      return new ColumnMapValues(this);
    }
    
    public Map<R, V> b(Object param1Object) {
      return this.a.b(param1Object) ? StandardTable.a(this.a, param1Object) : null;
    }
    
    public boolean containsKey(Object param1Object) {
      return this.a.b(param1Object);
    }
    
    public Set<C> keySet() {
      return this.a.b();
    }
    
    class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {
      ColumnMapEntrySet(StandardTable.ColumnMap this$0) {
        super(this$0.a);
      }
      
      public boolean contains(Object param2Object) {
        if (param2Object instanceof Map.Entry) {
          param2Object = param2Object;
          if (this.a.a.b(param2Object.getKey())) {
            Object object = param2Object.getKey();
            return this.a.a(object).equals(param2Object.getValue());
          } 
        } 
        return false;
      }
      
      public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
        return Maps.b(this.a.a.b(), new Function<C, Map<R, V>>(this) {
              public Map<R, V> a(C param3C) {
                return this.a.a.a.d(param3C);
              }
            });
      }
      
      public boolean remove(Object param2Object) {
        if (contains(param2Object)) {
          param2Object = param2Object;
          StandardTable.a(this.a.a, param2Object.getKey());
          return true;
        } 
        return false;
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        Preconditions.a(param2Collection);
        return Sets.a(this, param2Collection.iterator());
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        Preconditions.a(param2Collection);
        Iterator<Object> iterator = Lists.a(this.a.a.b().iterator()).iterator();
        boolean bool = false;
        while (iterator.hasNext()) {
          Object object = iterator.next();
          if (!param2Collection.contains(Maps.a(object, this.a.a.d(object)))) {
            StandardTable.a(this.a.a, object);
            bool = true;
          } 
        } 
        return bool;
      }
      
      public int size() {
        return this.a.a.b().size();
      }
    }
    
    class null implements Function<C, Map<R, V>> {
      null(StandardTable.ColumnMap this$0) {}
      
      public Map<R, V> a(C param2C) {
        return this.a.a.a.d(param2C);
      }
    }
    
    class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
      ColumnMapValues(StandardTable.ColumnMap this$0) {
        super(this$0);
      }
      
      public boolean remove(Object param2Object) {
        for (Map.Entry<C, Map<R, V>> entry : this.a.entrySet()) {
          if (((Map)entry.getValue()).equals(param2Object)) {
            StandardTable.a(this.a.a, entry.getKey());
            return true;
          } 
        } 
        return false;
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        Preconditions.a(param2Collection);
        Iterator<Object> iterator = Lists.a(this.a.a.b().iterator()).iterator();
        boolean bool = false;
        while (iterator.hasNext()) {
          Object object = iterator.next();
          if (param2Collection.contains(this.a.a.d(object))) {
            StandardTable.a(this.a.a, object);
            bool = true;
          } 
        } 
        return bool;
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        Preconditions.a(param2Collection);
        Iterator<Object> iterator = Lists.a(this.a.a.b().iterator()).iterator();
        boolean bool = false;
        while (iterator.hasNext()) {
          Object object = iterator.next();
          if (!param2Collection.contains(this.a.a.d(object))) {
            StandardTable.a(this.a.a, object);
            bool = true;
          } 
        } 
        return bool;
      }
    }
  }
  
  class ColumnMapEntrySet extends TableSet<Map.Entry<C, Map<R, V>>> {
    ColumnMapEntrySet(StandardTable this$0) {
      super(((StandardTable.ColumnMap)this$0).a);
    }
    
    public boolean contains(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        if (this.a.a.b(param1Object.getKey())) {
          Object object = param1Object.getKey();
          return this.a.a(object).equals(param1Object.getValue());
        } 
      } 
      return false;
    }
    
    public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
      return Maps.b(this.a.a.b(), new Function<C, Map<R, V>>(this) {
            public Map<R, V> a(C param3C) {
              return this.a.a.a.d(param3C);
            }
          });
    }
    
    public boolean remove(Object param1Object) {
      if (contains(param1Object)) {
        param1Object = param1Object;
        StandardTable.a(this.a.a, param1Object.getKey());
        return true;
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      Preconditions.a(param1Collection);
      return Sets.a(this, param1Collection.iterator());
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Preconditions.a(param1Collection);
      Iterator<Object> iterator = Lists.a(this.a.a.b().iterator()).iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (!param1Collection.contains(Maps.a(object, this.a.a.d(object)))) {
          StandardTable.a(this.a.a, object);
          bool = true;
        } 
      } 
      return bool;
    }
    
    public int size() {
      return this.a.a.b().size();
    }
  }
  
  class null implements Function<C, Map<R, V>> {
    null(StandardTable this$0) {}
    
    public Map<R, V> a(C param1C) {
      return this.a.a.a.d(param1C);
    }
  }
  
  class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
    ColumnMapValues(StandardTable this$0) {
      super((Map<C, Map<R, V>>)this$0);
    }
    
    public boolean remove(Object param1Object) {
      for (Map.Entry<C, Map<R, V>> entry : this.a.entrySet()) {
        if (((Map)entry.getValue()).equals(param1Object)) {
          StandardTable.a(this.a.a, entry.getKey());
          return true;
        } 
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      Preconditions.a(param1Collection);
      Iterator<Object> iterator = Lists.a(this.a.a.b().iterator()).iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (param1Collection.contains(this.a.a.d(object))) {
          StandardTable.a(this.a.a, object);
          bool = true;
        } 
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Preconditions.a(param1Collection);
      Iterator<Object> iterator = Lists.a(this.a.a.b().iterator()).iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (!param1Collection.contains(this.a.a.d(object))) {
          StandardTable.a(this.a.a, object);
          bool = true;
        } 
      } 
      return bool;
    }
  }
  
  class Row extends Maps.IteratorBasedAbstractMap<C, V> {
    final R a;
    
    @NullableDecl
    Map<C, V> b;
    
    Row(StandardTable this$0, R param1R) {
      this.a = (R)Preconditions.a(param1R);
    }
    
    Map.Entry<C, V> a(Map.Entry<C, V> param1Entry) {
      return new ForwardingMapEntry<C, V>(this, param1Entry) {
          protected Map.Entry<C, V> a() {
            return this.a;
          }
          
          public boolean equals(Object param2Object) {
            return a(param2Object);
          }
          
          public V setValue(V param2V) {
            return super.setValue((V)Preconditions.a(param2V));
          }
        };
    }
    
    Map<C, V> a() {
      Map<C, V> map = this.b;
      if (map == null || (map.isEmpty() && this.c.a.containsKey(this.a))) {
        map = c();
        this.b = map;
        return map;
      } 
      return this.b;
    }
    
    Iterator<Map.Entry<C, V>> b() {
      Map<C, V> map = a();
      return (map == null) ? Iterators.c() : new Iterator<Map.Entry<C, V>>(this, map.entrySet().iterator()) {
          public Map.Entry<C, V> a() {
            return this.b.a(this.a.next());
          }
          
          public boolean hasNext() {
            return this.a.hasNext();
          }
          
          public void remove() {
            this.a.remove();
            this.b.d();
          }
        };
    }
    
    Map<C, V> c() {
      return (Map<C, V>)this.c.a.get(this.a);
    }
    
    public void clear() {
      Map<C, V> map = a();
      if (map != null)
        map.clear(); 
      d();
    }
    
    public boolean containsKey(Object param1Object) {
      Map<C, V> map = a();
      return (param1Object != null && map != null && Maps.b(map, param1Object));
    }
    
    void d() {
      if (a() != null && this.b.isEmpty()) {
        this.c.a.remove(this.a);
        this.b = null;
      } 
    }
    
    public V get(Object param1Object) {
      Map<C, V> map = a();
      return (param1Object != null && map != null) ? Maps.a(map, param1Object) : null;
    }
    
    public V put(C param1C, V param1V) {
      Preconditions.a(param1C);
      Preconditions.a(param1V);
      Map<C, V> map = this.b;
      return (map != null && !map.isEmpty()) ? this.b.put(param1C, param1V) : this.c.a(this.a, param1C, param1V);
    }
    
    public V remove(Object param1Object) {
      Map<C, V> map = a();
      if (map == null)
        return null; 
      param1Object = Maps.c(map, param1Object);
      d();
      return (V)param1Object;
    }
    
    public int size() {
      Map<C, V> map = a();
      return (map == null) ? 0 : map.size();
    }
  }
  
  class null implements Iterator<Map.Entry<C, V>> {
    null(StandardTable this$0, Iterator param1Iterator) {}
    
    public Map.Entry<C, V> a() {
      return this.b.a(this.a.next());
    }
    
    public boolean hasNext() {
      return this.a.hasNext();
    }
    
    public void remove() {
      this.a.remove();
      this.b.d();
    }
  }
  
  class null extends ForwardingMapEntry<C, V> {
    null(StandardTable this$0, Map.Entry param1Entry) {}
    
    protected Map.Entry<C, V> a() {
      return this.a;
    }
    
    public boolean equals(Object param1Object) {
      return a(param1Object);
    }
    
    public V setValue(V param1V) {
      return super.setValue((V)Preconditions.a(param1V));
    }
  }
  
  class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {
    RowMap(StandardTable this$0) {}
    
    public Map<C, V> a(Object param1Object) {
      return this.b.a(param1Object) ? this.b.e(param1Object) : null;
    }
    
    protected Set<Map.Entry<R, Map<C, V>>> a() {
      return new EntrySet(this);
    }
    
    public Map<C, V> b(Object param1Object) {
      return (param1Object == null) ? null : (Map<C, V>)this.b.a.remove(param1Object);
    }
    
    public boolean containsKey(Object param1Object) {
      return this.b.a(param1Object);
    }
    
    class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {
      EntrySet(StandardTable.RowMap this$0) {
        super(this$0.b);
      }
      
      public boolean contains(Object param2Object) {
        boolean bool = param2Object instanceof Map.Entry;
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (bool) {
          param2Object = param2Object;
          bool1 = bool2;
          if (param2Object.getKey() != null) {
            bool1 = bool2;
            if (param2Object.getValue() instanceof Map) {
              bool1 = bool2;
              if (Collections2.a(this.a.b.a.entrySet(), param2Object))
                bool1 = true; 
            } 
          } 
        } 
        return bool1;
      }
      
      public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
        return Maps.b(this.a.b.a.keySet(), new Function<R, Map<C, V>>(this) {
              public Map<C, V> a(R param3R) {
                return this.a.a.b.e(param3R);
              }
            });
      }
      
      public boolean remove(Object param2Object) {
        boolean bool = param2Object instanceof Map.Entry;
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (bool) {
          param2Object = param2Object;
          bool1 = bool2;
          if (param2Object.getKey() != null) {
            bool1 = bool2;
            if (param2Object.getValue() instanceof Map) {
              bool1 = bool2;
              if (this.a.b.a.entrySet().remove(param2Object))
                bool1 = true; 
            } 
          } 
        } 
        return bool1;
      }
      
      public int size() {
        return this.a.b.a.size();
      }
    }
    
    class null implements Function<R, Map<C, V>> {
      null(StandardTable.RowMap this$0) {}
      
      public Map<C, V> a(R param2R) {
        return this.a.a.b.e(param2R);
      }
    }
  }
  
  class EntrySet extends TableSet<Map.Entry<R, Map<C, V>>> {
    EntrySet(StandardTable this$0) {
      super(((StandardTable.RowMap)this$0).b);
    }
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (param1Object.getKey() != null) {
          bool1 = bool2;
          if (param1Object.getValue() instanceof Map) {
            bool1 = bool2;
            if (Collections2.a(this.a.b.a.entrySet(), param1Object))
              bool1 = true; 
          } 
        } 
      } 
      return bool1;
    }
    
    public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
      return Maps.b(this.a.b.a.keySet(), new Function<R, Map<C, V>>(this) {
            public Map<C, V> a(R param3R) {
              return this.a.a.b.e(param3R);
            }
          });
    }
    
    public boolean remove(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (param1Object.getKey() != null) {
          bool1 = bool2;
          if (param1Object.getValue() instanceof Map) {
            bool1 = bool2;
            if (this.a.b.a.entrySet().remove(param1Object))
              bool1 = true; 
          } 
        } 
      } 
      return bool1;
    }
    
    public int size() {
      return this.a.b.a.size();
    }
  }
  
  class null implements Function<R, Map<C, V>> {
    null(StandardTable this$0) {}
    
    public Map<C, V> a(R param1R) {
      return this.a.a.b.e(param1R);
    }
  }
  
  abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
    private TableSet(StandardTable this$0) {}
    
    public void clear() {
      this.b.a.clear();
    }
    
    public boolean isEmpty() {
      return this.b.a.isEmpty();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\StandardTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */