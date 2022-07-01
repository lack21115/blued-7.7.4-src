package com.bun.miitmdid.c.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
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
      if (a1 != null)
        a1.b(); 
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  private native void a(String paramString);
  
  private native void b(String paramString);
  
  public native String a();
  
  public native String b();
  
  public native String c();
  
  public native String d();
  
  public native boolean e();
  
  public native void f();
  
  class a implements ServiceConnection {
    a(a this$0) {}
    
    public synchronized native void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
    
    public native void onServiceDisconnected(ComponentName param1ComponentName);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\c\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */