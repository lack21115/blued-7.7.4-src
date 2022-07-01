package org.chromium.midi;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

class UsbMidiDeviceFactoryAndroid {
  private final List mDevices = new ArrayList();
  
  private boolean mIsEnumeratingDevices;
  
  private long mNativePointer;
  
  private BroadcastReceiver mReceiver;
  
  private Set mRequestedDevices;
  
  private UsbManager mUsbManager = (UsbManager)ContextUtils.sApplicationContext.getSystemService("usb");
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private UsbMidiDeviceFactoryAndroid(long paramLong) {
    this.mNativePointer = paramLong;
    this.mReceiver = new UsbMidiDeviceFactoryAndroid$1(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("org.chromium.midi.USB_PERMISSION");
    ContextUtils.sApplicationContext.registerReceiver(this.mReceiver, intentFilter);
    this.mRequestedDevices = new HashSet();
  }
  
  @CalledByNative
  static UsbMidiDeviceFactoryAndroid create(long paramLong) {
    return new UsbMidiDeviceFactoryAndroid(paramLong);
  }
  
  private static native void nativeOnUsbMidiDeviceAttached(long paramLong, Object paramObject);
  
  private static native void nativeOnUsbMidiDeviceDetached(long paramLong, int paramInt);
  
  private static native void nativeOnUsbMidiDeviceRequestDone(long paramLong, Object[] paramArrayOfObject);
  
  private void requestDevicePermissionIfNecessary(UsbDevice paramUsbDevice) {
    Iterator<UsbDevice> iterator = this.mRequestedDevices.iterator();
    while (iterator.hasNext()) {
      if (((UsbDevice)iterator.next()).getDeviceId() == paramUsbDevice.getDeviceId())
        return; 
    } 
    for (int i = 0; i < paramUsbDevice.getInterfaceCount(); i++) {
      UsbInterface usbInterface = paramUsbDevice.getInterface(i);
      if (usbInterface.getInterfaceClass() == 1 && usbInterface.getInterfaceSubclass() == 3) {
        this.mUsbManager.requestPermission(paramUsbDevice, PendingIntent.getBroadcast(ContextUtils.sApplicationContext, 0, new Intent("org.chromium.midi.USB_PERMISSION"), 0));
        this.mRequestedDevices.add(paramUsbDevice);
        return;
      } 
    } 
  }
  
  @CalledByNative
  void close() {
    this.mNativePointer = 0L;
    ContextUtils.sApplicationContext.unregisterReceiver(this.mReceiver);
  }
  
  @CalledByNative
  boolean enumerateDevices() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\UsbMidiDeviceFactoryAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */