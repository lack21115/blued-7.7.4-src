package org.chromium.media;

import java.util.Arrays;
import java.util.UUID;
import org.chromium.base.ApiCompatibilityUtils;

final class MediaDrmSessionManager$SessionId {
  private static final char[] HEX_CHAR_LOOKUP;
  
  byte[] mDrmId;
  
  final byte[] mEmeId;
  
  byte[] mKeySetId;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MediaDrmSessionManager$SessionId(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
    assert false;
    throw new AssertionError();
  }
  
  static MediaDrmSessionManager$SessionId createNoExistSessionId() {
    return createTemporarySessionId(new byte[0]);
  }
  
  static MediaDrmSessionManager$SessionId createPersistentSessionId(byte[] paramArrayOfbyte) {
    return new MediaDrmSessionManager$SessionId(ApiCompatibilityUtils.getBytesUtf8(UUID.randomUUID().toString().replace('-', '0')), paramArrayOfbyte, null);
  }
  
  static MediaDrmSessionManager$SessionId createTemporarySessionId(byte[] paramArrayOfbyte) {
    return new MediaDrmSessionManager$SessionId(paramArrayOfbyte, paramArrayOfbyte, null);
  }
  
  static String toHexString(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      stringBuilder.append(HEX_CHAR_LOOKUP[paramArrayOfbyte[i] >>> 4]);
      stringBuilder.append(HEX_CHAR_LOOKUP[paramArrayOfbyte[i] & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  final boolean isEqual(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId) {
    return Arrays.equals(this.mEmeId, paramMediaDrmSessionManager$SessionId.mEmeId);
  }
  
  final String toHexString() {
    return toHexString(this.mEmeId);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmSessionManager$SessionId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */