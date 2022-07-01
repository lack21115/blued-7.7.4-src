package com.blued.android.framework.qrcode.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

final class PreviewCallback implements Camera.PreviewCallback {
  private static final String a = PreviewCallback.class.getSimpleName();
  
  private final CameraConfigurationManager b;
  
  private final boolean c;
  
  private Handler d;
  
  private int e;
  
  PreviewCallback(CameraConfigurationManager paramCameraConfigurationManager, boolean paramBoolean) {
    this.b = paramCameraConfigurationManager;
    this.c = paramBoolean;
  }
  
  void a(Handler paramHandler, int paramInt) {
    this.d = paramHandler;
    this.e = paramInt;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfbyte, Camera paramCamera) {
    Point point = this.b.a();
    if (!this.c)
      paramCamera.setPreviewCallback(null); 
    Handler handler = this.d;
    if (handler != null) {
      handler.obtainMessage(this.e, point.x, point.y, paramArrayOfbyte).sendToTarget();
      this.d = null;
      return;
    } 
    Log.d(a, "Got preview callback, but no handler for it");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\camera\PreviewCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */