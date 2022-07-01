package org.chromium.base.memory;

import android.app.ActivityManager;
import android.os.Build;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import org.chromium.base.Supplier;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.CachedMetrics;

public class MemoryPressureMonitor {
  public static final MemoryPressureMonitor INSTANCE;
  
  private static final CachedMetrics.Count1MHistogramSample sGetMyMemoryStateFailedTime;
  
  private static final CachedMetrics.Count1MHistogramSample sGetMyMemoryStateSucceededTime;
  
  private Supplier mCurrentPressureSupplier = MemoryPressureMonitor$$Lambda$0.$instance;
  
  public boolean mIsInsideThrottlingInterval;
  
  public int mLastReportedPressure = 0;
  
  public boolean mPollingEnabled;
  
  private MemoryPressureCallback mReportingCallback = MemoryPressureMonitor$$Lambda$1.$instance;
  
  Integer mThrottledPressure;
  
  private final int mThrottlingIntervalMs;
  
  private final Runnable mThrottlingIntervalTask = new MemoryPressureMonitor$$Lambda$2(this);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MemoryPressureMonitor(int paramInt) {
    this.mThrottlingIntervalMs = paramInt;
  }
  
  private static long elapsedRealtimeNanos() {
    return (Build.VERSION.SDK_INT >= 17) ? SystemClock.elapsedRealtimeNanos() : (SystemClock.elapsedRealtime() * 1000000L);
  }
  
  private static Integer getCurrentMemoryPressure() {
    long l = elapsedRealtimeNanos();
    try {
      ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(runningAppProcessInfo);
      recordRealtimeNanosDuration(sGetMyMemoryStateSucceededTime, l);
      return memoryPressureFromTrimLevel(runningAppProcessInfo.lastTrimLevel);
    } catch (Exception exception) {
      recordRealtimeNanosDuration(sGetMyMemoryStateFailedTime, l);
      return null;
    } 
  }
  
  public static Integer memoryPressureFromTrimLevel(int paramInt) {
    return (paramInt >= 80 || paramInt == 15) ? Integer.valueOf(2) : ((paramInt >= 40) ? Integer.valueOf(1) : null);
  }
  
  private static void recordRealtimeNanosDuration(CachedMetrics.Count1MHistogramSample paramCount1MHistogramSample, long paramLong) {
    paramCount1MHistogramSample.record((int)Math.min(TimeUnit.NANOSECONDS.toMicros(elapsedRealtimeNanos() - paramLong), 2147483647L));
  }
  
  public final void notifyPressure(int paramInt) {
    ThreadUtils.assertOnUiThread();
    if (this.mIsInsideThrottlingInterval) {
      this.mThrottledPressure = Integer.valueOf(paramInt);
      return;
    } 
    reportPressure(paramInt);
  }
  
  public final void reportCurrentPressure() {
    Integer integer = (Integer)this.mCurrentPressureSupplier.get();
    if (integer != null)
      reportPressure(integer.intValue()); 
  }
  
  final void reportPressure(int paramInt) {
    assert false;
    throw new AssertionError("Can't report pressure when throttling.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\memory\MemoryPressureMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */