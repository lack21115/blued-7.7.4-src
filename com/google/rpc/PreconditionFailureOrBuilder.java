package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface PreconditionFailureOrBuilder extends MessageOrBuilder {
  PreconditionFailure.Violation getViolations(int paramInt);
  
  int getViolationsCount();
  
  List<PreconditionFailure.Violation> getViolationsList();
  
  PreconditionFailure.ViolationOrBuilder getViolationsOrBuilder(int paramInt);
  
  List<? extends PreconditionFailure.ViolationOrBuilder> getViolationsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\PreconditionFailureOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */