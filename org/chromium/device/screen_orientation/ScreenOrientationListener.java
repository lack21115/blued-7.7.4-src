package org.chromium.device.screen_orientation;

import android.provider.Settings;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

class ScreenOrientationListener {
  @CalledByNative
  static boolean isAutoRotateEnabledByUser() {
    return (Settings.System.getInt(ContextUtils.sApplicationContext.getContentResolver(), "accelerometer_rotation", 0) == 1);
  }
  
  @CalledByNative
  static void startAccurateListening() {
    ThreadUtils.runOnUiThread(new ScreenOrientationListener$1());
  }
  
  @CalledByNative
  static void stopAccurateListening() {
    ThreadUtils.runOnUiThread(new ScreenOrientationListener$2());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\screen_orientation\ScreenOrientationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */