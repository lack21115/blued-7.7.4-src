package com.google.rpc;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface StatusOrBuilder extends MessageOrBuilder {
  int getCode();
  
  Any getDetails(int paramInt);
  
  int getDetailsCount();
  
  List<Any> getDetailsList();
  
  AnyOrBuilder getDetailsOrBuilder(int paramInt);
  
  List<? extends AnyOrBuilder> getDetailsOrBuilderList();
  
  String getMessage();
  
  ByteString getMessageBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\StatusOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */