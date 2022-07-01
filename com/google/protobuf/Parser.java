package com.google.protobuf;

public interface Parser {
  Object parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
  
  Object parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */