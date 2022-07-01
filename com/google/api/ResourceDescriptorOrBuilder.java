package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ResourceDescriptorOrBuilder extends MessageOrBuilder {
  ResourceDescriptor.History getHistory();
  
  int getHistoryValue();
  
  String getNameField();
  
  ByteString getNameFieldBytes();
  
  String getPattern(int paramInt);
  
  ByteString getPatternBytes(int paramInt);
  
  int getPatternCount();
  
  List<String> getPatternList();
  
  String getPlural();
  
  ByteString getPluralBytes();
  
  String getSingular();
  
  ByteString getSingularBytes();
  
  String getType();
  
  ByteString getTypeBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ResourceDescriptorOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */