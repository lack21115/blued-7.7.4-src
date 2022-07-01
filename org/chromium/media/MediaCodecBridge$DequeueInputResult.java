package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

class MediaCodecBridge$DequeueInputResult {
  private final int mIndex;
  
  private final int mStatus;
  
  private MediaCodecBridge$DequeueInputResult(int paramInt1, int paramInt2) {
    this.mStatus = paramInt1;
    this.mIndex = paramInt2;
  }
  
  @CalledByNative
  private int index() {
    return this.mIndex;
  }
  
  @CalledByNative
  private int status() {
    return this.mStatus;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecBridge$DequeueInputResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */