package com.qiniu.pili.droid.shortvideo.gl.texread;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class a {
  private int a;
  
  private int b;
  
  private int c;
  
  public a(String paramString1, String paramString2) {
    this.a = a(35633, paramString1);
    this.b = a(35632, paramString2);
    this.c = GLES20.glCreateProgram();
    int i = this.c;
    if (i != 0) {
      GLES20.glAttachShader(i, this.a);
      GLES20.glAttachShader(this.c, this.b);
      GLES20.glLinkProgram(this.c);
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      GLES20.glGetProgramiv(this.c, 35714, arrayOfInt, 0);
      if (arrayOfInt[0] == 1) {
        GlUtil.a("Creating GlShader");
        return;
      } 
      throw new RuntimeException(GLES20.glGetProgramInfoLog(this.c));
    } 
    throw new RuntimeException("Could not create program");
  }
  
  private static int a(int paramInt, String paramString) {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 1) {
      GlUtil.a("compileShader");
      return paramInt;
    } 
    throw new RuntimeException(GLES20.glGetShaderInfoLog(paramInt));
  }
  
  public int a(String paramString) {
    int i = this.c;
    if (i != -1) {
      i = GLES20.glGetAttribLocation(i, paramString);
      if (i >= 0)
        return i; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not locate '");
      stringBuilder.append(paramString);
      stringBuilder.append("' in program");
      throw new RuntimeException(stringBuilder.toString());
    } 
    throw new RuntimeException("The program has been released");
  }
  
  public void a() {
    int i = this.c;
    if (i != -1) {
      GLES20.glUseProgram(i);
      GlUtil.a("glUseProgram");
      return;
    } 
    throw new RuntimeException("The program has been released");
  }
  
  public void a(String paramString, int paramInt, FloatBuffer paramFloatBuffer) {
    if (this.c != -1) {
      int i = a(paramString);
      GLES20.glEnableVertexAttribArray(i);
      GLES20.glVertexAttribPointer(i, paramInt, 5126, false, 0, paramFloatBuffer);
      GlUtil.a("setVertexAttribArray");
      return;
    } 
    throw new RuntimeException("The program has been released");
  }
  
  public int b(String paramString) {
    int i = this.c;
    if (i != -1) {
      i = GLES20.glGetUniformLocation(i, paramString);
      if (i >= 0)
        return i; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not locate uniform '");
      stringBuilder.append(paramString);
      stringBuilder.append("' in program");
      throw new RuntimeException(stringBuilder.toString());
    } 
    throw new RuntimeException("The program has been released");
  }
  
  public void b() {
    int i = this.a;
    if (i != -1) {
      GLES20.glDeleteShader(i);
      this.a = -1;
    } 
    i = this.b;
    if (i != -1) {
      GLES20.glDeleteShader(i);
      this.b = -1;
    } 
    i = this.c;
    if (i != -1) {
      GLES20.glDeleteProgram(i);
      this.c = -1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\texread\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */