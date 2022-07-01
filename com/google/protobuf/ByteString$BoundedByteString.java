package com.google.protobuf;

final class ByteString$BoundedByteString extends ByteString$LiteralByteString {
  private final int bytesLength;
  
  private final int bytesOffset;
  
  ByteString$BoundedByteString(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    super(paramArrayOfbyte);
    checkRange(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    this.bytesOffset = paramInt1;
    this.bytesLength = paramInt2;
  }
  
  public final byte byteAt(int paramInt) {
    int i = this.bytesLength;
    if ((i - paramInt + 1 | paramInt) < 0) {
      if (paramInt < 0) {
        StringBuilder stringBuilder1 = new StringBuilder("Index < 0: ");
        stringBuilder1.append(paramInt);
        throw new ArrayIndexOutOfBoundsException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder("Index > length: ");
      stringBuilder.append(paramInt);
      stringBuilder.append(", ");
      stringBuilder.append(i);
      throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    } 
    return this.bytes[this.bytesOffset + paramInt];
  }
  
  protected final void copyToInternal(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    System.arraycopy(this.bytes, this.bytesOffset + paramInt1, paramArrayOfbyte, paramInt2, paramInt3);
  }
  
  protected final int getOffsetIntoBytes() {
    return this.bytesOffset;
  }
  
  public final int size() {
    return this.bytesLength;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ByteString$BoundedByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */