package org.chromium.device.bluetooth;

abstract class Wrappers$BluetoothGattCallbackWrapper {
  public abstract void onCharacteristicChanged(Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper);
  
  public abstract void onCharacteristicRead(Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper, int paramInt);
  
  public abstract void onCharacteristicWrite(Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper, int paramInt);
  
  public abstract void onConnectionStateChange(int paramInt1, int paramInt2);
  
  public abstract void onDescriptorRead(Wrappers$BluetoothGattDescriptorWrapper paramWrappers$BluetoothGattDescriptorWrapper, int paramInt);
  
  public abstract void onDescriptorWrite(Wrappers$BluetoothGattDescriptorWrapper paramWrappers$BluetoothGattDescriptorWrapper, int paramInt);
  
  public abstract void onServicesDiscovered(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\Wrappers$BluetoothGattCallbackWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */