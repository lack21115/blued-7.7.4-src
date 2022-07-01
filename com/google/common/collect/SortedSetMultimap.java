package com.google.common.collect;

import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
  SortedSet<V> h(@NullableDecl K paramK);
  
  SortedSet<V> i(@NullableDecl Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */