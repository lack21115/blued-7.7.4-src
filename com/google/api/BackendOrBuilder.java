package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface BackendOrBuilder extends MessageOrBuilder {
  BackendRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<BackendRule> getRulesList();
  
  BackendRuleOrBuilder getRulesOrBuilder(int paramInt);
  
  List<? extends BackendRuleOrBuilder> getRulesOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\BackendOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */