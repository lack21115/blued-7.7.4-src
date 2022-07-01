package org.chromium.device.usb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;

final class ChromeUsbService$1 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    UsbDevice usbDevice = (UsbDevice)paramIntent.getParcelableExtra("device");
    if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(paramIntent.getAction())) {
      ChromeUsbService.access$000(ChromeUsbService.this, ChromeUsbService.this.mUsbServiceAndroid, usbDevice);
      return;
    } 
    if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(paramIntent.getAction())) {
      ChromeUsbService.access$100(ChromeUsbService.this, ChromeUsbService.this.mUsbServiceAndroid, usbDevice.getDeviceId());
      return;
    } 
    if ("org.chromium.device.ACTION_USB_PERMISSION".equals(paramIntent.getAction()))
      ChromeUsbService.access$200(ChromeUsbService.this, ChromeUsbService.this.mUsbServiceAndroid, usbDevice.getDeviceId(), paramIntent.getBooleanExtra("permission", false)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\devic\\usb\ChromeUsbService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */