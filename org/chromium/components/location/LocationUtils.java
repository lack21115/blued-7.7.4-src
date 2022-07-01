package org.chromium.components.location;

import android.os.Process;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;

public final class LocationUtils {
  private static LocationUtils$Factory sFactory;
  
  private static LocationUtils sInstance;
  
  public static LocationUtils getInstance() {
    ThreadUtils.assertOnUiThread();
    if (sInstance == null)
      if (sFactory == null) {
        sInstance = new LocationUtils();
      } else {
        sInstance = sFactory.create();
      }  
    return sInstance;
  }
  
  public static boolean hasPermission(String paramString) {
    return (ApiCompatibilityUtils.checkPermission(ContextUtils.sApplicationContext, paramString, Process.myPid(), Process.myUid()) == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\location\LocationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */