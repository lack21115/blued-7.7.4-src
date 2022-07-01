package org.chromium.android_webview;

import android.os.Handler;
import android.os.Looper;
import org.chromium.base.Callback;

public class AwCookieManager$CookieCallback {
  Callback mCallback;
  
  Handler mHandler;
  
  private AwCookieManager$CookieCallback(Callback paramCallback, Handler paramHandler) {
    this.mCallback = paramCallback;
    this.mHandler = paramHandler;
  }
  
  public static AwCookieManager$CookieCallback convert(Callback paramCallback) {
    if (paramCallback == null)
      return null; 
    if (Looper.myLooper() != null)
      return new AwCookieManager$CookieCallback(paramCallback, new Handler()); 
    throw new IllegalStateException("CookieCallback.convert should be called on a thread with a running Looper.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwCookieManager$CookieCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */