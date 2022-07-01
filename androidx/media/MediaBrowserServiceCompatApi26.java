package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserServiceCompatApi26 {
  static Field a;
  
  static {
    try {
      a = MediaBrowserService.Result.class.getDeclaredField("mFlags");
      a.setAccessible(true);
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      Log.w("MBSCompatApi26", noSuchFieldException);
      return;
    } 
  }
  
  public static Object createService(Context paramContext, ServiceCompatProxy paramServiceCompatProxy) {
    return new MediaBrowserServiceAdaptor(paramContext, paramServiceCompatProxy);
  }
  
  public static Bundle getBrowserRootHints(Object paramObject) {
    return ((MediaBrowserService)paramObject).getBrowserRootHints();
  }
  
  public static void notifyChildrenChanged(Object paramObject, String paramString, Bundle paramBundle) {
    ((MediaBrowserService)paramObject).notifyChildrenChanged(paramString, paramBundle);
  }
  
  static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
    MediaBrowserServiceAdaptor(Context param1Context, MediaBrowserServiceCompatApi26.ServiceCompatProxy param1ServiceCompatProxy) {
      super(param1Context, param1ServiceCompatProxy);
    }
    
    public void onLoadChildren(String param1String, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> param1Result, Bundle param1Bundle) {
      MediaSessionCompat.ensureClassLoader(param1Bundle);
      ((MediaBrowserServiceCompatApi26.ServiceCompatProxy)this.a).onLoadChildren(param1String, new MediaBrowserServiceCompatApi26.ResultWrapper(param1Result), param1Bundle);
    }
  }
  
  static class ResultWrapper {
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
    
    public void sendResult(List<Parcel> param1List, int param1Int) {
      try {
        MediaBrowserServiceCompatApi26.a.setInt(this.a, param1Int);
      } catch (IllegalAccessException illegalAccessException) {
        Log.w("MBSCompatApi26", illegalAccessException);
      } 
      this.a.sendResult(a(param1List));
    }
  }
  
  public static interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
    void onLoadChildren(String param1String, MediaBrowserServiceCompatApi26.ResultWrapper param1ResultWrapper, Bundle param1Bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\MediaBrowserServiceCompatApi26.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */