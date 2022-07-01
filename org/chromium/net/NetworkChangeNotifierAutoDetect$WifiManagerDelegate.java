package org.chromium.net;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

final class NetworkChangeNotifierAutoDetect$WifiManagerDelegate {
  private final Context mContext;
  
  private boolean mHasWifiPermission;
  
  private boolean mHasWifiPermissionComputed;
  
  private final Object mLock = new Object();
  
  private WifiManager mWifiManager;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  NetworkChangeNotifierAutoDetect$WifiManagerDelegate() {
    this.mContext = null;
  }
  
  NetworkChangeNotifierAutoDetect$WifiManagerDelegate(Context paramContext) {
    assert false;
    throw new AssertionError();
  }
  
  private WifiInfo getWifiInfoLocked() {
    try {
      return this.mWifiManager.getConnectionInfo();
    } catch (NullPointerException nullPointerException) {
      try {
        return this.mWifiManager.getConnectionInfo();
      } catch (NullPointerException nullPointerException1) {
        return null;
      } 
    } 
  }
  
  final String getWifiSsid() {
    synchronized (this.mLock) {
      boolean bool;
      if (this.mHasWifiPermissionComputed) {
        bool = this.mHasWifiPermission;
      } else {
        WifiManager wifiManager;
        if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.mHasWifiPermission = bool;
        if (this.mHasWifiPermission) {
          wifiManager = (WifiManager)this.mContext.getSystemService("wifi");
        } else {
          wifiManager = null;
        } 
        this.mWifiManager = wifiManager;
        this.mHasWifiPermissionComputed = true;
        bool = this.mHasWifiPermission;
      } 
      if (bool) {
        WifiInfo wifiInfo = getWifiInfoLocked();
        if (wifiInfo != null)
          return wifiInfo.getSSID(); 
        return "";
      } 
      return AndroidNetworkLibrary.getWifiSSID();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect$WifiManagerDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */