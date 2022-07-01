package org.chromium.midi;

import android.annotation.TargetApi;
import android.media.midi.MidiDevice;
import android.media.midi.MidiInputPort;
import java.io.IOException;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(23)
class MidiOutputPortAndroid {
  private final MidiDevice mDevice;
  
  private final int mIndex;
  
  private MidiInputPort mPort;
  
  MidiOutputPortAndroid(MidiDevice paramMidiDevice, int paramInt) {
    this.mDevice = paramMidiDevice;
    this.mIndex = paramInt;
  }
  
  @CalledByNative
  void close() {
    if (this.mPort == null)
      return; 
    try {
      this.mPort.close();
    } catch (IOException iOException) {}
    this.mPort = null;
  }
  
  @CalledByNative
  boolean open() {
    if (this.mPort != null)
      return true; 
    this.mPort = this.mDevice.openInputPort(this.mIndex);
    return (this.mPort != null);
  }
  
  @CalledByNative
  void send(byte[] paramArrayOfbyte) {
    if (this.mPort == null)
      return; 
    try {
      this.mPort.send(paramArrayOfbyte, 0, paramArrayOfbyte.length);
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder("MidiOutputPortAndroid.send: ");
      stringBuilder.append(iOException);
      Log.e("midi", stringBuilder.toString(), new Object[0]);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\MidiOutputPortAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */