package org.chromium.media;

import android.os.Build;
import org.chromium.base.Callback;

final class MediaDrmBridge$KeyUpdatedCallback implements Callback {
  private final boolean mIsKeyRelease;
  
  private final long mPromiseId;
  
  private final MediaDrmSessionManager$SessionId mSessionId;
  
  MediaDrmBridge$KeyUpdatedCallback(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId, long paramLong, boolean paramBoolean) {
    this.mSessionId = paramMediaDrmSessionManager$SessionId;
    this.mPromiseId = paramLong;
    this.mIsKeyRelease = paramBoolean;
  }
  
  public final void onResult(Boolean paramBoolean) {
    if (!paramBoolean.booleanValue()) {
      MediaDrmBridge.access$1800(MediaDrmBridge.this, this.mPromiseId, "failed to update key after response accepted");
      return;
    } 
    MediaDrmSessionManager$SessionId.toHexString(this.mSessionId.mEmeId);
    MediaDrmBridge.access$1900(MediaDrmBridge.this, this.mPromiseId);
    if (!this.mIsKeyRelease && Build.VERSION.SDK_INT < 23)
      MediaDrmBridge.access$1400(MediaDrmBridge.this, this.mSessionId, MediaDrmBridge.access$1300(0).toArray(), true, this.mIsKeyRelease); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge$KeyUpdatedCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */