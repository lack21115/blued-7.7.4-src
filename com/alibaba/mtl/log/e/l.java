package com.alibaba.mtl.log.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

public class l {
  private static a a;
  
  private static b a;
  
  private static String[] a = new String[] { "Unknown", "Unknown" };
  
  static {
    a = (String[])new b();
    a = (String[])new a();
  }
  
  private static String a(int paramInt) {
    switch (paramInt) {
      default:
        return "Unknown";
      case 13:
        return "4G";
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 15:
        return "3G";
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
        break;
    } 
    return "2G";
  }
  
  public static void a(Context paramContext) {
    if (paramContext == null)
      return; 
    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver((BroadcastReceiver)a, intentFilter);
  }
  
  public static void b(Context paramContext) {
    if (paramContext == null)
      return; 
    String[] arrayOfString = a;
    if (arrayOfString == null)
      return; 
    paramContext.unregisterReceiver((BroadcastReceiver)arrayOfString);
  }
  
  public static String[] getNetworkState(Context paramContext) {
    return a;
  }
  
  public static String getWifiAddress(Context paramContext) {
    if (paramContext != null) {
      WifiInfo wifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (wifiInfo != null) {
        String str2 = wifiInfo.getMacAddress();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = "00:00:00:00:00:00"; 
        return str1;
      } 
    } 
    return "00:00:00:00:00:00";
  }
  
  public static boolean isConnected() {
    Context context = com.alibaba.mtl.log.a.getContext();
    if (context != null)
      try {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivityManager != null) {
          NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
          return (networkInfo != null) ? networkInfo.isConnected() : false;
        } 
      } catch (Exception exception) {} 
    return true;
  }
  
  public static String u() {
    Context context = com.alibaba.mtl.log.a.getContext();
    if (context == null)
      return "Unknown"; 
    try {
      if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0)
        return "Unknown"; 
      NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo == null)
        return "Unknown"; 
      return "Unknown";
    } finally {
      context = null;
    } 
  }
  
  static class a implements Runnable {
    private Context a;
    
    private a() {}
    
    public a a(Context param1Context) {
      this.a = param1Context;
      return this;
    }
    
    public void run() {
      Context context = this.a;
      if (context == null)
        return; 
      try {
        int i = context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.a.getPackageName());
        if (i != 0) {
          l.a()[0] = "Unknown";
          return;
        } 
        ConnectivityManager connectivityManager = (ConnectivityManager)this.a.getSystemService("connectivity");
        if (connectivityManager == null) {
          l.a()[0] = "Unknown";
          return;
        } 
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
          if (1 == networkInfo.getType()) {
            l.a()[0] = "Wi-Fi";
            return;
          } 
          if (networkInfo.getType() == 0) {
            l.a()[0] = "2G/3G";
            l.a()[1] = networkInfo.getSubtypeName();
          } 
        } 
        return;
      } catch (Exception exception) {
        return;
      } 
    }
  }
  
  static class b extends BroadcastReceiver {
    private b() {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      r.a().b(l.a().a(param1Context));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */