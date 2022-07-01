package com.baidu.mobads.interfaces.feeds;

import java.util.HashMap;
import java.util.Map;

public interface IXAdFeedsRequestParameters {
  int getAPPConfirmPolicy();
  
  String getAdPlacementId();
  
  int getAdsType();
  
  Map<String, String> getExtras();
  
  String getKeywords();
  
  @Deprecated
  boolean isConfirmDownloading();
  
  HashMap<String, Object> toHashMap();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\feeds\IXAdFeedsRequestParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */