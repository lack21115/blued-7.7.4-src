package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
  private final transient ImmutableSet<V> a;
  
  @LazyInit
  @NullableDecl
  private transient ImmutableSet<Map.Entry<K, V>> d;
  
  ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> paramImmutableMap, int paramInt, @NullableDecl Comparator<? super V> paramComparator) {
    super((ImmutableMap)paramImmutableMap, paramInt);
    this.a = a(paramComparator);
  }
  
  private static <V> ImmutableSet<V> a(@NullableDecl Comparator<? super V> paramComparator) {
    return (paramComparator == null) ? ImmutableSet.j() : ImmutableSortedSet.a(paramComparator);
  }
  
  private static <V> ImmutableSet<V> a(@NullableDecl Comparator<? super V> paramComparator, Collection<? extends V> paramCollection) {
    return (paramComparator == null) ? ImmutableSet.a(paramCollection) : ImmutableSortedSet.a(paramComparator, paramCollection);
  }
  
  public static <K, V> ImmutableSetMultimap<K, V> a() {
    return EmptyImmutableSetMultimap.a;
  }
  
  static <K, V> ImmutableSetMultimap<K, V> a(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> paramCollection, @NullableDecl Comparator<? super V> paramComparator) {
    if (paramCollection.isEmpty())
      return a(); 
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder<Object, Object>(paramCollection.size());
    int i = 0;
    for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : paramCollection) {
      Object object = entry.getKey();
      ImmutableSet<V> immutableSet = a(paramComparator, (Collection<? extends V>)entry.getValue());
      if (!immutableSet.isEmpty()) {
        builder.b(object, immutableSet);
        i += immutableSet.size();
      } 
    } 
    return new ImmutableSetMultimap<K, V>((ImmutableMap)builder.b(), i, paramComparator);
  }
  
  public ImmutableSet<Map.Entry<K, V>> b() {
    ImmutableSet<Map.Entry<K, V>> immutableSet2 = this.d;
    ImmutableSet<Map.Entry<K, V>> immutableSet1 = immutableSet2;
    if (immutableSet2 == null) {
      immutableSet1 = new EntrySet<K, V>(this);
      this.d = immutableSet1;
    } 
    return immutableSet1;
  }
  
  public ImmutableSet<V> e(@NullableDecl K paramK) {
    return (ImmutableSet<V>)MoreObjects.a(this.b.get(paramK), this.a);
  }
  
  @Deprecated
  public ImmutableSet<V> h(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
    public Builder<K, V> a(K param1K, V param1V) {
      super.b(param1K, param1V);
      return this;
    }
    
    public ImmutableSetMultimap<K, V> a() {
      ImmutableList<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> immutableList;
      Set<Map.Entry<K, Collection<V>>> set2 = this.a.entrySet();
      Set<Map.Entry<K, Collection<V>>> set1 = set2;
      if (this.b != null)
        immutableList = Ordering.<K>a(this.b).e().a(set2); 
      return ImmutableSetMultimap.a(immutableList, this.c);
    }
    
    Collection<V> c() {
      return Platform.b();
    }
  }
  
  static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
    private final transient ImmutableSetMultimap<K, V> a;
    
    EntrySet(ImmutableSetMultimap<K, V> param1ImmutableSetMultimap) {
      this.a = param1ImmutableSetMultimap;
    }
    
    boolean a() {
      return false;
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> av_() {
      return this.a.v();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return this.a.b(param1Object.getKey(), param1Object.getValue());
      } 
      return false;
    }
    
    public int size() {
      return this.a.f();
    }
  }
  
  static final class SetFieldSettersHolder {
    static final Serialization.FieldSetter<ImmutableSetMultimap> a = Serialization.a(ImmutableSetMultimap.class, "emptySet");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */