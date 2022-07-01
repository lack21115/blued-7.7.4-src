package com.google.protobuf;

import java.io.IOException;

public class InvalidProtocolBufferException extends IOException {
  public InvalidProtocolBufferException(String paramString) {
    super(paramString);
  }
  
  static InvalidProtocolBufferException invalidEndTag() {
    return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
  }
  
  static InvalidProtocolBufferException invalidTag() {
    return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
  }
  
  static InvalidProtocolBufferException$InvalidWireTypeException invalidWireType() {
    return new InvalidProtocolBufferException$InvalidWireTypeException("Protocol message tag had invalid wire type.");
  }
  
  static InvalidProtocolBufferException malformedVarint() {
    return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
  }
  
  static InvalidProtocolBufferException negativeSize() {
    return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static InvalidProtocolBufferException sizeLimitExceeded() {
    return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static InvalidProtocolBufferException truncatedMessage() {
    return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\InvalidProtocolBufferException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */