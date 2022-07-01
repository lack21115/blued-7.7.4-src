package org.chromium.device.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(23)
final class ChromeBluetoothRemoteGattCharacteristic {
  final Wrappers$BluetoothGattCharacteristicWrapper mCharacteristic;
  
  private ChromeBluetoothDevice mChromeDevice;
  
  private String mInstanceId;
  
  long mNativeBluetoothRemoteGattCharacteristicAndroid;
  
  private ChromeBluetoothRemoteGattCharacteristic(long paramLong, Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper, String paramString, ChromeBluetoothDevice paramChromeBluetoothDevice) {
    this.mNativeBluetoothRemoteGattCharacteristicAndroid = paramLong;
    this.mCharacteristic = paramWrappers$BluetoothGattCharacteristicWrapper;
    this.mInstanceId = paramString;
    this.mChromeDevice = paramChromeBluetoothDevice;
    this.mChromeDevice.mWrapperToChromeCharacteristicsMap.put(paramWrappers$BluetoothGattCharacteristicWrapper, this);
  }
  
  @CalledByNative
  private static ChromeBluetoothRemoteGattCharacteristic create(long paramLong, Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper, String paramString, ChromeBluetoothDevice paramChromeBluetoothDevice) {
    return new ChromeBluetoothRemoteGattCharacteristic(paramLong, paramWrappers$BluetoothGattCharacteristicWrapper, paramString, paramChromeBluetoothDevice);
  }
  
  @CalledByNative
  private void createDescriptors() {
    Wrappers$BluetoothGattCharacteristicWrapper wrappers$BluetoothGattCharacteristicWrapper = this.mCharacteristic;
    List list = wrappers$BluetoothGattCharacteristicWrapper.mCharacteristic.getDescriptors();
    ArrayList<Wrappers$BluetoothGattDescriptorWrapper> arrayList = new ArrayList(list.size());
    for (BluetoothGattDescriptor bluetoothGattDescriptor : list) {
      Wrappers$BluetoothGattDescriptorWrapper wrappers$BluetoothGattDescriptorWrapper2 = (Wrappers$BluetoothGattDescriptorWrapper)Wrappers$BluetoothDeviceWrapper.access$200(wrappers$BluetoothGattCharacteristicWrapper.mDeviceWrapper).get(bluetoothGattDescriptor);
      Wrappers$BluetoothGattDescriptorWrapper wrappers$BluetoothGattDescriptorWrapper1 = wrappers$BluetoothGattDescriptorWrapper2;
      if (wrappers$BluetoothGattDescriptorWrapper2 == null) {
        wrappers$BluetoothGattDescriptorWrapper1 = new Wrappers$BluetoothGattDescriptorWrapper(bluetoothGattDescriptor);
        Wrappers$BluetoothDeviceWrapper.access$200(wrappers$BluetoothGattCharacteristicWrapper.mDeviceWrapper).put(bluetoothGattDescriptor, wrappers$BluetoothGattDescriptorWrapper1);
      } 
      arrayList.add(wrappers$BluetoothGattDescriptorWrapper1);
    } 
    int i = 0;
    for (Wrappers$BluetoothGattDescriptorWrapper wrappers$BluetoothGattDescriptorWrapper : arrayList) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mInstanceId);
      stringBuilder.append("/");
      stringBuilder.append(wrappers$BluetoothGattDescriptorWrapper.mDescriptor.getUuid().toString());
      stringBuilder.append(";");
      stringBuilder.append(i);
      String str = stringBuilder.toString();
      nativeCreateGattRemoteDescriptor(this.mNativeBluetoothRemoteGattCharacteristicAndroid, str, wrappers$BluetoothGattDescriptorWrapper, this.mChromeDevice);
      i++;
    } 
  }
  
  @CalledByNative
  private int getProperties() {
    return this.mCharacteristic.mCharacteristic.getProperties();
  }
  
  @CalledByNative
  private String getUUID() {
    return this.mCharacteristic.mCharacteristic.getUuid().toString();
  }
  
  private native void nativeCreateGattRemoteDescriptor(long paramLong, String paramString, Wrappers$BluetoothGattDescriptorWrapper paramWrappers$BluetoothGattDescriptorWrapper, ChromeBluetoothDevice paramChromeBluetoothDevice);
  
  @CalledByNative
  private void onBluetoothRemoteGattCharacteristicAndroidDestruction() {
    if (this.mChromeDevice.mBluetoothGatt != null)
      this.mChromeDevice.mBluetoothGatt.setCharacteristicNotification(this.mCharacteristic, false); 
    this.mNativeBluetoothRemoteGattCharacteristicAndroid = 0L;
    this.mChromeDevice.mWrapperToChromeCharacteristicsMap.remove(this.mCharacteristic);
  }
  
  @CalledByNative
  private boolean readRemoteCharacteristic() {
    Wrappers$BluetoothGattWrapper wrappers$BluetoothGattWrapper = this.mChromeDevice.mBluetoothGatt;
    Wrappers$BluetoothGattCharacteristicWrapper wrappers$BluetoothGattCharacteristicWrapper = this.mCharacteristic;
    if (!wrappers$BluetoothGattWrapper.mGatt.readCharacteristic(wrappers$BluetoothGattCharacteristicWrapper.mCharacteristic)) {
      Log.i("Bluetooth", "readRemoteCharacteristic readCharacteristic failed.", new Object[0]);
      return false;
    } 
    return true;
  }
  
  @CalledByNative
  private boolean setCharacteristicNotification(boolean paramBoolean) {
    return this.mChromeDevice.mBluetoothGatt.setCharacteristicNotification(this.mCharacteristic, paramBoolean);
  }
  
  @CalledByNative
  private boolean writeRemoteCharacteristic(byte[] paramArrayOfbyte) {
    if (!this.mCharacteristic.mCharacteristic.setValue(paramArrayOfbyte)) {
      Log.i("Bluetooth", "writeRemoteCharacteristic setValue failed.", new Object[0]);
      return false;
    } 
    Wrappers$BluetoothGattWrapper wrappers$BluetoothGattWrapper = this.mChromeDevice.mBluetoothGatt;
    Wrappers$BluetoothGattCharacteristicWrapper wrappers$BluetoothGattCharacteristicWrapper = this.mCharacteristic;
    if (!wrappers$BluetoothGattWrapper.mGatt.writeCharacteristic(wrappers$BluetoothGattCharacteristicWrapper.mCharacteristic)) {
      Log.i("Bluetooth", "writeRemoteCharacteristic writeCharacteristic failed.", new Object[0]);
      return false;
    } 
    return true;
  }
  
  final native void nativeOnChanged(long paramLong, byte[] paramArrayOfbyte);
  
  final native void nativeOnRead(long paramLong, int paramInt, byte[] paramArrayOfbyte);
  
  final native void nativeOnWrite(long paramLong, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothRemoteGattCharacteristic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */