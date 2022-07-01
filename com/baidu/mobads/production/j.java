package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;

class j implements Observer {
  j(b paramb, IXAdInstanceInfo paramIXAdInstanceInfo, String paramString1, String paramString2, String paramString3) {}
  
  public void update(Observable paramObservable, Object paramObject) {
    IOAdDownloader iOAdDownloader = (IOAdDownloader)paramObservable;
    if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.CANCELLED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETE_BUT_FILE_REMOVED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.PAUSED)
      b.a(this.e, this.a, this.b, this.c, this.d); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */