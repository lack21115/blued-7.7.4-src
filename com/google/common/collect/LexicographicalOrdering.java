package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
  final Comparator<? super T> a;
  
  public int a(Iterable<T> paramIterable1, Iterable<T> paramIterable2) {
    Iterator<T> iterator1 = paramIterable1.iterator();
    Iterator<T> iterator2 = paramIterable2.iterator();
    while (iterator1.hasNext()) {
      if (!iterator2.hasNext())
        return 1; 
      int i = this.a.compare(iterator1.next(), iterator2.next());
      if (i != 0)
        return i; 
    } 
    return iterator2.hasNext() ? -1 : 0;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof LexicographicalOrdering) {
      paramObject = paramObject;
      return this.a.equals(((LexicographicalOrdering)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a.hashCode() ^ 0x7BB78CF5;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(".lexicographical()");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\LexicographicalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */