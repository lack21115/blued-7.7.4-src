package c.t.maploc.lite.tsa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

final class e extends BroadcastReceiver {
  private long a = 0L;
  
  e(c paramc) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent == null)
      return; 
    boolean bool = false;
    try {
      StringBuilder stringBuilder1;
      boolean bool1 = paramIntent.getBooleanExtra("noConnectivity", false);
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager == null) {
        connectivityManager = null;
      } else {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      } 
      StringBuilder stringBuilder2 = new StringBuilder("Network:");
      stringBuilder2.append(c.a(this.b).d());
      String str = stringBuilder2.toString();
      if (bool1) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        str = " not found";
      } else {
        boolean bool2 = bool;
        if (stringBuilder1 != null) {
          bool2 = bool;
          if (stringBuilder1.isConnected())
            bool2 = true; 
        } 
        return;
      } 
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */