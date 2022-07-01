package com.blued.android.framework.qrcode.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import com.google.zxing.Result;

public interface OnCaptureHandlerListener {
  void a(int paramInt, Intent paramIntent);
  
  void a(Intent paramIntent);
  
  void a(Result paramResult, Bitmap paramBitmap);
  
  Handler aZ_();
  
  Rect b();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\decoding\OnCaptureHandlerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */