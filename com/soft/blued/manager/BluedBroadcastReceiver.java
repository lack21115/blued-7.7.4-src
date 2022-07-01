package com.soft.blued.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.blued.android.framework.init.InitTaskManager;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

public class BluedBroadcastReceiver extends BroadcastReceiver {
  String a;
  
  boolean b = false;
  
  Context c;
  
  private final List<BroadcastReceiverListener> d = new ArrayList<BroadcastReceiverListener>();
  
  public BluedBroadcastReceiver(Context paramContext, String paramString) {
    this.a = paramString;
    this.c = paramContext.getApplicationContext();
  }
  
  public void a(BroadcastReceiverListener paramBroadcastReceiverListener) {
    if (!this.d.contains(paramBroadcastReceiverListener))
      this.d.add(paramBroadcastReceiverListener); 
    if (!this.b) {
      this.c.registerReceiver(this, new IntentFilter(this.a));
      this.b = true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("registerReceiver ");
    stringBuilder.append(this.a);
    stringBuilder.append(", actionCount:");
    stringBuilder.append(this.d.size());
    Logger.b(stringBuilder.toString(), new Object[0]);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BluedBroadcastReceiver.onReceive(), intent:");
    stringBuilder.append(paramIntent.getAction());
    Logger.b(stringBuilder.toString(), new Object[0]);
    if (this.c == null)
      this.c = paramContext.getApplicationContext(); 
    if (!InitTaskManager.b()) {
      Logger.b("InitHelper is not init, return", new Object[0]);
      return;
    } 
    for (BroadcastReceiverListener broadcastReceiverListener : this.d) {
      if (broadcastReceiverListener != null)
        broadcastReceiverListener.a(this.a, paramIntent); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\manager\BluedBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */