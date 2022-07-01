package org.chromium.ui.base;

import android.view.InputDevice;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

public class TouchDevice {
  @CalledByNative
  private static int[] availablePointerAndHoverTypes() {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    for (int i : InputDevice.getDeviceIds()) {
      try {
        InputDevice inputDevice = InputDevice.getDevice(i);
      } catch (RuntimeException runtimeException) {
        runtimeException = null;
      } 
      if (runtimeException != null) {
        i = runtimeException.getSources();
        if (hasSource(i, 8194) || hasSource(i, 16386) || hasSource(i, 1048584) || hasSource(i, 65540)) {
          arrayOfInt[0] = arrayOfInt[0] | 0x4;
        } else if (hasSource(i, 4098)) {
          arrayOfInt[0] = arrayOfInt[0] | 0x2;
        } 
        if (hasSource(i, 8194) || hasSource(i, 1048584) || hasSource(i, 65540))
          arrayOfInt[1] = arrayOfInt[1] | 0x2; 
      } 
    } 
    if (arrayOfInt[0] == 0)
      arrayOfInt[0] = 1; 
    if (arrayOfInt[1] == 0)
      arrayOfInt[1] = 1; 
    return arrayOfInt;
  }
  
  private static boolean hasSource(int paramInt1, int paramInt2) {
    return ((paramInt1 & paramInt2) == paramInt2);
  }
  
  @CalledByNative
  private static int maxTouchPoints() {
    return ContextUtils.sApplicationContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.jazzhand") ? 5 : (ContextUtils.sApplicationContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct") ? 2 : (ContextUtils.sApplicationContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch") ? 2 : (ContextUtils.sApplicationContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen") ? 1 : 0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\TouchDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */