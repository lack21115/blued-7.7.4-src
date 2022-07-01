package com.baidu.mobads.production.g;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;

class b implements Observer {
  b(a parama) {}
  
  public void update(Observable paramObservable, Object paramObject) {
    a a1;
    IOAdDownloader iOAdDownloader = (IOAdDownloader)paramObservable;
    if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
      this.a.y.d("XAbstractAdProdTemplate", "download complete");
      if (Looper.myLooper() == Looper.getMainLooper()) {
        a1 = this.a;
        paramObject = new StringBuilder();
        paramObject.append(a.a(this.a));
        paramObject.append(a.b(this.a));
        a.a(a1, paramObject.toString());
        return;
      } 
      (new Handler(a.c(this.a).getMainLooper())).post(new c(this));
      return;
    } 
    if (a1.getState() == IOAdDownloader.DownloadStatus.ERROR) {
      this.a.y.d("XAbstractAdProdTemplate", "download error");
      a.b(this.a, "开屏因为3d背景图片下载失败跳过");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */