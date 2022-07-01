package com.baidu.mobads.interfaces.download.activate;

import org.json.JSONObject;

public interface IXAppInfo {
  JSONObject convertToJsonObject();
  
  String getAdId();
  
  long getAppSize();
  
  long getClickTime();
  
  long getExpireTimestamp();
  
  String getPackageName();
  
  String getProd();
  
  String getQk();
  
  boolean isExpired();
  
  boolean isTooLarge();
  
  void setAdId(String paramString);
  
  void setAppSize(long paramLong);
  
  void setClickTime(long paramLong);
  
  void setPackageName(String paramString);
  
  void setProd(String paramString);
  
  void setQk(String paramString);
  
  void setTooLarge(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\download\activate\IXAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */