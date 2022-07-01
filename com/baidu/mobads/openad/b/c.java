package com.baidu.mobads.openad.b;

import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

class c implements Runnable {
  c(b paramb, IOAdDownloader paramIOAdDownloader) {}
  
  public void run() {
    try {
      if ((b.a(this.b)).g == IOAdDownloader.DownloadStatus.CANCELLED) {
        b.b().cancel((b.a(this.b)).f);
        return;
      } 
      b.b().notify((b.a(this.b)).f, b.a(this.b, this.a));
      if ((b.a(this.b)).g == IOAdDownloader.DownloadStatus.ERROR) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "status >> error");
        return;
      } 
      if ((b.a(this.b)).g == IOAdDownloader.DownloadStatus.INITING && (b.a(this.b)).r == 1) {
        b b1 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("开始下载 ");
        stringBuilder.append((b.a(this.b)).a);
        b.a(b1, stringBuilder.toString());
        return;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */