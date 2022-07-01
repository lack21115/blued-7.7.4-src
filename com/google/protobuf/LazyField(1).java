package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

public class LazyField extends LazyFieldLite {
  private final MessageLite defaultInstance;
  
  public LazyField(MessageLite paramMessageLite, ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString) {
    super(paramExtensionRegistryLite, paramByteString);
    this.defaultInstance = paramMessageLite;
  }
  
  public boolean containsDefaultInstance() {
    return (super.containsDefaultInstance() || this.value == this.defaultInstance);
  }
  
  public boolean equals(Object paramObject) {
    return getValue().equals(paramObject);
  }
  
  public MessageLite getValue() {
    return getValue(this.defaultInstance);
  }
  
  public int hashCode() {
    return getValue().hashCode();
  }
  
  public String toString() {
    return getValue().toString();
  }
  
  static class LazyEntry<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, LazyField> entry;
    
    private LazyEntry(Map.Entry<K, LazyField> param1Entry) {
      this.entry = param1Entry;
    }
    
    public LazyField getField() {
      return this.entry.getValue();
    }
    
    public K getKey() {
      return this.entry.getKey();
    }
    
    public Object getValue() {
      LazyField lazyField = this.entry.getValue();
      return (lazyField == null) ? null : lazyField.getValue();
    }
    
    public Object setValue(Object param1Object) {
      if (param1Object instanceof MessageLite)
        return ((LazyField)this.entry.getValue()).setValue((MessageLite)param1Object); 
      throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
  }
  
  static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> iterator;
    
    public LazyIterator(Iterator<Map.Entry<K, Object>> param1Iterator) {
      this.iterator = param1Iterator;
    }
    
    public boolean hasNext() {
      return this.iterator.hasNext();
    }
    
    public Map.Entry<K, Object> next() {
      Map.Entry<K, Object> entry = this.iterator.next();
      return (entry.getValue() instanceof LazyField) ? new LazyField.LazyEntry<K>(entry) : entry;
    }
    
    public void remove() {
      this.iterator.remove();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\LazyField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */