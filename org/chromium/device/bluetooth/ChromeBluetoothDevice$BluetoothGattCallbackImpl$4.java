package org.chromium.device.bluetooth;

import org.chromium.base.Log;
import org.chromium.base.metrics.RecordHistogram;

final class ChromeBluetoothDevice$BluetoothGattCallbackImpl$4 implements Runnable {
  public final void run() {
    ChromeBluetoothRemoteGattCharacteristic chromeBluetoothRemoteGattCharacteristic = (ChromeBluetoothRemoteGattCharacteristic)this.this$1.this$0.mWrapperToChromeCharacteristicsMap.get(characteristic);
    if (chromeBluetoothRemoteGattCharacteristic != null) {
      String str;
      RecordHistogram.recordSparseSlowlyHistogram("Bluetooth.Web.Android.onCharacteristicRead.Status", status);
      int i = status;
      if (i == 0) {
        str = "OK";
      } else {
        str = "Error";
      } 
      Log.i("Bluetooth", "onCharacteristicRead status:%d==%s", new Object[] { Integer.valueOf(i), str });
      if (chromeBluetoothRemoteGattCharacteristic.mNativeBluetoothRemoteGattCharacteristicAndroid != 0L)
        chromeBluetoothRemoteGattCharacteristic.nativeOnRead(chromeBluetoothRemoteGattCharacteristic.mNativeBluetoothRemoteGattCharacteristicAndroid, i, chromeBluetoothRemoteGattCharacteristic.mCharacteristic.mCharacteristic.getValue()); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothDevice$BluetoothGattCallbackImpl$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */