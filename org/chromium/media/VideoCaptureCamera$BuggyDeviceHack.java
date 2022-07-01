package org.chromium.media;

import android.os.Build;

final class VideoCaptureCamera$BuggyDeviceHack {
  private static final String[] COLORSPACE_BUGGY_DEVICE_LIST = new String[] { "SAMSUNG-SGH-I747", "ODROID-U2", "XT1092", "XT1095", "XT1096", "XT1097" };
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  static int getImageFormat() {
    String[] arrayOfString = COLORSPACE_BUGGY_DEVICE_LIST;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].contentEquals(Build.MODEL))
        return 17; 
    } 
    return 842094169;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera$BuggyDeviceHack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */