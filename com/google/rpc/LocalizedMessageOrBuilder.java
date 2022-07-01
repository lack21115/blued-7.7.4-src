package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface LocalizedMessageOrBuilder extends MessageOrBuilder {
  String getLocale();
  
  ByteString getLocaleBytes();
  
  String getMessage();
  
  ByteString getMessageBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\LocalizedMessageOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */