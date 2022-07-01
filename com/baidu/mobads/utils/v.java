package com.baidu.mobads.utils;

import android.content.Context;
import android.provider.Settings;
import com.baidu.mobads.openad.e.e;

class v extends e.b<String> {
  v(t paramt, Context paramContext) {}
  
  public void a(String paramString) {}
  
  public String b() {
    try {
      String str = Settings.System.getString(this.a.getContentResolver(), "com.baidu.deviceid");
    } finally {
      Exception exception = null;
    } 
    return XAdSDKFoundationFacade.getInstance().getCommonUtils().b(t.c());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */