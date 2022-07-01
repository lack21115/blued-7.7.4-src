package com.google.protobuf;

import java.io.OutputStream;

final class CodedOutputStream$OutputStreamEncoder extends CodedOutputStream$AbstractBufferedEncoder {
  private final OutputStream out;
  
  CodedOutputStream$OutputStreamEncoder(OutputStream paramOutputStream, int paramInt) {
    super(paramInt);
    if (paramOutputStream != null) {
      this.out = paramOutputStream;
      return;
    } 
    throw new NullPointerException("out");
  }
  
  private void doFlush() {
    this.out.write(this.buffer, 0, this.position);
    this.position = 0;
  }
  
  private void flushIfNotAvailable(int paramInt) {
    if (this.limit - this.position < paramInt)
      doFlush(); 
  }
  
  public final void flush() {
    if (this.position > 0)
      doFlush(); 
  }
  
  public final void writeBool(int paramInt, boolean paramBoolean) {
    flushIfNotAvailable(11);
    bufferTag(paramInt, 0);
    byte b = (byte)paramBoolean;
    byte[] arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = b;
    this.totalBytesWritten++;
  }
  
  public final void writeBytes(int paramInt, ByteString paramByteString) {
    writeTag(paramInt, 2);
    writeUInt32NoTag(paramByteString.size());
    paramByteString.writeTo(this);
  }
  
  public final void writeFixed32(int paramInt1, int paramInt2) {
    flushIfNotAvailable(14);
    bufferTag(paramInt1, 5);
    byte[] arrayOfByte = this.buffer;
    paramInt1 = this.position;
    this.position = paramInt1 + 1;
    arrayOfByte[paramInt1] = (byte)paramInt2;
    arrayOfByte = this.buffer;
    paramInt1 = this.position;
    this.position = paramInt1 + 1;
    arrayOfByte[paramInt1] = (byte)(paramInt2 >> 8);
    arrayOfByte = this.buffer;
    paramInt1 = this.position;
    this.position = paramInt1 + 1;
    arrayOfByte[paramInt1] = (byte)(paramInt2 >> 16);
    arrayOfByte = this.buffer;
    paramInt1 = this.position;
    this.position = paramInt1 + 1;
    arrayOfByte[paramInt1] = paramInt2 >> 24;
    this.totalBytesWritten += 4;
  }
  
  public final void writeFixed64(int paramInt, long paramLong) {
    flushIfNotAvailable(18);
    bufferTag(paramInt, 1);
    byte[] arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = (byte)(int)(paramLong & 0xFFL);
    arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = (byte)(int)(paramLong >> 8L & 0xFFL);
    arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = (byte)(int)(paramLong >> 16L & 0xFFL);
    arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = (byte)(int)(0xFFL & paramLong >> 24L);
    arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = (byte)(int)(paramLong >> 32L);
    arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = (byte)(int)(paramLong >> 40L);
    arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = (byte)(int)(paramLong >> 48L);
    arrayOfByte = this.buffer;
    paramInt = this.position;
    this.position = paramInt + 1;
    arrayOfByte[paramInt] = (byte)(int)(paramLong >> 56L);
    this.totalBytesWritten += 8;
  }
  
  public final void writeLazy(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (this.limit - this.position >= paramInt2) {
      System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
    } else {
      int i = this.limit - this.position;
      System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.position, i);
      paramInt1 += i;
      paramInt2 -= i;
      this.position = this.limit;
      this.totalBytesWritten += i;
      doFlush();
      if (paramInt2 <= this.limit) {
        System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, 0, paramInt2);
        this.position = paramInt2;
      } else {
        this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
      } 
    } 
    this.totalBytesWritten += paramInt2;
  }
  
  public final void writeString(int paramInt, String paramString) {
    writeTag(paramInt, 2);
    try {
      int i = paramString.length() * 3;
      paramInt = computeUInt32SizeNoTag(i);
      int j = paramInt + i;
      if (j > this.limit) {
        byte[] arrayOfByte = new byte[i];
        paramInt = Utf8.encode(paramString, arrayOfByte, 0, i);
        writeUInt32NoTag(paramInt);
        writeLazy(arrayOfByte, 0, paramInt);
        return;
      } 
      if (j > this.limit - this.position)
        doFlush(); 
      j = computeUInt32SizeNoTag(paramString.length());
      i = this.position;
      if (j == paramInt)
        try {
          this.position = i + j;
          int k = Utf8.encode(paramString, this.buffer, this.position, this.limit - this.position);
          this.position = i;
          paramInt = k - i - j;
          bufferUInt32NoTag(paramInt);
          this.position = k;
          this.totalBytesWritten += paramInt;
          return;
        } catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
          this.totalBytesWritten -= this.position - i;
          this.position = i;
          throw utf8$UnpairedSurrogateException;
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
          throw new CodedOutputStream$OutOfSpaceException(arrayIndexOutOfBoundsException);
        }  
      paramInt = Utf8.encodedLength(paramString);
      bufferUInt32NoTag(paramInt);
      this.position = Utf8.encode(paramString, this.buffer, this.position, paramInt);
      this.totalBytesWritten += paramInt;
      return;
    } catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
      inefficientWriteStringNoTag(paramString, utf8$UnpairedSurrogateException);
      return;
    } 
  }
  
  public final void writeTag(int paramInt1, int paramInt2) {
    writeUInt32NoTag(paramInt1 << 3 | paramInt2);
  }
  
  public final void writeUInt32NoTag(int paramInt) {
    flushIfNotAvailable(10);
    bufferUInt32NoTag(paramInt);
  }
  
  public final void writeUInt64(int paramInt, long paramLong) {
    flushIfNotAvailable(20);
    bufferTag(paramInt, 0);
    long l = paramLong;
    if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
      long l1 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
      for (l = l1;; l = 1L + l) {
        if ((paramLong & 0xFFFFFFFFFFFFFF80L) == 0L) {
          UnsafeUtil.putByte(this.buffer, l, (byte)(int)paramLong);
          paramInt = (int)(1L + l - l1);
          this.position += paramInt;
          this.totalBytesWritten += paramInt;
          return;
        } 
        UnsafeUtil.putByte(this.buffer, l, (byte)((int)paramLong & 0x7F | 0x80));
        paramLong >>>= 7L;
      } 
    } 
    while (true) {
      if ((l & 0xFFFFFFFFFFFFFF80L) == 0L) {
        byte[] arrayOfByte1 = this.buffer;
        paramInt = this.position;
        this.position = paramInt + 1;
        arrayOfByte1[paramInt] = (byte)(int)l;
        this.totalBytesWritten++;
        return;
      } 
      byte[] arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = (byte)((int)l & 0x7F | 0x80);
      this.totalBytesWritten++;
      l >>>= 7L;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\CodedOutputStream$OutputStreamEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */