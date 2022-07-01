package com.google.protobuf;

public interface MessageLite extends MessageLiteOrBuilder {
  Parser getParserForType();
  
  int getSerializedSize();
  
  ByteString toByteString();
  
  void writeTo(CodedOutputStream paramCodedOutputStream);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\MessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */