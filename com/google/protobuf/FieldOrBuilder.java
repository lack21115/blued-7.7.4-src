package com.google.protobuf;

import java.util.List;

public interface FieldOrBuilder extends MessageOrBuilder {
  Field.Cardinality getCardinality();
  
  int getCardinalityValue();
  
  String getDefaultValue();
  
  ByteString getDefaultValueBytes();
  
  String getJsonName();
  
  ByteString getJsonNameBytes();
  
  Field.Kind getKind();
  
  int getKindValue();
  
  String getName();
  
  ByteString getNameBytes();
  
  int getNumber();
  
  int getOneofIndex();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  OptionOrBuilder getOptionsOrBuilder(int paramInt);
  
  List<? extends OptionOrBuilder> getOptionsOrBuilderList();
  
  boolean getPacked();
  
  String getTypeUrl();
  
  ByteString getTypeUrlBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\FieldOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */