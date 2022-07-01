package com.blued.android.framework.qrcode.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class AutoFocusCallback implements Camera.AutoFocusCallback {
  private static final String a = AutoFocusCallback.class.getSimpleName();
  
  private Handler b;
  
  private int c;
  
  void a(Handler paramHandler, int paramInt) {
    this.b = paramHandler;
    this.c = paramInt;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {
    Handler handler = this.b;
    if (handler != null) {
      Message message = handler.obtainMessage(this.c, Boolean.valueOf(paramBoolean));
      this.b.sendMessageDelayed(message, 1500L);
      this.b = null;
      return;
    } 
    Log.d(a, "Got auto-focus callback, but no handler for it");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\camera\AutoFocusCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */