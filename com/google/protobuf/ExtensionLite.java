package com.google.protobuf;

public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
  public abstract Type getDefaultValue();
  
  public abstract WireFormat.FieldType getLiteType();
  
  public abstract MessageLite getMessageDefaultInstance();
  
  public abstract int getNumber();
  
  boolean isLite() {
    return true;
  }
  
  public abstract boolean isRepeated();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ExtensionLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */