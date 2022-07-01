package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

public class i {
  public static String a() {
    String str2 = a("wlan0");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = a("eth0"); 
    str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = "DU:MM:YA:DD:RE:SS"; 
    return str2;
  }
  
  private static String a(String paramString) {
    try {
      Iterator<NetworkInterface> iterator = Collections.<NetworkInterface>list(NetworkInterface.getNetworkInterfaces()).iterator();
      return "";
    } finally {
      paramString = null;
    } 
  }
  
  public static String a(boolean paramBoolean) {
    try {
      Iterator<NetworkInterface> iterator = Collections.<NetworkInterface>list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (iterator.hasNext()) {
        for (InetAddress inetAddress : Collections.<InetAddress>list(((NetworkInterface)iterator.next()).getInetAddresses())) {
          if (!inetAddress.isLoopbackAddress()) {
            boolean bool = inetAddress instanceof java.net.Inet4Address;
            String str = inetAddress.getHostAddress().toUpperCase();
            if (paramBoolean) {
              if (bool)
                return str; 
              continue;
            } 
            if (!bool) {
              int j = str.indexOf('%');
              return (j < 0) ? str : str.substring(0, j);
            } 
          } 
        } 
      } 
    } finally {
      Exception exception;
    } 
    return "";
  }
  
  public static boolean a(Context paramContext) {
    boolean bool = false;
    try {
      int j = (paramContext.getResources().getConfiguration()).screenLayout;
      return bool;
    } finally {
      paramContext = null;
    } 
  }
  
  public static boolean b(Context paramContext) {
    boolean bool = false;
    try {
      int j = (paramContext.getResources().getConfiguration()).uiMode;
      return bool;
    } finally {
      paramContext = null;
    } 
  }
  
  public static int c(Context paramContext) {
    return b(paramContext) ? 3 : (a(paramContext) ? 2 : 1);
  }
  
  public static JSONObject d(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("imei", j.d(paramContext));
      jSONObject.put("android_id", j.c(paramContext));
      jSONObject.put("uuid", j.e(paramContext));
      jSONObject.put("ssid", j.g(paramContext));
      jSONObject.put("wifi_mac", j.h(paramContext));
      jSONObject.put("imsi", j.f(paramContext));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(SystemClock.elapsedRealtime());
      stringBuilder.append("");
      jSONObject.put("power_on_time", stringBuilder.toString());
      jSONObject.put("rom_version", ac.a());
      jSONObject.put("sys_compiling_time", j.b(paramContext));
      jSONObject.put("type", c(paramContext));
      jSONObject.put("os", 1);
      stringBuilder = new StringBuilder();
      stringBuilder.append(Build.VERSION.RELEASE);
      stringBuilder.append("");
      jSONObject.put("os_version", stringBuilder.toString());
      jSONObject.put("vendor", Build.MANUFACTURER);
      jSONObject.put("model", Build.MODEL);
      jSONObject.put("language", Locale.getDefault().getLanguage());
      jSONObject.put("conn_type", w.b(paramContext));
      jSONObject.put("mac", a());
      jSONObject.put("screen_width", ai.c(paramContext));
      jSONObject.put("screen_height", ai.d(paramContext));
      jSONObject.put("oaid", x.a());
      return jSONObject;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */