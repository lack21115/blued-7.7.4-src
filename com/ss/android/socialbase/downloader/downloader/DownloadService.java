package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.f.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class DownloadService extends Service {
  private static final String b = DownloadService.class.getSimpleName();
  
  protected p a;
  
  public IBinder onBind(Intent paramIntent) {
    boolean bool;
    String str = b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onBind downloadServiceHandler != null:");
    if (this.a != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    a.b(str, stringBuilder.toString());
    p p1 = this.a;
    return (p1 != null) ? p1.a(paramIntent) : null;
  }
  
  public void onCreate() {
    super.onCreate();
    b.a((Context)this);
    this.a = b.q();
    this.a.a(new WeakReference<DownloadService>(this));
  }
  
  public void onDestroy() {
    if (a.a())
      a.b(b, "Service onDestroy"); 
    p p1 = this.a;
    if (p1 != null) {
      p1.d();
      this.a = null;
    } 
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    if (a.a())
      a.b(b, "DownloadService onStartCommand"); 
    this.a.c();
    ExecutorService executorService = b.j();
    if (executorService != null)
      executorService.execute(new Runnable(this, paramIntent, paramInt1, paramInt2) {
            public void run() {
              if (this.d.a != null)
                this.d.a.a(this.a, this.b, this.c); 
            }
          }); 
    return 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */