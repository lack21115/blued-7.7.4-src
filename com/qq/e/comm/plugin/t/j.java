package com.qq.e.comm.plugin.t;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;

public interface j {
  public static final String a;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GDTMobSDK");
    stringBuilder.append(SDKStatus.getSDKVersion());
    stringBuilder.append(".");
    stringBuilder.append(GDTADManager.getInstance().getPM().getPluginVersion());
    stringBuilder.append("-[");
    stringBuilder.append(System.getProperty("http.agent"));
    stringBuilder.append("]");
    a = stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */