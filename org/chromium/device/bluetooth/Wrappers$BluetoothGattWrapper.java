package org.chromium.device.bluetooth;

import android.bluetooth.BluetoothGatt;

final class Wrappers$BluetoothGattWrapper {
  final Wrappers$BluetoothDeviceWrapper mDeviceWrapper;
  
  final BluetoothGatt mGatt;
  
  Wrappers$BluetoothGattWrapper(BluetoothGatt paramBluetoothGatt, Wrappers$BluetoothDeviceWrapper paramWrappers$BluetoothDeviceWrapper) {
    this.mGatt = paramBluetoothGatt;
    this.mDeviceWrapper = paramWrappers$BluetoothDeviceWrapper;
  }
  
  final boolean setCharacteristicNotification(Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper, boolean paramBoolean) {
    return this.mGatt.setCharacteristicNotification(paramWrappers$BluetoothGattCharacteristicWrapper.mCharacteristic, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\Wrappers$BluetoothGattWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */