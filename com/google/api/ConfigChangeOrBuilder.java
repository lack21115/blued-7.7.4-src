package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ConfigChangeOrBuilder extends MessageOrBuilder {
  Advice getAdvices(int paramInt);
  
  int getAdvicesCount();
  
  List<Advice> getAdvicesList();
  
  AdviceOrBuilder getAdvicesOrBuilder(int paramInt);
  
  List<? extends AdviceOrBuilder> getAdvicesOrBuilderList();
  
  ChangeType getChangeType();
  
  int getChangeTypeValue();
  
  String getElement();
  
  ByteString getElementBytes();
  
  String getNewValue();
  
  ByteString getNewValueBytes();
  
  String getOldValue();
  
  ByteString getOldValueBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ConfigChangeOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */