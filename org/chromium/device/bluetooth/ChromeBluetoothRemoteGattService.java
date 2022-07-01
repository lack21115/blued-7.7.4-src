package org.chromium.device.bluetooth;

import android.bluetooth.BluetoothGattCharacteristic;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;

final class ChromeBluetoothRemoteGattService {
  private ChromeBluetoothDevice mChromeDevice;
  
  private String mInstanceId;
  
  private long mNativeBluetoothRemoteGattServiceAndroid;
  
  private Wrappers$BluetoothGattServiceWrapper mService;
  
  private ChromeBluetoothRemoteGattService(long paramLong, Wrappers$BluetoothGattServiceWrapper paramWrappers$BluetoothGattServiceWrapper, String paramString, ChromeBluetoothDevice paramChromeBluetoothDevice) {
    this.mNativeBluetoothRemoteGattServiceAndroid = paramLong;
    this.mService = paramWrappers$BluetoothGattServiceWrapper;
    this.mInstanceId = paramString;
    this.mChromeDevice = paramChromeBluetoothDevice;
  }
  
  @CalledByNative
  private static ChromeBluetoothRemoteGattService create(long paramLong, Wrappers$BluetoothGattServiceWrapper paramWrappers$BluetoothGattServiceWrapper, String paramString, ChromeBluetoothDevice paramChromeBluetoothDevice) {
    return new ChromeBluetoothRemoteGattService(paramLong, paramWrappers$BluetoothGattServiceWrapper, paramString, paramChromeBluetoothDevice);
  }
  
  @CalledByNative
  private void createCharacteristics() {
    Wrappers$BluetoothGattServiceWrapper wrappers$BluetoothGattServiceWrapper = this.mService;
    List list = wrappers$BluetoothGattServiceWrapper.mService.getCharacteristics();
    ArrayList<Wrappers$BluetoothGattCharacteristicWrapper> arrayList = new ArrayList(list.size());
    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : list) {
      Wrappers$BluetoothGattCharacteristicWrapper wrappers$BluetoothGattCharacteristicWrapper2 = (Wrappers$BluetoothGattCharacteristicWrapper)Wrappers$BluetoothDeviceWrapper.access$100(wrappers$BluetoothGattServiceWrapper.mDeviceWrapper).get(bluetoothGattCharacteristic);
      Wrappers$BluetoothGattCharacteristicWrapper wrappers$BluetoothGattCharacteristicWrapper1 = wrappers$BluetoothGattCharacteristicWrapper2;
      if (wrappers$BluetoothGattCharacteristicWrapper2 == null) {
        wrappers$BluetoothGattCharacteristicWrapper1 = new Wrappers$BluetoothGattCharacteristicWrapper(bluetoothGattCharacteristic, wrappers$BluetoothGattServiceWrapper.mDeviceWrapper);
        Wrappers$BluetoothDeviceWrapper.access$100(wrappers$BluetoothGattServiceWrapper.mDeviceWrapper).put(bluetoothGattCharacteristic, wrappers$BluetoothGattCharacteristicWrapper1);
      } 
      arrayList.add(wrappers$BluetoothGattCharacteristicWrapper1);
    } 
    for (Wrappers$BluetoothGattCharacteristicWrapper wrappers$BluetoothGattCharacteristicWrapper : arrayList) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mInstanceId);
      stringBuilder.append("/");
      stringBuilder.append(wrappers$BluetoothGattCharacteristicWrapper.mCharacteristic.getUuid().toString());
      stringBuilder.append(",");
      stringBuilder.append(wrappers$BluetoothGattCharacteristicWrapper.mCharacteristic.getInstanceId());
      String str = stringBuilder.toString();
      nativeCreateGattRemoteCharacteristic(this.mNativeBluetoothRemoteGattServiceAndroid, str, wrappers$BluetoothGattCharacteristicWrapper, this.mChromeDevice);
    } 
  }
  
  @CalledByNative
  private String getUUID() {
    return this.mService.mService.getUuid().toString();
  }
  
  private native void nativeCreateGattRemoteCharacteristic(long paramLong, String paramString, Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper, ChromeBluetoothDevice paramChromeBluetoothDevice);
  
  @CalledByNative
  private void onBluetoothRemoteGattServiceAndroidDestruction() {
    this.mNativeBluetoothRemoteGattServiceAndroid = 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothRemoteGattService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */