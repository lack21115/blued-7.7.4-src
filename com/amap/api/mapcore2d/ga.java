package com.amap.api.mapcore2d;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;

public final class ga {
  Context a;
  
  LocationManager b;
  
  volatile long c = 0L;
  
  volatile boolean d = false;
  
  boolean e = false;
  
  volatile Inner_3dMap_location f = null;
  
  Object g = null;
  
  boolean h = false;
  
  boolean i = false;
  
  LocationListener j = new LocationListener(this) {
      public final void onLocationChanged(Location param1Location) {
        if (param1Location == null)
          return; 
        try {
          Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(param1Location);
          inner_3dMap_location.setProvider("gps");
          inner_3dMap_location.setLocationType(1);
          Bundle bundle = param1Location.getExtras();
          int i = 0;
          if (bundle != null)
            i = bundle.getInt("satellites"); 
          inner_3dMap_location.setSatellites(i);
          inner_3dMap_location.setTime(gv.a(inner_3dMap_location.getTime(), System.currentTimeMillis()));
          this.a.f = inner_3dMap_location;
          return;
        } finally {
          param1Location = null;
          gu.a((Throwable)param1Location, "MAPGPSLocation", "onLocationChanged");
        } 
      }
      
      public final void onProviderDisabled(String param1String) {
        try {
          return;
        } finally {
          param1String = null;
          gu.a((Throwable)param1String, "MAPGPSLocation", "onProviderDisabled");
        } 
      }
      
      public final void onProviderEnabled(String param1String) {}
      
      public final void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {}
    };
  
  public ga(Context paramContext) {
    if (paramContext == null)
      return; 
    this.a = paramContext;
    e();
    try {
      if (this.g == null && !this.i) {
        Object object;
        if (this.h) {
          object = Class.forName("com.amap.api.maps.CoordinateConverter").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        } else {
          object = Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new Class[0]).newInstance(new Object[0]);
        } 
        this.g = object;
        if (paramContext == null)
          this.i = true; 
      } 
    } finally {}
    if (this.b == null)
      this.b = (LocationManager)this.a.getSystemService("location"); 
  }
  
  private void e() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void f() {
    try {
      Looper looper2 = Looper.myLooper();
      Looper looper1 = looper2;
      if (looper2 == null)
        looper1 = this.a.getMainLooper(); 
      Bundle bundle = new Bundle();
      return;
    } catch (SecurityException securityException) {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "MAPGPSLocation", "requestLocationUpdates");
    } 
  }
  
  private void g() {
    this.d = false;
    this.c = 0L;
    this.f = null;
  }
  
  public final void a() {
    if (!this.e) {
      f();
      this.e = true;
    } 
  }
  
  public final void b() {
    this.e = false;
    g();
    LocationManager locationManager = this.b;
    if (locationManager == null)
      return; 
    LocationListener locationListener = this.j;
    if (locationListener != null)
      locationManager.removeUpdates(locationListener); 
  }
  
  public final boolean c() {
    if (this.d) {
      if (gy.b() - this.c <= 10000L)
        return true; 
      this.f = null;
    } 
    return false;
  }
  
  public final Inner_3dMap_location d() {
    if (this.f == null)
      return null; 
    Inner_3dMap_location inner_3dMap_location = this.f.clone();
    if (inner_3dMap_location != null && inner_3dMap_location.getErrorCode() == 0)
      try {
        return inner_3dMap_location;
      } finally {
        Exception exception = null;
      }  
    return inner_3dMap_location;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */