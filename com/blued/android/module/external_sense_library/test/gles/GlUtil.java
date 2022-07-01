package com.blued.android.module.external_sense_library.test.gles;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil {
  public static final float[] a = new float[16];
  
  static {
    Matrix.setIdentityM(a, 0);
  }
  
  public static int a(int paramInt, String paramString) {
    int j = GLES20.glCreateShader(paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("glCreateShader type=");
    stringBuilder.append(paramInt);
    a(stringBuilder.toString());
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    int[] arrayOfInt = new int[1];
    GLES20.glGetShaderiv(j, 35713, arrayOfInt, 0);
    int i = j;
    if (arrayOfInt[0] == 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Could not compile shader ");
      stringBuilder1.append(paramInt);
      stringBuilder1.append(":");
      Log.e("Grafika", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" ");
      stringBuilder1.append(GLES20.glGetShaderInfoLog(j));
      Log.e("Grafika", stringBuilder1.toString());
      GLES20.glDeleteShader(j);
      i = 0;
    } 
    return i;
  }
  
  public static int a(String paramString1, String paramString2) {
    int i = a(35633, paramString1);
    if (i == 0)
      return 0; 
    int j = a(35632, paramString2);
    if (j == 0)
      return 0; 
    int k = GLES20.glCreateProgram();
    a("glCreateProgram");
    if (k == 0)
      Log.e("Grafika", "Could not create program"); 
    GLES20.glAttachShader(k, i);
    a("glAttachShader");
    GLES20.glAttachShader(k, j);
    a("glAttachShader");
    GLES20.glLinkProgram(k);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1) {
      Log.e("Grafika", "Could not link program: ");
      Log.e("Grafika", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    } 
    return k;
  }
  
  public static FloatBuffer a(float[] paramArrayOffloat) {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(paramArrayOffloat.length * 4);
    byteBuffer.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
    floatBuffer.put(paramArrayOffloat);
    floatBuffer.position(0);
    return floatBuffer;
  }
  
  public static void a(String paramString) {
    int i = GLES20.glGetError();
    if (i == 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": glError 0x");
    stringBuilder.append(Integer.toHexString(i));
    paramString = stringBuilder.toString();
    Log.e("Grafika", paramString);
    throw new RuntimeException(paramString);
  }
  
  public static void b(int paramInt, String paramString) {
    if (paramInt >= 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unable to locate '");
    stringBuilder.append(paramString);
    stringBuilder.append("' in program");
    throw new RuntimeException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\test\gles\GlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */