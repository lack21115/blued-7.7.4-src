package com.qq.e.comm.plugin.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qq.e.comm.util.GDTLogger;

class r extends BroadcastReceiver {
  private final a a;
  
  public r(a parama) {
    this.a = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (this.a == null)
      return; 
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isConnected()) {
      int i = networkInfo.getType();
      if (i == 0) {
        GDTLogger.d("连接到运营商网络");
        this.a.b();
        return;
      } 
      if (i == 1 && networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) {
        GDTLogger.d("连接到WIFI网络");
        this.a.a();
      } 
    } 
  }
  
  public static interface a {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */