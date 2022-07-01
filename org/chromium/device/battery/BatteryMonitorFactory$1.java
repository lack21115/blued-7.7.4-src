package org.chromium.device.battery;

import java.util.ArrayList;
import org.chromium.base.ThreadUtils;
import org.chromium.device.mojom.BatteryStatus;

final class BatteryMonitorFactory$1 implements BatteryStatusManager$BatteryStatusCallback {
  public final void onBatteryStatusChanged(BatteryStatus paramBatteryStatus) {
    ThreadUtils.assertOnUiThread();
    for (BatteryMonitorImpl batteryMonitorImpl : new ArrayList(BatteryMonitorFactory.access$000(BatteryMonitorFactory.this))) {
      batteryMonitorImpl.mStatus = paramBatteryStatus;
      batteryMonitorImpl.mHasStatusToReport = true;
      if (batteryMonitorImpl.mCallback != null)
        batteryMonitorImpl.reportStatus(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\battery\BatteryMonitorFactory$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */