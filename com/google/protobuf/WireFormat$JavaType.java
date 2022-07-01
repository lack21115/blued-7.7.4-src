package com.google.protobuf;

public enum WireFormat$JavaType {
  BOOLEAN, BYTE_STRING, DOUBLE, ENUM, FLOAT, INT, LONG, MESSAGE, STRING;
  
  static {
    FLOAT = new WireFormat$JavaType("FLOAT", 2);
    DOUBLE = new WireFormat$JavaType("DOUBLE", 3);
    BOOLEAN = new WireFormat$JavaType("BOOLEAN", 4);
    STRING = new WireFormat$JavaType("STRING", 5);
    ByteString byteString = ByteString.EMPTY;
    BYTE_STRING = new WireFormat$JavaType("BYTE_STRING", 6);
    ENUM = new WireFormat$JavaType("ENUM", 7);
    MESSAGE = new WireFormat$JavaType("MESSAGE", 8);
    $VALUES = new WireFormat$JavaType[] { INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE };
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\WireFormat$JavaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */