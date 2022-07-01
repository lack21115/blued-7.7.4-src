package org.chromium.media;

import android.annotation.TargetApi;
import android.media.MediaDrm;

@TargetApi(23)
final class MediaDrmBridge$ExpirationUpdateListener implements MediaDrm.OnExpirationUpdateListener {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MediaDrmBridge$ExpirationUpdateListener() {}
  
  public final void onExpirationUpdate(MediaDrm paramMediaDrm, byte[] paramArrayOfbyte, long paramLong) {
    MediaDrmSessionManager$SessionId mediaDrmSessionManager$SessionId = MediaDrmBridge.access$900(MediaDrmBridge.this, paramArrayOfbyte);
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge$ExpirationUpdateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */