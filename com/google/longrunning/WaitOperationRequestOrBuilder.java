package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface WaitOperationRequestOrBuilder extends MessageOrBuilder {
  String getName();
  
  ByteString getNameBytes();
  
  Duration getTimeout();
  
  DurationOrBuilder getTimeoutOrBuilder();
  
  boolean hasTimeout();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\WaitOperationRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */