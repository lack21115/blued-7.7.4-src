package com.blued.android.module.external_sense_library.glutils;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;

public class GlUtil {
  public static final float[] a = new float[16];
  
  static {
    Matrix.setIdentityM(a, 0);
  }
  
  public static int a() {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public static int a(int paramInt) {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10242, 33071.0F);
    GLES20.glTexParameterf(paramInt, 10243, 33071.0F);
    b("generateTexture");
    return i;
  }
  
  public static void a(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
    int j = paramArrayOfint.length;
    if (j > 0)
      GLES20.glGenTextures(j, paramArrayOfint, 0); 
    int i;
    for (i = 0; i < j; i++) {
      GLES20.glBindTexture(paramInt3, paramArrayOfint[i]);
      GLES20.glTexParameterf(paramInt3, 10240, 9729.0F);
      GLES20.glTexParameterf(paramInt3, 10241, 9729.0F);
      GLES20.glTexParameterf(paramInt3, 10242, 33071.0F);
      GLES20.glTexParameterf(paramInt3, 10243, 33071.0F);
      GLES20.glTexImage2D(paramInt3, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    } 
  }
  
  public static boolean a(String paramString) {
    int i = GLES20.glGetError();
    if (i != 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(": glError 0x");
      stringBuilder.append(Integer.toHexString(i));
      Log.e("GlUtil", stringBuilder.toString());
      return true;
    } 
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0) {
      int i = paramInt1 * paramInt2;
      if (i * 4 == paramArrayOfbyte.length) {
        byte[] arrayOfByte = new byte[i * 3 / 2];
        int m = 0;
        int j = 0;
        int k = 0;
        while (m < paramInt2) {
          int n = 0;
          while (n < paramInt1) {
            int i3 = k + 1;
            byte b1 = paramArrayOfbyte[k];
            int i2 = i3 + 1;
            byte b2 = paramArrayOfbyte[i3];
            k = paramArrayOfbyte[i2];
            i2 = i2 + 1 + 1;
            i3 = b1 & 0xFF;
            int i4 = b2 & 0xFF;
            int i5 = k & 0xFF;
            int i1 = (i3 * 66 + i4 * 129 + i5 * 25 + 128 >> 8) + 16;
            if (i1 > 255) {
              k = 255;
            } else {
              k = i1;
              if (i1 < 0)
                k = 0; 
            } 
            arrayOfByte[j] = (byte)k;
            i1 = i;
            if ((m & 0x1) == 0) {
              i1 = i;
              if ((i2 >> 2 & 0x1) == 0) {
                i1 = i;
                if (i < arrayOfByte.length - 2) {
                  i1 = (i3 * -38 - i4 * 74 + i5 * 112 + 128 >> 8) + 128;
                  i3 = (i3 * 112 - i4 * 94 - i5 * 18 + 128 >> 8) + 128;
                  i4 = i + 1;
                  if (i3 > 255) {
                    k = 255;
                  } else {
                    k = i3;
                    if (i3 < 0)
                      k = 0; 
                  } 
                  arrayOfByte[i] = (byte)k;
                  k = i4 + 1;
                  if (i1 > 255) {
                    i = 255;
                  } else {
                    i = i1;
                    if (i1 < 0)
                      i = 0; 
                  } 
                  arrayOfByte[i4] = (byte)i;
                  i1 = k;
                } 
              } 
            } 
            n++;
            k = i2;
            j++;
            i = i1;
          } 
          m++;
        } 
        return arrayOfByte;
      } 
    } 
    throw new IllegalArgumentException("invalid image params!");
  }
  
  public static void b(String paramString) {
    int i = GLES20.glGetError();
    if (i == 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": GLES20 error: ");
    stringBuilder.append(i);
    throw new RuntimeException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\glutils\GlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */