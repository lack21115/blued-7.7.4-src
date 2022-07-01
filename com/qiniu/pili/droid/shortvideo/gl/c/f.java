package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;

public class f extends k {
  private float c = 1.0F;
  
  private float d = 1.0F;
  
  private float e = 1.0F;
  
  private int f;
  
  public int a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    return a(paramInt);
  }
  
  protected String[] a() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform vec4 u_color;\nvoid main() {\n    gl_FragColor = u_color;\n}\n" };
  }
  
  protected boolean c() {
    this.f = GLES20.glGetUniformLocation(this.l, "u_color");
    return super.c();
  }
  
  protected void d() {
    GLES20.glUniform4f(this.f, this.c, this.d, this.e, 1.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */