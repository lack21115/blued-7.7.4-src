package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.a;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.downloader.o;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.c;
import com.ss.android.socialbase.downloader.m.f;
import com.ss.android.socialbase.downloader.m.g;
import java.util.ArrayList;
import java.util.List;

public class n extends a implements ServiceConnection {
  private static final String e = n.class.getSimpleName();
  
  private static int i = 0;
  
  private static long j = 0L;
  
  private j f;
  
  private o g;
  
  private int h = -1;
  
  private Handler k = new Handler(Looper.getMainLooper());
  
  private boolean l;
  
  private ServiceConnection m;
  
  private void l() {
    a.b(e, "resumeDownloaderProcessTaskForDied: ");
    if (b.B() == null)
      return; 
    m m = b.o();
    if (m == null)
      return; 
    com.ss.android.socialbase.downloader.downloader.n n1 = l.a(true);
    if (n1 != null) {
      List list = n1.d("application/vnd.android.package-archive");
      if (list != null && !list.isEmpty()) {
        ArrayList<c> arrayList = new ArrayList();
        for (c c : list) {
          if (c != null && c.T() && c.w() == -5)
            arrayList.add(c); 
        } 
        if (!arrayList.isEmpty()) {
          String str = e;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("resumeDownloaderProcessTaskForDied: resume size =");
          stringBuilder.append(arrayList.size());
          a.b(str, stringBuilder.toString());
          m.a(arrayList);
        } 
      } 
    } 
  }
  
  public IBinder a(Intent paramIntent) {
    if (paramIntent != null && paramIntent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
      Log.w(e, "downloader process sync database on main process!");
      a.a("fix_sigbus_downloader_db", true);
    } 
    a.b(e, "onBind IndependentDownloadBinder");
    return (IBinder)new m();
  }
  
  public void a(int paramInt) {
    j j1 = this.f;
    if (j1 == null) {
      this.h = paramInt;
      a(b.B(), this);
      return;
    } 
    try {
      j1.l(paramInt);
      return;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return;
    } 
  }
  
  public void a(Context paramContext, ServiceConnection paramServiceConnection) {
    try {
      a.b(e, "bindService");
      Intent intent = new Intent(paramContext, IndependentProcessDownloadService.class);
      if (f.a())
        intent.putExtra("fix_downloader_db_sigbus", a.b().a("fix_sigbus_downloader_db")); 
      if (paramServiceConnection != null)
        paramContext.bindService(intent, paramServiceConnection, 1); 
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public void a(o paramo) {
    this.g = paramo;
  }
  
  public void b(d paramd) {
    boolean bool;
    if (paramd == null)
      return; 
    String str = e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tryDownload aidlService == null:");
    j j1 = this.f;
    int i = 0;
    if (j1 == null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    a.b(str, stringBuilder.toString());
    if (this.f == null) {
      a(paramd);
      a(b.B(), this);
      return;
    } 
    if (this.a.get(paramd.o()) != null)
      synchronized (this.a) {
        if (this.a.get(paramd.o()) != null)
          this.a.remove(paramd.o()); 
      }  
    try {
      this.f.a(g.a(paramd));
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    synchronized (this.a) {
      SparseArray sparseArray = this.a.clone();
      this.a.clear();
      if (b.t() != null)
        while (true) {
          if (i < sparseArray.size()) {
            d d1 = (d)sparseArray.get(sparseArray.keyAt(i));
            if (d1 != null)
              try {
                this.f.a(g.a(paramd));
              } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
              }  
            continue;
          } 
          return;
          i++;
        }  
      return;
    } 
  }
  
  public void c(d paramd) {
    if (paramd == null)
      return; 
    c.a().a(paramd.o(), true);
    a a1 = b.t();
    if (a1 != null)
      a1.a(paramd); 
  }
  
  public void f() {
    if (this.f == null)
      a(b.B(), this); 
  }
  
  public void onBindingDied(ComponentName paramComponentName) {
    this.f = null;
    o o1 = this.g;
    if (o1 != null)
      o1.h(); 
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    boolean bool;
    a.b(e, "onServiceConnected ");
    this.f = j.a.a(paramIBinder);
    b.B();
    int k = Build.VERSION.SDK_INT;
    int i = 0;
    if (k < 26 && c.a(512) && f.a()) {
      try {
        paramIBinder.linkToDeath(new IBinder.DeathRecipient(this) {
              public void binderDied() {
                String str = n.h();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("binderDied: mServiceConnection = ");
                stringBuilder.append(n.a(this.a));
                a.d(str, stringBuilder.toString());
                if (n.i() < 5 && System.currentTimeMillis() - n.j() > 15000L) {
                  n.b(this.a).postDelayed(new Runnable(this) {
                        public void run() {
                          a.b(n.h(), "run: restart downloader process !!");
                          n.a(this.a.a, true);
                          try {
                            return;
                          } finally {
                            Exception exception = null;
                            exception.printStackTrace();
                          } 
                        }
                      }1000L);
                  n.k();
                  n.a(System.currentTimeMillis());
                } 
              }
            }0);
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      } 
      if (this.l) {
        this.k.postDelayed(new Runnable(this) {
              public void run() {
                b.k().execute(new Runnable(this) {
                      public void run() {
                        try {
                          n.c(this.a.a);
                          return;
                        } catch (Exception exception) {
                          exception.printStackTrace();
                          return;
                        } 
                      }
                    },  );
              }
            },  1000L);
        this.l = false;
      } 
    } 
    o o1 = this.g;
    if (o1 != null)
      o1.a(paramIBinder); 
    String str = e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onServiceConnected aidlService!=null");
    if (this.f != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    stringBuilder.append(" pendingTasks.size:");
    stringBuilder.append(this.a.size());
    a.b(str, stringBuilder.toString());
    if (this.f != null) {
      c.a().b();
      this.b = true;
      this.d = false;
      k = this.h;
      if (k != -1)
        try {
          this.f.l(k);
        } catch (RemoteException remoteException) {
          remoteException.printStackTrace();
        }  
      synchronized (this.a) {
        if (this.f != null) {
          SparseArray sparseArray = this.a.clone();
          this.a.clear();
          while (true) {
            if (i < sparseArray.size()) {
              d d = (d)sparseArray.get(sparseArray.keyAt(i));
              if (d != null)
                try {
                  this.f.a(g.a(d));
                } catch (RemoteException remoteException) {
                  remoteException.printStackTrace();
                }  
              continue;
            } 
            return;
            i++;
          } 
        } 
        return;
      } 
    } 
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    a.b(e, "onServiceDisconnected ");
    this.f = null;
    this.b = false;
    o o1 = this.g;
    if (o1 != null)
      o1.h(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */