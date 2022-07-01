package com.huawei.hms.framework.network.grs;

import android.content.Context;

public class GrsApp {
  private static GrsApp instance = new GrsApp();
  
  private String appConfigName;
  
  public static GrsApp getInstance() {
    return instance;
  }
  
  public String getAppConfigName() {
    return this.appConfigName;
  }
  
  public String getIssueCountryCode(Context paramContext) {
    return a.a(paramContext, false).getCountryCode();
  }
  
  public void setAppConfigName(String paramString) {
    this.appConfigName = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\GrsApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */