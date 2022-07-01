package org.chromium.base;

import android.os.Looper;
import android.util.Printer;
import org.chromium.base.annotations.CalledByNative;

public class TraceEvent implements AutoCloseable {
  private static volatile boolean sATraceEnabled;
  
  private static volatile boolean sEnabled;
  
  private final String mName;
  
  private TraceEvent(String paramString1, String paramString2) {
    this.mName = paramString1;
    begin(paramString1, paramString2);
  }
  
  public static void begin(String paramString) {
    begin(paramString, null);
  }
  
  public static void begin(String paramString1, String paramString2) {
    EarlyTraceEvent.begin(paramString1);
    if (sEnabled)
      nativeBegin(paramString1, paramString2); 
  }
  
  public static void end(String paramString) {
    EarlyTraceEvent.end(paramString);
    if (sEnabled)
      nativeEnd(paramString, null); 
  }
  
  public static void instant(String paramString) {
    if (sEnabled)
      nativeInstant(paramString, null); 
  }
  
  public static void instant(String paramString1, String paramString2) {
    if (sEnabled)
      nativeInstant(paramString1, paramString2); 
  }
  
  private static native void nativeBegin(String paramString1, String paramString2);
  
  private static native void nativeBeginToplevel(String paramString);
  
  private static native void nativeEnd(String paramString1, String paramString2);
  
  private static native void nativeEndToplevel();
  
  private static native void nativeFinishAsync(String paramString, long paramLong);
  
  private static native void nativeInstant(String paramString1, String paramString2);
  
  private static native void nativeRegisterEnabledObserver();
  
  private static native void nativeStartATrace();
  
  private static native void nativeStartAsync(String paramString, long paramLong);
  
  private static native void nativeStopATrace();
  
  public static void registerNativeEnabledObserver() {
    nativeRegisterEnabledObserver();
  }
  
  public static TraceEvent scoped(String paramString) {
    return (!EarlyTraceEvent.enabled() && !sEnabled) ? null : new TraceEvent(paramString, null);
  }
  
  public static void setATraceEnabled(boolean paramBoolean) {
    if (sATraceEnabled == paramBoolean)
      return; 
    sATraceEnabled = paramBoolean;
    if (paramBoolean) {
      nativeStartATrace();
      return;
    } 
    nativeStopATrace();
  }
  
  @CalledByNative
  public static void setEnabled(boolean paramBoolean) {
    if (paramBoolean)
      EarlyTraceEvent.disable(); 
    if (sEnabled != paramBoolean) {
      Printer printer;
      sEnabled = paramBoolean;
      if (sATraceEnabled)
        return; 
      Looper looper = ThreadUtils.getUiThreadLooper();
      if (paramBoolean) {
        printer = TraceEvent$LooperMonitorHolder.access$500();
      } else {
        printer = null;
      } 
      looper.setMessageLogging(printer);
    } 
  }
  
  public void close() {
    end(this.mName);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\TraceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */