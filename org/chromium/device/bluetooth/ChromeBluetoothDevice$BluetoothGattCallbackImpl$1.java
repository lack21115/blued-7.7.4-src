package org.chromium.device.bluetooth;

import org.chromium.base.metrics.RecordHistogram;

final class ChromeBluetoothDevice$BluetoothGattCallbackImpl$1 implements Runnable {
  public final void run() {
    if (newState == 2) {
      RecordHistogram.recordSparseSlowlyHistogram("Bluetooth.Web.Android.onConnectionStateChange.Status.Connected", status);
      this.this$1.this$0.mBluetoothGatt.mGatt.discoverServices();
    } else if (newState == 0) {
      RecordHistogram.recordSparseSlowlyHistogram("Bluetooth.Web.Android.onConnectionStateChange.Status.Disconnected", status);
      if (this.this$1.this$0.mBluetoothGatt != null) {
        this.this$1.this$0.mBluetoothGatt.mGatt.close();
        this.this$1.this$0.mBluetoothGatt = null;
      } 
    } else {
      RecordHistogram.recordSparseSlowlyHistogram("Bluetooth.Web.Android.onConnectionStateChange.Status.InvalidState", status);
    } 
    if (ChromeBluetoothDevice.access$100(this.this$1.this$0) != 0L) {
      boolean bool;
      ChromeBluetoothDevice chromeBluetoothDevice = this.this$1.this$0;
      long l = ChromeBluetoothDevice.access$100(this.this$1.this$0);
      int i = status;
      if (newState == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      ChromeBluetoothDevice.access$200(chromeBluetoothDevice, l, i, bool);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothDevice$BluetoothGattCallbackImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */