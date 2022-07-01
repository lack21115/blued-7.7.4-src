package org.chromium.android_webview;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.chromium.base.annotations.CalledByNative;

class InputStreamUtil {
  @CalledByNative
  public static int available(InputStream paramInputStream) {
    try {
      return Math.max(-1, paramInputStream.available());
    } catch (IOException iOException) {
      Log.e("InputStreamUtil", logMessage("available"), iOException);
      return -2;
    } 
  }
  
  @CalledByNative
  public static void close(InputStream paramInputStream) {
    try {
      paramInputStream.close();
      return;
    } catch (IOException iOException) {
      Log.e("InputStreamUtil", logMessage("close"), iOException);
      return;
    } 
  }
  
  private static String logMessage(String paramString) {
    StringBuilder stringBuilder = new StringBuilder("Got exception when calling ");
    stringBuilder.append(paramString);
    stringBuilder.append("() on an InputStream returned from shouldInterceptRequest. This will cause the related request to fail.");
    return stringBuilder.toString();
  }
  
  @CalledByNative
  public static int read(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return Math.max(-1, paramInputStream.read(paramArrayOfbyte, paramInt1, paramInt2));
    } catch (IOException iOException) {
      Log.e("InputStreamUtil", logMessage("read"), iOException);
      return -2;
    } 
  }
  
  @CalledByNative
  public static long skip(InputStream paramInputStream, long paramLong) {
    try {
      return Math.max(-1L, paramInputStream.skip(paramLong));
    } catch (IOException iOException) {
      Log.e("InputStreamUtil", logMessage("skip"), iOException);
      return -2L;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\InputStreamUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */