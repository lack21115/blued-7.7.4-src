package org.chromium.ui.events.devices;

import android.hardware.input.InputManager;
import org.chromium.base.annotations.CalledByNative;

public class InputDeviceObserver implements InputManager.InputDeviceListener {
  private static final InputDeviceObserver INSTANCE;
  
  private InputManager mInputManager;
  
  private int mObserversCounter;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  public static void addObserver() {
    assert false;
    throw new AssertionError();
  }
  
  private native void nativeInputConfigurationChanged();
  
  @CalledByNative
  public static void removeObserver() {
    assert false;
    throw new AssertionError();
  }
  
  public void onInputDeviceAdded(int paramInt) {
    nativeInputConfigurationChanged();
  }
  
  public void onInputDeviceChanged(int paramInt) {
    nativeInputConfigurationChanged();
  }
  
  public void onInputDeviceRemoved(int paramInt) {
    nativeInputConfigurationChanged();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\events\devices\InputDeviceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */