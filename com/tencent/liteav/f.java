package com.tencent.liteav;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.b.ae;

public class f extends ae {
  private int[] r = null;
  
  private int[] s = null;
  
  private j t;
  
  public f() {
    super("precision mediump float;  \nvarying vec2 textureCoordinate;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvoid main() {   \n\tgl_FragColor = vec4(mix(texture2D(inputImageTexture2, textureCoordinate).rgb, texture2D(inputImageTexture, textureCoordinate).rgb, vec3(0.06,0.21,0.6)),1.0);   \n}  \n");
  }
  
  public int a(int paramInt) {
    if (this.t == null) {
      this.t = new j();
      this.t.a(true);
      this.t.c();
      this.t.a(this.e, this.f);
      j j2 = this.t;
      j2.a(paramInt, j2.m(), this.t.l());
    } 
    paramInt = c(paramInt, this.t.l());
    j j1 = this.t;
    j1.a(paramInt, j1.m(), this.t.l());
    return paramInt;
  }
  
  public boolean a() {
    this.b = GLES20.glGetAttribLocation(this.a, "position");
    this.c = GLES20.glGetUniformLocation(this.a, "inputImageTexture");
    this.d = GLES20.glGetAttribLocation(this.a, "inputTextureCoordinate");
    this.v = GLES20.glGetUniformLocation(q(), "inputImageTexture2");
    return true;
  }
  
  public void b() {
    super.b();
    j j1 = this.t;
    if (j1 != null) {
      j1.e();
      this.t = null;
    } 
    int[] arrayOfInt = this.s;
    if (arrayOfInt != null) {
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      this.s = null;
    } 
    arrayOfInt = this.r;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.r = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */