package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface PropertyOrBuilder extends MessageOrBuilder {
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getName();
  
  ByteString getNameBytes();
  
  Property.PropertyType getType();
  
  int getTypeValue();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\PropertyOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */