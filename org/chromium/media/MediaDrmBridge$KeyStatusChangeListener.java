package org.chromium.media;

import android.annotation.TargetApi;
import android.media.MediaDrm;
import java.util.ArrayList;
import java.util.List;

@TargetApi(23)
final class MediaDrmBridge$KeyStatusChangeListener implements MediaDrm.OnKeyStatusChangeListener {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MediaDrmBridge$KeyStatusChangeListener() {}
  
  public final void onKeyStatusChange(MediaDrm paramMediaDrm, byte[] paramArrayOfbyte, List paramList, boolean paramBoolean) {
    MediaDrmSessionManager$SessionId mediaDrmSessionManager$SessionId = MediaDrmBridge.access$900(MediaDrmBridge.this, paramArrayOfbyte);
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge$KeyStatusChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */