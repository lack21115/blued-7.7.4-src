package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

class TwilightManager {
  private static TwilightManager a;
  
  private final Context b;
  
  private final LocationManager c;
  
  private final TwilightState d = new TwilightState();
  
  TwilightManager(Context paramContext, LocationManager paramLocationManager) {
    this.b = paramContext;
    this.c = paramLocationManager;
  }
  
  private Location a(String paramString) {
    try {
      if (this.c.isProviderEnabled(paramString))
        return this.c.getLastKnownLocation(paramString); 
    } catch (Exception exception) {
      Log.d("TwilightManager", "Failed to get last known location", exception);
    } 
    return null;
  }
  
  static TwilightManager a(Context paramContext) {
    if (a == null) {
      paramContext = paramContext.getApplicationContext();
      a = new TwilightManager(paramContext, (LocationManager)paramContext.getSystemService("location"));
    } 
    return a;
  }
  
  private void a(Location paramLocation) {
    boolean bool;
    TwilightState twilightState = this.d;
    long l1 = System.currentTimeMillis();
    TwilightCalculator twilightCalculator = TwilightCalculator.a();
    twilightCalculator.calculateTwilight(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = twilightCalculator.sunset;
    twilightCalculator.calculateTwilight(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (twilightCalculator.state == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    long l3 = twilightCalculator.sunrise;
    long l4 = twilightCalculator.sunset;
    twilightCalculator.calculateTwilight(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l5 = twilightCalculator.sunrise;
    if (l3 == -1L || l4 == -1L) {
      l1 = 43200000L + l1;
    } else {
      if (l1 > l4) {
        l1 = 0L + l5;
      } else if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      } 
      l1 += 60000L;
    } 
    twilightState.a = bool;
    twilightState.b = l2;
    twilightState.c = l3;
    twilightState.d = l4;
    twilightState.e = l5;
    twilightState.f = l1;
  }
  
  private Location b() {
    Location location1;
    int i = PermissionChecker.checkSelfPermission(this.b, "android.permission.ACCESS_COARSE_LOCATION");
    Location location2 = null;
    if (i == 0) {
      location1 = a("network");
    } else {
      location1 = null;
    } 
    if (PermissionChecker.checkSelfPermission(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0)
      location2 = a("gps"); 
    if (location2 != null && location1 != null) {
      Location location = location1;
      if (location2.getTime() > location1.getTime())
        location = location2; 
      return location;
    } 
    if (location2 != null)
      location1 = location2; 
    return location1;
  }
  
  private boolean c() {
    return (this.d.f > System.currentTimeMillis());
  }
  
  boolean a() {
    TwilightState twilightState = this.d;
    if (c())
      return twilightState.a; 
    Location location = b();
    if (location != null) {
      a(location);
      return twilightState.a;
    } 
    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
    int i = Calendar.getInstance().get(11);
    return (i < 6 || i >= 22);
  }
  
  static class TwilightState {
    boolean a;
    
    long b;
    
    long c;
    
    long d;
    
    long e;
    
    long f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\TwilightManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */