package com.google.common.collect;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
  HashMultiset(int paramInt) {
    super(paramInt);
  }
  
  public static <E> HashMultiset<E> a(Iterable<? extends E> paramIterable) {
    HashMultiset<?> hashMultiset = b(Multisets.a(paramIterable));
    Iterables.a(hashMultiset, paramIterable);
    return (HashMultiset)hashMultiset;
  }
  
  public static <E> HashMultiset<E> b(int paramInt) {
    return new HashMultiset<E>(paramInt);
  }
  
  void a(int paramInt) {
    this.a = new ObjectCountHashMap<E>(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\HashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */