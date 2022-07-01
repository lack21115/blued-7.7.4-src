package org.chromium.device.bluetooth;

import android.bluetooth.le.ScanResult;

final class Wrappers$ScanResultWrapper {
  final ScanResult mScanResult;
  
  public Wrappers$ScanResultWrapper(ScanResult paramScanResult) {
    this.mScanResult = paramScanResult;
  }
  
  public final Wrappers$BluetoothDeviceWrapper getDevice() {
    return new Wrappers$BluetoothDeviceWrapper(this.mScanResult.getDevice());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\Wrappers$ScanResultWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */