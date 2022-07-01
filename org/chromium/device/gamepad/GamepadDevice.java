package org.chromium.device.gamepad;

import android.os.Build;
import android.os.SystemClock;
import android.view.InputDevice;
import java.util.Iterator;
import java.util.List;

class GamepadDevice {
  int[] mAxes;
  
  final float[] mAxisValues;
  
  final float[] mButtonsValues;
  
  int mDeviceId;
  
  int mDeviceIndex;
  
  String mDeviceName;
  
  GamepadMappings mMappings;
  
  final float[] mRawAxes;
  
  final float[] mRawButtons;
  
  long mTimestamp;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  GamepadDevice(int paramInt, InputDevice paramInputDevice) {
    GamepadMappings$UnknownGamepadMappings gamepadMappings$UnknownGamepadMappings;
    GamepadMappings$SamsungEIGP20GamepadMappings gamepadMappings$SamsungEIGP20GamepadMappings2;
    Iterator iterator1;
    this.mAxisValues = new float[4];
    this.mButtonsValues = new float[17];
    this.mRawButtons = new float[256];
    this.mRawAxes = new float[256];
    this.mDeviceIndex = paramInt;
    this.mDeviceId = paramInputDevice.getId();
    this.mDeviceName = paramInputDevice.getName();
    this.mTimestamp = SystemClock.uptimeMillis();
    List list = paramInputDevice.getMotionRanges();
    this.mAxes = new int[list.size()];
    Iterator<InputDevice.MotionRange> iterator = list.iterator();
    for (paramInt = 0; iterator.hasNext(); paramInt = i) {
      iterator1 = (Iterator)iterator.next();
      int i = paramInt;
      if ((iterator1.getSource() & 0x10) != 0) {
        i = iterator1.getAxis();
        if ($assertionsDisabled || i < 256) {
          this.mAxes[paramInt] = i;
          i = paramInt + 1;
        } else {
          throw new AssertionError();
        } 
      } 
    } 
    int[] arrayOfInt = this.mAxes;
    paramInt = Build.VERSION.SDK_INT;
    GamepadMappings$SamsungEIGP20GamepadMappings gamepadMappings$SamsungEIGP20GamepadMappings3 = null;
    if (paramInt >= 19) {
      paramInt = paramInputDevice.getProductId();
      int i = paramInputDevice.getVendorId();
      if (i == 1356 && (paramInt == 1476 || paramInt == 2508 || paramInt == 2976)) {
        GamepadMappings$PS4GamepadMappings gamepadMappings$PS4GamepadMappings = new GamepadMappings$PS4GamepadMappings();
      } else if (i == 1118 && paramInt == 736) {
        GamepadMappings$XboxOneS2016FirmwareMappings gamepadMappings$XboxOneS2016FirmwareMappings = new GamepadMappings$XboxOneS2016FirmwareMappings((byte)0);
      } else {
        iterator = null;
      } 
      iterator1 = iterator;
    } else {
      iterator1 = null;
    } 
    iterator = iterator1;
    if (iterator1 == null) {
      GamepadMappings$XboxCompatibleGamepadMappings gamepadMappings$XboxCompatibleGamepadMappings;
      GamepadMappings$SamsungEIGP20GamepadMappings gamepadMappings$SamsungEIGP20GamepadMappings;
      String str = paramInputDevice.getName();
      if (str.startsWith("NVIDIA Corporation NVIDIA Controller") || str.equals("Microsoft X-Box 360 pad")) {
        gamepadMappings$XboxCompatibleGamepadMappings = new GamepadMappings$XboxCompatibleGamepadMappings((byte)0);
      } else {
        GamepadMappings$PS3SixAxisGamepadMappings gamepadMappings$PS3SixAxisGamepadMappings;
        if (gamepadMappings$XboxCompatibleGamepadMappings.equals("Sony PLAYSTATION(R)3 Controller")) {
          gamepadMappings$PS3SixAxisGamepadMappings = new GamepadMappings$PS3SixAxisGamepadMappings((byte)0);
        } else if (gamepadMappings$PS3SixAxisGamepadMappings.equals("Samsung Game Pad EI-GP20")) {
          gamepadMappings$SamsungEIGP20GamepadMappings = new GamepadMappings$SamsungEIGP20GamepadMappings((byte)0);
        } else if (gamepadMappings$SamsungEIGP20GamepadMappings.equals("Amazon Fire Game Controller")) {
          GamepadMappings$AmazonFireGamepadMappings gamepadMappings$AmazonFireGamepadMappings = new GamepadMappings$AmazonFireGamepadMappings((byte)0);
        } else {
          gamepadMappings$SamsungEIGP20GamepadMappings = gamepadMappings$SamsungEIGP20GamepadMappings3;
        } 
      } 
      gamepadMappings$SamsungEIGP20GamepadMappings2 = gamepadMappings$SamsungEIGP20GamepadMappings;
    } 
    GamepadMappings$SamsungEIGP20GamepadMappings gamepadMappings$SamsungEIGP20GamepadMappings1 = gamepadMappings$SamsungEIGP20GamepadMappings2;
    if (gamepadMappings$SamsungEIGP20GamepadMappings2 == null)
      gamepadMappings$UnknownGamepadMappings = new GamepadMappings$UnknownGamepadMappings(arrayOfInt); 
    this.mMappings = gamepadMappings$UnknownGamepadMappings;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */