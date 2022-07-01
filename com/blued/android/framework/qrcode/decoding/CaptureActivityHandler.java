package com.blued.android.framework.qrcode.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.blued.android.framework.qrcode.camera.CameraManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.Vector;

public final class CaptureActivityHandler extends Handler {
  private static final String a = CaptureActivityHandler.class.getSimpleName();
  
  private final OnCaptureHandlerListener b;
  
  private final DecodeThread c;
  
  private State d;
  
  public CaptureActivityHandler(OnCaptureHandlerListener paramOnCaptureHandlerListener, Vector<BarcodeFormat> paramVector, String paramString) {
    this.b = paramOnCaptureHandlerListener;
    this.c = new DecodeThread(paramOnCaptureHandlerListener, paramVector, paramString);
    this.c.start();
    this.d = State.b;
    CameraManager.a().d();
    b();
  }
  
  private void b() {
    if (this.d == State.b) {
      this.d = State.a;
      CameraManager.a().a(this.c.a(), 2000);
      CameraManager.a().b(this, 1001);
    } 
  }
  
  public void a() {
    this.d = State.d;
    CameraManager.a().e();
    Message.obtain(this.c.a(), 4002).sendToTarget();
    try {
      this.c.join();
    } catch (InterruptedException interruptedException) {}
    removeMessages(2002);
    removeMessages(2001);
  }
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 1001) {
      if (i != 4001) {
        if (i != 2001) {
          Bitmap bitmap;
          if (i != 2002) {
            if (i != 4003) {
              if (i != 4004)
                return; 
              Log.d(a, "Got return scan result message");
              this.b.a(-1, (Intent)paramMessage.obj);
              return;
            } 
            Log.d(a, "Got restart preview message");
            b();
            return;
          } 
          Log.d(a, "Got decode succeeded message");
          this.d = State.b;
          Bundle bundle = paramMessage.getData();
          if (bundle == null) {
            bundle = null;
          } else {
            bitmap = (Bitmap)bundle.getParcelable("barcode_bitmap");
          } 
          this.b.a((Result)paramMessage.obj, bitmap);
          return;
        } 
        this.d = State.a;
        CameraManager.a().a(this.c.a(), 2000);
        return;
      } 
      Log.d(a, "Got product query message");
      Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)paramMessage.obj));
      intent.addFlags(524288);
      this.b.a(intent);
      return;
    } 
    if (this.d == State.a)
      CameraManager.a().b(this, 1001); 
  }
  
  enum State {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\decoding\CaptureActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */