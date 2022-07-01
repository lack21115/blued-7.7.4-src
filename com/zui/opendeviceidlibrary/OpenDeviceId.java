package com.zui.opendeviceidlibrary;

import android.util.Log;
import com.zui.deviceidservice.IDeviceidInterface;

public class OpenDeviceId {
  private static String c = "OpenDeviceId library";
  
  private static boolean d;
  
  private IDeviceidInterface a;
  
  private CallBack b;
  
  private void a(String paramString) {
    if (d)
      Log.i(c, paramString); 
  }
  
  public static interface CallBack {
    void a(OpenDeviceId param1OpenDeviceId);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\zui\opendeviceidlibrary\OpenDeviceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */