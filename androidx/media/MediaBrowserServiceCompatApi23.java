package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;

class MediaBrowserServiceCompatApi23 {
  public static Object createService(Context paramContext, ServiceCompatProxy paramServiceCompatProxy) {
    return new MediaBrowserServiceAdaptor(paramContext, paramServiceCompatProxy);
  }
  
  static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
    MediaBrowserServiceAdaptor(Context param1Context, MediaBrowserServiceCompatApi23.ServiceCompatProxy param1ServiceCompatProxy) {
      super(param1Context, param1ServiceCompatProxy);
    }
    
    public void onLoadItem(String param1String, MediaBrowserService.Result<MediaBrowser.MediaItem> param1Result) {
      ((MediaBrowserServiceCompatApi23.ServiceCompatProxy)this.a).onLoadItem(param1String, new MediaBrowserServiceCompatApi21.ResultWrapper<Parcel>(param1Result));
    }
  }
  
  public static interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
    void onLoadItem(String param1String, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> param1ResultWrapper);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\MediaBrowserServiceCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */