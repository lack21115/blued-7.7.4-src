package org.chromium.media;

enum ScreenCapture$CaptureState {
  ALLOWED, ATTACHED, STARTED, STOPPED, STOPPING;
  
  static {
    ALLOWED = new ScreenCapture$CaptureState("ALLOWED", 1);
    STARTED = new ScreenCapture$CaptureState("STARTED", 2);
    STOPPING = new ScreenCapture$CaptureState("STOPPING", 3);
    STOPPED = new ScreenCapture$CaptureState("STOPPED", 4);
    $VALUES = new ScreenCapture$CaptureState[] { ATTACHED, ALLOWED, STARTED, STOPPING, STOPPED };
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\ScreenCapture$CaptureState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */