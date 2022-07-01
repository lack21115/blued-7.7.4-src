package com.baidu.mobads;

import android.text.TextUtils;

public class MobadsPermissionSettings {
  private static boolean a = false;
  
  private static boolean b = false;
  
  private static boolean c = false;
  
  private static boolean d = true;
  
  public static boolean hasPermissionGranted(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if ("permission_location".equalsIgnoreCase(paramString))
        return b; 
      if ("permission_storage".equalsIgnoreCase(paramString))
        return c; 
      if ("permission_app_list".equalsIgnoreCase(paramString))
        return d; 
      if ("permission_read_phone_state".equalsIgnoreCase(paramString))
        return a; 
    } 
    return false;
  }
  
  public static void setPermissionAppList(boolean paramBoolean) {
    d = paramBoolean;
  }
  
  public static void setPermissionLocation(boolean paramBoolean) {
    b = paramBoolean;
  }
  
  public static void setPermissionReadDeviceID(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static void setPermissionStorage(boolean paramBoolean) {
    c = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\MobadsPermissionSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */