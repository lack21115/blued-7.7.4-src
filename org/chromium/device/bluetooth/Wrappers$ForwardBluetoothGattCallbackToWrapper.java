package org.chromium.device.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import org.chromium.base.Log;

final class Wrappers$ForwardBluetoothGattCallbackToWrapper extends BluetoothGattCallback {
  private Wrappers$BluetoothDeviceWrapper mDeviceWrapper;
  
  private Wrappers$BluetoothGattCallbackWrapper mWrapperCallback;
  
  Wrappers$ForwardBluetoothGattCallbackToWrapper(Wrappers$BluetoothGattCallbackWrapper paramWrappers$BluetoothGattCallbackWrapper, Wrappers$BluetoothDeviceWrapper paramWrappers$BluetoothDeviceWrapper) {
    this.mWrapperCallback = paramWrappers$BluetoothGattCallbackWrapper;
    this.mDeviceWrapper = paramWrappers$BluetoothDeviceWrapper;
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic) {
    Log.i("Bluetooth", "wrapper onCharacteristicChanged.", new Object[0]);
    this.mWrapperCallback.onCharacteristicChanged((Wrappers$BluetoothGattCharacteristicWrapper)Wrappers$BluetoothDeviceWrapper.access$100(this.mDeviceWrapper).get(paramBluetoothGattCharacteristic));
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt) {
    this.mWrapperCallback.onCharacteristicRead((Wrappers$BluetoothGattCharacteristicWrapper)Wrappers$BluetoothDeviceWrapper.access$100(this.mDeviceWrapper).get(paramBluetoothGattCharacteristic), paramInt);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt) {
    this.mWrapperCallback.onCharacteristicWrite((Wrappers$BluetoothGattCharacteristicWrapper)Wrappers$BluetoothDeviceWrapper.access$100(this.mDeviceWrapper).get(paramBluetoothGattCharacteristic), paramInt);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {
    this.mWrapperCallback.onConnectionStateChange(paramInt1, paramInt2);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt) {
    this.mWrapperCallback.onDescriptorRead((Wrappers$BluetoothGattDescriptorWrapper)Wrappers$BluetoothDeviceWrapper.access$200(this.mDeviceWrapper).get(paramBluetoothGattDescriptor), paramInt);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt) {
    this.mWrapperCallback.onDescriptorWrite((Wrappers$BluetoothGattDescriptorWrapper)Wrappers$BluetoothDeviceWrapper.access$200(this.mDeviceWrapper).get(paramBluetoothGattDescriptor), paramInt);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt) {
    this.mWrapperCallback.onServicesDiscovered(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\Wrappers$ForwardBluetoothGattCallbackToWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */