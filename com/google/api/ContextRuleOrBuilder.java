package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ContextRuleOrBuilder extends MessageOrBuilder {
  String getAllowedRequestExtensions(int paramInt);
  
  ByteString getAllowedRequestExtensionsBytes(int paramInt);
  
  int getAllowedRequestExtensionsCount();
  
  List<String> getAllowedRequestExtensionsList();
  
  String getAllowedResponseExtensions(int paramInt);
  
  ByteString getAllowedResponseExtensionsBytes(int paramInt);
  
  int getAllowedResponseExtensionsCount();
  
  List<String> getAllowedResponseExtensionsList();
  
  String getProvided(int paramInt);
  
  ByteString getProvidedBytes(int paramInt);
  
  int getProvidedCount();
  
  List<String> getProvidedList();
  
  String getRequested(int paramInt);
  
  ByteString getRequestedBytes(int paramInt);
  
  int getRequestedCount();
  
  List<String> getRequestedList();
  
  String getSelector();
  
  ByteString getSelectorBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ContextRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */