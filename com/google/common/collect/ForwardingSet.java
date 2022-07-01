package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
  protected abstract Set<E> a();
  
  protected boolean c(Collection<?> paramCollection) {
    return Sets.a(this, (Collection)Preconditions.a(paramCollection));
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject == this || a().equals(paramObject));
  }
  
  public int hashCode() {
    return a().hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ForwardingSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */