package com.google.protobuf;

public enum WireFormat$FieldType {
  BOOL,
  BYTES,
  DOUBLE(WireFormat$JavaType.DOUBLE),
  ENUM(WireFormat$JavaType.DOUBLE),
  FIXED32(WireFormat$JavaType.DOUBLE),
  FIXED64(WireFormat$JavaType.DOUBLE),
  FLOAT(WireFormat$JavaType.FLOAT),
  GROUP(WireFormat$JavaType.FLOAT),
  INT32(WireFormat$JavaType.FLOAT),
  INT64(WireFormat$JavaType.LONG),
  MESSAGE(WireFormat$JavaType.LONG),
  SFIXED32(WireFormat$JavaType.LONG),
  SFIXED64(WireFormat$JavaType.LONG),
  SINT32(WireFormat$JavaType.LONG),
  SINT64(WireFormat$JavaType.LONG),
  STRING(WireFormat$JavaType.LONG),
  UINT32(WireFormat$JavaType.LONG),
  UINT64(WireFormat$JavaType.LONG);
  
  final WireFormat$JavaType javaType;
  
  static {
    INT32 = new WireFormat$FieldType("INT32", 4, WireFormat$JavaType.INT);
    FIXED64 = new WireFormat$FieldType("FIXED64", 5, WireFormat$JavaType.LONG);
    FIXED32 = new WireFormat$FieldType("FIXED32", 6, WireFormat$JavaType.INT);
    BOOL = new WireFormat$FieldType("BOOL", 7, WireFormat$JavaType.BOOLEAN);
    STRING = new WireFormat$FieldType$1("STRING", 8, WireFormat$JavaType.STRING, 2);
    GROUP = new WireFormat$FieldType$2("GROUP", 9, WireFormat$JavaType.MESSAGE, 3);
    MESSAGE = new WireFormat$FieldType$3("MESSAGE", 10, WireFormat$JavaType.MESSAGE, 2);
    BYTES = new WireFormat$FieldType$4("BYTES", 11, WireFormat$JavaType.BYTE_STRING, 2);
    UINT32 = new WireFormat$FieldType("UINT32", 12, WireFormat$JavaType.INT);
    ENUM = new WireFormat$FieldType("ENUM", 13, WireFormat$JavaType.ENUM);
    SFIXED32 = new WireFormat$FieldType("SFIXED32", 14, WireFormat$JavaType.INT);
    SFIXED64 = new WireFormat$FieldType("SFIXED64", 15, WireFormat$JavaType.LONG);
    SINT32 = new WireFormat$FieldType("SINT32", 16, WireFormat$JavaType.INT);
    SINT64 = new WireFormat$FieldType("SINT64", 17, WireFormat$JavaType.LONG);
    $VALUES = new WireFormat$FieldType[] { 
        DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, 
        MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64 };
    throw new VerifyError("bad dex opcode");
  }
  
  WireFormat$FieldType(WireFormat$JavaType paramWireFormat$JavaType) {
    this.javaType = paramWireFormat$JavaType;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\WireFormat$FieldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */