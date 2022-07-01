package com.google.protobuf;

abstract class CodedOutputStream$AbstractBufferedEncoder extends CodedOutputStream {
  final byte[] buffer;
  
  final int limit;
  
  int position;
  
  int totalBytesWritten;
  
  CodedOutputStream$AbstractBufferedEncoder(int paramInt) {
    super((byte)0);
    if (paramInt >= 0) {
      this.buffer = new byte[Math.max(paramInt, 20)];
      this.limit = this.buffer.length;
      return;
    } 
    throw new IllegalArgumentException("bufferSize must be >= 0");
  }
  
  final void bufferTag(int paramInt1, int paramInt2) {
    bufferUInt32NoTag(paramInt1 << 3 | paramInt2);
  }
  
  final void bufferUInt32NoTag(int paramInt) {
    int i = paramInt;
    if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
      long l2 = CodedOutputStream.ARRAY_BASE_OFFSET + this.position;
      for (long l1 = l2;; l1 = 1L + l1) {
        if ((paramInt & 0xFFFFFF80) == 0) {
          UnsafeUtil.putByte(this.buffer, l1, (byte)paramInt);
          paramInt = (int)(1L + l1 - l2);
          this.position += paramInt;
          this.totalBytesWritten += paramInt;
          return;
        } 
        UnsafeUtil.putByte(this.buffer, l1, (byte)(paramInt & 0x7F | 0x80));
        paramInt >>>= 7;
      } 
    } 
    while (true) {
      if ((i & 0xFFFFFF80) == 0) {
        byte[] arrayOfByte1 = this.buffer;
        paramInt = this.position;
        this.position = paramInt + 1;
        arrayOfByte1[paramInt] = (byte)i;
        this.totalBytesWritten++;
        return;
      } 
      byte[] arrayOfByte = this.buffer;
      paramInt = this.position;
      this.position = paramInt + 1;
      arrayOfByte[paramInt] = (byte)(i & 0x7F | 0x80);
      this.totalBytesWritten++;
      i >>>= 7;
    } 
  }
  
  public final int spaceLeft() {
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\CodedOutputStream$AbstractBufferedEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */