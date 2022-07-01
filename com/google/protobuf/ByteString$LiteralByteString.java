package com.google.protobuf;

class ByteString$LiteralByteString extends ByteString$LeafByteString {
  protected final byte[] bytes;
  
  ByteString$LiteralByteString(byte[] paramArrayOfbyte) {
    this.bytes = paramArrayOfbyte;
  }
  
  public byte byteAt(int paramInt) {
    return this.bytes[paramInt];
  }
  
  protected void copyToInternal(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    System.arraycopy(this.bytes, paramInt1, paramArrayOfbyte, paramInt2, paramInt3);
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ByteString))
      return false; 
    if (size() != ((ByteString)paramObject).size())
      return false; 
    if (size() == 0)
      return true; 
    if (paramObject instanceof ByteString$LiteralByteString) {
      paramObject = paramObject;
      int i = this.hash;
      int j = ((ByteString)paramObject).hash;
      if (i != 0 && j != 0 && i != j)
        return false; 
      int k = size();
      if (k <= paramObject.size()) {
        if (k <= paramObject.size()) {
          if (paramObject instanceof ByteString$LiteralByteString) {
            paramObject = paramObject;
            byte[] arrayOfByte1 = this.bytes;
            byte[] arrayOfByte2 = ((ByteString$LiteralByteString)paramObject).bytes;
            int m = getOffsetIntoBytes();
            j = getOffsetIntoBytes();
            for (i = paramObject.getOffsetIntoBytes(); j < m + k; i++) {
              if (arrayOfByte1[j] != arrayOfByte2[i])
                return false; 
              j++;
            } 
            return true;
          } 
          return paramObject.substring(0, k).equals(substring(0, k));
        } 
        StringBuilder stringBuilder = new StringBuilder("Ran off end of other: 0, ");
        stringBuilder.append(k);
        stringBuilder.append(", ");
        stringBuilder.append(paramObject.size());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      paramObject = new StringBuilder("Length too large: ");
      paramObject.append(k);
      paramObject.append(size());
      throw new IllegalArgumentException(paramObject.toString());
    } 
    return paramObject.equals(this);
  }
  
  protected int getOffsetIntoBytes() {
    return 0;
  }
  
  public final CodedInputStream newCodedInput() {
    return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
  }
  
  protected final int partialHash(int paramInt1, int paramInt2, int paramInt3) {
    return Internal.partialHash(paramInt1, this.bytes, getOffsetIntoBytes() + paramInt2, paramInt3);
  }
  
  public int size() {
    return this.bytes.length;
  }
  
  public final ByteString substring(int paramInt1, int paramInt2) {
    paramInt2 = checkRange(paramInt1, paramInt2, size());
    return (paramInt2 == 0) ? ByteString.EMPTY : new ByteString$BoundedByteString(this.bytes, getOffsetIntoBytes() + paramInt1, paramInt2);
  }
  
  final void writeTo(ByteOutput paramByteOutput) {
    paramByteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ByteString$LiteralByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */