package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

class MediaDrmBridge$KeyStatus {
  private final byte[] mKeyId;
  
  private final int mStatusCode;
  
  private MediaDrmBridge$KeyStatus(byte[] paramArrayOfbyte, int paramInt) {
    this.mKeyId = paramArrayOfbyte;
    this.mStatusCode = paramInt;
  }
  
  @CalledByNative
  private byte[] getKeyId() {
    return this.mKeyId;
  }
  
  @CalledByNative
  private int getStatusCode() {
    return this.mStatusCode;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge$KeyStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */