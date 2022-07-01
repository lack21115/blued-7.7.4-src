package com.blued.android.module.external_sense_library.test.gles;

import java.nio.ByteBuffer;

public class GeneratedTexture {
  private static final int[] a = new int[] { 
      -16776961, -16711681, -16711936, -65281, -1, 1073742079, 1073807104, -16711681, -65281, 65280, 
      -2147483393, -16777216, -256, -65281, -256, -65536 };
  
  private static final ByteBuffer b = a();
  
  private static final ByteBuffer c = b();
  
  private static ByteBuffer a() {
    byte[] arrayOfByte = new byte[16384];
    for (int i = 0; i < arrayOfByte.length; i += 4) {
      int k = i / 4;
      int j = k / 64 / 16;
      k = k % 64 / 16;
      j = a[j * 4 + k];
      k = -1;
      if (i == 0) {
        j = k;
      } else if (i == arrayOfByte.length - 4) {
        j = k;
      } 
      k = j >> 24 & 0xFF;
      float f = k / 255.0F;
      arrayOfByte[i] = (byte)(int)((j & 0xFF) * f);
      arrayOfByte[i + 1] = (byte)(int)((j >> 8 & 0xFF) * f);
      arrayOfByte[i + 2] = (byte)(int)((j >> 16 & 0xFF) * f);
      arrayOfByte[i + 3] = (byte)k;
    } 
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(arrayOfByte.length);
    byteBuffer.put(arrayOfByte);
    byteBuffer.position(0);
    return byteBuffer;
  }
  
  private static void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    while (paramInt2 < paramInt4) {
      int i;
      for (i = paramInt1; i < paramInt3; i++) {
        int j;
        int k = i * 4 + paramInt2 * 64 * 4;
        if ((paramInt2 & paramInt7 ^ i & paramInt7) == 0) {
          j = paramInt5;
        } else {
          j = paramInt6;
        } 
        int m = j >> 24 & 0xFF;
        float f = m / 255.0F;
        paramArrayOfbyte[k] = (byte)(int)((j & 0xFF) * f);
        paramArrayOfbyte[k + 1] = (byte)(int)((j >> 8 & 0xFF) * f);
        paramArrayOfbyte[k + 2] = (byte)(int)((j >> 16 & 0xFF) * f);
        paramArrayOfbyte[k + 3] = (byte)m;
      } 
      paramInt2++;
    } 
  }
  
  private static ByteBuffer b() {
    byte[] arrayOfByte = new byte[16384];
    a(arrayOfByte, 0, 0, 32, 32, -16776961, -65536, 1);
    a(arrayOfByte, 32, 32, 64, 64, -16776961, -16711936, 2);
    a(arrayOfByte, 0, 32, 32, 64, -65536, -16711936, 4);
    a(arrayOfByte, 32, 0, 64, 32, -1, -16777216, 8);
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(arrayOfByte.length);
    byteBuffer.put(arrayOfByte);
    byteBuffer.position(0);
    return byteBuffer;
  }
  
  public enum Image {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\test\gles\GeneratedTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */