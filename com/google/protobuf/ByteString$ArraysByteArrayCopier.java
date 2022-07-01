package com.google.protobuf;

import java.util.Arrays;

final class ByteString$ArraysByteArrayCopier implements ByteString$ByteArrayCopier {
  private ByteString$ArraysByteArrayCopier() {}
  
  public final byte[] copyFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return Arrays.copyOfRange(paramArrayOfbyte, paramInt1, paramInt2 + paramInt1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ByteString$ArraysByteArrayCopier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */