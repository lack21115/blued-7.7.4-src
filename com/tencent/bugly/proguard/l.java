package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

public final class l {
  static {
    byte[] arrayOfByte1 = new byte[16];
    arrayOfByte1[0] = 48;
    arrayOfByte1[1] = 49;
    arrayOfByte1[2] = 50;
    arrayOfByte1[3] = 51;
    arrayOfByte1[4] = 52;
    arrayOfByte1[5] = 53;
    arrayOfByte1[6] = 54;
    arrayOfByte1[7] = 55;
    arrayOfByte1[8] = 56;
    arrayOfByte1[9] = 57;
    arrayOfByte1[10] = 65;
    arrayOfByte1[11] = 66;
    arrayOfByte1[12] = 67;
    arrayOfByte1[13] = 68;
    arrayOfByte1[14] = 69;
    arrayOfByte1[15] = 70;
    byte[] arrayOfByte2 = new byte[256];
    byte[] arrayOfByte3 = new byte[256];
    for (int i = 0; i < 256; i++) {
      arrayOfByte2[i] = arrayOfByte1[i >>> 4];
      arrayOfByte3[i] = arrayOfByte1[i & 0xF];
    } 
  }
  
  public static boolean a(int paramInt1, int paramInt2) {
    return (paramInt1 == paramInt2);
  }
  
  public static boolean a(long paramLong1, long paramLong2) {
    return (paramLong1 == paramLong2);
  }
  
  public static boolean a(Object paramObject1, Object paramObject2) {
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean a(boolean paramBoolean1, boolean paramBoolean2) {
    return (paramBoolean1 == paramBoolean2);
  }
  
  public static byte[] a(ByteBuffer paramByteBuffer) {
    byte[] arrayOfByte = new byte[paramByteBuffer.position()];
    System.arraycopy(paramByteBuffer.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */