package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface MetricDescriptorOrBuilder extends MessageOrBuilder {
  String getDescription();
  
  ByteString getDescriptionBytes();
  
  String getDisplayName();
  
  ByteString getDisplayNameBytes();
  
  LabelDescriptor getLabels(int paramInt);
  
  int getLabelsCount();
  
  List<LabelDescriptor> getLabelsList();
  
  LabelDescriptorOrBuilder getLabelsOrBuilder(int paramInt);
  
  List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList();
  
  LaunchStage getLaunchStage();
  
  int getLaunchStageValue();
  
  MetricDescriptor.MetricDescriptorMetadata getMetadata();
  
  MetricDescriptor.MetricDescriptorMetadataOrBuilder getMetadataOrBuilder();
  
  MetricDescriptor.MetricKind getMetricKind();
  
  int getMetricKindValue();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getType();
  
  ByteString getTypeBytes();
  
  String getUnit();
  
  ByteString getUnitBytes();
  
  MetricDescriptor.ValueType getValueType();
  
  int getValueTypeValue();
  
  boolean hasMetadata();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MetricDescriptorOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */