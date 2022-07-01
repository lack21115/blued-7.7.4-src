package org.chromium.device.geolocation;

import android.location.Location;
import java.util.concurrent.FutureTask;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class LocationProviderAdapter {
  private LocationProvider mImpl = LocationProviderFactory.create();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  public static LocationProviderAdapter create() {
    return new LocationProviderAdapter();
  }
  
  private static native void nativeNewErrorAvailable(String paramString);
  
  private static native void nativeNewLocationAvailable(double paramDouble1, double paramDouble2, double paramDouble3, boolean paramBoolean1, double paramDouble4, boolean paramBoolean2, double paramDouble5, boolean paramBoolean3, double paramDouble6, boolean paramBoolean4, double paramDouble7);
  
  public static void newErrorAvailable(String paramString) {
    Log.e("cr_LocationProvider", "newErrorAvailable %s", new Object[] { paramString });
    nativeNewErrorAvailable(paramString);
  }
  
  public static void onNewLocationAvailable(Location paramLocation) {
    nativeNewLocationAvailable(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getTime() / 1000.0D, paramLocation.hasAltitude(), paramLocation.getAltitude(), paramLocation.hasAccuracy(), paramLocation.getAccuracy(), paramLocation.hasBearing(), paramLocation.getBearing(), paramLocation.hasSpeed(), paramLocation.getSpeed());
  }
  
  @CalledByNative
  public void start(boolean paramBoolean) {
    ThreadUtils.runOnUiThread(new FutureTask(new LocationProviderAdapter$1(this, paramBoolean), null));
  }
  
  @CalledByNative
  public void stop() {
    ThreadUtils.runOnUiThread(new FutureTask(new LocationProviderAdapter$2(this), null));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\geolocation\LocationProviderAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */