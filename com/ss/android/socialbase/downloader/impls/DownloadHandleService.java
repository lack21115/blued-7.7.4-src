package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;

public class DownloadHandleService extends Service {
  private static final String a = DownloadHandleService.class.getSimpleName();
  
  private void a(Intent paramIntent) {
    if (paramIntent == null)
      return; 
    String str = paramIntent.getAction();
    if (TextUtils.isEmpty(str))
      return; 
    int i = paramIntent.getIntExtra("extra_download_id", 0);
    if (i == 0)
      return; 
    if (str.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
      b.k().execute(new Runnable(this, i) {
            public void run() {
              try {
                c.a().m(this.a);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                return;
              } 
            }
          });
      return;
    } 
    if (str.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
      c.a().n(i);
      return;
    } 
    if (str.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY"))
      b.a(); 
  }
  
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public void onCreate() {
    super.onCreate();
    b.a((Context)this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    a(paramIntent);
    return 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\DownloadHandleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */