package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface QuotaFailureOrBuilder extends MessageOrBuilder {
  QuotaFailure.Violation getViolations(int paramInt);
  
  int getViolationsCount();
  
  List<QuotaFailure.Violation> getViolationsList();
  
  QuotaFailure.ViolationOrBuilder getViolationsOrBuilder(int paramInt);
  
  List<? extends QuotaFailure.ViolationOrBuilder> getViolationsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\QuotaFailureOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */