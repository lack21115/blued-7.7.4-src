package com.google.protobuf;

import java.io.IOException;

public abstract class AbstractMessageLite implements MessageLite {
  protected int memoizedHashCode = 0;
  
  public final ByteString toByteString() {
    try {
      ByteString$CodedBuilder byteString$CodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
      writeTo(byteString$CodedBuilder.output);
      if (byteString$CodedBuilder.output.spaceLeft() == 0)
        return new ByteString$LiteralByteString(byteString$CodedBuilder.buffer); 
      throw new IllegalStateException("Did not write as much data as expected.");
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder("Serializing ");
      stringBuilder.append(getClass().getName());
      stringBuilder.append(" to a ");
      stringBuilder.append("ByteString");
      stringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(stringBuilder.toString(), iOException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\AbstractMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */