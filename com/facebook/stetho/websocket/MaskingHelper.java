package com.facebook.stetho.websocket;

class MaskingHelper {
  public static void unmask(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
    byte b = 0;
    int i = paramInt1;
    for (paramInt1 = b; paramInt2 > 0; paramInt1++) {
      b = paramArrayOfbyte2[i];
      paramArrayOfbyte2[i] = (byte)(paramArrayOfbyte1[paramInt1 % paramArrayOfbyte1.length] ^ b);
      i++;
      paramInt2--;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\MaskingHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */