package org.chromium.midi;

final class UsbMidiDeviceAndroid$2 implements Runnable {
  public final void run() {
    if (UsbMidiDeviceAndroid.access$300(UsbMidiDeviceAndroid.this))
      return; 
    UsbMidiDeviceAndroid.access$500(UsbMidiDeviceAndroid.access$400(UsbMidiDeviceAndroid.this), endpointNumber, bs);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\UsbMidiDeviceAndroid$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */