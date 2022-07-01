package org.chromium.net;

import android.annotation.TargetApi;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;

final class AndroidCellularSignalStrength$CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
  private final TelephonyManager mTelephonyManager;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  AndroidCellularSignalStrength$CellStateListener() {
    ThreadUtils.assertOnBackgroundThread();
    this.mTelephonyManager = (TelephonyManager)ContextUtils.sApplicationContext.getSystemService("phone");
    if (this.mTelephonyManager.getSimState() != 5)
      return; 
    ApplicationStatus.registerApplicationStateListener(this);
    int i = ApplicationStatus.getStateForApplication();
    if (i == 1) {
      this.mTelephonyManager.listen(this, 256);
      return;
    } 
    if (i == 2) {
      AndroidCellularSignalStrength.access$002(AndroidCellularSignalStrength.this, -2147483648);
      this.mTelephonyManager.listen(this, 0);
    } 
  }
  
  @TargetApi(23)
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength) {
    if (ApplicationStatus.getStateForApplication() != 1)
      return; 
    try {
      AndroidCellularSignalStrength.access$002(AndroidCellularSignalStrength.this, paramSignalStrength.getLevel());
      return;
    } catch (SecurityException securityException) {
      AndroidCellularSignalStrength.access$002(AndroidCellularSignalStrength.this, -2147483648);
      assert false;
      throw new AssertionError();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidCellularSignalStrength$CellStateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */