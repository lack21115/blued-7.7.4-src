package org.chromium.device.bluetooth;

import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;

final class ChromeBluetoothDevice$BluetoothGattCallbackImpl extends Wrappers$BluetoothGattCallbackWrapper {
  private ChromeBluetoothDevice$BluetoothGattCallbackImpl() {}
  
  public final void onCharacteristicChanged(Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper) {
    Log.i("Bluetooth", "device onCharacteristicChanged.", new Object[0]);
    byte[] arrayOfByte = paramWrappers$BluetoothGattCharacteristicWrapper.mCharacteristic.getValue();
    Wrappers$ThreadUtilsWrapper.getInstance();
    ThreadUtils.runOnUiThread(new ChromeBluetoothDevice$BluetoothGattCallbackImpl$3(this, paramWrappers$BluetoothGattCharacteristicWrapper, arrayOfByte));
  }
  
  public final void onCharacteristicRead(Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper, int paramInt) {
    Wrappers$ThreadUtilsWrapper.getInstance();
    ThreadUtils.runOnUiThread(new ChromeBluetoothDevice$BluetoothGattCallbackImpl$4(this, paramWrappers$BluetoothGattCharacteristicWrapper, paramInt));
  }
  
  public final void onCharacteristicWrite(Wrappers$BluetoothGattCharacteristicWrapper paramWrappers$BluetoothGattCharacteristicWrapper, int paramInt) {
    Wrappers$ThreadUtilsWrapper.getInstance();
    ThreadUtils.runOnUiThread(new ChromeBluetoothDevice$BluetoothGattCallbackImpl$5(this, paramWrappers$BluetoothGattCharacteristicWrapper, paramInt));
  }
  
  public final void onConnectionStateChange(int paramInt1, int paramInt2) {
    String str;
    if (paramInt2 == 2) {
      str = "Connected";
    } else {
      str = "Disconnected";
    } 
    Log.i("Bluetooth", "onConnectionStateChange status:%d newState:%s", new Object[] { Integer.valueOf(paramInt1), str });
    Wrappers$ThreadUtilsWrapper.getInstance();
    ThreadUtils.runOnUiThread(new ChromeBluetoothDevice$BluetoothGattCallbackImpl$1(this, paramInt2, paramInt1));
  }
  
  public final void onDescriptorRead(Wrappers$BluetoothGattDescriptorWrapper paramWrappers$BluetoothGattDescriptorWrapper, int paramInt) {
    Wrappers$ThreadUtilsWrapper.getInstance();
    ThreadUtils.runOnUiThread(new ChromeBluetoothDevice$BluetoothGattCallbackImpl$6(this, paramWrappers$BluetoothGattDescriptorWrapper, paramInt));
  }
  
  public final void onDescriptorWrite(Wrappers$BluetoothGattDescriptorWrapper paramWrappers$BluetoothGattDescriptorWrapper, int paramInt) {
    Wrappers$ThreadUtilsWrapper.getInstance();
    ThreadUtils.runOnUiThread(new ChromeBluetoothDevice$BluetoothGattCallbackImpl$7(this, paramWrappers$BluetoothGattDescriptorWrapper, paramInt));
  }
  
  public final void onServicesDiscovered(int paramInt) {
    String str;
    if (paramInt == 0) {
      str = "OK";
    } else {
      str = "Error";
    } 
    Log.i("Bluetooth", "onServicesDiscovered status:%d==%s", new Object[] { Integer.valueOf(paramInt), str });
    Wrappers$ThreadUtilsWrapper.getInstance();
    ThreadUtils.runOnUiThread(new ChromeBluetoothDevice$BluetoothGattCallbackImpl$2(this, paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothDevice$BluetoothGattCallbackImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */