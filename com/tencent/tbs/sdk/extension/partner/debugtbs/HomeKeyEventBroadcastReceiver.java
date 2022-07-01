package com.tencent.tbs.sdk.extension.partner.debugtbs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class HomeKeyEventBroadcastReceiver extends BroadcastReceiver {
  private a.c a;
  
  public HomeKeyEventBroadcastReceiver(a.c paramc) {
    this.a = paramc;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent == null)
      return; 
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      String str = paramIntent.getStringExtra("reason");
      if (str != null) {
        a.c c1;
        if (str.equals("homekey")) {
          c1 = this.a;
          if (c1 != null) {
            c1.a();
            return;
          } 
        } else if (c1.equals("recentapps")) {
          c1 = this.a;
          if (c1 != null)
            c1.b(); 
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\debugtbs\HomeKeyEventBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */