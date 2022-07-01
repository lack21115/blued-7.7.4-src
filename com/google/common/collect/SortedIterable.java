package com.google.common.collect;

import java.util.Comparator;

interface SortedIterable<T> extends Iterable<T> {
  Comparator<? super T> comparator();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\SortedIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */