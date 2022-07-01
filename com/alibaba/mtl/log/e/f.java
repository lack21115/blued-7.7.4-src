package com.alibaba.mtl.log.e;

public class f {
  public static byte[] getBytes(int paramInt) {
    byte b1 = (byte)(paramInt % 256);
    paramInt >>= 8;
    byte b2 = (byte)(paramInt % 256);
    paramInt >>= 8;
    byte b3 = (byte)(paramInt % 256);
    return new byte[] { (byte)((paramInt >> 8) % 256), b3, b2, b1 };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */