package org.chromium.midi;

import android.media.midi.MidiDevice;
import android.media.midi.MidiDeviceInfo;
import android.media.midi.MidiManager;

final class MidiManagerAndroid$4 implements MidiManager.OnDeviceOpenedListener {
  public final void onDeviceOpened(MidiDevice paramMidiDevice) {
    MidiManagerAndroid.access$600(MidiManagerAndroid.this, paramMidiDevice, info);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\MidiManagerAndroid$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */