package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface MonitoringOrBuilder extends MessageOrBuilder {
  Monitoring.MonitoringDestination getConsumerDestinations(int paramInt);
  
  int getConsumerDestinationsCount();
  
  List<Monitoring.MonitoringDestination> getConsumerDestinationsList();
  
  Monitoring.MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt);
  
  List<? extends Monitoring.MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList();
  
  Monitoring.MonitoringDestination getProducerDestinations(int paramInt);
  
  int getProducerDestinationsCount();
  
  List<Monitoring.MonitoringDestination> getProducerDestinationsList();
  
  Monitoring.MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int paramInt);
  
  List<? extends Monitoring.MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\MonitoringOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */