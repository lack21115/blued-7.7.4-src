package com.soft.blued.utils;

import android.os.Build;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import java.util.HashMap;

public final class PermissionUtils {
  public static void a(PermissionCallbacks paramPermissionCallbacks) {
    b();
    if (Build.VERSION.SDK_INT >= 26) {
      PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" });
      return;
    } 
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  public static boolean a() {
    String[] arrayOfString;
    if (AppInfo.o() && Build.VERSION.SDK_INT >= 26) {
      arrayOfString = new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" };
    } else {
      arrayOfString = new String[] { "android.permission.ACCESS_FINE_LOCATION" };
    } 
    return a(arrayOfString);
  }
  
  public static boolean a(String... paramVarArgs) {
    return PermissionManager.a(paramVarArgs);
  }
  
  private static void b() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Integer integer = Integer.valueOf(2131758359);
    hashMap.put("android.permission.READ_CALENDAR", integer);
    hashMap.put("android.permission.WRITE_CALENDAR", integer);
    hashMap.put("android.permission.CAMERA", Integer.valueOf(2131758360));
    integer = Integer.valueOf(2131758363);
    hashMap.put("android.permission.ACCESS_FINE_LOCATION", integer);
    hashMap.put("android.permission.ACCESS_COARSE_LOCATION", integer);
    hashMap.put("android.permission.RECORD_AUDIO", Integer.valueOf(2131758364));
    hashMap.put("android.permission.READ_PHONE_STATE", Integer.valueOf(2131758365));
    integer = Integer.valueOf(2131758369);
    hashMap.put("android.permission.READ_EXTERNAL_STORAGE", integer);
    hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", integer);
    PermissionManager.a(hashMap);
  }
  
  public static void b(PermissionCallbacks paramPermissionCallbacks) {
    b();
    if (Build.VERSION.SDK_INT >= 26) {
      PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
    } 
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\PermissionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */