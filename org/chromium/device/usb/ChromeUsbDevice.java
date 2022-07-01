package org.chromium.device.usb;

import android.annotation.TargetApi;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import org.chromium.base.annotations.CalledByNative;

final class ChromeUsbDevice {
  final UsbDevice mDevice;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private ChromeUsbDevice(UsbDevice paramUsbDevice) {
    this.mDevice = paramUsbDevice;
  }
  
  @CalledByNative
  private static ChromeUsbDevice create(UsbDevice paramUsbDevice) {
    return new ChromeUsbDevice(paramUsbDevice);
  }
  
  @TargetApi(21)
  @CalledByNative
  private UsbConfiguration[] getConfigurations() {
    int j = this.mDevice.getConfigurationCount();
    UsbConfiguration[] arrayOfUsbConfiguration = new UsbConfiguration[j];
    for (int i = 0; i < j; i++)
      arrayOfUsbConfiguration[i] = this.mDevice.getConfiguration(i); 
    return arrayOfUsbConfiguration;
  }
  
  @CalledByNative
  private int getDeviceClass() {
    return this.mDevice.getDeviceClass();
  }
  
  @CalledByNative
  private int getDeviceId() {
    return this.mDevice.getDeviceId();
  }
  
  @CalledByNative
  private int getDeviceProtocol() {
    return this.mDevice.getDeviceProtocol();
  }
  
  @CalledByNative
  private int getDeviceSubclass() {
    return this.mDevice.getDeviceSubclass();
  }
  
  @TargetApi(23)
  @CalledByNative
  private int getDeviceVersion() {
    String[] arrayOfString = this.mDevice.getVersion().split("\\.");
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private UsbInterface[] getInterfaces() {
    int j = this.mDevice.getInterfaceCount();
    UsbInterface[] arrayOfUsbInterface = new UsbInterface[j];
    for (int i = 0; i < j; i++)
      arrayOfUsbInterface[i] = this.mDevice.getInterface(i); 
    return arrayOfUsbInterface;
  }
  
  @TargetApi(21)
  @CalledByNative
  private String getManufacturerName() {
    return this.mDevice.getManufacturerName();
  }
  
  @CalledByNative
  private int getProductId() {
    return this.mDevice.getProductId();
  }
  
  @TargetApi(21)
  @CalledByNative
  private String getProductName() {
    return this.mDevice.getProductName();
  }
  
  @TargetApi(21)
  @CalledByNative
  private String getSerialNumber() {
    return this.mDevice.getSerialNumber();
  }
  
  @CalledByNative
  private int getVendorId() {
    return this.mDevice.getVendorId();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\devic\\usb\ChromeUsbDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */