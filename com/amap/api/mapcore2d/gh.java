package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;
import org.json.JSONArray;

public final class gh {
  private static int m = 200;
  
  private static boolean n = true;
  
  Context a = null;
  
  ga b = null;
  
  gi c = null;
  
  b d = null;
  
  Handler e = null;
  
  Handler f = null;
  
  boolean g = false;
  
  boolean h = false;
  
  Inner_3dMap_locationOption i = null;
  
  final int j = 500;
  
  final int k = 30;
  
  Object l = new Object();
  
  private JSONArray o = null;
  
  public gh(Context paramContext, Handler paramHandler) {
    if (paramContext != null)
      try {
        this.a = paramContext.getApplicationContext();
        this.f = paramHandler;
        this.i = new Inner_3dMap_locationOption();
        return;
      } finally {
        paramContext = null;
        gu.a((Throwable)paramContext, "LocationService", "<init>");
      }  
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  private void a(Inner_3dMap_location paramInner_3dMap_location) {
    try {
      if (!n)
        return; 
    } finally {
      paramInner_3dMap_location = null;
      gu.a((Throwable)paramInner_3dMap_location, "LocationService", "recordOfflineLocLog");
    } 
  }
  
  private void e() {
    this.d = new b("locServiceAction");
    this.d.setPriority(5);
    this.d.start();
    this.e = new a(this, this.d.getLooper());
  }
  
  private void f() {
    try {
      if (this.i == null)
        this.i = new Inner_3dMap_locationOption(); 
      if (this.h)
        return; 
      this.b = new ga(this.a);
      this.c = new gi(this.a);
      this.c.a(this.i);
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "LocationService", "init");
    } 
  }
  
  private void g() {
    try {
      n = gx.b(this.a, "maploc", "ue");
      int i = gx.a(this.a, "maploc", "opn");
      m = i;
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "LocationService", "getSPConfig");
    } 
  }
  
  private void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield o : Lorg/json/JSONArray;
    //   6: ifnull -> 54
    //   9: aload_0
    //   10: getfield o : Lorg/json/JSONArray;
    //   13: invokevirtual length : ()I
    //   16: ifle -> 54
    //   19: invokestatic b : ()Lcom/amap/api/mapcore2d/da;
    //   22: astore_1
    //   23: new com/amap/api/mapcore2d/fd
    //   26: dup
    //   27: aload_0
    //   28: getfield a : Landroid/content/Context;
    //   31: aload_1
    //   32: aload_0
    //   33: getfield o : Lorg/json/JSONArray;
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/mapcore2d/da;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield a : Landroid/content/Context;
    //   46: invokestatic a : (Lcom/amap/api/mapcore2d/fd;Landroid/content/Context;)V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield o : Lorg/json/JSONArray;
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: ldc 'LocationService'
    //   61: ldc 'writeOfflineLog'
    //   63: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   2	54	57	finally
    //   58	66	69	finally
  }
  
  private void i() {
    synchronized (this.l) {
      if (this.e != null)
        this.e.removeCallbacksAndMessages(null); 
      this.e = null;
      return;
    } 
  }
  
  private void j() {
    synchronized (this.l) {
      if (this.e != null)
        this.e.removeMessages(1); 
      return;
    } 
  }
  
  public final void a() {
    try {
      f();
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "LocationService", "getLocation");
    } 
  }
  
  public final void a(Inner_3dMap_locationOption paramInner_3dMap_locationOption) {
    this.i = paramInner_3dMap_locationOption;
    if (this.i == null)
      this.i = new Inner_3dMap_locationOption(); 
    gi gi1 = this.c;
    if (gi1 != null)
      gi1.a(paramInner_3dMap_locationOption); 
  }
  
  final void b() {
    Inner_3dMap_location inner_3dMap_location = null;
    try {
      if (this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && this.g) {
        this.b.b();
        this.g = false;
      } 
      if (this.b.c()) {
        inner_3dMap_location = this.b.d();
      } else if (!this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors)) {
        inner_3dMap_location = this.c.a();
      } 
      return;
    } finally {
      inner_3dMap_location = null;
      gu.a((Throwable)inner_3dMap_location, "LocationService", "doGetLocation");
    } 
  }
  
  public final void c() {
    this.g = false;
    try {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "LocationService", "stopLocation");
    } 
  }
  
  public final void d() {
    try {
      c();
      i();
      if (this.d != null) {
        b b1;
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
          try {
            gw.a(this.d, HandlerThread.class, "quitSafely", new Object[0]);
            this.d = null;
            this.c.b();
            return;
          } finally {
            Exception exception = null;
          } 
        } else {
          b1 = this.d;
        } 
        b1.quit();
      } 
      this.d = null;
      this.c.b();
      this.g = false;
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "LocationService", "destroy");
    } 
  }
  
  public final class a extends Handler {
    public a(gh this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      if (param1Message.what != 1)
        return; 
      this.a.b();
    }
  }
  
  static final class b extends HandlerThread {
    public b(String param1String) {
      super(param1String);
    }
    
    protected final void onLooperPrepared() {
      super.onLooperPrepared();
    }
    
    public final void run() {
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */