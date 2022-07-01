package org.chromium.ui.base;

import android.content.Context;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.ui.R;

public class DeviceFormFactor {
  private static int detectScreenWidthBucket(Context paramContext) {
    return paramContext.getResources().getInteger(R.integer.min_screen_width_bucket);
  }
  
  public static boolean isNonMultiDisplayContextOnTablet(Context paramContext) {
    return (detectScreenWidthBucket(paramContext) >= 2);
  }
  
  @Deprecated
  @CalledByNative
  public static boolean isTablet() {
    return (detectScreenWidthBucket(ContextUtils.sApplicationContext) >= 2);
  }
  
  public static boolean isWindowOnTablet(WindowAndroid paramWindowAndroid) {
    int i;
    ThreadUtils.assertOnUiThread();
    Context context = paramWindowAndroid.getContext().get();
    if (context == null) {
      i = 0;
    } else {
      i = context.getResources().getInteger(R.integer.min_screen_width_bucket);
    } 
    return (i >= 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\DeviceFormFactor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */