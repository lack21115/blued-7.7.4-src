package org.chromium.midi;

import android.annotation.TargetApi;
import android.media.midi.MidiDevice;
import android.media.midi.MidiOutputPort;
import java.io.IOException;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(23)
class MidiInputPortAndroid {
  private final MidiDevice mDevice;
  
  private final int mIndex;
  
  private long mNativeReceiverPointer;
  
  private MidiOutputPort mPort;
  
  MidiInputPortAndroid(MidiDevice paramMidiDevice, int paramInt) {
    this.mDevice = paramMidiDevice;
    this.mIndex = paramInt;
  }
  
  private static native void nativeOnData(long paramLong1, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong2);
  
  @CalledByNative
  void close() {
    if (this.mPort == null)
      return; 
    try {
      this.mPort.close();
    } catch (IOException iOException) {}
    this.mNativeReceiverPointer = 0L;
    this.mPort = null;
  }
  
  @CalledByNative
  boolean open(long paramLong) {
    if (this.mPort != null)
      return true; 
    this.mPort = this.mDevice.openOutputPort(this.mIndex);
    if (this.mPort == null)
      return false; 
    this.mNativeReceiverPointer = paramLong;
    this.mPort.connect(new MidiInputPortAndroid$1(this));
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\MidiInputPortAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */