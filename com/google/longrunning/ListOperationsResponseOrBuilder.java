package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ListOperationsResponseOrBuilder extends MessageOrBuilder {
  String getNextPageToken();
  
  ByteString getNextPageTokenBytes();
  
  Operation getOperations(int paramInt);
  
  int getOperationsCount();
  
  List<Operation> getOperationsList();
  
  OperationOrBuilder getOperationsOrBuilder(int paramInt);
  
  List<? extends OperationOrBuilder> getOperationsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\longrunning\ListOperationsResponseOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */