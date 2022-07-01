package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface SetMultimap<K, V> extends Multimap<K, V> {
  Set<V> a(@NullableDecl K paramK);
  
  Set<V> b(@NullableDecl Object paramObject);
  
  Set<Map.Entry<K, V>> t();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */