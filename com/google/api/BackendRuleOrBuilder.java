package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface BackendRuleOrBuilder extends MessageOrBuilder {
  String getAddress();
  
  ByteString getAddressBytes();
  
  BackendRule.AuthenticationCase getAuthenticationCase();
  
  double getDeadline();
  
  String getJwtAudience();
  
  ByteString getJwtAudienceBytes();
  
  double getMinDeadline();
  
  double getOperationDeadline();
  
  BackendRule.PathTranslation getPathTranslation();
  
  int getPathTranslationValue();
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\BackendRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */