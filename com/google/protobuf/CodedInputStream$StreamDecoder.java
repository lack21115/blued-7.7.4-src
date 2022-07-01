package com.google.protobuf;

import java.io.InputStream;
import java.util.ArrayList;

public final class CodedInputStream$StreamDecoder extends CodedInputStream {
  private final byte[] buffer;
  
  private int bufferSize;
  
  private int bufferSizeAfterLimit;
  
  private int currentLimit = Integer.MAX_VALUE;
  
  private final InputStream input;
  
  private int lastTag;
  
  private int pos;
  
  private int totalBytesRetired;
  
  private CodedInputStream$StreamDecoder(InputStream paramInputStream, int paramInt) {
    super((byte)0);
    Internal.checkNotNull(paramInputStream, "input");
    this.input = paramInputStream;
    this.buffer = new byte[paramInt];
    this.bufferSize = 0;
    this.pos = 0;
    this.totalBytesRetired = 0;
  }
  
  private byte[] readRawBytesSlowPath(int paramInt) {
    if (paramInt == 0)
      return Internal.EMPTY_BYTE_ARRAY; 
    if (paramInt >= 0) {
      int i = this.totalBytesRetired + this.pos + paramInt;
      if (i - this.sizeLimit <= 0) {
        if (i <= this.currentLimit) {
          int k = this.pos;
          i = this.bufferSize - this.pos;
          this.totalBytesRetired += this.bufferSize;
          this.pos = 0;
          this.bufferSize = 0;
          int j = paramInt - i;
          if (j < 4096 || j <= this.input.available()) {
            byte[] arrayOfByte1 = new byte[paramInt];
            System.arraycopy(this.buffer, k, arrayOfByte1, 0, i);
            while (i < paramInt) {
              j = this.input.read(arrayOfByte1, i, paramInt - i);
              if (j != -1) {
                this.totalBytesRetired += j;
                i += j;
                continue;
              } 
              throw InvalidProtocolBufferException.truncatedMessage();
            } 
            return arrayOfByte1;
          } 
          ArrayList<byte[]> arrayList = new ArrayList();
          while (j > 0) {
            byte[] arrayOfByte1 = new byte[Math.min(j, 4096)];
            int m = 0;
            while (m < arrayOfByte1.length) {
              int n = this.input.read(arrayOfByte1, m, arrayOfByte1.length - m);
              if (n != -1) {
                this.totalBytesRetired += n;
                m += n;
                continue;
              } 
              throw InvalidProtocolBufferException.truncatedMessage();
            } 
            j -= arrayOfByte1.length;
            arrayList.add(arrayOfByte1);
          } 
          byte[] arrayOfByte = new byte[paramInt];
          System.arraycopy(this.buffer, k, arrayOfByte, 0, i);
          for (byte[] arrayOfByte1 : arrayList) {
            System.arraycopy(arrayOfByte1, 0, arrayOfByte, i, arrayOfByte1.length);
            i += arrayOfByte1.length;
          } 
          return arrayOfByte;
        } 
        skipRawBytes(this.currentLimit - this.totalBytesRetired - this.pos);
        throw InvalidProtocolBufferException.truncatedMessage();
      } 
      throw InvalidProtocolBufferException.sizeLimitExceeded();
    } 
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  private int readRawVarint32() {
    int i = this.pos;
    if (this.bufferSize != i) {
      byte[] arrayOfByte = this.buffer;
      int j = i + 1;
      byte b = arrayOfByte[i];
      if (b >= 0) {
        this.pos = j;
        return b;
      } 
      if (this.bufferSize - j >= 9) {
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
    if (this.bufferSize != i) {
      byte[] arrayOfByte = this.buffer;
      int j = i + 1;
      byte b = arrayOfByte[i];
      if (b >= 0) {
        this.pos = j;
        return b;
      } 
      if (this.bufferSize - j >= 9) {
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
  
  private void refillBuffer(int paramInt) {
    if (tryRefillBuffer(paramInt))
      return; 
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private void skipRawBytes(int paramInt) {
    if (paramInt <= this.bufferSize - this.pos && paramInt >= 0) {
      this.pos += paramInt;
      return;
    } 
    if (paramInt >= 0) {
      if (this.totalBytesRetired + this.pos + paramInt <= this.currentLimit) {
        int i = this.bufferSize - this.pos;
        this.pos = this.bufferSize;
        refillBuffer(1);
        while (true) {
          int j = paramInt - i;
          if (j > this.bufferSize) {
            i += this.bufferSize;
            this.pos = this.bufferSize;
            refillBuffer(1);
            continue;
          } 
          this.pos = j;
          return;
        } 
      } 
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.pos);
      throw InvalidProtocolBufferException.truncatedMessage();
    } 
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  private boolean tryRefillBuffer(int paramInt) {
    while (this.pos + paramInt > this.bufferSize) {
      if (this.totalBytesRetired + this.pos + paramInt > this.currentLimit)
        return false; 
      int i = this.pos;
      if (i > 0) {
        if (this.bufferSize > i)
          System.arraycopy(this.buffer, i, this.buffer, 0, this.bufferSize - i); 
        this.totalBytesRetired += i;
        this.bufferSize -= i;
        this.pos = 0;
      } 
      i = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
      if (i != 0 && i >= -1 && i <= this.buffer.length) {
        if (i > 0) {
          this.bufferSize += i;
          if (this.totalBytesRetired + paramInt - this.sizeLimit <= 0) {
            this.bufferSize += this.bufferSizeAfterLimit;
            i = this.totalBytesRetired + this.bufferSize;
            if (i > this.currentLimit) {
              this.bufferSizeAfterLimit = i - this.currentLimit;
              this.bufferSize -= this.bufferSizeAfterLimit;
            } else {
              this.bufferSizeAfterLimit = 0;
            } 
            if (this.bufferSize >= paramInt)
              return true; 
            continue;
          } 
          throw InvalidProtocolBufferException.sizeLimitExceeded();
        } 
        return false;
      } 
      StringBuilder stringBuilder1 = new StringBuilder("InputStream#read(byte[]) returned invalid result: ");
      stringBuilder1.append(i);
      stringBuilder1.append("\nThe InputStream implementation is buggy.");
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder("refillBuffer() called when ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" bytes were already available in buffer");
    throw new IllegalStateException(stringBuilder.toString());
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
    int i = readRawVarint32();
    if (i <= this.bufferSize - this.pos && i > 0) {
      ByteString byteString = ByteString.copyFrom(this.buffer, this.pos, i);
      this.pos += i;
      return byteString;
    } 
    return (i == 0) ? ByteString.EMPTY : ByteString.wrap(readRawBytesSlowPath(i));
  }
  
  public final int readFixed32() {
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
  
  public final long readFixed64() {
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
  
  public final long readInt64() {
    return readRawVarint64();
  }
  
  final long readRawVarint64SlowPath() {
    long l = 0L;
    for (int i = 0; i < 64; i += 7) {
      if (this.pos == this.bufferSize)
        refillBuffer(1); 
      byte[] arrayOfByte = this.buffer;
      int j = this.pos;
      this.pos = j + 1;
      j = arrayOfByte[j];
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
        return l; 
    } 
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public final String readString() {
    int i = readRawVarint32();
    if (i > 0 && i <= this.bufferSize - this.pos) {
      String str = new String(this.buffer, this.pos, i, Internal.UTF_8);
      this.pos += i;
      return str;
    } 
    if (i == 0)
      return ""; 
    if (i <= this.bufferSize) {
      refillBuffer(i);
      String str = new String(this.buffer, this.pos, i, Internal.UTF_8);
      this.pos += i;
      return str;
    } 
    return new String(readRawBytesSlowPath(i), Internal.UTF_8);
  }
  
  public final int readTag() {
    int i = this.pos;
    int j = this.bufferSize;
    boolean bool = true;
    if (i != j || tryRefillBuffer(1))
      bool = false; 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\CodedInputStream$StreamDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */