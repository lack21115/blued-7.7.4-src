package org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import org.chromium.base.annotations.CalledByNative;

public class AndroidTrafficStats {
  @CalledByNative
  private static long getCurrentUidRxBytes() {
    long l = TrafficStats.getUidRxBytes(Process.myUid());
    return (l != -1L) ? l : 0L;
  }
  
  @CalledByNative
  private static long getCurrentUidTxBytes() {
    long l = TrafficStats.getUidTxBytes(Process.myUid());
    return (l != -1L) ? l : 0L;
  }
  
  @CalledByNative
  private static long getTotalRxBytes() {
    long l = TrafficStats.getTotalRxBytes();
    return (l != -1L) ? l : 0L;
  }
  
  @CalledByNative
  private static long getTotalTxBytes() {
    long l = TrafficStats.getTotalTxBytes();
    return (l != -1L) ? l : 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidTrafficStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */