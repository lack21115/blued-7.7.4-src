package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

public class DevTools {
  private String a;
  
  public String getDemoGameUrl() {
    String str = this.a;
    this.a = null;
    return str;
  }
  
  public void testDemoGame(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (paramContext.getPackageName().equals("com.qq.e.union.demo.union"))
      this.a = paramString; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\devtool\DevTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */