package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AuthenticationInfoOrBuilder extends MessageOrBuilder {
  String getPrincipalEmail();
  
  ByteString getPrincipalEmailBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\AuthenticationInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */