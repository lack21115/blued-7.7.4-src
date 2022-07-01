package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
  
  private MessageType checkMessageInitialized(MessageType paramMessageType) throws InvalidProtocolBufferException {
    if (paramMessageType != null) {
      if (paramMessageType.isInitialized())
        return paramMessageType; 
      throw newUninitializedMessageException(paramMessageType).asInvalidProtocolBufferException().setUnfinishedMessage(paramMessageType);
    } 
    return paramMessageType;
  }
  
  private UninitializedMessageException newUninitializedMessageException(MessageType paramMessageType) {
    return (paramMessageType instanceof AbstractMessageLite) ? ((AbstractMessageLite)paramMessageType).newUninitializedMessageException() : new UninitializedMessageException((MessageLite)paramMessageType);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream) throws InvalidProtocolBufferException {
    return parseDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return parseFrom(paramByteString, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramByteString, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(CodedInputStream paramCodedInputStream) throws InvalidProtocolBufferException {
    return parseFrom(paramCodedInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramCodedInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(InputStream paramInputStream) throws InvalidProtocolBufferException {
    return parseFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return parseFrom(paramByteBuffer, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    try {
      CodedInputStream codedInputStream = CodedInputStream.newInstance(paramByteBuffer);
      MessageLite messageLite = (MessageLite)parsePartialFrom(codedInputStream, paramExtensionRegistryLite);
      try {
        codedInputStream.checkLastTagWas(0);
        return checkMessageInitialized((MessageType)messageLite);
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException.setUnfinishedMessage(messageLite);
      } 
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException;
    } 
  }
  
  public MessageType parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return parseFrom(paramArrayOfbyte, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws InvalidProtocolBufferException {
    return parseFrom(paramArrayOfbyte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramArrayOfbyte, paramInt1, paramInt2, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return parseFrom(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramExtensionRegistryLite);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream) throws InvalidProtocolBufferException {
    return parsePartialDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    try {
      int i = paramInputStream.read();
      if (i == -1)
        return null; 
      i = CodedInputStream.readRawVarint32(i, paramInputStream);
      return parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(paramInputStream, i), paramExtensionRegistryLite);
    } catch (IOException iOException) {
      throw new InvalidProtocolBufferException(iOException);
    } 
  }
  
  public MessageType parsePartialFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return parsePartialFrom(paramByteString, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    try {
      CodedInputStream codedInputStream = paramByteString.newCodedInput();
      MessageLite messageLite = (MessageLite)parsePartialFrom(codedInputStream, paramExtensionRegistryLite);
      try {
        codedInputStream.checkLastTagWas(0);
        return (MessageType)messageLite;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException.setUnfinishedMessage(messageLite);
      } 
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException;
    } 
  }
  
  public MessageType parsePartialFrom(CodedInputStream paramCodedInputStream) throws InvalidProtocolBufferException {
    return parsePartialFrom(paramCodedInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream) throws InvalidProtocolBufferException {
    return parsePartialFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    CodedInputStream codedInputStream = CodedInputStream.newInstance(paramInputStream);
    MessageLite messageLite = (MessageLite)parsePartialFrom(codedInputStream, paramExtensionRegistryLite);
    try {
      codedInputStream.checkLastTagWas(0);
      return (MessageType)messageLite;
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException.setUnfinishedMessage(messageLite);
    } 
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return parsePartialFrom(paramArrayOfbyte, 0, paramArrayOfbyte.length, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws InvalidProtocolBufferException {
    return parsePartialFrom(paramArrayOfbyte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    try {
      CodedInputStream codedInputStream = CodedInputStream.newInstance(paramArrayOfbyte, paramInt1, paramInt2);
      MessageLite messageLite = (MessageLite)parsePartialFrom(codedInputStream, paramExtensionRegistryLite);
      try {
        codedInputStream.checkLastTagWas(0);
        return (MessageType)messageLite;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException.setUnfinishedMessage(messageLite);
      } 
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException;
    } 
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return parsePartialFrom(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramExtensionRegistryLite);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\AbstractParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */