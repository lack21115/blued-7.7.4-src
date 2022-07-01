package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface RequestInfoOrBuilder extends MessageOrBuilder {
  String getRequestId();
  
  ByteString getRequestIdBytes();
  
  String getServingData();
  
  ByteString getServingDataBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\RequestInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */