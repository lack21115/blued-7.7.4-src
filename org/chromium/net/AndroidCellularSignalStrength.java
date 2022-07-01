package org.chromium.net;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import org.chromium.base.annotations.CalledByNative;

public class AndroidCellularSignalStrength {
  private static final AndroidCellularSignalStrength sInstance = new AndroidCellularSignalStrength();
  
  private volatile int mSignalLevel = Integer.MIN_VALUE;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private AndroidCellularSignalStrength() {
    if (Build.VERSION.SDK_INT < 23)
      return; 
    HandlerThread handlerThread = new HandlerThread("AndroidCellularSignalStrength");
    handlerThread.start();
    (new Handler(handlerThread.getLooper())).post(new AndroidCellularSignalStrength$1(this));
  }
  
  @TargetApi(23)
  @CalledByNative
  private static int getSignalStrengthLevel() {
    return sInstance.mSignalLevel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidCellularSignalStrength.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */