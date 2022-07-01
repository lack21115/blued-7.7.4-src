package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface BadRequestOrBuilder extends MessageOrBuilder {
  BadRequest.FieldViolation getFieldViolations(int paramInt);
  
  int getFieldViolationsCount();
  
  List<BadRequest.FieldViolation> getFieldViolationsList();
  
  BadRequest.FieldViolationOrBuilder getFieldViolationsOrBuilder(int paramInt);
  
  List<? extends BadRequest.FieldViolationOrBuilder> getFieldViolationsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\BadRequestOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */