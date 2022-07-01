package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil {
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\zegoVideoCapture\ve_gl\GlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */