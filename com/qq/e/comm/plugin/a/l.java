package com.qq.e.comm.plugin.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.a.d.b;
import com.qq.e.comm.plugin.a.d.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;

public final class l {
  private static final l a = new l();
  
  private c b;
  
  private boolean c = false;
  
  private s d;
  
  private BroadcastReceiver e;
  
  private ServiceConnection f;
  
  private final k g;
  
  private l() {
    if (MultiProcessFlag.isMultiProcess())
      f(); 
    this.g = new k(GDTADManager.getInstance().getAppContext());
  }
  
  public static l a() {
    return a;
  }
  
  private c c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    List<c> list = d();
    if (list != null) {
      if (list.isEmpty())
        return null; 
      for (c c1 : list) {
        if (c1 != null && paramString.equals(c1.h()))
          return c1; 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Not find task matched name: ");
      stringBuilder.append(paramString);
      GDTLogger.d(stringBuilder.toString());
    } 
    return null;
  }
  
  private void f() {
    this.c = true;
    Context context = GDTADManager.getInstance().getAppContext();
    Intent intent = j.c(context);
    this.f = new a();
    context.bindService(intent, this.f, 1);
    IntentFilter intentFilter = new IntentFilter();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(context.getPackageName());
    stringBuilder.append(".gdtdownload");
    intentFilter.addAction(stringBuilder.toString());
    this.b = new c();
    this.e = new b(this.b);
    context.registerReceiver(this.e, intentFilter);
  }
  
  private void g() {
    this.c = false;
    Context context = GDTADManager.getInstance().getAppContext();
    context.unbindService(this.f);
    context.unregisterReceiver(this.e);
  }
  
  public int a(String paramString) {
    if (this.c) {
      s s1 = this.d;
      if (s1 != null)
        try {
          return s1.a(paramString);
        } catch (RemoteException remoteException) {
          GDTLogger.e("Exception while invoke getStatus in another process", (Throwable)remoteException);
        }  
      return 0;
    } 
    return b.a().a(GDTADManager.getInstance().getAppContext(), (String)remoteException);
  }
  
  public void a(c paramc) {
    Context context = GDTADManager.getInstance().getAppContext();
    context.startService(j.a(context, paramc));
  }
  
  public void a(a parama) {
    if (this.c) {
      this.b.a(parama);
      return;
    } 
    b.a().a(parama);
  }
  
  public void a(String paramString, a parama) {
    if (this.c) {
      this.b.a(paramString, parama);
      return;
    } 
    b.a().a(paramString, parama);
  }
  
  public boolean a(int paramInt) {
    if (this.c) {
      s s1 = this.d;
      if (s1 != null)
        try {
          return s1.a(paramInt);
        } catch (RemoteException remoteException) {
          GDTLogger.e("Exception while invoke resumeTask in another process", (Throwable)remoteException);
        }  
      return false;
    } 
    return this.g.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    if (this.c) {
      s s1 = this.d;
      if (s1 != null)
        try {
          return s1.a(paramInt1, paramInt2);
        } catch (RemoteException remoteException) {
          GDTLogger.e("Exception while invoke pauseTask in another process", (Throwable)remoteException);
        }  
      return false;
    } 
    return this.g.a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong) {
    if (this.c) {
      s s1 = this.d;
      if (s1 != null)
        try {
          return s1.a(paramInt1, paramInt2, paramLong);
        } catch (RemoteException remoteException) {
          GDTLogger.e("Exception while invoke updateProgress in another process", (Throwable)remoteException);
        }  
      return false;
    } 
    return this.g.a(paramInt1, paramInt2, paramLong);
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2) {
    if (this.c) {
      s s1 = this.d;
      if (s1 != null)
        try {
          return s1.a(paramInt1, paramString, paramInt2);
        } catch (RemoteException remoteException) {
          GDTLogger.e("Exception while invoke rmTask in another process", (Throwable)remoteException);
        }  
      return false;
    } 
    return this.g.a(paramInt1, (String)remoteException, paramInt2);
  }
  
  public boolean a(String paramString, int paramInt) {
    c c1 = c(paramString);
    return (c1 == null) ? false : a(c1.m(), paramInt);
  }
  
  public int b(c paramc) {
    if (this.c) {
      s s1 = this.d;
      if (s1 != null)
        try {
          return s1.a(paramc);
        } catch (RemoteException remoteException) {
          GDTLogger.e("Exception while invoke getDownloadingTask in another process", (Throwable)remoteException);
        }  
      return 0;
    } 
    return this.g.a((c)remoteException);
  }
  
  public void b() {
    try {
      return;
    } finally {
      Exception exception = null;
      GDTLogger.w(exception.getMessage(), exception);
    } 
  }
  
  public void b(a parama) {
    if (this.c) {
      this.b.b(parama);
      return;
    } 
    b.a().b(parama);
  }
  
  public void b(String paramString, a parama) {
    if (this.c) {
      this.b.b(paramString, parama);
      return;
    } 
    b.a().b(paramString, parama);
  }
  
  public boolean b(String paramString) {
    c c1 = c(paramString);
    return (c1 == null) ? false : a(c1.m());
  }
  
  public void c() {
    try {
      return;
    } finally {
      Exception exception = null;
      GDTLogger.w(exception.getMessage(), exception);
    } 
  }
  
  public List<c> d() {
    if (this.c) {
      s s1 = this.d;
      if (s1 != null)
        try {
          return s1.a();
        } catch (RemoteException remoteException) {
          GDTLogger.e("Exception while invoke getDownloadingTask in another process", (Throwable)remoteException);
        }  
      return null;
    } 
    return this.g.b();
  }
  
  public List<c> e() {
    if (this.c) {
      s s1 = this.d;
      if (s1 != null)
        try {
          return s1.b();
        } catch (RemoteException remoteException) {
          GDTLogger.e("Exception while invoke getDownloadingTask in another process", (Throwable)remoteException);
        }  
      return null;
    } 
    return this.g.d();
  }
  
  protected void finalize() throws Throwable {
    g();
    super.finalize();
  }
  
  class a implements ServiceConnection {
    private a(l this$0) {}
    
    public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      l.a(this.a, s.a.a(param1IBinder));
    }
    
    public void onServiceDisconnected(ComponentName param1ComponentName) {
      l.a(this.a, (s)null);
    }
  }
  
  static class b extends BroadcastReceiver {
    private final c a;
    
    b(c param1c) {
      this.a = param1c;
    }
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      try {
        String str = param1Intent.getStringExtra("package");
        int i = param1Intent.getIntExtra("status", 0);
        int j = param1Intent.getIntExtra("progress", 0);
        return;
      } finally {
        param1Context = null;
        GDTLogger.w("StatusBroadCastReceiver#onReceive", (Throwable)param1Context);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */