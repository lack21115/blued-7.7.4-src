package com.tencent.tbs.sdk.extension.partner.incrupdate.a;

public class h {
  public static int a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length == 4) {
      byte b1 = paramArrayOfbyte[0];
      byte b2 = paramArrayOfbyte[1];
      byte b3 = paramArrayOfbyte[2];
      return paramArrayOfbyte[3] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
    } 
    throw new Exception();
  }
  
  public static byte[] a(int paramInt) {
    byte[] arrayOfByte = new byte[4];
    byte b = 3;
    int i = paramInt;
    for (paramInt = b; paramInt >= 0; paramInt--) {
      arrayOfByte[paramInt] = (byte)(i % 256);
      i >>= 8;
    } 
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong) {
    byte[] arrayOfByte = new byte[8];
    for (int i = 7; i >= 0; i--) {
      arrayOfByte[i] = (byte)(int)(paramLong % 256L);
      paramLong >>= 8L;
    } 
    return arrayOfByte;
  }
  
  public static long b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length == 8) {
      long l1 = paramArrayOfbyte[0];
      long l2 = paramArrayOfbyte[1];
      long l3 = paramArrayOfbyte[2];
      long l4 = paramArrayOfbyte[3];
      long l5 = paramArrayOfbyte[4];
      long l6 = paramArrayOfbyte[5];
      return (paramArrayOfbyte[6] & 0xFFL) << 8L | (l1 & 0xFFL) << 56L | (l2 & 0xFFL) << 48L | (l3 & 0xFFL) << 40L | (l4 & 0xFFL) << 32L | (l5 & 0xFFL) << 24L | (l6 & 0xFFL) << 16L | paramArrayOfbyte[7] & 0xFFL;
    } 
    throw new Exception();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */