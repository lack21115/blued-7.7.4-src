package com.geetest.onelogin.listener;

import org.json.JSONObject;

public interface SecurityPhoneListener {
  void onFailed(JSONObject paramJSONObject);
  
  void onSuccess(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\listener\SecurityPhoneListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */