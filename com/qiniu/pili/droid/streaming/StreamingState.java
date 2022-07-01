package com.qiniu.pili.droid.streaming;

public enum StreamingState {
  AUDIO_RECORDING_FAIL, CAMERA_SWITCHED, CONNECTED, CONNECTING, DISCONNECTED, INVALID_STREAMING_URL, IOERROR, NO_NV21_PREVIEW_FORMAT, NO_SUPPORTED_PREVIEW_SIZE, OPEN_CAMERA_FAIL, PREPARING, READY, REQUEST_SCREEN_CAPTURING_FAIL, SENDING_BUFFER_EMPTY, SENDING_BUFFER_FULL, SENDING_BUFFER_HAS_FEW_ITEMS, SENDING_BUFFER_HAS_MANY_ITEMS, SHUTDOWN, STREAMING, TORCH_INFO, UNAUTHORIZED_PACKAGE, UNAUTHORIZED_STREAMING_URL, UNKNOWN;
  
  static {
    PREPARING = new StreamingState("PREPARING", 1);
    READY = new StreamingState("READY", 2);
    CONNECTING = new StreamingState("CONNECTING", 3);
    STREAMING = new StreamingState("STREAMING", 4);
    SHUTDOWN = new StreamingState("SHUTDOWN", 5);
    IOERROR = new StreamingState("IOERROR", 6);
    CAMERA_SWITCHED = new StreamingState("CAMERA_SWITCHED", 7);
    TORCH_INFO = new StreamingState("TORCH_INFO", 8);
    SENDING_BUFFER_EMPTY = new StreamingState("SENDING_BUFFER_EMPTY", 9);
    SENDING_BUFFER_FULL = new StreamingState("SENDING_BUFFER_FULL", 10);
    SENDING_BUFFER_HAS_FEW_ITEMS = new StreamingState("SENDING_BUFFER_HAS_FEW_ITEMS", 11);
    SENDING_BUFFER_HAS_MANY_ITEMS = new StreamingState("SENDING_BUFFER_HAS_MANY_ITEMS", 12);
    DISCONNECTED = new StreamingState("DISCONNECTED", 13);
    NO_SUPPORTED_PREVIEW_SIZE = new StreamingState("NO_SUPPORTED_PREVIEW_SIZE", 14);
    AUDIO_RECORDING_FAIL = new StreamingState("AUDIO_RECORDING_FAIL", 15);
    OPEN_CAMERA_FAIL = new StreamingState("OPEN_CAMERA_FAIL", 16);
    NO_NV21_PREVIEW_FORMAT = new StreamingState("NO_NV21_PREVIEW_FORMAT", 17);
    INVALID_STREAMING_URL = new StreamingState("INVALID_STREAMING_URL", 18);
    CONNECTED = new StreamingState("CONNECTED", 19);
    UNAUTHORIZED_STREAMING_URL = new StreamingState("UNAUTHORIZED_STREAMING_URL", 20);
    REQUEST_SCREEN_CAPTURING_FAIL = new StreamingState("REQUEST_SCREEN_CAPTURING_FAIL", 21);
    StreamingState streamingState = new StreamingState("UNAUTHORIZED_PACKAGE", 22);
    UNAUTHORIZED_PACKAGE = streamingState;
    $VALUES = new StreamingState[] { 
        UNKNOWN, PREPARING, READY, CONNECTING, STREAMING, SHUTDOWN, IOERROR, CAMERA_SWITCHED, TORCH_INFO, SENDING_BUFFER_EMPTY, 
        SENDING_BUFFER_FULL, SENDING_BUFFER_HAS_FEW_ITEMS, SENDING_BUFFER_HAS_MANY_ITEMS, DISCONNECTED, NO_SUPPORTED_PREVIEW_SIZE, AUDIO_RECORDING_FAIL, OPEN_CAMERA_FAIL, NO_NV21_PREVIEW_FORMAT, INVALID_STREAMING_URL, CONNECTED, 
        UNAUTHORIZED_STREAMING_URL, REQUEST_SCREEN_CAPTURING_FAIL, streamingState };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\StreamingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */