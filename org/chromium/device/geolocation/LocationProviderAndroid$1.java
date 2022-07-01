package org.chromium.device.geolocation;

import android.location.Location;

final class LocationProviderAndroid$1 implements Runnable {
  public final void run() {
    LocationProviderAdapter.onNewLocationAvailable(location);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\geolocation\LocationProviderAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */