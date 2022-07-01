package com.google.protobuf;

import java.util.Arrays;

final class CodedInputStream$ArrayDecoder extends CodedInputStream {
  private final byte[] buffer;
  
  int bufferSizeAfterLimit;
  
  int currentLimit = Integer.MAX_VALUE;
  
  private boolean enableAliasing;
  
  private final boolean immutable;
  
  private int lastTag;
  
  int limit;
  
  int pos;
  
  int startPos;
  
  private CodedInputStream$ArrayDecoder(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    super((byte)0);
    this.buffer = paramArrayOfbyte;
    this.limit = paramInt2 + paramInt1;
    this.pos = paramInt1;
    this.startPos = this.pos;
    this.immutable = paramBoolean;
  }
  
  private int readRawVarint32() {
    int i = this.pos;
    if (this.limit != i) {
      byte[] arrayOfByte = this.buffer;
      int j = i + 1;
      byte b = arrayOfByte[i];
      if (b >= 0) {
        this.pos = j;
        return b;
      } 
      if (this.limit - j >= 9) {
        i = j + 1;
        int k = b ^ arrayOfByte[j] << 7;
        if (k < 0) {
          j = k ^ 0xFFFFFF80;
        } else {
          j = i + 1;
          k ^= arrayOfByte[i] << 14;
          if (k >= 0) {
            k ^= 0x3F80;
            i = j;
            j = k;
          } else {
            i = j + 1;
            j = k ^ arrayOfByte[j] << 21;
            if (j < 0) {
              j ^= 0xFFE03F80;
            } else {
              int m = i + 1;
              byte b1 = arrayOfByte[i];
              k = j ^ b1 << 28 ^ 0xFE03F80;
              j = k;
              i = m;
              if (b1 < 0) {
                int n = m + 1;
                j = k;
                i = n;
                if (arrayOfByte[m] < 0) {
                  m = n + 1;
                  j = k;
                  i = m;
                  if (arrayOfByte[n] < 0) {
                    n = m + 1;
                    j = k;
                    i = n;
                    if (arrayOfByte[m] < 0) {
                      m = n + 1;
                      j = k;
                      i = m;
                      if (arrayOfByte[n] < 0) {
                        i = m + 1;
                        if (arrayOfByte[m] >= 0) {
                          j = k;
                          this.pos = i;
                          return j;
                        } 
                      } else {
                        this.pos = i;
                        return j;
                      } 
                    } else {
                      this.pos = i;
                      return j;
                    } 
                  } else {
                    this.pos = i;
                    return j;
                  } 
                } else {
                  this.pos = i;
                  return j;
                } 
              } else {
                this.pos = i;
                return j;
              } 
              return (int)readRawVarint64SlowPath();
            } 
          } 
        } 
        this.pos = i;
        return j;
      } 
    } 
    return (int)readRawVarint64SlowPath();
  }
  
  private long readRawVarint64() {
    int i = this.pos;
    if (this.limit != i) {
      byte[] arrayOfByte = this.buffer;
      int j = i + 1;
      byte b = arrayOfByte[i];
      if (b >= 0) {
        this.pos = j;
        return b;
      } 
      if (this.limit - j >= 9) {
        long l;
        i = j + 1;
        int k = b ^ arrayOfByte[j] << 7;
        if (k < 0) {
          l = (k ^ 0xFFFFFF80);
        } else {
          j = i + 1;
          k ^= arrayOfByte[i] << 14;
          if (k >= 0) {
            l = (k ^ 0x3F80);
            i = j;
          } else {
            i = j + 1;
            j = k ^ arrayOfByte[j] << 21;
            if (j < 0) {
              l = (j ^ 0xFFE03F80);
            } else {
              l = j;
              j = i + 1;
              l = arrayOfByte[i] << 28L ^ l;
              if (l >= 0L) {
                l ^= 0xFE03F80L;
                i = j;
              } else {
                i = j + 1;
                l ^= arrayOfByte[j] << 35L;
                if (l < 0L) {
                  l = 0xFFFFFFF80FE03F80L ^ l;
                } else {
                  j = i + 1;
                  l ^= arrayOfByte[i] << 42L;
                  if (l >= 0L) {
                    l ^= 0x3F80FE03F80L;
                    i = j;
                  } else {
                    i = j + 1;
                    l ^= arrayOfByte[j] << 49L;
                    if (l < 0L) {
                      l = 0xFFFE03F80FE03F80L ^ l;
                    } else {
                      j = i + 1;
                      long l1 = l ^ arrayOfByte[i] << 56L ^ 0xFE03F80FE03F80L;
                      i = j;
                      l = l1;
                      if (l1 < 0L) {
                        i = j + 1;
                        if (arrayOfByte[j] >= 0L) {
                          l = l1;
                          this.pos = i;
                          return l;
                        } 
                      } else {
                        this.pos = i;
                        return l;
                      } 
                      return readRawVarint64SlowPath();
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
        this.pos = i;
        return l;
      } 
    } 
    return readRawVarint64SlowPath();
  }
  
  public final void checkLastTagWas(int paramInt) {
    if (this.lastTag == paramInt)
      return; 
    throw InvalidProtocolBufferException.invalidEndTag();
  }
  
  public final boolean readBool() {
    return (readRawVarint64() != 0L);
  }
  
  public final ByteString readBytes() {
    byte[] arrayOfByte;
    int i = readRawVarint32();
    if (i > 0 && i <= this.limit - this.pos) {
      ByteString byteString;
      if (this.immutable && this.enableAliasing) {
        byteString = ByteString.wrap(this.buffer, this.pos, i);
      } else {
        byteString = ByteString.copyFrom(this.buffer, this.pos, i);
      } 
      this.pos += i;
      return byteString;
    } 
    if (i == 0)
      return ByteString.EMPTY; 
    if (i > 0 && i <= this.limit - this.pos) {
      int j = this.pos;
      this.pos += i;
      arrayOfByte = Arrays.copyOfRange(this.buffer, j, this.pos);
    } else {
      if (i <= 0) {
        if (i == 0) {
          arrayOfByte = Internal.EMPTY_BYTE_ARRAY;
          return ByteString.wrap(arrayOfByte);
        } 
        throw InvalidProtocolBufferException.negativeSize();
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    } 
    return ByteString.wrap(arrayOfByte);
  }
  
  public final int readFixed32() {
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
  
  public final long readFixed64() {
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
  
  public final long readInt64() {
    return readRawVarint64();
  }
  
  final long readRawVarint64SlowPath() {
    long l = 0L;
    int i = 0;
    while (i < 64) {
      if (this.pos != this.limit) {
        byte[] arrayOfByte = this.buffer;
        int j = this.pos;
        this.pos = j + 1;
        j = arrayOfByte[j];
        l |= (j & 0x7F) << i;
        if ((j & 0x80) == 0)
          return l; 
        i += 7;
        continue;
      } 
      throw InvalidProtocolBufferException.truncatedMessage();
    } 
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public final String readString() {
    int i = readRawVarint32();
    if (i > 0 && i <= this.limit - this.pos) {
      String str = new String(this.buffer, this.pos, i, Internal.UTF_8);
      this.pos += i;
      return str;
    } 
    if (i == 0)
      return ""; 
    if (i < 0)
      throw InvalidProtocolBufferException.negativeSize(); 
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public final int readTag() {
    boolean bool;
    if (this.pos == this.limit) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      this.lastTag = 0;
      return 0;
    } 
    this.lastTag = readRawVarint32();
    if (this.lastTag >>> 3 != 0)
      return this.lastTag; 
    throw InvalidProtocolBufferException.invalidTag();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\CodedInputStream$ArrayDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */