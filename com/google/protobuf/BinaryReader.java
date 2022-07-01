package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

abstract class BinaryReader implements Reader {
  private static final int FIXED32_MULTIPLE_MASK = 3;
  
  private static final int FIXED64_MULTIPLE_MASK = 7;
  
  private BinaryReader() {}
  
  public static BinaryReader newInstance(ByteBuffer paramByteBuffer, boolean paramBoolean) {
    if (paramByteBuffer.hasArray())
      return new SafeHeapReader(paramByteBuffer, paramBoolean); 
    throw new IllegalArgumentException("Direct buffers not yet supported");
  }
  
  public abstract int getTotalBytesRead();
  
  public boolean shouldDiscardUnknownFields() {
    return false;
  }
  
  static final class SafeHeapReader extends BinaryReader {
    private final byte[] buffer;
    
    private final boolean bufferIsImmutable;
    
    private int endGroupTag;
    
    private final int initialPos;
    
    private int limit;
    
    private int pos;
    
    private int tag;
    
    public SafeHeapReader(ByteBuffer param1ByteBuffer, boolean param1Boolean) {
      this.bufferIsImmutable = param1Boolean;
      this.buffer = param1ByteBuffer.array();
      int i = param1ByteBuffer.arrayOffset() + param1ByteBuffer.position();
      this.pos = i;
      this.initialPos = i;
      this.limit = param1ByteBuffer.arrayOffset() + param1ByteBuffer.limit();
    }
    
    private boolean isAtEnd() {
      return (this.pos == this.limit);
    }
    
    private byte readByte() throws IOException {
      int i = this.pos;
      if (i != this.limit) {
        byte[] arrayOfByte = this.buffer;
        this.pos = i + 1;
        return arrayOfByte[i];
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    private Object readField(WireFormat.FieldType param1FieldType, Class<?> param1Class, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      switch (param1FieldType) {
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
          return readMessage(param1Class, param1ExtensionRegistryLite);
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
    
    private <T> T readGroup(Schema<T> param1Schema, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = this.endGroupTag;
      this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
      try {
        T t = param1Schema.newInstance();
        param1Schema.mergeFrom(t, this, param1ExtensionRegistryLite);
        param1Schema.makeImmutable(t);
        int j = this.tag;
        int k = this.endGroupTag;
        if (j == k)
          return t; 
        throw InvalidProtocolBufferException.parseFailure();
      } finally {
        this.endGroupTag = i;
      } 
    }
    
    private int readLittleEndian32() throws IOException {
      requireBytes(4);
      return readLittleEndian32_NoCheck();
    }
    
    private int readLittleEndian32_NoCheck() {
      int i = this.pos;
      byte[] arrayOfByte = this.buffer;
      this.pos = i + 4;
      byte b1 = arrayOfByte[i];
      byte b2 = arrayOfByte[i + 1];
      byte b3 = arrayOfByte[i + 2];
      return (arrayOfByte[i + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
    }
    
    private long readLittleEndian64() throws IOException {
      requireBytes(8);
      return readLittleEndian64_NoCheck();
    }
    
    private long readLittleEndian64_NoCheck() {
      int i = this.pos;
      byte[] arrayOfByte = this.buffer;
      this.pos = i + 8;
      long l1 = arrayOfByte[i];
      long l2 = arrayOfByte[i + 1];
      long l3 = arrayOfByte[i + 2];
      long l4 = arrayOfByte[i + 3];
      long l5 = arrayOfByte[i + 4];
      long l6 = arrayOfByte[i + 5];
      long l7 = arrayOfByte[i + 6];
      return (arrayOfByte[i + 7] & 0xFFL) << 56L | l1 & 0xFFL | (l2 & 0xFFL) << 8L | (l3 & 0xFFL) << 16L | (l4 & 0xFFL) << 24L | (l5 & 0xFFL) << 32L | (l6 & 0xFFL) << 40L | (l7 & 0xFFL) << 48L;
    }
    
    private <T> T readMessage(Schema<T> param1Schema, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int j = readVarint32();
      requireBytes(j);
      int i = this.limit;
      j = this.pos + j;
      this.limit = j;
      try {
        T t = param1Schema.newInstance();
        param1Schema.mergeFrom(t, this, param1ExtensionRegistryLite);
        param1Schema.makeImmutable(t);
        int k = this.pos;
        if (k == j)
          return t; 
        throw InvalidProtocolBufferException.parseFailure();
      } finally {
        this.limit = i;
      } 
    }
    
    private int readVarint32() throws IOException {
      int j = this.pos;
      int i = this.limit;
      if (i != j) {
        byte[] arrayOfByte = this.buffer;
        int k = j + 1;
        j = arrayOfByte[j];
        if (j >= 0) {
          this.pos = k;
          return j;
        } 
        if (i - k < 9)
          return (int)readVarint64SlowPath(); 
        i = k + 1;
        j ^= arrayOfByte[k] << 7;
        if (j < 0) {
          k = j ^ 0xFFFFFF80;
        } else {
          k = i + 1;
          j ^= arrayOfByte[i] << 14;
          if (j >= 0) {
            j ^= 0x3F80;
            i = k;
            k = j;
          } else {
            i = k + 1;
            k = j ^ arrayOfByte[k] << 21;
            if (k < 0) {
              k ^= 0xFFE03F80;
            } else {
              int m = i + 1;
              byte b = arrayOfByte[i];
              j = k ^ b << 28 ^ 0xFE03F80;
              k = j;
              i = m;
              if (b < 0) {
                int n = m + 1;
                k = j;
                i = n;
                if (arrayOfByte[m] < 0) {
                  m = n + 1;
                  k = j;
                  i = m;
                  if (arrayOfByte[n] < 0) {
                    n = m + 1;
                    k = j;
                    i = n;
                    if (arrayOfByte[m] < 0) {
                      m = n + 1;
                      k = j;
                      i = m;
                      if (arrayOfByte[n] < 0) {
                        i = m + 1;
                        if (arrayOfByte[m] >= 0) {
                          k = j;
                        } else {
                          throw InvalidProtocolBufferException.malformedVarint();
                        } 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
        this.pos = i;
        return k;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    private long readVarint64SlowPath() throws IOException {
      long l = 0L;
      for (int i = 0; i < 64; i += 7) {
        byte b = readByte();
        l |= (b & Byte.MAX_VALUE) << i;
        if ((b & 0x80) == 0)
          return l; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    private void requireBytes(int param1Int) throws IOException {
      if (param1Int >= 0 && param1Int <= this.limit - this.pos)
        return; 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    private void requirePosition(int param1Int) throws IOException {
      if (this.pos == param1Int)
        return; 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    private void requireWireType(int param1Int) throws IOException {
      if (WireFormat.getTagWireType(this.tag) == param1Int)
        return; 
      throw InvalidProtocolBufferException.invalidWireType();
    }
    
    private void skipBytes(int param1Int) throws IOException {
      requireBytes(param1Int);
      this.pos += param1Int;
    }
    
    private void skipGroup() throws IOException {
      int i = this.endGroupTag;
      this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
      do {
      
      } while (getFieldNumber() != Integer.MAX_VALUE && skipField());
      if (this.tag == this.endGroupTag) {
        this.endGroupTag = i;
        return;
      } 
      throw InvalidProtocolBufferException.parseFailure();
    }
    
    private void skipVarint() throws IOException {
      int j = this.limit;
      int i = this.pos;
      if (j - i >= 10) {
        byte[] arrayOfByte = this.buffer;
        j = 0;
        while (j < 10) {
          int k = i + 1;
          if (arrayOfByte[i] >= 0) {
            this.pos = k;
            return;
          } 
          j++;
          i = k;
        } 
      } 
      skipVarintSlowPath();
    }
    
    private void skipVarintSlowPath() throws IOException {
      for (int i = 0; i < 10; i++) {
        if (readByte() >= 0)
          return; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    private void verifyPackedFixed32Length(int param1Int) throws IOException {
      requireBytes(param1Int);
      if ((param1Int & 0x3) == 0)
        return; 
      throw InvalidProtocolBufferException.parseFailure();
    }
    
    private void verifyPackedFixed64Length(int param1Int) throws IOException {
      requireBytes(param1Int);
      if ((param1Int & 0x7) == 0)
        return; 
      throw InvalidProtocolBufferException.parseFailure();
    }
    
    public int getFieldNumber() throws IOException {
      if (isAtEnd())
        return Integer.MAX_VALUE; 
      this.tag = readVarint32();
      int i = this.tag;
      return (i == this.endGroupTag) ? Integer.MAX_VALUE : WireFormat.getTagFieldNumber(i);
    }
    
    public int getTag() {
      return this.tag;
    }
    
    public int getTotalBytesRead() {
      return this.pos - this.initialPos;
    }
    
    public boolean readBool() throws IOException {
      boolean bool = false;
      requireWireType(0);
      if (readVarint32() != 0)
        bool = true; 
      return bool;
    }
    
    public void readBoolList(List<Boolean> param1List) throws IOException {
      if (param1List instanceof BooleanArrayList) {
        param1List = param1List;
        int j = WireFormat.getTagWireType(this.tag);
        if (j != 0) {
          if (j == 2) {
            j = readVarint32();
            j = this.pos + j;
            while (this.pos < j) {
              boolean bool;
              if (readVarint32() != 0) {
                bool = true;
              } else {
                bool = false;
              } 
              param1List.addBoolean(bool);
            } 
            requirePosition(j);
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.addBoolean(readBool());
          if (isAtEnd())
            return; 
          j = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = j;
            return;
          } 
        } 
      } 
      int i = WireFormat.getTagWireType(this.tag);
      if (i != 0) {
        if (i == 2) {
          i = readVarint32();
          i = this.pos + i;
          while (this.pos < i) {
            boolean bool;
            if (readVarint32() != 0) {
              bool = true;
            } else {
              bool = false;
            } 
            param1List.add(Boolean.valueOf(bool));
          } 
          requirePosition(i);
          return;
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        param1List.add(Boolean.valueOf(readBool()));
        if (isAtEnd())
          return; 
        i = this.pos;
        if (readVarint32() != this.tag) {
          this.pos = i;
          return;
        } 
      } 
    }
    
    public ByteString readBytes() throws IOException {
      ByteString byteString;
      requireWireType(2);
      int i = readVarint32();
      if (i == 0)
        return ByteString.EMPTY; 
      requireBytes(i);
      if (this.bufferIsImmutable) {
        byteString = ByteString.wrap(this.buffer, this.pos, i);
      } else {
        byteString = ByteString.copyFrom(this.buffer, this.pos, i);
      } 
      this.pos += i;
      return byteString;
    }
    
    public void readBytesList(List<ByteString> param1List) throws IOException {
      if (WireFormat.getTagWireType(this.tag) == 2)
        while (true) {
          param1List.add(readBytes());
          if (isAtEnd())
            return; 
          int i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        }  
      throw InvalidProtocolBufferException.invalidWireType();
    }
    
    public double readDouble() throws IOException {
      requireWireType(1);
      return Double.longBitsToDouble(readLittleEndian64());
    }
    
    public void readDoubleList(List<Double> param1List) throws IOException {
      if (param1List instanceof DoubleArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 1) {
          if (i == 2) {
            i = readVarint32();
            verifyPackedFixed64Length(i);
            int j = this.pos;
            while (this.pos < j + i)
              param1List.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck())); 
          } else {
            throw InvalidProtocolBufferException.invalidWireType();
          } 
        } else {
          while (true) {
            param1List.addDouble(readDouble());
            if (isAtEnd())
              return; 
            i = this.pos;
            if (readVarint32() != this.tag) {
              this.pos = i;
              return;
            } 
          } 
        } 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 1) {
          if (i == 2) {
            i = readVarint32();
            verifyPackedFixed64Length(i);
            int j = this.pos;
            while (this.pos < j + i)
              param1List.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck()))); 
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.add(Double.valueOf(readDouble()));
          if (isAtEnd())
            return; 
          i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        } 
      } 
    }
    
    public int readEnum() throws IOException {
      requireWireType(0);
      return readVarint32();
    }
    
    public void readEnumList(List<Integer> param1List) throws IOException {
      if (param1List instanceof IntArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 0) {
          if (i == 2) {
            i = readVarint32();
            int j = this.pos;
            while (this.pos < j + i)
              param1List.addInt(readVarint32()); 
          } else {
            throw InvalidProtocolBufferException.invalidWireType();
          } 
        } else {
          while (true) {
            param1List.addInt(readEnum());
            if (isAtEnd())
              return; 
            i = this.pos;
            if (readVarint32() != this.tag) {
              this.pos = i;
              return;
            } 
          } 
        } 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 0) {
          if (i == 2) {
            i = readVarint32();
            int j = this.pos;
            while (this.pos < j + i)
              param1List.add(Integer.valueOf(readVarint32())); 
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.add(Integer.valueOf(readEnum()));
          if (isAtEnd())
            return; 
          i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        } 
      } 
    }
    
    public int readFixed32() throws IOException {
      requireWireType(5);
      return readLittleEndian32();
    }
    
    public void readFixed32List(List<Integer> param1List) throws IOException {
      if (param1List instanceof IntArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 2) {
          if (i == 5)
            while (true) {
              param1List.addInt(readFixed32());
              if (isAtEnd())
                return; 
              i = this.pos;
              if (readVarint32() != this.tag) {
                this.pos = i;
                return;
              } 
            }  
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        i = readVarint32();
        verifyPackedFixed32Length(i);
        int j = this.pos;
        while (this.pos < j + i)
          param1List.addInt(readLittleEndian32_NoCheck()); 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 2) {
          if (i == 5)
            while (true) {
              param1List.add(Integer.valueOf(readFixed32()));
              if (isAtEnd())
                return; 
              i = this.pos;
              if (readVarint32() != this.tag) {
                this.pos = i;
                return;
              } 
            }  
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        i = readVarint32();
        verifyPackedFixed32Length(i);
        int j = this.pos;
        while (this.pos < j + i)
          param1List.add(Integer.valueOf(readLittleEndian32_NoCheck())); 
      } 
    }
    
    public long readFixed64() throws IOException {
      requireWireType(1);
      return readLittleEndian64();
    }
    
    public void readFixed64List(List<Long> param1List) throws IOException {
      if (param1List instanceof LongArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 1) {
          if (i == 2) {
            i = readVarint32();
            verifyPackedFixed64Length(i);
            int j = this.pos;
            while (this.pos < j + i)
              param1List.addLong(readLittleEndian64_NoCheck()); 
          } else {
            throw InvalidProtocolBufferException.invalidWireType();
          } 
        } else {
          while (true) {
            param1List.addLong(readFixed64());
            if (isAtEnd())
              return; 
            i = this.pos;
            if (readVarint32() != this.tag) {
              this.pos = i;
              return;
            } 
          } 
        } 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 1) {
          if (i == 2) {
            i = readVarint32();
            verifyPackedFixed64Length(i);
            int j = this.pos;
            while (this.pos < j + i)
              param1List.add(Long.valueOf(readLittleEndian64_NoCheck())); 
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.add(Long.valueOf(readFixed64()));
          if (isAtEnd())
            return; 
          i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        } 
      } 
    }
    
    public float readFloat() throws IOException {
      requireWireType(5);
      return Float.intBitsToFloat(readLittleEndian32());
    }
    
    public void readFloatList(List<Float> param1List) throws IOException {
      if (param1List instanceof FloatArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 2) {
          if (i == 5)
            while (true) {
              param1List.addFloat(readFloat());
              if (isAtEnd())
                return; 
              i = this.pos;
              if (readVarint32() != this.tag) {
                this.pos = i;
                return;
              } 
            }  
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        i = readVarint32();
        verifyPackedFixed32Length(i);
        int j = this.pos;
        while (this.pos < j + i)
          param1List.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck())); 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 2) {
          if (i == 5)
            while (true) {
              param1List.add(Float.valueOf(readFloat()));
              if (isAtEnd())
                return; 
              i = this.pos;
              if (readVarint32() != this.tag) {
                this.pos = i;
                return;
              } 
            }  
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        i = readVarint32();
        verifyPackedFixed32Length(i);
        int j = this.pos;
        while (this.pos < j + i)
          param1List.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck()))); 
      } 
    }
    
    public <T> T readGroup(Class<T> param1Class, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      requireWireType(3);
      return readGroup(Protobuf.getInstance().schemaFor(param1Class), param1ExtensionRegistryLite);
    }
    
    public <T> T readGroupBySchemaWithCheck(Schema<T> param1Schema, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      requireWireType(3);
      return readGroup(param1Schema, param1ExtensionRegistryLite);
    }
    
    public <T> void readGroupList(List<T> param1List, Schema<T> param1Schema, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (WireFormat.getTagWireType(this.tag) == 3) {
        int i = this.tag;
        while (true) {
          param1List.add(readGroup(param1Schema, param1ExtensionRegistryLite));
          if (isAtEnd())
            return; 
          int j = this.pos;
          if (readVarint32() != i) {
            this.pos = j;
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    }
    
    public <T> void readGroupList(List<T> param1List, Class<T> param1Class, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      readGroupList(param1List, Protobuf.getInstance().schemaFor(param1Class), param1ExtensionRegistryLite);
    }
    
    public int readInt32() throws IOException {
      requireWireType(0);
      return readVarint32();
    }
    
    public void readInt32List(List<Integer> param1List) throws IOException {
      if (param1List instanceof IntArrayList) {
        param1List = param1List;
        int j = WireFormat.getTagWireType(this.tag);
        if (j != 0) {
          if (j == 2) {
            j = readVarint32();
            j = this.pos + j;
            while (this.pos < j)
              param1List.addInt(readVarint32()); 
            requirePosition(j);
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.addInt(readInt32());
          if (isAtEnd())
            return; 
          j = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = j;
            return;
          } 
        } 
      } 
      int i = WireFormat.getTagWireType(this.tag);
      if (i != 0) {
        if (i == 2) {
          i = readVarint32();
          i = this.pos + i;
          while (this.pos < i)
            param1List.add(Integer.valueOf(readVarint32())); 
          requirePosition(i);
          return;
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        param1List.add(Integer.valueOf(readInt32()));
        if (isAtEnd())
          return; 
        i = this.pos;
        if (readVarint32() != this.tag) {
          this.pos = i;
          return;
        } 
      } 
    }
    
    public long readInt64() throws IOException {
      requireWireType(0);
      return readVarint64();
    }
    
    public void readInt64List(List<Long> param1List) throws IOException {
      if (param1List instanceof LongArrayList) {
        param1List = param1List;
        int j = WireFormat.getTagWireType(this.tag);
        if (j != 0) {
          if (j == 2) {
            j = readVarint32();
            j = this.pos + j;
            while (this.pos < j)
              param1List.addLong(readVarint64()); 
            requirePosition(j);
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.addLong(readInt64());
          if (isAtEnd())
            return; 
          j = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = j;
            return;
          } 
        } 
      } 
      int i = WireFormat.getTagWireType(this.tag);
      if (i != 0) {
        if (i == 2) {
          i = readVarint32();
          i = this.pos + i;
          while (this.pos < i)
            param1List.add(Long.valueOf(readVarint64())); 
          requirePosition(i);
          return;
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        param1List.add(Long.valueOf(readInt64()));
        if (isAtEnd())
          return; 
        i = this.pos;
        if (readVarint32() != this.tag) {
          this.pos = i;
          return;
        } 
      } 
    }
    
    public <K, V> void readMap(Map<K, V> param1Map, MapEntryLite.Metadata<K, V> param1Metadata, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      requireWireType(2);
      int j = readVarint32();
      requireBytes(j);
      int i = this.limit;
      this.limit = this.pos + j;
      try {
        K k = param1Metadata.defaultKey;
        V v = param1Metadata.defaultValue;
        while (true) {
          j = getFieldNumber();
          if (j == Integer.MAX_VALUE) {
            param1Map.put(k, v);
            return;
          } 
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
            Object object1 = readField(param1Metadata.valueType, param1Metadata.defaultValue.getClass(), param1ExtensionRegistryLite);
            v = (V)object1;
            continue;
          } 
          Object object = readField(param1Metadata.keyType, null, null);
          k = (K)object;
        } 
      } finally {
        this.limit = i;
      } 
    }
    
    public <T> T readMessage(Class<T> param1Class, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      requireWireType(2);
      return readMessage(Protobuf.getInstance().schemaFor(param1Class), param1ExtensionRegistryLite);
    }
    
    public <T> T readMessageBySchemaWithCheck(Schema<T> param1Schema, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      requireWireType(2);
      return readMessage(param1Schema, param1ExtensionRegistryLite);
    }
    
    public <T> void readMessageList(List<T> param1List, Schema<T> param1Schema, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (WireFormat.getTagWireType(this.tag) == 2) {
        int i = this.tag;
        while (true) {
          param1List.add(readMessage(param1Schema, param1ExtensionRegistryLite));
          if (isAtEnd())
            return; 
          int j = this.pos;
          if (readVarint32() != i) {
            this.pos = j;
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    }
    
    public <T> void readMessageList(List<T> param1List, Class<T> param1Class, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      readMessageList(param1List, Protobuf.getInstance().schemaFor(param1Class), param1ExtensionRegistryLite);
    }
    
    public int readSFixed32() throws IOException {
      requireWireType(5);
      return readLittleEndian32();
    }
    
    public void readSFixed32List(List<Integer> param1List) throws IOException {
      if (param1List instanceof IntArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 2) {
          if (i == 5)
            while (true) {
              param1List.addInt(readSFixed32());
              if (isAtEnd())
                return; 
              i = this.pos;
              if (readVarint32() != this.tag) {
                this.pos = i;
                return;
              } 
            }  
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        i = readVarint32();
        verifyPackedFixed32Length(i);
        int j = this.pos;
        while (this.pos < j + i)
          param1List.addInt(readLittleEndian32_NoCheck()); 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 2) {
          if (i == 5)
            while (true) {
              param1List.add(Integer.valueOf(readSFixed32()));
              if (isAtEnd())
                return; 
              i = this.pos;
              if (readVarint32() != this.tag) {
                this.pos = i;
                return;
              } 
            }  
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        i = readVarint32();
        verifyPackedFixed32Length(i);
        int j = this.pos;
        while (this.pos < j + i)
          param1List.add(Integer.valueOf(readLittleEndian32_NoCheck())); 
      } 
    }
    
    public long readSFixed64() throws IOException {
      requireWireType(1);
      return readLittleEndian64();
    }
    
    public void readSFixed64List(List<Long> param1List) throws IOException {
      if (param1List instanceof LongArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 1) {
          if (i == 2) {
            i = readVarint32();
            verifyPackedFixed64Length(i);
            int j = this.pos;
            while (this.pos < j + i)
              param1List.addLong(readLittleEndian64_NoCheck()); 
          } else {
            throw InvalidProtocolBufferException.invalidWireType();
          } 
        } else {
          while (true) {
            param1List.addLong(readSFixed64());
            if (isAtEnd())
              return; 
            i = this.pos;
            if (readVarint32() != this.tag) {
              this.pos = i;
              return;
            } 
          } 
        } 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 1) {
          if (i == 2) {
            i = readVarint32();
            verifyPackedFixed64Length(i);
            int j = this.pos;
            while (this.pos < j + i)
              param1List.add(Long.valueOf(readLittleEndian64_NoCheck())); 
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.add(Long.valueOf(readSFixed64()));
          if (isAtEnd())
            return; 
          i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        } 
      } 
    }
    
    public int readSInt32() throws IOException {
      requireWireType(0);
      return CodedInputStream.decodeZigZag32(readVarint32());
    }
    
    public void readSInt32List(List<Integer> param1List) throws IOException {
      if (param1List instanceof IntArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 0) {
          if (i == 2) {
            i = readVarint32();
            int j = this.pos;
            while (this.pos < j + i)
              param1List.addInt(CodedInputStream.decodeZigZag32(readVarint32())); 
          } else {
            throw InvalidProtocolBufferException.invalidWireType();
          } 
        } else {
          while (true) {
            param1List.addInt(readSInt32());
            if (isAtEnd())
              return; 
            i = this.pos;
            if (readVarint32() != this.tag) {
              this.pos = i;
              return;
            } 
          } 
        } 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 0) {
          if (i == 2) {
            i = readVarint32();
            int j = this.pos;
            while (this.pos < j + i)
              param1List.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32()))); 
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.add(Integer.valueOf(readSInt32()));
          if (isAtEnd())
            return; 
          i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        } 
      } 
    }
    
    public long readSInt64() throws IOException {
      requireWireType(0);
      return CodedInputStream.decodeZigZag64(readVarint64());
    }
    
    public void readSInt64List(List<Long> param1List) throws IOException {
      if (param1List instanceof LongArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 0) {
          if (i == 2) {
            i = readVarint32();
            int j = this.pos;
            while (this.pos < j + i)
              param1List.addLong(CodedInputStream.decodeZigZag64(readVarint64())); 
          } else {
            throw InvalidProtocolBufferException.invalidWireType();
          } 
        } else {
          while (true) {
            param1List.addLong(readSInt64());
            if (isAtEnd())
              return; 
            i = this.pos;
            if (readVarint32() != this.tag) {
              this.pos = i;
              return;
            } 
          } 
        } 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 0) {
          if (i == 2) {
            i = readVarint32();
            int j = this.pos;
            while (this.pos < j + i)
              param1List.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64()))); 
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.add(Long.valueOf(readSInt64()));
          if (isAtEnd())
            return; 
          i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        } 
      } 
    }
    
    public String readString() throws IOException {
      return readStringInternal(false);
    }
    
    public String readStringInternal(boolean param1Boolean) throws IOException {
      requireWireType(2);
      int i = readVarint32();
      if (i == 0)
        return ""; 
      requireBytes(i);
      if (param1Boolean) {
        byte[] arrayOfByte = this.buffer;
        int j = this.pos;
        if (!Utf8.isValidUtf8(arrayOfByte, j, j + i))
          throw InvalidProtocolBufferException.invalidUtf8(); 
      } 
      String str = new String(this.buffer, this.pos, i, Internal.UTF_8);
      this.pos += i;
      return str;
    }
    
    public void readStringList(List<String> param1List) throws IOException {
      readStringListInternal(param1List, false);
    }
    
    public void readStringListInternal(List<String> param1List, boolean param1Boolean) throws IOException {
      if (WireFormat.getTagWireType(this.tag) == 2) {
        if (param1List instanceof LazyStringList && !param1Boolean) {
          param1List = param1List;
          while (true) {
            param1List.add(readBytes());
            if (isAtEnd())
              return; 
            int i = this.pos;
            if (readVarint32() != this.tag) {
              this.pos = i;
              return;
            } 
          } 
        } 
        while (true) {
          param1List.add(readStringInternal(param1Boolean));
          if (isAtEnd())
            return; 
          int i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        } 
      } 
      throw InvalidProtocolBufferException.invalidWireType();
    }
    
    public void readStringListRequireUtf8(List<String> param1List) throws IOException {
      readStringListInternal(param1List, true);
    }
    
    public String readStringRequireUtf8() throws IOException {
      return readStringInternal(true);
    }
    
    public int readUInt32() throws IOException {
      requireWireType(0);
      return readVarint32();
    }
    
    public void readUInt32List(List<Integer> param1List) throws IOException {
      if (param1List instanceof IntArrayList) {
        param1List = param1List;
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 0) {
          if (i == 2) {
            i = readVarint32();
            int j = this.pos;
            while (this.pos < j + i)
              param1List.addInt(readVarint32()); 
          } else {
            throw InvalidProtocolBufferException.invalidWireType();
          } 
        } else {
          while (true) {
            param1List.addInt(readUInt32());
            if (isAtEnd())
              return; 
            i = this.pos;
            if (readVarint32() != this.tag) {
              this.pos = i;
              return;
            } 
          } 
        } 
      } else {
        int i = WireFormat.getTagWireType(this.tag);
        if (i != 0) {
          if (i == 2) {
            i = readVarint32();
            int j = this.pos;
            while (this.pos < j + i)
              param1List.add(Integer.valueOf(readVarint32())); 
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.add(Integer.valueOf(readUInt32()));
          if (isAtEnd())
            return; 
          i = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = i;
            return;
          } 
        } 
      } 
    }
    
    public long readUInt64() throws IOException {
      requireWireType(0);
      return readVarint64();
    }
    
    public void readUInt64List(List<Long> param1List) throws IOException {
      if (param1List instanceof LongArrayList) {
        param1List = param1List;
        int j = WireFormat.getTagWireType(this.tag);
        if (j != 0) {
          if (j == 2) {
            j = readVarint32();
            j = this.pos + j;
            while (this.pos < j)
              param1List.addLong(readVarint64()); 
            requirePosition(j);
            return;
          } 
          throw InvalidProtocolBufferException.invalidWireType();
        } 
        while (true) {
          param1List.addLong(readUInt64());
          if (isAtEnd())
            return; 
          j = this.pos;
          if (readVarint32() != this.tag) {
            this.pos = j;
            return;
          } 
        } 
      } 
      int i = WireFormat.getTagWireType(this.tag);
      if (i != 0) {
        if (i == 2) {
          i = readVarint32();
          i = this.pos + i;
          while (this.pos < i)
            param1List.add(Long.valueOf(readVarint64())); 
          requirePosition(i);
          return;
        } 
        throw InvalidProtocolBufferException.invalidWireType();
      } 
      while (true) {
        param1List.add(Long.valueOf(readUInt64()));
        if (isAtEnd())
          return; 
        i = this.pos;
        if (readVarint32() != this.tag) {
          this.pos = i;
          return;
        } 
      } 
    }
    
    public long readVarint64() throws IOException {
      int j;
      int k = this.pos;
      int i = this.limit;
      if (i != k) {
        byte[] arrayOfByte = this.buffer;
        j = k + 1;
        k = arrayOfByte[k];
        if (k >= 0) {
          this.pos = j;
          return k;
        } 
        if (i - j < 9)
          return readVarint64SlowPath(); 
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0) {
          j = k ^ 0xFFFFFF80;
        } else {
          long l1;
          j = i + 1;
          k ^= arrayOfByte[i] << 14;
          if (k >= 0) {
            l1 = (k ^ 0x3F80);
            i = j;
          } else {
            i = j + 1;
            j = k ^ arrayOfByte[j] << 21;
            if (j < 0) {
              j ^= 0xFFE03F80;
            } else {
              long l2 = j;
              j = i + 1;
              long l3 = l2 ^ arrayOfByte[i] << 28L;
              if (l3 >= 0L) {
                l2 = 266354560L;
                i = j;
              } else {
                i = j + 1;
                l2 = l3 ^ arrayOfByte[j] << 35L;
                if (l2 < 0L) {
                  l3 = -34093383808L;
                } else {
                  j = i + 1;
                  l3 = l2 ^ arrayOfByte[i] << 42L;
                  if (l3 >= 0L) {
                    l2 = 4363953127296L;
                    i = j;
                  } else {
                    i = j + 1;
                    l2 = l3 ^ arrayOfByte[j] << 49L;
                    if (l2 < 0L) {
                      l3 = -558586000294016L;
                    } else {
                      j = i + 1;
                      l2 = l2 ^ arrayOfByte[i] << 56L ^ 0xFE03F80FE03F80L;
                      if (l2 < 0L) {
                        i = j + 1;
                        if (arrayOfByte[j] < 0L)
                          throw InvalidProtocolBufferException.malformedVarint(); 
                      } else {
                        i = j;
                      } 
                      this.pos = i;
                      return l2;
                    } 
                    l2 ^= l3;
                  } 
                  l2 = l3 ^ l2;
                } 
                l2 ^= l3;
              } 
              l2 = l3 ^ l2;
            } 
            l1 = j;
          } 
          this.pos = i;
          return l1;
        } 
      } else {
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      long l = j;
    }
    
    public boolean skipField() throws IOException {
      if (!isAtEnd()) {
        int i = this.tag;
        if (i != this.endGroupTag) {
          i = WireFormat.getTagWireType(i);
          if (i != 0) {
            if (i != 1) {
              if (i != 2) {
                if (i != 3) {
                  if (i == 5) {
                    skipBytes(4);
                    return true;
                  } 
                  throw InvalidProtocolBufferException.invalidWireType();
                } 
                skipGroup();
                return true;
              } 
              skipBytes(readVarint32());
              return true;
            } 
            skipBytes(8);
            return true;
          } 
          skipVarint();
          return true;
        } 
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\BinaryReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */