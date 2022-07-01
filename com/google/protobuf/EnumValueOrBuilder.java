package com.google.protobuf;

import java.util.List;

public interface EnumValueOrBuilder extends MessageOrBuilder {
  String getName();
  
  ByteString getNameBytes();
  
  int getNumber();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  OptionOrBuilder getOptionsOrBuilder(int paramInt);
  
  List<? extends OptionOrBuilder> getOptionsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\EnumValueOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */