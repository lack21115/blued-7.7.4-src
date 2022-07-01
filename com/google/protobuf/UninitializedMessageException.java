package com.google.protobuf;

public final class UninitializedMessageException extends RuntimeException {
  public UninitializedMessageException() {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
  }
  
  public final InvalidProtocolBufferException asInvalidProtocolBufferException() {
    return new InvalidProtocolBufferException(getMessage());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\UninitializedMessageException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */