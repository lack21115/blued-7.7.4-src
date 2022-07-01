package com.google.protobuf;

public abstract class AbstractParser implements Parser {
  static {
    ExtensionRegistryLite.getEmptyRegistry();
    throw new VerifyError("bad dex opcode");
  }
  
  private MessageLite parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) {
    try {
      CodedInputStream codedInputStream = paramByteString.newCodedInput();
      MessageLite messageLite = (MessageLite)parsePartialFrom(codedInputStream, paramExtensionRegistryLite);
      try {
        codedInputStream.checkLastTagWas(0);
        return messageLite;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } 
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\AbstractParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */