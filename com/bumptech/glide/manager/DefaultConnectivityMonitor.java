package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;

final class DefaultConnectivityMonitor implements ConnectivityMonitor {
  final ConnectivityMonitor.ConnectivityListener a;
  
  boolean b;
  
  private final Context c;
  
  private boolean d;
  
  private final BroadcastReceiver e = new BroadcastReceiver(this) {
      public void onReceive(Context param1Context, Intent param1Intent) {
        boolean bool = this.a.b;
        DefaultConnectivityMonitor defaultConnectivityMonitor = this.a;
        defaultConnectivityMonitor.b = defaultConnectivityMonitor.a(param1Context);
        if (bool != this.a.b) {
          if (Log.isLoggable("ConnectivityMonitor", 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("connectivity changed, isConnected: ");
            stringBuilder.append(this.a.b);
            Log.d("ConnectivityMonitor", stringBuilder.toString());
          } 
          this.a.a.a(this.a.b);
        } 
      }
    };
  
  DefaultConnectivityMonitor(Context paramContext, ConnectivityMonitor.ConnectivityListener paramConnectivityListener) {
    this.c = paramContext.getApplicationContext();
    this.a = paramConnectivityListener;
  }
  
  private void a() {
    if (this.d)
      return; 
    this.b = a(this.c);
    try {
      this.c.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      this.d = true;
      return;
    } catch (SecurityException securityException) {
      if (Log.isLoggable("ConnectivityMonitor", 5))
        Log.w("ConnectivityMonitor", "Failed to register", securityException); 
      return;
    } 
  }
  
  private void e() {
    if (!this.d)
      return; 
    this.c.unregisterReceiver(this.e);
    this.d = false;
  }
  
  boolean a(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)Preconditions.a(paramContext.getSystemService("connectivity"));
    try {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      return (networkInfo != null && networkInfo.isConnected());
    } catch (RuntimeException runtimeException) {
      if (Log.isLoggable("ConnectivityMonitor", 5))
        Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", runtimeException); 
      return true;
    } 
  }
  
  public void o_() {
    a();
  }
  
  public void p_() {
    e();
  }
  
  public void q_() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\manager\DefaultConnectivityMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */