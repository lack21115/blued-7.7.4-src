package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V> {
  public List<V> a(K paramK) {
    return (List<V>)super.c(paramK);
  }
  
  public List<V> b(@NullableDecl Object paramObject) {
    return (List<V>)super.d(paramObject);
  }
  
  public ListMultimap<K, V> d() {
    return (ListMultimap<K, V>)super.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\FilteredKeyListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */