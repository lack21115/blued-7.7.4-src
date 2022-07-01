package org.chromium.media;

import android.media.MediaFormat;
import org.chromium.base.annotations.CalledByNative;

class MediaCodecBridge$GetOutputFormatResult {
  private final MediaFormat mFormat;
  
  private final int mStatus;
  
  private MediaCodecBridge$GetOutputFormatResult(int paramInt, MediaFormat paramMediaFormat) {
    this.mStatus = paramInt;
    this.mFormat = paramMediaFormat;
  }
  
  @CalledByNative
  private int channelCount() {
    return this.mFormat.getInteger("channel-count");
  }
  
  private boolean formatHasCropValues() {
    return (this.mFormat.containsKey("crop-right") && this.mFormat.containsKey("crop-left") && this.mFormat.containsKey("crop-bottom") && this.mFormat.containsKey("crop-top"));
  }
  
  @CalledByNative
  private int height() {
    return formatHasCropValues() ? (this.mFormat.getInteger("crop-bottom") - this.mFormat.getInteger("crop-top") + 1) : this.mFormat.getInteger("height");
  }
  
  @CalledByNative
  private int sampleRate() {
    return this.mFormat.getInteger("sample-rate");
  }
  
  @CalledByNative
  private int status() {
    return this.mStatus;
  }
  
  @CalledByNative
  private int width() {
    return formatHasCropValues() ? (this.mFormat.getInteger("crop-right") - this.mFormat.getInteger("crop-left") + 1) : this.mFormat.getInteger("width");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecBridge$GetOutputFormatResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */