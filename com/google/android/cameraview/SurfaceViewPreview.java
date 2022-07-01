package com.google.android.cameraview;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

class SurfaceViewPreview extends PreviewImpl {
  final SurfaceView a;
  
  SurfaceViewPreview(Context paramContext, ViewGroup paramViewGroup) {
    this.a = (SurfaceView)View.inflate(paramContext, R.layout.surface_view, paramViewGroup).findViewById(R.id.surface_view);
    SurfaceHolder surfaceHolder = this.a.getHolder();
    surfaceHolder.setType(3);
    surfaceHolder.addCallback(new SurfaceHolder.Callback(this) {
          public void surfaceChanged(SurfaceHolder param1SurfaceHolder, int param1Int1, int param1Int2, int param1Int3) {
            this.a.b(param1Int2, param1Int3);
            if (!ViewCompat.isInLayout((View)this.a.a))
              this.a.e(); 
          }
          
          public void surfaceCreated(SurfaceHolder param1SurfaceHolder) {}
          
          public void surfaceDestroyed(SurfaceHolder param1SurfaceHolder) {
            this.a.b(0, 0);
          }
        });
  }
  
  Surface a() {
    return f().getSurface();
  }
  
  void a(int paramInt) {}
  
  View b() {
    return (View)this.a;
  }
  
  Class c() {
    return SurfaceHolder.class;
  }
  
  boolean d() {
    return (h() != 0 && i() != 0);
  }
  
  SurfaceHolder f() {
    return this.a.getHolder();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\SurfaceViewPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */