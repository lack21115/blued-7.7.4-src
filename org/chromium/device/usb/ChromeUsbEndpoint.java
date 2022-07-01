package org.chromium.device.usb;

import android.hardware.usb.UsbEndpoint;
import org.chromium.base.annotations.CalledByNative;

final class ChromeUsbEndpoint {
  private UsbEndpoint mEndpoint;
  
  private ChromeUsbEndpoint(UsbEndpoint paramUsbEndpoint) {
    this.mEndpoint = paramUsbEndpoint;
  }
  
  @CalledByNative
  private static ChromeUsbEndpoint create(UsbEndpoint paramUsbEndpoint) {
    return new ChromeUsbEndpoint(paramUsbEndpoint);
  }
  
  @CalledByNative
  private int getAddress() {
    return this.mEndpoint.getAddress();
  }
  
  @CalledByNative
  private int getAttributes() {
    return this.mEndpoint.getAttributes();
  }
  
  @CalledByNative
  private int getInterval() {
    return this.mEndpoint.getInterval();
  }
  
  @CalledByNative
  private int getMaxPacketSize() {
    return this.mEndpoint.getMaxPacketSize();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\devic\\usb\ChromeUsbEndpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */