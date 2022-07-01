package com.google.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class CodedInputStream {
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  
  private static final int DEFAULT_RECURSION_LIMIT = 100;
  
  private static final int DEFAULT_SIZE_LIMIT = 2147483647;
  
  int recursionDepth;
  
  int recursionLimit = 100;
  
  private boolean shouldDiscardUnknownFields = false;
  
  int sizeLimit = Integer.MAX_VALUE;
  
  CodedInputStreamReader wrapper;
  
  private CodedInputStream() {}
  
  public static int decodeZigZag32(int paramInt) {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public static long decodeZigZag64(long paramLong) {
    return -(paramLong & 0x1L) ^ paramLong >>> 1L;
  }
  
  public static CodedInputStream newInstance(InputStream paramInputStream) {
    return newInstance(paramInputStream, 4096);
  }
  
  public static CodedInputStream newInstance(InputStream paramInputStream, int paramInt) {
    if (paramInt > 0)
      return (paramInputStream == null) ? newInstance(Internal.EMPTY_BYTE_ARRAY) : new StreamDecoder(paramInputStream, paramInt); 
    throw new IllegalArgumentException("bufferSize must be > 0");
  }
  
  public static CodedInputStream newInstance(Iterable<ByteBuffer> paramIterable) {
    return !UnsafeDirectNioDecoder.isSupported() ? newInstance(new IterableByteBufferInputStream(paramIterable)) : newInstance(paramIterable, false);
  }
  
  static CodedInputStream newInstance(Iterable<ByteBuffer> paramIterable, boolean paramBoolean) {
    Iterator<ByteBuffer> iterator = paramIterable.iterator();
    int i = 0;
    int j = 0;
    while (iterator.hasNext()) {
      ByteBuffer byteBuffer = iterator.next();
      j += byteBuffer.remaining();
      if (byteBuffer.hasArray()) {
        i |= 0x1;
        continue;
      } 
      if (byteBuffer.isDirect()) {
        i |= 0x2;
        continue;
      } 
      i |= 0x4;
    } 
    return (i == 2) ? new IterableDirectByteBufferDecoder(paramIterable, j, paramBoolean) : newInstance(new IterableByteBufferInputStream(paramIterable));
  }
  
  public static CodedInputStream newInstance(ByteBuffer paramByteBuffer) {
    return newInstance(paramByteBuffer, false);
  }
  
  static CodedInputStream newInstance(ByteBuffer paramByteBuffer, boolean paramBoolean) {
    if (paramByteBuffer.hasArray())
      return newInstance(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining(), paramBoolean); 
    if (paramByteBuffer.isDirect() && UnsafeDirectNioDecoder.isSupported())
      return new UnsafeDirectNioDecoder(paramByteBuffer, paramBoolean); 
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.duplicate().get(arrayOfByte);
    return newInstance(arrayOfByte, 0, arrayOfByte.length, true);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfbyte) {
    return newInstance(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static CodedInputStream newInstance(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return newInstance(paramArrayOfbyte, paramInt1, paramInt2, false);
  }
  
  static CodedInputStream newInstance(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    ArrayDecoder arrayDecoder = new ArrayDecoder(paramArrayOfbyte, paramInt1, paramInt2, paramBoolean);
    try {
      arrayDecoder.pushLimit(paramInt2);
      return arrayDecoder;
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw new IllegalArgumentException(invalidProtocolBufferException);
    } 
  }
  
  public static int readRawVarint32(int paramInt, InputStream paramInputStream) throws IOException {
    int j;
    if ((paramInt & 0x80) == 0)
      return paramInt; 
    int i = paramInt & 0x7F;
    paramInt = 7;
    while (true) {
      j = paramInt;
      if (paramInt < 32) {
        j = paramInputStream.read();
        if (j != -1) {
          i |= (j & 0x7F) << paramInt;
          if ((j & 0x80) == 0)
            return i; 
          paramInt += 7;
          continue;
        } 
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      break;
    } 
    while (j < 64) {
      paramInt = paramInputStream.read();
      if (paramInt != -1) {
        if ((paramInt & 0x80) == 0)
          return i; 
        j += 7;
        continue;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    } 
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  static int readRawVarint32(InputStream paramInputStream) throws IOException {
    int i = paramInputStream.read();
    if (i != -1)
      return readRawVarint32(i, paramInputStream); 
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public abstract void checkLastTagWas(int paramInt) throws InvalidProtocolBufferException;
  
  final void discardUnknownFields() {
    this.shouldDiscardUnknownFields = true;
  }
  
  public abstract void enableAliasing(boolean paramBoolean);
  
  public abstract int getBytesUntilLimit();
  
  public abstract int getLastTag();
  
  public abstract int getTotalBytesRead();
  
  public abstract boolean isAtEnd() throws IOException;
  
  public abstract void popLimit(int paramInt);
  
  public abstract int pushLimit(int paramInt) throws InvalidProtocolBufferException;
  
  public abstract boolean readBool() throws IOException;
  
  public abstract byte[] readByteArray() throws IOException;
  
  public abstract ByteBuffer readByteBuffer() throws IOException;
  
  public abstract ByteString readBytes() throws IOException;
  
  public abstract double readDouble() throws IOException;
  
  public abstract int readEnum() throws IOException;
  
  public abstract int readFixed32() throws IOException;
  
  public abstract long readFixed64() throws IOException;
  
  public abstract float readFloat() throws IOException;
  
  public abstract <T extends MessageLite> T readGroup(int paramInt, Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  public abstract void readGroup(int paramInt, MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  public abstract int readInt32() throws IOException;
  
  public abstract long readInt64() throws IOException;
  
  public abstract <T extends MessageLite> T readMessage(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  public abstract void readMessage(MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  public abstract byte readRawByte() throws IOException;
  
  public abstract byte[] readRawBytes(int paramInt) throws IOException;
  
  public abstract int readRawLittleEndian32() throws IOException;
  
  public abstract long readRawLittleEndian64() throws IOException;
  
  public abstract int readRawVarint32() throws IOException;
  
  public abstract long readRawVarint64() throws IOException;
  
  abstract long readRawVarint64SlowPath() throws IOException;
  
  public abstract int readSFixed32() throws IOException;
  
  public abstract long readSFixed64() throws IOException;
  
  public abstract int readSInt32() throws IOException;
  
  public abstract long readSInt64() throws IOException;
  
  public abstract String readString() throws IOException;
  
  public abstract String readStringRequireUtf8() throws IOException;
  
  public abstract int readTag() throws IOException;
  
  public abstract int readUInt32() throws IOException;
  
  public abstract long readUInt64() throws IOException;
  
  @Deprecated
  public abstract void readUnknownGroup(int paramInt, MessageLite.Builder paramBuilder) throws IOException;
  
  public abstract void resetSizeCounter();
  
  public final int setRecursionLimit(int paramInt) {
    if (paramInt >= 0) {
      int i = this.recursionLimit;
      this.recursionLimit = paramInt;
      return i;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Recursion limit cannot be negative: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final int setSizeLimit(int paramInt) {
    if (paramInt >= 0) {
      int i = this.sizeLimit;
      this.sizeLimit = paramInt;
      return i;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Size limit cannot be negative: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  final boolean shouldDiscardUnknownFields() {
    return this.shouldDiscardUnknownFields;
  }
  
  public abstract boolean skipField(int paramInt) throws IOException;
  
  @Deprecated
  public abstract boolean skipField(int paramInt, CodedOutputStream paramCodedOutputStream) throws IOException;
  
  public abstract void skipMessage() throws IOException;
  
  public abstract void skipMessage(CodedOutputStream paramCodedOutputStream) throws IOException;
  
  public abstract void skipRawBytes(int paramInt) throws IOException;
  
  final void unsetDiscardUnknownFields() {
    this.shouldDiscardUnknownFields = false;
  }
  
  static final class ArrayDecoder extends CodedInputStream {
    private final byte[] buffer;
    
    private int bufferSizeAfterLimit;
    
    private int currentLimit = Integer.MAX_VALUE;
    
    private boolean enableAliasing;
    
    private final boolean immutable;
    
    private int lastTag;
    
    private int limit;
    
    private int pos;
    
    private int startPos;
    
    private ArrayDecoder(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      this.buffer = param1ArrayOfbyte;
      this.limit = param1Int2 + param1Int1;
      this.pos = param1Int1;
      this.startPos = this.pos;
      this.immutable = param1Boolean;
    }
    
    private void recomputeBufferSizeAfterLimit() {
      this.limit += this.bufferSizeAfterLimit;
      int i = this.limit;
      int j = i - this.startPos;
      int k = this.currentLimit;
      if (j > k) {
        this.bufferSizeAfterLimit = j - k;
        this.limit = i - this.bufferSizeAfterLimit;
        return;
      } 
      this.bufferSizeAfterLimit = 0;
    }
    
    private void skipRawVarint() throws IOException {
      if (this.limit - this.pos >= 10) {
        skipRawVarintFastPath();
        return;
      } 
      skipRawVarintSlowPath();
    }
    
    private void skipRawVarintFastPath() throws IOException {
      for (int i = 0; i < 10; i++) {
        byte[] arrayOfByte = this.buffer;
        int j = this.pos;
        this.pos = j + 1;
        if (arrayOfByte[j] >= 0)
          return; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    private void skipRawVarintSlowPath() throws IOException {
      for (int i = 0; i < 10; i++) {
        if (readRawByte() >= 0)
          return; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    public void checkLastTagWas(int param1Int) throws InvalidProtocolBufferException {
      if (this.lastTag == param1Int)
        return; 
      throw InvalidProtocolBufferException.invalidEndTag();
    }
    
    public void enableAliasing(boolean param1Boolean) {
      this.enableAliasing = param1Boolean;
    }
    
    public int getBytesUntilLimit() {
      int i = this.currentLimit;
      return (i == Integer.MAX_VALUE) ? -1 : (i - getTotalBytesRead());
    }
    
    public int getLastTag() {
      return this.lastTag;
    }
    
    public int getTotalBytesRead() {
      return this.pos - this.startPos;
    }
    
    public boolean isAtEnd() throws IOException {
      return (this.pos == this.limit);
    }
    
    public void popLimit(int param1Int) {
      this.currentLimit = param1Int;
      recomputeBufferSizeAfterLimit();
    }
    
    public int pushLimit(int param1Int) throws InvalidProtocolBufferException {
      if (param1Int >= 0) {
        param1Int += getTotalBytesRead();
        int i = this.currentLimit;
        if (param1Int <= i) {
          this.currentLimit = param1Int;
          recomputeBufferSizeAfterLimit();
          return i;
        } 
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      throw InvalidProtocolBufferException.negativeSize();
    }
    
    public boolean readBool() throws IOException {
      return (readRawVarint64() != 0L);
    }
    
    public byte[] readByteArray() throws IOException {
      return readRawBytes(readRawVarint32());
    }
    
    public ByteBuffer readByteBuffer() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        int j = this.limit;
        int k = this.pos;
        if (i <= j - k) {
          ByteBuffer byteBuffer;
          if (!this.immutable && this.enableAliasing) {
            byteBuffer = ByteBuffer.wrap(this.buffer, k, i).slice();
          } else {
            byte[] arrayOfByte = this.buffer;
            j = this.pos;
            byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(arrayOfByte, j, j + i));
          } 
          this.pos += i;
          return byteBuffer;
        } 
      } 
      if (i == 0)
        return Internal.EMPTY_BYTE_BUFFER; 
      if (i < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public ByteString readBytes() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        int j = this.limit;
        int k = this.pos;
        if (i <= j - k) {
          ByteString byteString;
          if (this.immutable && this.enableAliasing) {
            byteString = ByteString.wrap(this.buffer, k, i);
          } else {
            byteString = ByteString.copyFrom(this.buffer, this.pos, i);
          } 
          this.pos += i;
          return byteString;
        } 
      } 
      return (i == 0) ? ByteString.EMPTY : ByteString.wrap(readRawBytes(i));
    }
    
    public double readDouble() throws IOException {
      return Double.longBitsToDouble(readRawLittleEndian64());
    }
    
    public int readEnum() throws IOException {
      return readRawVarint32();
    }
    
    public int readFixed32() throws IOException {
      return readRawLittleEndian32();
    }
    
    public long readFixed64() throws IOException {
      return readRawLittleEndian64();
    }
    
    public float readFloat() throws IOException {
      return Float.intBitsToFloat(readRawLittleEndian32());
    }
    
    public <T extends MessageLite> T readGroup(int param1Int, Parser<T> param1Parser, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (this.recursionDepth < this.recursionLimit) {
        this.recursionDepth++;
        MessageLite messageLite = (MessageLite)param1Parser.parsePartialFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(param1Int, 4));
        this.recursionDepth--;
        return (T)messageLite;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public void readGroup(int param1Int, MessageLite.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (this.recursionDepth < this.recursionLimit) {
        this.recursionDepth++;
        param1Builder.mergeFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(param1Int, 4));
        this.recursionDepth--;
        return;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public int readInt32() throws IOException {
      return readRawVarint32();
    }
    
    public long readInt64() throws IOException {
      return readRawVarint64();
    }
    
    public <T extends MessageLite> T readMessage(Parser<T> param1Parser, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = readRawVarint32();
      if (this.recursionDepth < this.recursionLimit) {
        i = pushLimit(i);
        this.recursionDepth++;
        MessageLite messageLite = (MessageLite)param1Parser.parsePartialFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(i);
        return (T)messageLite;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public void readMessage(MessageLite.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = readRawVarint32();
      if (this.recursionDepth < this.recursionLimit) {
        i = pushLimit(i);
        this.recursionDepth++;
        param1Builder.mergeFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(i);
        return;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public byte readRawByte() throws IOException {
      int i = this.pos;
      if (i != this.limit) {
        byte[] arrayOfByte = this.buffer;
        this.pos = i + 1;
        return arrayOfByte[i];
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public byte[] readRawBytes(int param1Int) throws IOException {
      if (param1Int > 0) {
        int i = this.limit;
        int j = this.pos;
        if (param1Int <= i - j) {
          this.pos = param1Int + j;
          return Arrays.copyOfRange(this.buffer, j, this.pos);
        } 
      } 
      if (param1Int <= 0) {
        if (param1Int == 0)
          return Internal.EMPTY_BYTE_ARRAY; 
        throw InvalidProtocolBufferException.negativeSize();
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public int readRawLittleEndian32() throws IOException {
      int i = this.pos;
      if (this.limit - i >= 4) {
        byte[] arrayOfByte = this.buffer;
        this.pos = i + 4;
        byte b1 = arrayOfByte[i];
        byte b2 = arrayOfByte[i + 1];
        byte b3 = arrayOfByte[i + 2];
        return (arrayOfByte[i + 3] & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public long readRawLittleEndian64() throws IOException {
      int i = this.pos;
      if (this.limit - i >= 8) {
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
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public int readRawVarint32() throws IOException {
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
        if (i - k >= 9) {
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
                          k = j;
                          if (arrayOfByte[m] < 0)
                            return (int)readRawVarint64SlowPath(); 
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
      } 
      return (int)readRawVarint64SlowPath();
    }
    
    public long readRawVarint64() throws IOException {
      int k = this.pos;
      int i = this.limit;
      if (i == k)
        return readRawVarint64SlowPath(); 
      byte[] arrayOfByte = this.buffer;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0) {
        this.pos = j;
        return k;
      } 
      if (i - j < 9)
        return readRawVarint64SlowPath(); 
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
                        return readRawVarint64SlowPath(); 
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
      long l = j;
    }
    
    long readRawVarint64SlowPath() throws IOException {
      long l = 0L;
      for (int i = 0; i < 64; i += 7) {
        byte b = readRawByte();
        l |= (b & Byte.MAX_VALUE) << i;
        if ((b & 0x80) == 0)
          return l; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    public int readSFixed32() throws IOException {
      return readRawLittleEndian32();
    }
    
    public long readSFixed64() throws IOException {
      return readRawLittleEndian64();
    }
    
    public int readSInt32() throws IOException {
      return decodeZigZag32(readRawVarint32());
    }
    
    public long readSInt64() throws IOException {
      return decodeZigZag64(readRawVarint64());
    }
    
    public String readString() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        int j = this.limit;
        int k = this.pos;
        if (i <= j - k) {
          String str = new String(this.buffer, k, i, Internal.UTF_8);
          this.pos += i;
          return str;
        } 
      } 
      if (i == 0)
        return ""; 
      if (i < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public String readStringRequireUtf8() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        int j = this.limit;
        int k = this.pos;
        if (i <= j - k) {
          String str = Utf8.decodeUtf8(this.buffer, k, i);
          this.pos += i;
          return str;
        } 
      } 
      if (i == 0)
        return ""; 
      if (i <= 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public int readTag() throws IOException {
      if (isAtEnd()) {
        this.lastTag = 0;
        return 0;
      } 
      this.lastTag = readRawVarint32();
      if (WireFormat.getTagFieldNumber(this.lastTag) != 0)
        return this.lastTag; 
      throw InvalidProtocolBufferException.invalidTag();
    }
    
    public int readUInt32() throws IOException {
      return readRawVarint32();
    }
    
    public long readUInt64() throws IOException {
      return readRawVarint64();
    }
    
    @Deprecated
    public void readUnknownGroup(int param1Int, MessageLite.Builder param1Builder) throws IOException {
      readGroup(param1Int, param1Builder, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public void resetSizeCounter() {
      this.startPos = this.pos;
    }
    
    public boolean skipField(int param1Int) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  skipRawBytes(4);
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(param1Int), 4));
            return true;
          } 
          skipRawBytes(readRawVarint32());
          return true;
        } 
        skipRawBytes(8);
        return true;
      } 
      skipRawVarint();
      return true;
    }
    
    public boolean skipField(int param1Int, CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  i = readRawLittleEndian32();
                  param1CodedOutputStream.writeRawVarint32(param1Int);
                  param1CodedOutputStream.writeFixed32NoTag(i);
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            param1CodedOutputStream.writeRawVarint32(param1Int);
            skipMessage(param1CodedOutputStream);
            param1Int = WireFormat.makeTag(WireFormat.getTagFieldNumber(param1Int), 4);
            checkLastTagWas(param1Int);
            param1CodedOutputStream.writeRawVarint32(param1Int);
            return true;
          } 
          ByteString byteString = readBytes();
          param1CodedOutputStream.writeRawVarint32(param1Int);
          param1CodedOutputStream.writeBytesNoTag(byteString);
          return true;
        } 
        long l1 = readRawLittleEndian64();
        param1CodedOutputStream.writeRawVarint32(param1Int);
        param1CodedOutputStream.writeFixed64NoTag(l1);
        return true;
      } 
      long l = readInt64();
      param1CodedOutputStream.writeRawVarint32(param1Int);
      param1CodedOutputStream.writeUInt64NoTag(l);
      return true;
    }
    
    public void skipMessage() throws IOException {
      int i;
      do {
        i = readTag();
      } while (i != 0 && skipField(i));
    }
    
    public void skipMessage(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i;
      do {
        i = readTag();
      } while (i != 0 && skipField(i, param1CodedOutputStream));
    }
    
    public void skipRawBytes(int param1Int) throws IOException {
      if (param1Int >= 0) {
        int i = this.limit;
        int j = this.pos;
        if (param1Int <= i - j) {
          this.pos = j + param1Int;
          return;
        } 
      } 
      if (param1Int < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
  }
  
  static final class IterableDirectByteBufferDecoder extends CodedInputStream {
    private int bufferSizeAfterCurrentLimit;
    
    private long currentAddress;
    
    private ByteBuffer currentByteBuffer;
    
    private long currentByteBufferLimit;
    
    private long currentByteBufferPos;
    
    private long currentByteBufferStartPos;
    
    private int currentLimit = Integer.MAX_VALUE;
    
    private boolean enableAliasing;
    
    private boolean immutable;
    
    private Iterable<ByteBuffer> input;
    
    private Iterator<ByteBuffer> iterator;
    
    private int lastTag;
    
    private int startOffset;
    
    private int totalBufferSize;
    
    private int totalBytesRead;
    
    private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> param1Iterable, int param1Int, boolean param1Boolean) {
      this.totalBufferSize = param1Int;
      this.input = param1Iterable;
      this.iterator = this.input.iterator();
      this.immutable = param1Boolean;
      this.totalBytesRead = 0;
      this.startOffset = 0;
      if (param1Int == 0) {
        this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
        this.currentByteBufferPos = 0L;
        this.currentByteBufferStartPos = 0L;
        this.currentByteBufferLimit = 0L;
        this.currentAddress = 0L;
        return;
      } 
      tryGetNextByteBuffer();
    }
    
    private long currentRemaining() {
      return this.currentByteBufferLimit - this.currentByteBufferPos;
    }
    
    private void getNextByteBuffer() throws InvalidProtocolBufferException {
      if (this.iterator.hasNext()) {
        tryGetNextByteBuffer();
        return;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    private void readRawBytesTo(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      if (param1Int2 >= 0 && param1Int2 <= remaining()) {
        int i = param1Int2;
        while (i > 0) {
          if (currentRemaining() == 0L)
            getNextByteBuffer(); 
          int j = Math.min(i, (int)currentRemaining());
          long l1 = this.currentByteBufferPos;
          long l2 = (param1Int2 - i + param1Int1);
          long l3 = j;
          UnsafeUtil.copyMemory(l1, param1ArrayOfbyte, l2, l3);
          i -= j;
          this.currentByteBufferPos += l3;
        } 
        return;
      } 
      if (param1Int2 <= 0) {
        if (param1Int2 == 0)
          return; 
        throw InvalidProtocolBufferException.negativeSize();
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    private void recomputeBufferSizeAfterLimit() {
      this.totalBufferSize += this.bufferSizeAfterCurrentLimit;
      int i = this.totalBufferSize;
      int j = i - this.startOffset;
      int k = this.currentLimit;
      if (j > k) {
        this.bufferSizeAfterCurrentLimit = j - k;
        this.totalBufferSize = i - this.bufferSizeAfterCurrentLimit;
        return;
      } 
      this.bufferSizeAfterCurrentLimit = 0;
    }
    
    private int remaining() {
      return (int)((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos + this.currentByteBufferStartPos);
    }
    
    private void skipRawVarint() throws IOException {
      for (int i = 0; i < 10; i++) {
        if (readRawByte() >= 0)
          return; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    private ByteBuffer slice(int param1Int1, int param1Int2) throws IOException {
      int i = this.currentByteBuffer.position();
      int j = this.currentByteBuffer.limit();
      try {
        this.currentByteBuffer.position(param1Int1);
        this.currentByteBuffer.limit(param1Int2);
        return this.currentByteBuffer.slice();
      } catch (IllegalArgumentException illegalArgumentException) {
        throw InvalidProtocolBufferException.truncatedMessage();
      } finally {
        this.currentByteBuffer.position(i);
        this.currentByteBuffer.limit(j);
      } 
    }
    
    private void tryGetNextByteBuffer() {
      this.currentByteBuffer = this.iterator.next();
      this.totalBytesRead += (int)(this.currentByteBufferPos - this.currentByteBufferStartPos);
      this.currentByteBufferPos = this.currentByteBuffer.position();
      this.currentByteBufferStartPos = this.currentByteBufferPos;
      this.currentByteBufferLimit = this.currentByteBuffer.limit();
      this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
      long l1 = this.currentByteBufferPos;
      long l2 = this.currentAddress;
      this.currentByteBufferPos = l1 + l2;
      this.currentByteBufferStartPos += l2;
      this.currentByteBufferLimit += l2;
    }
    
    public void checkLastTagWas(int param1Int) throws InvalidProtocolBufferException {
      if (this.lastTag == param1Int)
        return; 
      throw InvalidProtocolBufferException.invalidEndTag();
    }
    
    public void enableAliasing(boolean param1Boolean) {
      this.enableAliasing = param1Boolean;
    }
    
    public int getBytesUntilLimit() {
      int i = this.currentLimit;
      return (i == Integer.MAX_VALUE) ? -1 : (i - getTotalBytesRead());
    }
    
    public int getLastTag() {
      return this.lastTag;
    }
    
    public int getTotalBytesRead() {
      return (int)((this.totalBytesRead - this.startOffset) + this.currentByteBufferPos - this.currentByteBufferStartPos);
    }
    
    public boolean isAtEnd() throws IOException {
      return (this.totalBytesRead + this.currentByteBufferPos - this.currentByteBufferStartPos == this.totalBufferSize);
    }
    
    public void popLimit(int param1Int) {
      this.currentLimit = param1Int;
      recomputeBufferSizeAfterLimit();
    }
    
    public int pushLimit(int param1Int) throws InvalidProtocolBufferException {
      if (param1Int >= 0) {
        param1Int += getTotalBytesRead();
        int i = this.currentLimit;
        if (param1Int <= i) {
          this.currentLimit = param1Int;
          recomputeBufferSizeAfterLimit();
          return i;
        } 
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      throw InvalidProtocolBufferException.negativeSize();
    }
    
    public boolean readBool() throws IOException {
      return (readRawVarint64() != 0L);
    }
    
    public byte[] readByteArray() throws IOException {
      return readRawBytes(readRawVarint32());
    }
    
    public ByteBuffer readByteBuffer() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        long l = i;
        if (l <= currentRemaining()) {
          if (!this.immutable && this.enableAliasing) {
            this.currentByteBufferPos += l;
            long l1 = this.currentByteBufferPos;
            long l2 = this.currentAddress;
            return slice((int)(l1 - l2 - l), (int)(l1 - l2));
          } 
          byte[] arrayOfByte = new byte[i];
          UnsafeUtil.copyMemory(this.currentByteBufferPos, arrayOfByte, 0L, l);
          this.currentByteBufferPos += l;
          return ByteBuffer.wrap(arrayOfByte);
        } 
      } 
      if (i > 0 && i <= remaining()) {
        byte[] arrayOfByte = new byte[i];
        readRawBytesTo(arrayOfByte, 0, i);
        return ByteBuffer.wrap(arrayOfByte);
      } 
      if (i == 0)
        return Internal.EMPTY_BYTE_BUFFER; 
      if (i < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public ByteString readBytes() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        long l1 = i;
        long l2 = this.currentByteBufferLimit;
        long l3 = this.currentByteBufferPos;
        if (l1 <= l2 - l3) {
          if (this.immutable && this.enableAliasing) {
            int j = (int)(l3 - this.currentAddress);
            ByteString byteString = ByteString.wrap(slice(j, i + j));
            this.currentByteBufferPos += l1;
            return byteString;
          } 
          byte[] arrayOfByte = new byte[i];
          UnsafeUtil.copyMemory(this.currentByteBufferPos, arrayOfByte, 0L, l1);
          this.currentByteBufferPos += l1;
          return ByteString.wrap(arrayOfByte);
        } 
      } 
      if (i > 0 && i <= remaining()) {
        byte[] arrayOfByte = new byte[i];
        readRawBytesTo(arrayOfByte, 0, i);
        return ByteString.wrap(arrayOfByte);
      } 
      if (i == 0)
        return ByteString.EMPTY; 
      if (i < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public double readDouble() throws IOException {
      return Double.longBitsToDouble(readRawLittleEndian64());
    }
    
    public int readEnum() throws IOException {
      return readRawVarint32();
    }
    
    public int readFixed32() throws IOException {
      return readRawLittleEndian32();
    }
    
    public long readFixed64() throws IOException {
      return readRawLittleEndian64();
    }
    
    public float readFloat() throws IOException {
      return Float.intBitsToFloat(readRawLittleEndian32());
    }
    
    public <T extends MessageLite> T readGroup(int param1Int, Parser<T> param1Parser, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (this.recursionDepth < this.recursionLimit) {
        this.recursionDepth++;
        MessageLite messageLite = (MessageLite)param1Parser.parsePartialFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(param1Int, 4));
        this.recursionDepth--;
        return (T)messageLite;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public void readGroup(int param1Int, MessageLite.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (this.recursionDepth < this.recursionLimit) {
        this.recursionDepth++;
        param1Builder.mergeFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(param1Int, 4));
        this.recursionDepth--;
        return;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public int readInt32() throws IOException {
      return readRawVarint32();
    }
    
    public long readInt64() throws IOException {
      return readRawVarint64();
    }
    
    public <T extends MessageLite> T readMessage(Parser<T> param1Parser, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = readRawVarint32();
      if (this.recursionDepth < this.recursionLimit) {
        i = pushLimit(i);
        this.recursionDepth++;
        MessageLite messageLite = (MessageLite)param1Parser.parsePartialFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(i);
        return (T)messageLite;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public void readMessage(MessageLite.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = readRawVarint32();
      if (this.recursionDepth < this.recursionLimit) {
        i = pushLimit(i);
        this.recursionDepth++;
        param1Builder.mergeFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(i);
        return;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public byte readRawByte() throws IOException {
      if (currentRemaining() == 0L)
        getNextByteBuffer(); 
      long l = this.currentByteBufferPos;
      this.currentByteBufferPos = 1L + l;
      return UnsafeUtil.getByte(l);
    }
    
    public byte[] readRawBytes(int param1Int) throws IOException {
      if (param1Int >= 0) {
        long l = param1Int;
        if (l <= currentRemaining()) {
          byte[] arrayOfByte = new byte[param1Int];
          UnsafeUtil.copyMemory(this.currentByteBufferPos, arrayOfByte, 0L, l);
          this.currentByteBufferPos += l;
          return arrayOfByte;
        } 
      } 
      if (param1Int >= 0 && param1Int <= remaining()) {
        byte[] arrayOfByte = new byte[param1Int];
        readRawBytesTo(arrayOfByte, 0, param1Int);
        return arrayOfByte;
      } 
      if (param1Int <= 0) {
        if (param1Int == 0)
          return Internal.EMPTY_BYTE_ARRAY; 
        throw InvalidProtocolBufferException.negativeSize();
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public int readRawLittleEndian32() throws IOException {
      if (currentRemaining() >= 4L) {
        long l = this.currentByteBufferPos;
        this.currentByteBufferPos = 4L + l;
        byte b1 = UnsafeUtil.getByte(l);
        byte b2 = UnsafeUtil.getByte(1L + l);
        byte b3 = UnsafeUtil.getByte(2L + l);
        return (UnsafeUtil.getByte(l + 3L) & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
      } 
      return readRawByte() & 0xFF | (readRawByte() & 0xFF) << 8 | (readRawByte() & 0xFF) << 16 | (readRawByte() & 0xFF) << 24;
    }
    
    public long readRawLittleEndian64() throws IOException {
      if (currentRemaining() >= 8L) {
        long l1 = this.currentByteBufferPos;
        this.currentByteBufferPos = 8L + l1;
        long l2 = UnsafeUtil.getByte(l1);
        long l3 = UnsafeUtil.getByte(1L + l1);
        long l4 = UnsafeUtil.getByte(2L + l1);
        long l5 = UnsafeUtil.getByte(3L + l1);
        long l6 = UnsafeUtil.getByte(4L + l1);
        long l7 = UnsafeUtil.getByte(5L + l1);
        long l8 = UnsafeUtil.getByte(6L + l1);
        return (UnsafeUtil.getByte(l1 + 7L) & 0xFFL) << 56L | l2 & 0xFFL | (l3 & 0xFFL) << 8L | (l4 & 0xFFL) << 16L | (l5 & 0xFFL) << 24L | (l6 & 0xFFL) << 32L | (l7 & 0xFFL) << 40L | (l8 & 0xFFL) << 48L;
      } 
      return readRawByte() & 0xFFL | (readRawByte() & 0xFFL) << 8L | (readRawByte() & 0xFFL) << 16L | (readRawByte() & 0xFFL) << 24L | (readRawByte() & 0xFFL) << 32L | (readRawByte() & 0xFFL) << 40L | (readRawByte() & 0xFFL) << 48L | (readRawByte() & 0xFFL) << 56L;
    }
    
    public int readRawVarint32() throws IOException {
      long l = this.currentByteBufferPos;
      if (this.currentByteBufferLimit != l) {
        long l1 = l + 1L;
        byte b = UnsafeUtil.getByte(l);
        if (b >= 0) {
          this.currentByteBufferPos++;
          return b;
        } 
        if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10L) {
          l = l1 + 1L;
          int i = b ^ UnsafeUtil.getByte(l1) << 7;
          if (i < 0) {
            i ^= 0xFFFFFF80;
          } else {
            l1 = l + 1L;
            i ^= UnsafeUtil.getByte(l) << 14;
            if (i >= 0) {
              i ^= 0x3F80;
              l = l1;
            } else {
              l = l1 + 1L;
              i ^= UnsafeUtil.getByte(l1) << 21;
              if (i < 0) {
                i ^= 0xFFE03F80;
              } else {
                l1 = l + 1L;
                byte b1 = UnsafeUtil.getByte(l);
                int j = i ^ b1 << 28 ^ 0xFE03F80;
                i = j;
                l = l1;
                if (b1 < 0) {
                  long l2 = l1 + 1L;
                  i = j;
                  l = l2;
                  if (UnsafeUtil.getByte(l1) < 0) {
                    l1 = l2 + 1L;
                    i = j;
                    l = l1;
                    if (UnsafeUtil.getByte(l2) < 0) {
                      l2 = l1 + 1L;
                      i = j;
                      l = l2;
                      if (UnsafeUtil.getByte(l1) < 0) {
                        l1 = l2 + 1L;
                        i = j;
                        l = l1;
                        if (UnsafeUtil.getByte(l2) < 0) {
                          l = l1 + 1L;
                          i = j;
                          if (UnsafeUtil.getByte(l1) < 0)
                            return (int)readRawVarint64SlowPath(); 
                        } 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
          this.currentByteBufferPos = l;
          return i;
        } 
      } 
      return (int)readRawVarint64SlowPath();
    }
    
    public long readRawVarint64() throws IOException {
      long l2 = this.currentByteBufferPos;
      if (this.currentByteBufferLimit == l2)
        return readRawVarint64SlowPath(); 
      long l1 = l2 + 1L;
      byte b = UnsafeUtil.getByte(l2);
      if (b >= 0) {
        this.currentByteBufferPos++;
        return b;
      } 
      if (this.currentByteBufferLimit - this.currentByteBufferPos < 10L)
        return readRawVarint64SlowPath(); 
      l2 = l1 + 1L;
      int i = b ^ UnsafeUtil.getByte(l1) << 7;
      if (i < 0) {
        i ^= 0xFFFFFF80;
        l1 = l2;
      } else {
        l1 = l2 + 1L;
        i ^= UnsafeUtil.getByte(l2) << 14;
        if (i >= 0) {
          l2 = (i ^ 0x3F80);
        } else {
          l2 = l1 + 1L;
          i ^= UnsafeUtil.getByte(l1) << 21;
          if (i < 0) {
            i ^= 0xFFE03F80;
            l1 = l2;
          } else {
            long l = i;
            l1 = l2 + 1L;
            l2 = l ^ UnsafeUtil.getByte(l2) << 28L;
            if (l2 >= 0L) {
              l = 266354560L;
            } else {
              l = l1 + 1L;
              l2 ^= UnsafeUtil.getByte(l1) << 35L;
              if (l2 < 0L) {
                long l3 = -34093383808L;
                l1 = l;
                l = l3;
              } else {
                l1 = l + 1L;
                l2 ^= UnsafeUtil.getByte(l) << 42L;
                if (l2 >= 0L) {
                  l = 4363953127296L;
                } else {
                  long l3 = l1 + 1L;
                  l2 ^= UnsafeUtil.getByte(l1) << 49L;
                  if (l2 < 0L) {
                    l = -558586000294016L;
                    l1 = l3;
                  } else {
                    l = l3 + 1L;
                    l3 = l2 ^ UnsafeUtil.getByte(l3) << 56L ^ 0xFE03F80FE03F80L;
                    l2 = l3;
                    l1 = l;
                    if (l3 < 0L) {
                      if (UnsafeUtil.getByte(l) < 0L)
                        return readRawVarint64SlowPath(); 
                      l1 = 1L + l;
                      l2 = l3;
                    } 
                    this.currentByteBufferPos = l1;
                    return l2;
                  } 
                  l2 ^= l;
                } 
                l2 ^= l;
              } 
              l2 ^= l;
            } 
            l2 ^= l;
          } 
          l2 = i;
        } 
        this.currentByteBufferPos = l1;
        return l2;
      } 
      l2 = i;
    }
    
    long readRawVarint64SlowPath() throws IOException {
      long l = 0L;
      for (int i = 0; i < 64; i += 7) {
        byte b = readRawByte();
        l |= (b & Byte.MAX_VALUE) << i;
        if ((b & 0x80) == 0)
          return l; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    public int readSFixed32() throws IOException {
      return readRawLittleEndian32();
    }
    
    public long readSFixed64() throws IOException {
      return readRawLittleEndian64();
    }
    
    public int readSInt32() throws IOException {
      return decodeZigZag32(readRawVarint32());
    }
    
    public long readSInt64() throws IOException {
      return decodeZigZag64(readRawVarint64());
    }
    
    public String readString() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        long l1 = i;
        long l2 = this.currentByteBufferLimit;
        long l3 = this.currentByteBufferPos;
        if (l1 <= l2 - l3) {
          byte[] arrayOfByte = new byte[i];
          UnsafeUtil.copyMemory(l3, arrayOfByte, 0L, l1);
          String str = new String(arrayOfByte, Internal.UTF_8);
          this.currentByteBufferPos += l1;
          return str;
        } 
      } 
      if (i > 0 && i <= remaining()) {
        byte[] arrayOfByte = new byte[i];
        readRawBytesTo(arrayOfByte, 0, i);
        return new String(arrayOfByte, Internal.UTF_8);
      } 
      if (i == 0)
        return ""; 
      if (i < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public String readStringRequireUtf8() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        long l1 = i;
        long l2 = this.currentByteBufferLimit;
        long l3 = this.currentByteBufferPos;
        if (l1 <= l2 - l3) {
          int j = (int)(l3 - this.currentByteBufferStartPos);
          String str = Utf8.decodeUtf8(this.currentByteBuffer, j, i);
          this.currentByteBufferPos += l1;
          return str;
        } 
      } 
      if (i >= 0 && i <= remaining()) {
        byte[] arrayOfByte = new byte[i];
        readRawBytesTo(arrayOfByte, 0, i);
        return Utf8.decodeUtf8(arrayOfByte, 0, i);
      } 
      if (i == 0)
        return ""; 
      if (i <= 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public int readTag() throws IOException {
      if (isAtEnd()) {
        this.lastTag = 0;
        return 0;
      } 
      this.lastTag = readRawVarint32();
      if (WireFormat.getTagFieldNumber(this.lastTag) != 0)
        return this.lastTag; 
      throw InvalidProtocolBufferException.invalidTag();
    }
    
    public int readUInt32() throws IOException {
      return readRawVarint32();
    }
    
    public long readUInt64() throws IOException {
      return readRawVarint64();
    }
    
    @Deprecated
    public void readUnknownGroup(int param1Int, MessageLite.Builder param1Builder) throws IOException {
      readGroup(param1Int, param1Builder, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public void resetSizeCounter() {
      this.startOffset = (int)(this.totalBytesRead + this.currentByteBufferPos - this.currentByteBufferStartPos);
    }
    
    public boolean skipField(int param1Int) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  skipRawBytes(4);
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(param1Int), 4));
            return true;
          } 
          skipRawBytes(readRawVarint32());
          return true;
        } 
        skipRawBytes(8);
        return true;
      } 
      skipRawVarint();
      return true;
    }
    
    public boolean skipField(int param1Int, CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  i = readRawLittleEndian32();
                  param1CodedOutputStream.writeRawVarint32(param1Int);
                  param1CodedOutputStream.writeFixed32NoTag(i);
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            param1CodedOutputStream.writeRawVarint32(param1Int);
            skipMessage(param1CodedOutputStream);
            param1Int = WireFormat.makeTag(WireFormat.getTagFieldNumber(param1Int), 4);
            checkLastTagWas(param1Int);
            param1CodedOutputStream.writeRawVarint32(param1Int);
            return true;
          } 
          ByteString byteString = readBytes();
          param1CodedOutputStream.writeRawVarint32(param1Int);
          param1CodedOutputStream.writeBytesNoTag(byteString);
          return true;
        } 
        long l1 = readRawLittleEndian64();
        param1CodedOutputStream.writeRawVarint32(param1Int);
        param1CodedOutputStream.writeFixed64NoTag(l1);
        return true;
      } 
      long l = readInt64();
      param1CodedOutputStream.writeRawVarint32(param1Int);
      param1CodedOutputStream.writeUInt64NoTag(l);
      return true;
    }
    
    public void skipMessage() throws IOException {
      int i;
      do {
        i = readTag();
      } while (i != 0 && skipField(i));
    }
    
    public void skipMessage(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i;
      do {
        i = readTag();
      } while (i != 0 && skipField(i, param1CodedOutputStream));
    }
    
    public void skipRawBytes(int param1Int) throws IOException {
      if (param1Int >= 0 && param1Int <= (this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos + this.currentByteBufferStartPos) {
        while (param1Int > 0) {
          if (currentRemaining() == 0L)
            getNextByteBuffer(); 
          int i = Math.min(param1Int, (int)currentRemaining());
          param1Int -= i;
          this.currentByteBufferPos += i;
        } 
        return;
      } 
      if (param1Int < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
  }
  
  static final class StreamDecoder extends CodedInputStream {
    private final byte[] buffer;
    
    private int bufferSize;
    
    private int bufferSizeAfterLimit;
    
    private int currentLimit = Integer.MAX_VALUE;
    
    private final InputStream input;
    
    private int lastTag;
    
    private int pos;
    
    private RefillCallback refillCallback = null;
    
    private int totalBytesRetired;
    
    private StreamDecoder(InputStream param1InputStream, int param1Int) {
      Internal.checkNotNull(param1InputStream, "input");
      this.input = param1InputStream;
      this.buffer = new byte[param1Int];
      this.bufferSize = 0;
      this.pos = 0;
      this.totalBytesRetired = 0;
    }
    
    private ByteString readBytesSlowPath(int param1Int) throws IOException {
      byte[] arrayOfByte = readRawBytesSlowPathOneChunk(param1Int);
      if (arrayOfByte != null)
        return ByteString.copyFrom(arrayOfByte); 
      int j = this.pos;
      int k = this.bufferSize;
      int i = k - j;
      this.totalBytesRetired += k;
      this.pos = 0;
      this.bufferSize = 0;
      List<byte[]> list = readRawBytesSlowPathRemainingChunks(param1Int - i);
      arrayOfByte = new byte[param1Int];
      System.arraycopy(this.buffer, j, arrayOfByte, 0, i);
      Iterator<byte> iterator = list.iterator();
      for (param1Int = i; iterator.hasNext(); param1Int += arrayOfByte1.length) {
        byte[] arrayOfByte1 = (byte[])iterator.next();
        System.arraycopy(arrayOfByte1, 0, arrayOfByte, param1Int, arrayOfByte1.length);
      } 
      return ByteString.wrap(arrayOfByte);
    }
    
    private byte[] readRawBytesSlowPath(int param1Int, boolean param1Boolean) throws IOException {
      byte[] arrayOfByte2 = readRawBytesSlowPathOneChunk(param1Int);
      if (arrayOfByte2 != null) {
        byte[] arrayOfByte = arrayOfByte2;
        if (param1Boolean)
          arrayOfByte = (byte[])arrayOfByte2.clone(); 
        return arrayOfByte;
      } 
      int j = this.pos;
      int k = this.bufferSize;
      int i = k - j;
      this.totalBytesRetired += k;
      this.pos = 0;
      this.bufferSize = 0;
      List<byte[]> list = readRawBytesSlowPathRemainingChunks(param1Int - i);
      byte[] arrayOfByte1 = new byte[param1Int];
      System.arraycopy(this.buffer, j, arrayOfByte1, 0, i);
      Iterator<byte> iterator = list.iterator();
      for (param1Int = i; iterator.hasNext(); param1Int += arrayOfByte.length) {
        byte[] arrayOfByte = (byte[])iterator.next();
        System.arraycopy(arrayOfByte, 0, arrayOfByte1, param1Int, arrayOfByte.length);
      } 
      return arrayOfByte1;
    }
    
    private byte[] readRawBytesSlowPathOneChunk(int param1Int) throws IOException {
      if (param1Int == 0)
        return Internal.EMPTY_BYTE_ARRAY; 
      if (param1Int >= 0) {
        int i = this.totalBytesRetired + this.pos + param1Int;
        if (i - this.sizeLimit <= 0) {
          int j = this.currentLimit;
          if (i <= j) {
            i = this.bufferSize - this.pos;
            j = param1Int - i;
            if (j < 4096 || j <= this.input.available()) {
              byte[] arrayOfByte = new byte[param1Int];
              System.arraycopy(this.buffer, this.pos, arrayOfByte, 0, i);
              this.totalBytesRetired += this.bufferSize;
              this.pos = 0;
              this.bufferSize = 0;
              while (i < arrayOfByte.length) {
                j = this.input.read(arrayOfByte, i, param1Int - i);
                if (j != -1) {
                  this.totalBytesRetired += j;
                  i += j;
                  continue;
                } 
                throw InvalidProtocolBufferException.truncatedMessage();
              } 
              return arrayOfByte;
            } 
            return null;
          } 
          skipRawBytes(j - this.totalBytesRetired - this.pos);
          throw InvalidProtocolBufferException.truncatedMessage();
        } 
        throw InvalidProtocolBufferException.sizeLimitExceeded();
      } 
      throw InvalidProtocolBufferException.negativeSize();
    }
    
    private List<byte[]> readRawBytesSlowPathRemainingChunks(int param1Int) throws IOException {
      ArrayList<byte[]> arrayList = new ArrayList();
      while (param1Int > 0) {
        byte[] arrayOfByte = new byte[Math.min(param1Int, 4096)];
        int i = 0;
        while (i < arrayOfByte.length) {
          int j = this.input.read(arrayOfByte, i, arrayOfByte.length - i);
          if (j != -1) {
            this.totalBytesRetired += j;
            i += j;
            continue;
          } 
          throw InvalidProtocolBufferException.truncatedMessage();
        } 
        param1Int -= arrayOfByte.length;
        arrayList.add(arrayOfByte);
      } 
      return (List<byte[]>)arrayList;
    }
    
    private void recomputeBufferSizeAfterLimit() {
      this.bufferSize += this.bufferSizeAfterLimit;
      int j = this.totalBytesRetired;
      int i = this.bufferSize;
      j += i;
      int k = this.currentLimit;
      if (j > k) {
        this.bufferSizeAfterLimit = j - k;
        this.bufferSize = i - this.bufferSizeAfterLimit;
        return;
      } 
      this.bufferSizeAfterLimit = 0;
    }
    
    private void refillBuffer(int param1Int) throws IOException {
      if (!tryRefillBuffer(param1Int)) {
        if (param1Int > this.sizeLimit - this.totalBytesRetired - this.pos)
          throw InvalidProtocolBufferException.sizeLimitExceeded(); 
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
    }
    
    private void skipRawBytesSlowPath(int param1Int) throws IOException {
      // Byte code:
      //   0: iload_1
      //   1: iflt -> 293
      //   4: aload_0
      //   5: getfield totalBytesRetired : I
      //   8: istore #4
      //   10: aload_0
      //   11: getfield pos : I
      //   14: istore_3
      //   15: aload_0
      //   16: getfield currentLimit : I
      //   19: istore_2
      //   20: iload #4
      //   22: iload_3
      //   23: iadd
      //   24: iload_1
      //   25: iadd
      //   26: iload_2
      //   27: if_icmpgt -> 279
      //   30: aload_0
      //   31: getfield refillCallback : Lcom/google/protobuf/CodedInputStream$StreamDecoder$RefillCallback;
      //   34: astore #9
      //   36: iconst_0
      //   37: istore_2
      //   38: aload #9
      //   40: ifnonnull -> 212
      //   43: aload_0
      //   44: iload #4
      //   46: iload_3
      //   47: iadd
      //   48: putfield totalBytesRetired : I
      //   51: aload_0
      //   52: getfield bufferSize : I
      //   55: istore_2
      //   56: aload_0
      //   57: iconst_0
      //   58: putfield bufferSize : I
      //   61: aload_0
      //   62: iconst_0
      //   63: putfield pos : I
      //   66: iload_2
      //   67: iload_3
      //   68: isub
      //   69: istore_2
      //   70: iload_2
      //   71: iload_1
      //   72: if_icmpge -> 198
      //   75: aload_0
      //   76: getfield input : Ljava/io/InputStream;
      //   79: astore #9
      //   81: iload_1
      //   82: iload_2
      //   83: isub
      //   84: i2l
      //   85: lstore #5
      //   87: aload #9
      //   89: lload #5
      //   91: invokevirtual skip : (J)J
      //   94: lstore #7
      //   96: lload #7
      //   98: lconst_0
      //   99: lcmp
      //   100: istore_3
      //   101: iload_3
      //   102: iflt -> 120
      //   105: lload #7
      //   107: lload #5
      //   109: lcmp
      //   110: ifgt -> 120
      //   113: iload_3
      //   114: ifne -> 297
      //   117: goto -> 198
      //   120: new java/lang/StringBuilder
      //   123: dup
      //   124: invokespecial <init> : ()V
      //   127: astore #9
      //   129: aload #9
      //   131: aload_0
      //   132: getfield input : Ljava/io/InputStream;
      //   135: invokevirtual getClass : ()Ljava/lang/Class;
      //   138: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   141: pop
      //   142: aload #9
      //   144: ldc '#skip returned invalid result: '
      //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: pop
      //   150: aload #9
      //   152: lload #7
      //   154: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   157: pop
      //   158: aload #9
      //   160: ldc '\\nThe InputStream implementation is buggy.'
      //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   165: pop
      //   166: new java/lang/IllegalStateException
      //   169: dup
      //   170: aload #9
      //   172: invokevirtual toString : ()Ljava/lang/String;
      //   175: invokespecial <init> : (Ljava/lang/String;)V
      //   178: athrow
      //   179: astore #9
      //   181: aload_0
      //   182: aload_0
      //   183: getfield totalBytesRetired : I
      //   186: iload_2
      //   187: iadd
      //   188: putfield totalBytesRetired : I
      //   191: aload_0
      //   192: invokespecial recomputeBufferSizeAfterLimit : ()V
      //   195: aload #9
      //   197: athrow
      //   198: aload_0
      //   199: aload_0
      //   200: getfield totalBytesRetired : I
      //   203: iload_2
      //   204: iadd
      //   205: putfield totalBytesRetired : I
      //   208: aload_0
      //   209: invokespecial recomputeBufferSizeAfterLimit : ()V
      //   212: iload_2
      //   213: iload_1
      //   214: if_icmpge -> 278
      //   217: aload_0
      //   218: getfield bufferSize : I
      //   221: istore_3
      //   222: iload_3
      //   223: aload_0
      //   224: getfield pos : I
      //   227: isub
      //   228: istore_2
      //   229: aload_0
      //   230: iload_3
      //   231: putfield pos : I
      //   234: aload_0
      //   235: iconst_1
      //   236: invokespecial refillBuffer : (I)V
      //   239: iload_1
      //   240: iload_2
      //   241: isub
      //   242: istore #4
      //   244: aload_0
      //   245: getfield bufferSize : I
      //   248: istore_3
      //   249: iload #4
      //   251: iload_3
      //   252: if_icmple -> 272
      //   255: iload_2
      //   256: iload_3
      //   257: iadd
      //   258: istore_2
      //   259: aload_0
      //   260: iload_3
      //   261: putfield pos : I
      //   264: aload_0
      //   265: iconst_1
      //   266: invokespecial refillBuffer : (I)V
      //   269: goto -> 239
      //   272: aload_0
      //   273: iload #4
      //   275: putfield pos : I
      //   278: return
      //   279: aload_0
      //   280: iload_2
      //   281: iload #4
      //   283: isub
      //   284: iload_3
      //   285: isub
      //   286: invokevirtual skipRawBytes : (I)V
      //   289: invokestatic truncatedMessage : ()Lcom/google/protobuf/InvalidProtocolBufferException;
      //   292: athrow
      //   293: invokestatic negativeSize : ()Lcom/google/protobuf/InvalidProtocolBufferException;
      //   296: athrow
      //   297: iload_2
      //   298: lload #7
      //   300: l2i
      //   301: iadd
      //   302: istore_2
      //   303: goto -> 70
      // Exception table:
      //   from	to	target	type
      //   75	81	179	finally
      //   87	96	179	finally
      //   120	179	179	finally
    }
    
    private void skipRawVarint() throws IOException {
      if (this.bufferSize - this.pos >= 10) {
        skipRawVarintFastPath();
        return;
      } 
      skipRawVarintSlowPath();
    }
    
    private void skipRawVarintFastPath() throws IOException {
      for (int i = 0; i < 10; i++) {
        byte[] arrayOfByte = this.buffer;
        int j = this.pos;
        this.pos = j + 1;
        if (arrayOfByte[j] >= 0)
          return; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    private void skipRawVarintSlowPath() throws IOException {
      for (int i = 0; i < 10; i++) {
        if (readRawByte() >= 0)
          return; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    private boolean tryRefillBuffer(int param1Int) throws IOException {
      if (this.pos + param1Int > this.bufferSize) {
        int i = this.sizeLimit;
        int j = this.totalBytesRetired;
        int k = this.pos;
        if (param1Int > i - j - k)
          return false; 
        if (j + k + param1Int > this.currentLimit)
          return false; 
        RefillCallback refillCallback = this.refillCallback;
        if (refillCallback != null)
          refillCallback.onRefill(); 
        i = this.pos;
        if (i > 0) {
          j = this.bufferSize;
          if (j > i) {
            byte[] arrayOfByte1 = this.buffer;
            System.arraycopy(arrayOfByte1, i, arrayOfByte1, 0, j - i);
          } 
          this.totalBytesRetired += i;
          this.bufferSize -= i;
          this.pos = 0;
        } 
        InputStream inputStream = this.input;
        byte[] arrayOfByte = this.buffer;
        i = this.bufferSize;
        i = inputStream.read(arrayOfByte, i, Math.min(arrayOfByte.length - i, this.sizeLimit - this.totalBytesRetired - this.bufferSize));
        if (i != 0 && i >= -1 && i <= this.buffer.length) {
          if (i > 0) {
            this.bufferSize += i;
            recomputeBufferSizeAfterLimit();
            return (this.bufferSize >= param1Int) ? true : tryRefillBuffer(param1Int);
          } 
          return false;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.input.getClass());
        stringBuilder1.append("#read(byte[]) returned invalid result: ");
        stringBuilder1.append(i);
        stringBuilder1.append("\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("refillBuffer() called when ");
      stringBuilder.append(param1Int);
      stringBuilder.append(" bytes were already available in buffer");
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public void checkLastTagWas(int param1Int) throws InvalidProtocolBufferException {
      if (this.lastTag == param1Int)
        return; 
      throw InvalidProtocolBufferException.invalidEndTag();
    }
    
    public void enableAliasing(boolean param1Boolean) {}
    
    public int getBytesUntilLimit() {
      int i = this.currentLimit;
      return (i == Integer.MAX_VALUE) ? -1 : (i - this.totalBytesRetired + this.pos);
    }
    
    public int getLastTag() {
      return this.lastTag;
    }
    
    public int getTotalBytesRead() {
      return this.totalBytesRetired + this.pos;
    }
    
    public boolean isAtEnd() throws IOException {
      return (this.pos == this.bufferSize && !tryRefillBuffer(1));
    }
    
    public void popLimit(int param1Int) {
      this.currentLimit = param1Int;
      recomputeBufferSizeAfterLimit();
    }
    
    public int pushLimit(int param1Int) throws InvalidProtocolBufferException {
      if (param1Int >= 0) {
        param1Int += this.totalBytesRetired + this.pos;
        int i = this.currentLimit;
        if (param1Int <= i) {
          this.currentLimit = param1Int;
          recomputeBufferSizeAfterLimit();
          return i;
        } 
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      throw InvalidProtocolBufferException.negativeSize();
    }
    
    public boolean readBool() throws IOException {
      return (readRawVarint64() != 0L);
    }
    
    public byte[] readByteArray() throws IOException {
      int i = readRawVarint32();
      int j = this.bufferSize;
      int k = this.pos;
      if (i <= j - k && i > 0) {
        byte[] arrayOfByte = Arrays.copyOfRange(this.buffer, k, k + i);
        this.pos += i;
        return arrayOfByte;
      } 
      return readRawBytesSlowPath(i, false);
    }
    
    public ByteBuffer readByteBuffer() throws IOException {
      int i = readRawVarint32();
      int j = this.bufferSize;
      int k = this.pos;
      if (i <= j - k && i > 0) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, k, k + i));
        this.pos += i;
        return byteBuffer;
      } 
      return (i == 0) ? Internal.EMPTY_BYTE_BUFFER : ByteBuffer.wrap(readRawBytesSlowPath(i, true));
    }
    
    public ByteString readBytes() throws IOException {
      int i = readRawVarint32();
      int j = this.bufferSize;
      int k = this.pos;
      if (i <= j - k && i > 0) {
        ByteString byteString = ByteString.copyFrom(this.buffer, k, i);
        this.pos += i;
        return byteString;
      } 
      return (i == 0) ? ByteString.EMPTY : readBytesSlowPath(i);
    }
    
    public double readDouble() throws IOException {
      return Double.longBitsToDouble(readRawLittleEndian64());
    }
    
    public int readEnum() throws IOException {
      return readRawVarint32();
    }
    
    public int readFixed32() throws IOException {
      return readRawLittleEndian32();
    }
    
    public long readFixed64() throws IOException {
      return readRawLittleEndian64();
    }
    
    public float readFloat() throws IOException {
      return Float.intBitsToFloat(readRawLittleEndian32());
    }
    
    public <T extends MessageLite> T readGroup(int param1Int, Parser<T> param1Parser, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (this.recursionDepth < this.recursionLimit) {
        this.recursionDepth++;
        MessageLite messageLite = (MessageLite)param1Parser.parsePartialFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(param1Int, 4));
        this.recursionDepth--;
        return (T)messageLite;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public void readGroup(int param1Int, MessageLite.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (this.recursionDepth < this.recursionLimit) {
        this.recursionDepth++;
        param1Builder.mergeFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(param1Int, 4));
        this.recursionDepth--;
        return;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public int readInt32() throws IOException {
      return readRawVarint32();
    }
    
    public long readInt64() throws IOException {
      return readRawVarint64();
    }
    
    public <T extends MessageLite> T readMessage(Parser<T> param1Parser, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = readRawVarint32();
      if (this.recursionDepth < this.recursionLimit) {
        i = pushLimit(i);
        this.recursionDepth++;
        MessageLite messageLite = (MessageLite)param1Parser.parsePartialFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(i);
        return (T)messageLite;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public void readMessage(MessageLite.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = readRawVarint32();
      if (this.recursionDepth < this.recursionLimit) {
        i = pushLimit(i);
        this.recursionDepth++;
        param1Builder.mergeFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(i);
        return;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public byte readRawByte() throws IOException {
      if (this.pos == this.bufferSize)
        refillBuffer(1); 
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i + 1;
      return arrayOfByte[i];
    }
    
    public byte[] readRawBytes(int param1Int) throws IOException {
      int i = this.pos;
      if (param1Int <= this.bufferSize - i && param1Int > 0) {
        param1Int += i;
        this.pos = param1Int;
        return Arrays.copyOfRange(this.buffer, i, param1Int);
      } 
      return readRawBytesSlowPath(param1Int, false);
    }
    
    public int readRawLittleEndian32() throws IOException {
      int j = this.pos;
      int i = j;
      if (this.bufferSize - j < 4) {
        refillBuffer(4);
        i = this.pos;
      } 
      byte[] arrayOfByte = this.buffer;
      this.pos = i + 4;
      j = arrayOfByte[i];
      byte b1 = arrayOfByte[i + 1];
      byte b2 = arrayOfByte[i + 2];
      return (arrayOfByte[i + 3] & 0xFF) << 24 | j & 0xFF | (b1 & 0xFF) << 8 | (b2 & 0xFF) << 16;
    }
    
    public long readRawLittleEndian64() throws IOException {
      int j = this.pos;
      int i = j;
      if (this.bufferSize - j < 8) {
        refillBuffer(8);
        i = this.pos;
      } 
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
    
    public int readRawVarint32() throws IOException {
      int j = this.pos;
      int i = this.bufferSize;
      if (i != j) {
        byte[] arrayOfByte = this.buffer;
        int k = j + 1;
        j = arrayOfByte[j];
        if (j >= 0) {
          this.pos = k;
          return j;
        } 
        if (i - k >= 9) {
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
                          k = j;
                          if (arrayOfByte[m] < 0)
                            return (int)readRawVarint64SlowPath(); 
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
      } 
      return (int)readRawVarint64SlowPath();
    }
    
    public long readRawVarint64() throws IOException {
      int k = this.pos;
      int i = this.bufferSize;
      if (i == k)
        return readRawVarint64SlowPath(); 
      byte[] arrayOfByte = this.buffer;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0) {
        this.pos = j;
        return k;
      } 
      if (i - j < 9)
        return readRawVarint64SlowPath(); 
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
                        return readRawVarint64SlowPath(); 
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
      long l = j;
    }
    
    long readRawVarint64SlowPath() throws IOException {
      long l = 0L;
      for (int i = 0; i < 64; i += 7) {
        byte b = readRawByte();
        l |= (b & Byte.MAX_VALUE) << i;
        if ((b & 0x80) == 0)
          return l; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    public int readSFixed32() throws IOException {
      return readRawLittleEndian32();
    }
    
    public long readSFixed64() throws IOException {
      return readRawLittleEndian64();
    }
    
    public int readSInt32() throws IOException {
      return decodeZigZag32(readRawVarint32());
    }
    
    public long readSInt64() throws IOException {
      return decodeZigZag64(readRawVarint64());
    }
    
    public String readString() throws IOException {
      int i = readRawVarint32();
      if (i > 0) {
        int j = this.bufferSize;
        int k = this.pos;
        if (i <= j - k) {
          String str = new String(this.buffer, k, i, Internal.UTF_8);
          this.pos += i;
          return str;
        } 
      } 
      if (i == 0)
        return ""; 
      if (i <= this.bufferSize) {
        refillBuffer(i);
        String str = new String(this.buffer, this.pos, i, Internal.UTF_8);
        this.pos += i;
        return str;
      } 
      return new String(readRawBytesSlowPath(i, false), Internal.UTF_8);
    }
    
    public String readStringRequireUtf8() throws IOException {
      byte[] arrayOfByte;
      int j = readRawVarint32();
      int i = this.pos;
      int k = this.bufferSize;
      boolean bool = false;
      if (j <= k - i && j > 0) {
        arrayOfByte = this.buffer;
        this.pos = i + j;
      } else {
        if (j == 0)
          return ""; 
        if (j <= this.bufferSize) {
          refillBuffer(j);
          arrayOfByte = this.buffer;
          this.pos = j + 0;
          i = bool;
        } else {
          arrayOfByte = readRawBytesSlowPath(j, false);
          i = bool;
        } 
      } 
      return Utf8.decodeUtf8(arrayOfByte, i, j);
    }
    
    public int readTag() throws IOException {
      if (isAtEnd()) {
        this.lastTag = 0;
        return 0;
      } 
      this.lastTag = readRawVarint32();
      if (WireFormat.getTagFieldNumber(this.lastTag) != 0)
        return this.lastTag; 
      throw InvalidProtocolBufferException.invalidTag();
    }
    
    public int readUInt32() throws IOException {
      return readRawVarint32();
    }
    
    public long readUInt64() throws IOException {
      return readRawVarint64();
    }
    
    @Deprecated
    public void readUnknownGroup(int param1Int, MessageLite.Builder param1Builder) throws IOException {
      readGroup(param1Int, param1Builder, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public void resetSizeCounter() {
      this.totalBytesRetired = -this.pos;
    }
    
    public boolean skipField(int param1Int) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  skipRawBytes(4);
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(param1Int), 4));
            return true;
          } 
          skipRawBytes(readRawVarint32());
          return true;
        } 
        skipRawBytes(8);
        return true;
      } 
      skipRawVarint();
      return true;
    }
    
    public boolean skipField(int param1Int, CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  i = readRawLittleEndian32();
                  param1CodedOutputStream.writeRawVarint32(param1Int);
                  param1CodedOutputStream.writeFixed32NoTag(i);
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            param1CodedOutputStream.writeRawVarint32(param1Int);
            skipMessage(param1CodedOutputStream);
            param1Int = WireFormat.makeTag(WireFormat.getTagFieldNumber(param1Int), 4);
            checkLastTagWas(param1Int);
            param1CodedOutputStream.writeRawVarint32(param1Int);
            return true;
          } 
          ByteString byteString = readBytes();
          param1CodedOutputStream.writeRawVarint32(param1Int);
          param1CodedOutputStream.writeBytesNoTag(byteString);
          return true;
        } 
        long l1 = readRawLittleEndian64();
        param1CodedOutputStream.writeRawVarint32(param1Int);
        param1CodedOutputStream.writeFixed64NoTag(l1);
        return true;
      } 
      long l = readInt64();
      param1CodedOutputStream.writeRawVarint32(param1Int);
      param1CodedOutputStream.writeUInt64NoTag(l);
      return true;
    }
    
    public void skipMessage() throws IOException {
      int i;
      do {
        i = readTag();
      } while (i != 0 && skipField(i));
    }
    
    public void skipMessage(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i;
      do {
        i = readTag();
      } while (i != 0 && skipField(i, param1CodedOutputStream));
    }
    
    public void skipRawBytes(int param1Int) throws IOException {
      int i = this.bufferSize;
      int j = this.pos;
      if (param1Int <= i - j && param1Int >= 0) {
        this.pos = j + param1Int;
        return;
      } 
      skipRawBytesSlowPath(param1Int);
    }
    
    static interface RefillCallback {
      void onRefill();
    }
    
    class SkippedDataSink implements RefillCallback {
      private ByteArrayOutputStream byteArrayStream;
      
      private int lastPos = CodedInputStream.StreamDecoder.this.pos;
      
      ByteBuffer getSkippedData() {
        ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
        if (byteArrayOutputStream == null)
          return ByteBuffer.wrap(CodedInputStream.StreamDecoder.this.buffer, this.lastPos, CodedInputStream.StreamDecoder.this.pos - this.lastPos); 
        byteArrayOutputStream.write(CodedInputStream.StreamDecoder.this.buffer, this.lastPos, CodedInputStream.StreamDecoder.this.pos);
        return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
      }
      
      public void onRefill() {
        if (this.byteArrayStream == null)
          this.byteArrayStream = new ByteArrayOutputStream(); 
        this.byteArrayStream.write(CodedInputStream.StreamDecoder.this.buffer, this.lastPos, CodedInputStream.StreamDecoder.this.pos - this.lastPos);
        this.lastPos = 0;
      }
    }
  }
  
  static interface RefillCallback {
    void onRefill();
  }
  
  class SkippedDataSink implements StreamDecoder.RefillCallback {
    private ByteArrayOutputStream byteArrayStream;
    
    private int lastPos = this.this$0.pos;
    
    ByteBuffer getSkippedData() {
      ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
      if (byteArrayOutputStream == null)
        return ByteBuffer.wrap(this.this$0.buffer, this.lastPos, this.this$0.pos - this.lastPos); 
      byteArrayOutputStream.write(this.this$0.buffer, this.lastPos, this.this$0.pos);
      return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
    }
    
    public void onRefill() {
      if (this.byteArrayStream == null)
        this.byteArrayStream = new ByteArrayOutputStream(); 
      this.byteArrayStream.write(this.this$0.buffer, this.lastPos, this.this$0.pos - this.lastPos);
      this.lastPos = 0;
    }
  }
  
  static final class UnsafeDirectNioDecoder extends CodedInputStream {
    private final long address;
    
    private final ByteBuffer buffer;
    
    private int bufferSizeAfterLimit;
    
    private int currentLimit = Integer.MAX_VALUE;
    
    private boolean enableAliasing;
    
    private final boolean immutable;
    
    private int lastTag;
    
    private long limit;
    
    private long pos;
    
    private long startPos;
    
    private UnsafeDirectNioDecoder(ByteBuffer param1ByteBuffer, boolean param1Boolean) {
      this.buffer = param1ByteBuffer;
      this.address = UnsafeUtil.addressOffset(param1ByteBuffer);
      this.limit = this.address + param1ByteBuffer.limit();
      this.pos = this.address + param1ByteBuffer.position();
      this.startPos = this.pos;
      this.immutable = param1Boolean;
    }
    
    private int bufferPos(long param1Long) {
      return (int)(param1Long - this.address);
    }
    
    static boolean isSupported() {
      return UnsafeUtil.hasUnsafeByteBufferOperations();
    }
    
    private void recomputeBufferSizeAfterLimit() {
      this.limit += this.bufferSizeAfterLimit;
      long l = this.limit;
      int i = (int)(l - this.startPos);
      int j = this.currentLimit;
      if (i > j) {
        this.bufferSizeAfterLimit = i - j;
        this.limit = l - this.bufferSizeAfterLimit;
        return;
      } 
      this.bufferSizeAfterLimit = 0;
    }
    
    private int remaining() {
      return (int)(this.limit - this.pos);
    }
    
    private void skipRawVarint() throws IOException {
      if (remaining() >= 10) {
        skipRawVarintFastPath();
        return;
      } 
      skipRawVarintSlowPath();
    }
    
    private void skipRawVarintFastPath() throws IOException {
      for (int i = 0; i < 10; i++) {
        long l = this.pos;
        this.pos = 1L + l;
        if (UnsafeUtil.getByte(l) >= 0)
          return; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    private void skipRawVarintSlowPath() throws IOException {
      for (int i = 0; i < 10; i++) {
        if (readRawByte() >= 0)
          return; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    private ByteBuffer slice(long param1Long1, long param1Long2) throws IOException {
      int i = this.buffer.position();
      int j = this.buffer.limit();
      try {
        this.buffer.position(bufferPos(param1Long1));
        this.buffer.limit(bufferPos(param1Long2));
        return this.buffer.slice();
      } catch (IllegalArgumentException illegalArgumentException) {
        throw InvalidProtocolBufferException.truncatedMessage();
      } finally {
        this.buffer.position(i);
        this.buffer.limit(j);
      } 
    }
    
    public void checkLastTagWas(int param1Int) throws InvalidProtocolBufferException {
      if (this.lastTag == param1Int)
        return; 
      throw InvalidProtocolBufferException.invalidEndTag();
    }
    
    public void enableAliasing(boolean param1Boolean) {
      this.enableAliasing = param1Boolean;
    }
    
    public int getBytesUntilLimit() {
      int i = this.currentLimit;
      return (i == Integer.MAX_VALUE) ? -1 : (i - getTotalBytesRead());
    }
    
    public int getLastTag() {
      return this.lastTag;
    }
    
    public int getTotalBytesRead() {
      return (int)(this.pos - this.startPos);
    }
    
    public boolean isAtEnd() throws IOException {
      return (this.pos == this.limit);
    }
    
    public void popLimit(int param1Int) {
      this.currentLimit = param1Int;
      recomputeBufferSizeAfterLimit();
    }
    
    public int pushLimit(int param1Int) throws InvalidProtocolBufferException {
      if (param1Int >= 0) {
        param1Int += getTotalBytesRead();
        int i = this.currentLimit;
        if (param1Int <= i) {
          this.currentLimit = param1Int;
          recomputeBufferSizeAfterLimit();
          return i;
        } 
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      throw InvalidProtocolBufferException.negativeSize();
    }
    
    public boolean readBool() throws IOException {
      return (readRawVarint64() != 0L);
    }
    
    public byte[] readByteArray() throws IOException {
      return readRawBytes(readRawVarint32());
    }
    
    public ByteBuffer readByteBuffer() throws IOException {
      int i = readRawVarint32();
      if (i > 0 && i <= remaining()) {
        if (!this.immutable && this.enableAliasing) {
          long l3 = this.pos;
          long l4 = i;
          ByteBuffer byteBuffer = slice(l3, l3 + l4);
          this.pos += l4;
          return byteBuffer;
        } 
        byte[] arrayOfByte = new byte[i];
        long l1 = this.pos;
        long l2 = i;
        UnsafeUtil.copyMemory(l1, arrayOfByte, 0L, l2);
        this.pos += l2;
        return ByteBuffer.wrap(arrayOfByte);
      } 
      if (i == 0)
        return Internal.EMPTY_BYTE_BUFFER; 
      if (i < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public ByteString readBytes() throws IOException {
      int i = readRawVarint32();
      if (i > 0 && i <= remaining()) {
        if (this.immutable && this.enableAliasing) {
          long l3 = this.pos;
          long l4 = i;
          ByteBuffer byteBuffer = slice(l3, l3 + l4);
          this.pos += l4;
          return ByteString.wrap(byteBuffer);
        } 
        byte[] arrayOfByte = new byte[i];
        long l1 = this.pos;
        long l2 = i;
        UnsafeUtil.copyMemory(l1, arrayOfByte, 0L, l2);
        this.pos += l2;
        return ByteString.wrap(arrayOfByte);
      } 
      if (i == 0)
        return ByteString.EMPTY; 
      if (i < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public double readDouble() throws IOException {
      return Double.longBitsToDouble(readRawLittleEndian64());
    }
    
    public int readEnum() throws IOException {
      return readRawVarint32();
    }
    
    public int readFixed32() throws IOException {
      return readRawLittleEndian32();
    }
    
    public long readFixed64() throws IOException {
      return readRawLittleEndian64();
    }
    
    public float readFloat() throws IOException {
      return Float.intBitsToFloat(readRawLittleEndian32());
    }
    
    public <T extends MessageLite> T readGroup(int param1Int, Parser<T> param1Parser, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (this.recursionDepth < this.recursionLimit) {
        this.recursionDepth++;
        MessageLite messageLite = (MessageLite)param1Parser.parsePartialFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(param1Int, 4));
        this.recursionDepth--;
        return (T)messageLite;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public void readGroup(int param1Int, MessageLite.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      if (this.recursionDepth < this.recursionLimit) {
        this.recursionDepth++;
        param1Builder.mergeFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(param1Int, 4));
        this.recursionDepth--;
        return;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public int readInt32() throws IOException {
      return readRawVarint32();
    }
    
    public long readInt64() throws IOException {
      return readRawVarint64();
    }
    
    public <T extends MessageLite> T readMessage(Parser<T> param1Parser, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = readRawVarint32();
      if (this.recursionDepth < this.recursionLimit) {
        i = pushLimit(i);
        this.recursionDepth++;
        MessageLite messageLite = (MessageLite)param1Parser.parsePartialFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(i);
        return (T)messageLite;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public void readMessage(MessageLite.Builder param1Builder, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = readRawVarint32();
      if (this.recursionDepth < this.recursionLimit) {
        i = pushLimit(i);
        this.recursionDepth++;
        param1Builder.mergeFrom(this, param1ExtensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(i);
        return;
      } 
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    public byte readRawByte() throws IOException {
      long l = this.pos;
      if (l != this.limit) {
        this.pos = 1L + l;
        return UnsafeUtil.getByte(l);
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public byte[] readRawBytes(int param1Int) throws IOException {
      if (param1Int >= 0 && param1Int <= remaining()) {
        byte[] arrayOfByte = new byte[param1Int];
        long l1 = this.pos;
        long l2 = param1Int;
        slice(l1, l1 + l2).get(arrayOfByte);
        this.pos += l2;
        return arrayOfByte;
      } 
      if (param1Int <= 0) {
        if (param1Int == 0)
          return Internal.EMPTY_BYTE_ARRAY; 
        throw InvalidProtocolBufferException.negativeSize();
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public int readRawLittleEndian32() throws IOException {
      long l = this.pos;
      if (this.limit - l >= 4L) {
        this.pos = 4L + l;
        byte b1 = UnsafeUtil.getByte(l);
        byte b2 = UnsafeUtil.getByte(1L + l);
        byte b3 = UnsafeUtil.getByte(2L + l);
        return (UnsafeUtil.getByte(l + 3L) & 0xFF) << 24 | b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public long readRawLittleEndian64() throws IOException {
      long l = this.pos;
      if (this.limit - l >= 8L) {
        this.pos = 8L + l;
        long l1 = UnsafeUtil.getByte(l);
        long l2 = UnsafeUtil.getByte(1L + l);
        long l3 = UnsafeUtil.getByte(2L + l);
        long l4 = UnsafeUtil.getByte(3L + l);
        long l5 = UnsafeUtil.getByte(4L + l);
        long l6 = UnsafeUtil.getByte(5L + l);
        long l7 = UnsafeUtil.getByte(6L + l);
        return (UnsafeUtil.getByte(l + 7L) & 0xFFL) << 56L | l1 & 0xFFL | (l2 & 0xFFL) << 8L | (l3 & 0xFFL) << 16L | (l4 & 0xFFL) << 24L | (l5 & 0xFFL) << 32L | (l6 & 0xFFL) << 40L | (l7 & 0xFFL) << 48L;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public int readRawVarint32() throws IOException {
      long l = this.pos;
      if (this.limit != l) {
        long l1 = l + 1L;
        byte b = UnsafeUtil.getByte(l);
        if (b >= 0) {
          this.pos = l1;
          return b;
        } 
        if (this.limit - l1 >= 9L) {
          l = l1 + 1L;
          int i = b ^ UnsafeUtil.getByte(l1) << 7;
          if (i < 0) {
            i ^= 0xFFFFFF80;
          } else {
            l1 = l + 1L;
            i ^= UnsafeUtil.getByte(l) << 14;
            if (i >= 0) {
              i ^= 0x3F80;
              l = l1;
            } else {
              l = l1 + 1L;
              i ^= UnsafeUtil.getByte(l1) << 21;
              if (i < 0) {
                i ^= 0xFFE03F80;
              } else {
                l1 = l + 1L;
                byte b1 = UnsafeUtil.getByte(l);
                int j = i ^ b1 << 28 ^ 0xFE03F80;
                i = j;
                l = l1;
                if (b1 < 0) {
                  long l2 = l1 + 1L;
                  i = j;
                  l = l2;
                  if (UnsafeUtil.getByte(l1) < 0) {
                    l1 = l2 + 1L;
                    i = j;
                    l = l1;
                    if (UnsafeUtil.getByte(l2) < 0) {
                      l2 = l1 + 1L;
                      i = j;
                      l = l2;
                      if (UnsafeUtil.getByte(l1) < 0) {
                        l1 = l2 + 1L;
                        i = j;
                        l = l1;
                        if (UnsafeUtil.getByte(l2) < 0) {
                          l = l1 + 1L;
                          i = j;
                          if (UnsafeUtil.getByte(l1) < 0)
                            return (int)readRawVarint64SlowPath(); 
                        } 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
          this.pos = l;
          return i;
        } 
      } 
      return (int)readRawVarint64SlowPath();
    }
    
    public long readRawVarint64() throws IOException {
      long l2 = this.pos;
      if (this.limit == l2)
        return readRawVarint64SlowPath(); 
      long l1 = l2 + 1L;
      byte b = UnsafeUtil.getByte(l2);
      if (b >= 0) {
        this.pos = l1;
        return b;
      } 
      if (this.limit - l1 < 9L)
        return readRawVarint64SlowPath(); 
      l2 = l1 + 1L;
      int i = b ^ UnsafeUtil.getByte(l1) << 7;
      if (i < 0) {
        i ^= 0xFFFFFF80;
        l1 = l2;
      } else {
        l1 = l2 + 1L;
        i ^= UnsafeUtil.getByte(l2) << 14;
        if (i >= 0) {
          l2 = (i ^ 0x3F80);
        } else {
          l2 = l1 + 1L;
          i ^= UnsafeUtil.getByte(l1) << 21;
          if (i < 0) {
            i ^= 0xFFE03F80;
            l1 = l2;
          } else {
            long l = i;
            l1 = l2 + 1L;
            l2 = l ^ UnsafeUtil.getByte(l2) << 28L;
            if (l2 >= 0L) {
              l = 266354560L;
            } else {
              l = l1 + 1L;
              l2 ^= UnsafeUtil.getByte(l1) << 35L;
              if (l2 < 0L) {
                long l3 = -34093383808L;
                l1 = l;
                l = l3;
              } else {
                l1 = l + 1L;
                l2 ^= UnsafeUtil.getByte(l) << 42L;
                if (l2 >= 0L) {
                  l = 4363953127296L;
                } else {
                  long l3 = l1 + 1L;
                  l2 ^= UnsafeUtil.getByte(l1) << 49L;
                  if (l2 < 0L) {
                    l = -558586000294016L;
                    l1 = l3;
                  } else {
                    l = l3 + 1L;
                    l3 = l2 ^ UnsafeUtil.getByte(l3) << 56L ^ 0xFE03F80FE03F80L;
                    l2 = l3;
                    l1 = l;
                    if (l3 < 0L) {
                      if (UnsafeUtil.getByte(l) < 0L)
                        return readRawVarint64SlowPath(); 
                      l1 = 1L + l;
                      l2 = l3;
                    } 
                    this.pos = l1;
                    return l2;
                  } 
                  l2 ^= l;
                } 
                l2 ^= l;
              } 
              l2 ^= l;
            } 
            l2 ^= l;
          } 
          l2 = i;
        } 
        this.pos = l1;
        return l2;
      } 
      l2 = i;
    }
    
    long readRawVarint64SlowPath() throws IOException {
      long l = 0L;
      for (int i = 0; i < 64; i += 7) {
        byte b = readRawByte();
        l |= (b & Byte.MAX_VALUE) << i;
        if ((b & 0x80) == 0)
          return l; 
      } 
      throw InvalidProtocolBufferException.malformedVarint();
    }
    
    public int readSFixed32() throws IOException {
      return readRawLittleEndian32();
    }
    
    public long readSFixed64() throws IOException {
      return readRawLittleEndian64();
    }
    
    public int readSInt32() throws IOException {
      return decodeZigZag32(readRawVarint32());
    }
    
    public long readSInt64() throws IOException {
      return decodeZigZag64(readRawVarint64());
    }
    
    public String readString() throws IOException {
      int i = readRawVarint32();
      if (i > 0 && i <= remaining()) {
        byte[] arrayOfByte = new byte[i];
        long l1 = this.pos;
        long l2 = i;
        UnsafeUtil.copyMemory(l1, arrayOfByte, 0L, l2);
        String str = new String(arrayOfByte, Internal.UTF_8);
        this.pos += l2;
        return str;
      } 
      if (i == 0)
        return ""; 
      if (i < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public String readStringRequireUtf8() throws IOException {
      int i = readRawVarint32();
      if (i > 0 && i <= remaining()) {
        int j = bufferPos(this.pos);
        String str = Utf8.decodeUtf8(this.buffer, j, i);
        this.pos += i;
        return str;
      } 
      if (i == 0)
        return ""; 
      if (i <= 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    public int readTag() throws IOException {
      if (isAtEnd()) {
        this.lastTag = 0;
        return 0;
      } 
      this.lastTag = readRawVarint32();
      if (WireFormat.getTagFieldNumber(this.lastTag) != 0)
        return this.lastTag; 
      throw InvalidProtocolBufferException.invalidTag();
    }
    
    public int readUInt32() throws IOException {
      return readRawVarint32();
    }
    
    public long readUInt64() throws IOException {
      return readRawVarint64();
    }
    
    @Deprecated
    public void readUnknownGroup(int param1Int, MessageLite.Builder param1Builder) throws IOException {
      readGroup(param1Int, param1Builder, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public void resetSizeCounter() {
      this.startPos = this.pos;
    }
    
    public boolean skipField(int param1Int) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  skipRawBytes(4);
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(param1Int), 4));
            return true;
          } 
          skipRawBytes(readRawVarint32());
          return true;
        } 
        skipRawBytes(8);
        return true;
      } 
      skipRawVarint();
      return true;
    }
    
    public boolean skipField(int param1Int, CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  i = readRawLittleEndian32();
                  param1CodedOutputStream.writeRawVarint32(param1Int);
                  param1CodedOutputStream.writeFixed32NoTag(i);
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            param1CodedOutputStream.writeRawVarint32(param1Int);
            skipMessage(param1CodedOutputStream);
            param1Int = WireFormat.makeTag(WireFormat.getTagFieldNumber(param1Int), 4);
            checkLastTagWas(param1Int);
            param1CodedOutputStream.writeRawVarint32(param1Int);
            return true;
          } 
          ByteString byteString = readBytes();
          param1CodedOutputStream.writeRawVarint32(param1Int);
          param1CodedOutputStream.writeBytesNoTag(byteString);
          return true;
        } 
        long l1 = readRawLittleEndian64();
        param1CodedOutputStream.writeRawVarint32(param1Int);
        param1CodedOutputStream.writeFixed64NoTag(l1);
        return true;
      } 
      long l = readInt64();
      param1CodedOutputStream.writeRawVarint32(param1Int);
      param1CodedOutputStream.writeUInt64NoTag(l);
      return true;
    }
    
    public void skipMessage() throws IOException {
      int i;
      do {
        i = readTag();
      } while (i != 0 && skipField(i));
    }
    
    public void skipMessage(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i;
      do {
        i = readTag();
      } while (i != 0 && skipField(i, param1CodedOutputStream));
    }
    
    public void skipRawBytes(int param1Int) throws IOException {
      if (param1Int >= 0 && param1Int <= remaining()) {
        this.pos += param1Int;
        return;
      } 
      if (param1Int < 0)
        throw InvalidProtocolBufferException.negativeSize(); 
      throw InvalidProtocolBufferException.truncatedMessage();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\CodedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */