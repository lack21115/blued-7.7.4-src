package c.t.maploc.lite.tsa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class aj extends BroadcastReceiver {
  aj(ai paramai) {}
  
  private static void a(List paramList) {
    HashSet<String> hashSet = new HashSet();
    Iterator iterator = paramList.iterator();
    while (iterator.hasNext()) {
      String str = ((ScanResult)iterator.next()).BSSID;
      if (str == null || str.equals("000000000000") || str.equals("00-00-00-00-00-00") || str.equals("00:00:00:00:00:00") || hashSet.contains(str)) {
        iterator.remove();
        continue;
      } 
      hashSet.add(str);
    } 
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent == null)
      return; 
    try {
      String str = paramIntent.getAction();
      if ("android.net.wifi.WIFI_STATE_CHANGED".equals(str))
        ai.a(this.a); 
      return;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */