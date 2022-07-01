package org.chromium.device.geolocation;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;

public class LocationProviderAndroid implements LocationListener, LocationProvider {
  private boolean mIsRunning;
  
  private LocationManager mLocationManager;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private void unregisterFromLocationUpdates() {
    if (!this.mIsRunning)
      return; 
    this.mIsRunning = false;
    this.mLocationManager.removeUpdates(this);
  }
  
  public void onLocationChanged(Location paramLocation) {
    if (this.mIsRunning)
      LocationProviderAdapter.onNewLocationAvailable(paramLocation); 
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public final void start(boolean paramBoolean) {
    boolean bool;
    ThreadUtils.assertOnUiThread();
    unregisterFromLocationUpdates();
    if (this.mLocationManager == null) {
      this.mLocationManager = (LocationManager)ContextUtils.sApplicationContext.getSystemService("location");
      if (this.mLocationManager == null)
        Log.e("cr_LocationProvider", "Could not get location manager.", new Object[0]); 
    } 
    List<String> list = this.mLocationManager.getProviders(true);
    if (list != null && list.size() == 1 && ((String)list.get(0)).equals("passive")) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      bool = false;
    } else {
      Location location = this.mLocationManager.getLastKnownLocation("passive");
      if (location != null)
        ThreadUtils.runOnUiThread(new LocationProviderAndroid$1(location)); 
      bool = true;
    } 
    if (!bool) {
      assert false;
      throw new AssertionError();
    } 
  }
  
  public final void stop() {
    ThreadUtils.assertOnUiThread();
    unregisterFromLocationUpdates();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\geolocation\LocationProviderAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */