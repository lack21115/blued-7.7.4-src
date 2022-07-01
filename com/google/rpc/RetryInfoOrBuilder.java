package com.google.rpc;

import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface RetryInfoOrBuilder extends MessageOrBuilder {
  Duration getRetryDelay();
  
  DurationOrBuilder getRetryDelayOrBuilder();
  
  boolean hasRetryDelay();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\RetryInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */