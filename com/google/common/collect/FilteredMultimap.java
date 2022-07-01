package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Map;

interface FilteredMultimap<K, V> extends Multimap<K, V> {
  Multimap<K, V> a();
  
  Predicate<? super Map.Entry<K, V>> b();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\FilteredMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */