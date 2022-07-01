package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;

public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
  public ConnectivityMonitor a(Context paramContext, ConnectivityMonitor.ConnectivityListener paramConnectivityListener) {
    boolean bool;
    if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE") == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (Log.isLoggable("ConnectivityMonitor", 3)) {
      String str;
      if (bool) {
        str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
      } else {
        str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
      } 
      Log.d("ConnectivityMonitor", str);
    } 
    return (ConnectivityMonitor)(bool ? new DefaultConnectivityMonitor(paramContext, paramConnectivityListener) : new NullConnectivityMonitor());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\manager\DefaultConnectivityMonitorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */