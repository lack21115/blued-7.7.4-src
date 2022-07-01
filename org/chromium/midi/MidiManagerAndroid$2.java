package org.chromium.midi;

import android.media.midi.MidiDeviceInfo;
import android.media.midi.MidiManager;

final class MidiManagerAndroid$2 extends MidiManager.DeviceCallback {
  public final void onDeviceAdded(MidiDeviceInfo paramMidiDeviceInfo) {
    MidiManagerAndroid.access$100(MidiManagerAndroid.this, paramMidiDeviceInfo);
  }
  
  public final void onDeviceRemoved(MidiDeviceInfo paramMidiDeviceInfo) {
    MidiManagerAndroid.access$200(MidiManagerAndroid.this, paramMidiDeviceInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\MidiManagerAndroid$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */