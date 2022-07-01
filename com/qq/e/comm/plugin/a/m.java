package com.qq.e.comm.plugin.a;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.plugin.a.d.b;
import com.qq.e.comm.plugin.a.d.d;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class m implements SVSD, r.a {
  private static final ArrayList<String> e = new ArrayList<String>();
  
  private static final HashMap<String, ReentrantLock> f = new HashMap<String, ReentrantLock>();
  
  private final Service a;
  
  private r b;
  
  private final Context c;
  
  private final ConcurrentHashMap<String, Intent> d = new ConcurrentHashMap<String, Intent>();
  
  private boolean g;
  
  private boolean h;
  
  private final k i;
  
  public m(Service paramService) {
    this.a = paramService;
    this.c = paramService.getApplicationContext();
    this.i = new k(this.c);
  }
  
  private ReentrantLock a(String paramString) {
    if (f.containsKey(paramString))
      return f.get(paramString); 
    ReentrantLock reentrantLock = new ReentrantLock();
    f.put(paramString, reentrantLock);
    return reentrantLock;
  }
  
  private void a(Intent paramIntent) {
    if (!this.h && j.c(paramIntent)) {
      this.i.a();
      this.h = true;
    } 
  }
  
  private void a(c paramc, int paramInt, Intent paramIntent) {
    ReentrantLock reentrantLock = a(paramc.h());
    if (reentrantLock.isLocked()) {
      GDTLogger.d("there is already a download worker running");
      return;
    } 
    e.add(paramc.h());
    (new q(this, new o(this.c, paramc, paramIntent, reentrantLock), new p(this.c, paramc), paramc, paramc, paramIntent, paramInt) {
        public void a(int param1Int, String param1String) {
          if (param1Int == 11)
            m.a(this.d).put(this.a.g(), this.b); 
          if (m.a(this.d).isEmpty() && m.b(this.d))
            this.d.a(this.c); 
        }
      }).b();
  }
  
  private void b(Intent paramIntent) {
    if (!this.g && j.b(paramIntent)) {
      for (c c : this.i.c()) {
        if (!e.contains(c.h()))
          this.i.a(c.m(), 0); 
      } 
      this.g = true;
    } 
  }
  
  private boolean c() {
    List<c> list = this.i.e();
    boolean bool = true;
    try {
      Iterator<c> iterator = list.iterator();
      return bool1;
    } finally {
      list = null;
    } 
  }
  
  private void d() {
    if (this.b == null) {
      this.b = new r(this);
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.c.registerReceiver(this.b, intentFilter);
      GDTLogger.d("注册网络状态广播接收器");
    } 
  }
  
  private void e() {
    r r1 = this.b;
    if (r1 != null) {
      this.c.unregisterReceiver(r1);
      this.b = null;
      GDTLogger.d("取消网络状态广播接收器");
    } 
  }
  
  private void f() {
    g();
    this.i.a();
  }
  
  private void g() {
    if (!this.d.isEmpty())
      try {
        return;
      } finally {
        Exception exception = null;
        String str = exception.toString();
        GDTLogger.e(str);
        d d = new d();
        d.a("msg", str);
      }  
  }
  
  public void a() {
    t.a.submit(new Runnable(this) {
          public void run() {
            m.e(this.a);
          }
        });
  }
  
  void a(int paramInt) {
    this.a.stopSelf(paramInt);
  }
  
  public void b() {}
  
  public IBinder onBind(Intent paramIntent) {
    GDTLogger.d("OnBind ");
    return (IBinder)new a();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onDestroy() {
    f.clear();
    e();
  }
  
  public void onLowMemory() {}
  
  public void onRebind(Intent paramIntent) {}
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    if (paramIntent == null)
      return 2; 
    a(paramIntent);
    b(paramIntent);
    c c = c.a(j.a(paramIntent));
    if (c != null && !d.b(b.a().a(this.c, c.h()))) {
      d();
      boolean bool = j.d(paramIntent);
      if (bool) {
        c.d(2);
      } else {
        c.e(2);
      } 
      if (bool && !this.d.isEmpty())
        this.d.remove(c.g()); 
      a(c, paramInt2, paramIntent);
    } 
    return 2;
  }
  
  public void onTaskRemoved(Intent paramIntent) {}
  
  public void onTrimMemory(int paramInt) {}
  
  public boolean onUnbind(Intent paramIntent) {
    return true;
  }
  
  class a extends s.a {
    private a(m this$0) {}
    
    public int a(c param1c) throws RemoteException {
      return m.d(this.a).a(param1c);
    }
    
    public int a(String param1String) throws RemoteException {
      return b.a().a(m.c(this.a), param1String);
    }
    
    public List<c> a() throws RemoteException {
      return m.d(this.a).b();
    }
    
    public boolean a(int param1Int) throws RemoteException {
      return m.d(this.a).a(param1Int);
    }
    
    public boolean a(int param1Int1, int param1Int2) throws RemoteException {
      return m.d(this.a).a(param1Int1, param1Int2);
    }
    
    public boolean a(int param1Int1, int param1Int2, long param1Long) throws RemoteException {
      return m.d(this.a).a(param1Int1, param1Int2, param1Long);
    }
    
    public boolean a(int param1Int1, String param1String, int param1Int2) throws RemoteException {
      return m.d(this.a).a(param1Int1, param1String, param1Int2);
    }
    
    public List<c> b() throws RemoteException {
      return m.d(this.a).d();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */