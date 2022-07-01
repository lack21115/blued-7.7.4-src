package org.chromium.media;

enum VideoCaptureCamera2$CameraState {
  CONFIGURING, OPENING, STARTED, STOPPED;
  
  static {
    CONFIGURING = new VideoCaptureCamera2$CameraState("CONFIGURING", 1);
    STARTED = new VideoCaptureCamera2$CameraState("STARTED", 2);
    STOPPED = new VideoCaptureCamera2$CameraState("STOPPED", 3);
    $VALUES = new VideoCaptureCamera2$CameraState[] { OPENING, CONFIGURING, STARTED, STOPPED };
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera2$CameraState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */