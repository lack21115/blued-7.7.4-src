package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.rpc.Status;
import com.google.rpc.StatusOrBuilder;

public interface OperationOrBuilder extends MessageOrBuilder {
  boolean getDone();
  
  Status getError();
  
  StatusOrBuilder getErrorOrBuilder();
  
  Any getMetadata();
  
  AnyOrBuilder getMetadataOrBuilder();
  
  String getName();
  
  ByteString getNameBytes();
  
  Any getResponse();
  
  AnyOrBuilder getResponseOrBuilder();
  
  Operation.ResultCase getResultCase();
  
  boolean hasError();
  
  boolean hasMetadata();
  
  boolean hasResponse();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\OperationOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */