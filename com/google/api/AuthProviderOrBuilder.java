package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AuthProviderOrBuilder extends MessageOrBuilder {
  String getAudiences();
  
  ByteString getAudiencesBytes();
  
  String getAuthorizationUrl();
  
  ByteString getAuthorizationUrlBytes();
  
  String getId();
  
  ByteString getIdBytes();
  
  String getIssuer();
  
  ByteString getIssuerBytes();
  
  String getJwksUri();
  
  ByteString getJwksUriBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AuthProviderOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */