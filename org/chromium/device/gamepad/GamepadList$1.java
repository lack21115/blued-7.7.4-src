package org.chromium.device.gamepad;

import android.hardware.input.InputManager;

final class GamepadList$1 implements InputManager.InputDeviceListener {
  public final void onInputDeviceAdded(int paramInt) {
    GamepadList.access$200(GamepadList.this, paramInt);
  }
  
  public final void onInputDeviceChanged(int paramInt) {
    GamepadList.access$000$20dd1d9d();
  }
  
  public final void onInputDeviceRemoved(int paramInt) {
    GamepadList.access$100(GamepadList.this, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */