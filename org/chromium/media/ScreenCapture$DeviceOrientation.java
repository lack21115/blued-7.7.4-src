package org.chromium.media;

enum ScreenCapture$DeviceOrientation {
  LANDSCAPE, PORTRAIT;
  
  static {
    LANDSCAPE = new ScreenCapture$DeviceOrientation("LANDSCAPE", 1);
    $VALUES = new ScreenCapture$DeviceOrientation[] { PORTRAIT, LANDSCAPE };
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\ScreenCapture$DeviceOrientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */