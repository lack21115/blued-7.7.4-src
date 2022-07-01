package org.chromium.device.bluetooth;

import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

final class ChromeBluetoothRemoteGattDescriptor {
  private ChromeBluetoothDevice mChromeDevice;
  
  final Wrappers$BluetoothGattDescriptorWrapper mDescriptor;
  
  long mNativeBluetoothRemoteGattDescriptorAndroid;
  
  private ChromeBluetoothRemoteGattDescriptor(long paramLong, Wrappers$BluetoothGattDescriptorWrapper paramWrappers$BluetoothGattDescriptorWrapper, ChromeBluetoothDevice paramChromeBluetoothDevice) {
    this.mNativeBluetoothRemoteGattDescriptorAndroid = paramLong;
    this.mDescriptor = paramWrappers$BluetoothGattDescriptorWrapper;
    this.mChromeDevice = paramChromeBluetoothDevice;
    this.mChromeDevice.mWrapperToChromeDescriptorsMap.put(paramWrappers$BluetoothGattDescriptorWrapper, this);
  }
  
  @CalledByNative
  private static ChromeBluetoothRemoteGattDescriptor create(long paramLong, Wrappers$BluetoothGattDescriptorWrapper paramWrappers$BluetoothGattDescriptorWrapper, ChromeBluetoothDevice paramChromeBluetoothDevice) {
    return new ChromeBluetoothRemoteGattDescriptor(paramLong, paramWrappers$BluetoothGattDescriptorWrapper, paramChromeBluetoothDevice);
  }
  
  @CalledByNative
  private String getUUID() {
    return this.mDescriptor.mDescriptor.getUuid().toString();
  }
  
  @CalledByNative
  private void onBluetoothRemoteGattDescriptorAndroidDestruction() {
    this.mNativeBluetoothRemoteGattDescriptorAndroid = 0L;
    this.mChromeDevice.mWrapperToChromeDescriptorsMap.remove(this.mDescriptor);
  }
  
  @CalledByNative
  private boolean readRemoteDescriptor() {
    Wrappers$BluetoothGattWrapper wrappers$BluetoothGattWrapper = this.mChromeDevice.mBluetoothGatt;
    Wrappers$BluetoothGattDescriptorWrapper wrappers$BluetoothGattDescriptorWrapper = this.mDescriptor;
    if (!wrappers$BluetoothGattWrapper.mGatt.readDescriptor(Wrappers$BluetoothGattDescriptorWrapper.access$000(wrappers$BluetoothGattDescriptorWrapper))) {
      Log.i("Bluetooth", "readRemoteDescriptor readDescriptor failed.", new Object[0]);
      return false;
    } 
    return true;
  }
  
  @CalledByNative
  private boolean writeRemoteDescriptor(byte[] paramArrayOfbyte) {
    if (!this.mDescriptor.mDescriptor.setValue(paramArrayOfbyte)) {
      Log.i("Bluetooth", "writeRemoteDescriptor setValue failed.", new Object[0]);
      return false;
    } 
    Wrappers$BluetoothGattWrapper wrappers$BluetoothGattWrapper = this.mChromeDevice.mBluetoothGatt;
    Wrappers$BluetoothGattDescriptorWrapper wrappers$BluetoothGattDescriptorWrapper = this.mDescriptor;
    if (!wrappers$BluetoothGattWrapper.mGatt.writeDescriptor(Wrappers$BluetoothGattDescriptorWrapper.access$000(wrappers$BluetoothGattDescriptorWrapper))) {
      Log.i("Bluetooth", "writeRemoteDescriptor writeDescriptor failed.", new Object[0]);
      return false;
    } 
    return true;
  }
  
  final native void nativeOnRead(long paramLong, int paramInt, byte[] paramArrayOfbyte);
  
  final native void nativeOnWrite(long paramLong, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothRemoteGattDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */