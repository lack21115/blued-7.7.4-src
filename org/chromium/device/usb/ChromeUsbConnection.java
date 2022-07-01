package org.chromium.device.usb;

import android.hardware.usb.UsbDeviceConnection;
import org.chromium.base.annotations.CalledByNative;

class ChromeUsbConnection {
  private UsbDeviceConnection mConnection;
  
  private ChromeUsbConnection(UsbDeviceConnection paramUsbDeviceConnection) {
    this.mConnection = paramUsbDeviceConnection;
  }
  
  @CalledByNative
  private void close() {
    this.mConnection.close();
  }
  
  @CalledByNative
  private static ChromeUsbConnection create(UsbDeviceConnection paramUsbDeviceConnection) {
    return new ChromeUsbConnection(paramUsbDeviceConnection);
  }
  
  @CalledByNative
  private int getFileDescriptor() {
    return this.mConnection.getFileDescriptor();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\devic\\usb\ChromeUsbConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */