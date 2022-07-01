package com.google.protobuf;

public abstract class CodedInputStream {
  int sizeLimit = Integer.MAX_VALUE;
  
  private CodedInputStream() {}
  
  public static CodedInputStream newInstance(byte[] paramArrayOfbyte) {
    return newInstance(paramArrayOfbyte, 0, paramArrayOfbyte.length, false);
  }
  
  static CodedInputStream newInstance(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    CodedInputStream$ArrayDecoder codedInputStream$ArrayDecoder = new CodedInputStream$ArrayDecoder(paramArrayOfbyte, paramInt1, paramInt2, paramBoolean, (byte)0);
    if (paramInt2 >= 0)
      try {
        paramInt1 = paramInt2 + codedInputStream$ArrayDecoder.pos - codedInputStream$ArrayDecoder.startPos;
        if (paramInt1 <= codedInputStream$ArrayDecoder.currentLimit) {
          codedInputStream$ArrayDecoder.currentLimit = paramInt1;
          codedInputStream$ArrayDecoder.limit += codedInputStream$ArrayDecoder.bufferSizeAfterLimit;
          paramInt1 = codedInputStream$ArrayDecoder.limit - codedInputStream$ArrayDecoder.startPos;
          if (paramInt1 > codedInputStream$ArrayDecoder.currentLimit) {
            codedInputStream$ArrayDecoder.bufferSizeAfterLimit = paramInt1 - codedInputStream$ArrayDecoder.currentLimit;
            codedInputStream$ArrayDecoder.limit -= codedInputStream$ArrayDecoder.bufferSizeAfterLimit;
            return codedInputStream$ArrayDecoder;
          } 
          codedInputStream$ArrayDecoder.bufferSizeAfterLimit = 0;
          return codedInputStream$ArrayDecoder;
        } 
        throw InvalidProtocolBufferException.truncatedMessage();
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw new IllegalArgumentException(invalidProtocolBufferException);
      }  
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  public abstract void checkLastTagWas(int paramInt);
  
  public abstract boolean readBool();
  
  public abstract ByteString readBytes();
  
  public abstract int readFixed32();
  
  public abstract long readFixed64();
  
  public abstract long readInt64();
  
  abstract long readRawVarint64SlowPath();
  
  public abstract String readString();
  
  public abstract int readTag();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\CodedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */