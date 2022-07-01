package com.baidu.mobads.command.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class b extends BroadcastReceiver {
  private a a;
  
  public b(a parama) {
    this.a = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    String str = paramIntent.getAction();
    if (TextUtils.isEmpty(str))
      return; 
    if ("lp_close".equals(str)) {
      a a1 = this.a;
      if (a1 != null)
        a1.a(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */