package androidx.media;

import android.content.Context;
import android.os.Build;
import android.util.Log;

public final class MediaSessionManager {
  static final boolean a = Log.isLoggable("MediaSessionManager", 3);
  
  private static final Object c = new Object();
  
  private static volatile MediaSessionManager d;
  
  MediaSessionManagerImpl b;
  
  private MediaSessionManager(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 28) {
      this.b = new MediaSessionManagerImplApi28(paramContext);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      this.b = new MediaSessionManagerImplApi21(paramContext);
      return;
    } 
    this.b = new MediaSessionManagerImplBase(paramContext);
  }
  
  public static MediaSessionManager getSessionManager(Context paramContext) {
    MediaSessionManager mediaSessionManager = d;
    if (mediaSessionManager == null)
      synchronized (c) {
        MediaSessionManager mediaSessionManager1 = d;
        mediaSessionManager = mediaSessionManager1;
        if (mediaSessionManager1 == null) {
          d = new MediaSessionManager(paramContext.getApplicationContext());
          mediaSessionManager = d;
        } 
        return mediaSessionManager;
      }  
    return mediaSessionManager;
  }
  
  public boolean isTrustedForMediaControl(RemoteUserInfo paramRemoteUserInfo) {
    if (paramRemoteUserInfo != null)
      return this.b.isTrustedForMediaControl(paramRemoteUserInfo.a); 
    throw new IllegalArgumentException("userInfo should not be null");
  }
  
  static interface MediaSessionManagerImpl {
    Context getContext();
    
    boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl param1RemoteUserInfoImpl);
  }
  
  public static final class RemoteUserInfo {
    public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
    
    MediaSessionManager.RemoteUserInfoImpl a;
    
    public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo param1RemoteUserInfo) {
      this.a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(param1RemoteUserInfo);
    }
    
    public RemoteUserInfo(String param1String, int param1Int1, int param1Int2) {
      if (Build.VERSION.SDK_INT >= 28) {
        this.a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(param1String, param1Int1, param1Int2);
        return;
      } 
      this.a = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(param1String, param1Int1, param1Int2);
    }
    
    public boolean equals(Object param1Object) {
      return (this == param1Object) ? true : (!(param1Object instanceof RemoteUserInfo) ? false : this.a.equals(((RemoteUserInfo)param1Object).a));
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
      return this.a.hashCode();
    }
  }
  
  static interface RemoteUserInfoImpl {
    String getPackageName();
    
    int getPid();
    
    int getUid();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\MediaSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */