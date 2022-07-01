package com.google.protobuf;

import java.util.List;

public interface EnumOrBuilder extends MessageOrBuilder {
  EnumValue getEnumvalue(int paramInt);
  
  int getEnumvalueCount();
  
  List<EnumValue> getEnumvalueList();
  
  EnumValueOrBuilder getEnumvalueOrBuilder(int paramInt);
  
  List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList();
  
  String getName();
  
  ByteString getNameBytes();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  OptionOrBuilder getOptionsOrBuilder(int paramInt);
  
  List<? extends OptionOrBuilder> getOptionsOrBuilderList();
  
  SourceContext getSourceContext();
  
  SourceContextOrBuilder getSourceContextOrBuilder();
  
  Syntax getSyntax();
  
  int getSyntaxValue();
  
  boolean hasSourceContext();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\EnumOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */