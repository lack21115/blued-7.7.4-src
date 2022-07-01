package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface PageOrBuilder extends MessageOrBuilder {
  String getContent();
  
  ByteString getContentBytes();
  
  String getName();
  
  ByteString getNameBytes();
  
  Page getSubpages(int paramInt);
  
  int getSubpagesCount();
  
  List<Page> getSubpagesList();
  
  PageOrBuilder getSubpagesOrBuilder(int paramInt);
  
  List<? extends PageOrBuilder> getSubpagesOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\PageOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */