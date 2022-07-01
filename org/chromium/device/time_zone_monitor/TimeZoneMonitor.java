package org.chromium.device.time_zone_monitor;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

class TimeZoneMonitor {
  private final BroadcastReceiver mBroadcastReceiver = new TimeZoneMonitor$1(this);
  
  private final IntentFilter mFilter = new IntentFilter("android.intent.action.TIMEZONE_CHANGED");
  
  private long mNativePtr;
  
  private TimeZoneMonitor(long paramLong) {
    this.mNativePtr = paramLong;
    ContextUtils.sApplicationContext.registerReceiver(this.mBroadcastReceiver, this.mFilter);
  }
  
  @CalledByNative
  static TimeZoneMonitor getInstance(long paramLong) {
    return new TimeZoneMonitor(paramLong);
  }
  
  private native void nativeTimeZoneChangedFromJava(long paramLong);
  
  @CalledByNative
  void stop() {
    ContextUtils.sApplicationContext.unregisterReceiver(this.mBroadcastReceiver);
    this.mNativePtr = 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\time_zone_monitor\TimeZoneMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */