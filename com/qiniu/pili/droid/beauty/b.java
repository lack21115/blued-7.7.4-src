package com.qiniu.pili.droid.beauty;

import android.content.Context;

public final class b {
  private int a = -1;
  
  private int b;
  
  private boolean c = false;
  
  public void a() {
    if (this.c)
      JNIControl.reInit(); 
    this.c = false;
    this.a = -1;
  }
  
  public void a(float paramFloat) {
    JNIControl.setBeautify(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    JNIControl.setSurfaceTextureID(paramInt1);
    JNIControl.processThrough(0L, paramInt3, paramInt2, paramInt3, paramInt2, paramInt4);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2) {
    this.c = true;
    if (this.a == -1) {
      if (paramInt1 == 3) {
        JNIControl.setGLES(3);
      } else {
        JNIControl.setGLES(2);
      } 
      JNIControl.onSurfaceCreated(paramContext, paramInt2);
    } 
  }
  
  public void a(boolean paramBoolean) {
    JNIControl.setIsPortraitDisplay(paramBoolean);
  }
  
  public void b(float paramFloat) {
    JNIControl.setWhiten(paramFloat);
  }
  
  public void b(Context paramContext, int paramInt1, int paramInt2) {
    JNIControl.onSurfaceChanged(paramInt1, paramInt2);
    this.b = JNIControl.getOutputTexture();
    JNIControl.setCurrentDirection(1);
  }
  
  public void c(float paramFloat) {
    JNIControl.setRedden(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\beauty\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */