package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface SystemParameterRuleOrBuilder extends MessageOrBuilder {
  SystemParameter getParameters(int paramInt);
  
  int getParametersCount();
  
  List<SystemParameter> getParametersList();
  
  SystemParameterOrBuilder getParametersOrBuilder(int paramInt);
  
  List<? extends SystemParameterOrBuilder> getParametersOrBuilderList();
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SystemParameterRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */