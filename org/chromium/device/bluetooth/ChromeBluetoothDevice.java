package org.chromium.device.bluetooth;

import android.annotation.TargetApi;
import android.content.Context;
import java.util.HashMap;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(23)
final class ChromeBluetoothDevice {
  Wrappers$BluetoothGattWrapper mBluetoothGatt;
  
  private final ChromeBluetoothDevice$BluetoothGattCallbackImpl mBluetoothGattCallbackImpl;
  
  private Wrappers$BluetoothDeviceWrapper mDevice;
  
  private long mNativeBluetoothDeviceAndroid;
  
  final HashMap mWrapperToChromeCharacteristicsMap;
  
  final HashMap mWrapperToChromeDescriptorsMap;
  
  private ChromeBluetoothDevice(long paramLong, Wrappers$BluetoothDeviceWrapper paramWrappers$BluetoothDeviceWrapper) {
    this.mNativeBluetoothDeviceAndroid = paramLong;
    this.mDevice = paramWrappers$BluetoothDeviceWrapper;
    this.mBluetoothGattCallbackImpl = new ChromeBluetoothDevice$BluetoothGattCallbackImpl(this, (byte)0);
    this.mWrapperToChromeCharacteristicsMap = new HashMap<Object, Object>();
    this.mWrapperToChromeDescriptorsMap = new HashMap<Object, Object>();
  }
  
  @CalledByNative
  private static ChromeBluetoothDevice create(long paramLong, Wrappers$BluetoothDeviceWrapper paramWrappers$BluetoothDeviceWrapper) {
    return new ChromeBluetoothDevice(paramLong, paramWrappers$BluetoothDeviceWrapper);
  }
  
  @CalledByNative
  private void createGattConnectionImpl() {
    Log.i("Bluetooth", "connectGatt", new Object[0]);
    if (this.mBluetoothGatt != null)
      this.mBluetoothGatt.mGatt.close(); 
    Wrappers$BluetoothDeviceWrapper wrappers$BluetoothDeviceWrapper = this.mDevice;
    Context context = ContextUtils.sApplicationContext;
    ChromeBluetoothDevice$BluetoothGattCallbackImpl chromeBluetoothDevice$BluetoothGattCallbackImpl = this.mBluetoothGattCallbackImpl;
    this.mBluetoothGatt = new Wrappers$BluetoothGattWrapper(wrappers$BluetoothDeviceWrapper.mDevice.connectGatt(context, false, new Wrappers$ForwardBluetoothGattCallbackToWrapper(chromeBluetoothDevice$BluetoothGattCallbackImpl, wrappers$BluetoothDeviceWrapper), 2), wrappers$BluetoothDeviceWrapper);
  }
  
  @CalledByNative
  private void disconnectGatt() {
    Log.i("Bluetooth", "BluetoothGatt.disconnect", new Object[0]);
    if (this.mBluetoothGatt != null)
      this.mBluetoothGatt.mGatt.disconnect(); 
  }
  
  @CalledByNative
  private String getAddress() {
    return this.mDevice.mDevice.getAddress();
  }
  
  @CalledByNative
  private int getBluetoothClass() {
    Wrappers$BluetoothDeviceWrapper wrappers$BluetoothDeviceWrapper = this.mDevice;
    return (wrappers$BluetoothDeviceWrapper.mDevice == null || wrappers$BluetoothDeviceWrapper.mDevice.getBluetoothClass() == null) ? 7936 : wrappers$BluetoothDeviceWrapper.mDevice.getBluetoothClass().getDeviceClass();
  }
  
  @CalledByNative
  private String getName() {
    return this.mDevice.mDevice.getName();
  }
  
  @CalledByNative
  private boolean isPaired() {
    return (this.mDevice.mDevice.getBondState() == 12);
  }
  
  private native void nativeCreateGattRemoteService(long paramLong, String paramString, Wrappers$BluetoothGattServiceWrapper paramWrappers$BluetoothGattServiceWrapper);
  
  private native void nativeOnConnectionStateChange(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativeOnGattServicesDiscovered(long paramLong);
  
  @CalledByNative
  private void onBluetoothDeviceAndroidDestruction() {
    if (this.mBluetoothGatt != null) {
      this.mBluetoothGatt.mGatt.close();
      this.mBluetoothGatt = null;
    } 
    this.mNativeBluetoothDeviceAndroid = 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */