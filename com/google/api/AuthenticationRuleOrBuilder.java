package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface AuthenticationRuleOrBuilder extends MessageOrBuilder {
  boolean getAllowWithoutCredential();
  
  OAuthRequirements getOauth();
  
  OAuthRequirementsOrBuilder getOauthOrBuilder();
  
  AuthRequirement getRequirements(int paramInt);
  
  int getRequirementsCount();
  
  List<AuthRequirement> getRequirementsList();
  
  AuthRequirementOrBuilder getRequirementsOrBuilder(int paramInt);
  
  List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList();
  
  String getSelector();
  
  ByteString getSelectorBytes();
  
  boolean hasOauth();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AuthenticationRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */