package com.google.protobuf;

import java.io.IOException;

public final class CodedOutputStream$OutOfSpaceException extends IOException {
  CodedOutputStream$OutOfSpaceException() {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.");
  }
  
  CodedOutputStream$OutOfSpaceException(String paramString, Throwable paramThrowable) {
    super(stringBuilder.toString(), paramThrowable);
  }
  
  CodedOutputStream$OutOfSpaceException(Throwable paramThrowable) {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.", paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\CodedOutputStream$OutOfSpaceException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */