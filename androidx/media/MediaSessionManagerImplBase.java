package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;

class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {
  private static final boolean a = MediaSessionManager.a;
  
  Context b;
  
  ContentResolver c;
  
  MediaSessionManagerImplBase(Context paramContext) {
    this.b = paramContext;
    this.c = this.b.getContentResolver();
  }
  
  private boolean a(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl, String paramString) {
    return (paramRemoteUserInfoImpl.getPid() < 0) ? ((this.b.getPackageManager().checkPermission(paramString, paramRemoteUserInfoImpl.getPackageName()) == 0)) : ((this.b.checkPermission(paramString, paramRemoteUserInfoImpl.getPid(), paramRemoteUserInfoImpl.getUid()) == 0));
  }
  
  boolean a(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl) {
    String str = Settings.Secure.getString(this.c, "enabled_notification_listeners");
    if (str != null) {
      String[] arrayOfString = str.split(":");
      for (int i = 0; i < arrayOfString.length; i++) {
        ComponentName componentName = ComponentName.unflattenFromString(arrayOfString[i]);
        if (componentName != null && componentName.getPackageName().equals(paramRemoteUserInfoImpl.getPackageName()))
          return true; 
      } 
    } 
    return false;
  }
  
  public Context getContext() {
    return this.b;
  }
  
  public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl) {
    boolean bool = false;
    try {
      ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(paramRemoteUserInfoImpl.getPackageName(), 0);
      if (applicationInfo.uid != paramRemoteUserInfoImpl.getUid()) {
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Package name ");
          stringBuilder.append(paramRemoteUserInfoImpl.getPackageName());
          stringBuilder.append(" doesn't match with the uid ");
          stringBuilder.append(paramRemoteUserInfoImpl.getUid());
          Log.d("MediaSessionManager", stringBuilder.toString());
        } 
        return false;
      } 
      if (a(paramRemoteUserInfoImpl, "android.permission.STATUS_BAR_SERVICE") || a(paramRemoteUserInfoImpl, "android.permission.MEDIA_CONTENT_CONTROL") || paramRemoteUserInfoImpl.getUid() == 1000 || a(paramRemoteUserInfoImpl))
        bool = true; 
      return bool;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      if (a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Package ");
        stringBuilder.append(paramRemoteUserInfoImpl.getPackageName());
        stringBuilder.append(" doesn't exist");
        Log.d("MediaSessionManager", stringBuilder.toString());
      } 
      return false;
    } 
  }
  
  static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {
    private String a;
    
    private int b;
    
    private int c;
    
    RemoteUserInfoImplBase(String param1String, int param1Int1, int param1Int2) {
      this.a = param1String;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (!(param1Object instanceof RemoteUserInfoImplBase))
        return false; 
      param1Object = param1Object;
      return (TextUtils.equals(this.a, ((RemoteUserInfoImplBase)param1Object).a) && this.b == ((RemoteUserInfoImplBase)param1Object).b && this.c == ((RemoteUserInfoImplBase)param1Object).c);
    }
    
    public String getPackageName() {
      return this.a;
    }
    
    public int getPid() {
      return this.b;
    }
    
    public int getUid() {
      return this.c;
    }
    
    public int hashCode() {
      return ObjectsCompat.hash(new Object[] { this.a, Integer.valueOf(this.b), Integer.valueOf(this.c) });
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\MediaSessionManagerImplBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */