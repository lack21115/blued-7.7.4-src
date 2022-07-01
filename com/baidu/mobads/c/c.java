package com.baidu.mobads.c;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;

class c implements Observer {
  c(a parama, String paramString, ImageView paramImageView) {}
  
  public void update(Observable paramObservable, Object paramObject) {
    if (((IOAdDownloader)paramObservable).getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
      Bitmap bitmap = a.a(this.c, a.b(this.a), this.b, false);
      if (bitmap != null) {
        a.b().post(new d(this, bitmap));
        a.a(this.c, this.a, bitmap);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */