package com.google.android.cameraview;

import android.view.View;
import java.util.Set;

abstract class CameraViewImpl {
  protected final Callback e;
  
  protected final PreviewImpl f;
  
  CameraViewImpl(Callback paramCallback, PreviewImpl paramPreviewImpl) {
    this.e = paramCallback;
    this.f = paramPreviewImpl;
  }
  
  abstract void a(int paramInt);
  
  abstract void a(boolean paramBoolean);
  
  abstract boolean a();
  
  abstract boolean a(AspectRatio paramAspectRatio);
  
  abstract void b();
  
  abstract void b(int paramInt);
  
  abstract void c(int paramInt);
  
  abstract boolean d();
  
  abstract int e();
  
  abstract Set<AspectRatio> f();
  
  abstract AspectRatio g();
  
  abstract boolean h();
  
  abstract int i();
  
  abstract void j();
  
  View o() {
    return this.f.b();
  }
  
  static interface Callback {
    void a();
    
    void a(byte[] param1ArrayOfbyte);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\CameraViewImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */