package com.qq.e.comm.plugin.h.a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

public class e extends f {
  private String a(TelephonyManager paramTelephonyManager) {
    Class<?> clazz = paramTelephonyManager.getClass();
    try {
      Method method = clazz.getDeclaredMethod("getImei", new Class[] { int.class });
      method.setAccessible(true);
      String str = (String)method.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(0) });
      try {
        return !TextUtils.isEmpty(str) ? str : (String)method.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(1) });
      } catch (Exception exception) {
        return str;
      } 
    } catch (Exception exception) {
      return null;
    } 
  }
  
  protected String c(Context paramContext) {
    if (paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
      return null; 
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      return (telephonyManager == null) ? null : ((Build.VERSION.SDK_INT >= 21) ? a(telephonyManager) : telephonyManager.getDeviceId());
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\h\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */