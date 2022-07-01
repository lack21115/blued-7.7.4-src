package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface UsageRuleOrBuilder extends MessageOrBuilder {
  boolean getAllowUnregisteredCalls();
  
  String getSelector();
  
  ByteString getSelectorBytes();
  
  boolean getSkipServiceControl();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\UsageRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */