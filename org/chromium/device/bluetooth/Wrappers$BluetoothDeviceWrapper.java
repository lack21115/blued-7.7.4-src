package org.chromium.device.bluetooth;

import android.bluetooth.BluetoothDevice;
import java.util.HashMap;

class Wrappers$BluetoothDeviceWrapper {
  private final HashMap mCharacteristicsToWrappers;
  
  private final HashMap mDescriptorsToWrappers;
  
  final BluetoothDevice mDevice;
  
  public Wrappers$BluetoothDeviceWrapper(BluetoothDevice paramBluetoothDevice) {
    this.mDevice = paramBluetoothDevice;
    this.mCharacteristicsToWrappers = new HashMap<Object, Object>();
    this.mDescriptorsToWrappers = new HashMap<Object, Object>();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\Wrappers$BluetoothDeviceWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */