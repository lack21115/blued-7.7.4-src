package org.chromium.device.usb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

final class ChromeUsbService {
  private BroadcastReceiver mUsbDeviceReceiver;
  
  private UsbManager mUsbManager;
  
  long mUsbServiceAndroid;
  
  private ChromeUsbService(long paramLong) {
    this.mUsbServiceAndroid = paramLong;
    this.mUsbManager = (UsbManager)ContextUtils.sApplicationContext.getSystemService("usb");
    this.mUsbDeviceReceiver = new ChromeUsbService$1(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("org.chromium.device.ACTION_USB_PERMISSION");
    ContextUtils.sApplicationContext.registerReceiver(this.mUsbDeviceReceiver, intentFilter);
  }
  
  @CalledByNative
  private void close() {
    ContextUtils.sApplicationContext.unregisterReceiver(this.mUsbDeviceReceiver);
    this.mUsbDeviceReceiver = null;
  }
  
  @CalledByNative
  private static ChromeUsbService create(long paramLong) {
    return new ChromeUsbService(paramLong);
  }
  
  @CalledByNative
  private Object[] getDevices() {
    return this.mUsbManager.getDeviceList().values().toArray();
  }
  
  private native void nativeDeviceAttached(long paramLong, UsbDevice paramUsbDevice);
  
  private native void nativeDeviceDetached(long paramLong, int paramInt);
  
  private native void nativeDevicePermissionRequestComplete(long paramLong, int paramInt, boolean paramBoolean);
  
  @CalledByNative
  private UsbDeviceConnection openDevice(ChromeUsbDevice paramChromeUsbDevice) {
    UsbDevice usbDevice = paramChromeUsbDevice.mDevice;
    return this.mUsbManager.openDevice(usbDevice);
  }
  
  @CalledByNative
  private void requestDevicePermission(ChromeUsbDevice paramChromeUsbDevice, long paramLong) {
    UsbDevice usbDevice = paramChromeUsbDevice.mDevice;
    if (this.mUsbManager.hasPermission(usbDevice)) {
      nativeDevicePermissionRequestComplete(this.mUsbServiceAndroid, usbDevice.getDeviceId(), true);
      return;
    } 
    PendingIntent pendingIntent = PendingIntent.getBroadcast(ContextUtils.sApplicationContext, 0, new Intent("org.chromium.device.ACTION_USB_PERMISSION"), 0);
    this.mUsbManager.requestPermission(paramChromeUsbDevice.mDevice, pendingIntent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\devic\\usb\ChromeUsbService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */