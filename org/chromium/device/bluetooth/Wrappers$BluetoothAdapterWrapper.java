package org.chromium.device.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.os.Build;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

class Wrappers$BluetoothAdapterWrapper {
  final BluetoothAdapter mAdapter;
  
  Context mContext;
  
  private Wrappers$BluetoothLeScannerWrapper mScannerWrapper;
  
  private Wrappers$BluetoothAdapterWrapper(BluetoothAdapter paramBluetoothAdapter, Context paramContext) {
    this.mAdapter = paramBluetoothAdapter;
    this.mContext = paramContext;
  }
  
  @CalledByNative
  public static Wrappers$BluetoothAdapterWrapper createWithDefaultAdapter() {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i >= 23) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i == 0) {
      Log.i("Bluetooth", "BluetoothAdapterWrapper.create failed: SDK version (%d) too low.", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      return null;
    } 
    if (ContextUtils.sApplicationContext.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0 && ContextUtils.sApplicationContext.checkCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN") == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i == 0) {
      Log.w("Bluetooth", "BluetoothAdapterWrapper.create failed: Lacking Bluetooth permissions.", new Object[0]);
      return null;
    } 
    if (Build.VERSION.SDK_INT >= 18 && ContextUtils.sApplicationContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
      i = bool;
    } else {
      i = 0;
    } 
    if (i == 0) {
      Log.i("Bluetooth", "BluetoothAdapterWrapper.create failed: No Low Energy support.", new Object[0]);
      return null;
    } 
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (bluetoothAdapter == null) {
      Log.i("Bluetooth", "BluetoothAdapterWrapper.create failed: Default adapter not found.", new Object[0]);
      return null;
    } 
    return new Wrappers$BluetoothAdapterWrapper(bluetoothAdapter, ContextUtils.sApplicationContext);
  }
  
  public final Wrappers$BluetoothLeScannerWrapper getBluetoothLeScanner() {
    BluetoothLeScanner bluetoothLeScanner = this.mAdapter.getBluetoothLeScanner();
    if (bluetoothLeScanner == null)
      return null; 
    if (this.mScannerWrapper == null)
      this.mScannerWrapper = new Wrappers$BluetoothLeScannerWrapper(bluetoothLeScanner); 
    return this.mScannerWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\Wrappers$BluetoothAdapterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */