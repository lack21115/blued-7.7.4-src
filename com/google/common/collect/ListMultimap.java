package com.google.common.collect;

import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface ListMultimap<K, V> extends Multimap<K, V> {
  List<V> a(@NullableDecl K paramK);
  
  List<V> b(@NullableDecl Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */