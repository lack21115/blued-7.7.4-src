package com.loc;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import java.util.List;

public final class g {
  static AMapLocation j;
  
  static long k;
  
  static Object l = new Object();
  
  static long q = 0L;
  
  static boolean t = false;
  
  static boolean u = false;
  
  public static volatile AMapLocation y = null;
  
  private long A = 0L;
  
  private int B = 0;
  
  private int C = 0;
  
  private GpsStatus D = null;
  
  private GpsStatus.Listener E = new GpsStatus.Listener(this) {
      public final void onGpsStatusChanged(int param1Int) {
        try {
          if (this.a.b == null)
            return; 
        } finally {
          Exception exception = null;
          ej.a(exception, "GpsLocation", "onGpsStatusChanged");
        } 
      }
    };
  
  private String F = null;
  
  private boolean G = false;
  
  private int H = 0;
  
  private boolean I = false;
  
  Handler a;
  
  LocationManager b;
  
  AMapLocationClientOption c;
  
  long d = 0L;
  
  boolean e = false;
  
  dr f = null;
  
  int g = 240;
  
  int h = 80;
  
  AMapLocation i = null;
  
  long m = 0L;
  
  float n = 0.0F;
  
  Object o = new Object();
  
  Object p = new Object();
  
  AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
  
  boolean s = true;
  
  long v = 0L;
  
  int w = 0;
  
  LocationListener x = null;
  
  private Context z;
  
  public g(Context paramContext, Handler paramHandler) {
    this.z = paramContext;
    this.a = paramHandler;
    try {
      this.b = (LocationManager)this.z.getSystemService("location");
    } finally {
      paramContext = null;
    } 
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, long paramLong) {
    try {
      return;
    } finally {
      paramString = null;
    } 
  }
  
  private void a(AMapLocation paramAMapLocation) {
    if (paramAMapLocation.getErrorCode() == 15 && !AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.c.getLocationMode()))
      return; 
    if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.c.getDeviceModeDistanceFilter() > 0.0F) {
      b(paramAMapLocation);
      return;
    } 
    if (ep.b() - this.v >= this.c.getInterval() - 200L) {
      this.v = ep.b();
      b(paramAMapLocation);
    } 
  }
  
  private static boolean a(LocationManager paramLocationManager) {
    try {
      if (t)
        return u; 
      List list = paramLocationManager.getAllProviders();
      if (list != null && list.size() > 0) {
        u = list.contains("gps");
      } else {
        u = false;
      } 
      return u;
    } finally {
      paramLocationManager = null;
    } 
  }
  
  private boolean a(String paramString) {
    boolean bool = false;
    try {
      ArrayList<String> arrayList1 = ep.d(paramString);
      ArrayList<String> arrayList2 = ep.d(this.F);
      boolean bool1 = bool;
      return bool1;
    } finally {
      paramString = null;
    } 
  }
  
  private void b(AMapLocation paramAMapLocation) {
    if (this.a != null) {
      Message message = Message.obtain();
      message.obj = paramAMapLocation;
      message.what = 2;
      this.a.sendMessage(message);
    } 
  }
  
  private static boolean e() {
    try {
      return ((Boolean)em.a(u.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), u.c("UaXNOYXZpU3RhcnRlZA=="), (Object[])null, (Class<?>[])null)).booleanValue();
    } finally {
      Exception exception = null;
    } 
  }
  
  private AMapLocation f() {
    try {
      if (!ep.a(this.i))
        return null; 
      if (!ei.j())
        return null; 
      return null;
    } finally {
      Exception exception = null;
    } 
  }
  
  public final AMapLocation a(AMapLocation paramAMapLocation, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : Lcom/amap/api/location/AMapLocation;
    //   4: ifnonnull -> 9
    //   7: aload_1
    //   8: areturn
    //   9: aload_0
    //   10: getfield c : Lcom/amap/api/location/AMapLocationClientOption;
    //   13: invokevirtual isMockEnable : ()Z
    //   16: ifne -> 31
    //   19: aload_0
    //   20: getfield i : Lcom/amap/api/location/AMapLocation;
    //   23: invokevirtual isMock : ()Z
    //   26: ifeq -> 31
    //   29: aload_1
    //   30: areturn
    //   31: aload_0
    //   32: getfield i : Lcom/amap/api/location/AMapLocation;
    //   35: invokestatic a : (Lcom/amap/api/location/AMapLocation;)Z
    //   38: ifne -> 43
    //   41: aload_1
    //   42: areturn
    //   43: aload_0
    //   44: invokespecial f : ()Lcom/amap/api/location/AMapLocation;
    //   47: astore #10
    //   49: aload #10
    //   51: ifnull -> 71
    //   54: aload #10
    //   56: invokestatic a : (Lcom/amap/api/location/AMapLocation;)Z
    //   59: ifeq -> 71
    //   62: aload #10
    //   64: iconst_2
    //   65: invokevirtual setTrustedLevel : (I)V
    //   68: aload #10
    //   70: areturn
    //   71: aload_0
    //   72: getfield i : Lcom/amap/api/location/AMapLocation;
    //   75: invokevirtual getSpeed : ()F
    //   78: fstore #4
    //   80: fload #4
    //   82: fstore_3
    //   83: fload #4
    //   85: fconst_0
    //   86: fcmpl
    //   87: ifne -> 141
    //   90: aload_0
    //   91: getfield m : J
    //   94: lstore #6
    //   96: fload #4
    //   98: fstore_3
    //   99: lload #6
    //   101: lconst_0
    //   102: lcmp
    //   103: ifle -> 141
    //   106: fload #4
    //   108: fstore_3
    //   109: lload #6
    //   111: ldc2_w 8
    //   114: lcmp
    //   115: ifge -> 141
    //   118: aload_0
    //   119: getfield n : F
    //   122: fstore #5
    //   124: fload #4
    //   126: fstore_3
    //   127: fload #5
    //   129: fconst_0
    //   130: fcmpl
    //   131: ifle -> 141
    //   134: fload #5
    //   136: lload #6
    //   138: l2f
    //   139: fdiv
    //   140: fstore_3
    //   141: aload_1
    //   142: ifnull -> 253
    //   145: aload_1
    //   146: invokestatic a : (Lcom/amap/api/location/AMapLocation;)Z
    //   149: ifeq -> 253
    //   152: aload_1
    //   153: invokevirtual getAccuracy : ()F
    //   156: ldc_w 200.0
    //   159: fcmpg
    //   160: ifge -> 217
    //   163: aload_0
    //   164: aload_0
    //   165: getfield H : I
    //   168: iconst_1
    //   169: iadd
    //   170: putfield H : I
    //   173: aload_0
    //   174: getfield F : Ljava/lang/String;
    //   177: ifnonnull -> 193
    //   180: aload_0
    //   181: getfield H : I
    //   184: iconst_2
    //   185: if_icmplt -> 193
    //   188: aload_0
    //   189: iconst_1
    //   190: putfield G : Z
    //   193: fload_3
    //   194: ldc_w 5.0
    //   197: fcmpl
    //   198: ifle -> 209
    //   201: ldc2_w 10000
    //   204: lstore #6
    //   206: goto -> 258
    //   209: ldc2_w 15000
    //   212: lstore #6
    //   214: goto -> 258
    //   217: aload_0
    //   218: getfield F : Ljava/lang/String;
    //   221: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   224: ifne -> 237
    //   227: aload_0
    //   228: iconst_0
    //   229: putfield G : Z
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield H : I
    //   237: fload_3
    //   238: ldc_w 5.0
    //   241: fcmpl
    //   242: ifle -> 253
    //   245: ldc2_w 20000
    //   248: lstore #6
    //   250: goto -> 258
    //   253: ldc2_w 30000
    //   256: lstore #6
    //   258: invokestatic b : ()J
    //   261: aload_0
    //   262: getfield d : J
    //   265: lsub
    //   266: lstore #8
    //   268: lload #8
    //   270: ldc2_w 30000
    //   273: lcmp
    //   274: ifle -> 279
    //   277: aload_1
    //   278: areturn
    //   279: lload #8
    //   281: lload #6
    //   283: lcmp
    //   284: iflt -> 358
    //   287: aload_0
    //   288: getfield G : Z
    //   291: ifeq -> 317
    //   294: aload_0
    //   295: aload_2
    //   296: invokespecial a : (Ljava/lang/String;)Z
    //   299: ifeq -> 317
    //   302: aload_0
    //   303: getfield i : Lcom/amap/api/location/AMapLocation;
    //   306: invokevirtual clone : ()Lcom/amap/api/location/AMapLocation;
    //   309: astore_1
    //   310: aload_1
    //   311: iconst_3
    //   312: invokevirtual setTrustedLevel : (I)V
    //   315: aload_1
    //   316: areturn
    //   317: aload_0
    //   318: aconst_null
    //   319: putfield F : Ljava/lang/String;
    //   322: aload_0
    //   323: iconst_0
    //   324: putfield H : I
    //   327: aload_0
    //   328: getfield p : Ljava/lang/Object;
    //   331: astore_2
    //   332: aload_2
    //   333: monitorenter
    //   334: aload_0
    //   335: aconst_null
    //   336: putfield i : Lcom/amap/api/location/AMapLocation;
    //   339: aload_2
    //   340: monitorexit
    //   341: aload_0
    //   342: lconst_0
    //   343: putfield m : J
    //   346: aload_0
    //   347: fconst_0
    //   348: putfield n : F
    //   351: aload_1
    //   352: areturn
    //   353: astore_1
    //   354: aload_2
    //   355: monitorexit
    //   356: aload_1
    //   357: athrow
    //   358: aload_0
    //   359: getfield F : Ljava/lang/String;
    //   362: ifnonnull -> 378
    //   365: aload_0
    //   366: getfield H : I
    //   369: iconst_2
    //   370: if_icmplt -> 378
    //   373: aload_0
    //   374: aload_2
    //   375: putfield F : Ljava/lang/String;
    //   378: aload_0
    //   379: getfield i : Lcom/amap/api/location/AMapLocation;
    //   382: invokevirtual clone : ()Lcom/amap/api/location/AMapLocation;
    //   385: astore_1
    //   386: aload_1
    //   387: iconst_2
    //   388: invokevirtual setTrustedLevel : (I)V
    //   391: aload_1
    //   392: areturn
    // Exception table:
    //   from	to	target	type
    //   334	341	353	finally
    //   354	356	353	finally
  }
  
  public final void a() {
    LocationManager locationManager = this.b;
    if (locationManager == null)
      return; 
    try {
      if (this.x != null) {
        locationManager.removeUpdates(this.x);
        ((a)this.x).a();
        this.x = null;
      } 
    } finally {}
    try {
      if (this.E != null)
        this.b.removeGpsStatusListener(this.E); 
    } finally {}
    try {
      if (this.a != null)
        this.a.removeMessages(8); 
    } finally {}
    this.C = 0;
    this.A = 0L;
    this.v = 0L;
    this.d = 0L;
    this.B = 0;
    this.w = 0;
    this.f.a();
    this.i = null;
    this.m = 0L;
    this.n = 0.0F;
    this.F = null;
    this.I = false;
  }
  
  public final void a(AMapLocationClientOption paramAMapLocationClientOption) {
    this.c = paramAMapLocationClientOption;
    if (this.c == null)
      this.c = new AMapLocationClientOption(); 
    try {
      q = eo.a(this.z, "pref", "lagt", q);
    } finally {}
    if (this.b == null)
      return; 
    try {
      if (ep.b() - k <= 5000L && ep.a(j) && (this.c.isMockEnable() || !j.isMock())) {
        this.d = ep.b();
        a(j);
      } 
      this.s = true;
      Looper looper2 = Looper.myLooper();
      Looper looper1 = looper2;
      if (looper2 == null)
        looper1 = this.z.getMainLooper(); 
      this.A = ep.b();
      boolean bool = a(this.b);
      return;
    } catch (SecurityException securityException) {
      this.s = false;
      en.a((String)null, 2121);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(securityException.getMessage());
      return;
    } finally {
      paramAMapLocationClientOption = null;
      ej.a((Throwable)paramAMapLocationClientOption, "GpsLocation", "requestLocationUpdates part2");
    } 
  }
  
  public final boolean b() {
    return !(ep.b() - this.d > 2800L);
  }
  
  public final int c() {
    LocationManager locationManager = this.b;
    if (locationManager == null)
      return 1; 
    if (!a(locationManager))
      return 1; 
    if (Build.VERSION.SDK_INT < 19) {
      if (!this.b.isProviderEnabled("gps"))
        return 2; 
    } else {
      int i = Settings.Secure.getInt(this.z.getContentResolver(), "location_mode", 0);
      if (i == 0)
        return 2; 
      if (i == 2)
        return 3; 
    } 
    return !this.s ? 4 : 0;
  }
  
  public final int d() {
    return this.C;
  }
  
  static final class a implements LocationListener {
    private g a;
    
    a(g param1g) {
      this.a = param1g;
    }
    
    final void a() {
      this.a = null;
    }
    
    public final void onLocationChanged(Location param1Location) {
      try {
        return;
      } finally {
        param1Location = null;
      } 
    }
    
    public final void onProviderDisabled(String param1String) {
      try {
        return;
      } finally {
        param1String = null;
      } 
    }
    
    public final void onProviderEnabled(String param1String) {}
    
    public final void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {
      try {
        return;
      } finally {
        param1String = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */