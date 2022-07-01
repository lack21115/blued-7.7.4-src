package com.google.android.cameraview;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

abstract class PreviewImpl {
  private Callback a;
  
  private int b;
  
  private int c;
  
  abstract Surface a();
  
  abstract void a(int paramInt);
  
  void a(int paramInt1, int paramInt2) {}
  
  void a(Callback paramCallback) {
    this.a = paramCallback;
  }
  
  abstract View b();
  
  void b(int paramInt1, int paramInt2) {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  abstract Class c();
  
  abstract boolean d();
  
  protected void e() {
    this.a.a();
  }
  
  SurfaceHolder f() {
    return null;
  }
  
  Object g() {
    return null;
  }
  
  int h() {
    return this.b;
  }
  
  int i() {
    return this.c;
  }
  
  static interface Callback {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\PreviewImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */