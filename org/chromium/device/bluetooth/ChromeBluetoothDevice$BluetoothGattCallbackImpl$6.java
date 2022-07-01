package org.chromium.device.bluetooth;

import org.chromium.base.Log;
import org.chromium.base.metrics.RecordHistogram;

final class ChromeBluetoothDevice$BluetoothGattCallbackImpl$6 implements Runnable {
  public final void run() {
    ChromeBluetoothRemoteGattDescriptor chromeBluetoothRemoteGattDescriptor = (ChromeBluetoothRemoteGattDescriptor)this.this$1.this$0.mWrapperToChromeDescriptorsMap.get(descriptor);
    if (chromeBluetoothRemoteGattDescriptor != null) {
      String str;
      RecordHistogram.recordSparseSlowlyHistogram("Bluetooth.Web.Android.onDescriptorRead.Status", status);
      int i = status;
      if (i == 0) {
        str = "OK";
      } else {
        str = "Error";
      } 
      Log.i("Bluetooth", "onDescriptorRead status:%d==%s", new Object[] { Integer.valueOf(i), str });
      if (chromeBluetoothRemoteGattDescriptor.mNativeBluetoothRemoteGattDescriptorAndroid != 0L)
        chromeBluetoothRemoteGattDescriptor.nativeOnRead(chromeBluetoothRemoteGattDescriptor.mNativeBluetoothRemoteGattDescriptorAndroid, i, chromeBluetoothRemoteGattDescriptor.mDescriptor.mDescriptor.getValue()); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothDevice$BluetoothGattCallbackImpl$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */