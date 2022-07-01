package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

class MediaDrmStorageBridge$PersistentInfo {
  private final byte[] mEmeId;
  
  private final byte[] mKeySetId;
  
  private final String mMimeType;
  
  MediaDrmStorageBridge$PersistentInfo(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, String paramString) {
    this.mEmeId = paramArrayOfbyte1;
    this.mKeySetId = paramArrayOfbyte2;
    this.mMimeType = paramString;
  }
  
  @CalledByNative
  private static MediaDrmStorageBridge$PersistentInfo create(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, String paramString) {
    return new MediaDrmStorageBridge$PersistentInfo(paramArrayOfbyte1, paramArrayOfbyte2, paramString);
  }
  
  @CalledByNative
  byte[] emeId() {
    return this.mEmeId;
  }
  
  @CalledByNative
  byte[] keySetId() {
    return this.mKeySetId;
  }
  
  @CalledByNative
  String mimeType() {
    return this.mMimeType;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmStorageBridge$PersistentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */