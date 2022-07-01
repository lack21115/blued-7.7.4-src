package org.chromium.media;

import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.os.Build;
import org.chromium.base.Log;

final class MediaDrmBridge$EventListener implements MediaDrm.OnEventListener {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MediaDrmBridge$EventListener() {}
  
  public final void onEvent(MediaDrm paramMediaDrm, byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2) {
    StringBuilder stringBuilder;
    MediaDrmBridge mediaDrmBridge;
    if (paramArrayOfbyte1 == null) {
      Log.e("cr_media", "EventListener: Null session.", new Object[0]);
      return;
    } 
    MediaDrmSessionManager$SessionId mediaDrmSessionManager$SessionId = MediaDrmBridge.access$900(MediaDrmBridge.this, paramArrayOfbyte1);
    boolean bool = true;
    if (mediaDrmSessionManager$SessionId == null) {
      Log.e("cr_media", "EventListener: Invalid session %s", new Object[] { MediaDrmSessionManager$SessionId.toHexString(paramArrayOfbyte1) });
      return;
    } 
    MediaDrmSessionManager$SessionInfo mediaDrmSessionManager$SessionInfo = MediaDrmBridge.access$1000(MediaDrmBridge.this).get(mediaDrmSessionManager$SessionId);
    switch (paramInt1) {
      default:
        stringBuilder = new StringBuilder("Invalid DRM event ");
        stringBuilder.append(paramInt1);
        Log.e("cr_media", stringBuilder.toString(), new Object[0]);
        return;
      case 4:
        assert false;
        throw new AssertionError();
      case 3:
        if (Build.VERSION.SDK_INT < 23) {
          mediaDrmBridge = MediaDrmBridge.this;
          Object[] arrayOfObject = MediaDrmBridge.access$1300(1).toArray();
          if (mediaDrmSessionManager$SessionInfo.mKeyType != 3)
            bool = false; 
          MediaDrmBridge.access$1400(mediaDrmBridge, (MediaDrmSessionManager$SessionId)stringBuilder, arrayOfObject, false, bool);
          return;
        } 
        return;
      case 2:
        break;
    } 
    try {
      MediaDrm.KeyRequest keyRequest = MediaDrmBridge.access$1100(MediaDrmBridge.this, (MediaDrmSessionManager$SessionId)stringBuilder, (byte[])mediaDrmBridge, mediaDrmSessionManager$SessionInfo.mMimeType, mediaDrmSessionManager$SessionInfo.mKeyType, null);
      if (keyRequest != null) {
        MediaDrmBridge.access$1200(MediaDrmBridge.this, (MediaDrmSessionManager$SessionId)stringBuilder, keyRequest);
        return;
      } 
      if (Build.VERSION.SDK_INT < 23)
        MediaDrmBridge.access$1400(MediaDrmBridge.this, (MediaDrmSessionManager$SessionId)stringBuilder, MediaDrmBridge.access$1300(4).toArray(), false, false); 
      Log.e("cr_media", "EventListener: getKeyRequest failed.", new Object[0]);
      return;
    } catch (NotProvisionedException notProvisionedException) {
      Log.e("cr_media", "Device not provisioned", new Object[] { notProvisionedException });
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge$EventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */