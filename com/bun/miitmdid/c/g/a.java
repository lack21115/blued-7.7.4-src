package com.bun.miitmdid.c.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.zui.deviceidservice.IDeviceidInterface;

public class a {
  private static String e = "OpenDeviceId library";
  
  private static boolean f;
  
  private Context a = null;
  
  private IDeviceidInterface b;
  
  private ServiceConnection c;
  
  private com.bun.miitmdid.c.e.a d;
  
  public a(Context paramContext, com.bun.miitmdid.c.e.a parama) {
    if (paramContext != null) {
      this.a = paramContext;
      this.d = parama;
      this.c = new a(this);
      Intent intent = new Intent();
      intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
      if (this.a.bindService(intent, this.c, 1)) {
        b("bindService Successful!");
        return;
      } 
      b("bindService Failed!");
      com.bun.miitmdid.c.e.a a1 = this.d;
      if (a1 != null) {
        a1.b();
        return;
      } 
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  private void a(String paramString) {
    if (f)
      Log.e(e, paramString); 
  }
  
  private void b(String paramString) {
    if (f)
      Log.i(e, paramString); 
  }
  
  public String a() {
    Context context = this.a;
    if (context != null) {
      String str = context.getPackageName();
      b("liufeng, getAAID package：" + str);
      if (str != null && !str.equals("")) {
        try {
          if (this.b != null)
            return this.b.getAAID(str); 
        } catch (RemoteException remoteException) {
          a("getAAID error, RemoteException!");
        } 
        return null;
      } 
      b("input package is null!");
      return null;
    } 
    b("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public String b() {
    if (this.a != null) {
      try {
        if (this.b != null)
          return this.b.getOAID(); 
      } catch (RemoteException remoteException) {
        a("getOAID error, RemoteException!");
        remoteException.printStackTrace();
      } 
      return null;
    } 
    a("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public String c() {
    if (this.a != null) {
      try {
        if (this.b != null)
          return this.b.getUDID(); 
      } catch (RemoteException remoteException) {
        a("getUDID error, RemoteException!");
        remoteException.printStackTrace();
      } 
      return null;
    } 
    a("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public String d() {
    Context context = this.a;
    if (context != null) {
      String str = context.getPackageName();
      b("liufeng, getVAID package：" + str);
      if (str != null && !str.equals("")) {
        try {
          if (this.b != null)
            return this.b.getVAID(str); 
        } catch (RemoteException remoteException) {
          a("getVAID error, RemoteException!");
          remoteException.printStackTrace();
        } 
        return null;
      } 
      b("input package is null!");
      return null;
    } 
    b("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public boolean e() {
    boolean bool = false;
    try {
      if (this.b != null) {
        b("Device support opendeviceid");
        bool = this.b.a();
      } 
      return bool;
    } catch (RemoteException remoteException) {
      a("isSupport error, RemoteException!");
      return false;
    } 
  }
  
  public void f() {
    try {
      this.a.unbindService(this.c);
      b("unBind Service successful");
    } catch (IllegalArgumentException illegalArgumentException) {
      a("unBind Service exception");
    } 
    this.b = null;
  }
  
  class a implements ServiceConnection {
    a(a this$0) {}
    
    public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Lcom/bun/miitmdid/c/g/a;
      //   6: aload_2
      //   7: invokestatic a : (Landroid/os/IBinder;)Lcom/zui/deviceidservice/IDeviceidInterface;
      //   10: invokestatic a : (Lcom/bun/miitmdid/c/g/a;Lcom/zui/deviceidservice/IDeviceidInterface;)Lcom/zui/deviceidservice/IDeviceidInterface;
      //   13: pop
      //   14: aload_0
      //   15: getfield a : Lcom/bun/miitmdid/c/g/a;
      //   18: invokestatic a : (Lcom/bun/miitmdid/c/g/a;)Lcom/bun/miitmdid/c/e/a;
      //   21: ifnull -> 37
      //   24: aload_0
      //   25: getfield a : Lcom/bun/miitmdid/c/g/a;
      //   28: invokestatic a : (Lcom/bun/miitmdid/c/g/a;)Lcom/bun/miitmdid/c/e/a;
      //   31: iconst_1
      //   32: invokeinterface a : (Z)V
      //   37: aload_0
      //   38: getfield a : Lcom/bun/miitmdid/c/g/a;
      //   41: ldc 'Service onServiceConnected'
      //   43: invokestatic a : (Lcom/bun/miitmdid/c/g/a;Ljava/lang/String;)V
      //   46: aload_0
      //   47: monitorexit
      //   48: return
      //   49: astore_1
      //   50: aload_0
      //   51: monitorexit
      //   52: aload_1
      //   53: athrow
      // Exception table:
      //   from	to	target	type
      //   2	37	49	finally
      //   37	46	49	finally
    }
    
    public void onServiceDisconnected(ComponentName param1ComponentName) {
      a.a(this.a, (IDeviceidInterface)null);
      a.a(this.a, "Service onServiceDisconnected");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */