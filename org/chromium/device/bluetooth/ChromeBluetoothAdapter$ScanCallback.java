package org.chromium.device.bluetooth;

import android.os.ParcelUuid;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.chromium.base.Log;

final class ChromeBluetoothAdapter$ScanCallback extends Wrappers$ScanCallbackWrapper {
  private ChromeBluetoothAdapter$ScanCallback() {}
  
  public final void onScanFailed(int paramInt) {
    Log.w("Bluetooth", "onScanFailed: %d", new Object[] { Integer.valueOf(paramInt) });
    ChromeBluetoothAdapter.access$300(ChromeBluetoothAdapter.this, ChromeBluetoothAdapter.access$100(ChromeBluetoothAdapter.this));
  }
  
  public final void onScanResult(int paramInt, Wrappers$ScanResultWrapper paramWrappers$ScanResultWrapper) {
    String[] arrayOfString1;
    String[] arrayOfString2;
    byte[][] arrayOfByte1;
    int[] arrayOfInt;
    byte[][] arrayOfByte2;
    (paramWrappers$ScanResultWrapper.getDevice()).mDevice.getAddress();
    (paramWrappers$ScanResultWrapper.getDevice()).mDevice.getName();
    List<ParcelUuid> list = paramWrappers$ScanResultWrapper.mScanResult.getScanRecord().getServiceUuids();
    boolean bool = false;
    if (list == null) {
      arrayOfString1 = new String[0];
    } else {
      arrayOfString1 = new String[list.size()];
      for (paramInt = 0; paramInt < list.size(); paramInt++)
        arrayOfString1[paramInt] = ((ParcelUuid)list.get(paramInt)).toString(); 
    } 
    Map map = paramWrappers$ScanResultWrapper.mScanResult.getScanRecord().getServiceData();
    if (map == null) {
      arrayOfString2 = new String[0];
      arrayOfByte1 = new byte[0][];
    } else {
      arrayOfString2 = new String[map.size()];
      arrayOfByte1 = new byte[map.size()][];
      Iterator<Map.Entry> iterator = map.entrySet().iterator();
      for (paramInt = 0; iterator.hasNext(); paramInt++) {
        Map.Entry entry = iterator.next();
        arrayOfString2[paramInt] = ((ParcelUuid)entry.getKey()).toString();
        arrayOfByte1[paramInt] = (byte[])entry.getValue();
      } 
    } 
    SparseArray sparseArray = paramWrappers$ScanResultWrapper.mScanResult.getScanRecord().getManufacturerSpecificData();
    if (sparseArray == null) {
      arrayOfInt = new int[0];
      arrayOfByte2 = new byte[0][];
    } else {
      arrayOfInt = new int[sparseArray.size()];
      arrayOfByte2 = new byte[sparseArray.size()][];
      for (paramInt = bool; paramInt < sparseArray.size(); paramInt++) {
        arrayOfInt[paramInt] = sparseArray.keyAt(paramInt);
        arrayOfByte2[paramInt] = (byte[])sparseArray.valueAt(paramInt);
      } 
    } 
    if (ChromeBluetoothAdapter.access$100(ChromeBluetoothAdapter.this) != 0L)
      ChromeBluetoothAdapter.access$200(ChromeBluetoothAdapter.this, ChromeBluetoothAdapter.access$100(ChromeBluetoothAdapter.this), (paramWrappers$ScanResultWrapper.getDevice()).mDevice.getAddress(), paramWrappers$ScanResultWrapper.getDevice(), paramWrappers$ScanResultWrapper.mScanResult.getRssi(), arrayOfString1, paramWrappers$ScanResultWrapper.mScanResult.getScanRecord().getTxPowerLevel(), arrayOfString2, (Object[])arrayOfByte1, arrayOfInt, (Object[])arrayOfByte2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothAdapter$ScanCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */