package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.i.c;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class d {
  private static long a = 1800000L;
  
  private static Handler b = new Handler(Looper.getMainLooper());
  
  private static Location a(LocationManager paramLocationManager) {
    Location location2 = a(paramLocationManager, "gps");
    Location location1 = location2;
    if (location2 == null)
      location1 = a(paramLocationManager, "network"); 
    location2 = location1;
    if (location1 == null)
      location2 = a(paramLocationManager, "passive"); 
    return location2;
  }
  
  private static Location a(LocationManager paramLocationManager, String paramString) {
    try {
      com.bytedance.sdk.openadsdk.i.b b = new com.bytedance.sdk.openadsdk.i.b(new b(paramLocationManager, paramString), 1, 2);
      return (Location)b.get(1L, TimeUnit.SECONDS);
    } finally {
      paramLocationManager = null;
    } 
  }
  
  private static TTLocation a() {
    try {
      com.bytedance.sdk.openadsdk.i.b b = new com.bytedance.sdk.openadsdk.i.b(new a(), 1, 2);
      com.bytedance.sdk.openadsdk.i.a.a().b(new c(b) {
            public void run() {
              this.a.run();
            }
          });
      TTLocation tTLocation = (TTLocation)b.get(1L, TimeUnit.SECONDS);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("location dev:");
      stringBuilder.append(tTLocation);
      return tTLocation;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static c a(Context paramContext) {
    if (!h.c().d().isCanUseLocation() && h.c().d().getTTLocation() == null)
      return null; 
    if (paramContext == null) {
      paramContext = o.a();
    } else {
      paramContext = paramContext.getApplicationContext();
    } 
    a = (o.h().m() * 60 * 1000);
    c c = c(paramContext);
    return !b(paramContext) ? c : d(paramContext);
  }
  
  private static void a(Context paramContext, TTLocation paramTTLocation) {
    if (paramTTLocation != null && paramTTLocation.getLatitude() != 0.0D && paramTTLocation.getLongitude() != 0.0D) {
      com.bytedance.sdk.openadsdk.core.d d1 = com.bytedance.sdk.openadsdk.core.d.a(paramContext);
      d1.a("latitude", (float)paramTTLocation.getLatitude());
      d1.a("longitude", (float)paramTTLocation.getLongitude());
      d1.a("lbstime", System.currentTimeMillis());
    } 
  }
  
  private static String b(LocationManager paramLocationManager) {
    return paramLocationManager.isProviderEnabled("gps") ? "gps" : (paramLocationManager.isProviderEnabled("network") ? "network" : (paramLocationManager.isProviderEnabled("passive") ? "passive" : null));
  }
  
  private static void b(Context paramContext, Location paramLocation) {
    if (!b(paramLocation))
      return; 
    com.bytedance.sdk.openadsdk.core.d d1 = com.bytedance.sdk.openadsdk.core.d.a(paramContext);
    d1.a("latitude", (float)paramLocation.getLatitude());
    d1.a("longitude", (float)paramLocation.getLongitude());
    d1.a("lbstime", System.currentTimeMillis());
  }
  
  private static void b(Context paramContext, LocationManager paramLocationManager) {
    if (paramContext != null) {
      if (paramLocationManager == null)
        return; 
      LocationListener locationListener = new LocationListener(paramContext, paramLocationManager) {
          public void onLocationChanged(Location param1Location) {
            if (param1Location != null && d.a(param1Location))
              d.a(this.a, param1Location); 
            d.a(this.b, this);
          }
          
          public void onProviderDisabled(String param1String) {}
          
          public void onProviderEnabled(String param1String) {}
          
          public void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {}
        };
      try {
        String str = b(paramLocationManager);
        if (TextUtils.isEmpty(str))
          return; 
        return;
      } finally {
        Exception exception = null;
        if (t.c())
          exception.printStackTrace(); 
      } 
    } 
  }
  
  private static void b(LocationManager paramLocationManager, LocationListener paramLocationListener) {
    if (paramLocationManager != null) {
      if (paramLocationListener == null)
        return; 
      try {
        return;
      } finally {
        paramLocationManager = null;
      } 
    } 
  }
  
  private static boolean b(Context paramContext) {
    long l = com.bytedance.sdk.openadsdk.core.d.a(paramContext).b("lbstime", -1L).longValue();
    return (l == -1L || System.currentTimeMillis() - l > a);
  }
  
  private static boolean b(Location paramLocation) {
    return (paramLocation.getLatitude() != 0.0D && paramLocation.getLongitude() != 0.0D);
  }
  
  private static c c(Context paramContext) {
    com.bytedance.sdk.openadsdk.core.d d1 = com.bytedance.sdk.openadsdk.core.d.a(paramContext);
    float f1 = d1.b("latitude", -1.0F);
    float f2 = d1.b("longitude", -1.0F);
    return (f1 == -1.0F || f2 == -1.0F) ? null : new c(f1, f2);
  }
  
  private static c d(Context paramContext) {
    boolean bool = h.c().d().isCanUseLocation();
    c c3 = null;
    c c1 = null;
    c c2 = null;
    if (!bool)
      try {
        TTLocation tTLocation = a();
        return null;
      } finally {
        paramContext = null;
      }  
    LocationManager locationManager = (LocationManager)paramContext.getSystemService("location");
    if (locationManager != null) {
      c c = c3;
      try {
        Location location = a(locationManager);
        c1 = c2;
        if (location != null) {
          c1 = c2;
          c = c3;
          if (b(location)) {
            c = c3;
            b(paramContext, location);
            c = c3;
            c1 = new c((float)location.getLatitude(), (float)location.getLongitude());
          } 
        } 
        c = c1;
        if (Looper.myLooper() != Looper.getMainLooper())
          return c1; 
        return c1;
      } finally {
        paramContext = null;
        c1 = c;
      } 
    } 
    return c1;
  }
  
  static class a implements Callable<TTLocation> {
    private a() {}
    
    public TTLocation a() throws Exception {
      return h.c().d().getTTLocation();
    }
  }
  
  static class b implements Callable<Location> {
    private LocationManager a;
    
    private String b;
    
    public b(LocationManager param1LocationManager, String param1String) {
      this.a = param1LocationManager;
      this.b = param1String;
    }
    
    public Location a() throws Exception {
      long l1 = System.currentTimeMillis();
      Location location = this.a.getLastKnownLocation(this.b);
      long l2 = System.currentTimeMillis();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("location:");
      stringBuilder.append(location);
      stringBuilder.append(",getLastKnownLocation use time :");
      stringBuilder.append(l2 - l1);
      t.b("AdLocationUtils", stringBuilder.toString());
      return location;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */