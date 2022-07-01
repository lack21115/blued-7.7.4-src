package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DebugInfoOrBuilder extends MessageOrBuilder {
  String getDetail();
  
  ByteString getDetailBytes();
  
  String getStackEntries(int paramInt);
  
  ByteString getStackEntriesBytes(int paramInt);
  
  int getStackEntriesCount();
  
  List<String> getStackEntriesList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\DebugInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */