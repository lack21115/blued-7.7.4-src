package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface LoggingOrBuilder extends MessageOrBuilder {
  Logging.LoggingDestination getConsumerDestinations(int paramInt);
  
  int getConsumerDestinationsCount();
  
  List<Logging.LoggingDestination> getConsumerDestinationsList();
  
  Logging.LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt);
  
  List<? extends Logging.LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList();
  
  Logging.LoggingDestination getProducerDestinations(int paramInt);
  
  int getProducerDestinationsCount();
  
  List<Logging.LoggingDestination> getProducerDestinationsList();
  
  Logging.LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int paramInt);
  
  List<? extends Logging.LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\LoggingOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */