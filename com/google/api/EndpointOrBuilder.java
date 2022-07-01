package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface EndpointOrBuilder extends MessageOrBuilder {
  @Deprecated
  String getAliases(int paramInt);
  
  @Deprecated
  ByteString getAliasesBytes(int paramInt);
  
  @Deprecated
  int getAliasesCount();
  
  @Deprecated
  List<String> getAliasesList();
  
  boolean getAllowCors();
  
  String getFeatures(int paramInt);
  
  ByteString getFeaturesBytes(int paramInt);
  
  int getFeaturesCount();
  
  List<String> getFeaturesList();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getTarget();
  
  ByteString getTargetBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\EndpointOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */