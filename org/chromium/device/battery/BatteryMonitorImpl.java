package org.chromium.device.battery;

import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.device.mojom.BatteryMonitor;
import org.chromium.device.mojom.BatteryStatus;
import org.chromium.mojo.system.MojoException;

public final class BatteryMonitorImpl implements BatteryMonitor {
  BatteryMonitor.QueryNextStatusResponse mCallback;
  
  private final BatteryMonitorFactory mFactory;
  
  boolean mHasStatusToReport;
  
  BatteryStatus mStatus;
  
  private boolean mSubscribed;
  
  public BatteryMonitorImpl(BatteryMonitorFactory paramBatteryMonitorFactory) {
    this.mFactory = paramBatteryMonitorFactory;
    this.mHasStatusToReport = false;
    this.mSubscribed = true;
  }
  
  private void unsubscribe() {
    if (this.mSubscribed) {
      BatteryMonitorFactory batteryMonitorFactory = this.mFactory;
      ThreadUtils.assertOnUiThread();
      if (BatteryMonitorFactory.$assertionsDisabled || batteryMonitorFactory.mSubscribedMonitors.contains(this)) {
        batteryMonitorFactory.mSubscribedMonitors.remove(this);
        if (batteryMonitorFactory.mSubscribedMonitors.isEmpty()) {
          BatteryStatusManager batteryStatusManager = batteryMonitorFactory.mManager;
          if (batteryStatusManager.mEnabled) {
            ContextUtils.sApplicationContext.unregisterReceiver(batteryStatusManager.mReceiver);
            batteryStatusManager.mEnabled = false;
          } 
        } 
        this.mSubscribed = false;
        return;
      } 
      throw new AssertionError();
    } 
  }
  
  public final void close() {
    unsubscribe();
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    unsubscribe();
  }
  
  public final void queryNextStatus(BatteryMonitor.QueryNextStatusResponse paramQueryNextStatusResponse) {
    if (this.mCallback != null) {
      Log.e("BatteryMonitorImpl", "Overlapped call to queryNextStatus!", new Object[0]);
      unsubscribe();
      return;
    } 
    this.mCallback = paramQueryNextStatusResponse;
    if (this.mHasStatusToReport)
      reportStatus(); 
  }
  
  final void reportStatus() {
    this.mCallback.call(this.mStatus);
    this.mCallback = null;
    this.mHasStatusToReport = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\battery\BatteryMonitorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */