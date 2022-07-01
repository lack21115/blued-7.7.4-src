package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.map.geoloclite.tsa.TencentLiteLocation;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationListener;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationManager;
import java.util.Random;

public class x {
  private static volatile x a;
  
  private double b = 0.0D;
  
  private double c = 0.0D;
  
  private float d = 0.0F;
  
  private int e = 0;
  
  private LocationManager f = null;
  
  private TencentLiteLocationManager g = null;
  
  private LocationListener h = new LocationListener(this) {
      public void onLocationChanged(Location param1Location) {
        if (param1Location != null) {
          GDTLogger.d("--- LocationListener ## onLocationChanged");
          x.a(this.a, param1Location);
          x.a(this.a);
        } 
      }
      
      public void onProviderDisabled(String param1String) {}
      
      public void onProviderEnabled(String param1String) {}
      
      public void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {}
    };
  
  private TencentLiteLocationListener i = null;
  
  private x(Context paramContext) {
    d(paramContext);
  }
  
  public static x a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/util/x.a : Lcom/qq/e/comm/plugin/util/x;
    //   3: ifnonnull -> 38
    //   6: ldc com/qq/e/comm/plugin/util/x
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/util/x.a : Lcom/qq/e/comm/plugin/util/x;
    //   12: ifnonnull -> 26
    //   15: new com/qq/e/comm/plugin/util/x
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/qq/e/comm/plugin/util/x.a : Lcom/qq/e/comm/plugin/util/x;
    //   26: ldc com/qq/e/comm/plugin/util/x
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/qq/e/comm/plugin/util/x
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/qq/e/comm/plugin/util/x.a : Lcom/qq/e/comm/plugin/util/x;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(Location paramLocation) {
    this.b = paramLocation.getLatitude();
    this.c = paramLocation.getLongitude();
    this.d = paramLocation.getAccuracy();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("--- Set current location: ");
    stringBuilder.append(paramLocation.toString());
    stringBuilder.append("-timeStamp: ");
    stringBuilder.append(paramLocation.getTime());
    GDTLogger.d(stringBuilder.toString());
  }
  
  private void a(TencentLiteLocation paramTencentLiteLocation) {
    this.b = paramTencentLiteLocation.getLatitude();
    this.c = paramTencentLiteLocation.getLongitude();
    this.d = paramTencentLiteLocation.getAccuracy();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("latitude=");
    stringBuilder.append(this.b);
    stringBuilder.append(", longitude=");
    stringBuilder.append(this.c);
    stringBuilder.append(", accuracy=");
    stringBuilder.append(this.d);
    stringBuilder.append("timeStamp=");
    stringBuilder.append(paramTencentLiteLocation.getTime());
    String str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("--- Set current location from tencent location: ");
    stringBuilder.append(str);
    GDTLogger.d(stringBuilder.toString());
  }
  
  public static boolean c(Context paramContext) {
    return (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0);
  }
  
  private void d() {
    this.b = 0.0D;
    this.c = 0.0D;
    this.d = 0.0F;
  }
  
  private void d(Context paramContext) {
    b(paramContext);
  }
  
  private void e() {
    this.i = new TencentLiteLocationListener(this) {
        public void onLocationChanged(TencentLiteLocation param1TencentLiteLocation, int param1Int, String param1String) {
          if (param1Int == 0 && param1TencentLiteLocation != null) {
            GDTLogger.d("--- TencentLiteLocationListener ## onLocationChanged");
            x.a(this.a, param1TencentLiteLocation);
            x.a(this.a);
            return;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("--- TencentLiteLocationListener ## update location failed, error=");
          stringBuilder.append(param1Int);
          stringBuilder.append("resson is ");
          stringBuilder.append(param1String);
          GDTLogger.d(stringBuilder.toString());
        }
        
        public void onStatusUpdate(String param1String1, int param1Int, String param1String2) {}
      };
  }
  
  private void e(Context paramContext) {
    Random random = new Random();
    int i = GDTADManager.getInstance().getSM().getInteger("mapSdkRatio", 0);
    if (random.nextInt(100) < i) {
      f(paramContext);
      return;
    } 
    g(paramContext);
  }
  
  private void f() {
    GDTLogger.d("stop request location updates.");
    LocationManager locationManager = this.f;
    if (locationManager != null)
      locationManager.removeUpdates(this.h); 
    TencentLiteLocationManager tencentLiteLocationManager = this.g;
    if (tencentLiteLocationManager != null)
      tencentLiteLocationManager.removeUpdates(this.i); 
  }
  
  private void f(Context paramContext) {
    try {
      this.g = TencentLiteLocationManager.getInstance(paramContext);
      if (this.g == null) {
        GDTLogger.d("### TencentLocationManager unavailable!");
        return;
      } 
      if (this.i == null)
        e(); 
      GDTLogger.d("use map sdk location");
      this.e = 5;
      this.g.requestLocationUpdates(0L, this.i);
      return;
    } catch (Exception exception) {
      GDTLogger.w("failed to request map sdk.", exception);
      return;
    } 
  }
  
  private void g(Context paramContext) {
    this.f = (LocationManager)paramContext.getSystemService("location");
    if (this.f == null) {
      GDTLogger.d("### LocationManager unavailable!");
      return;
    } 
    GDTLogger.d("use system location");
    this.e = 4;
    this.f.requestLocationUpdates("network", 0L, 0.0F, this.h);
  }
  
  public double a() {
    return this.b;
  }
  
  public double b() {
    return this.c;
  }
  
  public void b(Context paramContext) {
    if (!c(paramContext))
      return; 
    try {
      GDTLogger.d("--- Update Location ---");
      d();
      e(paramContext);
      (new az(this, 30000L, 30000L) {
          public void a() {
            GDTLogger.d("--- TikTok: on finish");
            x.a(this.a);
            c();
          }
          
          public void a(long param1Long) {}
        }).b();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Update location encounter exception: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
      return;
    } 
  }
  
  public int c() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */