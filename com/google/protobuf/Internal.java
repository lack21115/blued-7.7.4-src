package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class Internal {
  public static final byte[] EMPTY_BYTE_ARRAY;
  
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  static {
    Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    ByteBuffer.wrap(arrayOfByte);
    CodedInputStream.newInstance(EMPTY_BYTE_ARRAY);
    throw new VerifyError("bad dex opcode");
  }
  
  static Object checkNotNull(Object paramObject) {
    if (paramObject != null)
      return paramObject; 
    throw new NullPointerException();
  }
  
  static Object checkNotNull(Object paramObject, String paramString) {
    if (paramObject != null)
      return paramObject; 
    throw new NullPointerException(paramString);
  }
  
  public static int hashBoolean(boolean paramBoolean) {
    return paramBoolean ? 1231 : 1237;
  }
  
  static int partialHash(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    int i = paramInt1;
    for (paramInt1 = paramInt2; paramInt1 < paramInt2 + paramInt3; paramInt1++)
      i = i * 31 + paramArrayOfbyte[paramInt1]; 
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */