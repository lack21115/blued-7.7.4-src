package com.blued.android.framework.web;

import android.net.Uri;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.framework.urlroute.BluedURIRouter;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WebDownloaderManager {
  private Set<String> a = new HashSet<String>();
  
  private Set<DownloaderJSCallback> b = new HashSet<DownloaderJSCallback>();
  
  private WebDownloaderManager() {}
  
  public static WebDownloaderManager a() {
    return SingletonCreator.a();
  }
  
  public void a(DownloaderJSCallback paramDownloaderJSCallback) {
    synchronized (this.b) {
      this.b.add(paramDownloaderJSCallback);
      return;
    } 
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    synchronized (this.b) {
      Iterator<DownloaderJSCallback> iterator = this.b.iterator();
      while (iterator.hasNext())
        ((DownloaderJSCallback)iterator.next()).a(-1, paramString3, paramString2, 0); 
      return;
    } 
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    DownloadListener downloadListener = new DownloadListener(this);
    downloadListener.a = paramString1;
    downloadListener.b = paramString2;
    downloadListener.c = RecyclingUtils.e(paramString2);
    downloadListener.d = paramString3;
    downloadListener.e = paramString4;
    synchronized (this.a) {
      if (this.a.contains(paramString2))
        return; 
      this.a.add(paramString2);
      FileDownloader.a(downloadListener.b, downloadListener.c, downloadListener, null);
      return;
    } 
  }
  
  public void b(DownloaderJSCallback paramDownloaderJSCallback) {
    synchronized (this.b) {
      this.b.remove(paramDownloaderJSCallback);
      return;
    } 
  }
  
  public class DownloadListener extends FileHttpResponseHandler {
    public String a;
    
    public String b;
    
    public String c;
    
    public String d;
    
    public String e;
    
    public long f;
    
    public long g;
    
    private int i = 0;
    
    public DownloadListener(WebDownloaderManager this$0) {}
    
    public void a(File param1File) {
      synchronized (WebDownloaderManager.a(this.h)) {
        Iterator<DownloaderJSCallback> iterator = WebDownloaderManager.a(this.h).iterator();
        while (iterator.hasNext())
          ((DownloaderJSCallback)iterator.next()).a(1, this.e, this.d, 100); 
        return;
      } 
    }
    
    public void a(Throwable param1Throwable, int param1Int, File param1File) {
      super.onFailure(param1Throwable, param1Int, param1File);
      synchronized (WebDownloaderManager.a(this.h)) {
        Iterator<DownloaderJSCallback> iterator = WebDownloaderManager.a(this.h).iterator();
        while (iterator.hasNext())
          ((DownloaderJSCallback)iterator.next()).a(-1, this.e, this.d, 0); 
        return;
      } 
    }
    
    public boolean onAccept(int param1Int, long param1Long) {
      this.g = param1Long;
      return super.onAccept(param1Int, param1Long);
    }
    
    public void onFinish() {
      Set set;
      Uri uri;
      super.onFinish();
      synchronized (WebDownloaderManager.b(this.h)) {
        WebDownloaderManager.b(this.h).remove(this.b);
        if ("emotionpack".equals(this.d) && BluedURIRouter.a().b()) {
          BluedURIRouter bluedURIRouter = BluedURIRouter.a();
          String str = this.c;
          uri = bluedURIRouter.a("http://common.blued.com", "download_emotion", new String[] { "download_path" }, new String[] { str });
          BluedURIRouter.a().a(null, uri);
        } 
        return;
      } 
    }
    
    public void onProgress(int param1Int1, int param1Int2) {
      super.onProgress(param1Int1, param1Int2);
      this.f = param1Int2;
      if (this.i + 10 <= param1Int1) {
        this.i = param1Int1;
        synchronized (WebDownloaderManager.a(this.h)) {
          Iterator<DownloaderJSCallback> iterator = WebDownloaderManager.a(this.h).iterator();
          while (iterator.hasNext())
            ((DownloaderJSCallback)iterator.next()).a(0, this.e, this.d, param1Int1); 
          return;
        } 
      } 
    }
  }
  
  static class SingletonCreator {
    private static final WebDownloaderManager a = new WebDownloaderManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\WebDownloaderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */