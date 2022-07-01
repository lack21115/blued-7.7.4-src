package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

final class LazyField$LazyIterator implements Iterator {
  private Iterator iterator;
  
  public LazyField$LazyIterator(Iterator paramIterator) {
    this.iterator = paramIterator;
  }
  
  public final boolean hasNext() {
    return this.iterator.hasNext();
  }
  
  public final void remove() {
    this.iterator.remove();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\LazyField$LazyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */