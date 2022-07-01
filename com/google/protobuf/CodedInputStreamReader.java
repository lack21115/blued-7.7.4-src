package com.google.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class CodedInputStreamReader implements Reader {
  private static final int FIXED32_MULTIPLE_MASK = 3;
  
  private static final int FIXED64_MULTIPLE_MASK = 7;
  
  private static final int NEXT_TAG_UNSET = 0;
  
  private int endGroupTag;
  
  private final CodedInputStream input;
  
  private int nextTag = 0;
  
  private int tag;
  
  private CodedInputStreamReader(CodedInputStream paramCodedInputStream) {
    this.input = Internal.<CodedInputStream>checkNotNull(paramCodedInputStream, "input");
    this.input.wrapper = this;
  }
  
  public static CodedInputStreamReader forCodedInput(CodedInputStream paramCodedInputStream) {
    return (paramCodedInputStream.wrapper != null) ? paramCodedInputStream.wrapper : new CodedInputStreamReader(paramCodedInputStream);
  }
  
  private Object readField(WireFormat.FieldType paramFieldType, Class<?> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    switch (paramFieldType) {
      default:
        throw new RuntimeException("unsupported field type.");
      case null:
        return Long.valueOf(readUInt64());
      case UINT32:
        return Integer.valueOf(readUInt32());
      case STRING:
        return readStringRequireUtf8();
      case SINT64:
        return Long.valueOf(readSInt64());
      case SINT32:
        return Integer.valueOf(readSInt32());
      case SFIXED64:
        return Long.valueOf(readSFixed64());
      case SFIXED32:
        return Integer.valueOf(readSFixed32());
      case MESSAGE:
        return readMessage(paramClass, paramExtensionRegistryLite);
      case INT64:
        return Long.valueOf(readInt64());
      case INT32:
        return Integer.valueOf(readInt32());
      case FLOAT:
        return Float.valueOf(readFloat());
      case FIXED64:
        return Long.valueOf(readFixed64());
      case FIXED32:
        return Integer.valueOf(readFixed32());
      case ENUM:
        return Integer.valueOf(readEnum());
      case DOUBLE:
        return Double.valueOf(readDouble());
      case BYTES:
        return readBytes();
      case BOOL:
        break;
    } 
    return Boolean.valueOf(readBool());
  }
  
  private <T> T readGroup(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    int i = this.endGroupTag;
    this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
    try {
      T t = paramSchema.newInstance();
      paramSchema.mergeFrom(t, this, paramExtensionRegistryLite);
      paramSchema.makeImmutable(t);
      int j = this.tag;
      int k = this.endGroupTag;
      if (j == k)
        return t; 
      throw InvalidProtocolBufferException.parseFailure();
    } finally {
      this.endGroupTag = i;
    } 
  }
  
  private <T> T readMessage(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    int i = this.input.readUInt32();
    if (this.input.recursionDepth < this.input.recursionLimit) {
      i = this.input.pushLimit(i);
      T t = paramSchema.newInstance();
      CodedInputStream codedInputStream2 = this.input;
      codedInputStream2.recursionDepth++;
      paramSchema.mergeFrom(t, this, paramExtensionRegistryLite);
      paramSchema.makeImmutable(t);
      this.input.checkLastTagWas(0);
      CodedInputStream codedInputStream1 = this.input;
      codedInputStream1.recursionDepth--;
      this.input.popLimit(i);
      return t;
    } 
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  private void requirePosition(int paramInt) throws IOException {
    if (this.input.getTotalBytesRead() == paramInt)
      return; 
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private void requireWireType(int paramInt) throws IOException {
    if (WireFormat.getTagWireType(this.tag) == paramInt)
      return; 
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  private void verifyPackedFixed32Length(int paramInt) throws IOException {
    if ((paramInt & 0x3) == 0)
      return; 
    throw InvalidProtocolBufferException.parseFailure();
  }
  
  private void verifyPackedFixed64Length(int paramInt) throws IOException {
    if ((paramInt & 0x7) == 0)
      return; 
    throw InvalidProtocolBufferException.parseFailure();
  }
  
  public int getFieldNumber() throws IOException {
    int i = this.nextTag;
    if (i != 0) {
      this.tag = i;
      this.nextTag = 0;
    } else {
      this.tag = this.input.readTag();
    } 
    i = this.tag;
    return (i == 0 || i == this.endGroupTag) ? Integer.MAX_VALUE : WireFormat.getTagFieldNumber(i);
  }
  
  public int getTag() {
    return this.tag;
  }
  
  public boolean readBool() throws IOException {
    requireWireType(0);
    return this.input.readBool();
  }
  
  public void readBoolList(List<Boolean> paramList) throws IOException {
    if (paramList instanceof BooleanArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 0) {
        if (j == 2) {
          j = this.input.readUInt32();
          j = this.input.getTotalBytesRead() + j;
          while (true) {
            paramList.addBoolean(this.input.readBool());
            if (this.input.getTotalBytesRead() >= j) {
              requirePosition(j);
              return;
            } 
          } 
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addBoolean(this.input.readBool());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 0) {
      if (i == 2) {
        i = this.input.readUInt32();
        i = this.input.getTotalBytesRead() + i;
        while (true) {
          paramList.add(Boolean.valueOf(this.input.readBool()));
          if (this.input.getTotalBytesRead() >= i) {
            requirePosition(i);
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Boolean.valueOf(this.input.readBool()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public ByteString readBytes() throws IOException {
    requireWireType(2);
    return this.input.readBytes();
  }
  
  public void readBytesList(List<ByteString> paramList) throws IOException {
    if (WireFormat.getTagWireType(this.tag) == 2)
      while (true) {
        paramList.add(readBytes());
        if (this.input.isAtEnd())
          return; 
        int i = this.input.readTag();
        if (i != this.tag) {
          this.nextTag = i;
          return;
        } 
      }  
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  public double readDouble() throws IOException {
    requireWireType(1);
    return this.input.readDouble();
  }
  
  public void readDoubleList(List<Double> paramList) throws IOException {
    if (paramList instanceof DoubleArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 1) {
        if (j == 2) {
          j = this.input.readUInt32();
          verifyPackedFixed64Length(j);
          int k = this.input.getTotalBytesRead();
          do {
            paramList.addDouble(this.input.readDouble());
          } while (this.input.getTotalBytesRead() < k + j);
          return;
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addDouble(this.input.readDouble());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 1) {
      if (i == 2) {
        i = this.input.readUInt32();
        verifyPackedFixed64Length(i);
        int j = this.input.getTotalBytesRead();
        do {
          paramList.add(Double.valueOf(this.input.readDouble()));
        } while (this.input.getTotalBytesRead() < j + i);
        return;
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Double.valueOf(this.input.readDouble()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public int readEnum() throws IOException {
    requireWireType(0);
    return this.input.readEnum();
  }
  
  public void readEnumList(List<Integer> paramList) throws IOException {
    if (paramList instanceof IntArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 0) {
        if (j == 2) {
          j = this.input.readUInt32();
          j = this.input.getTotalBytesRead() + j;
          while (true) {
            paramList.addInt(this.input.readEnum());
            if (this.input.getTotalBytesRead() >= j) {
              requirePosition(j);
              return;
            } 
          } 
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addInt(this.input.readEnum());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 0) {
      if (i == 2) {
        i = this.input.readUInt32();
        i = this.input.getTotalBytesRead() + i;
        while (true) {
          paramList.add(Integer.valueOf(this.input.readEnum()));
          if (this.input.getTotalBytesRead() >= i) {
            requirePosition(i);
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Integer.valueOf(this.input.readEnum()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public int readFixed32() throws IOException {
    requireWireType(5);
    return this.input.readFixed32();
  }
  
  public void readFixed32List(List<Integer> paramList) throws IOException {
    if (paramList instanceof IntArrayList) {
      paramList = paramList;
      int k = WireFormat.getTagWireType(this.tag);
      if (k != 2) {
        if (k == 5)
          while (true) {
            paramList.addInt(this.input.readFixed32());
            if (this.input.isAtEnd())
              return; 
            k = this.input.readTag();
            if (k != this.tag) {
              this.nextTag = k;
              return;
            } 
          }  
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      k = this.input.readUInt32();
      verifyPackedFixed32Length(k);
      int m = this.input.getTotalBytesRead();
      do {
        paramList.addInt(this.input.readFixed32());
      } while (this.input.getTotalBytesRead() < m + k);
      return;
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 2) {
      if (i == 5)
        while (true) {
          paramList.add(Integer.valueOf(this.input.readFixed32()));
          if (this.input.isAtEnd())
            return; 
          i = this.input.readTag();
          if (i != this.tag) {
            this.nextTag = i;
            return;
          } 
        }  
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    i = this.input.readUInt32();
    verifyPackedFixed32Length(i);
    int j = this.input.getTotalBytesRead();
    do {
      paramList.add(Integer.valueOf(this.input.readFixed32()));
    } while (this.input.getTotalBytesRead() < j + i);
  }
  
  public long readFixed64() throws IOException {
    requireWireType(1);
    return this.input.readFixed64();
  }
  
  public void readFixed64List(List<Long> paramList) throws IOException {
    if (paramList instanceof LongArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 1) {
        if (j == 2) {
          j = this.input.readUInt32();
          verifyPackedFixed64Length(j);
          int k = this.input.getTotalBytesRead();
          do {
            paramList.addLong(this.input.readFixed64());
          } while (this.input.getTotalBytesRead() < k + j);
          return;
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addLong(this.input.readFixed64());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 1) {
      if (i == 2) {
        i = this.input.readUInt32();
        verifyPackedFixed64Length(i);
        int j = this.input.getTotalBytesRead();
        do {
          paramList.add(Long.valueOf(this.input.readFixed64()));
        } while (this.input.getTotalBytesRead() < j + i);
        return;
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Long.valueOf(this.input.readFixed64()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public float readFloat() throws IOException {
    requireWireType(5);
    return this.input.readFloat();
  }
  
  public void readFloatList(List<Float> paramList) throws IOException {
    if (paramList instanceof FloatArrayList) {
      paramList = paramList;
      int k = WireFormat.getTagWireType(this.tag);
      if (k != 2) {
        if (k == 5)
          while (true) {
            paramList.addFloat(this.input.readFloat());
            if (this.input.isAtEnd())
              return; 
            k = this.input.readTag();
            if (k != this.tag) {
              this.nextTag = k;
              return;
            } 
          }  
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      k = this.input.readUInt32();
      verifyPackedFixed32Length(k);
      int m = this.input.getTotalBytesRead();
      do {
        paramList.addFloat(this.input.readFloat());
      } while (this.input.getTotalBytesRead() < m + k);
      return;
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 2) {
      if (i == 5)
        while (true) {
          paramList.add(Float.valueOf(this.input.readFloat()));
          if (this.input.isAtEnd())
            return; 
          i = this.input.readTag();
          if (i != this.tag) {
            this.nextTag = i;
            return;
          } 
        }  
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    i = this.input.readUInt32();
    verifyPackedFixed32Length(i);
    int j = this.input.getTotalBytesRead();
    do {
      paramList.add(Float.valueOf(this.input.readFloat()));
    } while (this.input.getTotalBytesRead() < j + i);
  }
  
  public <T> T readGroup(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    requireWireType(3);
    return readGroup(Protobuf.getInstance().schemaFor(paramClass), paramExtensionRegistryLite);
  }
  
  public <T> T readGroupBySchemaWithCheck(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    requireWireType(3);
    return readGroup(paramSchema, paramExtensionRegistryLite);
  }
  
  public <T> void readGroupList(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    if (WireFormat.getTagWireType(this.tag) == 3) {
      int i = this.tag;
      while (true) {
        paramList.add(readGroup(paramSchema, paramExtensionRegistryLite));
        if (!this.input.isAtEnd()) {
          if (this.nextTag != 0)
            return; 
          int j = this.input.readTag();
          if (j != i) {
            this.nextTag = j;
            break;
          } 
          continue;
        } 
        break;
      } 
      return;
    } 
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  public <T> void readGroupList(List<T> paramList, Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    readGroupList(paramList, Protobuf.getInstance().schemaFor(paramClass), paramExtensionRegistryLite);
  }
  
  public int readInt32() throws IOException {
    requireWireType(0);
    return this.input.readInt32();
  }
  
  public void readInt32List(List<Integer> paramList) throws IOException {
    if (paramList instanceof IntArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 0) {
        if (j == 2) {
          j = this.input.readUInt32();
          j = this.input.getTotalBytesRead() + j;
          while (true) {
            paramList.addInt(this.input.readInt32());
            if (this.input.getTotalBytesRead() >= j) {
              requirePosition(j);
              return;
            } 
          } 
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addInt(this.input.readInt32());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 0) {
      if (i == 2) {
        i = this.input.readUInt32();
        i = this.input.getTotalBytesRead() + i;
        while (true) {
          paramList.add(Integer.valueOf(this.input.readInt32()));
          if (this.input.getTotalBytesRead() >= i) {
            requirePosition(i);
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Integer.valueOf(this.input.readInt32()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public long readInt64() throws IOException {
    requireWireType(0);
    return this.input.readInt64();
  }
  
  public void readInt64List(List<Long> paramList) throws IOException {
    if (paramList instanceof LongArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 0) {
        if (j == 2) {
          j = this.input.readUInt32();
          j = this.input.getTotalBytesRead() + j;
          while (true) {
            paramList.addLong(this.input.readInt64());
            if (this.input.getTotalBytesRead() >= j) {
              requirePosition(j);
              return;
            } 
          } 
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addLong(this.input.readInt64());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 0) {
      if (i == 2) {
        i = this.input.readUInt32();
        i = this.input.getTotalBytesRead() + i;
        while (true) {
          paramList.add(Long.valueOf(this.input.readInt64()));
          if (this.input.getTotalBytesRead() >= i) {
            requirePosition(i);
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Long.valueOf(this.input.readInt64()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public <K, V> void readMap(Map<K, V> paramMap, MapEntryLite.Metadata<K, V> paramMetadata, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    requireWireType(2);
    int i = this.input.readUInt32();
    i = this.input.pushLimit(i);
    K k = paramMetadata.defaultKey;
    V v = paramMetadata.defaultValue;
    while (true) {
      try {
        int j = getFieldNumber();
        if (j != Integer.MAX_VALUE) {
          boolean bool = this.input.isAtEnd();
          if (!bool) {
            if (j != 1) {
              if (j != 2)
                try {
                  if (skipField())
                    continue; 
                  throw new InvalidProtocolBufferException("Unable to parse map entry.");
                } catch (InvalidWireTypeException invalidWireTypeException) {
                  if (skipField())
                    continue; 
                  throw new InvalidProtocolBufferException("Unable to parse map entry.");
                }  
              Object object1 = readField(paramMetadata.valueType, paramMetadata.defaultValue.getClass(), paramExtensionRegistryLite);
              v = (V)object1;
              continue;
            } 
            Object object = readField(paramMetadata.keyType, null, null);
            k = (K)object;
            continue;
          } 
        } 
        paramMap.put(k, v);
        return;
      } finally {
        this.input.popLimit(i);
      } 
    } 
  }
  
  public <T> T readMessage(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    requireWireType(2);
    return readMessage(Protobuf.getInstance().schemaFor(paramClass), paramExtensionRegistryLite);
  }
  
  public <T> T readMessageBySchemaWithCheck(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    requireWireType(2);
    return readMessage(paramSchema, paramExtensionRegistryLite);
  }
  
  public <T> void readMessageList(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    if (WireFormat.getTagWireType(this.tag) == 2) {
      int i = this.tag;
      while (true) {
        paramList.add(readMessage(paramSchema, paramExtensionRegistryLite));
        if (!this.input.isAtEnd()) {
          if (this.nextTag != 0)
            return; 
          int j = this.input.readTag();
          if (j != i) {
            this.nextTag = j;
            break;
          } 
          continue;
        } 
        break;
      } 
      return;
    } 
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  public <T> void readMessageList(List<T> paramList, Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    readMessageList(paramList, Protobuf.getInstance().schemaFor(paramClass), paramExtensionRegistryLite);
  }
  
  public int readSFixed32() throws IOException {
    requireWireType(5);
    return this.input.readSFixed32();
  }
  
  public void readSFixed32List(List<Integer> paramList) throws IOException {
    if (paramList instanceof IntArrayList) {
      paramList = paramList;
      int k = WireFormat.getTagWireType(this.tag);
      if (k != 2) {
        if (k == 5)
          while (true) {
            paramList.addInt(this.input.readSFixed32());
            if (this.input.isAtEnd())
              return; 
            k = this.input.readTag();
            if (k != this.tag) {
              this.nextTag = k;
              return;
            } 
          }  
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      k = this.input.readUInt32();
      verifyPackedFixed32Length(k);
      int m = this.input.getTotalBytesRead();
      do {
        paramList.addInt(this.input.readSFixed32());
      } while (this.input.getTotalBytesRead() < m + k);
      return;
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 2) {
      if (i == 5)
        while (true) {
          paramList.add(Integer.valueOf(this.input.readSFixed32()));
          if (this.input.isAtEnd())
            return; 
          i = this.input.readTag();
          if (i != this.tag) {
            this.nextTag = i;
            return;
          } 
        }  
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    i = this.input.readUInt32();
    verifyPackedFixed32Length(i);
    int j = this.input.getTotalBytesRead();
    do {
      paramList.add(Integer.valueOf(this.input.readSFixed32()));
    } while (this.input.getTotalBytesRead() < j + i);
  }
  
  public long readSFixed64() throws IOException {
    requireWireType(1);
    return this.input.readSFixed64();
  }
  
  public void readSFixed64List(List<Long> paramList) throws IOException {
    if (paramList instanceof LongArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 1) {
        if (j == 2) {
          j = this.input.readUInt32();
          verifyPackedFixed64Length(j);
          int k = this.input.getTotalBytesRead();
          do {
            paramList.addLong(this.input.readSFixed64());
          } while (this.input.getTotalBytesRead() < k + j);
          return;
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addLong(this.input.readSFixed64());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 1) {
      if (i == 2) {
        i = this.input.readUInt32();
        verifyPackedFixed64Length(i);
        int j = this.input.getTotalBytesRead();
        do {
          paramList.add(Long.valueOf(this.input.readSFixed64()));
        } while (this.input.getTotalBytesRead() < j + i);
        return;
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Long.valueOf(this.input.readSFixed64()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public int readSInt32() throws IOException {
    requireWireType(0);
    return this.input.readSInt32();
  }
  
  public void readSInt32List(List<Integer> paramList) throws IOException {
    if (paramList instanceof IntArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 0) {
        if (j == 2) {
          j = this.input.readUInt32();
          j = this.input.getTotalBytesRead() + j;
          while (true) {
            paramList.addInt(this.input.readSInt32());
            if (this.input.getTotalBytesRead() >= j) {
              requirePosition(j);
              return;
            } 
          } 
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addInt(this.input.readSInt32());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 0) {
      if (i == 2) {
        i = this.input.readUInt32();
        i = this.input.getTotalBytesRead() + i;
        while (true) {
          paramList.add(Integer.valueOf(this.input.readSInt32()));
          if (this.input.getTotalBytesRead() >= i) {
            requirePosition(i);
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Integer.valueOf(this.input.readSInt32()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public long readSInt64() throws IOException {
    requireWireType(0);
    return this.input.readSInt64();
  }
  
  public void readSInt64List(List<Long> paramList) throws IOException {
    if (paramList instanceof LongArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 0) {
        if (j == 2) {
          j = this.input.readUInt32();
          j = this.input.getTotalBytesRead() + j;
          while (true) {
            paramList.addLong(this.input.readSInt64());
            if (this.input.getTotalBytesRead() >= j) {
              requirePosition(j);
              return;
            } 
          } 
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addLong(this.input.readSInt64());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 0) {
      if (i == 2) {
        i = this.input.readUInt32();
        i = this.input.getTotalBytesRead() + i;
        while (true) {
          paramList.add(Long.valueOf(this.input.readSInt64()));
          if (this.input.getTotalBytesRead() >= i) {
            requirePosition(i);
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Long.valueOf(this.input.readSInt64()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public String readString() throws IOException {
    requireWireType(2);
    return this.input.readString();
  }
  
  public void readStringList(List<String> paramList) throws IOException {
    readStringListInternal(paramList, false);
  }
  
  public void readStringListInternal(List<String> paramList, boolean paramBoolean) throws IOException {
    if (WireFormat.getTagWireType(this.tag) == 2) {
      if (paramList instanceof LazyStringList && !paramBoolean) {
        paramList = paramList;
        while (true) {
          paramList.add(readBytes());
          if (this.input.isAtEnd())
            return; 
          int i = this.input.readTag();
          if (i != this.tag) {
            this.nextTag = i;
            return;
          } 
        } 
      } 
      while (true) {
        String str;
        if (paramBoolean) {
          str = readStringRequireUtf8();
        } else {
          str = readString();
        } 
        paramList.add(str);
        if (this.input.isAtEnd())
          return; 
        int i = this.input.readTag();
        if (i != this.tag) {
          this.nextTag = i;
          return;
        } 
      } 
    } 
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  public void readStringListRequireUtf8(List<String> paramList) throws IOException {
    readStringListInternal(paramList, true);
  }
  
  public String readStringRequireUtf8() throws IOException {
    requireWireType(2);
    return this.input.readStringRequireUtf8();
  }
  
  public int readUInt32() throws IOException {
    requireWireType(0);
    return this.input.readUInt32();
  }
  
  public void readUInt32List(List<Integer> paramList) throws IOException {
    if (paramList instanceof IntArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 0) {
        if (j == 2) {
          j = this.input.readUInt32();
          j = this.input.getTotalBytesRead() + j;
          while (true) {
            paramList.addInt(this.input.readUInt32());
            if (this.input.getTotalBytesRead() >= j) {
              requirePosition(j);
              return;
            } 
          } 
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addInt(this.input.readUInt32());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 0) {
      if (i == 2) {
        i = this.input.readUInt32();
        i = this.input.getTotalBytesRead() + i;
        while (true) {
          paramList.add(Integer.valueOf(this.input.readUInt32()));
          if (this.input.getTotalBytesRead() >= i) {
            requirePosition(i);
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Integer.valueOf(this.input.readUInt32()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public long readUInt64() throws IOException {
    requireWireType(0);
    return this.input.readUInt64();
  }
  
  public void readUInt64List(List<Long> paramList) throws IOException {
    if (paramList instanceof LongArrayList) {
      paramList = paramList;
      int j = WireFormat.getTagWireType(this.tag);
      if (j != 0) {
        if (j == 2) {
          j = this.input.readUInt32();
          j = this.input.getTotalBytesRead() + j;
          while (true) {
            paramList.addLong(this.input.readUInt64());
            if (this.input.getTotalBytesRead() >= j) {
              requirePosition(j);
              return;
            } 
          } 
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        paramList.addLong(this.input.readUInt64());
        if (this.input.isAtEnd())
          return; 
        j = this.input.readTag();
        if (j != this.tag) {
          this.nextTag = j;
          return;
        } 
      } 
    } 
    int i = WireFormat.getTagWireType(this.tag);
    if (i != 0) {
      if (i == 2) {
        i = this.input.readUInt32();
        i = this.input.getTotalBytesRead() + i;
        while (true) {
          paramList.add(Long.valueOf(this.input.readUInt64()));
          if (this.input.getTotalBytesRead() >= i) {
            requirePosition(i);
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    } 
    while (true) {
      paramList.add(Long.valueOf(this.input.readUInt64()));
      if (this.input.isAtEnd())
        return; 
      i = this.input.readTag();
      if (i != this.tag) {
        this.nextTag = i;
        return;
      } 
    } 
  }
  
  public boolean shouldDiscardUnknownFields() {
    return this.input.shouldDiscardUnknownFields();
  }
  
  public boolean skipField() throws IOException {
    if (!this.input.isAtEnd()) {
      int i = this.tag;
      if (i != this.endGroupTag)
        return this.input.skipField(i); 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\CodedInputStreamReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */