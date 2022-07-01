package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface LabelDescriptorOrBuilder extends MessageOrBuilder {
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getKey();
  
  ByteString getKeyBytes();
  
  LabelDescriptor.ValueType getValueType();
  
  int getValueTypeValue();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\LabelDescriptorOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */