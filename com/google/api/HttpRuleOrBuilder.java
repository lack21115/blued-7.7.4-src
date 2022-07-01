package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface HttpRuleOrBuilder extends MessageOrBuilder {
  HttpRule getAdditionalBindings(int paramInt);
  
  int getAdditionalBindingsCount();
  
  List<HttpRule> getAdditionalBindingsList();
  
  HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int paramInt);
  
  List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList();
  
  String getBody();
  
  ByteString getBodyBytes();
  
  CustomHttpPattern getCustom();
  
  CustomHttpPatternOrBuilder getCustomOrBuilder();
  
  String getDelete();
  
  ByteString getDeleteBytes();
  
  String getGet();
  
  ByteString getGetBytes();
  
  String getPatch();
  
  ByteString getPatchBytes();
  
  HttpRule.PatternCase getPatternCase();
  
  String getPost();
  
  ByteString getPostBytes();
  
  String getPut();
  
  ByteString getPutBytes();
  
  String getResponseBody();
  
  ByteString getResponseBodyBytes();
  
  String getSelector();
  
  ByteString getSelectorBytes();
  
  boolean hasCustom();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\HttpRuleOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */