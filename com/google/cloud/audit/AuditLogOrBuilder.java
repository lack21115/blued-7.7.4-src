package com.google.cloud.audit;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.rpc.Status;
import com.google.rpc.StatusOrBuilder;
import java.util.List;

public interface AuditLogOrBuilder extends MessageOrBuilder {
  AuthenticationInfo getAuthenticationInfo();
  
  AuthenticationInfoOrBuilder getAuthenticationInfoOrBuilder();
  
  AuthorizationInfo getAuthorizationInfo(int paramInt);
  
  int getAuthorizationInfoCount();
  
  List<AuthorizationInfo> getAuthorizationInfoList();
  
  AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int paramInt);
  
  List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList();
  
  String getMethodName();
  
  ByteString getMethodNameBytes();
  
  long getNumResponseItems();
  
  Struct getRequest();
  
  RequestMetadata getRequestMetadata();
  
  RequestMetadataOrBuilder getRequestMetadataOrBuilder();
  
  StructOrBuilder getRequestOrBuilder();
  
  String getResourceName();
  
  ByteString getResourceNameBytes();
  
  Struct getResponse();
  
  StructOrBuilder getResponseOrBuilder();
  
  Any getServiceData();
  
  AnyOrBuilder getServiceDataOrBuilder();
  
  String getServiceName();
  
  ByteString getServiceNameBytes();
  
  Status getStatus();
  
  StatusOrBuilder getStatusOrBuilder();
  
  boolean hasAuthenticationInfo();
  
  boolean hasRequest();
  
  boolean hasRequestMetadata();
  
  boolean hasResponse();
  
  boolean hasServiceData();
  
  boolean hasStatus();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\cloud\audit\AuditLogOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */