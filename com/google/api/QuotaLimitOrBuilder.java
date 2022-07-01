package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.Map;

public interface QuotaLimitOrBuilder extends MessageOrBuilder {
  boolean containsValues(String paramString);
  
  long getDefaultLimit();
  
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getDisplayName();
  
  ByteString getDisplayNameBytes();
  
  String getDuration();
  
  ByteString getDurationBytes();
  
  long getFreeTier();
  
  long getMaxLimit();
  
  String getMetric();
  
  ByteString getMetricBytes();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getUnit();
  
  ByteString getUnitBytes();
  
  @Deprecated
  Map<String, Long> getValues();
  
  int getValuesCount();
  
  Map<String, Long> getValuesMap();
  
  long getValuesOrDefault(String paramString, long paramLong);
  
  long getValuesOrThrow(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\QuotaLimitOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */