package com.ss.android.socialbase.downloader.downloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.m.c;
import java.lang.ref.WeakReference;

public class IndependentProcessDownloadService extends DownloadService {
  private static final String b = IndependentProcessDownloadService.class.getSimpleName();
  
  private static boolean c = false;
  
  private static int d = 0;
  
  private static long e = 0L;
  
  private Handler f = new Handler(Looper.getMainLooper());
  
  private ServiceConnection g = new ServiceConnection(this) {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        IndependentProcessDownloadService.a(true);
        a.b(IndependentProcessDownloadService.a(), "onServiceConnected: ");
        try {
          param1IBinder.linkToDeath(new IBinder.DeathRecipient(this) {
                public void binderDied() {
                  IndependentProcessDownloadService.a(false);
                  a.d(IndependentProcessDownloadService.a(), "binderDied:");
                  IndependentProcessDownloadService.b(this.a.a);
                }
              }0);
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        } 
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        IndependentProcessDownloadService.a(false);
      }
    };
  
  private void b() {
    if (Build.VERSION.SDK_INT >= 26)
      return; 
    if (!c.a(512))
      return; 
    if (c)
      return; 
    if (d > 5) {
      a.d(b, "bindMainProcess: bind too many times!!! ");
      return;
    } 
    long l = System.currentTimeMillis();
    if (l - e < 15000L) {
      a.d(b, "bindMainProcess: time too short since last bind!!! ");
      return;
    } 
    d++;
    e = l;
    this.f.postDelayed(new Runnable(this) {
          public void run() {
            IndependentProcessDownloadService.a(this.a);
          }
        },  1000L);
  }
  
  private void c() {
    a.b(b, "bindMainProcess: ");
    Intent intent = new Intent((Context)this, DownloadService.class);
    try {
      return;
    } finally {
      intent = null;
      intent.printStackTrace();
    } 
  }
  
  public void onCreate() {
    super.onCreate();
    b.a((Context)this);
    this.a = b.r();
    this.a.a(new WeakReference<IndependentProcessDownloadService>(this));
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\IndependentProcessDownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */