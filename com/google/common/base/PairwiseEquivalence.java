package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable {
  final Equivalence<? super T> a;
  
  protected int a(Iterable<T> paramIterable) {
    Iterator<T> iterator = paramIterable.iterator();
    int i;
    for (i = 78721; iterator.hasNext(); i = i * 24943 + this.a.a(t))
      T t = iterator.next(); 
    return i;
  }
  
  protected boolean a(Iterable<T> paramIterable1, Iterable<T> paramIterable2) {
    boolean bool2;
    Iterator<T> iterator1 = paramIterable1.iterator();
    Iterator<T> iterator2 = paramIterable2.iterator();
    while (true) {
      boolean bool = iterator1.hasNext();
      bool2 = false;
      if (bool && iterator2.hasNext()) {
        if (!this.a.a(iterator1.next(), iterator2.next()))
          return false; 
        continue;
      } 
      break;
    } 
    boolean bool1 = bool2;
    if (!iterator1.hasNext()) {
      bool1 = bool2;
      if (!iterator2.hasNext())
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject instanceof PairwiseEquivalence) {
      paramObject = paramObject;
      return this.a.equals(((PairwiseEquivalence)paramObject).a);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a.hashCode() ^ 0x46A3EB07;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(".pairwise()");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\PairwiseEquivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */