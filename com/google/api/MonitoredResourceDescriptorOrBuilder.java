package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface MonitoredResourceDescriptorOrBuilder extends MessageOrBuilder {
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
  
  String getName();
  
  ByteString getNameBytes();
  
  String getType();
  
  ByteString getTypeBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoredResourceDescriptorOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */