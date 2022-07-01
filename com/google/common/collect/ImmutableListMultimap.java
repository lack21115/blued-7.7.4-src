package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
  ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> paramImmutableMap, int paramInt) {
    super((ImmutableMap)paramImmutableMap, paramInt);
  }
  
  public static <K, V> ImmutableListMultimap<K, V> a() {
    return EmptyImmutableListMultimap.a;
  }
  
  static <K, V> ImmutableListMultimap<K, V> a(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> paramCollection, @NullableDecl Comparator<? super V> paramComparator) {
    if (paramCollection.isEmpty())
      return a(); 
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder<Object, Object>(paramCollection.size());
    int i = 0;
    for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : paramCollection) {
      Object object = entry.getKey();
      Collection<?> collection = (Collection)entry.getValue();
      if (paramComparator == null) {
        collection = ImmutableList.a(collection);
      } else {
        collection = ImmutableList.a(paramComparator, collection);
      } 
      if (!collection.isEmpty()) {
        builder.b(object, collection);
        i += collection.size();
      } 
    } 
    return new ImmutableListMultimap<K, V>((ImmutableMap)builder.b(), i);
  }
  
  public static <K, V> Builder<K, V> b() {
    return new Builder<K, V>();
  }
  
  public static <K, V> ImmutableListMultimap<K, V> d(K paramK, V paramV) {
    Builder<?, ?> builder = b();
    builder.a(paramK, paramV);
    return (ImmutableListMultimap)builder.a();
  }
  
  public ImmutableList<V> e(@NullableDecl K paramK) {
    ImmutableList<?> immutableList2 = (ImmutableList)this.b.get(paramK);
    ImmutableList<?> immutableList1 = immutableList2;
    if (immutableList2 == null)
      immutableList1 = ImmutableList.d(); 
    return (ImmutableList)immutableList1;
  }
  
  @Deprecated
  public ImmutableList<V> h(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
    public Builder<K, V> a(K param1K, V param1V) {
      super.b(param1K, param1V);
      return this;
    }
    
    public ImmutableListMultimap<K, V> a() {
      return (ImmutableListMultimap<K, V>)super.b();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */