package com.google.protobuf;

import java.io.IOException;

public final class WireFormat {
  static final int FIXED32_SIZE = 4;
  
  static final int FIXED64_SIZE = 8;
  
  static final int MAX_VARINT32_SIZE = 5;
  
  static final int MAX_VARINT64_SIZE = 10;
  
  static final int MAX_VARINT_SIZE = 10;
  
  static final int MESSAGE_SET_ITEM = 1;
  
  static final int MESSAGE_SET_ITEM_END_TAG;
  
  static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
  
  static final int MESSAGE_SET_MESSAGE = 3;
  
  static final int MESSAGE_SET_MESSAGE_TAG;
  
  static final int MESSAGE_SET_TYPE_ID = 2;
  
  static final int MESSAGE_SET_TYPE_ID_TAG;
  
  static final int TAG_TYPE_BITS = 3;
  
  static final int TAG_TYPE_MASK = 7;
  
  public static final int WIRETYPE_END_GROUP = 4;
  
  public static final int WIRETYPE_FIXED32 = 5;
  
  public static final int WIRETYPE_FIXED64 = 1;
  
  public static final int WIRETYPE_LENGTH_DELIMITED = 2;
  
  public static final int WIRETYPE_START_GROUP = 3;
  
  public static final int WIRETYPE_VARINT = 0;
  
  static {
    MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
  }
  
  public static int getTagFieldNumber(int paramInt) {
    return paramInt >>> 3;
  }
  
  public static int getTagWireType(int paramInt) {
    return paramInt & 0x7;
  }
  
  static int makeTag(int paramInt1, int paramInt2) {
    return paramInt1 << 3 | paramInt2;
  }
  
  static Object readPrimitiveField(CodedInputStream paramCodedInputStream, FieldType paramFieldType, Utf8Validation paramUtf8Validation) throws IOException {
    switch (paramFieldType) {
      default:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      case null:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
      case MESSAGE:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
      case GROUP:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
      case STRING:
        return paramUtf8Validation.readString(paramCodedInputStream);
      case SINT64:
        return Long.valueOf(paramCodedInputStream.readSInt64());
      case SINT32:
        return Integer.valueOf(paramCodedInputStream.readSInt32());
      case SFIXED64:
        return Long.valueOf(paramCodedInputStream.readSFixed64());
      case SFIXED32:
        return Integer.valueOf(paramCodedInputStream.readSFixed32());
      case UINT32:
        return Integer.valueOf(paramCodedInputStream.readUInt32());
      case BYTES:
        return paramCodedInputStream.readBytes();
      case BOOL:
        return Boolean.valueOf(paramCodedInputStream.readBool());
      case FIXED32:
        return Integer.valueOf(paramCodedInputStream.readFixed32());
      case FIXED64:
        return Long.valueOf(paramCodedInputStream.readFixed64());
      case INT32:
        return Integer.valueOf(paramCodedInputStream.readInt32());
      case UINT64:
        return Long.valueOf(paramCodedInputStream.readUInt64());
      case INT64:
        return Long.valueOf(paramCodedInputStream.readInt64());
      case FLOAT:
        return Float.valueOf(paramCodedInputStream.readFloat());
      case DOUBLE:
        break;
    } 
    return Double.valueOf(paramCodedInputStream.readDouble());
  }
  
  public enum FieldType {
    BOOL,
    BYTES,
    DOUBLE((String)WireFormat.JavaType.DOUBLE, 1),
    ENUM((String)WireFormat.JavaType.DOUBLE, 1),
    FIXED32((String)WireFormat.JavaType.DOUBLE, 1),
    FIXED64((String)WireFormat.JavaType.DOUBLE, 1),
    FLOAT((String)WireFormat.JavaType.FLOAT, 5),
    GROUP((String)WireFormat.JavaType.FLOAT, 5),
    INT32((String)WireFormat.JavaType.FLOAT, 5),
    INT64((String)WireFormat.JavaType.LONG, 0),
    MESSAGE((String)WireFormat.JavaType.LONG, 0),
    SFIXED32((String)WireFormat.JavaType.LONG, 0),
    SFIXED64((String)WireFormat.JavaType.LONG, 0),
    SINT32((String)WireFormat.JavaType.LONG, 0),
    SINT64((String)WireFormat.JavaType.LONG, 0),
    STRING((String)WireFormat.JavaType.LONG, 0),
    UINT32((String)WireFormat.JavaType.LONG, 0),
    UINT64((String)WireFormat.JavaType.LONG, 0);
    
    private final WireFormat.JavaType javaType;
    
    private final int wireType;
    
    static {
      FIXED64 = new FieldType("FIXED64", 5, WireFormat.JavaType.LONG, 1);
      FIXED32 = new FieldType("FIXED32", 6, WireFormat.JavaType.INT, 5);
      BOOL = new FieldType("BOOL", 7, WireFormat.JavaType.BOOLEAN, 0);
      STRING = new null("STRING", 8, WireFormat.JavaType.STRING, 2);
      GROUP = new null("GROUP", 9, WireFormat.JavaType.MESSAGE, 3);
      MESSAGE = new null("MESSAGE", 10, WireFormat.JavaType.MESSAGE, 2);
      BYTES = new null("BYTES", 11, WireFormat.JavaType.BYTE_STRING, 2);
      UINT32 = new FieldType("UINT32", 12, WireFormat.JavaType.INT, 0);
      ENUM = new FieldType("ENUM", 13, WireFormat.JavaType.ENUM, 0);
      SFIXED32 = new FieldType("SFIXED32", 14, WireFormat.JavaType.INT, 5);
      SFIXED64 = new FieldType("SFIXED64", 15, WireFormat.JavaType.LONG, 1);
      SINT32 = new FieldType("SINT32", 16, WireFormat.JavaType.INT, 0);
      SINT64 = new FieldType("SINT64", 17, WireFormat.JavaType.LONG, 0);
      $VALUES = new FieldType[] { 
          DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, 
          MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64 };
    }
    
    FieldType(WireFormat.JavaType param1JavaType, int param1Int1) {
      this.javaType = param1JavaType;
      this.wireType = param1Int1;
    }
    
    public WireFormat.JavaType getJavaType() {
      return this.javaType;
    }
    
    public int getWireType() {
      return this.wireType;
    }
    
    public boolean isPackable() {
      return true;
    }
  }
  
  enum null {
    public boolean isPackable() {
      return false;
    }
  }
  
  enum null {
    public boolean isPackable() {
      return false;
    }
  }
  
  enum null {
    public boolean isPackable() {
      return false;
    }
  }
  
  enum null {
    public boolean isPackable() {
      return false;
    }
  }
  
  public enum JavaType {
    INT((String)Integer.valueOf(0)),
    LONG((String)Long.valueOf(0L)),
    MESSAGE((String)Long.valueOf(0L)),
    STRING((String)Long.valueOf(0L)),
    BOOLEAN((String)JavaType.LONG, 0),
    BYTE_STRING((String)JavaType.LONG, 0),
    DOUBLE((String)JavaType.LONG, 0),
    ENUM((String)JavaType.LONG, 0),
    FLOAT((String)JavaType.LONG, 0);
    
    private final Object defaultDefault;
    
    static {
      DOUBLE = new JavaType("DOUBLE", 3, Double.valueOf(0.0D));
      BOOLEAN = new JavaType("BOOLEAN", 4, Boolean.valueOf(false));
      STRING = new JavaType("STRING", 5, "");
      BYTE_STRING = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
      ENUM = new JavaType("ENUM", 7, null);
      MESSAGE = new JavaType("MESSAGE", 8, null);
      $VALUES = new JavaType[] { INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE };
    }
    
    JavaType(Object param1Object) {
      this.defaultDefault = param1Object;
    }
    
    Object getDefaultDefault() {
      return this.defaultDefault;
    }
  }
  
  enum Utf8Validation {
    LOOSE {
      Object readString(CodedInputStream param2CodedInputStream) throws IOException {
        return param2CodedInputStream.readString();
      }
    },
    LAZY((String)Long.valueOf(0L)),
    STRICT {
      Object readString(CodedInputStream param2CodedInputStream) throws IOException {
        return param2CodedInputStream.readStringRequireUtf8();
      }
    };
    
    static {
      $VALUES = new Utf8Validation[] { LOOSE, STRICT, LAZY };
    }
    
    abstract Object readString(CodedInputStream param1CodedInputStream) throws IOException;
  }
  
  enum null {
    Object readString(CodedInputStream param1CodedInputStream) throws IOException {
      return param1CodedInputStream.readString();
    }
  }
  
  enum null {
    Object readString(CodedInputStream param1CodedInputStream) throws IOException {
      return param1CodedInputStream.readStringRequireUtf8();
    }
  }
  
  enum null {
    Object readString(CodedInputStream param1CodedInputStream) throws IOException {
      return param1CodedInputStream.readBytes();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\WireFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */