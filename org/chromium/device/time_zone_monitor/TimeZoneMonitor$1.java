package org.chromium.device.time_zone_monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.chromium.base.Log;

final class TimeZoneMonitor$1 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    if (!paramIntent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
      Log.e("cr_TimeZoneMonitor", "unexpected intent", new Object[0]);
      return;
    } 
    TimeZoneMonitor.access$100(TimeZoneMonitor.this, TimeZoneMonitor.access$000(TimeZoneMonitor.this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\time_zone_monitor\TimeZoneMonitor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */