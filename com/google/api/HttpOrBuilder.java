package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface HttpOrBuilder extends MessageOrBuilder {
  boolean getFullyDecodeReservedExpansion();
  
  HttpRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<HttpRule> getRulesList();
  
  HttpRuleOrBuilder getRulesOrBuilder(int paramInt);
  
  List<? extends HttpRuleOrBuilder> getRulesOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\HttpOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */