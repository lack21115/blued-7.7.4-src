package org.chromium.midi;

import android.annotation.TargetApi;
import android.media.midi.MidiDevice;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(23)
class MidiDeviceAndroid {
  final MidiDevice mDevice;
  
  final MidiInputPortAndroid[] mInputPorts;
  
  boolean mIsOpen = true;
  
  final MidiOutputPortAndroid[] mOutputPorts;
  
  MidiDeviceAndroid(MidiDevice paramMidiDevice) {
    this.mDevice = paramMidiDevice;
    this.mOutputPorts = new MidiOutputPortAndroid[this.mDevice.getInfo().getInputPortCount()];
    boolean bool = false;
    int i;
    for (i = 0; i < this.mOutputPorts.length; i++)
      this.mOutputPorts[i] = new MidiOutputPortAndroid(paramMidiDevice, i); 
    this.mInputPorts = new MidiInputPortAndroid[this.mDevice.getInfo().getOutputPortCount()];
    for (i = bool; i < this.mInputPorts.length; i++)
      this.mInputPorts[i] = new MidiInputPortAndroid(paramMidiDevice, i); 
  }
  
  private String getProperty(String paramString) {
    return this.mDevice.getInfo().getProperties().getString(paramString);
  }
  
  @CalledByNative
  MidiInputPortAndroid[] getInputPorts() {
    return this.mInputPorts;
  }
  
  @CalledByNative
  String getManufacturer() {
    return getProperty("manufacturer");
  }
  
  @CalledByNative
  MidiOutputPortAndroid[] getOutputPorts() {
    return this.mOutputPorts;
  }
  
  @CalledByNative
  String getProduct() {
    String str = getProperty("product");
    return (str == null || str.isEmpty()) ? getProperty("name") : str;
  }
  
  @CalledByNative
  String getVersion() {
    return getProperty("version");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\MidiDeviceAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */