package com.google.protobuf;

import java.util.Map;

final class SmallSortedMap$Entry implements Comparable, Map.Entry {
  final Comparable key;
  
  private Object value;
  
  SmallSortedMap$Entry(Comparable paramComparable, Object paramObject) {
    this.key = paramComparable;
    this.value = paramObject;
  }
  
  SmallSortedMap$Entry(Map.Entry paramEntry) {
    this((Comparable)paramEntry.getKey(), paramEntry.getValue());
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Map.Entry))
      return false; 
    paramObject = paramObject;
    return (equals(this.key, paramObject.getKey()) && equals(this.value, paramObject.getValue()));
  }
  
  public final Object getValue() {
    return this.value;
  }
  
  public final int hashCode() {
    int i;
    Comparable comparable = this.key;
    int j = 0;
    if (comparable == null) {
      i = 0;
    } else {
      i = this.key.hashCode();
    } 
    if (this.value != null)
      j = this.value.hashCode(); 
    return i ^ j;
  }
  
  public final Object setValue(Object paramObject) {
    SmallSortedMap.access$200(SmallSortedMap.this);
    Object object = this.value;
    this.value = paramObject;
    return object;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.key);
    stringBuilder.append("=");
    stringBuilder.append(this.value);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\SmallSortedMap$Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */