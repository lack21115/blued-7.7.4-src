package com.google.protobuf;

import java.util.List;

public interface TypeOrBuilder extends MessageOrBuilder {
  Field getFields(int paramInt);
  
  int getFieldsCount();
  
  List<Field> getFieldsList();
  
  FieldOrBuilder getFieldsOrBuilder(int paramInt);
  
  List<? extends FieldOrBuilder> getFieldsOrBuilderList();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getOneofs(int paramInt);
  
  ByteString getOneofsBytes(int paramInt);
  
  int getOneofsCount();
  
  List<String> getOneofsList();
  
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\TypeOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */