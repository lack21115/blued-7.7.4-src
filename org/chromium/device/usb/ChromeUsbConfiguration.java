package org.chromium.device.usb;

import android.annotation.TargetApi;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbInterface;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(21)
final class ChromeUsbConfiguration {
  private UsbConfiguration mConfiguration;
  
  private ChromeUsbConfiguration(UsbConfiguration paramUsbConfiguration) {
    this.mConfiguration = paramUsbConfiguration;
  }
  
  @CalledByNative
  private static ChromeUsbConfiguration create(UsbConfiguration paramUsbConfiguration) {
    return new ChromeUsbConfiguration(paramUsbConfiguration);
  }
  
  @CalledByNative
  private int getConfigurationValue() {
    return this.mConfiguration.getId();
  }
  
  @CalledByNative
  private UsbInterface[] getInterfaces() {
    int j = this.mConfiguration.getInterfaceCount();
    UsbInterface[] arrayOfUsbInterface = new UsbInterface[j];
    for (int i = 0; i < j; i++)
      arrayOfUsbInterface[i] = this.mConfiguration.getInterface(i); 
    return arrayOfUsbInterface;
  }
  
  @CalledByNative
  private int getMaxPower() {
    return this.mConfiguration.getMaxPower();
  }
  
  @CalledByNative
  private boolean isRemoteWakeup() {
    return this.mConfiguration.isRemoteWakeup();
  }
  
  @CalledByNative
  private boolean isSelfPowered() {
    return this.mConfiguration.isSelfPowered();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\devic\\usb\ChromeUsbConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */