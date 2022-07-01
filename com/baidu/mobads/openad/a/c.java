package com.baidu.mobads.openad.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.openad.c.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;

public class c extends d {
  private int a;
  
  private b d;
  
  private IntentFilter e;
  
  public c(Context paramContext) {
    super(paramContext);
  }
  
  public void a() {
    if (this.a == 0) {
      if (this.d == null)
        a(new b(this)); 
      this.e = new IntentFilter();
      this.e.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    } 
    this.a++;
    this.b.registerReceiver(this.d, this.e);
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver) {
    this.d = (b)paramBroadcastReceiver;
  }
  
  public void b() {
    dispatchEvent((IOAdEvent)new b("network_changed"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */