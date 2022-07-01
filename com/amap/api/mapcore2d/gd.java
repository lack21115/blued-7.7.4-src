package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;
import java.util.ArrayList;

public class gd implements Inner_3dMap_locationManagerBase {
  Context a = null;
  
  ArrayList<Inner_3dMap_locationListener> b = new ArrayList<Inner_3dMap_locationListener>();
  
  Object c = new Object();
  
  Handler d = null;
  
  a e = null;
  
  Handler f = null;
  
  Inner_3dMap_locationOption g = new Inner_3dMap_locationOption();
  
  gh h = null;
  
  Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode i = Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
  
  boolean j = false;
  
  public gd(Context paramContext) {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
      e();
      return;
    } 
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  private Handler a(Looper paramLooper) {
    synchronized (this.c) {
      this.f = new ge(paramLooper, this);
      return this.f;
    } 
  }
  
  private void a(int paramInt) {
    synchronized (this.c) {
      if (this.f != null)
        this.f.removeMessages(paramInt); 
      return;
    } 
  }
  
  private void a(int paramInt, Object paramObject, long paramLong) {
    synchronized (this.c) {
      if (this.f != null) {
        Message message = Message.obtain();
        message.what = paramInt;
        message.obj = paramObject;
        this.f.sendMessageDelayed(message, paramLong);
      } 
      return;
    } 
  }
  
  private void e() {
    try {
      gf gf;
      if (Looper.myLooper() == null) {
        gf = new gf(this.a.getMainLooper(), this);
      } else {
        gf = new gf(this);
      } 
    } finally {
      Exception exception = null;
    } 
    try {
      this.e = new a("locaitonClientActionThread", this);
      this.e.setPriority(5);
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "MapLocationManager", "initActionThreadAndActionHandler");
    } 
  }
  
  private void f() {
    synchronized (this.c) {
      if (this.f != null)
        this.f.removeCallbacksAndMessages(null); 
      this.f = null;
      return;
    } 
  }
  
  final void a() {
    try {
      if (this.j)
        return; 
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "MapLocationManager", "doStartLocation");
    } 
  }
  
  final void a(Inner_3dMap_location paramInner_3dMap_location) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 15
    //   4: aload_1
    //   5: invokestatic a : (Lcom/autonavi/amap/mapcore2d/Inner_3dMap_location;)Z
    //   8: ifeq -> 15
    //   11: aload_1
    //   12: putstatic com/amap/api/mapcore2d/gb.a : Lcom/autonavi/amap/mapcore2d/Inner_3dMap_location;
    //   15: aload_0
    //   16: getfield j : Z
    //   19: ifeq -> 110
    //   22: ldc 'gps'
    //   24: aload_1
    //   25: invokevirtual getProvider : ()Ljava/lang/String;
    //   28: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   31: ifne -> 40
    //   34: aload_1
    //   35: ldc 'lbs'
    //   37: invokevirtual setProvider : (Ljava/lang/String;)V
    //   40: aload_1
    //   41: aload_1
    //   42: invokevirtual getAltitude : ()D
    //   45: invokestatic b : (D)D
    //   48: invokevirtual setAltitude : (D)V
    //   51: aload_1
    //   52: aload_1
    //   53: invokevirtual getBearing : ()F
    //   56: invokestatic a : (F)F
    //   59: invokevirtual setBearing : (F)V
    //   62: aload_1
    //   63: aload_1
    //   64: invokevirtual getSpeed : ()F
    //   67: invokestatic a : (F)F
    //   70: invokevirtual setSpeed : (F)V
    //   73: aload_0
    //   74: getfield b : Ljava/util/ArrayList;
    //   77: invokevirtual iterator : ()Ljava/util/Iterator;
    //   80: astore_2
    //   81: aload_2
    //   82: invokeinterface hasNext : ()Z
    //   87: ifeq -> 110
    //   90: aload_2
    //   91: invokeinterface next : ()Ljava/lang/Object;
    //   96: checkcast com/autonavi/amap/mapcore2d/Inner_3dMap_locationListener
    //   99: astore_3
    //   100: aload_3
    //   101: aload_1
    //   102: invokeinterface onLocationChanged : (Lcom/autonavi/amap/mapcore2d/Inner_3dMap_location;)V
    //   107: goto -> 81
    //   110: aload_0
    //   111: getfield g : Lcom/autonavi/amap/mapcore2d/Inner_3dMap_locationOption;
    //   114: invokevirtual isOnceLocation : ()Z
    //   117: ifeq -> 124
    //   120: aload_0
    //   121: invokevirtual c : ()V
    //   124: return
    //   125: astore_1
    //   126: aload_1
    //   127: ldc 'MapLocationManager'
    //   129: ldc 'callBackLocation'
    //   131: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   134: return
    //   135: astore_3
    //   136: goto -> 81
    // Exception table:
    //   from	to	target	type
    //   4	15	125	finally
    //   15	40	125	finally
    //   40	81	125	finally
    //   81	100	125	finally
    //   100	107	135	finally
    //   110	124	125	finally
  }
  
  final void a(Inner_3dMap_locationListener paramInner_3dMap_locationListener) {
    if (paramInner_3dMap_locationListener != null)
      try {
        return;
      } finally {
        paramInner_3dMap_locationListener = null;
        gu.a((Throwable)paramInner_3dMap_locationListener, "MapLocationManager", "doSetLocationListener");
      }  
    throw new IllegalArgumentException("listener参数不能为null");
  }
  
  final void a(Inner_3dMap_locationOption paramInner_3dMap_locationOption) {
    this.g = paramInner_3dMap_locationOption;
    if (this.g == null)
      this.g = new Inner_3dMap_locationOption(); 
    gh gh1 = this.h;
    if (gh1 != null)
      gh1.a(this.g); 
    if (this.j && !this.i.equals(paramInner_3dMap_locationOption.getLocationMode())) {
      c();
      a();
    } 
    this.i = this.g.getLocationMode();
  }
  
  final void b() {
    long l = 1000L;
    try {
      if (this.h != null)
        this.h.a(); 
    } finally {
      null = null;
    } 
  }
  
  final void b(Inner_3dMap_locationListener paramInner_3dMap_locationListener) {
    if (paramInner_3dMap_locationListener != null)
      try {
        return;
      } finally {
        paramInner_3dMap_locationListener = null;
        gu.a((Throwable)paramInner_3dMap_locationListener, "MapLocationManager", "doUnregisterListener");
      }  
    if (this.b.isEmpty())
      c(); 
  }
  
  final void c() {
    try {
      this.j = false;
      a(1004);
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "MapLocationManager", "doStopLocation");
    } 
  }
  
  final void d() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual c : ()V
    //   4: aload_0
    //   5: getfield h : Lcom/amap/api/mapcore2d/gh;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull -> 17
    //   13: aload_1
    //   14: invokevirtual d : ()V
    //   17: aload_0
    //   18: getfield b : Ljava/util/ArrayList;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull -> 35
    //   26: aload_1
    //   27: invokevirtual clear : ()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield b : Ljava/util/ArrayList;
    //   35: aload_0
    //   36: invokespecial f : ()V
    //   39: aload_0
    //   40: getfield e : Lcom/amap/api/mapcore2d/gd$a;
    //   43: ifnull -> 83
    //   46: getstatic android/os/Build$VERSION.SDK_INT : I
    //   49: bipush #18
    //   51: if_icmplt -> 75
    //   54: aload_0
    //   55: getfield e : Lcom/amap/api/mapcore2d/gd$a;
    //   58: ldc_w android/os/HandlerThread
    //   61: ldc_w 'quitSafely'
    //   64: iconst_0
    //   65: anewarray java/lang/Object
    //   68: invokestatic a : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: goto -> 83
    //   75: aload_0
    //   76: getfield e : Lcom/amap/api/mapcore2d/gd$a;
    //   79: invokevirtual quit : ()Z
    //   82: pop
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield e : Lcom/amap/api/mapcore2d/gd$a;
    //   88: aload_0
    //   89: getfield d : Landroid/os/Handler;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -> 107
    //   97: aload_1
    //   98: aconst_null
    //   99: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   102: aload_0
    //   103: aconst_null
    //   104: putfield d : Landroid/os/Handler;
    //   107: return
    //   108: astore_1
    //   109: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   54	72	108	finally
  }
  
  public void destroy() {
    try {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "MapLocationManager", "stopLocation");
    } 
  }
  
  public Inner_3dMap_location getLastKnownLocation() {
    return gb.a;
  }
  
  public void setLocationListener(Inner_3dMap_locationListener paramInner_3dMap_locationListener) {
    try {
      return;
    } finally {
      paramInner_3dMap_locationListener = null;
      gu.a((Throwable)paramInner_3dMap_locationListener, "MapLocationManager", "setLocationListener");
    } 
  }
  
  public void setLocationOption(Inner_3dMap_locationOption paramInner_3dMap_locationOption) {
    try {
      return;
    } finally {
      paramInner_3dMap_locationOption = null;
      gu.a((Throwable)paramInner_3dMap_locationOption, "LocationClientManager", "setLocationOption");
    } 
  }
  
  public void startLocation() {
    try {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "MapLocationManager", "startLocation");
    } 
  }
  
  public void stopLocation() {
    try {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "MapLocationManager", "stopLocation");
    } 
  }
  
  public void unRegisterLocationListener(Inner_3dMap_locationListener paramInner_3dMap_locationListener) {
    try {
      return;
    } finally {
      paramInner_3dMap_locationListener = null;
      gu.a((Throwable)paramInner_3dMap_locationListener, "MapLocationManager", "stopLocation");
    } 
  }
  
  static final class a extends HandlerThread {
    gd a;
    
    public a(String param1String, gd param1gd) {
      super(param1String);
      this.a = param1gd;
    }
    
    protected final void onLooperPrepared() {
      try {
        this.a.h = new gh(this.a.a, this.a.d);
        return;
      } finally {
        Exception exception = null;
      } 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */