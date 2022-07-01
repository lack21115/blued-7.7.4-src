package com.google.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class SmallSortedMap$EntrySet extends AbstractSet {
  private SmallSortedMap$EntrySet() {}
  
  public final void clear() {
    SmallSortedMap.this.clear();
  }
  
  public final boolean contains(Object paramObject) {
    Map.Entry entry = (Map.Entry)paramObject;
    paramObject = SmallSortedMap.this.get(entry.getKey());
    entry = (Map.Entry)entry.getValue();
    return (paramObject == entry || (paramObject != null && paramObject.equals(entry)));
  }
  
  public final Iterator iterator() {
    return new SmallSortedMap$EntryIterator(SmallSortedMap.this, (byte)0);
  }
  
  public final boolean remove(Object paramObject) {
    paramObject = paramObject;
    if (contains(paramObject)) {
      SmallSortedMap.this.remove(paramObject.getKey());
      return true;
    } 
    return false;
  }
  
  public final int size() {
    return SmallSortedMap.this.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\SmallSortedMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */