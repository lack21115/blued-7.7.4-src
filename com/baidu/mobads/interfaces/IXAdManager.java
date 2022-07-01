package com.baidu.mobads.interfaces;

import android.location.Location;

public interface IXAdManager {
  String getVersion();
  
  IXAdContext newAdContext();
  
  void setAppSid(String paramString);
  
  void setLocation(Location paramLocation);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */