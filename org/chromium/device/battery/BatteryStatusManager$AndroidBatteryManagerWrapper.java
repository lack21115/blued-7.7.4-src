package org.chromium.device.battery;

import android.annotation.TargetApi;
import android.os.BatteryManager;

final class BatteryStatusManager$AndroidBatteryManagerWrapper {
  private final BatteryManager mBatteryManager;
  
  protected BatteryStatusManager$AndroidBatteryManagerWrapper(BatteryManager paramBatteryManager) {
    this.mBatteryManager = paramBatteryManager;
  }
  
  @TargetApi(21)
  public final int getIntProperty(int paramInt) {
    return this.mBatteryManager.getIntProperty(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\battery\BatteryStatusManager$AndroidBatteryManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */