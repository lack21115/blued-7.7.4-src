package com.qq.e.comm.plugin.h.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.util.Md5Util;

public class f extends b {
  public String a(Context paramContext) {
    String str = b(paramContext);
    return !TextUtils.isEmpty(str) ? Md5Util.encode(str.toLowerCase()) : null;
  }
  
  protected boolean a() {
    return o.n();
  }
  
  protected String c(Context paramContext) {
    int i = paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
    Context context = null;
    if (i != 0)
      return null; 
    try {
      String str;
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      paramContext = context;
      if (telephonyManager != null)
        str = telephonyManager.getDeviceId(); 
      return str;
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\h\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */