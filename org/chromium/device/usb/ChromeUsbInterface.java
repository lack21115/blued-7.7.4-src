package org.chromium.device.usb;

import android.annotation.TargetApi;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import org.chromium.base.annotations.CalledByNative;

final class ChromeUsbInterface {
  private UsbInterface mInterface;
  
  private ChromeUsbInterface(UsbInterface paramUsbInterface) {
    this.mInterface = paramUsbInterface;
  }
  
  @CalledByNative
  private static ChromeUsbInterface create(UsbInterface paramUsbInterface) {
    return new ChromeUsbInterface(paramUsbInterface);
  }
  
  @TargetApi(21)
  @CalledByNative
  private int getAlternateSetting() {
    return this.mInterface.getAlternateSetting();
  }
  
  @CalledByNative
  private UsbEndpoint[] getEndpoints() {
    int j = this.mInterface.getEndpointCount();
    UsbEndpoint[] arrayOfUsbEndpoint = new UsbEndpoint[j];
    for (int i = 0; i < j; i++)
      arrayOfUsbEndpoint[i] = this.mInterface.getEndpoint(i); 
    return arrayOfUsbEndpoint;
  }
  
  @CalledByNative
  private int getInterfaceClass() {
    return this.mInterface.getInterfaceClass();
  }
  
  @CalledByNative
  private int getInterfaceNumber() {
    return this.mInterface.getId();
  }
  
  @CalledByNative
  private int getInterfaceProtocol() {
    return this.mInterface.getInterfaceProtocol();
  }
  
  @CalledByNative
  private int getInterfaceSubclass() {
    return this.mInterface.getInterfaceSubclass();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\devic\\usb\ChromeUsbInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */