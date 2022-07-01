package com.blued.android.module.external_sense_library.encoder.utils;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GLDrawer2D {
  private static final float[] e = new float[] { 1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, -1.0F, -1.0F };
  
  private static final float[] f = new float[] { 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  
  int a;
  
  int b;
  
  int c;
  
  int d;
  
  private final FloatBuffer g = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
  
  private final FloatBuffer h;
  
  private int i;
  
  private final float[] j = new float[16];
  
  public GLDrawer2D() {
    this.g.put(e);
    this.g.flip();
    this.h = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.h.put(f);
    this.h.flip();
    this.i = a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\n\nvoid main() {\n\tgl_Position = uMVPMatrix * aPosition;\n\tvTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nuniform sampler2D sTexture;\nvarying highp vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
    GLES20.glUseProgram(this.i);
    this.a = GLES20.glGetAttribLocation(this.i, "aPosition");
    this.b = GLES20.glGetAttribLocation(this.i, "aTextureCoord");
    this.c = GLES20.glGetUniformLocation(this.i, "uMVPMatrix");
    this.d = GLES20.glGetUniformLocation(this.i, "uTexMatrix");
    Matrix.setIdentityM(this.j, 0);
    GLES20.glUniformMatrix4fv(this.c, 1, false, this.j, 0);
    GLES20.glUniformMatrix4fv(this.d, 1, false, this.j, 0);
    GLES20.glVertexAttribPointer(this.a, 2, 5126, false, 8, this.g);
    GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 8, this.h);
    GLES20.glEnableVertexAttribArray(this.a);
    GLES20.glEnableVertexAttribArray(this.b);
  }
  
  public static int a(String paramString1, String paramString2) {
    int k = GLES20.glCreateShader(35633);
    GLES20.glShaderSource(k, paramString1);
    GLES20.glCompileShader(k);
    int[] arrayOfInt = new int[1];
    int j = 0;
    GLES20.glGetShaderiv(k, 35713, arrayOfInt, 0);
    int i = k;
    if (arrayOfInt[0] == 0) {
      GLES20.glDeleteShader(k);
      i = 0;
    } 
    k = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(k, paramString2);
    GLES20.glCompileShader(k);
    GLES20.glGetShaderiv(k, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0) {
      GLES20.glDeleteShader(k);
    } else {
      j = k;
    } 
    k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    return k;
  }
  
  public void a() {
    int i = this.i;
    if (i >= 0)
      GLES20.glDeleteProgram(i); 
    this.i = -1;
  }
  
  public void a(int paramInt, float[] paramArrayOffloat) {
    GLES20.glUseProgram(this.i);
    if (paramArrayOffloat != null)
      GLES20.glUniformMatrix4fv(this.d, 1, false, paramArrayOffloat, 0); 
    GLES20.glUniformMatrix4fv(this.c, 1, false, this.j, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindTexture(3553, 0);
    GLES20.glUseProgram(0);
  }
  
  public void a(float[] paramArrayOffloat, int paramInt) {
    if (paramArrayOffloat != null && paramArrayOffloat.length >= paramInt + 16) {
      System.arraycopy(paramArrayOffloat, paramInt, this.j, 0, 16);
      return;
    } 
    Matrix.setIdentityM(this.j, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\encode\\utils\GLDrawer2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */