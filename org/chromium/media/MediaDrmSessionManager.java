package org.chromium.media;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.Callback;

class MediaDrmSessionManager {
  HashMap mDrmSessionInfoMap = new HashMap<Object, Object>();
  
  HashMap mEmeSessionInfoMap = new HashMap<Object, Object>();
  
  MediaDrmStorageBridge mStorage;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public MediaDrmSessionManager(MediaDrmStorageBridge paramMediaDrmStorageBridge) {
    this.mStorage = paramMediaDrmStorageBridge;
  }
  
  static MediaDrmSessionManager$SessionId getSessionIdFromMap(HashMap paramHashMap, byte[] paramArrayOfbyte) {
    MediaDrmSessionManager$SessionInfo mediaDrmSessionManager$SessionInfo = (MediaDrmSessionManager$SessionInfo)paramHashMap.get(ByteBuffer.wrap(paramArrayOfbyte));
    return (mediaDrmSessionManager$SessionInfo == null) ? null : MediaDrmSessionManager$SessionInfo.access$100(mediaDrmSessionManager$SessionInfo);
  }
  
  final void clearPersistentSessionInfo(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId, Callback paramCallback) {
    MediaDrmSessionManager$SessionId.access$300(paramMediaDrmSessionManager$SessionId, null);
    MediaDrmStorageBridge mediaDrmStorageBridge = this.mStorage;
    byte[] arrayOfByte = paramMediaDrmSessionManager$SessionId.mEmeId;
    if (mediaDrmStorageBridge.isNativeMediaDrmStorageValid()) {
      mediaDrmStorageBridge.nativeOnClearInfo(mediaDrmStorageBridge.mNativeMediaDrmStorageBridge, arrayOfByte, paramCallback);
      return;
    } 
    paramCallback.onResult(Boolean.valueOf(true));
  }
  
  final MediaDrmSessionManager$SessionInfo get(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId) {
    return (MediaDrmSessionManager$SessionInfo)this.mEmeSessionInfoMap.get(ByteBuffer.wrap(paramMediaDrmSessionManager$SessionId.mEmeId));
  }
  
  final List getAllSessionIds() {
    ArrayList<MediaDrmSessionManager$SessionId> arrayList = new ArrayList();
    Iterator<MediaDrmSessionManager$SessionInfo> iterator = this.mEmeSessionInfoMap.values().iterator();
    while (iterator.hasNext())
      arrayList.add(MediaDrmSessionManager$SessionInfo.access$100(iterator.next())); 
    return arrayList;
  }
  
  final MediaDrmSessionManager$SessionId getSessionIdByEmeId(byte[] paramArrayOfbyte) {
    return getSessionIdFromMap(this.mEmeSessionInfoMap, paramArrayOfbyte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */