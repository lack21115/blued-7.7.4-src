package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AuthorizationInfoOrBuilder extends MessageOrBuilder {
  boolean getGranted();
  
  String getPermission();
  
  ByteString getPermissionBytes();
  
  String getResource();
  
  ByteString getResourceBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\AuthorizationInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */