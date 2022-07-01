package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

public class MediaPlayerBridge$AllowedOperations {
  private final boolean mCanPause;
  
  private final boolean mCanSeekBackward;
  
  private final boolean mCanSeekForward;
  
  public MediaPlayerBridge$AllowedOperations(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    this.mCanPause = paramBoolean1;
    this.mCanSeekForward = paramBoolean2;
    this.mCanSeekBackward = paramBoolean3;
  }
  
  @CalledByNative
  private boolean canPause() {
    return this.mCanPause;
  }
  
  @CalledByNative
  private boolean canSeekBackward() {
    return this.mCanSeekBackward;
  }
  
  @CalledByNative
  private boolean canSeekForward() {
    return this.mCanSeekForward;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaPlayerBridge$AllowedOperations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */