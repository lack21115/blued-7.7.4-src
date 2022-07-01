package org.chromium.base;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.chromium.base.annotations.CalledByNative;

public class PowerMonitor {
  private static PowerMonitor sInstance;
  
  private boolean mIsBatteryPower;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private static boolean isBatteryPower() {
    if (sInstance == null) {
      ThreadUtils.assertOnUiThread();
      if (sInstance == null) {
        Context context = ContextUtils.sApplicationContext;
        sInstance = new PowerMonitor();
        Intent intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intent != null)
          onBatteryChargingChanged(intent); 
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(new PowerMonitor$1(), intentFilter);
      } 
    } 
    return sInstance.mIsBatteryPower;
  }
  
  private static native void nativeOnBatteryChargingChanged();
  
  private static void onBatteryChargingChanged(Intent paramIntent) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\PowerMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */