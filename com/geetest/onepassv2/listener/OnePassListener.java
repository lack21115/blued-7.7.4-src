package com.geetest.onepassv2.listener;

import org.json.JSONObject;

public abstract class OnePassListener {
  public boolean onAlgorithm() {
    return false;
  }
  
  public String onAlgorithmPhone(String paramString1, String paramString2) {
    return null;
  }
  
  public boolean onAlgorithmSelf() {
    return false;
  }
  
  public abstract void onTokenFail(JSONObject paramJSONObject);
  
  public abstract void onTokenSuccess(JSONObject paramJSONObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\listener\OnePassListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */