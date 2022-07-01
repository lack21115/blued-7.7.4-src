package com.baidu.mobads.utils;

import android.content.SharedPreferences;
import android.os.Build;

class y implements Runnable {
  y(t paramt, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run() {
    if (Build.VERSION.SDK_INT >= 9) {
      this.a.edit().putString("deviceid", this.b).apply();
      return;
    } 
    this.a.edit().putString("deviceid", this.b).commit();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */