package com.geetest.onelogin.listener;

import android.app.Activity;
import org.json.JSONObject;

public abstract class AbstractOneLoginListener {
  public void onAuthActivityCreate(Activity paramActivity) {}
  
  public void onAuthWebActivityCreate(Activity paramActivity) {}
  
  public void onBackButtonClick() {}
  
  public void onLoginButtonClick() {}
  
  public void onLoginLoading() {}
  
  public void onPrivacyCheckBoxClick(boolean paramBoolean) {}
  
  public void onPrivacyClick(String paramString1, String paramString2) {}
  
  public boolean onRequestOtherVerify() {
    return false;
  }
  
  public void onRequestTokenSecurityPhone(String paramString) {}
  
  public abstract void onResult(JSONObject paramJSONObject);
  
  public void onSwitchButtonClick() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\listener\AbstractOneLoginListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */