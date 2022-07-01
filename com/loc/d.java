package com.loc;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import java.util.ArrayList;

public final class d {
  private static boolean D = true;
  
  private static boolean F = false;
  
  public static volatile boolean f = false;
  
  private Context A;
  
  private boolean B = false;
  
  private volatile boolean C = false;
  
  private boolean E = true;
  
  private h G = null;
  
  private ServiceConnection H = new ServiceConnection(this) {
      public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        try {
          this.a.i = new Messenger(param1IBinder);
          return;
        } finally {
          param1ComponentName = null;
          ej.a((Throwable)param1ComponentName, "ALManager", "onServiceConnected");
        } 
      }
      
      public final void onServiceDisconnected(ComponentName param1ComponentName) {
        d d1 = this.a;
        d1.i = null;
        d.a(d1, false);
      }
    };
  
  private volatile boolean I = false;
  
  AMapLocationClientOption a = new AMapLocationClientOption();
  
  public c b;
  
  g c = null;
  
  ArrayList<AMapLocationListener> d = new ArrayList<AMapLocationListener>();
  
  boolean e = false;
  
  public boolean g = true;
  
  i h;
  
  Messenger i = null;
  
  Messenger j = null;
  
  Intent k = null;
  
  int l = 0;
  
  b m = null;
  
  boolean n = false;
  
  AMapLocationClientOption.AMapLocationMode o = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
  
  Object p = new Object();
  
  en q = null;
  
  boolean r = false;
  
  e s = null;
  
  String t = null;
  
  AMapLocationQualityReport u = null;
  
  boolean v = false;
  
  boolean w = false;
  
  a x = null;
  
  String y = null;
  
  boolean z = false;
  
  public d(Context paramContext, Intent paramIntent, Looper paramLooper) {
    this.A = paramContext;
    this.k = paramIntent;
    if (paramLooper == null) {
      try {
        c c1;
        if (Looper.myLooper() == null) {
          c1 = new c(this, this.A.getMainLooper());
        } else {
          c1 = new c(this);
        } 
      } finally {
        paramContext = null;
      } 
    } else {
      c c1 = new c(this, paramLooper);
      this.b = c1;
    } 
    try {
      this.h = new i(this.A);
    } finally {
      paramContext = null;
    } 
    this.m.setPriority(5);
    this.m.start();
    this.x = a(this.m.getLooper());
  }
  
  private a a(Looper paramLooper) {
    synchronized (this.p) {
      this.x = new a(this, paramLooper);
      return this.x;
    } 
  }
  
  private ds a(dn paramdn) {
    if (this.a.isLocationCacheEnable())
      try {
        return paramdn.f();
      } finally {
        paramdn = null;
      }  
    return null;
  }
  
  private void a(int paramInt) {
    synchronized (this.p) {
      if (this.x != null)
        this.x.removeMessages(paramInt); 
      return;
    } 
  }
  
  private void a(int paramInt, Bundle paramBundle) {
    // Byte code:
    //   0: aload_2
    //   1: astore_3
    //   2: aload_2
    //   3: ifnonnull -> 14
    //   6: new android/os/Bundle
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield t : Ljava/lang/String;
    //   18: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   21: ifeq -> 35
    //   24: aload_0
    //   25: aload_0
    //   26: getfield A : Landroid/content/Context;
    //   29: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   32: putfield t : Ljava/lang/String;
    //   35: aload_3
    //   36: ldc 'c'
    //   38: aload_0
    //   39: getfield t : Ljava/lang/String;
    //   42: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   45: invokestatic obtain : ()Landroid/os/Message;
    //   48: astore_2
    //   49: aload_2
    //   50: iload_1
    //   51: putfield what : I
    //   54: aload_2
    //   55: aload_3
    //   56: invokevirtual setData : (Landroid/os/Bundle;)V
    //   59: aload_2
    //   60: aload_0
    //   61: getfield j : Landroid/os/Messenger;
    //   64: putfield replyTo : Landroid/os/Messenger;
    //   67: aload_0
    //   68: getfield i : Landroid/os/Messenger;
    //   71: ifnull -> 82
    //   74: aload_0
    //   75: getfield i : Landroid/os/Messenger;
    //   78: aload_2
    //   79: invokevirtual send : (Landroid/os/Message;)V
    //   82: return
    //   83: astore_2
    //   84: aload_2
    //   85: instanceof java/lang/IllegalStateException
    //   88: ifeq -> 109
    //   91: aload_2
    //   92: invokevirtual getMessage : ()Ljava/lang/String;
    //   95: ldc_w 'sending message to a Handler on a dead thread'
    //   98: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   101: ifeq -> 109
    //   104: iconst_1
    //   105: istore_1
    //   106: goto -> 111
    //   109: iconst_0
    //   110: istore_1
    //   111: aload_2
    //   112: instanceof android/os/RemoteException
    //   115: ifne -> 122
    //   118: iload_1
    //   119: ifeq -> 132
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield i : Landroid/os/Messenger;
    //   127: aload_0
    //   128: iconst_0
    //   129: putfield B : Z
    //   132: aload_2
    //   133: ldc 'ALManager'
    //   135: ldc_w 'sendLocMessage'
    //   138: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   141: return
    // Exception table:
    //   from	to	target	type
    //   6	14	83	finally
    //   14	35	83	finally
    //   35	82	83	finally
  }
  
  private void a(int paramInt, Object paramObject, long paramLong) {
    synchronized (this.p) {
      if (this.x != null) {
        Message message = Message.obtain();
        message.what = paramInt;
        if (paramObject instanceof Bundle) {
          message.setData((Bundle)paramObject);
        } else {
          message.obj = paramObject;
        } 
        this.x.sendMessageDelayed(message, paramLong);
      } 
      return;
    } 
  }
  
  private void a(Intent paramIntent, boolean paramBoolean) {
    if (this.A != null) {
      if (Build.VERSION.SDK_INT >= 26 && paramBoolean) {
        if (!o()) {
          Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
          return;
        } 
        try {
          this.A.getClass().getMethod("startForegroundService", new Class[] { Intent.class }).invoke(this.A, new Object[] { paramIntent });
          this.z = true;
          return;
        } finally {
          Exception exception;
        } 
      } 
      this.A.startService(paramIntent);
    } else {
      return;
    } 
    this.z = true;
  }
  
  private void a(Bundle paramBundle) {
    Bundle bundle;
    dm dm2 = null;
    if (paramBundle != null) {
      try {
        paramBundle.setClassLoader(AMapLocation.class.getClassLoader());
        AMapLocation aMapLocation2 = (AMapLocation)paramBundle.getParcelable("loc");
        this.y = paramBundle.getString("nb");
        dm dm5 = (dm)paramBundle.getParcelable("statics");
        AMapLocation aMapLocation1 = aMapLocation2;
        dm dm3 = dm5;
        if (aMapLocation2 != null) {
          aMapLocation1 = aMapLocation2;
          dm3 = dm5;
          dm dm = dm5;
          try {
          
          } finally {
            dm3 = null;
            ej.a((Throwable)dm3, "AmapLocationManager", "resultLbsLocationSuccess");
            dm3 = dm;
          } 
          return;
        } 
      } finally {
        paramBundle = null;
      } 
    } else {
      paramBundle = null;
      Bundle bundle1 = paramBundle;
      bundle = paramBundle;
    } 
    ej.a((Throwable)paramBundle, "AmapLocationManager", "resultLbsLocationSuccess");
    paramBundle = bundle;
    dm dm1 = dm2;
  }
  
  private void a(AMapLocation paramAMapLocation, dm paramdm) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: astore #4
    //   5: aload_1
    //   6: ifnonnull -> 36
    //   9: new com/amap/api/location/AMapLocation
    //   12: dup
    //   13: ldc_w ''
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: astore #4
    //   21: aload #4
    //   23: bipush #8
    //   25: invokevirtual setErrorCode : (I)V
    //   28: aload #4
    //   30: ldc_w 'amapLocation is null#0801'
    //   33: invokevirtual setLocationDetail : (Ljava/lang/String;)V
    //   36: ldc_w 'gps'
    //   39: aload #4
    //   41: invokevirtual getProvider : ()Ljava/lang/String;
    //   44: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   47: ifne -> 58
    //   50: aload #4
    //   52: ldc_w 'lbs'
    //   55: invokevirtual setProvider : (Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   62: ifnonnull -> 76
    //   65: aload_0
    //   66: new com/amap/api/location/AMapLocationQualityReport
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: putfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   76: aload_0
    //   77: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   80: aload_0
    //   81: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
    //   84: invokevirtual getLocationMode : ()Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   87: invokevirtual setLocationMode : (Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;)V
    //   90: aload_0
    //   91: getfield c : Lcom/loc/g;
    //   94: ifnull -> 125
    //   97: aload_0
    //   98: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   101: aload_0
    //   102: getfield c : Lcom/loc/g;
    //   105: invokevirtual d : ()I
    //   108: invokevirtual setGPSSatellites : (I)V
    //   111: aload_0
    //   112: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   115: aload_0
    //   116: getfield c : Lcom/loc/g;
    //   119: invokevirtual c : ()I
    //   122: invokevirtual setGpsStatus : (I)V
    //   125: aload_0
    //   126: getfield A : Landroid/content/Context;
    //   129: invokestatic h : (Landroid/content/Context;)Z
    //   132: istore_3
    //   133: aload_0
    //   134: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   137: iload_3
    //   138: invokevirtual setWifiAble : (Z)V
    //   141: aload_0
    //   142: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   145: aload_0
    //   146: getfield A : Landroid/content/Context;
    //   149: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   152: invokevirtual setNetworkType : (Ljava/lang/String;)V
    //   155: aload #4
    //   157: invokevirtual getLocationType : ()I
    //   160: iconst_1
    //   161: if_icmpeq -> 178
    //   164: ldc_w 'gps'
    //   167: aload #4
    //   169: invokevirtual getProvider : ()Ljava/lang/String;
    //   172: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   175: ifeq -> 186
    //   178: aload_0
    //   179: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   182: lconst_0
    //   183: invokevirtual setNetUseTime : (J)V
    //   186: aload_2
    //   187: ifnull -> 201
    //   190: aload_0
    //   191: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   194: aload_2
    //   195: invokevirtual a : ()J
    //   198: invokevirtual setNetUseTime : (J)V
    //   201: aload_0
    //   202: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   205: getstatic com/loc/d.F : Z
    //   208: invokevirtual setInstallHighDangerMockApp : (Z)V
    //   211: aload #4
    //   213: aload_0
    //   214: getfield u : Lcom/amap/api/location/AMapLocationQualityReport;
    //   217: invokevirtual setLocationQualityReport : (Lcom/amap/api/location/AMapLocationQualityReport;)V
    //   220: aload_0
    //   221: getfield C : Z
    //   224: ifeq -> 347
    //   227: aload_0
    //   228: getfield y : Ljava/lang/String;
    //   231: astore_1
    //   232: new android/os/Bundle
    //   235: dup
    //   236: invokespecial <init> : ()V
    //   239: astore #5
    //   241: aload #5
    //   243: ldc_w 'loc'
    //   246: aload #4
    //   248: invokevirtual putParcelable : (Ljava/lang/String;Landroid/os/Parcelable;)V
    //   251: aload #5
    //   253: ldc_w 'lastLocNb'
    //   256: aload_1
    //   257: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_0
    //   261: sipush #1014
    //   264: aload #5
    //   266: lconst_0
    //   267: invokespecial a : (ILjava/lang/Object;J)V
    //   270: aload_2
    //   271: ifnull -> 281
    //   274: aload_2
    //   275: invokestatic b : ()J
    //   278: invokevirtual d : (J)V
    //   281: aload_0
    //   282: getfield A : Landroid/content/Context;
    //   285: aload #4
    //   287: aload_2
    //   288: invokestatic a : (Landroid/content/Context;Lcom/amap/api/location/AMapLocation;Lcom/loc/dm;)V
    //   291: aload_0
    //   292: getfield A : Landroid/content/Context;
    //   295: aload #4
    //   297: invokestatic a : (Landroid/content/Context;Lcom/amap/api/location/AMapLocation;)V
    //   300: aload #4
    //   302: invokevirtual clone : ()Lcom/amap/api/location/AMapLocation;
    //   305: astore_1
    //   306: aload_0
    //   307: getfield b : Lcom/loc/d$c;
    //   310: invokevirtual obtainMessage : ()Landroid/os/Message;
    //   313: astore_2
    //   314: aload_2
    //   315: bipush #10
    //   317: putfield what : I
    //   320: aload_2
    //   321: aload_1
    //   322: putfield obj : Ljava/lang/Object;
    //   325: aload_0
    //   326: getfield b : Lcom/loc/d$c;
    //   329: aload_2
    //   330: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   333: pop
    //   334: goto -> 347
    //   337: astore_1
    //   338: aload_1
    //   339: ldc 'ALManager'
    //   341: ldc_w 'handlerLocation part2'
    //   344: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_0
    //   348: getfield n : Z
    //   351: istore_3
    //   352: iload_3
    //   353: ifeq -> 359
    //   356: aload_0
    //   357: monitorexit
    //   358: return
    //   359: aload_0
    //   360: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
    //   363: invokevirtual isOnceLocation : ()Z
    //   366: ifeq -> 380
    //   369: aload_0
    //   370: invokespecial k : ()V
    //   373: aload_0
    //   374: bipush #14
    //   376: aconst_null
    //   377: invokespecial a : (ILandroid/os/Bundle;)V
    //   380: aload_0
    //   381: monitorexit
    //   382: return
    //   383: astore_1
    //   384: aload_1
    //   385: ldc 'ALManager'
    //   387: ldc_w 'handlerLocation part3'
    //   390: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload_0
    //   394: monitorexit
    //   395: return
    //   396: astore_1
    //   397: aload_0
    //   398: monitorexit
    //   399: aload_1
    //   400: athrow
    // Exception table:
    //   from	to	target	type
    //   9	36	383	finally
    //   36	58	383	finally
    //   58	76	383	finally
    //   76	125	383	finally
    //   125	178	383	finally
    //   178	186	383	finally
    //   190	201	383	finally
    //   201	220	383	finally
    //   220	270	337	finally
    //   274	281	337	finally
    //   281	334	337	finally
    //   338	347	383	finally
    //   347	352	383	finally
    //   359	380	383	finally
    //   384	393	396	finally
  }
  
  private ds b(dn paramdn) {
    dm dm = new dm();
    AMapLocation aMapLocation = null;
    try {
      boolean bool;
      dm.c(ep.b());
      try {
        String str = AMapLocationClientOption.getAPIKEY();
        if (!TextUtils.isEmpty(str))
          l.a(this.A, str); 
      } finally {
        Exception exception = null;
      } 
      ds ds = a(paramdn);
    } finally {
      null = null;
      AMapLocation aMapLocation1 = null;
    } 
  }
  
  private boolean i() {
    boolean bool = false;
    int j = 0;
    try {
      while (this.i == null) {
        Thread.sleep(100L);
        int k = j + 1;
        j = k;
        if (k >= 50)
          break; 
      } 
    } finally {
      Exception exception = null;
    } 
    if (!bool) {
      if (!ep.l(this.A.getApplicationContext())) {
        j = 2103;
      } else {
        j = 2101;
      } 
      en.a((String)null, j);
    } 
    return bool;
  }
  
  private void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
    //   6: ifnonnull -> 20
    //   9: aload_0
    //   10: new com/amap/api/location/AMapLocationClientOption
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: putfield a : Lcom/amap/api/location/AMapLocationClientOption;
    //   20: aload_0
    //   21: getfield C : Z
    //   24: istore_2
    //   25: iload_2
    //   26: ifeq -> 32
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield C : Z
    //   37: getstatic com/loc/d$2.a : [I
    //   40: aload_0
    //   41: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
    //   44: invokevirtual getLocationMode : ()Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;
    //   47: invokevirtual ordinal : ()I
    //   50: iaload
    //   51: istore_1
    //   52: lconst_0
    //   53: lstore #5
    //   55: iload_1
    //   56: iconst_1
    //   57: if_icmpeq -> 147
    //   60: iload_1
    //   61: iconst_2
    //   62: if_icmpeq -> 128
    //   65: iload_1
    //   66: iconst_3
    //   67: if_icmpeq -> 73
    //   70: goto -> 125
    //   73: aload_0
    //   74: sipush #1015
    //   77: aconst_null
    //   78: lconst_0
    //   79: invokespecial a : (ILjava/lang/Object;J)V
    //   82: lload #5
    //   84: lstore_3
    //   85: aload_0
    //   86: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
    //   89: invokevirtual isGpsFirst : ()Z
    //   92: ifeq -> 116
    //   95: lload #5
    //   97: lstore_3
    //   98: aload_0
    //   99: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
    //   102: invokevirtual isOnceLocation : ()Z
    //   105: ifeq -> 116
    //   108: aload_0
    //   109: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
    //   112: invokevirtual getGpsFirstTimeout : ()J
    //   115: lstore_3
    //   116: aload_0
    //   117: sipush #1016
    //   120: aconst_null
    //   121: lload_3
    //   122: invokespecial a : (ILjava/lang/Object;J)V
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: aload_0
    //   129: sipush #1016
    //   132: invokespecial a : (I)V
    //   135: aload_0
    //   136: sipush #1015
    //   139: aconst_null
    //   140: lconst_0
    //   141: invokespecial a : (ILjava/lang/Object;J)V
    //   144: aload_0
    //   145: monitorexit
    //   146: return
    //   147: aload_0
    //   148: sipush #1017
    //   151: aconst_null
    //   152: lconst_0
    //   153: invokespecial a : (ILjava/lang/Object;J)V
    //   156: aload_0
    //   157: sipush #1016
    //   160: aconst_null
    //   161: lconst_0
    //   162: invokespecial a : (ILjava/lang/Object;J)V
    //   165: aload_0
    //   166: monitorexit
    //   167: return
    //   168: astore #7
    //   170: aload_0
    //   171: monitorexit
    //   172: aload #7
    //   174: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	168	finally
    //   20	25	168	finally
    //   32	52	168	finally
    //   73	82	168	finally
    //   85	95	168	finally
    //   98	116	168	finally
    //   116	125	168	finally
    //   128	144	168	finally
    //   147	165	168	finally
  }
  
  private void k() {
    try {
      a(1025);
      if (this.c != null)
        this.c.a(); 
      a(1016);
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ALManager", "stopLocation");
    } 
  }
  
  private void l() {
    if (this.a.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
      long l2 = this.a.getInterval();
      long l1 = 1000L;
      if (l2 >= 1000L)
        l1 = this.a.getInterval(); 
      a(1016, (Object)null, l1);
    } 
  }
  
  private void m() {
    try {
      if (this.j == null)
        this.j = new Messenger(this.b); 
      Intent intent = n();
    } finally {
      Exception exception = null;
    } 
  }
  
  private Intent n() {
    String str;
    if (this.k == null)
      this.k = new Intent(this.A, APSService.class); 
    try {
    
    } finally {
      Exception exception = null;
      ej.a(exception, "ALManager", "startServiceImpl p2");
    } 
    this.k.putExtra("a", str);
    this.k.putExtra("b", k.c(this.A));
    this.k.putExtra("d", UmidtokenInfo.getUmidtoken());
    return this.k;
  }
  
  private boolean o() {
    if (ep.k(this.A)) {
      int j = -1;
      try {
        int k = em.b(((Application)this.A.getApplicationContext()).getBaseContext(), "checkSelfPermission", new Object[] { "android.permission.FOREGROUND_SERVICE" });
        j = k;
      } finally {
        Exception exception;
      } 
      if (j != 0)
        return false; 
    } 
    return true;
  }
  
  public final void a(int paramInt, Notification paramNotification) {
    if (paramInt != 0) {
      if (paramNotification == null)
        return; 
      try {
        Bundle bundle = new Bundle();
        bundle.putInt("i", paramInt);
        bundle.putParcelable("h", (Parcelable)paramNotification);
        return;
      } finally {
        paramNotification = null;
      } 
    } 
  }
  
  public final void a(WebView paramWebView) {
    if (this.G == null)
      this.G = new h(this.A, paramWebView); 
    this.G.a();
  }
  
  public final void a(AMapLocationClientOption paramAMapLocationClientOption) {
    try {
      return;
    } finally {
      paramAMapLocationClientOption = null;
      ej.a((Throwable)paramAMapLocationClientOption, "ALManager", "setLocationOption");
    } 
  }
  
  public final void a(AMapLocationListener paramAMapLocationListener) {
    try {
      return;
    } finally {
      paramAMapLocationListener = null;
      ej.a((Throwable)paramAMapLocationListener, "ALManager", "setLocationListener");
    } 
  }
  
  public final void a(boolean paramBoolean) {
    try {
      Bundle bundle = new Bundle();
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ALManager", "disableBackgroundLocation");
    } 
  }
  
  public final boolean a() {
    return this.B;
  }
  
  public final void b() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ALManager", "startLocation");
    } 
  }
  
  public final void b(AMapLocationListener paramAMapLocationListener) {
    try {
      return;
    } finally {
      paramAMapLocationListener = null;
      ej.a((Throwable)paramAMapLocationListener, "ALManager", "unRegisterLocationListener");
    } 
  }
  
  public final void c() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ALManager", "stopLocation");
    } 
  }
  
  public final void d() {
    try {
      if (this.G != null) {
        this.G.b();
        this.G = null;
      } 
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ALManager", "onDestroy");
    } 
  }
  
  public final AMapLocation e() {
    AMapLocation aMapLocation2 = null;
    AMapLocation aMapLocation3 = null;
    AMapLocation aMapLocation1 = aMapLocation3;
  }
  
  public final void f() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ALManager", "startAssistantLocation");
    } 
  }
  
  public final void g() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "ALManager", "stopAssistantLocation");
    } 
  }
  
  final void h() {
    // Byte code:
    //   0: aload_0
    //   1: bipush #12
    //   3: aconst_null
    //   4: invokespecial a : (ILandroid/os/Bundle;)V
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield g : Z
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield B : Z
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield r : Z
    //   22: aload_0
    //   23: invokespecial k : ()V
    //   26: aload_0
    //   27: getfield q : Lcom/loc/en;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull -> 43
    //   35: aload_1
    //   36: aload_0
    //   37: getfield A : Landroid/content/Context;
    //   40: invokevirtual b : (Landroid/content/Context;)V
    //   43: aload_0
    //   44: getfield A : Landroid/content/Context;
    //   47: invokestatic a : (Landroid/content/Context;)V
    //   50: aload_0
    //   51: getfield s : Lcom/loc/e;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull -> 72
    //   59: aload_1
    //   60: getfield d : Lcom/loc/e$a;
    //   63: bipush #11
    //   65: invokevirtual sendEmptyMessage : (I)Z
    //   68: pop
    //   69: goto -> 89
    //   72: aload_0
    //   73: getfield H : Landroid/content/ServiceConnection;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull -> 89
    //   81: aload_0
    //   82: getfield A : Landroid/content/Context;
    //   85: aload_1
    //   86: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   89: aload_0
    //   90: getfield z : Z
    //   93: ifeq -> 111
    //   96: aload_0
    //   97: getfield A : Landroid/content/Context;
    //   100: aload_0
    //   101: invokespecial n : ()Landroid/content/Intent;
    //   104: invokevirtual stopService : (Landroid/content/Intent;)Z
    //   107: pop
    //   108: goto -> 111
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield z : Z
    //   116: aload_0
    //   117: getfield d : Ljava/util/ArrayList;
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull -> 134
    //   125: aload_1
    //   126: invokevirtual clear : ()V
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield d : Ljava/util/ArrayList;
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield H : Landroid/content/ServiceConnection;
    //   139: aload_0
    //   140: getfield p : Ljava/lang/Object;
    //   143: astore_1
    //   144: aload_1
    //   145: monitorenter
    //   146: aload_0
    //   147: getfield x : Lcom/loc/d$a;
    //   150: ifnull -> 161
    //   153: aload_0
    //   154: getfield x : Lcom/loc/d$a;
    //   157: aconst_null
    //   158: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   161: aload_0
    //   162: aconst_null
    //   163: putfield x : Lcom/loc/d$a;
    //   166: aload_1
    //   167: monitorexit
    //   168: aload_0
    //   169: getfield m : Lcom/loc/d$b;
    //   172: ifnull -> 212
    //   175: getstatic android/os/Build$VERSION.SDK_INT : I
    //   178: bipush #18
    //   180: if_icmplt -> 204
    //   183: aload_0
    //   184: getfield m : Lcom/loc/d$b;
    //   187: ldc_w android/os/HandlerThread
    //   190: ldc_w 'quitSafely'
    //   193: iconst_0
    //   194: anewarray java/lang/Object
    //   197: invokestatic a : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: goto -> 212
    //   204: aload_0
    //   205: getfield m : Lcom/loc/d$b;
    //   208: invokevirtual quit : ()Z
    //   211: pop
    //   212: aload_0
    //   213: aconst_null
    //   214: putfield m : Lcom/loc/d$b;
    //   217: aload_0
    //   218: getfield b : Lcom/loc/d$c;
    //   221: astore_1
    //   222: aload_1
    //   223: ifnull -> 231
    //   226: aload_1
    //   227: aconst_null
    //   228: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   231: aload_0
    //   232: getfield h : Lcom/loc/i;
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull -> 249
    //   240: aload_1
    //   241: invokevirtual c : ()V
    //   244: aload_0
    //   245: aconst_null
    //   246: putfield h : Lcom/loc/i;
    //   249: return
    //   250: astore_2
    //   251: aload_1
    //   252: monitorexit
    //   253: aload_2
    //   254: athrow
    //   255: astore_1
    //   256: goto -> 111
    //   259: astore_1
    //   260: goto -> 204
    // Exception table:
    //   from	to	target	type
    //   89	108	255	finally
    //   146	161	250	finally
    //   161	168	250	finally
    //   183	201	259	finally
    //   251	253	250	finally
  }
  
  public final class a extends Handler {
    public a(d this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      // Byte code:
      //   0: aconst_null
      //   1: astore #5
      //   3: aload #5
      //   5: astore #4
      //   7: aload_0
      //   8: aload_1
      //   9: invokespecial handleMessage : (Landroid/os/Message;)V
      //   12: aload #5
      //   14: astore #4
      //   16: aload_1
      //   17: getfield what : I
      //   20: istore_2
      //   21: iload_2
      //   22: bipush #11
      //   24: if_icmpeq -> 587
      //   27: iload_2
      //   28: bipush #12
      //   30: if_icmpeq -> 574
      //   33: iload_2
      //   34: tableswitch default -> 636, 1002 -> 555, 1003 -> 516, 1004 -> 488, 1005 -> 469, 1006 -> 704, 1007 -> 704, 1008 -> 457, 1009 -> 445, 1010 -> 703, 1011 -> 419
      //   88: ldc 'handleMessage ACTION_REBOOT_GPS_LOCATION'
      //   90: astore_1
      //   91: aload_1
      //   92: astore #4
      //   94: aload_0
      //   95: getfield a : Lcom/loc/d;
      //   98: getfield c : Lcom/loc/g;
      //   101: astore #5
      //   103: aload_1
      //   104: astore #4
      //   106: aload #5
      //   108: getfield c : Lcom/amap/api/location/AMapLocationClientOption;
      //   111: astore #6
      //   113: iconst_0
      //   114: istore_3
      //   115: iload_3
      //   116: istore_2
      //   117: aload #6
      //   119: ifnull -> 164
      //   122: aload_1
      //   123: astore #4
      //   125: aload #5
      //   127: getfield c : Lcom/amap/api/location/AMapLocationClientOption;
      //   130: invokevirtual isOnceLocation : ()Z
      //   133: ifeq -> 141
      //   136: iload_3
      //   137: istore_2
      //   138: goto -> 164
      //   141: iload_3
      //   142: istore_2
      //   143: aload_1
      //   144: astore #4
      //   146: invokestatic b : ()J
      //   149: aload #5
      //   151: getfield d : J
      //   154: lsub
      //   155: ldc2_w 300000
      //   158: lcmp
      //   159: ifle -> 164
      //   162: iconst_1
      //   163: istore_2
      //   164: iload_2
      //   165: ifeq -> 201
      //   168: aload_1
      //   169: astore #4
      //   171: aload_0
      //   172: getfield a : Lcom/loc/d;
      //   175: getfield c : Lcom/loc/g;
      //   178: invokevirtual a : ()V
      //   181: aload_1
      //   182: astore #4
      //   184: aload_0
      //   185: getfield a : Lcom/loc/d;
      //   188: getfield c : Lcom/loc/g;
      //   191: aload_0
      //   192: getfield a : Lcom/loc/d;
      //   195: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
      //   198: invokevirtual a : (Lcom/amap/api/location/AMapLocationClientOption;)V
      //   201: aload_1
      //   202: astore #4
      //   204: aload_0
      //   205: getfield a : Lcom/loc/d;
      //   208: sipush #1025
      //   211: ldc2_w 300000
      //   214: invokestatic a : (Lcom/loc/d;IJ)V
      //   217: return
      //   218: ldc 'handleMessage ACTION_DISABLE_BACKGROUND'
      //   220: astore #4
      //   222: aload_0
      //   223: getfield a : Lcom/loc/d;
      //   226: aload_1
      //   227: invokestatic d : (Lcom/loc/d;Landroid/os/Message;)V
      //   230: return
      //   231: ldc 'handleMessage ACTION_ENABLE_BACKGROUND'
      //   233: astore #4
      //   235: aload_0
      //   236: getfield a : Lcom/loc/d;
      //   239: aload_1
      //   240: invokestatic c : (Lcom/loc/d;Landroid/os/Message;)V
      //   243: return
      //   244: ldc 'handleMessage SET_OPTION'
      //   246: astore #5
      //   248: aload #5
      //   250: astore #4
      //   252: aload_0
      //   253: getfield a : Lcom/loc/d;
      //   256: aload_1
      //   257: getfield obj : Ljava/lang/Object;
      //   260: checkcast com/amap/api/location/AMapLocationClientOption
      //   263: putfield a : Lcom/amap/api/location/AMapLocationClientOption;
      //   266: aload #5
      //   268: astore #4
      //   270: aload_0
      //   271: getfield a : Lcom/loc/d;
      //   274: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
      //   277: ifnull -> 702
      //   280: aload #5
      //   282: astore #4
      //   284: aload_0
      //   285: getfield a : Lcom/loc/d;
      //   288: invokestatic g : (Lcom/loc/d;)V
      //   291: return
      //   292: ldc 'handleMessage STOP_GPS_LOCATION'
      //   294: astore_1
      //   295: aload_1
      //   296: astore #4
      //   298: aload_0
      //   299: getfield a : Lcom/loc/d;
      //   302: getfield c : Lcom/loc/g;
      //   305: invokevirtual a : ()V
      //   308: aload_1
      //   309: astore #4
      //   311: aload_0
      //   312: getfield a : Lcom/loc/d;
      //   315: invokestatic f : (Lcom/loc/d;)V
      //   318: return
      //   319: ldc 'handleMessage START_LBS_LOCATION'
      //   321: astore_1
      //   322: aload_1
      //   323: astore #4
      //   325: aload_0
      //   326: getfield a : Lcom/loc/d;
      //   329: getfield c : Lcom/loc/g;
      //   332: invokevirtual b : ()Z
      //   335: ifeq -> 355
      //   338: aload_1
      //   339: astore #4
      //   341: aload_0
      //   342: getfield a : Lcom/loc/d;
      //   345: sipush #1016
      //   348: ldc2_w 1000
      //   351: invokestatic a : (Lcom/loc/d;IJ)V
      //   354: return
      //   355: aload_1
      //   356: astore #4
      //   358: aload_0
      //   359: getfield a : Lcom/loc/d;
      //   362: invokestatic e : (Lcom/loc/d;)V
      //   365: return
      //   366: ldc 'handleMessage START_GPS_LOCATION'
      //   368: astore_1
      //   369: aload_1
      //   370: astore #4
      //   372: aload_0
      //   373: getfield a : Lcom/loc/d;
      //   376: getfield c : Lcom/loc/g;
      //   379: aload_0
      //   380: getfield a : Lcom/loc/d;
      //   383: getfield a : Lcom/amap/api/location/AMapLocationClientOption;
      //   386: invokevirtual a : (Lcom/amap/api/location/AMapLocationClientOption;)V
      //   389: aload_1
      //   390: astore #4
      //   392: aload_0
      //   393: getfield a : Lcom/loc/d;
      //   396: sipush #1025
      //   399: ldc2_w 300000
      //   402: invokestatic a : (Lcom/loc/d;IJ)V
      //   405: return
      //   406: ldc 'handleMessage ACTION_SAVE_LAST_LOCATION'
      //   408: astore #4
      //   410: aload_0
      //   411: getfield a : Lcom/loc/d;
      //   414: aload_1
      //   415: invokestatic b : (Lcom/loc/d;Landroid/os/Message;)V
      //   418: return
      //   419: aload #5
      //   421: astore #4
      //   423: aload_0
      //   424: getfield a : Lcom/loc/d;
      //   427: bipush #14
      //   429: aconst_null
      //   430: invokestatic a : (Lcom/loc/d;ILandroid/os/Bundle;)V
      //   433: ldc 'handleMessage DESTROY'
      //   435: astore #4
      //   437: aload_0
      //   438: getfield a : Lcom/loc/d;
      //   441: invokevirtual h : ()V
      //   444: return
      //   445: ldc 'handleMessage STOP_SOCKET'
      //   447: astore #4
      //   449: aload_0
      //   450: getfield a : Lcom/loc/d;
      //   453: invokestatic i : (Lcom/loc/d;)V
      //   456: return
      //   457: ldc 'handleMessage START_SOCKET'
      //   459: astore #4
      //   461: aload_0
      //   462: getfield a : Lcom/loc/d;
      //   465: invokestatic h : (Lcom/loc/d;)V
      //   468: return
      //   469: ldc 'handleMessage REMOVE_LISTENER'
      //   471: astore #4
      //   473: aload_0
      //   474: getfield a : Lcom/loc/d;
      //   477: aload_1
      //   478: getfield obj : Ljava/lang/Object;
      //   481: checkcast com/amap/api/location/AMapLocationListener
      //   484: invokestatic b : (Lcom/loc/d;Lcom/amap/api/location/AMapLocationListener;)V
      //   487: return
      //   488: ldc 'handleMessage STOP_LOCATION'
      //   490: astore #4
      //   492: aload #4
      //   494: astore_1
      //   495: aload_0
      //   496: getfield a : Lcom/loc/d;
      //   499: invokestatic d : (Lcom/loc/d;)V
      //   502: aload #4
      //   504: astore_1
      //   505: aload_0
      //   506: getfield a : Lcom/loc/d;
      //   509: bipush #14
      //   511: aconst_null
      //   512: invokestatic a : (Lcom/loc/d;ILandroid/os/Bundle;)V
      //   515: return
      //   516: ldc 'handleMessage START_LOCATION'
      //   518: astore #4
      //   520: aload #4
      //   522: astore_1
      //   523: aload_0
      //   524: getfield a : Lcom/loc/d;
      //   527: invokestatic c : (Lcom/loc/d;)V
      //   530: aload #4
      //   532: astore_1
      //   533: aload_0
      //   534: getfield a : Lcom/loc/d;
      //   537: bipush #13
      //   539: aconst_null
      //   540: invokestatic a : (Lcom/loc/d;ILandroid/os/Bundle;)V
      //   543: return
      //   544: astore #5
      //   546: aload_1
      //   547: astore #4
      //   549: aload #5
      //   551: astore_1
      //   552: goto -> 614
      //   555: ldc 'handleMessage SET_LISTENER'
      //   557: astore #4
      //   559: aload_0
      //   560: getfield a : Lcom/loc/d;
      //   563: aload_1
      //   564: getfield obj : Ljava/lang/Object;
      //   567: checkcast com/amap/api/location/AMapLocationListener
      //   570: invokestatic a : (Lcom/loc/d;Lcom/amap/api/location/AMapLocationListener;)V
      //   573: return
      //   574: ldc 'handleMessage ACTION_GPS_LOCATIONSUCCESS'
      //   576: astore #4
      //   578: aload_0
      //   579: getfield a : Lcom/loc/d;
      //   582: aload_1
      //   583: invokestatic a : (Lcom/loc/d;Landroid/os/Message;)V
      //   586: return
      //   587: ldc 'handleMessage ACTION_LBS_LOCATIONSUCCES'
      //   589: astore #5
      //   591: aload #5
      //   593: astore #4
      //   595: aload_1
      //   596: invokevirtual getData : ()Landroid/os/Bundle;
      //   599: astore_1
      //   600: aload #5
      //   602: astore #4
      //   604: aload_0
      //   605: getfield a : Lcom/loc/d;
      //   608: aload_1
      //   609: invokestatic a : (Lcom/loc/d;Landroid/os/Bundle;)V
      //   612: return
      //   613: astore_1
      //   614: aload #4
      //   616: astore #5
      //   618: aload #4
      //   620: ifnonnull -> 627
      //   623: ldc 'handleMessage'
      //   625: astore #5
      //   627: aload_1
      //   628: ldc 'AMapLocationManage$MHandlerr'
      //   630: aload #5
      //   632: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   635: return
      //   636: iload_2
      //   637: tableswitch default -> 700, 1014 -> 406, 1015 -> 366, 1016 -> 319, 1017 -> 292, 1018 -> 244, 1019 -> 701, 1020 -> 701, 1021 -> 701, 1022 -> 701, 1023 -> 231, 1024 -> 218, 1025 -> 88
      //   700: return
      //   701: return
      //   702: return
      //   703: return
      //   704: return
      // Exception table:
      //   from	to	target	type
      //   7	12	613	finally
      //   16	21	613	finally
      //   94	103	613	finally
      //   106	113	613	finally
      //   125	136	613	finally
      //   146	162	613	finally
      //   171	181	613	finally
      //   184	201	613	finally
      //   204	217	613	finally
      //   222	230	613	finally
      //   235	243	613	finally
      //   252	266	613	finally
      //   270	280	613	finally
      //   284	291	613	finally
      //   298	308	613	finally
      //   311	318	613	finally
      //   325	338	613	finally
      //   341	354	613	finally
      //   358	365	613	finally
      //   372	389	613	finally
      //   392	405	613	finally
      //   410	418	613	finally
      //   423	433	613	finally
      //   437	444	613	finally
      //   449	456	613	finally
      //   461	468	613	finally
      //   473	487	613	finally
      //   495	502	544	finally
      //   505	515	544	finally
      //   523	530	544	finally
      //   533	543	544	finally
      //   559	573	613	finally
      //   578	586	613	finally
      //   595	600	613	finally
      //   604	612	613	finally
    }
  }
  
  static final class b extends HandlerThread {
    d a = null;
    
    public b(String param1String, d param1d) {
      super(param1String);
      this.a = param1d;
    }
    
    protected final void onLooperPrepared() {
      try {
        this.a.h.a();
        d.a(this.a);
        dw.j();
        if (this.a != null && d.b(this.a) != null) {
          ei.b(d.b(this.a));
          ei.a(d.b(this.a));
        } 
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
  
  public final class c extends Handler {
    public c(d this$0) {}
    
    public c(d this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      String str2 = null;
      String str1 = str2;
      try {
        super.handleMessage(param1Message);
      } finally {
        str2 = null;
        String str = str1;
        if (str1 == null)
          str = "handleMessage"; 
        ej.a((Throwable)str2, "AmapLocationManager$MainHandler", str);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */