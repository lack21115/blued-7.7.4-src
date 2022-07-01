package org.chromium.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;

final class AudioManagerAndroid$5 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    if (!AudioManagerAndroid.access$1200$5b048130((UsbDevice)paramIntent.getParcelableExtra("device")))
      return; 
    if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(paramIntent.getAction())) {
      synchronized (AudioManagerAndroid.access$100(AudioManagerAndroid.this)) {
        if (!AudioManagerAndroid.access$1300(AudioManagerAndroid.this)) {
          AudioManagerAndroid.access$200(AudioManagerAndroid.this)[4] = true;
          AudioManagerAndroid.access$200(AudioManagerAndroid.this)[2] = false;
        } 
      } 
    } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(paramIntent.getAction()) && !AudioManagerAndroid.access$300(AudioManagerAndroid.this)) {
      synchronized (AudioManagerAndroid.access$100(AudioManagerAndroid.this)) {
        if (!AudioManagerAndroid.access$1300(AudioManagerAndroid.this)) {
          AudioManagerAndroid.access$200(AudioManagerAndroid.this)[4] = false;
          if (AudioManagerAndroid.access$400$7074bab7())
            AudioManagerAndroid.access$200(AudioManagerAndroid.this)[2] = true; 
        } 
      } 
    } 
    if (AudioManagerAndroid.access$600(AudioManagerAndroid.this))
      AudioManagerAndroid.access$700(AudioManagerAndroid.this); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioManagerAndroid$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */