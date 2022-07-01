package androidx.core.location;

import android.location.LocationManager;
import android.os.Build;

public final class LocationManagerCompat {
  public static boolean isLocationEnabled(LocationManager paramLocationManager) {
    return (Build.VERSION.SDK_INT >= 28) ? paramLocationManager.isLocationEnabled() : ((paramLocationManager.isProviderEnabled("network") || paramLocationManager.isProviderEnabled("gps")));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\location\LocationManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */