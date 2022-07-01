package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AuthRequirementOrBuilder extends MessageOrBuilder {
  String getAudiences();
  
  ByteString getAudiencesBytes();
  
  String getProviderId();
  
  ByteString getProviderIdBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AuthRequirementOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */