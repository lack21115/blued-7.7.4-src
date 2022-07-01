package com.google.protobuf;

public interface ValueOrBuilder extends MessageOrBuilder {
  boolean getBoolValue();
  
  Value.KindCase getKindCase();
  
  ListValue getListValue();
  
  ListValueOrBuilder getListValueOrBuilder();
  
  NullValue getNullValue();
  
  int getNullValueValue();
  
  double getNumberValue();
  
  String getStringValue();
  
  ByteString getStringValueBytes();
  
  Struct getStructValue();
  
  StructOrBuilder getStructValueOrBuilder();
  
  boolean hasListValue();
  
  boolean hasStructValue();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ValueOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */