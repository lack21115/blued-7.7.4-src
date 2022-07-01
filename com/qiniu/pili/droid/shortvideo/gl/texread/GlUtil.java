package com.qiniu.pili.droid.shortvideo.gl.texread;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil {
  public static final float[] a = new float[16];
  
  private static int b = 2;
  
  static {
    Matrix.setIdentityM(a, 0);
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
    a("generateTexture");
    return i;
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
    stringBuilder.append(": GLES20 error: ");
    stringBuilder.append(i);
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public static boolean a() {
    return (b > 2);
  }
  
  public static int b(int paramInt) {
    int[] arrayOfInt = new int[1];
    GLES20.glGenBuffers(1, arrayOfInt, 0);
    GLES20.glBindBuffer(35051, arrayOfInt[0]);
    GLES20.glBufferData(35051, paramInt, null, 35049);
    GLES20.glBindBuffer(35051, 0);
    return arrayOfInt[0];
  }
  
  public static native void read(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\texread\GlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */