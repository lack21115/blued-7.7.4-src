package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
  final Comparator<T> a;
  
  ComparatorOrdering(Comparator<T> paramComparator) {
    this.a = (Comparator<T>)Preconditions.a(paramComparator);
  }
  
  public int compare(T paramT1, T paramT2) {
    return this.a.compare(paramT1, paramT2);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ComparatorOrdering) {
      paramObject = paramObject;
      return this.a.equals(((ComparatorOrdering)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ComparatorOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */