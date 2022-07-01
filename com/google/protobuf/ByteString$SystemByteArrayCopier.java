package com.google.protobuf;

final class ByteString$SystemByteArrayCopier implements ByteString$ByteArrayCopier {
  private ByteString$SystemByteArrayCopier() {}
  
  public final byte[] copyFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ByteString$SystemByteArrayCopier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */