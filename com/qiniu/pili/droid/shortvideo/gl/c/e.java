package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;

public class e extends k {
  private float c = 1.0F;
  
  private int d;
  
  public int a(int paramInt1, float paramFloat, float[] paramArrayOffloat, int paramInt2, boolean paramBoolean) {
    this.c = paramFloat;
    GLES20.glBindFramebuffer(36160, this.a);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt2, 0);
    if (paramBoolean)
      GLES20.glClear(16384); 
    a(paramInt1, paramArrayOffloat);
    GLES20.glBindFramebuffer(36160, 0);
    return paramInt2;
  }
  
  protected String[] a() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex_coord) * u_alpha;\n}\n" };
  }
  
  protected boolean c() {
    this.d = GLES20.glGetUniformLocation(this.l, "u_alpha");
    return super.c();
  }
  
  protected void d() {
    GLES20.glUniform1f(this.d, this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */