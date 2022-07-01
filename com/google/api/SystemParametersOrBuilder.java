package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface SystemParametersOrBuilder extends MessageOrBuilder {
  SystemParameterRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<SystemParameterRule> getRulesList();
  
  SystemParameterRuleOrBuilder getRulesOrBuilder(int paramInt);
  
  List<? extends SystemParameterRuleOrBuilder> getRulesOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SystemParametersOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */