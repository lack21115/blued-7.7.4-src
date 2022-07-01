package org.chromium.content.browser;

import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

class MemoryMonitorAndroid {
  private static ComponentCallbacks2 sCallbacks;
  
  private static final ActivityManager.MemoryInfo sMemoryInfo = new ActivityManager.MemoryInfo();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private static void getMemoryInfo(long paramLong) {
    ActivityManager activityManager = (ActivityManager)ContextUtils.sApplicationContext.getSystemService("activity");
    try {
      activityManager.getMemoryInfo(sMemoryInfo);
    } catch (RuntimeException runtimeException) {
      Log.e("MemoryMonitorAndroid", "Failed to get memory info due to a runtime exception: %s", new Object[] { runtimeException });
      sMemoryInfo.availMem = 1L;
      sMemoryInfo.lowMemory = true;
      sMemoryInfo.threshold = 1L;
      sMemoryInfo.totalMem = 1L;
    } 
    nativeGetMemoryInfoCallback(sMemoryInfo.availMem, sMemoryInfo.lowMemory, sMemoryInfo.threshold, sMemoryInfo.totalMem, paramLong);
  }
  
  private static native void nativeGetMemoryInfoCallback(long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4);
  
  private static native void nativeOnTrimMemory(int paramInt);
  
  @CalledByNative
  private static void registerComponentCallbacks() {
    sCallbacks = new MemoryMonitorAndroid$1();
    ContextUtils.sApplicationContext.registerComponentCallbacks((ComponentCallbacks)sCallbacks);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\MemoryMonitorAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */