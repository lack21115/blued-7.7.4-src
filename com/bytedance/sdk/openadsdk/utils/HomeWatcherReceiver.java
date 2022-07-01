package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HomeWatcherReceiver extends BroadcastReceiver {
  private a a;
  
  public void a(a parama) {
    this.a = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent == null)
      return; 
    String str = paramIntent.getAction();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onReceive: action: ");
    stringBuilder.append(str);
    Log.i("HomeReceiver", stringBuilder.toString());
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(str)) {
      a a1;
      str = paramIntent.getStringExtra("reason");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("reason: ");
      stringBuilder1.append(str);
      Log.i("HomeReceiver", stringBuilder1.toString());
      if ("homekey".equals(str)) {
        Log.i("HomeReceiver", "homekey");
        a1 = this.a;
        if (a1 != null) {
          a1.E();
          return;
        } 
      } else if ("recentapps".equals(a1)) {
        Log.i("HomeReceiver", "long press home key or activity switch");
        a1 = this.a;
        if (a1 != null) {
          a1.F();
          return;
        } 
      } else if ("assist".equals(a1)) {
        Log.i("HomeReceiver", "assist");
      } 
    } 
  }
  
  public static interface a {
    void E();
    
    void F();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\HomeWatcherReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */