package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface BillingOrBuilder extends MessageOrBuilder {
  Billing.BillingDestination getConsumerDestinations(int paramInt);
  
  int getConsumerDestinationsCount();
  
  List<Billing.BillingDestination> getConsumerDestinationsList();
  
  Billing.BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt);
  
  List<? extends Billing.BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\BillingOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */