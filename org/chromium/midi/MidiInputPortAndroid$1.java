package org.chromium.midi;

import android.media.midi.MidiReceiver;

final class MidiInputPortAndroid$1 extends MidiReceiver {
  public final void onSend(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong) {
    MidiInputPortAndroid.access$100(MidiInputPortAndroid.access$000(MidiInputPortAndroid.this), paramArrayOfbyte, paramInt1, paramInt2, paramLong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\MidiInputPortAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */