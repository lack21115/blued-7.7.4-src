package com.bytedance.embedapplog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.embedapplog.a.e;
import com.bytedance.embedapplog.util.h;

public class Collector extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    String[] arrayOfString = paramIntent.getStringArrayExtra("EMBED_K_DATA");
    if (arrayOfString != null && arrayOfString.length > 0) {
      e.a(arrayOfString);
      return;
    } 
    h.a(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\collector\Collector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */