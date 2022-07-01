package com.qiniu.pili.droid.shortvideo.gl.texread;

import android.opengl.GLES20;

public class b {
  private final int a;
  
  private final int b;
  
  private final int c;
  
  private int d;
  
  private int e;
  
  public b(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid pixel format: ");
        stringBuilder.append(paramInt);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 6407:
      case 6408:
      case 6409:
        break;
    } 
    this.c = paramInt;
    this.b = GlUtil.a(3553);
    this.d = 0;
    this.e = 0;
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.a = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.a);
    GlUtil.a("Generate framebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.b, 0);
    GlUtil.a("Attach texture to framebuffer");
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public int a() {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (paramInt1 != 0 && paramInt2 != 0) {
      if (paramInt1 == this.d && paramInt2 == this.e)
        return; 
      this.d = paramInt1;
      this.e = paramInt2;
      GLES20.glBindFramebuffer(36160, this.a);
      GlUtil.a("glBindFramebuffer");
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.b);
      int i = this.c;
      GLES20.glTexImage2D(3553, 0, i, paramInt1, paramInt2, 0, i, 5121, null);
      paramInt1 = GLES20.glCheckFramebufferStatus(36160);
      if (paramInt1 == 36053) {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Framebuffer not complete, status: ");
      stringBuilder1.append(paramInt1);
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid size: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void b() {
    GLES20.glDeleteTextures(1, new int[] { this.b }, 0);
    GLES20.glDeleteFramebuffers(1, new int[] { this.a }, 0);
    this.d = 0;
    this.e = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\texread\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */