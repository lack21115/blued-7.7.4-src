package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.g.d;
import java.lang.ref.WeakReference;

public interface p<T extends DownloadService> {
  IBinder a(Intent paramIntent);
  
  void a(int paramInt);
  
  void a(int paramInt, Notification paramNotification);
  
  void a(Intent paramIntent, int paramInt1, int paramInt2);
  
  void a(o paramo);
  
  void a(WeakReference<T> paramWeakReference);
  
  void a(boolean paramBoolean);
  
  boolean a();
  
  void b(d paramd);
  
  boolean b();
  
  void c();
  
  void c(d paramd);
  
  void d();
  
  void f();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */