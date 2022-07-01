package org.chromium.midi;

final class MidiManagerAndroid$3 implements Runnable {
  public final void run() {
    if (MidiManagerAndroid.access$300(MidiManagerAndroid.this).isEmpty() && !MidiManagerAndroid.access$400(MidiManagerAndroid.this)) {
      MidiManagerAndroid.nativeOnInitialized(MidiManagerAndroid.access$000(MidiManagerAndroid.this), (MidiDeviceAndroid[])MidiManagerAndroid.access$500(MidiManagerAndroid.this).toArray((Object[])new MidiDeviceAndroid[0]));
      MidiManagerAndroid.access$402(MidiManagerAndroid.this, true);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\MidiManagerAndroid$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */