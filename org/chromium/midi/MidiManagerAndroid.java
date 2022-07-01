package org.chromium.midi;

import android.annotation.TargetApi;
import android.media.midi.MidiDevice;
import android.media.midi.MidiDeviceInfo;
import android.media.midi.MidiManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(23)
class MidiManagerAndroid {
  private final List mDevices = new ArrayList();
  
  private final Handler mHandler;
  
  private boolean mIsInitialized;
  
  private final MidiManager mManager;
  
  private final long mNativeManagerPointer;
  
  private final Set mPendingDevices = new HashSet();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MidiManagerAndroid(long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  static MidiManagerAndroid create(long paramLong) {
    return new MidiManagerAndroid(paramLong);
  }
  
  @CalledByNative
  static boolean hasSystemFeatureMidi() {
    return ContextUtils.sApplicationContext.getPackageManager().hasSystemFeature("android.software.midi");
  }
  
  static native void nativeOnAttached(long paramLong, MidiDeviceAndroid paramMidiDeviceAndroid);
  
  static native void nativeOnDetached(long paramLong, MidiDeviceAndroid paramMidiDeviceAndroid);
  
  static native void nativeOnInitializationFailed(long paramLong);
  
  static native void nativeOnInitialized(long paramLong, MidiDeviceAndroid[] paramArrayOfMidiDeviceAndroid);
  
  private void openDevice(MidiDeviceInfo paramMidiDeviceInfo) {
    this.mManager.openDevice(paramMidiDeviceInfo, new MidiManagerAndroid$4(this, paramMidiDeviceInfo), this.mHandler);
  }
  
  @CalledByNative
  void initialize() {
    if (this.mManager == null) {
      this.mHandler.post(new MidiManagerAndroid$1(this));
      return;
    } 
    this.mManager.registerDeviceCallback(new MidiManagerAndroid$2(this), this.mHandler);
    for (MidiDeviceInfo midiDeviceInfo : this.mManager.getDevices()) {
      this.mPendingDevices.add(midiDeviceInfo);
      openDevice(midiDeviceInfo);
    } 
    this.mHandler.post(new MidiManagerAndroid$3(this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\MidiManagerAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */