package com.baidu.mobads.openad.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class b extends BroadcastReceiver {
  private c a;
  
  public b(c paramc) {
    this.a = paramc;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      this.a.b(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */