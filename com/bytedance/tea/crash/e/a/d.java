package com.bytedance.tea.crash.e.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class d {
  private int a;
  
  d(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private void a(Context paramContext) {
    paramContext.registerReceiver(new a(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
  }
  
  public int a() {
    return this.a;
  }
  
  class a extends BroadcastReceiver {
    private a(d this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if ("android.intent.action.BATTERY_CHANGED".equals(param1Intent.getAction())) {
        int i = param1Intent.getIntExtra("level", 0);
        int j = param1Intent.getIntExtra("scale", 100);
        d.a(this.a, (int)(i * 100.0F / j));
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */