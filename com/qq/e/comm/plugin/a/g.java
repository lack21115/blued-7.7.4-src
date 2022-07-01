package com.qq.e.comm.plugin.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.qq.e.comm.util.GDTLogger;

class g extends BroadcastReceiver {
  private final a a;
  
  public g(a parama) {
    this.a = parama;
  }
  
  void a(Context paramContext) {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    intentFilter.addDataScheme("package");
    paramContext.registerReceiver(this, intentFilter);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("android.intent.action.PACKAGE_ADDED".equals(paramIntent.getAction())) {
      String str2 = paramIntent.getDataString();
      String str1 = str2;
      if (str2 != null) {
        str1 = str2;
        if (str2.startsWith("package:"))
          str1 = str2.substring(8); 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("App被安装，包名: ");
      stringBuilder.append(str1);
      GDTLogger.d(stringBuilder.toString());
      a a1 = this.a;
      if (a1 != null)
        a1.c(str1); 
    } 
  }
  
  static interface a {
    void c(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */