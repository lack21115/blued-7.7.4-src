package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
  public boolean a() {
    return e().isEmpty();
  }
  
  public boolean a(C paramC) {
    return (b(paramC) != null);
  }
  
  public abstract Range<C> b(C paramC);
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof RangeSet) {
      paramObject = paramObject;
      return e().equals(paramObject.e());
    } 
    return false;
  }
  
  public final int hashCode() {
    return e().hashCode();
  }
  
  public final String toString() {
    return e().toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\AbstractRangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */