package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

class MediaCodecBridge$DequeueOutputResult {
  private final int mFlags;
  
  private final int mIndex;
  
  private final int mNumBytes;
  
  private final int mOffset;
  
  private final long mPresentationTimeMicroseconds;
  
  private final int mStatus;
  
  private MediaCodecBridge$DequeueOutputResult(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5) {
    this.mStatus = paramInt1;
    this.mIndex = paramInt2;
    this.mFlags = paramInt3;
    this.mOffset = paramInt4;
    this.mPresentationTimeMicroseconds = paramLong;
    this.mNumBytes = paramInt5;
  }
  
  @CalledByNative
  private int flags() {
    return this.mFlags;
  }
  
  @CalledByNative
  private int index() {
    return this.mIndex;
  }
  
  @CalledByNative
  private int numBytes() {
    return this.mNumBytes;
  }
  
  @CalledByNative
  private int offset() {
    return this.mOffset;
  }
  
  @CalledByNative
  private long presentationTimeMicroseconds() {
    return this.mPresentationTimeMicroseconds;
  }
  
  @CalledByNative
  private int status() {
    return this.mStatus;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecBridge$DequeueOutputResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */