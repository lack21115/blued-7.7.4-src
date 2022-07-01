package com.blued.android.module.location.network;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.location.listener.OnLocationListener;
import com.blued.android.module.location.utils.AppUtils;
import com.blued.android.module.location.utils.LocationCacheUtils;
import com.blued.android.module.location.utils.ThreadUtils;

public class NetworkLocationService {
  private static final String a = NetworkLocationService.class.getSimpleName();
  
  private static volatile NetworkLocationService e;
  
  private OnLocationListener b;
  
  private LocationManager c;
  
  private final LocationListener d;
  
  private boolean f;
  
  private NetworkLocationService() {
    try {
      Application application;
      Context context2 = AppInfo.d();
      Context context1 = context2;
      if (context2 == null)
        application = AppUtils.a(); 
      this.c = (LocationManager)application.getSystemService("location");
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    this.d = new LocationListener(this) {
        public void onLocationChanged(Location param1Location) {
          Log.d(NetworkLocationService.d(), "定位Log：系统定位，onLocationChanged！");
          if (param1Location != null) {
            String str = NetworkLocationService.d();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("定位Log：系统定位更新成功：Longitude=");
            stringBuilder.append(param1Location.getLongitude());
            stringBuilder.append(",Latitude=");
            stringBuilder.append(param1Location.getLatitude());
            Log.d(str, stringBuilder.toString());
          } 
        }
        
        public void onProviderDisabled(String param1String) {
          String str = NetworkLocationService.d();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("定位Log：系统定位，onProviderDisabled！");
          stringBuilder.append(param1String);
          Log.d(str, stringBuilder.toString());
        }
        
        public void onProviderEnabled(String param1String) {
          String str = NetworkLocationService.d();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("定位Log：系统定位，onProviderEnabled！");
          stringBuilder.append(param1String);
          Log.d(str, stringBuilder.toString());
        }
        
        public void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {
          String str = NetworkLocationService.d();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("定位Log：系统定位，onStatusChanged！");
          stringBuilder.append(param1String);
          Log.d(str, stringBuilder.toString());
        }
      };
  }
  
  public static NetworkLocationService a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/location/network/NetworkLocationService.e : Lcom/blued/android/module/location/network/NetworkLocationService;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/location/network/NetworkLocationService
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/location/network/NetworkLocationService.e : Lcom/blued/android/module/location/network/NetworkLocationService;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/location/network/NetworkLocationService
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/location/network/NetworkLocationService.e : Lcom/blued/android/module/location/network/NetworkLocationService;
    //   25: ldc com/blued/android/module/location/network/NetworkLocationService
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/location/network/NetworkLocationService
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/location/network/NetworkLocationService.e : Lcom/blued/android/module/location/network/NetworkLocationService;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(int paramInt) {
    OnLocationListener onLocationListener = this.b;
    if (onLocationListener != null)
      onLocationListener.a(paramInt); 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("定位Log：系统定位失败 ");
    stringBuilder.append(paramInt);
    Log.d(str, stringBuilder.toString());
  }
  
  private void a(Location paramLocation) {
    double d1 = paramLocation.getLongitude();
    double d2 = paramLocation.getLatitude();
    if (d1 == Double.MIN_VALUE || d2 == Double.MIN_VALUE || (d1 == 0.0D && d2 == 0.0D)) {
      OnLocationListener onLocationListener1 = this.b;
      if (onLocationListener1 != null)
        onLocationListener1.a(); 
      return;
    } 
    LocationCacheUtils.a(d1);
    LocationCacheUtils.b(d2);
    OnLocationListener onLocationListener = this.b;
    if (onLocationListener != null)
      onLocationListener.a(); 
  }
  
  private String e() {
    try {
      boolean bool = this.c.isProviderEnabled("network");
      if (bool)
        return "network"; 
      bool = this.c.isProviderEnabled("gps");
      if (bool)
        return "gps"; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  private void f() {
    if (AppUtils.c() >= 23 && ActivityCompat.checkSelfPermission((Context)AppUtils.a(), "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission((Context)AppUtils.a(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
      OnLocationListener onLocationListener = this.b;
      if (onLocationListener != null)
        onLocationListener.a(); 
      return;
    } 
    String str = e();
    if (!StringUtils.a(str)) {
      Location location = this.c.getLastKnownLocation(str);
      if (location != null) {
        a(location);
        String str1 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("定位Log：系统定位成功: Longitude=");
        stringBuilder.append(location.getLongitude());
        stringBuilder.append("Latitude=");
        stringBuilder.append(location.getLatitude());
        Log.d(str1, stringBuilder.toString());
        return;
      } 
      a(-9);
      return;
    } 
    a(-15);
  }
  
  public void a(OnLocationListener paramOnLocationListener) {
    this.b = paramOnLocationListener;
    if (this.f) {
      f();
      c();
      return;
    } 
    this.f = true;
    c();
    ThreadUtils.a(new Runnable(this) {
          public void run() {
            NetworkLocationService.a(this.a);
          }
        },  200L);
  }
  
  public boolean b() {
    if (Build.VERSION.SDK_INT >= 19) {
      boolean bool1;
      boolean bool2 = false;
      try {
        bool1 = Settings.Secure.getInt(AppUtils.a().getContentResolver(), "location_mode");
      } catch (Exception null) {
        exception.printStackTrace();
        bool1 = false;
      } 
      if (bool1)
        bool2 = true; 
      return bool2;
    } 
    try {
      String str = Settings.Secure.getString(AppUtils.a().getContentResolver(), "location_providers_allowed");
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return StringUtils.a((String)exception) ^ true;
  }
  
  public void c() {
    ThreadUtils.a(new Runnable(this) {
          public void run() {
            if (AppUtils.c() >= 23 && ActivityCompat.checkSelfPermission((Context)AppUtils.a(), "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission((Context)AppUtils.a(), "android.permission.ACCESS_COARSE_LOCATION") != 0)
              return; 
            try {
              String str = NetworkLocationService.b(this.a);
              if (!StringUtils.a(str)) {
                Log.d(NetworkLocationService.d(), "定位Log：系统定位，更新系统定位！");
                NetworkLocationService.d(this.a).requestLocationUpdates(str, 3000L, 5.0F, NetworkLocationService.c(this.a));
                return;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\network\NetworkLocationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */