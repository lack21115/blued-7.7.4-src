package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
  final Multimap<K, V> a;
  
  final Predicate<? super K> b;
  
  public Multimap<K, V> a() {
    return this.a;
  }
  
  public Predicate<? super Map.Entry<K, V>> b() {
    return (Predicate)Maps.a(this.b);
  }
  
  public Collection<V> c(K paramK) {
    return (Collection<V>)(this.b.a(paramK) ? this.a.c(paramK) : ((this.a instanceof SetMultimap) ? new AddRejectingSet<K, V>(paramK) : new AddRejectingList<K, V>(paramK)));
  }
  
  public Collection<V> d(Object paramObject) {
    return f(paramObject) ? this.a.d(paramObject) : e();
  }
  
  Collection<V> e() {
    return (Collection<V>)((this.a instanceof SetMultimap) ? ImmutableSet.j() : ImmutableList.d());
  }
  
  public int f() {
    Iterator<Collection> iterator = c().values().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((Collection)iterator.next()).size());
    return i;
  }
  
  public boolean f(@NullableDecl Object paramObject) {
    return this.a.f(paramObject) ? this.b.a(paramObject) : false;
  }
  
  public void g() {
    s().clear();
  }
  
  Set<K> h() {
    return Sets.a(this.a.s(), this.b);
  }
  
  Collection<V> k() {
    return new FilteredMultimapValues<Object, V>(this);
  }
  
  Collection<Map.Entry<K, V>> n() {
    return new Entries(this);
  }
  
  Iterator<Map.Entry<K, V>> o() {
    throw new AssertionError("should never be called");
  }
  
  Map<K, Collection<V>> p() {
    return Maps.a(this.a.c(), this.b);
  }
  
  static class AddRejectingList<K, V> extends ForwardingList<V> {
    final K a;
    
    AddRejectingList(K param1K) {
      this.a = param1K;
    }
    
    protected List<V> a() {
      return Collections.emptyList();
    }
    
    public void add(int param1Int, V param1V) {
      Preconditions.b(param1Int, 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key does not satisfy predicate: ");
      stringBuilder.append(this.a);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public boolean add(V param1V) {
      add(0, param1V);
      return true;
    }
    
    public boolean addAll(int param1Int, Collection<? extends V> param1Collection) {
      Preconditions.a(param1Collection);
      Preconditions.b(param1Int, 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key does not satisfy predicate: ");
      stringBuilder.append(this.a);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      addAll(0, param1Collection);
      return true;
    }
  }
  
  static class AddRejectingSet<K, V> extends ForwardingSet<V> {
    final K a;
    
    AddRejectingSet(K param1K) {
      this.a = param1K;
    }
    
    protected Set<V> a() {
      return Collections.emptySet();
    }
    
    public boolean add(V param1V) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key does not satisfy predicate: ");
      stringBuilder.append(this.a);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public boolean addAll(Collection<? extends V> param1Collection) {
      Preconditions.a(param1Collection);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key does not satisfy predicate: ");
      stringBuilder.append(this.a);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
  }
  
  class Entries extends ForwardingCollection<Map.Entry<K, V>> {
    Entries(FilteredKeyMultimap this$0) {}
    
    protected Collection<Map.Entry<K, V>> c() {
      return Collections2.a(this.a.a.m(), this.a.b());
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        if (this.a.a.f(param1Object.getKey()) && this.a.b.a(param1Object.getKey()))
          return this.a.a.c(param1Object.getKey(), param1Object.getValue()); 
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\FilteredKeyMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */