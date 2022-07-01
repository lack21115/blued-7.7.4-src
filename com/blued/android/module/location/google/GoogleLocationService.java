package com.blued.android.module.location.google;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.blued.android.module.location.listener.OnLocationListener;
import com.blued.android.module.location.network.NetworkLocationService;
import com.blued.android.module.location.utils.AppUtils;
import com.blued.android.module.location.utils.LocationCacheUtils;
import com.blued.android.module.location.utils.ThreadUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class GoogleLocationService {
  private static final String a = GoogleLocationService.class.getCanonicalName();
  
  private static volatile GoogleLocationService d;
  
  private final FusedLocationProviderClient b;
  
  private OnLocationListener c;
  
  private final LocationRequest e = LocationRequest.create();
  
  private final LocationCallback f;
  
  private int g = -33;
  
  private boolean h = true;
  
  private GoogleLocationService() {
    this.e.setPriority(100);
    this.e.setInterval(20000L);
    this.e.setFastestInterval(2000L);
    this.f = new LocationCallback(this) {
        public void onLocationResult(LocationResult param1LocationResult) {}
      };
    this.b = LocationServices.getFusedLocationProviderClient((Context)AppUtils.a());
  }
  
  public static GoogleLocationService a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/location/google/GoogleLocationService.d : Lcom/blued/android/module/location/google/GoogleLocationService;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/location/google/GoogleLocationService
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/location/google/GoogleLocationService.d : Lcom/blued/android/module/location/google/GoogleLocationService;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/location/google/GoogleLocationService
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/location/google/GoogleLocationService.d : Lcom/blued/android/module/location/google/GoogleLocationService;
    //   25: ldc com/blued/android/module/location/google/GoogleLocationService
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/location/google/GoogleLocationService
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/location/google/GoogleLocationService.d : Lcom/blued/android/module/location/google/GoogleLocationService;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(int paramInt) {
    FusedLocationProviderClient fusedLocationProviderClient = this.b;
    if (fusedLocationProviderClient != null) {
      LocationCallback locationCallback = this.f;
      if (locationCallback != null)
        fusedLocationProviderClient.removeLocationUpdates(locationCallback); 
    } 
    OnLocationListener onLocationListener = this.c;
    if (onLocationListener != null)
      onLocationListener.a(paramInt); 
  }
  
  private void a(Location paramLocation) {
    double d1 = paramLocation.getLongitude();
    double d2 = paramLocation.getLatitude();
    FusedLocationProviderClient fusedLocationProviderClient = this.b;
    if (fusedLocationProviderClient != null) {
      LocationCallback locationCallback = this.f;
      if (locationCallback != null)
        fusedLocationProviderClient.removeLocationUpdates(locationCallback); 
    } 
    if (d1 == Double.MIN_VALUE || d2 == Double.MIN_VALUE || (d1 == 0.0D && d2 == 0.0D)) {
      OnLocationListener onLocationListener1 = this.c;
      if (onLocationListener1 != null)
        onLocationListener1.a(); 
      return;
    } 
    LocationCacheUtils.a(d1);
    LocationCacheUtils.b(d2);
    OnLocationListener onLocationListener = this.c;
    if (onLocationListener != null)
      onLocationListener.a(); 
  }
  
  private void c() {
    if (AppUtils.c() >= 23 && ActivityCompat.checkSelfPermission((Context)AppUtils.a(), "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission((Context)AppUtils.a(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
      OnLocationListener onLocationListener = this.c;
      if (onLocationListener != null)
        onLocationListener.a(); 
      return;
    } 
    this.b.requestLocationUpdates(this.e, this.f, Looper.getMainLooper());
    this.b.getLastLocation().addOnFailureListener(new OnFailureListener(this) {
          public void onFailure(Exception param1Exception) {
            String str = GoogleLocationService.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("定位Log：");
            stringBuilder.append(param1Exception.getMessage());
            Log.d(str, stringBuilder.toString());
            GoogleLocationService.a(this.a, -2);
          }
        }).addOnSuccessListener(new OnSuccessListener<Location>(this) {
          public void a(Location param1Location) {
            if (param1Location != null) {
              Log.d(GoogleLocationService.b(), "定位Log：定位成功");
              String str = GoogleLocationService.b();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("定位Log：Longitude=");
              stringBuilder.append(param1Location.getLongitude());
              stringBuilder.append(",Latitude=");
              stringBuilder.append(param1Location.getLatitude());
              Log.d(str, stringBuilder.toString());
              GoogleLocationService.a(this.a, param1Location);
              return;
            } 
            Log.d(GoogleLocationService.b(), "定位Log：Google 定位失败");
            if (NetworkLocationService.a().b()) {
              Log.d(GoogleLocationService.b(), "定位Log：采用系统定位");
              NetworkLocationService.a().a(GoogleLocationService.b(this.a));
              return;
            } 
            Log.d(GoogleLocationService.b(), "定位Log：系统定位服务没有打开");
            GoogleLocationService.a(this.a, -1);
          }
        });
  }
  
  public void a(OnLocationListener paramOnLocationListener) {
    this.c = paramOnLocationListener;
    ThreadUtils.b(new Runnable(this) {
          public void run() {
            GoogleLocationService.a(this.a);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\google\GoogleLocationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */