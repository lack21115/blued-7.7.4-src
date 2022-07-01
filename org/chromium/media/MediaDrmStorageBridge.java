package org.chromium.media;

import android.annotation.TargetApi;
import org.chromium.base.Callback;

@TargetApi(23)
class MediaDrmStorageBridge {
  long mNativeMediaDrmStorageBridge;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  MediaDrmStorageBridge(long paramLong) {
    this.mNativeMediaDrmStorageBridge = paramLong;
    assert false;
  }
  
  final boolean isNativeMediaDrmStorageValid() {
    return (this.mNativeMediaDrmStorageBridge != -1L);
  }
  
  native void nativeOnClearInfo(long paramLong, byte[] paramArrayOfbyte, Callback paramCallback);
  
  native void nativeOnLoadInfo(long paramLong, byte[] paramArrayOfbyte, Callback paramCallback);
  
  native void nativeOnProvisioned(long paramLong, Callback paramCallback);
  
  native void nativeOnSaveInfo(long paramLong, MediaDrmStorageBridge$PersistentInfo paramMediaDrmStorageBridge$PersistentInfo, Callback paramCallback);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmStorageBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */