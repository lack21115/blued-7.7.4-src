package org.chromium.media;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

@SuppressLint({"WrongConstant"})
@TargetApi(19)
public class MediaDrmBridge {
  private static final byte[] DUMMY_KEY_ID;
  
  private static final byte[] UNPROVISION;
  
  private static final UUID WIDEVINE_UUID;
  
  private static final MediaDrmBridge$MediaCryptoDeferrer sMediaCryptoDeferrer;
  
  private MediaCrypto mMediaCrypto;
  
  private MediaDrmSessionManager$SessionId mMediaCryptoSession;
  
  private MediaDrm mMediaDrm;
  
  private long mNativeMediaDrmBridge;
  
  private boolean mOriginSet = false;
  
  private boolean mProvisioningPending;
  
  private final boolean mRequiresMediaCrypto;
  
  private boolean mResetDeviceCredentialsPending;
  
  private UUID mSchemeUUID;
  
  private MediaDrmBridge$SessionEventDeferrer mSessionEventDeferrer = null;
  
  private MediaDrmSessionManager mSessionManager;
  
  private MediaDrmStorageBridge mStorage;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @TargetApi(23)
  private MediaDrmBridge(UUID paramUUID, boolean paramBoolean, long paramLong1, long paramLong2) {
    this.mSchemeUUID = paramUUID;
    this.mMediaDrm = new MediaDrm(paramUUID);
    this.mRequiresMediaCrypto = paramBoolean;
    this.mNativeMediaDrmBridge = paramLong1;
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void closeSession(byte[] paramArrayOfbyte, long paramLong) {
    StringBuilder stringBuilder;
    if (this.mMediaDrm == null) {
      onPromiseRejected(paramLong, "closeSession() called when MediaDrm is null.");
      return;
    } 
    MediaDrmSessionManager$SessionId mediaDrmSessionManager$SessionId = getSessionIdByEmeId(paramArrayOfbyte);
    if (mediaDrmSessionManager$SessionId == null) {
      stringBuilder = new StringBuilder("Invalid sessionId in closeSession(): ");
      stringBuilder.append(MediaDrmSessionManager$SessionId.toHexString(paramArrayOfbyte));
      onPromiseRejected(paramLong, stringBuilder.toString());
      return;
    } 
    try {
      this.mMediaDrm.removeKeys(((MediaDrmSessionManager$SessionId)stringBuilder).mDrmId);
    } catch (Exception exception) {
      Log.e("cr_media", "removeKeys failed: ", new Object[] { exception });
    } 
    closeSessionNoException((MediaDrmSessionManager$SessionId)stringBuilder);
    MediaDrmSessionManager mediaDrmSessionManager = this.mSessionManager;
    MediaDrmSessionManager$SessionInfo mediaDrmSessionManager$SessionInfo = mediaDrmSessionManager.get((MediaDrmSessionManager$SessionId)stringBuilder);
    if (MediaDrmSessionManager.$assertionsDisabled || mediaDrmSessionManager$SessionInfo != null) {
      if (MediaDrmSessionManager.$assertionsDisabled || stringBuilder.isEqual(MediaDrmSessionManager$SessionInfo.access$100(mediaDrmSessionManager$SessionInfo))) {
        mediaDrmSessionManager.mEmeSessionInfoMap.remove(ByteBuffer.wrap(((MediaDrmSessionManager$SessionId)stringBuilder).mEmeId));
        if (((MediaDrmSessionManager$SessionId)stringBuilder).mDrmId != null)
          mediaDrmSessionManager.mDrmSessionInfoMap.remove(ByteBuffer.wrap(((MediaDrmSessionManager$SessionId)stringBuilder).mDrmId)); 
        onPromiseResolved(paramLong);
        onSessionClosed((MediaDrmSessionManager$SessionId)stringBuilder);
        stringBuilder.toHexString();
        return;
      } 
      throw new AssertionError();
    } 
    throw new AssertionError();
  }
  
  private void closeSessionNoException(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId) {
    try {
      this.mMediaDrm.closeSession(paramMediaDrmSessionManager$SessionId.mDrmId);
      return;
    } catch (Exception exception) {
      Log.e("cr_media", "closeSession failed: ", new Object[] { exception });
      return;
    } 
  }
  
  @CalledByNative
  private static MediaDrmBridge create(byte[] paramArrayOfbyte, String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2) {
    UUID uUID = getUUIDFromBytes(paramArrayOfbyte);
    if (uUID != null) {
      if (!MediaDrm.isCryptoSchemeSupported(uUID))
        return null; 
      try {
        MediaDrmBridge mediaDrmBridge = new MediaDrmBridge(uUID, paramBoolean, paramLong1, paramLong2);
        return (!paramString2.isEmpty() && !mediaDrmBridge.setSecurityLevel(paramString2)) ? null : ((!paramString1.isEmpty() && !mediaDrmBridge.setOrigin(paramString1)) ? null : ((paramBoolean && !mediaDrmBridge.createMediaCrypto()) ? null : mediaDrmBridge));
      } catch (UnsupportedSchemeException unsupportedSchemeException) {
        Log.e("cr_media", "Unsupported DRM scheme", new Object[] { unsupportedSchemeException });
        return null;
      } catch (IllegalArgumentException illegalArgumentException) {
        Log.e("cr_media", "Failed to create MediaDrmBridge", new Object[] { illegalArgumentException });
        return null;
      } catch (IllegalStateException illegalStateException) {
        Log.e("cr_media", "Failed to create MediaDrmBridge", new Object[] { illegalStateException });
        return null;
      } 
    } 
    return null;
  }
  
  private boolean createMediaCrypto() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void createSessionFromNative(byte[] paramArrayOfbyte, String paramString, int paramInt, String[] paramArrayOfString, long paramLong) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramArrayOfString != null)
      if (paramArrayOfString.length % 2 == 0) {
        int i;
        for (i = 0; i < paramArrayOfString.length; i += 2)
          hashMap.put(paramArrayOfString[i], paramArrayOfString[i + 1]); 
      } else {
        throw new IllegalArgumentException("Additional data array doesn't have equal keys/values");
      }  
    if (this.mMediaDrm == null) {
      Log.e("cr_media", "createSession() called when MediaDrm is null.", new Object[0]);
      onPromiseRejected(paramLong, "MediaDrm released previously.");
      return;
    } 
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void destroy() {
    this.mNativeMediaDrmBridge = 0L;
    if (this.mMediaDrm != null)
      release(); 
  }
  
  private static List getDummyKeysInfo(int paramInt) {
    ArrayList<MediaDrmBridge$KeyStatus> arrayList = new ArrayList();
    arrayList.add(new MediaDrmBridge$KeyStatus(DUMMY_KEY_ID, paramInt, (byte)0));
    return arrayList;
  }
  
  private MediaDrm.KeyRequest getKeyRequest(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId, byte[] paramArrayOfbyte, String paramString, int paramInt, HashMap<Object, Object> paramHashMap) {
    byte[] arrayOfByte;
    HashMap<Object, Object> hashMap;
    if ($assertionsDisabled || this.mMediaDrm != null) {
      if ($assertionsDisabled || this.mMediaCryptoSession != null) {
        if ($assertionsDisabled || !this.mProvisioningPending) {
          hashMap = paramHashMap;
          if (paramHashMap == null)
            hashMap = new HashMap<Object, Object>(); 
          if (paramInt == 3)
            try {
              byte[] arrayOfByte1 = paramMediaDrmSessionManager$SessionId.mKeySetId;
              assert false;
              throw new AssertionError();
            } catch (IllegalStateException illegalStateException) {
              if (Build.VERSION.SDK_INT >= 21 && illegalStateException instanceof MediaDrm.MediaDrmStateException)
                Log.e("cr_media", "MediaDrmStateException fired during getKeyRequest().", new Object[] { illegalStateException }); 
              return null;
            }  
          arrayOfByte = ((MediaDrmSessionManager$SessionId)illegalStateException).mDrmId;
        } else {
          throw new AssertionError();
        } 
      } else {
        throw new AssertionError();
      } 
    } else {
      throw new AssertionError();
    } 
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getSecurityLevel() {
    if (this.mMediaDrm == null || !isWidevine()) {
      Log.e("cr_media", "getSecurityLevel(): MediaDrm is null or security level is not supported.", new Object[0]);
      return "";
    } 
    return this.mMediaDrm.getPropertyString("securityLevel");
  }
  
  private MediaDrmSessionManager$SessionId getSessionIdByEmeId(byte[] paramArrayOfbyte) {
    if (this.mMediaCryptoSession == null) {
      Log.e("cr_media", "Session doesn't exist because media crypto session is not created.", new Object[0]);
      return null;
    } 
    MediaDrmSessionManager$SessionId mediaDrmSessionManager$SessionId = this.mSessionManager.getSessionIdByEmeId(paramArrayOfbyte);
    if (mediaDrmSessionManager$SessionId == null)
      return null; 
    assert false;
    return mediaDrmSessionManager$SessionId;
  }
  
  private static UUID getUUIDFromBytes(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length != 16)
      return null; 
    int i = 0;
    long l2 = 0L;
    long l1 = 0L;
    while (i < 8) {
      l1 = l1 << 8L | (paramArrayOfbyte[i] & 0xFF);
      i++;
    } 
    for (i = 8; i < 16; i++)
      l2 = l2 << 8L | (paramArrayOfbyte[i] & 0xFF); 
    return new UUID(l1, l2);
  }
  
  @CalledByNative
  private static boolean isCryptoSchemeSupported(byte[] paramArrayOfbyte, String paramString) {
    UUID uUID = getUUIDFromBytes(paramArrayOfbyte);
    return paramString.isEmpty() ? MediaDrm.isCryptoSchemeSupported(uUID) : MediaDrm.isCryptoSchemeSupported(uUID, paramString);
  }
  
  private boolean isNativeMediaDrmBridgeValid() {
    return (this.mNativeMediaDrmBridge != 0L);
  }
  
  private boolean isWidevine() {
    return this.mSchemeUUID.equals(WIDEVINE_UUID);
  }
  
  @CalledByNative
  private void loadSession(byte[] paramArrayOfbyte, long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  private native void nativeOnMediaCryptoReady(long paramLong, MediaCrypto paramMediaCrypto);
  
  private native void nativeOnPromiseRejected(long paramLong1, long paramLong2, String paramString);
  
  private native void nativeOnPromiseResolved(long paramLong1, long paramLong2);
  
  private native void nativeOnPromiseResolvedWithSession(long paramLong1, long paramLong2, byte[] paramArrayOfbyte);
  
  private native void nativeOnResetDeviceCredentialsCompleted(long paramLong, boolean paramBoolean);
  
  private native void nativeOnSessionClosed(long paramLong, byte[] paramArrayOfbyte);
  
  private native void nativeOnSessionExpirationUpdate(long paramLong1, byte[] paramArrayOfbyte, long paramLong2);
  
  private native void nativeOnSessionKeysChange(long paramLong, byte[] paramArrayOfbyte, Object[] paramArrayOfObject, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeOnSessionMessage(long paramLong, byte[] paramArrayOfbyte1, int paramInt, byte[] paramArrayOfbyte2);
  
  private native void nativeOnStartProvisioning(long paramLong, String paramString, byte[] paramArrayOfbyte);
  
  private void onMediaCryptoReady(MediaCrypto paramMediaCrypto) {
    if (isNativeMediaDrmBridgeValid())
      nativeOnMediaCryptoReady(this.mNativeMediaDrmBridge, paramMediaCrypto); 
  }
  
  private void onPersistentLicenseNoExist(long paramLong) {
    onPromiseResolvedWithSession(paramLong, MediaDrmSessionManager$SessionId.createNoExistSessionId());
  }
  
  private void onPromiseRejected(long paramLong, String paramString) {
    Log.e("cr_media", "onPromiseRejected: %s", new Object[] { paramString });
    if (isNativeMediaDrmBridgeValid())
      nativeOnPromiseRejected(this.mNativeMediaDrmBridge, paramLong, paramString); 
  }
  
  private void onPromiseResolved(long paramLong) {
    if (isNativeMediaDrmBridgeValid())
      nativeOnPromiseResolved(this.mNativeMediaDrmBridge, paramLong); 
  }
  
  private void onPromiseResolvedWithSession(long paramLong, MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId) {
    if (isNativeMediaDrmBridgeValid())
      nativeOnPromiseResolvedWithSession(this.mNativeMediaDrmBridge, paramLong, paramMediaDrmSessionManager$SessionId.mEmeId); 
  }
  
  private void onResetDeviceCredentialsCompleted(boolean paramBoolean) {
    if (isNativeMediaDrmBridgeValid())
      nativeOnResetDeviceCredentialsCompleted(this.mNativeMediaDrmBridge, paramBoolean); 
  }
  
  private void onSessionClosed(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId) {
    if (isNativeMediaDrmBridgeValid())
      nativeOnSessionClosed(this.mNativeMediaDrmBridge, paramMediaDrmSessionManager$SessionId.mEmeId); 
  }
  
  private void onSessionKeysChange(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId, Object[] paramArrayOfObject, boolean paramBoolean1, boolean paramBoolean2) {
    if (isNativeMediaDrmBridgeValid())
      nativeOnSessionKeysChange(this.mNativeMediaDrmBridge, paramMediaDrmSessionManager$SessionId.mEmeId, paramArrayOfObject, paramBoolean1, paramBoolean2); 
  }
  
  @TargetApi(23)
  private void onSessionMessage(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId, MediaDrm.KeyRequest paramKeyRequest) {
    boolean bool;
    if (!isNativeMediaDrmBridgeValid())
      return; 
    if (Build.VERSION.SDK_INT >= 23) {
      bool = paramKeyRequest.getRequestType();
    } else if (paramKeyRequest.getDefaultUrl().isEmpty()) {
      bool = false;
    } else {
      bool = true;
    } 
    nativeOnSessionMessage(this.mNativeMediaDrmBridge, paramMediaDrmSessionManager$SessionId.mEmeId, bool, paramKeyRequest.getData());
  }
  
  private byte[] openSession() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void processProvisionResponse(boolean paramBoolean, byte[] paramArrayOfbyte) {
    assert false;
    throw new AssertionError();
  }
  
  private boolean provideProvisionResponse(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
      Log.e("cr_media", "Invalid provision response.", new Object[0]);
      return false;
    } 
    try {
      this.mMediaDrm.provideProvisionResponse(paramArrayOfbyte);
      return true;
    } catch (DeniedByServerException deniedByServerException) {
      Log.e("cr_media", "failed to provide provision response", new Object[] { deniedByServerException });
      return false;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_media", "failed to provide provision response", new Object[] { illegalStateException });
      return false;
    } 
  }
  
  private void release() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void removeSession(byte[] paramArrayOfbyte, long paramLong) {
    MediaDrmSessionManager$SessionId mediaDrmSessionManager$SessionId = getSessionIdByEmeId(paramArrayOfbyte);
    if (mediaDrmSessionManager$SessionId == null) {
      onPromiseRejected(paramLong, "Session doesn't exist");
      return;
    } 
    MediaDrmSessionManager$SessionInfo mediaDrmSessionManager$SessionInfo = this.mSessionManager.get(mediaDrmSessionManager$SessionId);
    if (mediaDrmSessionManager$SessionInfo.mKeyType != 2) {
      onPromiseRejected(paramLong, "Removing temporary session isn't implemented");
      return;
    } 
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void resetDeviceCredentials() {
    if (this.mMediaDrm == null) {
      onResetDeviceCredentialsCompleted(false);
      return;
    } 
    this.mResetDeviceCredentialsPending = true;
    startProvisioning();
  }
  
  private boolean setOrigin(String paramString) {
    assert false;
    throw new AssertionError();
  }
  
  private boolean setSecurityLevel(String paramString) {
    if (!isWidevine())
      return true; 
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean setServerCertificate(byte[] paramArrayOfbyte) {
    if (!isWidevine())
      return true; 
    try {
      this.mMediaDrm.setPropertyByteArray("serviceCertificate", paramArrayOfbyte);
      return true;
    } catch (IllegalArgumentException illegalArgumentException) {
      Log.e("cr_media", "Failed to set server certificate", new Object[] { illegalArgumentException });
      return false;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_media", "Failed to set server certificate", new Object[] { illegalStateException });
      return false;
    } 
  }
  
  private void startProvisioning() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void unprovision() {
    if (this.mMediaDrm == null)
      return; 
    if (!this.mOriginSet)
      return; 
    provideProvisionResponse(UNPROVISION);
  }
  
  @CalledByNative
  private void updateSession(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, long paramLong) {
    StringBuilder stringBuilder;
    if (this.mMediaDrm == null) {
      onPromiseRejected(paramLong, "updateSession() called when MediaDrm is null.");
      return;
    } 
    MediaDrmSessionManager$SessionId mediaDrmSessionManager$SessionId = getSessionIdByEmeId(paramArrayOfbyte1);
    if (mediaDrmSessionManager$SessionId == null) {
      assert false;
      throw new AssertionError();
    } 
    try {
      boolean bool;
      MediaDrmSessionManager$SessionInfo mediaDrmSessionManager$SessionInfo = this.mSessionManager.get(mediaDrmSessionManager$SessionId);
      if (mediaDrmSessionManager$SessionInfo.mKeyType == 3) {
        bool = true;
      } else {
        bool = false;
      } 
      paramArrayOfbyte1 = null;
      if (bool) {
        if ($assertionsDisabled || mediaDrmSessionManager$SessionId.mKeySetId != null) {
          this.mMediaDrm.provideKeyResponse(mediaDrmSessionManager$SessionId.mKeySetId, (byte[])stringBuilder);
        } else {
          throw new AssertionError();
        } 
      } else {
        paramArrayOfbyte1 = this.mMediaDrm.provideKeyResponse(mediaDrmSessionManager$SessionId.mDrmId, (byte[])stringBuilder);
      } 
      MediaDrmBridge$KeyUpdatedCallback mediaDrmBridge$KeyUpdatedCallback = new MediaDrmBridge$KeyUpdatedCallback(this, mediaDrmSessionManager$SessionId, paramLong, bool);
      if (bool) {
        this.mSessionManager.clearPersistentSessionInfo(mediaDrmSessionManager$SessionId, mediaDrmBridge$KeyUpdatedCallback);
        return;
      } 
      if (mediaDrmSessionManager$SessionInfo.mKeyType == 2 && paramArrayOfbyte1 != null && paramArrayOfbyte1.length > 0) {
        MediaDrmSessionManager mediaDrmSessionManager = this.mSessionManager;
        if (MediaDrmSessionManager.$assertionsDisabled || mediaDrmSessionManager.get(mediaDrmSessionManager$SessionId) != null) {
          if (MediaDrmSessionManager.$assertionsDisabled || (mediaDrmSessionManager.get(mediaDrmSessionManager$SessionId)).mKeyType == 2) {
            if (MediaDrmSessionManager.$assertionsDisabled || mediaDrmSessionManager$SessionId.mKeySetId == null) {
              MediaDrmSessionManager$SessionId.access$300(mediaDrmSessionManager$SessionId, paramArrayOfbyte1);
              MediaDrmStorageBridge mediaDrmStorageBridge = mediaDrmSessionManager.mStorage;
              MediaDrmStorageBridge$PersistentInfo mediaDrmStorageBridge$PersistentInfo = MediaDrmSessionManager$SessionInfo.access$400(mediaDrmSessionManager.get(mediaDrmSessionManager$SessionId));
              if (mediaDrmStorageBridge.isNativeMediaDrmStorageValid()) {
                mediaDrmStorageBridge.nativeOnSaveInfo(mediaDrmStorageBridge.mNativeMediaDrmStorageBridge, mediaDrmStorageBridge$PersistentInfo, mediaDrmBridge$KeyUpdatedCallback);
                return;
              } 
              mediaDrmBridge$KeyUpdatedCallback.onResult(Boolean.valueOf(false));
              return;
            } 
            throw new AssertionError();
          } 
          throw new AssertionError();
        } 
        throw new AssertionError();
      } 
      mediaDrmBridge$KeyUpdatedCallback.onResult(Boolean.valueOf(true));
      return;
    } catch (NotProvisionedException notProvisionedException) {
      Log.e("cr_media", "failed to provide key response", new Object[] { notProvisionedException });
    } catch (DeniedByServerException deniedByServerException) {
      Log.e("cr_media", "failed to provide key response", new Object[] { deniedByServerException });
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_media", "failed to provide key response", new Object[] { illegalStateException });
    } 
    onPromiseRejected(paramLong, "Update session failed.");
    release();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */