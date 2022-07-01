package com.soft.blued.app.permission;

import android.os.Build;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import java.util.HashMap;

public final class PermissionHelper {
  public static void a(PermissionCallbacks paramPermissionCallbacks) {
    b();
    if (Build.VERSION.SDK_INT >= 26) {
      PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR" });
      return;
    } 
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.READ_CALENDAR" });
  }
  
  public static boolean a() {
    return a(new String[] { "android.permission.READ_PHONE_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.CAMERA" });
  }
  
  public static void c(PermissionCallbacks paramPermissionCallbacks) {
    b();
    if (Build.VERSION.SDK_INT >= 26) {
      PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" });
      return;
    } 
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
  
  public static void d(PermissionCallbacks paramPermissionCallbacks) {
    b();
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public static void e(PermissionCallbacks paramPermissionCallbacks) {
    b();
    if (Build.VERSION.SDK_INT >= 26) {
      PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" });
      return;
    } 
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
  }
  
  public static void f(PermissionCallbacks paramPermissionCallbacks) {
    b();
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
  }
  
  public static void g(PermissionCallbacks paramPermissionCallbacks) {
    b();
    if (Build.VERSION.SDK_INT >= 26) {
      PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
    } 
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
  }
  
  public static void h(PermissionCallbacks paramPermissionCallbacks) {
    b();
    if (Build.VERSION.SDK_INT >= 26) {
      PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.READ_PHONE_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    } 
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE" });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\app\permission\PermissionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */