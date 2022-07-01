package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.core.util.ObjectsCompat;

class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
  MediaSessionManager a;
  
  MediaSessionManagerImplApi28(Context paramContext) {
    super(paramContext);
    this.a = (MediaSessionManager)paramContext.getSystemService("media_session");
  }
  
  public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl) {
    return (paramRemoteUserInfoImpl instanceof RemoteUserInfoImplApi28) ? this.a.isTrustedForMediaControl(((RemoteUserInfoImplApi28)paramRemoteUserInfoImpl).a) : false;
  }
  
  static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
    final MediaSessionManager.RemoteUserInfo a;
    
    RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo param1RemoteUserInfo) {
      this.a = param1RemoteUserInfo;
    }
    
    RemoteUserInfoImplApi28(String param1String, int param1Int1, int param1Int2) {
      this.a = new MediaSessionManager.RemoteUserInfo(param1String, param1Int1, param1Int2);
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (!(param1Object instanceof RemoteUserInfoImplApi28))
        return false; 
      param1Object = param1Object;
      return this.a.equals(((RemoteUserInfoImplApi28)param1Object).a);
    }
    
    public String getPackageName() {
      return this.a.getPackageName();
    }
    
    public int getPid() {
      return this.a.getPid();
    }
    
    public int getUid() {
      return this.a.getUid();
    }
    
    public int hashCode() {
      return ObjectsCompat.hash(new Object[] { this.a });
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\MediaSessionManagerImplApi28.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */