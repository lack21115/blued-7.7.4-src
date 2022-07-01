package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface AuthenticationOrBuilder extends MessageOrBuilder {
  AuthProvider getProviders(int paramInt);
  
  int getProvidersCount();
  
  List<AuthProvider> getProvidersList();
  
  AuthProviderOrBuilder getProvidersOrBuilder(int paramInt);
  
  List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList();
  
  AuthenticationRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<AuthenticationRule> getRulesList();
  
  AuthenticationRuleOrBuilder getRulesOrBuilder(int paramInt);
  
  List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AuthenticationOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */