package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import java.util.Map;

public interface MonitoredResourceMetadataOrBuilder extends MessageOrBuilder {
  boolean containsUserLabels(String paramString);
  
  Struct getSystemLabels();
  
  StructOrBuilder getSystemLabelsOrBuilder();
  
  @Deprecated
  Map<String, String> getUserLabels();
  
  int getUserLabelsCount();
  
  Map<String, String> getUserLabelsMap();
  
  String getUserLabelsOrDefault(String paramString1, String paramString2);
  
  String getUserLabelsOrThrow(String paramString);
  
  boolean hasSystemLabels();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoredResourceMetadataOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */