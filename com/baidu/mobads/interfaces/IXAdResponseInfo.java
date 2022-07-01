package com.baidu.mobads.interfaces;

import java.util.ArrayList;

public interface IXAdResponseInfo {
  ArrayList<IXAdInstanceInfo> getAdInstanceList();
  
  int getAdsNum();
  
  String getBaiduidOfCookie();
  
  String getDefaultFillInThemeForStaticAds();
  
  String getErrorCode();
  
  String getErrorMessage();
  
  String getExp2();
  
  String getExtentionActionExp();
  
  int getIntIcon();
  
  int getLatitude();
  
  int getLongitude();
  
  int getLunpan();
  
  Boolean getOpenPointModeForWall();
  
  String getOriginResponseStr();
  
  String getPointUnitForWall();
  
  IXAdInstanceInfo getPrimaryAdInstanceInfo();
  
  String getRequestId();
  
  long getTimeStamp();
  
  void setAdInstanceList(ArrayList<IXAdInstanceInfo> paramArrayList);
  
  void setAdsNum(int paramInt);
  
  void setBaiduidOfCookie(String paramString);
  
  void setDefaultFillInThemeForStaticAds(String paramString);
  
  void setErrorCode(String paramString);
  
  void setErrorMessage(String paramString);
  
  void setExp2(String paramString);
  
  void setExtentionActionExp(String paramString);
  
  void setIntIcon(int paramInt);
  
  void setLatitude(int paramInt);
  
  void setLongitude(int paramInt);
  
  void setLunpan(int paramInt);
  
  void setOpenPointModeForWall(Boolean paramBoolean);
  
  void setOriginResponseStr(String paramString);
  
  void setPointUnitForWall(String paramString);
  
  void setRequestId(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */