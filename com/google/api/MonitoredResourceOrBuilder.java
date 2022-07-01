package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.Map;

public interface MonitoredResourceOrBuilder extends MessageOrBuilder {
  boolean containsLabels(String paramString);
  
  @Deprecated
  Map<String, String> getLabels();
  
  int getLabelsCount();
  
  Map<String, String> getLabelsMap();
  
  String getLabelsOrDefault(String paramString1, String paramString2);
  
  String getLabelsOrThrow(String paramString);
  
  String getType();
  
  ByteString getTypeBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoredResourceOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */