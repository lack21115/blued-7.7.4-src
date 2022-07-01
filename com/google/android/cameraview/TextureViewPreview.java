package com.google.android.cameraview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

class TextureViewPreview extends PreviewImpl {
  private final TextureView a;
  
  private int b;
  
  TextureViewPreview(Context paramContext, ViewGroup paramViewGroup) {
    this.a = (TextureView)View.inflate(paramContext, R.layout.texture_view, paramViewGroup).findViewById(R.id.texture_view);
    this.a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) {
          public void onSurfaceTextureAvailable(SurfaceTexture param1SurfaceTexture, int param1Int1, int param1Int2) {
            this.a.b(param1Int1, param1Int2);
            this.a.k();
            this.a.e();
          }
          
          public boolean onSurfaceTextureDestroyed(SurfaceTexture param1SurfaceTexture) {
            this.a.b(0, 0);
            return true;
          }
          
          public void onSurfaceTextureSizeChanged(SurfaceTexture param1SurfaceTexture, int param1Int1, int param1Int2) {
            this.a.b(param1Int1, param1Int2);
            this.a.k();
            this.a.e();
          }
          
          public void onSurfaceTextureUpdated(SurfaceTexture param1SurfaceTexture) {}
        });
  }
  
  Surface a() {
    return new Surface(this.a.getSurfaceTexture());
  }
  
  void a(int paramInt) {
    this.b = paramInt;
    k();
  }
  
  void a(int paramInt1, int paramInt2) {
    this.a.getSurfaceTexture().setDefaultBufferSize(paramInt1, paramInt2);
  }
  
  View b() {
    return (View)this.a;
  }
  
  Class c() {
    return SurfaceTexture.class;
  }
  
  boolean d() {
    return (this.a.getSurfaceTexture() != null);
  }
  
  SurfaceTexture j() {
    return this.a.getSurfaceTexture();
  }
  
  void k() {
    Matrix matrix = new Matrix();
    int i = this.b;
    if (i % 180 == 90) {
      float[] arrayOfFloat;
      i = h();
      int j = i();
      float f1 = i;
      float f2 = j;
      if (this.b == 90) {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = 0.0F;
        arrayOfFloat[1] = f2;
        arrayOfFloat[2] = 0.0F;
        arrayOfFloat[3] = 0.0F;
        arrayOfFloat[4] = f1;
        arrayOfFloat[5] = f2;
        arrayOfFloat[6] = f1;
        arrayOfFloat[7] = 0.0F;
      } else {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = f1;
        arrayOfFloat[1] = 0.0F;
        arrayOfFloat[2] = f1;
        arrayOfFloat[3] = f2;
        arrayOfFloat[4] = 0.0F;
        arrayOfFloat[5] = 0.0F;
        arrayOfFloat[6] = 0.0F;
        arrayOfFloat[7] = f2;
      } 
      matrix.setPolyToPoly(new float[] { 0.0F, 0.0F, f1, 0.0F, 0.0F, f2, f1, f2 }, 0, arrayOfFloat, 0, 4);
    } else if (i == 180) {
      matrix.postRotate(180.0F, (h() / 2), (i() / 2));
    } 
    this.a.setTransform(matrix);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\TextureViewPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */