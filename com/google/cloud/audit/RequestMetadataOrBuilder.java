package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface RequestMetadataOrBuilder extends MessageOrBuilder {
  String getCallerIp();
  
  ByteString getCallerIpBytes();
  
  String getCallerSuppliedUserAgent();
  
  ByteString getCallerSuppliedUserAgentBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\RequestMetadataOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */