package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ContextOrBuilder extends MessageOrBuilder {
  ContextRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<ContextRule> getRulesList();
  
  ContextRuleOrBuilder getRulesOrBuilder(int paramInt);
  
  List<? extends ContextRuleOrBuilder> getRulesOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ContextOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */