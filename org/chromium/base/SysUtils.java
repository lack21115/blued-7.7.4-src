package org.chromium.base;

import android.app.ActivityManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.CachedMetrics;

public class SysUtils {
  private static Integer sAmountOfPhysicalMemoryKB;
  
  private static Boolean sLowEndDevice;
  
  private static CachedMetrics.BooleanHistogramSample sLowEndMatches;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static int detectAmountOfPhysicalMemoryKB() {
    Pattern pattern = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      FileReader fileReader = new FileReader("/proc/meminfo");
      try {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
      } finally {
        fileReader.close();
      } 
    } catch (Exception exception) {
      Log.w("SysUtils", "Cannot get total physical size from /proc/meminfo", exception);
    } finally {
      Exception exception;
    } 
    StrictMode.setThreadPolicy(threadPolicy);
    return 0;
  }
  
  @CalledByNative
  public static boolean isCurrentlyLowMemory() {
    ActivityManager activityManager = (ActivityManager)ContextUtils.sApplicationContext.getSystemService("activity");
    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
    activityManager.getMemoryInfo(memoryInfo);
    return memoryInfo.lowMemory;
  }
  
  @CalledByNative
  public static boolean isLowEndDevice() {
    if (sLowEndDevice == null) {
      assert false;
      throw new AssertionError();
    } 
    return sLowEndDevice.booleanValue();
  }
  
  private static native void nativeLogPageFaultCountToTracing();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\SysUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */