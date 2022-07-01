package org.chromium.device.geolocation;

import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

public class LocationProviderFactory {
  private static LocationProvider sProviderImpl;
  
  private static boolean sUseGmsCoreLocationProvider;
  
  public static LocationProvider create() {
    if (sProviderImpl != null)
      return sProviderImpl; 
    if (sUseGmsCoreLocationProvider && LocationProviderGmsCore.isGooglePlayServicesAvailable(ContextUtils.sApplicationContext)) {
      sProviderImpl = new LocationProviderGmsCore(ContextUtils.sApplicationContext);
    } else {
      sProviderImpl = new LocationProviderAndroid();
    } 
    return sProviderImpl;
  }
  
  @CalledByNative
  public static void useGmsCoreLocationProvider() {
    sUseGmsCoreLocationProvider = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\geolocation\LocationProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */