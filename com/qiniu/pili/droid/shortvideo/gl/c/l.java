package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.f.d;
import java.nio.ByteBuffer;

public class l extends k {
  public byte[] h() {
    GLES20.glBindFramebuffer(36160, this.a);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.b, 0);
    ByteBuffer byteBuffer = ByteBuffer.allocate(this.i * 4 * this.j);
    GLES20.glReadPixels(0, 0, this.i, this.j, 6408, 5121, byteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    return byteBuffer.array();
  }
  
  protected float[] j() {
    return d.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */