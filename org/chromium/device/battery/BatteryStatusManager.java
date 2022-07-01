package org.chromium.device.battery;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

class BatteryStatusManager {
  BatteryStatusManager$AndroidBatteryManagerWrapper mAndroidBatteryManager;
  
  final BatteryStatusManager$BatteryStatusCallback mCallback;
  
  boolean mEnabled;
  
  final IntentFilter mFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  
  final boolean mIgnoreBatteryPresentState;
  
  final BroadcastReceiver mReceiver = new BatteryStatusManager$1(this);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  BatteryStatusManager(BatteryStatusManager$BatteryStatusCallback paramBatteryStatusManager$BatteryStatusCallback) {
    this(paramBatteryStatusManager$BatteryStatusCallback, bool, batteryStatusManager$AndroidBatteryManagerWrapper);
  }
  
  private BatteryStatusManager(BatteryStatusManager$BatteryStatusCallback paramBatteryStatusManager$BatteryStatusCallback, boolean paramBoolean, BatteryStatusManager$AndroidBatteryManagerWrapper paramBatteryStatusManager$AndroidBatteryManagerWrapper) {
    this.mCallback = paramBatteryStatusManager$BatteryStatusCallback;
    this.mIgnoreBatteryPresentState = paramBoolean;
    this.mAndroidBatteryManager = paramBatteryStatusManager$AndroidBatteryManagerWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\battery\BatteryStatusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */