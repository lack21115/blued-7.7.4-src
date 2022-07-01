package com.huawei.hms.opendevice;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

public class OpenDevice {
  public static OpenDeviceClient getOpenDeviceClient(Activity paramActivity) {
    Checker.assertNonNull(paramActivity);
    return new OpenDeviceClientImpl(paramActivity);
  }
  
  public static OpenDeviceClient getOpenDeviceClient(Context paramContext) {
    Checker.assertNonNull(paramContext);
    return new OpenDeviceClientImpl(paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\OpenDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */