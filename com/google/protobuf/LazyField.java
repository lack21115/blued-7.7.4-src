package com.google.protobuf;

public final class LazyField extends LazyFieldLite {
  private final MessageLite defaultInstance;
  
  public final boolean equals(Object paramObject) {
    return getValue().equals(paramObject);
  }
  
  public final MessageLite getValue() {
    return getValue(this.defaultInstance);
  }
  
  public final int hashCode() {
    return getValue().hashCode();
  }
  
  public final String toString() {
    return getValue().toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\LazyField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */