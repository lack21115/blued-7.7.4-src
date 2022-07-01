package com.geetest.common.support;

import android.content.Context;
import android.os.Process;

public class ContextCompat {
  public static int a(Context paramContext, String paramString) {
    if (paramString != null)
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()); 
    throw new IllegalArgumentException("permission is null");
  }
  
  public static boolean a(Context paramContext) {
    return (a(paramContext, "android.permission.READ_PRIVILEGED_PHONE_STATE") == 0);
  }
  
  public static boolean b(Context paramContext) {
    return (a(paramContext, "android.permission.READ_PHONE_STATE") == 0);
  }
  
  public static boolean b(Context paramContext, String paramString) {
    return (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\common\support\ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */