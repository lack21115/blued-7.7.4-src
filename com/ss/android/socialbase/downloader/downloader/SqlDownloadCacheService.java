package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.impls.d;

public class SqlDownloadCacheService extends Service {
  private static final String a = SqlDownloadCacheService.class.getSimpleName();
  
  public static void a(Context paramContext, ServiceConnection paramServiceConnection) {
    if (paramContext != null)
      try {
        Intent intent = new Intent(paramContext, SqlDownloadCacheService.class);
        if (paramServiceConnection != null)
          paramContext.bindService(intent, paramServiceConnection, 1); 
        return;
      } finally {
        paramContext = null;
      }  
  }
  
  public IBinder onBind(Intent paramIntent) {
    k k = b.p();
    if (k instanceof d) {
      k = ((d)k).e();
    } else if (k instanceof s) {
      k = k;
    } else {
      k = null;
    } 
    return (IBinder)((k instanceof IBinder) ? k : new Binder());
  }
  
  public void onCreate() {
    super.onCreate();
    b.a(getApplicationContext());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\SqlDownloadCacheService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */