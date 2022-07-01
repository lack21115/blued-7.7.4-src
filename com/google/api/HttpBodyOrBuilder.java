package com.google.api;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface HttpBodyOrBuilder extends MessageOrBuilder {
  String getContentType();
  
  ByteString getContentTypeBytes();
  
  ByteString getData();
  
  Any getExtensions(int paramInt);
  
  int getExtensionsCount();
  
  List<Any> getExtensionsList();
  
  AnyOrBuilder getExtensionsOrBuilder(int paramInt);
  
  List<? extends AnyOrBuilder> getExtensionsOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\HttpBodyOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */