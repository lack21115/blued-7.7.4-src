package androidx.media;

import android.content.Context;

class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
  MediaSessionManagerImplApi21(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
  }
  
  private boolean b(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl) {
    return (getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", paramRemoteUserInfoImpl.getPid(), paramRemoteUserInfoImpl.getUid()) == 0);
  }
  
  public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl) {
    return (b(paramRemoteUserInfoImpl) || super.isTrustedForMediaControl(paramRemoteUserInfoImpl));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\MediaSessionManagerImplApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */