package org.chromium.device.bluetooth;

import org.chromium.base.Log;

final class ChromeBluetoothDevice$BluetoothGattCallbackImpl$3 implements Runnable {
  public final void run() {
    ChromeBluetoothRemoteGattCharacteristic chromeBluetoothRemoteGattCharacteristic = (ChromeBluetoothRemoteGattCharacteristic)this.this$1.this$0.mWrapperToChromeCharacteristicsMap.get(characteristic);
    if (chromeBluetoothRemoteGattCharacteristic != null) {
      byte[] arrayOfByte = value;
      Log.i("Bluetooth", "onCharacteristicChanged", new Object[0]);
      if (chromeBluetoothRemoteGattCharacteristic.mNativeBluetoothRemoteGattCharacteristicAndroid != 0L)
        chromeBluetoothRemoteGattCharacteristic.nativeOnChanged(chromeBluetoothRemoteGattCharacteristic.mNativeBluetoothRemoteGattCharacteristicAndroid, arrayOfByte); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothDevice$BluetoothGattCallbackImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */