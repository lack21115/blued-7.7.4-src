package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import org.apache.http.HttpHost;

public class NetStateManager {
  public static NetState CUR_NETSTATE = NetState.Mobile;
  
  private static Context mContext;
  
  public static HttpHost getAPN() {
    HttpHost httpHost;
    Uri uri1 = Uri.parse("content://telephony/carriers/preferapn");
    Context context = mContext;
    Uri uri3 = null;
    Uri uri2 = null;
    if (context != null) {
      Cursor cursor = context.getContentResolver().query(uri1, null, null, null, null);
    } else {
      context = null;
    } 
    uri1 = uri3;
    if (context != null) {
      uri1 = uri3;
      if (context.moveToFirst()) {
        String str = context.getString(context.getColumnIndex("proxy"));
        uri1 = uri2;
        if (str != null) {
          uri1 = uri2;
          if (str.trim().length() > 0)
            httpHost = new HttpHost(str, 80); 
        } 
        context.close();
      } 
    } 
    return httpHost;
  }
  
  public enum NetState {
    Mobile, NOWAY, WIFI;
    
    static {
      ENUM$VALUES = new NetState[] { Mobile, WIFI, NOWAY };
    }
  }
  
  public class NetStateReceive extends BroadcastReceiver {
    public void onReceive(Context param1Context, Intent param1Intent) {
      NetStateManager.mContext = param1Context;
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(param1Intent.getAction())) {
        WifiManager wifiManager = (WifiManager)param1Context.getSystemService("wifi");
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (!wifiManager.isWifiEnabled() || -1 == wifiInfo.getNetworkId())
          NetStateManager.CUR_NETSTATE = NetStateManager.NetState.Mobile; 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\net\NetStateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */