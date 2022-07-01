package com.google.protobuf;

final class CodedOutputStream$ArrayEncoder extends CodedOutputStream {
  private final byte[] buffer;
  
  private final int limit;
  
  private int position;
  
  CodedOutputStream$ArrayEncoder(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    super((byte)0);
    if (paramArrayOfbyte != null) {
      int i = paramArrayOfbyte.length;
      int j = paramInt1 + paramInt2;
      if ((paramInt1 | paramInt2 | i - j) >= 0) {
        this.buffer = paramArrayOfbyte;
        this.position = paramInt1;
        this.limit = j;
        return;
      } 
      throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    } 
    throw new NullPointerException("buffer");
  }
  
  public final void flush() {}
  
  public final int spaceLeft() {
    return this.limit - this.position;
  }
  
  public final void writeBool(int paramInt, boolean paramBoolean) {
    writeTag(paramInt, 0);
    byte b = (byte)paramBoolean;
    try {
      byte[] arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = b;
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
    } 
  }
  
  public final void writeBytes(int paramInt, ByteString paramByteString) {
    writeTag(paramInt, 2);
    writeUInt32NoTag(paramByteString.size());
    paramByteString.writeTo(this);
  }
  
  public final void writeFixed32(int paramInt1, int paramInt2) {
    writeTag(paramInt1, 5);
    try {
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
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
    } 
  }
  
  public final void writeFixed64(int paramInt, long paramLong) {
    writeTag(paramInt, 1);
    try {
      byte[] arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = (byte)(int)paramLong;
      arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = (byte)(int)(paramLong >> 8L);
      arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = (byte)(int)(paramLong >> 16L);
      arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = (byte)(int)(paramLong >> 24L);
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
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
    } 
  }
  
  public final void writeLazy(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.position, paramInt2);
      this.position += paramInt2;
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(paramInt2) }), indexOutOfBoundsException);
    } 
  }
  
  public final void writeString(int paramInt, String paramString) {
    writeTag(paramInt, 2);
    paramInt = this.position;
    try {
      int j = computeUInt32SizeNoTag(paramString.length() * 3);
      int i = computeUInt32SizeNoTag(paramString.length());
      if (i == j) {
        this.position = paramInt + i;
        j = Utf8.encode(paramString, this.buffer, this.position, spaceLeft());
        this.position = paramInt;
        writeUInt32NoTag(j - paramInt - i);
        this.position = j;
        return;
      } 
      writeUInt32NoTag(Utf8.encodedLength(paramString));
      this.position = Utf8.encode(paramString, this.buffer, this.position, spaceLeft());
      return;
    } catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
      this.position = paramInt;
      inefficientWriteStringNoTag(paramString, utf8$UnpairedSurrogateException);
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new CodedOutputStream$OutOfSpaceException(indexOutOfBoundsException);
    } 
  }
  
  public final void writeTag(int paramInt1, int paramInt2) {
    writeUInt32NoTag(paramInt1 << 3 | paramInt2);
  }
  
  public final void writeUInt32NoTag(int paramInt) {
    int i = paramInt;
    if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
      i = paramInt;
      if (spaceLeft() >= 10)
        for (long l = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;; l = 1L + l) {
          if ((paramInt & 0xFFFFFF80) == 0) {
            UnsafeUtil.putByte(this.buffer, l, (byte)paramInt);
            this.position++;
            return;
          } 
          UnsafeUtil.putByte(this.buffer, l, (byte)(paramInt & 0x7F | 0x80));
          this.position++;
          paramInt >>>= 7;
        }  
    } 
    while (true) {
      if ((i & 0xFFFFFF80) == 0)
        try {
          byte[] arrayOfByte1 = this.buffer;
          paramInt = this.position;
          this.position = paramInt + 1;
          arrayOfByte1[paramInt] = (byte)i;
          return;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
          throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
        }  
      byte[] arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = (byte)(i & 0x7F | 0x80);
      i >>>= 7;
    } 
  }
  
  public final void writeUInt64(int paramInt, long paramLong) {
    writeTag(paramInt, 0);
    long l = paramLong;
    if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
      l = paramLong;
      if (spaceLeft() >= 10) {
        long l1 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
        l = paramLong;
        for (paramLong = l1;; paramLong = 1L + paramLong) {
          if ((l & 0xFFFFFFFFFFFFFF80L) == 0L) {
            UnsafeUtil.putByte(this.buffer, paramLong, (byte)(int)l);
            this.position++;
            return;
          } 
          UnsafeUtil.putByte(this.buffer, paramLong, (byte)((int)l & 0x7F | 0x80));
          this.position++;
          l >>>= 7L;
        } 
      } 
    } 
    while (true) {
      if ((l & 0xFFFFFFFFFFFFFF80L) == 0L)
        try {
          byte[] arrayOfByte1 = this.buffer;
          paramInt = this.position;
          this.position = paramInt + 1;
          arrayOfByte1[paramInt] = (byte)(int)l;
          return;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
          throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
        }  
      byte[] arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = (byte)((int)l & 0x7F | 0x80);
      l >>>= 7L;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\CodedOutputStream$ArrayEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */