package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class AllEqualOrdering extends Ordering<Object> implements Serializable {
  static final AllEqualOrdering a = new AllEqualOrdering();
  
  public <E> ImmutableList<E> a(Iterable<E> paramIterable) {
    return ImmutableList.a(paramIterable);
  }
  
  public <S> Ordering<S> a() {
    return this;
  }
  
  public int compare(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return 0;
  }
  
  public String toString() {
    return "Ordering.allEqual()";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AllEqualOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */