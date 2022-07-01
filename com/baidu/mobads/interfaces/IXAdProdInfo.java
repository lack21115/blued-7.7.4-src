package com.baidu.mobads.interfaces;

import android.view.View;
import org.json.JSONObject;

public interface IXAdProdInfo {
  String getAdPlacementId();
  
  String getAdRequestURL();
  
  int getApt();
  
  JSONObject getAttribute();
  
  View getClickView();
  
  int getInstanceCount();
  
  @Deprecated
  String getProdType();
  
  int getRequestAdHeight();
  
  int getRequestAdWidth();
  
  IXAdConstants4PDK.SlotType getType();
  
  boolean isAutoPlay();
  
  boolean isMsspTagAvailable();
  
  void setClickView(View paramView);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdProdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */