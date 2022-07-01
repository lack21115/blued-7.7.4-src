package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserServiceCompatApi21 {
  public static Object createService(Context paramContext, ServiceCompatProxy paramServiceCompatProxy) {
    return new MediaBrowserServiceAdaptor(paramContext, paramServiceCompatProxy);
  }
  
  public static void notifyChildrenChanged(Object paramObject, String paramString) {
    ((MediaBrowserService)paramObject).notifyChildrenChanged(paramString);
  }
  
  public static IBinder onBind(Object paramObject, Intent paramIntent) {
    return ((MediaBrowserService)paramObject).onBind(paramIntent);
  }
  
  public static void onCreate(Object paramObject) {
    ((MediaBrowserService)paramObject).onCreate();
  }
  
  public static void setSessionToken(Object paramObject1, Object paramObject2) {
    ((MediaBrowserService)paramObject1).setSessionToken((MediaSession.Token)paramObject2);
  }
  
  static class BrowserRoot {
    final String a;
    
    final Bundle b;
    
    BrowserRoot(String param1String, Bundle param1Bundle) {
      this.a = param1String;
      this.b = param1Bundle;
    }
  }
  
  static class MediaBrowserServiceAdaptor extends MediaBrowserService {
    final MediaBrowserServiceCompatApi21.ServiceCompatProxy a;
    
    MediaBrowserServiceAdaptor(Context param1Context, MediaBrowserServiceCompatApi21.ServiceCompatProxy param1ServiceCompatProxy) {
      attachBaseContext(param1Context);
      this.a = param1ServiceCompatProxy;
    }
    
    public MediaBrowserService.BrowserRoot onGetRoot(String param1String, int param1Int, Bundle param1Bundle) {
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      MediaBrowserServiceCompatApi21.ServiceCompatProxy serviceCompatProxy = this.a;
      if (param1Bundle == null) {
        param1Bundle = null;
      } else {
        param1Bundle = new Bundle(param1Bundle);
      } 
      MediaBrowserServiceCompatApi21.BrowserRoot browserRoot = serviceCompatProxy.onGetRoot(param1String, param1Int, param1Bundle);
      return (browserRoot == null) ? null : new MediaBrowserService.BrowserRoot(browserRoot.a, browserRoot.b);
    }
    
    public void onLoadChildren(String param1String, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> param1Result) {
      this.a.onLoadChildren(param1String, new MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>>(param1Result));
    }
  }
  
  static class ResultWrapper<T> {
    MediaBrowserService.Result a;
    
    ResultWrapper(MediaBrowserService.Result param1Result) {
      this.a = param1Result;
    }
    
    List<MediaBrowser.MediaItem> a(List<Parcel> param1List) {
      if (param1List == null)
        return null; 
      ArrayList<Object> arrayList = new ArrayList();
      for (Parcel parcel : param1List) {
        parcel.setDataPosition(0);
        arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
        parcel.recycle();
      } 
      return arrayList;
    }
    
    public void detach() {
      this.a.detach();
    }
    
    public void sendResult(T param1T) {
      if (param1T instanceof List) {
        this.a.sendResult(a((List<Parcel>)param1T));
        return;
      } 
      if (param1T instanceof Parcel) {
        Parcel parcel = (Parcel)param1T;
        parcel.setDataPosition(0);
        this.a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        return;
      } 
      this.a.sendResult(null);
    }
  }
  
  public static interface ServiceCompatProxy {
    MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String param1String, int param1Int, Bundle param1Bundle);
    
    void onLoadChildren(String param1String, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> param1ResultWrapper);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\MediaBrowserServiceCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */