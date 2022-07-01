package com.bytedance.embedapplog.util;

import android.telephony.TelephonyManager;
import com.bytedance.embedapplog.AppLog;
import java.util.ArrayList;

public class e {
  public static ArrayList<String> a = new ArrayList<String>();
  
  public static String a(TelephonyManager paramTelephonyManager) {
    if (h.b)
      h.a("SensitiveUtils gDI c", null); 
    return paramTelephonyManager.getDeviceId();
  }
  
  public static boolean a(String paramString) {
    int i = a.contains(paramString) ^ true;
    if (h.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SensitiveUtils allowed c ");
      stringBuilder.append(paramString);
      stringBuilder.append(" ");
      stringBuilder.append(i);
      h.a(stringBuilder.toString(), null);
    } 
    return i;
  }
  
  public static String b(TelephonyManager paramTelephonyManager) {
    if (h.b)
      h.a("SensitiveUtils gSSN c", null); 
    return paramTelephonyManager.getSimSerialNumber();
  }
  
  public static String c(TelephonyManager paramTelephonyManager) {
    if (h.b)
      h.a("SensitiveUtils gSI c", null); 
    return (AppLog.getInitConfig() != null) ? AppLog.getInitConfig().getSensitiveInfoProvider().getImsi() : "";
  }
  
  public static String d(TelephonyManager paramTelephonyManager) {
    if (h.b)
      h.a("SensitiveUtils gLN c", null); 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */