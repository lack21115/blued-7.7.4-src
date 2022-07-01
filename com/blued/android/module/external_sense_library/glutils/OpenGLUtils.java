package com.blued.android.module.external_sense_library.glutils;

import android.opengl.GLES20;
import android.util.Log;

public class OpenGLUtils {
  public static int a() {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    return arrayOfInt[0];
  }
  
  public static int a(int paramInt1, int paramInt2) {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    return arrayOfInt[0];
  }
  
  public static int a(int paramInt1, int paramInt2, int[] paramArrayOfint) {
    GLES20.glGenTextures(1, paramArrayOfint, 0);
    GLES20.glBindTexture(3553, paramArrayOfint[0]);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    return paramArrayOfint[0];
  }
  
  private static int a(String paramString, int paramInt) {
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Compilation\n");
      stringBuilder.append(GLES20.glGetShaderInfoLog(paramInt));
      Log.e("Load Shader Failed", stringBuilder.toString());
      return 0;
    } 
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2) {
    int[] arrayOfInt = new int[1];
    int i = a(paramString1, 35633);
    if (i == 0) {
      Log.d("Load Program", "Vertex Shader Failed");
      return 0;
    } 
    int j = a(paramString2, 35632);
    if (j == 0) {
      Log.d("Load Program", "Fragment Shader Failed");
      return 0;
    } 
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0) {
      Log.d("Load Program", "Linking Failed");
      return 0;
    } 
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\glutils\OpenGLUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */