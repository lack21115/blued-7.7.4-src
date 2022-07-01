package com.google.protobuf;

import java.util.Map;

final class LazyField$LazyEntry implements Map.Entry {
  private Map.Entry entry;
  
  private LazyField$LazyEntry(Map.Entry paramEntry) {
    this.entry = paramEntry;
  }
  
  public final Object getKey() {
    return this.entry.getKey();
  }
  
  public final Object getValue() {
    LazyField lazyField = (LazyField)this.entry.getValue();
    return (lazyField == null) ? null : lazyField.getValue();
  }
  
  public final Object setValue(Object paramObject) {
    if (paramObject instanceof MessageLite) {
      LazyField lazyField = (LazyField)this.entry.getValue();
      paramObject = paramObject;
      MessageLite messageLite = lazyField.value;
      lazyField.delayedBytes = null;
      lazyField.memoizedBytes = null;
      lazyField.value = (MessageLite)paramObject;
      return messageLite;
    } 
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\LazyField$LazyEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */