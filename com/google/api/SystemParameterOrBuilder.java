package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface SystemParameterOrBuilder extends MessageOrBuilder {
  String getHttpHeader();
  
  ByteString getHttpHeaderBytes();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getUrlQueryParameter();
  
  ByteString getUrlQueryParameterBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SystemParameterOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */