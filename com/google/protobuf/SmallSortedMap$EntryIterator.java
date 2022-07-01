package com.google.protobuf;

import java.util.Iterator;

final class SmallSortedMap$EntryIterator implements Iterator {
  private Iterator lazyOverflowIterator;
  
  private boolean nextCalledBeforeRemove;
  
  private int pos = -1;
  
  private SmallSortedMap$EntryIterator() {}
  
  private Iterator getOverflowIterator() {
    if (this.lazyOverflowIterator == null)
      this.lazyOverflowIterator = SmallSortedMap.access$600(SmallSortedMap.this).entrySet().iterator(); 
    return this.lazyOverflowIterator;
  }
  
  public final boolean hasNext() {
    return (this.pos + 1 >= SmallSortedMap.access$400(SmallSortedMap.this).size()) ? (getOverflowIterator().hasNext()) : true;
  }
  
  public final void remove() {
    if (this.nextCalledBeforeRemove) {
      this.nextCalledBeforeRemove = false;
      SmallSortedMap.access$200(SmallSortedMap.this);
      if (this.pos < SmallSortedMap.access$400(SmallSortedMap.this).size()) {
        SmallSortedMap smallSortedMap = SmallSortedMap.this;
        int i = this.pos;
        this.pos = i - 1;
        SmallSortedMap.access$500(smallSortedMap, i);
        return;
      } 
      getOverflowIterator().remove();
      return;
    } 
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\SmallSortedMap$EntryIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */