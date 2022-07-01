package com.baidu.mobads;

import org.json.JSONObject;

public interface AdViewListener {
  void onAdClick(JSONObject paramJSONObject);
  
  void onAdClose(JSONObject paramJSONObject);
  
  void onAdFailed(String paramString);
  
  void onAdReady(AdView paramAdView);
  
  void onAdShow(JSONObject paramJSONObject);
  
  void onAdSwitch();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\AdViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */