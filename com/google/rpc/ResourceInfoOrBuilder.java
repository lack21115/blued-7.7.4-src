package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface ResourceInfoOrBuilder extends MessageOrBuilder {
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getOwner();
  
  ByteString getOwnerBytes();
  
  String getResourceName();
  
  ByteString getResourceNameBytes();
  
  String getResourceType();
  
  ByteString getResourceTypeBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\ResourceInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */