package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.m.c;
import java.lang.ref.WeakReference;

public abstract class a implements p {
  private static final String e = a.class.getSimpleName();
  
  protected final SparseArray<d> a = new SparseArray();
  
  protected volatile boolean b = false;
  
  protected volatile boolean c;
  
  protected volatile boolean d = false;
  
  private WeakReference<Service> f;
  
  private Handler g = new Handler(Looper.getMainLooper());
  
  private Runnable h = new Runnable(this) {
      public void run() {
        if (com.ss.android.socialbase.downloader.f.a.a())
          com.ss.android.socialbase.downloader.f.a.b(a.g(), "tryDownload: 2 try"); 
        if (!this.a.b) {
          if (com.ss.android.socialbase.downloader.f.a.a())
            com.ss.android.socialbase.downloader.f.a.b(a.g(), "tryDownload: 2 error"); 
          this.a.a(b.B(), (ServiceConnection)null);
        } 
      }
    };
  
  public IBinder a(Intent paramIntent) {
    com.ss.android.socialbase.downloader.f.a.b(e, "onBind Abs");
    return (IBinder)new Binder();
  }
  
  public void a(int paramInt) {
    com.ss.android.socialbase.downloader.f.a.a(paramInt);
  }
  
  public void a(int paramInt, Notification paramNotification) {
    WeakReference<Service> weakReference = this.f;
    if (weakReference != null && weakReference.get() != null) {
      String str = e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("startForeground  id = ");
      stringBuilder.append(paramInt);
      stringBuilder.append(", service = ");
      stringBuilder.append(this.f.get());
      stringBuilder.append(",  isServiceAlive = ");
      stringBuilder.append(this.b);
      com.ss.android.socialbase.downloader.f.a.c(str, stringBuilder.toString());
      try {
        ((Service)this.f.get()).startForeground(paramInt, paramNotification);
        this.c = true;
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      } 
    } 
    com.ss.android.socialbase.downloader.f.a.d(e, "startForeground: downloadService is null, do nothing!");
  }
  
  protected void a(Context paramContext, ServiceConnection paramServiceConnection) {}
  
  public void a(Intent paramIntent, int paramInt1, int paramInt2) {}
  
  public void a(o paramo) {}
  
  public void a(d paramd) {
    if (paramd == null)
      return; 
    String str2 = e;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("pendDownloadTask pendingTasks.size:");
    stringBuilder2.append(this.a.size());
    stringBuilder2.append(" downloadTask.getDownloadId():");
    stringBuilder2.append(paramd.o());
    com.ss.android.socialbase.downloader.f.a.b(str2, stringBuilder2.toString());
    if (this.a.get(paramd.o()) == null)
      synchronized (this.a) {
        if (this.a.get(paramd.o()) == null)
          this.a.put(paramd.o(), paramd); 
      }  
    String str1 = e;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("after pendDownloadTask pendingTasks.size:");
    stringBuilder1.append(this.a.size());
    com.ss.android.socialbase.downloader.f.a.b(str1, stringBuilder1.toString());
  }
  
  public void a(WeakReference<Service> paramWeakReference) {
    this.f = paramWeakReference;
  }
  
  public void a(boolean paramBoolean) {
    WeakReference<Service> weakReference = this.f;
    if (weakReference != null && weakReference.get() != null) {
      String str = e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stopForeground  service = ");
      stringBuilder.append(this.f.get());
      stringBuilder.append(",  isServiceAlive = ");
      stringBuilder.append(this.b);
      com.ss.android.socialbase.downloader.f.a.c(str, stringBuilder.toString());
      try {
        this.c = false;
        ((Service)this.f.get()).stopForeground(paramBoolean);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  public boolean a() {
    return this.b;
  }
  
  public void b(d paramd) {
    if (paramd == null)
      return; 
    if (!this.b) {
      if (com.ss.android.socialbase.downloader.f.a.a())
        com.ss.android.socialbase.downloader.f.a.b(e, "tryDownload but service is not alive"); 
      if (c.a(262144))
        synchronized (this.a) {
          a(paramd);
          if (!this.d) {
            if (com.ss.android.socialbase.downloader.f.a.a())
              com.ss.android.socialbase.downloader.f.a.b(e, "tryDownload: 1"); 
            a(b.B(), (ServiceConnection)null);
            this.d = true;
          } else {
            this.g.removeCallbacks(this.h);
            this.g.postDelayed(this.h, 10L);
          } 
          return;
        }  
      a(paramd);
      a(b.B(), (ServiceConnection)null);
      return;
    } 
    if (this.a.get(paramd.o()) != null)
      synchronized (this.a) {
        if (this.a.get(paramd.o()) != null)
          this.a.remove(paramd.o()); 
      }  
    com.ss.android.socialbase.downloader.impls.a a1 = b.t();
    if (a1 != null)
      a1.a(paramd); 
    e();
  }
  
  public boolean b() {
    String str = e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isServiceForeground = ");
    stringBuilder.append(this.c);
    com.ss.android.socialbase.downloader.f.a.c(str, stringBuilder.toString());
    return this.c;
  }
  
  public void c() {}
  
  public void c(d paramd) {}
  
  public void d() {
    this.b = false;
  }
  
  protected void e() {
    SparseArray<d> sparseArray;
    com.ss.android.socialbase.downloader.impls.a a1;
    null = e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resumePendingTask pendingTasks.size:");
    stringBuilder.append(this.a.size());
    com.ss.android.socialbase.downloader.f.a.b(null, stringBuilder.toString());
    synchronized (this.a) {
      SparseArray sparseArray1 = this.a.clone();
      this.a.clear();
      a1 = b.t();
      if (a1 != null)
        for (int i = 0; i < sparseArray1.size(); i++) {
          d d = (d)sparseArray1.get(sparseArray1.keyAt(i));
          if (d != null)
            a1.a(d); 
        }  
      return;
    } 
  }
  
  public void f() {
    if (!this.b) {
      if (com.ss.android.socialbase.downloader.f.a.a())
        com.ss.android.socialbase.downloader.f.a.b(e, "startService"); 
      a(b.B(), (ServiceConnection)null);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */