package org.chromium.midi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.os.Parcelable;

final class UsbMidiDeviceFactoryAndroid$1 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    Parcelable parcelable = paramIntent.getParcelableExtra("device");
    if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(paramIntent.getAction()))
      UsbMidiDeviceFactoryAndroid.access$000(UsbMidiDeviceFactoryAndroid.this, (UsbDevice)parcelable); 
    if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(paramIntent.getAction()))
      UsbMidiDeviceFactoryAndroid.access$100(UsbMidiDeviceFactoryAndroid.this, (UsbDevice)parcelable); 
    if ("org.chromium.midi.USB_PERMISSION".equals(paramIntent.getAction()))
      UsbMidiDeviceFactoryAndroid.access$200$4581c759(UsbMidiDeviceFactoryAndroid.this, paramIntent); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\UsbMidiDeviceFactoryAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */