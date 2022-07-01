package org.chromium.device.bluetooth;

import android.bluetooth.BluetoothGattService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.metrics.RecordHistogram;

final class ChromeBluetoothDevice$BluetoothGattCallbackImpl$2 implements Runnable {
  public final void run() {
    if (ChromeBluetoothDevice.access$100(this.this$1.this$0) != 0L) {
      if (this.this$1.this$0.mBluetoothGatt == null) {
        RecordHistogram.recordSparseSlowlyHistogram("Bluetooth.Web.Android.onServicesDiscovered.Status.Disconnected", status);
        return;
      } 
      RecordHistogram.recordSparseSlowlyHistogram("Bluetooth.Web.Android.onServicesDiscovered.Status.Connected", status);
      Wrappers$BluetoothGattWrapper wrappers$BluetoothGattWrapper = this.this$1.this$0.mBluetoothGatt;
      List list = wrappers$BluetoothGattWrapper.mGatt.getServices();
      ArrayList<Wrappers$BluetoothGattServiceWrapper> arrayList = new ArrayList(list.size());
      Iterator<BluetoothGattService> iterator = list.iterator();
      while (iterator.hasNext())
        arrayList.add(new Wrappers$BluetoothGattServiceWrapper(iterator.next(), wrappers$BluetoothGattWrapper.mDeviceWrapper)); 
      for (Wrappers$BluetoothGattServiceWrapper wrappers$BluetoothGattServiceWrapper : arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ChromeBluetoothDevice.access$300(this.this$1.this$0));
        stringBuilder.append("/");
        stringBuilder.append(wrappers$BluetoothGattServiceWrapper.mService.getUuid().toString());
        stringBuilder.append(",");
        stringBuilder.append(wrappers$BluetoothGattServiceWrapper.mService.getInstanceId());
        String str = stringBuilder.toString();
        ChromeBluetoothDevice.access$400(this.this$1.this$0, ChromeBluetoothDevice.access$100(this.this$1.this$0), str, wrappers$BluetoothGattServiceWrapper);
      } 
      ChromeBluetoothDevice.access$500(this.this$1.this$0, ChromeBluetoothDevice.access$100(this.this$1.this$0));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothDevice$BluetoothGattCallbackImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */